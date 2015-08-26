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

import static org.eclipse.papyrus.adltool.Activator.log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PropertyResourceBundle;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IContributor;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.spi.RegistryContributor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.papyrus.adltool.reversible.project.ReversibleProject;
import org.eclipse.papyrus.adl4eclipse.org.IADL4ECLIPSE_Stereotype;
import org.eclipse.papyrus.adltool.reversible.extensionpoint.ReversibleExtensionPoint;
import org.eclipse.papyrus.adltool.reversible.factory.ReversibleFactory;
import org.eclipse.pde.core.IIdentifiable;
import org.eclipse.pde.core.plugin.IPluginExtension;
import org.eclipse.pde.core.plugin.IPluginExtensionPoint;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.PluginRegistry;
import org.eclipse.pde.core.project.IBundleProjectDescription;
import org.eclipse.pde.core.project.IBundleProjectService;
import org.eclipse.pde.internal.core.PDECore;
import org.eclipse.pde.internal.core.PDEExtensionRegistry;
import org.eclipse.pde.internal.core.ifeature.IFeature;
import org.eclipse.pde.internal.core.ifeature.IFeatureModel;
import org.eclipse.pde.internal.core.ischema.ISchema;
import org.eclipse.pde.internal.core.schema.SchemaRegistry;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Stereotype;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceReference;

/**
 * This static class holds all the reversible projects that are loaded in the
 * platform or in the workspace.
 */
@SuppressWarnings("restriction")
public class ADL4EclipseUtils {

	static {
		// These methods are called once (on plug-in startup) to populate the reversible library
		// by creating an adapter for each loaded and workspace plug-ins/features
		getLoadedPlugins();
		getLoadedFeatures();
		getWorkspacePlugins();
		getWorkspaceFeatures();
	}

	/**
	 * Constructor. Private to prevent instantiation.
	 */
	private ADL4EclipseUtils() {
	}

	/**
	 * Gets the list of of reversible bundles loaded in the platform.
	 *
	 * @return The bundles loaded in the platform
	 */
	public static Set<ReversibleProject> getLoadedPlugins() {
		// Set to avoid duplicates: we don't add the reversible with the same symbolic name and type twice
		Set<ReversibleProject> bundleList = new HashSet<>();
		Bundle[] bundleArray = PDECore.getDefault().getBundleContext().getBundles();

		for (Bundle bundle : bundleArray) {
			ReversibleProject reversibleBundle = ReversibleFactory.getInstance().makeReversible(bundle);
			bundleList.add(reversibleBundle);
		}

		return bundleList;
	}

	/**
	 * Gets the list of reversible features loaded in the platform.
	 *
	 * @return The list of bundle description contained in the workspace
	 */
	private static Set<ReversibleProject> getLoadedFeatures() {
		Set<ReversibleProject> featureList = new HashSet<>();
		IFeatureModel[] featureModels = PDECore.getDefault().getFeatureModelManager().getModels();

		for (IFeatureModel featureModel : featureModels) {
			IFeature feature = featureModel.getFeature();
			ReversibleProject reversibleFeature = ReversibleFactory.getInstance().makeReversible(feature);

			featureList.add(reversibleFeature);
		}

		return featureList;
	}

	/**
	 * Gets the list of reversible plug-ins in the workspace.
	 *
	 * @return The list of bundle description contained in the workspace
	 */
	public static Set<ReversibleProject> getWorkspacePlugins() {
		Set<ReversibleProject> pluginList = new HashSet<>();
		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();

		for (IProject project : projects) {
			try {
				if (project.getNature(IBundleProjectDescription.PLUGIN_NATURE) != null) {
					IBundleProjectDescription bundleDescription = getProjectDescription(project);
					ReversibleProject reversiblePlugin = ReversibleFactory.getInstance().makeReversible(bundleDescription);

					pluginList.add(reversiblePlugin);
				}
			} catch (CoreException e) {
				log.warn(e.getMessage());
			}
		}

		return pluginList;
	}

	/**
	 * Gets the list of of reversible features in the workspace.
	 *
	 * @return The list of bundle description contained in the workspace
	 */
	public static Set<ReversibleProject> getWorkspaceFeatures() {
		Set<ReversibleProject> featureList = new HashSet<>();
		IFeatureModel[] featureModels = PDECore.getDefault().getFeatureModelManager().getWorkspaceModels();

		for (IFeatureModel featureModel : featureModels) {
			IFeature feature = featureModel.getFeature();
			ReversibleProject reversibleFeature = ReversibleFactory.getInstance().makeReversible(feature);

			featureList.add(reversibleFeature);
		}

		return featureList;
	}

	/**
	 * Gets the IBundleProjectDescription of a project.
	 *
	 * @param project
	 * @return the IBundleProjectDescription of the project
	 * @throws CoreException
	 */
	public static IBundleProjectDescription getProjectDescription(IProject project) throws CoreException {
		BundleContext context = Activator.getDefault().getBundleContext();
		ServiceReference<?> ref = context.getServiceReference(IBundleProjectService.class.getName());
		IBundleProjectService bundleProjectservice = (IBundleProjectService) context.getService(ref);

		return bundleProjectservice.getDescription(project);
	}

	/**
	 * Gets the IFeature of a project.
	 *
	 * @param project
	 * @return
	 */
	public static IFeature getFeature(IProject project) {
		return PDECore.getDefault().getFeatureModelManager().getFeatureModel(project).getFeature();
	}

	/**
	 * Returns an {@link org.eclipse.swt.graphics.Image} identified by its key.
	 * <br />
	 * By default, it returns a default image. This image is the image placed in
	 * the directory <em>resources/icons/default.gif</em>
	 *
	 * @param key the key of the image
	 *
	 * @return the Image
	 */
	public static Image getImage(String key) {
		ImageRegistry registry = Activator.getDefault().getImageRegistry();
		Image image = registry.get(key);

		if (image == null) {
			ImageDescriptor desc = AbstractUIPlugin.imageDescriptorFromPlugin(Activator.PLUGIN_ID, key);
			registry.put(key, desc);
			image = registry.get(key);
		}

		return image;
	}

	/**
	 *
	 * @param bundle
	 * @return
	 */
	public static PropertyResourceBundle getNLSFilesFor(IBundleProjectDescription bundle) {
		PropertyResourceBundle bundleproperties = null;
		// get the base localization path from the target
		String localization = bundle.getHeader(Constants.BUNDLE_LOCALIZATION);
		if (localization != null) {
			// we do a simple check to make sure the default nls path exists in
			// the target;
			// this is for performance reasons, but I'm not sure it is valid
			// because a target could ship without the default nls properties
			// file but this seems very unlikely
			IFile file = bundle.getProject().getFile(localization + ".properties");
			if (file != null) {
				try {
					bundleproperties = new PropertyResourceBundle(file.getContents());
				} catch (IOException e) {
					e.printStackTrace();
				} catch (CoreException e) {
					e.printStackTrace();
				}
			}
		}

		return bundleproperties;
	}

	/**
	 * Finds the extension points of a workspace plug-in.
	 *
	 * @param pluginId the plug-in's symbolic name
	 * @return the array containing the workspace plug-in's extension points
	 */
	public static IPluginExtensionPoint[] findExtensionPointsForPlugin(String pluginId) {
		PDEExtensionRegistry extensionsRegistry = PDECore.getDefault().getExtensionsRegistry();
		IPluginModelBase base = PluginRegistry.findModel(pluginId);

		return extensionsRegistry.findExtensionPointsForPlugin(base);
	}

	/**
	 * Finds the extensions of a workspace plug-in.
	 *
	 * @param pluginId the plug-in's symbolic name
	 * @return the array containing the workspace plug-in's extensions
	 */
	public static IPluginExtension[] findExtensionsForPlugin(String pluginId) {
		PDEExtensionRegistry extensionsRegistry = PDECore.getDefault().getExtensionsRegistry();
		IPluginModelBase base = PluginRegistry.findModel(pluginId);

		return extensionsRegistry.findExtensionsForPlugin(base);
	}

	/**
	 * Finds the extension points of a loaded plug-in.
	 *
	 * @param pluginId the plug-in's symbolic name
	 * @return the array containing the workspace plug-in's extension points
	 */
	public static IExtensionPoint[] findExtensionPointsForBundle(long bundleId, String symbolicName) {
		IExtensionRegistry extensionRegistry = Platform.getExtensionRegistry();
		IContributor contributor = new RegistryContributor(Long.toString(bundleId), symbolicName, null, null);

		return extensionRegistry.getExtensionPoints(contributor);
	}

	/**
	 * Finds the extension of a loaded plug-in.
	 *
	 * @param pluginId the plug-in's symbolic name
	 * @return the array containing the workspace plug-in's extensions
	 */
	public static IExtension[] findExtensionsForBundle(long bundleId, String symbolicName) {
		IExtensionRegistry extensionRegistry = Platform.getExtensionRegistry();
		IContributor contributor = new RegistryContributor(Long.toString(bundleId), symbolicName, null, null);

		return extensionRegistry.getExtensions(contributor);
	}

	/**
	 *
	 * @param extPointID
	 * @return
	 */
	public static ISchema getSchema(String extPointID) {
		SchemaRegistry schemaRegistry = PDECore.getDefault().getSchemaRegistry();

		return schemaRegistry.getSchema(extPointID);
	}

	/**
	 * Gets a list of feature stereotyped applications from a list of identifiables.
	 *
	 * @param identifiables
	 * @return
	 */
	public static List<EObject> getFeatureStereotypeApplication(IIdentifiable[] identifiables) {
		List<EObject> result = new ArrayList<>();

		for (IIdentifiable identifiable : identifiables) {
			ReversibleProject feature = ReversibleFactory.getInstance().getFeature(identifiable.getId());

			if (feature != null) {
				Component featureRepresentation = feature.getRepresentation();
				Stereotype stereotype = featureRepresentation.getAppliedStereotype(IADL4ECLIPSE_Stereotype.FEATURE_STEREOTYPE);

				if (stereotype != null) {
					result.add(featureRepresentation.getStereotypeApplication(stereotype));
				}
			}
		}

		return result;
	}

	/**
	 * Gets a list of plug-in stereotyped applications from a list of identifiables.
	 *
	 * @param identifiables
	 * @return
	 */
	public static List<EObject> getPluginStereotypeApplications(IIdentifiable[] identifiables) {
		List<EObject> result = new ArrayList<>();

		for (IIdentifiable identifiable : identifiables) {
			ReversibleProject plugin = ReversibleFactory.getInstance().getPlugin(identifiable.getId());

			if (plugin != null) {
				Component pluginRepresentation = plugin.getRepresentation();
				Stereotype stereotype = pluginRepresentation.getAppliedStereotype(IADL4ECLIPSE_Stereotype.PLUGIN_STEREOTYPE);

				if (stereotype != null) {
					result.add(pluginRepresentation.getStereotypeApplication(stereotype));
				}
			}
		}

		return result;
	}

	/**
	 * Gets a list of extension point stereotyped applications from a list of identifiables.
	 *
	 * @param component
	 * @param identifiables
	 * @return
	 */
	public static List<EObject> getExtensionPointStereotypeApplication(IIdentifiable[] identifiables) {
		List<EObject> result = new ArrayList<>();

		for (IIdentifiable identifiable : identifiables) {
			ReversibleExtensionPoint extensionPoint = ReversibleFactory.getInstance().getExtensionPoint(identifiable.getId());

			if (extensionPoint != null) {
				Component extensionPointRepresentation = extensionPoint.getRepresentation();
				Stereotype stereotype = extensionPointRepresentation.getAppliedStereotype(IADL4ECLIPSE_Stereotype.EXTENSION_POINT_STEREOTYPE);

				if (stereotype != null) {
					result.add(extensionPointRepresentation.getStereotypeApplication(stereotype));
				}
			}
		}

		return result;
	}

	/**
	 * Gets the root model of an element.
	 *
	 * @param element
	 * @return the root model or null
	 */
	public static Package getRootModel(Element element) {
		Element model = element;

		while (model.getOwner() != null) {
			model = model.getOwner();
		}

		return model instanceof Model ? (Model) model : null;
	}

	public static List<EObject> getBundleStereotypeApplications(List<String> requireBundleIds) {
		List<EObject> result = new ArrayList<>();

		for (String bundleId : requireBundleIds) {
			//System.out.println(bundleId);
			ReversibleProject plugin = ReversibleFactory.getInstance().getPlugin(bundleId);

			if (plugin != null) {
				Component pluginRepresentation = plugin.getRepresentation();
				Stereotype stereotype = pluginRepresentation.getApplicableStereotype(IADL4ECLIPSE_Stereotype.PLUGIN_STEREOTYPE);

				if (stereotype != null) {
					// TODO: Get EObject instead of DynamicEObject
					// (this method needs to be called when the representations are in the model explorer)
					//EObject stereotypeApplication = pluginRepresentation.getStereotypeApplication(stereotype);
					//result.add(stereotypeApplication);
				}
			}
		}

		return result;
	}

}
