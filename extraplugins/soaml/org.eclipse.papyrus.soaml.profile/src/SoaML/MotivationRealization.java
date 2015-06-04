/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Fadwa TMAR (CEA LIST) fadwa.tmar@cea.fr - Initial API and implementation
 *****************************************************************************/
package SoaML;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.Realization;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Motivation Realization</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link SoaML.MotivationRealization#getBase_Realization <em>Base Realization</em>}</li>
 * </ul>
 * </p>
 *
 * @see SoaML.SoaMLPackage#getMotivationRealization()
 * @model
 * @generated
 */
public interface MotivationRealization extends EObject {
	/**
	 * Returns the value of the '<em><b>Base Realization</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Realization</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Realization</em>' reference.
	 * @see #setBase_Realization(Realization)
	 * @see SoaML.SoaMLPackage#getMotivationRealization_Base_Realization()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Realization getBase_Realization();

	/**
	 * Sets the value of the '{@link SoaML.MotivationRealization#getBase_Realization <em>Base Realization</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Realization</em>' reference.
	 * @see #getBase_Realization()
	 * @generated
	 */
	void setBase_Realization(Realization value);

} // MotivationRealization
