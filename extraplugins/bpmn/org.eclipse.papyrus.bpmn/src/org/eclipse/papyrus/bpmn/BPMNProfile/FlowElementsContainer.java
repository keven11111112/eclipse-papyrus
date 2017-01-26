/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Flow Elements Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.FlowElementsContainer#getLaneSets <em>Lane Sets</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.FlowElementsContainer#getFlowElements <em>Flow Elements</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getFlowElementsContainer()
 * @model abstract="true"
 * @generated
 */
public interface FlowElementsContainer extends BaseElement {
	/**
	 * Returns the value of the '<em><b>Lane Sets</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.bpmn.BPMNProfile.LaneSet}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.bpmn.BPMNProfile.LaneSet#getFlowElementsContainer <em>Flow Elements Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lane Sets</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lane Sets</em>' reference list.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getFlowElementsContainer_LaneSets()
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.LaneSet#getFlowElementsContainer
	 * @model opposite="flowElementsContainer" ordered="false"
	 * @generated
	 */
	EList<LaneSet> getLaneSets();

	/**
	 * Returns the value of the '<em><b>Flow Elements</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.bpmn.BPMNProfile.FlowElement}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.bpmn.BPMNProfile.FlowElement#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Flow Elements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Flow Elements</em>' reference list.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getFlowElementsContainer_FlowElements()
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.FlowElement#getContainer
	 * @model opposite="container" transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	EList<FlowElement> getFlowElements();

} // FlowElementsContainer
