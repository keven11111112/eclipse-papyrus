/**
 */
package org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.ProductionSchedule.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.ProductionSchedule.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ProductionScheduleFactoryImpl extends EFactoryImpl implements ProductionScheduleFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ProductionScheduleFactory init() {
		try {
			ProductionScheduleFactory theProductionScheduleFactory = (ProductionScheduleFactory)EPackage.Registry.INSTANCE.getEFactory(ProductionSchedulePackage.eNS_URI);
			if (theProductionScheduleFactory != null) {
				return theProductionScheduleFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ProductionScheduleFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProductionScheduleFactoryImpl() {
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
			case ProductionSchedulePackage.PRODUCTION_SCHEDULE: return createProductionSchedule();
			case ProductionSchedulePackage.PRODUCTION_REQUEST: return createProductionRequest();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProductionSchedule createProductionSchedule() {
		ProductionScheduleImpl productionSchedule = new ProductionScheduleImpl();
		return productionSchedule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProductionRequest createProductionRequest() {
		ProductionRequestImpl productionRequest = new ProductionRequestImpl();
		return productionRequest;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProductionSchedulePackage getProductionSchedulePackage() {
		return (ProductionSchedulePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ProductionSchedulePackage getPackage() {
		return ProductionSchedulePackage.eINSTANCE;
	}

} //ProductionScheduleFactoryImpl
