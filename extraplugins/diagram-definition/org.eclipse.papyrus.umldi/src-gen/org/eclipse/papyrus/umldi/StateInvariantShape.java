/**
 * Copyright (c) 2014 CEA LIST.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.umldi;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State Invariant Shape</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.umldi.StateInvariantShape#isUseStateShape <em>Use State Shape</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getStateInvariantShape()
 * @model
 * @generated
 */
public interface StateInvariantShape extends InteractionFragmentShape {

	/**
	 * Returns the value of the '<em><b>Use State Shape</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Use State Shape</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Use State Shape</em>' attribute.
	 * @see #setUseStateShape(boolean)
	 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getStateInvariantShape_UseStateShape()
	 * @model default="false" dataType="org.eclipse.papyrus.dd.dc.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isUseStateShape();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.umldi.StateInvariantShape#isUseStateShape <em>Use State Shape</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Use State Shape</em>' attribute.
	 * @see #isUseStateShape()
	 * @generated
	 */
	void setUseStateShape(boolean value);
} // StateInvariantShape
