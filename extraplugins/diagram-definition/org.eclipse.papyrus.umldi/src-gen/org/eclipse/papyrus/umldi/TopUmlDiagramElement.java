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
 * A representation of the model object '<em><b>Top Uml Diagram Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.umldi.TopUmlDiagramElement#getUmlDiagram <em>Uml Diagram</em>}</li>
 * <li>{@link org.eclipse.papyrus.umldi.TopUmlDiagramElement#getDiagramCompartment <em>Diagram Compartment</em>}</li>
 * <li>{@link org.eclipse.papyrus.umldi.TopUmlDiagramElement#getMainLabel <em>Main Label</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getTopUmlDiagramElement()
 * @model abstract="true"
 * @generated
 */
public interface TopUmlDiagramElement extends StereotypedDiagramElement {

	/**
	 * Returns the value of the '<em><b>Uml Diagram</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.umldi.UmlDiagram#getTopUmlDiagramElement <em>Top Uml Diagram Element</em>}
	 * '.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 * <li>'{@link org.eclipse.papyrus.umldi.UmlDiagramElement#getOwningUmlDiagramElement() <em>Owning Uml Diagram Element</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uml Diagram</em>' container reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Uml Diagram</em>' container reference.
	 * @see #setUmlDiagram(UmlDiagram)
	 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getTopUmlDiagramElement_UmlDiagram()
	 * @see org.eclipse.papyrus.umldi.UmlDiagram#getTopUmlDiagramElement
	 * @model opposite="topUmlDiagramElement" transient="false" ordered="false"
	 * @generated
	 */
	UmlDiagram getUmlDiagram();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.umldi.TopUmlDiagramElement#getUmlDiagram <em>Uml Diagram</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Uml Diagram</em>' container reference.
	 * @see #getUmlDiagram()
	 * @generated
	 */
	void setUmlDiagram(UmlDiagram value);

	/**
	 * Returns the value of the '<em><b>Diagram Compartment</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.umldi.DiagramCompartment#getTopUmlDiagramElement
	 * <em>Top Uml Diagram Element</em>}'.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 * <li>'{@link org.eclipse.papyrus.umldi.UmlDiagramElement#getOwningUmlDiagramElement() <em>Owning Uml Diagram Element</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Diagram Compartment</em>' container reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Diagram Compartment</em>' container reference.
	 * @see #setDiagramCompartment(DiagramCompartment)
	 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getTopUmlDiagramElement_DiagramCompartment()
	 * @see org.eclipse.papyrus.umldi.DiagramCompartment#getTopUmlDiagramElement
	 * @model opposite="topUmlDiagramElement" transient="false" ordered="false"
	 * @generated
	 */
	DiagramCompartment getDiagramCompartment();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.umldi.TopUmlDiagramElement#getDiagramCompartment <em>Diagram Compartment</em>}' container
	 * reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Diagram Compartment</em>' container reference.
	 * @see #getDiagramCompartment()
	 * @generated
	 */
	void setDiagramCompartment(DiagramCompartment value);

	/**
	 * Returns the value of the '<em><b>Main Label</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.umldi.MainLabel#getTopUmlDiagramElement <em>Top Uml Diagram Element</em>}'.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 * <li>'{@link org.eclipse.papyrus.umldi.UmlDiagramElement#getOwnedUmlDiagramElement() <em>Owned Uml Diagram Element</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Main Label</em>' containment reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Main Label</em>' containment reference.
	 * @see #setMainLabel(MainLabel)
	 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getTopUmlDiagramElement_MainLabel()
	 * @see org.eclipse.papyrus.umldi.MainLabel#getTopUmlDiagramElement
	 * @model opposite="topUmlDiagramElement" containment="true" ordered="false"
	 * @generated
	 */
	MainLabel getMainLabel();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.umldi.TopUmlDiagramElement#getMainLabel <em>Main Label</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Main Label</em>' containment reference.
	 * @see #getMainLabel()
	 * @generated
	 */
	void setMainLabel(MainLabel value);
} // TopUmlDiagramElement
