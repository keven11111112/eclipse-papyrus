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

package org.eclipse.papyrus.aof.sync.gmf.internal;

import javax.inject.Inject;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.aof.core.IFactory;
import org.eclipse.papyrus.aof.core.IOne;
import org.eclipse.papyrus.aof.sync.AbstractMapping;
import org.eclipse.papyrus.aof.sync.ICorrespondenceResolver;
import org.eclipse.papyrus.aof.sync.InjectCached;

/**
 * Abstract mapping of views, taking care of properties such as type (the "visual ID") and the
 * reference to the semantic element.
 */
abstract class ViewMapping<V extends View> extends AbstractMapping<V> {

	@InjectCached
	private ICorrespondenceResolver<EObject, View> elementCorrespondence;

	@Inject
	public ViewMapping(EClass type, IFactory factory) {
		super(type, factory);
	}

	@Override
	protected void mapProperties(IOne<V> from, IOne<V> to) {
		mapCorresponding(from, to, NotationPackage.Literals.VIEW__ELEMENT, elementCorrespondence);

		// Ensure the same type
		property(to, NotationPackage.Literals.VIEW__TYPE).bind(property(from, NotationPackage.Literals.VIEW__TYPE))
				.setAutoDisable(true);
	}
}
