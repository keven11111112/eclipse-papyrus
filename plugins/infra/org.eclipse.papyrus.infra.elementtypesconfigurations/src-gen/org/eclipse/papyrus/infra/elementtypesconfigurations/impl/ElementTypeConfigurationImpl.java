/**
 * Copyright (c) 2014 CEA LIST.
 * 
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.infra.elementtypesconfigurations.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.infra.elementtypesconfigurations.ElementTypeConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.ElementtypesconfigurationsPackage;
import org.eclipse.papyrus.infra.elementtypesconfigurations.IconEntry;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>elementType Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.elementtypesconfigurations.impl.ElementTypeConfigurationImpl#getHint <em>Hint</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.elementtypesconfigurations.impl.ElementTypeConfigurationImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.elementtypesconfigurations.impl.ElementTypeConfigurationImpl#getIconEntry <em>Icon Entry</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ElementTypeConfigurationImpl extends ConfigurationElementImpl implements ElementTypeConfiguration {
	/**
	 * The default value of the '{@link #getHint() <em>Hint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHint()
	 * @generated
	 * @ordered
	 */
	protected static final String HINT_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getHint() <em>Hint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHint()
	 * @generated
	 * @ordered
	 */
	protected String hint = HINT_EDEFAULT;

	/**
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final String KIND_EDEFAULT = "org.eclipse.gmf.runtime.emf.type.core.IHintedType";

	/**
	 * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected String kind = KIND_EDEFAULT;

	/**
	 * The cached value of the '{@link #getIconEntry() <em>Icon Entry</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIconEntry()
	 * @generated
	 * @ordered
	 */
	protected IconEntry iconEntry;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ElementTypeConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ElementtypesconfigurationsPackage.Literals.ELEMENT_TYPE_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getHint() {
		return hint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHint(String newHint) {
		String oldHint = hint;
		hint = newHint;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ElementtypesconfigurationsPackage.ELEMENT_TYPE_CONFIGURATION__HINT, oldHint, hint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getKind() {
		return kind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKind(String newKind) {
		String oldKind = kind;
		kind = newKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ElementtypesconfigurationsPackage.ELEMENT_TYPE_CONFIGURATION__KIND, oldKind, kind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IconEntry getIconEntry() {
		return iconEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIconEntry(IconEntry newIconEntry, NotificationChain msgs) {
		IconEntry oldIconEntry = iconEntry;
		iconEntry = newIconEntry;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ElementtypesconfigurationsPackage.ELEMENT_TYPE_CONFIGURATION__ICON_ENTRY, oldIconEntry, newIconEntry);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIconEntry(IconEntry newIconEntry) {
		if (newIconEntry != iconEntry) {
			NotificationChain msgs = null;
			if (iconEntry != null)
				msgs = ((InternalEObject)iconEntry).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ElementtypesconfigurationsPackage.ELEMENT_TYPE_CONFIGURATION__ICON_ENTRY, null, msgs);
			if (newIconEntry != null)
				msgs = ((InternalEObject)newIconEntry).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ElementtypesconfigurationsPackage.ELEMENT_TYPE_CONFIGURATION__ICON_ENTRY, null, msgs);
			msgs = basicSetIconEntry(newIconEntry, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ElementtypesconfigurationsPackage.ELEMENT_TYPE_CONFIGURATION__ICON_ENTRY, newIconEntry, newIconEntry));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ElementtypesconfigurationsPackage.ELEMENT_TYPE_CONFIGURATION__ICON_ENTRY:
				return basicSetIconEntry(null, msgs);
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
			case ElementtypesconfigurationsPackage.ELEMENT_TYPE_CONFIGURATION__HINT:
				return getHint();
			case ElementtypesconfigurationsPackage.ELEMENT_TYPE_CONFIGURATION__KIND:
				return getKind();
			case ElementtypesconfigurationsPackage.ELEMENT_TYPE_CONFIGURATION__ICON_ENTRY:
				return getIconEntry();
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
			case ElementtypesconfigurationsPackage.ELEMENT_TYPE_CONFIGURATION__HINT:
				setHint((String)newValue);
				return;
			case ElementtypesconfigurationsPackage.ELEMENT_TYPE_CONFIGURATION__KIND:
				setKind((String)newValue);
				return;
			case ElementtypesconfigurationsPackage.ELEMENT_TYPE_CONFIGURATION__ICON_ENTRY:
				setIconEntry((IconEntry)newValue);
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
			case ElementtypesconfigurationsPackage.ELEMENT_TYPE_CONFIGURATION__HINT:
				setHint(HINT_EDEFAULT);
				return;
			case ElementtypesconfigurationsPackage.ELEMENT_TYPE_CONFIGURATION__KIND:
				setKind(KIND_EDEFAULT);
				return;
			case ElementtypesconfigurationsPackage.ELEMENT_TYPE_CONFIGURATION__ICON_ENTRY:
				setIconEntry((IconEntry)null);
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
			case ElementtypesconfigurationsPackage.ELEMENT_TYPE_CONFIGURATION__HINT:
				return HINT_EDEFAULT == null ? hint != null : !HINT_EDEFAULT.equals(hint);
			case ElementtypesconfigurationsPackage.ELEMENT_TYPE_CONFIGURATION__KIND:
				return KIND_EDEFAULT == null ? kind != null : !KIND_EDEFAULT.equals(kind);
			case ElementtypesconfigurationsPackage.ELEMENT_TYPE_CONFIGURATION__ICON_ENTRY:
				return iconEntry != null;
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
		result.append(" (hint: ");
		result.append(hint);
		result.append(", kind: ");
		result.append(kind);
		result.append(')');
		return result.toString();
	}

} //ElementTypeConfigurationImpl
