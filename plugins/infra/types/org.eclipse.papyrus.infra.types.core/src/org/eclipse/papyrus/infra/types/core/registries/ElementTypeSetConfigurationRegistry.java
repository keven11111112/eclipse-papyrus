/*****************************************************************************
 * Copyright (c) 2014, 2015 CEA LIST, Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *  Christian W. Damus - bug 459174
 *  Christian W. Damus - bug 467207
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.types.core.registries;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gmf.runtime.emf.type.core.ClientContextManager;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeUtil;
import org.eclipse.gmf.runtime.emf.type.core.IAdviceBindingDescriptor;
import org.eclipse.gmf.runtime.emf.type.core.IClientContext;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IMetamodelType;
import org.eclipse.gmf.runtime.emf.type.core.ISpecializationType;
import org.eclipse.gmf.runtime.emf.type.core.NullElementType;
import org.eclipse.papyrus.infra.types.AbstractAdviceBindingConfiguration;
import org.eclipse.papyrus.infra.types.AdviceConfiguration;
import org.eclipse.papyrus.infra.types.ElementTypeConfiguration;
import org.eclipse.papyrus.infra.types.ElementTypeSetConfiguration;
import org.eclipse.papyrus.infra.types.ExternallyRegisteredAdvice;
import org.eclipse.papyrus.infra.types.SpecializationTypeConfiguration;
import org.eclipse.papyrus.infra.types.core.Activator;
import org.eclipse.papyrus.infra.types.core.extensionpoints.IElementTypeSetExtensionPoint;
import org.eclipse.papyrus.infra.types.core.utils.ElementTypeRegistryUtils;
import org.eclipse.papyrus.infra.types.core.utils.OrientedGraph;
import org.eclipse.papyrus.infra.types.core.utils.TypesConfigurationsCycleUtil;
import org.osgi.framework.Bundle;

/**
 * Registry to manage load/unloaded {@link ElementTypeSetConfiguration}.
 */
public class ElementTypeSetConfigurationRegistry {

	protected static ElementTypeSetConfigurationRegistry elementTypeSetConfigurationRegistry;

	/** Map of retrieved elementType sets, key is their identifier */
	protected Map<String, Map<String, ElementTypeSetConfiguration>> elementTypeSetConfigurations = null;

	protected OrientedGraph<String> advicesDeps = null;


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
		elementTypeSetConfigurations = new HashMap<String, Map<String, ElementTypeSetConfiguration>>();
		// 1. creates the resource set
		elementTypeSetConfigurationResourceSet = createResourceSet();
		// 2. creates the list only when registry is acceded for the first time,
		Map<String, Set<ElementTypeSetConfiguration>> elementTypeSetConfigurationsToLoad = readElementTypeSetConfigurationModelsFromExtensionPoints();
		// Try to load all elementType set definitions
		for (String contexId : elementTypeSetConfigurationsToLoad.keySet()) {
			loadElementTypeSetConfigurations(contexId, elementTypeSetConfigurationsToLoad.get(contexId));
		}

	}


	protected Map<String, Set<ElementTypeSetConfiguration>> readElementTypeSetConfigurationModels() {
		Map<String, Set<ElementTypeSetConfiguration>> elementTypeSetConfigurations = new HashMap<String, Set<ElementTypeSetConfiguration>>();



		return elementTypeSetConfigurations;
	}

	/**
	 * Dispose this registry, i.e. remove all contribution on the elementType registry.
	 */
	public synchronized void dispose() {
		if (elementTypeSetConfigurations == null) {
			return;
		}

		for (String contextId : elementTypeSetConfigurations.keySet()) {
			for (String elementTypeSetId : elementTypeSetConfigurations.get(contextId).keySet()) {
				unload(contextId, elementTypeSetId);
			}

		}
		elementTypeSetConfigurationResourceSet = null;
		elementTypeSetConfigurations = null;
		elementTypeSetConfigurationRegistry = null;
	}

	/**
	 * Loads a given elementType set from a given identifier
	 */
	public boolean loadElementTypeSetConfiguration(String contextId, String path) {

		if (path == null) {
			Activator.log.warn("Path must not be null" + path);
			return false;
		}

		if (contextId == null) {
			Activator.log.warn("contextId must not be null" + path);
			return false;
		}
		URI localURI = URI.createPlatformResourceURI(path, true);
		Resource resource = elementTypeSetConfigurationResourceSet.createResource(localURI);
		try {
			resource.load(null);
			EObject content = resource.getContents().get(0);
			if (content instanceof ElementTypeSetConfiguration) {
				return loadElementTypeSetConfiguration(contextId, (ElementTypeSetConfiguration) content);
			}
		} catch (IOException e) {
			Activator.log.error(e);
		}

		return false;

	}

	public boolean loadElementTypeSetConfiguration(String clientContextID, ElementTypeSetConfiguration elementTypeSetConfiguration) {
		return loadElementTypeSetConfigurations(clientContextID, Collections.singleton(elementTypeSetConfiguration));
	}

	public OrientedGraph<String> getAdvicesDeps() {
		if (advicesDeps == null) {
			advicesDeps = new OrientedGraph<>();
		}
		return advicesDeps;
	}

	protected boolean isAlreadyRegistred(String elementTypeID, IClientContext context) {
		if (ElementTypeRegistry.getInstance().getType(elementTypeID) != null) {
			if (!elementTypeID.equals(NullElementType.ID)) {
				if (ElementTypeRegistryUtils.getType(context, elementTypeID) == null) {
					// The elementType is already existing but not binded yet
					context.bindId(elementTypeID);
					Activator.log.info(elementTypeID + " is already registred elementtype but it is not binded yet. It has been binded to Papyrus context. ");
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

	public boolean loadElementTypeSetConfigurations(String contexId, Collection<ElementTypeSetConfiguration> elementTypeSetConfigurationsToRegister) {

		if (contexId == null) {
			Activator.log.warn("contexId must not be null. Loading aborted. ");
			return false;
		}

		IClientContext context = ClientContextManager.getInstance().getClientContext(contexId);
		if (context == null) {
			Activator.log.warn("contexId couldn't be found. Loading aborted: " + contexId);
			return false;
		}

		Map<String, ElementTypeConfiguration> elementTypeConfigurationsDefinitions = new HashMap<String, ElementTypeConfiguration>();



		// Read from elementTypeSetConfigurations
		Set<ElementTypeSetConfiguration> registrableElementTypeSetConfiguration = new HashSet<ElementTypeSetConfiguration>();
		for (ElementTypeSetConfiguration elementTypeSetConfiguration : elementTypeSetConfigurationsToRegister) {
			if (elementTypeSetConfiguration == null) {
				Activator.log.warn("The collection of elementTypesconfigurations contains a null value. Loading aborted. ");
				return false;
			}
			// Check if not already registered
			if (elementTypeSetConfigurations.containsKey(elementTypeSetConfiguration.getIdentifier())) {
				Activator.log.warn("The following ElementTypesSetConfiguration has been ignored because the same ID already registreted: " + elementTypeSetConfiguration.getIdentifier());
			} else {
				registrableElementTypeSetConfiguration.add(elementTypeSetConfiguration);
				for (ElementTypeConfiguration elementTypeConfiguration : elementTypeSetConfiguration.getElementTypeConfigurations()) {
					elementTypeConfigurationsDefinitions.put(elementTypeConfiguration.getIdentifier(), elementTypeConfiguration);
				}
			}
		}

		// Check there is no cyclic dependencies among elementTypes introduced by this loading
		HashSet<ElementTypeConfiguration> elementTypesToCheck = new HashSet<ElementTypeConfiguration>();
		// The old ones already registered
		if (elementTypeSetConfigurations.containsKey(contexId)) {
			for (ElementTypeSetConfiguration elementTypeSetConfiguration : elementTypeSetConfigurations.get(contexId).values()) {
				elementTypesToCheck.addAll(elementTypeSetConfiguration.getElementTypeConfigurations());
			}
		}
		// The new ones we wan to register
		elementTypesToCheck.addAll(elementTypeConfigurationsDefinitions.values());
		OrientedGraph<String> elementTypesDeps = TypesConfigurationsCycleUtil.getDependenciesAmongElementTypes(elementTypesToCheck);

		Collection<Collection<Object>> cyclesElementTypes = TypesConfigurationsCycleUtil.getCyclesAmongElementTypes(elementTypesDeps.getVertices(), elementTypesDeps.getEdges());
		if (!cyclesElementTypes.isEmpty()) {
			Activator.log.warn("The ElementTypesConfiguration registration has been aborted because there is at least a cyclic-dependency in the ElementTypes definitions: " + cyclesElementTypes);
			return false;
		}

		// Collect all advicesconfiguration
		HashSet<AdviceConfiguration> adviceToCheck = new HashSet<AdviceConfiguration>();
		// The old ones already registered
		if (elementTypeSetConfigurations.containsKey(contexId)) {
			for (ElementTypeSetConfiguration elementTypeSetConfiguration : elementTypeSetConfigurations.get(contexId).values()) {
				TreeIterator<EObject> it = elementTypeSetConfiguration.eAllContents();
				while (it.hasNext()) {
					EObject element = (EObject) it.next();
					if (element instanceof AdviceConfiguration) {
						adviceToCheck.add((AdviceConfiguration) element);
					}

				}
			}
		}
		// The new ones we want to register
		for (ElementTypeSetConfiguration elementTypeSetConfiguration : registrableElementTypeSetConfiguration) {
			TreeIterator<EObject> it = elementTypeSetConfiguration.eAllContents();
			while (it.hasNext()) {
				EObject element = (EObject) it.next();
				if (element instanceof AdviceConfiguration) {
					adviceToCheck.add((AdviceConfiguration) element);

				}
			}
		}

		// Check that there is no cyclic dependencies among advices introduced by this loading
		advicesDeps = TypesConfigurationsCycleUtil.getDependenciesAmongAdvices(adviceToCheck);
		Collection<Collection<Object>> cyclesAdvices = TypesConfigurationsCycleUtil.getCyclesInAdvices(advicesDeps.getVertices(), advicesDeps.getEdges());
		if (!cyclesAdvices.isEmpty()) {
			Activator.log.warn("The ElementTypesConfiguration registration has been aborted because there is at least a cyclic-dependencies in the Advices definitions: " + cyclesAdvices);
			return false;
		}

		// If we reached that point, we should be able to register safely the none already registered elementTypeSets
		for (ElementTypeSetConfiguration elementTypeSetConfiguration : registrableElementTypeSetConfiguration) {
			if (!elementTypeSetConfigurations.containsKey(contexId)) {
				elementTypeSetConfigurations.put(contexId, new HashMap<String, ElementTypeSetConfiguration>());
			}
			elementTypeSetConfigurations.get(contexId).put(elementTypeSetConfiguration.getIdentifier(), elementTypeSetConfiguration);
		}

		// New ElementTypesConfigurations can be registered
		for (ElementTypeConfiguration elementTypeConfiguration : elementTypeConfigurationsDefinitions.values()) {
			registerElementTypeConfiguration(elementTypeConfiguration, elementTypeConfigurationsDefinitions, context);
		}

		// Register adviceBindings
		for (ElementTypeSetConfiguration elementTypeSetConfiguration : registrableElementTypeSetConfiguration) {
			List<AbstractAdviceBindingConfiguration> adviceBindingConfigurations = elementTypeSetConfiguration.getAdviceBindingsConfigurations();
			for (AbstractAdviceBindingConfiguration adviceBindingConfiguration : adviceBindingConfigurations) {
				if (adviceBindingConfiguration instanceof ExternallyRegisteredAdvice) {
					context.bindId(adviceBindingConfiguration.getIdentifier());
				} else {
					IAdviceBindingDescriptor editHelperAdviceDecriptor = AdviceConfigurationTypeRegistry.getInstance().getEditHelperAdviceDecriptor(adviceBindingConfiguration);
					ElementTypeRegistryUtils.registerAdviceBinding(editHelperAdviceDecriptor);
					context.bindId(editHelperAdviceDecriptor.getId());
				}
			}
		}

		return true;
	}


	public boolean unload(String contextId, String elementTypeSetId) {
		if (elementTypeSetConfigurations == null) {
			return false;
		}
		if (!elementTypeSetConfigurations.containsKey(contextId)) {
			return false;
		}
		Map<String, ElementTypeSetConfiguration> map = elementTypeSetConfigurations.get(contextId);
		ElementTypeSetConfiguration elementTypeSet = map.remove(elementTypeSetId);
		if (elementTypeSet == null) {
			return false;
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
		List<AbstractAdviceBindingConfiguration> adviceBindingConfigurations = elementTypeSet.getAdviceBindingsConfigurations();
		for (AbstractAdviceBindingConfiguration adviceBindingConfiguration : adviceBindingConfigurations) {
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

		// Recompute adviceDependencies
		HashSet<AdviceConfiguration> advices = new HashSet<AdviceConfiguration>();
		// The ones still registered
		for (ElementTypeSetConfiguration elementTypeSetConfiguration : elementTypeSetConfigurations.get(contextId).values()) {
			TreeIterator<EObject> it = elementTypeSetConfiguration.eAllContents();
			while (it.hasNext()) {
				EObject element = (EObject) it.next();
				if (element instanceof AdviceConfiguration) {
					advices.add((AdviceConfiguration) element);
				}

			}
		}
		advicesDeps = TypesConfigurationsCycleUtil.getDependenciesAmongAdvices(advices);

		return true;
	}



	protected void addElementTypeSetConfigurationToDefinitions(ElementTypeSetConfiguration set, String clientContextId, Map<String, Set<ElementTypeSetConfiguration>> existingDefinitions) {
		if (set.getIdentifier() == null) {
			Activator.log.warn("The following ElementTypesSetConfiguration has ill-defined ID and is therefore ignored: " + set.eResource().getURI());
		} else {
			if (set != null) {
				if (existingDefinitions.get(clientContextId) != null && containsElementTypeSet(existingDefinitions.get(clientContextId), set.getIdentifier())) {
					Activator.log.warn("The following ElementTypesSetConfiguration has been ignored because the same ID already registreted: " + set.getIdentifier());
				} else {
					if (!existingDefinitions.containsKey(clientContextId)) {
						existingDefinitions.put(clientContextId, new HashSet<ElementTypeSetConfiguration>());
					}
					existingDefinitions.get(clientContextId).add(set);
				}
			}
		}
	}

	protected Map<String, Set<ElementTypeSetConfiguration>> readElementTypeSetConfigurationModelsFromExtensionPoints() {
		Map<String, Set<ElementTypeSetConfiguration>> existingDefinitions = new HashMap<>();
		IConfigurationElement[] elements = Platform.getExtensionRegistry().getConfigurationElementsFor(IElementTypeSetExtensionPoint.EXTENSION_POINT_ID);
		// for each element, parses and retrieve the model file. then loads it and returns the root element
		for (IConfigurationElement element : elements) {
			String modelPath = element.getAttribute(IElementTypeSetExtensionPoint.PATH);
			String clientContextId = element.getAttribute(IElementTypeSetExtensionPoint.CLIENT_CONTEXT_ID);
			String contributorID = element.getContributor().getName();
			if (Platform.inDebugMode()) {
				Activator.log.debug("[Reading extension point]");
				Activator.log.debug("-  Path to the model: " + modelPath);
				Activator.log.debug("-  ClientContext the model should be registreted to: " + clientContextId);
				Activator.log.debug("-  id of the container bundle: " + contributorID);
			}
			ElementTypeSetConfiguration set = getElementTypeSetConfiguration(modelPath, contributorID);

			if (set != null) {
				addElementTypeSetConfigurationToDefinitions(set, clientContextId, existingDefinitions);
			}

		}
		return existingDefinitions;
	}

	protected boolean containsElementTypeSet(Set<ElementTypeSetConfiguration> elementTypeSets, String elementTypeSetConfigurationId) {
		if (elementTypeSets == null) {
			return false;
		}

		for (ElementTypeSetConfiguration elementTypeSetConfiguration : elementTypeSets) {
			if (elementTypeSetConfiguration.getIdentifier().equals(elementTypeSetConfigurationId)) {
				return true;
			}
		}
		return false;
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
	protected ElementTypeSetConfiguration getElementTypeSetConfiguration(String modelPath, String bundleId) {

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

	public Map<String, Map<String, ElementTypeSetConfiguration>> getElementTypeSetConfigurations() {
		return elementTypeSetConfigurations;
	}
}
