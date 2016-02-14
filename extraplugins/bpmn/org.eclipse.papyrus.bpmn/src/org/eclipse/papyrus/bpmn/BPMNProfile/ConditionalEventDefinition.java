/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.uml2.uml.ChangeEvent;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Conditional Event Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.ConditionalEventDefinition#getBase_ChangeEvent <em>Base Change Event</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.ConditionalEventDefinition#getCondition <em>Condition</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getConditionalEventDefinition()
 * @model
 * @generated
 */
public interface ConditionalEventDefinition extends EventDefinition {
	/**
	 * Returns the value of the '<em><b>Base Change Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Change Event</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Change Event</em>' reference.
	 * @see #setBase_ChangeEvent(ChangeEvent)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getConditionalEventDefinition_Base_ChangeEvent()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ChangeEvent getBase_ChangeEvent();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ConditionalEventDefinition#getBase_ChangeEvent <em>Base Change Event</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Change Event</em>' reference.
	 * @see #getBase_ChangeEvent()
	 * @generated
	 */
	void setBase_ChangeEvent(ChangeEvent value);

	/**
	 * Returns the value of the '<em><b>Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' reference.
	 * @see #setCondition(BPMNExpression)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getConditionalEventDefinition_Condition()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	BPMNExpression getCondition();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ConditionalEventDefinition#getCondition <em>Condition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' reference.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(BPMNExpression value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * conditionalEventDefinition::/condition :BPMNExpression = ChangeEvent.changeExpression
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='conditionalEventDefinition.condition'"
	 * @generated
	 */
	boolean conditionalEventDefinitioncondition(DiagnosticChain diagnostics, Map<Object, Object> context);

} // ConditionalEventDefinition
