/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Fadwa TMAR (CEA LIST) fadwa.tmar@cea.fr - Initial API and implementation
 *****************************************************************************/
package SoaML.impl;

import SoaML.CollaborationUse;
import SoaML.SoaMLPackage;

import SoaML.util.SoaMLValidator;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Collaboration Use</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link SoaML.impl.CollaborationUseImpl#getBase_CollaborationUse <em>Base Collaboration Use</em>}</li>
 *   <li>{@link SoaML.impl.CollaborationUseImpl#isIsStrict <em>Is Strict</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CollaborationUseImpl extends MinimalEObjectImpl.Container implements CollaborationUse {
	/**
	 * The cached value of the '{@link #getBase_CollaborationUse() <em>Base Collaboration Use</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_CollaborationUse()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.uml2.uml.CollaborationUse base_CollaborationUse;

	/**
	 * The default value of the '{@link #isIsStrict() <em>Is Strict</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsStrict()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_STRICT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsStrict() <em>Is Strict</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsStrict()
	 * @generated
	 * @ordered
	 */
	protected boolean isStrict = IS_STRICT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CollaborationUseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SoaMLPackage.Literals.COLLABORATION_USE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.CollaborationUse getBase_CollaborationUse() {
		if (base_CollaborationUse != null && base_CollaborationUse.eIsProxy()) {
			InternalEObject oldBase_CollaborationUse = (InternalEObject)base_CollaborationUse;
			base_CollaborationUse = (org.eclipse.uml2.uml.CollaborationUse)eResolveProxy(oldBase_CollaborationUse);
			if (base_CollaborationUse != oldBase_CollaborationUse) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SoaMLPackage.COLLABORATION_USE__BASE_COLLABORATION_USE, oldBase_CollaborationUse, base_CollaborationUse));
			}
		}
		return base_CollaborationUse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.CollaborationUse basicGetBase_CollaborationUse() {
		return base_CollaborationUse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_CollaborationUse(org.eclipse.uml2.uml.CollaborationUse newBase_CollaborationUse) {
		org.eclipse.uml2.uml.CollaborationUse oldBase_CollaborationUse = base_CollaborationUse;
		base_CollaborationUse = newBase_CollaborationUse;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SoaMLPackage.COLLABORATION_USE__BASE_COLLABORATION_USE, oldBase_CollaborationUse, base_CollaborationUse));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsStrict() {
		return isStrict;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsStrict(boolean newIsStrict) {
		boolean oldIsStrict = isStrict;
		isStrict = newIsStrict;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SoaMLPackage.COLLABORATION_USE__IS_STRICT, oldIsStrict, isStrict));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean RoleBindingClientSupplierCompatibility(DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO: implement this method
		// -> specify the condition that violates the invariant
		// -> verify the details of the diagnostic, including severity and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 SoaMLValidator.DIAGNOSTIC_SOURCE,
						 SoaMLValidator.COLLABORATION_USE__ROLE_BINDING_CLIENT_SUPPLIER_COMPATIBILITY,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "RoleBindingClientSupplierCompatibility", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SoaMLPackage.COLLABORATION_USE__BASE_COLLABORATION_USE:
				if (resolve) return getBase_CollaborationUse();
				return basicGetBase_CollaborationUse();
			case SoaMLPackage.COLLABORATION_USE__IS_STRICT:
				return isIsStrict();
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
			case SoaMLPackage.COLLABORATION_USE__BASE_COLLABORATION_USE:
				setBase_CollaborationUse((org.eclipse.uml2.uml.CollaborationUse)newValue);
				return;
			case SoaMLPackage.COLLABORATION_USE__IS_STRICT:
				setIsStrict((Boolean)newValue);
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
			case SoaMLPackage.COLLABORATION_USE__BASE_COLLABORATION_USE:
				setBase_CollaborationUse((org.eclipse.uml2.uml.CollaborationUse)null);
				return;
			case SoaMLPackage.COLLABORATION_USE__IS_STRICT:
				setIsStrict(IS_STRICT_EDEFAULT);
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
			case SoaMLPackage.COLLABORATION_USE__BASE_COLLABORATION_USE:
				return base_CollaborationUse != null;
			case SoaMLPackage.COLLABORATION_USE__IS_STRICT:
				return isStrict != IS_STRICT_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case SoaMLPackage.COLLABORATION_USE___ROLE_BINDING_CLIENT_SUPPLIER_COMPATIBILITY__DIAGNOSTICCHAIN_MAP:
				return RoleBindingClientSupplierCompatibility((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
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
		result.append(" (isStrict: ");
		result.append(isStrict);
		result.append(')');
		return result.toString();
	}

} //CollaborationUseImpl
