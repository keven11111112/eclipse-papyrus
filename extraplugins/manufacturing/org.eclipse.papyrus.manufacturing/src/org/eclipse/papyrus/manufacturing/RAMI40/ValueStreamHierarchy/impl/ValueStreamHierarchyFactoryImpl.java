/**
 */
package org.eclipse.papyrus.manufacturing.RAMI40.ValueStreamHierarchy.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.manufacturing.RAMI40.ValueStreamHierarchy.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ValueStreamHierarchyFactoryImpl extends EFactoryImpl implements ValueStreamHierarchyFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ValueStreamHierarchyFactory init() {
		try {
			ValueStreamHierarchyFactory theValueStreamHierarchyFactory = (ValueStreamHierarchyFactory)EPackage.Registry.INSTANCE.getEFactory(ValueStreamHierarchyPackage.eNS_URI);
			if (theValueStreamHierarchyFactory != null) {
				return theValueStreamHierarchyFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ValueStreamHierarchyFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueStreamHierarchyFactoryImpl() {
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
			case ValueStreamHierarchyPackage._1BUSINESS_LAYER: return create_1BusinessLayer();
			case ValueStreamHierarchyPackage._2FUNCTIONAL_LAYER: return create_2FunctionalLayer();
			case ValueStreamHierarchyPackage._3INFORMATION_LAYER: return create_3InformationLayer();
			case ValueStreamHierarchyPackage._4COMMUNICATION_LAYER: return create_4CommunicationLayer();
			case ValueStreamHierarchyPackage._5INTEGRATION_LAYER: return create_5IntegrationLayer();
			case ValueStreamHierarchyPackage._6ASSET_LAYER: return create_6AssetLayer();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public _1BusinessLayer create_1BusinessLayer() {
		_1BusinessLayerImpl _1BusinessLayer = new _1BusinessLayerImpl();
		return _1BusinessLayer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public _2FunctionalLayer create_2FunctionalLayer() {
		_2FunctionalLayerImpl _2FunctionalLayer = new _2FunctionalLayerImpl();
		return _2FunctionalLayer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public _3InformationLayer create_3InformationLayer() {
		_3InformationLayerImpl _3InformationLayer = new _3InformationLayerImpl();
		return _3InformationLayer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public _4CommunicationLayer create_4CommunicationLayer() {
		_4CommunicationLayerImpl _4CommunicationLayer = new _4CommunicationLayerImpl();
		return _4CommunicationLayer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public _5IntegrationLayer create_5IntegrationLayer() {
		_5IntegrationLayerImpl _5IntegrationLayer = new _5IntegrationLayerImpl();
		return _5IntegrationLayer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public _6AssetLayer create_6AssetLayer() {
		_6AssetLayerImpl _6AssetLayer = new _6AssetLayerImpl();
		return _6AssetLayer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueStreamHierarchyPackage getValueStreamHierarchyPackage() {
		return (ValueStreamHierarchyPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ValueStreamHierarchyPackage getPackage() {
		return ValueStreamHierarchyPackage.eINSTANCE;
	}

} //ValueStreamHierarchyFactoryImpl
