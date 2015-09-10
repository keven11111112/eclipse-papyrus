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
package org.eclipse.papyrus.adltool.reversible.project;

import static org.eclipse.papyrus.adltool.Activator.log;

import java.util.ArrayList;
import java.util.List;
import java.util.PropertyResourceBundle;

import org.eclipse.osgi.service.resolver.VersionRange;
import org.eclipse.papyrus.adl4eclipse.org.ADL4Eclipse_Stereotypes;
import org.eclipse.papyrus.adltool.ADL4EclipseUtils;
import org.eclipse.papyrus.adltool.reversible.extension.ReversibleExtension;
import org.eclipse.papyrus.adltool.reversible.extensionpoint.ReversibleExtensionPoint;
import org.eclipse.papyrus.adltool.reversible.factory.ReversibleFactory;
import org.eclipse.papyrus.adltool.reversible.packages.ReversiblePackage;
import org.eclipse.pde.core.plugin.IPluginExtension;
import org.eclipse.pde.core.plugin.IPluginExtensionPoint;
import org.eclipse.pde.core.project.IBundleProjectDescription;
import org.eclipse.pde.core.project.IPackageExportDescription;
import org.eclipse.pde.core.project.IPackageImportDescription;
import org.eclipse.pde.core.project.IRequiredBundleDescription;
import org.eclipse.swt.graphics.Image;
import org.osgi.framework.Constants;
import org.osgi.framework.Version;

/**
 * This class is a reversible adapter of a workspace plug-in.
 */
public class WorkspacePlugin extends AbstractPlugin {

	private IBundleProjectDescription plugin;

	/**
	 * Constructor.
	 *
	 * @param plugin
	 */
	public WorkspacePlugin(IBundleProjectDescription plugin) {
		super();
		this.plugin = plugin;

		// Save the exported packages
		List<ReversiblePackage> reversiblePackageExports = new ArrayList<>();
		IPackageExportDescription[] packageExports = plugin.getPackageExports();

		if (packageExports != null) {
			for (IPackageExportDescription packageExport : packageExports) {
				if (packageExport != null) {
					ReversiblePackage reversiblePackageExport = ReversibleFactory.getInstance().makeReversible(packageExport);

					reversiblePackageExports.add(reversiblePackageExport);

					Version version = packageExport.getVersion();

					if (version != null) {
						setReversibleVersion(reversiblePackageExport, new StereotypeVersion(version));
					}
				}
			}
		}

		// Save the imported packages
		List<ReversiblePackage> reversiblePackageImports = new ArrayList<>();
		IPackageImportDescription[] packageImports = plugin.getPackageImports();

		if (packageImports != null) {
			for (IPackageImportDescription packageImport : packageImports) {
				if (packageImport != null) {
					ReversiblePackage reversiblePackageImport = ReversibleFactory.getInstance().makeReversible(packageImport);

					reversiblePackageImports.add(reversiblePackageImport);

					VersionRange versionRange = packageImport.getVersionRange();
					if (versionRange != null) {
						setReversibleVersion(reversiblePackageImport, new StereotypeVersion(versionRange));
					}
				}
			}
		}

		// Save the extension points
		IPluginExtensionPoint[] pluginExtensionPoints = ADL4EclipseUtils.findExtensionPointsForPlugin(getId());
		List<ReversibleExtensionPoint> extensionPoints = new ArrayList<>();

		for (IPluginExtensionPoint pluginExtensionPoint : pluginExtensionPoints) {
			ReversibleExtensionPoint extensionPoint = ReversibleFactory.getInstance().makeReversible(pluginExtensionPoint);

			extensionPoint.setParent(this);
			extensionPoints.add(extensionPoint);
		}

		// Save the extensions
		IPluginExtension[] pluginExtensions = ADL4EclipseUtils.findExtensionsForPlugin(getId());
		List<ReversibleExtension> extensions = new ArrayList<>();

		for (IPluginExtension extension : pluginExtensions) {
			ReversibleExtension reversibleExtension = ReversibleFactory.getInstance().makeReversible(extension);

			reversibleExtension.setParent(this);
			extensions.add(reversibleExtension);
		}

		setExportedPackages(reversiblePackageExports);
		setImportedPackages(reversiblePackageImports);
		setExtensionPoints(extensionPoints);
		setExtensions(extensions);
	}

	@Override
	public String getId() {
		return plugin.getSymbolicName();
	}

	@Override
	public String getStereotypeName() {
		return ADL4Eclipse_Stereotypes.PLUGIN_STEREOTYPE;
	}

	@Override
	public Type getType() {
		return Type.PLUGIN;
	}

	@Override
	public Image getImage() {
		return ADL4EclipseUtils.getImage("img/bundle_pj.gif");
	}

	@Override
	public boolean isSingleton() {
		return plugin.isSingleton();
	}

	@Override
	public List<ReversibleProject> getDependencies() {
		List<ReversibleProject> dependencies = new ArrayList<>();
		IRequiredBundleDescription[] requiredBundles = plugin.getRequiredBundles();

		if (requiredBundles != null) {
			for (IRequiredBundleDescription requiredBundle : requiredBundles) {
				if (requiredBundle != null) {
					String pluginId = requiredBundle.getName();

					if (!Constants.SYSTEM_BUNDLE_SYMBOLICNAME.equals(pluginId)) {
						ReversibleProject reversiblePlugin = ReversibleFactory.getInstance().getPlugin(pluginId);

						if (reversiblePlugin != null) {
							dependencies.add(reversiblePlugin);
							// Save the version range of the dependency
							VersionRange versionRange = requiredBundle.getVersionRange();

							if (versionRange != null) {
								reversibleVersion.put(reversiblePlugin, new StereotypeVersion(versionRange));
							}
						} else {
							log.warn(getType() + " \"" + getId() + "\": cannot find child " + pluginId);
						}
					}
				}
			}
		}

		return dependencies;
	}

	@Override
	protected String getBundleValue(String key) {
		String valueFromDescription = plugin.getHeader(key);
		PropertyResourceBundle propertyResourceBundle = ADL4EclipseUtils.getNLSFilesFor(plugin);

		if (propertyResourceBundle != null && valueFromDescription != null) {
			if (valueFromDescription.startsWith("%") && valueFromDescription.length() > 1) { //$NON-NLS-1$
				String propertiesKey = valueFromDescription.substring(1);
				valueFromDescription = propertyResourceBundle.getString(propertiesKey);
			}
		}

		return valueFromDescription;
	}

}
