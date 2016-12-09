/**
 *   Copyright (c) 2016 CEA LIST and others.
 *   
 *   All rights reserved. This program and the accompanying materials
 *   are made available under the terms of the Eclipse Public License v1.0
 *   which accompanies this distribution, and is available at
 *   http://www.eclipse.org/legal/epl-v10.html
 *  
 *   Contributors:
 *     CEA LIST - Initial API and implementation
 * 
 */
package org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ICollaboration Diagram</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ICollaborationDiagram#getM_pICollaboration <em>MpI Collaboration</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getICollaborationDiagram()
 * @model
 * @generated
 */
public interface ICollaborationDiagram extends IDiagram {
	/**
	 * Returns the value of the '<em><b>MpI Collaboration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>MpI Collaboration</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>MpI Collaboration</em>' containment reference.
	 * @see #setM_pICollaboration(ICollaboration)
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getICollaborationDiagram_M_pICollaboration()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	ICollaboration getM_pICollaboration();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ICollaborationDiagram#getM_pICollaboration <em>MpI Collaboration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>MpI Collaboration</em>' containment reference.
	 * @see #getM_pICollaboration()
	 * @generated
	 */
	void setM_pICollaboration(ICollaboration value);

} // ICollaborationDiagram
