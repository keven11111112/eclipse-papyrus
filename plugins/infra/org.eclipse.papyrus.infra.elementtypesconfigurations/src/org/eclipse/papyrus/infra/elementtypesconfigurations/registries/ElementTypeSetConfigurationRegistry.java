/*****************************************************************************
 * Copyright (c) 2014, 2016 CEA LIST, Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *  Christian W. Damus - bugs 459174, 467207, 485220
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.elementtypesconfigurations.registries;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeUtil;
import org.eclipse.gmf.runtime.emf.type.core.IAdviceBindingDescriptor;
import org.eclipse.gmf.runtime.emf.type.core.IClientContext;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IMetamodelType;
import org.eclipse.gmf.runtime.emf.type.core.ISpecializationType;
import org.eclipse.gmf.runtime.emf.type.core.NullElementType;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.elementtypesconfigurations.Activator;
import org.eclipse.papyrus.infra.elementtypesconfigurations.AdviceBindingConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.ElementTypeConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.ElementTypeSetConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.SpecializationTypeConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.extensionpoints.IElementTypeSetExtensionPoint;
import org.eclipse.papyrus.infra.elementtypesconfigurations.utils.ElementTypeCycleUtil;
import org.eclipse.papyrus.infra.elementtypesconfigurations.utils.ElementTypeRegistryUtils;
import org.eclipse.papyrus.infra.services.edit.internal.context.TypeContext;
import org.osgi.framework.Bundle;

/**
 * Registry to manage load/unloaded {@link ElementTypeSetConfiguration}.
 */
@SuppressWarnings("restriction")
public class ElementTypeSetConfigurationRegistry {

	private static ElementTypeSetConfigurationRegistry elementTypeSetConfigurationRegistry;

	/** Map of retrieved elementType sets, key is their identifier */
	protected Map<String, ElementTypeSetConfiguration> elementTypeSetConfigurations = null;

	/** unique resource set to load all elementType sets models */
	protected ResourceSet elementTypeSetConfigurationResourceSet = null;

	/**
	 * returns the singleton instance of this registry
	 *
	 * @return the singleton instance of this registry
	 */
	public static synchronized ElementTypeSetConfigurationRegistry getInstance() {
		if (elementTypeSetConfigurationRegistry == null) {
			elementTypeSetConfigurationRegistry = new ElementTypeSetConfigurationRegistry();
			elementTypeSetConfigurationRegistry.init();
		}
		return elementTypeSetConfigurationRegistry;
	}

	/**
	 * Inits the registry.
	 */
	protected void init() {
		// 0. Resets values
		elementTypeSetConfigurationResourceSet = null;
		elementTypeSetConfigurations = null;
		// 1. creates the resource set
		elementTypeSetConfigurationResourceSet = createResourceSet();
		// 2. creates the list only when registry is acceded for the first time, (or on reload?)
		elementTypeSetConfigurations = readElementTypeSetConfigurationModels();
		// load all elementType set
		Collection<ElementTypeSetConfiguration> values = elementTypeSetConfigurations.values();
		loadElementTypeSetConfigurations(values);
	}


	protected Map<String, ElementTypeSetConfiguration> readElementTypeSetConfigurationModels() {
		Map<String, ElementTypeSetConfiguration> ElementTypeSetConfigurations = new HashMap<String, ElementTypeSetConfiguration>();
		// 1. retrieve from the workspace
		Map<String, ElementTypeSetConfiguration> localSets = readElementTypeSetConfigurationModelsFromWorkspace();
		if (localSets != null && !localSets.isEmpty()) {
			ElementTypeSetConfigurations.putAll(localSets);
		}
		// 2. retrieve from the platform. If already in workspace (id), do not load the platform ones
		Map<String, ElementTypeSetConfiguration> registeredSets = readElementTypeSetConfigurationModelsFromExtensionPoints(localSets.keySet());
		if (registeredSets != null && !registeredSets.isEmpty()) {
			ElementTypeSetConfigurations.putAll(registeredSets);
		}
		return ElementTypeSetConfigurations;
	}

	/**
	 * Dispose this registry, i.e. remove all contribution on the elementType registry.
	 */
	public synchronized void dispose() {
		if (elementTypeSetConfigurations == null) {
			return;
		}
		// copy set of entries to iterate and unload them one by one
		List<Entry<String, ElementTypeSetConfiguration>> entriesToDispose = new ArrayList<Entry<String, ElementTypeSetConfiguration>>(elementTypeSetConfigurations.entrySet());
		for (Entry<String, ElementTypeSetConfiguration> entry : entriesToDispose) {
			unload(entry.getKey());
		}
		elementTypeSetConfigurationResourceSet = null;
		elementTypeSetConfigurations = null;
		elementTypeSetConfigurationRegistry = null;
	}

	/**
	 * Loads a given elementType set from a given identifier
	 */
	public void loadElementTypeSetConfiguration(String identifier) {
		// retrieve the path from the identifier
		String path = UserElementTypeDefinitionsRegistry.getInstance().getLocalElementTypeDefinitions().get(identifier);
		if (path == null) {
			return;
		}
		URI localURI = URI.createPlatformResourceURI(path, true);
		Resource resource = elementTypeSetConfigurationResourceSet.createResource(localURI);
		try {
			resource.load(null);
			EObject content = resource.getContents().get(0);
			if (content instanceof ElementTypeSetConfiguration) {
				elementTypeSetConfigurations.put(identifier, (ElementTypeSetConfiguration) content);
				loadElementTypeSetConfiguration((ElementTypeSetConfiguration) content);
			}
		} catch (IOException e) {
			Activator.log.error(e);
		}
	}

	protected void loadElementTypeSetConfiguration(ElementTypeSetConfiguration elementTypeSetConfiguration) {
		loadElementTypeSetConfigurations(Collections.singleton(elementTypeSetConfiguration));
	}

	protected List<SpecializationTypeConfiguration> getDependencies(SpecializationTypeConfiguration specializationTypeConfiguration, Map<String, SpecializationTypeConfiguration> specializationTypeConfigurationsToRegister) {
		List<SpecializationTypeConfiguration> result = new ArrayList<SpecializationTypeConfiguration>();
		for (String specializedTypeID : specializationTypeConfiguration.getSpecializedTypesID()) {
			SpecializationTypeConfiguration value = specializationTypeConfigurationsToRegister.get(specializedTypeID);
			if (value != null) {
				result.add(value);
			}
		}
		return result;
	}

	protected boolean isAlreadyRegistred(String elementTypeID, IClientContext context) {
		if (ElementTypeRegistry.getInstance().getType(elementTypeID) != null) {
			if (!elementTypeID.equals(NullElementType.ID)) {
				if (ElementTypeRegistryUtils.getType(context, elementTypeID) == null) {
					// The elementType is already existing but not binded yet
					context.bindId(elementTypeID);
					Activator.log.info(elementTypeID + " is already registred elementtype but it is not binded yet. It has beeen binded to Papyrus context. ");
				}
			}
			return true;
		}

		return false;
	}

	protected boolean registerElementTypeConfiguration(ElementTypeConfiguration elementTypeConfiguration, Map<String, ElementTypeConfiguration> elementTypeConfigurationsDefinitions, IClientContext context) {
		String elementTypeID = elementTypeConfiguration.getIdentifier();
		if (isAlreadyRegistred(elementTypeID, context)) {
			return true;
		}

		if (elementTypeConfiguration instanceof SpecializationTypeConfiguration) {
			// First, check if dependencies are registered
			for (String specializedTypeId : ((SpecializationTypeConfiguration) elementTypeConfiguration).getSpecializedTypesID()) {

				if (!isAlreadyRegistred(specializedTypeId, context)) {
					// try to register the dependency
					ElementTypeConfiguration specializedTypeConfiguration = elementTypeConfigurationsDefinitions.get(specializedTypeId);
					if (specializedTypeConfiguration != null) {
						boolean registred = registerElementTypeConfiguration(specializedTypeConfiguration, elementTypeConfigurationsDefinitions, context);
						if (!registred) {
							Activator.log.info("Failed to register " + specializedTypeId);
							return false;
						}
					} else {
						if (!specializedTypeId.equals(NullElementType.ID)) {
							Activator.log.info("Cannot find ElementTypeConfiguration for " + specializedTypeId);
							return false;
						}
					}
				}
			}

		}

		IElementType elementType = ElementTypeConfigurationTypeRegistry.getInstance().getElementType(elementTypeConfiguration);
		if (elementType != null) {
			// register elementType
			if (elementType instanceof ISpecializationType) {
				if (ElementTypeRegistry.getInstance().register((ISpecializationType) elementType)) {
					context.bindId(elementType.getId());
					return true;
				} else {
					Activator.log.info("SpecializationType not added: " + elementType);
				}
			} else if (elementType instanceof IMetamodelType) {
				if (ElementTypeRegistry.getInstance().register((IMetamodelType) elementType)) {
					context.bindId(elementType.getId());
					return true;
				} else {
					Activator.log.info("MetamodelType not added: " + elementType);
					ElementTypeRegistry.getInstance().register((IMetamodelType) elementType);
				}
			}
		}

		return false;

	}

	public void loadElementTypeSetConfigurations(Collection<ElementTypeSetConfiguration> elementTypeSetConfigurations) {
		Map<String, ElementTypeConfiguration> elementTypeConfigurationsDefinitions = new HashMap<String, ElementTypeConfiguration>();

		IClientContext context;
		try {
			context = TypeContext.getContext();
		} catch (ServiceException e1) {
			Activator.log.error(e1);
			return;
		}

		// Read from elementTypeSetConfigurations
		for (ElementTypeSetConfiguration elementTypeSetConfiguration : elementTypeSetConfigurations) {
			for (ElementTypeConfiguration elementTypeConfiguration : elementTypeSetConfiguration.getElementTypeConfigurations()) {
				elementTypeConfigurationsDefinitions.put(elementTypeConfiguration.getIdentifier(), elementTypeConfiguration);
			}
		}

		Collection<Collection<String>> cycles = ElementTypeCycleUtil.getCycles(elementTypeConfigurationsDefinitions.values());
		if (!cycles.isEmpty()) {
			Activator.log.warn("The ElementTypesConfiguration registration has been aborted because there are cyclic-dependencies in the ElementTypes definitions: " + cycles);
			return;
		}


		// ElementTypesConfigurations can be registered
		for (ElementTypeConfiguration elementTypeConfiguration : elementTypeConfigurationsDefinitions.values()) {
			registerElementTypeConfiguration(elementTypeConfiguration, elementTypeConfigurationsDefinitions, context);
		}


		// Register adviceBindings
		for (ElementTypeSetConfiguration elementTypeSetConfiguration : elementTypeSetConfigurations) {
			List<AdviceBindingConfiguration> adviceBindingConfigurations = elementTypeSetConfiguration.getAdviceBindingsConfigurations();
			for (AdviceBindingConfiguration adviceBindingConfiguration : adviceBindingConfigurations) {
				IAdviceBindingDescriptor editHelperAdviceDecriptor = AdviceConfigurationTypeRegistry.getInstance().getEditHelperAdviceDecriptor(adviceBindingConfiguration);
				ElementTypeRegistryUtils.registerAdviceBinding(editHelperAdviceDecriptor);
				context.bindId(editHelperAdviceDecriptor.getId());
			}
		}
	}


	public void unload(String identifier) {
		if (elementTypeSetConfigurations == null) {
			return;
		}
		ElementTypeSetConfiguration elementTypeSet = elementTypeSetConfigurations.remove(identifier);
		if (elementTypeSet == null) {
			return;
		}

		// Remove elementTypes
		ElementTypeRegistry registry = ElementTypeRegistry.getInstance();
		List<IElementType> elementTypes = new ArrayList<IElementType>(elementTypeSet.getElementTypeConfigurations().size());
		for (ElementTypeConfiguration elementTypeConfiguration : elementTypeSet.getElementTypeConfigurations()) {
			if (elementTypeConfiguration != null && elementTypeConfiguration.getIdentifier() != null) {
				String configIdentifier = elementTypeConfiguration.getIdentifier();
				IElementType elementType = registry.getType(configIdentifier);
				if (elementType != null) {
					elementTypes.add(elementType);
				}
			}
		}

		ElementTypeUtil.deregisterElementTypes(elementTypes, ElementTypeUtil.ALL_DEPENDENTS);

		// Remove adviceBindings
		List<AdviceBindingConfiguration> adviceBindingConfigurations = elementTypeSet.getAdviceBindingsConfigurations();
		for (AdviceBindingConfiguration adviceBindingConfiguration : adviceBindingConfigurations) {
			IAdviceBindingDescriptor advice = AdviceConfigurationTypeRegistry.getInstance().getEditHelperAdviceDecriptor(adviceBindingConfiguration);
			if (advice != null) {
				ElementTypeRegistryUtils.removeAdviceDescriptorFromBindings(advice);
			}
		}

		// If I loaded this element-types configuration model, I should now unload it. Otherwise,
		// I don't own this resource so I should not attempt to manage it
		if (elementTypeSetConfigurationResourceSet != null) {
			Resource resource = elementTypeSet.eResource();
			if ((resource != null) && (resource.getResourceSet() == elementTypeSetConfigurationResourceSet)) {
				resource.unload();
				elementTypeSetConfigurationResourceSet.getResources().remove(resource);
			}
		}
	}


	protected Map<String, ElementTypeSetConfiguration> readElementTypeSetConfigurationModelsFromWorkspace() {
		Map<String, String> localFilesPath = UserElementTypeDefinitionsRegistry.getInstance().getLocalElementTypeDefinitions();
		Map<String, ElementTypeSetConfiguration> workspaceElementTypeSets = new HashMap<String, ElementTypeSetConfiguration>();
		if (localFilesPath != null && !localFilesPath.isEmpty()) {
			for (Entry<String, String> idToPath : localFilesPath.entrySet()) {
				String filePath = idToPath.getValue();
				String id = idToPath.getKey();
				URI localURI = URI.createPlatformResourceURI(filePath, true);
				Resource resource = elementTypeSetConfigurationResourceSet.createResource(localURI);
				try {
					resource.load(null);
					EObject content = resource.getContents().get(0);
					if (content instanceof ElementTypeSetConfiguration) {
						workspaceElementTypeSets.put(id, (ElementTypeSetConfiguration) content);
					}
				} catch (IOException e) {
					Activator.log.error(e);
				}
			}
		}
		return workspaceElementTypeSets;
	}

	protected Map<String, ElementTypeSetConfiguration> readElementTypeSetConfigurationModelsFromExtensionPoints(Set<String> workspaceDefinitions) {
		Map<String, ElementTypeSetConfiguration> platformElementTypeSets = new HashMap<String, ElementTypeSetConfiguration>();
		IConfigurationElement[] elements = Platform.getExtensionRegistry().getConfigurationElementsFor(IElementTypeSetExtensionPoint.EXTENSION_POINT_ID);
		// for each element, parses and retrieve the model file. then loads it and returns the root element
		for (IConfigurationElement element : elements) {
			String modelPath = element.getAttribute(IElementTypeSetExtensionPoint.PATH);
			String elementTypeSetId = element.getAttribute(IElementTypeSetExtensionPoint.ID);
			String contributorID = element.getContributor().getName();
			if (Platform.inDebugMode()) {
				Activator.log.debug("[Reading extension point]");
				Activator.log.debug("-  Path to the model: " + modelPath);
				Activator.log.debug("-  id of the container bundle: " + contributorID);
				Activator.log.debug("-  id of the elementType set: " + elementTypeSetId);
			}
			ElementTypeSetConfiguration set = getElementTypeSetConfiguration(elementTypeSetId, modelPath, contributorID);
			if (set != null && !workspaceDefinitions.contains(elementTypeSetId)) { // do not add if it is locally redefined
				if (platformElementTypeSets.containsKey(elementTypeSetId)) {
					Activator.log.warn("An element type set is already registered with the id : " + elementTypeSetId);
				}
				platformElementTypeSets.put(elementTypeSetId, set);
			}
		}
		return platformElementTypeSets;
	}

	/**
	 * <p>
	 * Loads the resource containing the elementType set model.
	 * </p>
	 * <p>
	 * It looks the model file in the fragments first, then in the plugin itself.<BR>
	 * If this is already a fragment, it should look in the fragment only
	 * </p>
	 *
	 * @param elementTypesID
	 *            id of the elementType set to load
	 * @param modelPath
	 *            path of the model in the bundle
	 * @param bundleId
	 *            id of the bundle containing the model file
	 * @return the loaded file or <code>null</code> if some problem occured during loading
	 */
	protected ElementTypeSetConfiguration getElementTypeSetConfiguration(String elementTypesID, String modelPath, String bundleId) {
		// 1. look in preferences.
		String filePath = UserElementTypeDefinitionsRegistry.getInstance().getElementTypesRedefinition(elementTypesID);
		if (filePath != null) {
			getElementTypeSetConfigurationInPluginStateArea(elementTypesID);
		}
		// 2. no local redefinition. Load elementType set from plugin definition
		Bundle bundle = Platform.getBundle(bundleId);
		if (Platform.isFragment(bundle)) {
			ElementTypeSetConfiguration configuration = getElementTypeSetConfigurationInBundle(modelPath, bundleId);
			if (configuration == null) {
				Activator.log.warn("Cannot find resource " + modelPath + " in bundle " + bundleId);
			}
			return configuration;
		} else { // this is a plugin. Search in sub fragments, then in the plugin
			Bundle[] fragments = Platform.getFragments(bundle);
			// no fragment, so the file should be in the plugin itself
			if (fragments == null) {
				return getElementTypeSetConfigurationInBundle(modelPath, bundleId);
			} else {

				ElementTypeSetConfiguration elementTypeSetConfiguration = null;

				for (Bundle fragment : fragments) {
					elementTypeSetConfiguration = getElementTypeSetConfigurationInBundle(modelPath, fragment.getSymbolicName());
					if (elementTypeSetConfiguration != null) {
						break;
					}
				}

				if (elementTypeSetConfiguration == null) {
					// not found in fragments. Look in the plugin itself
					elementTypeSetConfiguration = getElementTypeSetConfigurationInBundle(modelPath, bundleId);
				}

				if (elementTypeSetConfiguration == null) {
					Activator.log.warn("Cannot find resource " + modelPath + " in bundle " + bundleId);
				}

				return elementTypeSetConfiguration;
			}
		}
	}

	/**
	 * Retrieves the contribution in the plugin area
	 *
	 * @param path
	 *            the path of the elementType set to load in the plugin area
	 */
	protected ElementTypeSetConfiguration getElementTypeSetConfigurationInPluginStateArea(String path) {
		// read in preferences area
		IPath resourcePath = Activator.getDefault().getStateLocation().append(path);
		URI uri = URI.createFileURI(resourcePath.toOSString());
		if (uri != null && uri.isFile()) {
			Resource resource = elementTypeSetConfigurationResourceSet.createResource(uri);
			try {
				resource.load(null);
			} catch (IOException e) {
				return null;
			}
			EObject content = resource.getContents().get(0);
			if (content instanceof ElementTypeSetConfiguration) {
				return (ElementTypeSetConfiguration) content;
			}
			Activator.log.warn("Impossible to cast the object into an ElementTypeSetConfiguration: " + content);
			return null;
		}
		return null;
	}

	/**
	 *
	 * @param modelPath
	 *            path of the model in the bundle
	 * @param bundleId
	 *            id of the bundle containing the model file
	 * @return the loaded file or <code>null</code> if some problem occured during loading
	 */
	protected ElementTypeSetConfiguration getElementTypeSetConfigurationInBundle(String modelPath, String bundleID) {
		String path = bundleID + IPath.SEPARATOR + modelPath;
		Resource resource = elementTypeSetConfigurationResourceSet.createResource(URI.createPlatformPluginURI(path, true));
		try {
			resource.load(null);
		} catch (IOException e) {
			return null; // Don't log the error yet; we're trying several options
		}
		EObject content = resource.getContents().get(0);
		if (content instanceof ElementTypeSetConfiguration) {
			return (ElementTypeSetConfiguration) content;
		}
		return null;
	}

	protected ResourceSet createResourceSet() {
		ResourceSet set = new ResourceSetImpl();
		return set;
	}

	public Map<String, ElementTypeSetConfiguration> getElementTypeSetConfigurations() {
		return elementTypeSetConfigurations;
	}
}
