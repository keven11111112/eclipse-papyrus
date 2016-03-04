/**
 * Copyright (c) 2016 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   CEA LIST - Initial API and implementation
 * 
 */
package org.omg.smm.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.omg.smm.MeasureLibrary;
import org.omg.smm.Observation;
import org.omg.smm.SmmModel;
import org.omg.smm.SmmPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.omg.smm.impl.SmmModelImpl#getLibraries <em>Libraries</em>}</li>
 *   <li>{@link org.omg.smm.impl.SmmModelImpl#getObservations <em>Observations</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SmmModelImpl extends SmmElementImpl implements SmmModel {
	/**
	 * The cached value of the '{@link #getLibraries() <em>Libraries</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLibraries()
	 * @generated
	 * @ordered
	 */
	protected EList<MeasureLibrary> libraries;

	/**
	 * The cached value of the '{@link #getObservations() <em>Observations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObservations()
	 * @generated
	 * @ordered
	 */
	protected EList<Observation> observations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SmmModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SmmPackage.Literals.SMM_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MeasureLibrary> getLibraries() {
		if (libraries == null) {
			libraries = new EObjectContainmentEList<MeasureLibrary>(MeasureLibrary.class, this, SmmPackage.SMM_MODEL__LIBRARIES);
		}
		return libraries;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Observation> getObservations() {
		if (observations == null) {
			observations = new EObjectContainmentEList<Observation>(Observation.class, this, SmmPackage.SMM_MODEL__OBSERVATIONS);
		}
		return observations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SmmPackage.SMM_MODEL__LIBRARIES:
				return ((InternalEList<?>)getLibraries()).basicRemove(otherEnd, msgs);
			case SmmPackage.SMM_MODEL__OBSERVATIONS:
				return ((InternalEList<?>)getObservations()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SmmPackage.SMM_MODEL__LIBRARIES:
				return getLibraries();
			case SmmPackage.SMM_MODEL__OBSERVATIONS:
				return getObservations();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SmmPackage.SMM_MODEL__LIBRARIES:
				getLibraries().clear();
				getLibraries().addAll((Collection<? extends MeasureLibrary>)newValue);
				return;
			case SmmPackage.SMM_MODEL__OBSERVATIONS:
				getObservations().clear();
				getObservations().addAll((Collection<? extends Observation>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case SmmPackage.SMM_MODEL__LIBRARIES:
				getLibraries().clear();
				return;
			case SmmPackage.SMM_MODEL__OBSERVATIONS:
				getObservations().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SmmPackage.SMM_MODEL__LIBRARIES:
				return libraries != null && !libraries.isEmpty();
			case SmmPackage.SMM_MODEL__OBSERVATIONS:
				return observations != null && !observations.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SmmModelImpl
