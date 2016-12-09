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

import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.DeclarativesType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.DefaultSubsystemType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.DependsOnType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ElementsType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IClass;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IMatrixLayout;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IProfile;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ITag;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.OwnerHandleType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>IProfile</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IProfileImpl#getWeakCGTime <em>Weak CG Time</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IProfileImpl#getStrongCGTime <em>Strong CG Time</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IProfileImpl#getDeclaratives <em>Declaratives</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IProfileImpl#getDefaultComposite <em>Default Composite</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IProfileImpl#getEventsBaseID <em>Events Base ID</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IProfileImpl#getClasses <em>Classes</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IProfileImpl#getConfigurationRelatedTime <em>Configuration Related Time</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IProfileImpl#getTags <em>Tags</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IProfileImpl#getTypes <em>Types</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IProfileImpl#getMatrixLayouts <em>Matrix Layouts</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IProfileImpl#getLicense <em>License</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IProfileImpl#getDisplayName <em>Display Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IProfileImpl extends IPackageImpl implements IProfile {
	/**
	 * The cached value of the '{@link #getWeakCGTime() <em>Weak CG Time</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWeakCGTime()
	 * @generated
	 * @ordered
	 */
	protected EList<String> weakCGTime;

	/**
	 * The cached value of the '{@link #getStrongCGTime() <em>Strong CG Time</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStrongCGTime()
	 * @generated
	 * @ordered
	 */
	protected EList<String> strongCGTime;

	/**
	 * The cached value of the '{@link #getDeclaratives() <em>Declaratives</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeclaratives()
	 * @generated
	 * @ordered
	 */
	protected EList<DeclarativesType> declaratives;

	/**
	 * The cached value of the '{@link #getDefaultComposite() <em>Default Composite</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultComposite()
	 * @generated
	 * @ordered
	 */
	protected IClass defaultComposite;

	/**
	 * The default value of the '{@link #getEventsBaseID() <em>Events Base ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventsBaseID()
	 * @generated
	 * @ordered
	 */
	protected static final String EVENTS_BASE_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEventsBaseID() <em>Events Base ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventsBaseID()
	 * @generated
	 * @ordered
	 */
	protected String eventsBaseID = EVENTS_BASE_ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getClasses() <em>Classes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClasses()
	 * @generated
	 * @ordered
	 */
	protected EList<IClass> classes;

	/**
	 * The cached value of the '{@link #getConfigurationRelatedTime() <em>Configuration Related Time</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfigurationRelatedTime()
	 * @generated
	 * @ordered
	 */
	protected EList<String> configurationRelatedTime;

	/**
	 * The cached value of the '{@link #getTags() <em>Tags</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTags()
	 * @generated
	 * @ordered
	 */
	protected EList<ITag> tags;

	/**
	 * The cached value of the '{@link #getTypes() <em>Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<IType> types;

	/**
	 * The cached value of the '{@link #getMatrixLayouts() <em>Matrix Layouts</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMatrixLayouts()
	 * @generated
	 * @ordered
	 */
	protected IMatrixLayout matrixLayouts;

	/**
	 * The default value of the '{@link #getLicense() <em>License</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLicense()
	 * @generated
	 * @ordered
	 */
	protected static final String LICENSE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLicense() <em>License</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLicense()
	 * @generated
	 * @ordered
	 */
	protected String license = LICENSE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDisplayName() <em>Display Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDisplayName()
	 * @generated
	 * @ordered
	 */
	protected static final String DISPLAY_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDisplayName() <em>Display Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDisplayName()
	 * @generated
	 * @ordered
	 */
	protected String displayName = DISPLAY_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IProfileImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLRhapsodyPackage.eINSTANCE.getIProfile();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getWeakCGTime() {
		if (weakCGTime == null) {
			weakCGTime = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.IPROFILE__WEAK_CG_TIME);
		}
		return weakCGTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getStrongCGTime() {
		if (strongCGTime == null) {
			strongCGTime = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.IPROFILE__STRONG_CG_TIME);
		}
		return strongCGTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DeclarativesType> getDeclaratives() {
		if (declaratives == null) {
			declaratives = new EObjectContainmentEList.Resolving<DeclarativesType>(DeclarativesType.class, this, UMLRhapsodyPackage.IPROFILE__DECLARATIVES);
		}
		return declaratives;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IClass getDefaultComposite() {
		if (defaultComposite != null && defaultComposite.eIsProxy()) {
			InternalEObject oldDefaultComposite = (InternalEObject)defaultComposite;
			defaultComposite = (IClass)eResolveProxy(oldDefaultComposite);
			if (defaultComposite != oldDefaultComposite) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IPROFILE__DEFAULT_COMPOSITE, oldDefaultComposite, defaultComposite));
			}
		}
		return defaultComposite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IClass basicGetDefaultComposite() {
		return defaultComposite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultComposite(IClass newDefaultComposite) {
		IClass oldDefaultComposite = defaultComposite;
		defaultComposite = newDefaultComposite;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IPROFILE__DEFAULT_COMPOSITE, oldDefaultComposite, defaultComposite));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEventsBaseID() {
		return eventsBaseID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEventsBaseID(String newEventsBaseID) {
		String oldEventsBaseID = eventsBaseID;
		eventsBaseID = newEventsBaseID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IPROFILE__EVENTS_BASE_ID, oldEventsBaseID, eventsBaseID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IClass> getClasses() {
		if (classes == null) {
			classes = new EObjectContainmentEList.Resolving<IClass>(IClass.class, this, UMLRhapsodyPackage.IPROFILE__CLASSES);
		}
		return classes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getConfigurationRelatedTime() {
		if (configurationRelatedTime == null) {
			configurationRelatedTime = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.IPROFILE__CONFIGURATION_RELATED_TIME);
		}
		return configurationRelatedTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ITag> getTags() {
		if (tags == null) {
			tags = new EObjectContainmentEList.Resolving<ITag>(ITag.class, this, UMLRhapsodyPackage.IPROFILE__TAGS);
		}
		return tags;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IType> getTypes() {
		if (types == null) {
			types = new EObjectContainmentEList.Resolving<IType>(IType.class, this, UMLRhapsodyPackage.IPROFILE__TYPES);
		}
		return types;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IMatrixLayout getMatrixLayouts() {
		if (matrixLayouts != null && matrixLayouts.eIsProxy()) {
			InternalEObject oldMatrixLayouts = (InternalEObject)matrixLayouts;
			matrixLayouts = (IMatrixLayout)eResolveProxy(oldMatrixLayouts);
			if (matrixLayouts != oldMatrixLayouts) {
				InternalEObject newMatrixLayouts = (InternalEObject)matrixLayouts;
				NotificationChain msgs = oldMatrixLayouts.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IPROFILE__MATRIX_LAYOUTS, null, null);
				if (newMatrixLayouts.eInternalContainer() == null) {
					msgs = newMatrixLayouts.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IPROFILE__MATRIX_LAYOUTS, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IPROFILE__MATRIX_LAYOUTS, oldMatrixLayouts, matrixLayouts));
			}
		}
		return matrixLayouts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IMatrixLayout basicGetMatrixLayouts() {
		return matrixLayouts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMatrixLayouts(IMatrixLayout newMatrixLayouts, NotificationChain msgs) {
		IMatrixLayout oldMatrixLayouts = matrixLayouts;
		matrixLayouts = newMatrixLayouts;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IPROFILE__MATRIX_LAYOUTS, oldMatrixLayouts, newMatrixLayouts);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMatrixLayouts(IMatrixLayout newMatrixLayouts) {
		if (newMatrixLayouts != matrixLayouts) {
			NotificationChain msgs = null;
			if (matrixLayouts != null)
				msgs = ((InternalEObject)matrixLayouts).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IPROFILE__MATRIX_LAYOUTS, null, msgs);
			if (newMatrixLayouts != null)
				msgs = ((InternalEObject)newMatrixLayouts).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IPROFILE__MATRIX_LAYOUTS, null, msgs);
			msgs = basicSetMatrixLayouts(newMatrixLayouts, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IPROFILE__MATRIX_LAYOUTS, newMatrixLayouts, newMatrixLayouts));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLicense() {
		return license;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLicense(String newLicense) {
		String oldLicense = license;
		license = newLicense;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IPROFILE__LICENSE, oldLicense, license));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDisplayName(String newDisplayName) {
		String oldDisplayName = displayName;
		displayName = newDisplayName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IPROFILE__DISPLAY_NAME, oldDisplayName, displayName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLRhapsodyPackage.IPROFILE__DECLARATIVES:
				return ((InternalEList<?>)getDeclaratives()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.IPROFILE__CLASSES:
				return ((InternalEList<?>)getClasses()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.IPROFILE__TAGS:
				return ((InternalEList<?>)getTags()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.IPROFILE__TYPES:
				return ((InternalEList<?>)getTypes()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.IPROFILE__MATRIX_LAYOUTS:
				return basicSetMatrixLayouts(null, msgs);
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
			case UMLRhapsodyPackage.IPROFILE__WEAK_CG_TIME:
				return getWeakCGTime();
			case UMLRhapsodyPackage.IPROFILE__STRONG_CG_TIME:
				return getStrongCGTime();
			case UMLRhapsodyPackage.IPROFILE__DECLARATIVES:
				return getDeclaratives();
			case UMLRhapsodyPackage.IPROFILE__DEFAULT_COMPOSITE:
				if (resolve) return getDefaultComposite();
				return basicGetDefaultComposite();
			case UMLRhapsodyPackage.IPROFILE__EVENTS_BASE_ID:
				return getEventsBaseID();
			case UMLRhapsodyPackage.IPROFILE__CLASSES:
				return getClasses();
			case UMLRhapsodyPackage.IPROFILE__CONFIGURATION_RELATED_TIME:
				return getConfigurationRelatedTime();
			case UMLRhapsodyPackage.IPROFILE__TAGS:
				return getTags();
			case UMLRhapsodyPackage.IPROFILE__TYPES:
				return getTypes();
			case UMLRhapsodyPackage.IPROFILE__MATRIX_LAYOUTS:
				if (resolve) return getMatrixLayouts();
				return basicGetMatrixLayouts();
			case UMLRhapsodyPackage.IPROFILE__LICENSE:
				return getLicense();
			case UMLRhapsodyPackage.IPROFILE__DISPLAY_NAME:
				return getDisplayName();
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
			case UMLRhapsodyPackage.IPROFILE__WEAK_CG_TIME:
				getWeakCGTime().clear();
				getWeakCGTime().addAll((Collection<? extends String>)newValue);
				return;
			case UMLRhapsodyPackage.IPROFILE__STRONG_CG_TIME:
				getStrongCGTime().clear();
				getStrongCGTime().addAll((Collection<? extends String>)newValue);
				return;
			case UMLRhapsodyPackage.IPROFILE__DECLARATIVES:
				getDeclaratives().clear();
				getDeclaratives().addAll((Collection<? extends DeclarativesType>)newValue);
				return;
			case UMLRhapsodyPackage.IPROFILE__DEFAULT_COMPOSITE:
				setDefaultComposite((IClass)newValue);
				return;
			case UMLRhapsodyPackage.IPROFILE__EVENTS_BASE_ID:
				setEventsBaseID((String)newValue);
				return;
			case UMLRhapsodyPackage.IPROFILE__CLASSES:
				getClasses().clear();
				getClasses().addAll((Collection<? extends IClass>)newValue);
				return;
			case UMLRhapsodyPackage.IPROFILE__CONFIGURATION_RELATED_TIME:
				getConfigurationRelatedTime().clear();
				getConfigurationRelatedTime().addAll((Collection<? extends String>)newValue);
				return;
			case UMLRhapsodyPackage.IPROFILE__TAGS:
				getTags().clear();
				getTags().addAll((Collection<? extends ITag>)newValue);
				return;
			case UMLRhapsodyPackage.IPROFILE__TYPES:
				getTypes().clear();
				getTypes().addAll((Collection<? extends IType>)newValue);
				return;
			case UMLRhapsodyPackage.IPROFILE__MATRIX_LAYOUTS:
				setMatrixLayouts((IMatrixLayout)newValue);
				return;
			case UMLRhapsodyPackage.IPROFILE__LICENSE:
				setLicense((String)newValue);
				return;
			case UMLRhapsodyPackage.IPROFILE__DISPLAY_NAME:
				setDisplayName((String)newValue);
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
			case UMLRhapsodyPackage.IPROFILE__WEAK_CG_TIME:
				getWeakCGTime().clear();
				return;
			case UMLRhapsodyPackage.IPROFILE__STRONG_CG_TIME:
				getStrongCGTime().clear();
				return;
			case UMLRhapsodyPackage.IPROFILE__DECLARATIVES:
				getDeclaratives().clear();
				return;
			case UMLRhapsodyPackage.IPROFILE__DEFAULT_COMPOSITE:
				setDefaultComposite((IClass)null);
				return;
			case UMLRhapsodyPackage.IPROFILE__EVENTS_BASE_ID:
				setEventsBaseID(EVENTS_BASE_ID_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IPROFILE__CLASSES:
				getClasses().clear();
				return;
			case UMLRhapsodyPackage.IPROFILE__CONFIGURATION_RELATED_TIME:
				getConfigurationRelatedTime().clear();
				return;
			case UMLRhapsodyPackage.IPROFILE__TAGS:
				getTags().clear();
				return;
			case UMLRhapsodyPackage.IPROFILE__TYPES:
				getTypes().clear();
				return;
			case UMLRhapsodyPackage.IPROFILE__MATRIX_LAYOUTS:
				setMatrixLayouts((IMatrixLayout)null);
				return;
			case UMLRhapsodyPackage.IPROFILE__LICENSE:
				setLicense(LICENSE_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IPROFILE__DISPLAY_NAME:
				setDisplayName(DISPLAY_NAME_EDEFAULT);
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
			case UMLRhapsodyPackage.IPROFILE__WEAK_CG_TIME:
				return weakCGTime != null && !weakCGTime.isEmpty();
			case UMLRhapsodyPackage.IPROFILE__STRONG_CG_TIME:
				return strongCGTime != null && !strongCGTime.isEmpty();
			case UMLRhapsodyPackage.IPROFILE__DECLARATIVES:
				return declaratives != null && !declaratives.isEmpty();
			case UMLRhapsodyPackage.IPROFILE__DEFAULT_COMPOSITE:
				return defaultComposite != null;
			case UMLRhapsodyPackage.IPROFILE__EVENTS_BASE_ID:
				return EVENTS_BASE_ID_EDEFAULT == null ? eventsBaseID != null : !EVENTS_BASE_ID_EDEFAULT.equals(eventsBaseID);
			case UMLRhapsodyPackage.IPROFILE__CLASSES:
				return classes != null && !classes.isEmpty();
			case UMLRhapsodyPackage.IPROFILE__CONFIGURATION_RELATED_TIME:
				return configurationRelatedTime != null && !configurationRelatedTime.isEmpty();
			case UMLRhapsodyPackage.IPROFILE__TAGS:
				return tags != null && !tags.isEmpty();
			case UMLRhapsodyPackage.IPROFILE__TYPES:
				return types != null && !types.isEmpty();
			case UMLRhapsodyPackage.IPROFILE__MATRIX_LAYOUTS:
				return matrixLayouts != null;
			case UMLRhapsodyPackage.IPROFILE__LICENSE:
				return LICENSE_EDEFAULT == null ? license != null : !LICENSE_EDEFAULT.equals(license);
			case UMLRhapsodyPackage.IPROFILE__DISPLAY_NAME:
				return DISPLAY_NAME_EDEFAULT == null ? displayName != null : !DISPLAY_NAME_EDEFAULT.equals(displayName);
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
		if (baseClass == DefaultSubsystemType.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == OwnerHandleType.class) {
			switch (derivedFeatureID) {
				case UMLRhapsodyPackage.IPROFILE__WEAK_CG_TIME: return UMLRhapsodyPackage.OWNER_HANDLE_TYPE__WEAK_CG_TIME;
				case UMLRhapsodyPackage.IPROFILE__STRONG_CG_TIME: return UMLRhapsodyPackage.OWNER_HANDLE_TYPE__STRONG_CG_TIME;
				default: return -1;
			}
		}
		if (baseClass == ElementsType.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == DependsOnType.class) {
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
		if (baseClass == DefaultSubsystemType.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == OwnerHandleType.class) {
			switch (baseFeatureID) {
				case UMLRhapsodyPackage.OWNER_HANDLE_TYPE__WEAK_CG_TIME: return UMLRhapsodyPackage.IPROFILE__WEAK_CG_TIME;
				case UMLRhapsodyPackage.OWNER_HANDLE_TYPE__STRONG_CG_TIME: return UMLRhapsodyPackage.IPROFILE__STRONG_CG_TIME;
				default: return -1;
			}
		}
		if (baseClass == ElementsType.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == DependsOnType.class) {
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
		result.append(" (weakCGTime: "); //$NON-NLS-1$
		result.append(weakCGTime);
		result.append(", strongCGTime: "); //$NON-NLS-1$
		result.append(strongCGTime);
		result.append(", eventsBaseID: "); //$NON-NLS-1$
		result.append(eventsBaseID);
		result.append(", configurationRelatedTime: "); //$NON-NLS-1$
		result.append(configurationRelatedTime);
		result.append(", license: "); //$NON-NLS-1$
		result.append(license);
		result.append(", displayName: "); //$NON-NLS-1$
		result.append(displayName);
		result.append(')');
		return result.toString();
	}

} //IProfileImpl
