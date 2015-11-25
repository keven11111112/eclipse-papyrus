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
package org.eclipse.papyrus.adltool.reversible.factory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.osgi.service.resolver.BundleDescription;
import org.eclipse.osgi.service.resolver.ExportPackageDescription;
import org.eclipse.osgi.service.resolver.ImportPackageSpecification;
import org.eclipse.papyrus.adltool.reversible.project.FragmentPlugin;
import org.eclipse.papyrus.adltool.reversible.project.LoadedPlugin;
import org.eclipse.papyrus.adltool.reversible.project.ReversibleFeature;
import org.eclipse.papyrus.adltool.reversible.project.ReversiblePlugin;
import org.eclipse.papyrus.adltool.reversible.project.ReversibleProject;
import org.eclipse.papyrus.adltool.reversible.project.WorkspacePlugin;
import org.eclipse.papyrus.adltool.ADL4EclipseUtils;
import org.eclipse.papyrus.adltool.reversible.extension.LoadedExtension;
import org.eclipse.papyrus.adltool.reversible.extension.WorkspaceExtension;
import org.eclipse.papyrus.adltool.reversible.extension.ReversibleExtension;
import org.eclipse.papyrus.adltool.reversible.extensionpoint.LoadedExtensionPoint;
import org.eclipse.papyrus.adltool.reversible.extensionpoint.ReversibleExtensionPoint;
import org.eclipse.papyrus.adltool.reversible.extensionpoint.WorkspaceExtensionPoint;
import org.eclipse.papyrus.adltool.reversible.packages.ExportPackage;
import org.eclipse.papyrus.adltool.reversible.packages.ImportPackage;
import org.eclipse.papyrus.adltool.reversible.packages.ReversiblePackage;
import org.eclipse.pde.core.plugin.IPluginExtension;
import org.eclipse.pde.core.plugin.IPluginExtensionPoint;
import org.eclipse.pde.core.project.IBundleProjectDescription;
import org.eclipse.pde.core.project.IPackageExportDescription;
import org.eclipse.pde.core.project.IPackageImportDescription;
import org.eclipse.pde.internal.core.ifeature.IFeature;
import org.osgi.framework.Bundle;

/**
 * A factory for creating reversibles.
 */
@SuppressWarnings("restriction")
public class ReversibleFactory {

	/**
	 * The type of reversible package (either EXPORT or IMPORT).
	 */
	public enum ReversiblePackageType { EXPORT, IMPORT };

	/**
	 * Map containing all the reversible features.
	 */
	private Map<String, ReversibleProject> features;

	/**
	 * Map containing all the reversible plug-ins.
	 */
	private Map<String, ReversibleProject> plugins;

	/**
	 * Map containing all the extensions.
	 */
	private Map<String, ReversibleExtension> extensions;

	/**
	 * Map containing all the extension points.
	 */
	private Map<String, ReversibleExtensionPoint> extensionPoints;

	/**
	 * Map containing all the imported packages.
	 */
	private Map<String, ReversiblePackage> importedPackages;

	/**
	 * Map containing all the exported packages.
	 */
	private Map<String, ReversiblePackage> exportedPackages;

	/**
	 * The singleton instance of the factory.
	 */
	private static ReversibleFactory instance = null;

	/**
	 * Return the singleton instance of the factory.
	 *
	 * @return the singleton instance of the factory
	 */
	public static ReversibleFactory getInstance() {
		if (instance == null) {
			instance = new ReversibleFactory();
		}

		return instance;
	}

	/**
	 * Constructor.
	 */
	private ReversibleFactory() {
		plugins = new HashMap<>();
		features = new HashMap<>();
		extensions = new HashMap<>();
		extensionPoints = new HashMap<>();
		importedPackages = new HashMap<>();
		exportedPackages = new HashMap<>();
	}

	/**
	 * Gets a reversible feature project.
	 *
	 * @param id the id of the reversible project to be returned
	 * @return the reversible project to which the specified id is mapped, or null if the project does not exist.
	 */
	public ReversibleProject getFeature(String id) {
		return features.get(id);
	}

	/**
	 * Gets a reversible plug-in project.
	 *
	 * @param id the id of the reversible project to be returned
	 * @return the reversible project to which the specified id is mapped, or null if the project does not exist.
	 */
	public ReversibleProject getPlugin(String id) {
		return plugins.get(id);
	}

	/**
	 * Gets a reversible extension point.
	 *
	 * @param id the id of the reversible extension point to be returned
	 * @return the reversible extension point with the corresponding id or null
	 *         if the extension point does not exist.
	 */
	public ReversibleExtensionPoint getExtensionPoint(String id) {
		return extensionPoints.get(id);
	}

	/**
	 * Gets a reversible extension.
	 *
	 * @param id the id of the reversible extension to be returned
	 * @return the reversible extension with the corresponding id or null if the
	 *         extension point does not exist.
	 */
	public ReversibleExtension getExtension(String id) {
		return extensions.get(id);
	}

	/**
	 * Remove a plug-in from the map.
	 *
	 * @param id the id of the reversible plug-in to remove
	 */
	public void removePlugin(String id) {
		ReversibleProject reversible = getPlugin(id);

		if (reversible instanceof ReversiblePlugin) {
			ReversiblePlugin reversiblePlugin = (ReversiblePlugin) reversible;

			// TODO: Remove project's package, but some package can have the same name.

			for (ReversibleExtensionPoint extensionPoint : reversiblePlugin.getExtensionPoints()) {
				removeExtensionPoint(extensionPoint.getId());
			}

			for (ReversibleExtension extension :  reversiblePlugin.getExtensions()) {
				removeExtension(extension.getId());
			}
		}

		plugins.remove(id);
	}

	/**
	 * Removes a feature from the map.
	 *
	 * @param id the id of the reversible feature to remove
	 */
	public void removeFeature(String id) {
		features.remove(id);
	}

	/**
	 * Removes an extension point from the map.
	 *
	 * @param id the id of the reversible extension point to remove
	 */
	private void removeExtensionPoint(String id) {
		extensionPoints.remove(id);
	}

	/**
	 * Removes an extension from the map.
	 *
	 * @param id the id of the reversible extension to remove
	 */
	private void removeExtension(String id) {
		extensions.remove(id);
	}

	/**
	 * Builds a reversible adapter from a workspace plug-in project and stores
	 * it in a map. The plug-in's extension points and extensions will also
	 * be adapted and saved in other maps.
	 *
	 * @param pluginDescription the description of the OSGi bundle
	 * @return the reversible plug-in project
	 */
	public ReversiblePlugin makeReversible(IBundleProjectDescription pluginDescription) {
		ReversiblePlugin project = new WorkspacePlugin(pluginDescription);
		registerPlugin(project);

		return project;
	}

	/**
	 * Builds a reversible adapter from a bundle project and save it.
	 *
	 * @param bundle the OSGi bundle
	 * @return the reversible bundle project
	 */
	public ReversiblePlugin makeReversible(Bundle bundle) {
		ReversiblePlugin project = new LoadedPlugin(bundle);
		registerPlugin(project);

		return project;
	}

	/**
	 * Builds a reversible feature project.
	 *
	 * @param feature
	 * @return the reversible feature project
	 */
	public ReversibleProject makeReversible(IFeature feature) {
		ReversibleProject project = new ReversibleFeature(feature);
		registerFeature(project);

		return project;
	}

	/**
	 * Builds a reversible plug-in extension point.
	 *
	 * @param pluginExtensionPoint
	 * @return the reversible plug-in extension point
	 */
	public ReversibleExtensionPoint makeReversible(IPluginExtensionPoint pluginExtensionPoint) {
		ReversibleExtensionPoint reversibleExtensionPoint = new WorkspaceExtensionPoint(pluginExtensionPoint);
		registerExtensionPoint(reversibleExtensionPoint);

		return reversibleExtensionPoint;
	}

	/**
	 * Builds a reversible bundle extension point.
	 *
	 * @param extensionPoint
	 * @return the reversible bundle extension point
	 */
	public ReversibleExtensionPoint makeReversible(IExtensionPoint extensionPoint) {
		ReversibleExtensionPoint reversibleExtensionPoint = new LoadedExtensionPoint(extensionPoint);
		registerExtensionPoint(reversibleExtensionPoint);

		return reversibleExtensionPoint;
	}

	/**
	 * Builds a reversible bundle extension.
	 *
	 * @param bundleExtension
	 * @return the reversible bundle extension
	 */
	public ReversibleExtension makeReversible(IExtension bundleExtension) {
		ReversibleExtension extension = new LoadedExtension(bundleExtension);
		registerExtension(extension);

		return extension;
	}

	/**
	 * Builds a reversible plug-in extension.
	 *
	 * @param pluginExtension
	 * @return
	 */
	public ReversibleExtension makeReversible(IPluginExtension pluginExtension) {
		ReversibleExtension extension = new WorkspaceExtension(pluginExtension);
		registerExtension(extension);

		return extension;
	}

	/**
	 * Builds a reversible workspace imported package.
	 *
	 * @param importPackage
	 * @return
	 */
	public ReversiblePackage makeReversible(IPackageImportDescription importPackage) {
		ReversiblePackage importedPackage = new ImportPackage(importPackage);
		registerImportedPackage(importedPackage);

		return importedPackage;
	}

	/**
	 * Builds a reversible workspace exported package.
	 *
	 * @param exportPackage
	 * @return
	 */
	public ReversiblePackage makeReversible(IPackageExportDescription exportPackage) {
		ReversiblePackage exportedPackage = new ExportPackage(exportPackage);
		registerExportedPackage(exportedPackage);

		return exportedPackage;
	}

	/**
	 * Builds a reversible exported package.
	 *
	 * @param exportPackage
	 * @return
	 */
	public ReversiblePackage makeReversible(ExportPackageDescription exportPackage) {
		ReversiblePackage exportedPackage = new ExportPackage(exportPackage);
		registerExportedPackage(exportedPackage);

		return exportedPackage;
	}

	/**
	 *
	 * @param importPackage
	 * @return
	 */
	public ReversiblePackage makeReversible(ImportPackageSpecification importPackage) {
		ReversiblePackage importedPackage = new ImportPackage(importPackage);
		registerImportedPackage(importedPackage);

		return importedPackage;
	}

	/**
	 *
	 * @param bundleDescription
	 * @return
	 */
	public ReversibleProject makeReversible(BundleDescription bundleDescription) {
		ReversiblePlugin plugin = new FragmentPlugin(bundleDescription);
		registerPlugin(plugin);

		// Save the extension points
		IPluginExtensionPoint[] pluginExtensionPoints = ADL4EclipseUtils.findExtensionPointsForPlugin(plugin.getId());
		List<ReversibleExtensionPoint> extensionPoints = new ArrayList<>();

		for (IPluginExtensionPoint pluginExtensionPoint : pluginExtensionPoints) {
			ReversibleExtensionPoint extensionPoint = makeReversible(pluginExtensionPoint);

			extensionPoint.setParent(plugin);
			extensionPoints.add(extensionPoint);
		}

		plugin.setExtensionPoints(extensionPoints);

		// Save the extensions
		IPluginExtension[] pluginExtensions = ADL4EclipseUtils.findExtensionsForPlugin(plugin.getId());
		List<ReversibleExtension> extensions = new ArrayList<>();

		for (IPluginExtension extension : pluginExtensions) {
			ReversibleExtension reversibleExtension = makeReversible(extension);

			reversibleExtension.setParent(plugin);
			extensions.add(reversibleExtension);
		}

		plugin.setExtensions(extensions);

		return plugin;
	}

	/**
	 * Create a reversible package from a {@link ReversiblePackageType type}.
	 *
	 * @param id the name of the package
	 * @param type the type of the package
	 * @return
	 */
	public ReversiblePackage makeReversible(String id, ReversiblePackageType type) {
		ReversiblePackage reversiblePackage;

		if (ReversiblePackageType.EXPORT == type) {
			reversiblePackage = new ExportPackage(id);
			registerExportedPackage(reversiblePackage);
		} else {
			reversiblePackage = new ImportPackage(id);
			registerImportedPackage(reversiblePackage);
		}

		return reversiblePackage;
	}

	/**
	 * Saves a reversible plug-in in a map.
	 *
	 * @param plugin
	 */
	private void registerPlugin(ReversibleProject plugin) {
		ReversibleProject savedPlugin = plugins.get(plugin.getId());

		if (savedPlugin == null || savedPlugin.equals(plugin)) {
			plugins.put(plugin.getId(), plugin);
		}
	}

	/**
	 * Saves a reversible feature in a map.
	 *
	 * @param feature
	 */
	private void registerFeature(ReversibleProject feature) {
		ReversibleProject savedFeature = features.get(feature.getId());

		if (savedFeature == null || savedFeature.equals(feature)) {
			features.put(feature.getId(), feature);
		}
		// else: name & type conflict
	}

	/**
	 * Saves an extension point in a map.
	 *
	 * @param extensionPoint
	 */
	private void registerExtensionPoint(ReversibleExtensionPoint extensionPoint) {
		ReversibleExtensionPoint savedExtensionPoint = extensionPoints.get(extensionPoint.getId());

		if (savedExtensionPoint == null || savedExtensionPoint.equals(extensionPoint)) {
			extensionPoints.put(extensionPoint.getId(), extensionPoint);
		}
	}

	/**
	 * Saves an extension in a map.
	 *
	 * @param extension
	 */
	private void registerExtension(ReversibleExtension extension) {
		ReversibleExtension savedExtension = extensions.get(extension.getId());

		if (savedExtension == null || savedExtension.equals(extension)) {
			extensions.put(extension.getId(), extension);
		}
	}

	/**
	 * Saves an imported package in a map.
	 *
	 * @param importedPackage
	 */
	private void registerImportedPackage(ReversiblePackage importedPackage) {
		ReversiblePackage savedPackage = importedPackages.get(importedPackage.getId());

		if (savedPackage == null || savedPackage.equals(importedPackage)) {
			importedPackages.put(importedPackage.getId(), importedPackage);
		}
	}

	/**
	 * Saves an exported package in a map.
	 *
	 * @param exportedPackage
	 */
	private void registerExportedPackage(ReversiblePackage exportedPackage) {
		ReversiblePackage savedPackage = exportedPackages.get(exportedPackage.getId());

		if (savedPackage == null || savedPackage.equals(exportedPackage)) {
			exportedPackages.put(exportedPackage.getId(), exportedPackage);
		}
	}

}
