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
import org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.impl.ReferenceBooleanExpressionImpl;

public class CustomReferenceBooleanExpression extends ReferenceBooleanExpressionImpl {

	@Override
	public Boolean evaluate(EObject context) {
		if (null != this.referencedExpression) {
			return this.referencedExpression.evaluate(context);
		}
		return Boolean.TRUE;
	}
}
