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
package org.eclipse.papyrus.osgi.profile;

/**
 * This class contains all string to manipulate stereotypedElement
 */
public class OSGIStereotypes {

	/**
	 * OSGI profile name
	 */
	public static final String OSGI = "OSGI";

	/**
	 * OSGI Module layer profile name
	 */
	public static final String OSGI_MODULE_LAYER = "ModuleLayer";

	/**
	 * Qualified name of the Bundle
	 */
	public static final String BUNDLE = "OSGI::ModuleLayer::Bundle";

	/**
	 * Name of property hasLazyActivationPolicy of the stereotype Bundle
	 */
	public static final String BUNDLE_ACTIVATION_POLICY_ATT = "activationPolicy";

	/**
	 * Name of property activator of the stereotype Bundle
	 */
	public static final String BUNDLE_ACTIVATOR_ATT = "activator";

	/**
	 * Name of property category of the stereotype Bundle
	 */
	public static final String BUNDLE_CATEGORY_ATT = "category";

	/**
	 * Name of literal osgi of the Enumeration Bundle-Category
	 */
	public static final String BUNDLE_CATEGORY_OSGI_ENUM = "osgi";

	/**
	 * Name of literal test of the Enumeration Bundle-Category
	 */
	public static final String BUNDLE_CATEGORY_TEST_ENUM = "test";

	/**
	 * Name of literal nursery of the Enumeration Bundle-Category
	 */
	public static final String BUNDLE_CATEGORY_NURSERY_ENUM = "nursery";

	/**
	 * Name of property classPath of the stereotype Bundle
	 */
	public static final String BUNDLE_CLASSPATH_ATT = "classPath";

	/**
	 * Name of property contactAddress of the stereotype Bundle
	 */
	public static final String BUNDLE_CONTACTADDRESS_ATT = "contactAddress";

	/**
	 * Name of property copyright of the stereotype Bundle
	 */
	public static final String BUNDLE_COPYRIGHT_ATT = "copyright";

	/**
	 * Name of property description of the stereotype Bundle
	 */
	public static final String BUNDLE_DESCRIPTION_ATT = "description";

	/**
	 * Name of property docURL of the stereotype Bundle
	 */
	public static final String BUNDLE_DOCURL_ATT = "docURL";

	/**
	 * Name of property dynamicImportPackage of the stereotype Bundle
	 */
	public static final String BUNDLE_DYNAMICIMPORTPACKAGE_ATT = "dynamicImportPackage";

	/**
	 * Name of property exportPackage of the stereotype Bundle
	 */
	public static final String BUNDLE_EXPORTPACKAGE_ATT = "exportPackage";

	/**
	 * Name of property fragmentHost of the stereotype Bundle
	 */
	public static final String BUNDLE_FRAGMENTHOST_ATT = "fragmentHost";

	/**
	 * Name of property icon of the stereotype Bundle
	 */
	public static final String BUNDLE_ICON_ATT = "icon";

	/**
	 * Name of property importPackage of the stereotype Bundle
	 */
	public static final String BUNDLE_IMPORTPACKAGE_ATT = "importPackage";

	/**
	 * Name of property license of the stereotype Bundle
	 */
	public static final String BUNDLE_LICENSE_ATT = "license";

	/**
	 * Name of property localization of the stereotype Bundle
	 */
	public static final String BUNDLE_LOCALIZATION_ATT = "localization";

	/**
	 * Name of the property main class of the stereotype Bundle
	 */
	public static final String BUNDLE_MAIN_CLASS_ATT = "mainClass";

	/**
	 * Name of property manifestVersion of the stereotype Bundle
	 */
	public static final String BUNDLE_MANIFESTVERSION_ATT = "manifestVersion";

	/**
	 * Name of property name of the stereotype Bundle
	 */
	public static final String BUNDLE_NAME_ATT = "name";

	/**
	 * Name of property nativeCode of the stereotype Bundle
	 */
	public static final String BUNDLE_NATIVECODE_ATT = "nativeCode";

	/**
	 * Name of property provideCapability of the stereotype Bundle
	 */
	public static final String BUNDLE_PROVIDE_CAPABILITY_ATT = "provideCapability";

	/**
	 * Name of property requireBundle of the stereotype Bundle
	 */
	public static final String BUNDLE_REQUIREBUNDLE_ATT = "requireBundle";

	/**
	 * Name of property requireCapability of the stereotype Bundle
	 */
	public static final String BUNDLE_REQUIRE_CAPABILITY_ATT = "requireCapability";

	/**
	 * Name of property requiredExecutionEnvironment of the stereotype Bundle
	 */
	public static final String BUNDLE_REQUIREDEXECUTIONENVIRONMENT_ATT = "requiredExecutionEnvironment";

	/**
	 * Name of property serviceComponent of the stereotype Bundle
	 */
	public static final String BUNDLE_SERVICE_COMPONENT_ATT = "serviceComponent";

	/**
	 * Name of property symbolicName of the stereotype Bundle
	 */
	public static final String BUNDLE_SYMBOLICNAME_ATT = "symbolicName";

	/**
	 * Name of property updateLocation of the stereotype Bundle
	 */
	public static final String BUNDLE_UPDATELOCATION_ATT = "updateLocation";

	/**
	 * Name of property vendor of the stereotype Bundle
	 */
	public static final String BUNDLE_VENDOR_ATT = "vendor";

	/**
	 * Name of property version of the stereotype Bundle
	 */
	public static final String BUNDLE_VERSION_ATT = "version";

	/**
	 * Name of property isSingleton of the stereotype Bundle
	 */
	public static final String BUNDLE_ISSINGLETON_ATT = "isSingleton";

	/**
	 * Name of property base_Component of the stereotype Bundle
	 */
	public static final String BUNDLE_BASE_COMPONENT_ATT = "base_Component";

	/**
	 * Qualified name of the VersionRange
	 */
	public static final String VERSION_RANGE = "OSGI::ModuleLayer::VersionRange";

	/**
	 * Name of property floor of the stereotype VersionRange
	 */
	public static final String VERSIONRANGE_FLOOR_ATT = "floor";

	/**
	 * Name of property ceiling of the stereotype VersionRange
	 */
	public static final String VERSIONRANGE_CEILING_ATT = "ceiling";

	/**
	 * Name of property atleast of the stereotype VersionRange
	 */
	public static final String VERSIONRANGE_ATLEAST_ATT = "atleast";

	/**
	 * Name of property includefloor of the stereotype VersionRange
	 */
	public static final String VERSIONRANGE_INCLUDEFLOOR_ATT = "includefloor";

	/**
	 * Name of property includeCeiling of the stereotype VersionRange
	 */
	public static final String VERSIONRANGE_INCLUDECEILING_ATT = "includeCeiling";

	/**
	 * Qualified name of the BundleReference
	 */
	public static final String BUNDLE_REFERENCE = "OSGI::ModuleLayer::BundleReference";

	/**
	 * Name of property base_Dependency of the stereotype BundleReference
	 */
	public static final String BUNDLEREFERENCE_BASE_DEPENDENCY_ATT = "base_Dependency";

	/**
	 * Qualified name of the PackageReference
	 */
	public static final String PACKAGE_REFERENCE = "OSGI::ModuleLayer::PackageReference";

	/**
	 * Name of property base_Dependency of the stereotype PackageReference
	 */
	public static final String PACKAGEREFERENCE_BASE_DEPENDENCY_ATT = "base_Dependency";

	/**
	 * Qualified name of the ExportedPackage
	 */
	public static final String EXPORTED_PACKAGE_STEREOTYPE = "OSGI::ModuleLayer::ExportedPackage";

	/**
	 * Qualified name of the ImportedPackage
	 */
	public static final String IMPORTED_PACKAGE_STEREOTYPE = "OSGI::ModuleLayer::ImportedPackage";

	/**
	 * Name of property base_Package of the stereotype ExportedPackage
	 */
	public static final String EXPORTEDPACKAGE_BASE_PACKAGE_ATT = "base_Package";

	/**
	 * Private constructor to prevent instantiation.
	 */
	private OSGIStereotypes() {
	}
}
