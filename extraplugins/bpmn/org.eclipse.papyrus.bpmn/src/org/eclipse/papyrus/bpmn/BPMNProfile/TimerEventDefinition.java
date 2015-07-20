/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile;

import org.eclipse.uml2.uml.ChangeEvent;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Timer Event Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.TimerEventDefinition#getTimeCycle <em>Time Cycle</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.TimerEventDefinition#getTimeDate <em>Time Date</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.TimerEventDefinition#getTimeDuration <em>Time Duration</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.TimerEventDefinition#getBase_ChangeEvent <em>Base Change Event</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getTimerEventDefinition()
 * @model
 * @generated
 */
public interface TimerEventDefinition extends EventDefinition {
	/**
	 * Returns the value of the '<em><b>Time Cycle</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time Cycle</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time Cycle</em>' reference.
	 * @see #setTimeCycle(BPMNExpression)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getTimerEventDefinition_TimeCycle()
	 * @model ordered="false"
	 * @generated
	 */
	BPMNExpression getTimeCycle();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.TimerEventDefinition#getTimeCycle <em>Time Cycle</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Cycle</em>' reference.
	 * @see #getTimeCycle()
	 * @generated
	 */
	void setTimeCycle(BPMNExpression value);

	/**
	 * Returns the value of the '<em><b>Time Date</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time Date</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time Date</em>' reference.
	 * @see #setTimeDate(BPMNExpression)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getTimerEventDefinition_TimeDate()
	 * @model ordered="false"
	 * @generated
	 */
	BPMNExpression getTimeDate();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.TimerEventDefinition#getTimeDate <em>Time Date</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Date</em>' reference.
	 * @see #getTimeDate()
	 * @generated
	 */
	void setTimeDate(BPMNExpression value);

	/**
	 * Returns the value of the '<em><b>Time Duration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time Duration</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time Duration</em>' reference.
	 * @see #setTimeDuration(BPMNExpression)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getTimerEventDefinition_TimeDuration()
	 * @model ordered="false"
	 * @generated
	 */
	BPMNExpression getTimeDuration();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.TimerEventDefinition#getTimeDuration <em>Time Duration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Duration</em>' reference.
	 * @see #getTimeDuration()
	 * @generated
	 */
	void setTimeDuration(BPMNExpression value);

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
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getTimerEventDefinition_Base_ChangeEvent()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ChangeEvent getBase_ChangeEvent();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.TimerEventDefinition#getBase_ChangeEvent <em>Base Change Event</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Change Event</em>' reference.
	 * @see #getBase_ChangeEvent()
	 * @generated
	 */
	void setBase_ChangeEvent(ChangeEvent value);

} // TimerEventDefinition
