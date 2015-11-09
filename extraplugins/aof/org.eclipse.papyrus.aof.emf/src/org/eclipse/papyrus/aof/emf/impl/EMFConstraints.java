package org.eclipse.papyrus.aof.emf.impl;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.aof.core.IConstraints;
import org.eclipse.papyrus.aof.core.impl.Constraints;

/**
 * Constraints inferred for an EMF feature.
 */
public class EMFConstraints implements IConstraints {
	private final EStructuralFeature feature;
	
	public EMFConstraints(EStructuralFeature feature) {
		super();
		
		this.feature = feature;
	}
	
	// All EMF singleton features behave as Ones with possible null value
	// @see GetSetFeatureDelagate.size
	@Override
	public boolean isOptional() {
		return feature.isMany();// || !feature.isRequired();
	}

	@Override
	public boolean isSingleton() {
		return !feature.isMany();
	}

	@Override
	public boolean isOrdered() {
		return true;// feature.isOrdered() || isSingleton(); // FIXME mandatory to have all EMF features ordered ??
	}

	@Override
	public boolean isUnique() {
		return feature.isUnique() || isSingleton();
	}

	// the constraints are computed form the EMF feature, so we need to check for their consistency
	@Override
	public boolean isLegal() {
		IConstraints delegate = new Constraints(this);
		return delegate.isLegal();
	}

	@Override
	public boolean matches(IConstraints that) {
		IConstraints delegate = new Constraints(this);
		return delegate.matches(that);
	}
}