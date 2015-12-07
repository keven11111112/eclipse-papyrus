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

package org.eclipse.papyrus.infra.gmfdiag.welcome.internal.modelelements;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.views.properties.modelelement.EMFModelElement;

/**
 * @author damus
 *
 */
public class WelcomeModelElement extends EMFModelElement {
	private final String DIAGRAMS = "diagrams"; //$NON-NLS-1$

	public WelcomeModelElement(EObject source, EditingDomain domain) {
		super(source, domain);
	}

	@Override
	protected IObservable doGetObservable(String propertyPath) {
		IObservable result;

		switch (propertyPath) {
		case DIAGRAMS:
			result = new DiagramsObservableList(this);
			break;
		default:
			result = super.doGetObservable(propertyPath);
			break;
		}

		return result;
	}

	@Override
	protected boolean isFeatureEditable(String propertyPath) {
		boolean result;

		switch (propertyPath) {
		case DIAGRAMS:
			result = true;
			break;
		default:
			result = super.isFeatureEditable(propertyPath);
			break;
		}

		return result;
	}

	@Override
	protected boolean isElementEditable() {
		return true;
	}
}
