/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.uml2.uml.DecisionNode;
import org.eclipse.uml2.uml.MergeNode;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Exclusive Gateway</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.ExclusiveGateway#getBase_DecisionNode <em>Base Decision Node</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.ExclusiveGateway#getBase_MergeNode <em>Base Merge Node</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.ExclusiveGateway#getDefault <em>Default</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getExclusiveGateway()
 * @model
 * @generated
 */
public interface ExclusiveGateway extends Gateway {
	/**
	 * Returns the value of the '<em><b>Base Decision Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Decision Node</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Decision Node</em>' reference.
	 * @see #setBase_DecisionNode(DecisionNode)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getExclusiveGateway_Base_DecisionNode()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	DecisionNode getBase_DecisionNode();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ExclusiveGateway#getBase_DecisionNode <em>Base Decision Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Decision Node</em>' reference.
	 * @see #getBase_DecisionNode()
	 * @generated
	 */
	void setBase_DecisionNode(DecisionNode value);

	/**
	 * Returns the value of the '<em><b>Base Merge Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Merge Node</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Merge Node</em>' reference.
	 * @see #setBase_MergeNode(MergeNode)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getExclusiveGateway_Base_MergeNode()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	MergeNode getBase_MergeNode();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ExclusiveGateway#getBase_MergeNode <em>Base Merge Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Merge Node</em>' reference.
	 * @see #getBase_MergeNode()
	 * @generated
	 */
	void setBase_MergeNode(MergeNode value);

	/**
	 * Returns the value of the '<em><b>Default</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default</em>' reference.
	 * @see #setDefault(SequenceFlow)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getExclusiveGateway_Default()
	 * @model ordered="false"
	 * @generated
	 */
	SequenceFlow getDefault();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ExclusiveGateway#getDefault <em>Default</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default</em>' reference.
	 * @see #getDefault()
	 * @generated
	 */
	void setDefault(SequenceFlow value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * exclusiveGateway::/default : SequenceFlow [0..1] = an outgoing control flow with guard "else"
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='exclusiveGateway.default'"
	 * @generated
	 */
	boolean exclusiveGatewaydefault(DiagnosticChain diagnostics, Map<Object, Object> context);

} // ExclusiveGateway
