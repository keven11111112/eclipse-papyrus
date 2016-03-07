/*****************************************************************************
 * Copyright (c) 2011, 2016 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *
 *  CEA LIST - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 422257
 *  Mickael ADAM (ALL4TEC) mickael.adam@all4tec.net - bug 487199
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.newchild;

import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.papyrus.infra.newchild.elementcreationmenumodel.ElementCreationMenuModelPackage;
import org.eclipse.papyrus.infra.newchild.elementcreationmenumodel.Folder;
import org.eclipse.papyrus.infra.newchild.messages.Messages;
import org.osgi.framework.Bundle;

/**
 * This class is used to load all extension point call org.eclipse.papyrus.infra.newchild
 * It gives the set of all Folder that has to be displayed
 */
public class CreationMenuRegistry {

	/** The registry. */
	protected static CreationMenuRegistry creationMenuRegistry;

	/** The extension id. */
	private final String MENU_CREATION_MODEL_EXTENSION_ID = "org.eclipse.papyrus.infra.newchild"; //$NON-NLS-1$

	/** The model id. */
	private final String MODEL_ID = "model"; //$NON-NLS-1$

	/** the folders collection. */
	private List<Folder> rootFolders = new ArrayList<Folder>();

	/** the resource set. */
	private static ResourceSetImpl resourceSet;

	/**
	 * returns the singleton instance of this registry
	 *
	 * @return the singleton instance of this registry
	 */
	public static synchronized CreationMenuRegistry getInstance() {
		if (null == creationMenuRegistry) {
			creationMenuRegistry = new CreationMenuRegistry();
			creationMenuRegistry.init();
		}
		return creationMenuRegistry;
	}

	/**
	 * Constructor.
	 */
	public CreationMenuRegistry() {
	}

	/**
	 * this method load the extension points and initialize resource set.
	 */
	public void init() {
		// Obtain a new resource set
		resourceSet = new ResourceSetImpl();
		resourceSet.getPackageRegistry().put(ElementCreationMenuModelPackage.eINSTANCE.getNsURI(), ElementCreationMenuModelPackage.eINSTANCE);

		// Reading data from plugins
		IConfigurationElement[] configElements = Platform.getExtensionRegistry().getConfigurationElementsFor(MENU_CREATION_MODEL_EXTENSION_ID);
		for (int i = 0; i < configElements.length; i++) {
			rootFolders.add(initializeOneModel(configElements[i]));
		}

	}

	/**
	 * @return the set of root folders
	 */
	public List<Folder> getRootFolder() {
		return rootFolders;
	}

	/**
	 * Load one model
	 *
	 * @param element
	 *            the extension point
	 * @return the Folder
	 */
	private Folder initializeOneModel(final IConfigurationElement element) {
		try {
			return createExtension(element, element.getAttribute(MODEL_ID));

		} catch (Exception e) {
			Activator.log.error(Messages.CreationMenuRegistry_Error_ModelCanBeLoaded, e);
		}
		return null;
	}

	/**
	 * Load the {@link Folder} of the CreationMenuModel from the {@link URI}.
	 * 
	 * @param uri
	 *            the uri of the model file to load
	 * @throws Exception
	 */
	public void loadCreationMenuModel(final URI uri) throws Exception {
		// unload before add it;
		unloadCreationMenuModel(uri);
		try {
			rootFolders.add(getCreationMenuModel(uri));
		} catch (URISyntaxException e) {
			throw new Exception(Messages.CreationMenuRegistry_Error_UnableToLoadCreationMenu + e);
		}
	}

	/**
	 * Unload the {@link Folder} of the CreationMenuModel from the {@link URI}.
	 * This is done by removing all {@link Folder} with the same Label.
	 * 
	 * @param uri
	 *            the uri of the model file to unload
	 * @throws Exception
	 */
	public void unloadCreationMenuModel(final URI uri) throws Exception {
		try {
			Folder creationMenuModel = getCreationMenuModel(uri);

			// get all folders with the same Label
			Object[] array = rootFolders.stream().filter(f -> f.getLabel().equals(creationMenuModel.getLabel())).toArray();

			// Remove them from registry
			rootFolders.removeAll(Arrays.asList(array));

		} catch (URISyntaxException e) {
			throw new Exception(Messages.CreationMenuRegistry_Error_UnableToUnloadCreationMenu + e);
		}
	}

	/**
	 * Load a resource instanceof ElementCreationMenuModel
	 *
	 * @param resourceSet
	 *            the resource set in which to load the menu model
	 * @param element
	 *            the extension point
	 * @param classAttribute
	 *            the name of the resource to load
	 * @return the loaded Folder
	 * @throws Exception
	 *             if the resource is not loaded
	 */
	private static Folder createExtension(final IConfigurationElement element, final String classAttribute) throws Exception {
		Folder folder = null;
		try {
			Bundle extensionBundle = Platform.getBundle(element.getDeclaringExtension().getNamespaceIdentifier());
			URL url = extensionBundle.getResource(classAttribute);
			if (url != null) {
				URI uri = URI.createURI(url.toURI().toASCIIString());
				folder = getCreationMenuModel(uri);
			}

		} catch (URISyntaxException e) {
			throw new Exception(Messages.CreationMenuRegistry_Error_UnableToCreateExtension + e);
		}
		return folder;
	}

	/**
	 * 
	 * @param uri
	 *            The uri of the fle of the model.
	 * @return the root {@link Folder} from the model CreationMenuModel
	 * @throws URISyntaxException
	 */
	private static Folder getCreationMenuModel(final URI uri) throws URISyntaxException {
		Folder folder = null;
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());

		// Get the resource
		Resource resource = resourceSet.getResource(uri, true);
		if (null != resource.getContents() && 0 < resource.getContents().size() && resource.getContents().get(0) instanceof Folder) {
			folder = (Folder) resource.getContents().get(0);
		}

		return folder;
	}
}