/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.uml2.uml.LoopNode;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Standard Loop Characteristics</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.StandardLoopCharacteristics#getLoopMaximum <em>Loop Maximum</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.StandardLoopCharacteristics#getBase_LoopNode <em>Base Loop Node</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.StandardLoopCharacteristics#isTestBefore <em>Test Before</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.StandardLoopCharacteristics#getLoopCondition <em>Loop Condition</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getStandardLoopCharacteristics()
 * @model
 * @generated
 */
public interface StandardLoopCharacteristics extends LoopCharacteristics {
	/**
	 * Returns the value of the '<em><b>Loop Maximum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Loop Maximum</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Loop Maximum</em>' attribute.
	 * @see #setLoopMaximum(int)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getStandardLoopCharacteristics_LoopMaximum()
	 * @model dataType="org.eclipse.uml2.types.Integer" ordered="false"
	 * @generated
	 */
	int getLoopMaximum();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.StandardLoopCharacteristics#getLoopMaximum <em>Loop Maximum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Loop Maximum</em>' attribute.
	 * @see #getLoopMaximum()
	 * @generated
	 */
	void setLoopMaximum(int value);

	/**
	 * Returns the value of the '<em><b>Base Loop Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Loop Node</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Loop Node</em>' reference.
	 * @see #setBase_LoopNode(LoopNode)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getStandardLoopCharacteristics_Base_LoopNode()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	LoopNode getBase_LoopNode();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.StandardLoopCharacteristics#getBase_LoopNode <em>Base Loop Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Loop Node</em>' reference.
	 * @see #getBase_LoopNode()
	 * @generated
	 */
	void setBase_LoopNode(LoopNode value);

	/**
	 * Returns the value of the '<em><b>Test Before</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Test Before</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Test Before</em>' attribute.
	 * @see #setTestBefore(boolean)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getStandardLoopCharacteristics_TestBefore()
	 * @model dataType="org.eclipse.uml2.types.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isTestBefore();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.StandardLoopCharacteristics#isTestBefore <em>Test Before</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Test Before</em>' attribute.
	 * @see #isTestBefore()
	 * @generated
	 */
	void setTestBefore(boolean value);

	/**
	 * Returns the value of the '<em><b>Loop Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Loop Condition</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Loop Condition</em>' reference.
	 * @see #setLoopCondition(BPMNExpression)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getStandardLoopCharacteristics_LoopCondition()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	BPMNExpression getLoopCondition();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.StandardLoopCharacteristics#getLoopCondition <em>Loop Condition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Loop Condition</em>' reference.
	 * @see #getLoopCondition()
	 * @generated
	 */
	void setLoopCondition(BPMNExpression value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * StandardLoopCharacteristics::/testBefore :Boolean = isTestedFirst
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='StandardLoopCharacteristics.testBefore'"
	 * @generated
	 */
	boolean StandardLoopCharacteristicstestBefore(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * StandardLoopCharacteristics:::/loopCondition :BPMNExpression = loopNode.test.value
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='StandardLoopCharacteristics.loopCondition'"
	 * @generated
	 */
	boolean StandardLoopCharacteristicsloopCondition(DiagnosticChain diagnostics, Map<Object, Object> context);

} // StandardLoopCharacteristics
