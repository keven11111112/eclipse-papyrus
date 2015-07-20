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
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PropertyResourceBundle;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.adl4eclipse.org.IADL4ECLIPSE_Stereotype;
import org.eclipse.papyrus.adltool.ADL4EclipseUtils;
import org.eclipse.papyrus.adltool.ADLConstants;
import org.eclipse.papyrus.adltool.reversible.factory.ReversibleFactory;
import org.eclipse.papyrus.osgi.profile.IOSGIStereotype;
import org.eclipse.pde.core.project.IBundleProjectDescription;
import org.eclipse.pde.core.project.IPackageExportDescription;
import org.eclipse.pde.core.project.IRequiredBundleDescription;
import org.eclipse.swt.graphics.Image;
import org.osgi.framework.Constants;

/**
 * This class is a reversible adapter of a workspace plug-in.
 */
public class WorkspacePlugin extends AbstractReversiblePlugin {

	private IBundleProjectDescription plugin;

	/**
	 * Constructor.
	 *
	 * @param plugin
	 */
	public WorkspacePlugin(IBundleProjectDescription plugin) {
		this.plugin = plugin;
	}

	@Override
	public String getId() {
		return plugin.getSymbolicName();
	}

	@Override
	public String getStereotypeName() {
		return IADL4ECLIPSE_Stereotype.PLUGIN_STEREOTYPE;
	}

	@Override
	public Type getType() {
		return Type.PLUGIN;
	}

	@Override
	public Image getImage() {
		return ADL4EclipseUtils.getImage("img/bundle_pj.gif");
	}

	private List<String> getDependenciesIds() {
		List<String> children = new ArrayList<>();
		IRequiredBundleDescription[] requiredBundles = plugin.getRequiredBundles();

		if (requiredBundles != null) {
			for (IRequiredBundleDescription child : requiredBundles) {
				children.add(child.getName());
			}
		}

		return children;
	}

	@Override
	public List<ReversibleProject> getDependencies() {
		List<ReversibleProject> dependencies = new ArrayList<>();
		List<String> dependenciesIds = getDependenciesIds();

		if (!dependenciesIds.isEmpty()) {
			for (String pluginId : dependenciesIds) {
				ReversibleProject reversiblePlugin = ReversibleFactory.getInstance().getPlugin(pluginId);

				if (reversiblePlugin != null) {
					dependencies.add(reversiblePlugin);
				} else {
					log.warn("Plug-in " + getId() + " : cannot find child " + pluginId);
				}
			}
		}

		return dependencies;
	}

	@Override
	public List<String> getExportedPackages() {
		List<String> packageExports = new ArrayList<>();
		IPackageExportDescription[] packageExportDescriptions = plugin.getPackageExports();

		if (packageExportDescriptions != null) {
			for (IPackageExportDescription packageExport : packageExportDescriptions) {
				packageExports.add(packageExport.getName());
			}
		}

		return packageExports;
	}

	@Override
	protected String getBundleValue(String key) {
		String valueFromDescription = plugin.getHeader(key);
		PropertyResourceBundle propertyResourceBundle = ADL4EclipseUtils.getNLSFilesFor(plugin);

		if (propertyResourceBundle != null && valueFromDescription != null) {
			if (valueFromDescription.startsWith("%") && valueFromDescription.length() > 1) { //$NON-NLS-1$
				String propertiesKey = valueFromDescription.substring(1);
				valueFromDescription = propertyResourceBundle.getString(propertiesKey);
			}
		}

		return valueFromDescription;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void fillStereotype() {
		if (!applyStereotype()) {
			log.warn("(" + getType() + ") " + getId() + " cannot fill the stereotype properties");
			return;
		}

		Map<String, String> stereotypeKeyValues = new HashMap<>();

		// Activator
		stereotypeKeyValues.put(Constants.BUNDLE_ACTIVATOR, IOSGIStereotype.BUNDLE_ACTIVATOR_ATT);
		// Category
		stereotypeKeyValues.put(Constants.BUNDLE_CATEGORY, IOSGIStereotype.BUNDLE_CATEGORY_ATT);
		// Classpath
		stereotypeKeyValues.put(Constants.BUNDLE_CLASSPATH, IOSGIStereotype.BUNDLE_CLASSPATH_ATT);
		// Contact address
		stereotypeKeyValues.put(Constants.BUNDLE_CONTACTADDRESS, IOSGIStereotype.BUNDLE_CONTACTADDRESS_ATT);
		// Copyright
		stereotypeKeyValues.put(Constants.BUNDLE_COPYRIGHT, IOSGIStereotype.BUNDLE_COPYRIGHT_ATT);
		// Description
		stereotypeKeyValues.put(Constants.BUNDLE_DESCRIPTION, IOSGIStereotype.BUNDLE_DESCRIPTION_ATT);
		// DocURL
		stereotypeKeyValues.put(Constants.BUNDLE_DOCURL, IOSGIStereotype.BUNDLE_DOCURL_ATT);
		// Localization
		stereotypeKeyValues.put(Constants.BUNDLE_LOCALIZATION, IOSGIStereotype.BUNDLE_LOCALIZATION_ATT);
		// Manifest version
		stereotypeKeyValues.put(Constants.BUNDLE_MANIFESTVERSION, IOSGIStereotype.BUNDLE_MANIFESTVERSION_ATT);
		// NativeCode
		stereotypeKeyValues.put(Constants.BUNDLE_NATIVECODE, IOSGIStereotype.BUNDLE_NATIVECODE_ATT);
		// RequiredExecutionEnvironment
		stereotypeKeyValues.put(Constants.BUNDLE_REQUIREDEXECUTIONENVIRONMENT, IOSGIStereotype.BUNDLE_REQUIREDEXECUTIONENVIRONMENT_ATT);
		// Update location
		stereotypeKeyValues.put(Constants.BUNDLE_UPDATELOCATION, IOSGIStereotype.BUNDLE_UPDATELOCATION_ATT);
		// Vendor
		stereotypeKeyValues.put(Constants.BUNDLE_VENDOR, IOSGIStereotype.BUNDLE_VENDOR_ATT);
		// Version
		stereotypeKeyValues.put(Constants.BUNDLE_VERSION, IOSGIStereotype.BUNDLE_VERSION_ATT);
		// Platform filter
		stereotypeKeyValues.put(ADLConstants.ECLIPSE_PLATFORMFILTER, IADL4ECLIPSE_Stereotype.PLUGIN_PLATFORMFILTER_ATT);

		for (Map.Entry<String, String> entry : stereotypeKeyValues.entrySet()) {
			String value = getBundleValue(entry.getKey());
			representation.setValue(stereotype, entry.getValue(), value);
		}

		// Lazy start
		String activationPolicy = getBundleValue(Constants.BUNDLE_ACTIVATIONPOLICY);
		boolean hasLazyActivationPolicy = "lazy".equals(activationPolicy);

		representation.setValue(stereotype, IOSGIStereotype.BUNDLE_HASLAZYACTIVATIONPOLICY_ATT, hasLazyActivationPolicy);

		// BUNDLE_SYMBOLICNAME
		representation.setValue(stereotype, IOSGIStereotype.BUNDLE_SYMBOLICNAME_ATT, getId());

		// BUNDLE_NAME
		String name = getBundleValue(Constants.BUNDLE_NAME);
		if (name != null) {
			if (name.toLowerCase().contains("incubation")) {

				name = name.replace("(Incubation)", "");
				name = name.replace("(incubation)", "");
				name = name.replace("Incubation", "");
				name = name.replace("incubation", "");

				representation.setValue(stereotype, IADL4ECLIPSE_Stereotype.PLUGIN_ISINCUBATION_ATT, true);
			} else {
				representation.setValue(stereotype, IADL4ECLIPSE_Stereotype.PLUGIN_ISINCUBATION_ATT, false);
			}

			representation.setValue(stereotype, IOSGIStereotype.BUNDLE_NAME_ATT, name.trim());
		}

		String lazystartExpression = getBundleValue(ADLConstants.ECLIPSE_LAZYSTART);
		if (lazystartExpression != null) {
			boolean lazyStartValue;
			if (lazystartExpression.contains(";")) {
				String lazyStartString = lazystartExpression.substring(0, lazystartExpression.indexOf(";"));
				lazyStartValue = Boolean.valueOf(lazyStartString);
				// String lazyStartException=
				// lazystartExpression.substring(lazystartExpression.indexOf(";"));
				// TODO: lazystartExpression
				// bundleComponent.setValue(pluginStereotype,
				// IADL4ECLIPSE_Stereotype.PLUGIN_LAZYSTARTEXCEPTION_ATT,lazyStartException
				// );
			} else {
				lazyStartValue = Boolean.valueOf(lazystartExpression);
				representation.setValue(stereotype, IADL4ECLIPSE_Stereotype.PLUGIN_LAZYSTART_ATT, lazyStartValue);
				representation.setValue(stereotype, IADL4ECLIPSE_Stereotype.PLUGIN_LAZYSTARTEXCEPTION_ATT, Collections.EMPTY_LIST);
			}
		} else {
			representation.setValue(stereotype, IADL4ECLIPSE_Stereotype.PLUGIN_LAZYSTART_ATT, null);
			representation.setValue(stereotype, IADL4ECLIPSE_Stereotype.PLUGIN_LAZYSTARTEXCEPTION_ATT, Collections.EMPTY_LIST);
		}

		List<String> requireBundleIds = extractManifestHeader(Constants.REQUIRE_BUNDLE);

		List<EObject> requireBundles = ADL4EclipseUtils.getBundleStereotypeApplications(requireBundleIds);

		representation.setValue(stereotype, IADL4ECLIPSE_Stereotype.PLUGIN_REQUIRE_BUNDLE_ATT, requireBundles);
	}

}
