/*****************************************************************************
 * Copyright (c) 2015, 2016 CEA LIST, Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Thomas Daniellou (CEA LIST) - Initial API and implementation
 *  Christian W. Damus - bug 485220
 *  
 *****************************************************************************/
package org.eclipse.papyrus.adl4eclipse.generation.generator;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.papyrus.adl4eclipse.generation.Activator;
import org.eclipse.papyrus.adl4eclipse.generation.GeneratorUtils;
import org.eclipse.papyrus.adl4eclipse.org.ADL4Eclipse_Stereotypes;
import org.eclipse.papyrus.eclipse.project.editors.interfaces.IFeatureProjectEditor;
import org.eclipse.papyrus.eclipse.project.editors.project.FeatureProjectEditor;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Stereotype;
import org.xml.sax.SAXException;

public class FeatureGenerator implements Generator {

	private Component component;
	private Stereotype stereotype;

	private Set<String> files;
	private IFeatureProjectEditor featureProjectEditor;

	public FeatureGenerator(Component component) {
		this.component = component;

		stereotype = component.getAppliedStereotype(ADL4Eclipse_Stereotypes.FEATURE_STEREOTYPE);

		files = new HashSet<>();
		files.add(FeatureProjectEditor.FEATURE_XML_FILE);
	}

	@Override
	public void generate() throws CoreException {
		// Retrieve the project
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();

		IProject project = root.getProject(component.getName());

		if (!project.exists()) {
			project.create(new NullProgressMonitor());
		}

		if (!project.isOpen()) {
			project.open(new NullProgressMonitor());
		}

		try {
			featureProjectEditor = new FeatureProjectEditor(project);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			Activator.log.error(e);
		}

		featureProjectEditor.createFiles(files);
		featureProjectEditor.init();

		// TODO: Attributes that are removed in the model aren't removed when the feature is generated.
		// We need to either clear attributes before making the generation, or check (in a copy of the model)
		// which elements have been removed.

		String id = (String) component.getValue(stereotype, ADL4Eclipse_Stereotypes.FEATURE_ID_ATT);
		featureProjectEditor.setId(id);

		String label = (String) component.getValue(stereotype, ADL4Eclipse_Stereotypes.FEATURE_LABEL_ATT);
		featureProjectEditor.setLabel(label);

		String version = (String) component.getValue(stereotype, ADL4Eclipse_Stereotypes.FEATURE_VERSION_ATT);
		featureProjectEditor.setVersion(version);

		String providerName = (String) component.getValue(stereotype, ADL4Eclipse_Stereotypes.FEATURE_PROVIDER_ATT);
		featureProjectEditor.setProviderName(providerName);

		String descriptionURL = (String) component.getValue(stereotype, ADL4Eclipse_Stereotypes.FEATURE_DESCRIPTION_URL_ATT);
		String description = (String) component.getValue(stereotype, ADL4Eclipse_Stereotypes.FEATURE_DESCRIPTION_ATT);
		featureProjectEditor.setDescription(descriptionURL, description);

		String copyrightURL = (String) component.getValue(stereotype, ADL4Eclipse_Stereotypes.FEATURE_COPYRIGHT_URL_ATT);
		String copyrightDesc = (String) component.getValue(stereotype, ADL4Eclipse_Stereotypes.FEATURE_COPYRIGHT_ATT);
		featureProjectEditor.setCopyright(copyrightURL, copyrightDesc);

		String licenseURL = (String) component.getValue(stereotype, ADL4Eclipse_Stereotypes.FEATURE_LICENSE_URL_ATT);
		String licence = (String) component.getValue(stereotype, ADL4Eclipse_Stereotypes.FEATURE_LICENSE_ATT);
		featureProjectEditor.setLicense(licenseURL, licence);

		String url = (String) component.getValue(stereotype, ADL4Eclipse_Stereotypes.FEATURE_URL_ATT);
		if (url != null && url.length() > 0) {
			String urlLabel = (String) component.getValue(stereotype, ADL4Eclipse_Stereotypes.FEATURE_URL_LABEL_ATT);
			featureProjectEditor.setUpdateURL(urlLabel, url);
		}

		String os = (String) component.getValue(stereotype, ADL4Eclipse_Stereotypes.FEATURE_OS_ATT);
		featureProjectEditor.setOS(os);

		String ws = (String) component.getValue(stereotype, ADL4Eclipse_Stereotypes.FEATURE_WS_ATT);
		featureProjectEditor.setWS(ws);

		String nl = (String) component.getValue(stereotype, ADL4Eclipse_Stereotypes.FEATURE_LANGUAGES_ATT);
		featureProjectEditor.setNL(nl);

		String architecture = (String) component.getValue(stereotype, ADL4Eclipse_Stereotypes.FEATURE_ARCHITECTURE_ATT);
		featureProjectEditor.setArch(architecture);

		// Plug-ins
		List<?> plugins = (List<?>) component.getValue(stereotype, ADL4Eclipse_Stereotypes.FEATURE_PLUGINS_ATT);
		for (Object plugin : plugins) {
			String elementName = GeneratorUtils.getElementName(plugin);
			featureProjectEditor.addPlugin(elementName);
		}

		// Included Features
		List<?> includedFeatures = (List<?>) component.getValue(stereotype, ADL4Eclipse_Stereotypes.FEATURE_INCLUDED_FEATURES_ATT);
		for (Object feature : includedFeatures) {
			String featureName = GeneratorUtils.getElementName(feature);
			if (featureName != null) {
				// TODO: Version
				featureProjectEditor.addInclude(featureName, "0.0.0");
			}
		}

		// Required features
		List<?> featureDependencies = (List<?>) component.getValue(stereotype, ADL4Eclipse_Stereotypes.FEATURE_FEATURE_DEPENDENCIES_ATT);
		for (Object feature : featureDependencies) {
			String featureName = GeneratorUtils.getElementName(feature);
			if (featureName != null) {
				// TODO: Version
				featureProjectEditor.addRequiredFeature(featureName, "1.0.0.qualifier");
			}
		}

		// Required plug-ins
		List<?> pluginDependencies = (List<?>) component.getValue(stereotype, ADL4Eclipse_Stereotypes.FEATURE_PLUGIN_DEPENDENCIES_ATT);
		for (Object plugin : pluginDependencies) {
			String pluginName = GeneratorUtils.getElementName(plugin);
			featureProjectEditor.addRequiredPlugin(pluginName);
		}

		try {
			featureProjectEditor.save();
		} catch (Throwable e) {
			Activator.log.error(e);
		}
	}

}
