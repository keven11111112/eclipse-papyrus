/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile;

import org.eclipse.uml2.uml.ForkNode;
import org.eclipse.uml2.uml.JoinNode;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Non Exclusive Gateway</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.NonExclusiveGateway#getBase_JoinNode <em>Base Join Node</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.NonExclusiveGateway#getBase_ForkNode <em>Base Fork Node</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getNonExclusiveGateway()
 * @model abstract="true"
 * @generated
 */
public interface NonExclusiveGateway extends Gateway {
	/**
	 * Returns the value of the '<em><b>Base Join Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Join Node</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Join Node</em>' reference.
	 * @see #setBase_JoinNode(JoinNode)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getNonExclusiveGateway_Base_JoinNode()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	JoinNode getBase_JoinNode();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.NonExclusiveGateway#getBase_JoinNode <em>Base Join Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Join Node</em>' reference.
	 * @see #getBase_JoinNode()
	 * @generated
	 */
	void setBase_JoinNode(JoinNode value);

	/**
	 * Returns the value of the '<em><b>Base Fork Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Fork Node</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Fork Node</em>' reference.
	 * @see #setBase_ForkNode(ForkNode)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getNonExclusiveGateway_Base_ForkNode()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ForkNode getBase_ForkNode();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.NonExclusiveGateway#getBase_ForkNode <em>Base Fork Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Fork Node</em>' reference.
	 * @see #getBase_ForkNode()
	 * @generated
	 */
	void setBase_ForkNode(ForkNode value);

} // NonExclusiveGateway
