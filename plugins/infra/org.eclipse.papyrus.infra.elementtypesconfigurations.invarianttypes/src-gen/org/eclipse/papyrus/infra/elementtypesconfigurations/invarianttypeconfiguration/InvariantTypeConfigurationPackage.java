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
package org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration;

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
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.InvariantTypeConfigurationFactory
 * @model kind="package"
 * @generated
 */
public interface InvariantTypeConfigurationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "invarianttypeconfiguration";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/infra/elementtypesconfigurations/invarianttype/1.1";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "invarianttypeconfiguration";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	InvariantTypeConfigurationPackage eINSTANCE = org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.impl.InvariantTypeConfigurationPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.impl.InvariantTypeConfigurationImpl <em>Invariant Type Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.impl.InvariantTypeConfigurationImpl
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.impl.InvariantTypeConfigurationPackageImpl#getInvariantTypeConfiguration()
	 * @generated
	 */
	int INVARIANT_TYPE_CONFIGURATION = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVARIANT_TYPE_CONFIGURATION__DESCRIPTION = ElementtypesconfigurationsPackage.SPECIALIZATION_TYPE_CONFIGURATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVARIANT_TYPE_CONFIGURATION__IDENTIFIER = ElementtypesconfigurationsPackage.SPECIALIZATION_TYPE_CONFIGURATION__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVARIANT_TYPE_CONFIGURATION__NAME = ElementtypesconfigurationsPackage.SPECIALIZATION_TYPE_CONFIGURATION__NAME;

	/**
	 * The feature id for the '<em><b>Hint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVARIANT_TYPE_CONFIGURATION__HINT = ElementtypesconfigurationsPackage.SPECIALIZATION_TYPE_CONFIGURATION__HINT;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVARIANT_TYPE_CONFIGURATION__KIND = ElementtypesconfigurationsPackage.SPECIALIZATION_TYPE_CONFIGURATION__KIND;

	/**
	 * The feature id for the '<em><b>Icon Entry</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVARIANT_TYPE_CONFIGURATION__ICON_ENTRY = ElementtypesconfigurationsPackage.SPECIALIZATION_TYPE_CONFIGURATION__ICON_ENTRY;

	/**
	 * The feature id for the '<em><b>Specialized Types ID</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVARIANT_TYPE_CONFIGURATION__SPECIALIZED_TYPES_ID = ElementtypesconfigurationsPackage.SPECIALIZATION_TYPE_CONFIGURATION__SPECIALIZED_TYPES_ID;

	/**
	 * The feature id for the '<em><b>Edit Helper Advice Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVARIANT_TYPE_CONFIGURATION__EDIT_HELPER_ADVICE_CONFIGURATION = ElementtypesconfigurationsPackage.SPECIALIZATION_TYPE_CONFIGURATION__EDIT_HELPER_ADVICE_CONFIGURATION;

	/**
	 * The feature id for the '<em><b>Container Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVARIANT_TYPE_CONFIGURATION__CONTAINER_CONFIGURATION = ElementtypesconfigurationsPackage.SPECIALIZATION_TYPE_CONFIGURATION__CONTAINER_CONFIGURATION;

	/**
	 * The feature id for the '<em><b>Matcher Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVARIANT_TYPE_CONFIGURATION__MATCHER_CONFIGURATION = ElementtypesconfigurationsPackage.SPECIALIZATION_TYPE_CONFIGURATION__MATCHER_CONFIGURATION;

	/**
	 * The feature id for the '<em><b>Invariant Rule Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVARIANT_TYPE_CONFIGURATION__INVARIANT_RULE_CONFIGURATION = ElementtypesconfigurationsPackage.SPECIALIZATION_TYPE_CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Invariant Type Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVARIANT_TYPE_CONFIGURATION_FEATURE_COUNT = ElementtypesconfigurationsPackage.SPECIALIZATION_TYPE_CONFIGURATION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Invariant Type Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVARIANT_TYPE_CONFIGURATION_OPERATION_COUNT = ElementtypesconfigurationsPackage.SPECIALIZATION_TYPE_CONFIGURATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.impl.InvariantRuleConfigurationImpl <em>Invariant Rule Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.impl.InvariantRuleConfigurationImpl
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.impl.InvariantTypeConfigurationPackageImpl#getInvariantRuleConfiguration()
	 * @generated
	 */
	int INVARIANT_RULE_CONFIGURATION = 1;

	/**
	 * The number of structural features of the '<em>Invariant Rule Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVARIANT_RULE_CONFIGURATION_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Invariant Rule Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVARIANT_RULE_CONFIGURATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.impl.CompositeInvariantRuleConfigurationImpl <em>Composite Invariant Rule Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.impl.CompositeInvariantRuleConfigurationImpl
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.impl.InvariantTypeConfigurationPackageImpl#getCompositeInvariantRuleConfiguration()
	 * @generated
	 */
	int COMPOSITE_INVARIANT_RULE_CONFIGURATION = 2;

	/**
	 * The feature id for the '<em><b>Composed Rules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_INVARIANT_RULE_CONFIGURATION__COMPOSED_RULES = INVARIANT_RULE_CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Composite Invariant Rule Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_INVARIANT_RULE_CONFIGURATION_FEATURE_COUNT = INVARIANT_RULE_CONFIGURATION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Composite Invariant Rule Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_INVARIANT_RULE_CONFIGURATION_OPERATION_COUNT = INVARIANT_RULE_CONFIGURATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.impl.NotInvariantRuleConfigurationImpl <em>Not Invariant Rule Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.impl.NotInvariantRuleConfigurationImpl
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.impl.InvariantTypeConfigurationPackageImpl#getNotInvariantRuleConfiguration()
	 * @generated
	 */
	int NOT_INVARIANT_RULE_CONFIGURATION = 3;

	/**
	 * The feature id for the '<em><b>Composed Rule</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_INVARIANT_RULE_CONFIGURATION__COMPOSED_RULE = INVARIANT_RULE_CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Not Invariant Rule Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_INVARIANT_RULE_CONFIGURATION_FEATURE_COUNT = INVARIANT_RULE_CONFIGURATION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Not Invariant Rule Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_INVARIANT_RULE_CONFIGURATION_OPERATION_COUNT = INVARIANT_RULE_CONFIGURATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.impl.AndInvariantRuleConfigurationImpl <em>And Invariant Rule Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.impl.AndInvariantRuleConfigurationImpl
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.impl.InvariantTypeConfigurationPackageImpl#getAndInvariantRuleConfiguration()
	 * @generated
	 */
	int AND_INVARIANT_RULE_CONFIGURATION = 4;

	/**
	 * The feature id for the '<em><b>Composed Rules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_INVARIANT_RULE_CONFIGURATION__COMPOSED_RULES = COMPOSITE_INVARIANT_RULE_CONFIGURATION__COMPOSED_RULES;

	/**
	 * The number of structural features of the '<em>And Invariant Rule Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_INVARIANT_RULE_CONFIGURATION_FEATURE_COUNT = COMPOSITE_INVARIANT_RULE_CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>And Invariant Rule Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_INVARIANT_RULE_CONFIGURATION_OPERATION_COUNT = COMPOSITE_INVARIANT_RULE_CONFIGURATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.impl.OrInvariantRuleConfigurationImpl <em>Or Invariant Rule Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.impl.OrInvariantRuleConfigurationImpl
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.impl.InvariantTypeConfigurationPackageImpl#getOrInvariantRuleConfiguration()
	 * @generated
	 */
	int OR_INVARIANT_RULE_CONFIGURATION = 5;

	/**
	 * The feature id for the '<em><b>Composed Rules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_INVARIANT_RULE_CONFIGURATION__COMPOSED_RULES = COMPOSITE_INVARIANT_RULE_CONFIGURATION__COMPOSED_RULES;

	/**
	 * The number of structural features of the '<em>Or Invariant Rule Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_INVARIANT_RULE_CONFIGURATION_FEATURE_COUNT = COMPOSITE_INVARIANT_RULE_CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Or Invariant Rule Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_INVARIANT_RULE_CONFIGURATION_OPERATION_COUNT = COMPOSITE_INVARIANT_RULE_CONFIGURATION_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.InvariantTypeConfiguration <em>Invariant Type Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Invariant Type Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.InvariantTypeConfiguration
	 * @generated
	 */
	EClass getInvariantTypeConfiguration();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.InvariantTypeConfiguration#getInvariantRuleConfiguration <em>Invariant Rule Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Invariant Rule Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.InvariantTypeConfiguration#getInvariantRuleConfiguration()
	 * @see #getInvariantTypeConfiguration()
	 * @generated
	 */
	EReference getInvariantTypeConfiguration_InvariantRuleConfiguration();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.InvariantRuleConfiguration <em>Invariant Rule Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Invariant Rule Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.InvariantRuleConfiguration
	 * @generated
	 */
	EClass getInvariantRuleConfiguration();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.CompositeInvariantRuleConfiguration <em>Composite Invariant Rule Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite Invariant Rule Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.CompositeInvariantRuleConfiguration
	 * @generated
	 */
	EClass getCompositeInvariantRuleConfiguration();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.CompositeInvariantRuleConfiguration#getComposedRules <em>Composed Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Composed Rules</em>'.
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.CompositeInvariantRuleConfiguration#getComposedRules()
	 * @see #getCompositeInvariantRuleConfiguration()
	 * @generated
	 */
	EReference getCompositeInvariantRuleConfiguration_ComposedRules();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.NotInvariantRuleConfiguration <em>Not Invariant Rule Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Not Invariant Rule Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.NotInvariantRuleConfiguration
	 * @generated
	 */
	EClass getNotInvariantRuleConfiguration();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.NotInvariantRuleConfiguration#getComposedRule <em>Composed Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Composed Rule</em>'.
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.NotInvariantRuleConfiguration#getComposedRule()
	 * @see #getNotInvariantRuleConfiguration()
	 * @generated
	 */
	EReference getNotInvariantRuleConfiguration_ComposedRule();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.AndInvariantRuleConfiguration <em>And Invariant Rule Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>And Invariant Rule Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.AndInvariantRuleConfiguration
	 * @generated
	 */
	EClass getAndInvariantRuleConfiguration();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.OrInvariantRuleConfiguration <em>Or Invariant Rule Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Or Invariant Rule Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.OrInvariantRuleConfiguration
	 * @generated
	 */
	EClass getOrInvariantRuleConfiguration();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	InvariantTypeConfigurationFactory getInvariantTypeConfigurationFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.impl.InvariantTypeConfigurationImpl <em>Invariant Type Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.impl.InvariantTypeConfigurationImpl
		 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.impl.InvariantTypeConfigurationPackageImpl#getInvariantTypeConfiguration()
		 * @generated
		 */
		EClass INVARIANT_TYPE_CONFIGURATION = eINSTANCE.getInvariantTypeConfiguration();

		/**
		 * The meta object literal for the '<em><b>Invariant Rule Configuration</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INVARIANT_TYPE_CONFIGURATION__INVARIANT_RULE_CONFIGURATION = eINSTANCE.getInvariantTypeConfiguration_InvariantRuleConfiguration();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.impl.InvariantRuleConfigurationImpl <em>Invariant Rule Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.impl.InvariantRuleConfigurationImpl
		 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.impl.InvariantTypeConfigurationPackageImpl#getInvariantRuleConfiguration()
		 * @generated
		 */
		EClass INVARIANT_RULE_CONFIGURATION = eINSTANCE.getInvariantRuleConfiguration();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.impl.CompositeInvariantRuleConfigurationImpl <em>Composite Invariant Rule Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.impl.CompositeInvariantRuleConfigurationImpl
		 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.impl.InvariantTypeConfigurationPackageImpl#getCompositeInvariantRuleConfiguration()
		 * @generated
		 */
		EClass COMPOSITE_INVARIANT_RULE_CONFIGURATION = eINSTANCE.getCompositeInvariantRuleConfiguration();

		/**
		 * The meta object literal for the '<em><b>Composed Rules</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_INVARIANT_RULE_CONFIGURATION__COMPOSED_RULES = eINSTANCE.getCompositeInvariantRuleConfiguration_ComposedRules();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.impl.NotInvariantRuleConfigurationImpl <em>Not Invariant Rule Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.impl.NotInvariantRuleConfigurationImpl
		 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.impl.InvariantTypeConfigurationPackageImpl#getNotInvariantRuleConfiguration()
		 * @generated
		 */
		EClass NOT_INVARIANT_RULE_CONFIGURATION = eINSTANCE.getNotInvariantRuleConfiguration();

		/**
		 * The meta object literal for the '<em><b>Composed Rule</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NOT_INVARIANT_RULE_CONFIGURATION__COMPOSED_RULE = eINSTANCE.getNotInvariantRuleConfiguration_ComposedRule();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.impl.AndInvariantRuleConfigurationImpl <em>And Invariant Rule Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.impl.AndInvariantRuleConfigurationImpl
		 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.impl.InvariantTypeConfigurationPackageImpl#getAndInvariantRuleConfiguration()
		 * @generated
		 */
		EClass AND_INVARIANT_RULE_CONFIGURATION = eINSTANCE.getAndInvariantRuleConfiguration();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.impl.OrInvariantRuleConfigurationImpl <em>Or Invariant Rule Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.impl.OrInvariantRuleConfigurationImpl
		 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.impl.InvariantTypeConfigurationPackageImpl#getOrInvariantRuleConfiguration()
		 * @generated
		 */
		EClass OR_INVARIANT_RULE_CONFIGURATION = eINSTANCE.getOrInvariantRuleConfiguration();

	}

} //InvariantTypeConfigurationPackage
