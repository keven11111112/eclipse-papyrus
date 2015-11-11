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
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gmf.runtime.notation.NamedStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.Style;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.aof.core.IBox;
import org.eclipse.papyrus.aof.core.IFactory;
import org.eclipse.papyrus.aof.core.IOne;
import org.eclipse.papyrus.aof.sync.ISyncCorrespondenceResolver;
import org.eclipse.papyrus.aof.sync.ISyncMapping;
import org.eclipse.papyrus.aof.sync.InjectCached;

/**
 * Abstract mapping of views, taking care of properties such as type (the "visual ID") and the
 * reference to the semantic element.
 */
abstract class ViewMapping<V extends View> extends NotationMapping<V> {

	@InjectCached
	private ISyncCorrespondenceResolver<EObject, View> elementCorrespondence;

	@Inject
	private ISyncMapping<Style> styles;

	@Inject
	private ISyncCorrespondenceResolver<Style, View> styleCorrespondence;

	@Inject
	public ViewMapping(EClass type, IFactory factory) {
		super(type, factory);
	}

	@Override
	protected void doMapProperties(IOne<V> from, IOne<V> to) {
		mapCorresponding(from, to, NotationPackage.Literals.VIEW__ELEMENT, elementCorrespondence);

		// Ensure the same type
		bindProperty(from, to, NotationPackage.Literals.VIEW__TYPE);

		// One-way synch all inherited (not attached by distinct style objects) style attributes
		from.get().eClass().getEAllAttributes().stream()
				.filter(attr -> NotationPackage.Literals.STYLE.isSuperTypeOf(attr.getEContainingClass()))
				.forEach(attr -> bindProperty(from, to, attr));

		// Also attached discrete Style objects such as FontStyle for DecorationNodes
		EReference stylesRef = NotationPackage.Literals.VIEW__STYLES;
		IBox<Style> fromStyles = property(from, stylesRef);
		fromStyles = fromStyles.select(this::isStandardStyle);
		IBox<Style> toStyles = property(to, stylesRef);
		toStyles = toStyles.select(this::isStandardStyle);

		mapCorresponding(fromStyles, toStyles, to, stylesRef, styleCorrespondence, styles);
	}

	boolean isStandardStyle(Style style) {
		return !(style instanceof NamedStyle) && (style.eClass().getEPackage() == NotationPackage.eINSTANCE);
	}

}
