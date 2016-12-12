/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.migration.rhapsody.transformations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.gmf.runtime.emf.core.resources.GMFResource;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Style;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.m2m.qvt.oml.BasicModelExtent;
import org.eclipse.m2m.qvt.oml.ExecutionContextImpl;
import org.eclipse.m2m.qvt.oml.ModelExtent;
import org.eclipse.papyrus.infra.internationalization.resource.InternationalizationResource;
import org.eclipse.papyrus.infra.internationalization.utils.InternationalizationResourceOptionsConstants;
import org.eclipse.papyrus.infra.internationalization.utils.PropertiesFilesUtils;
import org.eclipse.papyrus.infra.tools.util.ListHelper;
import org.eclipse.papyrus.migration.common.MigrationParameters.ThreadConfig;
import org.eclipse.papyrus.migration.common.concurrent.ResourceAccessHelper;
import org.eclipse.papyrus.migration.common.transformation.AbstractImportTransformation;
import org.eclipse.papyrus.migration.common.transformation.IDependencyAnalysisHelper;
import org.eclipse.papyrus.migration.rhapsody.Activator;
import org.eclipse.papyrus.uml.internationalization.utils.UMLInternationalizationKeyResolver;
import org.eclipse.uml2.uml.resource.UMLResource;

/**
 * @author Vincent Lorenzo
 *
 */
public class RhapsodyImportTransformation extends AbstractImportTransformation {

	/**
	 * The file used to store the labels defined in the Rhaposdy Model
	 */
	private InternationalizationResource propertiesResource;

	public RhapsodyImportTransformation(URI sourceURI, ThreadConfig config, IDependencyAnalysisHelper analysisHelper) {
		super(sourceURI, config, analysisHelper);
		DEBUG = true;
	}

	public RhapsodyImportTransformation(URI sourceURI) {
		super(sourceURI);
	}

	/**
	 * @see org.eclipse.papyrus.migration.rhapsody..transformations.NEW_AbstractImportTransformation_NEW#run(org.eclipse.core.runtime.IProgressMonitor)
	 *
	 * @param monitor
	 * @return
	 */
	@Override
	protected IStatus run(IProgressMonitor monitor) {
		//
		// INITIALIZATION / LOADING
		//

		monitor.subTask("Loading source model " + getModelName());

		long startLoad = System.nanoTime();
		initResourceSet(monitor);

		int numberOfElements = countSupportedElements();

		monitor.beginTask("Importing " + getModelName(), numberOfElements);

		monitor.subTask("Loading transformations (This may take a few seconds for the first import)...");

		loadTransformations(monitor);

		List<ModelExtent> extents = getModelExtents();

		String statusMessage = String.format("Import %s", getModelName());
		MultiStatus generationStatus = new MultiStatus(Activator.PLUGIN_ID, IStatus.OK, statusMessage, null);

		context = createExecutionContext(monitor, generationStatus);

		try {
			getInPapyrusProfiles(); // Preload profiles

			long endLoad = System.nanoTime();
			loadingTime = endLoad - startLoad;

			//
			// TRANSFORMATIONS
			//

			IStatus result; // Result of an individual transformation (Will be aggregated to the complete GenerationStatus)

			prepareExtensions();

			// TODO useful for the Rhapsody import ?
			long startExtensions = System.nanoTime();
			result = importExtensions(context, monitor, ExtensionFunction::executeBefore);
			long endExtensions = System.nanoTime();

			this.importExtensionsTime = endExtensions - startExtensions;
			generationStatus.add(result);

			// TODO : warning, this step is not in RSA
			monitor.subTask("Importing semantic model...");
			URI semanticTransformationURI = getSemanticTransformationURI();
			if(null!=semanticTransformationURI){
				result = runTransformation(semanticTransformationURI, extents, monitor);
				generationStatus.add(result);
			}
			// Diagrams
			Collection<URI> transformations = getDiagramTransformationURIs();

			monitor.subTask("Importing diagrams...");
			for (URI transformationURI : transformations) {
				result = runTransformation(transformationURI, extents, monitor);
				generationStatus.add(result);
			}

			// TODO : it seems to be an additional transfo for RSA import
			// // Semantic model changes (Default language for OpaqueExpressions...)
			// monitor.subTask("Importing semantic model...");
			// result = runTransformation(getSemanticTransformationURI(), extents, monitor);
			// generationStatus.add(result);

			// TODO : remove me, not required for Rhapsody import
			// if (!monitor.isCanceled()) {
			// monitor.subTask("Handle additional profiles...");
			// // Default.epx and ProfileBase.epx
			// result = importRSAProfiles(context, monitor);
			// generationStatus.add(result);
			// }

			Collection<URI> additional = getAdditionalTransformationURIs();
			if (!additional.isEmpty()) {
				monitor.subTask("Additional transformations...");
				for (URI transformationURI : additional) {
					result = runTransformation(transformationURI, extents, monitor);
					generationStatus.add(result);
				}
			}

			long startExtensionsAfter = System.nanoTime();
			result = importExtensions(context, monitor, ExtensionFunction::executeAfter);
			long endExtensionsAfter = System.nanoTime();
			this.importExtensionsTime += endExtensionsAfter - startExtensionsAfter;
		} finally {
			context = null;
		}

		//
		// FRAGMENTS & SAVE
		//

		if (generationStatus.getSeverity() <= Diagnostic.WARNING) {

			monitor.subTask("Cleaning-up target model...");
			URI notationModelURI = null;
			URI sashModelURI = null;

			targetURI = convertToPapyrus(sourceURI, UMLResource.FILE_EXTENSION);
			notationModelURI = convertToPapyrus(sourceURI, "notation"); // TODO use constant
			sashModelURI = convertToPapyrus(sourceURI, "di"); // TODO use constant

			// TODO : remove epx here!
			if ("epx".equals(sourceURI.fileExtension())) {
				profileURIMappings.put(sourceURI, targetURI);
			}
			// Profile mappings are also library mappings
			uriMappings.put(sourceURI, targetURI);

			umlResource = createUMLResource(resourceSet, sourceURI, targetURI);

			// This list contains all the objects from the initial ModelExtent, plus all the ones
			// which were created during the QVTo transformations.
			List<EObject> outUMLObjects = getInOutUMLModel().getContents();
			umlResource.getContents().addAll(outUMLObjects);

			GMFResource notationResource = new GMFResource(notationModelURI); // GMF Resource content type?
			resourceSet.getResources().add(notationResource);
			List<EObject> outNotationObjects = getInoutNotationModel().getContents();
			notationResource.getContents().addAll(outNotationObjects);

			// Cleanup empty diagrams (FIXME: They should not be generated)
			List<EObject> contentsCopy = new LinkedList<>(notationResource.getContents());
			for (EObject next : contentsCopy) {
				if (next instanceof Diagram) {
					Diagram diagram = (Diagram) next;
					if (diagram.getType() == null || "".equals(diagram.getType())) {
						delete(diagram);
					}
				}
			}

			final URI propertyURI = convertToPapyrus(sourceURI, PropertiesFilesUtils.PROPERTIES_FILE_EXTENSION);
			propertiesResource = createAndConfigureInternationalizationResource(propertyURI);
			resourceSet.getResources().add(propertiesResource);
			propertiesResource.getContents().addAll(getInOutInternationalizationModel().getContents());

			XMIResource sashResource = new XMIResourceImpl(sashModelURI);
			resourceSet.getResources().add(sashResource);
			List<EObject> sashModelObjects = getOutSashModel().getContents();
			sashResource.getContents().addAll(sashModelObjects);

			configureResource(sashResource);
			configureResource(notationResource);
			configureResource((XMIResource) umlResource);
			// configureResource((XMIResource)propertiesResource); //not required

			// Handle orphaned elements: remove them and log a warning (Log temporarily disabled to avoid spamming the console)
			List<EObject> notationRootElements = new LinkedList<>(notationResource.getContents());
			for (EObject rootElement : notationRootElements) {
				if (rootElement instanceof View) {
					View rootView = (View) rootElement;
					if (!(rootView instanceof Diagram)) {
						if (DEBUG) {
							String objectType = rootView.getElement() == null ? "None" : rootView.getElement().eClass().getName();
							String viewType = rootView.getType() == null ? "None" : rootView.getType();
							generationStatus.add(new Status(IStatus.WARNING, Activator.PLUGIN_ID, "An orphaned view has been found after the migration. It will be removed. View Type: " + viewType + ", semantic type: " + objectType));
						}

						delete(rootElement);
					}
				} else if (rootElement instanceof Style) {

					if (DEBUG) {
						String styleType = rootElement.eClass().getName();
						generationStatus.add(new Status(IStatus.WARNING, Activator.PLUGIN_ID, "An orphaned style has been found after the migration. It will be removed. Style Type: " + styleType));
					}

					delete(rootElement);
				}
			}


			monitor.subTask("Handling fragments...");


			Collection<Resource> resourcesToSave = handleFragments(umlResource, notationResource, sashResource);
			resourcesToSave.add(propertiesResource);
			// TODO : commented because it probably concerns only RSa
			// for (Resource resource : resourcesToSave) {
			// List<EObject> rootElements = new LinkedList<>(resource.getContents());
			// for (EObject rootElement : rootElements) {
			// EPackage ePackage = rootElement.eClass().getEPackage();
			// if (ePackage == ProfileBasePackage.eINSTANCE || ePackage == DefaultPackage.eINSTANCE) {
			// delete(rootElement);
			// }
			// }
			// }

			monitor.subTask("Deleting source diagrams...");

			for (Diagram diagram : diagramsToDelete) {
				EObject container = diagram.eContainer();
				delete(diagram);
				if (container instanceof EAnnotation) {
					EAnnotation annotation = (EAnnotation) container;
					if (annotation.getContents().isEmpty()) {
						delete(annotation);
					}
				}
			}

			diagramsToDelete.clear();

			monitor.subTask("Analyzing dangling references...");

			long startDangling = System.nanoTime();
			handleDanglingURIs(resourcesToSave);
			long endDangling = System.nanoTime();
			this.danglingRefTime = endDangling - startDangling;

			monitor.subTask("Saving models...");

			for (Resource resource : resourcesToSave) {
				try {
					cleanMetadataAnnotations(resource);
					ResourceAccessHelper.INSTANCE.saveResource(resource, null);
				} catch (Exception ex) {
					Activator.log.error(ex);
					generationStatus.add(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "An exception occurred during save", ex));
				}
			}
		}

		monitor.subTask("Releasing memory...");

		unloadResourceSet(this.resourceSet);

		this.resourceSet = null;
		this.umlResource = null;
		// TODO : we ùust clean all ModelExtends and all resource (a method will help us!)
		this.outNotation = this.inParameters = this.outSashModel = this.outUML = null;

		monitor.done();
		return generationStatus;
	}

	/**
	 * 
	 * @param propertyURI
	 *            the uri of the property file
	 * @return
	 * 		the Resource to use for internationlization
	 */
	protected InternationalizationResource createAndConfigureInternationalizationResource(final URI propertyURI) {
		if (null == this.propertiesResource) {
			this.propertiesResource = new InternationalizationResource(propertyURI);
			this.propertiesResource.getDefaultSaveOptions().put(InternationalizationResourceOptionsConstants.SAVE_OPTION_SORT, Boolean.TRUE);
			this.propertiesResource.getDefaultSaveOptions().put(InternationalizationResourceOptionsConstants.LOAD_SAVE_OPTION_KEY_RESOLVER, UMLInternationalizationKeyResolver.getInstance());
		}
		return this.propertiesResource;
	}


	/**
	 * @see org.eclipse.papyrus.migration.rhapsody..transformations.NEW_AbstractImportTransformation_NEW#loadInPapyrusProfiles()
	 *
	 * @return
	 */
	@Override
	protected Diagnostic loadInPapyrusProfiles() {


		// currently there is nothing to do for Rhapsody import
		return null;
	}

	/**
	 * @see org.eclipse.papyrus.migration.rhapsody..transformations.NEW_AbstractImportTransformation_NEW#countSupportedElements()
	 *
	 * @return
	 */
	@Override
	protected int countSupportedElements() {
		// TODO Auto-generated method stub
		return 1000;
	}

	/**
	 * @see org.eclipse.papyrus.migration.rhapsody..transformations.NEW_AbstractImportTransformation_NEW#getDiagramTransformationURIs()
	 *
	 * @return
	 */
	@Override
	protected Collection<URI> getDiagramTransformationURIs() {
		return ListHelper.asList(new URI[] { getTransformationURI("Rhapsody2PapyrusNotation", Activator.PLUGIN_ID),

		});
	}

	/**
	 * @see org.eclipse.papyrus.migration.rhapsody..transformations.NEW_AbstractImportTransformation_NEW#getSemanticTransformationURI()
	 *
	 * @return
	 */
	@Override
	protected URI getSemanticTransformationURI() {
		// TODO never call, called from the Rhapsody2PapyrusNotation transform to make the link between uml created elements and their representation
		// return ListHelper.asList(new URI[] { getTransformationURI("Rhapsody2PapyrusSemanticElements"),
		//
		// });

		return null;
	}

	/**
	 * @see org.eclipse.papyrus.migration.rhapsody..transformations.NEW_AbstractImportTransformation_NEW#getProfilesTransformationURI()
	 *
	 * @return
	 */
	@Override
	protected Collection<URI> getProfilesTransformationURI() {
		return Collections.emptyList();
	}

	/**
	 * @see org.eclipse.papyrus.migration.common.transformation.AbstractImportTransformation#getAllTransformationURIs()
	 *
	 * @return
	 */
	@Override
	protected Collection<URI> getAllTransformationURIs() {
		final Collection<URI> allTransformations = new ArrayList<URI>();
		final URI semanticTransformationURI = getSemanticTransformationURI();
		if(null!=semanticTransformationURI){
			allTransformations.add(semanticTransformationURI);
		}
		final Collection<URI> diagramTransformationURI = getDiagramTransformationURIs();
		if(null!=diagramTransformationURI){
			allTransformations.addAll(diagramTransformationURI);
		}
		final Collection<URI> profilesTransformationURI = getProfilesTransformationURI();
		if(null!=profilesTransformationURI){
			allTransformations.addAll(profilesTransformationURI);
		}
		final Collection<URI> additionalTransformationURIs = getAdditionalTransformationURIs();
		if(null!=additionalTransformationURIs){
			allTransformations.addAll(additionalTransformationURIs);
		}
		return allTransformations;

	}

	/**
	 * @see org.eclipse.papyrus.migration.rhapsody..transformations.NEW_AbstractImportTransformation_NEW#getModelExtents()
	 *
	 * @return
	 */
	@Override
	protected List<ModelExtent> getModelExtents() {
		List<ModelExtent> allExtents = new LinkedList<ModelExtent>();
		allExtents.add(getInRhapsodyModel());
		allExtents.add(getInoutNotationModel());
		allExtents.add(getInOutUMLModel());
		allExtents.add(getPrimitivesCUMLModel());
		allExtents.add(getSysML1_1Profile());
		allExtents.add(getInUMLPrimitivesTypes());
		allExtents.add(getInOutInternationalizationModel());
		return allExtents;
	}


	public ModelExtent getInUMLPrimitivesTypes() {
		URI umlPrimitivesTypesURI = URI.createURI("pathmap://UML_LIBRARIES/UMLPrimitiveTypes.library.uml");
		Resource umlPrimitivesTypesResource = resourceSet.getResource(umlPrimitivesTypesURI, true);
		umlPrimitivesTypes = new BasicModelExtent(umlPrimitivesTypesResource.getContents());
		return umlPrimitivesTypes;
	}

	private ModelExtent inRhapsodyModel, primitivesCTypesModel, umlPrimitivesTypes, labels;

	public ModelExtent getInRhapsodyModel() {
		if (inRhapsodyModel == null) {
			Resource resource = resourceSet.getResource(sourceURI, true);
			inRhapsodyModel = new BasicModelExtent(resource.getContents());
		}
		return inRhapsodyModel;
	}

	public ModelExtent getSysML1_1Profile() {
		URI sysMLProfile = URI.createURI("pathmap://SysML_PROFILES/SysML.profile.uml");
		Resource fCMProfile = resourceSet.getResource(sysMLProfile, true);
		sysML11Profile = new BasicModelExtent(fCMProfile.getContents());
		return sysML11Profile;
	}

	public ModelExtent getPrimitivesCUMLModel() {
		// URI primitiveTypesURI = URI.createURI("pathmap://PapyrusC_Cpp_LIBRARIES/AnsiCLibrary.uml");
		URI primitiveTypesURI = URI.createURI("pathmap://PapyrusC_Cpp_LIBRARIES_Rhapsody/AnsiCLibrary.uml");
		Resource primitiveTypes = resourceSet.getResource(primitiveTypesURI, true);
		primitivesCTypesModel = new BasicModelExtent(primitiveTypes.getContents());
		return primitivesCTypesModel;
	}


	/**
	 * 
	 * @return
	 * 		the model extends to use to create the required file .property
	 */
	public ModelExtent getInOutInternationalizationModel() {
		if (this.labels == null) {
			this.labels = new BasicModelExtent();
		}
		return this.labels;
	}


	/**
	 * @see org.eclipse.papyrus.migration.rhapsody..transformations.NEW_AbstractImportTransformation_NEW#initTransformationProperties(org.eclipse.m2m.qvt.oml.ExecutionContextImpl)
	 *
	 * @param context
	 */
	@Override
	protected void initTransformationProperties(ExecutionContextImpl context) {
		// TODO Auto-generated method stub

	}

	/**
	 * @see org.eclipse.papyrus.migration.rhapsody..transformations.NEW_AbstractImportTransformation_NEW#convertToPapyrus(org.eclipse.emf.common.util.URI, java.lang.String)
	 *
	 * @param initialModelURI
	 * @param extension
	 * @return
	 */
	@Override
	protected URI convertToPapyrus(URI initialModelURI, String extension) {
		return initialModelURI.trimFileExtension().appendFileExtension(extension);
	}

	/**
	 * @see org.eclipse.papyrus.migration.rhapsody..transformations.NEW_AbstractImportTransformation_NEW#createUMLResource(org.eclipse.emf.ecore.resource.ResourceSet, org.eclipse.emf.common.util.URI, org.eclipse.emf.common.util.URI)
	 *
	 * @param resourceSet
	 * @param sourceResourceURI
	 * @param targetResourceURI
	 * @return
	 */
	@Override
	protected Resource createUMLResource(ResourceSet resourceSet, URI sourceResourceURI, URI targetResourceURI) {
		Resource resource = resourceSet.createResource(targetResourceURI, UMLResource.UML_5_0_0_CONTENT_TYPE_IDENTIFIER);
		return resource;
	}

	/**
	 * @see org.eclipse.papyrus.migration.rhapsody..transformations.NEW_AbstractImportTransformation_NEW#getInOutUMLModel()
	 *
	 * @return
	 */
	@Override
	public ModelExtent getInOutUMLModel() {
		if (outUML == null) {
			outUML = new BasicModelExtent();
		}
		return outUML;
	}




}
