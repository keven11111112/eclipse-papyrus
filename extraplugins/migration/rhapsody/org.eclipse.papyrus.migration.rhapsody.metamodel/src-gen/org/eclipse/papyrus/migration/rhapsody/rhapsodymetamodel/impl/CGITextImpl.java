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

import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIText;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IColor;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CGI Text</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGITextImpl#getM_str <em>Mstr</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGITextImpl#getM_style <em>Mstyle</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGITextImpl#getM_color <em>Mcolor</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGITextImpl#getM_position <em>Mposition</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGITextImpl#getM_nIdent <em>MnIdent</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGITextImpl#getM_bImplicitSetRectPoints <em>MbImplicit Set Rect Points</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGITextImpl#getM_nOrientationCtrlPt <em>MnOrientation Ctrl Pt</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGITextImpl#getM_nVerticalSpacing <em>MnVertical Spacing</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGITextImpl#getM_nHorizontalSpacing <em>MnHorizontal Spacing</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGITextImpl#getM_transform <em>Mtransform</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CGITextImpl extends MinimalEObjectImpl.Container implements CGIText {
	/**
	 * The default value of the '{@link #getM_str() <em>Mstr</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_str()
	 * @generated
	 * @ordered
	 */
	protected static final String MSTR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_str() <em>Mstr</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_str()
	 * @generated
	 * @ordered
	 */
	protected String m_str = MSTR_EDEFAULT;

	/**
	 * The cached value of the '{@link #getM_style() <em>Mstyle</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_style()
	 * @generated
	 * @ordered
	 */
	protected EList<String> m_style;

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
	 * The cached value of the '{@link #getM_position() <em>Mposition</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_position()
	 * @generated
	 * @ordered
	 */
	protected EList<String> m_position;

	/**
	 * The default value of the '{@link #getM_nIdent() <em>MnIdent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_nIdent()
	 * @generated
	 * @ordered
	 */
	protected static final String MNIDENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_nIdent() <em>MnIdent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_nIdent()
	 * @generated
	 * @ordered
	 */
	protected String m_nIdent = MNIDENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getM_bImplicitSetRectPoints() <em>MbImplicit Set Rect Points</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_bImplicitSetRectPoints()
	 * @generated
	 * @ordered
	 */
	protected static final String MBIMPLICIT_SET_RECT_POINTS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_bImplicitSetRectPoints() <em>MbImplicit Set Rect Points</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_bImplicitSetRectPoints()
	 * @generated
	 * @ordered
	 */
	protected String m_bImplicitSetRectPoints = MBIMPLICIT_SET_RECT_POINTS_EDEFAULT;

	/**
	 * The default value of the '{@link #getM_nOrientationCtrlPt() <em>MnOrientation Ctrl Pt</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_nOrientationCtrlPt()
	 * @generated
	 * @ordered
	 */
	protected static final String MNORIENTATION_CTRL_PT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_nOrientationCtrlPt() <em>MnOrientation Ctrl Pt</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_nOrientationCtrlPt()
	 * @generated
	 * @ordered
	 */
	protected String m_nOrientationCtrlPt = MNORIENTATION_CTRL_PT_EDEFAULT;

	/**
	 * The default value of the '{@link #getM_nVerticalSpacing() <em>MnVertical Spacing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_nVerticalSpacing()
	 * @generated
	 * @ordered
	 */
	protected static final String MNVERTICAL_SPACING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_nVerticalSpacing() <em>MnVertical Spacing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_nVerticalSpacing()
	 * @generated
	 * @ordered
	 */
	protected String m_nVerticalSpacing = MNVERTICAL_SPACING_EDEFAULT;

	/**
	 * The default value of the '{@link #getM_nHorizontalSpacing() <em>MnHorizontal Spacing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_nHorizontalSpacing()
	 * @generated
	 * @ordered
	 */
	protected static final String MNHORIZONTAL_SPACING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_nHorizontalSpacing() <em>MnHorizontal Spacing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_nHorizontalSpacing()
	 * @generated
	 * @ordered
	 */
	protected String m_nHorizontalSpacing = MNHORIZONTAL_SPACING_EDEFAULT;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CGITextImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLRhapsodyPackage.eINSTANCE.getCGIText();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_str() {
		return m_str;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_str(String newM_str) {
		String oldM_str = m_str;
		m_str = newM_str;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_TEXT__MSTR, oldM_str, m_str));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getM_style() {
		if (m_style == null) {
			m_style = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.CGI_TEXT__MSTYLE);
		}
		return m_style;
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
				NotificationChain msgs = oldM_color.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_TEXT__MCOLOR, null, null);
				if (newM_color.eInternalContainer() == null) {
					msgs = newM_color.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_TEXT__MCOLOR, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.CGI_TEXT__MCOLOR, oldM_color, m_color));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_TEXT__MCOLOR, oldM_color, newM_color);
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
				msgs = ((InternalEObject)m_color).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_TEXT__MCOLOR, null, msgs);
			if (newM_color != null)
				msgs = ((InternalEObject)newM_color).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_TEXT__MCOLOR, null, msgs);
			msgs = basicSetM_color(newM_color, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_TEXT__MCOLOR, newM_color, newM_color));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getM_position() {
		if (m_position == null) {
			m_position = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.CGI_TEXT__MPOSITION);
		}
		return m_position;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_nIdent() {
		return m_nIdent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_nIdent(String newM_nIdent) {
		String oldM_nIdent = m_nIdent;
		m_nIdent = newM_nIdent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_TEXT__MNIDENT, oldM_nIdent, m_nIdent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_bImplicitSetRectPoints() {
		return m_bImplicitSetRectPoints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_bImplicitSetRectPoints(String newM_bImplicitSetRectPoints) {
		String oldM_bImplicitSetRectPoints = m_bImplicitSetRectPoints;
		m_bImplicitSetRectPoints = newM_bImplicitSetRectPoints;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_TEXT__MBIMPLICIT_SET_RECT_POINTS, oldM_bImplicitSetRectPoints, m_bImplicitSetRectPoints));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_nOrientationCtrlPt() {
		return m_nOrientationCtrlPt;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_nOrientationCtrlPt(String newM_nOrientationCtrlPt) {
		String oldM_nOrientationCtrlPt = m_nOrientationCtrlPt;
		m_nOrientationCtrlPt = newM_nOrientationCtrlPt;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_TEXT__MNORIENTATION_CTRL_PT, oldM_nOrientationCtrlPt, m_nOrientationCtrlPt));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_nVerticalSpacing() {
		return m_nVerticalSpacing;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_nVerticalSpacing(String newM_nVerticalSpacing) {
		String oldM_nVerticalSpacing = m_nVerticalSpacing;
		m_nVerticalSpacing = newM_nVerticalSpacing;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_TEXT__MNVERTICAL_SPACING, oldM_nVerticalSpacing, m_nVerticalSpacing));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_nHorizontalSpacing() {
		return m_nHorizontalSpacing;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_nHorizontalSpacing(String newM_nHorizontalSpacing) {
		String oldM_nHorizontalSpacing = m_nHorizontalSpacing;
		m_nHorizontalSpacing = newM_nHorizontalSpacing;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_TEXT__MNHORIZONTAL_SPACING, oldM_nHorizontalSpacing, m_nHorizontalSpacing));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getM_transform() {
		if (m_transform == null) {
			m_transform = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.CGI_TEXT__MTRANSFORM);
		}
		return m_transform;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLRhapsodyPackage.CGI_TEXT__MCOLOR:
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
			case UMLRhapsodyPackage.CGI_TEXT__MSTR:
				return getM_str();
			case UMLRhapsodyPackage.CGI_TEXT__MSTYLE:
				return getM_style();
			case UMLRhapsodyPackage.CGI_TEXT__MCOLOR:
				if (resolve) return getM_color();
				return basicGetM_color();
			case UMLRhapsodyPackage.CGI_TEXT__MPOSITION:
				return getM_position();
			case UMLRhapsodyPackage.CGI_TEXT__MNIDENT:
				return getM_nIdent();
			case UMLRhapsodyPackage.CGI_TEXT__MBIMPLICIT_SET_RECT_POINTS:
				return getM_bImplicitSetRectPoints();
			case UMLRhapsodyPackage.CGI_TEXT__MNORIENTATION_CTRL_PT:
				return getM_nOrientationCtrlPt();
			case UMLRhapsodyPackage.CGI_TEXT__MNVERTICAL_SPACING:
				return getM_nVerticalSpacing();
			case UMLRhapsodyPackage.CGI_TEXT__MNHORIZONTAL_SPACING:
				return getM_nHorizontalSpacing();
			case UMLRhapsodyPackage.CGI_TEXT__MTRANSFORM:
				return getM_transform();
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
			case UMLRhapsodyPackage.CGI_TEXT__MSTR:
				setM_str((String)newValue);
				return;
			case UMLRhapsodyPackage.CGI_TEXT__MSTYLE:
				getM_style().clear();
				getM_style().addAll((Collection<? extends String>)newValue);
				return;
			case UMLRhapsodyPackage.CGI_TEXT__MCOLOR:
				setM_color((IColor)newValue);
				return;
			case UMLRhapsodyPackage.CGI_TEXT__MPOSITION:
				getM_position().clear();
				getM_position().addAll((Collection<? extends String>)newValue);
				return;
			case UMLRhapsodyPackage.CGI_TEXT__MNIDENT:
				setM_nIdent((String)newValue);
				return;
			case UMLRhapsodyPackage.CGI_TEXT__MBIMPLICIT_SET_RECT_POINTS:
				setM_bImplicitSetRectPoints((String)newValue);
				return;
			case UMLRhapsodyPackage.CGI_TEXT__MNORIENTATION_CTRL_PT:
				setM_nOrientationCtrlPt((String)newValue);
				return;
			case UMLRhapsodyPackage.CGI_TEXT__MNVERTICAL_SPACING:
				setM_nVerticalSpacing((String)newValue);
				return;
			case UMLRhapsodyPackage.CGI_TEXT__MNHORIZONTAL_SPACING:
				setM_nHorizontalSpacing((String)newValue);
				return;
			case UMLRhapsodyPackage.CGI_TEXT__MTRANSFORM:
				getM_transform().clear();
				getM_transform().addAll((Collection<? extends String>)newValue);
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
			case UMLRhapsodyPackage.CGI_TEXT__MSTR:
				setM_str(MSTR_EDEFAULT);
				return;
			case UMLRhapsodyPackage.CGI_TEXT__MSTYLE:
				getM_style().clear();
				return;
			case UMLRhapsodyPackage.CGI_TEXT__MCOLOR:
				setM_color((IColor)null);
				return;
			case UMLRhapsodyPackage.CGI_TEXT__MPOSITION:
				getM_position().clear();
				return;
			case UMLRhapsodyPackage.CGI_TEXT__MNIDENT:
				setM_nIdent(MNIDENT_EDEFAULT);
				return;
			case UMLRhapsodyPackage.CGI_TEXT__MBIMPLICIT_SET_RECT_POINTS:
				setM_bImplicitSetRectPoints(MBIMPLICIT_SET_RECT_POINTS_EDEFAULT);
				return;
			case UMLRhapsodyPackage.CGI_TEXT__MNORIENTATION_CTRL_PT:
				setM_nOrientationCtrlPt(MNORIENTATION_CTRL_PT_EDEFAULT);
				return;
			case UMLRhapsodyPackage.CGI_TEXT__MNVERTICAL_SPACING:
				setM_nVerticalSpacing(MNVERTICAL_SPACING_EDEFAULT);
				return;
			case UMLRhapsodyPackage.CGI_TEXT__MNHORIZONTAL_SPACING:
				setM_nHorizontalSpacing(MNHORIZONTAL_SPACING_EDEFAULT);
				return;
			case UMLRhapsodyPackage.CGI_TEXT__MTRANSFORM:
				getM_transform().clear();
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
			case UMLRhapsodyPackage.CGI_TEXT__MSTR:
				return MSTR_EDEFAULT == null ? m_str != null : !MSTR_EDEFAULT.equals(m_str);
			case UMLRhapsodyPackage.CGI_TEXT__MSTYLE:
				return m_style != null && !m_style.isEmpty();
			case UMLRhapsodyPackage.CGI_TEXT__MCOLOR:
				return m_color != null;
			case UMLRhapsodyPackage.CGI_TEXT__MPOSITION:
				return m_position != null && !m_position.isEmpty();
			case UMLRhapsodyPackage.CGI_TEXT__MNIDENT:
				return MNIDENT_EDEFAULT == null ? m_nIdent != null : !MNIDENT_EDEFAULT.equals(m_nIdent);
			case UMLRhapsodyPackage.CGI_TEXT__MBIMPLICIT_SET_RECT_POINTS:
				return MBIMPLICIT_SET_RECT_POINTS_EDEFAULT == null ? m_bImplicitSetRectPoints != null : !MBIMPLICIT_SET_RECT_POINTS_EDEFAULT.equals(m_bImplicitSetRectPoints);
			case UMLRhapsodyPackage.CGI_TEXT__MNORIENTATION_CTRL_PT:
				return MNORIENTATION_CTRL_PT_EDEFAULT == null ? m_nOrientationCtrlPt != null : !MNORIENTATION_CTRL_PT_EDEFAULT.equals(m_nOrientationCtrlPt);
			case UMLRhapsodyPackage.CGI_TEXT__MNVERTICAL_SPACING:
				return MNVERTICAL_SPACING_EDEFAULT == null ? m_nVerticalSpacing != null : !MNVERTICAL_SPACING_EDEFAULT.equals(m_nVerticalSpacing);
			case UMLRhapsodyPackage.CGI_TEXT__MNHORIZONTAL_SPACING:
				return MNHORIZONTAL_SPACING_EDEFAULT == null ? m_nHorizontalSpacing != null : !MNHORIZONTAL_SPACING_EDEFAULT.equals(m_nHorizontalSpacing);
			case UMLRhapsodyPackage.CGI_TEXT__MTRANSFORM:
				return m_transform != null && !m_transform.isEmpty();
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
		result.append(" (m_str: "); //$NON-NLS-1$
		result.append(m_str);
		result.append(", m_style: "); //$NON-NLS-1$
		result.append(m_style);
		result.append(", m_position: "); //$NON-NLS-1$
		result.append(m_position);
		result.append(", m_nIdent: "); //$NON-NLS-1$
		result.append(m_nIdent);
		result.append(", m_bImplicitSetRectPoints: "); //$NON-NLS-1$
		result.append(m_bImplicitSetRectPoints);
		result.append(", m_nOrientationCtrlPt: "); //$NON-NLS-1$
		result.append(m_nOrientationCtrlPt);
		result.append(", m_nVerticalSpacing: "); //$NON-NLS-1$
		result.append(m_nVerticalSpacing);
		result.append(", m_nHorizontalSpacing: "); //$NON-NLS-1$
		result.append(m_nHorizontalSpacing);
		result.append(", m_transform: "); //$NON-NLS-1$
		result.append(m_transform);
		result.append(')');
		return result.toString();
	}

} //CGITextImpl
