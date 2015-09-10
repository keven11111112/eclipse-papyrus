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

import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.osgi.service.resolver.VersionRange;
import org.eclipse.osgi.util.ManifestElement;
import org.eclipse.papyrus.adltool.ADL4EclipseUtils;
import org.eclipse.papyrus.adltool.reversible.extension.ReversibleExtension;
import org.eclipse.papyrus.adltool.reversible.extensionpoint.ReversibleExtensionPoint;
import org.eclipse.papyrus.adltool.reversible.factory.ReversibleFactory;
import org.eclipse.papyrus.adltool.reversible.factory.ReversibleFactory.ReversiblePackageType;
import org.eclipse.papyrus.adltool.reversible.packages.ReversiblePackage;
import org.eclipse.papyrus.osgi.profile.OSGIStereotypes;
import org.eclipse.swt.graphics.Image;
import org.osgi.framework.Bundle;
import org.osgi.framework.Constants;

/**
 * This class is a reversible adapter of a loaded plug-in.
 */
public class LoadedPlugin extends AbstractPlugin {

	private Bundle bundle;

	/**
	 * Constructor.
	 *
	 * @param bundle
	 */
	public LoadedPlugin(Bundle bundle) {
		super();
		this.bundle = bundle;

		List<ReversiblePackage> exportedPackages = new ArrayList<>();
		List<ManifestElement> manifestExportedPackages = extractManifestHeader(Constants.EXPORT_PACKAGE);

		for (ManifestElement exportedPackage : manifestExportedPackages) {
			ReversiblePackage exportPackage = ReversibleFactory.getInstance().makeReversible(exportedPackage.getValue(), ReversiblePackageType.EXPORT);

			exportPackage.setParent(this);
			exportedPackages.add(exportPackage);
		}

		List<ManifestElement> manifestImportedPackages = extractManifestHeader(Constants.IMPORT_PACKAGE);
		List<ReversiblePackage> importedPackages = new ArrayList<>();

		for (ManifestElement importedPackage : manifestImportedPackages) {
			ReversiblePackage importPackage = ReversibleFactory.getInstance().makeReversible(importedPackage.getValue(), ReversiblePackageType.IMPORT);

			importPackage.setParent(this);
			importedPackages.add(importPackage);
		}

		// Save the extension points
		IExtensionPoint[] bundleExtensionPoints = ADL4EclipseUtils.findExtensionPointsForBundle(bundle.getBundleId(), getId());
		List<ReversibleExtensionPoint> extensionPoints = new ArrayList<>();

		for (IExtensionPoint bundleExtensionPoint : bundleExtensionPoints) {
			ReversibleExtensionPoint extensionPoint = ReversibleFactory.getInstance().makeReversible(bundleExtensionPoint);

			extensionPoint.setParent(this);
			extensionPoints.add(extensionPoint);
		}

		// Save the extensions
		IExtension[] bundleExtensions = ADL4EclipseUtils.findExtensionsForBundle(bundle.getBundleId(), getId());
		List<ReversibleExtension> extensions = new ArrayList<>();

		for (IExtension extension : bundleExtensions) {
			ReversibleExtension reversibleExtension = ReversibleFactory.getInstance().makeReversible(extension);

			reversibleExtension.setParent(this);
			extensions.add(reversibleExtension);
		}

		setExportedPackages(exportedPackages);
		setImportedPackages(importedPackages);
		setExtensionPoints(extensionPoints);
		setExtensions(extensions);
	}

	@Override
	public String getId() {
		return bundle.getSymbolicName();
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
		String isSingleton = getBundleValue(Constants.SINGLETON_DIRECTIVE);

		return Boolean.valueOf(isSingleton);
	}

	@Override
	public List<ReversibleProject> getDependencies() {
		List<ReversibleProject> dependencies = new ArrayList<>();
		List<ManifestElement> requiredBundles = extractManifestHeader(Constants.REQUIRE_BUNDLE);

		if (!requiredBundles.isEmpty()) {
			for (ManifestElement requiredBundle : requiredBundles) {
				String bundleId = requiredBundle.getValue();

				if (!Constants.SYSTEM_BUNDLE_SYMBOLICNAME.equals(bundleId)) {
					ReversibleProject reversibleChild = ReversibleFactory.getInstance().getPlugin(bundleId);

					if (reversibleChild != null) {
						dependencies.add(reversibleChild);

						// Version
						String version = requiredBundle.getAttribute(Constants.BUNDLE_VERSION_ATTRIBUTE);
						if (version != null) {
							VersionRange versionRange = new VersionRange(version);
							reversibleVersion.put(reversibleChild, new StereotypeVersion(versionRange));
						}
					} else {
						log.warn(getType() + " \"" + getId() + "\": cannot find child " + bundleId);
					}
				}
			}
		}

		return dependencies;
	}

	@Override
	protected String getBundleValue(String key) {
		return bundle.getHeaders().get(key);
	}

}
