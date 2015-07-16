/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile;

import org.eclipse.uml2.uml.ActivityGroup;
import org.eclipse.uml2.uml.ControlNode;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gateway</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.Gateway#getBase_ControlNode <em>Base Control Node</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.Gateway#getBase_ActivityGroup <em>Base Activity Group</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getGateway()
 * @model abstract="true"
 * @generated
 */
public interface Gateway extends FlowNode {
	/**
	 * Returns the value of the '<em><b>Base Control Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Control Node</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Control Node</em>' reference.
	 * @see #setBase_ControlNode(ControlNode)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getGateway_Base_ControlNode()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ControlNode getBase_ControlNode();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Gateway#getBase_ControlNode <em>Base Control Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Control Node</em>' reference.
	 * @see #getBase_ControlNode()
	 * @generated
	 */
	void setBase_ControlNode(ControlNode value);

	/**
	 * Returns the value of the '<em><b>Base Activity Group</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Activity Group</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Activity Group</em>' reference.
	 * @see #setBase_ActivityGroup(ActivityGroup)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getGateway_Base_ActivityGroup()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ActivityGroup getBase_ActivityGroup();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Gateway#getBase_ActivityGroup <em>Base Activity Group</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Activity Group</em>' reference.
	 * @see #getBase_ActivityGroup()
	 * @generated
	 */
	void setBase_ActivityGroup(ActivityGroup value);

} // Gateway
