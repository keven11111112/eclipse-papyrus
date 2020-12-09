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

package org.eclipse.papyrus.toolsmiths.validation.elementtypes.tests;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.junit.utils.JUnitUtils;
import org.eclipse.papyrus.junit.utils.rules.ProjectFixture;
import org.eclipse.papyrus.toolsmiths.plugin.builder.preferences.PluginBuilderPreferencesConstants;
import org.eclipse.papyrus.toolsmiths.validation.elementtypes.constants.ElementTypesPluginValidationConstants;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * A project fixture that copies initial content into the project and ensures that the project name
 * matches the bundle symbolic name if the project is a bundle project.
 */
public class TestProjectFixture extends ProjectFixture {

	static final Pattern BUNDLE_SYMBOLIC_NAME = Pattern.compile("Bundle-SymbolicName:\\s*([^;]+)"); //$NON-NLS-1$

	private final String markerType;
	private String projectNameOverride;

	/**
	 * Initializes me. I look for element-types plugin validation markers.
	 */
	public TestProjectFixture() {
		this(ElementTypesPluginValidationConstants.ELEMENTTYPES_PLUGIN_VALIDATION_TYPE);
	}

	/**
	 * Initializes me with the type of markers that I look for.
	 *
	 * @param markerType
	 *
	 * @see #getMarkers(IResource)
	 */
	public TestProjectFixture(String markerType) {
		super();

		this.markerType = markerType;
	}

	@Override
	public Statement apply(Statement base, Description description) {
		Build build = JUnitUtils.getAnnotation(description, Build.class);
		if (build != null && build.value()) {
			base = new BuildProject(base);
		}

		List<OverlayFile> overlayFiles = JUnitUtils.getAnnotationsByType(description, OverlayFile.class);
		if (!overlayFiles.isEmpty()) {
			base = new OverlayFilesInProject(overlayFiles, base, description);
		}

		TestProject testProject = JUnitUtils.getAnnotation(description, TestProject.class);
		Statement initProject = new Preferences(new InitializeProject(testProject, base, description));

		Statement createProject = super.apply(initProject, description);

		return new InitProjectName(testProject, createProject, description);
	}

	/**
	 * Build the test project.
	 */
	public void build() {
		try {
			getProject().build(IncrementalProjectBuilder.CLEAN_BUILD, new NullProgressMonitor());
			getProject().build(IncrementalProjectBuilder.FULL_BUILD, new NullProgressMonitor());
		} catch (CoreException e) {
			throw new AssertionError("Failed to build project.", e);
		}
	}

	/**
	 * Get all of the markers in the project.
	 *
	 * @return the markers
	 * @see #getMarkers(IResource)
	 */
	public List<IMarker> getMarkers() {
		return getMarkers(getProject());
	}

	/**
	 * Get the markers on the given {@code resource}. In the case that the resource is a container,
	 * the markers of all contained resources are aggregated within it.
	 *
	 * @param resource
	 *            the resource for which to get markers
	 * @return the markers
	 */
	public List<IMarker> getMarkers(IResource resource) {
		List<IMarker> result = null;

		try {
			result = Arrays.asList(resource.findMarkers(markerType, true, IResource.DEPTH_INFINITE));
		} catch (CoreException e) {
			throw new AssertionError("Failed to get project markers.", e); //$NON-NLS-1$
		}

		return result;
	}

	/**
	 * Get the markers on the named resource. In the case that the resource is a container,
	 * the markers of all contained resources are aggregated within it.
	 *
	 * @param path
	 *            the resource path for which to get markers
	 * @return the markers
	 * @see #getMarkers(IResource)
	 */
	public List<IMarker> getMarkers(String path) {
		IResource resource = getProject().findMember(path);
		assertThat("No such resource in the project: " + path, resource, notNullValue()); //$NON-NLS-1$

		return getMarkers(resource);
	}

	@Override
	protected void createProject(String name) throws CoreException {
		if (projectNameOverride != null) {
			super.createProject(projectNameOverride);
		} else {
			super.createProject(name);
		}
	}

	//
	// Nested types
	//

	/**
	 * Annotates a test or test class with a path to the content to copy into the project.
	 */
	@Target({ ElementType.METHOD, ElementType.TYPE })
	@Retention(RetentionPolicy.RUNTIME)
	public @interface TestProject {
		/** The path to the project template folder, relative to the {@code resources/} folder. */
		String value();
	}

	/**
	 * Annotates a test or test class to indicate that the project should be built before running the test.
	 */
	@Target({ ElementType.METHOD, ElementType.TYPE })
	@Retention(RetentionPolicy.RUNTIME)
	public @interface Build {
		/**
		 * Whether to build the project. A {@code false} value can override a default specified on the class.
		 */
		boolean value() default true;
	}

	/**
	 * Annotates a test or test class with a file to overlay on the {@link TestProject project content}
	 * after that has initially been populated.
	 */
	@Target({ ElementType.METHOD, ElementType.TYPE })
	@Retention(RetentionPolicy.RUNTIME)
	@Repeatable(OverlayFiles.class)
	public @interface OverlayFile {
		/**
		 * The source path of the file to overlay on the project, relative to the {@code resources/} folder.
		 */
		String value();

		/**
		 * The path of the file to create in the project. If omitted, the file is created at the same path
		 * relative to the project as the source is relative to the first-level nested folder of the
		 * {@code resources/} folder in the bundle in which the source file is contained. If the source
		 * file is a direct member of the {@code resources/} folder, then it is created in the root of
		 * the project.
		 */
		String path() default "";
	}

	/**
	 * Container of the repeatable {@code OverlayFile} annotation.
	 */
	@Target({ ElementType.METHOD, ElementType.TYPE })
	@Retention(RetentionPolicy.RUNTIME)
	public @interface OverlayFiles {
		OverlayFile[] value();
	}

	/**
	 * A statement that peeks into the contents of the project before the project is created,
	 * to override the name of the project that will be created with the bundle symbolic name
	 * in the case that the project's content will be a bundle project.
	 */
	private final class InitProjectName extends Statement {
		private final TestProject testProject;
		private final Statement base;
		private final Description description;

		InitProjectName(TestProject testProject, Statement base, Description description) {
			super();

			this.testProject = testProject;
			this.base = base;
			this.description = description;
		}

		@Override
		public void evaluate() throws Throwable {
			initializeProjectNameOverride();

			base.evaluate();
		}

		private void initializeProjectNameOverride() throws IOException {
			String path = testProject.value();
			while (path.endsWith("/")) {
				path = path.substring(0, path.length() - 1);
			}

			// If it's a bundle project, it needs to have the same name as the bundle
			String resourcePath = "resources/" + path + "/META-INF/MANIFEST.MF";
			URL resource = JUnitUtils.getTestClass(description).getClassLoader().getResource(resourcePath);
			if (resource != null) {
				Matcher m = null;
				try (InputStream input = resource.openStream()) {
					BufferedReader reader = new BufferedReader(new InputStreamReader(input, "UTF-8"));
					for (String line = reader.readLine(); line != null; line = reader.readLine()) {
						if (m == null) {
							m = BUNDLE_SYMBOLIC_NAME.matcher(line);
						} else {
							m.reset(line);
						}
						if (m.find()) {
							projectNameOverride = m.group(1);
							break;
						}
					}
				}
			}
		}
	}

	/**
	 * A statement that initializes the contents of the project before the test.
	 */
	private final class InitializeProject extends Statement {
		private final TestProject testProject;
		private final Statement base;
		private final Description description;

		InitializeProject(TestProject testProject, Statement base, Description description) {
			super();

			this.testProject = testProject;
			this.base = base;
			this.description = description;
		}

		@Override
		public void evaluate() throws Throwable {
			if (testProject == null) {
				throw new IllegalStateException("No @TestProject annotation found."); //$NON-NLS-1$
			}

			try {
				copyFolder(JUnitUtils.getTestClass(description), "resources/" + testProject.value()); //$NON-NLS-1$
			} catch (IOException e) {
				throw new IOException("Failed to initialize project contents.", e); //$NON-NLS-1$
			}

			base.evaluate();
		}
	}

	/**
	 * A statement that overlays additional files onto the initialized project.
	 *
	 * @see InitializeProject
	 */
	private final class OverlayFilesInProject extends Statement {
		private final List<OverlayFile> overlayFiles;
		private final Statement base;
		private final Description description;

		OverlayFilesInProject(List<OverlayFile> overlayFiles, Statement base, Description description) {
			super();

			this.overlayFiles = List.copyOf(overlayFiles);
			this.base = base;
			this.description = description;
		}

		@Override
		public void evaluate() throws Throwable {
			Class<?> testClass = JUnitUtils.getTestClass(description);

			for (OverlayFile overlay : overlayFiles) {
				URL resource = testClass.getClassLoader().getResource("resources/" + overlay.value()); //$NON-NLS-1$
				try (InputStream input = resource.openStream()) {
					IFile file = getProject().getFile(getTargetPath(overlay));
					if (file.exists()) {
						file.setContents(input, true, false, null);
					} else {
						file.create(input, true, null);
					}
				}
			}

			base.evaluate();
		}

		private IPath getTargetPath(OverlayFile overlay) {
			IPath result;

			if (overlay.path().isBlank()) {
				result = new Path(overlay.value());
				if (result.segmentCount() > 1) {
					result = result.removeFirstSegments(1);
				}
			} else {
				result = new Path(overlay.path());
			}

			return result;
		}

	}

	/**
	 * A statement that builds the project before the test.
	 */
	private final class BuildProject extends Statement {
		private final Statement base;

		BuildProject(Statement base) {
			super();

			this.base = base;
		}

		@Override
		public void evaluate() throws Throwable {
			build();
			base.evaluate();
		}

	}

	/**
	 * A statement that ensures that Papyrus builders are enabled in the preferences
	 * and restores the preferences to the previous values when complete.
	 */
	private final class Preferences extends Statement {
		private final Set<String> prefNames = Set.of(
				PluginBuilderPreferencesConstants.ACTIVATE_MAIN_PAPYRUS_BUILDER,
				PluginBuilderPreferencesConstants.ACTIVATE_PAPYRUS_MODEL_BUILDER,
				PluginBuilderPreferencesConstants.PAPYRUS_MODEL_BUILDER_CHECK_MODEL_DEPENDENCIES,
				PluginBuilderPreferencesConstants.PAPYRUS_MODEL_BUILDER_VALIDATE_MODEL,
				PluginBuilderPreferencesConstants.ACTIVATE_PAPYRUS_MANIFEST_BUILDER,
				PluginBuilderPreferencesConstants.PAPYRUS_MANIFEST_BUILDER_CHECK_DEPENDENCY_RANGE,
				PluginBuilderPreferencesConstants.PAPYRUS_MANIFEST_BUILDER_CHECK_NO_REEXPORT);
		private final IPreferenceStore prefs = org.eclipse.papyrus.toolsmiths.plugin.builder.Activator.getDefault().getPreferenceStore();
		private final Statement base;

		private final Map<String, Boolean> restorePrefs = new HashMap<>();

		Preferences(Statement base) {
			super();

			this.base = base;
		}

		@Override
		public void evaluate() throws Throwable {
			prefNames.forEach(pref -> restorePrefs.put(pref, prefs.getBoolean(pref)));
			prefNames.forEach(pref -> prefs.setValue(pref, true));

			try {
				base.evaluate();
			} finally {
				restorePrefs.forEach((pref, restore) -> prefs.setValue(pref, restore));
			}
		}

	}

}
