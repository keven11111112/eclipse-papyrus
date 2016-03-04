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

import org.eclipse.uml2.uml.Stereotype;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Scope</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.omg.smm.Scope#getBreakCondition <em>Break Condition</em>}</li>
 *   <li>{@link org.omg.smm.Scope#getRecognizer <em>Recognizer</em>}</li>
 *   <li>{@link org.omg.smm.Scope#getClass_ <em>Class</em>}</li>
 *   <li>{@link org.omg.smm.Scope#getStereotype <em>Stereotype</em>}</li>
 * </ul>
 *
 * @see org.omg.smm.SmmPackage#getScope()
 * @model
 * @generated
 */
public interface Scope extends AbstractMeasureElement {
	/**
	 * Returns the value of the '<em><b>Break Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Break Condition</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Break Condition</em>' reference.
	 * @see #setBreakCondition(Operation)
	 * @see org.omg.smm.SmmPackage#getScope_BreakCondition()
	 * @model
	 * @generated
	 */
	Operation getBreakCondition();

	/**
	 * Sets the value of the '{@link org.omg.smm.Scope#getBreakCondition <em>Break Condition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Break Condition</em>' reference.
	 * @see #getBreakCondition()
	 * @generated
	 */
	void setBreakCondition(Operation value);

	/**
	 * Returns the value of the '<em><b>Recognizer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Recognizer</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Recognizer</em>' reference.
	 * @see #setRecognizer(Operation)
	 * @see org.omg.smm.SmmPackage#getScope_Recognizer()
	 * @model
	 * @generated
	 */
	Operation getRecognizer();

	/**
	 * Sets the value of the '{@link org.omg.smm.Scope#getRecognizer <em>Recognizer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Recognizer</em>' reference.
	 * @see #getRecognizer()
	 * @generated
	 */
	void setRecognizer(Operation value);

	/**
	 * Returns the value of the '<em><b>Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class</em>' reference.
	 * @see #setClass(org.eclipse.uml2.uml.Class)
	 * @see org.omg.smm.SmmPackage#getScope_Class()
	 * @model
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getClass_();

	/**
	 * Sets the value of the '{@link org.omg.smm.Scope#getClass_ <em>Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class</em>' reference.
	 * @see #getClass_()
	 * @generated
	 */
	void setClass(org.eclipse.uml2.uml.Class value);

	/**
	 * Returns the value of the '<em><b>Stereotype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stereotype</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stereotype</em>' reference.
	 * @see #setStereotype(Stereotype)
	 * @see org.omg.smm.SmmPackage#getScope_Stereotype()
	 * @model
	 * @generated
	 */
	Stereotype getStereotype();

	/**
	 * Sets the value of the '{@link org.omg.smm.Scope#getStereotype <em>Stereotype</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stereotype</em>' reference.
	 * @see #getStereotype()
	 * @generated
	 */
	void setStereotype(Stereotype value);

} // Scope
