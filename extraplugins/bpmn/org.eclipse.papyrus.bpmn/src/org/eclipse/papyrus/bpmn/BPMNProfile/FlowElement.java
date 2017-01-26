/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Flow Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.FlowElement#getAuditing <em>Auditing</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.FlowElement#getMonitoring <em>Monitoring</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.FlowElement#get_categoryValueRef <em>category Value Ref</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.FlowElement#getContainer <em>Container</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getFlowElement()
 * @model abstract="true"
 * @generated
 */
public interface FlowElement extends BaseElement {
	/**
	 * Returns the value of the '<em><b>Auditing</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Auditing</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Auditing</em>' reference.
	 * @see #setAuditing(Auditing)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getFlowElement_Auditing()
	 * @model ordered="false"
	 * @generated
	 */
	Auditing getAuditing();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.FlowElement#getAuditing <em>Auditing</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Auditing</em>' reference.
	 * @see #getAuditing()
	 * @generated
	 */
	void setAuditing(Auditing value);

	/**
	 * Returns the value of the '<em><b>Monitoring</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Monitoring</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Monitoring</em>' reference.
	 * @see #setMonitoring(Monitoring)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getFlowElement_Monitoring()
	 * @model ordered="false"
	 * @generated
	 */
	Monitoring getMonitoring();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.FlowElement#getMonitoring <em>Monitoring</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Monitoring</em>' reference.
	 * @see #getMonitoring()
	 * @generated
	 */
	void setMonitoring(Monitoring value);

	/**
	 * Returns the value of the '<em><b>category Value Ref</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.bpmn.BPMNProfile.CategoryValue}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.bpmn.BPMNProfile.CategoryValue#getCategorizedFlowElements <em>Categorized Flow Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>category Value Ref</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>category Value Ref</em>' reference list.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getFlowElement__categoryValueRef()
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.CategoryValue#getCategorizedFlowElements
	 * @model opposite="categorizedFlowElements" ordered="false"
	 *        annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName=' categoryValueRef'"
	 * @generated
	 */
	EList<CategoryValue> get_categoryValueRef();

	/**
	 * Returns the value of the '<em><b>Container</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.bpmn.BPMNProfile.FlowElementsContainer#getFlowElements <em>Flow Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Container</em>' reference.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getFlowElement_Container()
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.FlowElementsContainer#getFlowElements
	 * @model opposite="flowElements" required="true" transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	FlowElementsContainer getContainer();

} // FlowElement
