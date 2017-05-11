/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Nicolas FAUVERGUE (ALL4TEC) nicolas.fauvergue@all4tec.net - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.infra.internationalization.common.utils;

import java.util.Locale;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.sasheditor.DiModel;
import org.eclipse.papyrus.infra.internationalization.common.Activator;

/**
 * The internationalization preference utils methods which allow to get or
 * change the internationalization preference value.
 */
public class InternationalizationPreferencesUtils {

	/**
	 * Get the preference store for the project containing the {@link EObject}
	 * in parameter.
	 * 
	 * @param eObject
	 *            The eObject.
	 * @return The preference store for the project containing the EObject.
	 */
	public static IPreferenceStore getPreferenceStore(final EObject eObject) {
		URI resourceURI = eObject.eResource().getURI();
		final ResourceSet resourceSet = eObject.eResource().getResourceSet();
		if (resourceSet instanceof ModelSet && null != ((ModelSet) resourceSet).getURIWithoutExtension()) {
			resourceURI = ((ModelSet) resourceSet).getURIWithoutExtension().appendFileExtension(DiModel.DI_FILE_EXTENSION);
		}
		return getPreferenceStore(resourceURI);
	}

	/**
	 * Get the preference store for the project containing the {@link Resource}
	 * in parameter.
	 * 
	 * @param resource
	 *            The resource.
	 * @return The preference store for the project containing the Resource.
	 */
	public static IPreferenceStore getPreferenceStore(final Resource resource) {
		IPreferenceStore result = null;

		if (null != resource) {
			result = getPreferenceStore(resource.getURI());
		}

		return result;
	}

	/**
	 * Get the preference store for the project containing the resource
	 * {@link URI} in parameter.
	 * 
	 * @param resource
	 *            The resource.
	 * @return The preference store for the project containing the resource URI.
	 */
	public static IPreferenceStore getPreferenceStore(final URI uri) {
		IPreferenceStore result = null;

		if (null != uri) {
			final String filePathString = CommonPlugin.resolve(uri).toFileString();

			if (null != filePathString) {
				final IFile resourceFile = ResourcesPlugin.getWorkspace().getRoot()
						.getFileForLocation(new Path(filePathString));

				if (null != resourceFile) {
					final IProject currentProject = resourceFile.getProject();
					final String papyrusProjectName = uri.trimFileExtension().lastSegment();

					if (null != currentProject && !papyrusProjectName.isEmpty()) {
						result = Activator.getDefault().getInternationalizationPreferenceStore(currentProject,
								papyrusProjectName);
					}
				}
			}
		}

		return result;
	}

	/**
	 * This allows to modify the internationalization preference value.
	 * 
	 * @param eObject
	 *            The {@link EObject) corresponding (to get its resource).
	 * @param value
	 *            The new preference value.
	 */
	public static void setInternationalizationPreference(final EObject eObject, final boolean value) {
		URI resourceURI = eObject.eResource().getURI();
		final ResourceSet resourceSet = eObject.eResource().getResourceSet();
		if (resourceSet instanceof ModelSet && null != ((ModelSet) resourceSet).getURIWithoutExtension()) {
			resourceURI = ((ModelSet) resourceSet).getURIWithoutExtension().appendFileExtension(DiModel.DI_FILE_EXTENSION);
		}
		setInternationalizationPreference(resourceURI, value);
	}

	/**
	 * This allows to modify the internationalization preference value.
	 * 
	 * @param resource
	 *            The {@link Resource) to get the papyrus project preferences.
	 * @param value
	 *            The new preference value.
	 */
	public static void setInternationalizationPreference(final Resource resource, final boolean value) {
		setInternationalizationPreference(resource.getURI(), value);
	}

	/**
	 * This allows to modify the internationalization preference value.
	 * 
	 * @param resourceURI
	 *            The resource URI to get the papyrus project preferences.
	 * @param value
	 *            The new preference value.
	 */
	public static void setInternationalizationPreference(final URI resourceURI, final boolean value) {
		final IPreferenceStore preferenceStore = getPreferenceStore(resourceURI);

		if (null != preferenceStore) {
			preferenceStore.setValue(InternationalizationPreferencesConstants.USE_INTERNATIONALIZATION_PREFERENCE,
					value);
		}
	}

	/**
	 * This allows to get the internationalization preference value.
	 * 
	 * @param eObject
	 *            The {@link EObject) corresponding (to get its resource).
	 * @return <code>true</code> if the preference value is set to true,
	 *         <code>false</code> otherwise.
	 */
	public static boolean getInternationalizationPreference(final EObject eObject) {
		boolean result = false;
		if (null != eObject && null != eObject.eResource()) {
			URI resourceURI = eObject.eResource().getURI();
			final ResourceSet resourceSet = eObject.eResource().getResourceSet();
			if (resourceSet instanceof ModelSet && null != ((ModelSet) resourceSet).getURIWithoutExtension()) {
				resourceURI = ((ModelSet) resourceSet).getURIWithoutExtension().appendFileExtension(DiModel.DI_FILE_EXTENSION);
			}
			result = getInternationalizationPreference(resourceURI);
		}
		return result;
	}

	/**
	 * This allows to get the internationalization preference value.
	 * 
	 * @param resource
	 *            The {@link Resource) to get the papyrus project preferences.
	 * @return <code>true</code> if the preference value is set to true,
	 *         <code>false</code> otherwise.
	 */
	public static boolean getInternationalizationPreference(final Resource resource) {
		return getInternationalizationPreference(resource.getURI());
	}

	/**
	 * This allows to get the internationalization preference value.
	 * 
	 * @param resourceURI
	 *            The resource URI to get the papyrus project preferences.
	 * @return <code>true</code> if the preference value is set to true,
	 *         <code>false</code> otherwise.
	 */
	public static boolean getInternationalizationPreference(final URI resourceURI) {
		boolean result = false;

		final IPreferenceStore preferenceStore = getPreferenceStore(resourceURI);

		if (null != preferenceStore && preferenceStore
				.contains(InternationalizationPreferencesConstants.USE_INTERNATIONALIZATION_PREFERENCE)) {
			result = preferenceStore
					.getBoolean(InternationalizationPreferencesConstants.USE_INTERNATIONALIZATION_PREFERENCE);
		}

		return result;
	}

	/**
	 * Get the language preference (create it with the current locale if not
	 * existing).
	 * 
	 * @param resource
	 *            The {@link Resource) to get the papyrus project preferences.
	 * @return The language in the preferences.
	 */
	private static String getLanguagePreference(final URI uri) {
		String result = null;

		final IPreferenceStore preferenceStore = getPreferenceStore(uri);
		if (null != preferenceStore
				&& preferenceStore.contains(InternationalizationPreferencesConstants.LANGUAGE_PREFERENCE)) {
			result = preferenceStore.getString(InternationalizationPreferencesConstants.LANGUAGE_PREFERENCE);
		}

		return result;
	}

	/**
	 * Get the locale preference created from the language preference.
	 * 
	 * @param eObject
	 *            The {@link EObject) corresponding (to get its resource).
	 * @return The locale preference.
	 */
	public static Locale getLocalePreference(final EObject eObject) {
		Locale result = null;
		if (null != eObject && null != eObject.eResource()) {
			URI resourceURI = eObject.eResource().getURI();
			final ResourceSet resourceSet = eObject.eResource().getResourceSet();
			if (resourceSet instanceof ModelSet && null != ((ModelSet) resourceSet).getURIWithoutExtension()) {
				resourceURI = ((ModelSet) resourceSet).getURIWithoutExtension().appendFileExtension(DiModel.DI_FILE_EXTENSION);
			}
			result = getLocalePreference(resourceURI);
		}
		return result;
	}

	/**
	 * Get the locale preference created from the language preference.
	 * 
	 * @param resource
	 *            The {@link Resource) to get the papyrus project preferences.
	 * @return The locale preference.
	 */
	public static Locale getLocalePreference(final URI uri) {
		final String localePreference = getLanguagePreference(uri);

		Locale result = null;

		if (null != localePreference) {
			result = LocaleNameResolver.getLocaleFromString(localePreference);
		} else {
			result = Locale.getDefault();
		}

		return result;
	}

	/**
	 * This allows to set the language preference.
	 * 
	 * @param eObject
	 *            The {@link EObject) corresponding (to get its resource).
	 * @param language
	 *            The language to set.
	 */
	public static void setLanguagePreference(final EObject eObject, final String language) {
		URI resourceURI = eObject.eResource().getURI();
		final ResourceSet resourceSet = eObject.eResource().getResourceSet();
		if (resourceSet instanceof ModelSet && null != ((ModelSet) resourceSet).getURIWithoutExtension()) {
			resourceURI = ((ModelSet) resourceSet).getURIWithoutExtension().appendFileExtension(DiModel.DI_FILE_EXTENSION);
		}
		setLanguagePreference(resourceURI, language);
	}

	/**
	 * This allows to set the language preference.
	 * 
	 * @param resource
	 *            The {@link Resource) to get the papyrus project preferences.
	 * @param language
	 *            The language to set.
	 */
	public static void setLanguagePreference(final Resource resource, final String language) {
		setLanguagePreference(resource.getURI(), language);
	}

	/**
	 * This allows to set the language preference.
	 * 
	 * @param resourceURI
	 *            The resource URI to get the papyrus project preferences.
	 * @param language
	 *            The language to set.
	 */
	public static void setLanguagePreference(final URI resourceURI, final String language) {
		final IPreferenceStore preferenceStore = getPreferenceStore(resourceURI);

		if (null != preferenceStore) {
			preferenceStore.setValue(InternationalizationPreferencesConstants.LANGUAGE_PREFERENCE, language);
		}
	}
}
