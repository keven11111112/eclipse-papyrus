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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.osgi.util.ManifestElement;
import org.eclipse.papyrus.adltool.reversible.AbstractReversible;
import org.eclipse.papyrus.adltool.reversible.Reversible;
import org.eclipse.papyrus.adltool.reversible.extension.ReversibleExtension;
import org.eclipse.papyrus.adltool.reversible.extensionpoint.ReversibleExtensionPoint;
import org.eclipse.papyrus.adltool.reversible.packages.ReversiblePackage;
import org.eclipse.papyrus.osgi.profile.OSGIStereotypes;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLFactory;
import org.osgi.framework.BundleException;
import org.osgi.framework.Constants;

/**
 * This abstract class provides the default implementation of the
 * {@link ReversiblePlugin} adapter.
 */
public abstract class AbstractPlugin extends AbstractReversible<Component> implements ReversiblePlugin {

	/**
	 * Map containing all the versions of reversible project or package.
	 */
	protected Map<Reversible<?>, StereotypeVersion> reversibleVersion;

	/**
	 * The list of packages exported by this plug-in.
	 */
	protected List<ReversiblePackage> exportedPackages;

	/**
	 * The list of packages imported by this plug-in.
	 */
	protected List<ReversiblePackage> importedPackages;

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

	public AbstractPlugin() {
		reversibleVersion = new HashMap<>();
	}

	@Override
	public List<ReversiblePackage> getExportedPackages() {
		return exportedPackages;
	}

	@Override
	public void setExportedPackages(List<ReversiblePackage> exportedPackages) {
		this.exportedPackages = exportedPackages;
	}

	@Override
	public List<ReversiblePackage> getImportedPackages() {
		return importedPackages;
	}

	@Override
	public void setImportedPackages(List<ReversiblePackage> importedPackages) {
		this.importedPackages = importedPackages;
	}

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
		return OSGIStereotypes.BUNDLE_REFERENCE;
	}

	@Override
	public Component createRepresentation() {
		return UMLFactory.eINSTANCE.createComponent();
	}

	public List<ManifestElement> extractManifestHeader(String header) {
		List<ManifestElement> result = new ArrayList<>();
		String value = getBundleValue(header);

		try {
			ManifestElement[] manifests = ManifestElement.parseHeader(header, value);

			if (manifests != null) {
				for (ManifestElement manifest : manifests) {
					result.add(manifest);
				}
			}
		} catch (BundleException e) {
			log.error(e);
		}

		return result;
	}

	/**
	 * Retrieves a list of stereotyped applications from a list of bundleId and
	 * store it in the representation's stereotype at the propertyName value.
	 *
	 * @param propertyName the name of the property to set the value.
	 * @param requireBundleIds the array of identifiable to set
	 * @param stereotypeIdentifier the stereotype qualified name of the EObject to save
	 */
	protected void setStereotypeValues(String propertyName, List<ManifestElement> requireBundleIds, String stereotypeIdentifier) {
		List<EObject> pluginReferences = new ArrayList<>();

		for (ManifestElement bundle : requireBundleIds) {
			// The stereotype takes stereotyped dependencies that are inside the representation
			Dependency dependency = getElement(bundle.getValue(), Dependency.class);

			if (dependency != null) {
				Stereotype dependencyStereotype = dependency.getAppliedStereotype(stereotypeIdentifier);

				if (dependencyStereotype != null) {
					EObject stereotypeApplication = dependency.getStereotypeApplication(dependencyStereotype);

					if (stereotypeApplication != null) {
						pluginReferences.add(stereotypeApplication);
					}
				}
			}
		}

		representation.setValue(stereotype, propertyName, pluginReferences);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void fillStereotype() {
		if (!applyStereotype()) {
			log.warn("(" + getType() +") " + getId() + " cannot fill the stereotype properties");
			return;
		}

		Map<String, String> stereotypeKeyValues = new HashMap<>();

		// ActivationPolicy
		stereotypeKeyValues.put(Constants.BUNDLE_ACTIVATIONPOLICY, OSGIStereotypes.BUNDLE_ACTIVATION_POLICY_ATT);
		// Activator
		stereotypeKeyValues.put(Constants.BUNDLE_ACTIVATOR, OSGIStereotypes.BUNDLE_ACTIVATOR_ATT);
		// Category
		stereotypeKeyValues.put(Constants.BUNDLE_CATEGORY, OSGIStereotypes.BUNDLE_CATEGORY_ATT);
		// Classpath
		stereotypeKeyValues.put(Constants.BUNDLE_CLASSPATH, OSGIStereotypes.BUNDLE_CLASSPATH_ATT);
		// Contact address
		stereotypeKeyValues.put(Constants.BUNDLE_CONTACTADDRESS, OSGIStereotypes.BUNDLE_CONTACTADDRESS_ATT);
		// Copyright
		stereotypeKeyValues.put(Constants.BUNDLE_COPYRIGHT, OSGIStereotypes.BUNDLE_COPYRIGHT_ATT);
		// Description
		stereotypeKeyValues.put(Constants.BUNDLE_DESCRIPTION, OSGIStereotypes.BUNDLE_DESCRIPTION_ATT);
		// DocURL
		stereotypeKeyValues.put(Constants.BUNDLE_DOCURL, OSGIStereotypes.BUNDLE_DOCURL_ATT);
		// Icon
		stereotypeKeyValues.put(Constants.BUNDLE_ICON, OSGIStereotypes.BUNDLE_ICON_ATT);
		// License
		stereotypeKeyValues.put(Constants.BUNDLE_LICENSE, OSGIStereotypes.BUNDLE_LICENSE_ATT);
		// Localization
		stereotypeKeyValues.put(Constants.BUNDLE_LOCALIZATION, OSGIStereotypes.BUNDLE_LOCALIZATION_ATT);
		// Manifest version
		stereotypeKeyValues.put(Constants.BUNDLE_MANIFESTVERSION, OSGIStereotypes.BUNDLE_MANIFESTVERSION_ATT);
		// Name
		stereotypeKeyValues.put(Constants.BUNDLE_NAME, OSGIStereotypes.BUNDLE_NAME_ATT);
		// NativeCode
		stereotypeKeyValues.put(Constants.BUNDLE_NATIVECODE, OSGIStereotypes.BUNDLE_NATIVECODE_ATT);
		// ProvideCapability
		stereotypeKeyValues.put(Constants.PROVIDE_CAPABILITY, OSGIStereotypes.BUNDLE_PROVIDE_CAPABILITY_ATT);
		// RequireCapability
		stereotypeKeyValues.put(Constants.REQUIRE_CAPABILITY, OSGIStereotypes.BUNDLE_REQUIRE_CAPABILITY_ATT);
		// RequiredExecutionEnvironment
		stereotypeKeyValues.put(Constants.BUNDLE_REQUIREDEXECUTIONENVIRONMENT, OSGIStereotypes.BUNDLE_REQUIREDEXECUTIONENVIRONMENT_ATT);
		// SymbolicName
		representation.setValue(stereotype, OSGIStereotypes.BUNDLE_SYMBOLICNAME_ATT, getId());
		// Update location
		stereotypeKeyValues.put(Constants.BUNDLE_UPDATELOCATION, OSGIStereotypes.BUNDLE_UPDATELOCATION_ATT);
		// Vendor
		stereotypeKeyValues.put(Constants.BUNDLE_VENDOR, OSGIStereotypes.BUNDLE_VENDOR_ATT);
		// Version
		stereotypeKeyValues.put(Constants.BUNDLE_VERSION, OSGIStereotypes.BUNDLE_VERSION_ATT);

		for (Map.Entry<String, String> entry : stereotypeKeyValues.entrySet()) {
			String value = getBundleValue(entry.getKey());
			if (value != null && value.length() > 0) {
				representation.setValue(stereotype, entry.getValue(), value);
			}
		}

		// Singleton
		representation.setValue(stereotype, OSGIStereotypes.BUNDLE_ISSINGLETON_ATT, isSingleton());
		// ExportPackage
		List<ManifestElement> exportedPackages = extractManifestHeader(Constants.EXPORT_PACKAGE);
		setStereotypeValues(OSGIStereotypes.BUNDLE_EXPORTPACKAGE_ATT, exportedPackages, OSGIStereotypes.PACKAGE_REFERENCE);

		// ImportPackage
		List<ManifestElement> importedPackages = extractManifestHeader(Constants.IMPORT_PACKAGE);
		setStereotypeValues(OSGIStereotypes.BUNDLE_IMPORTPACKAGE_ATT, importedPackages, OSGIStereotypes.PACKAGE_REFERENCE);

		// RequireBundle
		List<ManifestElement> requireBundleIds = extractManifestHeader(Constants.REQUIRE_BUNDLE);
		setStereotypeValues(OSGIStereotypes.BUNDLE_REQUIREBUNDLE_ATT, requireBundleIds, OSGIStereotypes.BUNDLE_REFERENCE);

		// DynamicImportPackage
		// TODO

		// FragmentHost
		// TODO
	}

	@Override
	public StereotypeVersion getReversibleVersion(Reversible<?> reversible) {
		return reversibleVersion.get(reversible);
	}

	@Override
	public void setReversibleVersion(Reversible<?> reversible, StereotypeVersion version) {
		reversibleVersion.put(reversible, version);
	}

}
