/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
*     CEA LIST. - initial API and implementation
*     Trung-Truc Nguyen - Bug 473610
*     
*******************************************************************************/
package org.eclipse.papyrus.req.sysml.assistant.testers;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.uml2.uml.Package;

/**
 * This class helps to test if the selected element is a UML Package or not
 */
public class PackageTester extends PropertyTester {

	public static final String isUMLPackage = "isUMLPackage";//NLS
	
	@Override
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if (isUMLPackage.equals(property)) {
			boolean testResult = isExpected((IStructuredSelection) receiver);

			return expectedValue.equals(testResult);
		}
		return false;
	}
	private boolean isExpected(IStructuredSelection receiver) {
		for (Object current : receiver.toArray()) {
			// Adapt current selection to EObject
			if (current instanceof IAdaptable) {
				EObject eObj = (EObject) ((IAdaptable) current)
						.getAdapter(EObject.class);
				if (eObj instanceof Package)
					return true;
			}
			return false;
		}
		return false;
	}

}
