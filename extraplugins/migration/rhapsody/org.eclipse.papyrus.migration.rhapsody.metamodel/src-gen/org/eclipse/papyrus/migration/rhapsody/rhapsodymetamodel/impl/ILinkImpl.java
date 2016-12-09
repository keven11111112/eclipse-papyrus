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

import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IClassHandle;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ILink;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IUnit;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.LinksType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.M_pModelObjectType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>ILink</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ILinkImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ILinkImpl#getMultiplicity <em>Multiplicity</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ILinkImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ILinkImpl#getOtherClass <em>Other Class</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ILinkImpl#getInverse <em>Inverse</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ILinkImpl#getLinkName <em>Link Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ILinkImpl#getLinkType <em>Link Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ILinkImpl#getMyState <em>My State</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ILinkImpl extends IUnitImpl implements ILink {
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
	 * The default value of the '{@link #getMultiplicity() <em>Multiplicity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMultiplicity()
	 * @generated
	 * @ordered
	 */
	protected static final String MULTIPLICITY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMultiplicity() <em>Multiplicity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMultiplicity()
	 * @generated
	 * @ordered
	 */
	protected String multiplicity = MULTIPLICITY_EDEFAULT;

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
	 * The cached value of the '{@link #getOtherClass() <em>Other Class</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOtherClass()
	 * @generated
	 * @ordered
	 */
	protected IClassHandle otherClass;

	/**
	 * The cached value of the '{@link #getInverse() <em>Inverse</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInverse()
	 * @generated
	 * @ordered
	 */
	protected IUnit inverse;

	/**
	 * The default value of the '{@link #getLinkName() <em>Link Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinkName()
	 * @generated
	 * @ordered
	 */
	protected static final String LINK_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLinkName() <em>Link Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinkName()
	 * @generated
	 * @ordered
	 */
	protected String linkName = LINK_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getLinkType() <em>Link Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinkType()
	 * @generated
	 * @ordered
	 */
	protected static final String LINK_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLinkType() <em>Link Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinkType()
	 * @generated
	 * @ordered
	 */
	protected String linkType = LINK_TYPE_EDEFAULT;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ILinkImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLRhapsodyPackage.eINSTANCE.getILink();
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ILINK__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMultiplicity() {
		return multiplicity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMultiplicity(String newMultiplicity) {
		String oldMultiplicity = multiplicity;
		multiplicity = newMultiplicity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ILINK__MULTIPLICITY, oldMultiplicity, multiplicity));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ILINK__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IClassHandle getOtherClass() {
		if (otherClass != null && otherClass.eIsProxy()) {
			InternalEObject oldOtherClass = (InternalEObject)otherClass;
			otherClass = (IClassHandle)eResolveProxy(oldOtherClass);
			if (otherClass != oldOtherClass) {
				InternalEObject newOtherClass = (InternalEObject)otherClass;
				NotificationChain msgs = oldOtherClass.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ILINK__OTHER_CLASS, null, null);
				if (newOtherClass.eInternalContainer() == null) {
					msgs = newOtherClass.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ILINK__OTHER_CLASS, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.ILINK__OTHER_CLASS, oldOtherClass, otherClass));
			}
		}
		return otherClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IClassHandle basicGetOtherClass() {
		return otherClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOtherClass(IClassHandle newOtherClass, NotificationChain msgs) {
		IClassHandle oldOtherClass = otherClass;
		otherClass = newOtherClass;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ILINK__OTHER_CLASS, oldOtherClass, newOtherClass);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOtherClass(IClassHandle newOtherClass) {
		if (newOtherClass != otherClass) {
			NotificationChain msgs = null;
			if (otherClass != null)
				msgs = ((InternalEObject)otherClass).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ILINK__OTHER_CLASS, null, msgs);
			if (newOtherClass != null)
				msgs = ((InternalEObject)newOtherClass).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ILINK__OTHER_CLASS, null, msgs);
			msgs = basicSetOtherClass(newOtherClass, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ILINK__OTHER_CLASS, newOtherClass, newOtherClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IUnit getInverse() {
		if (inverse != null && inverse.eIsProxy()) {
			InternalEObject oldInverse = (InternalEObject)inverse;
			inverse = (IUnit)eResolveProxy(oldInverse);
			if (inverse != oldInverse) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.ILINK__INVERSE, oldInverse, inverse));
			}
		}
		return inverse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IUnit basicGetInverse() {
		return inverse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInverse(IUnit newInverse) {
		IUnit oldInverse = inverse;
		inverse = newInverse;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ILINK__INVERSE, oldInverse, inverse));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLinkName() {
		return linkName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinkName(String newLinkName) {
		String oldLinkName = linkName;
		linkName = newLinkName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ILINK__LINK_NAME, oldLinkName, linkName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLinkType() {
		return linkType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinkType(String newLinkType) {
		String oldLinkType = linkType;
		linkType = newLinkType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ILINK__LINK_TYPE, oldLinkType, linkType));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ILINK__MY_STATE, oldMyState, myState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLRhapsodyPackage.ILINK__OTHER_CLASS:
				return basicSetOtherClass(null, msgs);
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
			case UMLRhapsodyPackage.ILINK__ID:
				return getId();
			case UMLRhapsodyPackage.ILINK__MULTIPLICITY:
				return getMultiplicity();
			case UMLRhapsodyPackage.ILINK__NAME:
				return getName();
			case UMLRhapsodyPackage.ILINK__OTHER_CLASS:
				if (resolve) return getOtherClass();
				return basicGetOtherClass();
			case UMLRhapsodyPackage.ILINK__INVERSE:
				if (resolve) return getInverse();
				return basicGetInverse();
			case UMLRhapsodyPackage.ILINK__LINK_NAME:
				return getLinkName();
			case UMLRhapsodyPackage.ILINK__LINK_TYPE:
				return getLinkType();
			case UMLRhapsodyPackage.ILINK__MY_STATE:
				return getMyState();
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
			case UMLRhapsodyPackage.ILINK__ID:
				setId((String)newValue);
				return;
			case UMLRhapsodyPackage.ILINK__MULTIPLICITY:
				setMultiplicity((String)newValue);
				return;
			case UMLRhapsodyPackage.ILINK__NAME:
				setName((String)newValue);
				return;
			case UMLRhapsodyPackage.ILINK__OTHER_CLASS:
				setOtherClass((IClassHandle)newValue);
				return;
			case UMLRhapsodyPackage.ILINK__INVERSE:
				setInverse((IUnit)newValue);
				return;
			case UMLRhapsodyPackage.ILINK__LINK_NAME:
				setLinkName((String)newValue);
				return;
			case UMLRhapsodyPackage.ILINK__LINK_TYPE:
				setLinkType((String)newValue);
				return;
			case UMLRhapsodyPackage.ILINK__MY_STATE:
				setMyState((String)newValue);
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
			case UMLRhapsodyPackage.ILINK__ID:
				setId(ID_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ILINK__MULTIPLICITY:
				setMultiplicity(MULTIPLICITY_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ILINK__NAME:
				setName(NAME_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ILINK__OTHER_CLASS:
				setOtherClass((IClassHandle)null);
				return;
			case UMLRhapsodyPackage.ILINK__INVERSE:
				setInverse((IUnit)null);
				return;
			case UMLRhapsodyPackage.ILINK__LINK_NAME:
				setLinkName(LINK_NAME_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ILINK__LINK_TYPE:
				setLinkType(LINK_TYPE_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ILINK__MY_STATE:
				setMyState(MY_STATE_EDEFAULT);
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
			case UMLRhapsodyPackage.ILINK__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case UMLRhapsodyPackage.ILINK__MULTIPLICITY:
				return MULTIPLICITY_EDEFAULT == null ? multiplicity != null : !MULTIPLICITY_EDEFAULT.equals(multiplicity);
			case UMLRhapsodyPackage.ILINK__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case UMLRhapsodyPackage.ILINK__OTHER_CLASS:
				return otherClass != null;
			case UMLRhapsodyPackage.ILINK__INVERSE:
				return inverse != null;
			case UMLRhapsodyPackage.ILINK__LINK_NAME:
				return LINK_NAME_EDEFAULT == null ? linkName != null : !LINK_NAME_EDEFAULT.equals(linkName);
			case UMLRhapsodyPackage.ILINK__LINK_TYPE:
				return LINK_TYPE_EDEFAULT == null ? linkType != null : !LINK_TYPE_EDEFAULT.equals(linkType);
			case UMLRhapsodyPackage.ILINK__MY_STATE:
				return MY_STATE_EDEFAULT == null ? myState != null : !MY_STATE_EDEFAULT.equals(myState);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == LinksType.class) {
			switch (derivedFeatureID) {
				case UMLRhapsodyPackage.ILINK__ID: return UMLRhapsodyPackage.LINKS_TYPE__ID;
				case UMLRhapsodyPackage.ILINK__MULTIPLICITY: return UMLRhapsodyPackage.LINKS_TYPE__MULTIPLICITY;
				case UMLRhapsodyPackage.ILINK__NAME: return UMLRhapsodyPackage.LINKS_TYPE__NAME;
				case UMLRhapsodyPackage.ILINK__OTHER_CLASS: return UMLRhapsodyPackage.LINKS_TYPE__OTHER_CLASS;
				default: return -1;
			}
		}
		if (baseClass == M_pModelObjectType.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == LinksType.class) {
			switch (baseFeatureID) {
				case UMLRhapsodyPackage.LINKS_TYPE__ID: return UMLRhapsodyPackage.ILINK__ID;
				case UMLRhapsodyPackage.LINKS_TYPE__MULTIPLICITY: return UMLRhapsodyPackage.ILINK__MULTIPLICITY;
				case UMLRhapsodyPackage.LINKS_TYPE__NAME: return UMLRhapsodyPackage.ILINK__NAME;
				case UMLRhapsodyPackage.LINKS_TYPE__OTHER_CLASS: return UMLRhapsodyPackage.ILINK__OTHER_CLASS;
				default: return -1;
			}
		}
		if (baseClass == M_pModelObjectType.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(", multiplicity: "); //$NON-NLS-1$
		result.append(multiplicity);
		result.append(", name: "); //$NON-NLS-1$
		result.append(name);
		result.append(", linkName: "); //$NON-NLS-1$
		result.append(linkName);
		result.append(", linkType: "); //$NON-NLS-1$
		result.append(linkType);
		result.append(", myState: "); //$NON-NLS-1$
		result.append(myState);
		result.append(')');
		return result.toString();
	}

} //ILinkImpl
