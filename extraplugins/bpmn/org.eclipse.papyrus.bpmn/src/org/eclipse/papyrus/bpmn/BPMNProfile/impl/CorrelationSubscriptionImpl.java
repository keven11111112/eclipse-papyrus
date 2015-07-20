/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage;
import org.eclipse.papyrus.bpmn.BPMNProfile.CorrelationKey;
import org.eclipse.papyrus.bpmn.BPMNProfile.CorrelationPropertyBinding;
import org.eclipse.papyrus.bpmn.BPMNProfile.CorrelationSubscription;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Correlation Subscription</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.CorrelationSubscriptionImpl#getBase_Class <em>Base Class</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.CorrelationSubscriptionImpl#getCorrelationKeyRef <em>Correlation Key Ref</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.CorrelationSubscriptionImpl#getCorrelationPropertyBinding <em>Correlation Property Binding</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CorrelationSubscriptionImpl extends BaseElementImpl implements CorrelationSubscription {
	/**
	 * The cached value of the '{@link #getBase_Class() <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Class()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.uml2.uml.Class base_Class;

	/**
	 * The cached value of the '{@link #getCorrelationKeyRef() <em>Correlation Key Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCorrelationKeyRef()
	 * @generated
	 * @ordered
	 */
	protected CorrelationKey correlationKeyRef;
	/**
	 * The cached value of the '{@link #getCorrelationPropertyBinding() <em>Correlation Property Binding</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCorrelationPropertyBinding()
	 * @generated
	 * @ordered
	 */
	protected EList<CorrelationPropertyBinding> correlationPropertyBinding;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CorrelationSubscriptionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BPMNProfilePackage.eINSTANCE.getCorrelationSubscription();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class getBase_Class() {
		if (base_Class != null && base_Class.eIsProxy()) {
			InternalEObject oldBase_Class = (InternalEObject)base_Class;
			base_Class = (org.eclipse.uml2.uml.Class)eResolveProxy(oldBase_Class);
			if (base_Class != oldBase_Class) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.CORRELATION_SUBSCRIPTION__BASE_CLASS, oldBase_Class, base_Class));
			}
		}
		return base_Class;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class basicGetBase_Class() {
		return base_Class;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Class(org.eclipse.uml2.uml.Class newBase_Class) {
		org.eclipse.uml2.uml.Class oldBase_Class = base_Class;
		base_Class = newBase_Class;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.CORRELATION_SUBSCRIPTION__BASE_CLASS, oldBase_Class, base_Class));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CorrelationKey getCorrelationKeyRef() {
		if (correlationKeyRef != null && correlationKeyRef.eIsProxy()) {
			InternalEObject oldCorrelationKeyRef = (InternalEObject)correlationKeyRef;
			correlationKeyRef = (CorrelationKey)eResolveProxy(oldCorrelationKeyRef);
			if (correlationKeyRef != oldCorrelationKeyRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.CORRELATION_SUBSCRIPTION__CORRELATION_KEY_REF, oldCorrelationKeyRef, correlationKeyRef));
			}
		}
		return correlationKeyRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CorrelationKey basicGetCorrelationKeyRef() {
		return correlationKeyRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCorrelationKeyRef(CorrelationKey newCorrelationKeyRef) {
		CorrelationKey oldCorrelationKeyRef = correlationKeyRef;
		correlationKeyRef = newCorrelationKeyRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.CORRELATION_SUBSCRIPTION__CORRELATION_KEY_REF, oldCorrelationKeyRef, correlationKeyRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CorrelationPropertyBinding> getCorrelationPropertyBinding() {
		if (correlationPropertyBinding == null) {
			correlationPropertyBinding = new EObjectResolvingEList<CorrelationPropertyBinding>(CorrelationPropertyBinding.class, this, BPMNProfilePackage.CORRELATION_SUBSCRIPTION__CORRELATION_PROPERTY_BINDING);
		}
		return correlationPropertyBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BPMNProfilePackage.CORRELATION_SUBSCRIPTION__BASE_CLASS:
				if (resolve) return getBase_Class();
				return basicGetBase_Class();
			case BPMNProfilePackage.CORRELATION_SUBSCRIPTION__CORRELATION_KEY_REF:
				if (resolve) return getCorrelationKeyRef();
				return basicGetCorrelationKeyRef();
			case BPMNProfilePackage.CORRELATION_SUBSCRIPTION__CORRELATION_PROPERTY_BINDING:
				return getCorrelationPropertyBinding();
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
			case BPMNProfilePackage.CORRELATION_SUBSCRIPTION__BASE_CLASS:
				setBase_Class((org.eclipse.uml2.uml.Class)newValue);
				return;
			case BPMNProfilePackage.CORRELATION_SUBSCRIPTION__CORRELATION_KEY_REF:
				setCorrelationKeyRef((CorrelationKey)newValue);
				return;
			case BPMNProfilePackage.CORRELATION_SUBSCRIPTION__CORRELATION_PROPERTY_BINDING:
				getCorrelationPropertyBinding().clear();
				getCorrelationPropertyBinding().addAll((Collection<? extends CorrelationPropertyBinding>)newValue);
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
			case BPMNProfilePackage.CORRELATION_SUBSCRIPTION__BASE_CLASS:
				setBase_Class((org.eclipse.uml2.uml.Class)null);
				return;
			case BPMNProfilePackage.CORRELATION_SUBSCRIPTION__CORRELATION_KEY_REF:
				setCorrelationKeyRef((CorrelationKey)null);
				return;
			case BPMNProfilePackage.CORRELATION_SUBSCRIPTION__CORRELATION_PROPERTY_BINDING:
				getCorrelationPropertyBinding().clear();
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
			case BPMNProfilePackage.CORRELATION_SUBSCRIPTION__BASE_CLASS:
				return base_Class != null;
			case BPMNProfilePackage.CORRELATION_SUBSCRIPTION__CORRELATION_KEY_REF:
				return correlationKeyRef != null;
			case BPMNProfilePackage.CORRELATION_SUBSCRIPTION__CORRELATION_PROPERTY_BINDING:
				return correlationPropertyBinding != null && !correlationPropertyBinding.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CorrelationSubscriptionImpl
