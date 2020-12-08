/*****************************************************************************
 * Copyright (c) 2020 Christian W. Damus, CEA LIST, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.toolsmiths.validation.common.checkers;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.infra.emf.utils.ResourceUtils;
import org.eclipse.papyrus.toolsmiths.validation.common.Activator;

/**
 * <p>
 * A variant of the {@link IPluginChecker} that reports problems to a diagnostic chain instead
 * of directly creating problem markers. This allows a client such as a plug-in builder to
 * optimize the creation of markers, avoiding redundant reporting of the same issue in multiple
 * models in the same plug-in. For example, missing bundle dependency declarations may be
 * detected in multiple models that all cross-reference to models in the same bundle, but that
 * missing dependency only needs to be reported once.
 * </p>
 * <p>
 * Diagnostics reported by a checker may add some contextual information about the problem to
 * assist in the analysis and creation of problem markers, including:
 * </p>
 * <ul>
 * <li>the {@link IProject} that is being validated</li>
 * <li>the {@link IFile} that is being validated</li>
 * <li>the {@link MarkerType} to create</li>
 * <li>any number of {@link MarkerAttribute}s to set on the marker, with the exception of message and severity that are determined by the corresponding diagnostic attributes</li>
 * </ul>
 * <p>
 * Any of these parameters that are missing from a diagnostic may be inferred by the client as necessary.
 * </p>
 */
public interface IPluginChecker2 {

	/**
	 * Check the plug-in, reporting problems to the given {@code diagnostics}.
	 *
	 * @param diagnostics
	 *            a collector of plug-in problem diagnostics
	 * @param monitor
	 *            for reporting checking progress
	 */
	void check(DiagnosticChain diagnostics, IProgressMonitor monitor);

	/**
	 * Get or infer the project of a {@code diagnostic}.
	 */
	static Optional<IProject> getProject(Diagnostic diagnostic) {
		return diagnostic.getData().stream().filter(IProject.class::isInstance)
				.map(IProject.class::cast)
				.findFirst()
				.or(() -> getFile(diagnostic).map(IResource::getProject));
	}

	/**
	 * Get or infer the file of a {@code diagnostic}.
	 */
	static Optional<IFile> getFile(Diagnostic diagnostic) {
		return diagnostic.getData().stream().filter(IFile.class::isInstance)
				.map(IFile.class::cast)
				.findFirst()
				.or(() -> getResource(diagnostic).map(ResourceUtils::getFile));
	}

	/**
	 * Get or infer the EMF resource of a {@code diagnostic}.
	 */
	static Optional<Resource> getResource(Diagnostic diagnostic) {
		return diagnostic.getData().stream().filter(EObject.class::isInstance)
				.map(EObject.class::cast)
				.map(EObject::eResource)
				.findFirst();
	}

	/**
	 * Get the marker type, if any, specified in the {@linkplain Diagnostic#getData() data list} of a {@code diagnostic}.
	 */
	static Optional<String> getMarkerType(Diagnostic diagnostic) {
		List<?> data = diagnostic.getData();
		if (data == null) {
			return Optional.empty();
		}
		return data.stream().filter(MarkerType.class::isInstance)
				.map(MarkerType.class::cast)
				.map(MarkerType::getType)
				.findFirst();
	}

	/**
	 * Process any marker-attribute tokens in the {@linkplain Diagnostic#getData() data list} of a {@link Diagnostic} to
	 * set the attributes of the given {@code marker}.
	 */
	static void setAttributes(Diagnostic diagnostic, IMarker marker) {
		diagnostic.getData().stream().filter(MarkerAttribute.class::isInstance)
				.map(MarkerAttribute.class::cast)
				.forEach(attribute -> attribute.applyTo(marker));
	}

	/**
	 * Create a token to put in the {@linkplain Diagnostic#getData() data list} of a {@link Diagnostic} to indicate the marker type to
	 * create on the resource.
	 */
	static MarkerType markerType(String type) {
		return new MarkerType(type);
	}

	/**
	 * Create a token to put in the {@linkplain Diagnostic#getData() data list} of a {@link Diagnostic} to indicate the line number to
	 * set in the resource marker.
	 */
	static MarkerAttribute lineNumber(int line) {
		return new MarkerAttribute(IMarker.LINE_NUMBER, line);
	}

	/**
	 * Create a token to put in the {@linkplain Diagnostic#getData() data list} of a {@link Diagnostic} to indicate the start offset to
	 * set in the resource marker.
	 */
	static MarkerAttribute charStart(int index) {
		return new MarkerAttribute(IMarker.CHAR_START, index);
	}

	/**
	 * Create a token to put in the {@linkplain Diagnostic#getData() data list} of a {@link Diagnostic} to indicate the end offset to
	 * set in the resource marker.
	 */
	static MarkerAttribute charEnd(int index) {
		return new MarkerAttribute(IMarker.CHAR_END, index);
	}

	/**
	 * Create a token to put in the {@linkplain Diagnostic#getData() data list} of a {@link Diagnostic} to indicate the
	 * descriptive location to set in the resource marker.
	 */
	static MarkerAttribute location(String location) {
		return new MarkerAttribute(IMarker.LOCATION, location);
	}

	//
	// Nested types
	//

	/**
	 * <p>
	 * A factory for creation of plug-in checkers. Any given factory may be requested to create
	 * a checker for:
	 * </p>
	 * <ul>
	 * <li>the project as a whole, in which case only the {@link IFile} and {@link Resource} arguments are both {@code null}</li>
	 * <li>a file that is not an EMF resource, in which case only the {@link Resource} argument is {@code null}</li>
	 * <li>an EMF resource, in which case all three arguments are supplied</li>
	 * </ul>
	 * <p>
	 * A factory is expected to handle all of these cases, returning {@code null} for cases that are not applicable.
	 * There are convenience wrappers to adapt specific cases to the general protocol.
	 * </p>
	 */
	@FunctionalInterface
	interface Factory {

		/**
		 * Create a plug-in checker, or {@code null} if none is applicable. For example, a factory may
		 * provide a checker only for the project as a whole (when the model file is {@code null}) and
		 * so return {@code null} otherwise. Or only when there <em>is</em> a model file and return
		 * {@code null} otherwise.
		 *
		 * @param project
		 *            the project being checked. Never {@code null}
		 * @param modelFile
		 *            the model file being checked, or {@code null} to create a checker for the {@code project} as a whole
		 * @param resource
		 *            the resource being checked, or {@code null} if either the {@code modelFile} is {@code null} or
		 *            the {@code modelFile} is not an EMF resource
		 *
		 * @return the checker, if needed
		 */
		IPluginChecker2 createChecker(IProject project, IFile modelFile, Resource resource);

		/**
		 * Obtain a new factory that tries me and, if I don't provide a result, tries the other {@code factory}.
		 *
		 * @param factory
		 *            an alternative factory to myself. This one also is permitted to return {@code null}
		 * @return the "or" factory
		 */
		default Factory or(Factory factory) {
			return (project, modelFile, resource) -> {
				IPluginChecker2 result = this.createChecker(project, modelFile, resource);
				if (result == null) {
					result = factory.createChecker(project, modelFile, resource);
				}
				return result;
			};
		}

		/**
		 * Wrapper for a factory that only handles the project-as-a-whole case.
		 *
		 * @param factory
		 *            a project checker factory
		 * @return a generic checker factory that returns {@code null} for all file-specific cases
		 */
		static Factory forProject(Function<? super IProject, ? extends IPluginChecker2> factory) {
			return (project, modelFile, resource) -> (modelFile == null || resource == null) ? factory.apply(project) : null;
		}

		/**
		 * Wrapper for a factory that only handles the EMF resource case.
		 *
		 * @param factory
		 *            an EMF resource checker factory
		 * @return a generic checker factory that returns {@code null} for all non-EMF-resource cases
		 */
		static Factory forEMFResource(Factory factory) {
			return (project, modelFile, resource) -> (modelFile == null || resource == null) ? null : factory.createChecker(project, modelFile, resource);
		}

	}

	/**
	 * A token to put in the {@linkplain Diagnostic#getData() data list} of a {@link Diagnostic} to indicate the marker type to
	 * create on the resource.
	 */
	static final class MarkerType {
		private final String type;

		/**
		 * Create a new marker {code type} token.
		 *
		 * @param type
		 *            the marker type to encapsulate
		 */
		public MarkerType(String type) {
			this.type = type;
		}

		public String getType() {
			return type;
		}

		@Override
		public int hashCode() {
			return Objects.hash(type);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (!(obj instanceof MarkerType)) {
				return false;
			}
			MarkerType other = (MarkerType) obj;
			return Objects.equals(type, other.type);
		}

		@Override
		public String toString() {
			return String.format("@type=%s", type);
		}

	}

	/**
	 * A token to put in the {@linkplain Diagnostic#getData() data list} of a {@link Diagnostic} to indicate an attribute
	 * to set on the resource marker.
	 */
	static final class MarkerAttribute {
		private final String name;
		private final Object value;

		/**
		 * Create a new boolean-valued marker attribute token.
		 *
		 * @param name
		 *            the marker attribute name
		 * @param value
		 *            the boolean value of the attribute
		 */
		public MarkerAttribute(String name, boolean value) {
			this.name = name;
			this.value = value;
		}

		/**
		 * Create a new integer-valued marker attribute token.
		 *
		 * @param name
		 *            the marker attribute name
		 * @param value
		 *            the integer value of the attribute
		 */
		public MarkerAttribute(String name, int value) {
			this.name = name;
			this.value = value;
		}

		/**
		 * Create a new marker attribute token.
		 *
		 * @param name
		 *            the marker attribute name
		 * @param value
		 *            the generic value of the attribute
		 */
		public MarkerAttribute(String name, Object value) {
			this.name = name;
			this.value = value;
		}

		public String getName() {
			return name;
		}

		public Object getValue() {
			return value;
		}

		/**
		 * Set the attribute that I specify on the given {@code marker}.
		 *
		 * @param marker
		 *            a marker
		 */
		public void applyTo(IMarker marker) {
			try {
				if (value instanceof Boolean) {
					marker.setAttribute(name, (boolean) value);
				} else if (value instanceof Integer) {
					marker.setAttribute(name, (int) value);
				} else {
					marker.setAttribute(name, value);
				}
			} catch (CoreException e) {
				Activator.log.error("Could not set marker attribute.", e); //$NON-NLS-1$
			}
		}

		@Override
		public int hashCode() {
			return Objects.hash(name, value);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (!(obj instanceof MarkerAttribute)) {
				return false;
			}
			MarkerAttribute other = (MarkerAttribute) obj;
			return Objects.equals(name, other.name) && Objects.equals(value, other.value);
		}

		@Override
		public String toString() {
			return String.format("%s=%s", name, value);
		}

	}

}
