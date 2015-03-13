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
package org.eclipse.papyrus.aof.emf.impl.utils;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.aof.core.IBox;
import org.eclipse.papyrus.aof.core.IUnaryFunction;
import org.eclipse.papyrus.aof.core.impl.utils.Cache;
import org.eclipse.papyrus.aof.emf.EMFFactory;

public class EMFFeatureAccessor<A, B> implements IUnaryFunction<A, IBox<B>> {

	private EStructuralFeature feature;

	// only used for memory optimization
	// method apply would work without such a cache
	private static Cache cache = new Cache();

	public EMFFeatureAccessor(EStructuralFeature feature) {
		this.feature = feature;
	}

	public IBox<B> apply(A object) {
		Object result = cache.getTarget(object, feature);
		if (result == null) {
			result = EMFFactory.INSTANCE.createPropertyBox(object, feature);
			cache.addLink(object, feature, result);
		}
		return (IBox<B>) result;
	}

}
