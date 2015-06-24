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
 * A representation of the model object '<em><b>Template Parameter Compartment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.umldi.TemplateParameterCompartment#getTemplateableElementShape <em>Templateable Element Shape</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getTemplateParameterCompartment()
 * @model
 * @generated
 */
public interface TemplateParameterCompartment extends ListCompartment {

	/**
	 * Returns the value of the '<em><b>Templateable Element Shape</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.umldi.TemplateableElementShape#getTemplateParameterCompartment
	 * <em>Template Parameter Compartment</em>}'.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 * <li>'{@link org.eclipse.papyrus.umldi.UmlDiagramElement#getOwningUmlDiagramElement() <em>Owning Uml Diagram Element</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Templateable Element Shape</em>' container reference isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Templateable Element Shape</em>' container reference.
	 * @see #setTemplateableElementShape(TemplateableElementShape)
	 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getTemplateParameterCompartment_TemplateableElementShape()
	 * @see org.eclipse.papyrus.umldi.TemplateableElementShape#getTemplateParameterCompartment
	 * @model opposite="templateParameterCompartment" transient="false" ordered="false"
	 * @generated
	 */
	TemplateableElementShape getTemplateableElementShape();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.umldi.TemplateParameterCompartment#getTemplateableElementShape
	 * <em>Templateable Element Shape</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Templateable Element Shape</em>' container reference.
	 * @see #getTemplateableElementShape()
	 * @generated
	 */
	void setTemplateableElementShape(TemplateableElementShape value);
} // TemplateParameterCompartment
