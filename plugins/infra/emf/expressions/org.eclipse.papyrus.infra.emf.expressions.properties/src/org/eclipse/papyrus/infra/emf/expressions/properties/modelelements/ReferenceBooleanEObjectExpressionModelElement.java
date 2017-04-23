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
import org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.EObjectBooleanExpressionsPackage;
import org.eclipse.papyrus.infra.emf.expressions.properties.provider.ExpressionCatalogContentProvider;
import org.eclipse.papyrus.infra.properties.ui.modelelement.EMFModelElement;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;

/**
 * @author VL222926
 *
 */
public class ReferenceBooleanEObjectExpressionModelElement extends EMFModelElement {

	/**
	 * The managed feature
	 */
	private String REFERENCED_EXPRESSION = "referencedExpression";// $NON-NLS-0$

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
		if (REFERENCED_EXPRESSION.equals(propertyPath)) {
			return new ExpressionCatalogContentProvider(EObjectBooleanExpressionsPackage.eINSTANCE.getReferenceBooleanExpression_ReferencedExpression());
		}
		return super.getContentProvider(propertyPath);
	}

}
