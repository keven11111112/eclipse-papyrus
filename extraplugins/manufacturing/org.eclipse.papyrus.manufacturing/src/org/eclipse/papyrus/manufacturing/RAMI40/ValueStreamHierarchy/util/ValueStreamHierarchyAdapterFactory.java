/**
 */
package org.eclipse.papyrus.manufacturing.RAMI40.ValueStreamHierarchy.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.papyrus.manufacturing.RAMI40.ValueStreamHierarchy.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.manufacturing.RAMI40.ValueStreamHierarchy.ValueStreamHierarchyPackage
 * @generated
 */
public class ValueStreamHierarchyAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ValueStreamHierarchyPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueStreamHierarchyAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ValueStreamHierarchyPackage.eINSTANCE;
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
	protected ValueStreamHierarchySwitch<Adapter> modelSwitch =
		new ValueStreamHierarchySwitch<Adapter>() {
			@Override
			public Adapter case_1BusinessLayer(_1BusinessLayer object) {
				return create_1BusinessLayerAdapter();
			}
			@Override
			public Adapter case_2FunctionalLayer(_2FunctionalLayer object) {
				return create_2FunctionalLayerAdapter();
			}
			@Override
			public Adapter case_3InformationLayer(_3InformationLayer object) {
				return create_3InformationLayerAdapter();
			}
			@Override
			public Adapter case_4CommunicationLayer(_4CommunicationLayer object) {
				return create_4CommunicationLayerAdapter();
			}
			@Override
			public Adapter case_5IntegrationLayer(_5IntegrationLayer object) {
				return create_5IntegrationLayerAdapter();
			}
			@Override
			public Adapter case_6AssetLayer(_6AssetLayer object) {
				return create_6AssetLayerAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.manufacturing.RAMI40.ValueStreamHierarchy._1BusinessLayer <em>1Business Layer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.manufacturing.RAMI40.ValueStreamHierarchy._1BusinessLayer
	 * @generated
	 */
	public Adapter create_1BusinessLayerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.manufacturing.RAMI40.ValueStreamHierarchy._2FunctionalLayer <em>2Functional Layer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.manufacturing.RAMI40.ValueStreamHierarchy._2FunctionalLayer
	 * @generated
	 */
	public Adapter create_2FunctionalLayerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.manufacturing.RAMI40.ValueStreamHierarchy._3InformationLayer <em>3Information Layer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.manufacturing.RAMI40.ValueStreamHierarchy._3InformationLayer
	 * @generated
	 */
	public Adapter create_3InformationLayerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.manufacturing.RAMI40.ValueStreamHierarchy._4CommunicationLayer <em>4Communication Layer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.manufacturing.RAMI40.ValueStreamHierarchy._4CommunicationLayer
	 * @generated
	 */
	public Adapter create_4CommunicationLayerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.manufacturing.RAMI40.ValueStreamHierarchy._5IntegrationLayer <em>5Integration Layer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.manufacturing.RAMI40.ValueStreamHierarchy._5IntegrationLayer
	 * @generated
	 */
	public Adapter create_5IntegrationLayerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.manufacturing.RAMI40.ValueStreamHierarchy._6AssetLayer <em>6Asset Layer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.manufacturing.RAMI40.ValueStreamHierarchy._6AssetLayer
	 * @generated
	 */
	public Adapter create_6AssetLayerAdapter() {
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

} //ValueStreamHierarchyAdapterFactory
