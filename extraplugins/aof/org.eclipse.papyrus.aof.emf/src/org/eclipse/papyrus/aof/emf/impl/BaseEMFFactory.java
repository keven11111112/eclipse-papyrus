/*******************************************************************************
 *  Copyright (c) 2015 ESEO.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *     Olivier Beaudoux - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.aof.emf.impl;

import java.lang.reflect.Constructor;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.aof.core.AOFFactory;
import org.eclipse.papyrus.aof.core.IBox;
import org.eclipse.papyrus.aof.core.IUnaryFunction;
import org.eclipse.papyrus.aof.core.impl.BaseFactory;
import org.eclipse.papyrus.aof.emf.impl.delegate.FeatureDelegate;
import org.eclipse.papyrus.aof.emf.impl.delegate.GetSetFeatureDelegate;
import org.eclipse.papyrus.aof.emf.impl.delegate.ListFeatureDelegate;
import org.eclipse.papyrus.aof.emf.impl.utils.EMFFeatureAccessor;

public class BaseEMFFactory extends BaseFactory {

	public <A> IBox<A> createPropertyBox(Object object, Object property) {
		if ((object instanceof EObject) && (property instanceof EStructuralFeature)) {
			EObject eobject = (EObject) object;
			EStructuralFeature feature = (EStructuralFeature) property;
			FeatureDelegate<A> delegate;
			if (feature.isMany()) {
				delegate = new ListFeatureDelegate<A>(eobject, feature);
			}
			else {
				delegate = new GetSetFeatureDelegate<A>(eobject, feature);
			}
			return createBox(delegate, delegate);
		}
		else if (!(object instanceof EObject)) {
			throw new IllegalArgumentException("Object " + object + " is not an EObject");
		}
		else /* if (!(property instanceof EStructuralFeature)) */ {
			throw new IllegalArgumentException("Property " + property + " is not an EStructuralFeature");
		}
	}

	public <A, B> IUnaryFunction<A, IBox<B>> createPropertyAccessor(Object property) {
		if (property instanceof EStructuralFeature) {
			return new EMFFeatureAccessor<A, B>((EStructuralFeature) property);
		}
		else {
			throw new IllegalArgumentException("Property " + property + " is not an EStructuralFeature");
		}
	}


	public <A> A createInstance(Object clazz) throws ClassNotFoundException {
		if (clazz instanceof Class<?>) {
			return AOFFactory.INSTANCE.createInstance(clazz);
		}
		else if (clazz instanceof EClass) {
			EClass eclass = (EClass) clazz;
			String packageFullName = eclass.getInstanceClass().getPackage().getName();
			packageFullName = packageFullName + ".impl";
			Class<A> implClass = (Class<A>) Class.forName(packageFullName + "." + eclass.getName() + "Impl");
			try {
				Constructor defaultConstructor = implClass.getDeclaredConstructor();
				defaultConstructor.setAccessible(true);
				return (A) defaultConstructor.newInstance();
			} catch (Exception e) {
				throw new IllegalArgumentException("Implementation class " + implClass + " of interface " + clazz + " is not well formed to the respect of AOF");
			}
		}
		else
			throw new IllegalArgumentException("Class " + clazz + " is neither a Java Class<T>, nor an EClass");
	}

}
