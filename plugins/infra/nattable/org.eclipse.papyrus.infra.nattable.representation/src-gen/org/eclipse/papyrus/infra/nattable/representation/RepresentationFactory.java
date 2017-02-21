/**
 * Copyright (c) 2017 CEA LIST.
 * 
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *  Maged Elaasar - Initial API and implementation
 *  
 * 
 */
package org.eclipse.papyrus.infra.nattable.representation;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.infra.nattable.representation.RepresentationPackage
 * @generated
 */
public interface RepresentationFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RepresentationFactory eINSTANCE = org.eclipse.papyrus.infra.nattable.representation.impl.RepresentationFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Papyrus Sync Table</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Papyrus Sync Table</em>'.
	 * @generated
	 */
	PapyrusSyncTable createPapyrusSyncTable();

	/**
	 * Returns a new object of class '<em>Papyrus Table</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Papyrus Table</em>'.
	 * @generated
	 */
	PapyrusTable createPapyrusTable();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	RepresentationPackage getRepresentationPackage();

} //RepresentationFactory
