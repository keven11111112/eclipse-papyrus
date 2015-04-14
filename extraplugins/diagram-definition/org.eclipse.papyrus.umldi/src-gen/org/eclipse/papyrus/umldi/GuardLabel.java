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
 * A representation of the model object '<em><b>Guard Label</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.umldi.GuardLabel#getRelationshipWithGuardEdge <em>Relationship With Guard Edge</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getGuardLabel()
 * @model
 * @generated
 */
public interface GuardLabel extends UmlLabel {
	/**
	 * Returns the value of the '<em><b>Relationship With Guard Edge</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.umldi.RelationshipWithGuardEdge#getGuardLabel <em>Guard Label</em>}'.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.eclipse.papyrus.umldi.UmlDiagramElement#getOwningUmlDiagramElement() <em>Owning Uml Diagram Element</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relationship With Guard Edge</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relationship With Guard Edge</em>' container reference.
	 * @see #setRelationshipWithGuardEdge(RelationshipWithGuardEdge)
	 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getGuardLabel_RelationshipWithGuardEdge()
	 * @see org.eclipse.papyrus.umldi.RelationshipWithGuardEdge#getGuardLabel
	 * @model opposite="guardLabel" transient="false" ordered="false"
	 * @generated
	 */
	RelationshipWithGuardEdge getRelationshipWithGuardEdge();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.umldi.GuardLabel#getRelationshipWithGuardEdge <em>Relationship With Guard Edge</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relationship With Guard Edge</em>' container reference.
	 * @see #getRelationshipWithGuardEdge()
	 * @generated
	 */
	void setRelationshipWithGuardEdge(RelationshipWithGuardEdge value);

} // GuardLabel
