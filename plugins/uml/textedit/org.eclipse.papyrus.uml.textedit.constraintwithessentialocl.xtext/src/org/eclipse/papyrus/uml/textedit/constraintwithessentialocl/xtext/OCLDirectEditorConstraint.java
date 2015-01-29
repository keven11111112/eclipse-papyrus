/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Gabriel Pascual (ALL4TEC) gabriel.pascual@all4tec.net - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.textedit.constraintwithessentialocl.xtext;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.extensionpoints.editors.configuration.IDirectEditorConstraint;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.ValueSpecification;

/**
 * Constraint for OCL Direct Editor.
 * 
 * @author Gabriel Pascual
 *
 */
public class OCLDirectEditorConstraint implements IDirectEditorConstraint {

	/** The Constant OCL_LANGAGE_CONSTRAINT. */
	private static final String OCL_LANGAGE_CONSTRAINT = "OCL Langage Constraint";

	/** The Constant OCL_LANGAGE_BODY. */
	private static final String OCL_LANGAGE_BODY = "OCL";

	/**
	 * Constructor.
	 *
	 */
	public OCLDirectEditorConstraint() {
	}

	/**
	 * @see org.eclipse.papyrus.extensionpoints.editors.configuration.IDirectEditorConstraint#getLabel()
	 *
	 * @return
	 */
	public String getLabel() {
		return OCL_LANGAGE_CONSTRAINT;
	}

	/**
	 * @see org.eclipse.papyrus.extensionpoints.editors.configuration.IDirectEditorConstraint#appliesTo(java.lang.Object)
	 *
	 * @param selection
	 * @return
	 */
	public boolean appliesTo(Object selection) {
		boolean appliedConstraint = false;
		EObject resolveEobject = EMFHelper.getEObject(selection);
		if (resolveEobject instanceof Constraint) {
			Constraint selectedConstraint = (Constraint) resolveEobject;
			ValueSpecification constraintSpecification = selectedConstraint.getSpecification();
			if (constraintSpecification instanceof OpaqueExpression) {
				appliedConstraint = ((OpaqueExpression) constraintSpecification).getBodies().isEmpty() || ((OpaqueExpression) constraintSpecification).getLanguages().contains(OCL_LANGAGE_BODY);
			} else {
				appliedConstraint = constraintSpecification instanceof LiteralString;
			}

		}

		return appliedConstraint;
	}
}
