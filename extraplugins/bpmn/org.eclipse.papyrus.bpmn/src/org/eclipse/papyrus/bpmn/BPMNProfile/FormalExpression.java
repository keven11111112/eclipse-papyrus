/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Formal Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.FormalExpression#getEvaluatesToTypeRef <em>Evaluates To Type Ref</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getFormalExpression()
 * @model
 * @generated
 */
public interface FormalExpression extends BPMNExpression {
	/**
	 * Returns the value of the '<em><b>Evaluates To Type Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Evaluates To Type Ref</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Evaluates To Type Ref</em>' reference.
	 * @see #setEvaluatesToTypeRef(ItemDefinition)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getFormalExpression_EvaluatesToTypeRef()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ItemDefinition getEvaluatesToTypeRef();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.FormalExpression#getEvaluatesToTypeRef <em>Evaluates To Type Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Evaluates To Type Ref</em>' reference.
	 * @see #getEvaluatesToTypeRef()
	 * @generated
	 */
	void setEvaluatesToTypeRef(ItemDefinition value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.evaluatesToTypeRef = self.base_OpaqueExpression.type. extension_ItemDefinition
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='FormalExpression.evaluatesToTypeRef'"
	 * @generated
	 */
	boolean FormalExpressionevaluatesToTypeRef(DiagnosticChain diagnostics, Map<Object, Object> context);

} // FormalExpression
