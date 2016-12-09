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

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IAssociationEndHandle;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>IAssociation End Handle</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IAssociationEndHandleImpl#getM2Class <em>M2 Class</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IAssociationEndHandleImpl#getFilename <em>Filename</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IAssociationEndHandleImpl#getSubsystem <em>Subsystem</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IAssociationEndHandleImpl#getClass_ <em>Class</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IAssociationEndHandleImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IAssociationEndHandleImpl#getId <em>Id</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IAssociationEndHandleImpl extends MinimalEObjectImpl.Container implements IAssociationEndHandle {
	/**
	 * The default value of the '{@link #getM2Class() <em>M2 Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM2Class()
	 * @generated
	 * @ordered
	 */
	protected static final String M2_CLASS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM2Class() <em>M2 Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM2Class()
	 * @generated
	 * @ordered
	 */
	protected String m2Class = M2_CLASS_EDEFAULT;

	/**
	 * The default value of the '{@link #getFilename() <em>Filename</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFilename()
	 * @generated
	 * @ordered
	 */
	protected static final String FILENAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFilename() <em>Filename</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFilename()
	 * @generated
	 * @ordered
	 */
	protected String filename = FILENAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getSubsystem() <em>Subsystem</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubsystem()
	 * @generated
	 * @ordered
	 */
	protected static final String SUBSYSTEM_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSubsystem() <em>Subsystem</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubsystem()
	 * @generated
	 * @ordered
	 */
	protected String subsystem = SUBSYSTEM_EDEFAULT;

	/**
	 * The default value of the '{@link #getClass_() <em>Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClass_()
	 * @generated
	 * @ordered
	 */
	protected static final String CLASS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getClass_() <em>Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClass_()
	 * @generated
	 * @ordered
	 */
	protected String class_ = CLASS_EDEFAULT;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IAssociationEndHandleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLRhapsodyPackage.eINSTANCE.getIAssociationEndHandle();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM2Class() {
		return m2Class;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM2Class(String newM2Class) {
		String oldM2Class = m2Class;
		m2Class = newM2Class;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IASSOCIATION_END_HANDLE__M2_CLASS, oldM2Class, m2Class));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFilename() {
		return filename;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFilename(String newFilename) {
		String oldFilename = filename;
		filename = newFilename;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IASSOCIATION_END_HANDLE__FILENAME, oldFilename, filename));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSubsystem() {
		return subsystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubsystem(String newSubsystem) {
		String oldSubsystem = subsystem;
		subsystem = newSubsystem;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IASSOCIATION_END_HANDLE__SUBSYSTEM, oldSubsystem, subsystem));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getClass_() {
		return class_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClass(String newClass) {
		String oldClass = class_;
		class_ = newClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IASSOCIATION_END_HANDLE__CLASS, oldClass, class_));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IASSOCIATION_END_HANDLE__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IASSOCIATION_END_HANDLE__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UMLRhapsodyPackage.IASSOCIATION_END_HANDLE__M2_CLASS:
				return getM2Class();
			case UMLRhapsodyPackage.IASSOCIATION_END_HANDLE__FILENAME:
				return getFilename();
			case UMLRhapsodyPackage.IASSOCIATION_END_HANDLE__SUBSYSTEM:
				return getSubsystem();
			case UMLRhapsodyPackage.IASSOCIATION_END_HANDLE__CLASS:
				return getClass_();
			case UMLRhapsodyPackage.IASSOCIATION_END_HANDLE__NAME:
				return getName();
			case UMLRhapsodyPackage.IASSOCIATION_END_HANDLE__ID:
				return getId();
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
			case UMLRhapsodyPackage.IASSOCIATION_END_HANDLE__M2_CLASS:
				setM2Class((String)newValue);
				return;
			case UMLRhapsodyPackage.IASSOCIATION_END_HANDLE__FILENAME:
				setFilename((String)newValue);
				return;
			case UMLRhapsodyPackage.IASSOCIATION_END_HANDLE__SUBSYSTEM:
				setSubsystem((String)newValue);
				return;
			case UMLRhapsodyPackage.IASSOCIATION_END_HANDLE__CLASS:
				setClass((String)newValue);
				return;
			case UMLRhapsodyPackage.IASSOCIATION_END_HANDLE__NAME:
				setName((String)newValue);
				return;
			case UMLRhapsodyPackage.IASSOCIATION_END_HANDLE__ID:
				setId((String)newValue);
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
			case UMLRhapsodyPackage.IASSOCIATION_END_HANDLE__M2_CLASS:
				setM2Class(M2_CLASS_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IASSOCIATION_END_HANDLE__FILENAME:
				setFilename(FILENAME_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IASSOCIATION_END_HANDLE__SUBSYSTEM:
				setSubsystem(SUBSYSTEM_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IASSOCIATION_END_HANDLE__CLASS:
				setClass(CLASS_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IASSOCIATION_END_HANDLE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IASSOCIATION_END_HANDLE__ID:
				setId(ID_EDEFAULT);
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
			case UMLRhapsodyPackage.IASSOCIATION_END_HANDLE__M2_CLASS:
				return M2_CLASS_EDEFAULT == null ? m2Class != null : !M2_CLASS_EDEFAULT.equals(m2Class);
			case UMLRhapsodyPackage.IASSOCIATION_END_HANDLE__FILENAME:
				return FILENAME_EDEFAULT == null ? filename != null : !FILENAME_EDEFAULT.equals(filename);
			case UMLRhapsodyPackage.IASSOCIATION_END_HANDLE__SUBSYSTEM:
				return SUBSYSTEM_EDEFAULT == null ? subsystem != null : !SUBSYSTEM_EDEFAULT.equals(subsystem);
			case UMLRhapsodyPackage.IASSOCIATION_END_HANDLE__CLASS:
				return CLASS_EDEFAULT == null ? class_ != null : !CLASS_EDEFAULT.equals(class_);
			case UMLRhapsodyPackage.IASSOCIATION_END_HANDLE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case UMLRhapsodyPackage.IASSOCIATION_END_HANDLE__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
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
		result.append(" (m2Class: "); //$NON-NLS-1$
		result.append(m2Class);
		result.append(", filename: "); //$NON-NLS-1$
		result.append(filename);
		result.append(", subsystem: "); //$NON-NLS-1$
		result.append(subsystem);
		result.append(", class: "); //$NON-NLS-1$
		result.append(class_);
		result.append(", name: "); //$NON-NLS-1$
		result.append(name);
		result.append(", id: "); //$NON-NLS-1$
		result.append(id);
		result.append(')');
		return result.toString();
	}

} //IAssociationEndHandleImpl
