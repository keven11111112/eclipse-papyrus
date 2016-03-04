/**
 * Copyright (c) 2016 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   CEA LIST - Initial API and implementation
 * 
 */
package org.omg.smm;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Measure</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.omg.smm.Measure#getMeasureLabelFormat <em>Measure Label Format</em>}</li>
 *   <li>{@link org.omg.smm.Measure#getMeasurementLabelFormat <em>Measurement Label Format</em>}</li>
 *   <li>{@link org.omg.smm.Measure#isVisible <em>Visible</em>}</li>
 *   <li>{@link org.omg.smm.Measure#getSource <em>Source</em>}</li>
 *   <li>{@link org.omg.smm.Measure#getDefaultQuery <em>Default Query</em>}</li>
 *   <li>{@link org.omg.smm.Measure#getMeasureRelationships <em>Measure Relationships</em>}</li>
 *   <li>{@link org.omg.smm.Measure#getCategory <em>Category</em>}</li>
 *   <li>{@link org.omg.smm.Measure#getScope <em>Scope</em>}</li>
 *   <li>{@link org.omg.smm.Measure#getTrait <em>Trait</em>}</li>
 *   <li>{@link org.omg.smm.Measure#getScale <em>Scale</em>}</li>
 *   <li>{@link org.omg.smm.Measure#getCustomScale <em>Custom Scale</em>}</li>
 * </ul>
 *
 * @see org.omg.smm.SmmPackage#getMeasure()
 * @model abstract="true"
 * @generated
 */
public interface Measure extends AbstractMeasureElement {
	/**
	 * Returns the value of the '<em><b>Measure Label Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Measure Label Format</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Measure Label Format</em>' attribute.
	 * @see #setMeasureLabelFormat(String)
	 * @see org.omg.smm.SmmPackage#getMeasure_MeasureLabelFormat()
	 * @model
	 * @generated
	 */
	String getMeasureLabelFormat();

	/**
	 * Sets the value of the '{@link org.omg.smm.Measure#getMeasureLabelFormat <em>Measure Label Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Measure Label Format</em>' attribute.
	 * @see #getMeasureLabelFormat()
	 * @generated
	 */
	void setMeasureLabelFormat(String value);

	/**
	 * Returns the value of the '<em><b>Measurement Label Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Measurement Label Format</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Measurement Label Format</em>' attribute.
	 * @see #setMeasurementLabelFormat(String)
	 * @see org.omg.smm.SmmPackage#getMeasure_MeasurementLabelFormat()
	 * @model
	 * @generated
	 */
	String getMeasurementLabelFormat();

	/**
	 * Sets the value of the '{@link org.omg.smm.Measure#getMeasurementLabelFormat <em>Measurement Label Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Measurement Label Format</em>' attribute.
	 * @see #getMeasurementLabelFormat()
	 * @generated
	 */
	void setMeasurementLabelFormat(String value);

	/**
	 * Returns the value of the '<em><b>Visible</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Visible</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Visible</em>' attribute.
	 * @see #setVisible(boolean)
	 * @see org.omg.smm.SmmPackage#getMeasure_Visible()
	 * @model default="true"
	 * @generated
	 */
	boolean isVisible();

	/**
	 * Sets the value of the '{@link org.omg.smm.Measure#isVisible <em>Visible</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Visible</em>' attribute.
	 * @see #isVisible()
	 * @generated
	 */
	void setVisible(boolean value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' attribute.
	 * @see #setSource(String)
	 * @see org.omg.smm.SmmPackage#getMeasure_Source()
	 * @model
	 * @generated
	 */
	String getSource();

	/**
	 * Sets the value of the '{@link org.omg.smm.Measure#getSource <em>Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' attribute.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(String value);

	/**
	 * Returns the value of the '<em><b>Default Query</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Query</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Query</em>' reference.
	 * @see #setDefaultQuery(Operation)
	 * @see org.omg.smm.SmmPackage#getMeasure_DefaultQuery()
	 * @model
	 * @generated
	 */
	Operation getDefaultQuery();

	/**
	 * Sets the value of the '{@link org.omg.smm.Measure#getDefaultQuery <em>Default Query</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Query</em>' reference.
	 * @see #getDefaultQuery()
	 * @generated
	 */
	void setDefaultQuery(Operation value);

	/**
	 * Returns the value of the '<em><b>Measure Relationships</b></em>' containment reference list.
	 * The list contents are of type {@link org.omg.smm.MeasureRelationship}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Measure Relationships</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Measure Relationships</em>' containment reference list.
	 * @see org.omg.smm.SmmPackage#getMeasure_MeasureRelationships()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<MeasureRelationship> getMeasureRelationships();

	/**
	 * Returns the value of the '<em><b>Category</b></em>' reference list.
	 * The list contents are of type {@link org.omg.smm.MeasureCategory}.
	 * It is bidirectional and its opposite is '{@link org.omg.smm.MeasureCategory#getCategoryMeasure <em>Category Measure</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Category</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Category</em>' reference list.
	 * @see org.omg.smm.SmmPackage#getMeasure_Category()
	 * @see org.omg.smm.MeasureCategory#getCategoryMeasure
	 * @model opposite="categoryMeasure" ordered="false"
	 * @generated
	 */
	EList<MeasureCategory> getCategory();

	/**
	 * Returns the value of the '<em><b>Scope</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scope</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scope</em>' reference.
	 * @see #setScope(Scope)
	 * @see org.omg.smm.SmmPackage#getMeasure_Scope()
	 * @model required="true"
	 * @generated
	 */
	Scope getScope();

	/**
	 * Sets the value of the '{@link org.omg.smm.Measure#getScope <em>Scope</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scope</em>' reference.
	 * @see #getScope()
	 * @generated
	 */
	void setScope(Scope value);

	/**
	 * Returns the value of the '<em><b>Trait</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trait</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trait</em>' reference.
	 * @see #setTrait(Characteristic)
	 * @see org.omg.smm.SmmPackage#getMeasure_Trait()
	 * @model required="true"
	 * @generated
	 */
	Characteristic getTrait();

	/**
	 * Sets the value of the '{@link org.omg.smm.Measure#getTrait <em>Trait</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Trait</em>' reference.
	 * @see #getTrait()
	 * @generated
	 */
	void setTrait(Characteristic value);

	/**
	 * Returns the value of the '<em><b>Scale</b></em>' attribute.
	 * The literals are from the enumeration {@link org.omg.smm.ScaleOfMeasurement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scale</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scale</em>' attribute.
	 * @see org.omg.smm.ScaleOfMeasurement
	 * @see #setScale(ScaleOfMeasurement)
	 * @see org.omg.smm.SmmPackage#getMeasure_Scale()
	 * @model
	 * @generated
	 */
	ScaleOfMeasurement getScale();

	/**
	 * Sets the value of the '{@link org.omg.smm.Measure#getScale <em>Scale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scale</em>' attribute.
	 * @see org.omg.smm.ScaleOfMeasurement
	 * @see #getScale()
	 * @generated
	 */
	void setScale(ScaleOfMeasurement value);

	/**
	 * Returns the value of the '<em><b>Custom Scale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Custom Scale</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Custom Scale</em>' attribute.
	 * @see #setCustomScale(String)
	 * @see org.omg.smm.SmmPackage#getMeasure_CustomScale()
	 * @model
	 * @generated
	 */
	String getCustomScale();

	/**
	 * Sets the value of the '{@link org.omg.smm.Measure#getCustomScale <em>Custom Scale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Custom Scale</em>' attribute.
	 * @see #getCustomScale()
	 * @generated
	 */
	void setCustomScale(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" ordered="false"
	 * @generated
	 */
	EList<Argument> getAllArguments();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" ordered="false"
	 * @generated
	 */
	EList<Argument> getArguments();

} // Measure
