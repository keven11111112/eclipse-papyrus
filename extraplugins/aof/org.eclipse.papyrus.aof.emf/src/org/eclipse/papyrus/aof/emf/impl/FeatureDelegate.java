/*******************************************************************************
 *  Copyright (c) 2015 ESEO, Christian W. Damus, and others.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *     Olivier Beaudoux - initial API and implementation
 *     Frederic Jouault - API and implementation improvements
 *     Christian W. Damus - bug 476683
 *******************************************************************************/
package org.eclipse.papyrus.aof.emf.impl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.aof.core.IConstraints;
import org.eclipse.papyrus.aof.core.impl.BaseDelegate;

/**
 * A delegate bound to an EMF object property.
 *
 * @author obeaudoux
 *
 * @param <E>
 */

public abstract class FeatureDelegate<E> extends BaseDelegate<E> implements IConstraints {

	private EObject object;

	private EStructuralFeature feature;

	private IConstraints constraints;

	private IDisposalDelegate disposalDelegate;

	protected FeatureDelegate(EObject object, EStructuralFeature feature) {
		this.object = object;
		this.feature = feature;
		this.constraints = new EMFConstraints(feature);
	}

	protected EObject getObject() {
		return object;
	}

	protected EStructuralFeature getFeature() {
		return feature;
	}

	protected final void onDisposed(final IDisposalDelegate disposalDelegate) {
		if (this.disposalDelegate == null) {
			this.disposalDelegate = disposalDelegate;
		} else {
			// Chain them
			final IDisposalDelegate chained = this.disposalDelegate;

			this.disposalDelegate = new IDisposalDelegate() {

				@Override
				public void onDisposed(FeatureDelegate<?> delegate) {
					disposalDelegate.onDisposed(delegate);
					chained.onDisposed(delegate);
				}
			};
		}
	}

	protected final void disposed() {
		if (disposalDelegate != null) {
			disposalDelegate.onDisposed(this);
			disposalDelegate = null;
		}
	}

	// IConstraints delegation

	@Override
	public boolean isOptional() {
		return constraints.isOptional();
	}

	@Override
	public boolean isSingleton() {
		return constraints.isSingleton();
	}

	@Override
	public boolean isOrdered() {
		return constraints.isOrdered();
	}

	@Override
	public boolean isUnique() {
		return constraints.isUnique();
	}

	@Override
	public boolean isLegal() {
		return constraints.isLegal();
	}

	@Override
	public boolean matches(IConstraints that) {
		return constraints.matches(that);
	}

	//
	// Nested types
	//

}
