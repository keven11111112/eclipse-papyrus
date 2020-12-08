/*****************************************************************************
 * Copyright (c) 2019, 2020 CEA LIST, EclipseSource, Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Nicolas FAUVERGUE (CEA LIST) nicolas.fauvergue@cea.fr - Initial API and implementation
 *   Remi Schnekenburger (EclipseSource) - Bug 568495
 *   Christian W. Damus - bug 569357
 *
 *****************************************************************************/
package org.eclipse.papyrus.toolsmiths.validation.common.checkers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.ToIntFunction;

import org.eclipse.core.filebuffers.FileBuffers;
import org.eclipse.core.filebuffers.ITextFileBuffer;
import org.eclipse.core.filebuffers.ITextFileBufferManager;
import org.eclipse.core.filebuffers.LocationKind;
import org.eclipse.core.internal.runtime.MetaDataKeeper;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.osgi.service.resolver.BundleSpecification;
import org.eclipse.papyrus.toolsmiths.validation.common.Activator;
import org.eclipse.papyrus.toolsmiths.validation.common.utils.ProjectManagementService;
import org.eclipse.pde.internal.core.ibundle.IManifestHeader;
import org.eclipse.pde.internal.core.text.bundle.BundleModel;
import org.eclipse.pde.internal.core.text.bundle.ManifestHeader;
import org.osgi.framework.Constants;

/**
 * A checker that verifies specification of the dependencies for bundles that provide the resources
 * referenced by cross-document references from a model resource.
 */
@SuppressWarnings("restriction")
public class ModelDependenciesChecker extends AbstractPluginChecker {

	/**
	 * The EMF model resource.
	 */
	private final Resource resource;

	private final Set<String> additionalRequirements = new HashSet<>();

	private ToIntFunction<? super String> severityFunction = __ -> Diagnostic.ERROR;

	private final List<Function<? super Resource, ? extends Collection<String>>> additionalDependencyFunctions = new ArrayList<>();

	/**
	 * Initializes me to report all missing bundle dependencies as errors.
	 *
	 * @param project
	 *            The current project resource.
	 * @param modelFile
	 *            The model file, or {@code null} to check only the project's additional requirements.
	 * @param resource
	 *            The EMF model resource, or {@code null} to check only the project's additional requirements.
	 *
	 * @see #addRequirement(String)
	 */
	public ModelDependenciesChecker(final IProject project, final IFile modelFile, final Resource resource) {
		super(project, modelFile);

		this.resource = resource;
	}

	/**
	 * Constructor.
	 *
	 * @param project
	 *            The current project resource.
	 * @param modelFile
	 *            The model file, or {@code null} to check only the project's additional requirements.
	 * @param resource
	 *            The EMF model resource, or {@code null} to check only the project's additional requirements.
	 * @param markerType
	 *            The marker type.
	 *
	 * @see #addRequirement(String)
	 */
	public ModelDependenciesChecker(final IProject project, final IFile modelFile, final Resource resource, String markerType) {
		super(project, modelFile, markerType);

		this.resource = resource;
	}

	/**
	 * Set a severity mapping function.
	 *
	 * @param severityFunction
	 *            an optional function that maps bundle symbolic names (being missing dependencies) to {@link Diagnostic} severities.
	 *            If omitted, all missing dependencies are reported as errors
	 * @return myself, for convenience of call chaining
	 */
	public ModelDependenciesChecker withSeverityFunction(ToIntFunction<? super String> severityFunction) {
		this.severityFunction = severityFunction != null ? severityFunction : __ -> Diagnostic.ERROR;
		return this;
	}

	/**
	 * Add a required bundle dependency that is not (necessarily) implied by the references in the model.
	 *
	 * @param bundleSymbolicName
	 *            a bundle that must be declared as a dependency
	 * @return myself, for convenience of call chaining
	 */
	public ModelDependenciesChecker addRequirement(String bundleSymbolicName) {
		additionalRequirements.add(bundleSymbolicName);
		return this;
	}

	/**
	 * Add required bundle dependencies that are not (necessarily) implied by the references in the model.
	 *
	 * @param bundleSymbolicNames
	 *            bundle that must be declared as dependencies
	 * @return myself, for convenience of call chaining
	 */
	public ModelDependenciesChecker addRequirements(Collection<String> bundleSymbolicNames) {
		additionalRequirements.addAll(bundleSymbolicNames);
		return this;
	}

	/**
	 * Add a function that computes additional requirements from the model that are encoded in some other
	 * ways than cross-document references to resources in other bundles. Those dependencies are covered
	 * automatically by this checker.
	 *
	 * @param requirementsFunction
	 *            a function that maps the resource being validated to bundle symbolic names that are required dependencies
	 *            implied by the model in ways other than cross-document references
	 * @return myself, for convenience of call chaining
	 */
	public ModelDependenciesChecker withAdditionalRequirements(Function<? super Resource, Collection<String>> requirementsFunction) {
		this.additionalDependencyFunctions.add(requirementsFunction);
		return this;
	}

	/**
	 * This allows to check that the plug-in has the correct dependencies depending to the external cross-deocument references.
	 */
	@Override
	public void check(DiagnosticChain diagnostics, final IProgressMonitor monitor) {
		String resourceName = getModelFile() == null ? getProject().getName() : getModelFile().getName();

		SubMonitor subMonitor = SubMonitor.convert(monitor, "Validate dependencies for '" + resourceName + "'.", 3);

		// Get the external reference paths
		final Collection<URI> externalReferencesPaths = getExternalReferencesPaths(diagnostics, getProject(), getModelFile(), resource);
		subMonitor.worked(1);

		// Calculate plug-ins names from URI. Initial set is the "additional requirements" from the client
		final Collection<String> requiredPlugins = new HashSet<>(additionalRequirements);
		externalReferencesPaths.stream().map(this::getPluginNameFromURI).forEach(requiredPlugins::add);
		additionalDependencyFunctions.stream().map(func -> func.apply(resource)).forEach(requiredPlugins::addAll);

		// For each external reference, get its plug-in name and search its dependency in the plug-in
		final List<BundleSpecification> dependencies = ProjectManagementService.getPluginDependencies(getProject());
		if (null != dependencies && !dependencies.isEmpty()) {
			dependencies.stream().map(BundleSpecification::getName).forEach(requiredPlugins::remove);
		}
		subMonitor.worked(1);

		List<ManifestError> errors = new ArrayList<>();

		// If requiredPlugins is not empty, that means, the dependency is not available in the model plug-in.
		// So, create the problem markers
		if (!requiredPlugins.isEmpty()) {
			requiredPlugins.stream().forEach(requiredPlugin -> {
				int severity = severityFunction.applyAsInt(requiredPlugin);
				errors.add(new ManifestError(getMarkerType(), "The plug-in '" + requiredPlugin + "' must be declared as required plug-in (for '" + resourceName + "').", severity, Constants.REQUIRE_BUNDLE));
			});
			reportErrors(diagnostics, errors);
		}
		subMonitor.worked(1);

		SubMonitor.done(monitor);
	}

	/**
	 * generate markers for the specified list of errors.
	 *
	 * @param errors
	 *            the list of errors for which markers will be created.
	 */
	private void reportErrors(DiagnosticChain diagnostics, List<ManifestError> errors) {
		if (!errors.isEmpty()) {
			final IFile manifestFile = ProjectManagementService.getManifestFile(getProject());
			BundleModel textBundleModel = prepareTextBundleModel(manifestFile);
			errors.stream().forEach(error -> {
				reportBundleError(diagnostics, manifestFile, textBundleModel, error.type, error.message, error.severity, error.header);
			});
		}
	}

	/**
	 * Create a Marker on the specified file, with the given parameters.
	 *
	 * @param manifestFile
	 *            the file on which the marker should be created.
	 * @param textBundleModel
	 *            the textual model representation of the Manifest.MF file
	 * @param type
	 *            the type of the marker to create
	 * @param message
	 *            the message of the marker to create
	 * @param severity
	 *            the severity of the marker to create
	 * @param header
	 *            the header entry of the manifest file on which marker is created.
	 */
	private void reportBundleError(DiagnosticChain diagnostics, IFile manifestFile, BundleModel textBundleModel, String type, String message, int severity, String header) {
		Diagnostic diagnostic;

		if (textBundleModel != null) {
			diagnostic = createDiagnostic(manifestFile, severity, 0, message,
					IPluginChecker2.markerType(type),
					IPluginChecker2.lineNumber(getLineNumber(textBundleModel.getBundle().getManifestHeader(header))));

		} else {
			diagnostic = createDiagnostic(manifestFile, severity, 0, message);
		}

		diagnostics.add(diagnostic);
	}

	/**
	 * Read and parse the manifest file to create the abstract representation.
	 *
	 * @param manifestFile
	 *            the file to parse
	 * @return the model of the manifest file.
	 */
	private BundleModel prepareTextBundleModel(IFile manifestFile) {
		try {
			IDocument doc = createDocument(manifestFile);
			if (doc == null) {
				return null;
			}
			BundleModel bm = new BundleModel(doc, true);
			bm.load();
			if (!bm.isLoaded()) {
				return null;
			}
			return bm;
		} catch (CoreException e) {
			Activator.log.error(e);
			return null;
		}
	}

	/**
	 * Read the manifest file and provide a {@link IDocument}.
	 *
	 * @param file
	 *            the file to parse
	 * @return the document of the textual file.
	 */
	protected IDocument createDocument(IFile file) {
		if (!file.exists()) {
			return null;
		}
		ITextFileBufferManager manager = FileBuffers.getTextFileBufferManager();
		if (manager == null) {
			return null;
		}
		IDocument document = null;
		try {
			manager.connect(file.getFullPath(), LocationKind.NORMALIZE, null);
			ITextFileBuffer textBuf = manager.getTextFileBuffer(file.getFullPath(), LocationKind.NORMALIZE);
			document = textBuf.getDocument();
		} catch (CoreException e) {
			Activator.log.error(e);
		} finally {
			try {
				manager.disconnect(file.getFullPath(), LocationKind.NORMALIZE, null);
			} catch (CoreException e) {
				Activator.log.error(e);
			}
		}
		return document;
	}

	/**
	 * This allows to get the external references paths.
	 *
	 * @param project
	 *            The current project.
	 * @param modelFile
	 *            The model file, or {@code null} to check only the project's additional requirements.
	 * @param resource
	 *            The resource to get external references paths, or {@code null} to check only the project's additional requirements.
	 * @return The external references paths.
	 */
	private Collection<URI> getExternalReferencesPaths(final DiagnosticChain diagnostics, final IProject project, final IFile modelFile, final Resource resource) {
		final Collection<URI> externalReferencesPaths = new HashSet<>();
		if (modelFile == null || resource == null) {
			return externalReferencesPaths;
		}

		String metadataPath = MetaDataKeeper.getMetaArea().getMetadataLocation().toString();

		// First step, resolve all references
		EcoreUtil.resolveAll(resource);

		for (final Resource currentResource : resource.getResourceSet().getResources()) {
			// Check that the resource is not the current one or is not available in the same plugin
			if (isExternalReferenceToManage(project, currentResource)) {
				final URI resourceURI = currentResource.getURI();

				// React differently if this is a pathmap
				if (!resourceURI.isPlatform()) {
					// Try to resolve the pathmap
					final URI correspondingURI = resource.getResourceSet().getURIConverter().normalize(resourceURI);
					if (resourceURI.equals(correspondingURI)) {
						// If this case, the pathmap cannot be resolved, so create a marker
						diagnostics.add(createDiagnostic(project, modelFile, Diagnostic.ERROR, 1,
								"The URI '" + resourceURI.toString() + "' cannot be resolved.")); //$NON-NLS-1$ //$NON-NLS-2$
					} else {
						externalReferencesPaths.add(correspondingURI);
					}
				} else if (resourceURI.isFile() && resourceURI.toFileString().startsWith(metadataPath)) {
					// avoid adding dependencies towards local metadata (case of internationalization)
				} else {
					externalReferencesPaths.add(resourceURI);
				}
			}
		}

		return externalReferencesPaths;

	}

	/**
	 * This allows to determinate if the external reference must be managed or not.
	 * For example, we don't have to manage references of files from the same plug-in.
	 * Moreover, some pathmaps don't need to be include in the dependencies.
	 *
	 * @param project
	 *            The current project.
	 * @param resource
	 *            The resource to check.
	 * @return <code>true</code> if we have to manage reference, <code>false</code> otherwise.
	 */
	private boolean isExternalReferenceToManage(final IProject project, final Resource resource) {
		final URI uri = resource.getURI();

		// We don't have to manage references of files from the same plug-in
		return !(uri.isPlatformPlugin() || uri.isPlatformResource())
				|| uri.segmentCount() < 2 || !uri.segment(1).equals(project.getName());
	}

	/**
	 * This allows to get the plug-in name from the URI.
	 *
	 * @param uri
	 *            The initial URI.
	 * @return The plug-in name from URI or <code>null</code> if any problem occurred.
	 */
	private String getPluginNameFromURI(final URI uri) {
		String pluginName = null;

		// Take we correct segment (without authority)
		final int takenSegment = uri.hasAuthority() ? 0 : 1;
		if (uri.segmentCount() > takenSegment) {
			pluginName = uri.segment(takenSegment);
		}

		return pluginName;
	}

	/**
	 * Retrieve the line number for the specified header in the Manifest file.
	 *
	 * @param imh
	 *            the manifest header to be retrieved.
	 * @return the line number or <code>0</code> if none was found.
	 */
	private int getLineNumber(IManifestHeader imh) {
		if (!(imh instanceof ManifestHeader)) {
			return 0;
		}
		ManifestHeader mh = (ManifestHeader) imh;
		org.eclipse.jface.text.IDocument doc = ((BundleModel) mh.getModel()).getDocument();
		try {
			int bundleEntryLineNumber = doc.getLineOfOffset(mh.getOffset()) + 1;
			// we are interested in the build entry name
			// (getLineOfOffset is 0-indexed, need 1-indexed)
			return bundleEntryLineNumber;
		} catch (BadLocationException e) {
			Activator.log.error(e);
		}
		return 0;
	}

	/**
	 * A severity function that maps the given missing dependencies to warnings and any others to errors.
	 *
	 * @param bundleSymbolicNames
	 *            bundle dependencies that if missing are warning conditions, not errors
	 * @return the severity function
	 */
	public static ToIntFunction<String> warningsFor(String... bundleSymbolicNames) {
		Set<String> warningExceptions = Set.of(bundleSymbolicNames);
		return bundleName -> warningExceptions.contains(bundleName) ? Diagnostic.WARNING : Diagnostic.ERROR;
	}

	/**
	 * Representation of an error on the Manifest file.
	 */
	private static class ManifestError {

		private final String type;
		private final String message;
		private final int severity;
		private final String header;

		public ManifestError(String type, String message, int severity, String header) {
			this.type = type;
			this.message = message;
			this.severity = severity;
			this.header = header;
		}
	}
}
