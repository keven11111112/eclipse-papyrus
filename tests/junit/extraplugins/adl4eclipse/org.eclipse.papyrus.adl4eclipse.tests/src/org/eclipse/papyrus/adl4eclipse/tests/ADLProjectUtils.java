/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Thomas Daniellou (CEA LIST) - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.adl4eclipse.tests;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.papyrus.adltool.ADLConstants;
import org.eclipse.pde.core.project.IBundleProjectDescription;

/**
 * This class helps configuring plug-in or feature projects.
 */
public class ADLProjectUtils {

	// Private constructor to prevent instantiation
	private ADLProjectUtils() {}

	/**
	 * Configures an IProject as a plug-in project by setting its nature, builders and classpath.
	 *
	 * @param project The IProject to configure as a plug-in.
	 * @throws CoreException
	 */
	public static void configureProjectAsPlugin(IProject project) throws CoreException {
		// Set the Java nature
		IProjectDescription description = project.getDescription();
		description.setNatureIds(new String[] { JavaCore.NATURE_ID, IBundleProjectDescription.PLUGIN_NATURE });

		// Configure the plug-in's builders
		List<ICommand> builders = new ArrayList<>();

		final ICommand java = description.newCommand();
		java.setBuilderName(JavaCore.BUILDER_ID);
		builders.add(java);

		final ICommand manifest = description.newCommand();
		manifest.setBuilderName(ADLConstants.MANIFEST_BUILDER_ID);
		builders.add(manifest);

		final ICommand schema = description.newCommand();
		schema.setBuilderName(ADLConstants.SCHEMA_BUILDER_ID);
		builders.add(schema);

		description.setBuildSpec(builders.toArray(new ICommand[builders.size()]));
		project.setDescription(description, new NullProgressMonitor());

		// Create the source folder
		IFolder src = project.getFolder("src");

		if (!src.exists()) {
			src.create(false, true, new NullProgressMonitor());
		}

		// Create the project and configure its classpath
		IJavaProject javaProject = JavaCore.create(project);
		IClasspathEntry[] classPath = { JavaCore.newSourceEntry(src.getFullPath()),
				JavaRuntime.getDefaultJREContainerEntry(),
				JavaCore.newContainerEntry(ADLConstants.REQUIRED_PLUGINS_CONTAINER_PATH)
		};

		javaProject.setRawClasspath(classPath, project.getFullPath().append("bin"), new NullProgressMonitor());
	}

	/**
	 * Configures an IProject as a Feature by setting its nature and builder.
	 *
	 * @param featureProject
	 *            The IProject to configure as a feature.
	 * @throws CoreException
	 */
	public static void configureProjectAsFeature(IProject featureProject) throws CoreException {
		IProjectDescription description = featureProject.getDescription();
		description.setNatureIds(new String[] { ADLConstants.FEATURE_NATURE });

		final ICommand feature = description.newCommand();
		feature.setBuilderName(ADLConstants.FEATURE_BUILDER_ID);

		description.setBuildSpec(new ICommand[] { feature });
		featureProject.setDescription(description, new NullProgressMonitor());
	}
}
