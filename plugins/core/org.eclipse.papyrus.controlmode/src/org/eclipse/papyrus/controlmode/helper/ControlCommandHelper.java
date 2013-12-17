/*****************************************************************************
 * Copyright (c) 2013 Atos.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Arthur Daussy (Atos) arthur.daussy@atos.net - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.controlmode.helper;

import java.util.Collection;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.core.utils.PapyrusEcoreUtils;

/**
 * Helper for control command
 * 
 * @author adaussy
 * 
 */
public class ControlCommandHelper {

	/**
	 * Return true if the object is an controled object
	 * 
	 * @param eObject
	 * @return
	 */
	public static boolean isRootControledObject(EObject eObject) {
		if(eObject != null) {
			Resource resource = eObject.eResource();
			if(resource != null) {
				EList<EObject> contents = resource.getContents();
				if(contents != null && !contents.isEmpty()) {
					return contents.contains(eObject);
				}
			}
		}
		return false;
	}


	public static Set<Resource> getAffectedResourceByControlCommand(EObject source, Set<Resource> affectedResources) {
		Collection<Setting> settings = PapyrusEcoreUtils.getUsages(source);
		for(Setting setting : settings) {
			EStructuralFeature feature = setting.getEStructuralFeature();
			if(!feature.isDerived() && !feature.isTransient() && !feature.isVolatile()) {
				EObject fromEObject = setting.getEObject();
				Resource resource = fromEObject.eResource();
				if(resource != null) {
					affectedResources.add(resource);
				}
			}
		}
		for(EObject child : source.eContents()) {
			Resource childResoure = child.eResource();
			if(childResoure != null && childResoure.equals(source.eResource())) {
				getAffectedResourceByControlCommand(child, affectedResources);
			}
		}
		return affectedResources;
	}
}
