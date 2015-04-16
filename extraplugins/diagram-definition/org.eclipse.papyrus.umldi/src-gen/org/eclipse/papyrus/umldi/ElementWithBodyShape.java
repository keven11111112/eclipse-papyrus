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
 * A representation of the model object '<em><b>Element With Body Shape</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.umldi.ElementWithBodyShape#getBodyLabel <em>Body Label</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getElementWithBodyShape()
 * @model abstract="true"
 * @generated
 */
public interface ElementWithBodyShape extends ElementShape {
	/**
	 * Returns the value of the '<em><b>Body Label</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.umldi.BodyLabel#getElementWithBodyShape <em>Element With Body Shape</em>}'.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.eclipse.papyrus.umldi.UmlDiagramElement#getOwnedUmlDiagramElement() <em>Owned Uml Diagram Element</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body Label</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body Label</em>' containment reference.
	 * @see #setBodyLabel(BodyLabel)
	 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getElementWithBodyShape_BodyLabel()
	 * @see org.eclipse.papyrus.umldi.BodyLabel#getElementWithBodyShape
	 * @model opposite="elementWithBodyShape" containment="true" ordered="false"
	 * @generated
	 */
	BodyLabel getBodyLabel();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.umldi.ElementWithBodyShape#getBodyLabel <em>Body Label</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body Label</em>' containment reference.
	 * @see #getBodyLabel()
	 * @generated
	 */
	void setBodyLabel(BodyLabel value);

} // ElementWithBodyShape
