/*****************************************************************************
 * Copyright (c) 2013, 2016 CEA LIST, Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) - Initial API and implementation
 *  Christian W. Damus - bugs 459174, 459825, 485220
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.extendedtypes;

import static org.eclipse.papyrus.infra.extendedtypes.util.InternalUtils.loadClass;

import java.io.IOException;
import java.util.ArrayList;
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
import org.eclipse.gmf.runtime.emf.type.core.IClientContext;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.internal.descriptors.IEditHelperAdviceDescriptor;
import org.eclipse.gmf.runtime.emf.type.core.internal.impl.SpecializationTypeRegistry;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.elementtypesconfigurations.registries.ElementTypeSetConfigurationRegistry;
import org.eclipse.papyrus.infra.extendedtypes.types.IExtendedHintedElementType;
import org.eclipse.papyrus.infra.services.edit.internal.context.TypeContext;
import org.osgi.framework.Bundle;

/**
 * Registry to manage load/unloaded {@link ExtendedElementTypeSet}.
 */
public class ExtendedElementTypeSetRegistry {

	public static final String LOCAL_CONTRIBUTOR_ID = "local contribution";

	/** private singleton instance */
	private static ExtendedElementTypeSetRegistry registry;

	/** Map of retrieved extended type sets, key is their identifier */
	protected Map<String, ExtendedElementTypeSet> extendedTypeSets = null;

	/** unique resource set to load all extended types models */
	protected ResourceSet extendedTypesResourceSet = null;

	protected List<ExtendedElementTypeSet> loadedExtendedElementTypeSets = null;

	protected Map<String, IExtendedElementTypeFactory<ElementTypeConfiguration>> configurationTypeToElementTypeFactory = null;

	protected List<String> configurationTypeFactoryExceptions = null;

	/**
	 * returns the singleton instance of this registry
	 *
	 * @return the singleton instance of this registry
	 */
	public static synchronized ExtendedElementTypeSetRegistry getInstance() {
		if (registry == null) {
			// Ensure the existence of element types modeled by the Element Types Configurations
			ElementTypeSetConfigurationRegistry.getInstance();

			registry = new ExtendedElementTypeSetRegistry();
			registry.init();
		}
		return registry;
	}

	/**
	 * Inits the registry.
	 */
	protected void init() {
		// 0. Resets values
		extendedTypesResourceSet = null;
		extendedTypeSets = null;
		configurationTypeToElementTypeFactory = new HashMap<String, IExtendedElementTypeFactory<ElementTypeConfiguration>>();
		// 1. creates the resource set
		extendedTypesResourceSet = createResourceSet();
		// 2. creates the list only when registry is acceded for the first time, (or on reload?)
		extendedTypeSets = loadExtendedTypeSets();
	}

	/**
	 * Dispose this registry, i.e. remove all contribution on the element type registry
	 */
	public void dispose() {
		if (extendedTypeSets == null) {
			return;
		}
		// copy set of entries to iterate and unload them one by one
		List<Entry<String, ExtendedElementTypeSet>> entriesToDispose = new ArrayList<Entry<String, ExtendedElementTypeSet>>(extendedTypeSets.entrySet());

		for (Entry<String, ExtendedElementTypeSet> entry : entriesToDispose) {
			unload(entry.getKey());
		}
		extendedTypesResourceSet = null;
		extendedTypeSets = null;
		configurationTypeToElementTypeFactory = new HashMap<String, IExtendedElementTypeFactory<ElementTypeConfiguration>>();
		// 1. creates the resource set
		extendedTypesResourceSet = null;
		registry = null;
	}


	/**
	 * Loads a given extended type set from a given identifier
	 */
	public void loadExtendedElementTypeSet(String identifier) {
		if (getExtendedTypeSets() == null) {
			return;
		}

		// retrieve the path from the identifier
		String path = UserExtendedTypesRegistry.getInstance().getLocalExtendedTypesDefinitions().get(identifier);
		if (path == null) {
			return;
		}

		URI localURI = URI.createPlatformResourceURI(path, true);
		Resource resource = extendedTypesResourceSet.createResource(localURI);
		try {
			resource.load(null);
			EObject content = resource.getContents().get(0);
			if (content instanceof ExtendedElementTypeSet) {
				getExtendedTypeSets().put(identifier, (ExtendedElementTypeSet) content);
				loadExtendedElementTypeSet((ExtendedElementTypeSet) content);
			}
		} catch (IOException e) {
			Activator.log.error(e);
		}
	}

	/**
	 * Loads the specified extended element type set.
	 * This does not take care to unload a similar set (a set with the same id) before loading. This should be handled before calling this method.
	 *
	 * @param extendedElementTypeSet
	 *            {@link ExtendedElementTypeSet} to load.
	 */
	public void loadExtendedElementTypeSet(ExtendedElementTypeSet extendedElementTypeSet) {
		IClientContext context;
		try {
			context = TypeContext.getContext();
		} catch (ServiceException e1) {
			Activator.log.error(e1);
			return;
		}
		List<ElementTypeConfiguration> elementTypeConfigurations = extendedElementTypeSet.getElementType();
		for (ElementTypeConfiguration configuration : elementTypeConfigurations) {
			// load class associated to the configuration model => read extension point that defines this kind of configuration.
			String configurationType = configuration.eClass().getInstanceTypeName();
			// retrieve the factory for a given kind of configuration
			IExtendedElementTypeFactory<ElementTypeConfiguration> factory = configurationTypeToElementTypeFactory.get(configurationType);
			// check factory is not on the exception table
			if (factory == null && isNotInFactoryExceptionList(configurationType)) {
				Class<IExtendedElementTypeFactory<ElementTypeConfiguration>> factoryClass = retrieveFactoryClassFromExtensionPoint(configurationType);
				if (factoryClass != null) {
					try {
						factory = factoryClass.newInstance();
					} catch (InstantiationException e) {
						if (configurationTypeFactoryExceptions == null) {
							configurationTypeFactoryExceptions = new ArrayList<String>();
						}
						configurationTypeFactoryExceptions.add(configurationType);
					} catch (IllegalAccessException e) {
						if (configurationTypeFactoryExceptions == null) {
							configurationTypeFactoryExceptions = new ArrayList<String>();
						}
						configurationTypeFactoryExceptions.add(configurationType);
					}
					configurationTypeToElementTypeFactory.put(configurationType, factory);
				}
			}
			if (factory != null) {
				IExtendedHintedElementType type = factory.createElementType(configuration);
				// register element Type
				ElementTypeRegistry.getInstance().register(type);
				context.bindId(type.getId());
			}
		}
	}

	/**
	 * Unloads a given {@link ExtendedElementTypeSet}
	 *
	 * @param elementTypeSet
	 *            the element type set to unload
	 */
	public void unload(String identifier) {
		if (extendedTypeSets == null) {
			return;
		}
		ExtendedElementTypeSet elementTypeSet = extendedTypeSets.get(identifier);
		if (elementTypeSet == null) {
			// there is an entry in the map for this extended type set, it should be removed...
			extendedTypeSets.remove(identifier);
			return;
		}

		// Retrieve the element types to remove them from the registry
		ElementTypeRegistry registry = ElementTypeRegistry.getInstance();
		List<IElementType> elementTypes = new ArrayList<IElementType>(elementTypeSet.getElementType().size());
		for (ElementTypeConfiguration configuration : elementTypeSet.getElementType()) {
			if (configuration != null && configuration.getIdentifier() != null) {
				String configIdentifier = configuration.getIdentifier();
				// retrieve element type
				IElementType elementType = registry.getType(configIdentifier);
				if (elementType != null) {
					elementTypes.add(elementType);
				}
			}
		}

		// And remove them
		ElementTypeUtil.deregisterElementTypes(elementTypes, ElementTypeUtil.ALL_DEPENDENTS);

		// Then unload the configuration model
		Resource resource = elementTypeSet.eResource();
		if (resource != null) {
			resource.unload();
			if (extendedTypesResourceSet != null) {
				extendedTypesResourceSet.getResources().remove(resource);
			}
		}
		extendedTypeSets.remove(identifier);
	}

	protected void removeAdviceFromBindings(SpecializationTypeRegistry registry, String adviceDescriptorId, IEditHelperAdviceDescriptor adviceDescriptor) {
		ElementTypeRegistry.getInstance().deregisterAdvice(adviceDescriptor);
	}




	/**
	 * check this configuration type has not already caused issues du
	 *
	 * @param configurationType
	 * @return
	 */
	protected boolean isNotInFactoryExceptionList(String configurationType) {
		if (configurationTypeFactoryExceptions == null) {
			return true;
		}
		// this is not null, check the configuration type is not in the list
		return !configurationTypeFactoryExceptions.contains(configurationType);
	}

	/**
	 * Returns the {@link IExtendedElementTypeFactory} class used to instantiate element type for the given configuration
	 *
	 * @return the {@link IExtendedElementTypeFactory} found or <code>null</code> if none was found
	 */
	@SuppressWarnings("unchecked")
	protected Class<IExtendedElementTypeFactory<ElementTypeConfiguration>> retrieveFactoryClassFromExtensionPoint(String configurationType) {
		IConfigurationElement[] elements = Platform.getExtensionRegistry().getConfigurationElementsFor(IExtendedTypeConfigurationExtensionPoint.EXTENSION_POINT_ID);
		for (IConfigurationElement configurationElement : elements) {
			String eCoreClassName = configurationElement.getAttribute(IExtendedTypeConfigurationExtensionPoint.CONFIGURATION_CLASS);
			if (configurationType.equals(eCoreClassName)) {
				// retrieve factory to load
				String factoryClassName = configurationElement.getAttribute(IExtendedTypeConfigurationExtensionPoint.FACTORY_CLASS);
				return (Class<IExtendedElementTypeFactory<ElementTypeConfiguration>>) loadClass(factoryClassName, configurationElement.getContributor().getName());
			}
		}
		return null;
	}

	/**
	 * Retrieves and loads extended type sets registered in the platform. It should also load configuration sets from the workspace.
	 */
	protected Map<String, ExtendedElementTypeSet> loadExtendedTypeSets() {
		Map<String, ExtendedElementTypeSet> extendedElementTypeSets = new HashMap<String, ExtendedElementTypeSet>();
		// 1. retrieve from the workspace
		Map<String, ExtendedElementTypeSet> localSets = loadExtendedTypeSetsFromWorkspace();
		if (localSets != null && !localSets.isEmpty()) {
			extendedElementTypeSets.putAll(localSets);
		}

		// 2. retrieve from the platform. If already in workspace (id), do not load the platform ones
		Map<String, ExtendedElementTypeSet> registeredSets = loadExtendedTypeSetsFromPlatform(localSets.keySet());
		if (registeredSets != null && !registeredSets.isEmpty()) {
			extendedElementTypeSets.putAll(registeredSets);
		}
		// load each extended element type set
		for (Entry<String, ExtendedElementTypeSet> entry : extendedElementTypeSets.entrySet()) {
			loadExtendedElementTypeSet(entry.getValue());
		}
		return extendedElementTypeSets;
	}

	/**
	 * @return
	 */
	protected Map<String, ExtendedElementTypeSet> loadExtendedTypeSetsFromWorkspace() {
		Map<String, String> localFilesPath = UserExtendedTypesRegistry.getInstance().getLocalExtendedTypesDefinitions();
		Map<String, ExtendedElementTypeSet> workspaceElementTypeSets = new HashMap<String, ExtendedElementTypeSet>();
		if (localFilesPath != null && !localFilesPath.isEmpty()) {
			for (Entry<String, String> idToPath : localFilesPath.entrySet()) {
				String filePath = idToPath.getValue();
				String id = idToPath.getKey();

				URI localURI = URI.createPlatformResourceURI(filePath, true);
				Resource resource = extendedTypesResourceSet.createResource(localURI);
				try {
					resource.load(null);
					EObject content = resource.getContents().get(0);
					if (content instanceof ExtendedElementTypeSet) {
						workspaceElementTypeSets.put(id, (ExtendedElementTypeSet) content);
					}
				} catch (IOException e) {
					Activator.log.error(e);
				}
			}
		}
		return workspaceElementTypeSets;
	}

	/**
	 * Loads the extensions in the platform
	 *
	 * @return the list of extension registered in the platform
	 */
	protected Map<String, ExtendedElementTypeSet> loadExtendedTypeSetsFromPlatform(Set<String> workspaceDefinitions) {
		Map<String, ExtendedElementTypeSet> platformElementTypeSets = new HashMap<String, ExtendedElementTypeSet>();
		IConfigurationElement[] elements = Platform.getExtensionRegistry().getConfigurationElementsFor(IExtendedElementTypeSetExtensionPoint.EXTENSION_POINT_ID);
		// for each element, parses and retrieve the model file. then loads it and returns the root element
		for (IConfigurationElement element : elements) {
			String modelPath = element.getAttribute(IExtendedElementTypeSetExtensionPoint.PATH);
			String extendedTypeSetId = element.getAttribute(IExtendedElementTypeSetExtensionPoint.ID);
			String contributorID = element.getContributor().getName();
			if (Platform.inDebugMode()) {
				Activator.log.debug("[Reading extension point]");
				Activator.log.debug("-  Path to the model: " + modelPath);
				Activator.log.debug("-  id of the container bundle: " + contributorID);
				Activator.log.debug("-  id of the extended type set: " + extendedTypeSetId);
			}
			ExtendedElementTypeSet set = getExtendedElementTypeSet(extendedTypeSetId, modelPath, contributorID);
			if (set != null && !workspaceDefinitions.contains(extendedTypeSetId)) { // do not add if it is locally redefined
				platformElementTypeSets.put(extendedTypeSetId, set);
			}
		}
		return platformElementTypeSets;
	}

	/**
	 * <p>
	 * Loads the resource containing the extended element type set model.
	 * </p>
	 * <p>
	 * It looks the model file in the fragments first, then in the plugin itself.<BR>
	 * If this is already a fragment, it should look in the fragment only
	 * </p>
	 *
	 * @param extendedTypesID
	 *            id of the extended type set to load
	 * @param modelPath
	 *            path of the model in the bundle
	 * @param bundleId
	 *            id of the bundle containing the model file
	 * @return the loaded file or <code>null</code> if some problem occured during loading
	 */
	protected ExtendedElementTypeSet getExtendedElementTypeSet(String extendedTypesID, String modelPath, String bundleId) {
		// 1. look in preferences.
		String filePath = UserExtendedTypesRegistry.getInstance().getExtendedTypesRedefinition(extendedTypesID);
		if (filePath != null) {
			getExtendedElementTypeSetInPluginStateArea(extendedTypesID);
		}
		// 2. no local redefinition. Load extended type set from plugin definition
		Bundle bundle = Platform.getBundle(bundleId);
		if (Platform.isFragment(bundle)) {
			return getExtendedElementTypeSetInBundle(modelPath, bundleId);
		} else { // this is a plugin. Search in sub fragments, then in the plugin
			Bundle[] fragments = Platform.getFragments(bundle);
			// no fragment, so the file should be in the plugin itself
			if (fragments == null) {
				return getExtendedElementTypeSetInBundle(modelPath, bundleId);
			} else {
				for (Bundle fragment : fragments) {
					ExtendedElementTypeSet extendedElementTypeSet = getExtendedElementTypeSetInBundle(modelPath, fragment.getSymbolicName());
					if (extendedElementTypeSet != null) {
						return extendedElementTypeSet;
					}
				}
				// not found in fragments. Look in the plugin itself
				return getExtendedElementTypeSetInBundle(modelPath, bundleId);
			}
		}
	}

	/**
	 * Retrieves the contribution in the plugin area
	 *
	 * @param path
	 *            the path of the element type set to load in the plugin area
	 */
	protected ExtendedElementTypeSet getExtendedElementTypeSetInPluginStateArea(String path) {
		// read in preferences area
		IPath resourcePath = Activator.getDefault().getStateLocation().append(path);
		URI uri = URI.createFileURI(resourcePath.toOSString());
		if (uri != null && uri.isFile()) {
			Resource resource = extendedTypesResourceSet.createResource(uri);
			try {
				resource.load(null);
			} catch (IOException e) {
				return null;
			}
			EObject content = resource.getContents().get(0);
			if (content instanceof ExtendedElementTypeSet) {
				return (ExtendedElementTypeSet) content;
			}
			Activator.log.error("Impossible to cast the object into an ExtendedElementTypeSet: " + content, null);
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
	protected ExtendedElementTypeSet getExtendedElementTypeSetInBundle(String modelPath, String bundleID) {
		Resource resource = extendedTypesResourceSet.createResource(URI.createPlatformPluginURI(bundleID + IPath.SEPARATOR + modelPath, true));
		try {
			resource.load(null);
		} catch (IOException e) {
			return null;
		}
		EObject content = resource.getContents().get(0);
		if (content instanceof ExtendedElementTypeSet) {
			return (ExtendedElementTypeSet) content;
		}
		Activator.log.error("Impossible to cast the object into an ExtendedElementTypeSet: " + content, null);
		return null;
	}

	/**
	 * Creates the resource set that contains all models for extended types
	 *
	 * @return the resource set newly created.
	 */
	protected ResourceSet createResourceSet() {
		ResourceSet set = new ResourceSetImpl();
		return set;
	}

	/**
	 * @return the extendedTypeSets
	 */
	public Map<String, ExtendedElementTypeSet> getExtendedTypeSets() {
		return extendedTypeSets;
	}
}
