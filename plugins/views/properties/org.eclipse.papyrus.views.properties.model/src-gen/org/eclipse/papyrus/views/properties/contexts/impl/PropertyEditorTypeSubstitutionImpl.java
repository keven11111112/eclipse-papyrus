/**
 */
package org.eclipse.papyrus.views.properties.contexts.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.papyrus.views.properties.contexts.ContextsPackage;
import org.eclipse.papyrus.views.properties.contexts.PropertyEditorTypeSubstitution;

import org.eclipse.papyrus.views.properties.environment.PropertyEditorType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property Editor Type Substitution</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.views.properties.contexts.impl.PropertyEditorTypeSubstitutionImpl#getSourceEditorType <em>Source Editor Type</em>}</li>
 * <li>{@link org.eclipse.papyrus.views.properties.contexts.impl.PropertyEditorTypeSubstitutionImpl#getTargetEditorType <em>Target Editor Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PropertyEditorTypeSubstitutionImpl extends EObjectImpl implements PropertyEditorTypeSubstitution {
	/**
	 * The cached value of the '{@link #getSourceEditorType() <em>Source Editor Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getSourceEditorType()
	 * @generated
	 * @ordered
	 */
	protected PropertyEditorType sourceEditorType;

	/**
	 * The cached value of the '{@link #getTargetEditorType() <em>Target Editor Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getTargetEditorType()
	 * @generated
	 * @ordered
	 */
	protected PropertyEditorType targetEditorType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected PropertyEditorTypeSubstitutionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ContextsPackage.Literals.PROPERTY_EDITOR_TYPE_SUBSTITUTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public PropertyEditorType getSourceEditorType() {
		if (sourceEditorType != null && sourceEditorType.eIsProxy()) {
			InternalEObject oldSourceEditorType = (InternalEObject) sourceEditorType;
			sourceEditorType = (PropertyEditorType) eResolveProxy(oldSourceEditorType);
			if (sourceEditorType != oldSourceEditorType) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ContextsPackage.PROPERTY_EDITOR_TYPE_SUBSTITUTION__SOURCE_EDITOR_TYPE, oldSourceEditorType, sourceEditorType));
				}
			}
		}
		return sourceEditorType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public PropertyEditorType basicGetSourceEditorType() {
		return sourceEditorType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setSourceEditorType(PropertyEditorType newSourceEditorType) {
		PropertyEditorType oldSourceEditorType = sourceEditorType;
		sourceEditorType = newSourceEditorType;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, ContextsPackage.PROPERTY_EDITOR_TYPE_SUBSTITUTION__SOURCE_EDITOR_TYPE, oldSourceEditorType, sourceEditorType));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public PropertyEditorType getTargetEditorType() {
		if (targetEditorType != null && targetEditorType.eIsProxy()) {
			InternalEObject oldTargetEditorType = (InternalEObject) targetEditorType;
			targetEditorType = (PropertyEditorType) eResolveProxy(oldTargetEditorType);
			if (targetEditorType != oldTargetEditorType) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ContextsPackage.PROPERTY_EDITOR_TYPE_SUBSTITUTION__TARGET_EDITOR_TYPE, oldTargetEditorType, targetEditorType));
				}
			}
		}
		return targetEditorType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public PropertyEditorType basicGetTargetEditorType() {
		return targetEditorType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setTargetEditorType(PropertyEditorType newTargetEditorType) {
		PropertyEditorType oldTargetEditorType = targetEditorType;
		targetEditorType = newTargetEditorType;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, ContextsPackage.PROPERTY_EDITOR_TYPE_SUBSTITUTION__TARGET_EDITOR_TYPE, oldTargetEditorType, targetEditorType));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ContextsPackage.PROPERTY_EDITOR_TYPE_SUBSTITUTION__SOURCE_EDITOR_TYPE:
			if (resolve) {
				return getSourceEditorType();
			}
			return basicGetSourceEditorType();
		case ContextsPackage.PROPERTY_EDITOR_TYPE_SUBSTITUTION__TARGET_EDITOR_TYPE:
			if (resolve) {
				return getTargetEditorType();
			}
			return basicGetTargetEditorType();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case ContextsPackage.PROPERTY_EDITOR_TYPE_SUBSTITUTION__SOURCE_EDITOR_TYPE:
			setSourceEditorType((PropertyEditorType) newValue);
			return;
		case ContextsPackage.PROPERTY_EDITOR_TYPE_SUBSTITUTION__TARGET_EDITOR_TYPE:
			setTargetEditorType((PropertyEditorType) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case ContextsPackage.PROPERTY_EDITOR_TYPE_SUBSTITUTION__SOURCE_EDITOR_TYPE:
			setSourceEditorType((PropertyEditorType) null);
			return;
		case ContextsPackage.PROPERTY_EDITOR_TYPE_SUBSTITUTION__TARGET_EDITOR_TYPE:
			setTargetEditorType((PropertyEditorType) null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case ContextsPackage.PROPERTY_EDITOR_TYPE_SUBSTITUTION__SOURCE_EDITOR_TYPE:
			return sourceEditorType != null;
		case ContextsPackage.PROPERTY_EDITOR_TYPE_SUBSTITUTION__TARGET_EDITOR_TYPE:
			return targetEditorType != null;
		}
		return super.eIsSet(featureID);
	}

} // PropertyEditorTypeSubstitutionImpl
