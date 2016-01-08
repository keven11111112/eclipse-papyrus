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

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.osgi.service.resolver.VersionRange;
import org.eclipse.papyrus.adl4eclipse.org.ADL4Eclipse_Stereotypes;
import org.eclipse.papyrus.adltool.ADL4EclipseUtils;
import org.eclipse.papyrus.adltool.reversible.AbstractReversible;
import org.eclipse.papyrus.adltool.reversible.Reversible;
import org.eclipse.papyrus.adltool.reversible.factory.ReversibleFactory;
import org.eclipse.papyrus.osgi.profile.OSGIStereotypes;
import org.eclipse.pde.core.IIdentifiable;
import org.eclipse.pde.internal.core.ifeature.IFeature;
import org.eclipse.pde.internal.core.ifeature.IFeatureChild;
import org.eclipse.pde.internal.core.ifeature.IFeatureImport;
import org.eclipse.pde.internal.core.ifeature.IFeatureInfo;
import org.eclipse.pde.internal.core.ifeature.IFeaturePlugin;
import org.eclipse.pde.internal.core.ifeature.IFeatureURL;
import org.eclipse.pde.internal.core.ifeature.IFeatureURLElement;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * This class is a reversible adapter of a feature project.
 */
@SuppressWarnings("restriction")
public class ReversibleFeature extends AbstractReversible<Component> implements ReversibleProject {

	private Map<Reversible<?>, StereotypeVersion> dependencyVersions;

	private IFeature feature;

	/**
	 * Constructor.
	 *
	 * @param feature
	 */
	public ReversibleFeature(IFeature feature) {
		this.feature = feature;

		dependencyVersions = new HashMap<>();
	}

	@Override
	public String getId() {
		return feature.getId();
	}

	@Override
	public String getStereotypeName() {
		return ADL4Eclipse_Stereotypes.FEATURE_STEREOTYPE;
	}

	@Override
	public String getDependencyStereotypeName() {
		return ADL4Eclipse_Stereotypes.FEATURE_REFERENCE;
	}

	@Override
	public Type getType() {
		return Type.FEATURE;
	}

	@Override
	public Component createRepresentation() {
		return UMLFactory.eINSTANCE.createComponent();
	}

	@Override
	public List<ReversibleProject> getDependencies() {
		List<ReversibleProject> dependencies = new ArrayList<>();

		for (IFeatureChild include : feature.getIncludedFeatures()) {
			ReversibleProject reversibleFeature = ReversibleFactory.getInstance().getFeature(include.getId());

			if (reversibleFeature != null) {
				dependencies.add(reversibleFeature);
				VersionRange versionRange = new VersionRange(include.getVersion());
				dependencyVersions.put(reversibleFeature, new StereotypeVersion(versionRange));
			} else {
				log.warn(getType() + " \"" + getId() + "\": cannot find child " + include.getId());
			}
		}

		for (IFeatureImport require : feature.getImports()) {
			ReversibleProject reversibleProject = ReversibleFactory.getInstance().getFeature(require.getId());

			if (reversibleProject == null) {
				reversibleProject = ReversibleFactory.getInstance().getPlugin(require.getId());
			}

			if (reversibleProject != null) {
				dependencies.add(reversibleProject);
				dependencyVersions.put(reversibleProject, new StereotypeVersion(require.getVersion()));
			} else {
				log.warn(getType() + " \"" + getId() + "\": cannot find child " + require.getId());
			}
		}

		for (IFeaturePlugin plugin : feature.getPlugins()) {
			ReversibleProject reversiblePlugin = ReversibleFactory.getInstance().getPlugin(plugin.getId());

			if (reversiblePlugin != null) {
				dependencies.add(reversiblePlugin);
				dependencyVersions.put(reversiblePlugin, new StereotypeVersion(plugin.getVersion()));
			} else {
				log.warn(getType() + " \"" + getId() + "\": cannot find child " + plugin.getId());
			}
		}

		return dependencies;
	}

	@Override
	public String getDescription() {
		IFeatureInfo featureInfo = feature.getFeatureInfo(IFeature.INFO_DESCRIPTION);

		if (featureInfo != null) {
			return featureInfo.getDescription();
		}

		return null;
	}

	@Override
	public Image getImage() {
		return ADL4EclipseUtils.getImage("img/feature_obj.gif");
	}

	@Override
	public void fillStereotype() {
		if (!applyStereotype()) {
			log.warn(getId() + ": cannot fill the stereotype properties");
			return;
		}

		// Id
		String id = feature.getId();
		representation.setValue(stereotype, ADL4Eclipse_Stereotypes.FEATURE_ID_ATT, id);

		// Label
		String label = feature.getLabel();
		representation.setValue(stereotype, ADL4Eclipse_Stereotypes.FEATURE_LABEL_ATT, label);

		// Version
		String version = feature.getVersion();
		representation.setValue(stereotype, ADL4Eclipse_Stereotypes.FEATURE_VERSION_ATT, version);

		// Provider
		String provider = feature.getProviderName();
		representation.setValue(stereotype, ADL4Eclipse_Stereotypes.FEATURE_PROVIDER_ATT, provider);

		IFeatureInfo featureInfoDescription = feature.getFeatureInfo(IFeature.INFO_DESCRIPTION);
		if (featureInfoDescription != null) {
			// Description
			String description = getDescription();
			representation.setValue(stereotype, ADL4Eclipse_Stereotypes.FEATURE_DESCRIPTION_ATT, description);

			// Description URL
			String descriptionURL = featureInfoDescription.getURL();
			representation.setValue(stereotype, ADL4Eclipse_Stereotypes.FEATURE_DESCRIPTION_URL_ATT, descriptionURL);
		}

		IFeatureInfo featureInfoCopyright = feature.getFeatureInfo(IFeature.INFO_COPYRIGHT);
		if (featureInfoCopyright != null) {
			// Copyright
			String copyright = feature.getFeatureInfo(IFeature.INFO_COPYRIGHT).getDescription();
			representation.setValue(stereotype, ADL4Eclipse_Stereotypes.FEATURE_COPYRIGHT_ATT, copyright);

			// Copyright URL
			String copyrightURL = feature.getFeatureInfo(IFeature.INFO_COPYRIGHT).getURL();
			representation.setValue(stereotype, ADL4Eclipse_Stereotypes.FEATURE_COPYRIGHT_URL_ATT, copyrightURL);
		}

		IFeatureInfo featureInfoLicense = feature.getFeatureInfo(IFeature.INFO_LICENSE);
		if (featureInfoLicense != null) {
			// License
			String license = featureInfoLicense.getDescription();
			representation.setValue(stereotype, ADL4Eclipse_Stereotypes.FEATURE_LICENSE_ATT, license);

			// License URL
			String licenseURL = feature.getFeatureInfo(IFeature.INFO_LICENSE).getURL();
			representation.setValue(stereotype, ADL4Eclipse_Stereotypes.FEATURE_LICENSE_URL_ATT, licenseURL);
		}

		// URL
		IFeatureURL featureUrl = feature.getURL();
		if (featureUrl != null) {

			IFeatureURLElement updateUrl = featureUrl.getUpdate();
			if (updateUrl != null) {
				// URL label
				representation.setValue(stereotype, ADL4Eclipse_Stereotypes.FEATURE_URL_LABEL_ATT, updateUrl.getLabel());

				URL url = updateUrl.getURL();
				if (url != null) {
					// URL address
					representation.setValue(stereotype, ADL4Eclipse_Stereotypes.FEATURE_URL_ATT, url.toString());
				}
			}
		}

		// Operating system
		representation.setValue(stereotype, ADL4Eclipse_Stereotypes.FEATURE_OS_ATT, feature.getOS());

		// Window system
		representation.setValue(stereotype, ADL4Eclipse_Stereotypes.FEATURE_WS_ATT, feature.getWS());

		// Language
		representation.setValue(stereotype, ADL4Eclipse_Stereotypes.FEATURE_LANGUAGES_ATT, feature.getNL());

		// Architecture
		representation.setValue(stereotype, ADL4Eclipse_Stereotypes.FEATURE_ARCHITECTURE_ATT, feature.getArch());

		// Plug-ins
		setStereotypeValues(ADL4Eclipse_Stereotypes.FEATURE_PLUGINS_ATT, feature.getPlugins(), OSGIStereotypes.BUNDLE_REFERENCE);

		// Included Features
		setStereotypeValues(ADL4Eclipse_Stereotypes.FEATURE_INCLUDED_FEATURES_ATT, feature.getIncludedFeatures(), ADL4Eclipse_Stereotypes.FEATURE_REFERENCE);

		// Imported Features
		setStereotypeValues(ADL4Eclipse_Stereotypes.FEATURE_FEATURE_DEPENDENCIES_ATT, feature.getImports(), ADL4Eclipse_Stereotypes.FEATURE_REFERENCE);

		// Imported Plug-ins
		setStereotypeValues(ADL4Eclipse_Stereotypes.FEATURE_PLUGIN_DEPENDENCIES_ATT, feature.getImports(), OSGIStereotypes.BUNDLE_REFERENCE);
	}

	/**
	 * Retrieves a list of stereotyped applications from an array of identifiable and
	 * store it in the feature's stereotype at the propertyName value.
	 *
	 * @param propertyName the name of the property to set the value.
	 * @param identifiables the array of identifiable to set
	 * @param stereotypeIdentifier the stereotype qualified name of the EObject to save
	 */
	private void setStereotypeValues(String propertyName, IIdentifiable[] identifiables, String stereotypeIdentifier) {
		List<EObject> pluginReferences = new ArrayList<>();

		for (IIdentifiable identifiable : identifiables) {
			// The stereotype takes stereotyped dependencies that are inside the representation
			Dependency dependency = getElement(identifiable.getId(), Dependency.class);

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

	@Override
	public StereotypeVersion getReversibleVersion(Reversible<?> reversibleProject) {
		return dependencyVersions.get(reversibleProject);
	}

	@Override
	public void setReversibleVersion(Reversible<?> reversible, StereotypeVersion version) {
		dependencyVersions.put(reversible, version);

	}

	public List<ReversibleProject> getIncludedReversibleFeatures() {
		if (feature.getIncludedFeatures().length > 0) {
			List<ReversibleProject> includedFeatures = new ArrayList<ReversibleProject>();
			for (IFeatureChild includedFeature : feature.getIncludedFeatures()) {
				includedFeatures.add(ReversibleFactory.getInstance().getFeature(includedFeature.getId()));
			}
			return includedFeatures;
		}
		return Collections.emptyList();
	}

	public List<ReversibleProject> getIncludedReversiblePlugins() {
		if (feature.getPlugins().length > 0) {
			List<ReversibleProject> includedPlugins = new ArrayList<ReversibleProject>();
			for (IFeaturePlugin includedPlugin : feature.getPlugins()) {
				includedPlugins.add(ReversibleFactory.getInstance().getPlugin(includedPlugin.getId()));
			}
			return includedPlugins;
		}
		return Collections.emptyList();
	}

}
