/**
 */
package org.eclipse.papyrus.uml.types.core.advices.stereotypepropertyreferenceedgeadvice.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.uml.types.core.advices.stereotypepropertyreferenceedgeadvice.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class StereotypePropertyReferenceEdgeAdviceFactoryImpl extends EFactoryImpl implements StereotypePropertyReferenceEdgeAdviceFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static StereotypePropertyReferenceEdgeAdviceFactory init() {
		try {
			StereotypePropertyReferenceEdgeAdviceFactory theStereotypePropertyReferenceEdgeAdviceFactory = (StereotypePropertyReferenceEdgeAdviceFactory)EPackage.Registry.INSTANCE.getEFactory(StereotypePropertyReferenceEdgeAdvicePackage.eNS_URI);
			if (theStereotypePropertyReferenceEdgeAdviceFactory != null) {
				return theStereotypePropertyReferenceEdgeAdviceFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new StereotypePropertyReferenceEdgeAdviceFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StereotypePropertyReferenceEdgeAdviceFactoryImpl() {
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
			case StereotypePropertyReferenceEdgeAdvicePackage.STEREOTYPE_PROPERTY_REFERENCE_EDGE_ADVICE_CONFIGURATION: return createStereotypePropertyReferenceEdgeAdviceConfiguration();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StereotypePropertyReferenceEdgeAdviceConfiguration createStereotypePropertyReferenceEdgeAdviceConfiguration() {
		StereotypePropertyReferenceEdgeAdviceConfigurationImpl stereotypePropertyReferenceEdgeAdviceConfiguration = new StereotypePropertyReferenceEdgeAdviceConfigurationImpl();
		return stereotypePropertyReferenceEdgeAdviceConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StereotypePropertyReferenceEdgeAdvicePackage getStereotypePropertyReferenceEdgeAdvicePackage() {
		return (StereotypePropertyReferenceEdgeAdvicePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static StereotypePropertyReferenceEdgeAdvicePackage getPackage() {
		return StereotypePropertyReferenceEdgeAdvicePackage.eINSTANCE;
	}

} //StereotypePropertyReferenceEdgeAdviceFactoryImpl
