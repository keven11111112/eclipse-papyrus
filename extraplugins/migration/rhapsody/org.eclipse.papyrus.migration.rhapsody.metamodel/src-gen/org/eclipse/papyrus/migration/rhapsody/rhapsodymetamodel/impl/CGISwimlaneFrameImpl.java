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

import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGISwimlaneFrame;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CompartmentsType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.GraphElementsType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UnknownType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CGI Swimlane Frame</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGISwimlaneFrameImpl#getM_pModelObject <em>MpModel Object</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGISwimlaneFrameImpl#getM_pParent <em>MpParent</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGISwimlaneFrameImpl#getM_polygon <em>Mpolygon</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGISwimlaneFrameImpl#getM_nNameFormat <em>MnName Format</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGISwimlaneFrameImpl#getM_nIsNameFormat <em>MnIs Name Format</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGISwimlaneFrameImpl#getFrameset <em>Frameset</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGISwimlaneFrameImpl#getM_transform <em>Mtransform</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGISwimlaneFrameImpl#getM_bFramesetModified <em>MbFrameset Modified</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGISwimlaneFrameImpl#getCompartments <em>Compartments</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CGISwimlaneFrameImpl extends GraphElementsTypeImpl implements CGISwimlaneFrame {
	/**
	 * The cached value of the '{@link #getM_pModelObject() <em>MpModel Object</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_pModelObject()
	 * @generated
	 * @ordered
	 */
	protected EList<UnknownType> m_pModelObject;

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
	 * The cached value of the '{@link #getM_transform() <em>Mtransform</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_transform()
	 * @generated
	 * @ordered
	 */
	protected EList<String> m_transform;

	/**
	 * The default value of the '{@link #getM_bFramesetModified() <em>MbFrameset Modified</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_bFramesetModified()
	 * @generated
	 * @ordered
	 */
	protected static final String MBFRAMESET_MODIFIED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_bFramesetModified() <em>MbFrameset Modified</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_bFramesetModified()
	 * @generated
	 * @ordered
	 */
	protected String m_bFramesetModified = MBFRAMESET_MODIFIED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getCompartments() <em>Compartments</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompartments()
	 * @generated
	 * @ordered
	 */
	protected CompartmentsType compartments;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CGISwimlaneFrameImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLRhapsodyPackage.eINSTANCE.getCGISwimlaneFrame();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UnknownType> getM_pModelObject() {
		if (m_pModelObject == null) {
			m_pModelObject = new EObjectResolvingEList<UnknownType>(UnknownType.class, this, UMLRhapsodyPackage.CGI_SWIMLANE_FRAME__MPMODEL_OBJECT);
		}
		return m_pModelObject;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.CGI_SWIMLANE_FRAME__MPPARENT, oldM_pParent, m_pParent));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_SWIMLANE_FRAME__MPPARENT, oldM_pParent, m_pParent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getM_polygon() {
		if (m_polygon == null) {
			m_polygon = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.CGI_SWIMLANE_FRAME__MPOLYGON);
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_SWIMLANE_FRAME__MNNAME_FORMAT, oldM_nNameFormat, m_nNameFormat));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_SWIMLANE_FRAME__MNIS_NAME_FORMAT, oldM_nIsNameFormat, m_nIsNameFormat));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_SWIMLANE_FRAME__FRAMESET, oldFrameset, frameset));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getM_transform() {
		if (m_transform == null) {
			m_transform = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.CGI_SWIMLANE_FRAME__MTRANSFORM);
		}
		return m_transform;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_bFramesetModified() {
		return m_bFramesetModified;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_bFramesetModified(String newM_bFramesetModified) {
		String oldM_bFramesetModified = m_bFramesetModified;
		m_bFramesetModified = newM_bFramesetModified;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_SWIMLANE_FRAME__MBFRAMESET_MODIFIED, oldM_bFramesetModified, m_bFramesetModified));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompartmentsType getCompartments() {
		if (compartments != null && compartments.eIsProxy()) {
			InternalEObject oldCompartments = (InternalEObject)compartments;
			compartments = (CompartmentsType)eResolveProxy(oldCompartments);
			if (compartments != oldCompartments) {
				InternalEObject newCompartments = (InternalEObject)compartments;
				NotificationChain msgs = oldCompartments.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_SWIMLANE_FRAME__COMPARTMENTS, null, null);
				if (newCompartments.eInternalContainer() == null) {
					msgs = newCompartments.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_SWIMLANE_FRAME__COMPARTMENTS, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.CGI_SWIMLANE_FRAME__COMPARTMENTS, oldCompartments, compartments));
			}
		}
		return compartments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompartmentsType basicGetCompartments() {
		return compartments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCompartments(CompartmentsType newCompartments, NotificationChain msgs) {
		CompartmentsType oldCompartments = compartments;
		compartments = newCompartments;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_SWIMLANE_FRAME__COMPARTMENTS, oldCompartments, newCompartments);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompartments(CompartmentsType newCompartments) {
		if (newCompartments != compartments) {
			NotificationChain msgs = null;
			if (compartments != null)
				msgs = ((InternalEObject)compartments).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_SWIMLANE_FRAME__COMPARTMENTS, null, msgs);
			if (newCompartments != null)
				msgs = ((InternalEObject)newCompartments).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_SWIMLANE_FRAME__COMPARTMENTS, null, msgs);
			msgs = basicSetCompartments(newCompartments, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_SWIMLANE_FRAME__COMPARTMENTS, newCompartments, newCompartments));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLRhapsodyPackage.CGI_SWIMLANE_FRAME__COMPARTMENTS:
				return basicSetCompartments(null, msgs);
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
			case UMLRhapsodyPackage.CGI_SWIMLANE_FRAME__MPMODEL_OBJECT:
				return getM_pModelObject();
			case UMLRhapsodyPackage.CGI_SWIMLANE_FRAME__MPPARENT:
				if (resolve) return getM_pParent();
				return basicGetM_pParent();
			case UMLRhapsodyPackage.CGI_SWIMLANE_FRAME__MPOLYGON:
				return getM_polygon();
			case UMLRhapsodyPackage.CGI_SWIMLANE_FRAME__MNNAME_FORMAT:
				return getM_nNameFormat();
			case UMLRhapsodyPackage.CGI_SWIMLANE_FRAME__MNIS_NAME_FORMAT:
				return getM_nIsNameFormat();
			case UMLRhapsodyPackage.CGI_SWIMLANE_FRAME__FRAMESET:
				return getFrameset();
			case UMLRhapsodyPackage.CGI_SWIMLANE_FRAME__MTRANSFORM:
				return getM_transform();
			case UMLRhapsodyPackage.CGI_SWIMLANE_FRAME__MBFRAMESET_MODIFIED:
				return getM_bFramesetModified();
			case UMLRhapsodyPackage.CGI_SWIMLANE_FRAME__COMPARTMENTS:
				if (resolve) return getCompartments();
				return basicGetCompartments();
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
			case UMLRhapsodyPackage.CGI_SWIMLANE_FRAME__MPMODEL_OBJECT:
				getM_pModelObject().clear();
				getM_pModelObject().addAll((Collection<? extends UnknownType>)newValue);
				return;
			case UMLRhapsodyPackage.CGI_SWIMLANE_FRAME__MPPARENT:
				setM_pParent((GraphElementsType)newValue);
				return;
			case UMLRhapsodyPackage.CGI_SWIMLANE_FRAME__MPOLYGON:
				getM_polygon().clear();
				getM_polygon().addAll((Collection<? extends String>)newValue);
				return;
			case UMLRhapsodyPackage.CGI_SWIMLANE_FRAME__MNNAME_FORMAT:
				setM_nNameFormat((String)newValue);
				return;
			case UMLRhapsodyPackage.CGI_SWIMLANE_FRAME__MNIS_NAME_FORMAT:
				setM_nIsNameFormat((String)newValue);
				return;
			case UMLRhapsodyPackage.CGI_SWIMLANE_FRAME__FRAMESET:
				setFrameset((String)newValue);
				return;
			case UMLRhapsodyPackage.CGI_SWIMLANE_FRAME__MTRANSFORM:
				getM_transform().clear();
				getM_transform().addAll((Collection<? extends String>)newValue);
				return;
			case UMLRhapsodyPackage.CGI_SWIMLANE_FRAME__MBFRAMESET_MODIFIED:
				setM_bFramesetModified((String)newValue);
				return;
			case UMLRhapsodyPackage.CGI_SWIMLANE_FRAME__COMPARTMENTS:
				setCompartments((CompartmentsType)newValue);
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
			case UMLRhapsodyPackage.CGI_SWIMLANE_FRAME__MPMODEL_OBJECT:
				getM_pModelObject().clear();
				return;
			case UMLRhapsodyPackage.CGI_SWIMLANE_FRAME__MPPARENT:
				setM_pParent((GraphElementsType)null);
				return;
			case UMLRhapsodyPackage.CGI_SWIMLANE_FRAME__MPOLYGON:
				getM_polygon().clear();
				return;
			case UMLRhapsodyPackage.CGI_SWIMLANE_FRAME__MNNAME_FORMAT:
				setM_nNameFormat(MNNAME_FORMAT_EDEFAULT);
				return;
			case UMLRhapsodyPackage.CGI_SWIMLANE_FRAME__MNIS_NAME_FORMAT:
				setM_nIsNameFormat(MNIS_NAME_FORMAT_EDEFAULT);
				return;
			case UMLRhapsodyPackage.CGI_SWIMLANE_FRAME__FRAMESET:
				setFrameset(FRAMESET_EDEFAULT);
				return;
			case UMLRhapsodyPackage.CGI_SWIMLANE_FRAME__MTRANSFORM:
				getM_transform().clear();
				return;
			case UMLRhapsodyPackage.CGI_SWIMLANE_FRAME__MBFRAMESET_MODIFIED:
				setM_bFramesetModified(MBFRAMESET_MODIFIED_EDEFAULT);
				return;
			case UMLRhapsodyPackage.CGI_SWIMLANE_FRAME__COMPARTMENTS:
				setCompartments((CompartmentsType)null);
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
			case UMLRhapsodyPackage.CGI_SWIMLANE_FRAME__MPMODEL_OBJECT:
				return m_pModelObject != null && !m_pModelObject.isEmpty();
			case UMLRhapsodyPackage.CGI_SWIMLANE_FRAME__MPPARENT:
				return m_pParent != null;
			case UMLRhapsodyPackage.CGI_SWIMLANE_FRAME__MPOLYGON:
				return m_polygon != null && !m_polygon.isEmpty();
			case UMLRhapsodyPackage.CGI_SWIMLANE_FRAME__MNNAME_FORMAT:
				return MNNAME_FORMAT_EDEFAULT == null ? m_nNameFormat != null : !MNNAME_FORMAT_EDEFAULT.equals(m_nNameFormat);
			case UMLRhapsodyPackage.CGI_SWIMLANE_FRAME__MNIS_NAME_FORMAT:
				return MNIS_NAME_FORMAT_EDEFAULT == null ? m_nIsNameFormat != null : !MNIS_NAME_FORMAT_EDEFAULT.equals(m_nIsNameFormat);
			case UMLRhapsodyPackage.CGI_SWIMLANE_FRAME__FRAMESET:
				return FRAMESET_EDEFAULT == null ? frameset != null : !FRAMESET_EDEFAULT.equals(frameset);
			case UMLRhapsodyPackage.CGI_SWIMLANE_FRAME__MTRANSFORM:
				return m_transform != null && !m_transform.isEmpty();
			case UMLRhapsodyPackage.CGI_SWIMLANE_FRAME__MBFRAMESET_MODIFIED:
				return MBFRAMESET_MODIFIED_EDEFAULT == null ? m_bFramesetModified != null : !MBFRAMESET_MODIFIED_EDEFAULT.equals(m_bFramesetModified);
			case UMLRhapsodyPackage.CGI_SWIMLANE_FRAME__COMPARTMENTS:
				return compartments != null;
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
		result.append(" (m_polygon: "); //$NON-NLS-1$
		result.append(m_polygon);
		result.append(", m_nNameFormat: "); //$NON-NLS-1$
		result.append(m_nNameFormat);
		result.append(", m_nIsNameFormat: "); //$NON-NLS-1$
		result.append(m_nIsNameFormat);
		result.append(", frameset: "); //$NON-NLS-1$
		result.append(frameset);
		result.append(", m_transform: "); //$NON-NLS-1$
		result.append(m_transform);
		result.append(", m_bFramesetModified: "); //$NON-NLS-1$
		result.append(m_bFramesetModified);
		result.append(')');
		return result.toString();
	}

} //CGISwimlaneFrameImpl
