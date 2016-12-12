/**
 * Copyright (c) 2015 CEA LIST.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 * 	CEA LIST - Initial API and implementation
 * 
 */
package org.eclipse.papyrus.infra.gmfdiag.expansion.expansionmodel.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.infra.gmfdiag.expansion.expansionmodel.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExpansionmodelFactoryImpl extends EFactoryImpl implements ExpansionmodelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ExpansionmodelFactory init() {
		try {
			ExpansionmodelFactory theExpansionmodelFactory = (ExpansionmodelFactory)EPackage.Registry.INSTANCE.getEFactory(ExpansionmodelPackage.eNS_URI);
			if (theExpansionmodelFactory != null) {
				return theExpansionmodelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ExpansionmodelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpansionmodelFactoryImpl() {
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
			case ExpansionmodelPackage.REPRESENTATION: return createRepresentation();
			case ExpansionmodelPackage.REPRESENTATION_KIND: return createRepresentationKind();
			case ExpansionmodelPackage.INDUCED_REPRESENTATION: return createInducedRepresentation();
			case ExpansionmodelPackage.GRAPHICAL_ELEMENT_LIBRARY: return createGraphicalElementLibrary();
			case ExpansionmodelPackage.USE_CONTEXT: return createUseContext();
			case ExpansionmodelPackage.GMFT_BASED_REPRESENTATION: return createGMFT_BasedRepresentation();
			case ExpansionmodelPackage.DIAGRAM_EXPANSION: return createDiagramExpansion();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
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
	public RepresentationKind createRepresentationKind() {
		RepresentationKindImpl representationKind = new RepresentationKindImpl();
		return representationKind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InducedRepresentation createInducedRepresentation() {
		InducedRepresentationImpl inducedRepresentation = new InducedRepresentationImpl();
		return inducedRepresentation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphicalElementLibrary createGraphicalElementLibrary() {
		GraphicalElementLibraryImpl graphicalElementLibrary = new GraphicalElementLibraryImpl();
		return graphicalElementLibrary;
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
	public GMFT_BasedRepresentation createGMFT_BasedRepresentation() {
		GMFT_BasedRepresentationImpl gmfT_BasedRepresentation = new GMFT_BasedRepresentationImpl();
		return gmfT_BasedRepresentation;
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
	public ExpansionmodelPackage getExpansionmodelPackage() {
		return (ExpansionmodelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ExpansionmodelPackage getPackage() {
		return ExpansionmodelPackage.eINSTANCE;
	}

} //ExpansionmodelFactoryImpl
