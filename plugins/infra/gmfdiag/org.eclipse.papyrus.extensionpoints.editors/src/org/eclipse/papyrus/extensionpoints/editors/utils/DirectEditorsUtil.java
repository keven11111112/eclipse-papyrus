/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) Remi.Schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.extensionpoints.editors.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.extensionpoints.editors.Activator;
import org.eclipse.papyrus.extensionpoints.editors.configuration.DefaultDirectEditorConfiguration;
import org.eclipse.papyrus.extensionpoints.editors.configuration.IDirectEditorConfiguration;
import org.eclipse.papyrus.extensionpoints.editors.configuration.IDirectEditorConstraint;
import org.eclipse.papyrus.extensionpoints.editors.definition.DirectEditorExtensionPoint;
import org.eclipse.papyrus.extensionpoints.editors.definition.IDirectEditorExtensionPoint;

public class DirectEditorsUtil {

	/** The Constant UNKNOWN_PRIORITY. */
	private static final int UNKNOWN_PRIORITY = 100;

	/**
	 * Finds a editor for specific language and object to edit type
	 *
	 * @param language
	 *            the language to edit
	 * @param objectToEdit
	 *            the type of object to edit
	 * @return the extension point proxy that manages this kind of editor
	 *
	 * @deprecated Use {@link #findEditorConfiguration(String language, EObject eObjectToEdit)} instead
	 */
	@Deprecated
	public static IDirectEditorConfiguration findEditorConfiguration(String language, String objectToEdit) {
		IDirectEditorExtensionPoint[] extensionPoints = DirectEditorExtensionPoint.getInstance().getDirectEditorConfigurations();
		for (IDirectEditorExtensionPoint directEditorExtensionPoint : extensionPoints) {
			final String lang = directEditorExtensionPoint.getLanguage();
			final String oToEdit = directEditorExtensionPoint.getObjectToEdit();
			if (lang.equals(language) && oToEdit.equals(objectToEdit)) {
				// extension point found!
				return directEditorExtensionPoint.getDirectEditorConfiguration();
			}
		}
		return new DefaultDirectEditorConfiguration();
	}

	/**
	 * Finds a editor for specific language and object to edit type
	 *
	 * @param language
	 *            the language to edit
	 * @param semanticObjectToEdit
	 *            the semantic object to edit
	 * @param selectedElement
	 *            The real selected element (e.g. widget, edit part, ...)
	 * @return the extension point proxy that manages this kind of editor
	 */
	public static IDirectEditorConfiguration findEditorConfiguration(String language, Object semanticObjectToEdit, Object selectedElement) {
		IDirectEditorExtensionPoint[] extensionPoints = DirectEditorExtensionPoint.getInstance().getDirectEditorConfigurations();
		IDirectEditorConfiguration editorConfiguration = new DefaultDirectEditorConfiguration();
		int configurationPriority = UNKNOWN_PRIORITY;
		for (IDirectEditorExtensionPoint directEditorExtensionPoint : extensionPoints) {
			final String lang = directEditorExtensionPoint.getLanguage();
			final Class<? extends EObject> classToEdit = directEditorExtensionPoint.getObjectClassToEdit();
			if (lang.equals(language) && classToEdit.isInstance(semanticObjectToEdit)) {
				IDirectEditorConstraint constraint = directEditorExtensionPoint.getAdditionalConstraint();
				if ((constraint == null || constraint.appliesTo(selectedElement)) && directEditorExtensionPoint.getPriority() < configurationPriority) {
					// extension point found!
					editorConfiguration = directEditorExtensionPoint.getDirectEditorConfiguration();
					configurationPriority = directEditorExtensionPoint.getPriority();
				}
			}
		}
		return editorConfiguration;
	}

	/**
	 * finds if an editor for specific language and object is available to edit type
	 *
	 * @param language
	 *            the language to edit
	 * @param objectToEdit
	 *            the object to edit
	 * @return <code>true</code> if an editor exists
	 *
	 * @deprecated Use {@link #hasSpecificEditorConfiguration(String language, EObject eObjectToEdit)} instead
	 */
	@Deprecated
	public static boolean hasSpecificEditorConfiguration(String language, String objectToEdit) {
		IDirectEditorExtensionPoint[] extensionPoints = DirectEditorExtensionPoint.getInstance().getDirectEditorConfigurations();
		for (IDirectEditorExtensionPoint directEditorExtensionPoint : extensionPoints) {
			final String lang = directEditorExtensionPoint.getLanguage();
			final String oToEdit = directEditorExtensionPoint.getObjectToEdit();
			if (lang.equals(language) && oToEdit.equals(objectToEdit)) {
				// extension point found!
				return true;
			}
		}
		return false;
	}

	/**
	 * finds if an editor for specific language and object is available to edit type
	 *
	 * @param language
	 *            the language to edit
	 * @param semanticObjectToEdit
	 *            the semantic object to edit
	 * @param selectedElement
	 *            The real selected element (e.g. widget, edit part, ...)
	 * @return <code>true</code> if an editor exists
	 */
	public static boolean hasSpecificEditorConfiguration(String language, Object semanticObjectToEdit, Object selectedElement) {
		IDirectEditorExtensionPoint[] extensionPoints = DirectEditorExtensionPoint.getInstance().getDirectEditorConfigurations();
		for (IDirectEditorExtensionPoint directEditorExtensionPoint : extensionPoints) {
			final String lang = directEditorExtensionPoint.getLanguage();
			final Class<? extends EObject> classToEdit = directEditorExtensionPoint.getObjectClassToEdit();
			if (lang.equals(language) && classToEdit.isInstance(semanticObjectToEdit)) {
				IDirectEditorConstraint constraint = directEditorExtensionPoint.getAdditionalConstraint();
				if (constraint == null || constraint.appliesTo(selectedElement)) {
					// extension point found!
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * finds if an editor for specific object is available to edit type
	 *
	 * @param language
	 *            the language to edit
	 * @param objectToEdit
	 *            the type of object to edit
	 * @return <code>true</code> if an editor exists
	 *
	 * @deprecated Use {@link #hasSpecificEditorConfiguration(EObject)} instead
	 */
	@Deprecated
	public static boolean hasSpecificEditorConfiguration(String objectToEdit) {
		IDirectEditorExtensionPoint[] extensionPoints = DirectEditorExtensionPoint.getInstance().getDirectEditorConfigurations();
		for (IDirectEditorExtensionPoint directEditorExtensionPoint : extensionPoints) {
			final String oToEdit = directEditorExtensionPoint.getObjectToEdit();
			if (oToEdit.equals(objectToEdit)) {
				// extension point found!
				return true;
			}
		}
		return false;
	}

	/**
	 * finds if an editor for specific object is available to edit type
	 *
	 * @param language
	 *            the language to edit
	 * @param semanticObjectToEdit
	 *            the semantic object to edit
	 * @param selectedElement
	 *            The real selected element (e.g. widget, edit part, ...)
	 * @return <code>true</code> if an editor exists
	 */
	public static boolean hasSpecificEditorConfiguration(Object semanticObjectToEdit, Object selectedElement) {
		IDirectEditorExtensionPoint[] extensionPoints = DirectEditorExtensionPoint.getInstance().getDirectEditorConfigurations();
		for (IDirectEditorExtensionPoint directEditorExtensionPoint : extensionPoints) {
			final Class<? extends EObject> classToEdit = directEditorExtensionPoint.getObjectClassToEdit();
			if (classToEdit.isInstance(semanticObjectToEdit)) {
				IDirectEditorConstraint constraint = directEditorExtensionPoint.getAdditionalConstraint();
				if (constraint == null || constraint.appliesTo(selectedElement)) {
					// extension point found!
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Retrieves the preferred editor configuration for the specified type
	 *
	 * @param class_
	 *            the type of element to edit
	 * @return the preferred editor configuration for the specified type or <code>null</code>
	 */
	public static IDirectEditorExtensionPoint getDefautDirectEditorConfiguration(Object semanticObjectToEdit, Object selectedObject) {
		// retrieves preference for this element
		String language = Activator.getDefault().getPreferenceStore().getString(IDirectEditorsIds.EDITOR_FOR_ELEMENT + semanticObjectToEdit.getClass().asSubclass(EObject.class));
		if (language == null || IDirectEditorsIds.SIMPLE_DIRECT_EDITOR.equals(language)) {
			return null;
		}
		IDirectEditorExtensionPoint currentConfiguration = null;
		int currentPriority = UNKNOWN_PRIORITY;
		Collection<IDirectEditorExtensionPoint> configs = getDirectEditorConfigurations(semanticObjectToEdit, selectedObject);

		for (IDirectEditorExtensionPoint extensionPoint : configs) {
			if (language.equals(extensionPoint.getLanguage()) && extensionPoint.getPriority() < currentPriority) {
				currentConfiguration = extensionPoint;
				currentPriority = extensionPoint.getPriority();
			}
		}

		return currentConfiguration;
	}

	/**
	 * Returns the set of transformations registered in the platform for the specified kind of
	 * element
	 *
	 * @param the
	 *            type of element to be edited
	 * @return the set of transformations registered in the platform for the specified kind of
	 *         element
	 */
	public static Collection<IDirectEditorExtensionPoint> getDirectEditorConfigurations(Object semanticObjectToEdit, Object selectedObject) {
		// list of configuration to be returned. They correspond to
		// configuration to edit the
		// specified type
		final List<IDirectEditorExtensionPoint> elementConfigurations = new ArrayList<IDirectEditorExtensionPoint>();

		// check each configuration in the platform and select corresponding
		// ones.
		for (IDirectEditorExtensionPoint configuration : DirectEditorExtensionPoint.getInstance().getDirectEditorConfigurations()) {
			// both class are compatibles ?
			if (configuration.getObjectClassToEdit() != null) {
				if (configuration.getObjectClassToEdit().isInstance(semanticObjectToEdit)) {
					IDirectEditorConstraint constraint = configuration.getAdditionalConstraint();
					if (constraint == null || constraint.appliesTo(selectedObject))
						elementConfigurations.add(configuration);
				}
			}
		}
		return elementConfigurations;
	}

	/**
	 * Finds a editor for specific language and object to edit type with the higher priority.
	 *
	 * @param language
	 *            the language to edit
	 * @param objectToEdit
	 *            the type of object to edit
	 * @return the extension point proxy that manages this kind of editor
	 */
	public static IDirectEditorConfiguration findEditorConfigurationWithPriority(String language, String objectToEdit) {
		IDirectEditorConfiguration result = null;
		int currentPrority = UNKNOWN_PRIORITY;
		IDirectEditorExtensionPoint[] extensionPoints = DirectEditorExtensionPoint.getInstance().getDirectEditorConfigurations();
		for (IDirectEditorExtensionPoint directEditorExtensionPoint : extensionPoints) {
			final String lang = directEditorExtensionPoint.getLanguage();
			final String oToEdit = directEditorExtensionPoint.getObjectToEdit();
			if (lang.equals(language) && oToEdit.equals(objectToEdit)) {
				// extension point found!
				int directEditorExtensionPointPriority = directEditorExtensionPoint.getPriority() != null ? directEditorExtensionPoint.getPriority() : UNKNOWN_PRIORITY;
				if (result == null || (directEditorExtensionPointPriority < currentPrority)) {
					result = directEditorExtensionPoint.getDirectEditorConfiguration();
					currentPrority = directEditorExtensionPointPriority;
				}
			}
		}
		return result != null ? result : new DefaultDirectEditorConfiguration();
	}

	/**
	 * returns the list of languages that are available from extension points
	 *
	 * @return the list of languages that have an extended editor
	 */
	public static List<String> getLanguages(String objectToEdit) {
		List<String> languages = new ArrayList<String>();
		IDirectEditorExtensionPoint[] extensionPoints = DirectEditorExtensionPoint.getInstance().getDirectEditorConfigurations();
		for (IDirectEditorExtensionPoint directEditorExtensionPoint : extensionPoints) {
			if (objectToEdit == null || directEditorExtensionPoint.getObjectToEdit().equals(objectToEdit)) {
				String lang = directEditorExtensionPoint.getLanguage();
				if (!languages.contains(lang)) {
					languages.add(lang);
				}
			}
		}
		return languages;
	}

}
