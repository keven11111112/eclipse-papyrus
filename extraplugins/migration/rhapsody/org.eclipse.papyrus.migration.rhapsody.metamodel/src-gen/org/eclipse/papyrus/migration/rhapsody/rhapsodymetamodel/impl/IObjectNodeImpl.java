/**
 *   Copyright (c) 2016 CEA LIST and others.
 *   
 *   All rights reserved. This program and the accompanying materials
 *   are made available under the terms of the Eclipse Public License v1.0
 *   which accompanies this distribution, and is available at
 *   http://www.eclipse.org/legal/epl-v10.html
 *  
 *   Contributors:
 *     CEA LIST - Initial API and implementation
 * 
 */
package org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IClass;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IObjectNode;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IState;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>IObject Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IObjectNodeImpl#getRepresents <em>Represents</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IObjectNodeImpl#getTheInState <em>The In State</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IObjectNodeImpl#getInState <em>In State</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IObjectNodeImpl extends IStateImpl implements IObjectNode {
	/**
	 * The cached value of the '{@link #getRepresents() <em>Represents</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepresents()
	 * @generated
	 * @ordered
	 */
	protected IClass represents;

	/**
	 * The cached value of the '{@link #getTheInState() <em>The In State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTheInState()
	 * @generated
	 * @ordered
	 */
	protected IState theInState;

	/**
	 * The default value of the '{@link #getInState() <em>In State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInState()
	 * @generated
	 * @ordered
	 */
	protected static final String IN_STATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInState() <em>In State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInState()
	 * @generated
	 * @ordered
	 */
	protected String inState = IN_STATE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IObjectNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLRhapsodyPackage.eINSTANCE.getIObjectNode();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IClass getRepresents() {
		if (represents != null && represents.eIsProxy()) {
			InternalEObject oldRepresents = (InternalEObject)represents;
			represents = (IClass)eResolveProxy(oldRepresents);
			if (represents != oldRepresents) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IOBJECT_NODE__REPRESENTS, oldRepresents, represents));
			}
		}
		return represents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IClass basicGetRepresents() {
		return represents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRepresents(IClass newRepresents) {
		IClass oldRepresents = represents;
		represents = newRepresents;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IOBJECT_NODE__REPRESENTS, oldRepresents, represents));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IState getTheInState() {
		if (theInState != null && theInState.eIsProxy()) {
			InternalEObject oldTheInState = (InternalEObject)theInState;
			theInState = (IState)eResolveProxy(oldTheInState);
			if (theInState != oldTheInState) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IOBJECT_NODE__THE_IN_STATE, oldTheInState, theInState));
			}
		}
		return theInState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IState basicGetTheInState() {
		return theInState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTheInState(IState newTheInState) {
		IState oldTheInState = theInState;
		theInState = newTheInState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IOBJECT_NODE__THE_IN_STATE, oldTheInState, theInState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInState() {
		return inState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInState(String newInState) {
		String oldInState = inState;
		inState = newInState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IOBJECT_NODE__IN_STATE, oldInState, inState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UMLRhapsodyPackage.IOBJECT_NODE__REPRESENTS:
				if (resolve) return getRepresents();
				return basicGetRepresents();
			case UMLRhapsodyPackage.IOBJECT_NODE__THE_IN_STATE:
				if (resolve) return getTheInState();
				return basicGetTheInState();
			case UMLRhapsodyPackage.IOBJECT_NODE__IN_STATE:
				return getInState();
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
			case UMLRhapsodyPackage.IOBJECT_NODE__REPRESENTS:
				setRepresents((IClass)newValue);
				return;
			case UMLRhapsodyPackage.IOBJECT_NODE__THE_IN_STATE:
				setTheInState((IState)newValue);
				return;
			case UMLRhapsodyPackage.IOBJECT_NODE__IN_STATE:
				setInState((String)newValue);
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
			case UMLRhapsodyPackage.IOBJECT_NODE__REPRESENTS:
				setRepresents((IClass)null);
				return;
			case UMLRhapsodyPackage.IOBJECT_NODE__THE_IN_STATE:
				setTheInState((IState)null);
				return;
			case UMLRhapsodyPackage.IOBJECT_NODE__IN_STATE:
				setInState(IN_STATE_EDEFAULT);
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
			case UMLRhapsodyPackage.IOBJECT_NODE__REPRESENTS:
				return represents != null;
			case UMLRhapsodyPackage.IOBJECT_NODE__THE_IN_STATE:
				return theInState != null;
			case UMLRhapsodyPackage.IOBJECT_NODE__IN_STATE:
				return IN_STATE_EDEFAULT == null ? inState != null : !IN_STATE_EDEFAULT.equals(inState);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (inState: "); //$NON-NLS-1$
		result.append(inState);
		result.append(')');
		return result.toString();
	}

} //IObjectNodeImpl
