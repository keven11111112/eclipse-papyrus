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

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.uml2.uml.Stereotype;

import org.omg.smm.Operation;
import org.omg.smm.Scope;
import org.omg.smm.SmmPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Scope</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.omg.smm.impl.ScopeImpl#getBreakCondition <em>Break Condition</em>}</li>
 *   <li>{@link org.omg.smm.impl.ScopeImpl#getRecognizer <em>Recognizer</em>}</li>
 *   <li>{@link org.omg.smm.impl.ScopeImpl#getClass_ <em>Class</em>}</li>
 *   <li>{@link org.omg.smm.impl.ScopeImpl#getStereotype <em>Stereotype</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ScopeImpl extends AbstractMeasureElementImpl implements Scope {
	/**
	 * The cached value of the '{@link #getBreakCondition() <em>Break Condition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBreakCondition()
	 * @generated
	 * @ordered
	 */
	protected Operation breakCondition;

	/**
	 * The cached value of the '{@link #getRecognizer() <em>Recognizer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRecognizer()
	 * @generated
	 * @ordered
	 */
	protected Operation recognizer;

	/**
	 * The cached value of the '{@link #getClass_() <em>Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClass_()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.uml2.uml.Class class_;

	/**
	 * The cached value of the '{@link #getStereotype() <em>Stereotype</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStereotype()
	 * @generated
	 * @ordered
	 */
	protected Stereotype stereotype;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ScopeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SmmPackage.Literals.SCOPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation getBreakCondition() {
		if (breakCondition != null && breakCondition.eIsProxy()) {
			InternalEObject oldBreakCondition = (InternalEObject)breakCondition;
			breakCondition = (Operation)eResolveProxy(oldBreakCondition);
			if (breakCondition != oldBreakCondition) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SmmPackage.SCOPE__BREAK_CONDITION, oldBreakCondition, breakCondition));
			}
		}
		return breakCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation basicGetBreakCondition() {
		return breakCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBreakCondition(Operation newBreakCondition) {
		Operation oldBreakCondition = breakCondition;
		breakCondition = newBreakCondition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SmmPackage.SCOPE__BREAK_CONDITION, oldBreakCondition, breakCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation getRecognizer() {
		if (recognizer != null && recognizer.eIsProxy()) {
			InternalEObject oldRecognizer = (InternalEObject)recognizer;
			recognizer = (Operation)eResolveProxy(oldRecognizer);
			if (recognizer != oldRecognizer) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SmmPackage.SCOPE__RECOGNIZER, oldRecognizer, recognizer));
			}
		}
		return recognizer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation basicGetRecognizer() {
		return recognizer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRecognizer(Operation newRecognizer) {
		Operation oldRecognizer = recognizer;
		recognizer = newRecognizer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SmmPackage.SCOPE__RECOGNIZER, oldRecognizer, recognizer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class getClass_() {
		if (class_ != null && class_.eIsProxy()) {
			InternalEObject oldClass = (InternalEObject)class_;
			class_ = (org.eclipse.uml2.uml.Class)eResolveProxy(oldClass);
			if (class_ != oldClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SmmPackage.SCOPE__CLASS, oldClass, class_));
			}
		}
		return class_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class basicGetClass() {
		return class_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClass(org.eclipse.uml2.uml.Class newClass) {
		org.eclipse.uml2.uml.Class oldClass = class_;
		class_ = newClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SmmPackage.SCOPE__CLASS, oldClass, class_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Stereotype getStereotype() {
		if (stereotype != null && stereotype.eIsProxy()) {
			InternalEObject oldStereotype = (InternalEObject)stereotype;
			stereotype = (Stereotype)eResolveProxy(oldStereotype);
			if (stereotype != oldStereotype) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SmmPackage.SCOPE__STEREOTYPE, oldStereotype, stereotype));
			}
		}
		return stereotype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Stereotype basicGetStereotype() {
		return stereotype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStereotype(Stereotype newStereotype) {
		Stereotype oldStereotype = stereotype;
		stereotype = newStereotype;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SmmPackage.SCOPE__STEREOTYPE, oldStereotype, stereotype));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SmmPackage.SCOPE__BREAK_CONDITION:
				if (resolve) return getBreakCondition();
				return basicGetBreakCondition();
			case SmmPackage.SCOPE__RECOGNIZER:
				if (resolve) return getRecognizer();
				return basicGetRecognizer();
			case SmmPackage.SCOPE__CLASS:
				if (resolve) return getClass_();
				return basicGetClass();
			case SmmPackage.SCOPE__STEREOTYPE:
				if (resolve) return getStereotype();
				return basicGetStereotype();
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
			case SmmPackage.SCOPE__BREAK_CONDITION:
				setBreakCondition((Operation)newValue);
				return;
			case SmmPackage.SCOPE__RECOGNIZER:
				setRecognizer((Operation)newValue);
				return;
			case SmmPackage.SCOPE__CLASS:
				setClass((org.eclipse.uml2.uml.Class)newValue);
				return;
			case SmmPackage.SCOPE__STEREOTYPE:
				setStereotype((Stereotype)newValue);
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
			case SmmPackage.SCOPE__BREAK_CONDITION:
				setBreakCondition((Operation)null);
				return;
			case SmmPackage.SCOPE__RECOGNIZER:
				setRecognizer((Operation)null);
				return;
			case SmmPackage.SCOPE__CLASS:
				setClass((org.eclipse.uml2.uml.Class)null);
				return;
			case SmmPackage.SCOPE__STEREOTYPE:
				setStereotype((Stereotype)null);
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
			case SmmPackage.SCOPE__BREAK_CONDITION:
				return breakCondition != null;
			case SmmPackage.SCOPE__RECOGNIZER:
				return recognizer != null;
			case SmmPackage.SCOPE__CLASS:
				return class_ != null;
			case SmmPackage.SCOPE__STEREOTYPE:
				return stereotype != null;
		}
		return super.eIsSet(featureID);
	}

} //ScopeImpl
