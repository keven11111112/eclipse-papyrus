/*****************************************************************************
 * Copyright (c) 2013, 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.migration.rhapsody.transformations;

import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.gmf.runtime.emf.core.resources.GMFResource;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.m2m.qvt.oml.BasicModelExtent;
import org.eclipse.m2m.qvt.oml.ExecutionContext;
import org.eclipse.m2m.qvt.oml.ExecutionContextImpl;
import org.eclipse.m2m.qvt.oml.ExecutionDiagnostic;
import org.eclipse.m2m.qvt.oml.ModelExtent;
import org.eclipse.m2m.qvt.oml.TransformationExecutor;
import org.eclipse.m2m.qvt.oml.util.Trace;
import org.eclipse.m2m.qvt.oml.util.WriterLog;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.tools.util.ListHelper;
import org.eclipse.papyrus.m2m.qvto.TransformationUI;
import org.eclipse.papyrus.migration.common.concurrent.ExecutorsPool;
import org.eclipse.papyrus.migration.common.concurrent.ResourceAccessHelper;
import org.eclipse.papyrus.migration.rhapsody.Activator;
import org.eclipse.papyrus.migration.rhapsody.blackboxes.Rhapsody2PapyrusNotationBlackboxes;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * Executes a single Rhapsody-to-Papyrus transformation
 *
 * 
 */
public class ImportTransformations {

	ResourceSetImpl resourceSet;

	// SourceURI is the input
	protected final URI sourceURI;

	// targetURI is computed during the transformation
	protected URI targetURI;

	protected ModelExtent outUML, outNotation, outSashModel, primitivesCTypesModel, inPapyrusProfiles, inRhapsodyModel,
			inPapyrusLibraries, umlPrimitivesTypes, ansiCLibrary, sysML11Profile;

	protected Trace executionTrace;

	protected Job job;

	protected Resource umlResource;

	protected boolean complete = false;

	protected List<Diagram> diagramsToDelete = new LinkedList<Diagram>();

	protected static final ExecutorsPool executorsPool = new ExecutorsPool(2);

	/**
	 * EPackages corresponding to source native profiles with specific support
	 * in the transformation
	 */
	protected static final Set<EPackage> sourceEPackages = new HashSet<EPackage>();

	protected static final Set<String> supportedDiagramIds = new HashSet<String>();

	public ImportTransformations(URI sourceURI) {
		Assert.isNotNull(sourceURI);
		this.sourceURI = sourceURI;
	}

	// MemoryLeak: Don't rely on BasicDiagnostic.toIStatus
	// The source Diagnostic contains references to the QVTo ModelExtents,
	// referencing the Model elements (used in #extractPapyrusProfiles())
	// When using the standard conversion, these references are not discarded
	protected static IStatus createStatusFromDiagnostic(Diagnostic diagnostic) {
		return new Status(diagnostic.getSeverity(), diagnostic.getSource(), diagnostic.getMessage(),
				diagnostic.getException());
	}

	/**
	 * Actually runs the transformation
	 *
	 * @param monitor
	 * @return The transformation IStatus
	 * 
	 * 
	 */
	public IStatus run() {

		//
		// INITIALIZATION / LOADING
		//

		initResourceSet();

		List<ModelExtent> extents = getModelExtents();

		String statusMessage = String.format("Import %s", getModelName());
		MultiStatus generationStatus = new MultiStatus(Activator.PLUGIN_ID, IStatus.OK, statusMessage, null);

		ExecutionContext context = createExecutionContext(generationStatus);

		IStatus result; // Result of an individual transformation (Will be
						// aggregated to the complete GenerationStatus)

		// Diagrams
		Collection<URI> transformations = getDiagramTransformationURIs();

		// Semantic
		// Collection<URI> transformations = getSemanticTransformationURI();

		for (URI transformationURI : transformations) {
			TransformationExecutor.BlackboxRegistry.INSTANCE.registerModules(Rhapsody2PapyrusNotationBlackboxes.class);
			TransformationExecutor executor = new TransformationExecutor(transformationURI);
			ExecutionDiagnostic resultTransdo = executor.execute(context, extents.toArray(new ModelExtent[0]));
			result = createStatusFromDiagnostic(resultTransdo);
			System.out.print(resultTransdo.getMessage());
			generationStatus.add(result);
		}

		if (generationStatus.getSeverity() <= Diagnostic.WARNING) {

			URI notationModelURI = null;
			URI sashModelURI = null;

			targetURI = convertToPapyrus(sourceURI, "uml");
			notationModelURI = convertToPapyrus(sourceURI, "notation");
			sashModelURI = convertToPapyrus(sourceURI, "di");

			umlResource = createUMLResource(resourceSet, sourceURI, targetURI);

			// this resource contains the result of the qvto transfo
			List<EObject> outUMLObjects = getInOutUMLModel().getContents();
			umlResource.getContents().addAll(outUMLObjects);

			GMFResource notationResource = new GMFResource(notationModelURI); // GMF
																				// Resource
																				// content
																				// type?
			resourceSet.getResources().add(notationResource);
			List<EObject> outNotationObjects = getInoutNotationModel().getContents();
			notationResource.getContents().addAll(outNotationObjects);

			XMIResource sashResource = new XMIResourceImpl(sashModelURI);
			resourceSet.getResources().add(sashResource);
			List<EObject> sashModelObjects = getOutSashModel().getContents();
			sashResource.getContents().addAll(sashModelObjects);

			configureResource(sashResource);
			configureResource(notationResource);
			configureResource((XMIResource) umlResource);

			Collection<Resource> resourcesToSave = new HashSet<Resource>();
			resourcesToSave.add(umlResource);
			resourcesToSave.add(notationResource);
			resourcesToSave.add(sashResource);

			for (Resource resource : resourcesToSave) {
				try {
					cleanMetadataAnnotations(resource);
					ResourceAccessHelper.INSTANCE.saveResource(resource, null);
				} catch (Exception ex) {
					Activator.log.error(ex);
					generationStatus.add(
							new Status(IStatus.ERROR, Activator.PLUGIN_ID, "An exception occurred during save", ex));
				}
			}
		} else {
			System.out.print("can not execute transfo");
		}

		unloadResourceSet(this.resourceSet);

		this.resourceSet = null;
		this.umlResource = null;
		this.outNotation = this.outSashModel = this.outUML = this.primitivesCTypesModel = null;

		return generationStatus;
	}

	protected void configureResource(XMIResource resource) {
		Map<Object, Object> saveOptions = new HashMap<Object, Object>();

		// default save options.
		saveOptions.put(XMLResource.OPTION_DECLARE_XML, Boolean.TRUE);
		saveOptions.put(XMLResource.OPTION_PROCESS_DANGLING_HREF, XMLResource.OPTION_PROCESS_DANGLING_HREF_DISCARD);
		saveOptions.put(XMLResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);
		saveOptions.put(XMIResource.OPTION_USE_XMI_TYPE, Boolean.TRUE);
		saveOptions.put(XMLResource.OPTION_SAVE_TYPE_INFORMATION, Boolean.TRUE);
		saveOptions.put(XMLResource.OPTION_SKIP_ESCAPE_URI, Boolean.FALSE);
		saveOptions.put(XMLResource.OPTION_ENCODING, "UTF-8");

		// see bug 397987: [Core][Save] The referenced plugin models are saved
		// using relative path
		saveOptions.put(XMLResource.OPTION_URI_HANDLER,
				new org.eclipse.emf.ecore.xmi.impl.URIHandlerImpl.PlatformSchemeAware());

		resource.setEncoding("UTF-8");
		resource.getDefaultSaveOptions().putAll(saveOptions);
	}

	/**
	 * Executes the transformation (Asynchronous)
	 *
	 * @param urisToImport
	 */

	public URI getTargetURI() {
		return targetURI;
	}

	/**
	 * Initializes the resource set, and resolve all dependencies
	 */
	protected void initResourceSet() {
		resourceSet = new ResourceSetImpl();
		synchronized (UMLUtil.class) {
			UMLUtil.init(resourceSet);
		}
		resourceSet.getLoadOptions().put(XMLResource.OPTION_DEFER_ATTACHMENT, true);
		resourceSet.getLoadOptions().put(XMLResource.OPTION_DEFER_IDREF_RESOLUTION, true);
		resourceSet.getLoadOptions().put(XMLResource.OPTION_RECORD_UNKNOWN_FEATURE, Boolean.TRUE);
		resourceSet.getLoadOptions().put(XMLResource.OPTION_USE_PACKAGE_NS_URI_AS_LOCATION, Boolean.FALSE);

		try {
			resourceSet.getResource(sourceURI, true);

		} catch (Exception ex) {
			Activator.log.error("An error occurred while loading " + getModelName(), ex);
		}
	}

	// protected ModelExtent getInPapyrusProfiles() {
	// if (inPapyrusProfiles == null) {
	// loadInPapyrusProfiles();
	// }
	//
	// return inPapyrusProfiles;
	// }

	// protected ModelExtent getInPapyrusLibraries() {
	// if (inPapyrusLibraries == null) {
	// loadInPapyrusLibraries();
	// }
	//
	// return inPapyrusLibraries;
	// }

	protected Diagnostic loadInPapyrusProfiles() {
		if (inPapyrusProfiles != null) {
			return Diagnostic.OK_INSTANCE;
		}

		List<String> missingProfiles = new LinkedList<String>();

		List<EObject> allContents = new LinkedList<EObject>();
		// try {
		// URI fcmProfile1 =
		// URI.createURI("pathmap://FCM_PROFILES/FCM.profile.uml");
		// Resource fcmProfile = resourceSet.getResource(fcmProfile1, true);
		// checkResource(fcmProfile);
		// allContents.addAll(fcmProfile.getContents());
		// } catch (WrappedException ex) {
		// missingProfiles.add("FCM Profile");
		// }

		inPapyrusProfiles = new BasicModelExtent(allContents);

		String message;
		int code;
		if (missingProfiles.isEmpty()) {
			message = "OK";
			code = Diagnostic.OK;
		} else {
			message = "The following Papyrus profiles cannot be found: "
					+ ListHelper.deepToString(missingProfiles, ", ");
			code = Diagnostic.ERROR;
		}

		Diagnostic diagnostic = new BasicDiagnostic(code, Activator.PLUGIN_ID, code, message, null);

		return diagnostic;
	}

	protected Diagnostic loadInPapyrusLibraries() {
		if (inPapyrusLibraries != null) {
			return Diagnostic.OK_INSTANCE;
		}

		List<String> missingLibraries = new LinkedList<String>();

		List<EObject> allContents = new LinkedList<EObject>();
		try {
			URI ancyLib = URI.createURI("pathmap://PapyrusC_Cpp_LIBRARIES/AnsiCLibrary.uml");
			Resource ancyLibRes = resourceSet.getResource(ancyLib, true);
			checkResource(ancyLibRes);
			allContents.addAll(ancyLibRes.getContents());
		} catch (WrappedException ex) {
			missingLibraries.add("Ancy C Library");
		}

		inPapyrusLibraries = new BasicModelExtent(allContents);

		String message;
		int code;
		if (missingLibraries.isEmpty()) {
			message = "OK";
			code = Diagnostic.OK;
		} else {
			message = "The following Papyrus libraries cannot be found: "
					+ ListHelper.deepToString(missingLibraries, ", ");
			code = Diagnostic.ERROR;
		}

		Diagnostic diagnostic = new BasicDiagnostic(code, Activator.PLUGIN_ID, code, message, null);

		return diagnostic;
	}

	protected void checkResource(Resource resource) {
		Assert.isNotNull(resource);
		Assert.isTrue(!resource.getContents().isEmpty(), "The resource " + resource.getURI() + " is empty");
		for (EObject rootElement : resource.getContents()) {
			Assert.isTrue(!rootElement.eIsProxy());
		}
	}

	protected Resource createUMLResource(ResourceSet resourceSet, URI sourceResourceURI, URI targetResourceURI) {
		Resource resource = resourceSet.createResource(targetResourceURI,
				UMLResource.UML_5_0_0_CONTENT_TYPE_IDENTIFIER);

		return resource;
	}

	protected URI convertToPapyrus(URI rhpURI, String extension) {

		return rhpURI.trimFileExtension().appendFileExtension(extension);
	}

	// the transfo parameters :
	protected List<ModelExtent> getModelExtents() {
		List<ModelExtent> allExtents = new LinkedList<ModelExtent>();
		allExtents.add(getInRhapsodyModel());
		allExtents.add(getInoutNotationModel());
		allExtents.add(getInOutUMLModel());
		allExtents.add(getPrimitivesCUMLModel());
		allExtents.add(getSysML1_1Profile());
		allExtents.add(getInUMLPrimitivesTypes());
		return allExtents;
	}
	
	public ModelExtent getInUMLPrimitivesTypes() {
		URI umlPrimitivesTypesURI = URI.createURI("pathmap://UML_LIBRARIES/UMLPrimitiveTypes.library.uml");
		Resource umlPrimitivesTypesResource = resourceSet.getResource(umlPrimitivesTypesURI, true);
		umlPrimitivesTypes = new BasicModelExtent(umlPrimitivesTypesResource.getContents());
		return umlPrimitivesTypes;
	}
	
//	public ModelExtent getANSICLibrary() {
//		URI umlPrimitivesTypesURI = URI.createURI("pathmap://PapyrusC_Cpp_LIBRARIES/AnsiCLibrary.uml");
//		Resource umlPrimitivesTypesResource = resourceSet.getResource(umlPrimitivesTypesURI, true);
//		ansiCLibrary = new BasicModelExtent(umlPrimitivesTypesResource.getContents());
//		return ansiCLibrary;
//	}

	public ModelExtent getInRhapsodyModel() {
		if (inRhapsodyModel == null) {
			Resource resource = resourceSet.getResource(sourceURI, true);
			inRhapsodyModel = new BasicModelExtent(resource.getContents());
		}
		return inRhapsodyModel;
	}

	public ModelExtent getSysML1_1Profile() {
		URI sysMLProfile = URI.createURI("pathmap://SysML_PROFILES/SysML.profile.uml");
		Resource sysProfile = resourceSet.getResource(sysMLProfile, true);
		sysML11Profile = new BasicModelExtent(sysProfile.getContents());
		return sysML11Profile;
	}

	public ModelExtent getPrimitivesCUMLModel() {

		URI primitiveTypesURI = URI.createURI("pathmap://PapyrusC_Cpp_LIBRARIES/AnsiCLibrary.uml");

		Resource primitiveTypes = resourceSet.getResource(primitiveTypesURI, true);

		primitivesCTypesModel = new BasicModelExtent(primitiveTypes.getContents());

		return primitivesCTypesModel;
	}

	public ModelExtent getInOutUMLModel() {
		if (outUML == null)

			outUML = new BasicModelExtent();

		return outUML;
	}

	/*
	 * Notation model is initially empty, but will be filled successively by
	 * each transformation
	 */
	public ModelExtent getInoutNotationModel() {
		if (outNotation == null) {
			outNotation = new BasicModelExtent();
		}

		return outNotation;
	}

	protected ModelExtent getOutSashModel() {
		if (outSashModel == null) {
			outSashModel = new BasicModelExtent();
		}

		return outSashModel;
	}

	static {
		supportedDiagramIds.addAll(Arrays.asList(new String[] { "Class", // Includes
																			// Profiles
				"Statechart", }));
	}

	// TODO never call, called from the Rhapsody2PapyrusNotation transform to make the link between uml created elements and their representation
	protected Collection<URI> getSemanticTransformationURI() {
		return ListHelper.asList(new URI[] { getTransformationURI("Rhapsody2PapyrusSemanticElements"),

		});

	}

	protected Collection<URI> getDiagramTransformationURIs() {
		return ListHelper.asList(new URI[] { getTransformationURI("Rhapsody2PapyrusNotation"),

		});
	}

	protected URI getTransformationURI(String transformationName) {
		return URI.createPlatformPluginURI(
				String.format("%s/transform/%s.qvto", Activator.PLUGIN_ID, transformationName), true); //$NON-NLS-1$
	}

	public String getModelName() {
		return URI.decode(sourceURI.lastSegment());
	}

	protected ExecutionContext createExecutionContext(final MultiStatus generationStatus) {
		ExecutionContextImpl context = new ExecutionContextImpl();
		context.setConfigProperty("keepModeling", true); //$NON-NLS-1$
		//TODO : exist in RSA, isn't it ? 
		//context.setConfigProperty(TransformationUI.MONITOR);

		context.setLog(new WriterLog(new OutputStreamWriter(System.out)) {

			@Override
			public void log(String message) {
				super.log(message);
			}

			@Override
			public void log(String message, Object param) {
				super.log(message, param);
			}

			@Override
			public void log(int level, String message) {
				super.log(level, message);
				if (level >= 1) {
					generationStatus.merge(new Status(level, Activator.PLUGIN_ID, message));
				}

			}

			@Override
			public void log(int level, String message, Object param) {
				super.log(level, message, param);
				if (level >= 1) {
					generationStatus.merge(new Status(level, Activator.PLUGIN_ID, message + ", data:" + param));
				}
			}
		});

		return context;
	}

	protected void unloadResourceSet(ResourceSet resourceSet) {
		EMFHelper.unload(resourceSet);
	}

	/**
	 * @param resource
	 */
	private void cleanMetadataAnnotations(Resource resource) {
		// Bug 471684: UML2.x to UML2.5 creates (invalid) Ecore Metadata
		// EAnnotations, which then cause OCL validation to fail
		// Remove these EAnnotations from the model to avoid side effects
		Iterator<EObject> rootElementsIterator = resource.getContents().iterator();
		while (rootElementsIterator.hasNext()) {
			EObject root = rootElementsIterator.next();
			if (root instanceof EAnnotation) {
				EAnnotation annotation = (EAnnotation) root;
				if (ExtendedMetaData.ANNOTATION_URI.equals(annotation.getSource())) {
					rootElementsIterator.remove();
				}
			}
		}
	}

}
