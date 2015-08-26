/**
 * Copyright (c) 2015 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.migration.rsa.diagramholder;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

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
 * @see org.eclipse.papyrus.migration.rsa.diagramholder.DiagramHolderFactory
 * @model kind="package"
 * @generated
 */
public interface DiagramHolderPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "diagramholder";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/migration/diagramholder";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "res";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DiagramHolderPackage eINSTANCE = org.eclipse.papyrus.migration.rsa.diagramholder.impl.DiagramHolderPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.migration.rsa.diagramholder.impl.DiagramHolderImpl <em>Diagram Holder</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.migration.rsa.diagramholder.impl.DiagramHolderImpl
	 * @see org.eclipse.papyrus.migration.rsa.diagramholder.impl.DiagramHolderPackageImpl#getDiagramHolder()
	 * @generated
	 */
	int DIAGRAM_HOLDER = 0;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_HOLDER__EANNOTATIONS = EcorePackage.EANNOTATION__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_HOLDER__SOURCE = EcorePackage.EANNOTATION__SOURCE;

	/**
	 * The feature id for the '<em><b>Details</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_HOLDER__DETAILS = EcorePackage.EANNOTATION__DETAILS;

	/**
	 * The feature id for the '<em><b>EModel Element</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_HOLDER__EMODEL_ELEMENT = EcorePackage.EANNOTATION__EMODEL_ELEMENT;

	/**
	 * The feature id for the '<em><b>Contents</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_HOLDER__CONTENTS = EcorePackage.EANNOTATION__CONTENTS;

	/**
	 * The feature id for the '<em><b>References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_HOLDER__REFERENCES = EcorePackage.EANNOTATION__REFERENCES;

	/**
	 * The feature id for the '<em><b>Owned Diagrams</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_HOLDER__OWNED_DIAGRAMS = EcorePackage.EANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Diagram Holder</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_HOLDER_FEATURE_COUNT = EcorePackage.EANNOTATION_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get EAnnotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_HOLDER___GET_EANNOTATION__STRING = EcorePackage.EANNOTATION___GET_EANNOTATION__STRING;

	/**
	 * The number of operations of the '<em>Diagram Holder</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_HOLDER_OPERATION_COUNT = EcorePackage.EANNOTATION_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.migration.rsa.diagramholder.DiagramHolder <em>Diagram Holder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Diagram Holder</em>'.
	 * @see org.eclipse.papyrus.migration.rsa.diagramholder.DiagramHolder
	 * @generated
	 */
	EClass getDiagramHolder();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.migration.rsa.diagramholder.DiagramHolder#getOwnedDiagrams <em>Owned Diagrams</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Owned Diagrams</em>'.
	 * @see org.eclipse.papyrus.migration.rsa.diagramholder.DiagramHolder#getOwnedDiagrams()
	 * @see #getDiagramHolder()
	 * @generated
	 */
	EReference getDiagramHolder_OwnedDiagrams();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DiagramHolderFactory getDiagramHolderFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.migration.rsa.diagramholder.impl.DiagramHolderImpl <em>Diagram Holder</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.migration.rsa.diagramholder.impl.DiagramHolderImpl
		 * @see org.eclipse.papyrus.migration.rsa.diagramholder.impl.DiagramHolderPackageImpl#getDiagramHolder()
		 * @generated
		 */
		EClass DIAGRAM_HOLDER = eINSTANCE.getDiagramHolder();

		/**
		 * The meta object literal for the '<em><b>Owned Diagrams</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIAGRAM_HOLDER__OWNED_DIAGRAMS = eINSTANCE.getDiagramHolder_OwnedDiagrams();

	}

} //DiagramHolderPackage
