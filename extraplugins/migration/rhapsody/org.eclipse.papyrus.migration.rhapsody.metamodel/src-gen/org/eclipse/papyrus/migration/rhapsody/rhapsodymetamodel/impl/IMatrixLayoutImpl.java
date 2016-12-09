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

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IDescription;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IMatrixLayout;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.TableDataDefinition;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>IMatrix Layout</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IMatrixLayoutImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IMatrixLayoutImpl#getMyState <em>My State</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IMatrixLayoutImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IMatrixLayoutImpl#getModifiedTimeWeak <em>Modified Time Weak</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IMatrixLayoutImpl#getFromElementTypes <em>From Element Types</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IMatrixLayoutImpl#getToElementTypes <em>To Element Types</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IMatrixLayoutImpl#getCellElementTypes <em>Cell Element Types</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IMatrixLayoutImpl#getDescription <em>Description</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IMatrixLayoutImpl extends IUnitImpl implements IMatrixLayout {
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
	 * The default value of the '{@link #getMyState() <em>My State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMyState()
	 * @generated
	 * @ordered
	 */
	protected static final String MY_STATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMyState() <em>My State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMyState()
	 * @generated
	 * @ordered
	 */
	protected String myState = MY_STATE_EDEFAULT;

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
	 * The cached value of the '{@link #getModifiedTimeWeak() <em>Modified Time Weak</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModifiedTimeWeak()
	 * @generated
	 * @ordered
	 */
	protected EList<String> modifiedTimeWeak;

	/**
	 * The cached value of the '{@link #getFromElementTypes() <em>From Element Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFromElementTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<TableDataDefinition> fromElementTypes;

	/**
	 * The cached value of the '{@link #getToElementTypes() <em>To Element Types</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToElementTypes()
	 * @generated
	 * @ordered
	 */
	protected TableDataDefinition toElementTypes;

	/**
	 * The cached value of the '{@link #getCellElementTypes() <em>Cell Element Types</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCellElementTypes()
	 * @generated
	 * @ordered
	 */
	protected TableDataDefinition cellElementTypes;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected IDescription description;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IMatrixLayoutImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLRhapsodyPackage.eINSTANCE.getIMatrixLayout();
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IMATRIX_LAYOUT__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMyState() {
		return myState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMyState(String newMyState) {
		String oldMyState = myState;
		myState = newMyState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IMATRIX_LAYOUT__MY_STATE, oldMyState, myState));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IMATRIX_LAYOUT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getModifiedTimeWeak() {
		if (modifiedTimeWeak == null) {
			modifiedTimeWeak = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.IMATRIX_LAYOUT__MODIFIED_TIME_WEAK);
		}
		return modifiedTimeWeak;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TableDataDefinition> getFromElementTypes() {
		if (fromElementTypes == null) {
			fromElementTypes = new EObjectContainmentEList.Resolving<TableDataDefinition>(TableDataDefinition.class, this, UMLRhapsodyPackage.IMATRIX_LAYOUT__FROM_ELEMENT_TYPES);
		}
		return fromElementTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TableDataDefinition getToElementTypes() {
		if (toElementTypes != null && toElementTypes.eIsProxy()) {
			InternalEObject oldToElementTypes = (InternalEObject)toElementTypes;
			toElementTypes = (TableDataDefinition)eResolveProxy(oldToElementTypes);
			if (toElementTypes != oldToElementTypes) {
				InternalEObject newToElementTypes = (InternalEObject)toElementTypes;
				NotificationChain msgs = oldToElementTypes.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IMATRIX_LAYOUT__TO_ELEMENT_TYPES, null, null);
				if (newToElementTypes.eInternalContainer() == null) {
					msgs = newToElementTypes.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IMATRIX_LAYOUT__TO_ELEMENT_TYPES, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IMATRIX_LAYOUT__TO_ELEMENT_TYPES, oldToElementTypes, toElementTypes));
			}
		}
		return toElementTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TableDataDefinition basicGetToElementTypes() {
		return toElementTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetToElementTypes(TableDataDefinition newToElementTypes, NotificationChain msgs) {
		TableDataDefinition oldToElementTypes = toElementTypes;
		toElementTypes = newToElementTypes;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IMATRIX_LAYOUT__TO_ELEMENT_TYPES, oldToElementTypes, newToElementTypes);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setToElementTypes(TableDataDefinition newToElementTypes) {
		if (newToElementTypes != toElementTypes) {
			NotificationChain msgs = null;
			if (toElementTypes != null)
				msgs = ((InternalEObject)toElementTypes).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IMATRIX_LAYOUT__TO_ELEMENT_TYPES, null, msgs);
			if (newToElementTypes != null)
				msgs = ((InternalEObject)newToElementTypes).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IMATRIX_LAYOUT__TO_ELEMENT_TYPES, null, msgs);
			msgs = basicSetToElementTypes(newToElementTypes, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IMATRIX_LAYOUT__TO_ELEMENT_TYPES, newToElementTypes, newToElementTypes));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TableDataDefinition getCellElementTypes() {
		if (cellElementTypes != null && cellElementTypes.eIsProxy()) {
			InternalEObject oldCellElementTypes = (InternalEObject)cellElementTypes;
			cellElementTypes = (TableDataDefinition)eResolveProxy(oldCellElementTypes);
			if (cellElementTypes != oldCellElementTypes) {
				InternalEObject newCellElementTypes = (InternalEObject)cellElementTypes;
				NotificationChain msgs = oldCellElementTypes.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IMATRIX_LAYOUT__CELL_ELEMENT_TYPES, null, null);
				if (newCellElementTypes.eInternalContainer() == null) {
					msgs = newCellElementTypes.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IMATRIX_LAYOUT__CELL_ELEMENT_TYPES, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IMATRIX_LAYOUT__CELL_ELEMENT_TYPES, oldCellElementTypes, cellElementTypes));
			}
		}
		return cellElementTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TableDataDefinition basicGetCellElementTypes() {
		return cellElementTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCellElementTypes(TableDataDefinition newCellElementTypes, NotificationChain msgs) {
		TableDataDefinition oldCellElementTypes = cellElementTypes;
		cellElementTypes = newCellElementTypes;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IMATRIX_LAYOUT__CELL_ELEMENT_TYPES, oldCellElementTypes, newCellElementTypes);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCellElementTypes(TableDataDefinition newCellElementTypes) {
		if (newCellElementTypes != cellElementTypes) {
			NotificationChain msgs = null;
			if (cellElementTypes != null)
				msgs = ((InternalEObject)cellElementTypes).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IMATRIX_LAYOUT__CELL_ELEMENT_TYPES, null, msgs);
			if (newCellElementTypes != null)
				msgs = ((InternalEObject)newCellElementTypes).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IMATRIX_LAYOUT__CELL_ELEMENT_TYPES, null, msgs);
			msgs = basicSetCellElementTypes(newCellElementTypes, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IMATRIX_LAYOUT__CELL_ELEMENT_TYPES, newCellElementTypes, newCellElementTypes));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IDescription getDescription() {
		if (description != null && description.eIsProxy()) {
			InternalEObject oldDescription = (InternalEObject)description;
			description = (IDescription)eResolveProxy(oldDescription);
			if (description != oldDescription) {
				InternalEObject newDescription = (InternalEObject)description;
				NotificationChain msgs = oldDescription.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IMATRIX_LAYOUT__DESCRIPTION, null, null);
				if (newDescription.eInternalContainer() == null) {
					msgs = newDescription.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IMATRIX_LAYOUT__DESCRIPTION, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IMATRIX_LAYOUT__DESCRIPTION, oldDescription, description));
			}
		}
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IDescription basicGetDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDescription(IDescription newDescription, NotificationChain msgs) {
		IDescription oldDescription = description;
		description = newDescription;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IMATRIX_LAYOUT__DESCRIPTION, oldDescription, newDescription);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(IDescription newDescription) {
		if (newDescription != description) {
			NotificationChain msgs = null;
			if (description != null)
				msgs = ((InternalEObject)description).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IMATRIX_LAYOUT__DESCRIPTION, null, msgs);
			if (newDescription != null)
				msgs = ((InternalEObject)newDescription).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IMATRIX_LAYOUT__DESCRIPTION, null, msgs);
			msgs = basicSetDescription(newDescription, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IMATRIX_LAYOUT__DESCRIPTION, newDescription, newDescription));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLRhapsodyPackage.IMATRIX_LAYOUT__FROM_ELEMENT_TYPES:
				return ((InternalEList<?>)getFromElementTypes()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.IMATRIX_LAYOUT__TO_ELEMENT_TYPES:
				return basicSetToElementTypes(null, msgs);
			case UMLRhapsodyPackage.IMATRIX_LAYOUT__CELL_ELEMENT_TYPES:
				return basicSetCellElementTypes(null, msgs);
			case UMLRhapsodyPackage.IMATRIX_LAYOUT__DESCRIPTION:
				return basicSetDescription(null, msgs);
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
			case UMLRhapsodyPackage.IMATRIX_LAYOUT__ID:
				return getId();
			case UMLRhapsodyPackage.IMATRIX_LAYOUT__MY_STATE:
				return getMyState();
			case UMLRhapsodyPackage.IMATRIX_LAYOUT__NAME:
				return getName();
			case UMLRhapsodyPackage.IMATRIX_LAYOUT__MODIFIED_TIME_WEAK:
				return getModifiedTimeWeak();
			case UMLRhapsodyPackage.IMATRIX_LAYOUT__FROM_ELEMENT_TYPES:
				return getFromElementTypes();
			case UMLRhapsodyPackage.IMATRIX_LAYOUT__TO_ELEMENT_TYPES:
				if (resolve) return getToElementTypes();
				return basicGetToElementTypes();
			case UMLRhapsodyPackage.IMATRIX_LAYOUT__CELL_ELEMENT_TYPES:
				if (resolve) return getCellElementTypes();
				return basicGetCellElementTypes();
			case UMLRhapsodyPackage.IMATRIX_LAYOUT__DESCRIPTION:
				if (resolve) return getDescription();
				return basicGetDescription();
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
			case UMLRhapsodyPackage.IMATRIX_LAYOUT__ID:
				setId((String)newValue);
				return;
			case UMLRhapsodyPackage.IMATRIX_LAYOUT__MY_STATE:
				setMyState((String)newValue);
				return;
			case UMLRhapsodyPackage.IMATRIX_LAYOUT__NAME:
				setName((String)newValue);
				return;
			case UMLRhapsodyPackage.IMATRIX_LAYOUT__MODIFIED_TIME_WEAK:
				getModifiedTimeWeak().clear();
				getModifiedTimeWeak().addAll((Collection<? extends String>)newValue);
				return;
			case UMLRhapsodyPackage.IMATRIX_LAYOUT__FROM_ELEMENT_TYPES:
				getFromElementTypes().clear();
				getFromElementTypes().addAll((Collection<? extends TableDataDefinition>)newValue);
				return;
			case UMLRhapsodyPackage.IMATRIX_LAYOUT__TO_ELEMENT_TYPES:
				setToElementTypes((TableDataDefinition)newValue);
				return;
			case UMLRhapsodyPackage.IMATRIX_LAYOUT__CELL_ELEMENT_TYPES:
				setCellElementTypes((TableDataDefinition)newValue);
				return;
			case UMLRhapsodyPackage.IMATRIX_LAYOUT__DESCRIPTION:
				setDescription((IDescription)newValue);
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
			case UMLRhapsodyPackage.IMATRIX_LAYOUT__ID:
				setId(ID_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IMATRIX_LAYOUT__MY_STATE:
				setMyState(MY_STATE_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IMATRIX_LAYOUT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IMATRIX_LAYOUT__MODIFIED_TIME_WEAK:
				getModifiedTimeWeak().clear();
				return;
			case UMLRhapsodyPackage.IMATRIX_LAYOUT__FROM_ELEMENT_TYPES:
				getFromElementTypes().clear();
				return;
			case UMLRhapsodyPackage.IMATRIX_LAYOUT__TO_ELEMENT_TYPES:
				setToElementTypes((TableDataDefinition)null);
				return;
			case UMLRhapsodyPackage.IMATRIX_LAYOUT__CELL_ELEMENT_TYPES:
				setCellElementTypes((TableDataDefinition)null);
				return;
			case UMLRhapsodyPackage.IMATRIX_LAYOUT__DESCRIPTION:
				setDescription((IDescription)null);
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
			case UMLRhapsodyPackage.IMATRIX_LAYOUT__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case UMLRhapsodyPackage.IMATRIX_LAYOUT__MY_STATE:
				return MY_STATE_EDEFAULT == null ? myState != null : !MY_STATE_EDEFAULT.equals(myState);
			case UMLRhapsodyPackage.IMATRIX_LAYOUT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case UMLRhapsodyPackage.IMATRIX_LAYOUT__MODIFIED_TIME_WEAK:
				return modifiedTimeWeak != null && !modifiedTimeWeak.isEmpty();
			case UMLRhapsodyPackage.IMATRIX_LAYOUT__FROM_ELEMENT_TYPES:
				return fromElementTypes != null && !fromElementTypes.isEmpty();
			case UMLRhapsodyPackage.IMATRIX_LAYOUT__TO_ELEMENT_TYPES:
				return toElementTypes != null;
			case UMLRhapsodyPackage.IMATRIX_LAYOUT__CELL_ELEMENT_TYPES:
				return cellElementTypes != null;
			case UMLRhapsodyPackage.IMATRIX_LAYOUT__DESCRIPTION:
				return description != null;
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
		result.append(", myState: "); //$NON-NLS-1$
		result.append(myState);
		result.append(", name: "); //$NON-NLS-1$
		result.append(name);
		result.append(", modifiedTimeWeak: "); //$NON-NLS-1$
		result.append(modifiedTimeWeak);
		result.append(')');
		return result.toString();
	}

} //IMatrixLayoutImpl
