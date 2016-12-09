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

import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IClassInstance;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ILinkInstance;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IMetaLinkHandle;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>ILink Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ILinkInstanceImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ILinkInstanceImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ILinkInstanceImpl#getToLink <em>To Link</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ILinkInstanceImpl#getFromLink <em>From Link</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ILinkInstanceImpl#getInstantiates <em>Instantiates</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ILinkInstanceImpl extends ComponentsTypeImpl implements ILinkInstance {
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getToLink() <em>To Link</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToLink()
	 * @generated
	 * @ordered
	 */
	protected IClassInstance toLink;

	/**
	 * The cached value of the '{@link #getFromLink() <em>From Link</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFromLink()
	 * @generated
	 * @ordered
	 */
	protected IClassInstance fromLink;

	/**
	 * The cached value of the '{@link #getInstantiates() <em>Instantiates</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstantiates()
	 * @generated
	 * @ordered
	 */
	protected IMetaLinkHandle instantiates;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ILinkInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLRhapsodyPackage.eINSTANCE.getILinkInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ILINK_INSTANCE__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ILINK_INSTANCE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IClassInstance getToLink() {
		if (toLink != null && toLink.eIsProxy()) {
			InternalEObject oldToLink = (InternalEObject)toLink;
			toLink = (IClassInstance)eResolveProxy(oldToLink);
			if (toLink != oldToLink) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.ILINK_INSTANCE__TO_LINK, oldToLink, toLink));
			}
		}
		return toLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IClassInstance basicGetToLink() {
		return toLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setToLink(IClassInstance newToLink) {
		IClassInstance oldToLink = toLink;
		toLink = newToLink;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ILINK_INSTANCE__TO_LINK, oldToLink, toLink));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IClassInstance getFromLink() {
		if (fromLink != null && fromLink.eIsProxy()) {
			InternalEObject oldFromLink = (InternalEObject)fromLink;
			fromLink = (IClassInstance)eResolveProxy(oldFromLink);
			if (fromLink != oldFromLink) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.ILINK_INSTANCE__FROM_LINK, oldFromLink, fromLink));
			}
		}
		return fromLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IClassInstance basicGetFromLink() {
		return fromLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFromLink(IClassInstance newFromLink) {
		IClassInstance oldFromLink = fromLink;
		fromLink = newFromLink;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ILINK_INSTANCE__FROM_LINK, oldFromLink, fromLink));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IMetaLinkHandle getInstantiates() {
		if (instantiates != null && instantiates.eIsProxy()) {
			InternalEObject oldInstantiates = (InternalEObject)instantiates;
			instantiates = (IMetaLinkHandle)eResolveProxy(oldInstantiates);
			if (instantiates != oldInstantiates) {
				InternalEObject newInstantiates = (InternalEObject)instantiates;
				NotificationChain msgs = oldInstantiates.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ILINK_INSTANCE__INSTANTIATES, null, null);
				if (newInstantiates.eInternalContainer() == null) {
					msgs = newInstantiates.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ILINK_INSTANCE__INSTANTIATES, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.ILINK_INSTANCE__INSTANTIATES, oldInstantiates, instantiates));
			}
		}
		return instantiates;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IMetaLinkHandle basicGetInstantiates() {
		return instantiates;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInstantiates(IMetaLinkHandle newInstantiates, NotificationChain msgs) {
		IMetaLinkHandle oldInstantiates = instantiates;
		instantiates = newInstantiates;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ILINK_INSTANCE__INSTANTIATES, oldInstantiates, newInstantiates);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInstantiates(IMetaLinkHandle newInstantiates) {
		if (newInstantiates != instantiates) {
			NotificationChain msgs = null;
			if (instantiates != null)
				msgs = ((InternalEObject)instantiates).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ILINK_INSTANCE__INSTANTIATES, null, msgs);
			if (newInstantiates != null)
				msgs = ((InternalEObject)newInstantiates).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ILINK_INSTANCE__INSTANTIATES, null, msgs);
			msgs = basicSetInstantiates(newInstantiates, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ILINK_INSTANCE__INSTANTIATES, newInstantiates, newInstantiates));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLRhapsodyPackage.ILINK_INSTANCE__INSTANTIATES:
				return basicSetInstantiates(null, msgs);
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
			case UMLRhapsodyPackage.ILINK_INSTANCE__ID:
				return getId();
			case UMLRhapsodyPackage.ILINK_INSTANCE__NAME:
				return getName();
			case UMLRhapsodyPackage.ILINK_INSTANCE__TO_LINK:
				if (resolve) return getToLink();
				return basicGetToLink();
			case UMLRhapsodyPackage.ILINK_INSTANCE__FROM_LINK:
				if (resolve) return getFromLink();
				return basicGetFromLink();
			case UMLRhapsodyPackage.ILINK_INSTANCE__INSTANTIATES:
				if (resolve) return getInstantiates();
				return basicGetInstantiates();
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
			case UMLRhapsodyPackage.ILINK_INSTANCE__ID:
				setId((String)newValue);
				return;
			case UMLRhapsodyPackage.ILINK_INSTANCE__NAME:
				setName((String)newValue);
				return;
			case UMLRhapsodyPackage.ILINK_INSTANCE__TO_LINK:
				setToLink((IClassInstance)newValue);
				return;
			case UMLRhapsodyPackage.ILINK_INSTANCE__FROM_LINK:
				setFromLink((IClassInstance)newValue);
				return;
			case UMLRhapsodyPackage.ILINK_INSTANCE__INSTANTIATES:
				setInstantiates((IMetaLinkHandle)newValue);
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
			case UMLRhapsodyPackage.ILINK_INSTANCE__ID:
				setId(ID_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ILINK_INSTANCE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ILINK_INSTANCE__TO_LINK:
				setToLink((IClassInstance)null);
				return;
			case UMLRhapsodyPackage.ILINK_INSTANCE__FROM_LINK:
				setFromLink((IClassInstance)null);
				return;
			case UMLRhapsodyPackage.ILINK_INSTANCE__INSTANTIATES:
				setInstantiates((IMetaLinkHandle)null);
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
			case UMLRhapsodyPackage.ILINK_INSTANCE__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case UMLRhapsodyPackage.ILINK_INSTANCE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case UMLRhapsodyPackage.ILINK_INSTANCE__TO_LINK:
				return toLink != null;
			case UMLRhapsodyPackage.ILINK_INSTANCE__FROM_LINK:
				return fromLink != null;
			case UMLRhapsodyPackage.ILINK_INSTANCE__INSTANTIATES:
				return instantiates != null;
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
		result.append(" (id: "); //$NON-NLS-1$
		result.append(id);
		result.append(", name: "); //$NON-NLS-1$
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //ILinkInstanceImpl
