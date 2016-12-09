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

import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIInformationFlow;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIText;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IInformationFlow;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IPropertyContainer;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.M_pRootType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CGI Information Flow</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIInformationFlowImpl#getM_pModelObject <em>MpModel Object</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIInformationFlowImpl#getM_pParent <em>MpParent</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIInformationFlowImpl#getM_pSource <em>MpSource</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIInformationFlowImpl#getM_sourceType <em>Msource Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIInformationFlowImpl#getM_pTarget <em>MpTarget</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIInformationFlowImpl#getM_targetType <em>Mtarget Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIInformationFlowImpl#getM_direction <em>Mdirection</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIInformationFlowImpl#getM_rpn <em>Mrpn</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIInformationFlowImpl#getM_anglePoint1 <em>Mangle Point1</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIInformationFlowImpl#getM_anglePoint2 <em>Mangle Point2</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIInformationFlowImpl#getM_line_style <em>Mline style</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIInformationFlowImpl#getM_SourcePort <em>MSource Port</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIInformationFlowImpl#getM_TargetPort <em>MTarget Port</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIInformationFlowImpl#getM_bShowKeyword <em>MbShow Keyword</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIInformationFlowImpl#getM_showConveyed <em>Mshow Conveyed</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIInformationFlowImpl#getM_keyword <em>Mkeyword</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIInformationFlowImpl#getM_conveyed <em>Mconveyed</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIInformationFlowImpl#getM_arrow <em>Marrow</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIInformationFlowImpl#getProperties <em>Properties</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CGIInformationFlowImpl extends GraphElementsTypeImpl implements CGIInformationFlow {
	/**
	 * The cached value of the '{@link #getM_pModelObject() <em>MpModel Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_pModelObject()
	 * @generated
	 * @ordered
	 */
	protected IInformationFlow m_pModelObject;

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
	 * The cached value of the '{@link #getM_pSource() <em>MpSource</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_pSource()
	 * @generated
	 * @ordered
	 */
	protected M_pRootType m_pSource;

	/**
	 * The default value of the '{@link #getM_sourceType() <em>Msource Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_sourceType()
	 * @generated
	 * @ordered
	 */
	protected static final String MSOURCE_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_sourceType() <em>Msource Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_sourceType()
	 * @generated
	 * @ordered
	 */
	protected String m_sourceType = MSOURCE_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getM_pTarget() <em>MpTarget</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_pTarget()
	 * @generated
	 * @ordered
	 */
	protected M_pRootType m_pTarget;

	/**
	 * The default value of the '{@link #getM_targetType() <em>Mtarget Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_targetType()
	 * @generated
	 * @ordered
	 */
	protected static final String MTARGET_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_targetType() <em>Mtarget Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_targetType()
	 * @generated
	 * @ordered
	 */
	protected String m_targetType = MTARGET_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getM_direction() <em>Mdirection</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_direction()
	 * @generated
	 * @ordered
	 */
	protected static final String MDIRECTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_direction() <em>Mdirection</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_direction()
	 * @generated
	 * @ordered
	 */
	protected String m_direction = MDIRECTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getM_rpn() <em>Mrpn</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_rpn()
	 * @generated
	 * @ordered
	 */
	protected CGIText m_rpn;

	/**
	 * The cached value of the '{@link #getM_anglePoint1() <em>Mangle Point1</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_anglePoint1()
	 * @generated
	 * @ordered
	 */
	protected EList<String> m_anglePoint1;

	/**
	 * The cached value of the '{@link #getM_anglePoint2() <em>Mangle Point2</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_anglePoint2()
	 * @generated
	 * @ordered
	 */
	protected EList<String> m_anglePoint2;

	/**
	 * The default value of the '{@link #getM_line_style() <em>Mline style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_line_style()
	 * @generated
	 * @ordered
	 */
	protected static final String MLINE_STYLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_line_style() <em>Mline style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_line_style()
	 * @generated
	 * @ordered
	 */
	protected String m_line_style = MLINE_STYLE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getM_SourcePort() <em>MSource Port</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_SourcePort()
	 * @generated
	 * @ordered
	 */
	protected EList<String> m_SourcePort;

	/**
	 * The cached value of the '{@link #getM_TargetPort() <em>MTarget Port</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_TargetPort()
	 * @generated
	 * @ordered
	 */
	protected EList<String> m_TargetPort;

	/**
	 * The default value of the '{@link #getM_bShowKeyword() <em>MbShow Keyword</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_bShowKeyword()
	 * @generated
	 * @ordered
	 */
	protected static final String MBSHOW_KEYWORD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_bShowKeyword() <em>MbShow Keyword</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_bShowKeyword()
	 * @generated
	 * @ordered
	 */
	protected String m_bShowKeyword = MBSHOW_KEYWORD_EDEFAULT;

	/**
	 * The default value of the '{@link #getM_showConveyed() <em>Mshow Conveyed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_showConveyed()
	 * @generated
	 * @ordered
	 */
	protected static final String MSHOW_CONVEYED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_showConveyed() <em>Mshow Conveyed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_showConveyed()
	 * @generated
	 * @ordered
	 */
	protected String m_showConveyed = MSHOW_CONVEYED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getM_keyword() <em>Mkeyword</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_keyword()
	 * @generated
	 * @ordered
	 */
	protected CGIText m_keyword;

	/**
	 * The cached value of the '{@link #getM_conveyed() <em>Mconveyed</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_conveyed()
	 * @generated
	 * @ordered
	 */
	protected CGIText m_conveyed;

	/**
	 * The cached value of the '{@link #getM_arrow() <em>Marrow</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_arrow()
	 * @generated
	 * @ordered
	 */
	protected EList<String> m_arrow;

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
	protected CGIInformationFlowImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLRhapsodyPackage.eINSTANCE.getCGIInformationFlow();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IInformationFlow getM_pModelObject() {
		if (m_pModelObject != null && m_pModelObject.eIsProxy()) {
			InternalEObject oldM_pModelObject = (InternalEObject)m_pModelObject;
			m_pModelObject = (IInformationFlow)eResolveProxy(oldM_pModelObject);
			if (m_pModelObject != oldM_pModelObject) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MPMODEL_OBJECT, oldM_pModelObject, m_pModelObject));
			}
		}
		return m_pModelObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IInformationFlow basicGetM_pModelObject() {
		return m_pModelObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_pModelObject(IInformationFlow newM_pModelObject) {
		IInformationFlow oldM_pModelObject = m_pModelObject;
		m_pModelObject = newM_pModelObject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MPMODEL_OBJECT, oldM_pModelObject, m_pModelObject));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MPPARENT, oldM_pParent, m_pParent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public M_pRootType getM_pSource() {
		if (m_pSource != null && m_pSource.eIsProxy()) {
			InternalEObject oldM_pSource = (InternalEObject)m_pSource;
			m_pSource = (M_pRootType)eResolveProxy(oldM_pSource);
			if (m_pSource != oldM_pSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MPSOURCE, oldM_pSource, m_pSource));
			}
		}
		return m_pSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public M_pRootType basicGetM_pSource() {
		return m_pSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_pSource(M_pRootType newM_pSource) {
		M_pRootType oldM_pSource = m_pSource;
		m_pSource = newM_pSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MPSOURCE, oldM_pSource, m_pSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_sourceType() {
		return m_sourceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_sourceType(String newM_sourceType) {
		String oldM_sourceType = m_sourceType;
		m_sourceType = newM_sourceType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MSOURCE_TYPE, oldM_sourceType, m_sourceType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public M_pRootType getM_pTarget() {
		if (m_pTarget != null && m_pTarget.eIsProxy()) {
			InternalEObject oldM_pTarget = (InternalEObject)m_pTarget;
			m_pTarget = (M_pRootType)eResolveProxy(oldM_pTarget);
			if (m_pTarget != oldM_pTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MPTARGET, oldM_pTarget, m_pTarget));
			}
		}
		return m_pTarget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public M_pRootType basicGetM_pTarget() {
		return m_pTarget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_pTarget(M_pRootType newM_pTarget) {
		M_pRootType oldM_pTarget = m_pTarget;
		m_pTarget = newM_pTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MPTARGET, oldM_pTarget, m_pTarget));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_targetType() {
		return m_targetType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_targetType(String newM_targetType) {
		String oldM_targetType = m_targetType;
		m_targetType = newM_targetType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MTARGET_TYPE, oldM_targetType, m_targetType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_direction() {
		return m_direction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_direction(String newM_direction) {
		String oldM_direction = m_direction;
		m_direction = newM_direction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MDIRECTION, oldM_direction, m_direction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGIText getM_rpn() {
		if (m_rpn != null && m_rpn.eIsProxy()) {
			InternalEObject oldM_rpn = (InternalEObject)m_rpn;
			m_rpn = (CGIText)eResolveProxy(oldM_rpn);
			if (m_rpn != oldM_rpn) {
				InternalEObject newM_rpn = (InternalEObject)m_rpn;
				NotificationChain msgs = oldM_rpn.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MRPN, null, null);
				if (newM_rpn.eInternalContainer() == null) {
					msgs = newM_rpn.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MRPN, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MRPN, oldM_rpn, m_rpn));
			}
		}
		return m_rpn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGIText basicGetM_rpn() {
		return m_rpn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetM_rpn(CGIText newM_rpn, NotificationChain msgs) {
		CGIText oldM_rpn = m_rpn;
		m_rpn = newM_rpn;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MRPN, oldM_rpn, newM_rpn);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_rpn(CGIText newM_rpn) {
		if (newM_rpn != m_rpn) {
			NotificationChain msgs = null;
			if (m_rpn != null)
				msgs = ((InternalEObject)m_rpn).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MRPN, null, msgs);
			if (newM_rpn != null)
				msgs = ((InternalEObject)newM_rpn).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MRPN, null, msgs);
			msgs = basicSetM_rpn(newM_rpn, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MRPN, newM_rpn, newM_rpn));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getM_anglePoint1() {
		if (m_anglePoint1 == null) {
			m_anglePoint1 = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MANGLE_POINT1);
		}
		return m_anglePoint1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getM_anglePoint2() {
		if (m_anglePoint2 == null) {
			m_anglePoint2 = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MANGLE_POINT2);
		}
		return m_anglePoint2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_line_style() {
		return m_line_style;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_line_style(String newM_line_style) {
		String oldM_line_style = m_line_style;
		m_line_style = newM_line_style;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MLINE_STYLE, oldM_line_style, m_line_style));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getM_SourcePort() {
		if (m_SourcePort == null) {
			m_SourcePort = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MSOURCE_PORT);
		}
		return m_SourcePort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getM_TargetPort() {
		if (m_TargetPort == null) {
			m_TargetPort = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MTARGET_PORT);
		}
		return m_TargetPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_bShowKeyword() {
		return m_bShowKeyword;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_bShowKeyword(String newM_bShowKeyword) {
		String oldM_bShowKeyword = m_bShowKeyword;
		m_bShowKeyword = newM_bShowKeyword;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MBSHOW_KEYWORD, oldM_bShowKeyword, m_bShowKeyword));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_showConveyed() {
		return m_showConveyed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_showConveyed(String newM_showConveyed) {
		String oldM_showConveyed = m_showConveyed;
		m_showConveyed = newM_showConveyed;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MSHOW_CONVEYED, oldM_showConveyed, m_showConveyed));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGIText getM_keyword() {
		if (m_keyword != null && m_keyword.eIsProxy()) {
			InternalEObject oldM_keyword = (InternalEObject)m_keyword;
			m_keyword = (CGIText)eResolveProxy(oldM_keyword);
			if (m_keyword != oldM_keyword) {
				InternalEObject newM_keyword = (InternalEObject)m_keyword;
				NotificationChain msgs = oldM_keyword.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MKEYWORD, null, null);
				if (newM_keyword.eInternalContainer() == null) {
					msgs = newM_keyword.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MKEYWORD, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MKEYWORD, oldM_keyword, m_keyword));
			}
		}
		return m_keyword;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGIText basicGetM_keyword() {
		return m_keyword;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetM_keyword(CGIText newM_keyword, NotificationChain msgs) {
		CGIText oldM_keyword = m_keyword;
		m_keyword = newM_keyword;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MKEYWORD, oldM_keyword, newM_keyword);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_keyword(CGIText newM_keyword) {
		if (newM_keyword != m_keyword) {
			NotificationChain msgs = null;
			if (m_keyword != null)
				msgs = ((InternalEObject)m_keyword).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MKEYWORD, null, msgs);
			if (newM_keyword != null)
				msgs = ((InternalEObject)newM_keyword).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MKEYWORD, null, msgs);
			msgs = basicSetM_keyword(newM_keyword, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MKEYWORD, newM_keyword, newM_keyword));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGIText getM_conveyed() {
		if (m_conveyed != null && m_conveyed.eIsProxy()) {
			InternalEObject oldM_conveyed = (InternalEObject)m_conveyed;
			m_conveyed = (CGIText)eResolveProxy(oldM_conveyed);
			if (m_conveyed != oldM_conveyed) {
				InternalEObject newM_conveyed = (InternalEObject)m_conveyed;
				NotificationChain msgs = oldM_conveyed.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MCONVEYED, null, null);
				if (newM_conveyed.eInternalContainer() == null) {
					msgs = newM_conveyed.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MCONVEYED, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MCONVEYED, oldM_conveyed, m_conveyed));
			}
		}
		return m_conveyed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGIText basicGetM_conveyed() {
		return m_conveyed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetM_conveyed(CGIText newM_conveyed, NotificationChain msgs) {
		CGIText oldM_conveyed = m_conveyed;
		m_conveyed = newM_conveyed;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MCONVEYED, oldM_conveyed, newM_conveyed);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_conveyed(CGIText newM_conveyed) {
		if (newM_conveyed != m_conveyed) {
			NotificationChain msgs = null;
			if (m_conveyed != null)
				msgs = ((InternalEObject)m_conveyed).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MCONVEYED, null, msgs);
			if (newM_conveyed != null)
				msgs = ((InternalEObject)newM_conveyed).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MCONVEYED, null, msgs);
			msgs = basicSetM_conveyed(newM_conveyed, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MCONVEYED, newM_conveyed, newM_conveyed));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getM_arrow() {
		if (m_arrow == null) {
			m_arrow = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MARROW);
		}
		return m_arrow;
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
				NotificationChain msgs = oldProperties.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_INFORMATION_FLOW__PROPERTIES, null, null);
				if (newProperties.eInternalContainer() == null) {
					msgs = newProperties.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_INFORMATION_FLOW__PROPERTIES, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.CGI_INFORMATION_FLOW__PROPERTIES, oldProperties, properties));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_INFORMATION_FLOW__PROPERTIES, oldProperties, newProperties);
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
				msgs = ((InternalEObject)properties).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_INFORMATION_FLOW__PROPERTIES, null, msgs);
			if (newProperties != null)
				msgs = ((InternalEObject)newProperties).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_INFORMATION_FLOW__PROPERTIES, null, msgs);
			msgs = basicSetProperties(newProperties, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_INFORMATION_FLOW__PROPERTIES, newProperties, newProperties));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MRPN:
				return basicSetM_rpn(null, msgs);
			case UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MKEYWORD:
				return basicSetM_keyword(null, msgs);
			case UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MCONVEYED:
				return basicSetM_conveyed(null, msgs);
			case UMLRhapsodyPackage.CGI_INFORMATION_FLOW__PROPERTIES:
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
			case UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MPMODEL_OBJECT:
				if (resolve) return getM_pModelObject();
				return basicGetM_pModelObject();
			case UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MPPARENT:
				return getM_pParent();
			case UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MPSOURCE:
				if (resolve) return getM_pSource();
				return basicGetM_pSource();
			case UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MSOURCE_TYPE:
				return getM_sourceType();
			case UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MPTARGET:
				if (resolve) return getM_pTarget();
				return basicGetM_pTarget();
			case UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MTARGET_TYPE:
				return getM_targetType();
			case UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MDIRECTION:
				return getM_direction();
			case UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MRPN:
				if (resolve) return getM_rpn();
				return basicGetM_rpn();
			case UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MANGLE_POINT1:
				return getM_anglePoint1();
			case UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MANGLE_POINT2:
				return getM_anglePoint2();
			case UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MLINE_STYLE:
				return getM_line_style();
			case UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MSOURCE_PORT:
				return getM_SourcePort();
			case UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MTARGET_PORT:
				return getM_TargetPort();
			case UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MBSHOW_KEYWORD:
				return getM_bShowKeyword();
			case UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MSHOW_CONVEYED:
				return getM_showConveyed();
			case UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MKEYWORD:
				if (resolve) return getM_keyword();
				return basicGetM_keyword();
			case UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MCONVEYED:
				if (resolve) return getM_conveyed();
				return basicGetM_conveyed();
			case UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MARROW:
				return getM_arrow();
			case UMLRhapsodyPackage.CGI_INFORMATION_FLOW__PROPERTIES:
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
			case UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MPMODEL_OBJECT:
				setM_pModelObject((IInformationFlow)newValue);
				return;
			case UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MPPARENT:
				setM_pParent((String)newValue);
				return;
			case UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MPSOURCE:
				setM_pSource((M_pRootType)newValue);
				return;
			case UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MSOURCE_TYPE:
				setM_sourceType((String)newValue);
				return;
			case UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MPTARGET:
				setM_pTarget((M_pRootType)newValue);
				return;
			case UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MTARGET_TYPE:
				setM_targetType((String)newValue);
				return;
			case UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MDIRECTION:
				setM_direction((String)newValue);
				return;
			case UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MRPN:
				setM_rpn((CGIText)newValue);
				return;
			case UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MANGLE_POINT1:
				getM_anglePoint1().clear();
				getM_anglePoint1().addAll((Collection<? extends String>)newValue);
				return;
			case UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MANGLE_POINT2:
				getM_anglePoint2().clear();
				getM_anglePoint2().addAll((Collection<? extends String>)newValue);
				return;
			case UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MLINE_STYLE:
				setM_line_style((String)newValue);
				return;
			case UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MSOURCE_PORT:
				getM_SourcePort().clear();
				getM_SourcePort().addAll((Collection<? extends String>)newValue);
				return;
			case UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MTARGET_PORT:
				getM_TargetPort().clear();
				getM_TargetPort().addAll((Collection<? extends String>)newValue);
				return;
			case UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MBSHOW_KEYWORD:
				setM_bShowKeyword((String)newValue);
				return;
			case UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MSHOW_CONVEYED:
				setM_showConveyed((String)newValue);
				return;
			case UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MKEYWORD:
				setM_keyword((CGIText)newValue);
				return;
			case UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MCONVEYED:
				setM_conveyed((CGIText)newValue);
				return;
			case UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MARROW:
				getM_arrow().clear();
				getM_arrow().addAll((Collection<? extends String>)newValue);
				return;
			case UMLRhapsodyPackage.CGI_INFORMATION_FLOW__PROPERTIES:
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
			case UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MPMODEL_OBJECT:
				setM_pModelObject((IInformationFlow)null);
				return;
			case UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MPPARENT:
				setM_pParent(MPPARENT_EDEFAULT);
				return;
			case UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MPSOURCE:
				setM_pSource((M_pRootType)null);
				return;
			case UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MSOURCE_TYPE:
				setM_sourceType(MSOURCE_TYPE_EDEFAULT);
				return;
			case UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MPTARGET:
				setM_pTarget((M_pRootType)null);
				return;
			case UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MTARGET_TYPE:
				setM_targetType(MTARGET_TYPE_EDEFAULT);
				return;
			case UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MDIRECTION:
				setM_direction(MDIRECTION_EDEFAULT);
				return;
			case UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MRPN:
				setM_rpn((CGIText)null);
				return;
			case UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MANGLE_POINT1:
				getM_anglePoint1().clear();
				return;
			case UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MANGLE_POINT2:
				getM_anglePoint2().clear();
				return;
			case UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MLINE_STYLE:
				setM_line_style(MLINE_STYLE_EDEFAULT);
				return;
			case UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MSOURCE_PORT:
				getM_SourcePort().clear();
				return;
			case UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MTARGET_PORT:
				getM_TargetPort().clear();
				return;
			case UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MBSHOW_KEYWORD:
				setM_bShowKeyword(MBSHOW_KEYWORD_EDEFAULT);
				return;
			case UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MSHOW_CONVEYED:
				setM_showConveyed(MSHOW_CONVEYED_EDEFAULT);
				return;
			case UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MKEYWORD:
				setM_keyword((CGIText)null);
				return;
			case UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MCONVEYED:
				setM_conveyed((CGIText)null);
				return;
			case UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MARROW:
				getM_arrow().clear();
				return;
			case UMLRhapsodyPackage.CGI_INFORMATION_FLOW__PROPERTIES:
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
			case UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MPMODEL_OBJECT:
				return m_pModelObject != null;
			case UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MPPARENT:
				return MPPARENT_EDEFAULT == null ? m_pParent != null : !MPPARENT_EDEFAULT.equals(m_pParent);
			case UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MPSOURCE:
				return m_pSource != null;
			case UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MSOURCE_TYPE:
				return MSOURCE_TYPE_EDEFAULT == null ? m_sourceType != null : !MSOURCE_TYPE_EDEFAULT.equals(m_sourceType);
			case UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MPTARGET:
				return m_pTarget != null;
			case UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MTARGET_TYPE:
				return MTARGET_TYPE_EDEFAULT == null ? m_targetType != null : !MTARGET_TYPE_EDEFAULT.equals(m_targetType);
			case UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MDIRECTION:
				return MDIRECTION_EDEFAULT == null ? m_direction != null : !MDIRECTION_EDEFAULT.equals(m_direction);
			case UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MRPN:
				return m_rpn != null;
			case UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MANGLE_POINT1:
				return m_anglePoint1 != null && !m_anglePoint1.isEmpty();
			case UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MANGLE_POINT2:
				return m_anglePoint2 != null && !m_anglePoint2.isEmpty();
			case UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MLINE_STYLE:
				return MLINE_STYLE_EDEFAULT == null ? m_line_style != null : !MLINE_STYLE_EDEFAULT.equals(m_line_style);
			case UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MSOURCE_PORT:
				return m_SourcePort != null && !m_SourcePort.isEmpty();
			case UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MTARGET_PORT:
				return m_TargetPort != null && !m_TargetPort.isEmpty();
			case UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MBSHOW_KEYWORD:
				return MBSHOW_KEYWORD_EDEFAULT == null ? m_bShowKeyword != null : !MBSHOW_KEYWORD_EDEFAULT.equals(m_bShowKeyword);
			case UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MSHOW_CONVEYED:
				return MSHOW_CONVEYED_EDEFAULT == null ? m_showConveyed != null : !MSHOW_CONVEYED_EDEFAULT.equals(m_showConveyed);
			case UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MKEYWORD:
				return m_keyword != null;
			case UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MCONVEYED:
				return m_conveyed != null;
			case UMLRhapsodyPackage.CGI_INFORMATION_FLOW__MARROW:
				return m_arrow != null && !m_arrow.isEmpty();
			case UMLRhapsodyPackage.CGI_INFORMATION_FLOW__PROPERTIES:
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
		result.append(" (m_pParent: "); //$NON-NLS-1$
		result.append(m_pParent);
		result.append(", m_sourceType: "); //$NON-NLS-1$
		result.append(m_sourceType);
		result.append(", m_targetType: "); //$NON-NLS-1$
		result.append(m_targetType);
		result.append(", m_direction: "); //$NON-NLS-1$
		result.append(m_direction);
		result.append(", m_anglePoint1: "); //$NON-NLS-1$
		result.append(m_anglePoint1);
		result.append(", m_anglePoint2: "); //$NON-NLS-1$
		result.append(m_anglePoint2);
		result.append(", m_line_style: "); //$NON-NLS-1$
		result.append(m_line_style);
		result.append(", m_SourcePort: "); //$NON-NLS-1$
		result.append(m_SourcePort);
		result.append(", m_TargetPort: "); //$NON-NLS-1$
		result.append(m_TargetPort);
		result.append(", m_bShowKeyword: "); //$NON-NLS-1$
		result.append(m_bShowKeyword);
		result.append(", m_showConveyed: "); //$NON-NLS-1$
		result.append(m_showConveyed);
		result.append(", m_arrow: "); //$NON-NLS-1$
		result.append(m_arrow);
		result.append(')');
		return result.toString();
	}

} //CGIInformationFlowImpl
