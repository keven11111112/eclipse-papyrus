/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>BPMN Message</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNMessage#getItemRef <em>Item Ref</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getBPMNMessage()
 * @model
 * @generated
 */
public interface BPMNMessage extends ItemDefinition {
	/**
	 * Returns the value of the '<em><b>Item Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Item Ref</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Item Ref</em>' reference.
	 * @see #setItemRef(ItemDefinition)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getBPMNMessage_ItemRef()
	 * @model ordered="false"
	 * @generated
	 */
	ItemDefinition getItemRef();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNMessage#getItemRef <em>Item Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Item Ref</em>' reference.
	 * @see #getItemRef()
	 * @generated
	 */
	void setItemRef(ItemDefinition value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.iitemRef : ItemDefintion [0..1] = self.base_Class.extension_ItemDefinition
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='Message.itemRef'"
	 * @generated
	 */
	boolean MessageitemRef(DiagnosticChain diagnostics, Map<Object, Object> context);

} // BPMNMessage
