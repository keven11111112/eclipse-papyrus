/**
 */
package org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.ExpansionModelFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='ExpansionModel'"
 * @generated
 */
public interface ExpansionModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "expansionmodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///expansionmodel.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "expansionmodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ExpansionModelPackage eINSTANCE = org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.ExpansionModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.RepresentationImpl <em>Representation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.RepresentationImpl
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.ExpansionModelPackageImpl#getRepresentation()
	 * @generated
	 */
	int REPRESENTATION = 0;

	/**
	 * The feature id for the '<em><b>Edit Part Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPRESENTATION__EDIT_PART_QUALIFIED_NAME = 0;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPRESENTATION__KIND = 1;

	/**
	 * The feature id for the '<em><b>Graphical Element Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPRESENTATION__GRAPHICAL_ELEMENT_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Compartments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPRESENTATION__COMPARTMENTS = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPRESENTATION__NAME = 4;

	/**
	 * The feature id for the '<em><b>View Factory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPRESENTATION__VIEW_FACTORY = 5;

	/**
	 * The number of structural features of the '<em>Representation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPRESENTATION_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Representation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPRESENTATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.CompartmentsImpl <em>Compartments</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.CompartmentsImpl
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.ExpansionModelPackageImpl#getCompartments()
	 * @generated
	 */
	int COMPARTMENTS = 1;

	/**
	 * The feature id for the '<em><b>Hint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARTMENTS__HINT = 0;

	/**
	 * The feature id for the '<em><b>Children</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARTMENTS__CHILDREN = 1;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARTMENTS__KIND = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARTMENTS__NAME = 3;

	/**
	 * The feature id for the '<em><b>Edit Part Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARTMENTS__EDIT_PART_QUALIFIED_NAME = 4;

	/**
	 * The number of structural features of the '<em>Compartments</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARTMENTS_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Compartments</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARTMENTS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.LibraryImpl <em>Library</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.LibraryImpl
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.ExpansionModelPackageImpl#getLibrary()
	 * @generated
	 */
	int LIBRARY = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__NAME = 0;

	/**
	 * The number of structural features of the '<em>Library</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Library</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.RepresentationLibraryImpl <em>Representation Library</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.RepresentationLibraryImpl
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.ExpansionModelPackageImpl#getRepresentationLibrary()
	 * @generated
	 */
	int REPRESENTATION_LIBRARY = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPRESENTATION_LIBRARY__NAME = LIBRARY__NAME;

	/**
	 * The feature id for the '<em><b>Representations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPRESENTATION_LIBRARY__REPRESENTATIONS = LIBRARY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Representation Library</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPRESENTATION_LIBRARY_FEATURE_COUNT = LIBRARY_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Representation Library</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPRESENTATION_LIBRARY_OPERATION_COUNT = LIBRARY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.CompartmentLibraryImpl <em>Compartment Library</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.CompartmentLibraryImpl
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.ExpansionModelPackageImpl#getCompartmentLibrary()
	 * @generated
	 */
	int COMPARTMENT_LIBRARY = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARTMENT_LIBRARY__NAME = LIBRARY__NAME;

	/**
	 * The feature id for the '<em><b>Compartments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARTMENT_LIBRARY__COMPARTMENTS = LIBRARY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Compartment Library</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARTMENT_LIBRARY_FEATURE_COUNT = LIBRARY_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Compartment Library</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARTMENT_LIBRARY_OPERATION_COUNT = LIBRARY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.UseContextImpl <em>Use Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.UseContextImpl
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.ExpansionModelPackageImpl#getUseContext()
	 * @generated
	 */
	int USE_CONTEXT = 5;

	/**
	 * The feature id for the '<em><b>Diagram Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CONTEXT__DIAGRAM_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Representations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CONTEXT__REPRESENTATIONS = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CONTEXT__NAME = 2;

	/**
	 * The feature id for the '<em><b>Gmft Representations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CONTEXT__GMFT_REPRESENTATIONS = 3;

	/**
	 * The number of structural features of the '<em>Use Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CONTEXT_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Use Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CONTEXT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.GmftBasedRepresentationImpl <em>Gmft Based Representation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.GmftBasedRepresentationImpl
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.ExpansionModelPackageImpl#getGmftBasedRepresentation()
	 * @generated
	 */
	int GMFT_BASED_REPRESENTATION = 6;

	/**
	 * The feature id for the '<em><b>Edit Part Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GMFT_BASED_REPRESENTATION__EDIT_PART_QUALIFIED_NAME = REPRESENTATION__EDIT_PART_QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GMFT_BASED_REPRESENTATION__KIND = REPRESENTATION__KIND;

	/**
	 * The feature id for the '<em><b>Graphical Element Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GMFT_BASED_REPRESENTATION__GRAPHICAL_ELEMENT_TYPE = REPRESENTATION__GRAPHICAL_ELEMENT_TYPE;

	/**
	 * The feature id for the '<em><b>Compartments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GMFT_BASED_REPRESENTATION__COMPARTMENTS = REPRESENTATION__COMPARTMENTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GMFT_BASED_REPRESENTATION__NAME = REPRESENTATION__NAME;

	/**
	 * The feature id for the '<em><b>View Factory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GMFT_BASED_REPRESENTATION__VIEW_FACTORY = REPRESENTATION__VIEW_FACTORY;

	/**
	 * The feature id for the '<em><b>Reused Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GMFT_BASED_REPRESENTATION__REUSED_ID = REPRESENTATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Gmft Based Representation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GMFT_BASED_REPRESENTATION_FEATURE_COUNT = REPRESENTATION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Gmft Based Representation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GMFT_BASED_REPRESENTATION_OPERATION_COUNT = REPRESENTATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.DiagramExpansionImpl <em>Diagram Expansion</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.DiagramExpansionImpl
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.ExpansionModelPackageImpl#getDiagramExpansion()
	 * @generated
	 */
	int DIAGRAM_EXPANSION = 7;

	/**
	 * The feature id for the '<em><b>Usages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_EXPANSION__USAGES = 0;

	/**
	 * The feature id for the '<em><b>Libraries</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_EXPANSION__LIBRARIES = 1;

	/**
	 * The number of structural features of the '<em>Diagram Expansion</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_EXPANSION_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Diagram Expansion</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_EXPANSION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.RepresentationKind <em>Representation Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.RepresentationKind
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.ExpansionModelPackageImpl#getRepresentationKind()
	 * @generated
	 */
	int REPRESENTATION_KIND = 8;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.CompartmentKind <em>Compartment Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.CompartmentKind
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.ExpansionModelPackageImpl#getCompartmentKind()
	 * @generated
	 */
	int COMPARTMENT_KIND = 9;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.Representation <em>Representation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Representation</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.Representation
	 * @generated
	 */
	EClass getRepresentation();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.Representation#getEditPartQualifiedName <em>Edit Part Qualified Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Edit Part Qualified Name</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.Representation#getEditPartQualifiedName()
	 * @see #getRepresentation()
	 * @generated
	 */
	EAttribute getRepresentation_EditPartQualifiedName();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.Representation#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.Representation#getKind()
	 * @see #getRepresentation()
	 * @generated
	 */
	EAttribute getRepresentation_Kind();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.Representation#getGraphicalElementType <em>Graphical Element Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Graphical Element Type</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.Representation#getGraphicalElementType()
	 * @see #getRepresentation()
	 * @generated
	 */
	EAttribute getRepresentation_GraphicalElementType();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.Representation#getCompartments <em>Compartments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Compartments</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.Representation#getCompartments()
	 * @see #getRepresentation()
	 * @generated
	 */
	EReference getRepresentation_Compartments();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.Representation#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.Representation#getName()
	 * @see #getRepresentation()
	 * @generated
	 */
	EAttribute getRepresentation_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.Representation#getViewFactory <em>View Factory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>View Factory</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.Representation#getViewFactory()
	 * @see #getRepresentation()
	 * @generated
	 */
	EAttribute getRepresentation_ViewFactory();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.Compartments <em>Compartments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Compartments</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.Compartments
	 * @generated
	 */
	EClass getCompartments();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.Compartments#getHint <em>Hint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hint</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.Compartments#getHint()
	 * @see #getCompartments()
	 * @generated
	 */
	EAttribute getCompartments_Hint();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.Compartments#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Children</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.Compartments#getChildren()
	 * @see #getCompartments()
	 * @generated
	 */
	EReference getCompartments_Children();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.Compartments#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.Compartments#getKind()
	 * @see #getCompartments()
	 * @generated
	 */
	EAttribute getCompartments_Kind();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.Compartments#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.Compartments#getName()
	 * @see #getCompartments()
	 * @generated
	 */
	EAttribute getCompartments_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.Compartments#getEditPartQualifiedName <em>Edit Part Qualified Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Edit Part Qualified Name</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.Compartments#getEditPartQualifiedName()
	 * @see #getCompartments()
	 * @generated
	 */
	EAttribute getCompartments_EditPartQualifiedName();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.RepresentationLibrary <em>Representation Library</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Representation Library</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.RepresentationLibrary
	 * @generated
	 */
	EClass getRepresentationLibrary();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.RepresentationLibrary#getRepresentations <em>Representations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Representations</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.RepresentationLibrary#getRepresentations()
	 * @see #getRepresentationLibrary()
	 * @generated
	 */
	EReference getRepresentationLibrary_Representations();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.Library <em>Library</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Library</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.Library
	 * @generated
	 */
	EClass getLibrary();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.Library#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.Library#getName()
	 * @see #getLibrary()
	 * @generated
	 */
	EAttribute getLibrary_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.CompartmentLibrary <em>Compartment Library</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Compartment Library</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.CompartmentLibrary
	 * @generated
	 */
	EClass getCompartmentLibrary();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.CompartmentLibrary#getCompartments <em>Compartments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Compartments</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.CompartmentLibrary#getCompartments()
	 * @see #getCompartmentLibrary()
	 * @generated
	 */
	EReference getCompartmentLibrary_Compartments();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.UseContext <em>Use Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Use Context</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.UseContext
	 * @generated
	 */
	EClass getUseContext();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.UseContext#getDiagramType <em>Diagram Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Diagram Type</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.UseContext#getDiagramType()
	 * @see #getUseContext()
	 * @generated
	 */
	EAttribute getUseContext_DiagramType();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.UseContext#getRepresentations <em>Representations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Representations</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.UseContext#getRepresentations()
	 * @see #getUseContext()
	 * @generated
	 */
	EReference getUseContext_Representations();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.UseContext#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.UseContext#getName()
	 * @see #getUseContext()
	 * @generated
	 */
	EAttribute getUseContext_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.UseContext#getGmftRepresentations <em>Gmft Representations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Gmft Representations</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.UseContext#getGmftRepresentations()
	 * @see #getUseContext()
	 * @generated
	 */
	EReference getUseContext_GmftRepresentations();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.GmftBasedRepresentation <em>Gmft Based Representation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gmft Based Representation</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.GmftBasedRepresentation
	 * @generated
	 */
	EClass getGmftBasedRepresentation();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.GmftBasedRepresentation#getReusedId <em>Reused Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Reused Id</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.GmftBasedRepresentation#getReusedId()
	 * @see #getGmftBasedRepresentation()
	 * @generated
	 */
	EAttribute getGmftBasedRepresentation_ReusedId();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.DiagramExpansion <em>Diagram Expansion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Diagram Expansion</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.DiagramExpansion
	 * @generated
	 */
	EClass getDiagramExpansion();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.DiagramExpansion#getUsages <em>Usages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Usages</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.DiagramExpansion#getUsages()
	 * @see #getDiagramExpansion()
	 * @generated
	 */
	EReference getDiagramExpansion_Usages();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.DiagramExpansion#getLibraries <em>Libraries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Libraries</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.DiagramExpansion#getLibraries()
	 * @see #getDiagramExpansion()
	 * @generated
	 */
	EReference getDiagramExpansion_Libraries();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.RepresentationKind <em>Representation Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Representation Kind</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.RepresentationKind
	 * @generated
	 */
	EEnum getRepresentationKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.CompartmentKind <em>Compartment Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Compartment Kind</em>'.
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.CompartmentKind
	 * @generated
	 */
	EEnum getCompartmentKind();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ExpansionModelFactory getExpansionModelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.RepresentationImpl <em>Representation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.RepresentationImpl
		 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.ExpansionModelPackageImpl#getRepresentation()
		 * @generated
		 */
		EClass REPRESENTATION = eINSTANCE.getRepresentation();

		/**
		 * The meta object literal for the '<em><b>Edit Part Qualified Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REPRESENTATION__EDIT_PART_QUALIFIED_NAME = eINSTANCE.getRepresentation_EditPartQualifiedName();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REPRESENTATION__KIND = eINSTANCE.getRepresentation_Kind();

		/**
		 * The meta object literal for the '<em><b>Graphical Element Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REPRESENTATION__GRAPHICAL_ELEMENT_TYPE = eINSTANCE.getRepresentation_GraphicalElementType();

		/**
		 * The meta object literal for the '<em><b>Compartments</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REPRESENTATION__COMPARTMENTS = eINSTANCE.getRepresentation_Compartments();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REPRESENTATION__NAME = eINSTANCE.getRepresentation_Name();

		/**
		 * The meta object literal for the '<em><b>View Factory</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REPRESENTATION__VIEW_FACTORY = eINSTANCE.getRepresentation_ViewFactory();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.CompartmentsImpl <em>Compartments</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.CompartmentsImpl
		 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.ExpansionModelPackageImpl#getCompartments()
		 * @generated
		 */
		EClass COMPARTMENTS = eINSTANCE.getCompartments();

		/**
		 * The meta object literal for the '<em><b>Hint</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPARTMENTS__HINT = eINSTANCE.getCompartments_Hint();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPARTMENTS__CHILDREN = eINSTANCE.getCompartments_Children();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPARTMENTS__KIND = eINSTANCE.getCompartments_Kind();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPARTMENTS__NAME = eINSTANCE.getCompartments_Name();

		/**
		 * The meta object literal for the '<em><b>Edit Part Qualified Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPARTMENTS__EDIT_PART_QUALIFIED_NAME = eINSTANCE.getCompartments_EditPartQualifiedName();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.RepresentationLibraryImpl <em>Representation Library</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.RepresentationLibraryImpl
		 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.ExpansionModelPackageImpl#getRepresentationLibrary()
		 * @generated
		 */
		EClass REPRESENTATION_LIBRARY = eINSTANCE.getRepresentationLibrary();

		/**
		 * The meta object literal for the '<em><b>Representations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REPRESENTATION_LIBRARY__REPRESENTATIONS = eINSTANCE.getRepresentationLibrary_Representations();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.LibraryImpl <em>Library</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.LibraryImpl
		 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.ExpansionModelPackageImpl#getLibrary()
		 * @generated
		 */
		EClass LIBRARY = eINSTANCE.getLibrary();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIBRARY__NAME = eINSTANCE.getLibrary_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.CompartmentLibraryImpl <em>Compartment Library</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.CompartmentLibraryImpl
		 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.ExpansionModelPackageImpl#getCompartmentLibrary()
		 * @generated
		 */
		EClass COMPARTMENT_LIBRARY = eINSTANCE.getCompartmentLibrary();

		/**
		 * The meta object literal for the '<em><b>Compartments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPARTMENT_LIBRARY__COMPARTMENTS = eINSTANCE.getCompartmentLibrary_Compartments();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.UseContextImpl <em>Use Context</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.UseContextImpl
		 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.ExpansionModelPackageImpl#getUseContext()
		 * @generated
		 */
		EClass USE_CONTEXT = eINSTANCE.getUseContext();

		/**
		 * The meta object literal for the '<em><b>Diagram Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USE_CONTEXT__DIAGRAM_TYPE = eINSTANCE.getUseContext_DiagramType();

		/**
		 * The meta object literal for the '<em><b>Representations</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USE_CONTEXT__REPRESENTATIONS = eINSTANCE.getUseContext_Representations();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USE_CONTEXT__NAME = eINSTANCE.getUseContext_Name();

		/**
		 * The meta object literal for the '<em><b>Gmft Representations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USE_CONTEXT__GMFT_REPRESENTATIONS = eINSTANCE.getUseContext_GmftRepresentations();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.GmftBasedRepresentationImpl <em>Gmft Based Representation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.GmftBasedRepresentationImpl
		 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.ExpansionModelPackageImpl#getGmftBasedRepresentation()
		 * @generated
		 */
		EClass GMFT_BASED_REPRESENTATION = eINSTANCE.getGmftBasedRepresentation();

		/**
		 * The meta object literal for the '<em><b>Reused Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GMFT_BASED_REPRESENTATION__REUSED_ID = eINSTANCE.getGmftBasedRepresentation_ReusedId();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.DiagramExpansionImpl <em>Diagram Expansion</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.DiagramExpansionImpl
		 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.ExpansionModelPackageImpl#getDiagramExpansion()
		 * @generated
		 */
		EClass DIAGRAM_EXPANSION = eINSTANCE.getDiagramExpansion();

		/**
		 * The meta object literal for the '<em><b>Usages</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIAGRAM_EXPANSION__USAGES = eINSTANCE.getDiagramExpansion_Usages();

		/**
		 * The meta object literal for the '<em><b>Libraries</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIAGRAM_EXPANSION__LIBRARIES = eINSTANCE.getDiagramExpansion_Libraries();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.RepresentationKind <em>Representation Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.RepresentationKind
		 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.ExpansionModelPackageImpl#getRepresentationKind()
		 * @generated
		 */
		EEnum REPRESENTATION_KIND = eINSTANCE.getRepresentationKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.CompartmentKind <em>Compartment Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.CompartmentKind
		 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.ExpansionModelPackageImpl#getCompartmentKind()
		 * @generated
		 */
		EEnum COMPARTMENT_KIND = eINSTANCE.getCompartmentKind();

	}

} //ExpansionModelPackage
