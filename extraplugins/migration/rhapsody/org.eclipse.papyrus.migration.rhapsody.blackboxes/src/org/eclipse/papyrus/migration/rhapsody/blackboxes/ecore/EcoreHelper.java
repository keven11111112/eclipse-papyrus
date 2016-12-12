/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
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

package org.eclipse.papyrus.migration.rhapsody.blackboxes.ecore;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation.Kind;

/**
 * @author VL222926
 *
 */
public class EcoreHelper {

	/**
	 * This method allows to call eAllContents in a QVTo TransformationS
	 * 
	 * @return
	 * 		a list with all the contents of the object
	 */
	@Operation(kind = Kind.HELPER)
	public List<EObject> eAllContents(final EObject eobject) {
		final TreeIterator<EObject> iter = eobject.eAllContents();
		List<EObject> returnedList = new ArrayList<>();
		while (iter.hasNext()) {
			returnedList.add(iter.next());
		}
		return returnedList;
	}
}
