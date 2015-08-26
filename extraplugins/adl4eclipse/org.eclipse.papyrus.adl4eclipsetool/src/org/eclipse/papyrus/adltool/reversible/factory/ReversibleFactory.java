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
import org.eclipse.pde.core.plugin.IPluginExtension;
import org.eclipse.pde.core.plugin.IPluginExtensionPoint;
import org.eclipse.pde.core.project.IBundleProjectDescription;
import org.eclipse.pde.internal.core.ifeature.IFeature;
import org.osgi.framework.Bundle;

/**
 * A factory for creating reversibles.
 */
@SuppressWarnings("restriction")
public class ReversibleFactory {

	/**
	 * Map containing all the reversible features.
	 */
	private Map<String, ReversibleProject> features;

	/**
	 * Map containing all the reversible plug-ins.
	 */
	private Map<String, ReversibleProject> plugins;

	/**
	 * Map containing all the extension points.
	 */
	private Map<String, ReversibleExtensionPoint> extensionPoints;

	/**
	 * Map containing all the extensions.
	 */
	private Map<String, ReversibleExtension> extensions;

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
		extensionPoints = new HashMap<>();
		extensions = new HashMap<>();
	}

	/**
	 * Gets a reversible project.
	 *
	 * @param id the id of the reversible project to be returned
	 * @return the reversible project to which the specified id is mapped, or null if the project does not exist.
	 */
	public ReversibleProject getFeature(String id) {
		return features.get(id);
	}

	public ReversibleProject getPlugin(String id) {
		return plugins.get(id);
	}

	/**
	 * Gets a reversible extension point.
	 *
	 * @param id
	 * @return the reversible extension point with the corresponding id or null
	 *         if the extension point does not exist.
	 */
	public ReversibleExtensionPoint getExtensionPoint(String id) {
		return extensionPoints.get(id);
	}

	/**
	 * Gets a reversible extension.
	 *
	 * @param id
	 * @return the reversible extension with the corresponding id or null if the
	 *         extension point does not exist.
	 */
	public ReversibleExtension getExtension(String id) {
		return extensions.get(id);
	}

	public void removePlugin(String id) {
		ReversibleProject reversible = getPlugin(id);

		if (reversible instanceof ReversiblePlugin) {
			ReversiblePlugin reversiblePlugin = (ReversiblePlugin) reversible;

			for (ReversibleExtensionPoint extensionPoint : reversiblePlugin.getExtensionPoints()) {
				removeExtensionPoint(extensionPoint.getId());
			}

			for (ReversibleExtension extension :  reversiblePlugin.getExtensions()) {
				removeExtension(extension.getId());
			}
		}

		plugins.remove(id);
	}

	public void removeFeature(String id) {
		features.remove(id);
	}

	/**
	 * Removes an extension point from the map.
	 *
	 * @param id
	 */
	private void removeExtensionPoint(String id) {
		extensionPoints.remove(id);
	}

	/**
	 * Removes an extension from the map.
	 *
	 * @param id
	 */
	private void removeExtension(String id) {
		extensions.remove(id);
	}

	/**
	 * Builds a reversible adapter from a plug-in project and stores it in a
	 * map. The plug-in's extension points and extensions will also be adapted
	 * and saved in other maps.
	 *
	 * @param pluginDescription
	 * @return the reversible plug-in project
	 */
	public ReversiblePlugin makeReversible(IBundleProjectDescription pluginDescription) {
		ReversiblePlugin project = new WorkspacePlugin(pluginDescription);
		registerPlugin(project);

		// Save the extension points
		IPluginExtensionPoint[] pluginExtensionPoints = ADL4EclipseUtils.findExtensionPointsForPlugin(project.getId());
		List<ReversibleExtensionPoint> extensionPoints = new ArrayList<>();

		for (IPluginExtensionPoint pluginExtensionPoint : pluginExtensionPoints) {
			ReversibleExtensionPoint extensionPoint = makeReversible(pluginExtensionPoint);

			extensionPoint.setParent(project);
			extensionPoints.add(extensionPoint);
		}

		project.setExtensionPoints(extensionPoints);

		// Save the extensions
		IPluginExtension[] pluginExtensions = ADL4EclipseUtils.findExtensionsForPlugin(project.getId());
		List<ReversibleExtension> extensions = new ArrayList<>();

		for (IPluginExtension extension : pluginExtensions) {
			ReversibleExtension reversibleExtension = makeReversible(extension);

			reversibleExtension.setParent(project);
			extensions.add(reversibleExtension);
		}

		project.setExtensions(extensions);

		return project;
	}

	/**
	 * Builds a reversible adapter from a bundle project and save it.
	 *
	 * @param bundle
	 * @return the reversible bundle project
	 */
	public ReversiblePlugin makeReversible(Bundle bundle) {
		ReversiblePlugin project = new LoadedPlugin(bundle);
		registerPlugin(project);

		// Save the extension points
		IExtensionPoint[] bundleExtensionPoints = ADL4EclipseUtils.findExtensionPointsForBundle(bundle.getBundleId(), project.getId());
		List<ReversibleExtensionPoint> extensionPoints = new ArrayList<>();

		for (IExtensionPoint bundleExtensionPoint : bundleExtensionPoints) {
			ReversibleExtensionPoint extensionPoint = makeReversible(bundleExtensionPoint);

			extensionPoint.setParent(project);
			extensionPoints.add(extensionPoint);
		}

		project.setExtensionPoints(extensionPoints);

		// Save the extensions
		IExtension[] bundleExtensions = ADL4EclipseUtils.findExtensionsForBundle(bundle.getBundleId(), project.getId());
		List<ReversibleExtension> extensions = new ArrayList<>();

		for (IExtension extension : bundleExtensions) {
			ReversibleExtension reversibleExtension = makeReversible(extension);

			reversibleExtension.setParent(project);
			extensions.add(reversibleExtension);
		}

		project.setExtensions(extensions);

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

}
