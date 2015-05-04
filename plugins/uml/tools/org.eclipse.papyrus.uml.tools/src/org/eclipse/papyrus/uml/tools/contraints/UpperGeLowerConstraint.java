/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Nicolas FAUVERGUE (ALL4TEC) nicolas.fauvergue@all4tec.net - Initial API and implementation
 *  
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.contraints;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.EMFEventType;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.uml2.uml.LiteralInteger;
import org.eclipse.uml2.uml.LiteralUnlimitedNatural;
import org.eclipse.uml2.uml.MultiplicityElement;
import org.eclipse.uml2.uml.NamedElement;

/**
 * This class allows to manage the UpperGeLower constraint (this one will be called only if the lower and upper values are LiteralInteger of LiteralUnlimitedNatural).
 */
public class UpperGeLowerConstraint extends AbstractModelConstraint {

	/**
	 * Constructor.
	 */
	public UpperGeLowerConstraint() {
		super();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.validation.AbstractModelConstraint#validate(org.eclipse.emf.validation.IValidationContext)
	 */
	@Override
	public IStatus validate(final IValidationContext ctx) {
		IStatus result = ctx.createSuccessStatus();
		final EObject target = ctx.getTarget();
		final EMFEventType type = ctx.getEventType();
		
		// In the case of batch mode.
		if (EMFEventType.NULL == type) {
			if(target instanceof MultiplicityElement){
				final MultiplicityElement multiplicityElement = (MultiplicityElement)target;
				if(canCompareUpperGeLower(multiplicityElement)){
					if(!multiplicityElement.validateUpperGeLower(null, null)){
						final StringBuilder name = new StringBuilder();
						name.append("'");
						if(multiplicityElement instanceof NamedElement){
							name.append(((NamedElement) multiplicityElement).getQualifiedName());
						}else{
							name.append(multiplicityElement.eClass().getName());
						}
						name.append("'");
						result = ctx.createFailureStatus(name.toString());
					}
				}
			}
		}
		
		return result;
	}
	
	/**
	 * This allows to define if the multiplicity element can compare the lower and the upper values (depending to the type of ValueSpecifications).
	 * 
	 * @param eObject
	 *            The {@link EObject} to check.
	 * @return <code>true</code> if the lower and upper can be compared (or if this is not a MultiplicityElement), <code>false</code> otherwise.
	 */
	private boolean canCompareUpperGeLower(final MultiplicityElement multiplicityElement) {
		boolean result = true;
		if ((!((multiplicityElement.getLowerValue() instanceof LiteralInteger || multiplicityElement.getLowerValue() instanceof LiteralUnlimitedNatural)
				&& (multiplicityElement.getUpperValue() instanceof LiteralInteger || multiplicityElement.getUpperValue() instanceof LiteralUnlimitedNatural)))) {
			result = false;
		}
		return result;
	}

}
