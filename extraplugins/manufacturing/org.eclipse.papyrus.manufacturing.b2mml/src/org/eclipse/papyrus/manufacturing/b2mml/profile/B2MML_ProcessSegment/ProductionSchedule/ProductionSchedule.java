/**
 */
package org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.ProductionSchedule;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.Artifact;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Production Schedule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.ProductionSchedule.ProductionSchedule#getBase_Artifact <em>Base Artifact</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.ProductionSchedule.ProductionSchedulePackage#getProductionSchedule()
 * @model
 * @generated
 */
public interface ProductionSchedule extends EObject {
	/**
	 * Returns the value of the '<em><b>Base Artifact</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Artifact</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Artifact</em>' reference.
	 * @see #setBase_Artifact(Artifact)
	 * @see org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.ProductionSchedule.ProductionSchedulePackage#getProductionSchedule_Base_Artifact()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Artifact getBase_Artifact();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.ProductionSchedule.ProductionSchedule#getBase_Artifact <em>Base Artifact</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Artifact</em>' reference.
	 * @see #getBase_Artifact()
	 * @generated
	 */
	void setBase_Artifact(Artifact value);

} // ProductionSchedule
