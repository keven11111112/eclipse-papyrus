/**
 * Copyright (c) 2014 CEA LIST.
 * 
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.infra.elementtypesconfigurations;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.ElementtypesconfigurationsPackage
 * @generated
 */
public interface ElementtypesconfigurationsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ElementtypesconfigurationsFactory eINSTANCE = org.eclipse.papyrus.infra.elementtypesconfigurations.impl.ElementtypesconfigurationsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Element Type Set Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Element Type Set Configuration</em>'.
	 * @generated
	 */
	ElementTypeSetConfiguration createElementTypeSetConfiguration();

	/**
	 * Returns a new object of class '<em>Icon Entry</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Icon Entry</em>'.
	 * @generated
	 */
	IconEntry createIconEntry();

	/**
	 * Returns a new object of class '<em>Specialization Type Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Specialization Type Configuration</em>'.
	 * @generated
	 */
	SpecializationTypeConfiguration createSpecializationTypeConfiguration();

	/**
	 * Returns a new object of class '<em>Container Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Container Configuration</em>'.
	 * @generated
	 */
	ContainerConfiguration createContainerConfiguration();

	/**
	 * Returns a new object of class '<em>Metamodel Type Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Metamodel Type Configuration</em>'.
	 * @generated
	 */
	MetamodelTypeConfiguration createMetamodelTypeConfiguration();

	/**
	 * Returns a new object of class '<em>Edit Helper Advice Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Edit Helper Advice Configuration</em>'.
	 * @generated
	 */
	EditHelperAdviceConfiguration createEditHelperAdviceConfiguration();

	/**
	 * Returns a new object of class '<em>Advice Binding Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Advice Binding Configuration</em>'.
	 * @generated
	 */
	AdviceBindingConfiguration createAdviceBindingConfiguration();

	/**
	 * Returns a new object of class '<em>Matcher Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Matcher Configuration</em>'.
	 * @generated
	 */
	MatcherConfiguration createMatcherConfiguration();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ElementtypesconfigurationsPackage getElementtypesconfigurationsPackage();

} //ElementtypesconfigurationsFactory
