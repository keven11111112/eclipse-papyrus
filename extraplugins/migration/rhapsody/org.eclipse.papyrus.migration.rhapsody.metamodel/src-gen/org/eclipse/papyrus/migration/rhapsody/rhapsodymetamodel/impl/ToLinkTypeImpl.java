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

import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IClass;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ToLinkType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>To Link Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ToLinkTypeImpl#getImplicitClass <em>Implicit Class</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ToLinkTypeImpl extends FromLinkTypeImpl implements ToLinkType {
	/**
	 * The cached value of the '{@link #getImplicitClass() <em>Implicit Class</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplicitClass()
	 * @generated
	 * @ordered
	 */
	protected IClass implicitClass;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ToLinkTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLRhapsodyPackage.eINSTANCE.getToLinkType();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IClass getImplicitClass() {
		if (implicitClass != null && implicitClass.eIsProxy()) {
			InternalEObject oldImplicitClass = (InternalEObject)implicitClass;
			implicitClass = (IClass)eResolveProxy(oldImplicitClass);
			if (implicitClass != oldImplicitClass) {
				InternalEObject newImplicitClass = (InternalEObject)implicitClass;
				NotificationChain msgs = oldImplicitClass.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.TO_LINK_TYPE__IMPLICIT_CLASS, null, null);
				if (newImplicitClass.eInternalContainer() == null) {
					msgs = newImplicitClass.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.TO_LINK_TYPE__IMPLICIT_CLASS, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.TO_LINK_TYPE__IMPLICIT_CLASS, oldImplicitClass, implicitClass));
			}
		}
		return implicitClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IClass basicGetImplicitClass() {
		return implicitClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetImplicitClass(IClass newImplicitClass, NotificationChain msgs) {
		IClass oldImplicitClass = implicitClass;
		implicitClass = newImplicitClass;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.TO_LINK_TYPE__IMPLICIT_CLASS, oldImplicitClass, newImplicitClass);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImplicitClass(IClass newImplicitClass) {
		if (newImplicitClass != implicitClass) {
			NotificationChain msgs = null;
			if (implicitClass != null)
				msgs = ((InternalEObject)implicitClass).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.TO_LINK_TYPE__IMPLICIT_CLASS, null, msgs);
			if (newImplicitClass != null)
				msgs = ((InternalEObject)newImplicitClass).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.TO_LINK_TYPE__IMPLICIT_CLASS, null, msgs);
			msgs = basicSetImplicitClass(newImplicitClass, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.TO_LINK_TYPE__IMPLICIT_CLASS, newImplicitClass, newImplicitClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLRhapsodyPackage.TO_LINK_TYPE__IMPLICIT_CLASS:
				return basicSetImplicitClass(null, msgs);
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
			case UMLRhapsodyPackage.TO_LINK_TYPE__IMPLICIT_CLASS:
				if (resolve) return getImplicitClass();
				return basicGetImplicitClass();
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
			case UMLRhapsodyPackage.TO_LINK_TYPE__IMPLICIT_CLASS:
				setImplicitClass((IClass)newValue);
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
			case UMLRhapsodyPackage.TO_LINK_TYPE__IMPLICIT_CLASS:
				setImplicitClass((IClass)null);
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
			case UMLRhapsodyPackage.TO_LINK_TYPE__IMPLICIT_CLASS:
				return implicitClass != null;
		}
		return super.eIsSet(featureID);
	}

} //ToLinkTypeImpl
