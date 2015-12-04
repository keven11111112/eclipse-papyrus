/*****************************************************************************
 * Copyright (c) 2015 Christian W. Damus and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.infra.editor.welcome.internal.constraints;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.papyrus.infra.constraints.SimpleConstraint;
import org.eclipse.papyrus.infra.constraints.constraints.AbstractConstraint;
import org.eclipse.papyrus.infra.constraints.constraints.Constraint;
import org.eclipse.papyrus.infra.editor.welcome.WelcomePackage;

/**
 * @author damus
 *
 */
public class IsWelcomeElement extends AbstractConstraint {

	private EClassifier eclassifier;

	public IsWelcomeElement() {
		super();
	}

	@Override
	protected void setDescriptor(SimpleConstraint descriptor) {
		eclassifier = WelcomePackage.eINSTANCE.getEClassifier(getValue("metaclassName"));
	}

	@Override
	protected boolean match(Object selection) {
		return (eclassifier != null) && eclassifier.isInstance(selection);
	}

	@Override
	protected boolean equivalent(Constraint other) {
		return (other instanceof IsWelcomeElement)
				&& (((IsWelcomeElement) other).eclassifier == this.eclassifier);
	}

}
