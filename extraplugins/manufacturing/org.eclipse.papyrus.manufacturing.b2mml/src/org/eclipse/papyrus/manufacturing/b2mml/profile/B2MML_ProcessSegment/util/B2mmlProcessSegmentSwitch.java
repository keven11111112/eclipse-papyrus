/**
 */
package org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.B2mmlProcessSegmentPackage
 * @generated
 */
public class B2mmlProcessSegmentSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static B2mmlProcessSegmentPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public B2mmlProcessSegmentSwitch() {
		if (modelPackage == null) {
			modelPackage = B2mmlProcessSegmentPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case B2mmlProcessSegmentPackage.PROCESS_SEGMENT_INFORMATION: {
				ProcessSegmentInformation processSegmentInformation = (ProcessSegmentInformation)theEObject;
				T result = caseProcessSegmentInformation(processSegmentInformation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case B2mmlProcessSegmentPackage.PROCESS_SEGMENT: {
				ProcessSegment processSegment = (ProcessSegment)theEObject;
				T result = caseProcessSegment(processSegment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case B2mmlProcessSegmentPackage.PROCESS_SEGMENT_PARAMETER: {
				ProcessSegmentParameter processSegmentParameter = (ProcessSegmentParameter)theEObject;
				T result = caseProcessSegmentParameter(processSegmentParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case B2mmlProcessSegmentPackage.PERSONNEL_SEGMENT_SPECIFICATION: {
				PersonnelSegmentSpecification personnelSegmentSpecification = (PersonnelSegmentSpecification)theEObject;
				T result = casePersonnelSegmentSpecification(personnelSegmentSpecification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case B2mmlProcessSegmentPackage.EQUIPMENT_SEGMENT_SPECIFICATION: {
				EquipmentSegmentSpecification equipmentSegmentSpecification = (EquipmentSegmentSpecification)theEObject;
				T result = caseEquipmentSegmentSpecification(equipmentSegmentSpecification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case B2mmlProcessSegmentPackage.PHYSICAL_ASSET_SEGMENT_SPECIFICATION: {
				PhysicalAssetSegmentSpecification physicalAssetSegmentSpecification = (PhysicalAssetSegmentSpecification)theEObject;
				T result = casePhysicalAssetSegmentSpecification(physicalAssetSegmentSpecification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case B2mmlProcessSegmentPackage.MATERIAL_SEGMENT_SPECIFICATION: {
				MaterialSegmentSpecification materialSegmentSpecification = (MaterialSegmentSpecification)theEObject;
				T result = caseMaterialSegmentSpecification(materialSegmentSpecification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Process Segment Information</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Process Segment Information</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProcessSegmentInformation(ProcessSegmentInformation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Process Segment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Process Segment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProcessSegment(ProcessSegment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Process Segment Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Process Segment Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProcessSegmentParameter(ProcessSegmentParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Personnel Segment Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Personnel Segment Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePersonnelSegmentSpecification(PersonnelSegmentSpecification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Equipment Segment Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Equipment Segment Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEquipmentSegmentSpecification(EquipmentSegmentSpecification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Physical Asset Segment Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Physical Asset Segment Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePhysicalAssetSegmentSpecification(PhysicalAssetSegmentSpecification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Material Segment Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Material Segment Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMaterialSegmentSpecification(MaterialSegmentSpecification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //B2mmlProcessSegmentSwitch
