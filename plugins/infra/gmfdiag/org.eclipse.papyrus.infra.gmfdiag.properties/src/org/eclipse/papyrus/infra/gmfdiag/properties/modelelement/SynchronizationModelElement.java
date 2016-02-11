/*****************************************************************************
 * Copyright (c) 2015 Christian W. Damus and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Christian W. Damus - Initial API and implementation
 *  
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.properties.modelelement;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.papyrus.infra.gmfdiag.properties.databinding.CanonicalObservableValue;
import org.eclipse.papyrus.infra.properties.ui.modelelement.AbstractModelElement;

/**
 * An encapsulation of the synthetic synchronization-related properties of an {@link EditPart} in the diagrams.
 */
public class SynchronizationModelElement extends AbstractModelElement {
	TransactionalEditingDomain domain;
	EditPart editPart;

	public SynchronizationModelElement(TransactionalEditingDomain domain, EditPart source) {
		super();

		this.domain = domain;
		this.editPart = source;
	}

	@Override
	protected IObservable doGetObservable(String propertyPath) {
		IObservable result = null;

		if (propertyPath.endsWith("syncWithModel")) {
			result = new CanonicalObservableValue(domain, editPart);
		}

		return result;
	}
}
