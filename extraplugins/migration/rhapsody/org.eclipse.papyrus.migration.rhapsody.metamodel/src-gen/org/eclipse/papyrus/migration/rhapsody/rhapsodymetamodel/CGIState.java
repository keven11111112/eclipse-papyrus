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
 * A representation of the model object '<em><b>CGI State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIState#getM_pModelObject <em>MpModel Object</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIState#getM_AdditionalLabel <em>MAdditional Label</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIState#getM_polygon <em>Mpolygon</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIState#getM_nNameFormat <em>MnName Format</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIState#getM_nIsNameFormat <em>MnIs Name Format</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIState#getNAndLineCount <em>NAnd Line Count</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIState#getM_nInheritanceMask <em>MnInheritance Mask</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIState#getM_pDefaultComponentRelation <em>MpDefault Component Relation</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIState#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIState#getM_pParent <em>MpParent</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIState#getM_transform <em>Mtransform</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIState#getAndLinePoly <em>And Line Poly</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIState#getM_pVirtualParent <em>MpVirtual Parent</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIState#getM_moveAndLineTimeStamp <em>Mmove And Line Time Stamp</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIState#getMyState <em>My State</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIState#getM_pInheritsFrom <em>MpInherits From</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIState#getFrameset <em>Frameset</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIState#getM_bFramesetModified <em>MbFrameset Modified</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIState#getM_bIsMisplaced <em>MbIs Misplaced</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIState#getM_color <em>Mcolor</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIState#getM_lineWidth <em>Mline Width</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIState#getCompartments <em>Compartments</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getCGIState()
 * @model
 * @generated
 */
public interface CGIState extends GraphElementsType {
	/**
	 * Returns the value of the '<em><b>MpModel Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>MpModel Object</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>MpModel Object</em>' reference.
	 * @see #setM_pModelObject(ItsTargetType)
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getCGIState_M_pModelObject()
	 * @model
	 * @generated
	 */
	ItsTargetType getM_pModelObject();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIState#getM_pModelObject <em>MpModel Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>MpModel Object</em>' reference.
	 * @see #getM_pModelObject()
	 * @generated
	 */
	void setM_pModelObject(ItsTargetType value);

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
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getCGIState_M_AdditionalLabel()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	CGIText getM_AdditionalLabel();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIState#getM_AdditionalLabel <em>MAdditional Label</em>}' containment reference.
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
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getCGIState_M_polygon()
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
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getCGIState_M_nNameFormat()
	 * @model
	 * @generated
	 */
	String getM_nNameFormat();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIState#getM_nNameFormat <em>MnName Format</em>}' attribute.
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
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getCGIState_M_nIsNameFormat()
	 * @model
	 * @generated
	 */
	String getM_nIsNameFormat();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIState#getM_nIsNameFormat <em>MnIs Name Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>MnIs Name Format</em>' attribute.
	 * @see #getM_nIsNameFormat()
	 * @generated
	 */
	void setM_nIsNameFormat(String value);

	/**
	 * Returns the value of the '<em><b>NAnd Line Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>NAnd Line Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>NAnd Line Count</em>' attribute.
	 * @see #setNAndLineCount(String)
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getCGIState_NAndLineCount()
	 * @model
	 * @generated
	 */
	String getNAndLineCount();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIState#getNAndLineCount <em>NAnd Line Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>NAnd Line Count</em>' attribute.
	 * @see #getNAndLineCount()
	 * @generated
	 */
	void setNAndLineCount(String value);

	/**
	 * Returns the value of the '<em><b>MnInheritance Mask</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>MnInheritance Mask</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>MnInheritance Mask</em>' attribute.
	 * @see #setM_nInheritanceMask(String)
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getCGIState_M_nInheritanceMask()
	 * @model
	 * @generated
	 */
	String getM_nInheritanceMask();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIState#getM_nInheritanceMask <em>MnInheritance Mask</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>MnInheritance Mask</em>' attribute.
	 * @see #getM_nInheritanceMask()
	 * @generated
	 */
	void setM_nInheritanceMask(String value);

	/**
	 * Returns the value of the '<em><b>MpDefault Component Relation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>MpDefault Component Relation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>MpDefault Component Relation</em>' attribute.
	 * @see #setM_pDefaultComponentRelation(String)
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getCGIState_M_pDefaultComponentRelation()
	 * @model
	 * @generated
	 */
	String getM_pDefaultComponentRelation();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIState#getM_pDefaultComponentRelation <em>MpDefault Component Relation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>MpDefault Component Relation</em>' attribute.
	 * @see #getM_pDefaultComponentRelation()
	 * @generated
	 */
	void setM_pDefaultComponentRelation(String value);

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
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getCGIState_Properties()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	IPropertyContainer getProperties();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIState#getProperties <em>Properties</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Properties</em>' containment reference.
	 * @see #getProperties()
	 * @generated
	 */
	void setProperties(IPropertyContainer value);

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
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getCGIState_M_pParent()
	 * @model
	 * @generated
	 */
	GraphElementsType getM_pParent();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIState#getM_pParent <em>MpParent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>MpParent</em>' reference.
	 * @see #getM_pParent()
	 * @generated
	 */
	void setM_pParent(GraphElementsType value);

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
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getCGIState_M_transform()
	 * @model unique="false"
	 * @generated
	 */
	EList<String> getM_transform();

	/**
	 * Returns the value of the '<em><b>And Line Poly</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>And Line Poly</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>And Line Poly</em>' attribute list.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getCGIState_AndLinePoly()
	 * @model unique="false"
	 * @generated
	 */
	EList<String> getAndLinePoly();

	/**
	 * Returns the value of the '<em><b>MpVirtual Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>MpVirtual Parent</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>MpVirtual Parent</em>' reference.
	 * @see #setM_pVirtualParent(GraphElementsType)
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getCGIState_M_pVirtualParent()
	 * @model
	 * @generated
	 */
	GraphElementsType getM_pVirtualParent();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIState#getM_pVirtualParent <em>MpVirtual Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>MpVirtual Parent</em>' reference.
	 * @see #getM_pVirtualParent()
	 * @generated
	 */
	void setM_pVirtualParent(GraphElementsType value);

	/**
	 * Returns the value of the '<em><b>Mmove And Line Time Stamp</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mmove And Line Time Stamp</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mmove And Line Time Stamp</em>' attribute list.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getCGIState_M_moveAndLineTimeStamp()
	 * @model unique="false"
	 * @generated
	 */
	EList<String> getM_moveAndLineTimeStamp();

	/**
	 * Returns the value of the '<em><b>My State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>My State</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>My State</em>' attribute.
	 * @see #setMyState(String)
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getCGIState_MyState()
	 * @model
	 * @generated
	 */
	String getMyState();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIState#getMyState <em>My State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>My State</em>' attribute.
	 * @see #getMyState()
	 * @generated
	 */
	void setMyState(String value);

	/**
	 * Returns the value of the '<em><b>MpInherits From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>MpInherits From</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>MpInherits From</em>' reference.
	 * @see #setM_pInheritsFrom(GraphElementsType)
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getCGIState_M_pInheritsFrom()
	 * @model
	 * @generated
	 */
	GraphElementsType getM_pInheritsFrom();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIState#getM_pInheritsFrom <em>MpInherits From</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>MpInherits From</em>' reference.
	 * @see #getM_pInheritsFrom()
	 * @generated
	 */
	void setM_pInheritsFrom(GraphElementsType value);

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
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getCGIState_Frameset()
	 * @model
	 * @generated
	 */
	String getFrameset();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIState#getFrameset <em>Frameset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Frameset</em>' attribute.
	 * @see #getFrameset()
	 * @generated
	 */
	void setFrameset(String value);

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
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getCGIState_M_bFramesetModified()
	 * @model
	 * @generated
	 */
	String getM_bFramesetModified();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIState#getM_bFramesetModified <em>MbFrameset Modified</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>MbFrameset Modified</em>' attribute.
	 * @see #getM_bFramesetModified()
	 * @generated
	 */
	void setM_bFramesetModified(String value);

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
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getCGIState_M_bIsMisplaced()
	 * @model
	 * @generated
	 */
	String getM_bIsMisplaced();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIState#getM_bIsMisplaced <em>MbIs Misplaced</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>MbIs Misplaced</em>' attribute.
	 * @see #getM_bIsMisplaced()
	 * @generated
	 */
	void setM_bIsMisplaced(String value);

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
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getCGIState_M_color()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	IColor getM_color();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIState#getM_color <em>Mcolor</em>}' containment reference.
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
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getCGIState_M_lineWidth()
	 * @model
	 * @generated
	 */
	String getM_lineWidth();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIState#getM_lineWidth <em>Mline Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mline Width</em>' attribute.
	 * @see #getM_lineWidth()
	 * @generated
	 */
	void setM_lineWidth(String value);

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
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getCGIState_Compartments()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	CompartmentsType getCompartments();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIState#getCompartments <em>Compartments</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Compartments</em>' containment reference.
	 * @see #getCompartments()
	 * @generated
	 */
	void setCompartments(CompartmentsType value);

} // CGIState
