/*****************************************************************************
 * Copyright (c) 2017 CEA LIST and others.
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

package org.eclipse.papyrus.infra.emf.expressions.properties.modelelements;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.emf.expressions.booleanexpressions.BooleanExpressionsPackage;
import org.eclipse.papyrus.infra.emf.expressions.properties.provider.ExpressionCatalogContentProvider;
import org.eclipse.papyrus.infra.properties.ui.modelelement.EMFModelElement;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;

/**
 * @author VL222926
 *
 */
public class ReferenceBooleanEObjectExpressionModelElement extends EMFModelElement {

	/**
	 * Constructor.
	 *
	 * @param source
	 * @param domain
	 */
	public ReferenceBooleanEObjectExpressionModelElement(final EObject source, final EditingDomain domain) {
		super(source, domain);
	}

	/**
	 * Constructor.
	 *
	 * @param source
	 */
	public ReferenceBooleanEObjectExpressionModelElement(final EObject source) {
		super(source);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.properties.ui.modelelement.EMFModelElement#getContentProvider(java.lang.String)
	 *
	 * @param propertyPath
	 * @return
	 */
	@Override
	public IStaticContentProvider getContentProvider(final String propertyPath) {
		if (BooleanExpressionsPackage.eINSTANCE.getReferenceBooleanExpression_ReferencedExpression().getName().equals(propertyPath)) {
			return new ExpressionCatalogContentProvider(BooleanExpressionsPackage.eINSTANCE.getReferenceBooleanExpression_ReferencedExpression());
		}
		return super.getContentProvider(propertyPath);
	}

}
