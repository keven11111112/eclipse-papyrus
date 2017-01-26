/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile;

import org.eclipse.uml2.uml.ActivityNode;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Flow Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.FlowNode#getBase_ActivityNode <em>Base Activity Node</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getFlowNode()
 * @model abstract="true"
 * @generated
 */
public interface FlowNode extends FlowElement {
	/**
	 * Returns the value of the '<em><b>Base Activity Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Activity Node</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Activity Node</em>' reference.
	 * @see #setBase_ActivityNode(ActivityNode)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getFlowNode_Base_ActivityNode()
	 * @model ordered="false"
	 * @generated
	 */
	ActivityNode getBase_ActivityNode();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.FlowNode#getBase_ActivityNode <em>Base Activity Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Activity Node</em>' reference.
	 * @see #getBase_ActivityNode()
	 * @generated
	 */
	void setBase_ActivityNode(ActivityNode value);

} // FlowNode
