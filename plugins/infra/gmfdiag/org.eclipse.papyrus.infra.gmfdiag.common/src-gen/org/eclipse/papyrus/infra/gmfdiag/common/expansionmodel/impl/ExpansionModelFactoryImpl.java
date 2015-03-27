/**
 */
package org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExpansionModelFactoryImpl extends EFactoryImpl implements ExpansionModelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ExpansionModelFactory init() {
		try {
			ExpansionModelFactory theExpansionModelFactory = (ExpansionModelFactory)EPackage.Registry.INSTANCE.getEFactory(ExpansionModelPackage.eNS_URI);
			if (theExpansionModelFactory != null) {
				return theExpansionModelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ExpansionModelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpansionModelFactoryImpl() {
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
			case ExpansionModelPackage.REPRESENTATION: return createRepresentation();
			case ExpansionModelPackage.COMPARTMENTS: return createCompartments();
			case ExpansionModelPackage.REPRESENTATION_LIBRARY: return createRepresentationLibrary();
			case ExpansionModelPackage.COMPARTMENT_LIBRARY: return createCompartmentLibrary();
			case ExpansionModelPackage.USE_CONTEXT: return createUseContext();
			case ExpansionModelPackage.GMFT_BASED_REPRESENTATION: return createGmftBasedRepresentation();
			case ExpansionModelPackage.DIAGRAM_EXPANSION: return createDiagramExpansion();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case ExpansionModelPackage.REPRESENTATION_KIND:
				return createRepresentationKindFromString(eDataType, initialValue);
			case ExpansionModelPackage.COMPARTMENT_KIND:
				return createCompartmentKindFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case ExpansionModelPackage.REPRESENTATION_KIND:
				return convertRepresentationKindToString(eDataType, instanceValue);
			case ExpansionModelPackage.COMPARTMENT_KIND:
				return convertCompartmentKindToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Representation createRepresentation() {
		RepresentationImpl representation = new RepresentationImpl();
		return representation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Compartments createCompartments() {
		CompartmentsImpl compartments = new CompartmentsImpl();
		return compartments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RepresentationLibrary createRepresentationLibrary() {
		RepresentationLibraryImpl representationLibrary = new RepresentationLibraryImpl();
		return representationLibrary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompartmentLibrary createCompartmentLibrary() {
		CompartmentLibraryImpl compartmentLibrary = new CompartmentLibraryImpl();
		return compartmentLibrary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UseContext createUseContext() {
		UseContextImpl useContext = new UseContextImpl();
		return useContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GmftBasedRepresentation createGmftBasedRepresentation() {
		GmftBasedRepresentationImpl gmftBasedRepresentation = new GmftBasedRepresentationImpl();
		return gmftBasedRepresentation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DiagramExpansion createDiagramExpansion() {
		DiagramExpansionImpl diagramExpansion = new DiagramExpansionImpl();
		return diagramExpansion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RepresentationKind createRepresentationKindFromString(EDataType eDataType, String initialValue) {
		RepresentationKind result = RepresentationKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRepresentationKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompartmentKind createCompartmentKindFromString(EDataType eDataType, String initialValue) {
		CompartmentKind result = CompartmentKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCompartmentKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpansionModelPackage getExpansionModelPackage() {
		return (ExpansionModelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ExpansionModelPackage getPackage() {
		return ExpansionModelPackage.eINSTANCE;
	}

} //ExpansionModelFactoryImpl
