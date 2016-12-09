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
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIText;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.GraphElementsType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.GraphicChartType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Graphic Chart Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.GraphicChartTypeImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.GraphicChartTypeImpl#getM_access <em>Maccess</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.GraphicChartTypeImpl#getElementList <em>Element List</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.GraphicChartTypeImpl#getM_nModifyDate <em>MnModify Date</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.GraphicChartTypeImpl#getM_currentLeftTop <em>Mcurrent Left Top</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.GraphicChartTypeImpl#getM_modified <em>Mmodified</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.GraphicChartTypeImpl#getM_nCreateDate <em>MnCreate Date</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.GraphicChartTypeImpl#getM_pParent <em>MpParent</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.GraphicChartTypeImpl#getM_arrowStyle <em>Marrow Style</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.GraphicChartTypeImpl#getM_drawBehavior <em>Mdraw Behavior</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.GraphicChartTypeImpl#getM_currentRightBottom <em>Mcurrent Right Bottom</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.GraphicChartTypeImpl#getM_creator <em>Mcreator</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.GraphicChartTypeImpl#getM_bScaleWithZoom <em>MbScale With Zoom</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.GraphicChartTypeImpl#getM_type <em>Mtype</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.GraphicChartTypeImpl#getGraphElements <em>Graph Elements</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.GraphicChartTypeImpl#getM_name <em>Mname</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.GraphicChartTypeImpl#getM_fileVersion <em>Mfile Version</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.GraphicChartTypeImpl#getM_bIsPreferencesInitialized <em>MbIs Preferences Initialized</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class GraphicChartTypeImpl extends MinimalEObjectImpl.Container implements GraphicChartType {
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
	 * The default value of the '{@link #getM_access() <em>Maccess</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_access()
	 * @generated
	 * @ordered
	 */
	protected static final String MACCESS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_access() <em>Maccess</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_access()
	 * @generated
	 * @ordered
	 */
	protected String m_access = MACCESS_EDEFAULT;

	/**
	 * The default value of the '{@link #getElementList() <em>Element List</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElementList()
	 * @generated
	 * @ordered
	 */
	protected static final String ELEMENT_LIST_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getElementList() <em>Element List</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElementList()
	 * @generated
	 * @ordered
	 */
	protected String elementList = ELEMENT_LIST_EDEFAULT;

	/**
	 * The default value of the '{@link #getM_nModifyDate() <em>MnModify Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_nModifyDate()
	 * @generated
	 * @ordered
	 */
	protected static final String MNMODIFY_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_nModifyDate() <em>MnModify Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_nModifyDate()
	 * @generated
	 * @ordered
	 */
	protected String m_nModifyDate = MNMODIFY_DATE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getM_currentLeftTop() <em>Mcurrent Left Top</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_currentLeftTop()
	 * @generated
	 * @ordered
	 */
	protected EList<String> m_currentLeftTop;

	/**
	 * The default value of the '{@link #getM_modified() <em>Mmodified</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_modified()
	 * @generated
	 * @ordered
	 */
	protected static final String MMODIFIED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_modified() <em>Mmodified</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_modified()
	 * @generated
	 * @ordered
	 */
	protected String m_modified = MMODIFIED_EDEFAULT;

	/**
	 * The default value of the '{@link #getM_nCreateDate() <em>MnCreate Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_nCreateDate()
	 * @generated
	 * @ordered
	 */
	protected static final String MNCREATE_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_nCreateDate() <em>MnCreate Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_nCreateDate()
	 * @generated
	 * @ordered
	 */
	protected String m_nCreateDate = MNCREATE_DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getM_pParent() <em>MpParent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_pParent()
	 * @generated
	 * @ordered
	 */
	protected static final String MPPARENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_pParent() <em>MpParent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_pParent()
	 * @generated
	 * @ordered
	 */
	protected String m_pParent = MPPARENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getM_arrowStyle() <em>Marrow Style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_arrowStyle()
	 * @generated
	 * @ordered
	 */
	protected static final String MARROW_STYLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_arrowStyle() <em>Marrow Style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_arrowStyle()
	 * @generated
	 * @ordered
	 */
	protected String m_arrowStyle = MARROW_STYLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getM_drawBehavior() <em>Mdraw Behavior</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_drawBehavior()
	 * @generated
	 * @ordered
	 */
	protected static final String MDRAW_BEHAVIOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_drawBehavior() <em>Mdraw Behavior</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_drawBehavior()
	 * @generated
	 * @ordered
	 */
	protected String m_drawBehavior = MDRAW_BEHAVIOR_EDEFAULT;

	/**
	 * The cached value of the '{@link #getM_currentRightBottom() <em>Mcurrent Right Bottom</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_currentRightBottom()
	 * @generated
	 * @ordered
	 */
	protected EList<String> m_currentRightBottom;

	/**
	 * The default value of the '{@link #getM_creator() <em>Mcreator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_creator()
	 * @generated
	 * @ordered
	 */
	protected static final String MCREATOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_creator() <em>Mcreator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_creator()
	 * @generated
	 * @ordered
	 */
	protected String m_creator = MCREATOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getM_bScaleWithZoom() <em>MbScale With Zoom</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_bScaleWithZoom()
	 * @generated
	 * @ordered
	 */
	protected static final String MBSCALE_WITH_ZOOM_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_bScaleWithZoom() <em>MbScale With Zoom</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_bScaleWithZoom()
	 * @generated
	 * @ordered
	 */
	protected String m_bScaleWithZoom = MBSCALE_WITH_ZOOM_EDEFAULT;

	/**
	 * The default value of the '{@link #getM_type() <em>Mtype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_type()
	 * @generated
	 * @ordered
	 */
	protected static final String MTYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_type() <em>Mtype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_type()
	 * @generated
	 * @ordered
	 */
	protected String m_type = MTYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getGraphElements() <em>Graph Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGraphElements()
	 * @generated
	 * @ordered
	 */
	protected EList<GraphElementsType> graphElements;

	/**
	 * The cached value of the '{@link #getM_name() <em>Mname</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_name()
	 * @generated
	 * @ordered
	 */
	protected CGIText m_name;

	/**
	 * The default value of the '{@link #getM_fileVersion() <em>Mfile Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_fileVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String MFILE_VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_fileVersion() <em>Mfile Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_fileVersion()
	 * @generated
	 * @ordered
	 */
	protected String m_fileVersion = MFILE_VERSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getM_bIsPreferencesInitialized() <em>MbIs Preferences Initialized</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_bIsPreferencesInitialized()
	 * @generated
	 * @ordered
	 */
	protected static final String MBIS_PREFERENCES_INITIALIZED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_bIsPreferencesInitialized() <em>MbIs Preferences Initialized</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_bIsPreferencesInitialized()
	 * @generated
	 * @ordered
	 */
	protected String m_bIsPreferencesInitialized = MBIS_PREFERENCES_INITIALIZED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GraphicChartTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLRhapsodyPackage.eINSTANCE.getGraphicChartType();
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_access() {
		return m_access;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_access(String newM_access) {
		String oldM_access = m_access;
		m_access = newM_access;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__MACCESS, oldM_access, m_access));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getElementList() {
		return elementList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElementList(String newElementList) {
		String oldElementList = elementList;
		elementList = newElementList;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__ELEMENT_LIST, oldElementList, elementList));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_nModifyDate() {
		return m_nModifyDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_nModifyDate(String newM_nModifyDate) {
		String oldM_nModifyDate = m_nModifyDate;
		m_nModifyDate = newM_nModifyDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__MNMODIFY_DATE, oldM_nModifyDate, m_nModifyDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getM_currentLeftTop() {
		if (m_currentLeftTop == null) {
			m_currentLeftTop = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__MCURRENT_LEFT_TOP);
		}
		return m_currentLeftTop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_modified() {
		return m_modified;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_modified(String newM_modified) {
		String oldM_modified = m_modified;
		m_modified = newM_modified;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__MMODIFIED, oldM_modified, m_modified));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_nCreateDate() {
		return m_nCreateDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_nCreateDate(String newM_nCreateDate) {
		String oldM_nCreateDate = m_nCreateDate;
		m_nCreateDate = newM_nCreateDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__MNCREATE_DATE, oldM_nCreateDate, m_nCreateDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_pParent() {
		return m_pParent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_pParent(String newM_pParent) {
		String oldM_pParent = m_pParent;
		m_pParent = newM_pParent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__MPPARENT, oldM_pParent, m_pParent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_arrowStyle() {
		return m_arrowStyle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_arrowStyle(String newM_arrowStyle) {
		String oldM_arrowStyle = m_arrowStyle;
		m_arrowStyle = newM_arrowStyle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__MARROW_STYLE, oldM_arrowStyle, m_arrowStyle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_drawBehavior() {
		return m_drawBehavior;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_drawBehavior(String newM_drawBehavior) {
		String oldM_drawBehavior = m_drawBehavior;
		m_drawBehavior = newM_drawBehavior;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__MDRAW_BEHAVIOR, oldM_drawBehavior, m_drawBehavior));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getM_currentRightBottom() {
		if (m_currentRightBottom == null) {
			m_currentRightBottom = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__MCURRENT_RIGHT_BOTTOM);
		}
		return m_currentRightBottom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_creator() {
		return m_creator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_creator(String newM_creator) {
		String oldM_creator = m_creator;
		m_creator = newM_creator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__MCREATOR, oldM_creator, m_creator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_bScaleWithZoom() {
		return m_bScaleWithZoom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_bScaleWithZoom(String newM_bScaleWithZoom) {
		String oldM_bScaleWithZoom = m_bScaleWithZoom;
		m_bScaleWithZoom = newM_bScaleWithZoom;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__MBSCALE_WITH_ZOOM, oldM_bScaleWithZoom, m_bScaleWithZoom));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_type() {
		return m_type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_type(String newM_type) {
		String oldM_type = m_type;
		m_type = newM_type;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__MTYPE, oldM_type, m_type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<GraphElementsType> getGraphElements() {
		if (graphElements == null) {
			graphElements = new EObjectContainmentEList.Resolving<GraphElementsType>(GraphElementsType.class, this, UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__GRAPH_ELEMENTS);
		}
		return graphElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGIText getM_name() {
		if (m_name != null && m_name.eIsProxy()) {
			InternalEObject oldM_name = (InternalEObject)m_name;
			m_name = (CGIText)eResolveProxy(oldM_name);
			if (m_name != oldM_name) {
				InternalEObject newM_name = (InternalEObject)m_name;
				NotificationChain msgs = oldM_name.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__MNAME, null, null);
				if (newM_name.eInternalContainer() == null) {
					msgs = newM_name.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__MNAME, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__MNAME, oldM_name, m_name));
			}
		}
		return m_name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGIText basicGetM_name() {
		return m_name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetM_name(CGIText newM_name, NotificationChain msgs) {
		CGIText oldM_name = m_name;
		m_name = newM_name;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__MNAME, oldM_name, newM_name);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_name(CGIText newM_name) {
		if (newM_name != m_name) {
			NotificationChain msgs = null;
			if (m_name != null)
				msgs = ((InternalEObject)m_name).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__MNAME, null, msgs);
			if (newM_name != null)
				msgs = ((InternalEObject)newM_name).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__MNAME, null, msgs);
			msgs = basicSetM_name(newM_name, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__MNAME, newM_name, newM_name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_fileVersion() {
		return m_fileVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_fileVersion(String newM_fileVersion) {
		String oldM_fileVersion = m_fileVersion;
		m_fileVersion = newM_fileVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__MFILE_VERSION, oldM_fileVersion, m_fileVersion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_bIsPreferencesInitialized() {
		return m_bIsPreferencesInitialized;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_bIsPreferencesInitialized(String newM_bIsPreferencesInitialized) {
		String oldM_bIsPreferencesInitialized = m_bIsPreferencesInitialized;
		m_bIsPreferencesInitialized = newM_bIsPreferencesInitialized;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__MBIS_PREFERENCES_INITIALIZED, oldM_bIsPreferencesInitialized, m_bIsPreferencesInitialized));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__GRAPH_ELEMENTS:
				return ((InternalEList<?>)getGraphElements()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__MNAME:
				return basicSetM_name(null, msgs);
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
			case UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__ID:
				return getId();
			case UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__MACCESS:
				return getM_access();
			case UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__ELEMENT_LIST:
				return getElementList();
			case UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__MNMODIFY_DATE:
				return getM_nModifyDate();
			case UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__MCURRENT_LEFT_TOP:
				return getM_currentLeftTop();
			case UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__MMODIFIED:
				return getM_modified();
			case UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__MNCREATE_DATE:
				return getM_nCreateDate();
			case UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__MPPARENT:
				return getM_pParent();
			case UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__MARROW_STYLE:
				return getM_arrowStyle();
			case UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__MDRAW_BEHAVIOR:
				return getM_drawBehavior();
			case UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__MCURRENT_RIGHT_BOTTOM:
				return getM_currentRightBottom();
			case UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__MCREATOR:
				return getM_creator();
			case UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__MBSCALE_WITH_ZOOM:
				return getM_bScaleWithZoom();
			case UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__MTYPE:
				return getM_type();
			case UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__GRAPH_ELEMENTS:
				return getGraphElements();
			case UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__MNAME:
				if (resolve) return getM_name();
				return basicGetM_name();
			case UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__MFILE_VERSION:
				return getM_fileVersion();
			case UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__MBIS_PREFERENCES_INITIALIZED:
				return getM_bIsPreferencesInitialized();
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
			case UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__ID:
				setId((String)newValue);
				return;
			case UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__MACCESS:
				setM_access((String)newValue);
				return;
			case UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__ELEMENT_LIST:
				setElementList((String)newValue);
				return;
			case UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__MNMODIFY_DATE:
				setM_nModifyDate((String)newValue);
				return;
			case UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__MCURRENT_LEFT_TOP:
				getM_currentLeftTop().clear();
				getM_currentLeftTop().addAll((Collection<? extends String>)newValue);
				return;
			case UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__MMODIFIED:
				setM_modified((String)newValue);
				return;
			case UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__MNCREATE_DATE:
				setM_nCreateDate((String)newValue);
				return;
			case UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__MPPARENT:
				setM_pParent((String)newValue);
				return;
			case UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__MARROW_STYLE:
				setM_arrowStyle((String)newValue);
				return;
			case UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__MDRAW_BEHAVIOR:
				setM_drawBehavior((String)newValue);
				return;
			case UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__MCURRENT_RIGHT_BOTTOM:
				getM_currentRightBottom().clear();
				getM_currentRightBottom().addAll((Collection<? extends String>)newValue);
				return;
			case UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__MCREATOR:
				setM_creator((String)newValue);
				return;
			case UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__MBSCALE_WITH_ZOOM:
				setM_bScaleWithZoom((String)newValue);
				return;
			case UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__MTYPE:
				setM_type((String)newValue);
				return;
			case UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__GRAPH_ELEMENTS:
				getGraphElements().clear();
				getGraphElements().addAll((Collection<? extends GraphElementsType>)newValue);
				return;
			case UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__MNAME:
				setM_name((CGIText)newValue);
				return;
			case UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__MFILE_VERSION:
				setM_fileVersion((String)newValue);
				return;
			case UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__MBIS_PREFERENCES_INITIALIZED:
				setM_bIsPreferencesInitialized((String)newValue);
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
			case UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__ID:
				setId(ID_EDEFAULT);
				return;
			case UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__MACCESS:
				setM_access(MACCESS_EDEFAULT);
				return;
			case UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__ELEMENT_LIST:
				setElementList(ELEMENT_LIST_EDEFAULT);
				return;
			case UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__MNMODIFY_DATE:
				setM_nModifyDate(MNMODIFY_DATE_EDEFAULT);
				return;
			case UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__MCURRENT_LEFT_TOP:
				getM_currentLeftTop().clear();
				return;
			case UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__MMODIFIED:
				setM_modified(MMODIFIED_EDEFAULT);
				return;
			case UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__MNCREATE_DATE:
				setM_nCreateDate(MNCREATE_DATE_EDEFAULT);
				return;
			case UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__MPPARENT:
				setM_pParent(MPPARENT_EDEFAULT);
				return;
			case UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__MARROW_STYLE:
				setM_arrowStyle(MARROW_STYLE_EDEFAULT);
				return;
			case UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__MDRAW_BEHAVIOR:
				setM_drawBehavior(MDRAW_BEHAVIOR_EDEFAULT);
				return;
			case UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__MCURRENT_RIGHT_BOTTOM:
				getM_currentRightBottom().clear();
				return;
			case UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__MCREATOR:
				setM_creator(MCREATOR_EDEFAULT);
				return;
			case UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__MBSCALE_WITH_ZOOM:
				setM_bScaleWithZoom(MBSCALE_WITH_ZOOM_EDEFAULT);
				return;
			case UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__MTYPE:
				setM_type(MTYPE_EDEFAULT);
				return;
			case UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__GRAPH_ELEMENTS:
				getGraphElements().clear();
				return;
			case UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__MNAME:
				setM_name((CGIText)null);
				return;
			case UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__MFILE_VERSION:
				setM_fileVersion(MFILE_VERSION_EDEFAULT);
				return;
			case UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__MBIS_PREFERENCES_INITIALIZED:
				setM_bIsPreferencesInitialized(MBIS_PREFERENCES_INITIALIZED_EDEFAULT);
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
			case UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__MACCESS:
				return MACCESS_EDEFAULT == null ? m_access != null : !MACCESS_EDEFAULT.equals(m_access);
			case UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__ELEMENT_LIST:
				return ELEMENT_LIST_EDEFAULT == null ? elementList != null : !ELEMENT_LIST_EDEFAULT.equals(elementList);
			case UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__MNMODIFY_DATE:
				return MNMODIFY_DATE_EDEFAULT == null ? m_nModifyDate != null : !MNMODIFY_DATE_EDEFAULT.equals(m_nModifyDate);
			case UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__MCURRENT_LEFT_TOP:
				return m_currentLeftTop != null && !m_currentLeftTop.isEmpty();
			case UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__MMODIFIED:
				return MMODIFIED_EDEFAULT == null ? m_modified != null : !MMODIFIED_EDEFAULT.equals(m_modified);
			case UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__MNCREATE_DATE:
				return MNCREATE_DATE_EDEFAULT == null ? m_nCreateDate != null : !MNCREATE_DATE_EDEFAULT.equals(m_nCreateDate);
			case UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__MPPARENT:
				return MPPARENT_EDEFAULT == null ? m_pParent != null : !MPPARENT_EDEFAULT.equals(m_pParent);
			case UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__MARROW_STYLE:
				return MARROW_STYLE_EDEFAULT == null ? m_arrowStyle != null : !MARROW_STYLE_EDEFAULT.equals(m_arrowStyle);
			case UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__MDRAW_BEHAVIOR:
				return MDRAW_BEHAVIOR_EDEFAULT == null ? m_drawBehavior != null : !MDRAW_BEHAVIOR_EDEFAULT.equals(m_drawBehavior);
			case UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__MCURRENT_RIGHT_BOTTOM:
				return m_currentRightBottom != null && !m_currentRightBottom.isEmpty();
			case UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__MCREATOR:
				return MCREATOR_EDEFAULT == null ? m_creator != null : !MCREATOR_EDEFAULT.equals(m_creator);
			case UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__MBSCALE_WITH_ZOOM:
				return MBSCALE_WITH_ZOOM_EDEFAULT == null ? m_bScaleWithZoom != null : !MBSCALE_WITH_ZOOM_EDEFAULT.equals(m_bScaleWithZoom);
			case UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__MTYPE:
				return MTYPE_EDEFAULT == null ? m_type != null : !MTYPE_EDEFAULT.equals(m_type);
			case UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__GRAPH_ELEMENTS:
				return graphElements != null && !graphElements.isEmpty();
			case UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__MNAME:
				return m_name != null;
			case UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__MFILE_VERSION:
				return MFILE_VERSION_EDEFAULT == null ? m_fileVersion != null : !MFILE_VERSION_EDEFAULT.equals(m_fileVersion);
			case UMLRhapsodyPackage.GRAPHIC_CHART_TYPE__MBIS_PREFERENCES_INITIALIZED:
				return MBIS_PREFERENCES_INITIALIZED_EDEFAULT == null ? m_bIsPreferencesInitialized != null : !MBIS_PREFERENCES_INITIALIZED_EDEFAULT.equals(m_bIsPreferencesInitialized);
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
		result.append(", m_access: "); //$NON-NLS-1$
		result.append(m_access);
		result.append(", elementList: "); //$NON-NLS-1$
		result.append(elementList);
		result.append(", m_nModifyDate: "); //$NON-NLS-1$
		result.append(m_nModifyDate);
		result.append(", m_currentLeftTop: "); //$NON-NLS-1$
		result.append(m_currentLeftTop);
		result.append(", m_modified: "); //$NON-NLS-1$
		result.append(m_modified);
		result.append(", m_nCreateDate: "); //$NON-NLS-1$
		result.append(m_nCreateDate);
		result.append(", m_pParent: "); //$NON-NLS-1$
		result.append(m_pParent);
		result.append(", m_arrowStyle: "); //$NON-NLS-1$
		result.append(m_arrowStyle);
		result.append(", m_drawBehavior: "); //$NON-NLS-1$
		result.append(m_drawBehavior);
		result.append(", m_currentRightBottom: "); //$NON-NLS-1$
		result.append(m_currentRightBottom);
		result.append(", m_creator: "); //$NON-NLS-1$
		result.append(m_creator);
		result.append(", m_bScaleWithZoom: "); //$NON-NLS-1$
		result.append(m_bScaleWithZoom);
		result.append(", m_type: "); //$NON-NLS-1$
		result.append(m_type);
		result.append(", m_fileVersion: "); //$NON-NLS-1$
		result.append(m_fileVersion);
		result.append(", m_bIsPreferencesInitialized: "); //$NON-NLS-1$
		result.append(m_bIsPreferencesInitialized);
		result.append(')');
		return result.toString();
	}

} //GraphicChartTypeImpl
