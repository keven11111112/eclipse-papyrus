/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Global Business Rule Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.GlobalBusinessRuleTask#getImplementation <em>Implementation</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getGlobalBusinessRuleTask()
 * @model
 * @generated
 */
public interface GlobalBusinessRuleTask extends GlobalTask {
	/**
	 * Returns the value of the '<em><b>Implementation</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Implementation</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Implementation</em>' attribute list.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getGlobalBusinessRuleTask_Implementation()
	 * @model default="##unspecified" unique="false" dataType="org.eclipse.uml2.types.String" required="true"
	 * @generated
	 */
	EList<String> getImplementation();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * GlobalBusinessRuleTask::/implementation: String [*] {ordered,non-unique} = OpaqueBehavior.body (defaults to "##unspecified")
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='GlobalBusinessRuleTask.implementation'"
	 * @generated
	 */
	boolean GlobalBusinessRuleTaskimplementation(DiagnosticChain diagnostics, Map<Object, Object> context);

} // GlobalBusinessRuleTask
