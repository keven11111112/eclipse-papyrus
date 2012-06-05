/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Mathieu Velten (Atos Origin) mathieu.velten@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.core.utils;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;

public class PapyrusEcoreUtils {

	/**
	 * Gets the usages.
	 * 
	 * @param source
	 *        the source
	 * 
	 * @return the usages or null if there is no usages
	 */
	public static Collection<Setting> getUsages(EObject source) {
		if(source == null) {
			return Collections.emptyList();
		}

		ECrossReferenceAdapter crossReferencer = ECrossReferenceAdapter.getCrossReferenceAdapter(source);
		if (crossReferencer == null) {
			// try to register a cross referencer at the highest level
			crossReferencer = new ECrossReferenceAdapter();
			if (source.eResource() != null) {
				if (source.eResource().getResourceSet() != null) {
					crossReferencer.setTarget(source.eResource().getResourceSet());
				} else {
					crossReferencer.setTarget(source.eResource());
				}
			} else {
				crossReferencer.setTarget(source);
			}
		}

		return crossReferencer.getInverseReferences(source, true);
	}

	/**
	 * <pre>
	 * Test if the used element is referenced by other elements than the known
	 * referencer (except its container). It ignores references from an other meta-model.
	 * </pre>
	 * 
	 * @param usedObject
	 *        the used object
	 * @param knownReferencer
	 *        the known referencer
	 * @return true if the known referencer is the only referencer.
	 */
	public static boolean isOnlyUsage(EObject usedObject, EObject knownReferencer) {
		boolean isUsed = false;
		EPackage mmPackage = usedObject.eClass().getEPackage();

		// Retrieve the list of elements referencing the usedObject.
		Set<EObject> crossReferences = new HashSet<EObject>();
		for(Setting setting : PapyrusEcoreUtils.getUsages(usedObject)) {
			EObject eObj = setting.getEObject();
			if(eObj.eClass().getEPackage().equals(mmPackage)) {
				crossReferences.add(eObj);
			}
		}

		// Remove the container of used object.
		crossReferences.remove(usedObject.eContainer());
		// Remove the knownReferencer from the list of references.
		crossReferences.remove(knownReferencer);

		// If no referencer remains in the list, the known element is the only
		// usage.
		if(crossReferences.isEmpty()) {
			isUsed = true;
		}

		return isUsed;
	}
}
