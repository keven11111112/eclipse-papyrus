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

import org.eclipse.papyrus.adl4eclipse.org.IADL4ECLIPSE_Stereotype;
import org.eclipse.papyrus.adltool.ADL4EclipseUtils;
import org.eclipse.papyrus.adltool.reversible.factory.ReversibleFactory;
import org.eclipse.swt.graphics.Image;
import org.osgi.framework.Bundle;
import org.osgi.framework.Constants;

/**
 * This class is a reversible adapter of a loaded plug-in.
 */
public class LoadedPlugin extends AbstractReversiblePlugin {

	private Bundle bundle;

	/**
	 * Constructor.
	 *
	 * @param bundle
	 */
	public LoadedPlugin(Bundle bundle) {
		this.bundle = bundle;
	}

	@Override
	public String getId() {
		return bundle.getSymbolicName();
	}

	@Override
	public String getStereotypeName() {
		return IADL4ECLIPSE_Stereotype.PLUGIN_STEREOTYPE;
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
	public List<ReversibleProject> getDependencies() {
		List<ReversibleProject> children = new ArrayList<>();
		String requireBundles = getBundleValue(Constants.REQUIRE_BUNDLE);

		if (requireBundles != null) {
			List<String> childrenIds = extractManifestHeader(Constants.REQUIRE_BUNDLE);

			if (!childrenIds.isEmpty()) {
				for (String childId : childrenIds) {
					ReversibleProject reversibleChild = ReversibleFactory.getInstance().getPlugin(childId);

					if (reversibleChild != null) {
						children.add(reversibleChild);
					} else {
						log.warn("Bundle \"" + getId() + "\" : cannot find child " + childId);
					}
				}
			}
		}

		return children;
	}

	@Override
	public List<String> getExportedPackages() {
		return extractManifestHeader(Constants.EXPORT_PACKAGE);
	}

	@Override
	protected String getBundleValue(String key) {
		return bundle.getHeaders().get(key);
	}

	@Override
	public void fillStereotype() {
		if (!applyStereotype()) {
			log.warn("(" + getType() +") " + getId() + " cannot fill the stereotype properties");
			return;
		}

		// TODO
	}

}
