/**
 */
package org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.Activity;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Process Segment Information</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.ProcessSegmentInformation#getProcesssegment <em>Processsegment</em>}</li>
 *   <li>{@link org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.ProcessSegmentInformation#getBase_Activity <em>Base Activity</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.B2mmlProcessSegmentPackage#getProcessSegmentInformation()
 * @model
 * @generated
 */
public interface ProcessSegmentInformation extends EObject {
	/**
	 * Returns the value of the '<em><b>Processsegment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Processsegment</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Processsegment</em>' reference.
	 * @see #setProcesssegment(ProcessSegment)
	 * @see org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.B2mmlProcessSegmentPackage#getProcessSegmentInformation_Processsegment()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ProcessSegment getProcesssegment();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.ProcessSegmentInformation#getProcesssegment <em>Processsegment</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Processsegment</em>' reference.
	 * @see #getProcesssegment()
	 * @generated
	 */
	void setProcesssegment(ProcessSegment value);

	/**
	 * Returns the value of the '<em><b>Base Activity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Activity</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Activity</em>' reference.
	 * @see #setBase_Activity(Activity)
	 * @see org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.B2mmlProcessSegmentPackage#getProcessSegmentInformation_Base_Activity()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Activity getBase_Activity();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.ProcessSegmentInformation#getBase_Activity <em>Base Activity</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Activity</em>' reference.
	 * @see #getBase_Activity()
	 * @generated
	 */
	void setBase_Activity(Activity value);

} // ProcessSegmentInformation
