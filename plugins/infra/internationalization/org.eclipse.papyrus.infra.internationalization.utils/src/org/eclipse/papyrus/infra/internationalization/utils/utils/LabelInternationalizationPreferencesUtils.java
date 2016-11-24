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

package org.eclipse.papyrus.infra.internationalization.utils.utils;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.infra.internationalization.common.utils.InternationalizationPreferencesUtils;

/**
 * Open the label internationalization preferences to the others plugins with the utils plugin.
 */
public class LabelInternationalizationPreferencesUtils {

	/**
	 * This allows to modify the internationalization preference value.
	 * 
	 * @param eObject The {@link EObject) corresponding (to get its resource).
	 * @param value The new preference value.
	 */
	public static void setInternationalizationPreference(final EObject eObject, final boolean value){
		InternationalizationPreferencesUtils.setInternationalizationPreference(eObject, value);
	}
	
	/**
	 * This allows to modify the internationalization preference value.
	 * 
	 * @param resource The {@link Resource) to get the papyrus project preferences.
	 * @param value The new preference value.
	 */
	public static void setInternationalizationPreference(final Resource resource, final boolean value){
		InternationalizationPreferencesUtils.setInternationalizationPreference(resource, value);
	}
	
	/**
	 * This allows to get the internationalization preference value.
	 * 
	 * @param eObject The {@link EObject) corresponding (to get its resource).
	 * @return <code>true</code> if the preference value is set to true, <code>false</code> otherwise.
	 */
	public static boolean getInternationalizationPreference(final EObject eObject){
		return InternationalizationPreferencesUtils.getInternationalizationPreference(eObject);
	}
	
	/**
	 * This allows to get the internationalization preference value.
	 * 
	 * @param resource The {@link Resource) to get the papyrus project preferences.
	 * @return <code>true</code> if the preference value is set to true, <code>false</code> otherwise.
	 */
	public static boolean getInternationalizationPreference(final Resource resource){
		return InternationalizationPreferencesUtils.getInternationalizationPreference(resource);
	}
}
