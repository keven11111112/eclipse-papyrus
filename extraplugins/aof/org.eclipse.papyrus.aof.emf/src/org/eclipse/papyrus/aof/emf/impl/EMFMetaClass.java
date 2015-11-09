/*******************************************************************************
 *  Copyright (c) 2015 ESEO, Christian W. Damus, and others.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *     Olivier Beaudoux - initial API and implementation
 *     Christian W. Damus - bug 476683
 *******************************************************************************/
package org.eclipse.papyrus.aof.emf.impl;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.aof.core.IBox;
import org.eclipse.papyrus.aof.core.IMetaClass;
import org.eclipse.papyrus.aof.core.IUnaryFunction;
import org.eclipse.papyrus.aof.core.impl.BaseMetaClass;
import org.eclipse.papyrus.aof.core.impl.utils.cache.IUnaryCache;
import org.eclipse.papyrus.aof.core.impl.utils.cache.WeakKeysWeakValuesUnaryCache;
import org.eclipse.papyrus.aof.emf.EMFFactory;

public class EMFMetaClass<C extends EObject> extends BaseMetaClass<C> {

	private EClass ecoreClass;

	public EMFMetaClass(EClass ecoreClass) {
		this.ecoreClass = ecoreClass;
	}

	@Override
	protected C computeDefaultInstance() {
		return newInstance();
	}

	// IMetaClass

	@Override
	public boolean isInstance(Object object) {
		return ecoreClass.isInstance(object);
	}

	@Override
	public C newInstance() {
		return (C) ecoreClass.getEPackage().getEFactoryInstance().create(ecoreClass);
	}

	@Override
	public boolean isSubTypeOf(IMetaClass<?> that) {
		if (that instanceof EMFMetaClass) {
			EMFMetaClass<?> thatEMFClass = (EMFMetaClass<?>) that;
			return thatEMFClass.ecoreClass.isSuperTypeOf(this.ecoreClass);
		} else {
			// Can't be a subtype of a metaclass from a different platform
			return false;
		}
	}

	private Map<EStructuralFeature, PropertyAccessor<?,C>> cache = new HashMap<EStructuralFeature, PropertyAccessor<?,C>>();

	@Override
	public <B> IUnaryFunction<C, IBox<B>> getPropertyAccessor(Object property) {
		EStructuralFeature feature;
		if (property instanceof EStructuralFeature) {
			feature = (EStructuralFeature) property;
		} else if (property instanceof String) {
			feature = ecoreClass.getEStructuralFeature((String) property);
			if (feature == null) {
				throw new IllegalArgumentException("Property " + property + " not defined in class " + ecoreClass);
			}
		} else {
			throw new IllegalArgumentException("Property " + property + " is neither a Java String, nor an EMF EStructuralFeature");
		}
		PropertyAccessor<B,C> ret = (PropertyAccessor<B,C>) cache.get(feature);
		if (ret == null) {
			ret = new PropertyAccessor<B,C>(feature);
			cache.put(feature, ret);
		}
		return ret;
	}

	// Object

	@Override
	public String toString() {
		return ecoreClass.getName();
	}

	@Override
	public boolean equals(Object other) {
		return (other instanceof EMFMetaClass) && ((EMFMetaClass<?>) other).ecoreClass == this.ecoreClass;
	}

	@Override
	public int hashCode() {
		return this.ecoreClass.hashCode() * 11 + 1;
	}



}
