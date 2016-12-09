/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.migration.rhapsody.blackboxes.uml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.m2m.qvt.oml.blackbox.java.Operation;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation.Kind;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Element;

/**
 * Helper to set register the created association in the correct owner
 *
 */
public class AssociationOwnerHelper {

	/**
	 * This map allow to store the association to store in the nearest package of the key element
	 */
	private final Map<Element, List<Association>> associationsToSet = new HashMap<Element, List<Association>>();

	/**
	 * 
	 * @param an
	 *            element
	 *            the associations will be stored in the nearest package of this element
	 * @param associations
	 *            to store
	 * 
	 * 
	 *            This method allows to save temporary the associations to store in the nearest package of the element.
	 *            This method doesn't do the final store, you need call {@link AssociationOwnerHelper#setAssociationOwnerAndClear()} at the end of your transformation to do really the work
	 */
	@Operation(kind = Kind.HELPER)
	public void registerAssociationToStore(final Element ownerOfThis, List<Association> associations) {
		List<Association> list = associationsToSet.get(ownerOfThis);
		if (list == null) {
			list = new ArrayList<Association>();
			associationsToSet.put(ownerOfThis, list);
		}
		for (Association curr : associations) {
			if (curr != null) {
				list.add(curr);
			}
		}

	}

	/**
	 * This method crosses the element registered previously with {@link AssociationOwnerHelper#registerAssociationToStore(Element, List)} and register their association into their nearest package, then clean the private map used to save them temporary
	 */
	@Operation(kind = Kind.HELPER)
	public void setAssociationOwnerAndClear() {
		for (Element key : associationsToSet.keySet()) {
			key.getNearestPackage().getPackagedElements().addAll(associationsToSet.get(key));
		}
		associationsToSet.clear();
	}
}
