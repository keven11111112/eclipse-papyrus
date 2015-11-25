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

import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.adltool.ADL4EclipseUtils;
import org.eclipse.papyrus.adltool.command.CompleteArchitectureSnapshotCommand;
import org.eclipse.papyrus.adltool.designer.ReverseSettings;
import org.eclipse.papyrus.adltool.reversible.project.ReversibleProject;
import org.eclipse.papyrus.adltool.reversible.factory.ReversibleFactory;
import org.eclipse.papyrus.junit.utils.PapyrusProjectUtils;
import org.eclipse.papyrus.junit.utils.ProjectUtils;
import org.eclipse.papyrus.junit.utils.tests.AbstractEditorTest;
import org.eclipse.pde.core.project.IBundleProjectDescription;
import org.eclipse.pde.internal.core.ifeature.IFeature;
import org.eclipse.uml2.uml.Package;
import org.junit.After;
import org.junit.Assert;
import org.osgi.framework.Bundle;

@SuppressWarnings("restriction")
public abstract class AbstractADLTest extends AbstractEditorTest {

	// Model project name
	protected static final String MODEL_NAME = "testModel";
	protected static final String MODEL_PROJECT_NAME = "PapyrusTestModel";

	// Available features and plug-ins project names

	// Note: These projects should NOT be loaded in the target platform,
	// otherwise the wrong stereotypes will be applied to them
	protected static final String EMPTY_PLUGIN_PROJECT_NAME = "EmptyPlugin";
	protected static final String PLUGIN_WITH_DEPS_PROJECT_NAME = "PluginWithDependencies";
	protected static final String PLUGIN_WITH_PACKAGES_PROJECT_NAME = "PluginWithPackages";
	protected static final String PLUGIN_WITH_EXTENSION_PROJECT_NAME = "PluginWithExtension";
	protected static final String PLUGIN_WITH_DUPLICATE_DEPS_PROJECT_NAME = "PluginWithDuplicateDependency";

	protected static final String EMPTY_FEATURE_PROJECT_NAME = "EmptyFeature";
	protected static final String FEATURE_WITH_PLUGINS_PROJECT_NAME = "FeatureWithPlugins";
	protected static final String FEATURE_WITH_INCLUDES_PROJECT_NAME = "FeatureWithIncludes";
	protected static final String FEATURE_WITH_REQUIRES_PROJECT_NAME = "FeatureWithRequires";
	protected static final String FEATURE_WITH_DUPLICATES_PROJECT_NAME = "FeatureWithDuplicates";

	// Model, Plug-in and Feature resource path
	protected static final String MODEL_RESOURCES_PATH = "resources/model/";
	protected static final String PLUGINS_RESOURCES_PATH = "resources/templatePlugins/";
	protected static final String FEATURES_RESOURCES_PATH = "resources/templateFeatures/";

	protected static final int SIMPLE_REVERSE_DEPTH = 1;

	/**
	 * The object used to perform transactions on the models.
	 */
	protected TransactionalEditingDomain domain;

	/**
	 * The root element of the Papyrus model.
	 */
	protected Package rootModel;

	/**
	 * The list of project to reverse.
	 */
	protected Map<String, ReversibleProject> reversibleProjects;

	public AbstractADLTest() {
		reversibleProjects = new HashMap<>();
	}

	/**
	 * Initializes the Papyrus editor, the root model and the transactional
	 * editing domain.
	 *
	 * @throws Exception
	 */
	protected void initModel() throws Exception {
		initModel(MODEL_PROJECT_NAME, MODEL_NAME, Activator.getDefault().getBundle());

		rootModel = getRootUMLModel();
		domain = getTransactionalEditingDomain();

		assertNotNull("The root uml model is null", rootModel);
		assertNotNull("The transactional editing domain is null", domain);
	}

	/**
	 * Creates a feature project from a projectName that corresponds to a
	 * template in the resources/templateFeatures folder. The template must have
	 * the same name and must contain the feature.xml file.
	 *
	 * @param projectName The name of the folder in the
	 *        resource/templateFeatures containing the feature.xml file.
	 * @return
	 * @throws Exception
	 */
	protected ReversibleProject createReversibleFeature(String projectName) throws Exception {
		// Create the feature project in the workspace
		IProject project = ProjectUtils.createProject(projectName);
		ADLProjectUtils.configureProjectAsFeature(project);

		// The bundle where the feature is stored
		Bundle sourceBundle = Activator.getDefault().getBundle();

		// Copy the feature.xml in the project
		String featureXml = "feature.xml";
		String featureXmlPath = FEATURES_RESOURCES_PATH + projectName + "/" + featureXml;
		PapyrusProjectUtils.copyIFile(featureXmlPath, sourceBundle, project, featureXml);

		IFeature feature = ADL4EclipseUtils.getFeature(project);

		assertNotNull("The IFeature is null", feature);

		// Create the adapters
		ADL4EclipseUtils.populateReversibleFactory();

		ReversibleProject reversibleFeature = ReversibleFactory.getInstance().getFeature(projectName);

		assertNotNull("Reversible feature is null", reversibleFeature);

		reversibleProjects.put(reversibleFeature.getId(), reversibleFeature);

		return reversibleFeature;
	}

	/**
	 * Creates a plug-in project from a projectName that corresponds to a
	 * template in the resources/templatePlugins folder. The template must have
	 * the same name and must contain the META-INF/MANIFEST.MF file.
	 *
	 * @param projectName The name of the folder in the
	 *        resources/templatePlugins containing the META-INF/MANIFEST.MF
	 *        file.
	 * @throws Exception
	 */
	protected ReversibleProject createReversiblePlugin(String projectName) throws Exception {
		// Create the plug-in project in the workspace
		IProject project = ProjectUtils.createProject(projectName);
		ADLProjectUtils.configureProjectAsPlugin(project);

		// The bundle where the feature is stored
		Bundle sourceBundle = Activator.getDefault().getBundle();

		// Copy the MANIFEST.MF in the project
		String manifestFileName = "META-INF/MANIFEST.MF";
		String manifestPath = PLUGINS_RESOURCES_PATH + projectName + "/" + manifestFileName;
		PapyrusProjectUtils.copyIFile(manifestPath, sourceBundle, project, manifestFileName);

		IBundleProjectDescription projectDescription = ADL4EclipseUtils.getProjectDescription(project);

		assertNotNull("The IBundleProjectDescription is null", projectDescription);

		// Create the adapters
		ADL4EclipseUtils.populateReversibleFactory();

		ReversibleProject reversiblePlugin = ReversibleFactory.getInstance().getPlugin(projectName);

		assertNotNull("Reversible plug-in is null", reversiblePlugin);

		reversibleProjects.put(reversiblePlugin.getId(), reversiblePlugin);

		return reversiblePlugin;
	}

	/**
	 * Executes the reverse on the list of reversible projects that were
	 * created.
	 *
	 * @param depth
	 */
	protected void executeReverse(int depth) {
		// TODO: Set reverse settings properties
		ReverseSettings reverseSettings = new ReverseSettings();
		reverseSettings.setReverseDepth(depth);

		RecordingCommand cmd = new CompleteArchitectureSnapshotCommand(domain,
				rootModel,
				new HashSet<>(reversibleProjects.values()),
				reverseSettings);

		domain.getCommandStack().execute(cmd);
	}

	/**
	 * Clears the workspace by deleting every projects.
	 */
	@After
	public void clearWorkspace() {
		try {
			ProjectUtils.removeAllProjectFromTheWorkspace();
		} catch (CoreException e) {
			Assert.fail(e.getMessage());
		}
	}

	@Override
	protected String getSourcePath() {
		return MODEL_RESOURCES_PATH;
	}
}
