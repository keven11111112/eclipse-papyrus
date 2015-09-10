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
import org.eclipse.osgi.service.resolver.BundleDescription;
import org.eclipse.osgi.service.resolver.BundleSpecification;
import org.eclipse.osgi.service.resolver.ExportPackageDescription;
import org.eclipse.osgi.service.resolver.ImportPackageSpecification;
import org.eclipse.osgi.service.resolver.VersionRange;
import org.eclipse.papyrus.adltool.ADL4EclipseUtils;
import org.eclipse.papyrus.adltool.reversible.factory.ReversibleFactory;
import org.eclipse.papyrus.adltool.reversible.packages.ReversiblePackage;
import org.eclipse.papyrus.osgi.profile.OSGIStereotypes;
import org.eclipse.swt.graphics.Image;
import org.osgi.framework.Version;

/**
 * <p>This class is an adapter of the BundleDescription that represents a bundle in
 * the system. (Loaded, workspace, fragment plug-ins)</p>
 * <p>
 * Since the workspace and loaded plug-ins are already adapted with the LoadedPlugin
 * and WorkspacePlugin, this adapter can be used for Fragment plug-ins.</p>
 * <p>
 * For now, a reversed Fragment plug-in will be the same as a reversed
 * LoadedPlugin.</p>
 */
public class FragmentPlugin extends AbstractPlugin {

	/**
	 * The adaptee.
	 */
	private BundleDescription bundleDescription;

	public FragmentPlugin(BundleDescription bundleDescription) {
		super();
		this.bundleDescription = bundleDescription;
	}

	@Override
	public String getId() {
		return bundleDescription.getSymbolicName();
	}

	@Override
	public String getStereotypeName() {
		return OSGIStereotypes.BUNDLE;
	}

	@Override
	public Type getType() {
		return Type.BUNDLE;
	}

	@Override
	public Image getImage() {
		return ADL4EclipseUtils.getImage("img/bundle_obj.gif");
	}

	@Override
	public boolean isSingleton() {
		return bundleDescription.isSingleton();
	}

	@Override
	public List<ReversibleProject> getDependencies() {
		List<ReversibleProject> dependencies = new ArrayList<>();
		BundleSpecification[] requiredBundles = bundleDescription.getRequiredBundles();

		if (requiredBundles != null) {
			for (BundleSpecification requireBundle : requiredBundles) {
				ReversibleProject plugin = ReversibleFactory.getInstance().getPlugin(requireBundle.getName());
				if (plugin != null) {
					dependencies.add(plugin);

					VersionRange version = requireBundle.getVersionRange();
					if (version != null) {
						reversibleVersion.put(plugin, new StereotypeVersion(version));
					}
				} else {
					log.warn(getType() + " \"" + getId() + "\": cannot find child " + requireBundle.getName());
				}
			}
		}

		return dependencies;
	}

	@Override
	public List<ReversiblePackage> getExportedPackages() {
		List<ReversiblePackage> exportedPackages = new ArrayList<>();
		ExportPackageDescription[] exportPackages = bundleDescription.getExportPackages();

		if (exportPackages != null) {
			for (ExportPackageDescription exportPackage : exportPackages) {
				ReversiblePackage reversibleExportPackage = ReversibleFactory.getInstance().makeReversible(exportPackage);
				exportedPackages.add(reversibleExportPackage);

				Version version = exportPackage.getVersion();
				if (version != null) {
					reversibleVersion.put(reversibleExportPackage, new StereotypeVersion(version));
				}
			}
		}

		return exportedPackages;
	}

	@Override
	public List<ReversiblePackage> getImportedPackages() {
		List<ReversiblePackage> importedPackages = new ArrayList<>();
		ImportPackageSpecification[] importPackages = bundleDescription.getImportPackages();

		if (importPackages != null) {
			for (ImportPackageSpecification importPackage : importPackages) {
				ReversiblePackage reversibleImportPackage = ReversibleFactory.getInstance().makeReversible(importPackage);
				importedPackages.add(reversibleImportPackage);

				VersionRange version = importPackage.getVersionRange();
				if (version != null) {
					reversibleVersion.put(reversibleImportPackage, new StereotypeVersion(version));
				}
			}
		}

		return importedPackages;
	}

	@Override
	protected String getBundleValue(String key) {
		// Unused
		return null;
	}
}
