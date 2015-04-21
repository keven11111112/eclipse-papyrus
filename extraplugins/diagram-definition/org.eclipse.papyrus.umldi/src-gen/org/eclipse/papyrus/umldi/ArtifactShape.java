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
 * A representation of the model object '<em><b>Artifact Shape</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.umldi.ArtifactShape#getNestedArtifactCompartment <em>Nested Artifact Compartment</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getArtifactShape()
 * @model
 * @generated
 */
public interface ArtifactShape extends ClassifierWithOperationsShape {
	/**
	 * Returns the value of the '<em><b>Nested Artifact Compartment</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.umldi.NestedArtifactCompartment#getArtifactShape <em>Artifact Shape</em>}'.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.eclipse.papyrus.umldi.UmlDiagramElement#getOwnedUmlDiagramElement() <em>Owned Uml Diagram Element</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nested Artifact Compartment</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nested Artifact Compartment</em>' containment reference.
	 * @see #setNestedArtifactCompartment(NestedArtifactCompartment)
	 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getArtifactShape_NestedArtifactCompartment()
	 * @see org.eclipse.papyrus.umldi.NestedArtifactCompartment#getArtifactShape
	 * @model opposite="artifactShape" containment="true" ordered="false"
	 * @generated
	 */
	NestedArtifactCompartment getNestedArtifactCompartment();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.umldi.ArtifactShape#getNestedArtifactCompartment <em>Nested Artifact Compartment</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nested Artifact Compartment</em>' containment reference.
	 * @see #getNestedArtifactCompartment()
	 * @generated
	 */
	void setNestedArtifactCompartment(NestedArtifactCompartment value);

} // ArtifactShape
