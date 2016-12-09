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

import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIAssociationEnd;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIText;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IAssociationEndHandle;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IObjectLinkHandle;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IPropertyContainer;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.M_pModelObjectType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.M_pRootType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CGI Association End</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIAssociationEndImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIAssociationEndImpl#getM_pModelObject <em>MpModel Object</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIAssociationEndImpl#getM_pParent <em>MpParent</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIAssociationEndImpl#getM_pSource <em>MpSource</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIAssociationEndImpl#getM_sourceType <em>Msource Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIAssociationEndImpl#getM_pTarget <em>MpTarget</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIAssociationEndImpl#getM_targetType <em>Mtarget Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIAssociationEndImpl#getM_direction <em>Mdirection</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIAssociationEndImpl#getM_rpn <em>Mrpn</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIAssociationEndImpl#getM_anglePoint1 <em>Mangle Point1</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIAssociationEndImpl#getM_anglePoint2 <em>Mangle Point2</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIAssociationEndImpl#getM_line_style <em>Mline style</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIAssociationEndImpl#getM_SourcePort <em>MSource Port</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIAssociationEndImpl#getM_TargetPort <em>MTarget Port</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIAssociationEndImpl#getM_pInverseModelObject <em>MpInverse Model Object</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIAssociationEndImpl#getM_pInstance <em>MpInstance</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIAssociationEndImpl#getM_pInverseInstance <em>MpInverse Instance</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIAssociationEndImpl#getM_bShowSourceMultiplicity <em>MbShow Source Multiplicity</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIAssociationEndImpl#getM_bShowSourceRole <em>MbShow Source Role</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIAssociationEndImpl#getM_bShowTargetMultiplicity <em>MbShow Target Multiplicity</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIAssociationEndImpl#getM_bShowTargetRole <em>MbShow Target Role</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIAssociationEndImpl#getM_bShowLinkName <em>MbShow Link Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIAssociationEndImpl#getM_bShowSpecificType <em>MbShow Specific Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIAssociationEndImpl#getM_bInstance <em>MbInstance</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIAssociationEndImpl#getM_bShowQualifier1 <em>MbShow Qualifier1</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIAssociationEndImpl#getM_bShowQualifier2 <em>MbShow Qualifier2</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIAssociationEndImpl#getM_sourceRole <em>Msource Role</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIAssociationEndImpl#getM_targetRole <em>Mtarget Role</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIAssociationEndImpl#getM_sourceMultiplicity <em>Msource Multiplicity</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIAssociationEndImpl#getM_targetMultiplicity <em>Mtarget Multiplicity</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIAssociationEndImpl#getM_sourceQualifier <em>Msource Qualifier</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIAssociationEndImpl#getM_targetQualifier <em>Mtarget Qualifier</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIAssociationEndImpl#getM_specificType <em>Mspecific Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIAssociationEndImpl#getM_arrow <em>Marrow</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CGIAssociationEndImpl extends GraphElementsTypeImpl implements CGIAssociationEnd {
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
	 * The cached value of the '{@link #getM_pInverseModelObject() <em>MpInverse Model Object</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_pInverseModelObject()
	 * @generated
	 * @ordered
	 */
	protected IAssociationEndHandle m_pInverseModelObject;

	/**
	 * The cached value of the '{@link #getM_pInstance() <em>MpInstance</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_pInstance()
	 * @generated
	 * @ordered
	 */
	protected IObjectLinkHandle m_pInstance;

	/**
	 * The cached value of the '{@link #getM_pInverseInstance() <em>MpInverse Instance</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_pInverseInstance()
	 * @generated
	 * @ordered
	 */
	protected IObjectLinkHandle m_pInverseInstance;

	/**
	 * The default value of the '{@link #getM_bShowSourceMultiplicity() <em>MbShow Source Multiplicity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_bShowSourceMultiplicity()
	 * @generated
	 * @ordered
	 */
	protected static final String MBSHOW_SOURCE_MULTIPLICITY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_bShowSourceMultiplicity() <em>MbShow Source Multiplicity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_bShowSourceMultiplicity()
	 * @generated
	 * @ordered
	 */
	protected String m_bShowSourceMultiplicity = MBSHOW_SOURCE_MULTIPLICITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getM_bShowSourceRole() <em>MbShow Source Role</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_bShowSourceRole()
	 * @generated
	 * @ordered
	 */
	protected static final String MBSHOW_SOURCE_ROLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_bShowSourceRole() <em>MbShow Source Role</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_bShowSourceRole()
	 * @generated
	 * @ordered
	 */
	protected String m_bShowSourceRole = MBSHOW_SOURCE_ROLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getM_bShowTargetMultiplicity() <em>MbShow Target Multiplicity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_bShowTargetMultiplicity()
	 * @generated
	 * @ordered
	 */
	protected static final String MBSHOW_TARGET_MULTIPLICITY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_bShowTargetMultiplicity() <em>MbShow Target Multiplicity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_bShowTargetMultiplicity()
	 * @generated
	 * @ordered
	 */
	protected String m_bShowTargetMultiplicity = MBSHOW_TARGET_MULTIPLICITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getM_bShowTargetRole() <em>MbShow Target Role</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_bShowTargetRole()
	 * @generated
	 * @ordered
	 */
	protected static final String MBSHOW_TARGET_ROLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_bShowTargetRole() <em>MbShow Target Role</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_bShowTargetRole()
	 * @generated
	 * @ordered
	 */
	protected String m_bShowTargetRole = MBSHOW_TARGET_ROLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getM_bShowLinkName() <em>MbShow Link Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_bShowLinkName()
	 * @generated
	 * @ordered
	 */
	protected static final String MBSHOW_LINK_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_bShowLinkName() <em>MbShow Link Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_bShowLinkName()
	 * @generated
	 * @ordered
	 */
	protected String m_bShowLinkName = MBSHOW_LINK_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getM_bShowSpecificType() <em>MbShow Specific Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_bShowSpecificType()
	 * @generated
	 * @ordered
	 */
	protected static final String MBSHOW_SPECIFIC_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_bShowSpecificType() <em>MbShow Specific Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_bShowSpecificType()
	 * @generated
	 * @ordered
	 */
	protected String m_bShowSpecificType = MBSHOW_SPECIFIC_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getM_bInstance() <em>MbInstance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_bInstance()
	 * @generated
	 * @ordered
	 */
	protected static final String MBINSTANCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_bInstance() <em>MbInstance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_bInstance()
	 * @generated
	 * @ordered
	 */
	protected String m_bInstance = MBINSTANCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getM_bShowQualifier1() <em>MbShow Qualifier1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_bShowQualifier1()
	 * @generated
	 * @ordered
	 */
	protected static final String MBSHOW_QUALIFIER1_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_bShowQualifier1() <em>MbShow Qualifier1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_bShowQualifier1()
	 * @generated
	 * @ordered
	 */
	protected String m_bShowQualifier1 = MBSHOW_QUALIFIER1_EDEFAULT;

	/**
	 * The default value of the '{@link #getM_bShowQualifier2() <em>MbShow Qualifier2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_bShowQualifier2()
	 * @generated
	 * @ordered
	 */
	protected static final String MBSHOW_QUALIFIER2_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_bShowQualifier2() <em>MbShow Qualifier2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_bShowQualifier2()
	 * @generated
	 * @ordered
	 */
	protected String m_bShowQualifier2 = MBSHOW_QUALIFIER2_EDEFAULT;

	/**
	 * The cached value of the '{@link #getM_sourceRole() <em>Msource Role</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_sourceRole()
	 * @generated
	 * @ordered
	 */
	protected CGIText m_sourceRole;

	/**
	 * The cached value of the '{@link #getM_targetRole() <em>Mtarget Role</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_targetRole()
	 * @generated
	 * @ordered
	 */
	protected CGIText m_targetRole;

	/**
	 * The cached value of the '{@link #getM_sourceMultiplicity() <em>Msource Multiplicity</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_sourceMultiplicity()
	 * @generated
	 * @ordered
	 */
	protected CGIText m_sourceMultiplicity;

	/**
	 * The cached value of the '{@link #getM_targetMultiplicity() <em>Mtarget Multiplicity</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_targetMultiplicity()
	 * @generated
	 * @ordered
	 */
	protected CGIText m_targetMultiplicity;

	/**
	 * The cached value of the '{@link #getM_sourceQualifier() <em>Msource Qualifier</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_sourceQualifier()
	 * @generated
	 * @ordered
	 */
	protected CGIText m_sourceQualifier;

	/**
	 * The cached value of the '{@link #getM_targetQualifier() <em>Mtarget Qualifier</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_targetQualifier()
	 * @generated
	 * @ordered
	 */
	protected CGIText m_targetQualifier;

	/**
	 * The default value of the '{@link #getM_specificType() <em>Mspecific Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_specificType()
	 * @generated
	 * @ordered
	 */
	protected static final String MSPECIFIC_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_specificType() <em>Mspecific Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_specificType()
	 * @generated
	 * @ordered
	 */
	protected String m_specificType = MSPECIFIC_TYPE_EDEFAULT;

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
	protected CGIAssociationEndImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLRhapsodyPackage.eINSTANCE.getCGIAssociationEnd();
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
				NotificationChain msgs = oldProperties.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_ASSOCIATION_END__PROPERTIES, null, null);
				if (newProperties.eInternalContainer() == null) {
					msgs = newProperties.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_ASSOCIATION_END__PROPERTIES, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.CGI_ASSOCIATION_END__PROPERTIES, oldProperties, properties));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_ASSOCIATION_END__PROPERTIES, oldProperties, newProperties);
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
				msgs = ((InternalEObject)properties).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_ASSOCIATION_END__PROPERTIES, null, msgs);
			if (newProperties != null)
				msgs = ((InternalEObject)newProperties).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_ASSOCIATION_END__PROPERTIES, null, msgs);
			msgs = basicSetProperties(newProperties, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_ASSOCIATION_END__PROPERTIES, newProperties, newProperties));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.CGI_ASSOCIATION_END__MPMODEL_OBJECT, oldM_pModelObject, m_pModelObject));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_ASSOCIATION_END__MPMODEL_OBJECT, oldM_pModelObject, m_pModelObject));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_ASSOCIATION_END__MPPARENT, oldM_pParent, m_pParent));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.CGI_ASSOCIATION_END__MPSOURCE, oldM_pSource, m_pSource));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_ASSOCIATION_END__MPSOURCE, oldM_pSource, m_pSource));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_ASSOCIATION_END__MSOURCE_TYPE, oldM_sourceType, m_sourceType));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.CGI_ASSOCIATION_END__MPTARGET, oldM_pTarget, m_pTarget));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_ASSOCIATION_END__MPTARGET, oldM_pTarget, m_pTarget));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_ASSOCIATION_END__MTARGET_TYPE, oldM_targetType, m_targetType));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_ASSOCIATION_END__MDIRECTION, oldM_direction, m_direction));
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
				NotificationChain msgs = oldM_rpn.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_ASSOCIATION_END__MRPN, null, null);
				if (newM_rpn.eInternalContainer() == null) {
					msgs = newM_rpn.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_ASSOCIATION_END__MRPN, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.CGI_ASSOCIATION_END__MRPN, oldM_rpn, m_rpn));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_ASSOCIATION_END__MRPN, oldM_rpn, newM_rpn);
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
				msgs = ((InternalEObject)m_rpn).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_ASSOCIATION_END__MRPN, null, msgs);
			if (newM_rpn != null)
				msgs = ((InternalEObject)newM_rpn).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_ASSOCIATION_END__MRPN, null, msgs);
			msgs = basicSetM_rpn(newM_rpn, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_ASSOCIATION_END__MRPN, newM_rpn, newM_rpn));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getM_anglePoint1() {
		if (m_anglePoint1 == null) {
			m_anglePoint1 = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.CGI_ASSOCIATION_END__MANGLE_POINT1);
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
			m_anglePoint2 = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.CGI_ASSOCIATION_END__MANGLE_POINT2);
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_ASSOCIATION_END__MLINE_STYLE, oldM_line_style, m_line_style));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getM_SourcePort() {
		if (m_SourcePort == null) {
			m_SourcePort = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.CGI_ASSOCIATION_END__MSOURCE_PORT);
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
			m_TargetPort = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.CGI_ASSOCIATION_END__MTARGET_PORT);
		}
		return m_TargetPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IAssociationEndHandle getM_pInverseModelObject() {
		if (m_pInverseModelObject != null && m_pInverseModelObject.eIsProxy()) {
			InternalEObject oldM_pInverseModelObject = (InternalEObject)m_pInverseModelObject;
			m_pInverseModelObject = (IAssociationEndHandle)eResolveProxy(oldM_pInverseModelObject);
			if (m_pInverseModelObject != oldM_pInverseModelObject) {
				InternalEObject newM_pInverseModelObject = (InternalEObject)m_pInverseModelObject;
				NotificationChain msgs = oldM_pInverseModelObject.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_ASSOCIATION_END__MPINVERSE_MODEL_OBJECT, null, null);
				if (newM_pInverseModelObject.eInternalContainer() == null) {
					msgs = newM_pInverseModelObject.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_ASSOCIATION_END__MPINVERSE_MODEL_OBJECT, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.CGI_ASSOCIATION_END__MPINVERSE_MODEL_OBJECT, oldM_pInverseModelObject, m_pInverseModelObject));
			}
		}
		return m_pInverseModelObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IAssociationEndHandle basicGetM_pInverseModelObject() {
		return m_pInverseModelObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetM_pInverseModelObject(IAssociationEndHandle newM_pInverseModelObject, NotificationChain msgs) {
		IAssociationEndHandle oldM_pInverseModelObject = m_pInverseModelObject;
		m_pInverseModelObject = newM_pInverseModelObject;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_ASSOCIATION_END__MPINVERSE_MODEL_OBJECT, oldM_pInverseModelObject, newM_pInverseModelObject);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_pInverseModelObject(IAssociationEndHandle newM_pInverseModelObject) {
		if (newM_pInverseModelObject != m_pInverseModelObject) {
			NotificationChain msgs = null;
			if (m_pInverseModelObject != null)
				msgs = ((InternalEObject)m_pInverseModelObject).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_ASSOCIATION_END__MPINVERSE_MODEL_OBJECT, null, msgs);
			if (newM_pInverseModelObject != null)
				msgs = ((InternalEObject)newM_pInverseModelObject).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_ASSOCIATION_END__MPINVERSE_MODEL_OBJECT, null, msgs);
			msgs = basicSetM_pInverseModelObject(newM_pInverseModelObject, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_ASSOCIATION_END__MPINVERSE_MODEL_OBJECT, newM_pInverseModelObject, newM_pInverseModelObject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IObjectLinkHandle getM_pInstance() {
		if (m_pInstance != null && m_pInstance.eIsProxy()) {
			InternalEObject oldM_pInstance = (InternalEObject)m_pInstance;
			m_pInstance = (IObjectLinkHandle)eResolveProxy(oldM_pInstance);
			if (m_pInstance != oldM_pInstance) {
				InternalEObject newM_pInstance = (InternalEObject)m_pInstance;
				NotificationChain msgs = oldM_pInstance.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_ASSOCIATION_END__MPINSTANCE, null, null);
				if (newM_pInstance.eInternalContainer() == null) {
					msgs = newM_pInstance.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_ASSOCIATION_END__MPINSTANCE, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.CGI_ASSOCIATION_END__MPINSTANCE, oldM_pInstance, m_pInstance));
			}
		}
		return m_pInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IObjectLinkHandle basicGetM_pInstance() {
		return m_pInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetM_pInstance(IObjectLinkHandle newM_pInstance, NotificationChain msgs) {
		IObjectLinkHandle oldM_pInstance = m_pInstance;
		m_pInstance = newM_pInstance;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_ASSOCIATION_END__MPINSTANCE, oldM_pInstance, newM_pInstance);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_pInstance(IObjectLinkHandle newM_pInstance) {
		if (newM_pInstance != m_pInstance) {
			NotificationChain msgs = null;
			if (m_pInstance != null)
				msgs = ((InternalEObject)m_pInstance).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_ASSOCIATION_END__MPINSTANCE, null, msgs);
			if (newM_pInstance != null)
				msgs = ((InternalEObject)newM_pInstance).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_ASSOCIATION_END__MPINSTANCE, null, msgs);
			msgs = basicSetM_pInstance(newM_pInstance, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_ASSOCIATION_END__MPINSTANCE, newM_pInstance, newM_pInstance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IObjectLinkHandle getM_pInverseInstance() {
		if (m_pInverseInstance != null && m_pInverseInstance.eIsProxy()) {
			InternalEObject oldM_pInverseInstance = (InternalEObject)m_pInverseInstance;
			m_pInverseInstance = (IObjectLinkHandle)eResolveProxy(oldM_pInverseInstance);
			if (m_pInverseInstance != oldM_pInverseInstance) {
				InternalEObject newM_pInverseInstance = (InternalEObject)m_pInverseInstance;
				NotificationChain msgs = oldM_pInverseInstance.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_ASSOCIATION_END__MPINVERSE_INSTANCE, null, null);
				if (newM_pInverseInstance.eInternalContainer() == null) {
					msgs = newM_pInverseInstance.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_ASSOCIATION_END__MPINVERSE_INSTANCE, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.CGI_ASSOCIATION_END__MPINVERSE_INSTANCE, oldM_pInverseInstance, m_pInverseInstance));
			}
		}
		return m_pInverseInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IObjectLinkHandle basicGetM_pInverseInstance() {
		return m_pInverseInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetM_pInverseInstance(IObjectLinkHandle newM_pInverseInstance, NotificationChain msgs) {
		IObjectLinkHandle oldM_pInverseInstance = m_pInverseInstance;
		m_pInverseInstance = newM_pInverseInstance;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_ASSOCIATION_END__MPINVERSE_INSTANCE, oldM_pInverseInstance, newM_pInverseInstance);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_pInverseInstance(IObjectLinkHandle newM_pInverseInstance) {
		if (newM_pInverseInstance != m_pInverseInstance) {
			NotificationChain msgs = null;
			if (m_pInverseInstance != null)
				msgs = ((InternalEObject)m_pInverseInstance).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_ASSOCIATION_END__MPINVERSE_INSTANCE, null, msgs);
			if (newM_pInverseInstance != null)
				msgs = ((InternalEObject)newM_pInverseInstance).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_ASSOCIATION_END__MPINVERSE_INSTANCE, null, msgs);
			msgs = basicSetM_pInverseInstance(newM_pInverseInstance, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_ASSOCIATION_END__MPINVERSE_INSTANCE, newM_pInverseInstance, newM_pInverseInstance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_bShowSourceMultiplicity() {
		return m_bShowSourceMultiplicity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_bShowSourceMultiplicity(String newM_bShowSourceMultiplicity) {
		String oldM_bShowSourceMultiplicity = m_bShowSourceMultiplicity;
		m_bShowSourceMultiplicity = newM_bShowSourceMultiplicity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_ASSOCIATION_END__MBSHOW_SOURCE_MULTIPLICITY, oldM_bShowSourceMultiplicity, m_bShowSourceMultiplicity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_bShowSourceRole() {
		return m_bShowSourceRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_bShowSourceRole(String newM_bShowSourceRole) {
		String oldM_bShowSourceRole = m_bShowSourceRole;
		m_bShowSourceRole = newM_bShowSourceRole;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_ASSOCIATION_END__MBSHOW_SOURCE_ROLE, oldM_bShowSourceRole, m_bShowSourceRole));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_bShowTargetMultiplicity() {
		return m_bShowTargetMultiplicity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_bShowTargetMultiplicity(String newM_bShowTargetMultiplicity) {
		String oldM_bShowTargetMultiplicity = m_bShowTargetMultiplicity;
		m_bShowTargetMultiplicity = newM_bShowTargetMultiplicity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_ASSOCIATION_END__MBSHOW_TARGET_MULTIPLICITY, oldM_bShowTargetMultiplicity, m_bShowTargetMultiplicity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_bShowTargetRole() {
		return m_bShowTargetRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_bShowTargetRole(String newM_bShowTargetRole) {
		String oldM_bShowTargetRole = m_bShowTargetRole;
		m_bShowTargetRole = newM_bShowTargetRole;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_ASSOCIATION_END__MBSHOW_TARGET_ROLE, oldM_bShowTargetRole, m_bShowTargetRole));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_bShowLinkName() {
		return m_bShowLinkName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_bShowLinkName(String newM_bShowLinkName) {
		String oldM_bShowLinkName = m_bShowLinkName;
		m_bShowLinkName = newM_bShowLinkName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_ASSOCIATION_END__MBSHOW_LINK_NAME, oldM_bShowLinkName, m_bShowLinkName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_bShowSpecificType() {
		return m_bShowSpecificType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_bShowSpecificType(String newM_bShowSpecificType) {
		String oldM_bShowSpecificType = m_bShowSpecificType;
		m_bShowSpecificType = newM_bShowSpecificType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_ASSOCIATION_END__MBSHOW_SPECIFIC_TYPE, oldM_bShowSpecificType, m_bShowSpecificType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_bInstance() {
		return m_bInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_bInstance(String newM_bInstance) {
		String oldM_bInstance = m_bInstance;
		m_bInstance = newM_bInstance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_ASSOCIATION_END__MBINSTANCE, oldM_bInstance, m_bInstance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_bShowQualifier1() {
		return m_bShowQualifier1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_bShowQualifier1(String newM_bShowQualifier1) {
		String oldM_bShowQualifier1 = m_bShowQualifier1;
		m_bShowQualifier1 = newM_bShowQualifier1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_ASSOCIATION_END__MBSHOW_QUALIFIER1, oldM_bShowQualifier1, m_bShowQualifier1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_bShowQualifier2() {
		return m_bShowQualifier2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_bShowQualifier2(String newM_bShowQualifier2) {
		String oldM_bShowQualifier2 = m_bShowQualifier2;
		m_bShowQualifier2 = newM_bShowQualifier2;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_ASSOCIATION_END__MBSHOW_QUALIFIER2, oldM_bShowQualifier2, m_bShowQualifier2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGIText getM_sourceRole() {
		if (m_sourceRole != null && m_sourceRole.eIsProxy()) {
			InternalEObject oldM_sourceRole = (InternalEObject)m_sourceRole;
			m_sourceRole = (CGIText)eResolveProxy(oldM_sourceRole);
			if (m_sourceRole != oldM_sourceRole) {
				InternalEObject newM_sourceRole = (InternalEObject)m_sourceRole;
				NotificationChain msgs = oldM_sourceRole.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_ASSOCIATION_END__MSOURCE_ROLE, null, null);
				if (newM_sourceRole.eInternalContainer() == null) {
					msgs = newM_sourceRole.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_ASSOCIATION_END__MSOURCE_ROLE, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.CGI_ASSOCIATION_END__MSOURCE_ROLE, oldM_sourceRole, m_sourceRole));
			}
		}
		return m_sourceRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGIText basicGetM_sourceRole() {
		return m_sourceRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetM_sourceRole(CGIText newM_sourceRole, NotificationChain msgs) {
		CGIText oldM_sourceRole = m_sourceRole;
		m_sourceRole = newM_sourceRole;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_ASSOCIATION_END__MSOURCE_ROLE, oldM_sourceRole, newM_sourceRole);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_sourceRole(CGIText newM_sourceRole) {
		if (newM_sourceRole != m_sourceRole) {
			NotificationChain msgs = null;
			if (m_sourceRole != null)
				msgs = ((InternalEObject)m_sourceRole).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_ASSOCIATION_END__MSOURCE_ROLE, null, msgs);
			if (newM_sourceRole != null)
				msgs = ((InternalEObject)newM_sourceRole).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_ASSOCIATION_END__MSOURCE_ROLE, null, msgs);
			msgs = basicSetM_sourceRole(newM_sourceRole, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_ASSOCIATION_END__MSOURCE_ROLE, newM_sourceRole, newM_sourceRole));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGIText getM_targetRole() {
		if (m_targetRole != null && m_targetRole.eIsProxy()) {
			InternalEObject oldM_targetRole = (InternalEObject)m_targetRole;
			m_targetRole = (CGIText)eResolveProxy(oldM_targetRole);
			if (m_targetRole != oldM_targetRole) {
				InternalEObject newM_targetRole = (InternalEObject)m_targetRole;
				NotificationChain msgs = oldM_targetRole.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_ASSOCIATION_END__MTARGET_ROLE, null, null);
				if (newM_targetRole.eInternalContainer() == null) {
					msgs = newM_targetRole.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_ASSOCIATION_END__MTARGET_ROLE, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.CGI_ASSOCIATION_END__MTARGET_ROLE, oldM_targetRole, m_targetRole));
			}
		}
		return m_targetRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGIText basicGetM_targetRole() {
		return m_targetRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetM_targetRole(CGIText newM_targetRole, NotificationChain msgs) {
		CGIText oldM_targetRole = m_targetRole;
		m_targetRole = newM_targetRole;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_ASSOCIATION_END__MTARGET_ROLE, oldM_targetRole, newM_targetRole);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_targetRole(CGIText newM_targetRole) {
		if (newM_targetRole != m_targetRole) {
			NotificationChain msgs = null;
			if (m_targetRole != null)
				msgs = ((InternalEObject)m_targetRole).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_ASSOCIATION_END__MTARGET_ROLE, null, msgs);
			if (newM_targetRole != null)
				msgs = ((InternalEObject)newM_targetRole).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_ASSOCIATION_END__MTARGET_ROLE, null, msgs);
			msgs = basicSetM_targetRole(newM_targetRole, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_ASSOCIATION_END__MTARGET_ROLE, newM_targetRole, newM_targetRole));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGIText getM_sourceMultiplicity() {
		if (m_sourceMultiplicity != null && m_sourceMultiplicity.eIsProxy()) {
			InternalEObject oldM_sourceMultiplicity = (InternalEObject)m_sourceMultiplicity;
			m_sourceMultiplicity = (CGIText)eResolveProxy(oldM_sourceMultiplicity);
			if (m_sourceMultiplicity != oldM_sourceMultiplicity) {
				InternalEObject newM_sourceMultiplicity = (InternalEObject)m_sourceMultiplicity;
				NotificationChain msgs = oldM_sourceMultiplicity.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_ASSOCIATION_END__MSOURCE_MULTIPLICITY, null, null);
				if (newM_sourceMultiplicity.eInternalContainer() == null) {
					msgs = newM_sourceMultiplicity.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_ASSOCIATION_END__MSOURCE_MULTIPLICITY, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.CGI_ASSOCIATION_END__MSOURCE_MULTIPLICITY, oldM_sourceMultiplicity, m_sourceMultiplicity));
			}
		}
		return m_sourceMultiplicity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGIText basicGetM_sourceMultiplicity() {
		return m_sourceMultiplicity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetM_sourceMultiplicity(CGIText newM_sourceMultiplicity, NotificationChain msgs) {
		CGIText oldM_sourceMultiplicity = m_sourceMultiplicity;
		m_sourceMultiplicity = newM_sourceMultiplicity;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_ASSOCIATION_END__MSOURCE_MULTIPLICITY, oldM_sourceMultiplicity, newM_sourceMultiplicity);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_sourceMultiplicity(CGIText newM_sourceMultiplicity) {
		if (newM_sourceMultiplicity != m_sourceMultiplicity) {
			NotificationChain msgs = null;
			if (m_sourceMultiplicity != null)
				msgs = ((InternalEObject)m_sourceMultiplicity).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_ASSOCIATION_END__MSOURCE_MULTIPLICITY, null, msgs);
			if (newM_sourceMultiplicity != null)
				msgs = ((InternalEObject)newM_sourceMultiplicity).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_ASSOCIATION_END__MSOURCE_MULTIPLICITY, null, msgs);
			msgs = basicSetM_sourceMultiplicity(newM_sourceMultiplicity, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_ASSOCIATION_END__MSOURCE_MULTIPLICITY, newM_sourceMultiplicity, newM_sourceMultiplicity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGIText getM_targetMultiplicity() {
		if (m_targetMultiplicity != null && m_targetMultiplicity.eIsProxy()) {
			InternalEObject oldM_targetMultiplicity = (InternalEObject)m_targetMultiplicity;
			m_targetMultiplicity = (CGIText)eResolveProxy(oldM_targetMultiplicity);
			if (m_targetMultiplicity != oldM_targetMultiplicity) {
				InternalEObject newM_targetMultiplicity = (InternalEObject)m_targetMultiplicity;
				NotificationChain msgs = oldM_targetMultiplicity.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_ASSOCIATION_END__MTARGET_MULTIPLICITY, null, null);
				if (newM_targetMultiplicity.eInternalContainer() == null) {
					msgs = newM_targetMultiplicity.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_ASSOCIATION_END__MTARGET_MULTIPLICITY, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.CGI_ASSOCIATION_END__MTARGET_MULTIPLICITY, oldM_targetMultiplicity, m_targetMultiplicity));
			}
		}
		return m_targetMultiplicity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGIText basicGetM_targetMultiplicity() {
		return m_targetMultiplicity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetM_targetMultiplicity(CGIText newM_targetMultiplicity, NotificationChain msgs) {
		CGIText oldM_targetMultiplicity = m_targetMultiplicity;
		m_targetMultiplicity = newM_targetMultiplicity;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_ASSOCIATION_END__MTARGET_MULTIPLICITY, oldM_targetMultiplicity, newM_targetMultiplicity);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_targetMultiplicity(CGIText newM_targetMultiplicity) {
		if (newM_targetMultiplicity != m_targetMultiplicity) {
			NotificationChain msgs = null;
			if (m_targetMultiplicity != null)
				msgs = ((InternalEObject)m_targetMultiplicity).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_ASSOCIATION_END__MTARGET_MULTIPLICITY, null, msgs);
			if (newM_targetMultiplicity != null)
				msgs = ((InternalEObject)newM_targetMultiplicity).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_ASSOCIATION_END__MTARGET_MULTIPLICITY, null, msgs);
			msgs = basicSetM_targetMultiplicity(newM_targetMultiplicity, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_ASSOCIATION_END__MTARGET_MULTIPLICITY, newM_targetMultiplicity, newM_targetMultiplicity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGIText getM_sourceQualifier() {
		if (m_sourceQualifier != null && m_sourceQualifier.eIsProxy()) {
			InternalEObject oldM_sourceQualifier = (InternalEObject)m_sourceQualifier;
			m_sourceQualifier = (CGIText)eResolveProxy(oldM_sourceQualifier);
			if (m_sourceQualifier != oldM_sourceQualifier) {
				InternalEObject newM_sourceQualifier = (InternalEObject)m_sourceQualifier;
				NotificationChain msgs = oldM_sourceQualifier.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_ASSOCIATION_END__MSOURCE_QUALIFIER, null, null);
				if (newM_sourceQualifier.eInternalContainer() == null) {
					msgs = newM_sourceQualifier.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_ASSOCIATION_END__MSOURCE_QUALIFIER, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.CGI_ASSOCIATION_END__MSOURCE_QUALIFIER, oldM_sourceQualifier, m_sourceQualifier));
			}
		}
		return m_sourceQualifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGIText basicGetM_sourceQualifier() {
		return m_sourceQualifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetM_sourceQualifier(CGIText newM_sourceQualifier, NotificationChain msgs) {
		CGIText oldM_sourceQualifier = m_sourceQualifier;
		m_sourceQualifier = newM_sourceQualifier;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_ASSOCIATION_END__MSOURCE_QUALIFIER, oldM_sourceQualifier, newM_sourceQualifier);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_sourceQualifier(CGIText newM_sourceQualifier) {
		if (newM_sourceQualifier != m_sourceQualifier) {
			NotificationChain msgs = null;
			if (m_sourceQualifier != null)
				msgs = ((InternalEObject)m_sourceQualifier).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_ASSOCIATION_END__MSOURCE_QUALIFIER, null, msgs);
			if (newM_sourceQualifier != null)
				msgs = ((InternalEObject)newM_sourceQualifier).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_ASSOCIATION_END__MSOURCE_QUALIFIER, null, msgs);
			msgs = basicSetM_sourceQualifier(newM_sourceQualifier, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_ASSOCIATION_END__MSOURCE_QUALIFIER, newM_sourceQualifier, newM_sourceQualifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGIText getM_targetQualifier() {
		if (m_targetQualifier != null && m_targetQualifier.eIsProxy()) {
			InternalEObject oldM_targetQualifier = (InternalEObject)m_targetQualifier;
			m_targetQualifier = (CGIText)eResolveProxy(oldM_targetQualifier);
			if (m_targetQualifier != oldM_targetQualifier) {
				InternalEObject newM_targetQualifier = (InternalEObject)m_targetQualifier;
				NotificationChain msgs = oldM_targetQualifier.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_ASSOCIATION_END__MTARGET_QUALIFIER, null, null);
				if (newM_targetQualifier.eInternalContainer() == null) {
					msgs = newM_targetQualifier.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_ASSOCIATION_END__MTARGET_QUALIFIER, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.CGI_ASSOCIATION_END__MTARGET_QUALIFIER, oldM_targetQualifier, m_targetQualifier));
			}
		}
		return m_targetQualifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGIText basicGetM_targetQualifier() {
		return m_targetQualifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetM_targetQualifier(CGIText newM_targetQualifier, NotificationChain msgs) {
		CGIText oldM_targetQualifier = m_targetQualifier;
		m_targetQualifier = newM_targetQualifier;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_ASSOCIATION_END__MTARGET_QUALIFIER, oldM_targetQualifier, newM_targetQualifier);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_targetQualifier(CGIText newM_targetQualifier) {
		if (newM_targetQualifier != m_targetQualifier) {
			NotificationChain msgs = null;
			if (m_targetQualifier != null)
				msgs = ((InternalEObject)m_targetQualifier).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_ASSOCIATION_END__MTARGET_QUALIFIER, null, msgs);
			if (newM_targetQualifier != null)
				msgs = ((InternalEObject)newM_targetQualifier).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_ASSOCIATION_END__MTARGET_QUALIFIER, null, msgs);
			msgs = basicSetM_targetQualifier(newM_targetQualifier, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_ASSOCIATION_END__MTARGET_QUALIFIER, newM_targetQualifier, newM_targetQualifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_specificType() {
		return m_specificType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_specificType(String newM_specificType) {
		String oldM_specificType = m_specificType;
		m_specificType = newM_specificType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_ASSOCIATION_END__MSPECIFIC_TYPE, oldM_specificType, m_specificType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getM_arrow() {
		if (m_arrow == null) {
			m_arrow = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.CGI_ASSOCIATION_END__MARROW);
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
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__PROPERTIES:
				return basicSetProperties(null, msgs);
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MRPN:
				return basicSetM_rpn(null, msgs);
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MPINVERSE_MODEL_OBJECT:
				return basicSetM_pInverseModelObject(null, msgs);
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MPINSTANCE:
				return basicSetM_pInstance(null, msgs);
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MPINVERSE_INSTANCE:
				return basicSetM_pInverseInstance(null, msgs);
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MSOURCE_ROLE:
				return basicSetM_sourceRole(null, msgs);
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MTARGET_ROLE:
				return basicSetM_targetRole(null, msgs);
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MSOURCE_MULTIPLICITY:
				return basicSetM_sourceMultiplicity(null, msgs);
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MTARGET_MULTIPLICITY:
				return basicSetM_targetMultiplicity(null, msgs);
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MSOURCE_QUALIFIER:
				return basicSetM_sourceQualifier(null, msgs);
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MTARGET_QUALIFIER:
				return basicSetM_targetQualifier(null, msgs);
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
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__PROPERTIES:
				if (resolve) return getProperties();
				return basicGetProperties();
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MPMODEL_OBJECT:
				if (resolve) return getM_pModelObject();
				return basicGetM_pModelObject();
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MPPARENT:
				return getM_pParent();
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MPSOURCE:
				if (resolve) return getM_pSource();
				return basicGetM_pSource();
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MSOURCE_TYPE:
				return getM_sourceType();
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MPTARGET:
				if (resolve) return getM_pTarget();
				return basicGetM_pTarget();
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MTARGET_TYPE:
				return getM_targetType();
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MDIRECTION:
				return getM_direction();
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MRPN:
				if (resolve) return getM_rpn();
				return basicGetM_rpn();
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MANGLE_POINT1:
				return getM_anglePoint1();
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MANGLE_POINT2:
				return getM_anglePoint2();
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MLINE_STYLE:
				return getM_line_style();
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MSOURCE_PORT:
				return getM_SourcePort();
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MTARGET_PORT:
				return getM_TargetPort();
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MPINVERSE_MODEL_OBJECT:
				if (resolve) return getM_pInverseModelObject();
				return basicGetM_pInverseModelObject();
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MPINSTANCE:
				if (resolve) return getM_pInstance();
				return basicGetM_pInstance();
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MPINVERSE_INSTANCE:
				if (resolve) return getM_pInverseInstance();
				return basicGetM_pInverseInstance();
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MBSHOW_SOURCE_MULTIPLICITY:
				return getM_bShowSourceMultiplicity();
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MBSHOW_SOURCE_ROLE:
				return getM_bShowSourceRole();
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MBSHOW_TARGET_MULTIPLICITY:
				return getM_bShowTargetMultiplicity();
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MBSHOW_TARGET_ROLE:
				return getM_bShowTargetRole();
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MBSHOW_LINK_NAME:
				return getM_bShowLinkName();
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MBSHOW_SPECIFIC_TYPE:
				return getM_bShowSpecificType();
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MBINSTANCE:
				return getM_bInstance();
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MBSHOW_QUALIFIER1:
				return getM_bShowQualifier1();
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MBSHOW_QUALIFIER2:
				return getM_bShowQualifier2();
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MSOURCE_ROLE:
				if (resolve) return getM_sourceRole();
				return basicGetM_sourceRole();
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MTARGET_ROLE:
				if (resolve) return getM_targetRole();
				return basicGetM_targetRole();
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MSOURCE_MULTIPLICITY:
				if (resolve) return getM_sourceMultiplicity();
				return basicGetM_sourceMultiplicity();
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MTARGET_MULTIPLICITY:
				if (resolve) return getM_targetMultiplicity();
				return basicGetM_targetMultiplicity();
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MSOURCE_QUALIFIER:
				if (resolve) return getM_sourceQualifier();
				return basicGetM_sourceQualifier();
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MTARGET_QUALIFIER:
				if (resolve) return getM_targetQualifier();
				return basicGetM_targetQualifier();
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MSPECIFIC_TYPE:
				return getM_specificType();
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MARROW:
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
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__PROPERTIES:
				setProperties((IPropertyContainer)newValue);
				return;
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MPMODEL_OBJECT:
				setM_pModelObject((M_pModelObjectType)newValue);
				return;
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MPPARENT:
				setM_pParent((String)newValue);
				return;
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MPSOURCE:
				setM_pSource((M_pRootType)newValue);
				return;
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MSOURCE_TYPE:
				setM_sourceType((String)newValue);
				return;
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MPTARGET:
				setM_pTarget((M_pRootType)newValue);
				return;
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MTARGET_TYPE:
				setM_targetType((String)newValue);
				return;
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MDIRECTION:
				setM_direction((String)newValue);
				return;
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MRPN:
				setM_rpn((CGIText)newValue);
				return;
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MANGLE_POINT1:
				getM_anglePoint1().clear();
				getM_anglePoint1().addAll((Collection<? extends String>)newValue);
				return;
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MANGLE_POINT2:
				getM_anglePoint2().clear();
				getM_anglePoint2().addAll((Collection<? extends String>)newValue);
				return;
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MLINE_STYLE:
				setM_line_style((String)newValue);
				return;
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MSOURCE_PORT:
				getM_SourcePort().clear();
				getM_SourcePort().addAll((Collection<? extends String>)newValue);
				return;
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MTARGET_PORT:
				getM_TargetPort().clear();
				getM_TargetPort().addAll((Collection<? extends String>)newValue);
				return;
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MPINVERSE_MODEL_OBJECT:
				setM_pInverseModelObject((IAssociationEndHandle)newValue);
				return;
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MPINSTANCE:
				setM_pInstance((IObjectLinkHandle)newValue);
				return;
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MPINVERSE_INSTANCE:
				setM_pInverseInstance((IObjectLinkHandle)newValue);
				return;
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MBSHOW_SOURCE_MULTIPLICITY:
				setM_bShowSourceMultiplicity((String)newValue);
				return;
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MBSHOW_SOURCE_ROLE:
				setM_bShowSourceRole((String)newValue);
				return;
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MBSHOW_TARGET_MULTIPLICITY:
				setM_bShowTargetMultiplicity((String)newValue);
				return;
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MBSHOW_TARGET_ROLE:
				setM_bShowTargetRole((String)newValue);
				return;
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MBSHOW_LINK_NAME:
				setM_bShowLinkName((String)newValue);
				return;
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MBSHOW_SPECIFIC_TYPE:
				setM_bShowSpecificType((String)newValue);
				return;
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MBINSTANCE:
				setM_bInstance((String)newValue);
				return;
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MBSHOW_QUALIFIER1:
				setM_bShowQualifier1((String)newValue);
				return;
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MBSHOW_QUALIFIER2:
				setM_bShowQualifier2((String)newValue);
				return;
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MSOURCE_ROLE:
				setM_sourceRole((CGIText)newValue);
				return;
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MTARGET_ROLE:
				setM_targetRole((CGIText)newValue);
				return;
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MSOURCE_MULTIPLICITY:
				setM_sourceMultiplicity((CGIText)newValue);
				return;
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MTARGET_MULTIPLICITY:
				setM_targetMultiplicity((CGIText)newValue);
				return;
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MSOURCE_QUALIFIER:
				setM_sourceQualifier((CGIText)newValue);
				return;
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MTARGET_QUALIFIER:
				setM_targetQualifier((CGIText)newValue);
				return;
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MSPECIFIC_TYPE:
				setM_specificType((String)newValue);
				return;
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MARROW:
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
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__PROPERTIES:
				setProperties((IPropertyContainer)null);
				return;
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MPMODEL_OBJECT:
				setM_pModelObject((M_pModelObjectType)null);
				return;
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MPPARENT:
				setM_pParent(MPPARENT_EDEFAULT);
				return;
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MPSOURCE:
				setM_pSource((M_pRootType)null);
				return;
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MSOURCE_TYPE:
				setM_sourceType(MSOURCE_TYPE_EDEFAULT);
				return;
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MPTARGET:
				setM_pTarget((M_pRootType)null);
				return;
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MTARGET_TYPE:
				setM_targetType(MTARGET_TYPE_EDEFAULT);
				return;
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MDIRECTION:
				setM_direction(MDIRECTION_EDEFAULT);
				return;
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MRPN:
				setM_rpn((CGIText)null);
				return;
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MANGLE_POINT1:
				getM_anglePoint1().clear();
				return;
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MANGLE_POINT2:
				getM_anglePoint2().clear();
				return;
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MLINE_STYLE:
				setM_line_style(MLINE_STYLE_EDEFAULT);
				return;
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MSOURCE_PORT:
				getM_SourcePort().clear();
				return;
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MTARGET_PORT:
				getM_TargetPort().clear();
				return;
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MPINVERSE_MODEL_OBJECT:
				setM_pInverseModelObject((IAssociationEndHandle)null);
				return;
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MPINSTANCE:
				setM_pInstance((IObjectLinkHandle)null);
				return;
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MPINVERSE_INSTANCE:
				setM_pInverseInstance((IObjectLinkHandle)null);
				return;
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MBSHOW_SOURCE_MULTIPLICITY:
				setM_bShowSourceMultiplicity(MBSHOW_SOURCE_MULTIPLICITY_EDEFAULT);
				return;
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MBSHOW_SOURCE_ROLE:
				setM_bShowSourceRole(MBSHOW_SOURCE_ROLE_EDEFAULT);
				return;
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MBSHOW_TARGET_MULTIPLICITY:
				setM_bShowTargetMultiplicity(MBSHOW_TARGET_MULTIPLICITY_EDEFAULT);
				return;
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MBSHOW_TARGET_ROLE:
				setM_bShowTargetRole(MBSHOW_TARGET_ROLE_EDEFAULT);
				return;
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MBSHOW_LINK_NAME:
				setM_bShowLinkName(MBSHOW_LINK_NAME_EDEFAULT);
				return;
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MBSHOW_SPECIFIC_TYPE:
				setM_bShowSpecificType(MBSHOW_SPECIFIC_TYPE_EDEFAULT);
				return;
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MBINSTANCE:
				setM_bInstance(MBINSTANCE_EDEFAULT);
				return;
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MBSHOW_QUALIFIER1:
				setM_bShowQualifier1(MBSHOW_QUALIFIER1_EDEFAULT);
				return;
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MBSHOW_QUALIFIER2:
				setM_bShowQualifier2(MBSHOW_QUALIFIER2_EDEFAULT);
				return;
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MSOURCE_ROLE:
				setM_sourceRole((CGIText)null);
				return;
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MTARGET_ROLE:
				setM_targetRole((CGIText)null);
				return;
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MSOURCE_MULTIPLICITY:
				setM_sourceMultiplicity((CGIText)null);
				return;
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MTARGET_MULTIPLICITY:
				setM_targetMultiplicity((CGIText)null);
				return;
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MSOURCE_QUALIFIER:
				setM_sourceQualifier((CGIText)null);
				return;
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MTARGET_QUALIFIER:
				setM_targetQualifier((CGIText)null);
				return;
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MSPECIFIC_TYPE:
				setM_specificType(MSPECIFIC_TYPE_EDEFAULT);
				return;
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MARROW:
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
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__PROPERTIES:
				return properties != null;
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MPMODEL_OBJECT:
				return m_pModelObject != null;
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MPPARENT:
				return MPPARENT_EDEFAULT == null ? m_pParent != null : !MPPARENT_EDEFAULT.equals(m_pParent);
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MPSOURCE:
				return m_pSource != null;
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MSOURCE_TYPE:
				return MSOURCE_TYPE_EDEFAULT == null ? m_sourceType != null : !MSOURCE_TYPE_EDEFAULT.equals(m_sourceType);
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MPTARGET:
				return m_pTarget != null;
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MTARGET_TYPE:
				return MTARGET_TYPE_EDEFAULT == null ? m_targetType != null : !MTARGET_TYPE_EDEFAULT.equals(m_targetType);
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MDIRECTION:
				return MDIRECTION_EDEFAULT == null ? m_direction != null : !MDIRECTION_EDEFAULT.equals(m_direction);
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MRPN:
				return m_rpn != null;
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MANGLE_POINT1:
				return m_anglePoint1 != null && !m_anglePoint1.isEmpty();
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MANGLE_POINT2:
				return m_anglePoint2 != null && !m_anglePoint2.isEmpty();
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MLINE_STYLE:
				return MLINE_STYLE_EDEFAULT == null ? m_line_style != null : !MLINE_STYLE_EDEFAULT.equals(m_line_style);
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MSOURCE_PORT:
				return m_SourcePort != null && !m_SourcePort.isEmpty();
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MTARGET_PORT:
				return m_TargetPort != null && !m_TargetPort.isEmpty();
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MPINVERSE_MODEL_OBJECT:
				return m_pInverseModelObject != null;
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MPINSTANCE:
				return m_pInstance != null;
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MPINVERSE_INSTANCE:
				return m_pInverseInstance != null;
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MBSHOW_SOURCE_MULTIPLICITY:
				return MBSHOW_SOURCE_MULTIPLICITY_EDEFAULT == null ? m_bShowSourceMultiplicity != null : !MBSHOW_SOURCE_MULTIPLICITY_EDEFAULT.equals(m_bShowSourceMultiplicity);
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MBSHOW_SOURCE_ROLE:
				return MBSHOW_SOURCE_ROLE_EDEFAULT == null ? m_bShowSourceRole != null : !MBSHOW_SOURCE_ROLE_EDEFAULT.equals(m_bShowSourceRole);
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MBSHOW_TARGET_MULTIPLICITY:
				return MBSHOW_TARGET_MULTIPLICITY_EDEFAULT == null ? m_bShowTargetMultiplicity != null : !MBSHOW_TARGET_MULTIPLICITY_EDEFAULT.equals(m_bShowTargetMultiplicity);
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MBSHOW_TARGET_ROLE:
				return MBSHOW_TARGET_ROLE_EDEFAULT == null ? m_bShowTargetRole != null : !MBSHOW_TARGET_ROLE_EDEFAULT.equals(m_bShowTargetRole);
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MBSHOW_LINK_NAME:
				return MBSHOW_LINK_NAME_EDEFAULT == null ? m_bShowLinkName != null : !MBSHOW_LINK_NAME_EDEFAULT.equals(m_bShowLinkName);
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MBSHOW_SPECIFIC_TYPE:
				return MBSHOW_SPECIFIC_TYPE_EDEFAULT == null ? m_bShowSpecificType != null : !MBSHOW_SPECIFIC_TYPE_EDEFAULT.equals(m_bShowSpecificType);
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MBINSTANCE:
				return MBINSTANCE_EDEFAULT == null ? m_bInstance != null : !MBINSTANCE_EDEFAULT.equals(m_bInstance);
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MBSHOW_QUALIFIER1:
				return MBSHOW_QUALIFIER1_EDEFAULT == null ? m_bShowQualifier1 != null : !MBSHOW_QUALIFIER1_EDEFAULT.equals(m_bShowQualifier1);
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MBSHOW_QUALIFIER2:
				return MBSHOW_QUALIFIER2_EDEFAULT == null ? m_bShowQualifier2 != null : !MBSHOW_QUALIFIER2_EDEFAULT.equals(m_bShowQualifier2);
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MSOURCE_ROLE:
				return m_sourceRole != null;
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MTARGET_ROLE:
				return m_targetRole != null;
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MSOURCE_MULTIPLICITY:
				return m_sourceMultiplicity != null;
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MTARGET_MULTIPLICITY:
				return m_targetMultiplicity != null;
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MSOURCE_QUALIFIER:
				return m_sourceQualifier != null;
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MTARGET_QUALIFIER:
				return m_targetQualifier != null;
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MSPECIFIC_TYPE:
				return MSPECIFIC_TYPE_EDEFAULT == null ? m_specificType != null : !MSPECIFIC_TYPE_EDEFAULT.equals(m_specificType);
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MARROW:
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
		result.append(", m_bShowSourceMultiplicity: "); //$NON-NLS-1$
		result.append(m_bShowSourceMultiplicity);
		result.append(", m_bShowSourceRole: "); //$NON-NLS-1$
		result.append(m_bShowSourceRole);
		result.append(", m_bShowTargetMultiplicity: "); //$NON-NLS-1$
		result.append(m_bShowTargetMultiplicity);
		result.append(", m_bShowTargetRole: "); //$NON-NLS-1$
		result.append(m_bShowTargetRole);
		result.append(", m_bShowLinkName: "); //$NON-NLS-1$
		result.append(m_bShowLinkName);
		result.append(", m_bShowSpecificType: "); //$NON-NLS-1$
		result.append(m_bShowSpecificType);
		result.append(", m_bInstance: "); //$NON-NLS-1$
		result.append(m_bInstance);
		result.append(", m_bShowQualifier1: "); //$NON-NLS-1$
		result.append(m_bShowQualifier1);
		result.append(", m_bShowQualifier2: "); //$NON-NLS-1$
		result.append(m_bShowQualifier2);
		result.append(", m_specificType: "); //$NON-NLS-1$
		result.append(m_specificType);
		result.append(", m_arrow: "); //$NON-NLS-1$
		result.append(m_arrow);
		result.append(')');
		return result.toString();
	}

} //CGIAssociationEndImpl
