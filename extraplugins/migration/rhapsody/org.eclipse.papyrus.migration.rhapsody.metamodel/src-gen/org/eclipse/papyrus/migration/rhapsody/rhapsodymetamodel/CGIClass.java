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
 * A representation of the model object '<em><b>CGI Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIClass#getM_pModelObject <em>MpModel Object</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIClass#getM_AdditionalLabel <em>MAdditional Label</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIClass#getM_polygon <em>Mpolygon</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIClass#getM_nNameFormat <em>MnName Format</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIClass#getM_nIsNameFormat <em>MnIs Name Format</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIClass#getCompartments <em>Compartments</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIClass#getM_pParent <em>MpParent</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIClass#getM_transform <em>Mtransform</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIClass#getFrameset <em>Frameset</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIClass#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIClass#getAttrs <em>Attrs</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIClass#getOperations <em>Operations</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIClass#getM_color <em>Mcolor</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIClass#getM_lineWidth <em>Mline Width</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIClass#getM_dSeparatorPosition <em>MdSeparator Position</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIClass#getM_bIsMisplaced <em>MbIs Misplaced</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIClass#getM_pImageViewData <em>MpImage View Data</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIClass#getM_bFramesetModified <em>MbFrameset Modified</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getCGIClass()
 * @model
 * @generated
 */
public interface CGIClass extends GraphElementsType, M_pRootType {
	/**
	 * Returns the value of the '<em><b>MpModel Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>MpModel Object</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>MpModel Object</em>' reference.
	 * @see #setM_pModelObject(M_pModelObjectType)
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getCGIClass_M_pModelObject()
	 * @model
	 * @generated
	 */
	M_pModelObjectType getM_pModelObject();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIClass#getM_pModelObject <em>MpModel Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>MpModel Object</em>' reference.
	 * @see #getM_pModelObject()
	 * @generated
	 */
	void setM_pModelObject(M_pModelObjectType value);

	/**
	 * Returns the value of the '<em><b>MAdditional Label</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>MAdditional Label</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>MAdditional Label</em>' containment reference.
	 * @see #setM_AdditionalLabel(CGIText)
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getCGIClass_M_AdditionalLabel()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	CGIText getM_AdditionalLabel();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIClass#getM_AdditionalLabel <em>MAdditional Label</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>MAdditional Label</em>' containment reference.
	 * @see #getM_AdditionalLabel()
	 * @generated
	 */
	void setM_AdditionalLabel(CGIText value);

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
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getCGIClass_M_polygon()
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
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getCGIClass_M_nNameFormat()
	 * @model
	 * @generated
	 */
	String getM_nNameFormat();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIClass#getM_nNameFormat <em>MnName Format</em>}' attribute.
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
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getCGIClass_M_nIsNameFormat()
	 * @model
	 * @generated
	 */
	String getM_nIsNameFormat();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIClass#getM_nIsNameFormat <em>MnIs Name Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>MnIs Name Format</em>' attribute.
	 * @see #getM_nIsNameFormat()
	 * @generated
	 */
	void setM_nIsNameFormat(String value);

	/**
	 * Returns the value of the '<em><b>Compartments</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CompartmentsType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Compartments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Compartments</em>' containment reference list.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getCGIClass_Compartments()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<CompartmentsType> getCompartments();

	/**
	 * Returns the value of the '<em><b>MpParent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>MpParent</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>MpParent</em>' reference.
	 * @see #setM_pParent(M_pRootType)
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getCGIClass_M_pParent()
	 * @model
	 * @generated
	 */
	M_pRootType getM_pParent();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIClass#getM_pParent <em>MpParent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>MpParent</em>' reference.
	 * @see #getM_pParent()
	 * @generated
	 */
	void setM_pParent(M_pRootType value);

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
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getCGIClass_M_transform()
	 * @model unique="false"
	 * @generated
	 */
	EList<String> getM_transform();

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
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getCGIClass_Frameset()
	 * @model
	 * @generated
	 */
	String getFrameset();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIClass#getFrameset <em>Frameset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Frameset</em>' attribute.
	 * @see #getFrameset()
	 * @generated
	 */
	void setFrameset(String value);

	/**
	 * Returns the value of the '<em><b>Properties</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Properties</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' containment reference.
	 * @see #setProperties(IPropertyContainer)
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getCGIClass_Properties()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	IPropertyContainer getProperties();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIClass#getProperties <em>Properties</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Properties</em>' containment reference.
	 * @see #getProperties()
	 * @generated
	 */
	void setProperties(IPropertyContainer value);

	/**
	 * Returns the value of the '<em><b>Attrs</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IUnit}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attrs</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attrs</em>' reference list.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getCGIClass_Attrs()
	 * @model
	 * @generated
	 */
	EList<IUnit> getAttrs();

	/**
	 * Returns the value of the '<em><b>Operations</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.OperationsType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operations</em>' reference list.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getCGIClass_Operations()
	 * @model
	 * @generated
	 */
	EList<OperationsType> getOperations();

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
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getCGIClass_M_color()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	IColor getM_color();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIClass#getM_color <em>Mcolor</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mcolor</em>' containment reference.
	 * @see #getM_color()
	 * @generated
	 */
	void setM_color(IColor value);

	/**
	 * Returns the value of the '<em><b>Mline Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mline Width</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mline Width</em>' attribute.
	 * @see #setM_lineWidth(String)
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getCGIClass_M_lineWidth()
	 * @model
	 * @generated
	 */
	String getM_lineWidth();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIClass#getM_lineWidth <em>Mline Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mline Width</em>' attribute.
	 * @see #getM_lineWidth()
	 * @generated
	 */
	void setM_lineWidth(String value);

	/**
	 * Returns the value of the '<em><b>MdSeparator Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>MdSeparator Position</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>MdSeparator Position</em>' attribute.
	 * @see #setM_dSeparatorPosition(String)
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getCGIClass_M_dSeparatorPosition()
	 * @model
	 * @generated
	 */
	String getM_dSeparatorPosition();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIClass#getM_dSeparatorPosition <em>MdSeparator Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>MdSeparator Position</em>' attribute.
	 * @see #getM_dSeparatorPosition()
	 * @generated
	 */
	void setM_dSeparatorPosition(String value);

	/**
	 * Returns the value of the '<em><b>MbIs Misplaced</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>MbIs Misplaced</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>MbIs Misplaced</em>' attribute.
	 * @see #setM_bIsMisplaced(String)
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getCGIClass_M_bIsMisplaced()
	 * @model
	 * @generated
	 */
	String getM_bIsMisplaced();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIClass#getM_bIsMisplaced <em>MbIs Misplaced</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>MbIs Misplaced</em>' attribute.
	 * @see #getM_bIsMisplaced()
	 * @generated
	 */
	void setM_bIsMisplaced(String value);

	/**
	 * Returns the value of the '<em><b>MpImage View Data</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>MpImage View Data</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>MpImage View Data</em>' reference.
	 * @see #setM_pImageViewData(CGIImageData)
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getCGIClass_M_pImageViewData()
	 * @model
	 * @generated
	 */
	CGIImageData getM_pImageViewData();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIClass#getM_pImageViewData <em>MpImage View Data</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>MpImage View Data</em>' reference.
	 * @see #getM_pImageViewData()
	 * @generated
	 */
	void setM_pImageViewData(CGIImageData value);

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
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getCGIClass_M_bFramesetModified()
	 * @model
	 * @generated
	 */
	String getM_bFramesetModified();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIClass#getM_bFramesetModified <em>MbFrameset Modified</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>MbFrameset Modified</em>' attribute.
	 * @see #getM_bFramesetModified()
	 * @generated
	 */
	void setM_bFramesetModified(String value);

} // CGIClass
