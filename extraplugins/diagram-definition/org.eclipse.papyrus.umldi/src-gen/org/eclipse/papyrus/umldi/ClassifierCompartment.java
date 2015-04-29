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
 * A representation of the model object '<em><b>Classifier Compartment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.umldi.ClassifierCompartment#getLayout <em>Layout</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getClassifierCompartment()
 * @model abstract="true"
 * @generated
 */
public interface ClassifierCompartment extends DiagramCompartment, ListCompartment {
	/**
	 * Returns the value of the '<em><b>Layout</b></em>' attribute.
	 * The default value is <code>"list"</code>.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.umldi.CompartmentLayout}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Layout</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Layout</em>' attribute.
	 * @see org.eclipse.papyrus.umldi.CompartmentLayout
	 * @see #setLayout(CompartmentLayout)
	 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getClassifierCompartment_Layout()
	 * @model default="list" required="true" ordered="false"
	 * @generated
	 */
	CompartmentLayout getLayout();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.umldi.ClassifierCompartment#getLayout <em>Layout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Layout</em>' attribute.
	 * @see org.eclipse.papyrus.umldi.CompartmentLayout
	 * @see #getLayout()
	 * @generated
	 */
	void setLayout(CompartmentLayout value);

} // ClassifierCompartment
