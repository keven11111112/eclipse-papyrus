/*****************************************************************************
 * Copyright (c) 2020 Christian W. Damus, CEA LIST, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.infra.emf.utils;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

import org.eclipse.core.runtime.Platform;
import org.eclipse.osgi.container.ModuleContainer;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.PluginRegistry;
import org.osgi.framework.Bundle;
import org.osgi.framework.Constants;
import org.osgi.framework.namespace.IdentityNamespace;
import org.osgi.framework.wiring.BundleCapability;
import org.osgi.framework.wiring.FrameworkWiring;

/**
 * Optional support for a PDE Target platform, to discover the plug-ins against
 * which workspace projects (if any) are overlaid.
 */
abstract class PlatformHelper {

	static final PlatformHelper INSTANCE;

	static {
		PlatformHelper instance;

		try {
			instance = new PDEHelper();
		} catch (Exception e) {
			// PDE is not available
			instance = new InstallHelper();
		}

		INSTANCE = instance;
	}


	/**
	 * Get the IDs of all bundles available in the target platform, whether that be the
	 * PDE Target Platform (in case PDE is installed) or else the host installation.
	 *
	 * @return the platform bundle IDs
	 */
	abstract Collection<String> getPlatformBundleIDs();

	//
	// Nested types
	//

	/**
	 * The install helper instance gets all resolved (ready/available) bundles in the current installation.
	 */
	private static final class InstallHelper extends PlatformHelper {

		private static final int AVAILABLE = Bundle.ACTIVE | Bundle.RESOLVED | Bundle.STARTING;

		@Override
		Collection<String> getPlatformBundleIDs() {
			Collection<String> result = new HashSet<>();

			FrameworkWiring wiring = Platform.getBundle(Constants.SYSTEM_BUNDLE_SYMBOLICNAME).adapt(FrameworkWiring.class);
			Collection<BundleCapability> bundleIdentities = wiring.findProviders(ModuleContainer
					.createRequirement(IdentityNamespace.IDENTITY_NAMESPACE, Collections.emptyMap(), Collections.emptyMap()));
			for (BundleCapability next : bundleIdentities) {
				Bundle bundle = next.getRevision().getBundle();
				if ((bundle.getState() & AVAILABLE) != 0) {
					result.add(bundle.getSymbolicName());
				}
			}

			return result;
		}

	}

	/**
	 * The PDE helper instance gets all active bundles in the current PDE target platform.
	 */
	private static final class PDEHelper extends PlatformHelper {

		@Override
		Collection<String> getPlatformBundleIDs() {
			IPluginModelBase[] pluginModels = PluginRegistry.getActiveModels();
			Collection<String> result = new HashSet<>();

			for (IPluginModelBase next : pluginModels) {
				if (next.getBundleDescription() != null) {
					result.add(next.getBundleDescription().getSymbolicName());
				}
			}

			return result;
		}

	}

}
