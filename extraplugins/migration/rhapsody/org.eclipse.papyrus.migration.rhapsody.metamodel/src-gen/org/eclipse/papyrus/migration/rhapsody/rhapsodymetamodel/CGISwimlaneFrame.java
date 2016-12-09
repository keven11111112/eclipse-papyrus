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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CGI Swimlane Frame</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGISwimlaneFrame#getM_pModelObject <em>MpModel Object</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGISwimlaneFrame#getM_pParent <em>MpParent</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGISwimlaneFrame#getM_polygon <em>Mpolygon</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGISwimlaneFrame#getM_nNameFormat <em>MnName Format</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGISwimlaneFrame#getM_nIsNameFormat <em>MnIs Name Format</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGISwimlaneFrame#getFrameset <em>Frameset</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGISwimlaneFrame#getM_transform <em>Mtransform</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGISwimlaneFrame#getM_bFramesetModified <em>MbFrameset Modified</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGISwimlaneFrame#getCompartments <em>Compartments</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getCGISwimlaneFrame()
 * @model
 * @generated
 */
public interface CGISwimlaneFrame extends GraphElementsType {
	/**
	 * Returns the value of the '<em><b>MpModel Object</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UnknownType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>MpModel Object</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>MpModel Object</em>' reference list.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getCGISwimlaneFrame_M_pModelObject()
	 * @model
	 * @generated
	 */
	EList<UnknownType> getM_pModelObject();

	/**
	 * Returns the value of the '<em><b>MpParent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>MpParent</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>MpParent</em>' reference.
	 * @see #setM_pParent(GraphElementsType)
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getCGISwimlaneFrame_M_pParent()
	 * @model
	 * @generated
	 */
	GraphElementsType getM_pParent();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGISwimlaneFrame#getM_pParent <em>MpParent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>MpParent</em>' reference.
	 * @see #getM_pParent()
	 * @generated
	 */
	void setM_pParent(GraphElementsType value);

	/**
	 * Returns the value of the '<em><b>Mpolygon</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mpolygon</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mpolygon</em>' attribute list.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getCGISwimlaneFrame_M_polygon()
	 * @model unique="false"
	 * @generated
	 */
	EList<String> getM_polygon();

	/**
	 * Returns the value of the '<em><b>MnName Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>MnName Format</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>MnName Format</em>' attribute.
	 * @see #setM_nNameFormat(String)
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getCGISwimlaneFrame_M_nNameFormat()
	 * @model
	 * @generated
	 */
	String getM_nNameFormat();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGISwimlaneFrame#getM_nNameFormat <em>MnName Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>MnName Format</em>' attribute.
	 * @see #getM_nNameFormat()
	 * @generated
	 */
	void setM_nNameFormat(String value);

	/**
	 * Returns the value of the '<em><b>MnIs Name Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>MnIs Name Format</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>MnIs Name Format</em>' attribute.
	 * @see #setM_nIsNameFormat(String)
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getCGISwimlaneFrame_M_nIsNameFormat()
	 * @model
	 * @generated
	 */
	String getM_nIsNameFormat();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGISwimlaneFrame#getM_nIsNameFormat <em>MnIs Name Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>MnIs Name Format</em>' attribute.
	 * @see #getM_nIsNameFormat()
	 * @generated
	 */
	void setM_nIsNameFormat(String value);

	/**
	 * Returns the value of the '<em><b>Frameset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Frameset</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Frameset</em>' attribute.
	 * @see #setFrameset(String)
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getCGISwimlaneFrame_Frameset()
	 * @model
	 * @generated
	 */
	String getFrameset();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGISwimlaneFrame#getFrameset <em>Frameset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Frameset</em>' attribute.
	 * @see #getFrameset()
	 * @generated
	 */
	void setFrameset(String value);

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
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getCGISwimlaneFrame_M_transform()
	 * @model unique="false"
	 * @generated
	 */
	EList<String> getM_transform();

	/**
	 * Returns the value of the '<em><b>MbFrameset Modified</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>MbFrameset Modified</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>MbFrameset Modified</em>' attribute.
	 * @see #setM_bFramesetModified(String)
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getCGISwimlaneFrame_M_bFramesetModified()
	 * @model
	 * @generated
	 */
	String getM_bFramesetModified();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGISwimlaneFrame#getM_bFramesetModified <em>MbFrameset Modified</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>MbFrameset Modified</em>' attribute.
	 * @see #getM_bFramesetModified()
	 * @generated
	 */
	void setM_bFramesetModified(String value);

	/**
	 * Returns the value of the '<em><b>Compartments</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Compartments</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Compartments</em>' containment reference.
	 * @see #setCompartments(CompartmentsType)
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getCGISwimlaneFrame_Compartments()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	CompartmentsType getCompartments();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGISwimlaneFrame#getCompartments <em>Compartments</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Compartments</em>' containment reference.
	 * @see #getCompartments()
	 * @generated
	 */
	void setCompartments(CompartmentsType value);

} // CGISwimlaneFrame
