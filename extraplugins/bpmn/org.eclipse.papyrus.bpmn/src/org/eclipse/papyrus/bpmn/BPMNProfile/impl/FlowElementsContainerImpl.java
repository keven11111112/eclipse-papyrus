/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage;
import org.eclipse.papyrus.bpmn.BPMNProfile.FlowElement;
import org.eclipse.papyrus.bpmn.BPMNProfile.FlowElementsContainer;
import org.eclipse.papyrus.bpmn.BPMNProfile.LaneSet;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Flow Elements Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.FlowElementsContainerImpl#getLaneSets <em>Lane Sets</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.FlowElementsContainerImpl#getFlowElements <em>Flow Elements</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class FlowElementsContainerImpl extends BaseElementImpl implements FlowElementsContainer {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FlowElementsContainerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BPMNProfilePackage.eINSTANCE.getFlowElementsContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LaneSet> getLaneSets() {
		// TODO: implement this method to return the 'Lane Sets' reference list
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FlowElement> getFlowElements() {
		// TODO: implement this method to return the 'Flow Elements' reference list
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BPMNProfilePackage.FLOW_ELEMENTS_CONTAINER__LANE_SETS:
				return getLaneSets();
			case BPMNProfilePackage.FLOW_ELEMENTS_CONTAINER__FLOW_ELEMENTS:
				return getFlowElements();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case BPMNProfilePackage.FLOW_ELEMENTS_CONTAINER__LANE_SETS:
				return !getLaneSets().isEmpty();
			case BPMNProfilePackage.FLOW_ELEMENTS_CONTAINER__FLOW_ELEMENTS:
				return !getFlowElements().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //FlowElementsContainerImpl
