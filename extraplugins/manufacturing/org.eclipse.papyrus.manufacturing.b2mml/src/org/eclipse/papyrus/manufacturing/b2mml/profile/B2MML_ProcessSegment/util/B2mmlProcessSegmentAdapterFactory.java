/**
 */
package org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.B2mmlProcessSegmentPackage
 * @generated
 */
public class B2mmlProcessSegmentAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static B2mmlProcessSegmentPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public B2mmlProcessSegmentAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = B2mmlProcessSegmentPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected B2mmlProcessSegmentSwitch<Adapter> modelSwitch =
		new B2mmlProcessSegmentSwitch<Adapter>() {
			@Override
			public Adapter caseProcessSegmentInformation(ProcessSegmentInformation object) {
				return createProcessSegmentInformationAdapter();
			}
			@Override
			public Adapter caseProcessSegment(ProcessSegment object) {
				return createProcessSegmentAdapter();
			}
			@Override
			public Adapter caseProcessSegmentParameter(ProcessSegmentParameter object) {
				return createProcessSegmentParameterAdapter();
			}
			@Override
			public Adapter casePersonnelSegmentSpecification(PersonnelSegmentSpecification object) {
				return createPersonnelSegmentSpecificationAdapter();
			}
			@Override
			public Adapter caseEquipmentSegmentSpecification(EquipmentSegmentSpecification object) {
				return createEquipmentSegmentSpecificationAdapter();
			}
			@Override
			public Adapter casePhysicalAssetSegmentSpecification(PhysicalAssetSegmentSpecification object) {
				return createPhysicalAssetSegmentSpecificationAdapter();
			}
			@Override
			public Adapter caseMaterialSegmentSpecification(MaterialSegmentSpecification object) {
				return createMaterialSegmentSpecificationAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.ProcessSegmentInformation <em>Process Segment Information</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.ProcessSegmentInformation
	 * @generated
	 */
	public Adapter createProcessSegmentInformationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.ProcessSegment <em>Process Segment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.ProcessSegment
	 * @generated
	 */
	public Adapter createProcessSegmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.ProcessSegmentParameter <em>Process Segment Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.ProcessSegmentParameter
	 * @generated
	 */
	public Adapter createProcessSegmentParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.PersonnelSegmentSpecification <em>Personnel Segment Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.PersonnelSegmentSpecification
	 * @generated
	 */
	public Adapter createPersonnelSegmentSpecificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.EquipmentSegmentSpecification <em>Equipment Segment Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.EquipmentSegmentSpecification
	 * @generated
	 */
	public Adapter createEquipmentSegmentSpecificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.PhysicalAssetSegmentSpecification <em>Physical Asset Segment Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.PhysicalAssetSegmentSpecification
	 * @generated
	 */
	public Adapter createPhysicalAssetSegmentSpecificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.MaterialSegmentSpecification <em>Material Segment Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.MaterialSegmentSpecification
	 * @generated
	 */
	public Adapter createMaterialSegmentSpecificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //B2mmlProcessSegmentAdapterFactory
