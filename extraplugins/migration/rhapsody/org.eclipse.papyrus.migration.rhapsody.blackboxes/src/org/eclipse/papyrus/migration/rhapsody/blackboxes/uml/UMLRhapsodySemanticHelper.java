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
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation.Kind;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IColor;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ITag;

/**
 * @author VL222926
 *
 */
public class UMLRhapsodySemanticHelper {


	/**
	 * 
	 * @param rhapsodyElement
	 *            an EObject
	 * @return
	 * 		all semantic elements (so the element which can be stereotyped)
	 */
	@Operation(kind = Kind.HELPER)
	public List<EObject> getAllUMLSemanticElementAsList(final EObject rhapsodyElement) {
		TreeIterator<EObject> iter = rhapsodyElement.eAllContents();
		List<EObject> returnedList = new ArrayList<EObject>();
		while (iter.hasNext()) {
			EObject current = iter.next();
			if (isASemanticElement(current)) {
				returnedList.add(current);
			}
		}
		return returnedList;
	}

	/**
	 * 
	 * @param rhapsodyElement
	 *            a rhapsody object
	 * @return
	 * 		<code>true</code> if the rhapsody object represents a UML semantic element
	 */
	@Operation(kind = Kind.HELPER)
	private boolean isASemanticElement(final EObject rhapsodyElement) {
		if (rhapsodyElement.getClass().getName().contains("CGI")) { //$NON-NLS-1$
			return false;
		} else if (rhapsodyElement instanceof IColor) {
			return false;
		} else if (rhapsodyElement instanceof ITag) {
			return false;
		}
		return true;
	}
	
}
