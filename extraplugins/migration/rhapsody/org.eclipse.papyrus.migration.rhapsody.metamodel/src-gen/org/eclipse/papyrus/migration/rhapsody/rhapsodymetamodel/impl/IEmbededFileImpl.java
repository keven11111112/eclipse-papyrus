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
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IEmbededFile;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ITag;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UnknownType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>IEmbeded File</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IEmbededFileImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IEmbededFileImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IEmbededFileImpl#getModifiedTimeWeak <em>Modified Time Weak</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IEmbededFileImpl#getMayNeedToRelocate <em>May Need To Relocate</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IEmbededFileImpl#getLastKnownFullPath <em>Last Known Full Path</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IEmbededFileImpl#getStereotypes <em>Stereotypes</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IEmbededFileImpl#getTags <em>Tags</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IEmbededFileImpl extends EmbededFilesTypeImpl implements IEmbededFile {
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
	 * The default value of the '{@link #getModifiedTimeWeak() <em>Modified Time Weak</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModifiedTimeWeak()
	 * @generated
	 * @ordered
	 */
	protected static final String MODIFIED_TIME_WEAK_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getModifiedTimeWeak() <em>Modified Time Weak</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModifiedTimeWeak()
	 * @generated
	 * @ordered
	 */
	protected String modifiedTimeWeak = MODIFIED_TIME_WEAK_EDEFAULT;

	/**
	 * The default value of the '{@link #getMayNeedToRelocate() <em>May Need To Relocate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMayNeedToRelocate()
	 * @generated
	 * @ordered
	 */
	protected static final String MAY_NEED_TO_RELOCATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMayNeedToRelocate() <em>May Need To Relocate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMayNeedToRelocate()
	 * @generated
	 * @ordered
	 */
	protected String mayNeedToRelocate = MAY_NEED_TO_RELOCATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getLastKnownFullPath() <em>Last Known Full Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastKnownFullPath()
	 * @generated
	 * @ordered
	 */
	protected static final String LAST_KNOWN_FULL_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLastKnownFullPath() <em>Last Known Full Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastKnownFullPath()
	 * @generated
	 * @ordered
	 */
	protected String lastKnownFullPath = LAST_KNOWN_FULL_PATH_EDEFAULT;

	/**
	 * The cached value of the '{@link #getStereotypes() <em>Stereotypes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStereotypes()
	 * @generated
	 * @ordered
	 */
	protected EList<UnknownType> stereotypes;

	/**
	 * The cached value of the '{@link #getTags() <em>Tags</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTags()
	 * @generated
	 * @ordered
	 */
	protected ITag tags;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IEmbededFileImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLRhapsodyPackage.eINSTANCE.getIEmbededFile();
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IEMBEDED_FILE__ID, oldId, id));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IEMBEDED_FILE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getModifiedTimeWeak() {
		return modifiedTimeWeak;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModifiedTimeWeak(String newModifiedTimeWeak) {
		String oldModifiedTimeWeak = modifiedTimeWeak;
		modifiedTimeWeak = newModifiedTimeWeak;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IEMBEDED_FILE__MODIFIED_TIME_WEAK, oldModifiedTimeWeak, modifiedTimeWeak));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMayNeedToRelocate() {
		return mayNeedToRelocate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMayNeedToRelocate(String newMayNeedToRelocate) {
		String oldMayNeedToRelocate = mayNeedToRelocate;
		mayNeedToRelocate = newMayNeedToRelocate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IEMBEDED_FILE__MAY_NEED_TO_RELOCATE, oldMayNeedToRelocate, mayNeedToRelocate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLastKnownFullPath() {
		return lastKnownFullPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastKnownFullPath(String newLastKnownFullPath) {
		String oldLastKnownFullPath = lastKnownFullPath;
		lastKnownFullPath = newLastKnownFullPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IEMBEDED_FILE__LAST_KNOWN_FULL_PATH, oldLastKnownFullPath, lastKnownFullPath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UnknownType> getStereotypes() {
		if (stereotypes == null) {
			stereotypes = new EObjectResolvingEList<UnknownType>(UnknownType.class, this, UMLRhapsodyPackage.IEMBEDED_FILE__STEREOTYPES);
		}
		return stereotypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ITag getTags() {
		if (tags != null && tags.eIsProxy()) {
			InternalEObject oldTags = (InternalEObject)tags;
			tags = (ITag)eResolveProxy(oldTags);
			if (tags != oldTags) {
				InternalEObject newTags = (InternalEObject)tags;
				NotificationChain msgs = oldTags.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IEMBEDED_FILE__TAGS, null, null);
				if (newTags.eInternalContainer() == null) {
					msgs = newTags.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IEMBEDED_FILE__TAGS, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IEMBEDED_FILE__TAGS, oldTags, tags));
			}
		}
		return tags;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ITag basicGetTags() {
		return tags;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTags(ITag newTags, NotificationChain msgs) {
		ITag oldTags = tags;
		tags = newTags;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IEMBEDED_FILE__TAGS, oldTags, newTags);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTags(ITag newTags) {
		if (newTags != tags) {
			NotificationChain msgs = null;
			if (tags != null)
				msgs = ((InternalEObject)tags).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IEMBEDED_FILE__TAGS, null, msgs);
			if (newTags != null)
				msgs = ((InternalEObject)newTags).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IEMBEDED_FILE__TAGS, null, msgs);
			msgs = basicSetTags(newTags, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IEMBEDED_FILE__TAGS, newTags, newTags));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLRhapsodyPackage.IEMBEDED_FILE__TAGS:
				return basicSetTags(null, msgs);
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
			case UMLRhapsodyPackage.IEMBEDED_FILE__ID:
				return getId();
			case UMLRhapsodyPackage.IEMBEDED_FILE__NAME:
				return getName();
			case UMLRhapsodyPackage.IEMBEDED_FILE__MODIFIED_TIME_WEAK:
				return getModifiedTimeWeak();
			case UMLRhapsodyPackage.IEMBEDED_FILE__MAY_NEED_TO_RELOCATE:
				return getMayNeedToRelocate();
			case UMLRhapsodyPackage.IEMBEDED_FILE__LAST_KNOWN_FULL_PATH:
				return getLastKnownFullPath();
			case UMLRhapsodyPackage.IEMBEDED_FILE__STEREOTYPES:
				return getStereotypes();
			case UMLRhapsodyPackage.IEMBEDED_FILE__TAGS:
				if (resolve) return getTags();
				return basicGetTags();
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
			case UMLRhapsodyPackage.IEMBEDED_FILE__ID:
				setId((String)newValue);
				return;
			case UMLRhapsodyPackage.IEMBEDED_FILE__NAME:
				setName((String)newValue);
				return;
			case UMLRhapsodyPackage.IEMBEDED_FILE__MODIFIED_TIME_WEAK:
				setModifiedTimeWeak((String)newValue);
				return;
			case UMLRhapsodyPackage.IEMBEDED_FILE__MAY_NEED_TO_RELOCATE:
				setMayNeedToRelocate((String)newValue);
				return;
			case UMLRhapsodyPackage.IEMBEDED_FILE__LAST_KNOWN_FULL_PATH:
				setLastKnownFullPath((String)newValue);
				return;
			case UMLRhapsodyPackage.IEMBEDED_FILE__STEREOTYPES:
				getStereotypes().clear();
				getStereotypes().addAll((Collection<? extends UnknownType>)newValue);
				return;
			case UMLRhapsodyPackage.IEMBEDED_FILE__TAGS:
				setTags((ITag)newValue);
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
			case UMLRhapsodyPackage.IEMBEDED_FILE__ID:
				setId(ID_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IEMBEDED_FILE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IEMBEDED_FILE__MODIFIED_TIME_WEAK:
				setModifiedTimeWeak(MODIFIED_TIME_WEAK_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IEMBEDED_FILE__MAY_NEED_TO_RELOCATE:
				setMayNeedToRelocate(MAY_NEED_TO_RELOCATE_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IEMBEDED_FILE__LAST_KNOWN_FULL_PATH:
				setLastKnownFullPath(LAST_KNOWN_FULL_PATH_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IEMBEDED_FILE__STEREOTYPES:
				getStereotypes().clear();
				return;
			case UMLRhapsodyPackage.IEMBEDED_FILE__TAGS:
				setTags((ITag)null);
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
			case UMLRhapsodyPackage.IEMBEDED_FILE__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case UMLRhapsodyPackage.IEMBEDED_FILE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case UMLRhapsodyPackage.IEMBEDED_FILE__MODIFIED_TIME_WEAK:
				return MODIFIED_TIME_WEAK_EDEFAULT == null ? modifiedTimeWeak != null : !MODIFIED_TIME_WEAK_EDEFAULT.equals(modifiedTimeWeak);
			case UMLRhapsodyPackage.IEMBEDED_FILE__MAY_NEED_TO_RELOCATE:
				return MAY_NEED_TO_RELOCATE_EDEFAULT == null ? mayNeedToRelocate != null : !MAY_NEED_TO_RELOCATE_EDEFAULT.equals(mayNeedToRelocate);
			case UMLRhapsodyPackage.IEMBEDED_FILE__LAST_KNOWN_FULL_PATH:
				return LAST_KNOWN_FULL_PATH_EDEFAULT == null ? lastKnownFullPath != null : !LAST_KNOWN_FULL_PATH_EDEFAULT.equals(lastKnownFullPath);
			case UMLRhapsodyPackage.IEMBEDED_FILE__STEREOTYPES:
				return stereotypes != null && !stereotypes.isEmpty();
			case UMLRhapsodyPackage.IEMBEDED_FILE__TAGS:
				return tags != null;
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
		result.append(", modifiedTimeWeak: "); //$NON-NLS-1$
		result.append(modifiedTimeWeak);
		result.append(", MayNeedToRelocate: "); //$NON-NLS-1$
		result.append(mayNeedToRelocate);
		result.append(", LastKnownFullPath: "); //$NON-NLS-1$
		result.append(lastKnownFullPath);
		result.append(')');
		return result.toString();
	}

} //IEmbededFileImpl
