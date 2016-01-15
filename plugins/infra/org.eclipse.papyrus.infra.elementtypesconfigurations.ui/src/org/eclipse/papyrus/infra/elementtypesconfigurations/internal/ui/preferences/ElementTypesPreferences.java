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
 *  Christian W. Damus - bug 485220
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.elementtypesconfigurations.internal.ui.preferences;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.infra.elementtypesconfigurations.internal.ui.LogUtil;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.WorkbenchException;
import org.eclipse.ui.XMLMemento;
import org.eclipse.ui.preferences.ScopedPreferenceStore;

/**
 * Preferences management for elementTypesConfigurations
 */
public class ElementTypesPreferences {

	/** id for the preference store for elementTypes redefinitions */
	public final static String ELEMENT_TYPES_REDEFINITIONS = "elementTypesRedefinitions"; //$NON-NLS-1$

	/** id for the node: elementTypes redefinition */
	public final static String ELEMENT_TYPES_REDEFINITION = "elementTypesRedefinition"; //$NON-NLS-1$

	public static final String ELEMENT_TYPES_SET_WORKSPACE_DEFINITION = "elementTypeSetsWorkspaceDefinition";

	/** name of the ID attribute */
	public final static String ID = "id"; //$NON-NLS-1$

	/** name for the field giving the path to the XML file */
	public final static String PATH = "path"; //$NON-NLS-1$

	private static IPreferenceStore preferences;

	/**
	 * Returns the preference store used to store elementTypes preferences.
	 *
	 * @return the preference store of the plugin
	 */
	protected synchronized static IPreferenceStore getPreferenceStore() {
		if (preferences == null) {
			preferences = new ScopedPreferenceStore(InstanceScope.INSTANCE,
					org.eclipse.papyrus.infra.elementtypesconfigurations.Activator.PLUGIN_ID);
		}

		return preferences;
	}

	/**
	 * Retrieves the root memento from the plugin preferences for all elementTypes redefinition
	 * redefinitions.
	 *
	 * @return the root memento if there were existing customizations, a newly created one otherwise (empty one)
	 */
	protected static XMLMemento getLocalRedefinitions() {
		String sValue = getPreferenceStore().getString(ELEMENT_TYPES_REDEFINITIONS);
		try {
			if (sValue != null && !sValue.equals("")) { //$NON-NLS-1$
				XMLMemento rootMemento = XMLMemento.createReadRoot(new StringReader(sValue));
				return rootMemento;
			} else {
				return XMLMemento.createWriteRoot(ELEMENT_TYPES_REDEFINITIONS);
			}
		} catch (WorkbenchException e) {
			LogUtil.LOG.error("Impossible to read preferences for elementTypes local redefinitions", e);
		}
		return null;
	}

	/**
	 * Register a new local redefinition of a elementTypes.
	 *
	 * @param elementTypesID
	 *            the id of the elementTypes to register
	 * @param path
	 *            the path to the configuration of the elementTypes
	 * @return the memento that has been registered
	 */
	public static IMemento registerLocalRedefinition(String elementTypesID, String path) {
		XMLMemento rootMemento = getLocalRedefinitions();
		// try to find an existing local definition for this elementTypes
		IMemento memento = getelementTypesRedefinitionNode(elementTypesID);
		// if one exists, remove it from the preferences
		if (memento != null) {
			unregisterLocalRedefinition(elementTypesID);
		}
		// then register the new one
		IMemento newMemento = rootMemento.createChild(ELEMENT_TYPES_REDEFINITION);
		newMemento.putString(ID, elementTypesID);
		newMemento.putString(PATH, path);
		saveLocalRedefinitions(rootMemento);
		return newMemento;
	}

	/**
	 * Returns the memento associated to the elementTypes, or <code>null</code> if none exists
	 *
	 * @param elementTypesID
	 *            the identifier of the elementTypes to find
	 * @return the memento found or <code>null</code> if no customization exists for this elementTypes
	 */
	protected static IMemento getelementTypesRedefinitionNode(String elementTypesID) {
		XMLMemento rootMemento = getLocalRedefinitions();
		IMemento[] redefinitions = rootMemento.getChildren(ELEMENT_TYPES_REDEFINITION);
		for (IMemento redefinitionMemento : redefinitions) {
			String elementTypesNodeID = redefinitionMemento.getString(ID);
			// check equals. elementTypes ID is not null, as checked at the begining of the method.
			if (elementTypesID.equals(elementTypesNodeID)) {
				return redefinitionMemento;
			}
		}
		return null;
	}

	/**
	 * Returns the memento associated to the elementTypes set definition in workspace, or <code>null</code> if none exists
	 *
	 * @return the memento found or <code>null</code> if no customization exists for this elementTypes
	 */
	protected static IMemento[] getWorkspaceDefinitions() {
		XMLMemento rootMemento = getLocalRedefinitions();
		IMemento[] workspaceDefinitions = rootMemento.getChildren(ELEMENT_TYPES_SET_WORKSPACE_DEFINITION);
		return workspaceDefinitions;
	}

	/**
	 * Returns the memento associated to the elementTypes set definition in workspace, or <code>null</code> if none exists
	 *
	 * @return the memento found or <code>null</code> if no customization exists for this elementTypes
	 */
	protected static IMemento getWorkspaceDefinition(String elementTypesetsID) {
		if (elementTypesetsID == null) {
			return null;
		}
		IMemento[] workspaceDefinitions = getWorkspaceDefinitions();
		if (workspaceDefinitions == null || workspaceDefinitions.length == 0) {
			return null;
		}
		for (IMemento memento : workspaceDefinitions) {
			String id = memento.getString(ID);
			if (elementTypesetsID.equals(id)) {
				return memento;
			}
		}
		return null;
	}

	/**
	 * Returns the path for a given elementType local redefinition
	 *
	 * @param elementTypesID
	 *            the unique identifier of the elementType to retrieve
	 * @return the path to the configuration of the elementTypes or <code>null</code> if no customization exists for this elementType
	 *         configuration
	 */
	public static String getElementTypesRedefinition(String elementTypesID) {
		if (elementTypesID == null) {
			LogUtil.LOG.debug("Trying to find preferences for a null elementType set identifier");
		}
		IMemento memento = getelementTypesRedefinitionNode(elementTypesID);
		if (memento != null) {
			return memento.getString(PATH);
		}
		return null;
	}

	/**
	 * Unregister a specific local redefinition
	 *
	 * @param elementTypesID
	 *            the identifier of the elementTypes set to unregister
	 */
	public static void unregisterLocalRedefinition(String elementTypesID) {
		XMLMemento rootMemento = getLocalRedefinitions();
		// no remove method...
		// so, creation of a new root memento, then, duplicate all entries
		// except the one to
		// delete...
		XMLMemento newRootMemento = XMLMemento.createWriteRoot(ELEMENT_TYPES_REDEFINITIONS);
		for (IMemento memento : rootMemento.getChildren(ELEMENT_TYPES_REDEFINITION)) {
			if (!memento.getString(ID).equals(elementTypesID)) {
				newRootMemento.putMemento(memento);
			}
		}
		for (IMemento memento : rootMemento.getChildren(ELEMENT_TYPES_SET_WORKSPACE_DEFINITION)) {
			newRootMemento.putMemento(memento);
		}
		// save new Memento
		saveLocalRedefinitions(newRootMemento);
	}

	/**
	 * @param elementTypesID
	 */
	public static void unregisterWorkspaceDefinition(String elementTypesID) {
		XMLMemento rootMemento = getLocalRedefinitions();
		// no remove method...
		// so, creation of a new root memento, then, duplicate all entries
		// except the one to
		// delete...
		XMLMemento newRootMemento = XMLMemento.createWriteRoot(ELEMENT_TYPES_REDEFINITIONS);
		for (IMemento memento : rootMemento.getChildren(ELEMENT_TYPES_REDEFINITION)) {
			newRootMemento.putMemento(memento);
		}
		for (IMemento memento : rootMemento.getChildren(ELEMENT_TYPES_SET_WORKSPACE_DEFINITION)) {
			if (!memento.getString(ID).equals(elementTypesID)) {
				newRootMemento.putMemento(memento);
			}
		}
		// save new Memento
		saveLocalRedefinitions(newRootMemento);
	}

	/**
	 * saves the given root memento with the given key in the preference area
	 *
	 * @param xmlMemento
	 *            the memento to save
	 * @param key
	 *            the key for the preference store
	 */
	protected static void saveMemento(XMLMemento xmlMemento, String key) {
		// save memento
		StringWriter writer = new StringWriter();
		try {
			xmlMemento.save(writer);
			if (getPreferenceStore() != null) {
				getPreferenceStore().setValue(key, writer.toString());
			}
		} catch (IOException e) {
			LogUtil.LOG.error("input/ouput exception", e);
		}
	}

	/**
	 * Saves the set of local redefinitions into the preference store
	 *
	 * @param rootMemento
	 *            the memento to save
	 */
	public static void saveLocalRedefinitions(XMLMemento rootMemento) {
		saveMemento(rootMemento, ELEMENT_TYPES_REDEFINITIONS);
	}

	/**
	 * Returns all the paths in the workspace that should be an elementType set to load, with the id as a key
	 *
	 * @return
	 */
	public static Map<String, String> getLocalElementTypeDefinitions() {
		IMemento[] mementos = getWorkspaceDefinitions();
		if (mementos != null && mementos.length > 0) {
			Map<String, String> idToPath = new HashMap<String, String>();
			for (IMemento memento : mementos) {
				String id = memento.getString(ID);
				String path = memento.getString(PATH);
				if (id != null && !"".equals(id) && path != null && !"".equals(PATH)) {
					idToPath.put(id, path);
				}
			}
			return idToPath;
		}
		return null;
	}

	/**
	 * Register a new local redefinition of a elementTypes.
	 *
	 * @param elementTypesID
	 *            the id of the elementTypes to register
	 * @param path
	 *            the path to the configuration of the elementTypes
	 * @return the memento that has been registered
	 */
	public static IMemento registerWorkspaceDefinition(String elementTypesID, String path) {
		XMLMemento rootMemento = getLocalRedefinitions();
		// try to find an existing local definition for this elementTypes
		IMemento memento = getWorkspaceDefinition(elementTypesID);
		// if one exists, remove it from the preferences
		if (memento != null) {
			unregisterWorkspaceDefinition(elementTypesID);
		}
		// then register the new one
		IMemento newMemento = rootMemento.createChild(ELEMENT_TYPES_SET_WORKSPACE_DEFINITION);
		newMemento.putString(ID, elementTypesID);
		newMemento.putString(PATH, path);
		saveLocalRedefinitions(rootMemento);
		return newMemento;
	}
}
