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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGICompartment;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ItemsType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CGI Compartment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGICompartmentImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGICompartmentImpl#getM_name <em>Mname</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGICompartmentImpl#getM_displayOption <em>Mdisplay Option</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGICompartmentImpl#getM_bShowInherited <em>MbShow Inherited</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGICompartmentImpl#getM_bOrdered <em>MbOrdered</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGICompartmentImpl#getItems <em>Items</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CGICompartmentImpl extends CompartmentsTypeImpl implements CGICompartment {
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
	 * The default value of the '{@link #getM_name() <em>Mname</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_name()
	 * @generated
	 * @ordered
	 */
	protected static final String MNAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_name() <em>Mname</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_name()
	 * @generated
	 * @ordered
	 */
	protected String m_name = MNAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getM_displayOption() <em>Mdisplay Option</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_displayOption()
	 * @generated
	 * @ordered
	 */
	protected static final String MDISPLAY_OPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_displayOption() <em>Mdisplay Option</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_displayOption()
	 * @generated
	 * @ordered
	 */
	protected String m_displayOption = MDISPLAY_OPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getM_bShowInherited() <em>MbShow Inherited</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_bShowInherited()
	 * @generated
	 * @ordered
	 */
	protected static final String MBSHOW_INHERITED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_bShowInherited() <em>MbShow Inherited</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_bShowInherited()
	 * @generated
	 * @ordered
	 */
	protected String m_bShowInherited = MBSHOW_INHERITED_EDEFAULT;

	/**
	 * The default value of the '{@link #getM_bOrdered() <em>MbOrdered</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_bOrdered()
	 * @generated
	 * @ordered
	 */
	protected static final String MBORDERED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_bOrdered() <em>MbOrdered</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_bOrdered()
	 * @generated
	 * @ordered
	 */
	protected String m_bOrdered = MBORDERED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getItems() <em>Items</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getItems()
	 * @generated
	 * @ordered
	 */
	protected EList<ItemsType> items;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CGICompartmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLRhapsodyPackage.eINSTANCE.getCGICompartment();
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_COMPARTMENT__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_name() {
		return m_name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_name(String newM_name) {
		String oldM_name = m_name;
		m_name = newM_name;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_COMPARTMENT__MNAME, oldM_name, m_name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_displayOption() {
		return m_displayOption;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_displayOption(String newM_displayOption) {
		String oldM_displayOption = m_displayOption;
		m_displayOption = newM_displayOption;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_COMPARTMENT__MDISPLAY_OPTION, oldM_displayOption, m_displayOption));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_bShowInherited() {
		return m_bShowInherited;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_bShowInherited(String newM_bShowInherited) {
		String oldM_bShowInherited = m_bShowInherited;
		m_bShowInherited = newM_bShowInherited;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_COMPARTMENT__MBSHOW_INHERITED, oldM_bShowInherited, m_bShowInherited));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_bOrdered() {
		return m_bOrdered;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_bOrdered(String newM_bOrdered) {
		String oldM_bOrdered = m_bOrdered;
		m_bOrdered = newM_bOrdered;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_COMPARTMENT__MBORDERED, oldM_bOrdered, m_bOrdered));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ItemsType> getItems() {
		if (items == null) {
			items = new EObjectResolvingEList<ItemsType>(ItemsType.class, this, UMLRhapsodyPackage.CGI_COMPARTMENT__ITEMS);
		}
		return items;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UMLRhapsodyPackage.CGI_COMPARTMENT__ID:
				return getId();
			case UMLRhapsodyPackage.CGI_COMPARTMENT__MNAME:
				return getM_name();
			case UMLRhapsodyPackage.CGI_COMPARTMENT__MDISPLAY_OPTION:
				return getM_displayOption();
			case UMLRhapsodyPackage.CGI_COMPARTMENT__MBSHOW_INHERITED:
				return getM_bShowInherited();
			case UMLRhapsodyPackage.CGI_COMPARTMENT__MBORDERED:
				return getM_bOrdered();
			case UMLRhapsodyPackage.CGI_COMPARTMENT__ITEMS:
				return getItems();
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
			case UMLRhapsodyPackage.CGI_COMPARTMENT__ID:
				setId((String)newValue);
				return;
			case UMLRhapsodyPackage.CGI_COMPARTMENT__MNAME:
				setM_name((String)newValue);
				return;
			case UMLRhapsodyPackage.CGI_COMPARTMENT__MDISPLAY_OPTION:
				setM_displayOption((String)newValue);
				return;
			case UMLRhapsodyPackage.CGI_COMPARTMENT__MBSHOW_INHERITED:
				setM_bShowInherited((String)newValue);
				return;
			case UMLRhapsodyPackage.CGI_COMPARTMENT__MBORDERED:
				setM_bOrdered((String)newValue);
				return;
			case UMLRhapsodyPackage.CGI_COMPARTMENT__ITEMS:
				getItems().clear();
				getItems().addAll((Collection<? extends ItemsType>)newValue);
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
			case UMLRhapsodyPackage.CGI_COMPARTMENT__ID:
				setId(ID_EDEFAULT);
				return;
			case UMLRhapsodyPackage.CGI_COMPARTMENT__MNAME:
				setM_name(MNAME_EDEFAULT);
				return;
			case UMLRhapsodyPackage.CGI_COMPARTMENT__MDISPLAY_OPTION:
				setM_displayOption(MDISPLAY_OPTION_EDEFAULT);
				return;
			case UMLRhapsodyPackage.CGI_COMPARTMENT__MBSHOW_INHERITED:
				setM_bShowInherited(MBSHOW_INHERITED_EDEFAULT);
				return;
			case UMLRhapsodyPackage.CGI_COMPARTMENT__MBORDERED:
				setM_bOrdered(MBORDERED_EDEFAULT);
				return;
			case UMLRhapsodyPackage.CGI_COMPARTMENT__ITEMS:
				getItems().clear();
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
			case UMLRhapsodyPackage.CGI_COMPARTMENT__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case UMLRhapsodyPackage.CGI_COMPARTMENT__MNAME:
				return MNAME_EDEFAULT == null ? m_name != null : !MNAME_EDEFAULT.equals(m_name);
			case UMLRhapsodyPackage.CGI_COMPARTMENT__MDISPLAY_OPTION:
				return MDISPLAY_OPTION_EDEFAULT == null ? m_displayOption != null : !MDISPLAY_OPTION_EDEFAULT.equals(m_displayOption);
			case UMLRhapsodyPackage.CGI_COMPARTMENT__MBSHOW_INHERITED:
				return MBSHOW_INHERITED_EDEFAULT == null ? m_bShowInherited != null : !MBSHOW_INHERITED_EDEFAULT.equals(m_bShowInherited);
			case UMLRhapsodyPackage.CGI_COMPARTMENT__MBORDERED:
				return MBORDERED_EDEFAULT == null ? m_bOrdered != null : !MBORDERED_EDEFAULT.equals(m_bOrdered);
			case UMLRhapsodyPackage.CGI_COMPARTMENT__ITEMS:
				return items != null && !items.isEmpty();
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
		result.append(", m_name: "); //$NON-NLS-1$
		result.append(m_name);
		result.append(", m_displayOption: "); //$NON-NLS-1$
		result.append(m_displayOption);
		result.append(", m_bShowInherited: "); //$NON-NLS-1$
		result.append(m_bShowInherited);
		result.append(", m_bOrdered: "); //$NON-NLS-1$
		result.append(m_bOrdered);
		result.append(')');
		return result.toString();
	}

} //CGICompartmentImpl
