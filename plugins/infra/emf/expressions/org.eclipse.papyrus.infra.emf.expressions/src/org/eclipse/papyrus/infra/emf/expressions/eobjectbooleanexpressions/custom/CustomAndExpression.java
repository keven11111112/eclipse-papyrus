/**
 * Copyright (c) 2017 CEA LIST.
 * 
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.infra.emf.expressions.eobjectbooleanexpressions.custom;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.IBooleanExpression;
import org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.impl.AndExpressionImpl;

public class CustomAndExpression extends AndExpressionImpl{
	
	@Override
	public Boolean evaluate(EObject context) {
		for(IBooleanExpression<EObject> current : getOwnedExpressions()) {
			if(Boolean.FALSE.equals(current.evaluate(context))){
				return Boolean.FALSE;
			}
		}
		
		for(IBooleanExpression<EObject> current : getReferencedExpressions()) {
			if(Boolean.FALSE.equals(current.evaluate(context))){
				return Boolean.FALSE;
			}
		}

		
		return Boolean.TRUE;
	}
}