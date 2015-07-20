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

public interface ADLConstants {

	/* Projects natures */
	final String FEATURE_NATURE = "org.eclipse.pde.FeatureNature";
	final String JAVA_NATURE = "org.eclipse.jdt.core.javanature";
	final String PLUGIN_NATURE = "org.eclipse.pde.PluginNature";

	/* Projects builders */
	final String FEATURE_BUILDER_ID = "org.eclipse.pde.FeatureBuilder";
	final String MANIFEST_BUILDER_ID = "org.eclipse.pde.ManifestBuilder";
	final String SCHEMA_BUILDER_ID = "org.eclipse.pde.SchemaBuilder";

	/* Plug-in container path */
	final Path REQUIRED_PLUGINS_CONTAINER_PATH = new Path("org.eclipse.pde.core.requiredPlugins");

	/* Plug-in stereotype */
	final String ECLIPSE_BUDDY_LOADER = "Eclipse-BuddyPolicy"; //$NON-NLS-1$
	final String ECLIPSE_BUNDLE_SHAPE = "Eclipse-BundleShape";
	final String ECLIPSE_GENERICCAPABILITY = "Eclipse-GenericCapability";
	final String ECLIPSE_GENERICREQUIRE = "Eclipse-GenericRequire";
	final String ECLIPSE_LAZYSTART = "Eclipse-LazyStart";
	final String ECLIPSE_PLATFORMFILTER = "Eclipse-PlatformFilter";
	final String ECLIPSE_REGISTERBUDDY = "Eclipse-RegisterBuddy";

	final String PLUGINS_PACKAGE = "Plugins";
	final String FEATURES_PACKAGE = "Features";
	final String EXTENSION_POINTS_PACKAGE = "ExtensionPoints";

	final int INFINITE_DEPTH_OPTION = -1;
}
