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
package org.eclipse.papyrus.adl4eclipse.generation.generator;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.papyrus.adl4eclipse.generation.GeneratorUtils;
import org.eclipse.papyrus.adltool.reversible.project.StereotypeVersion;
import org.eclipse.papyrus.eclipse.project.editors.file.ManifestEditor;
import org.eclipse.papyrus.eclipse.project.editors.interfaces.IManifestEditor;
import org.eclipse.papyrus.eclipse.project.editors.interfaces.IPluginProjectEditor;
import org.eclipse.papyrus.eclipse.project.editors.project.PluginProjectEditor;
import org.eclipse.papyrus.osgi.profile.OSGIStereotypes;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Stereotype;
import org.osgi.framework.Constants;
import org.xml.sax.SAXException;

public class BundleGenerator implements Generator {

	private static final String GENERATION_SUFFIX = "-gen";

	protected Component component;
	protected Stereotype stereotype;

	protected Set<String> files;
	protected IManifestEditor manifestEditor;
	protected IPluginProjectEditor projectEditor;

	public BundleGenerator(Component component) {
		this.component = component;

		files = new HashSet<>();
		files.add(IManifestEditor.MANIFEST_PATH);
		files.add(PluginProjectEditor.PLUGIN_XML_FILE);

		stereotype = component.getAppliedStereotype(OSGIStereotypes.BUNDLE);
	}

	@Override
	public void generate() throws CoreException {
		// TODO: Check if stereotype != null ?
		String projectName = component.getName();
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();

		IProject project = root.getProject(projectName + GENERATION_SUFFIX);

		if (!project.exists()) {
			project.create(new NullProgressMonitor());
		}

		if (!project.isOpen()) {
			project.open(new NullProgressMonitor());
		}

		try {
			manifestEditor = new ManifestEditor(project);
			projectEditor = new PluginProjectEditor(project);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}

		if (manifestEditor != null) {
			generateManifest();
		}

		if (projectEditor != null) {
			generatePluginXml();
		}
	}

	@SuppressWarnings("deprecation")
	private void generateManifest() {
		manifestEditor.createFiles(files);
		manifestEditor.init();

		// TODO: Remove manifest entries if they are empty

		// Bundle manifest version
		int manifestVersion = (int) component.getValue(stereotype, OSGIStereotypes.BUNDLE_MANIFESTVERSION_ATT);
		manifestEditor.setValue(Constants.BUNDLE_MANIFESTVERSION, Integer.toString(manifestVersion));

		// Name
		String name = (String) component.getValue(stereotype, OSGIStereotypes.BUNDLE_NAME_ATT);
		manifestEditor.setBundleName(name);

		// SymbolicName
		String symbolicName = (String) component.getValue(stereotype, OSGIStereotypes.BUNDLE_SYMBOLICNAME_ATT);
		manifestEditor.setSymbolicBundleName(symbolicName);

		// Singleton
		boolean singleton = (boolean) component.getValue(stereotype, OSGIStereotypes.BUNDLE_ISSINGLETON_ATT);
		manifestEditor.setSingleton(singleton);

		// Version
		String version = (String) component.getValue(stereotype, OSGIStereotypes.BUNDLE_VERSION_ATT);
		manifestEditor.setBundleVersion(version);

		// Vendor
		String vendor = (String) component.getValue(stereotype, OSGIStereotypes.BUNDLE_VENDOR_ATT);
		manifestEditor.setBundleVendor(vendor);

		// The following map contains:
		// * the key of the manifest entry used by the manifest editor
		// * the stereotype attributes that will be used to retrieve the value from the component
		Map<String, String> keyStereotype = new HashMap<>();

		// RequiredExecutionEnvironment
		keyStereotype.put(Constants.BUNDLE_REQUIREDEXECUTIONENVIRONMENT, OSGIStereotypes.BUNDLE_REQUIREDEXECUTIONENVIRONMENT_ATT);
		// ActivationPolicy
		keyStereotype.put(Constants.BUNDLE_ACTIVATIONPOLICY, OSGIStereotypes.BUNDLE_ACTIVATION_POLICY_ATT);
		// Activator
		keyStereotype.put(Constants.BUNDLE_ACTIVATOR, OSGIStereotypes.BUNDLE_ACTIVATOR_ATT);
		// Category
		keyStereotype.put(Constants.BUNDLE_CATEGORY, OSGIStereotypes.BUNDLE_CATEGORY_ATT);
		// ClassPath
		keyStereotype.put(Constants.BUNDLE_CLASSPATH, OSGIStereotypes.BUNDLE_CLASSPATH_ATT);
		// ContactAddress
		keyStereotype.put(Constants.BUNDLE_CONTACTADDRESS, OSGIStereotypes.BUNDLE_CONTACTADDRESS_ATT);
		// Copyright
		keyStereotype.put(Constants.BUNDLE_COPYRIGHT, OSGIStereotypes.BUNDLE_COPYRIGHT_ATT);
		// Description
		keyStereotype.put(Constants.BUNDLE_DESCRIPTION, OSGIStereotypes.BUNDLE_DESCRIPTION_ATT);
		// DocURL
		keyStereotype.put(Constants.BUNDLE_DOCURL, OSGIStereotypes.BUNDLE_DOCURL_ATT);
		// Localization
		keyStereotype.put(Constants.BUNDLE_LOCALIZATION, OSGIStereotypes.BUNDLE_LOCALIZATION_ATT);
		// NativeCode
		keyStereotype.put(Constants.BUNDLE_NATIVECODE, OSGIStereotypes.BUNDLE_NATIVECODE_ATT);
		// UpdateLocation
		keyStereotype.put(Constants.BUNDLE_UPDATELOCATION, OSGIStereotypes.BUNDLE_UPDATELOCATION_ATT);

		for (Map.Entry<String, String> entry : keyStereotype.entrySet()) {
			Object value = component.getValue(stereotype, entry.getValue());
			if (value instanceof String) {
				manifestEditor.setValue(entry.getKey(), value.toString().trim());
			}
		}

		// Require bundle
		List<?> requireBundles = (List<?>) component.getValue(stereotype, OSGIStereotypes.BUNDLE_REQUIREBUNDLE_ATT);
		for (Object bundle : requireBundles) {
			String bundleName = GeneratorUtils.getElementName(bundle);
			StereotypeVersion bundleVersion = GeneratorUtils.getDepdendencyVersion(bundle, OSGIStereotypes.BUNDLE_REFERENCE);
			if (bundleName != null) {
				if (bundleVersion != null) {
					manifestEditor.addDependency(bundleName, bundleVersion.toString());
				} else {
					manifestEditor.addDependency(bundleName);
				}
			}
		}

		// Import-Package
		List<?> importPackages = (List<?>) component.getValue(stereotype, OSGIStereotypes.BUNDLE_IMPORTPACKAGE_ATT);
		for (Object importPackage : importPackages) {
			String packageName = GeneratorUtils.getElementName(importPackage);
			StereotypeVersion packageVersion = GeneratorUtils.getDepdendencyVersion(importPackage, OSGIStereotypes.PACKAGE_REFERENCE);
			if (packageName != null) {
				if (packageVersion != null) {
					manifestEditor.addImportPackage(packageName, packageVersion.toString());
				} else {
					manifestEditor.addImportPackage(packageName);
				}
			}
		}

		// Export-Package
		List<?> exportPackages = (List<?>) component.getValue(stereotype, OSGIStereotypes.BUNDLE_EXPORTPACKAGE_ATT);
		for (Object exportPackage : exportPackages) {
			String packageName = GeneratorUtils.getElementName(exportPackage);
			StereotypeVersion packageVersion = GeneratorUtils.getDepdendencyVersion(exportPackage, OSGIStereotypes.PACKAGE_REFERENCE);
			if (packageName != null) {
				if (packageVersion != null) {
					manifestEditor.addExportPackage(packageName, packageVersion.toString());
				} else {
					manifestEditor.addExportPackage(packageName);
				}
			}
		}

		manifestEditor.save();
	}

	private void generatePluginXml() {
		projectEditor.createFiles(files);
		projectEditor.init();

		projectEditor.save();
	}

}
