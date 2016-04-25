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

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.ConfigurationScope;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.papyrus.infra.newchild.elementcreationmenumodel.ElementCreationMenuModelPackage;
import org.eclipse.papyrus.infra.newchild.elementcreationmenumodel.Folder;
import org.eclipse.papyrus.infra.newchild.messages.Messages;
import org.osgi.framework.Bundle;
import org.osgi.service.prefs.BackingStoreException;
import org.osgi.service.prefs.Preferences;

/**
 * This class is used to load all extension point call org.eclipse.papyrus.infra.newchild
 * It gives the set of all Folder that has to be displayed
 */
public class CreationMenuRegistry {

	/** The default visibility of folders */
	private static final boolean DEFAULT_VISIBILITY = true;

	/** The registry. */
	protected static CreationMenuRegistry creationMenuRegistry;

	/** The extension id. */
	private final String MENU_CREATION_MODEL_EXTENSION_ID = "org.eclipse.papyrus.infra.newchild"; //$NON-NLS-1$

	/** The model id. */
	private final String MODEL_ID = "model"; //$NON-NLS-1$

	/** The tool id. */
	private final String ID = "id"; //$NON-NLS-1$

	/** preferences which contain visible folder */
	private Preferences preferences;

	/** the folders collection. */
	private Map<String, Folder> rootFolders = new HashMap<>();

	/** Default values of folder visibilities */
	private Map<String, Boolean> defaultValues = new HashMap<>();

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

		// Preference init
		preferences = ConfigurationScope.INSTANCE.getNode(Activator.PLUGIN_ID);

		// Reading data from plugins
		IConfigurationElement[] configElements = Platform.getExtensionRegistry().getConfigurationElementsFor(MENU_CREATION_MODEL_EXTENSION_ID);
		for (int i = 0; i < configElements.length; i++) {
			initializeOneModel(configElements[i]);
		}

	}

	/**
	 * @return the set of root folders
	 */
	public List<Folder> getRootFolder() {
		return new ArrayList<>(rootFolders.values());
	}

	/**
	 * Return the id of the folder if is loaded.
	 */
	public String getFolderId(Folder folder) {
		String id = "";//$NON-NLS-1$

		Iterator<Entry<String, Folder>> entrySet = rootFolders.entrySet().iterator();
		while (entrySet.hasNext()) {
			Entry<String, Folder> entry = entrySet.next();
			if (folder.equals(entry.getValue())) {
				id = entry.getKey();
			}
		}

		return id;
	}

	/**
	 * Load one model.
	 *
	 * @param element
	 *            the extension point
	 * @return the Folder
	 */
	private Folder initializeOneModel(final IConfigurationElement element) {
		Folder folder = null;
		try {
			folder = createExtension(element, element.getAttribute(MODEL_ID));
		} catch (Exception e) {
			Activator.log.error(Messages.CreationMenuRegistry_Error_ModelCanBeLoaded, e);
		}
		return folder;
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
			Folder folder = getCreationMenuModel(uri);
			String creationMenuId = getCreationMenuId(uri);
			rootFolders.put(creationMenuId, folder);
			defaultValues.put(creationMenuId, folder.isVisible());

			folder.setVisible(getPreferedVisibility(uri, DEFAULT_VISIBILITY));

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
		String creationMenuModelId = getCreationMenuId(uri);

		rootFolders.remove(creationMenuModelId);
		defaultValues.remove(creationMenuModelId);
		preferences.remove(creationMenuModelId);
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
	private Folder createExtension(final IConfigurationElement element, final String classAttribute) throws Exception {
		Folder folder = null;
		try {
			Bundle extensionBundle = Platform.getBundle(element.getDeclaringExtension().getNamespaceIdentifier());
			URL url = extensionBundle.getResource(classAttribute);
			if (null != url) {
				URI uri = URI.createURI(url.toURI().toASCIIString());

				String creationMenuId = getCreationMenuId(uri);
				folder = getCreationMenuModel(uri);
				defaultValues.put(creationMenuId, folder.isVisible());

				String visible = preferences.get(creationMenuId, "true"); //$NON-NLS-1$
				folder.setVisible(Boolean.valueOf(visible));

				rootFolders.put(creationMenuId, folder);
			}

		} catch (URISyntaxException e) {
			throw new Exception(Messages.CreationMenuRegistry_Error_UnableToCreateExtension + e);
		}
		return folder;
	}

	/**
	 * Get the creation menu id from a {@link URI}.
	 */
	public String getCreationMenuId(URI uri) {

		// FileLocator.resolve(url)(url).getPath();

		String bundleId = "";//$NON-NLS-1$
		String relativePath = "";//$NON-NLS-1$
		String fileName = uri.lastSegment();

		try {
			// Bundle id
			URL url = new URL(uri.toString());
			String absolutePath = FileLocator.resolve(url).getPath();
			String replace = absolutePath.replace(url.getPath(), "");//$NON-NLS-1$
			int lastIndexOf = replace.lastIndexOf("/");//$NON-NLS-1$
			bundleId = replace.substring(lastIndexOf + 1, replace.length());
			// relative path
			relativePath = url.getPath().replace(fileName, "");//$NON-NLS-1$
		} catch (MalformedURLException e) {
			Activator.log.error(e);
		} catch (IOException e) {
			Activator.log.error(e);
		}

		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(fileName);
		stringBuilder.append(" - ");//$NON-NLS-1$
		stringBuilder.append(bundleId);
		stringBuilder.append(relativePath);

		return stringBuilder.toString();
	}

	/**
	 * @param uri
	 *            The uri of the file of the model.
	 * @return the root {@link Folder} from the model CreationMenuModel.
	 * @throws URISyntaxException
	 */
	private Folder getCreationMenuModel(final URI uri) throws URISyntaxException {
		Folder folder = null;
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());

		// Get the resource
		Resource resource = resourceSet.getResource(uri, true);
		if (null != resource.getContents() && 0 < resource.getContents().size() && resource.getContents().get(0) instanceof Folder) {
			folder = (Folder) resource.getContents().get(0);
		}

		return folder;
	}

	/**
	 * Set the visibility of a menu by its id.
	 * 
	 * @param id
	 *            The id.
	 * @param visibility
	 *            The visibility to set.
	 */
	public void setCreationMenuVisibility(final String id, final Boolean visibility) {
		preferences.put(id, String.valueOf(visibility));
		rootFolders.get(id).setVisible(visibility);
		try {
			// forces the application to save the preferences
			preferences.flush();
		} catch (BackingStoreException e) {
			Activator.log.error(e);
		}
	}

	/**
	 * Set the creation menu visibility by its folder model.
	 * 
	 * @param folder
	 *            The folder.
	 * @param visibility
	 *            The visibility to set.
	 */
	public void setCreationMenuVisibility(final Folder folder, final Boolean visibility) {
		Set<Entry<String, Folder>> entrySet = rootFolders.entrySet();

		for (Entry<String, Folder> entry : entrySet) {
			if (folder.equals(entry.getValue())) {
				setCreationMenuVisibility(entry.getKey(), visibility);
			}
		}
	}

	/**
	 * Gets the visibility of a {@link Folder}.
	 * 
	 * @param folder
	 *            The folder.
	 * @return The current visibility of the folder.
	 */
	public boolean getCreationMenuVisibility(final Folder folder) {
		String visible = preferences.get(getFolderId(folder), "");//$NON-NLS-1$
		return "" == visible ? folder.isVisible() : Boolean.valueOf(visible);//$NON-NLS-1$
	}

	/**
	 * Gets the visibility of a {@link Folder} refereed by its URI.
	 * 
	 * @param folder
	 *            The folder.
	 * @return The current visibility of the folder.
	 */
	public boolean getCreationMenuVisibility(final URI uri) {
		Folder folder = null;
		try {
			folder = getCreationMenuModel(uri);
		} catch (URISyntaxException e) {
			Activator.log.error(e);
		}
		String visible = preferences.get(getCreationMenuId(uri), "");//$NON-NLS-1$
		return "" == visible ? folder.isVisible() : Boolean.valueOf(visible);//$NON-NLS-1$
	}

	/**
	 * Gets the default value of a {@link Folder}.
	 * 
	 * @param folder
	 *            The folder
	 * @return The default visibility of the folder.
	 */
	public boolean getDefaultCreationMenuVisibility(final Folder folder) {
		Boolean defaultVisibility = defaultValues.get(getFolderId(folder));
		return null != defaultVisibility ? defaultVisibility : folder.isVisible();
	}

	/**
	 * Gets the default value of a {@link Folder} refereed by its URI.
	 * 
	 * @param folder
	 *            The folder
	 * @return The default visibility of the folder.
	 */
	public boolean getDefaultCreationMenuVisibility(final URI uri) {
		Folder folder = null;
		try {
			folder = getCreationMenuModel(uri);
		} catch (URISyntaxException e) {
			Activator.log.error(e);
		}
		return getDefaultCreationMenuVisibility(folder);
	}

	/**
	 * Gets the visibility of the {@link Folder} set in preferences.
	 * 
	 * @param folder
	 *            The folder.
	 * @param defautVisibility
	 *            The default visibility if it is not set in preferences.
	 * @return
	 * 		The preferred visibility.
	 */
	public boolean getPreferedVisibility(final Folder folder, final boolean defautVisibility) {
		String visible = preferences.get(getFolderId(folder), String.valueOf(defautVisibility));
		return Boolean.valueOf(visible);
	}

	/**
	 * Gets the visibility of the {@link Folder} refereed by its URI set in preferences.
	 * 
	 * @param folder
	 *            The folder.
	 * @param defautVisibility
	 *            The default visibility if it is not set in preferences.
	 * @return
	 * 		The preferred visibility.
	 */
	public boolean getPreferedVisibility(final URI uri, final boolean defautVisibility) {
		String visible = preferences.get(getCreationMenuId(uri), String.valueOf(defautVisibility));
		return Boolean.valueOf(visible);
	}

	/**
	 * Restore the default visibility value of folders.
	 */
	public void restoreDefault() {
		try {
			preferences.clear();
		} catch (BackingStoreException e) {
			Activator.log.error(e);
		}
		Set<Entry<String, Folder>> entrySet = rootFolders.entrySet();
		for (Entry<String, Folder> entry : entrySet) {
			Folder folder = entry.getValue();
			folder.setVisible(getDefaultCreationMenuVisibility(folder));
		}
	}

}