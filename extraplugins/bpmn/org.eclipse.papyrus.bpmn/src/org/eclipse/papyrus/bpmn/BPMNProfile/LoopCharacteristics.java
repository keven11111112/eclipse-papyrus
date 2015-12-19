/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile;

import org.eclipse.uml2.uml.StructuredActivityNode;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Loop Characteristics</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.LoopCharacteristics#getBase_StructuredActivityNode <em>Base Structured Activity Node</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getLoopCharacteristics()
 * @model abstract="true"
 * @generated
 */
public interface LoopCharacteristics extends BaseElement {
	/**
	 * Returns the value of the '<em><b>Base Structured Activity Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Structured Activity Node</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Structured Activity Node</em>' reference.
	 * @see #setBase_StructuredActivityNode(StructuredActivityNode)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getLoopCharacteristics_Base_StructuredActivityNode()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	StructuredActivityNode getBase_StructuredActivityNode();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.LoopCharacteristics#getBase_StructuredActivityNode <em>Base Structured Activity Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Structured Activity Node</em>' reference.
	 * @see #getBase_StructuredActivityNode()
	 * @generated
	 */
	void setBase_StructuredActivityNode(StructuredActivityNode value);

} // LoopCharacteristics
