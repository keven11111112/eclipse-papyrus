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

import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IClassifier;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IMatrixInstance;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IPropertyContainer;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IUnit;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.M_pModelObjectType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>IMatrix Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IMatrixInstanceImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IMatrixInstanceImpl#getMyState <em>My State</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IMatrixInstanceImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IMatrixInstanceImpl#getModifiedTimeWeak <em>Modified Time Weak</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IMatrixInstanceImpl#getLayoutHandle <em>Layout Handle</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IMatrixInstanceImpl#getFromScopeHandles <em>From Scope Handles</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IMatrixInstanceImpl#getToScopeHandles <em>To Scope Handles</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IMatrixInstanceImpl#getStereotypes <em>Stereotypes</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IMatrixInstanceImpl#getM_IncludeDescendants_to <em>MInclude Descendants to</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IMatrixInstanceImpl#getProperties <em>Properties</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IMatrixInstanceImpl extends MatrixInstancesTypeImpl implements IMatrixInstance {
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
	 * The cached value of the '{@link #getLayoutHandle() <em>Layout Handle</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLayoutHandle()
	 * @generated
	 * @ordered
	 */
	protected IUnit layoutHandle;

	/**
	 * The cached value of the '{@link #getFromScopeHandles() <em>From Scope Handles</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFromScopeHandles()
	 * @generated
	 * @ordered
	 */
	protected M_pModelObjectType fromScopeHandles;

	/**
	 * The cached value of the '{@link #getToScopeHandles() <em>To Scope Handles</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToScopeHandles()
	 * @generated
	 * @ordered
	 */
	protected M_pModelObjectType toScopeHandles;

	/**
	 * The cached value of the '{@link #getStereotypes() <em>Stereotypes</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStereotypes()
	 * @generated
	 * @ordered
	 */
	protected IClassifier stereotypes;

	/**
	 * The default value of the '{@link #getM_IncludeDescendants_to() <em>MInclude Descendants to</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_IncludeDescendants_to()
	 * @generated
	 * @ordered
	 */
	protected static final String MINCLUDE_DESCENDANTS_TO_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_IncludeDescendants_to() <em>MInclude Descendants to</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_IncludeDescendants_to()
	 * @generated
	 * @ordered
	 */
	protected String m_IncludeDescendants_to = MINCLUDE_DESCENDANTS_TO_EDEFAULT;

	/**
	 * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperties()
	 * @generated
	 * @ordered
	 */
	protected IPropertyContainer properties;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IMatrixInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLRhapsodyPackage.eINSTANCE.getIMatrixInstance();
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IMATRIX_INSTANCE__ID, oldId, id));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IMATRIX_INSTANCE__MY_STATE, oldMyState, myState));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IMATRIX_INSTANCE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getModifiedTimeWeak() {
		if (modifiedTimeWeak == null) {
			modifiedTimeWeak = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.IMATRIX_INSTANCE__MODIFIED_TIME_WEAK);
		}
		return modifiedTimeWeak;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IUnit getLayoutHandle() {
		if (layoutHandle != null && layoutHandle.eIsProxy()) {
			InternalEObject oldLayoutHandle = (InternalEObject)layoutHandle;
			layoutHandle = (IUnit)eResolveProxy(oldLayoutHandle);
			if (layoutHandle != oldLayoutHandle) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IMATRIX_INSTANCE__LAYOUT_HANDLE, oldLayoutHandle, layoutHandle));
			}
		}
		return layoutHandle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IUnit basicGetLayoutHandle() {
		return layoutHandle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLayoutHandle(IUnit newLayoutHandle) {
		IUnit oldLayoutHandle = layoutHandle;
		layoutHandle = newLayoutHandle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IMATRIX_INSTANCE__LAYOUT_HANDLE, oldLayoutHandle, layoutHandle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public M_pModelObjectType getFromScopeHandles() {
		if (fromScopeHandles != null && fromScopeHandles.eIsProxy()) {
			InternalEObject oldFromScopeHandles = (InternalEObject)fromScopeHandles;
			fromScopeHandles = (M_pModelObjectType)eResolveProxy(oldFromScopeHandles);
			if (fromScopeHandles != oldFromScopeHandles) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IMATRIX_INSTANCE__FROM_SCOPE_HANDLES, oldFromScopeHandles, fromScopeHandles));
			}
		}
		return fromScopeHandles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public M_pModelObjectType basicGetFromScopeHandles() {
		return fromScopeHandles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFromScopeHandles(M_pModelObjectType newFromScopeHandles) {
		M_pModelObjectType oldFromScopeHandles = fromScopeHandles;
		fromScopeHandles = newFromScopeHandles;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IMATRIX_INSTANCE__FROM_SCOPE_HANDLES, oldFromScopeHandles, fromScopeHandles));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public M_pModelObjectType getToScopeHandles() {
		if (toScopeHandles != null && toScopeHandles.eIsProxy()) {
			InternalEObject oldToScopeHandles = (InternalEObject)toScopeHandles;
			toScopeHandles = (M_pModelObjectType)eResolveProxy(oldToScopeHandles);
			if (toScopeHandles != oldToScopeHandles) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IMATRIX_INSTANCE__TO_SCOPE_HANDLES, oldToScopeHandles, toScopeHandles));
			}
		}
		return toScopeHandles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public M_pModelObjectType basicGetToScopeHandles() {
		return toScopeHandles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setToScopeHandles(M_pModelObjectType newToScopeHandles) {
		M_pModelObjectType oldToScopeHandles = toScopeHandles;
		toScopeHandles = newToScopeHandles;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IMATRIX_INSTANCE__TO_SCOPE_HANDLES, oldToScopeHandles, toScopeHandles));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IClassifier getStereotypes() {
		if (stereotypes != null && stereotypes.eIsProxy()) {
			InternalEObject oldStereotypes = (InternalEObject)stereotypes;
			stereotypes = (IClassifier)eResolveProxy(oldStereotypes);
			if (stereotypes != oldStereotypes) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IMATRIX_INSTANCE__STEREOTYPES, oldStereotypes, stereotypes));
			}
		}
		return stereotypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IClassifier basicGetStereotypes() {
		return stereotypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStereotypes(IClassifier newStereotypes) {
		IClassifier oldStereotypes = stereotypes;
		stereotypes = newStereotypes;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IMATRIX_INSTANCE__STEREOTYPES, oldStereotypes, stereotypes));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_IncludeDescendants_to() {
		return m_IncludeDescendants_to;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_IncludeDescendants_to(String newM_IncludeDescendants_to) {
		String oldM_IncludeDescendants_to = m_IncludeDescendants_to;
		m_IncludeDescendants_to = newM_IncludeDescendants_to;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IMATRIX_INSTANCE__MINCLUDE_DESCENDANTS_TO, oldM_IncludeDescendants_to, m_IncludeDescendants_to));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IPropertyContainer getProperties() {
		if (properties != null && properties.eIsProxy()) {
			InternalEObject oldProperties = (InternalEObject)properties;
			properties = (IPropertyContainer)eResolveProxy(oldProperties);
			if (properties != oldProperties) {
				InternalEObject newProperties = (InternalEObject)properties;
				NotificationChain msgs = oldProperties.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IMATRIX_INSTANCE__PROPERTIES, null, null);
				if (newProperties.eInternalContainer() == null) {
					msgs = newProperties.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IMATRIX_INSTANCE__PROPERTIES, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IMATRIX_INSTANCE__PROPERTIES, oldProperties, properties));
			}
		}
		return properties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IPropertyContainer basicGetProperties() {
		return properties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProperties(IPropertyContainer newProperties, NotificationChain msgs) {
		IPropertyContainer oldProperties = properties;
		properties = newProperties;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IMATRIX_INSTANCE__PROPERTIES, oldProperties, newProperties);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProperties(IPropertyContainer newProperties) {
		if (newProperties != properties) {
			NotificationChain msgs = null;
			if (properties != null)
				msgs = ((InternalEObject)properties).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IMATRIX_INSTANCE__PROPERTIES, null, msgs);
			if (newProperties != null)
				msgs = ((InternalEObject)newProperties).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IMATRIX_INSTANCE__PROPERTIES, null, msgs);
			msgs = basicSetProperties(newProperties, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IMATRIX_INSTANCE__PROPERTIES, newProperties, newProperties));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLRhapsodyPackage.IMATRIX_INSTANCE__PROPERTIES:
				return basicSetProperties(null, msgs);
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
			case UMLRhapsodyPackage.IMATRIX_INSTANCE__ID:
				return getId();
			case UMLRhapsodyPackage.IMATRIX_INSTANCE__MY_STATE:
				return getMyState();
			case UMLRhapsodyPackage.IMATRIX_INSTANCE__NAME:
				return getName();
			case UMLRhapsodyPackage.IMATRIX_INSTANCE__MODIFIED_TIME_WEAK:
				return getModifiedTimeWeak();
			case UMLRhapsodyPackage.IMATRIX_INSTANCE__LAYOUT_HANDLE:
				if (resolve) return getLayoutHandle();
				return basicGetLayoutHandle();
			case UMLRhapsodyPackage.IMATRIX_INSTANCE__FROM_SCOPE_HANDLES:
				if (resolve) return getFromScopeHandles();
				return basicGetFromScopeHandles();
			case UMLRhapsodyPackage.IMATRIX_INSTANCE__TO_SCOPE_HANDLES:
				if (resolve) return getToScopeHandles();
				return basicGetToScopeHandles();
			case UMLRhapsodyPackage.IMATRIX_INSTANCE__STEREOTYPES:
				if (resolve) return getStereotypes();
				return basicGetStereotypes();
			case UMLRhapsodyPackage.IMATRIX_INSTANCE__MINCLUDE_DESCENDANTS_TO:
				return getM_IncludeDescendants_to();
			case UMLRhapsodyPackage.IMATRIX_INSTANCE__PROPERTIES:
				if (resolve) return getProperties();
				return basicGetProperties();
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
			case UMLRhapsodyPackage.IMATRIX_INSTANCE__ID:
				setId((String)newValue);
				return;
			case UMLRhapsodyPackage.IMATRIX_INSTANCE__MY_STATE:
				setMyState((String)newValue);
				return;
			case UMLRhapsodyPackage.IMATRIX_INSTANCE__NAME:
				setName((String)newValue);
				return;
			case UMLRhapsodyPackage.IMATRIX_INSTANCE__MODIFIED_TIME_WEAK:
				getModifiedTimeWeak().clear();
				getModifiedTimeWeak().addAll((Collection<? extends String>)newValue);
				return;
			case UMLRhapsodyPackage.IMATRIX_INSTANCE__LAYOUT_HANDLE:
				setLayoutHandle((IUnit)newValue);
				return;
			case UMLRhapsodyPackage.IMATRIX_INSTANCE__FROM_SCOPE_HANDLES:
				setFromScopeHandles((M_pModelObjectType)newValue);
				return;
			case UMLRhapsodyPackage.IMATRIX_INSTANCE__TO_SCOPE_HANDLES:
				setToScopeHandles((M_pModelObjectType)newValue);
				return;
			case UMLRhapsodyPackage.IMATRIX_INSTANCE__STEREOTYPES:
				setStereotypes((IClassifier)newValue);
				return;
			case UMLRhapsodyPackage.IMATRIX_INSTANCE__MINCLUDE_DESCENDANTS_TO:
				setM_IncludeDescendants_to((String)newValue);
				return;
			case UMLRhapsodyPackage.IMATRIX_INSTANCE__PROPERTIES:
				setProperties((IPropertyContainer)newValue);
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
			case UMLRhapsodyPackage.IMATRIX_INSTANCE__ID:
				setId(ID_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IMATRIX_INSTANCE__MY_STATE:
				setMyState(MY_STATE_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IMATRIX_INSTANCE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IMATRIX_INSTANCE__MODIFIED_TIME_WEAK:
				getModifiedTimeWeak().clear();
				return;
			case UMLRhapsodyPackage.IMATRIX_INSTANCE__LAYOUT_HANDLE:
				setLayoutHandle((IUnit)null);
				return;
			case UMLRhapsodyPackage.IMATRIX_INSTANCE__FROM_SCOPE_HANDLES:
				setFromScopeHandles((M_pModelObjectType)null);
				return;
			case UMLRhapsodyPackage.IMATRIX_INSTANCE__TO_SCOPE_HANDLES:
				setToScopeHandles((M_pModelObjectType)null);
				return;
			case UMLRhapsodyPackage.IMATRIX_INSTANCE__STEREOTYPES:
				setStereotypes((IClassifier)null);
				return;
			case UMLRhapsodyPackage.IMATRIX_INSTANCE__MINCLUDE_DESCENDANTS_TO:
				setM_IncludeDescendants_to(MINCLUDE_DESCENDANTS_TO_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IMATRIX_INSTANCE__PROPERTIES:
				setProperties((IPropertyContainer)null);
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
			case UMLRhapsodyPackage.IMATRIX_INSTANCE__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case UMLRhapsodyPackage.IMATRIX_INSTANCE__MY_STATE:
				return MY_STATE_EDEFAULT == null ? myState != null : !MY_STATE_EDEFAULT.equals(myState);
			case UMLRhapsodyPackage.IMATRIX_INSTANCE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case UMLRhapsodyPackage.IMATRIX_INSTANCE__MODIFIED_TIME_WEAK:
				return modifiedTimeWeak != null && !modifiedTimeWeak.isEmpty();
			case UMLRhapsodyPackage.IMATRIX_INSTANCE__LAYOUT_HANDLE:
				return layoutHandle != null;
			case UMLRhapsodyPackage.IMATRIX_INSTANCE__FROM_SCOPE_HANDLES:
				return fromScopeHandles != null;
			case UMLRhapsodyPackage.IMATRIX_INSTANCE__TO_SCOPE_HANDLES:
				return toScopeHandles != null;
			case UMLRhapsodyPackage.IMATRIX_INSTANCE__STEREOTYPES:
				return stereotypes != null;
			case UMLRhapsodyPackage.IMATRIX_INSTANCE__MINCLUDE_DESCENDANTS_TO:
				return MINCLUDE_DESCENDANTS_TO_EDEFAULT == null ? m_IncludeDescendants_to != null : !MINCLUDE_DESCENDANTS_TO_EDEFAULT.equals(m_IncludeDescendants_to);
			case UMLRhapsodyPackage.IMATRIX_INSTANCE__PROPERTIES:
				return properties != null;
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
		result.append(", m_IncludeDescendants_to: "); //$NON-NLS-1$
		result.append(m_IncludeDescendants_to);
		result.append(')');
		return result.toString();
	}

} //IMatrixInstanceImpl
