/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile;

import org.eclipse.uml2.uml.Dependency;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Input Output Binding</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.InputOutputBinding#getInputDataRef <em>Input Data Ref</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.InputOutputBinding#getOutputDataRef <em>Output Data Ref</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.InputOutputBinding#getOperationRef <em>Operation Ref</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.InputOutputBinding#getBase_Dependency <em>Base Dependency</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getInputOutputBinding()
 * @model
 * @generated
 */
public interface InputOutputBinding extends BaseElement {
	/**
	 * Returns the value of the '<em><b>Input Data Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Data Ref</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Data Ref</em>' reference.
	 * @see #setInputDataRef(InputSet)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getInputOutputBinding_InputDataRef()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	InputSet getInputDataRef();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.InputOutputBinding#getInputDataRef <em>Input Data Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Data Ref</em>' reference.
	 * @see #getInputDataRef()
	 * @generated
	 */
	void setInputDataRef(InputSet value);

	/**
	 * Returns the value of the '<em><b>Output Data Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Data Ref</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Data Ref</em>' reference.
	 * @see #setOutputDataRef(OutputSet)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getInputOutputBinding_OutputDataRef()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	OutputSet getOutputDataRef();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.InputOutputBinding#getOutputDataRef <em>Output Data Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Data Ref</em>' reference.
	 * @see #getOutputDataRef()
	 * @generated
	 */
	void setOutputDataRef(OutputSet value);

	/**
	 * Returns the value of the '<em><b>Operation Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operation Ref</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation Ref</em>' reference.
	 * @see #setOperationRef(BPMNOperation)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getInputOutputBinding_OperationRef()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	BPMNOperation getOperationRef();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.InputOutputBinding#getOperationRef <em>Operation Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation Ref</em>' reference.
	 * @see #getOperationRef()
	 * @generated
	 */
	void setOperationRef(BPMNOperation value);

	/**
	 * Returns the value of the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Dependency</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Dependency</em>' reference.
	 * @see #setBase_Dependency(Dependency)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getInputOutputBinding_Base_Dependency()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Dependency getBase_Dependency();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.InputOutputBinding#getBase_Dependency <em>Base Dependency</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Dependency</em>' reference.
	 * @see #getBase_Dependency()
	 * @generated
	 */
	void setBase_Dependency(Dependency value);

} // InputOutputBinding
