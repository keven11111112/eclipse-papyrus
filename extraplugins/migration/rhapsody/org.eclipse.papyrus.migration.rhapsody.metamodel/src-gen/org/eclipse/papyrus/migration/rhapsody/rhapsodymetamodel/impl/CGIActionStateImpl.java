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
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIActionState;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIText;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.GraphElementsType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IPropertyContainer;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IStateVertex;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UnknownType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CGI Action State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIActionStateImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIActionStateImpl#getM_pModelObject <em>MpModel Object</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIActionStateImpl#getM_pParent <em>MpParent</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIActionStateImpl#getM_transform <em>Mtransform</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIActionStateImpl#getM_AdditionalLabel <em>MAdditional Label</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIActionStateImpl#getM_polygon <em>Mpolygon</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIActionStateImpl#getM_nNameFormat <em>MnName Format</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIActionStateImpl#getM_nIsNameFormat <em>MnIs Name Format</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIActionStateImpl#getCompartments <em>Compartments</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIActionStateImpl#getNAndLineCount <em>NAnd Line Count</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIActionStateImpl#getM_pInheritsFrom <em>MpInherits From</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIActionStateImpl#getM_nInheritanceMask <em>MnInheritance Mask</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIActionStateImpl#getM_pDefaultComponentRelation <em>MpDefault Component Relation</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIActionStateImpl#getM_NameDisplayMode <em>MName Display Mode</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIActionStateImpl#getM_ActDescLablDiaplayMode <em>MAct Desc Labl Diaplay Mode</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIActionStateImpl#getM_moveAndLineTimeStamp <em>Mmove And Line Time Stamp</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CGIActionStateImpl extends GraphElementsTypeImpl implements CGIActionState {
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
	protected IStateVertex m_pModelObject;

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
	 * The cached value of the '{@link #getM_AdditionalLabel() <em>MAdditional Label</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_AdditionalLabel()
	 * @generated
	 * @ordered
	 */
	protected CGIText m_AdditionalLabel;

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
	 * The cached value of the '{@link #getCompartments() <em>Compartments</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompartments()
	 * @generated
	 * @ordered
	 */
	protected EList<UnknownType> compartments;

	/**
	 * The default value of the '{@link #getNAndLineCount() <em>NAnd Line Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNAndLineCount()
	 * @generated
	 * @ordered
	 */
	protected static final String NAND_LINE_COUNT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNAndLineCount() <em>NAnd Line Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNAndLineCount()
	 * @generated
	 * @ordered
	 */
	protected String nAndLineCount = NAND_LINE_COUNT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getM_pInheritsFrom() <em>MpInherits From</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_pInheritsFrom()
	 * @generated
	 * @ordered
	 */
	protected EList<UnknownType> m_pInheritsFrom;

	/**
	 * The default value of the '{@link #getM_nInheritanceMask() <em>MnInheritance Mask</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_nInheritanceMask()
	 * @generated
	 * @ordered
	 */
	protected static final String MNINHERITANCE_MASK_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_nInheritanceMask() <em>MnInheritance Mask</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_nInheritanceMask()
	 * @generated
	 * @ordered
	 */
	protected String m_nInheritanceMask = MNINHERITANCE_MASK_EDEFAULT;

	/**
	 * The default value of the '{@link #getM_pDefaultComponentRelation() <em>MpDefault Component Relation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_pDefaultComponentRelation()
	 * @generated
	 * @ordered
	 */
	protected static final String MPDEFAULT_COMPONENT_RELATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_pDefaultComponentRelation() <em>MpDefault Component Relation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_pDefaultComponentRelation()
	 * @generated
	 * @ordered
	 */
	protected String m_pDefaultComponentRelation = MPDEFAULT_COMPONENT_RELATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getM_NameDisplayMode() <em>MName Display Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_NameDisplayMode()
	 * @generated
	 * @ordered
	 */
	protected static final String MNAME_DISPLAY_MODE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_NameDisplayMode() <em>MName Display Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_NameDisplayMode()
	 * @generated
	 * @ordered
	 */
	protected String m_NameDisplayMode = MNAME_DISPLAY_MODE_EDEFAULT;

	/**
	 * The default value of the '{@link #getM_ActDescLablDiaplayMode() <em>MAct Desc Labl Diaplay Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_ActDescLablDiaplayMode()
	 * @generated
	 * @ordered
	 */
	protected static final String MACT_DESC_LABL_DIAPLAY_MODE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_ActDescLablDiaplayMode() <em>MAct Desc Labl Diaplay Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_ActDescLablDiaplayMode()
	 * @generated
	 * @ordered
	 */
	protected String m_ActDescLablDiaplayMode = MACT_DESC_LABL_DIAPLAY_MODE_EDEFAULT;

	/**
	 * The default value of the '{@link #getM_moveAndLineTimeStamp() <em>Mmove And Line Time Stamp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_moveAndLineTimeStamp()
	 * @generated
	 * @ordered
	 */
	protected static final String MMOVE_AND_LINE_TIME_STAMP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_moveAndLineTimeStamp() <em>Mmove And Line Time Stamp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_moveAndLineTimeStamp()
	 * @generated
	 * @ordered
	 */
	protected String m_moveAndLineTimeStamp = MMOVE_AND_LINE_TIME_STAMP_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CGIActionStateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLRhapsodyPackage.eINSTANCE.getCGIActionState();
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
				NotificationChain msgs = oldProperties.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_ACTION_STATE__PROPERTIES, null, null);
				if (newProperties.eInternalContainer() == null) {
					msgs = newProperties.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_ACTION_STATE__PROPERTIES, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.CGI_ACTION_STATE__PROPERTIES, oldProperties, properties));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_ACTION_STATE__PROPERTIES, oldProperties, newProperties);
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
				msgs = ((InternalEObject)properties).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_ACTION_STATE__PROPERTIES, null, msgs);
			if (newProperties != null)
				msgs = ((InternalEObject)newProperties).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_ACTION_STATE__PROPERTIES, null, msgs);
			msgs = basicSetProperties(newProperties, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_ACTION_STATE__PROPERTIES, newProperties, newProperties));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IStateVertex getM_pModelObject() {
		if (m_pModelObject != null && m_pModelObject.eIsProxy()) {
			InternalEObject oldM_pModelObject = (InternalEObject)m_pModelObject;
			m_pModelObject = (IStateVertex)eResolveProxy(oldM_pModelObject);
			if (m_pModelObject != oldM_pModelObject) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.CGI_ACTION_STATE__MPMODEL_OBJECT, oldM_pModelObject, m_pModelObject));
			}
		}
		return m_pModelObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IStateVertex basicGetM_pModelObject() {
		return m_pModelObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_pModelObject(IStateVertex newM_pModelObject) {
		IStateVertex oldM_pModelObject = m_pModelObject;
		m_pModelObject = newM_pModelObject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_ACTION_STATE__MPMODEL_OBJECT, oldM_pModelObject, m_pModelObject));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.CGI_ACTION_STATE__MPPARENT, oldM_pParent, m_pParent));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_ACTION_STATE__MPPARENT, oldM_pParent, m_pParent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getM_transform() {
		if (m_transform == null) {
			m_transform = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.CGI_ACTION_STATE__MTRANSFORM);
		}
		return m_transform;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGIText getM_AdditionalLabel() {
		if (m_AdditionalLabel != null && m_AdditionalLabel.eIsProxy()) {
			InternalEObject oldM_AdditionalLabel = (InternalEObject)m_AdditionalLabel;
			m_AdditionalLabel = (CGIText)eResolveProxy(oldM_AdditionalLabel);
			if (m_AdditionalLabel != oldM_AdditionalLabel) {
				InternalEObject newM_AdditionalLabel = (InternalEObject)m_AdditionalLabel;
				NotificationChain msgs = oldM_AdditionalLabel.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_ACTION_STATE__MADDITIONAL_LABEL, null, null);
				if (newM_AdditionalLabel.eInternalContainer() == null) {
					msgs = newM_AdditionalLabel.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_ACTION_STATE__MADDITIONAL_LABEL, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.CGI_ACTION_STATE__MADDITIONAL_LABEL, oldM_AdditionalLabel, m_AdditionalLabel));
			}
		}
		return m_AdditionalLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGIText basicGetM_AdditionalLabel() {
		return m_AdditionalLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetM_AdditionalLabel(CGIText newM_AdditionalLabel, NotificationChain msgs) {
		CGIText oldM_AdditionalLabel = m_AdditionalLabel;
		m_AdditionalLabel = newM_AdditionalLabel;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_ACTION_STATE__MADDITIONAL_LABEL, oldM_AdditionalLabel, newM_AdditionalLabel);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_AdditionalLabel(CGIText newM_AdditionalLabel) {
		if (newM_AdditionalLabel != m_AdditionalLabel) {
			NotificationChain msgs = null;
			if (m_AdditionalLabel != null)
				msgs = ((InternalEObject)m_AdditionalLabel).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_ACTION_STATE__MADDITIONAL_LABEL, null, msgs);
			if (newM_AdditionalLabel != null)
				msgs = ((InternalEObject)newM_AdditionalLabel).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_ACTION_STATE__MADDITIONAL_LABEL, null, msgs);
			msgs = basicSetM_AdditionalLabel(newM_AdditionalLabel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_ACTION_STATE__MADDITIONAL_LABEL, newM_AdditionalLabel, newM_AdditionalLabel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getM_polygon() {
		if (m_polygon == null) {
			m_polygon = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.CGI_ACTION_STATE__MPOLYGON);
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_ACTION_STATE__MNNAME_FORMAT, oldM_nNameFormat, m_nNameFormat));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_ACTION_STATE__MNIS_NAME_FORMAT, oldM_nIsNameFormat, m_nIsNameFormat));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UnknownType> getCompartments() {
		if (compartments == null) {
			compartments = new EObjectResolvingEList<UnknownType>(UnknownType.class, this, UMLRhapsodyPackage.CGI_ACTION_STATE__COMPARTMENTS);
		}
		return compartments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNAndLineCount() {
		return nAndLineCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNAndLineCount(String newNAndLineCount) {
		String oldNAndLineCount = nAndLineCount;
		nAndLineCount = newNAndLineCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_ACTION_STATE__NAND_LINE_COUNT, oldNAndLineCount, nAndLineCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UnknownType> getM_pInheritsFrom() {
		if (m_pInheritsFrom == null) {
			m_pInheritsFrom = new EObjectResolvingEList<UnknownType>(UnknownType.class, this, UMLRhapsodyPackage.CGI_ACTION_STATE__MPINHERITS_FROM);
		}
		return m_pInheritsFrom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_nInheritanceMask() {
		return m_nInheritanceMask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_nInheritanceMask(String newM_nInheritanceMask) {
		String oldM_nInheritanceMask = m_nInheritanceMask;
		m_nInheritanceMask = newM_nInheritanceMask;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_ACTION_STATE__MNINHERITANCE_MASK, oldM_nInheritanceMask, m_nInheritanceMask));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_pDefaultComponentRelation() {
		return m_pDefaultComponentRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_pDefaultComponentRelation(String newM_pDefaultComponentRelation) {
		String oldM_pDefaultComponentRelation = m_pDefaultComponentRelation;
		m_pDefaultComponentRelation = newM_pDefaultComponentRelation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_ACTION_STATE__MPDEFAULT_COMPONENT_RELATION, oldM_pDefaultComponentRelation, m_pDefaultComponentRelation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_NameDisplayMode() {
		return m_NameDisplayMode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_NameDisplayMode(String newM_NameDisplayMode) {
		String oldM_NameDisplayMode = m_NameDisplayMode;
		m_NameDisplayMode = newM_NameDisplayMode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_ACTION_STATE__MNAME_DISPLAY_MODE, oldM_NameDisplayMode, m_NameDisplayMode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_ActDescLablDiaplayMode() {
		return m_ActDescLablDiaplayMode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_ActDescLablDiaplayMode(String newM_ActDescLablDiaplayMode) {
		String oldM_ActDescLablDiaplayMode = m_ActDescLablDiaplayMode;
		m_ActDescLablDiaplayMode = newM_ActDescLablDiaplayMode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_ACTION_STATE__MACT_DESC_LABL_DIAPLAY_MODE, oldM_ActDescLablDiaplayMode, m_ActDescLablDiaplayMode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_moveAndLineTimeStamp() {
		return m_moveAndLineTimeStamp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_moveAndLineTimeStamp(String newM_moveAndLineTimeStamp) {
		String oldM_moveAndLineTimeStamp = m_moveAndLineTimeStamp;
		m_moveAndLineTimeStamp = newM_moveAndLineTimeStamp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_ACTION_STATE__MMOVE_AND_LINE_TIME_STAMP, oldM_moveAndLineTimeStamp, m_moveAndLineTimeStamp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLRhapsodyPackage.CGI_ACTION_STATE__PROPERTIES:
				return basicSetProperties(null, msgs);
			case UMLRhapsodyPackage.CGI_ACTION_STATE__MADDITIONAL_LABEL:
				return basicSetM_AdditionalLabel(null, msgs);
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
			case UMLRhapsodyPackage.CGI_ACTION_STATE__PROPERTIES:
				if (resolve) return getProperties();
				return basicGetProperties();
			case UMLRhapsodyPackage.CGI_ACTION_STATE__MPMODEL_OBJECT:
				if (resolve) return getM_pModelObject();
				return basicGetM_pModelObject();
			case UMLRhapsodyPackage.CGI_ACTION_STATE__MPPARENT:
				if (resolve) return getM_pParent();
				return basicGetM_pParent();
			case UMLRhapsodyPackage.CGI_ACTION_STATE__MTRANSFORM:
				return getM_transform();
			case UMLRhapsodyPackage.CGI_ACTION_STATE__MADDITIONAL_LABEL:
				if (resolve) return getM_AdditionalLabel();
				return basicGetM_AdditionalLabel();
			case UMLRhapsodyPackage.CGI_ACTION_STATE__MPOLYGON:
				return getM_polygon();
			case UMLRhapsodyPackage.CGI_ACTION_STATE__MNNAME_FORMAT:
				return getM_nNameFormat();
			case UMLRhapsodyPackage.CGI_ACTION_STATE__MNIS_NAME_FORMAT:
				return getM_nIsNameFormat();
			case UMLRhapsodyPackage.CGI_ACTION_STATE__COMPARTMENTS:
				return getCompartments();
			case UMLRhapsodyPackage.CGI_ACTION_STATE__NAND_LINE_COUNT:
				return getNAndLineCount();
			case UMLRhapsodyPackage.CGI_ACTION_STATE__MPINHERITS_FROM:
				return getM_pInheritsFrom();
			case UMLRhapsodyPackage.CGI_ACTION_STATE__MNINHERITANCE_MASK:
				return getM_nInheritanceMask();
			case UMLRhapsodyPackage.CGI_ACTION_STATE__MPDEFAULT_COMPONENT_RELATION:
				return getM_pDefaultComponentRelation();
			case UMLRhapsodyPackage.CGI_ACTION_STATE__MNAME_DISPLAY_MODE:
				return getM_NameDisplayMode();
			case UMLRhapsodyPackage.CGI_ACTION_STATE__MACT_DESC_LABL_DIAPLAY_MODE:
				return getM_ActDescLablDiaplayMode();
			case UMLRhapsodyPackage.CGI_ACTION_STATE__MMOVE_AND_LINE_TIME_STAMP:
				return getM_moveAndLineTimeStamp();
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
			case UMLRhapsodyPackage.CGI_ACTION_STATE__PROPERTIES:
				setProperties((IPropertyContainer)newValue);
				return;
			case UMLRhapsodyPackage.CGI_ACTION_STATE__MPMODEL_OBJECT:
				setM_pModelObject((IStateVertex)newValue);
				return;
			case UMLRhapsodyPackage.CGI_ACTION_STATE__MPPARENT:
				setM_pParent((GraphElementsType)newValue);
				return;
			case UMLRhapsodyPackage.CGI_ACTION_STATE__MTRANSFORM:
				getM_transform().clear();
				getM_transform().addAll((Collection<? extends String>)newValue);
				return;
			case UMLRhapsodyPackage.CGI_ACTION_STATE__MADDITIONAL_LABEL:
				setM_AdditionalLabel((CGIText)newValue);
				return;
			case UMLRhapsodyPackage.CGI_ACTION_STATE__MPOLYGON:
				getM_polygon().clear();
				getM_polygon().addAll((Collection<? extends String>)newValue);
				return;
			case UMLRhapsodyPackage.CGI_ACTION_STATE__MNNAME_FORMAT:
				setM_nNameFormat((String)newValue);
				return;
			case UMLRhapsodyPackage.CGI_ACTION_STATE__MNIS_NAME_FORMAT:
				setM_nIsNameFormat((String)newValue);
				return;
			case UMLRhapsodyPackage.CGI_ACTION_STATE__COMPARTMENTS:
				getCompartments().clear();
				getCompartments().addAll((Collection<? extends UnknownType>)newValue);
				return;
			case UMLRhapsodyPackage.CGI_ACTION_STATE__NAND_LINE_COUNT:
				setNAndLineCount((String)newValue);
				return;
			case UMLRhapsodyPackage.CGI_ACTION_STATE__MPINHERITS_FROM:
				getM_pInheritsFrom().clear();
				getM_pInheritsFrom().addAll((Collection<? extends UnknownType>)newValue);
				return;
			case UMLRhapsodyPackage.CGI_ACTION_STATE__MNINHERITANCE_MASK:
				setM_nInheritanceMask((String)newValue);
				return;
			case UMLRhapsodyPackage.CGI_ACTION_STATE__MPDEFAULT_COMPONENT_RELATION:
				setM_pDefaultComponentRelation((String)newValue);
				return;
			case UMLRhapsodyPackage.CGI_ACTION_STATE__MNAME_DISPLAY_MODE:
				setM_NameDisplayMode((String)newValue);
				return;
			case UMLRhapsodyPackage.CGI_ACTION_STATE__MACT_DESC_LABL_DIAPLAY_MODE:
				setM_ActDescLablDiaplayMode((String)newValue);
				return;
			case UMLRhapsodyPackage.CGI_ACTION_STATE__MMOVE_AND_LINE_TIME_STAMP:
				setM_moveAndLineTimeStamp((String)newValue);
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
			case UMLRhapsodyPackage.CGI_ACTION_STATE__PROPERTIES:
				setProperties((IPropertyContainer)null);
				return;
			case UMLRhapsodyPackage.CGI_ACTION_STATE__MPMODEL_OBJECT:
				setM_pModelObject((IStateVertex)null);
				return;
			case UMLRhapsodyPackage.CGI_ACTION_STATE__MPPARENT:
				setM_pParent((GraphElementsType)null);
				return;
			case UMLRhapsodyPackage.CGI_ACTION_STATE__MTRANSFORM:
				getM_transform().clear();
				return;
			case UMLRhapsodyPackage.CGI_ACTION_STATE__MADDITIONAL_LABEL:
				setM_AdditionalLabel((CGIText)null);
				return;
			case UMLRhapsodyPackage.CGI_ACTION_STATE__MPOLYGON:
				getM_polygon().clear();
				return;
			case UMLRhapsodyPackage.CGI_ACTION_STATE__MNNAME_FORMAT:
				setM_nNameFormat(MNNAME_FORMAT_EDEFAULT);
				return;
			case UMLRhapsodyPackage.CGI_ACTION_STATE__MNIS_NAME_FORMAT:
				setM_nIsNameFormat(MNIS_NAME_FORMAT_EDEFAULT);
				return;
			case UMLRhapsodyPackage.CGI_ACTION_STATE__COMPARTMENTS:
				getCompartments().clear();
				return;
			case UMLRhapsodyPackage.CGI_ACTION_STATE__NAND_LINE_COUNT:
				setNAndLineCount(NAND_LINE_COUNT_EDEFAULT);
				return;
			case UMLRhapsodyPackage.CGI_ACTION_STATE__MPINHERITS_FROM:
				getM_pInheritsFrom().clear();
				return;
			case UMLRhapsodyPackage.CGI_ACTION_STATE__MNINHERITANCE_MASK:
				setM_nInheritanceMask(MNINHERITANCE_MASK_EDEFAULT);
				return;
			case UMLRhapsodyPackage.CGI_ACTION_STATE__MPDEFAULT_COMPONENT_RELATION:
				setM_pDefaultComponentRelation(MPDEFAULT_COMPONENT_RELATION_EDEFAULT);
				return;
			case UMLRhapsodyPackage.CGI_ACTION_STATE__MNAME_DISPLAY_MODE:
				setM_NameDisplayMode(MNAME_DISPLAY_MODE_EDEFAULT);
				return;
			case UMLRhapsodyPackage.CGI_ACTION_STATE__MACT_DESC_LABL_DIAPLAY_MODE:
				setM_ActDescLablDiaplayMode(MACT_DESC_LABL_DIAPLAY_MODE_EDEFAULT);
				return;
			case UMLRhapsodyPackage.CGI_ACTION_STATE__MMOVE_AND_LINE_TIME_STAMP:
				setM_moveAndLineTimeStamp(MMOVE_AND_LINE_TIME_STAMP_EDEFAULT);
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
			case UMLRhapsodyPackage.CGI_ACTION_STATE__PROPERTIES:
				return properties != null;
			case UMLRhapsodyPackage.CGI_ACTION_STATE__MPMODEL_OBJECT:
				return m_pModelObject != null;
			case UMLRhapsodyPackage.CGI_ACTION_STATE__MPPARENT:
				return m_pParent != null;
			case UMLRhapsodyPackage.CGI_ACTION_STATE__MTRANSFORM:
				return m_transform != null && !m_transform.isEmpty();
			case UMLRhapsodyPackage.CGI_ACTION_STATE__MADDITIONAL_LABEL:
				return m_AdditionalLabel != null;
			case UMLRhapsodyPackage.CGI_ACTION_STATE__MPOLYGON:
				return m_polygon != null && !m_polygon.isEmpty();
			case UMLRhapsodyPackage.CGI_ACTION_STATE__MNNAME_FORMAT:
				return MNNAME_FORMAT_EDEFAULT == null ? m_nNameFormat != null : !MNNAME_FORMAT_EDEFAULT.equals(m_nNameFormat);
			case UMLRhapsodyPackage.CGI_ACTION_STATE__MNIS_NAME_FORMAT:
				return MNIS_NAME_FORMAT_EDEFAULT == null ? m_nIsNameFormat != null : !MNIS_NAME_FORMAT_EDEFAULT.equals(m_nIsNameFormat);
			case UMLRhapsodyPackage.CGI_ACTION_STATE__COMPARTMENTS:
				return compartments != null && !compartments.isEmpty();
			case UMLRhapsodyPackage.CGI_ACTION_STATE__NAND_LINE_COUNT:
				return NAND_LINE_COUNT_EDEFAULT == null ? nAndLineCount != null : !NAND_LINE_COUNT_EDEFAULT.equals(nAndLineCount);
			case UMLRhapsodyPackage.CGI_ACTION_STATE__MPINHERITS_FROM:
				return m_pInheritsFrom != null && !m_pInheritsFrom.isEmpty();
			case UMLRhapsodyPackage.CGI_ACTION_STATE__MNINHERITANCE_MASK:
				return MNINHERITANCE_MASK_EDEFAULT == null ? m_nInheritanceMask != null : !MNINHERITANCE_MASK_EDEFAULT.equals(m_nInheritanceMask);
			case UMLRhapsodyPackage.CGI_ACTION_STATE__MPDEFAULT_COMPONENT_RELATION:
				return MPDEFAULT_COMPONENT_RELATION_EDEFAULT == null ? m_pDefaultComponentRelation != null : !MPDEFAULT_COMPONENT_RELATION_EDEFAULT.equals(m_pDefaultComponentRelation);
			case UMLRhapsodyPackage.CGI_ACTION_STATE__MNAME_DISPLAY_MODE:
				return MNAME_DISPLAY_MODE_EDEFAULT == null ? m_NameDisplayMode != null : !MNAME_DISPLAY_MODE_EDEFAULT.equals(m_NameDisplayMode);
			case UMLRhapsodyPackage.CGI_ACTION_STATE__MACT_DESC_LABL_DIAPLAY_MODE:
				return MACT_DESC_LABL_DIAPLAY_MODE_EDEFAULT == null ? m_ActDescLablDiaplayMode != null : !MACT_DESC_LABL_DIAPLAY_MODE_EDEFAULT.equals(m_ActDescLablDiaplayMode);
			case UMLRhapsodyPackage.CGI_ACTION_STATE__MMOVE_AND_LINE_TIME_STAMP:
				return MMOVE_AND_LINE_TIME_STAMP_EDEFAULT == null ? m_moveAndLineTimeStamp != null : !MMOVE_AND_LINE_TIME_STAMP_EDEFAULT.equals(m_moveAndLineTimeStamp);
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
		result.append(", nAndLineCount: "); //$NON-NLS-1$
		result.append(nAndLineCount);
		result.append(", m_nInheritanceMask: "); //$NON-NLS-1$
		result.append(m_nInheritanceMask);
		result.append(", m_pDefaultComponentRelation: "); //$NON-NLS-1$
		result.append(m_pDefaultComponentRelation);
		result.append(", m_NameDisplayMode: "); //$NON-NLS-1$
		result.append(m_NameDisplayMode);
		result.append(", m_ActDescLablDiaplayMode: "); //$NON-NLS-1$
		result.append(m_ActDescLablDiaplayMode);
		result.append(", m_moveAndLineTimeStamp: "); //$NON-NLS-1$
		result.append(m_moveAndLineTimeStamp);
		result.append(')');
		return result.toString();
	}

} //CGIActionStateImpl
