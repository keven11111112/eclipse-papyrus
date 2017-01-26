/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile;

import org.eclipse.uml2.uml.OpaqueExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>BPMN Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNExpression#getBase_OpaqueExpression <em>Base Opaque Expression</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getBPMNExpression()
 * @model
 * @generated
 */
public interface BPMNExpression extends BaseElement {
	/**
	 * Returns the value of the '<em><b>Base Opaque Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Opaque Expression</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Opaque Expression</em>' reference.
	 * @see #setBase_OpaqueExpression(OpaqueExpression)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getBPMNExpression_Base_OpaqueExpression()
	 * @model ordered="false"
	 * @generated
	 */
	OpaqueExpression getBase_OpaqueExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNExpression#getBase_OpaqueExpression <em>Base Opaque Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Opaque Expression</em>' reference.
	 * @see #getBase_OpaqueExpression()
	 * @generated
	 */
	void setBase_OpaqueExpression(OpaqueExpression value);

} // BPMNExpression
