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
package org.eclipse.papyrus.uml.tools.elementtypesconfigurations.stereotypeapplicationmatcherconfiguration;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.papyrus.infra.elementtypesconfigurations.ElementtypesconfigurationsPackage;

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
 * @see org.eclipse.papyrus.uml.tools.elementtypesconfigurations.stereotypeapplicationmatcherconfiguration.StereotypeApplicationMatcherConfigurationFactory
 * @model kind="package"
 * @generated
 */
public interface StereotypeApplicationMatcherConfigurationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "stereotypeapplicationmatcherconfiguration";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/payrus/elementtypesconfigurations/uml/stereotypematcherconfiguration/1.1";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "stereotypeapplicationmatcherconfiguration";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	StereotypeApplicationMatcherConfigurationPackage eINSTANCE = org.eclipse.papyrus.uml.tools.elementtypesconfigurations.stereotypeapplicationmatcherconfiguration.impl.StereotypeApplicationMatcherConfigurationPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.tools.elementtypesconfigurations.stereotypeapplicationmatcherconfiguration.impl.StereotypeApplicationMatcherConfigurationImpl <em>Stereotype Application Matcher Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.uml.tools.elementtypesconfigurations.stereotypeapplicationmatcherconfiguration.impl.StereotypeApplicationMatcherConfigurationImpl
	 * @see org.eclipse.papyrus.uml.tools.elementtypesconfigurations.stereotypeapplicationmatcherconfiguration.impl.StereotypeApplicationMatcherConfigurationPackageImpl#getStereotypeApplicationMatcherConfiguration()
	 * @generated
	 */
	int STEREOTYPE_APPLICATION_MATCHER_CONFIGURATION = 0;

	/**
	 * The feature id for the '<em><b>Stereotypes Qualified Names</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_APPLICATION_MATCHER_CONFIGURATION__STEREOTYPES_QUALIFIED_NAMES = ElementtypesconfigurationsPackage.ABSTRACT_MATCHER_CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Profile Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_APPLICATION_MATCHER_CONFIGURATION__PROFILE_URI = ElementtypesconfigurationsPackage.ABSTRACT_MATCHER_CONFIGURATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Stereotype Application Matcher Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_APPLICATION_MATCHER_CONFIGURATION_FEATURE_COUNT = ElementtypesconfigurationsPackage.ABSTRACT_MATCHER_CONFIGURATION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Stereotype Application Matcher Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_APPLICATION_MATCHER_CONFIGURATION_OPERATION_COUNT = ElementtypesconfigurationsPackage.ABSTRACT_MATCHER_CONFIGURATION_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.tools.elementtypesconfigurations.stereotypeapplicationmatcherconfiguration.StereotypeApplicationMatcherConfiguration <em>Stereotype Application Matcher Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stereotype Application Matcher Configuration</em>'.
	 * @see org.eclipse.papyrus.uml.tools.elementtypesconfigurations.stereotypeapplicationmatcherconfiguration.StereotypeApplicationMatcherConfiguration
	 * @generated
	 */
	EClass getStereotypeApplicationMatcherConfiguration();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.uml.tools.elementtypesconfigurations.stereotypeapplicationmatcherconfiguration.StereotypeApplicationMatcherConfiguration#getStereotypesQualifiedNames <em>Stereotypes Qualified Names</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Stereotypes Qualified Names</em>'.
	 * @see org.eclipse.papyrus.uml.tools.elementtypesconfigurations.stereotypeapplicationmatcherconfiguration.StereotypeApplicationMatcherConfiguration#getStereotypesQualifiedNames()
	 * @see #getStereotypeApplicationMatcherConfiguration()
	 * @generated
	 */
	EAttribute getStereotypeApplicationMatcherConfiguration_StereotypesQualifiedNames();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.tools.elementtypesconfigurations.stereotypeapplicationmatcherconfiguration.StereotypeApplicationMatcherConfiguration#getProfileUri <em>Profile Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Profile Uri</em>'.
	 * @see org.eclipse.papyrus.uml.tools.elementtypesconfigurations.stereotypeapplicationmatcherconfiguration.StereotypeApplicationMatcherConfiguration#getProfileUri()
	 * @see #getStereotypeApplicationMatcherConfiguration()
	 * @generated
	 */
	EAttribute getStereotypeApplicationMatcherConfiguration_ProfileUri();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	StereotypeApplicationMatcherConfigurationFactory getStereotypeApplicationMatcherConfigurationFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.tools.elementtypesconfigurations.stereotypeapplicationmatcherconfiguration.impl.StereotypeApplicationMatcherConfigurationImpl <em>Stereotype Application Matcher Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.uml.tools.elementtypesconfigurations.stereotypeapplicationmatcherconfiguration.impl.StereotypeApplicationMatcherConfigurationImpl
		 * @see org.eclipse.papyrus.uml.tools.elementtypesconfigurations.stereotypeapplicationmatcherconfiguration.impl.StereotypeApplicationMatcherConfigurationPackageImpl#getStereotypeApplicationMatcherConfiguration()
		 * @generated
		 */
		EClass STEREOTYPE_APPLICATION_MATCHER_CONFIGURATION = eINSTANCE.getStereotypeApplicationMatcherConfiguration();

		/**
		 * The meta object literal for the '<em><b>Stereotypes Qualified Names</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STEREOTYPE_APPLICATION_MATCHER_CONFIGURATION__STEREOTYPES_QUALIFIED_NAMES = eINSTANCE.getStereotypeApplicationMatcherConfiguration_StereotypesQualifiedNames();

		/**
		 * The meta object literal for the '<em><b>Profile Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STEREOTYPE_APPLICATION_MATCHER_CONFIGURATION__PROFILE_URI = eINSTANCE.getStereotypeApplicationMatcherConfiguration_ProfileUri();

	}

} //StereotypeApplicationMatcherConfigurationPackage
