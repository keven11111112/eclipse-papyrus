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
 * A representation of the model object '<em><b>Activity Partition Shape</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.umldi.ActivityPartitionShape#isVertical <em>Is Vertical</em>}</li>
 * <li>{@link org.eclipse.papyrus.umldi.ActivityPartitionShape#getSubpartitionCompartment <em>Subpartition Compartment</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getActivityPartitionShape()
 * @model
 * @generated
 */
public interface ActivityPartitionShape extends ActivityGroupShape {

	/**
	 * Returns the value of the '<em><b>Is Vertical</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Vertical</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Is Vertical</em>' attribute.
	 * @see #setIsVertical(boolean)
	 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getActivityPartitionShape_IsVertical()
	 * @model default="true" dataType="org.eclipse.papyrus.dd.dc.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isVertical();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.umldi.ActivityPartitionShape#isVertical <em>Is Vertical</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Is Vertical</em>' attribute.
	 * @see #isVertical()
	 * @generated
	 */
	void setIsVertical(boolean value);

	/**
	 * Returns the value of the '<em><b>Subpartition Compartment</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.umldi.SubpartitionCompartment#getActivityPartitionShape
	 * <em>Activity Partition Shape</em>}'.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 * <li>'{@link org.eclipse.papyrus.umldi.UmlDiagramElement#getOwnedUmlDiagramElement() <em>Owned Uml Diagram Element</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subpartition Compartment</em>' containment reference isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Subpartition Compartment</em>' containment reference.
	 * @see #setSubpartitionCompartment(SubpartitionCompartment)
	 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getActivityPartitionShape_SubpartitionCompartment()
	 * @see org.eclipse.papyrus.umldi.SubpartitionCompartment#getActivityPartitionShape
	 * @model opposite="activityPartitionShape" containment="true" ordered="false"
	 * @generated
	 */
	SubpartitionCompartment getSubpartitionCompartment();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.umldi.ActivityPartitionShape#getSubpartitionCompartment <em>Subpartition Compartment</em>}'
	 * containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Subpartition Compartment</em>' containment reference.
	 * @see #getSubpartitionCompartment()
	 * @generated
	 */
	void setSubpartitionCompartment(SubpartitionCompartment value);
} // ActivityPartitionShape
