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

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIMscColumnCR;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIMscExecutionOccurrence;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIMscMessage;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IExecutionOccurrence;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UnknownType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CGI Msc Execution Occurrence</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIMscExecutionOccurrenceImpl#getM_pModelObject <em>MpModel Object</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIMscExecutionOccurrenceImpl#getM_pParent <em>MpParent</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIMscExecutionOccurrenceImpl#getM_transform <em>Mtransform</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIMscExecutionOccurrenceImpl#getM_position <em>Mposition</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIMscExecutionOccurrenceImpl#getM_pInheritsFrom <em>MpInherits From</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIMscExecutionOccurrenceImpl#getM_nInheritanceMask <em>MnInheritance Mask</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIMscExecutionOccurrenceImpl#getM_SubType <em>MSub Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIMscExecutionOccurrenceImpl#getM_pStartMessage <em>MpStart Message</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CGIMscExecutionOccurrenceImpl extends GraphElementsTypeImpl implements CGIMscExecutionOccurrence {
	/**
	 * The cached value of the '{@link #getM_pModelObject() <em>MpModel Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_pModelObject()
	 * @generated
	 * @ordered
	 */
	protected IExecutionOccurrence m_pModelObject;

	/**
	 * The cached value of the '{@link #getM_pParent() <em>MpParent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_pParent()
	 * @generated
	 * @ordered
	 */
	protected CGIMscColumnCR m_pParent;

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
	 * The cached value of the '{@link #getM_position() <em>Mposition</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_position()
	 * @generated
	 * @ordered
	 */
	protected EList<String> m_position;

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
	 * The default value of the '{@link #getM_SubType() <em>MSub Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_SubType()
	 * @generated
	 * @ordered
	 */
	protected static final String MSUB_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_SubType() <em>MSub Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_SubType()
	 * @generated
	 * @ordered
	 */
	protected String m_SubType = MSUB_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getM_pStartMessage() <em>MpStart Message</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_pStartMessage()
	 * @generated
	 * @ordered
	 */
	protected CGIMscMessage m_pStartMessage;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CGIMscExecutionOccurrenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLRhapsodyPackage.eINSTANCE.getCGIMscExecutionOccurrence();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IExecutionOccurrence getM_pModelObject() {
		if (m_pModelObject != null && m_pModelObject.eIsProxy()) {
			InternalEObject oldM_pModelObject = (InternalEObject)m_pModelObject;
			m_pModelObject = (IExecutionOccurrence)eResolveProxy(oldM_pModelObject);
			if (m_pModelObject != oldM_pModelObject) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.CGI_MSC_EXECUTION_OCCURRENCE__MPMODEL_OBJECT, oldM_pModelObject, m_pModelObject));
			}
		}
		return m_pModelObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IExecutionOccurrence basicGetM_pModelObject() {
		return m_pModelObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_pModelObject(IExecutionOccurrence newM_pModelObject) {
		IExecutionOccurrence oldM_pModelObject = m_pModelObject;
		m_pModelObject = newM_pModelObject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_MSC_EXECUTION_OCCURRENCE__MPMODEL_OBJECT, oldM_pModelObject, m_pModelObject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGIMscColumnCR getM_pParent() {
		if (m_pParent != null && m_pParent.eIsProxy()) {
			InternalEObject oldM_pParent = (InternalEObject)m_pParent;
			m_pParent = (CGIMscColumnCR)eResolveProxy(oldM_pParent);
			if (m_pParent != oldM_pParent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.CGI_MSC_EXECUTION_OCCURRENCE__MPPARENT, oldM_pParent, m_pParent));
			}
		}
		return m_pParent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGIMscColumnCR basicGetM_pParent() {
		return m_pParent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_pParent(CGIMscColumnCR newM_pParent) {
		CGIMscColumnCR oldM_pParent = m_pParent;
		m_pParent = newM_pParent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_MSC_EXECUTION_OCCURRENCE__MPPARENT, oldM_pParent, m_pParent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getM_transform() {
		if (m_transform == null) {
			m_transform = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.CGI_MSC_EXECUTION_OCCURRENCE__MTRANSFORM);
		}
		return m_transform;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getM_position() {
		if (m_position == null) {
			m_position = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.CGI_MSC_EXECUTION_OCCURRENCE__MPOSITION);
		}
		return m_position;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UnknownType> getM_pInheritsFrom() {
		if (m_pInheritsFrom == null) {
			m_pInheritsFrom = new EObjectResolvingEList<UnknownType>(UnknownType.class, this, UMLRhapsodyPackage.CGI_MSC_EXECUTION_OCCURRENCE__MPINHERITS_FROM);
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_MSC_EXECUTION_OCCURRENCE__MNINHERITANCE_MASK, oldM_nInheritanceMask, m_nInheritanceMask));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_SubType() {
		return m_SubType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_SubType(String newM_SubType) {
		String oldM_SubType = m_SubType;
		m_SubType = newM_SubType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_MSC_EXECUTION_OCCURRENCE__MSUB_TYPE, oldM_SubType, m_SubType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGIMscMessage getM_pStartMessage() {
		if (m_pStartMessage != null && m_pStartMessage.eIsProxy()) {
			InternalEObject oldM_pStartMessage = (InternalEObject)m_pStartMessage;
			m_pStartMessage = (CGIMscMessage)eResolveProxy(oldM_pStartMessage);
			if (m_pStartMessage != oldM_pStartMessage) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.CGI_MSC_EXECUTION_OCCURRENCE__MPSTART_MESSAGE, oldM_pStartMessage, m_pStartMessage));
			}
		}
		return m_pStartMessage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGIMscMessage basicGetM_pStartMessage() {
		return m_pStartMessage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_pStartMessage(CGIMscMessage newM_pStartMessage) {
		CGIMscMessage oldM_pStartMessage = m_pStartMessage;
		m_pStartMessage = newM_pStartMessage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_MSC_EXECUTION_OCCURRENCE__MPSTART_MESSAGE, oldM_pStartMessage, m_pStartMessage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UMLRhapsodyPackage.CGI_MSC_EXECUTION_OCCURRENCE__MPMODEL_OBJECT:
				if (resolve) return getM_pModelObject();
				return basicGetM_pModelObject();
			case UMLRhapsodyPackage.CGI_MSC_EXECUTION_OCCURRENCE__MPPARENT:
				if (resolve) return getM_pParent();
				return basicGetM_pParent();
			case UMLRhapsodyPackage.CGI_MSC_EXECUTION_OCCURRENCE__MTRANSFORM:
				return getM_transform();
			case UMLRhapsodyPackage.CGI_MSC_EXECUTION_OCCURRENCE__MPOSITION:
				return getM_position();
			case UMLRhapsodyPackage.CGI_MSC_EXECUTION_OCCURRENCE__MPINHERITS_FROM:
				return getM_pInheritsFrom();
			case UMLRhapsodyPackage.CGI_MSC_EXECUTION_OCCURRENCE__MNINHERITANCE_MASK:
				return getM_nInheritanceMask();
			case UMLRhapsodyPackage.CGI_MSC_EXECUTION_OCCURRENCE__MSUB_TYPE:
				return getM_SubType();
			case UMLRhapsodyPackage.CGI_MSC_EXECUTION_OCCURRENCE__MPSTART_MESSAGE:
				if (resolve) return getM_pStartMessage();
				return basicGetM_pStartMessage();
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
			case UMLRhapsodyPackage.CGI_MSC_EXECUTION_OCCURRENCE__MPMODEL_OBJECT:
				setM_pModelObject((IExecutionOccurrence)newValue);
				return;
			case UMLRhapsodyPackage.CGI_MSC_EXECUTION_OCCURRENCE__MPPARENT:
				setM_pParent((CGIMscColumnCR)newValue);
				return;
			case UMLRhapsodyPackage.CGI_MSC_EXECUTION_OCCURRENCE__MTRANSFORM:
				getM_transform().clear();
				getM_transform().addAll((Collection<? extends String>)newValue);
				return;
			case UMLRhapsodyPackage.CGI_MSC_EXECUTION_OCCURRENCE__MPOSITION:
				getM_position().clear();
				getM_position().addAll((Collection<? extends String>)newValue);
				return;
			case UMLRhapsodyPackage.CGI_MSC_EXECUTION_OCCURRENCE__MPINHERITS_FROM:
				getM_pInheritsFrom().clear();
				getM_pInheritsFrom().addAll((Collection<? extends UnknownType>)newValue);
				return;
			case UMLRhapsodyPackage.CGI_MSC_EXECUTION_OCCURRENCE__MNINHERITANCE_MASK:
				setM_nInheritanceMask((String)newValue);
				return;
			case UMLRhapsodyPackage.CGI_MSC_EXECUTION_OCCURRENCE__MSUB_TYPE:
				setM_SubType((String)newValue);
				return;
			case UMLRhapsodyPackage.CGI_MSC_EXECUTION_OCCURRENCE__MPSTART_MESSAGE:
				setM_pStartMessage((CGIMscMessage)newValue);
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
			case UMLRhapsodyPackage.CGI_MSC_EXECUTION_OCCURRENCE__MPMODEL_OBJECT:
				setM_pModelObject((IExecutionOccurrence)null);
				return;
			case UMLRhapsodyPackage.CGI_MSC_EXECUTION_OCCURRENCE__MPPARENT:
				setM_pParent((CGIMscColumnCR)null);
				return;
			case UMLRhapsodyPackage.CGI_MSC_EXECUTION_OCCURRENCE__MTRANSFORM:
				getM_transform().clear();
				return;
			case UMLRhapsodyPackage.CGI_MSC_EXECUTION_OCCURRENCE__MPOSITION:
				getM_position().clear();
				return;
			case UMLRhapsodyPackage.CGI_MSC_EXECUTION_OCCURRENCE__MPINHERITS_FROM:
				getM_pInheritsFrom().clear();
				return;
			case UMLRhapsodyPackage.CGI_MSC_EXECUTION_OCCURRENCE__MNINHERITANCE_MASK:
				setM_nInheritanceMask(MNINHERITANCE_MASK_EDEFAULT);
				return;
			case UMLRhapsodyPackage.CGI_MSC_EXECUTION_OCCURRENCE__MSUB_TYPE:
				setM_SubType(MSUB_TYPE_EDEFAULT);
				return;
			case UMLRhapsodyPackage.CGI_MSC_EXECUTION_OCCURRENCE__MPSTART_MESSAGE:
				setM_pStartMessage((CGIMscMessage)null);
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
			case UMLRhapsodyPackage.CGI_MSC_EXECUTION_OCCURRENCE__MPMODEL_OBJECT:
				return m_pModelObject != null;
			case UMLRhapsodyPackage.CGI_MSC_EXECUTION_OCCURRENCE__MPPARENT:
				return m_pParent != null;
			case UMLRhapsodyPackage.CGI_MSC_EXECUTION_OCCURRENCE__MTRANSFORM:
				return m_transform != null && !m_transform.isEmpty();
			case UMLRhapsodyPackage.CGI_MSC_EXECUTION_OCCURRENCE__MPOSITION:
				return m_position != null && !m_position.isEmpty();
			case UMLRhapsodyPackage.CGI_MSC_EXECUTION_OCCURRENCE__MPINHERITS_FROM:
				return m_pInheritsFrom != null && !m_pInheritsFrom.isEmpty();
			case UMLRhapsodyPackage.CGI_MSC_EXECUTION_OCCURRENCE__MNINHERITANCE_MASK:
				return MNINHERITANCE_MASK_EDEFAULT == null ? m_nInheritanceMask != null : !MNINHERITANCE_MASK_EDEFAULT.equals(m_nInheritanceMask);
			case UMLRhapsodyPackage.CGI_MSC_EXECUTION_OCCURRENCE__MSUB_TYPE:
				return MSUB_TYPE_EDEFAULT == null ? m_SubType != null : !MSUB_TYPE_EDEFAULT.equals(m_SubType);
			case UMLRhapsodyPackage.CGI_MSC_EXECUTION_OCCURRENCE__MPSTART_MESSAGE:
				return m_pStartMessage != null;
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
		result.append(", m_position: "); //$NON-NLS-1$
		result.append(m_position);
		result.append(", m_nInheritanceMask: "); //$NON-NLS-1$
		result.append(m_nInheritanceMask);
		result.append(", m_SubType: "); //$NON-NLS-1$
		result.append(m_SubType);
		result.append(')');
		return result.toString();
	}

} //CGIMscExecutionOccurrenceImpl
