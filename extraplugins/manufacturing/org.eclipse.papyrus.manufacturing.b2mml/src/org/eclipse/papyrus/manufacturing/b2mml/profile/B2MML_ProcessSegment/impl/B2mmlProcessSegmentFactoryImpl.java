/**
 */
package org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class B2mmlProcessSegmentFactoryImpl extends EFactoryImpl implements B2mmlProcessSegmentFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static B2mmlProcessSegmentFactory init() {
		try {
			B2mmlProcessSegmentFactory theB2mmlProcessSegmentFactory = (B2mmlProcessSegmentFactory)EPackage.Registry.INSTANCE.getEFactory(B2mmlProcessSegmentPackage.eNS_URI);
			if (theB2mmlProcessSegmentFactory != null) {
				return theB2mmlProcessSegmentFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new B2mmlProcessSegmentFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public B2mmlProcessSegmentFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case B2mmlProcessSegmentPackage.PROCESS_SEGMENT_INFORMATION: return createProcessSegmentInformation();
			case B2mmlProcessSegmentPackage.PROCESS_SEGMENT: return createProcessSegment();
			case B2mmlProcessSegmentPackage.PROCESS_SEGMENT_PARAMETER: return createProcessSegmentParameter();
			case B2mmlProcessSegmentPackage.PERSONNEL_SEGMENT_SPECIFICATION: return createPersonnelSegmentSpecification();
			case B2mmlProcessSegmentPackage.EQUIPMENT_SEGMENT_SPECIFICATION: return createEquipmentSegmentSpecification();
			case B2mmlProcessSegmentPackage.PHYSICAL_ASSET_SEGMENT_SPECIFICATION: return createPhysicalAssetSegmentSpecification();
			case B2mmlProcessSegmentPackage.MATERIAL_SEGMENT_SPECIFICATION: return createMaterialSegmentSpecification();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessSegmentInformation createProcessSegmentInformation() {
		ProcessSegmentInformationImpl processSegmentInformation = new ProcessSegmentInformationImpl();
		return processSegmentInformation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessSegment createProcessSegment() {
		ProcessSegmentImpl processSegment = new ProcessSegmentImpl();
		return processSegment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessSegmentParameter createProcessSegmentParameter() {
		ProcessSegmentParameterImpl processSegmentParameter = new ProcessSegmentParameterImpl();
		return processSegmentParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PersonnelSegmentSpecification createPersonnelSegmentSpecification() {
		PersonnelSegmentSpecificationImpl personnelSegmentSpecification = new PersonnelSegmentSpecificationImpl();
		return personnelSegmentSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EquipmentSegmentSpecification createEquipmentSegmentSpecification() {
		EquipmentSegmentSpecificationImpl equipmentSegmentSpecification = new EquipmentSegmentSpecificationImpl();
		return equipmentSegmentSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PhysicalAssetSegmentSpecification createPhysicalAssetSegmentSpecification() {
		PhysicalAssetSegmentSpecificationImpl physicalAssetSegmentSpecification = new PhysicalAssetSegmentSpecificationImpl();
		return physicalAssetSegmentSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MaterialSegmentSpecification createMaterialSegmentSpecification() {
		MaterialSegmentSpecificationImpl materialSegmentSpecification = new MaterialSegmentSpecificationImpl();
		return materialSegmentSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public B2mmlProcessSegmentPackage getB2mmlProcessSegmentPackage() {
		return (B2mmlProcessSegmentPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static B2mmlProcessSegmentPackage getPackage() {
		return B2mmlProcessSegmentPackage.eINSTANCE;
	}

} //B2mmlProcessSegmentFactoryImpl
