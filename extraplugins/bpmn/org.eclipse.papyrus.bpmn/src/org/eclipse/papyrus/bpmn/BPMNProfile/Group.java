/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile;

import org.eclipse.uml2.uml.ActivityPartition;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Group</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.Group#getBase_ActivityPartition <em>Base Activity Partition</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.Group#get_categoryValueRef <em>category Value Ref</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getGroup()
 * @model
 * @generated
 */
public interface Group extends BPMNArtifact {
	/**
	 * Returns the value of the '<em><b>Base Activity Partition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Activity Partition</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Activity Partition</em>' reference.
	 * @see #setBase_ActivityPartition(ActivityPartition)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getGroup_Base_ActivityPartition()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ActivityPartition getBase_ActivityPartition();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Group#getBase_ActivityPartition <em>Base Activity Partition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Activity Partition</em>' reference.
	 * @see #getBase_ActivityPartition()
	 * @generated
	 */
	void setBase_ActivityPartition(ActivityPartition value);

	/**
	 * Returns the value of the '<em><b>category Value Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>category Value Ref</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>category Value Ref</em>' reference.
	 * @see #set_categoryValueRef(CategoryValue)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getGroup__categoryValueRef()
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName=' categoryValueRef'"
	 * @generated
	 */
	CategoryValue get_categoryValueRef();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Group#get_categoryValueRef <em>category Value Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>category Value Ref</em>' reference.
	 * @see #get_categoryValueRef()
	 * @generated
	 */
	void set_categoryValueRef(CategoryValue value);

} // Group
