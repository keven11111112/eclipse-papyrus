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

import org.eclipse.papyrus.dd.di.Shape;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Uml Shape</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The most general class for UML diagram elements that are not rendered as lines.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.umldi.UmlShape#getMainLabel <em>Main Label</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getUmlShape()
 * @model abstract="true"
 * @generated
 */
public interface UmlShape extends TopUmlDiagramElement, Shape {
	/**
	 * Returns the value of the '<em><b>Main Label</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.umldi.MainLabel#getUmlShape <em>Uml Shape</em>}'.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.eclipse.papyrus.umldi.UmlDiagramElement#getOwnedUmlDiagramElement() <em>Owned Uml Diagram Element</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Main Label</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Main Label</em>' containment reference.
	 * @see #setMainLabel(MainLabel)
	 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getUmlShape_MainLabel()
	 * @see org.eclipse.papyrus.umldi.MainLabel#getUmlShape
	 * @model opposite="umlShape" containment="true" ordered="false"
	 * @generated
	 */
	MainLabel getMainLabel();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.umldi.UmlShape#getMainLabel <em>Main Label</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Main Label</em>' containment reference.
	 * @see #getMainLabel()
	 * @generated
	 */
	void setMainLabel(MainLabel value);

} // UmlShape
