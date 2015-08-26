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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.osgi.util.ManifestElement;
import org.eclipse.papyrus.adltool.reversible.AbstractReversible;
import org.eclipse.papyrus.adltool.reversible.extension.ReversibleExtension;
import org.eclipse.papyrus.adltool.reversible.extensionpoint.ReversibleExtensionPoint;
import org.eclipse.papyrus.osgi.profile.IOSGIStereotype;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.UMLFactory;
import org.osgi.framework.BundleException;
import org.osgi.framework.Constants;

/**
 * This abstract class provides the default implementation of the
 * {@link ReversiblePlugin} adapter.
 */
public abstract class AbstractReversiblePlugin extends AbstractReversible<Component> implements ReversiblePlugin {

	/**
	 * The list of extension points defined by this plug-in.
	 */
	protected List<ReversibleExtensionPoint> extensionPoints;

	/**
	 * The list of extensions defined by this plug-in.
	 */
	protected List<ReversibleExtension> extensions;

	/**
	 * Gets a value in the plug-in manifest.
	 *
	 * @param key the key of the value to retrieve.
	 * @return the corresponding value in the plug-in manifest
	 */
	protected abstract String getBundleValue(String key);

	@Override
	public List<ReversibleExtensionPoint> getExtensionPoints() {
		return extensionPoints;
	}

	@Override
	public void setExtensionPoints(List<ReversibleExtensionPoint> extensionPoints) {
		this.extensionPoints = extensionPoints;
	}

	@Override
	public List<ReversibleExtension> getExtensions() {
		return extensions;
	}

	@Override
	public void setExtensions(List<ReversibleExtension> extensions) {
		this.extensions = extensions;
	}

	@Override
	public String getDescription() {
		String bundleDescription = getBundleValue(Constants.BUNDLE_DESCRIPTION);

		return bundleDescription != null ? bundleDescription : "";
	}

	@Override
	public String getDependencyStereotypeName() {
		return IOSGIStereotype.BUNDLEREFERENCE;
	}

	@Override
	public Component createRepresentation() {
		return UMLFactory.eINSTANCE.createComponent();
	}

	protected List<String> extractManifestHeader(String header) {
		List<String> result = new ArrayList<>();
		String value = getBundleValue(header);

		try {
			ManifestElement[] manifests = ManifestElement.parseHeader(header, value);

			if (manifests != null) {
				for (ManifestElement manifest : manifests) {
					result.add(manifest.getValue());
				}
			}
		} catch (BundleException e) {
			e.printStackTrace();
		}

		return result;
	}

}
