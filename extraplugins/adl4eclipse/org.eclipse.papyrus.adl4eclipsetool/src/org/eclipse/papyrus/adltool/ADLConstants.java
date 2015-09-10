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
package org.eclipse.papyrus.adltool;

import org.eclipse.core.runtime.Path;

public class ADLConstants {

	/* Projects natures */
	public static final String FEATURE_NATURE = "org.eclipse.pde.FeatureNature";
	public static final String JAVA_NATURE = "org.eclipse.jdt.core.javanature";
	public static final String PLUGIN_NATURE = "org.eclipse.pde.PluginNature";

	/* Projects builders */
	public static final String FEATURE_BUILDER_ID = "org.eclipse.pde.FeatureBuilder";
	public static final String MANIFEST_BUILDER_ID = "org.eclipse.pde.ManifestBuilder";
	public static final String SCHEMA_BUILDER_ID = "org.eclipse.pde.SchemaBuilder";

	/* Plug-in container path */
	public static final Path REQUIRED_PLUGINS_CONTAINER_PATH = new Path("org.eclipse.pde.core.requiredPlugins");

	/* Plug-in stereotype */
	public static final String ECLIPSE_BUDDY_POLICY = "Eclipse-BuddyPolicy"; //$NON-NLS-1$
	public static final String ECLIPSE_BUNDLE_SHAPE = "Eclipse-BundleShape";

	public static final String ECLIPSE_GENERIC_CAPABILITY = "Eclipse-GenericCapability";
	public static final String ECLIPSE_GENERIC_REQUIRE = "Eclipse-GenericRequire";
	public static final String ECLIPSE_LAZYSTART = "Eclipse-LazyStart";

	public static final String ECLIPSE_PLATFORMFILTER = "Eclipse-PlatformFilter";
	public static final String ECLIPSE_REGISTERBUDDY = "Eclipse-RegisterBuddy";

	public static final String PLUGINS_PACKAGE = "Plugins";
	public static final String FEATURES_PACKAGE = "Features";
	public static final String EXTENSION_POINTS_PACKAGE = "ExtensionPoints";

	public static final int INFINITE_DEPTH_OPTION = -1;

	/**
	 * Private constructor to prevent instantiation.
	 */
	private ADLConstants() {
	}

}
