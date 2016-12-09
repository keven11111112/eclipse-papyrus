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

import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIAnchor;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIText;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IColor;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IPropertyContainer;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.M_pModelObjectType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.M_pRootType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CGI Anchor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIAnchorImpl#getM_pModelObject <em>MpModel Object</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIAnchorImpl#getM_pParent <em>MpParent</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIAnchorImpl#getM_pSource <em>MpSource</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIAnchorImpl#getM_sourceType <em>Msource Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIAnchorImpl#getM_pTarget <em>MpTarget</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIAnchorImpl#getM_targetType <em>Mtarget Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIAnchorImpl#getM_direction <em>Mdirection</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIAnchorImpl#getM_rpn <em>Mrpn</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIAnchorImpl#getM_anglePoint1 <em>Mangle Point1</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIAnchorImpl#getM_anglePoint2 <em>Mangle Point2</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIAnchorImpl#getM_line_style <em>Mline style</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIAnchorImpl#getM_SourcePort <em>MSource Port</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIAnchorImpl#getM_TargetPort <em>MTarget Port</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIAnchorImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIAnchorImpl#getM_color <em>Mcolor</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIAnchorImpl#getM_lineWidth <em>Mline Width</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIAnchorImpl#getM_arrow <em>Marrow</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CGIAnchorImpl extends GraphElementsTypeImpl implements CGIAnchor {
	/**
	 * The cached value of the '{@link #getM_pModelObject() <em>MpModel Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_pModelObject()
	 * @generated
	 * @ordered
	 */
	protected M_pModelObjectType m_pModelObject;

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
	 * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperties()
	 * @generated
	 * @ordered
	 */
	protected IPropertyContainer properties;

	/**
	 * The cached value of the '{@link #getM_color() <em>Mcolor</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_color()
	 * @generated
	 * @ordered
	 */
	protected IColor m_color;

	/**
	 * The default value of the '{@link #getM_lineWidth() <em>Mline Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_lineWidth()
	 * @generated
	 * @ordered
	 */
	protected static final String MLINE_WIDTH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_lineWidth() <em>Mline Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_lineWidth()
	 * @generated
	 * @ordered
	 */
	protected String m_lineWidth = MLINE_WIDTH_EDEFAULT;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CGIAnchorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLRhapsodyPackage.eINSTANCE.getCGIAnchor();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public M_pModelObjectType getM_pModelObject() {
		if (m_pModelObject != null && m_pModelObject.eIsProxy()) {
			InternalEObject oldM_pModelObject = (InternalEObject)m_pModelObject;
			m_pModelObject = (M_pModelObjectType)eResolveProxy(oldM_pModelObject);
			if (m_pModelObject != oldM_pModelObject) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.CGI_ANCHOR__MPMODEL_OBJECT, oldM_pModelObject, m_pModelObject));
			}
		}
		return m_pModelObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public M_pModelObjectType basicGetM_pModelObject() {
		return m_pModelObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_pModelObject(M_pModelObjectType newM_pModelObject) {
		M_pModelObjectType oldM_pModelObject = m_pModelObject;
		m_pModelObject = newM_pModelObject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_ANCHOR__MPMODEL_OBJECT, oldM_pModelObject, m_pModelObject));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_ANCHOR__MPPARENT, oldM_pParent, m_pParent));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.CGI_ANCHOR__MPSOURCE, oldM_pSource, m_pSource));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_ANCHOR__MPSOURCE, oldM_pSource, m_pSource));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_ANCHOR__MSOURCE_TYPE, oldM_sourceType, m_sourceType));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.CGI_ANCHOR__MPTARGET, oldM_pTarget, m_pTarget));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_ANCHOR__MPTARGET, oldM_pTarget, m_pTarget));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_ANCHOR__MTARGET_TYPE, oldM_targetType, m_targetType));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_ANCHOR__MDIRECTION, oldM_direction, m_direction));
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
				NotificationChain msgs = oldM_rpn.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_ANCHOR__MRPN, null, null);
				if (newM_rpn.eInternalContainer() == null) {
					msgs = newM_rpn.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_ANCHOR__MRPN, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.CGI_ANCHOR__MRPN, oldM_rpn, m_rpn));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_ANCHOR__MRPN, oldM_rpn, newM_rpn);
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
				msgs = ((InternalEObject)m_rpn).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_ANCHOR__MRPN, null, msgs);
			if (newM_rpn != null)
				msgs = ((InternalEObject)newM_rpn).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_ANCHOR__MRPN, null, msgs);
			msgs = basicSetM_rpn(newM_rpn, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_ANCHOR__MRPN, newM_rpn, newM_rpn));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getM_anglePoint1() {
		if (m_anglePoint1 == null) {
			m_anglePoint1 = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.CGI_ANCHOR__MANGLE_POINT1);
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
			m_anglePoint2 = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.CGI_ANCHOR__MANGLE_POINT2);
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_ANCHOR__MLINE_STYLE, oldM_line_style, m_line_style));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getM_SourcePort() {
		if (m_SourcePort == null) {
			m_SourcePort = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.CGI_ANCHOR__MSOURCE_PORT);
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
			m_TargetPort = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.CGI_ANCHOR__MTARGET_PORT);
		}
		return m_TargetPort;
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
				NotificationChain msgs = oldProperties.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_ANCHOR__PROPERTIES, null, null);
				if (newProperties.eInternalContainer() == null) {
					msgs = newProperties.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_ANCHOR__PROPERTIES, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.CGI_ANCHOR__PROPERTIES, oldProperties, properties));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_ANCHOR__PROPERTIES, oldProperties, newProperties);
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
				msgs = ((InternalEObject)properties).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_ANCHOR__PROPERTIES, null, msgs);
			if (newProperties != null)
				msgs = ((InternalEObject)newProperties).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_ANCHOR__PROPERTIES, null, msgs);
			msgs = basicSetProperties(newProperties, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_ANCHOR__PROPERTIES, newProperties, newProperties));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IColor getM_color() {
		if (m_color != null && m_color.eIsProxy()) {
			InternalEObject oldM_color = (InternalEObject)m_color;
			m_color = (IColor)eResolveProxy(oldM_color);
			if (m_color != oldM_color) {
				InternalEObject newM_color = (InternalEObject)m_color;
				NotificationChain msgs = oldM_color.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_ANCHOR__MCOLOR, null, null);
				if (newM_color.eInternalContainer() == null) {
					msgs = newM_color.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_ANCHOR__MCOLOR, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.CGI_ANCHOR__MCOLOR, oldM_color, m_color));
			}
		}
		return m_color;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IColor basicGetM_color() {
		return m_color;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetM_color(IColor newM_color, NotificationChain msgs) {
		IColor oldM_color = m_color;
		m_color = newM_color;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_ANCHOR__MCOLOR, oldM_color, newM_color);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_color(IColor newM_color) {
		if (newM_color != m_color) {
			NotificationChain msgs = null;
			if (m_color != null)
				msgs = ((InternalEObject)m_color).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_ANCHOR__MCOLOR, null, msgs);
			if (newM_color != null)
				msgs = ((InternalEObject)newM_color).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_ANCHOR__MCOLOR, null, msgs);
			msgs = basicSetM_color(newM_color, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_ANCHOR__MCOLOR, newM_color, newM_color));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_lineWidth() {
		return m_lineWidth;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_lineWidth(String newM_lineWidth) {
		String oldM_lineWidth = m_lineWidth;
		m_lineWidth = newM_lineWidth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_ANCHOR__MLINE_WIDTH, oldM_lineWidth, m_lineWidth));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getM_arrow() {
		if (m_arrow == null) {
			m_arrow = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.CGI_ANCHOR__MARROW);
		}
		return m_arrow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLRhapsodyPackage.CGI_ANCHOR__MRPN:
				return basicSetM_rpn(null, msgs);
			case UMLRhapsodyPackage.CGI_ANCHOR__PROPERTIES:
				return basicSetProperties(null, msgs);
			case UMLRhapsodyPackage.CGI_ANCHOR__MCOLOR:
				return basicSetM_color(null, msgs);
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
			case UMLRhapsodyPackage.CGI_ANCHOR__MPMODEL_OBJECT:
				if (resolve) return getM_pModelObject();
				return basicGetM_pModelObject();
			case UMLRhapsodyPackage.CGI_ANCHOR__MPPARENT:
				return getM_pParent();
			case UMLRhapsodyPackage.CGI_ANCHOR__MPSOURCE:
				if (resolve) return getM_pSource();
				return basicGetM_pSource();
			case UMLRhapsodyPackage.CGI_ANCHOR__MSOURCE_TYPE:
				return getM_sourceType();
			case UMLRhapsodyPackage.CGI_ANCHOR__MPTARGET:
				if (resolve) return getM_pTarget();
				return basicGetM_pTarget();
			case UMLRhapsodyPackage.CGI_ANCHOR__MTARGET_TYPE:
				return getM_targetType();
			case UMLRhapsodyPackage.CGI_ANCHOR__MDIRECTION:
				return getM_direction();
			case UMLRhapsodyPackage.CGI_ANCHOR__MRPN:
				if (resolve) return getM_rpn();
				return basicGetM_rpn();
			case UMLRhapsodyPackage.CGI_ANCHOR__MANGLE_POINT1:
				return getM_anglePoint1();
			case UMLRhapsodyPackage.CGI_ANCHOR__MANGLE_POINT2:
				return getM_anglePoint2();
			case UMLRhapsodyPackage.CGI_ANCHOR__MLINE_STYLE:
				return getM_line_style();
			case UMLRhapsodyPackage.CGI_ANCHOR__MSOURCE_PORT:
				return getM_SourcePort();
			case UMLRhapsodyPackage.CGI_ANCHOR__MTARGET_PORT:
				return getM_TargetPort();
			case UMLRhapsodyPackage.CGI_ANCHOR__PROPERTIES:
				if (resolve) return getProperties();
				return basicGetProperties();
			case UMLRhapsodyPackage.CGI_ANCHOR__MCOLOR:
				if (resolve) return getM_color();
				return basicGetM_color();
			case UMLRhapsodyPackage.CGI_ANCHOR__MLINE_WIDTH:
				return getM_lineWidth();
			case UMLRhapsodyPackage.CGI_ANCHOR__MARROW:
				return getM_arrow();
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
			case UMLRhapsodyPackage.CGI_ANCHOR__MPMODEL_OBJECT:
				setM_pModelObject((M_pModelObjectType)newValue);
				return;
			case UMLRhapsodyPackage.CGI_ANCHOR__MPPARENT:
				setM_pParent((String)newValue);
				return;
			case UMLRhapsodyPackage.CGI_ANCHOR__MPSOURCE:
				setM_pSource((M_pRootType)newValue);
				return;
			case UMLRhapsodyPackage.CGI_ANCHOR__MSOURCE_TYPE:
				setM_sourceType((String)newValue);
				return;
			case UMLRhapsodyPackage.CGI_ANCHOR__MPTARGET:
				setM_pTarget((M_pRootType)newValue);
				return;
			case UMLRhapsodyPackage.CGI_ANCHOR__MTARGET_TYPE:
				setM_targetType((String)newValue);
				return;
			case UMLRhapsodyPackage.CGI_ANCHOR__MDIRECTION:
				setM_direction((String)newValue);
				return;
			case UMLRhapsodyPackage.CGI_ANCHOR__MRPN:
				setM_rpn((CGIText)newValue);
				return;
			case UMLRhapsodyPackage.CGI_ANCHOR__MANGLE_POINT1:
				getM_anglePoint1().clear();
				getM_anglePoint1().addAll((Collection<? extends String>)newValue);
				return;
			case UMLRhapsodyPackage.CGI_ANCHOR__MANGLE_POINT2:
				getM_anglePoint2().clear();
				getM_anglePoint2().addAll((Collection<? extends String>)newValue);
				return;
			case UMLRhapsodyPackage.CGI_ANCHOR__MLINE_STYLE:
				setM_line_style((String)newValue);
				return;
			case UMLRhapsodyPackage.CGI_ANCHOR__MSOURCE_PORT:
				getM_SourcePort().clear();
				getM_SourcePort().addAll((Collection<? extends String>)newValue);
				return;
			case UMLRhapsodyPackage.CGI_ANCHOR__MTARGET_PORT:
				getM_TargetPort().clear();
				getM_TargetPort().addAll((Collection<? extends String>)newValue);
				return;
			case UMLRhapsodyPackage.CGI_ANCHOR__PROPERTIES:
				setProperties((IPropertyContainer)newValue);
				return;
			case UMLRhapsodyPackage.CGI_ANCHOR__MCOLOR:
				setM_color((IColor)newValue);
				return;
			case UMLRhapsodyPackage.CGI_ANCHOR__MLINE_WIDTH:
				setM_lineWidth((String)newValue);
				return;
			case UMLRhapsodyPackage.CGI_ANCHOR__MARROW:
				getM_arrow().clear();
				getM_arrow().addAll((Collection<? extends String>)newValue);
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
			case UMLRhapsodyPackage.CGI_ANCHOR__MPMODEL_OBJECT:
				setM_pModelObject((M_pModelObjectType)null);
				return;
			case UMLRhapsodyPackage.CGI_ANCHOR__MPPARENT:
				setM_pParent(MPPARENT_EDEFAULT);
				return;
			case UMLRhapsodyPackage.CGI_ANCHOR__MPSOURCE:
				setM_pSource((M_pRootType)null);
				return;
			case UMLRhapsodyPackage.CGI_ANCHOR__MSOURCE_TYPE:
				setM_sourceType(MSOURCE_TYPE_EDEFAULT);
				return;
			case UMLRhapsodyPackage.CGI_ANCHOR__MPTARGET:
				setM_pTarget((M_pRootType)null);
				return;
			case UMLRhapsodyPackage.CGI_ANCHOR__MTARGET_TYPE:
				setM_targetType(MTARGET_TYPE_EDEFAULT);
				return;
			case UMLRhapsodyPackage.CGI_ANCHOR__MDIRECTION:
				setM_direction(MDIRECTION_EDEFAULT);
				return;
			case UMLRhapsodyPackage.CGI_ANCHOR__MRPN:
				setM_rpn((CGIText)null);
				return;
			case UMLRhapsodyPackage.CGI_ANCHOR__MANGLE_POINT1:
				getM_anglePoint1().clear();
				return;
			case UMLRhapsodyPackage.CGI_ANCHOR__MANGLE_POINT2:
				getM_anglePoint2().clear();
				return;
			case UMLRhapsodyPackage.CGI_ANCHOR__MLINE_STYLE:
				setM_line_style(MLINE_STYLE_EDEFAULT);
				return;
			case UMLRhapsodyPackage.CGI_ANCHOR__MSOURCE_PORT:
				getM_SourcePort().clear();
				return;
			case UMLRhapsodyPackage.CGI_ANCHOR__MTARGET_PORT:
				getM_TargetPort().clear();
				return;
			case UMLRhapsodyPackage.CGI_ANCHOR__PROPERTIES:
				setProperties((IPropertyContainer)null);
				return;
			case UMLRhapsodyPackage.CGI_ANCHOR__MCOLOR:
				setM_color((IColor)null);
				return;
			case UMLRhapsodyPackage.CGI_ANCHOR__MLINE_WIDTH:
				setM_lineWidth(MLINE_WIDTH_EDEFAULT);
				return;
			case UMLRhapsodyPackage.CGI_ANCHOR__MARROW:
				getM_arrow().clear();
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
			case UMLRhapsodyPackage.CGI_ANCHOR__MPMODEL_OBJECT:
				return m_pModelObject != null;
			case UMLRhapsodyPackage.CGI_ANCHOR__MPPARENT:
				return MPPARENT_EDEFAULT == null ? m_pParent != null : !MPPARENT_EDEFAULT.equals(m_pParent);
			case UMLRhapsodyPackage.CGI_ANCHOR__MPSOURCE:
				return m_pSource != null;
			case UMLRhapsodyPackage.CGI_ANCHOR__MSOURCE_TYPE:
				return MSOURCE_TYPE_EDEFAULT == null ? m_sourceType != null : !MSOURCE_TYPE_EDEFAULT.equals(m_sourceType);
			case UMLRhapsodyPackage.CGI_ANCHOR__MPTARGET:
				return m_pTarget != null;
			case UMLRhapsodyPackage.CGI_ANCHOR__MTARGET_TYPE:
				return MTARGET_TYPE_EDEFAULT == null ? m_targetType != null : !MTARGET_TYPE_EDEFAULT.equals(m_targetType);
			case UMLRhapsodyPackage.CGI_ANCHOR__MDIRECTION:
				return MDIRECTION_EDEFAULT == null ? m_direction != null : !MDIRECTION_EDEFAULT.equals(m_direction);
			case UMLRhapsodyPackage.CGI_ANCHOR__MRPN:
				return m_rpn != null;
			case UMLRhapsodyPackage.CGI_ANCHOR__MANGLE_POINT1:
				return m_anglePoint1 != null && !m_anglePoint1.isEmpty();
			case UMLRhapsodyPackage.CGI_ANCHOR__MANGLE_POINT2:
				return m_anglePoint2 != null && !m_anglePoint2.isEmpty();
			case UMLRhapsodyPackage.CGI_ANCHOR__MLINE_STYLE:
				return MLINE_STYLE_EDEFAULT == null ? m_line_style != null : !MLINE_STYLE_EDEFAULT.equals(m_line_style);
			case UMLRhapsodyPackage.CGI_ANCHOR__MSOURCE_PORT:
				return m_SourcePort != null && !m_SourcePort.isEmpty();
			case UMLRhapsodyPackage.CGI_ANCHOR__MTARGET_PORT:
				return m_TargetPort != null && !m_TargetPort.isEmpty();
			case UMLRhapsodyPackage.CGI_ANCHOR__PROPERTIES:
				return properties != null;
			case UMLRhapsodyPackage.CGI_ANCHOR__MCOLOR:
				return m_color != null;
			case UMLRhapsodyPackage.CGI_ANCHOR__MLINE_WIDTH:
				return MLINE_WIDTH_EDEFAULT == null ? m_lineWidth != null : !MLINE_WIDTH_EDEFAULT.equals(m_lineWidth);
			case UMLRhapsodyPackage.CGI_ANCHOR__MARROW:
				return m_arrow != null && !m_arrow.isEmpty();
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
		result.append(", m_lineWidth: "); //$NON-NLS-1$
		result.append(m_lineWidth);
		result.append(", m_arrow: "); //$NON-NLS-1$
		result.append(m_arrow);
		result.append(')');
		return result.toString();
	}

} //CGIAnchorImpl
