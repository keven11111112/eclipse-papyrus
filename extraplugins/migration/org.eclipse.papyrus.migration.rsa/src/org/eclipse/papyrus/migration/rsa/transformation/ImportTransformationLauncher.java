/*****************************************************************************
 * Copyright (c) 2014, 2017 CEA LIST, Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Christian W. Damus - bugs 496439, 505330
 *  
 *****************************************************************************/
package org.eclipse.papyrus.migration.rsa.transformation;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.impl.InternalTransactionalEditingDomain;
import org.eclipse.gmf.runtime.notation.DecorationNode;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.StringValueStyle;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.m2m.qvt.oml.ExecutionContext;
import org.eclipse.m2m.qvt.oml.util.Trace;
import org.eclipse.papyrus.infra.core.resource.IEMFModel;
import org.eclipse.papyrus.infra.core.resource.IModel;
import org.eclipse.papyrus.infra.core.resource.ModelMultiException;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.emf.resource.DependencyManagementHelper;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.tools.util.StringHelper;
import org.eclipse.papyrus.m2m.qvto.TraceHelper;
import org.eclipse.papyrus.migration.rsa.Activator;
import org.eclipse.papyrus.migration.rsa.RSAToPapyrusParameters.Config;
import org.eclipse.papyrus.migration.rsa.RSAToPapyrusParameters.MappingParameters;
import org.eclipse.papyrus.migration.rsa.RSAToPapyrusParameters.URIMapping;
import org.eclipse.papyrus.migration.rsa.concurrent.ResourceAccessHelper;
import org.eclipse.papyrus.migration.rsa.internal.extension.PostProcessExtension;
import org.eclipse.papyrus.migration.rsa.internal.schedule.JobWrapper;
import org.eclipse.papyrus.migration.rsa.internal.schedule.Schedulable;
import org.eclipse.papyrus.migration.rsa.internal.schedule.Scheduler;
import org.eclipse.papyrus.migration.rsa.internal.schedule.TransformationWrapper;
import org.eclipse.papyrus.migration.rsa.transformation.ImportTransformation.ExtensionFunction;
import org.eclipse.papyrus.migration.rsa.transformation.ui.URIMappingDialog;
import org.eclipse.papyrus.uml.tools.model.UmlModel;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;
import org.eclipse.ui.dialogs.SelectionDialog;
import org.eclipse.ui.statushandlers.StatusManager;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.ProfileApplication;
import org.eclipse.uml2.uml.Stereotype;

/**
 * Executes a batch of {@link ImportTransformation}s, then restores the dependencies (References)
 * between each other
 *
 * @author Camille Letavernier
 *
 */
public class ImportTransformationLauncher {

	// Nano to Second
	protected final static long SECOND = 1000 * 1000 * 1000;

	// Nano to Milliseconds
	protected final static long MILLIS = 1000 * 1000;

	protected final Config config;

	protected final Control baseControl;

	/**
	 * Own execution time, in nano-seconds. Doesn't take individual transformation's exec
	 * time into account. Also ignores the time when Blocking user Dialogs are opened
	 */
	protected long ownExecutionTime;

	/**
	 * Own loading time (For initial model loading)
	 */
	protected long ownLoadingTime;

	/**
	 * Own cumulated execution time for repairing stereotypes
	 */
	protected long ownRepairStereotypesTime;

	/**
	 * Own cumulated execution time for post-processing extensions
	 */
	protected long ownPostProcessingTime;

	/**
	 * Own cumulated execution time for repairing libraries
	 */
	protected long ownRepairLibrariesTime;

	/**
	 * Own execution time for resolving all matches for broken profiles/libraries
	 */
	protected long resolveAllDependencies;

	/**
	 * The top-level job for this transformation
	 */
	protected Job importDependenciesJob;

	/**
	 * Total time for all invidivual transformations to complete. Since they are executed in parallel,
	 * this may be different from their cumulated execution time (Unless a single thread is used)
	 */
	protected long transformationsExecutionTime = 0L;

	protected DependencyAnalysisHelper analysisHelper;

	public ImportTransformationLauncher(Config config) {
		this(config, null);
	}

	public ImportTransformationLauncher(Config config, Control baseControl) {
		this.config = config;
		this.baseControl = baseControl;
	}

	/**
	 * Executes the transformation (Asynchronous)
	 *
	 * @param urisToImport
	 */
	public void run(List<URI> urisToImport) {
		List<ImportTransformation> transformations = new LinkedList<ImportTransformation>();

		analysisHelper = new DependencyAnalysisHelper(config);

		for (URI uri : urisToImport) {
			ImportTransformation transformation = createTransformation(uri);
			transformations.add(transformation);
		}

		// Always use the batch launcher, even if there is only 1 transformation (Bug 455012)
		importModels(transformations);
	}

	protected ImportTransformation createTransformation(URI transformationURI) {
		return new ImportTransformation(transformationURI, config, analysisHelper);
	}

	/**
	 * Start a Job and delegate to {@link #importModels(IProgressMonitor, List)}
	 *
	 * @param transformations
	 */
	protected void importModels(final List<ImportTransformation> transformations) {
		importDependenciesJob = new Job("Import Models") {

			@Override
			protected IStatus run(IProgressMonitor monitor) {
				IStatus result = ImportTransformationLauncher.this.importModels(monitor, transformations);

				if (monitor.isCanceled()) {
					return new Status(IStatus.CANCEL, Activator.PLUGIN_ID, "Operation Canceled");
				}

				long cumulatedLoadingTime = 0L;
				long cumulatedTransformationTime = 0L;
				long cumulatedHandleDanglingTime = 0L;
				long cumulatedImportExtensionsTime = 0L;
				for (ImportTransformation transformation : transformations) {
					cumulatedLoadingTime += transformation.getLoadingTime();
					cumulatedImportExtensionsTime += transformation.getImportExtensionsTime();
					cumulatedHandleDanglingTime += transformation.getHandleDanglingRefTime();

					cumulatedTransformationTime += transformation.getExecutionTime();

					log("Import " + transformation.getModelName());
					log("First phase (0-50%):");
					log("\tTotal loading time: " + timeFormat(transformation.getLoadingTime()));
					log("\tTotal Import Extensions time: " + timeFormat(transformation.getImportExtensionsTime()));
					log("\tTotal Handle Dangling References time: " + timeFormat(transformation.getHandleDanglingRefTime()));
					log("\tTotal execution time: " + timeFormat(transformation.getExecutionTime()));

					Long loadingTime = loadingTimeV2.get(transformation);
					Long repairProxiesTime = proxiesTime.get(transformation);
					Long repairStereoTime = stereoTime.get(transformation);
					Long postTime = postProcessTime.get(transformation);
					Long totalPhase2 = totalTimeV2.get(transformation);

					log("Second phase (50-100%):");
					log("\tTotal loading time: " + timeFormat(loadingTime));
					log("\tTotal fix proxies time: " + timeFormat(repairProxiesTime));
					log("\tTotal fix stereotypes time: " + timeFormat(repairStereoTime));
					log("\tTotal post-processing time: " + timeFormat(postTime));
					log("\tTotal execution time: " + timeFormat(totalPhase2));

					log("Total");
					log("\tTotal execution time: " + timeFormat(transformation.getExecutionTime() + totalPhase2));
					log("\n");
				}

				int nbThreads = Math.max(1, config.getMaxThreads());
				log("First phase (0-50%) / " + nbThreads + " Threads");
				log("\tCumulated Transformation Time: " + timeFormat(cumulatedTransformationTime));
				log("\tCumulated Loading Time: " + timeFormat(cumulatedLoadingTime));
				log("\tCumulated Handle Dangling Refs Time: " + timeFormat(cumulatedHandleDanglingTime));
				log("\tCumulated Import Extensions Time: " + timeFormat(cumulatedImportExtensionsTime));
				log("\tTotal Transformation Time: " + timeFormat(transformationsExecutionTime));

				log("Second phase (50-100%) / " + nbThreads + " Threads");
				log("\tTotal Handle all Dangling References: " + timeFormat(resolveAllDependencies));
				log("\tCumulated Loading Time: " + timeFormat(ownLoadingTime));
				log("\tCumulated Fix Libraries Time: " + timeFormat(ownRepairLibrariesTime));
				log("\tCumulated Fix Stereotypes Time: " + timeFormat(ownRepairStereotypesTime));
				log("\tCumulated Post-processing Time: " + timeFormat(ownPostProcessingTime));
				log("\tTotal Fix Dependencies Time: " + timeFormat(ownExecutionTime));

				log("Total");
				log("\tCumulated Total time: " + timeFormat(ownExecutionTime + cumulatedTransformationTime));
				log("\tTotal time: " + timeFormat(ownExecutionTime + transformationsExecutionTime));

				log("Import Complete");
				log("");

				return result;
			}

		};

		importDependenciesJob.addJobChangeListener(new JobChangeAdapter() {
			@Override
			public void done(IJobChangeEvent event) {

				MultiStatus multiStatus = new MultiStatus(Activator.PLUGIN_ID, IStatus.OK, "", null);

				multiStatus.merge(event.getResult());

				for (ImportTransformation transformation : transformations) {
					multiStatus.merge(transformation.getStatus());
				}

				int severity = multiStatus.getSeverity();
				String message;

				switch (severity) {
				case IStatus.OK:
					message = "The selected models have been successfully imported";
					break;
				case IStatus.CANCEL:
					message = "Operation canceled";
					break;
				case IStatus.WARNING:
					message = "The selected models have been imported; some warnings have been reported";
					break;
				default:
					message = "Some errors occurred during model import";
					break;
				}


				handle(new MultiStatus(Activator.PLUGIN_ID, severity, multiStatus.getChildren(), message, null));
			}

			protected void handle(final IStatus status) {
				if (baseControl == null) {
					int severity = status.getSeverity();
					if (severity == IStatus.OK || severity == IStatus.CANCEL) {
						return;
					}

					StatusManager.getManager().handle(status, StatusManager.LOG);
					return;
				}

				Display display = baseControl.getDisplay();

				if (status.getSeverity() == IStatus.OK) {
					display.asyncExec(new Runnable() {

						@Override
						public void run() {
							MessageDialog.openInformation(baseControl.getShell(), "Import models", status.getMessage());
						}
					});

				} else if (status.getSeverity() == IStatus.CANCEL) {
					display.asyncExec(new Runnable() {

						@Override
						public void run() {
							MessageDialog.openInformation(baseControl.getShell(), "Import models", status.getMessage());
						}
					});
				} else {
					StatusManager.getManager().handle(status, StatusManager.BLOCK);
				}
			}
		});

		importDependenciesJob.setUser(true);
		importDependenciesJob.schedule();
	}

	protected void log(String message) {
		System.out.println(message);

		MessageConsole console = getConsole();
		MessageConsoleStream out = console.newMessageStream();
		out.println(message);
	}

	protected static final String CONSOLE_NAME = "Model Import Results"; // The name is both the ID and the Label

	protected MessageConsole getConsole() {
		ConsolePlugin plugin = ConsolePlugin.getDefault();
		IConsoleManager consoleManager = plugin.getConsoleManager();
		IConsole[] existing = consoleManager.getConsoles();
		for (int i = 0; i < existing.length; i++) {
			if (CONSOLE_NAME.equals(existing[i].getName())) {
				return (MessageConsole) existing[i];
			}
		}
		// no console found, so create a new one
		MessageConsole rsaConsole = new MessageConsole(CONSOLE_NAME, null);
		consoleManager.addConsoles(new IConsole[] { rsaConsole });
		return rsaConsole;
	}

	protected String timeFormat(Long nano) {
		if (nano == null) {
			return "?"; // FIXME: crash?
		}
		long seconds = nano / SECOND;
		if (seconds < 1) {
			long millis = nano / MILLIS;
			return String.format("%s ms", millis);
		}
		return String.format("%d:%02d:%02d", seconds / 3600, (seconds % 3600) / 60, (seconds % 60));
	}

	/**
	 * Schedules all the individual transformations, wait for completion, then
	 * call {@link #handleModelDependencies(List, IProgressMonitor)}
	 *
	 * @param monitor
	 * @param transformations
	 * @return
	 */
	protected IStatus importModels(IProgressMonitor monitor, List<ImportTransformation> transformations) {

		long begin = System.nanoTime();

		monitor.setTaskName("Waiting for import tasks to complete...");
		int numTasks = transformations.size() * 2; // For each transformation: wait for completion, then handle dependencies
		monitor.beginTask("Importing Models...", numTasks);

		List<Schedulable> tasks = new LinkedList<Schedulable>();

		for (ImportTransformation transformation : transformations) {
			tasks.add(new TransformationWrapper(transformation));
		}

		Scheduler scheduler = new Scheduler(config.getMaxThreads());
		scheduler.schedule(monitor, tasks);

		long end = System.nanoTime();
		transformationsExecutionTime = end - begin;

		if (monitor.isCanceled()) {
			return new Status(IStatus.CANCEL, Activator.PLUGIN_ID, "Operation canceled");
		}

		handleModelDependencies(transformations, monitor);

		return Status.OK_STATUS;
	}

	/**
	 * Convert all model dependencies (For "imported model -> emx library" to "imported model -> imported library")
	 * Also repairs profile and stereotype applications
	 *
	 * @param transformations
	 * @param monitor
	 */
	protected void handleModelDependencies(List<ImportTransformation> transformations, IProgressMonitor monitor) {

		long begin = System.nanoTime();

		long timeToIgnore = 0L;


		final Map<URI, URI> urisToReplace = new HashMap<URI, URI>();
		final Map<URI, URI> profileUrisToReplace = new HashMap<URI, URI>();

		for (ImportTransformation transformation : transformations) {
			urisToReplace.putAll(transformation.getURIMappings());
			profileUrisToReplace.putAll(transformation.getProfileURIMappings());
		}

		monitor.subTask("Analysing unresolved references...");
		long startResolveAll = System.nanoTime();
		analysisHelper.resolveAllMappings(urisToReplace, profileUrisToReplace);
		long endResolveAll = System.nanoTime();
		resolveAllDependencies = endResolveAll - startResolveAll;

		if (!config.getMappingParameters().getUriMappings().isEmpty() || !config.getMappingParameters().getProfileUriMappings().isEmpty()) {

			long beginDialog = System.nanoTime();
			MappingParameters parameters = confirmURIMappings(config.getMappingParameters());
			long endDialog = System.nanoTime();
			timeToIgnore = endDialog - beginDialog;

			config.setMappingParameters(parameters);

			// Include the user-defined URI mappings
			populateURIMap(parameters.getUriMappings(), urisToReplace);
			populateURIMap(parameters.getUriMappings(), profileUrisToReplace);
			populateURIMap(parameters.getProfileUriMappings(), profileUrisToReplace);
		}

		removeEmptyMappings(urisToReplace);

		List<Schedulable> tasks = new LinkedList<Schedulable>();
		for (final ImportTransformation transformation : transformations) {
			Job transformationJob = new Job("Importing dependencies for " + transformation.getModelName()) {
				@Override
				protected IStatus run(IProgressMonitor monitor) {
					long startFix = System.nanoTime();
					IStatus fixStatus = fixDependencies(transformation, monitor, urisToReplace, profileUrisToReplace);
					long endFix = System.nanoTime();
					synchronized (ImportTransformationLauncher.this) {
						totalTimeV2.put(transformation, endFix - startFix);
					}

					return fixStatus;
				}
			};

			tasks.add(new JobWrapper(transformationJob));
		}

		Scheduler scheduler = new Scheduler(config.getMaxThreads());
		scheduler.schedule(monitor, tasks);

		long end = System.nanoTime();

		ownExecutionTime = end - begin - timeToIgnore;
	}

	protected void removeEmptyMappings(Map<URI, URI> urisToReplace) {
		Iterator<Map.Entry<URI, URI>> iterator = urisToReplace.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<URI, URI> entry = iterator.next();
			if (entry.getKey().equals(entry.getValue())) {
				iterator.remove();
			}
		}
	}

	final protected Map<ImportTransformation, Long> loadingTimeV2 = new HashMap<ImportTransformation, Long>();

	final protected Map<ImportTransformation, Long> proxiesTime = new HashMap<ImportTransformation, Long>();

	final protected Map<ImportTransformation, Long> stereoTime = new HashMap<ImportTransformation, Long>();

	final protected Map<ImportTransformation, Long> postProcessTime = new HashMap<ImportTransformation, Long>();

	final protected Map<ImportTransformation, Long> totalTimeV2 = new HashMap<ImportTransformation, Long>();

	protected IStatus fixDependencies(ImportTransformation transformation, IProgressMonitor monitor, Map<URI, URI> urisToReplace, Map<URI, URI> profileUrisToReplace) {
		monitor.subTask("Importing dependencies for " + transformation.getModelName());
		final MigrationModelSet modelSet = new MigrationModelSet();

		final Collection<Resource> resourcesToRepair;
		try {
			URI targetURI = transformation.getTargetURI();
			if (targetURI == null) {
				// The transformation didn't complete properly
				monitor.worked(1);
				return Status.OK_STATUS;
			}

			long startLoading = System.nanoTime();
			modelSet.loadModels(transformation.getTargetURI());
			resourcesToRepair = resolveOwnResources(modelSet);
			long endLoading = System.nanoTime();
			synchronized (ImportTransformationLauncher.this) {
				ownLoadingTime += endLoading - startLoading;
				loadingTimeV2.put(transformation, endLoading - startLoading);
			}
		} catch (ModelMultiException e) {
			Activator.log.error(e);
			monitor.worked(1);
			return new Status(IStatus.ERROR, Activator.PLUGIN_ID, "An exception occurred when repairing library dependencies", e);
		}

		try {
			long startProxies = System.nanoTime();
			modelSet.freeze(); // The repairProxies operation will try to load referenced resources, which we want to avoid (For performances)
			try {
				repairProxies(modelSet, resourcesToRepair, urisToReplace, monitor); // Repairing proxies first will change the Applied Profiles. This helps repairing stereotypes
			} finally {
				modelSet.unfreeze();
			}
			long endProxies = System.nanoTime();
			synchronized (ImportTransformationLauncher.this) {
				ownRepairLibrariesTime += endProxies - startProxies;
				proxiesTime.put(transformation, endProxies - startProxies);
			}
		} catch (Exception ex) {
			Activator.log.error(ex);
			return new Status(IStatus.ERROR, Activator.PLUGIN_ID, "An exception occurred when repairing library dependencies", ex);
		}

		RepairStereotypes repairStereotypesAction = new RepairStereotypes(modelSet, resourcesToRepair, profileUrisToReplace);
		try {
			long startStereotypes = System.nanoTime();
			repairStereotypesAction.execute();
			long endStereotypes = System.nanoTime();
			synchronized (ImportTransformationLauncher.this) {
				ownRepairStereotypesTime += endStereotypes - startStereotypes;
				stereoTime.put(transformation, endStereotypes - startStereotypes);
			}
		} catch (Exception ex) {
			Activator.log.error(ex);
			return new Status(IStatus.ERROR, Activator.PLUGIN_ID, "An exception occurred when repairing profiles/stereotypes", ex);
		}

		if (config.isRemoveUnmappedProfilesAndStereotypes()) {
			try {
				for (final Resource resource : resourcesToRepair) {
					final List<EObject> eObjectsToDelete = new LinkedList<EObject>();
					TreeIterator<EObject> allContents = resource.getAllContents();
					while (allContents.hasNext()) {
						EObject next = allContents.next();
						if (next.eResource() != resource) {
							allContents.prune();
							continue;
						}

						// Delete instances of RSA Stereotypes
						URI eClassURI = EcoreUtil.getURI(next.eClass());
						if (StringHelper.equals("epx", eClassURI.fileExtension())) {
							eObjectsToDelete.add(next);
							allContents.prune();
							continue;
						}

						// Delete applications of RSA Profiles
						if (next instanceof ProfileApplication) {
							ProfileApplication profileApplication = (ProfileApplication) next;
							Profile appliedProfile = profileApplication.getAppliedProfile();
							if (appliedProfile != null) {
								URI profileURI = EcoreUtil.getURI(appliedProfile);
								if (StringHelper.equals("epx", profileURI.fileExtension())) {
									eObjectsToDelete.add(next);
									allContents.prune();
									continue;
								}
							}
						}
					}

					Runnable runnable = new Runnable() {
						@Override
						public void run() {
							for (EObject eObject : eObjectsToDelete) {
								EObject parentElement = eObject.eContainer();
								if (parentElement == null) {
									resource.getContents().remove(eObject);
								} else {
									EStructuralFeature containingFeature = eObject.eContainingFeature();
									EcoreUtil.remove(parentElement, containingFeature, eObject);
								}
							}
						}
					};

					runFastTransaction(modelSet.getTransactionalEditingDomain(), runnable);

				}
			} catch (Exception ex) {
				Activator.log.error(ex);
				return new Status(IStatus.ERROR, Activator.PLUGIN_ID, "An exception occurred when repairing profiles/stereotypes", ex);
			}
		}

		IStatus repairDisplayStatus = repairStereotypeDisplay(modelSet, resourcesToRepair);
		if (!repairDisplayStatus.isOK()) {
			return repairDisplayStatus;
		}

		IStatus result = Status.OK_STATUS;

		// Post-processing extensions
		long postProcessors = transformation.getExtensions().stream()
				.filter(PostProcessExtension.class::isInstance)
				.count();
		if (postProcessors > 0L) {
			final TransactionalEditingDomain domain = modelSet.getTransactionalEditingDomain();

			String statusMessage = String.format("Post-process %s", transformation.getModelName());
			MultiStatus postProcessStatus = new MultiStatus(Activator.PLUGIN_ID, IStatus.OK, statusMessage, null);

			long startPostProcessing = System.nanoTime();

			try {
				runFastTransaction(domain, () -> {
					// Re-initialize the transformation for the new resource set
					transformation.initResourceSet(transformation.getTargetURI(), modelSet);

					ExecutionContext context = transformation.createExecutionContext(
							SubMonitor.convert(monitor, 1),
							postProcessStatus);

					// Cannot increment on previous transformations because they were in a different resource set
					context.getSessionData().setValue(TraceHelper.TRACE_HISTORY, Trace.createEmptyTrace());

					postProcessStatus.merge(transformation.importExtensions(context, monitor, ExtensionFunction::postProcess));
				});
			} catch (RollbackException ex) {
				Activator.log.error(ex);
			} catch (InterruptedException ex) {
				Activator.log.error(ex);
			} finally {
				long endPostProcessing = System.nanoTime();
				synchronized (ImportTransformationLauncher.this) {
					ownPostProcessingTime += endPostProcessing - startPostProcessing;
					postProcessTime.put(transformation, endPostProcessing - startPostProcessing);
				}
			}

			if (postProcessStatus.getSeverity() > IStatus.WARNING) {
				return postProcessStatus;
			}

			result = postProcessStatus;
		}

		try {

			for (Resource resource : resourcesToRepair) {
				ResourceAccessHelper.INSTANCE.saveResource(resource, null);
			}

			monitor.worked(1);

			TransactionalEditingDomain domain = modelSet.getTransactionalEditingDomain();
			runFastTransaction(domain, () -> EMFHelper.unload(modelSet));

			domain.dispose();

		} catch (IOException ex) {
			Activator.log.error(ex);
		} catch (RollbackException ex) {
			Activator.log.error(ex);
		} catch (InterruptedException ex) {
			Activator.log.error(ex);
		}

		return result;
	}

	protected IStatus repairStereotypeDisplay(ModelSet modelSet, Collection<Resource> resourcesToRepair) {

		Map<View, List<DecorationNode>> nodesToCreate = new HashMap<View, List<DecorationNode>>();

		final TransactionalEditingDomain domain = modelSet.getTransactionalEditingDomain();

		InternalTransactionalEditingDomain internalDomain = (InternalTransactionalEditingDomain) domain;

		Map<String, Object> options = new HashMap<String, Object>();
		options.put(Transaction.OPTION_NO_UNDO, true);
		options.put(Transaction.OPTION_NO_VALIDATION, true);
		options.put(Transaction.OPTION_NO_TRIGGERS, true);
		options.put(Transaction.OPTION_UNPROTECTED, true);

		List<StringValueStyle> stylesToDelete = new LinkedList<StringValueStyle>();

		try {

			// We're in a batch environment, with no undo/redo support. Run a vanilla transaction to improve performances
			Transaction fastTransaction = internalDomain.startTransaction(false, options);

			for (Resource resource : resourcesToRepair) {
				if ("notation".equals(resource.getURI().fileExtension())) {
					TreeIterator<EObject> contents = resource.getAllContents();
					while (contents.hasNext()) {
						EObject next = contents.next();

						if (next instanceof StringValueStyle) {
							StringValueStyle style = (StringValueStyle) next;
							if ("stereotypeDisplayBackup".equals(style.getName())) {
								stylesToDelete.add(style); // Cannot use iterator.remove(), it is not supported. Store and delete later
								continue;
							}
						}

						if (!(next instanceof View)) {
							contents.prune();
							continue;
						}

						View content = (View) next;
						StringValueStyle stereotypeDisplay = (StringValueStyle) content.getNamedStyle(NotationPackage.eINSTANCE.getStringValueStyle(), "stereotypeDisplayBackup");
						if (stereotypeDisplay == null) {
							continue;
						}

						final String value = stereotypeDisplay.getStringValue();
						if (value == null) {
							continue;
						}

						switch (value) {
						case "None": // Other values not handled yet //$NON-NLS-1$
							EObject semanticElement = content.getElement();
							if (!(semanticElement instanceof Element)) {
								continue;
							}

							Element umlElement = (Element) semanticElement;

							List<Stereotype> stereotypes = umlElement.getAppliedStereotypes();

							List<DecorationNode> childNodesToCreate = new LinkedList<DecorationNode>();
							nodesToCreate.put(content, childNodesToCreate);

							for (Stereotype appliedStereotype : stereotypes) {
								DecorationNode stereotypeLabel = NotationFactory.eINSTANCE.createDecorationNode();
								stereotypeLabel.setType("StereotypeLabel");
								stereotypeLabel.setVisible(false);

								StringValueStyle stereotypeStyle = (StringValueStyle) stereotypeLabel.createStyle(NotationPackage.eINSTANCE.getStringValueStyle());
								stereotypeStyle.setName("stereotype");
								stereotypeStyle.setStringValue(appliedStereotype.getQualifiedName());
								stereotypeLabel.setElement(appliedStereotype);

								stereotypeLabel.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());

								childNodesToCreate.add(stereotypeLabel);
							}
							break;
						default:
							// Not handled
						}
					}
				}
			}

			for (Entry<View, List<DecorationNode>> toCreate : nodesToCreate.entrySet()) {
				View parent = toCreate.getKey();
				for (DecorationNode decorationNode : toCreate.getValue()) {
					parent.getPersistedChildren().add(decorationNode);
				}
			}

			// Simple delete for performances (These styles don't have any incoming reference other than the containment)
			for (StringValueStyle styleToDelete : stylesToDelete) {
				EObject container = styleToDelete.eContainer();
				EReference feature = styleToDelete.eContainmentFeature();

				if (container != null && feature != null) {

					if (feature.isMany()) {
						List<?> values = (List<?>) container.eGet(feature);
						values.remove(styleToDelete);
					} else {
						container.eUnset(feature);
					}
				}
			}

			fastTransaction.commit();
		} catch (Exception ex) {
			Activator.log.error(ex);
			return new Status(IStatus.ERROR, Activator.PLUGIN_ID, "An error occurred while trying to migrate Stereotype Display", ex);
		}

		return Status.OK_STATUS;
	}

	protected Collection<Resource> resolveOwnResources(ModelSet modelSet) {
		UmlModel umlModel = (UmlModel) modelSet.getModel(UmlModel.MODEL_ID);
		if (umlModel == null) {
			return Collections.emptySet();
		}

		// Iterate on the main resource's contents (Including fragments).
		// The ModelSet will take care of loading any associated resource (notation, di)

		Resource mainResource = umlModel.getResource();
		if (mainResource == null) {
			return Collections.emptySet();
		}

		Iterator<EObject> contents = mainResource.getAllContents();
		while (contents.hasNext()) {
			contents.next();
		}

		Set<Resource> resourcesToRepair = new HashSet<Resource>();
		for (Resource resource : modelSet.getResources()) {
			if (isMainModelResource(modelSet, resource)) {
				resourcesToRepair.add(resource);
			}
		}
		return resourcesToRepair;
	}

	/**
	 * A resource belongs to the main model if it is one of the 4-files model (Di, Notation, Uml, Sash), or if it is
	 * a resource associated to a Sub-model of the main model (i.e. child of the main UML resource,
	 * or resource associated to a child of the main UML resource)
	 *
	 * @param modelSet
	 * @param resource
	 * @return
	 */
	protected boolean isMainModelResource(ModelSet modelSet, Resource resource) {
		IModel model = modelSet.getModelFor(resource);
		if (model instanceof IEMFModel) {
			IEMFModel logicalModel = (IEMFModel) model;
			if (logicalModel.getResource() == resource || logicalModel.isControlled(resource)) {
				return true;
			}
		}

		return false;
	}

	protected void repairProxies(final ModelSet modelSet, final Collection<Resource> resourcesToRepair, final Map<URI, URI> urisToReplace, IProgressMonitor monitor) throws InterruptedException, RollbackException {
		final TransactionalEditingDomain domain = modelSet.getTransactionalEditingDomain();
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				DependencyManagementHelper.batchUpdateDependencies(urisToReplace, resourcesToRepair, domain);
			}
		};

		runFastTransaction(domain, runnable);
	}

	protected static final void runFastTransaction(TransactionalEditingDomain domain, Runnable runnable) throws InterruptedException, RollbackException {
		InternalTransactionalEditingDomain internalDomain = (InternalTransactionalEditingDomain) domain;

		Map<String, Object> options = new HashMap<String, Object>();
		options.put(Transaction.OPTION_NO_UNDO, true);
		options.put(Transaction.OPTION_NO_VALIDATION, true);
		options.put(Transaction.OPTION_NO_TRIGGERS, true);
		options.put(Transaction.OPTION_UNPROTECTED, true);

		// We're in a batch environment, with no undo/redo support. Run a vanilla transaction to improve performances
		Transaction fastTransaction = internalDomain.startTransaction(false, options);
		try {
			runnable.run();
		} finally {
			fastTransaction.commit();
		}
	}

	/**
	 * Convert and add all the URIMappings into the URI Map
	 *
	 * @param mappings
	 * @param uriMap
	 */
	protected static void populateURIMap(List<URIMapping> mappings, Map<URI, URI> uriMap) {
		for (URIMapping mapping : mappings) {
			if (mapping == null) {
				continue;
			}
			String source = mapping.getSourceURI();
			String target = mapping.getTargetURI();

			if (source != null && target != null && !source.trim().isEmpty() && !target.trim().isEmpty()) {

				URI sourceURI = URI.createURI(mapping.getSourceURI());
				URI targetURI = URI.createURI(mapping.getTargetURI());

				if (uriMap.containsKey(sourceURI)) {
					continue;
				}

				uriMap.put(sourceURI, targetURI);
			}
		}
	}

	protected MappingParameters confirmURIMappings(final MappingParameters mappingParameters) {
		List<URIMapping> flatMappings = analysisHelper.flattenURIMappings(mappingParameters);
		analysisHelper.propagateURIMappings(flatMappings, mappingParameters);

		if (config.isAlwaysAcceptSuggestedMappings()) {
			return mappingParameters;
		}

		final AtomicReference<MappingParameters> newParameters = new AtomicReference<MappingParameters>(mappingParameters);

		if (baseControl != null && !baseControl.isDisposed()) {
			baseControl.getDisplay().syncExec(new Runnable() {
				@Override
				public void run() {
					newParameters.set(openMappingsDialog(mappingParameters));
				}
			});
		}

		return newParameters.get();
	}

	protected MappingParameters openMappingsDialog(final MappingParameters mappingParameters) {
		final Shell shell = baseControl.getShell();

		SelectionDialog dialog = new URIMappingDialog(shell, mappingParameters, analysisHelper);

		dialog.open();
		return (MappingParameters) dialog.getResult()[0];
	}

	/** Mainly for test purpose */
	public void waitForCompletion() throws Exception {
		importDependenciesJob.join();
	}

	/** Mainly for test purpose */
	public IStatus getResult() {
		return importDependenciesJob.getResult();
	}
}
