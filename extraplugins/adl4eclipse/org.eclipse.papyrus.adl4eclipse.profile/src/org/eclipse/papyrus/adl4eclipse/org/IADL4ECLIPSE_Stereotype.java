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
public interface IADL4ECLIPSE_Stereotype {

	/** Name of the profile */
	public static final String ADL4ECLIPSE = "ADL4Eclipse";

	/** Qualified name of the stereotype Plug-in */
	public static final String PLUGIN_STEREOTYPE = "ADL4Eclipse::Plugin";
	/** Name of property isIncubation of the stereotype Plug-in */
	public static final String PLUGIN_ISINCUBATION_ATT = "isIncubation";
	/** Name of property lazyStart of the stereotype Plug-in */
	public static final String PLUGIN_LAZYSTART_ATT = "lazyStart";
	/** Name of property lazyStartException of the stereotype Plug-in */
	public static final String PLUGIN_LAZYSTARTEXCEPTION_ATT = "lazyStartException";
	/** Name of property platformFilter of the stereotype Plug-in */
	public static final String PLUGIN_PLATFORMFILTER_ATT = "platformFilter";
	/** Name of property buddyPolicy of the stereotype Plug-in */
	public static final String PLUGIN_BUDDYPOLICY_ATT = "buddyPolicy";
	/** Name of property extensibleAPI of the stereotype Plug-in */
	public static final String PLUGIN_EXTENSIBLEAPI_ATT = "extensibleAPI";
	/** Name of property bundleShape of the stereotype Plug-in */
	public static final String PLUGIN_BUNDLESHAPE_ATT = "bundleShape";
	/** Name of property capability of the stereotype Plug-in */
	public static final String PLUGIN_CAPABILITY_ATT = "capability";
	/** Name of property requireCapability of the stereotype Plug-in */
	public static final String PLUGIN_REQUIRECAPABILITY_ATT = "requireCapability";
	/** Name of property genericCapabilityAlias of the stereotype Plug-in */
	public static final String PLUGIN_GENERICCAPABILITYALIAS_ATT = "genericCapabilityAlias";

	public static final String PLUGIN_REQUIRE_BUNDLE_ATT = "requireBundle";

	/** Qualified name of the stereotype EclipseExportedPackage */
	public static final String ECLIPSE_EXPORTEDPACKAGE_STEREOTYPE = "ADL4Eclipse::EclipseExportedPackage";
	/** Name of property isInternal of the stereotype EclipseExportedPackage */
	public static final String ECLIPSEEXPORTEDPACKAGE_ISINTERNAL_ATT = "isInternal";
	/** Name of property friend of the stereotype EclipseExportedPackage */
	public static final String ECLIPSEEXPORTEDPACKAGE_FRIEND_ATT = "friend";
	/** Name of literal dependent of the Enumeration BuddyPolicyEnumeration */
	public static final String BUDDYPOLICYENUMERATION_DEPENDENT_ENUM = "dependent";
	/** Name of literal global of the Enumeration BuddyPolicyEnumeration */
	public static final String BUDDYPOLICYENUMERATION_GLOBAL_ENUM = "global";
	/** Name of literal registered of the Enumeration BuddyPolicyEnumeration */
	public static final String BUDDYPOLICYENUMERATION_REGISTERED_ENUM = "registered";
	/** Name of literal app of the Enumeration BuddyPolicyEnumeration */
	public static final String BUDDYPOLICYENUMERATION_APP_ENUM = "app";
	/** Name of literal ext of the Enumeration BuddyPolicyEnumeration */
	public static final String BUDDYPOLICYENUMERATION_EXT_ENUM = "ext";
	/** Name of literal boot of the Enumeration BuddyPolicyEnumeration */
	public static final String BUDDYPOLICYENUMERATION_BOOT_ENUM = "boot";
	/** Name of literal parent of the Enumeration BuddyPolicyEnumeration */
	public static final String BUDDYPOLICYENUMERATION_PARENT_ENUM = "parent";
	/** Name of literal jar of the Enumeration BundleShapeEnumeration */
	public static final String BUNDLESHAPEENUMERATION_JAR_ENUM = "jar";
	/** Name of literal dir of the Enumeration BundleShapeEnumeration */
	public static final String BUNDLESHAPEENUMERATION_DIR_ENUM = "dir";

	/** Qualified name of the stereotype Feature */
	public static final String FEATURE_STEREOTYPE = "ADL4Eclipse::Feature";
	/** Name of property base_Class of the stereotype Feature */
	public static final String FEATURE_BASE_CLASS_ATT = "base_Class";
	/** Name of property description of the stereotype Feature */
	public static final String FEATURE_DESCRIPTION_ATT = "description";
	/** Name of property copyright of the stereotype Feature */
	public static final String FEATURE_COPYRIGHT_ATT = "copyright";
	/** Name of property license of the stereotype Feature */
	public static final String FEATURE_LICENSE_ATT = "license";
	/** Name of property provider of the stereotype Feature */
	public static final String FEATURE_PROVIDER_ATT = "provider";
	/** Name of property image of the stereotype Feature */
	public static final String FEATURE_IMAGE_ATT = "image";
	/** Name of property url of the stereotype Feature */
	public static final String FEATURE_URL_ATT = "url";
	/** Name of property plugins of the stereotype Feature */
	public static final String FEATURE_PLUGINS_ATT = "plugins";
	/** Name of property includedFeatures of the stereotype Feature */
	public static final String FEATURE_INCLUDEDFEATURES_ATT = "includedFeatures";
	/** Name of property importedFeatures of the stereotype Feature */
	public static final String FEATURE_IMPORTEDFEATURES_ATT = "importedFeatures";
	/** Name of property label of the stereotype Feature */
	public static final String FEATURE_LABEL_ATT = "label";
	/** Name of property id of the stereotype Feature */
	public static final String FEATURE_ID_ATT = "id";
	/** Name of property version of the stereotype Feature */
	public static final String FEATURE_VERSION_ATT = "version";

	/** Qualified name of the stereotype Extension */
	public static final String EXTENSION_STEREOTYPE = "ADL4Eclipse::Extension";

	/** Extension points **/
	public static final String EXTENSION_POINT_STEREOTYPE = "ADL4Eclipse::ExtensionPoint";
	// TODO: ExtensionPoint stereotype properties

	public static final String ELEMENT_STEREOTYPE = "ADL4Eclipse::Element";

}
