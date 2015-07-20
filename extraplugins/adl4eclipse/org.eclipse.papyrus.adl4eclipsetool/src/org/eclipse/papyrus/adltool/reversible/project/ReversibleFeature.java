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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.adl4eclipse.org.IADL4ECLIPSE_Stereotype;
import org.eclipse.papyrus.adltool.ADL4EclipseUtils;
import org.eclipse.papyrus.adltool.reversible.AbstractReversible;
import org.eclipse.papyrus.adltool.reversible.factory.ReversibleFactory;
import org.eclipse.papyrus.osgi.profile.IOSGIStereotype;
import org.eclipse.pde.core.IIdentifiable;
import org.eclipse.pde.internal.core.ifeature.IFeature;
import org.eclipse.pde.internal.core.ifeature.IFeatureURL;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * This class is a reversible adapter of a feature project.
 */
@SuppressWarnings("restriction")
public class ReversibleFeature extends AbstractReversible<Component> implements ReversibleProject {

	private IFeature feature;

	/**
	 * Constructor.
	 *
	 * @param feature
	 */
	public ReversibleFeature(IFeature feature) {
		this.feature = feature;
	}

	@Override
	public String getId() {
		return feature.getId();
	}

	@Override
	public String getStereotypeName() {
		return IADL4ECLIPSE_Stereotype.FEATURE_STEREOTYPE;
	}

	@Override
	public String getDependencyStereotypeName() {
		return IOSGIStereotype.FEATURE_REFERENCE;
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
		List<ReversibleProject> children = new ArrayList<>();

		for (String featureId : getFeatureDependencies()) {
			ReversibleProject reversibleFeature = ReversibleFactory.getInstance().getFeature(featureId);
			if (reversibleFeature != null) {
				children.add(reversibleFeature);
			} else {
				log.warn(getType() + "\"" + getId() + "\": cannot find child " + featureId);
			}
		}

		for (String pluginId : getPluginDependencies()) {
			ReversibleProject reversibleChild = ReversibleFactory.getInstance().getPlugin(pluginId);

			if (reversibleChild != null) {
				children.add(reversibleChild);
			} else {
				log.warn(getType() + "\"" + getId() + "\" : cannot find child " + pluginId);
			}
		}

		return children;
	}

	public List<String> getFeatureDependencies() {
		List<String> features = new ArrayList<>();

		IIdentifiable[] includes = feature.getIncludedFeatures();
		IIdentifiable[] requires = feature.getImports();

		// Includes
		if (includes != null) {
			for (IIdentifiable include : includes) {
				features.add(include.getId());
			}
		}

		// Requires
		if (requires != null) {
			for (IIdentifiable require : requires) {
				features.add(require.getId());
			}
		}

		return features;
	}

	public List<String> getPluginDependencies() {
		List<String> result = new ArrayList<>();

		IIdentifiable[] plugins = feature.getPlugins();

		// Plug-ins
		if (plugins != null) {
			for (IIdentifiable plugin : plugins) {
				result.add(plugin.getId());
			}
		}

		return result;
	}

	@Override
	public String getDescription() {
		return feature.getFeatureInfo(IFeature.INFO_DESCRIPTION).getDescription();
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

		// Description
		String description = feature.getFeatureInfo(IFeature.INFO_DESCRIPTION).getDescription();
		representation.setValue(stereotype, IADL4ECLIPSE_Stereotype.FEATURE_DESCRIPTION_ATT, description);

		// Copyright
		String copyright = feature.getFeatureInfo(IFeature.INFO_COPYRIGHT).getDescription();
		representation.setValue(stereotype, IADL4ECLIPSE_Stereotype.FEATURE_COPYRIGHT_ATT, copyright);

		// License
		String license = feature.getFeatureInfo(IFeature.INFO_LICENSE).getDescription();
		representation.setValue(stereotype, IADL4ECLIPSE_Stereotype.FEATURE_LICENSE_ATT, license);

		// Provider
		String provider = feature.getProviderName();
		representation.setValue(stereotype, IADL4ECLIPSE_Stereotype.FEATURE_PROVIDER_ATT, provider);

		// Image
		String image = feature.getImageName();
		representation.setValue(stereotype, IADL4ECLIPSE_Stereotype.FEATURE_IMAGE_ATT, image);

		// URL
		IFeatureURL url = feature.getURL();
		if (url != null) {
			representation.setValue(stereotype, IADL4ECLIPSE_Stereotype.FEATURE_URL_ATT, url.toString());
		}

		// Label
		String label = feature.getLabel();
		representation.setValue(stereotype, IADL4ECLIPSE_Stereotype.FEATURE_LABEL_ATT, label);

		// Id
		String id = feature.getId();
		representation.setValue(stereotype, IADL4ECLIPSE_Stereotype.FEATURE_ID_ATT, id);

		// Version
		String version = feature.getVersion();
		representation.setValue(stereotype, IADL4ECLIPSE_Stereotype.FEATURE_VERSION_ATT, version);

		// Plug-ins
		List<EObject> packagedPlugins = ADL4EclipseUtils.getPluginStereotypeApplications(feature.getPlugins());
		representation.setValue(stereotype, IADL4ECLIPSE_Stereotype.FEATURE_PLUGINS_ATT, packagedPlugins);

		// Included Features
		List<EObject> packagedFeatures = ADL4EclipseUtils.getFeatureStereotypeApplication(feature.getIncludedFeatures());
		representation.setValue(stereotype, IADL4ECLIPSE_Stereotype.FEATURE_INCLUDEDFEATURES_ATT, packagedFeatures);

		// Imported Features
		List<EObject> importedFeatures = ADL4EclipseUtils.getFeatureStereotypeApplication(feature.getImports());
		representation.setValue(stereotype, IADL4ECLIPSE_Stereotype.FEATURE_IMPORTEDFEATURES_ATT, importedFeatures);
	}

}
