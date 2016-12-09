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
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IVariable;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>IVariable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IVariableImpl#getIsOrdered <em>Is Ordered</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IVariableImpl#getMyTypeOf <em>My Type Of</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IVariableImpl extends IUnitImpl implements IVariable {
	/**
	 * The default value of the '{@link #getIsOrdered() <em>Is Ordered</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsOrdered()
	 * @generated
	 * @ordered
	 */
	protected static final String IS_ORDERED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIsOrdered() <em>Is Ordered</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsOrdered()
	 * @generated
	 * @ordered
	 */
	protected String isOrdered = IS_ORDERED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMyTypeOf() <em>My Type Of</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMyTypeOf()
	 * @generated
	 * @ordered
	 */
	protected IType myTypeOf;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IVariableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLRhapsodyPackage.eINSTANCE.getIVariable();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIsOrdered() {
		return isOrdered;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsOrdered(String newIsOrdered) {
		String oldIsOrdered = isOrdered;
		isOrdered = newIsOrdered;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IVARIABLE__IS_ORDERED, oldIsOrdered, isOrdered));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IType getMyTypeOf() {
		if (myTypeOf != null && myTypeOf.eIsProxy()) {
			InternalEObject oldMyTypeOf = (InternalEObject)myTypeOf;
			myTypeOf = (IType)eResolveProxy(oldMyTypeOf);
			if (myTypeOf != oldMyTypeOf) {
				InternalEObject newMyTypeOf = (InternalEObject)myTypeOf;
				NotificationChain msgs = oldMyTypeOf.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IVARIABLE__MY_TYPE_OF, null, null);
				if (newMyTypeOf.eInternalContainer() == null) {
					msgs = newMyTypeOf.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IVARIABLE__MY_TYPE_OF, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IVARIABLE__MY_TYPE_OF, oldMyTypeOf, myTypeOf));
			}
		}
		return myTypeOf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IType basicGetMyTypeOf() {
		return myTypeOf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMyTypeOf(IType newMyTypeOf, NotificationChain msgs) {
		IType oldMyTypeOf = myTypeOf;
		myTypeOf = newMyTypeOf;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IVARIABLE__MY_TYPE_OF, oldMyTypeOf, newMyTypeOf);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMyTypeOf(IType newMyTypeOf) {
		if (newMyTypeOf != myTypeOf) {
			NotificationChain msgs = null;
			if (myTypeOf != null)
				msgs = ((InternalEObject)myTypeOf).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IVARIABLE__MY_TYPE_OF, null, msgs);
			if (newMyTypeOf != null)
				msgs = ((InternalEObject)newMyTypeOf).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IVARIABLE__MY_TYPE_OF, null, msgs);
			msgs = basicSetMyTypeOf(newMyTypeOf, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IVARIABLE__MY_TYPE_OF, newMyTypeOf, newMyTypeOf));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLRhapsodyPackage.IVARIABLE__MY_TYPE_OF:
				return basicSetMyTypeOf(null, msgs);
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
			case UMLRhapsodyPackage.IVARIABLE__IS_ORDERED:
				return getIsOrdered();
			case UMLRhapsodyPackage.IVARIABLE__MY_TYPE_OF:
				if (resolve) return getMyTypeOf();
				return basicGetMyTypeOf();
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
			case UMLRhapsodyPackage.IVARIABLE__IS_ORDERED:
				setIsOrdered((String)newValue);
				return;
			case UMLRhapsodyPackage.IVARIABLE__MY_TYPE_OF:
				setMyTypeOf((IType)newValue);
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
			case UMLRhapsodyPackage.IVARIABLE__IS_ORDERED:
				setIsOrdered(IS_ORDERED_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IVARIABLE__MY_TYPE_OF:
				setMyTypeOf((IType)null);
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
			case UMLRhapsodyPackage.IVARIABLE__IS_ORDERED:
				return IS_ORDERED_EDEFAULT == null ? isOrdered != null : !IS_ORDERED_EDEFAULT.equals(isOrdered);
			case UMLRhapsodyPackage.IVARIABLE__MY_TYPE_OF:
				return myTypeOf != null;
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
		result.append(" (isOrdered: "); //$NON-NLS-1$
		result.append(isOrdered);
		result.append(')');
		return result.toString();
	}

} //IVariableImpl
