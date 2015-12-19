/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.Task#getIoSpecification <em>Io Specification</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getTask()
 * @model
 * @generated
 */
public interface Task extends BPMNActivity {
	/**
	 * Returns the value of the '<em><b>Io Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Io Specification</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Io Specification</em>' reference.
	 * @see #setIoSpecification(InputOutputSpecification)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getTask_IoSpecification()
	 * @model ordered="false"
	 * @generated
	 */
	InputOutputSpecification getIoSpecification();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Task#getIoSpecification <em>Io Specification</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Io Specification</em>' reference.
	 * @see #getIoSpecification()
	 * @generated
	 */
	void setIoSpecification(InputOutputSpecification value);

} // Task
