/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Sara TUCCI (CEA LIST) sara.tucci@cea.fr - Initial API and implementation
 *  Chokri MRAIDHA (CEA LIST) chokri.mraidha@cea.fr - Initial API and implementation
 *  David SERVAT (CEA LIST) david.servat@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.eastadl;

import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains accessors for the meta
 * objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 *
 * @see org.eclipse.papyrus.eastadl.EastadlFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='EAST-ADL2'"
 * @generated
 */
public interface EastadlPackage extends EPackage {

	/**
	 * <!-- begin-user-doc --> Defines literals for the meta objects that represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	interface Literals {

		/**
		 * The meta object literal for the '<em>Dummy</em>' data type.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 *
		 * @see java.lang.String
		 * @see org.eclipse.papyrus.eastadl.impl.EastadlPackageImpl#getDummy()
		 * @generated
		 */
		EDataType DUMMY = eINSTANCE.getDummy();

	}

	/**
	 * The package name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	String eNAME = "eastadl";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	String eNS_URI = "http://www.papyrusuml.org/EAST-ADL2/1";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	String eNS_PREFIX = "EAST-ADL2";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	EastadlPackage eINSTANCE = org.eclipse.papyrus.eastadl.impl.EastadlPackageImpl.init();

	/**
	 * The meta object id for the '<em>Dummy</em>' data type.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @see java.lang.String
	 * @see org.eclipse.papyrus.eastadl.impl.EastadlPackageImpl#getDummy()
	 * @generated
	 */
	int DUMMY = 0;

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Dummy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for data type '<em>Dummy</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getDummy();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EastadlFactory getEastadlFactory();

} // EastadlPackage
