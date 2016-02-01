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
package org.eclipse.papyrus.infra.elementtypesconfigurations.emf.ui.runtimevalueseditionadviceconfiguration;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.papyrus.infra.elementtypesconfigurations.ElementtypesconfigurationsPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.emf.ui.runtimevalueseditionadviceconfiguration.RuntimevalueseditionadviceconfigurationFactory
 * @model kind="package"
 * @generated
 */
public interface RuntimevalueseditionadviceconfigurationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "runtimevalueseditionadviceconfiguration";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/infra/elementtypesconfigurations/emf/runtimevalueseditionadviceconfiguration/1.1";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "runtimevalueseditionadviceconfiguration";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RuntimevalueseditionadviceconfigurationPackage eINSTANCE = org.eclipse.papyrus.infra.elementtypesconfigurations.emf.ui.runtimevalueseditionadviceconfiguration.impl.RuntimevalueseditionadviceconfigurationPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.emf.ui.runtimevalueseditionadviceconfiguration.impl.RuntimeValuesEditionAdviceConfigurationImpl <em>Runtime Values Edition Advice Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.emf.ui.runtimevalueseditionadviceconfiguration.impl.RuntimeValuesEditionAdviceConfigurationImpl
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.emf.ui.runtimevalueseditionadviceconfiguration.impl.RuntimevalueseditionadviceconfigurationPackageImpl#getRuntimeValuesEditionAdviceConfiguration()
	 * @generated
	 */
	int RUNTIME_VALUES_EDITION_ADVICE_CONFIGURATION = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNTIME_VALUES_EDITION_ADVICE_CONFIGURATION__DESCRIPTION = ElementtypesconfigurationsPackage.ABSTRACT_ADVICE_BINDING_CONFIGURATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Before</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNTIME_VALUES_EDITION_ADVICE_CONFIGURATION__BEFORE = ElementtypesconfigurationsPackage.ABSTRACT_ADVICE_BINDING_CONFIGURATION__BEFORE;

	/**
	 * The feature id for the '<em><b>After</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNTIME_VALUES_EDITION_ADVICE_CONFIGURATION__AFTER = ElementtypesconfigurationsPackage.ABSTRACT_ADVICE_BINDING_CONFIGURATION__AFTER;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNTIME_VALUES_EDITION_ADVICE_CONFIGURATION__IDENTIFIER = ElementtypesconfigurationsPackage.ABSTRACT_ADVICE_BINDING_CONFIGURATION__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNTIME_VALUES_EDITION_ADVICE_CONFIGURATION__TARGET = ElementtypesconfigurationsPackage.ABSTRACT_ADVICE_BINDING_CONFIGURATION__TARGET;

	/**
	 * The feature id for the '<em><b>Container Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNTIME_VALUES_EDITION_ADVICE_CONFIGURATION__CONTAINER_CONFIGURATION = ElementtypesconfigurationsPackage.ABSTRACT_ADVICE_BINDING_CONFIGURATION__CONTAINER_CONFIGURATION;

	/**
	 * The feature id for the '<em><b>Matcher Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNTIME_VALUES_EDITION_ADVICE_CONFIGURATION__MATCHER_CONFIGURATION = ElementtypesconfigurationsPackage.ABSTRACT_ADVICE_BINDING_CONFIGURATION__MATCHER_CONFIGURATION;

	/**
	 * The feature id for the '<em><b>Inheritance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNTIME_VALUES_EDITION_ADVICE_CONFIGURATION__INHERITANCE = ElementtypesconfigurationsPackage.ABSTRACT_ADVICE_BINDING_CONFIGURATION__INHERITANCE;

	/**
	 * The feature id for the '<em><b>Views To Display</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNTIME_VALUES_EDITION_ADVICE_CONFIGURATION__VIEWS_TO_DISPLAY = ElementtypesconfigurationsPackage.ABSTRACT_ADVICE_BINDING_CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Runtime Values Edition Advice Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNTIME_VALUES_EDITION_ADVICE_CONFIGURATION_FEATURE_COUNT = ElementtypesconfigurationsPackage.ABSTRACT_ADVICE_BINDING_CONFIGURATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.emf.ui.runtimevalueseditionadviceconfiguration.impl.ViewToDisplayImpl <em>View To Display</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.emf.ui.runtimevalueseditionadviceconfiguration.impl.ViewToDisplayImpl
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.emf.ui.runtimevalueseditionadviceconfiguration.impl.RuntimevalueseditionadviceconfigurationPackageImpl#getViewToDisplay()
	 * @generated
	 */
	int VIEW_TO_DISPLAY = 1;

	/**
	 * The feature id for the '<em><b>View</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_TO_DISPLAY__VIEW = 0;

	/**
	 * The number of structural features of the '<em>View To Display</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_TO_DISPLAY_FEATURE_COUNT = 1;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.emf.ui.runtimevalueseditionadviceconfiguration.RuntimeValuesEditionAdviceConfiguration <em>Runtime Values Edition Advice Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Runtime Values Edition Advice Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.emf.ui.runtimevalueseditionadviceconfiguration.RuntimeValuesEditionAdviceConfiguration
	 * @generated
	 */
	EClass getRuntimeValuesEditionAdviceConfiguration();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.emf.ui.runtimevalueseditionadviceconfiguration.RuntimeValuesEditionAdviceConfiguration#getViewsToDisplay <em>Views To Display</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Views To Display</em>'.
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.emf.ui.runtimevalueseditionadviceconfiguration.RuntimeValuesEditionAdviceConfiguration#getViewsToDisplay()
	 * @see #getRuntimeValuesEditionAdviceConfiguration()
	 * @generated
	 */
	EReference getRuntimeValuesEditionAdviceConfiguration_ViewsToDisplay();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.emf.ui.runtimevalueseditionadviceconfiguration.ViewToDisplay <em>View To Display</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>View To Display</em>'.
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.emf.ui.runtimevalueseditionadviceconfiguration.ViewToDisplay
	 * @generated
	 */
	EClass getViewToDisplay();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.emf.ui.runtimevalueseditionadviceconfiguration.ViewToDisplay#getView <em>View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>View</em>'.
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.emf.ui.runtimevalueseditionadviceconfiguration.ViewToDisplay#getView()
	 * @see #getViewToDisplay()
	 * @generated
	 */
	EReference getViewToDisplay_View();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	RuntimevalueseditionadviceconfigurationFactory getRuntimevalueseditionadviceconfigurationFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.emf.ui.runtimevalueseditionadviceconfiguration.impl.RuntimeValuesEditionAdviceConfigurationImpl <em>Runtime Values Edition Advice Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.emf.ui.runtimevalueseditionadviceconfiguration.impl.RuntimeValuesEditionAdviceConfigurationImpl
		 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.emf.ui.runtimevalueseditionadviceconfiguration.impl.RuntimevalueseditionadviceconfigurationPackageImpl#getRuntimeValuesEditionAdviceConfiguration()
		 * @generated
		 */
		EClass RUNTIME_VALUES_EDITION_ADVICE_CONFIGURATION = eINSTANCE.getRuntimeValuesEditionAdviceConfiguration();

		/**
		 * The meta object literal for the '<em><b>Views To Display</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RUNTIME_VALUES_EDITION_ADVICE_CONFIGURATION__VIEWS_TO_DISPLAY = eINSTANCE.getRuntimeValuesEditionAdviceConfiguration_ViewsToDisplay();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.emf.ui.runtimevalueseditionadviceconfiguration.impl.ViewToDisplayImpl <em>View To Display</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.emf.ui.runtimevalueseditionadviceconfiguration.impl.ViewToDisplayImpl
		 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.emf.ui.runtimevalueseditionadviceconfiguration.impl.RuntimevalueseditionadviceconfigurationPackageImpl#getViewToDisplay()
		 * @generated
		 */
		EClass VIEW_TO_DISPLAY = eINSTANCE.getViewToDisplay();

		/**
		 * The meta object literal for the '<em><b>View</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIEW_TO_DISPLAY__VIEW = eINSTANCE.getViewToDisplay_View();

	}

} //RuntimevalueseditionadviceconfigurationPackage
