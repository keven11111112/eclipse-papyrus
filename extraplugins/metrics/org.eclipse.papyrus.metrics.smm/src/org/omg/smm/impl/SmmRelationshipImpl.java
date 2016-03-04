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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.omg.smm.SmmElement;
import org.omg.smm.SmmPackage;
import org.omg.smm.SmmRelationship;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Relationship</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.omg.smm.impl.SmmRelationshipImpl#getFrom <em>From</em>}</li>
 *   <li>{@link org.omg.smm.impl.SmmRelationshipImpl#getTo <em>To</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class SmmRelationshipImpl extends SmmElementImpl implements SmmRelationship {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SmmRelationshipImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SmmPackage.Literals.SMM_RELATIONSHIP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SmmElement getFrom() {
		SmmElement from = basicGetFrom();
		return from != null && from.eIsProxy() ? (SmmElement)eResolveProxy((InternalEObject)from) : from;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SmmElement basicGetFrom() {
		// TODO: implement this method to return the 'From' reference
		// -> do not perform proxy resolution
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFrom(SmmElement newFrom) {
		// TODO: implement this method to set the 'From' reference
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SmmElement getTo() {
		SmmElement to = basicGetTo();
		return to != null && to.eIsProxy() ? (SmmElement)eResolveProxy((InternalEObject)to) : to;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SmmElement basicGetTo() {
		// TODO: implement this method to return the 'To' reference
		// -> do not perform proxy resolution
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTo(SmmElement newTo) {
		// TODO: implement this method to set the 'To' reference
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SmmPackage.SMM_RELATIONSHIP__FROM:
				if (resolve) return getFrom();
				return basicGetFrom();
			case SmmPackage.SMM_RELATIONSHIP__TO:
				if (resolve) return getTo();
				return basicGetTo();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SmmPackage.SMM_RELATIONSHIP__FROM:
				setFrom((SmmElement)newValue);
				return;
			case SmmPackage.SMM_RELATIONSHIP__TO:
				setTo((SmmElement)newValue);
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
			case SmmPackage.SMM_RELATIONSHIP__FROM:
				setFrom((SmmElement)null);
				return;
			case SmmPackage.SMM_RELATIONSHIP__TO:
				setTo((SmmElement)null);
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
			case SmmPackage.SMM_RELATIONSHIP__FROM:
				return basicGetFrom() != null;
			case SmmPackage.SMM_RELATIONSHIP__TO:
				return basicGetTo() != null;
		}
		return super.eIsSet(featureID);
	}

} //SmmRelationshipImpl
