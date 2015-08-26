/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ad Hoc Sub Process</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.AdHocSubProcess#getCompletionCondition <em>Completion Condition</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.AdHocSubProcess#getOrdering <em>Ordering</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.AdHocSubProcess#isCancelRemainingInstances <em>Cancel Remaining Instances</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getAdHocSubProcess()
 * @model
 * @generated
 */
public interface AdHocSubProcess extends SubProcess {
	/**
	 * Returns the value of the '<em><b>Completion Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Completion Condition</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Completion Condition</em>' reference.
	 * @see #setCompletionCondition(BPMNExpression)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getAdHocSubProcess_CompletionCondition()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	BPMNExpression getCompletionCondition();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.AdHocSubProcess#getCompletionCondition <em>Completion Condition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Completion Condition</em>' reference.
	 * @see #getCompletionCondition()
	 * @generated
	 */
	void setCompletionCondition(BPMNExpression value);

	/**
	 * Returns the value of the '<em><b>Ordering</b></em>' attribute.
	 * The default value is <code>"parallel"</code>.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.bpmn.BPMNProfile.AdHocOrdering}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ordering</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ordering</em>' attribute.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.AdHocOrdering
	 * @see #setOrdering(AdHocOrdering)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getAdHocSubProcess_Ordering()
	 * @model default="parallel" required="true" ordered="false"
	 * @generated
	 */
	AdHocOrdering getOrdering();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.AdHocSubProcess#getOrdering <em>Ordering</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ordering</em>' attribute.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.AdHocOrdering
	 * @see #getOrdering()
	 * @generated
	 */
	void setOrdering(AdHocOrdering value);

	/**
	 * Returns the value of the '<em><b>Cancel Remaining Instances</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cancel Remaining Instances</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cancel Remaining Instances</em>' attribute.
	 * @see #setCancelRemainingInstances(boolean)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getAdHocSubProcess_CancelRemainingInstances()
	 * @model default="true" dataType="org.eclipse.uml2.types.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isCancelRemainingInstances();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.AdHocSubProcess#isCancelRemainingInstances <em>Cancel Remaining Instances</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cancel Remaining Instances</em>' attribute.
	 * @see #isCancelRemainingInstances()
	 * @generated
	 */
	void setCancelRemainingInstances(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * cancelRemainingInstances attribute shall be used only if ordering = parallel
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='AdHocSubProcess.cancelRemainingInstances'"
	 * @generated
	 */
	boolean AdHocSubProcesscancelRemainingInstances(DiagnosticChain diagnostics, Map<Object, Object> context);

} // AdHocSubProcess
