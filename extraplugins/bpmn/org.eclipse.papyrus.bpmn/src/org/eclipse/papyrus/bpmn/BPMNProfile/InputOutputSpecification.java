/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile;

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.Action;
import org.eclipse.uml2.uml.Behavior;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Input Output Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.InputOutputSpecification#getBase_Behavior <em>Base Behavior</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.InputOutputSpecification#getBase_Action <em>Base Action</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.InputOutputSpecification#getDataInputs <em>Data Inputs</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.InputOutputSpecification#getDataOutputs <em>Data Outputs</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.InputOutputSpecification#getInputSets <em>Input Sets</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.InputOutputSpecification#getOutputSets <em>Output Sets</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getInputOutputSpecification()
 * @model
 * @generated
 */
public interface InputOutputSpecification extends BaseElement {
	/**
	 * Returns the value of the '<em><b>Base Behavior</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Behavior</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Behavior</em>' reference.
	 * @see #setBase_Behavior(Behavior)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getInputOutputSpecification_Base_Behavior()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Behavior getBase_Behavior();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.InputOutputSpecification#getBase_Behavior <em>Base Behavior</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Behavior</em>' reference.
	 * @see #getBase_Behavior()
	 * @generated
	 */
	void setBase_Behavior(Behavior value);

	/**
	 * Returns the value of the '<em><b>Base Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Action</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Action</em>' reference.
	 * @see #setBase_Action(Action)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getInputOutputSpecification_Base_Action()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Action getBase_Action();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.InputOutputSpecification#getBase_Action <em>Base Action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Action</em>' reference.
	 * @see #getBase_Action()
	 * @generated
	 */
	void setBase_Action(Action value);

	/**
	 * Returns the value of the '<em><b>Data Inputs</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.bpmn.BPMNProfile.DataInput}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Inputs</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Inputs</em>' reference list.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getInputOutputSpecification_DataInputs()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EList<DataInput> getDataInputs();

	/**
	 * Returns the value of the '<em><b>Data Outputs</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.bpmn.BPMNProfile.DataOutput}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Outputs</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Outputs</em>' reference list.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getInputOutputSpecification_DataOutputs()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EList<DataOutput> getDataOutputs();

	/**
	 * Returns the value of the '<em><b>Input Sets</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.bpmn.BPMNProfile.InputSet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Sets</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Sets</em>' reference list.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getInputOutputSpecification_InputSets()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EList<InputSet> getInputSets();

	/**
	 * Returns the value of the '<em><b>Output Sets</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.bpmn.BPMNProfile.OutputSet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Sets</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Sets</em>' reference list.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getInputOutputSpecification_OutputSets()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EList<OutputSet> getOutputSets();

} // InputOutputSpecification
