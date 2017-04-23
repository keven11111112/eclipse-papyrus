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

import org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.AndExpression;
import org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.LiteralFalseExpression;
import org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.LiteralTrueExpression;
import org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.NotExpression;
import org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.OrExpression;
import org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.ReferenceBooleanExpression;
import org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.impl.EObjectBooleanExpressionsFactoryImpl;

public class CustomEObjectBooleanExpressionsFactory extends EObjectBooleanExpressionsFactoryImpl {

	/**
	 * @see org.eclipse.papyrus.infra.emf.expressions.eobjectbooleanexpressions.impl.EObjectBooleanExpressionsFactoryImpl#createAndExpression()
	 *
	 * @return
	 */

	@Override
	public AndExpression createAndExpression() {
		return new CustomAndExpression();
	}

	/**
	 * @see org.eclipse.papyrus.infra.emf.expressions.eobjectbooleanexpressions.impl.EObjectBooleanExpressionsFactoryImpl#createLiteralTrueExpression()
	 *
	 * @return
	 */

	@Override
	public LiteralTrueExpression createLiteralTrueExpression() {
		return new CustomLiteralTrueExpression();
	}

	/**
	 * @see org.eclipse.papyrus.infra.emf.expressions.eobjectbooleanexpressions.impl.EObjectBooleanExpressionsFactoryImpl#createOrExpression()
	 *
	 * @return
	 */

	@Override
	public OrExpression createOrExpression() {
		return new CustomOrExpression();
	}

	/**
	 * @see org.eclipse.papyrus.infra.emf.expressions.eobjectbooleanexpressions.impl.EObjectBooleanExpressionsFactoryImpl#createNotExpression()
	 *
	 * @return
	 */

	@Override
	public NotExpression createNotExpression() {
		return new CustomNotExpression();
	}

	/**
	 * @see org.eclipse.papyrus.infra.emf.expressions.eobjectbooleanexpressions.impl.EObjectBooleanExpressionsFactoryImpl#createLiteralFalseExpression()
	 *
	 * @return
	 */

	@Override
	public LiteralFalseExpression createLiteralFalseExpression() {
		return new CustomLiteralFalseExpression();
	}

	/**
	 * @see org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.impl.EObjectBooleanExpressionsFactoryImpl#createReferenceBooleanExpression()
	 *
	 * @return
	 */
	@Override
	public ReferenceBooleanExpression createReferenceBooleanExpression() {
		return new CustomReferenceBooleanExpression();
	}

}
