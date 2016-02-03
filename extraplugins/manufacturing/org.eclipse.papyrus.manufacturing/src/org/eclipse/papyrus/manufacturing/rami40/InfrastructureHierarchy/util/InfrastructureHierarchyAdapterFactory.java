/**
 */
package org.eclipse.papyrus.manufacturing.rami40.InfrastructureHierarchy.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.papyrus.manufacturing.rami40.InfrastructureHierarchy.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.manufacturing.rami40.InfrastructureHierarchy.InfrastructureHierarchyPackage
 * @generated
 */
public class InfrastructureHierarchyAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static InfrastructureHierarchyPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InfrastructureHierarchyAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = InfrastructureHierarchyPackage.eINSTANCE;
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
	protected InfrastructureHierarchySwitch<Adapter> modelSwitch =
		new InfrastructureHierarchySwitch<Adapter>() {
			@Override
			public Adapter case_1ConnectedWorld(_1ConnectedWorld object) {
				return create_1ConnectedWorldAdapter();
			}
			@Override
			public Adapter case_2EnterpriseLevel(_2EnterpriseLevel object) {
				return create_2EnterpriseLevelAdapter();
			}
			@Override
			public Adapter case_3WorkCentersLevel(_3WorkCentersLevel object) {
				return create_3WorkCentersLevelAdapter();
			}
			@Override
			public Adapter case_4StationsLevel(_4StationsLevel object) {
				return create_4StationsLevelAdapter();
			}
			@Override
			public Adapter case_5ControlDeviceLevel(_5ControlDeviceLevel object) {
				return create_5ControlDeviceLevelAdapter();
			}
			@Override
			public Adapter case_6FieldDeviceLevel(_6FieldDeviceLevel object) {
				return create_6FieldDeviceLevelAdapter();
			}
			@Override
			public Adapter case_7ProductLevel(_7ProductLevel object) {
				return create_7ProductLevelAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.manufacturing.rami40.InfrastructureHierarchy._1ConnectedWorld <em>1Connected World</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.manufacturing.rami40.InfrastructureHierarchy._1ConnectedWorld
	 * @generated
	 */
	public Adapter create_1ConnectedWorldAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.manufacturing.rami40.InfrastructureHierarchy._2EnterpriseLevel <em>2Enterprise Level</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.manufacturing.rami40.InfrastructureHierarchy._2EnterpriseLevel
	 * @generated
	 */
	public Adapter create_2EnterpriseLevelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.manufacturing.rami40.InfrastructureHierarchy._3WorkCentersLevel <em>3Work Centers Level</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.manufacturing.rami40.InfrastructureHierarchy._3WorkCentersLevel
	 * @generated
	 */
	public Adapter create_3WorkCentersLevelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.manufacturing.rami40.InfrastructureHierarchy._4StationsLevel <em>4Stations Level</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.manufacturing.rami40.InfrastructureHierarchy._4StationsLevel
	 * @generated
	 */
	public Adapter create_4StationsLevelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.manufacturing.rami40.InfrastructureHierarchy._5ControlDeviceLevel <em>5Control Device Level</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.manufacturing.rami40.InfrastructureHierarchy._5ControlDeviceLevel
	 * @generated
	 */
	public Adapter create_5ControlDeviceLevelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.manufacturing.rami40.InfrastructureHierarchy._6FieldDeviceLevel <em>6Field Device Level</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.manufacturing.rami40.InfrastructureHierarchy._6FieldDeviceLevel
	 * @generated
	 */
	public Adapter create_6FieldDeviceLevelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.manufacturing.rami40.InfrastructureHierarchy._7ProductLevel <em>7Product Level</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.manufacturing.rami40.InfrastructureHierarchy._7ProductLevel
	 * @generated
	 */
	public Adapter create_7ProductLevelAdapter() {
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

} //InfrastructureHierarchyAdapterFactory
