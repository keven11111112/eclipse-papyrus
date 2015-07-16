/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage;
import org.eclipse.papyrus.bpmn.BPMNProfile.Definitions;
import org.eclipse.papyrus.bpmn.BPMNProfile.RootElement;

import org.eclipse.uml2.uml.PackageableElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Root Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.RootElementImpl#getBase_PackageableElement <em>Base Packageable Element</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.RootElementImpl#getDefinition <em>Definition</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class RootElementImpl extends BaseElementImpl implements RootElement {
	/**
	 * The cached value of the '{@link #getBase_PackageableElement() <em>Base Packageable Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_PackageableElement()
	 * @generated
	 * @ordered
	 */
	protected PackageableElement base_PackageableElement;

	/**
	 * The cached value of the '{@link #getDefinition() <em>Definition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefinition()
	 * @generated
	 * @ordered
	 */
	protected Definitions definition;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RootElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BPMNProfilePackage.eINSTANCE.getRootElement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PackageableElement getBase_PackageableElement() {
		if (base_PackageableElement != null && base_PackageableElement.eIsProxy()) {
			InternalEObject oldBase_PackageableElement = (InternalEObject)base_PackageableElement;
			base_PackageableElement = (PackageableElement)eResolveProxy(oldBase_PackageableElement);
			if (base_PackageableElement != oldBase_PackageableElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.ROOT_ELEMENT__BASE_PACKAGEABLE_ELEMENT, oldBase_PackageableElement, base_PackageableElement));
			}
		}
		return base_PackageableElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PackageableElement basicGetBase_PackageableElement() {
		return base_PackageableElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_PackageableElement(PackageableElement newBase_PackageableElement) {
		PackageableElement oldBase_PackageableElement = base_PackageableElement;
		base_PackageableElement = newBase_PackageableElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.ROOT_ELEMENT__BASE_PACKAGEABLE_ELEMENT, oldBase_PackageableElement, base_PackageableElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Definitions getDefinition() {
		if (definition != null && definition.eIsProxy()) {
			InternalEObject oldDefinition = (InternalEObject)definition;
			definition = (Definitions)eResolveProxy(oldDefinition);
			if (definition != oldDefinition) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.ROOT_ELEMENT__DEFINITION, oldDefinition, definition));
			}
		}
		return definition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Definitions basicGetDefinition() {
		return definition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDefinition(Definitions newDefinition, NotificationChain msgs) {
		Definitions oldDefinition = definition;
		definition = newDefinition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.ROOT_ELEMENT__DEFINITION, oldDefinition, newDefinition);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefinition(Definitions newDefinition) {
		if (newDefinition != definition) {
			NotificationChain msgs = null;
			if (definition != null)
				msgs = ((InternalEObject)definition).eInverseRemove(this, BPMNProfilePackage.DEFINITIONS__ROOT_ELEMENTS, Definitions.class, msgs);
			if (newDefinition != null)
				msgs = ((InternalEObject)newDefinition).eInverseAdd(this, BPMNProfilePackage.DEFINITIONS__ROOT_ELEMENTS, Definitions.class, msgs);
			msgs = basicSetDefinition(newDefinition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.ROOT_ELEMENT__DEFINITION, newDefinition, newDefinition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BPMNProfilePackage.ROOT_ELEMENT__DEFINITION:
				if (definition != null)
					msgs = ((InternalEObject)definition).eInverseRemove(this, BPMNProfilePackage.DEFINITIONS__ROOT_ELEMENTS, Definitions.class, msgs);
				return basicSetDefinition((Definitions)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BPMNProfilePackage.ROOT_ELEMENT__DEFINITION:
				return basicSetDefinition(null, msgs);
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
			case BPMNProfilePackage.ROOT_ELEMENT__BASE_PACKAGEABLE_ELEMENT:
				if (resolve) return getBase_PackageableElement();
				return basicGetBase_PackageableElement();
			case BPMNProfilePackage.ROOT_ELEMENT__DEFINITION:
				if (resolve) return getDefinition();
				return basicGetDefinition();
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
			case BPMNProfilePackage.ROOT_ELEMENT__BASE_PACKAGEABLE_ELEMENT:
				setBase_PackageableElement((PackageableElement)newValue);
				return;
			case BPMNProfilePackage.ROOT_ELEMENT__DEFINITION:
				setDefinition((Definitions)newValue);
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
			case BPMNProfilePackage.ROOT_ELEMENT__BASE_PACKAGEABLE_ELEMENT:
				setBase_PackageableElement((PackageableElement)null);
				return;
			case BPMNProfilePackage.ROOT_ELEMENT__DEFINITION:
				setDefinition((Definitions)null);
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
			case BPMNProfilePackage.ROOT_ELEMENT__BASE_PACKAGEABLE_ELEMENT:
				return base_PackageableElement != null;
			case BPMNProfilePackage.ROOT_ELEMENT__DEFINITION:
				return definition != null;
		}
		return super.eIsSet(featureID);
	}

} //RootElementImpl
