/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.adl4eclipse.org;

/** set of constant to manipulate stereotype **/
public class ADL4Eclipse_Stereotypes {

	/**
	 * Name of the profile
	 */
	public static final String ADL4ECLIPSE = "ADL4Eclipse";

	/**
	 * Qualified name of the stereotype Plug-in
	 */
	public static final String PLUGIN_STEREOTYPE = "ADL4Eclipse::Plugin";

	/**
	 * Name of property isIncubation of the stereotype Plug-in
	 */
	public static final String PLUGIN_ISINCUBATION_ATT = "isIncubation";

	/**
	 * Name of property lazyStart of the stereotype Plug-in
	 */
	public static final String PLUGIN_LAZYSTART_ATT = "lazyStart";

	/**
	 * Name of property lazyStartException of the stereotype Plug-in
	 */
	public static final String PLUGIN_LAZYSTARTEXCEPTION_ATT = "lazyStartExceptions";

	/**
	 * Name of property platformFilter of the stereotype Plug-in
	 */
	public static final String PLUGIN_PLATFORMFILTER_ATT = "platformFilter";

	/**
	 * Name of property buddyPolicy of the stereotype Plug-in
	 */
	public static final String PLUGIN_BUDDYPOLICY_ATT = "buddyPolicy";

	/**
	 * Name of property extensibleAPI of the stereotype Plug-in
	 */
	public static final String PLUGIN_EXTENSIBLEAPI_ATT = "extensibleAPI";

	/**
	 * Name of property bundleShape of the stereotype Plug-in
	 */
	public static final String PLUGIN_BUNDLESHAPE_ATT = "bundleShape";

	/**
	 * Name of property capability of the stereotype Plug-in
	 */
	public static final String PLUGIN_CAPABILITY_ATT = "capability";

	/**
	 * Name of property requireCapability of the stereotype Plug-in
	 */
	public static final String PLUGIN_REQUIRECAPABILITY_ATT = "requireCapability";

	/**
	 * Name of property genericCapabilityAlias of the stereotype Plug-in
	 */
	public static final String PLUGIN_GENERICCAPABILITYALIAS_ATT = "genericCapabilityAlias";

	/**
	 * Name of property requireBundle of the stereotype Plug-in
	 */
	//public static final String PLUGIN_REQUIRE_BUNDLE_ATT = "requireBundle";

	/**
	 * Qualified name of the stereotype EclipseExportedPackage
	 */
	public static final String ECLIPSE_EXPORTED_PACKAGE_STEREOTYPE = "ADL4Eclipse::EclipseExportedPackage";

	/**
	 * Name of property isInternal of the stereotype EclipseExportedPackage
	 */
	public static final String ECLIPSE_EXPORTED_PACKAGE_ISINTERNAL_ATT = "isInternal";

	/**
	 * Name of property friend of the stereotype EclipseExportedPackage
	 */
	public static final String ECLIPSE_EXPORTED_PACKAGE_FRIEND_ATT = "friend";

	/**
	 * Qualified name of the stereotype EclipseImportedPackage
	 */
	public static final String ECLIPSE_IMPORTED_PACKAGE_STEREOTYPE = "ADL4Eclipse::EclipseImportedPackage";

	/**
	 * Name of literal dependent of the Enumeration BuddyPolicyEnumeration
	 */
	public static final String BUDDYPOLICYENUMERATION_DEPENDENT_ENUM = "dependent";

	/**
	 * Name of literal global of the Enumeration BuddyPolicyEnumeration
	 */
	public static final String BUDDYPOLICYENUMERATION_GLOBAL_ENUM = "global";

	/**
	 * Name of literal registered of the Enumeration BuddyPolicyEnumeration
	 */
	public static final String BUDDYPOLICYENUMERATION_REGISTERED_ENUM = "registered";

	/**
	 * Name of literal app of the Enumeration BuddyPolicyEnumeration
	 */
	public static final String BUDDYPOLICYENUMERATION_APP_ENUM = "app";

	/**
	 * Name of literal ext of the Enumeration BuddyPolicyEnumeration
	 */
	public static final String BUDDYPOLICYENUMERATION_EXT_ENUM = "ext";

	/**
	 * Name of literal boot of the Enumeration BuddyPolicyEnumeration
	 */
	public static final String BUDDYPOLICYENUMERATION_BOOT_ENUM = "boot";

	/**
	 * Name of literal parent of the Enumeration BuddyPolicyEnumeration
	 */
	public static final String BUDDYPOLICYENUMERATION_PARENT_ENUM = "parent";

	/**
	 * Name of literal jar of the Enumeration BundleShapeEnumeration
	 */
	public static final String BUNDLESHAPEENUMERATION_JAR_ENUM = "jar";

	/**
	 * Name of literal dir of the Enumeration BundleShapeEnumeration
	 */
	public static final String BUNDLESHAPEENUMERATION_DIR_ENUM = "dir";

	/**
	 * Qualified name of the Feature
	 */
	public static final String FEATURE_STEREOTYPE = "ADL4Eclipse::Feature";

	/**
	 * Name of property base_Class of the stereotype Feature
	 */
	public static final String FEATURE_BASE_CLASS_ATT = "base_Class";

	/**
	 * Name of property id of the stereotype Feature
	 */
	public static final String FEATURE_ID_ATT = "id";

	/**
	 * Name of property label of the stereotype Feature
	 */
	public static final String FEATURE_LABEL_ATT = "label";

	/**
	 * Name of property version of the stereotype Feature
	 */
	public static final String FEATURE_VERSION_ATT = "version";

	/**
	 * Name of property provider of the stereotype Feature
	 */
	public static final String FEATURE_PROVIDER_ATT = "provider";

	/**
	 * Name of property description of the stereotype Feature
	 */
	public static final String FEATURE_DESCRIPTION_ATT = "description";

	/**
	 * Name of property description URL of the stereotype Feature
	 */
	public static final String FEATURE_DESCRIPTION_URL_ATT = "description_url";

	/**
	 * Name of property copyright of the stereotype Feature
	 */
	public static final String FEATURE_COPYRIGHT_ATT = "copyright";

	/**
	 * Name of property copyright URL of the stereotype Feature
	 */
	public static final String FEATURE_COPYRIGHT_URL_ATT = "copyright_url";

	/**
	 * Name of property license of the stereotype Feature
	 */
	public static final String FEATURE_LICENSE_ATT = "license";

	/**
	 * Name of property license URL of the stereotype Feature
	 */
	public static final String FEATURE_LICENSE_URL_ATT = "license_url";

	/**
	 * Name of property url of the stereotype Feature
	 */
	public static final String FEATURE_URL_ATT = "url";

	/**
	 * Name of property url_label of the stereotype Feature
	 */
	public static final String FEATURE_URL_LABEL_ATT = "url_label";

	/**
	 * Name of property operatingSystem of the stereotype Feature
	 */
	public static final String FEATURE_OS_ATT = "operatingSystem";

	/**
	 * Name of property window of the stereotype Feature
	 */
	public static final String FEATURE_WS_ATT = "windowSystem";

	/**
	 * Name of property languages of the stereotype Feature
	 */
	public static final String FEATURE_LANGUAGES_ATT = "languages";

	/**
	 * Name of property architecture of the stereotype Feature
	 */
	public static final String FEATURE_ARCHITECTURE_ATT = "architecture";

	/**
	 * Name of property plugins of the stereotype Feature
	 */
	public static final String FEATURE_PLUGINS_ATT = "plugins";

	/**
	 * Name of property includedFeatures of the stereotype Feature
	 */
	public static final String FEATURE_FEATURE_DEPENDENCIES_ATT = "featureDependencies";

	/**
	 * Name of property includedFeatures of the stereotype Feature
	 */
	public static final String FEATURE_PLUGIN_DEPENDENCIES_ATT = "pluginDependencies";

	/**
	 * Name of property importedFeatures of the stereotype Feature
	 */
	public static final String FEATURE_INCLUDED_FEATURES_ATT = "includedFeatures";

	/**
	 * Qualified name of the FeatureReference
	 */
	public static final String FEATURE_REFERENCE = "ADL4Eclipse::FeatureReference";

	/**
	 * Qualified name of the ExtensionReference
	 */
	public static final String EXTENSION_REFERENCE = "ADL4Eclipse::ExtensionReference";

	/**
	 * Qualified name of the ExtensionPointReference
	 */
	public static final String EXTENSION_POINT_REFERENCE = "ADL4Eclipse::ExtensionPointReference";

	/**
	 * Qualified name of the stereotype Extension
	 */
	public static final String EXTENSION_STEREOTYPE = "ADL4Eclipse::Extension";

	/**
	 * Extension points
	 */
	public static final String EXTENSION_POINT_STEREOTYPE = "ADL4Eclipse::ExtensionPoint";

	// TODO: ExtensionPoint stereotype properties

	public static final String ELEMENT_STEREOTYPE = "ADL4Eclipse::Element";

	private ADL4Eclipse_Stereotypes() {
		// Private constructor to prevent instantiation
	}

}
