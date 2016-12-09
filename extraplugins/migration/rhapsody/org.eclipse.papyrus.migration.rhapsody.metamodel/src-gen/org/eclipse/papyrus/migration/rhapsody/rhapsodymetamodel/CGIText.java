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
package org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CGI Text</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIText#getM_str <em>Mstr</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIText#getM_style <em>Mstyle</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIText#getM_color <em>Mcolor</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIText#getM_position <em>Mposition</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIText#getM_nIdent <em>MnIdent</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIText#getM_bImplicitSetRectPoints <em>MbImplicit Set Rect Points</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIText#getM_nOrientationCtrlPt <em>MnOrientation Ctrl Pt</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIText#getM_nVerticalSpacing <em>MnVertical Spacing</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIText#getM_nHorizontalSpacing <em>MnHorizontal Spacing</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIText#getM_transform <em>Mtransform</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getCGIText()
 * @model
 * @generated
 */
public interface CGIText extends EObject {
	/**
	 * Returns the value of the '<em><b>Mstr</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mstr</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mstr</em>' attribute.
	 * @see #setM_str(String)
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getCGIText_M_str()
	 * @model
	 * @generated
	 */
	String getM_str();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIText#getM_str <em>Mstr</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mstr</em>' attribute.
	 * @see #getM_str()
	 * @generated
	 */
	void setM_str(String value);

	/**
	 * Returns the value of the '<em><b>Mstyle</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mstyle</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mstyle</em>' attribute list.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getCGIText_M_style()
	 * @model unique="false"
	 * @generated
	 */
	EList<String> getM_style();

	/**
	 * Returns the value of the '<em><b>Mcolor</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mcolor</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mcolor</em>' containment reference.
	 * @see #setM_color(IColor)
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getCGIText_M_color()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	IColor getM_color();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIText#getM_color <em>Mcolor</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mcolor</em>' containment reference.
	 * @see #getM_color()
	 * @generated
	 */
	void setM_color(IColor value);

	/**
	 * Returns the value of the '<em><b>Mposition</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mposition</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mposition</em>' attribute list.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getCGIText_M_position()
	 * @model unique="false"
	 * @generated
	 */
	EList<String> getM_position();

	/**
	 * Returns the value of the '<em><b>MnIdent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>MnIdent</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>MnIdent</em>' attribute.
	 * @see #setM_nIdent(String)
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getCGIText_M_nIdent()
	 * @model
	 * @generated
	 */
	String getM_nIdent();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIText#getM_nIdent <em>MnIdent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>MnIdent</em>' attribute.
	 * @see #getM_nIdent()
	 * @generated
	 */
	void setM_nIdent(String value);

	/**
	 * Returns the value of the '<em><b>MbImplicit Set Rect Points</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>MbImplicit Set Rect Points</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>MbImplicit Set Rect Points</em>' attribute.
	 * @see #setM_bImplicitSetRectPoints(String)
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getCGIText_M_bImplicitSetRectPoints()
	 * @model
	 * @generated
	 */
	String getM_bImplicitSetRectPoints();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIText#getM_bImplicitSetRectPoints <em>MbImplicit Set Rect Points</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>MbImplicit Set Rect Points</em>' attribute.
	 * @see #getM_bImplicitSetRectPoints()
	 * @generated
	 */
	void setM_bImplicitSetRectPoints(String value);

	/**
	 * Returns the value of the '<em><b>MnOrientation Ctrl Pt</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>MnOrientation Ctrl Pt</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>MnOrientation Ctrl Pt</em>' attribute.
	 * @see #setM_nOrientationCtrlPt(String)
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getCGIText_M_nOrientationCtrlPt()
	 * @model
	 * @generated
	 */
	String getM_nOrientationCtrlPt();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIText#getM_nOrientationCtrlPt <em>MnOrientation Ctrl Pt</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>MnOrientation Ctrl Pt</em>' attribute.
	 * @see #getM_nOrientationCtrlPt()
	 * @generated
	 */
	void setM_nOrientationCtrlPt(String value);

	/**
	 * Returns the value of the '<em><b>MnVertical Spacing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>MnVertical Spacing</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>MnVertical Spacing</em>' attribute.
	 * @see #setM_nVerticalSpacing(String)
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getCGIText_M_nVerticalSpacing()
	 * @model
	 * @generated
	 */
	String getM_nVerticalSpacing();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIText#getM_nVerticalSpacing <em>MnVertical Spacing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>MnVertical Spacing</em>' attribute.
	 * @see #getM_nVerticalSpacing()
	 * @generated
	 */
	void setM_nVerticalSpacing(String value);

	/**
	 * Returns the value of the '<em><b>MnHorizontal Spacing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>MnHorizontal Spacing</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>MnHorizontal Spacing</em>' attribute.
	 * @see #setM_nHorizontalSpacing(String)
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getCGIText_M_nHorizontalSpacing()
	 * @model
	 * @generated
	 */
	String getM_nHorizontalSpacing();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIText#getM_nHorizontalSpacing <em>MnHorizontal Spacing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>MnHorizontal Spacing</em>' attribute.
	 * @see #getM_nHorizontalSpacing()
	 * @generated
	 */
	void setM_nHorizontalSpacing(String value);

	/**
	 * Returns the value of the '<em><b>Mtransform</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mtransform</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mtransform</em>' attribute list.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getCGIText_M_transform()
	 * @model unique="false"
	 * @generated
	 */
	EList<String> getM_transform();

} // CGIText
