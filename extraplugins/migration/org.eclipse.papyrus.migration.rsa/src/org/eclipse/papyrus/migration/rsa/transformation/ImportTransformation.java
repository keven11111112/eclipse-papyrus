/*****************************************************************************
 * Copyright (c) 2013, 2017 CEA LIST, Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Christian W. Damus - bugs 496439, 496299, 505330
 *  
 *****************************************************************************/
package org.eclipse.papyrus.migration.rsa.transformation;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticException;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.gmf.runtime.emf.core.resources.GMFResource;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Style;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.m2m.qvt.oml.BasicModelExtent;
import org.eclipse.m2m.qvt.oml.ExecutionContext;
import org.eclipse.m2m.qvt.oml.ExecutionContextImpl;
import org.eclipse.m2m.qvt.oml.ExecutionDiagnostic;
import org.eclipse.m2m.qvt.oml.ModelExtent;
import org.eclipse.m2m.qvt.oml.TransformationExecutor;
import org.eclipse.m2m.qvt.oml.util.ISessionData;
import org.eclipse.m2m.qvt.oml.util.Trace;
import org.eclipse.m2m.qvt.oml.util.WriterLog;
import org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.PapyrusDSMLValidationRulePackage;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.emf.resource.ShardResourceHelper;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.gmfdiag.common.model.NotationModel;
import org.eclipse.papyrus.infra.tools.util.ClassLoaderHelper;
import org.eclipse.papyrus.infra.tools.util.ListHelper;
import org.eclipse.papyrus.m2m.qvto.TraceHelper;
import org.eclipse.papyrus.m2m.qvto.TransformationUI;
import org.eclipse.papyrus.migration.rsa.Activator;
import org.eclipse.papyrus.migration.rsa.RSAToPapyrusParameters.Config;
import org.eclipse.papyrus.migration.rsa.RSAToPapyrusParameters.RSAToPapyrusParametersFactory;
import org.eclipse.papyrus.migration.rsa.blackbox.ProfileBaseHelper;
import org.eclipse.papyrus.migration.rsa.concurrent.ExecutorsPool;
import org.eclipse.papyrus.migration.rsa.concurrent.ResourceAccessHelper;
import org.eclipse.papyrus.migration.rsa.default_.DefaultPackage;
import org.eclipse.papyrus.migration.rsa.internal.extension.PostProcessExtension;
import org.eclipse.papyrus.migration.rsa.internal.extension.TransformationExtension;
import org.eclipse.papyrus.migration.rsa.profilebase.ProfileBasePackage;
import org.eclipse.papyrus.uml.documentation.Documentation.DocumentationPackage;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.statushandlers.StatusManager;
import org.eclipse.uml2.common.util.CacheAdapter;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Extension;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.eclipse.uml2.uml.util.UMLUtil;

import com.google.common.collect.ImmutableList;

/**
 * Executes a single RSA-to-Papyrus transformation
 *
 * @author Camille Letavernier
 *
 */
public class ImportTransformation {

	/** For debug purpose */
	private static final boolean DEBUG = false;

	// SourceURI is the input
	protected URI sourceURI;

	// targetURI is computed during the transformation
	protected URI targetURI;

	protected ModelExtent outUML, outNotation, outSashModel, inParameters, inPapyrusProfiles;

	protected MigrationResourceSet resourceSet;

	protected Job job;

	protected Resource umlResource;

	protected Config parameters;

	protected boolean complete = false;

	// For logging purpose (Bug 455001)
	// Starts when the job starts; ends when the job returns
	/** Execution time, in nano-seconds */
	protected long executionTime = 0L;

	/** Execution time of the initial model loading / ns */
	protected long loadingTime = 0L;

	/** Execution time for handling dangling references / ns */
	protected long danglingRefTime = 0L;

	/** Execution time for executing the UML-RT transformation / ns */
	protected long importExtensionsTime = 0L;

	/** Source URI to Target URI map (For Models/Libraries/Fragments) */
	protected final Map<URI, URI> uriMappings = new HashMap<>();

	/** Source URI to Target URI map (For Profiles) */
	protected final Map<URI, URI> profileURIMappings = new HashMap<>();

	protected List<Diagram> diagramsToDelete = new LinkedList<>();

	protected static final ExecutorsPool executorsPool = new ExecutorsPool(2);

	/** EPackages corresponding to source native profiles with specific support in the transformation */
	protected static final Set<EPackage> sourceEPackages = new HashSet<>();

	protected final DependencyAnalysisHelper analysisHelper;

	/** Store the extension classes to avoid re-parsing the extension point, but still be able to instantiate them in parallel/multiple times */
	protected final static List<Class<? extends TransformationExtension>> extensionClasses = ImmutableList.copyOf(loadExtensionClasses());

	/** Extensions contributed via other plug-ins */
	protected final List<TransformationExtension> extensions;

	/** The extension point contributing {@link TransformationExtension}s */
	public static final String EXTENSION_POINT_ID = Activator.PLUGIN_ID + ".extensions";

	/** Accumulation of incremental update traces from each transformation. */
	private Trace trace = Trace.createEmptyTrace();

	/** Transformation execution context used for all transformation runs. */
	private ExecutionContext context;

	static {
		sourceEPackages.add(org.eclipse.papyrus.migration.rsa.default_.DefaultPackage.eINSTANCE);
		sourceEPackages.add(org.eclipse.papyrus.migration.rsa.profilebase.ProfileBasePackage.eINSTANCE);

		for (TransformationExtension extension : getAllExtensions()) {
			sourceEPackages.addAll(extension.getAdditionalSourceEPackages());
		}
	}

	public ImportTransformation(URI sourceURI) {
		this(sourceURI, RSAToPapyrusParametersFactory.eINSTANCE.createConfig(), null);
	}

	public ImportTransformation(URI sourceURI, Config config, DependencyAnalysisHelper analysisHelper) {
		Assert.isNotNull(sourceURI);
		this.sourceURI = sourceURI;
		this.parameters = config;
		this.analysisHelper = analysisHelper;
		this.extensions = getAllExtensions();
	}

	/**
	 * Parse the extension point and return all valid classes (To be instantiated by each instance of the transformation)
	 *
	 * @return
	 * 		All the valid (i.e. instantiatable) extensions to the RSA-to-Papyrus transformation. The list is never null, but can be empty
	 */
	protected static List<Class<? extends TransformationExtension>> loadExtensionClasses() {
		LinkedList<Class<? extends TransformationExtension>> result = new LinkedList<>();

		IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSION_POINT_ID);
		for (IConfigurationElement e : config) {
			try {
				String className = e.getAttribute("className");

				Class<? extends TransformationExtension> extensionClass = ClassLoaderHelper.loadClass(className, TransformationExtension.class);
				if (result == null) {
					continue; // ClassLoaderHelper has already logged an exception (ClassNotFound, not type-compliant, ...)
				}

				if (extensionClass.getConstructor() == null) { // No default constructor
					Activator.log.error(new IllegalArgumentException(String.format("The class %s contributed by %s should have a default constructor", extensionClass.getName(), e.getContributor())));
				}

				result.add(extensionClass);
			} catch (Throwable t) { // Other errors (Most common ones should have already been caught)
				Activator.log.error(String.format("The plug-in %s contributed an invalid class", e.getContributor()), t);
			}
		}

		return result;
	}

	/**
	 * Instantiate all the extensions for a specific transformation
	 *
	 * @return
	 * 		A non-null (potentially empty) list of extensions
	 */
	protected static List<TransformationExtension> getAllExtensions() {
		List<TransformationExtension> extensions = new ArrayList<>(extensionClasses.size());

		for (Class<? extends TransformationExtension> extension : extensionClasses) {
			try {
				extensions.add(extension.newInstance()); // Extension has already been checked while parsing the extension point. We don't expect any error here
			} catch (Exception ex) {
				Activator.log.error(ex);
			}
		}

		return extensions;
	}

	public void run() {
		run(true);
	}

	/**
	 * Executes the transformation
	 *
	 * The transformation will be executed asynchronously in a Job
	 */
	public void run(final boolean isUserJob) {

		job = new Job("Import " + getModelName()) {

			@Override
			protected IStatus run(IProgressMonitor monitor) {
				long begin = System.nanoTime();
				IStatus result = ImportTransformation.this.run(monitor);
				long end = System.nanoTime();
				executionTime = end - begin;
				return result;
			}
		};

		job.setUser(isUserJob);

		job.addJobChangeListener(new JobChangeAdapter() {

			@Override
			public void done(IJobChangeEvent event) {
				complete = true;
				if (isUserJob) {
					if (event.getResult().getSeverity() == IStatus.OK) {
						Display.getDefault().asyncExec(new Runnable() {

							@Override
							public void run() {
								MessageDialog.openInformation(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), job.getName(), String.format("Model %s has been successfully imported", getModelName()));
							}
						});

					} else if (event.getResult().getSeverity() == IStatus.CANCEL) {
						Display.getDefault().asyncExec(new Runnable() {

							@Override
							public void run() {
								MessageDialog.openInformation(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), job.getName(), String.format("Operation canceled: %s", getModelName()));
							}
						});
					} else {
						StatusManager.getManager().handle(event.getResult(), StatusManager.BLOCK);
					}
				}
			}

		});

		job.schedule();
	}

	public void waitForCompletion() {
		try {
			job.join();
		} catch (InterruptedException ex) {
			Activator.log.error(ex);
		}
	}

	public boolean isComplete() {
		return complete;
	}

	public IStatus getStatus() {
		if (job == null) { // If job hasn't been created, the operation has probably been canceled before the transformation is ran
			return new Status(IStatus.CANCEL, Activator.PLUGIN_ID, "Operation canceled");
		}
		return job.getResult();
	}

	public long getExecutionTime() {
		return executionTime;
	}

	public long getLoadingTime() {
		return loadingTime;
	}

	public long getHandleDanglingRefTime() {
		return danglingRefTime;
	}

	public long getImportExtensionsTime() {
		return importExtensionsTime;
	}

	public Map<URI, URI> getURIMappings() {
		return uriMappings;
	}

	public Map<URI, URI> getProfileURIMappings() {
		return profileURIMappings;
	}

	public URI getTargetURI() {
		return targetURI;
	}

	/**
	 * Initializes the resource set, and resolve all dependencies
	 */
	protected void initResourceSet(IProgressMonitor monitor) {
		resourceSet = new MigrationResourceSetImpl(analysisHelper);
		synchronized (UMLUtil.class) {
			UMLUtil.init(resourceSet);
		}
		resourceSet.getLoadOptions().put(XMLResource.OPTION_DEFER_ATTACHMENT, true);
		resourceSet.getLoadOptions().put(XMLResource.OPTION_DEFER_IDREF_RESOLUTION, true);
		resourceSet.getLoadOptions().put(XMLResource.OPTION_RECORD_UNKNOWN_FEATURE, Boolean.TRUE);
		resourceSet.getLoadOptions().put(XMLResource.OPTION_USE_PACKAGE_NS_URI_AS_LOCATION, Boolean.FALSE);

		monitor.subTask("Loading source model " + getModelName());

		try {
			resourceSet.getResource(sourceURI, true);
			loadInPapyrusProfiles();
		} catch (Exception ex) {
			Activator.log.error("An error occurred while loading " + getModelName(), ex);
		}
	}

	protected void initResourceSet(URI sourceURI, MigrationResourceSet resourceSet) {
		this.sourceURI = sourceURI;
		this.resourceSet = resourceSet;
		this.umlResource = resourceSet.getResource(sourceURI, false);

		// These are all new in the new resource set
		outUML = null;
		outNotation = null;
		outSashModel = null;
		inPapyrusProfiles = null;
	}

	/**
	 * Returns the number of elements to be migrated (i.e. diagrams to be migrated + specific non-trivial elements)
	 * Used to initialize the progress monitor
	 *
	 * @return
	 * 		The total number of elements to be migrated
	 */
	protected int countSupportedElements() {
		int i = 0;

		ModelExtent extent = getInOutUMLModel();
		for (EObject eObject : extent.getContents()) {

			TreeIterator<EObject> modelIterator = EcoreUtil.getAllContents(eObject, true);
			while (modelIterator.hasNext()) {
				EObject next = modelIterator.next();
				if (next instanceof Diagram) {
					Diagram diagram = (Diagram) next;
					if (isSupported(diagram)) {
						i++;
						diagramsToDelete.add(diagram);
					}
					modelIterator.prune(); // Don't navigate Diagram children
				} else if (next instanceof OpaqueExpression) {
					if (parameters.isConvertOpaqueExpressionToLiteralString()) {
						OpaqueExpression exp = (OpaqueExpression) next;
						if (needsConversion(exp)) {
							i++;
						}
					}
				}
			}
		}

		i += getAllTransformationURIs().size();

		// Add the number of steps required by each extension
		for (TransformationExtension extension : getExtensions()) {
			int extraSteps = extension.getNumberOfSteps();
			if (extraSteps > 0) {
				i += extraSteps;
			}
		}

		return i;
	}

	/**
	 * Returns true if the OpaqueExpression is to be converted to a LiteralString
	 * OpaqueExpressions are converted to LiteralString when they have a single body with no language
	 *
	 * @param exp
	 * @return
	 */
	protected static boolean needsConversion(OpaqueExpression exp) {
		List<String> languages = exp.getLanguages();
		List<String> bodies = exp.getBodies();
		if (bodies.size() > 1) {
			return false;
		}

		if (languages.isEmpty() || (languages.size() == 1 && exp.getLanguages().get(0).isEmpty())) {
			return true;
		}

		return false;
	}

	protected static final Set<String> supportedDiagramIds = new HashSet<>();

	protected static boolean isSupported(Diagram diagram) {
		return supportedDiagramIds.contains(diagram.getType());
	}

	// Preloads all required transformations (Either locally or statically, depending on the cache parameter)
	protected IStatus loadTransformations(IProgressMonitor monitor) {
		for (URI transformationURI : getAllTransformationURIs()) {
			executorsPool.preLoad(transformationURI);
			monitor.worked(1);
		}

		return Status.OK_STATUS;
	}

	// MemoryLeak: Don't rely on BasicDiagnostic.toIStatus
	// The source Diagnostic contains references to the QVTo ModelExtents, referencing the Model elements (used in #extractPapyrusProfiles())
	// When using the standard conversion, these references are not discarded
	protected static IStatus createStatusFromDiagnostic(Diagnostic diagnostic) {
		return new Status(diagnostic.getSeverity(),
				diagnostic.getSource(),
				diagnostic.getMessage(),
				diagnostic.getException());
	}

	/**
	 * Actually runs the transformation (in the current thread)
	 *
	 * @param monitor
	 * @return The transformation IStatus
	 */
	protected IStatus run(final IProgressMonitor monitor) {

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

			long startExtensions = System.nanoTime();
			result = importExtensions(context, monitor, ExtensionFunction::executeBefore);
			long endExtensions = System.nanoTime();
			this.importExtensionsTime = endExtensions - startExtensions;
			generationStatus.add(result);

			// Diagrams
			Collection<URI> transformations = getDiagramTransformationURIs();

			monitor.subTask("Importing diagrams...");
			for (URI transformationURI : transformations) {
				result = runTransformation(transformationURI, extents, monitor);
				generationStatus.add(result);
			}

			// Semantic model changes (Default language for OpaqueExpressions...)
			monitor.subTask("Importing semantic model...");
			result = runTransformation(getSemanticTransformationURI(), extents, monitor);
			generationStatus.add(result);

			if (!monitor.isCanceled()) {
				monitor.subTask("Handle additional profiles...");
				// Default.epx and ProfileBase.epx
				result = importRSAProfiles(context, monitor);
				generationStatus.add(result);
			}

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

			XMIResource sashResource = new XMIResourceImpl(sashModelURI);
			resourceSet.getResources().add(sashResource);
			List<EObject> sashModelObjects = getOutSashModel().getContents();
			sashResource.getContents().addAll(sashModelObjects);

			configureResource(sashResource);
			configureResource(notationResource);
			configureResource((XMIResource) umlResource);

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

			for (Resource resource : resourcesToSave) {
				List<EObject> rootElements = new LinkedList<>(resource.getContents());
				for (EObject rootElement : rootElements) {
					EPackage ePackage = rootElement.eClass().getEPackage();
					if (ePackage == ProfileBasePackage.eINSTANCE || ePackage == DefaultPackage.eINSTANCE) {
						delete(rootElement);
					}
				}
			}

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
		this.outNotation = this.inParameters = this.outSashModel = this.outUML = null;

		monitor.done();
		return generationStatus;
	}

	/**
	 * Functional interface to abstract {@link TransformationExtension#executeBefore(ExecutionContext, IProgressMonitor)}
	 * and {@link TransformationExtension#executeAfter(ExecutionContext, IProgressMonitor)}
	 *
	 * @author Camille Letavernier
	 *
	 */
	@FunctionalInterface
	protected static interface ExtensionFunction {
		public IStatus apply(TransformationExtension extension, ExecutionContext context, IProgressMonitor monitor);

		/**
		 * Implements ExtensionFunction
		 *
		 * Delegates to {@link TransformationExtension#executeBefore(ExecutionContext, IProgressMonitor)}
		 */
		public static IStatus executeBefore(TransformationExtension extension, ExecutionContext context, IProgressMonitor monitor) {
			return extension.executeBefore(context, monitor);
		}

		/**
		 * Implements ExtensionFunction
		 *
		 * Delegates to {@link TransformationExtension#executeAfter(ExecutionContext, IProgressMonitor)}
		 */
		public static IStatus executeAfter(TransformationExtension extension, ExecutionContext context, IProgressMonitor monitor) {
			return extension.executeAfter(context, monitor);
		}

		/**
		 * Delegates to {@link PostProcessExtension#postProcess(ExecutionContext, IProgressMonitor)}.
		 */
		public static IStatus postProcess(TransformationExtension extension, ExecutionContext context, IProgressMonitor monitor) {
			return Optional.of(extension)
					.filter(PostProcessExtension.class::isInstance)
					.map(PostProcessExtension.class::cast)
					.map(post -> post.postProcess(context, SubMonitor.convert(monitor, 1)))
					.orElse(Status.OK_STATUS);
		}
	}

	protected void prepareExtensions() {
		for (TransformationExtension extension : getExtensions()) {
			extension.setResourceSet(resourceSet);
			extension.setExecutorsPool(executorsPool);
			extension.setTransformation(this);
		}
	}

	/**
	 * @return the extensions
	 */
	protected List<TransformationExtension> getExtensions() {
		return extensions;
	}

	protected IStatus importExtensions(ExecutionContext context, IProgressMonitor monitor, ExtensionFunction function) {
		List<IStatus> allResults = new ArrayList<>(getExtensions().size());
		for (TransformationExtension extension : getExtensions()) {
			IStatus result = function.apply(extension, context, monitor);
			allResults.add(result);
		}

		if (allResults.isEmpty()) {
			return Status.OK_STATUS;
		} else if (allResults.size() == 1) {
			return allResults.get(0);
		} else {
			return aggregateStatus(allResults);
		}
	}

	// FIXME implement properly
	public static MultiStatus aggregateStatus(List<IStatus> statuses) {
		return new MultiStatus(Activator.PLUGIN_ID, IStatus.OK, statuses.toArray(new IStatus[statuses.size()]), "", null);
	}

	/**
	 * @param resource
	 */
	private void cleanMetadataAnnotations(Resource resource) {
		// Bug 471684: UML2.x to UML2.5 creates (invalid) Ecore Metadata EAnnotations, which then cause OCL validation to fail
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

	protected void handleDanglingURIs(Collection<Resource> resourcesToSave) {
		if (analysisHelper != null) {
			resourceSet.freeze();
			try {
				analysisHelper.computeURIMappings(resourcesToSave);
			} finally {
				resourceSet.unfreeze();
			}
		}
	}

	protected void unloadResourceSet(ResourceSet resourceSet) {
		EMFHelper.unload(resourceSet);
	}

	protected IStatus importRSAProfiles(ExecutionContext context, IProgressMonitor monitor) {
		URI transformationURI = getProfilesTransformationURI();

		List<ModelExtent> extents = new LinkedList<>();
		extents.add(getInOutUMLModel());
		extents.add(getInoutNotationModel());
		Diagnostic loadedProfiles = loadInPapyrusProfiles();
		extents.add(getInPapyrusProfiles());
		extents.add(getInProfileDefinitions());
		extents.add(getInConfig());

		IStatus transformationStatus = runTransformation(transformationURI, extents, monitor);
		IStatus loadedProfilesStatus = createStatusFromDiagnostic(loadedProfiles);

		int severity = Math.max(loadedProfiles.getSeverity(), transformationStatus.getSeverity());

		String message;
		if (severity > IStatus.OK) {
			message = "The following errors occurred:";
		} else {
			message = "OK";
		}

		IStatus completeResult = new MultiStatus(Activator.PLUGIN_ID, severity, new IStatus[] { loadedProfilesStatus, transformationStatus }, message, null);

		return completeResult;
	}

	protected TransformationExecutor getTransformation(URI transformationURI, IProgressMonitor monitor) throws DiagnosticException {
		return executorsPool.getExecutor(transformationURI);
	}

	// Static synchronized, as it seems that QVTo can't load 2 transformations at the same time, even in separate execution contexts
	protected static synchronized TransformationExecutor loadTransformationExecutor(URI transformationURI, IProgressMonitor monitor) throws DiagnosticException {
		TransformationExecutor executor = new TransformationExecutor(transformationURI);
		Diagnostic diagnostic = executor.loadTransformation(monitor);

		if (diagnostic.getSeverity() != Diagnostic.OK) {
			throw new DiagnosticException(diagnostic);
		}

		return executor;
	}

	protected Properties readProfileBaseProperties() {
		URI propertiesURI = sourceURI.trimFileExtension().appendFileExtension("properties");

		Properties properties = new Properties();
		InputStream inputStream = null;

		try {
			URL url = new URL(propertiesURI.toString());
			inputStream = url.openStream();
			properties.load(inputStream);
		} catch (FileNotFoundException ex) {
			// Ignore: the file doesn't exist
		} catch (IOException ex) {
			Activator.log.error(ex);
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException ex) {
					Activator.log.error(ex);
				}
			}
		}

		return properties;
	}

	protected ModelExtent getInProfileDefinitions() {
		return new BasicModelExtent(Arrays.asList(new EPackage[] {
				PapyrusDSMLValidationRulePackage.eINSTANCE,
				DocumentationPackage.eINSTANCE
		}));
	}

	protected ModelExtent getInPapyrusProfiles() {
		if (inPapyrusProfiles == null) {
			loadInPapyrusProfiles();
		}

		return inPapyrusProfiles;
	}

	/**
	 * Returns a Diagnostic. Diagnostic#data is the ModelExtent containing the loaded profiles
	 *
	 * @return
	 * @throws WrappedException
	 */
	protected Diagnostic loadInPapyrusProfiles() {
		if (inPapyrusProfiles != null) {
			return Diagnostic.OK_INSTANCE;
		}

		List<String> missingProfiles = new LinkedList<>();

		List<EObject> allContents = new LinkedList<>();
		try {
			URI validationProfileURI = URI.createURI("pathmap://DSMLValidation_PROFILES/PapyrusValidationRuleDSML.uml");
			Resource validationProfile = resourceSet.getResource(validationProfileURI, true);
			checkResource(validationProfile);
			allContents.addAll(validationProfile.getContents());
		} catch (WrappedException ex) {
			missingProfiles.add("Validation Rules Profile");
		}

		try {
			URI documentationProfileURI = URI.createURI("pathmap://PAPYRUS_DOCUMENTATION/Papyrus.profile.uml");
			Resource documentationProfile = resourceSet.getResource(documentationProfileURI, true);
			checkResource(documentationProfile);
			allContents.addAll(documentationProfile.getContents());
		} catch (WrappedException ex) {
			missingProfiles.add("Documentation Profile");
		}

		inPapyrusProfiles = new BasicModelExtent(allContents);

		String message;
		int code;
		if (missingProfiles.isEmpty()) {
			message = "OK";
			code = Diagnostic.OK;
		} else {
			message = "The following Papyrus profiles cannot be found: " + ListHelper.deepToString(missingProfiles, ", ");
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
		// Use the same resource to ensure that XMI IDs are maintained
		Resource resource = resourceSet.getResource(sourceResourceURI, false);
		resource.setURI(targetResourceURI);
		return resource;
	}

	protected ModelExtent getInConfig() {
		if (inParameters == null) {
			inParameters = new BasicModelExtent(Collections.singletonList(parameters));
		}
		return inParameters;
	}

	protected Collection<Resource> handleFragments(Resource umlResource, Resource notationResource, Resource sashResource) {
		Collection<Resource> result = new HashSet<>();
		result.add(umlResource);
		result.add(notationResource);
		result.add(sashResource);

		ResourceSet resourceSet = umlResource.getResourceSet();

		Iterator<EObject> elementIterator = umlResource.getAllContents();

		Set<Resource> fragmentResources = new HashSet<>();
		List<EAnnotation> rsaAnnotations = new ArrayList<>();

		while (elementIterator.hasNext()) {
			EObject element = elementIterator.next();
			Resource possibleFragment = element.eResource();
			if ((possibleFragment != umlResource) && possibleFragment.getContents().contains(element)) { // Controlled/Fragment root
				fragmentResources.add(possibleFragment);
			}

			collectRSAAnnotations(element, rsaAnnotations);
		}

		// Strip all RSA fragment annotations
		rsaAnnotations.forEach(EcoreUtil::remove);

		List<Resource> fragmentUMLResources = new LinkedList<>();

		for (Resource fragmentResource : fragmentResources) {
			URI papyrusFragmentURI = convertToPapyrus(fragmentResource.getURI(), UMLResource.FILE_EXTENSION);

			uriMappings.put(fragmentResource.getURI(), papyrusFragmentURI);

			Resource newResource = resourceSet.getResource(papyrusFragmentURI, false);
			if (newResource == null) {
				newResource = createUMLResource(resourceSet, fragmentResource.getURI(), papyrusFragmentURI);

				fragmentUMLResources.add(newResource);

				Resource fragmentNotationResource = new GMFResource(convertToPapyrus(papyrusFragmentURI, "notation"));
				Resource fragmentDiResource = new XMIResourceImpl(convertToPapyrus(papyrusFragmentURI, "di"));

				result.add(fragmentNotationResource);
				result.add(fragmentDiResource);

				resourceSet.getResources().add(fragmentNotationResource);
				resourceSet.getResources().add(fragmentDiResource);
			}

			newResource.getContents().addAll(fragmentResource.getContents());

			// Make it a Papyrus controlled unit of the "shard" variety
			try (ShardResourceHelper shard = new ShardResourceHelper(newResource)) {
				shard.setShard(true);
			}

			result.add(newResource);
		}

		deleteSourceStereotypes(fragmentResources);

		List<EObject> importedElements = new LinkedList<>(notationResource.getContents());
		for (EObject notationElement : importedElements) {
			if (notationElement instanceof Diagram) {
				EObject semanticElement = ((Diagram) notationElement).getElement();
				if (semanticElement.eResource() != umlResource && semanticElement.eResource() != null) {

					URI notationFragmentURI = convertToPapyrus(semanticElement.eResource().getURI(), "notation");

					Resource newNotationResource = resourceSet.getResource(notationFragmentURI, false);
					if (newNotationResource == null) {
						newNotationResource = new GMFResource(notationFragmentURI);
						resourceSet.getResources().add(newNotationResource);
					}
					newNotationResource.getContents().add(notationElement);
					result.add(newNotationResource);
				}
			}
		}

		handleFragmentStereotypes(umlResource, fragmentUMLResources);

		for (Resource resource : result) {
			if (resource instanceof XMIResource) {
				configureResource((XMIResource) resource);
			}
		}

		return result;
	}

	/*
	 * Bug 447097: [Model Import] Importing a fragmented model causes stereotype applications to be lost in resulting submodel
	 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=447097
	 *
	 * Before the transformation, We moved all root elements from the fragment resources to the main
	 * resource, then we transformed some of them to Papyrus Stereotype Applications. We need to move
	 * these stereotype applications back to the proper fragment resource
	 */
	protected void handleFragmentStereotypes(Resource mainUMLResource, List<Resource> umlResources) {
		Iterator<EObject> rootElementIterator = mainUMLResource.getContents().iterator();
		while (rootElementIterator.hasNext()) {
			EObject rootElement = rootElementIterator.next();
			if (rootElement instanceof Element) {
				continue;
			}

			Resource targetStereotypeResource = getTargetStereotypeResource(rootElement, umlResources);
			if (targetStereotypeResource != null && targetStereotypeResource != mainUMLResource) {
				rootElementIterator.remove(); // To avoid ConcurrentModificationException when moving to the other resource
				targetStereotypeResource.getContents().add(rootElement);
			}
		}
	}

	protected Resource getTargetStereotypeResource(EObject rootElement, List<Resource> umlResources) {
		for (EReference eReference : rootElement.eClass().getEAllReferences()) {
			if (eReference.getName().startsWith(Extension.METACLASS_ROLE_PREFIX)) {
				Object value = rootElement.eGet(eReference);
				if (value instanceof Element) {
					return ((Element) value).eResource();
				}
			}
		}

		return null;
	}

	protected void deleteSourceStereotypes(Collection<Resource> fragmentResources) {
		Set<Resource> allResources = new HashSet<>(fragmentResources);
		allResources.add(umlResource);

		for (Resource resource : allResources) {

			// For performance reasons, RSA RT Stereotypes have not been deleted during the QVTo transformation (Bug 444379)
			// Delete them as a post-action. Iterate on all controlled models and delete the RealTime stereotypes at the root of each resource
			List<EObject> resourceContents = new LinkedList<>(resource.getContents());
			for (EObject rootElement : resourceContents) {
				if (sourceEPackages.contains(rootElement.eClass().getEPackage())) {
					delete(rootElement);
				}
			}
		}
	}

	/**
	 * Collects the RSA-style fragment linkage annotations, RSA diagrams, and other
	 * RSA-specific annotations attached to an {@code object}.
	 * 
	 * @param object
	 *            an object in the model
	 * @param annotations
	 *            collects the RSA-specific annotations
	 */
	protected void collectRSAAnnotations(EObject object, Collection<? super EAnnotation> annotations) {
		if (object instanceof EModelElement) {
			EModelElement modelElement = (EModelElement) object;
			modelElement.getEAnnotations().stream()
					.filter(this::isRSASpecificAnnotation)
					.forEach(annotations::add);
		}
	}

	protected boolean isRSASpecificAnnotation(EAnnotation annotation) {
		boolean result = false;

		String source = annotation.getSource();
		if (source != null) {
			// This covers both the fragments and the fragmentContainer annotation
			result = source.startsWith("com.ibm.xtools.uml.msl.fragment") //$NON-NLS-1$
					|| source.equals("uml2.diagrams") //$NON-NLS-1$
					// Covers the UI-reduction annotation
					|| source.startsWith("com.ibm.xtools.common.ui."); //$NON-NLS-1$
		}

		return result;
	}

	protected URI convertToPapyrus(URI rsaURI, String extension) {
		if ("epx".equals(rsaURI.fileExtension())) { //$NON-NLS-1$
			// Profiles: myProfile.profile.uml, myProfile.profile.notation, ...
			return rsaURI.trimFileExtension().appendFileExtension("profile").appendFileExtension(extension); //$NON-NLS-1$
		} else {
			// Models and Fragments: myModel.uml, myFragment.uml, ...
			return rsaURI.trimFileExtension().appendFileExtension(extension);
		}
	}

	/**
	 * Runs a transformation using the context shared by all transformations.
	 * 
	 * @param transformationURI
	 *            the transformation to run
	 * @param extents
	 *            the extents on which to apply the transformation
	 * @param monitor
	 *            progress monitor
	 * 
	 * @return the result of the transformation execution
	 */
	public IStatus runTransformation(URI transformationURI, List<ModelExtent> extents, IProgressMonitor monitor) {
		return runTransformation(transformationURI, context, monitor, extents);
	}

	protected IStatus runTransformation(URI transformationURI, ExecutionContext context, IProgressMonitor monitor, List<ModelExtent> extents) {
		if (monitor.isCanceled()) {
			return new Status(IStatus.CANCEL, Activator.PLUGIN_ID, "Operation canceled");
		}

		TransformationExecutor executor;
		try {
			executor = getTransformation(transformationURI, monitor);
		} catch (DiagnosticException ex) {
			Diagnostic diagnostic = ex.getDiagnostic();

			Activator.log.warn(String.format("Cannot load the transformation : %s. Diagnostic: %s", transformationURI, diagnostic.getMessage()));
			return createStatusFromDiagnostic(diagnostic);
		}

		ExecutionDiagnostic result;
		synchronized (executor) {
			try {
				// Gather the new execution traces
				Trace newTraces = Trace.createEmptyTrace();
				@SuppressWarnings("restriction")
				ISessionData.SimpleEntry<Trace> traceKey = org.eclipse.m2m.internal.qvt.oml.evaluator.QVTEvaluationOptions.INCREMENTAL_UPDATE_TRACE;
				context.getSessionData().setValue(traceKey, newTraces);

				result = executor.execute(context, extents.toArray(new ModelExtent[0]));

				// Append to our history
				List<EObject> history = new ArrayList<>(trace.getTraceContent());
				history.addAll(newTraces.getTraceContent());
				trace.setTraceContent(history);
			} finally {
				executor.cleanup();
				executorsPool.releaseExecutor(executor);
			}
		}

		return createStatusFromDiagnostic(result);
	}

	protected ExecutionContext createExecutionContext(final IProgressMonitor monitor, final MultiStatus generationStatus) {
		ExecutionContextImpl context = new ExecutionContextImpl();
		context.setConfigProperty("keepModeling", true); //$NON-NLS-1$ o
		context.setConfigProperty(TransformationUI.MONITOR, monitor);

		// context.setProgressMonitor(monitor);

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

		initTransformationProperties(context);

		// Invoke extensions as incremental transformations

		context.getSessionData().setValue(TraceHelper.TRACE_HISTORY, trace);

		this.context = context;
		return context;
	}

	/**
	 * Initializes the ExecutionContext with configuration properties required by transformations
	 *
	 * This is a lightweight mechanism to avoid initializing ModelExtents for a single EObject reference, or for non-EMF values
	 *
	 * Typically used by blackbox methods
	 *
	 * @param context
	 */
	protected void initTransformationProperties(ExecutionContextImpl context) {
		// Load the *.properties file associated to ProfileBase
		context.setConfigProperty(ProfileBaseHelper.PROFILE_BASE_PROPERTIES, readProfileBaseProperties());

		// Load the InnerClassDiagramView (From viewpoints)
		URI innerClassDiagramViewURI = URI.createPlatformPluginURI("org.eclipse.papyrus.infra.viewpoints.policy/builtin/default.configuration", false);
		innerClassDiagramViewURI = innerClassDiagramViewURI.appendFragment("//@viewpoints.0/@modelKinds.0");

		context.setConfigProperty("InnerClassDiagramView", resourceSet.getEObject(innerClassDiagramViewURI, true));
	}

	protected void configureResource(XMIResource resource) {
		Map<Object, Object> saveOptions = new HashMap<>();

		// default save options.
		saveOptions.put(XMLResource.OPTION_DECLARE_XML, Boolean.TRUE);
		saveOptions.put(XMLResource.OPTION_PROCESS_DANGLING_HREF, XMLResource.OPTION_PROCESS_DANGLING_HREF_DISCARD);
		saveOptions.put(XMLResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);
		saveOptions.put(XMIResource.OPTION_USE_XMI_TYPE, Boolean.TRUE);
		saveOptions.put(XMLResource.OPTION_SAVE_TYPE_INFORMATION, Boolean.TRUE);
		saveOptions.put(XMLResource.OPTION_SKIP_ESCAPE_URI, Boolean.FALSE);
		saveOptions.put(XMLResource.OPTION_ENCODING, "UTF-8");

		// see bug 397987: [Core][Save] The referenced plugin models are saved using relative path
		saveOptions.put(XMLResource.OPTION_URI_HANDLER, new org.eclipse.emf.ecore.xmi.impl.URIHandlerImpl.PlatformSchemeAware());

		resource.setEncoding("UTF-8");
		resource.getDefaultSaveOptions().putAll(saveOptions);
	}

	protected List<ModelExtent> getModelExtents() {
		List<ModelExtent> allExtents = new LinkedList<>();
		allExtents.add(getInOutUMLModel());
		allExtents.add(getInoutNotationModel());
		allExtents.add(getOutSashModel());
		allExtents.add(getInConfig());
		return allExtents;
	}

	public ModelExtent getInOutUMLModel() {
		if (outUML == null) {
			try {
				Resource resource = resourceSet.getResource(sourceURI, true);

				/*
				 * Bug 447097: [Model Import] Importing a fragmented model causes stereotype applications to be lost in resulting submodel
				 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=447097
				 *
				 * StereotypeApplications from Fragments are not considered "rootElements" by QVTo, and
				 * there is no logical link between UML Elements and stereotype applications in fragments
				 * We need to make all root Elements available to the QVTo ModelExtent (Including the ones
				 * from fragments)
				 */
				List<EObject> allStereotypeApplications = new LinkedList<>();
				TreeIterator<EObject> allContents = resource.getAllContents();
				Set<Resource> browsedResources = new HashSet<>();
				browsedResources.add(resource);
				while (allContents.hasNext()) {
					EObject next = allContents.next();
					if (!(next instanceof Element)) { // Only navigate the UML hierarchy
						allContents.prune();
						continue;
					}

					Resource nextResource = next.eResource();
					if (!browsedResources.contains(nextResource)) {
						browsedResources.add(nextResource);
						for (EObject rootElement : nextResource.getContents()) {
							EPackage rootElementPackage = rootElement.eClass().getEPackage();
							if (sourceEPackages.contains(rootElementPackage)) {
								// We're interested in all stereotype applications which require a specific support in the QVTo transformation
								allStereotypeApplications.add(rootElement);
							}
						}
					}
				}

				List<EObject> allRootElements = new LinkedList<>(resource.getContents());
				allRootElements.addAll(allStereotypeApplications);

				// outUML = new BasicModelExtent(resource.getContents());
				outUML = new BasicModelExtent(allRootElements);

			} catch (Exception ex) {
				Activator.log.error(ex);
			}
		}

		return outUML;
	}

	/* Notation model is initially empty, but will be filled successively by each transformation */
	public ModelExtent getInoutNotationModel() {
		if (outNotation == null) {
			try {
				if (resourceSet instanceof ModelSet) {
					// This is the post-processing phase, so we already have the notations
					NotationModel notation = (NotationModel) ((ModelSet) resourceSet).getModel(NotationModel.MODEL_ID);
					if (notation != null) {
						List<EObject> diagrams = notation.getResources().stream()
								.flatMap(res -> res.getContents().stream())
								.filter(Diagram.class::isInstance)
								.collect(Collectors.toList());
						outNotation = new BasicModelExtent(diagrams);
					}
				}
			} catch (Exception e) {
				Activator.log.error(e);
			}

			if (outNotation == null) {
				// Guess it's not the post-processing phase
				outNotation = new BasicModelExtent();
			}
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
		supportedDiagramIds.addAll(Arrays.asList(new String[] {
				"Class", // Includes Profiles
				"Object",
				"Activity",
				// "Component", //Not yet
				// "Sequence", // Not yet
				"Statechart",
				"Structure"
		}));
	}

	protected Collection<URI> getDiagramTransformationURIs() {
		return ListHelper.asList(new URI[] {
				getTransformationURI("RSAClassDiagram"),
				// getTransformationURI("RSASequenceDiagram"), //Disabled since Sequence Diagrams are not properly supported
				getTransformationURI("RSAStructureDiagram"),
				getTransformationURI("RSAActivityDiagram"),
				getTransformationURI("RSAStateMachineDiagram"),
				getTransformationURI("RSAProfileDiagram"),
				getTransformationURI("RSAUsecaseDiagram")
		});
	}

	protected URI getSemanticTransformationURI() {
		return getTransformationURI("RSAModelToPapyrus");
	}

	protected URI getProfilesTransformationURI() {
		return getTransformationURI("RSAProfilesToPapyrus");
	}

	protected Collection<URI> getAdditionalTransformationURIs() {
		return Collections.emptyList();
	}

	protected Collection<URI> getAllTransformationURIs() {
		Collection<URI> allTransformations = getDiagramTransformationURIs();
		allTransformations.add(getProfilesTransformationURI());
		allTransformations.add(getSemanticTransformationURI());
		allTransformations.addAll(getAdditionalTransformationURIs());
		return allTransformations;
	}

	protected URI getTransformationURI(String transformationName) {
		return URI.createPlatformPluginURI(String.format("%s/transform/%s.qvto", Activator.PLUGIN_ID, transformationName), true); //$NON-NLS-1$
	}

	public String getModelName() {
		return URI.decode(sourceURI.lastSegment());
	}

	public void cancel() {
		job.cancel();
	}

	/** Lightweight delete operation, which only removes the object from its parent. Incoming references are not deleted */
	public void delete(EObject elementToDelete) {
		CacheAdapter adapter = CacheAdapter.getCacheAdapter(elementToDelete);
		if (adapter == null) {
			adapter = CacheAdapter.getInstance();
		}
		adapter.unsetTarget(elementToDelete);
		if (elementToDelete.eResource() != null) {
			elementToDelete.eResource().getContents().remove(elementToDelete);
		}

		EObject parent = elementToDelete.eContainer();
		if (parent == null) {
			return;
		}
		EReference containmentFeature = elementToDelete.eContainmentFeature();

		if (containmentFeature.getUpperBound() == 1) {
			parent.eUnset(containmentFeature);
		} else {
			List<?> values = (List<?>) parent.eGet(containmentFeature);
			values.remove(elementToDelete);
		}
	}

	public URI getSourceURI() {
		return sourceURI;
	}
}
