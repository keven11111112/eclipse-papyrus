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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.migration.rhapsody.Activator;

/**
 * This class is used to calculate XMI_ID
 *
 */
public class XMI_ID_Helper {

	/**
	 * This method calculate an XMI ID for element. The goal of this method is to generate unique XMI_ID for element which doesn't exist in Rhapsody and there is not
	 * 
	 * @param element
	 *            an element
	 * @return
	 * 		the XMI_ID to use for the element
	 */
	public static final String calculateXMI_ID(final EObject element) {
		String result = UML_XMI_ID_Helper.calculateIdForUML(element);
//		if (result!=null && !result.contains(RpyUtil.GUID_STRING) && !result.contains(RpyUtil.OLDID_STRING)) {
//			Activator.log.warn(NLS.bind("The ID built for an element of type {0} doesn't contains \"GUID\" neither \"OLDID\" strings.", element.eClass())); //$NON-NLS-1$
//		}
		return result;
	}

	/**
	 * 
	 * @param eobject
	 *            an eobject
	 * @return
	 * 		the current XMI_ID for this object
	 */
	public static final String getXMI_ID(final EObject eobject) {
		final Resource res = eobject.eResource();
		if (res instanceof XMIResource) {
			return ((XMIResource) res).getID(eobject);
		}
		Activator.log.error(NLS.bind("The resource of {0} is not a XMIResource", eobject), null); //$NON-NLS-1$
		return null;
	}
}
