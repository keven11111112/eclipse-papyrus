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
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIButtonArray;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGICompartment;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.DependsOnType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.GraphElementsType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IAttribute;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IPropertyContainer;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CGI Button Array</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIButtonArrayImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIButtonArrayImpl#getM_pModelObject <em>MpModel Object</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIButtonArrayImpl#getM_pParent <em>MpParent</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIButtonArrayImpl#getM_transform <em>Mtransform</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIButtonArrayImpl#getM_polygon <em>Mpolygon</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIButtonArrayImpl#getM_nNameFormat <em>MnName Format</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIButtonArrayImpl#getM_nIsNameFormat <em>MnIs Name Format</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIButtonArrayImpl#getFrameset <em>Frameset</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIButtonArrayImpl#getCompartments <em>Compartments</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIButtonArrayImpl#getM_csModelObjPath <em>Mcs Model Obj Path</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIButtonArrayImpl#getM_csName <em>Mcs Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIButtonArrayImpl#getM_PartsArray <em>MParts Array</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIButtonArrayImpl#getM_liButtonNames <em>Mli Button Names</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIButtonArrayImpl#getM_liButtonValues <em>Mli Button Values</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CGIButtonArrayImpl extends GraphElementsTypeImpl implements CGIButtonArray {
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
	 * The cached value of the '{@link #getM_pModelObject() <em>MpModel Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_pModelObject()
	 * @generated
	 * @ordered
	 */
	protected IAttribute m_pModelObject;

	/**
	 * The cached value of the '{@link #getM_pParent() <em>MpParent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_pParent()
	 * @generated
	 * @ordered
	 */
	protected GraphElementsType m_pParent;

	/**
	 * The cached value of the '{@link #getM_transform() <em>Mtransform</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_transform()
	 * @generated
	 * @ordered
	 */
	protected EList<String> m_transform;

	/**
	 * The cached value of the '{@link #getM_polygon() <em>Mpolygon</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_polygon()
	 * @generated
	 * @ordered
	 */
	protected EList<String> m_polygon;

	/**
	 * The default value of the '{@link #getM_nNameFormat() <em>MnName Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_nNameFormat()
	 * @generated
	 * @ordered
	 */
	protected static final String MNNAME_FORMAT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_nNameFormat() <em>MnName Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_nNameFormat()
	 * @generated
	 * @ordered
	 */
	protected String m_nNameFormat = MNNAME_FORMAT_EDEFAULT;

	/**
	 * The default value of the '{@link #getM_nIsNameFormat() <em>MnIs Name Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_nIsNameFormat()
	 * @generated
	 * @ordered
	 */
	protected static final String MNIS_NAME_FORMAT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_nIsNameFormat() <em>MnIs Name Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_nIsNameFormat()
	 * @generated
	 * @ordered
	 */
	protected String m_nIsNameFormat = MNIS_NAME_FORMAT_EDEFAULT;

	/**
	 * The default value of the '{@link #getFrameset() <em>Frameset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFrameset()
	 * @generated
	 * @ordered
	 */
	protected static final String FRAMESET_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFrameset() <em>Frameset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFrameset()
	 * @generated
	 * @ordered
	 */
	protected String frameset = FRAMESET_EDEFAULT;

	/**
	 * The cached value of the '{@link #getCompartments() <em>Compartments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompartments()
	 * @generated
	 * @ordered
	 */
	protected EList<CGICompartment> compartments;

	/**
	 * The default value of the '{@link #getM_csModelObjPath() <em>Mcs Model Obj Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_csModelObjPath()
	 * @generated
	 * @ordered
	 */
	protected static final String MCS_MODEL_OBJ_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_csModelObjPath() <em>Mcs Model Obj Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_csModelObjPath()
	 * @generated
	 * @ordered
	 */
	protected String m_csModelObjPath = MCS_MODEL_OBJ_PATH_EDEFAULT;

	/**
	 * The default value of the '{@link #getM_csName() <em>Mcs Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_csName()
	 * @generated
	 * @ordered
	 */
	protected static final String MCS_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_csName() <em>Mcs Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_csName()
	 * @generated
	 * @ordered
	 */
	protected String m_csName = MCS_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getM_PartsArray() <em>MParts Array</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_PartsArray()
	 * @generated
	 * @ordered
	 */
	protected EList<DependsOnType> m_PartsArray;

	/**
	 * The cached value of the '{@link #getM_liButtonNames() <em>Mli Button Names</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_liButtonNames()
	 * @generated
	 * @ordered
	 */
	protected EList<String> m_liButtonNames;

	/**
	 * The cached value of the '{@link #getM_liButtonValues() <em>Mli Button Values</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_liButtonValues()
	 * @generated
	 * @ordered
	 */
	protected EList<String> m_liButtonValues;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CGIButtonArrayImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLRhapsodyPackage.eINSTANCE.getCGIButtonArray();
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
				NotificationChain msgs = oldProperties.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_BUTTON_ARRAY__PROPERTIES, null, null);
				if (newProperties.eInternalContainer() == null) {
					msgs = newProperties.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_BUTTON_ARRAY__PROPERTIES, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.CGI_BUTTON_ARRAY__PROPERTIES, oldProperties, properties));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_BUTTON_ARRAY__PROPERTIES, oldProperties, newProperties);
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
				msgs = ((InternalEObject)properties).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_BUTTON_ARRAY__PROPERTIES, null, msgs);
			if (newProperties != null)
				msgs = ((InternalEObject)newProperties).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_BUTTON_ARRAY__PROPERTIES, null, msgs);
			msgs = basicSetProperties(newProperties, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_BUTTON_ARRAY__PROPERTIES, newProperties, newProperties));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IAttribute getM_pModelObject() {
		if (m_pModelObject != null && m_pModelObject.eIsProxy()) {
			InternalEObject oldM_pModelObject = (InternalEObject)m_pModelObject;
			m_pModelObject = (IAttribute)eResolveProxy(oldM_pModelObject);
			if (m_pModelObject != oldM_pModelObject) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.CGI_BUTTON_ARRAY__MPMODEL_OBJECT, oldM_pModelObject, m_pModelObject));
			}
		}
		return m_pModelObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IAttribute basicGetM_pModelObject() {
		return m_pModelObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_pModelObject(IAttribute newM_pModelObject) {
		IAttribute oldM_pModelObject = m_pModelObject;
		m_pModelObject = newM_pModelObject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_BUTTON_ARRAY__MPMODEL_OBJECT, oldM_pModelObject, m_pModelObject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphElementsType getM_pParent() {
		if (m_pParent != null && m_pParent.eIsProxy()) {
			InternalEObject oldM_pParent = (InternalEObject)m_pParent;
			m_pParent = (GraphElementsType)eResolveProxy(oldM_pParent);
			if (m_pParent != oldM_pParent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.CGI_BUTTON_ARRAY__MPPARENT, oldM_pParent, m_pParent));
			}
		}
		return m_pParent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphElementsType basicGetM_pParent() {
		return m_pParent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_pParent(GraphElementsType newM_pParent) {
		GraphElementsType oldM_pParent = m_pParent;
		m_pParent = newM_pParent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_BUTTON_ARRAY__MPPARENT, oldM_pParent, m_pParent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getM_transform() {
		if (m_transform == null) {
			m_transform = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.CGI_BUTTON_ARRAY__MTRANSFORM);
		}
		return m_transform;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getM_polygon() {
		if (m_polygon == null) {
			m_polygon = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.CGI_BUTTON_ARRAY__MPOLYGON);
		}
		return m_polygon;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_nNameFormat() {
		return m_nNameFormat;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_nNameFormat(String newM_nNameFormat) {
		String oldM_nNameFormat = m_nNameFormat;
		m_nNameFormat = newM_nNameFormat;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_BUTTON_ARRAY__MNNAME_FORMAT, oldM_nNameFormat, m_nNameFormat));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_nIsNameFormat() {
		return m_nIsNameFormat;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_nIsNameFormat(String newM_nIsNameFormat) {
		String oldM_nIsNameFormat = m_nIsNameFormat;
		m_nIsNameFormat = newM_nIsNameFormat;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_BUTTON_ARRAY__MNIS_NAME_FORMAT, oldM_nIsNameFormat, m_nIsNameFormat));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFrameset() {
		return frameset;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFrameset(String newFrameset) {
		String oldFrameset = frameset;
		frameset = newFrameset;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_BUTTON_ARRAY__FRAMESET, oldFrameset, frameset));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CGICompartment> getCompartments() {
		if (compartments == null) {
			compartments = new EObjectContainmentEList.Resolving<CGICompartment>(CGICompartment.class, this, UMLRhapsodyPackage.CGI_BUTTON_ARRAY__COMPARTMENTS);
		}
		return compartments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_csModelObjPath() {
		return m_csModelObjPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_csModelObjPath(String newM_csModelObjPath) {
		String oldM_csModelObjPath = m_csModelObjPath;
		m_csModelObjPath = newM_csModelObjPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_BUTTON_ARRAY__MCS_MODEL_OBJ_PATH, oldM_csModelObjPath, m_csModelObjPath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_csName() {
		return m_csName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_csName(String newM_csName) {
		String oldM_csName = m_csName;
		m_csName = newM_csName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_BUTTON_ARRAY__MCS_NAME, oldM_csName, m_csName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DependsOnType> getM_PartsArray() {
		if (m_PartsArray == null) {
			m_PartsArray = new EObjectResolvingEList<DependsOnType>(DependsOnType.class, this, UMLRhapsodyPackage.CGI_BUTTON_ARRAY__MPARTS_ARRAY);
		}
		return m_PartsArray;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getM_liButtonNames() {
		if (m_liButtonNames == null) {
			m_liButtonNames = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.CGI_BUTTON_ARRAY__MLI_BUTTON_NAMES);
		}
		return m_liButtonNames;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getM_liButtonValues() {
		if (m_liButtonValues == null) {
			m_liButtonValues = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.CGI_BUTTON_ARRAY__MLI_BUTTON_VALUES);
		}
		return m_liButtonValues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLRhapsodyPackage.CGI_BUTTON_ARRAY__PROPERTIES:
				return basicSetProperties(null, msgs);
			case UMLRhapsodyPackage.CGI_BUTTON_ARRAY__COMPARTMENTS:
				return ((InternalEList<?>)getCompartments()).basicRemove(otherEnd, msgs);
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
			case UMLRhapsodyPackage.CGI_BUTTON_ARRAY__PROPERTIES:
				if (resolve) return getProperties();
				return basicGetProperties();
			case UMLRhapsodyPackage.CGI_BUTTON_ARRAY__MPMODEL_OBJECT:
				if (resolve) return getM_pModelObject();
				return basicGetM_pModelObject();
			case UMLRhapsodyPackage.CGI_BUTTON_ARRAY__MPPARENT:
				if (resolve) return getM_pParent();
				return basicGetM_pParent();
			case UMLRhapsodyPackage.CGI_BUTTON_ARRAY__MTRANSFORM:
				return getM_transform();
			case UMLRhapsodyPackage.CGI_BUTTON_ARRAY__MPOLYGON:
				return getM_polygon();
			case UMLRhapsodyPackage.CGI_BUTTON_ARRAY__MNNAME_FORMAT:
				return getM_nNameFormat();
			case UMLRhapsodyPackage.CGI_BUTTON_ARRAY__MNIS_NAME_FORMAT:
				return getM_nIsNameFormat();
			case UMLRhapsodyPackage.CGI_BUTTON_ARRAY__FRAMESET:
				return getFrameset();
			case UMLRhapsodyPackage.CGI_BUTTON_ARRAY__COMPARTMENTS:
				return getCompartments();
			case UMLRhapsodyPackage.CGI_BUTTON_ARRAY__MCS_MODEL_OBJ_PATH:
				return getM_csModelObjPath();
			case UMLRhapsodyPackage.CGI_BUTTON_ARRAY__MCS_NAME:
				return getM_csName();
			case UMLRhapsodyPackage.CGI_BUTTON_ARRAY__MPARTS_ARRAY:
				return getM_PartsArray();
			case UMLRhapsodyPackage.CGI_BUTTON_ARRAY__MLI_BUTTON_NAMES:
				return getM_liButtonNames();
			case UMLRhapsodyPackage.CGI_BUTTON_ARRAY__MLI_BUTTON_VALUES:
				return getM_liButtonValues();
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
			case UMLRhapsodyPackage.CGI_BUTTON_ARRAY__PROPERTIES:
				setProperties((IPropertyContainer)newValue);
				return;
			case UMLRhapsodyPackage.CGI_BUTTON_ARRAY__MPMODEL_OBJECT:
				setM_pModelObject((IAttribute)newValue);
				return;
			case UMLRhapsodyPackage.CGI_BUTTON_ARRAY__MPPARENT:
				setM_pParent((GraphElementsType)newValue);
				return;
			case UMLRhapsodyPackage.CGI_BUTTON_ARRAY__MTRANSFORM:
				getM_transform().clear();
				getM_transform().addAll((Collection<? extends String>)newValue);
				return;
			case UMLRhapsodyPackage.CGI_BUTTON_ARRAY__MPOLYGON:
				getM_polygon().clear();
				getM_polygon().addAll((Collection<? extends String>)newValue);
				return;
			case UMLRhapsodyPackage.CGI_BUTTON_ARRAY__MNNAME_FORMAT:
				setM_nNameFormat((String)newValue);
				return;
			case UMLRhapsodyPackage.CGI_BUTTON_ARRAY__MNIS_NAME_FORMAT:
				setM_nIsNameFormat((String)newValue);
				return;
			case UMLRhapsodyPackage.CGI_BUTTON_ARRAY__FRAMESET:
				setFrameset((String)newValue);
				return;
			case UMLRhapsodyPackage.CGI_BUTTON_ARRAY__COMPARTMENTS:
				getCompartments().clear();
				getCompartments().addAll((Collection<? extends CGICompartment>)newValue);
				return;
			case UMLRhapsodyPackage.CGI_BUTTON_ARRAY__MCS_MODEL_OBJ_PATH:
				setM_csModelObjPath((String)newValue);
				return;
			case UMLRhapsodyPackage.CGI_BUTTON_ARRAY__MCS_NAME:
				setM_csName((String)newValue);
				return;
			case UMLRhapsodyPackage.CGI_BUTTON_ARRAY__MPARTS_ARRAY:
				getM_PartsArray().clear();
				getM_PartsArray().addAll((Collection<? extends DependsOnType>)newValue);
				return;
			case UMLRhapsodyPackage.CGI_BUTTON_ARRAY__MLI_BUTTON_NAMES:
				getM_liButtonNames().clear();
				getM_liButtonNames().addAll((Collection<? extends String>)newValue);
				return;
			case UMLRhapsodyPackage.CGI_BUTTON_ARRAY__MLI_BUTTON_VALUES:
				getM_liButtonValues().clear();
				getM_liButtonValues().addAll((Collection<? extends String>)newValue);
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
			case UMLRhapsodyPackage.CGI_BUTTON_ARRAY__PROPERTIES:
				setProperties((IPropertyContainer)null);
				return;
			case UMLRhapsodyPackage.CGI_BUTTON_ARRAY__MPMODEL_OBJECT:
				setM_pModelObject((IAttribute)null);
				return;
			case UMLRhapsodyPackage.CGI_BUTTON_ARRAY__MPPARENT:
				setM_pParent((GraphElementsType)null);
				return;
			case UMLRhapsodyPackage.CGI_BUTTON_ARRAY__MTRANSFORM:
				getM_transform().clear();
				return;
			case UMLRhapsodyPackage.CGI_BUTTON_ARRAY__MPOLYGON:
				getM_polygon().clear();
				return;
			case UMLRhapsodyPackage.CGI_BUTTON_ARRAY__MNNAME_FORMAT:
				setM_nNameFormat(MNNAME_FORMAT_EDEFAULT);
				return;
			case UMLRhapsodyPackage.CGI_BUTTON_ARRAY__MNIS_NAME_FORMAT:
				setM_nIsNameFormat(MNIS_NAME_FORMAT_EDEFAULT);
				return;
			case UMLRhapsodyPackage.CGI_BUTTON_ARRAY__FRAMESET:
				setFrameset(FRAMESET_EDEFAULT);
				return;
			case UMLRhapsodyPackage.CGI_BUTTON_ARRAY__COMPARTMENTS:
				getCompartments().clear();
				return;
			case UMLRhapsodyPackage.CGI_BUTTON_ARRAY__MCS_MODEL_OBJ_PATH:
				setM_csModelObjPath(MCS_MODEL_OBJ_PATH_EDEFAULT);
				return;
			case UMLRhapsodyPackage.CGI_BUTTON_ARRAY__MCS_NAME:
				setM_csName(MCS_NAME_EDEFAULT);
				return;
			case UMLRhapsodyPackage.CGI_BUTTON_ARRAY__MPARTS_ARRAY:
				getM_PartsArray().clear();
				return;
			case UMLRhapsodyPackage.CGI_BUTTON_ARRAY__MLI_BUTTON_NAMES:
				getM_liButtonNames().clear();
				return;
			case UMLRhapsodyPackage.CGI_BUTTON_ARRAY__MLI_BUTTON_VALUES:
				getM_liButtonValues().clear();
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
			case UMLRhapsodyPackage.CGI_BUTTON_ARRAY__PROPERTIES:
				return properties != null;
			case UMLRhapsodyPackage.CGI_BUTTON_ARRAY__MPMODEL_OBJECT:
				return m_pModelObject != null;
			case UMLRhapsodyPackage.CGI_BUTTON_ARRAY__MPPARENT:
				return m_pParent != null;
			case UMLRhapsodyPackage.CGI_BUTTON_ARRAY__MTRANSFORM:
				return m_transform != null && !m_transform.isEmpty();
			case UMLRhapsodyPackage.CGI_BUTTON_ARRAY__MPOLYGON:
				return m_polygon != null && !m_polygon.isEmpty();
			case UMLRhapsodyPackage.CGI_BUTTON_ARRAY__MNNAME_FORMAT:
				return MNNAME_FORMAT_EDEFAULT == null ? m_nNameFormat != null : !MNNAME_FORMAT_EDEFAULT.equals(m_nNameFormat);
			case UMLRhapsodyPackage.CGI_BUTTON_ARRAY__MNIS_NAME_FORMAT:
				return MNIS_NAME_FORMAT_EDEFAULT == null ? m_nIsNameFormat != null : !MNIS_NAME_FORMAT_EDEFAULT.equals(m_nIsNameFormat);
			case UMLRhapsodyPackage.CGI_BUTTON_ARRAY__FRAMESET:
				return FRAMESET_EDEFAULT == null ? frameset != null : !FRAMESET_EDEFAULT.equals(frameset);
			case UMLRhapsodyPackage.CGI_BUTTON_ARRAY__COMPARTMENTS:
				return compartments != null && !compartments.isEmpty();
			case UMLRhapsodyPackage.CGI_BUTTON_ARRAY__MCS_MODEL_OBJ_PATH:
				return MCS_MODEL_OBJ_PATH_EDEFAULT == null ? m_csModelObjPath != null : !MCS_MODEL_OBJ_PATH_EDEFAULT.equals(m_csModelObjPath);
			case UMLRhapsodyPackage.CGI_BUTTON_ARRAY__MCS_NAME:
				return MCS_NAME_EDEFAULT == null ? m_csName != null : !MCS_NAME_EDEFAULT.equals(m_csName);
			case UMLRhapsodyPackage.CGI_BUTTON_ARRAY__MPARTS_ARRAY:
				return m_PartsArray != null && !m_PartsArray.isEmpty();
			case UMLRhapsodyPackage.CGI_BUTTON_ARRAY__MLI_BUTTON_NAMES:
				return m_liButtonNames != null && !m_liButtonNames.isEmpty();
			case UMLRhapsodyPackage.CGI_BUTTON_ARRAY__MLI_BUTTON_VALUES:
				return m_liButtonValues != null && !m_liButtonValues.isEmpty();
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
		result.append(" (m_transform: "); //$NON-NLS-1$
		result.append(m_transform);
		result.append(", m_polygon: "); //$NON-NLS-1$
		result.append(m_polygon);
		result.append(", m_nNameFormat: "); //$NON-NLS-1$
		result.append(m_nNameFormat);
		result.append(", m_nIsNameFormat: "); //$NON-NLS-1$
		result.append(m_nIsNameFormat);
		result.append(", frameset: "); //$NON-NLS-1$
		result.append(frameset);
		result.append(", m_csModelObjPath: "); //$NON-NLS-1$
		result.append(m_csModelObjPath);
		result.append(", m_csName: "); //$NON-NLS-1$
		result.append(m_csName);
		result.append(", m_liButtonNames: "); //$NON-NLS-1$
		result.append(m_liButtonNames);
		result.append(", m_liButtonValues: "); //$NON-NLS-1$
		result.append(m_liButtonValues);
		result.append(')');
		return result.toString();
	}

} //CGIButtonArrayImpl
