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

package org.eclipse.papyrus.infra.emf.expressions.properties.factories;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.ReferenceBooleanExpression;
import org.eclipse.papyrus.infra.emf.expressions.properties.modelelements.ReferenceBooleanEObjectExpressionModelElement;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.properties.contexts.DataContextElement;
import org.eclipse.papyrus.infra.properties.ui.modelelement.EMFModelElement;
import org.eclipse.papyrus.infra.properties.ui.modelelement.EMFModelElementFactory;

/**
 * @author VL222926
 * 
 */
public class CustomExpressionsEMFModelElementFactory extends EMFModelElementFactory {

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.properties.ui.modelelement.EMFModelElementFactory#doCreateFromSource(java.lang.Object, org.eclipse.papyrus.infra.properties.contexts.DataContextElement)
	 *
	 * @param sourceElement
	 * @param context
	 * @return
	 */
	@Override
	protected EMFModelElement doCreateFromSource(Object sourceElement, DataContextElement context) {
		if (sourceElement instanceof ReferenceBooleanExpression) {
			return new ReferenceBooleanEObjectExpressionModelElement((EObject) sourceElement, EMFHelper.resolveEditingDomain(sourceElement));
		}
		return super.doCreateFromSource(sourceElement, context);
	}
}
