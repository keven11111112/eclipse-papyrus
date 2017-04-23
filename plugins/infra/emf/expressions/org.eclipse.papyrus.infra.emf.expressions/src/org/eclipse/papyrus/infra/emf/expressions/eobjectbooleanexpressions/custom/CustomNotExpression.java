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
import org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.impl.NotExpressionImpl;


public class CustomNotExpression extends NotExpressionImpl{
	
	@Override
	public Boolean evaluate(EObject context) {
		//1. we evaluate the own expression first
		if(null!=ownedExpression) {
			return !ownedExpression.evaluate(context);
		}
		
		//2. we evaluate the referenced expression
		if(null!=referencedExpression) {
			return !referencedExpression.evaluate(context);
		}
		
		//3. we return the default value
		return Boolean.FALSE;
	}
}