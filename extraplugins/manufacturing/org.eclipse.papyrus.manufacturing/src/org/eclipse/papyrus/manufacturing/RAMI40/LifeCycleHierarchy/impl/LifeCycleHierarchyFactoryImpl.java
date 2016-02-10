/**
 */
package org.eclipse.papyrus.manufacturing.RAMI40.LifeCycleHierarchy.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.manufacturing.RAMI40.LifeCycleHierarchy.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class LifeCycleHierarchyFactoryImpl extends EFactoryImpl implements LifeCycleHierarchyFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static LifeCycleHierarchyFactory init() {
		try {
			LifeCycleHierarchyFactory theLifeCycleHierarchyFactory = (LifeCycleHierarchyFactory)EPackage.Registry.INSTANCE.getEFactory(LifeCycleHierarchyPackage.eNS_URI);
			if (theLifeCycleHierarchyFactory != null) {
				return theLifeCycleHierarchyFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new LifeCycleHierarchyFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LifeCycleHierarchyFactoryImpl() {
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
			case LifeCycleHierarchyPackage._2INSTANCE_PRODUCTION: return create_2InstanceProduction();
			case LifeCycleHierarchyPackage._1TYPE_DEVELOPMENT: return create_1TypeDevelopment();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public _2InstanceProduction create_2InstanceProduction() {
		_2InstanceProductionImpl _2InstanceProduction = new _2InstanceProductionImpl();
		return _2InstanceProduction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public _1TypeDevelopment create_1TypeDevelopment() {
		_1TypeDevelopmentImpl _1TypeDevelopment = new _1TypeDevelopmentImpl();
		return _1TypeDevelopment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LifeCycleHierarchyPackage getLifeCycleHierarchyPackage() {
		return (LifeCycleHierarchyPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static LifeCycleHierarchyPackage getPackage() {
		return LifeCycleHierarchyPackage.eINSTANCE;
	}

} //LifeCycleHierarchyFactoryImpl
