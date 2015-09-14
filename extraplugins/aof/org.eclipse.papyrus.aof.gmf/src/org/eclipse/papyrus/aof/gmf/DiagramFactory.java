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

package org.eclipse.papyrus.aof.gmf;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Singleton;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.LayoutConstraint;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.aof.core.AOFFactory;
import org.eclipse.papyrus.aof.core.IBox;
import org.eclipse.papyrus.aof.core.IFactory;
import org.eclipse.papyrus.aof.core.IMetaClass;
import org.eclipse.papyrus.aof.core.IUnaryFunction;
import org.eclipse.papyrus.aof.core.impl.BaseFactory;
import org.eclipse.papyrus.aof.emf.EMFFactory;
import org.eclipse.papyrus.aof.gmf.internal.DiagramMetaClass;
import org.eclipse.papyrus.aof.gmf.internal.MetaclassWrapper;

/**
 * An AOF factory for metaclasses in the domain of GMF Notation views (diagrams).
 */
@Singleton
public class DiagramFactory extends BaseFactory {
	public static final String LOCATION_PROPERTY = NotationPackage.eNAME + "::Location"; //$NON-NLS-1$

	public static final String SIZE_PROPERTY = NotationPackage.eNAME + "::Size"; //$NON-NLS-1$

	public static final String CHILDREN_PROPERTY = NotationPackage.Literals.VIEW__PERSISTED_CHILDREN.getName();

	public static final DiagramFactory INSTANCE = new DiagramFactory();

	private final IFactory aof = AOFFactory.INSTANCE;
	private final IFactory emf = EMFFactory.INSTANCE;

	private final Map<Object, IMetaClass<?>> metaclasses = new HashMap<>();

	public DiagramFactory() {
		super();
	}

	public IBox<Location> getLocationProperty(Node node) {
		return createPropertyBox(node, LOCATION_PROPERTY);
	}

	public IBox<Location> getSizeProperty(Node node) {
		return createPropertyBox(node, SIZE_PROPERTY);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public <C> IMetaClass<C> getMetaClass(Object platformClass) {
		IMetaClass<C> result;

		result = (IMetaClass<C>) metaclasses.get(platformClass);
		if (result == null) {
			if (platformClass instanceof Class<?>) {
				Class<C> javaClass = (Class<C>) platformClass;
				if (isNotationViewClass(javaClass) || isLayoutConstraintClass(javaClass)) {
					EClass eClass = getNotationEClass(javaClass);
					result = new DiagramMetaClass(this, eClass);
				} else {
					// Other metamodel
					result = new MetaclassWrapper<>(this, aof.getMetaClass(platformClass));
				}
			} else if (platformClass instanceof EClass) {
				EClass eclass = (EClass) platformClass;
				if (isNotationViewClass(eclass) || isLayoutConstraintClass(eclass)) {
					result = new DiagramMetaClass(this, eclass);
				} else {
					// Other metamodel
					result = new MetaclassWrapper<>(this, emf.getMetaClass(platformClass));
				}
			} else {
				throw new IllegalArgumentException("Invalid platform class: " + platformClass);
			}

			metaclasses.put(platformClass, result);
		}

		return result;
	}

	static boolean isNotationViewClass(Class<?> javaClass) {
		return View.class.isAssignableFrom(javaClass) && isNotationClass(javaClass);
	}

	static boolean isNotationClass(Class<?> javaClass) {
		return (javaClass.getPackage() == NotationPackage.class.getPackage())
				|| (javaClass.getPackage() == NotationPackage.eINSTANCE.getClass().getPackage());
	}

	static boolean isNotationViewClass(EClass eClass) {
		return NotationPackage.Literals.VIEW.isSuperTypeOf(eClass) && isNotationClass(eClass);
	}

	static boolean isLayoutConstraintClass(Class<?> javaClass) {
		return LayoutConstraint.class.isAssignableFrom(javaClass) && isNotationClass(javaClass);
	}

	static boolean isNotationClass(EClass eClass) {
		return NotationPackage.eINSTANCE == eClass.getEPackage();
	}

	static boolean isLayoutConstraintClass(EClass eClass) {
		return NotationPackage.Literals.LAYOUT_CONSTRAINT.isSuperTypeOf(eClass) && isNotationClass(eClass);
	}

	static EClass getNotationEClass(Class<?> javaClass) {
		String name = javaClass.getSimpleName();
		if (name.endsWith("Impl")) { //$NON-NLS-1$
			name = name.substring(0, name.length() - "Impl".length()); //$NON-NLS-1$
		}
		EClassifier result = NotationPackage.eINSTANCE.getEClassifier(name);

		if (!(result instanceof EClass)) {
			throw new IllegalArgumentException("Invalid platform class: " + javaClass);
		}

		return (EClass) result;
	}

	@Override
	public <C, P> IBox<P> createPropertyBox(C object, Object property) {
		IMetaClass<C> metaclass;
		if (object instanceof EObject) {
			metaclass = getMetaClass(((EObject) object).eClass());
		} else {
			metaclass = getMetaClass(object.getClass());
		}

		IUnaryFunction<C, IBox<P>> accessor = metaclass.getPropertyAccessor(property);
		return accessor.apply(object);
	}

}
