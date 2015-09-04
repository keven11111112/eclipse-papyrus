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

package org.eclipse.papyrus.aof.gmf.internal;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.Size;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.aof.core.IBox;
import org.eclipse.papyrus.aof.core.utils.Functions;
import org.eclipse.papyrus.aof.emf.impl.EMFMetaClass;
import org.eclipse.papyrus.aof.emf.impl.PropertyAccessor;
import org.eclipse.papyrus.aof.gmf.DiagramFactory;

/**
 * An AOF metaclass for objects in the domain of GMF Notation views (diagrams).
 */
public class DiagramMetaClass<C extends View> extends EMFMetaClass<C> {

	public DiagramMetaClass(EClass ecoreClass) {
		super(ecoreClass);
	}

	@Override
	public C newInstance() {
		C result;

		switch (getEClass().getClassifierID()) {
		case NotationPackage.LOCATION:
		case NotationPackage.SIZE:
			@SuppressWarnings("unchecked")
			C bounds = (C) NotationFactory.eINSTANCE.createBounds();
			result = bounds;
			break;
		default:
			result = super.newInstance();
			break;
		}

		return result;
	}

	@Override
	protected EStructuralFeature resolveStructuralFeature(Object property) {
		EStructuralFeature result;

		if (property instanceof EClass) {
			// We use notation metamodel classes to identify them as properties
			property = EMFCoreUtil.getQualifiedName((EClass) property, true);
		}

		if (property instanceof String) {
			switch ((String) property) {
			case DiagramFactory.LOCATION_PROPERTY:
			case DiagramFactory.SIZE_PROPERTY:
				// In both cases, the node's bounds implements the required interface.
				result = NotationPackage.Literals.NODE__LAYOUT_CONSTRAINT;
				break;
			default:
				result = super.resolveStructuralFeature(property);
				break;
			}
		} else {
			result = super.resolveStructuralFeature(property);
		}

		return result;
	}

	@Override
	protected <B> PropertyAccessor<B, C> createPropertyAccessor(Object property, EStructuralFeature feature) {
		PropertyAccessor<B, C> result = super.createPropertyAccessor(property, feature);

		if (property instanceof EClass) {
			// We use notation metamodel classes to identify them as properties
			property = EMFCoreUtil.getQualifiedName((EClass) property, true);
		}

		if (property instanceof String) {
			switch ((String) property) {
			case DiagramFactory.LOCATION_PROPERTY:
				result = select(result, feature, Location.class);
				break;
			case DiagramFactory.SIZE_PROPERTY:
				result = select(result, feature, Size.class);
				break;
			}
		}

		return result;
	}

	static <B, C extends EObject> PropertyAccessor<B, C> select(PropertyAccessor<B, C> propertyAccessor, EStructuralFeature feature, Class<?> type) {
		return new PropertyAccessor<B, C>(feature) {
			@Override
			public IBox<B> apply(C input) {
				return propertyAccessor.apply(input).select(Functions.instanceOf(type));
			}
		};
	}
}
