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
 * A representation of the model object '<em><b>Subpartition Compartment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.umldi.SubpartitionCompartment#getActivityPartitionShape <em>Activity Partition Shape</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getSubpartitionCompartment()
 * @model
 * @generated
 */
public interface SubpartitionCompartment extends DiagramCompartment {

	/**
	 * Returns the value of the '<em><b>Activity Partition Shape</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.umldi.ActivityPartitionShape#getSubpartitionCompartment
	 * <em>Subpartition Compartment</em>}'.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 * <li>'{@link org.eclipse.papyrus.umldi.UmlDiagramElement#getOwningUmlDiagramElement() <em>Owning Uml Diagram Element</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Activity Partition Shape</em>' container reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Activity Partition Shape</em>' container reference.
	 * @see #setActivityPartitionShape(ActivityPartitionShape)
	 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getSubpartitionCompartment_ActivityPartitionShape()
	 * @see org.eclipse.papyrus.umldi.ActivityPartitionShape#getSubpartitionCompartment
	 * @model opposite="subpartitionCompartment" transient="false" ordered="false"
	 * @generated
	 */
	ActivityPartitionShape getActivityPartitionShape();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.umldi.SubpartitionCompartment#getActivityPartitionShape <em>Activity Partition Shape</em>}'
	 * container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Activity Partition Shape</em>' container reference.
	 * @see #getActivityPartitionShape()
	 * @generated
	 */
	void setActivityPartitionShape(ActivityPartitionShape value);
} // SubpartitionCompartment
