/*****************************************************************************
 * Copyright (c) 2017 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.migration.rhapsody.xmi;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl;
import org.eclipse.papyrus.migration.rhapsody.importer.utils.RpyUtil;

/**
 * @author VL222926
 *         This helper allows to build XMI_ID for EMF objects
 */
public class EMF_XMI_ID_Helper {


	/**
	 * 
	 * @param eobject
	 *            an element
	 * @return
	 * 		the calculated XMI_ID for the given element, value can be <code>null</code>
	 */
	public static final String calculateIdForEMF(final EObject eobject) {
		String result = null;
		if (eobject instanceof EAnnotation) {
			result = calculateId((EAnnotation) eobject);
		} else if (eobject instanceof EStringToStringMapEntryImpl) {
			result = calculateId((EStringToStringMapEntryImpl) eobject);
		}
		return result;
	}

	/**
	 * 
	 * @param eannotation
	 *            an eannotation
	 * @return
	 * 		the ID calculated for it
	 */
	public static final String calculateId(final EAnnotation eannotation) {
		final EObject parent = eannotation.eContainer();
		StringBuilder builder = new StringBuilder();
		if (null != parent) {
			final String parentID = XMI_ID_Helper.getXMI_ID(parent);
			builder.append(parentID);
			builder.append(RpyUtil.ID_SEPARATOR);
			builder.append(eannotation.eClass().getName());
			builder.append(RpyUtil.ID_SEPARATOR);
			builder.append(eannotation.getSource().hashCode());
		} else {
			builder = new StringBuilder();
		}
		return builder.toString();
	}

	/**
	 * 
	 * @param map
	 *            a map
	 * @return
	 * 		the ID calculated for it
	 */
	public static final String calculateId(final EStringToStringMapEntryImpl map) {
		final EObject parent = map.eContainer();
		StringBuilder builder = new StringBuilder();
		if (null != parent) {
			final String parentID = XMI_ID_Helper.getXMI_ID(parent);
			builder.append(parentID);
			builder.append(RpyUtil.ID_SEPARATOR);
			builder.append(map.eClass().getName());
			builder.append(RpyUtil.ID_SEPARATOR);
			builder.append(map.getKey().hashCode());
			builder.append(RpyUtil.ID_SEPARATOR);
			builder.append(map.getValue().hashCode());
		} else {
			builder = new StringBuilder();
		}
		return builder.toString();
	}
}
