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

package org.eclipse.papyrus.adl4eclipsetool.assistant.handlers;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.adl4eclipse.org.ADL4Eclipse_Stereotypes;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.uml2.uml.Package;

/**
 * {@link PropertyTester} for Architecture Models
 */
public class ArchitectureModelPropertyTester extends PropertyTester {

	/** Tester ID for UML Profile nature */
	public final static String IS_ARCHITECTURE_MODEL = "isArchitectureModel";

	/** Default constructor */
	public ArchitectureModelPropertyTester() {
	}

	/** Test the receiver against the selected property */
	@Override
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if (IS_ARCHITECTURE_MODEL.equals(property)) {
			EObject root = getRoot(receiver);
			return root instanceof Package
					&& (((Package) root).getAppliedProfile(ADL4Eclipse_Stereotypes.ADL4ECLIPSE) != null);
		}

		return false;
	}

	private EObject getRoot(Object receiver) {
		if (receiver instanceof IStructuredSelection) {
			IStructuredSelection selection = (IStructuredSelection) receiver;
			if (!selection.isEmpty()) {
				return EMFHelper.getEObject(selection.getFirstElement());
			}
		}
		return null;
	}
}
