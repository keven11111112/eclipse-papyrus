/**
 */
package org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.ExpansionModelPackage
 * @generated
 */
public interface ExpansionModelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ExpansionModelFactory eINSTANCE = org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.ExpansionModelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Representation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Representation</em>'.
	 * @generated
	 */
	Representation createRepresentation();

	/**
	 * Returns a new object of class '<em>Compartments</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Compartments</em>'.
	 * @generated
	 */
	Compartments createCompartments();

	/**
	 * Returns a new object of class '<em>Representation Library</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Representation Library</em>'.
	 * @generated
	 */
	RepresentationLibrary createRepresentationLibrary();

	/**
	 * Returns a new object of class '<em>Compartment Library</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Compartment Library</em>'.
	 * @generated
	 */
	CompartmentLibrary createCompartmentLibrary();

	/**
	 * Returns a new object of class '<em>Use Context</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Use Context</em>'.
	 * @generated
	 */
	UseContext createUseContext();

	/**
	 * Returns a new object of class '<em>Gmft Based Representation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Gmft Based Representation</em>'.
	 * @generated
	 */
	GmftBasedRepresentation createGmftBasedRepresentation();

	/**
	 * Returns a new object of class '<em>Diagram Expansion</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Diagram Expansion</em>'.
	 * @generated
	 */
	DiagramExpansion createDiagramExpansion();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ExpansionModelPackage getExpansionModelPackage();

} //ExpansionModelFactory
