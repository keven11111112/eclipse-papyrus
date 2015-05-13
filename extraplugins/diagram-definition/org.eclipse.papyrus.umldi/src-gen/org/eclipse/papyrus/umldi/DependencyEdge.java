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
 * A representation of the model object '<em><b>Dependency Edge</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.umldi.DependencyEdge#getRoleLabel <em>Role Label</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getDependencyEdge()
 * @model
 * @generated
 */
public interface DependencyEdge extends ElementEdge {
	/**
	 * Returns the value of the '<em><b>Role Label</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.umldi.RoleLabel#getRoleBindingEdge <em>Role Binding Edge</em>}'.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.eclipse.papyrus.umldi.UmlDiagramElement#getOwnedUmlDiagramElement() <em>Owned Uml Diagram Element</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Role Label</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Role Label</em>' containment reference.
	 * @see #setRoleLabel(RoleLabel)
	 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getDependencyEdge_RoleLabel()
	 * @see org.eclipse.papyrus.umldi.RoleLabel#getRoleBindingEdge
	 * @model opposite="roleBindingEdge" containment="true" ordered="false"
	 * @generated
	 */
	RoleLabel getRoleLabel();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.umldi.DependencyEdge#getRoleLabel <em>Role Label</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Role Label</em>' containment reference.
	 * @see #getRoleLabel()
	 * @generated
	 */
	void setRoleLabel(RoleLabel value);

} // DependencyEdge
