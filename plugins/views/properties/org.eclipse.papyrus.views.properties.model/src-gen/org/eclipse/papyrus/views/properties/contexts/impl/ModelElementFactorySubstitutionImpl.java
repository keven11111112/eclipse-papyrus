/**
 */
package org.eclipse.papyrus.views.properties.contexts.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.papyrus.views.properties.contexts.ContextsPackage;
import org.eclipse.papyrus.views.properties.contexts.ModelElementFactorySubstitution;

import org.eclipse.papyrus.views.properties.environment.ModelElementFactoryDescriptor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Element Factory Substitution</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.views.properties.contexts.impl.ModelElementFactorySubstitutionImpl#getSourceFactoryType <em>Source Factory Type</em>}</li>
 * <li>{@link org.eclipse.papyrus.views.properties.contexts.impl.ModelElementFactorySubstitutionImpl#getTargetFactoryType <em>Target Factory Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModelElementFactorySubstitutionImpl extends SubstitutionImpl implements ModelElementFactorySubstitution {
	/**
	 * The cached value of the '{@link #getSourceFactoryType() <em>Source Factory Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getSourceFactoryType()
	 * @generated
	 * @ordered
	 */
	protected ModelElementFactoryDescriptor sourceFactoryType;

	/**
	 * The cached value of the '{@link #getTargetFactoryType() <em>Target Factory Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getTargetFactoryType()
	 * @generated
	 * @ordered
	 */
	protected ModelElementFactoryDescriptor targetFactoryType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected ModelElementFactorySubstitutionImpl() {
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
		return ContextsPackage.Literals.MODEL_ELEMENT_FACTORY_SUBSTITUTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public ModelElementFactoryDescriptor getSourceFactoryType() {
		if (sourceFactoryType != null && sourceFactoryType.eIsProxy()) {
			InternalEObject oldSourceFactoryType = (InternalEObject) sourceFactoryType;
			sourceFactoryType = (ModelElementFactoryDescriptor) eResolveProxy(oldSourceFactoryType);
			if (sourceFactoryType != oldSourceFactoryType) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ContextsPackage.MODEL_ELEMENT_FACTORY_SUBSTITUTION__SOURCE_FACTORY_TYPE, oldSourceFactoryType, sourceFactoryType));
				}
			}
		}
		return sourceFactoryType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public ModelElementFactoryDescriptor basicGetSourceFactoryType() {
		return sourceFactoryType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setSourceFactoryType(ModelElementFactoryDescriptor newSourceFactoryType) {
		ModelElementFactoryDescriptor oldSourceFactoryType = sourceFactoryType;
		sourceFactoryType = newSourceFactoryType;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, ContextsPackage.MODEL_ELEMENT_FACTORY_SUBSTITUTION__SOURCE_FACTORY_TYPE, oldSourceFactoryType, sourceFactoryType));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public ModelElementFactoryDescriptor getTargetFactoryType() {
		if (targetFactoryType != null && targetFactoryType.eIsProxy()) {
			InternalEObject oldTargetFactoryType = (InternalEObject) targetFactoryType;
			targetFactoryType = (ModelElementFactoryDescriptor) eResolveProxy(oldTargetFactoryType);
			if (targetFactoryType != oldTargetFactoryType) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ContextsPackage.MODEL_ELEMENT_FACTORY_SUBSTITUTION__TARGET_FACTORY_TYPE, oldTargetFactoryType, targetFactoryType));
				}
			}
		}
		return targetFactoryType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public ModelElementFactoryDescriptor basicGetTargetFactoryType() {
		return targetFactoryType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setTargetFactoryType(ModelElementFactoryDescriptor newTargetFactoryType) {
		ModelElementFactoryDescriptor oldTargetFactoryType = targetFactoryType;
		targetFactoryType = newTargetFactoryType;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, ContextsPackage.MODEL_ELEMENT_FACTORY_SUBSTITUTION__TARGET_FACTORY_TYPE, oldTargetFactoryType, targetFactoryType));
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
		case ContextsPackage.MODEL_ELEMENT_FACTORY_SUBSTITUTION__SOURCE_FACTORY_TYPE:
			if (resolve) {
				return getSourceFactoryType();
			}
			return basicGetSourceFactoryType();
		case ContextsPackage.MODEL_ELEMENT_FACTORY_SUBSTITUTION__TARGET_FACTORY_TYPE:
			if (resolve) {
				return getTargetFactoryType();
			}
			return basicGetTargetFactoryType();
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
		case ContextsPackage.MODEL_ELEMENT_FACTORY_SUBSTITUTION__SOURCE_FACTORY_TYPE:
			setSourceFactoryType((ModelElementFactoryDescriptor) newValue);
			return;
		case ContextsPackage.MODEL_ELEMENT_FACTORY_SUBSTITUTION__TARGET_FACTORY_TYPE:
			setTargetFactoryType((ModelElementFactoryDescriptor) newValue);
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
		case ContextsPackage.MODEL_ELEMENT_FACTORY_SUBSTITUTION__SOURCE_FACTORY_TYPE:
			setSourceFactoryType((ModelElementFactoryDescriptor) null);
			return;
		case ContextsPackage.MODEL_ELEMENT_FACTORY_SUBSTITUTION__TARGET_FACTORY_TYPE:
			setTargetFactoryType((ModelElementFactoryDescriptor) null);
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
		case ContextsPackage.MODEL_ELEMENT_FACTORY_SUBSTITUTION__SOURCE_FACTORY_TYPE:
			return sourceFactoryType != null;
		case ContextsPackage.MODEL_ELEMENT_FACTORY_SUBSTITUTION__TARGET_FACTORY_TYPE:
			return targetFactoryType != null;
		}
		return super.eIsSet(featureID);
	}

} // ModelElementFactorySubstitutionImpl
