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
package org.eclipse.papyrus.infra.core.architecture;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
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
 * <!-- begin-model-doc -->
 * An architecture context is a method for customizing Papyrus for a given domain. It defines a regime for editing a Papyrus model semantically and notationally. The semantic editing is defined by a set of element type set configurations (from some domain), while the notational side is defined by a set of viewpoints consisting of a set of representation kinds (e.g., diagram kinds and table kinds) and other notational configurations....
 * <!-- end-model-doc -->
 * @see org.eclipse.papyrus.infra.core.architecture.ArchitectureFactory
 * @model kind="package"
 * @generated
 */
public interface ArchitecturePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "architecture";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/infra/core/architecture";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "architecture";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ArchitecturePackage eINSTANCE = org.eclipse.papyrus.infra.core.architecture.impl.ArchitecturePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.core.architecture.impl.ADElementImpl <em>AD Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.core.architecture.impl.ADElementImpl
	 * @see org.eclipse.papyrus.infra.core.architecture.impl.ArchitecturePackageImpl#getADElement()
	 * @generated
	 */
	int AD_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AD_ELEMENT__ID = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AD_ELEMENT__NAME = 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AD_ELEMENT__DESCRIPTION = 2;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AD_ELEMENT__QUALIFIED_NAME = 3;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AD_ELEMENT__ICON = 4;

	/**
	 * The number of structural features of the '<em>AD Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AD_ELEMENT_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>AD Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AD_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.core.architecture.impl.ArchitectureDomainImpl <em>Domain</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.core.architecture.impl.ArchitectureDomainImpl
	 * @see org.eclipse.papyrus.infra.core.architecture.impl.ArchitecturePackageImpl#getArchitectureDomain()
	 * @generated
	 */
	int ARCHITECTURE_DOMAIN = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_DOMAIN__ID = AD_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_DOMAIN__NAME = AD_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_DOMAIN__DESCRIPTION = AD_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_DOMAIN__QUALIFIED_NAME = AD_ELEMENT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_DOMAIN__ICON = AD_ELEMENT__ICON;

	/**
	 * The feature id for the '<em><b>Stakeholders</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_DOMAIN__STAKEHOLDERS = AD_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Concerns</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_DOMAIN__CONCERNS = AD_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Contexts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_DOMAIN__CONTEXTS = AD_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Domain</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_DOMAIN_FEATURE_COUNT = AD_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Domain</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_DOMAIN_OPERATION_COUNT = AD_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.core.architecture.impl.ArchitectureContextImpl <em>Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.core.architecture.impl.ArchitectureContextImpl
	 * @see org.eclipse.papyrus.infra.core.architecture.impl.ArchitecturePackageImpl#getArchitectureContext()
	 * @generated
	 */
	int ARCHITECTURE_CONTEXT = 7;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_CONTEXT__ID = AD_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_CONTEXT__NAME = AD_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_CONTEXT__DESCRIPTION = AD_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_CONTEXT__QUALIFIED_NAME = AD_ELEMENT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_CONTEXT__ICON = AD_ELEMENT__ICON;

	/**
	 * The feature id for the '<em><b>Viewpoints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_CONTEXT__VIEWPOINTS = AD_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Default Viewpoints</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_CONTEXT__DEFAULT_VIEWPOINTS = AD_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Element Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_CONTEXT__ELEMENT_TYPES = AD_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Domain</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_CONTEXT__DOMAIN = AD_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Extension Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_CONTEXT__EXTENSION_PREFIX = AD_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Creation Command Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_CONTEXT__CREATION_COMMAND_CLASS = AD_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Conversion Command Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_CONTEXT__CONVERSION_COMMAND_CLASS = AD_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_CONTEXT_FEATURE_COUNT = AD_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The operation id for the '<em>Ceation Command Class Exists</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 * @since 2.0
	 */
	int ARCHITECTURE_CONTEXT___CEATION_COMMAND_CLASS_EXISTS__DIAGNOSTICCHAIN_MAP = AD_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Conversion Command Class Exists</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 * @since 2.0
	 */
	int ARCHITECTURE_CONTEXT___CONVERSION_COMMAND_CLASS_EXISTS__DIAGNOSTICCHAIN_MAP = AD_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_CONTEXT_OPERATION_COUNT = AD_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.core.architecture.impl.ArchitectureDescriptionLanguageImpl <em>Description Language</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.core.architecture.impl.ArchitectureDescriptionLanguageImpl
	 * @see org.eclipse.papyrus.infra.core.architecture.impl.ArchitecturePackageImpl#getArchitectureDescriptionLanguage()
	 * @generated
	 */
	int ARCHITECTURE_DESCRIPTION_LANGUAGE = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_DESCRIPTION_LANGUAGE__ID = ARCHITECTURE_CONTEXT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_DESCRIPTION_LANGUAGE__NAME = ARCHITECTURE_CONTEXT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_DESCRIPTION_LANGUAGE__DESCRIPTION = ARCHITECTURE_CONTEXT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_DESCRIPTION_LANGUAGE__QUALIFIED_NAME = ARCHITECTURE_CONTEXT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_DESCRIPTION_LANGUAGE__ICON = ARCHITECTURE_CONTEXT__ICON;

	/**
	 * The feature id for the '<em><b>Viewpoints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_DESCRIPTION_LANGUAGE__VIEWPOINTS = ARCHITECTURE_CONTEXT__VIEWPOINTS;

	/**
	 * The feature id for the '<em><b>Default Viewpoints</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_DESCRIPTION_LANGUAGE__DEFAULT_VIEWPOINTS = ARCHITECTURE_CONTEXT__DEFAULT_VIEWPOINTS;

	/**
	 * The feature id for the '<em><b>Element Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_DESCRIPTION_LANGUAGE__ELEMENT_TYPES = ARCHITECTURE_CONTEXT__ELEMENT_TYPES;

	/**
	 * The feature id for the '<em><b>Domain</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_DESCRIPTION_LANGUAGE__DOMAIN = ARCHITECTURE_CONTEXT__DOMAIN;

	/**
	 * The feature id for the '<em><b>Extension Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_DESCRIPTION_LANGUAGE__EXTENSION_PREFIX = ARCHITECTURE_CONTEXT__EXTENSION_PREFIX;

	/**
	 * The feature id for the '<em><b>Creation Command Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_DESCRIPTION_LANGUAGE__CREATION_COMMAND_CLASS = ARCHITECTURE_CONTEXT__CREATION_COMMAND_CLASS;

	/**
	 * The feature id for the '<em><b>Conversion Command Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_DESCRIPTION_LANGUAGE__CONVERSION_COMMAND_CLASS = ARCHITECTURE_CONTEXT__CONVERSION_COMMAND_CLASS;

	/**
	 * The feature id for the '<em><b>Representation Kinds</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_DESCRIPTION_LANGUAGE__REPRESENTATION_KINDS = ARCHITECTURE_CONTEXT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Metamodel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_DESCRIPTION_LANGUAGE__METAMODEL = ARCHITECTURE_CONTEXT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Profiles</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_DESCRIPTION_LANGUAGE__PROFILES = ARCHITECTURE_CONTEXT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Description Language</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_DESCRIPTION_LANGUAGE_FEATURE_COUNT = ARCHITECTURE_CONTEXT_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Ceation Command Class Exists</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 * @since 2.0
	 */
	int ARCHITECTURE_DESCRIPTION_LANGUAGE___CEATION_COMMAND_CLASS_EXISTS__DIAGNOSTICCHAIN_MAP = ARCHITECTURE_CONTEXT___CEATION_COMMAND_CLASS_EXISTS__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Conversion Command Class Exists</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 * @since 2.0
	 */
	int ARCHITECTURE_DESCRIPTION_LANGUAGE___CONVERSION_COMMAND_CLASS_EXISTS__DIAGNOSTICCHAIN_MAP = ARCHITECTURE_CONTEXT___CONVERSION_COMMAND_CLASS_EXISTS__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>Description Language</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_DESCRIPTION_LANGUAGE_OPERATION_COUNT = ARCHITECTURE_CONTEXT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.core.architecture.impl.StakeholderImpl <em>Stakeholder</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.core.architecture.impl.StakeholderImpl
	 * @see org.eclipse.papyrus.infra.core.architecture.impl.ArchitecturePackageImpl#getStakeholder()
	 * @generated
	 */
	int STAKEHOLDER = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STAKEHOLDER__ID = AD_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STAKEHOLDER__NAME = AD_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STAKEHOLDER__DESCRIPTION = AD_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STAKEHOLDER__QUALIFIED_NAME = AD_ELEMENT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STAKEHOLDER__ICON = AD_ELEMENT__ICON;

	/**
	 * The feature id for the '<em><b>Concerns</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STAKEHOLDER__CONCERNS = AD_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Domain</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STAKEHOLDER__DOMAIN = AD_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Stakeholder</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STAKEHOLDER_FEATURE_COUNT = AD_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Stakeholder</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STAKEHOLDER_OPERATION_COUNT = AD_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.core.architecture.impl.ConcernImpl <em>Concern</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.core.architecture.impl.ConcernImpl
	 * @see org.eclipse.papyrus.infra.core.architecture.impl.ArchitecturePackageImpl#getConcern()
	 * @generated
	 */
	int CONCERN = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCERN__ID = AD_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCERN__NAME = AD_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCERN__DESCRIPTION = AD_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCERN__QUALIFIED_NAME = AD_ELEMENT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCERN__ICON = AD_ELEMENT__ICON;

	/**
	 * The feature id for the '<em><b>Domain</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCERN__DOMAIN = AD_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Concern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCERN_FEATURE_COUNT = AD_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Concern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCERN_OPERATION_COUNT = AD_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.core.architecture.impl.ArchitectureViewpointImpl <em>Viewpoint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.core.architecture.impl.ArchitectureViewpointImpl
	 * @see org.eclipse.papyrus.infra.core.architecture.impl.ArchitecturePackageImpl#getArchitectureViewpoint()
	 * @generated
	 */
	int ARCHITECTURE_VIEWPOINT = 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_VIEWPOINT__ID = AD_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_VIEWPOINT__NAME = AD_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_VIEWPOINT__DESCRIPTION = AD_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_VIEWPOINT__QUALIFIED_NAME = AD_ELEMENT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_VIEWPOINT__ICON = AD_ELEMENT__ICON;

	/**
	 * The feature id for the '<em><b>Concerns</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_VIEWPOINT__CONCERNS = AD_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Representation Kinds</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_VIEWPOINT__REPRESENTATION_KINDS = AD_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Context</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_VIEWPOINT__CONTEXT = AD_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Viewpoint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_VIEWPOINT_FEATURE_COUNT = AD_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Viewpoint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_VIEWPOINT_OPERATION_COUNT = AD_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.core.architecture.impl.RepresentationKindImpl <em>Representation Kind</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.core.architecture.impl.RepresentationKindImpl
	 * @see org.eclipse.papyrus.infra.core.architecture.impl.ArchitecturePackageImpl#getRepresentationKind()
	 * @generated
	 */
	int REPRESENTATION_KIND = 6;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPRESENTATION_KIND__ID = AD_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPRESENTATION_KIND__NAME = AD_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPRESENTATION_KIND__DESCRIPTION = AD_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPRESENTATION_KIND__QUALIFIED_NAME = AD_ELEMENT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPRESENTATION_KIND__ICON = AD_ELEMENT__ICON;

	/**
	 * The feature id for the '<em><b>Language</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPRESENTATION_KIND__LANGUAGE = AD_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Concerns</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPRESENTATION_KIND__CONCERNS = AD_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Representation Kind</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPRESENTATION_KIND_FEATURE_COUNT = AD_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Representation Kind</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPRESENTATION_KIND_OPERATION_COUNT = AD_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.core.architecture.impl.ArchitectureFrameworkImpl <em>Framework</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.core.architecture.impl.ArchitectureFrameworkImpl
	 * @see org.eclipse.papyrus.infra.core.architecture.impl.ArchitecturePackageImpl#getArchitectureFramework()
	 * @generated
	 */
	int ARCHITECTURE_FRAMEWORK = 8;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_FRAMEWORK__ID = ARCHITECTURE_CONTEXT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_FRAMEWORK__NAME = ARCHITECTURE_CONTEXT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_FRAMEWORK__DESCRIPTION = ARCHITECTURE_CONTEXT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_FRAMEWORK__QUALIFIED_NAME = ARCHITECTURE_CONTEXT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_FRAMEWORK__ICON = ARCHITECTURE_CONTEXT__ICON;

	/**
	 * The feature id for the '<em><b>Viewpoints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_FRAMEWORK__VIEWPOINTS = ARCHITECTURE_CONTEXT__VIEWPOINTS;

	/**
	 * The feature id for the '<em><b>Default Viewpoints</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_FRAMEWORK__DEFAULT_VIEWPOINTS = ARCHITECTURE_CONTEXT__DEFAULT_VIEWPOINTS;

	/**
	 * The feature id for the '<em><b>Element Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_FRAMEWORK__ELEMENT_TYPES = ARCHITECTURE_CONTEXT__ELEMENT_TYPES;

	/**
	 * The feature id for the '<em><b>Domain</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_FRAMEWORK__DOMAIN = ARCHITECTURE_CONTEXT__DOMAIN;

	/**
	 * The feature id for the '<em><b>Extension Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_FRAMEWORK__EXTENSION_PREFIX = ARCHITECTURE_CONTEXT__EXTENSION_PREFIX;

	/**
	 * The feature id for the '<em><b>Creation Command Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_FRAMEWORK__CREATION_COMMAND_CLASS = ARCHITECTURE_CONTEXT__CREATION_COMMAND_CLASS;

	/**
	 * The feature id for the '<em><b>Conversion Command Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_FRAMEWORK__CONVERSION_COMMAND_CLASS = ARCHITECTURE_CONTEXT__CONVERSION_COMMAND_CLASS;

	/**
	 * The number of structural features of the '<em>Framework</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_FRAMEWORK_FEATURE_COUNT = ARCHITECTURE_CONTEXT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Ceation Command Class Exists</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 * @since 2.0
	 */
	int ARCHITECTURE_FRAMEWORK___CEATION_COMMAND_CLASS_EXISTS__DIAGNOSTICCHAIN_MAP = ARCHITECTURE_CONTEXT___CEATION_COMMAND_CLASS_EXISTS__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Conversion Command Class Exists</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 * @since 2.0
	 */
	int ARCHITECTURE_FRAMEWORK___CONVERSION_COMMAND_CLASS_EXISTS__DIAGNOSTICCHAIN_MAP = ARCHITECTURE_CONTEXT___CONVERSION_COMMAND_CLASS_EXISTS__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>Framework</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_FRAMEWORK_OPERATION_COUNT = ARCHITECTURE_CONTEXT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.core.architecture.impl.ArchitectureDescriptionImpl <em>Description</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.core.architecture.impl.ArchitectureDescriptionImpl
	 * @see org.eclipse.papyrus.infra.core.architecture.impl.ArchitecturePackageImpl#getArchitectureDescription()
	 * @generated
	 */
	int ARCHITECTURE_DESCRIPTION = 9;

	/**
	 * The feature id for the '<em><b>Context Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_DESCRIPTION__CONTEXT_ID = 0;

	/**
	 * The number of structural features of the '<em>Description</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_DESCRIPTION_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Description</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_DESCRIPTION_OPERATION_COUNT = 0;


	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.core.architecture.impl.ArchitectureDescriptionPreferencesImpl <em>Description Preferences</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.core.architecture.impl.ArchitectureDescriptionPreferencesImpl
	 * @see org.eclipse.papyrus.infra.core.architecture.impl.ArchitecturePackageImpl#getArchitectureDescriptionPreferences()
	 * @generated
	 */
	int ARCHITECTURE_DESCRIPTION_PREFERENCES = 10;

	/**
	 * The feature id for the '<em><b>Viewpoint Ids</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_DESCRIPTION_PREFERENCES__VIEWPOINT_IDS = 0;

	/**
	 * The number of structural features of the '<em>Description Preferences</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_DESCRIPTION_PREFERENCES_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Description Preferences</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURE_DESCRIPTION_PREFERENCES_OPERATION_COUNT = 0;

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.core.architecture.ADElement <em>AD Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>AD Element</em>'.
	 * @see org.eclipse.papyrus.infra.core.architecture.ADElement
	 * @generated
	 */
	EClass getADElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.core.architecture.ADElement#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.eclipse.papyrus.infra.core.architecture.ADElement#getId()
	 * @see #getADElement()
	 * @generated
	 */
	EAttribute getADElement_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.core.architecture.ADElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.infra.core.architecture.ADElement#getName()
	 * @see #getADElement()
	 * @generated
	 */
	EAttribute getADElement_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.core.architecture.ADElement#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.eclipse.papyrus.infra.core.architecture.ADElement#getDescription()
	 * @see #getADElement()
	 * @generated
	 */
	EAttribute getADElement_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.core.architecture.ADElement#getQualifiedName <em>Qualified Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Qualified Name</em>'.
	 * @see org.eclipse.papyrus.infra.core.architecture.ADElement#getQualifiedName()
	 * @see #getADElement()
	 * @generated
	 */
	EAttribute getADElement_QualifiedName();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.core.architecture.ADElement#getIcon <em>Icon</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Icon</em>'.
	 * @see org.eclipse.papyrus.infra.core.architecture.ADElement#getIcon()
	 * @see #getADElement()
	 * @generated
	 */
	EAttribute getADElement_Icon();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.core.architecture.ArchitectureDomain <em>Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Domain</em>'.
	 * @see org.eclipse.papyrus.infra.core.architecture.ArchitectureDomain
	 * @generated
	 */
	EClass getArchitectureDomain();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.core.architecture.ArchitectureDomain#getStakeholders <em>Stakeholders</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Stakeholders</em>'.
	 * @see org.eclipse.papyrus.infra.core.architecture.ArchitectureDomain#getStakeholders()
	 * @see #getArchitectureDomain()
	 * @generated
	 */
	EReference getArchitectureDomain_Stakeholders();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.core.architecture.ArchitectureDomain#getConcerns <em>Concerns</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Concerns</em>'.
	 * @see org.eclipse.papyrus.infra.core.architecture.ArchitectureDomain#getConcerns()
	 * @see #getArchitectureDomain()
	 * @generated
	 */
	EReference getArchitectureDomain_Concerns();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.core.architecture.ArchitectureDomain#getContexts <em>Contexts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Contexts</em>'.
	 * @see org.eclipse.papyrus.infra.core.architecture.ArchitectureDomain#getContexts()
	 * @see #getArchitectureDomain()
	 * @generated
	 */
	EReference getArchitectureDomain_Contexts();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.core.architecture.ArchitectureDescriptionLanguage <em>Description Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Description Language</em>'.
	 * @see org.eclipse.papyrus.infra.core.architecture.ArchitectureDescriptionLanguage
	 * @generated
	 */
	EClass getArchitectureDescriptionLanguage();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.core.architecture.ArchitectureDescriptionLanguage#getRepresentationKinds <em>Representation Kinds</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Representation Kinds</em>'.
	 * @see org.eclipse.papyrus.infra.core.architecture.ArchitectureDescriptionLanguage#getRepresentationKinds()
	 * @see #getArchitectureDescriptionLanguage()
	 * @generated
	 */
	EReference getArchitectureDescriptionLanguage_RepresentationKinds();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.infra.core.architecture.ArchitectureDescriptionLanguage#getMetamodel <em>Metamodel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Metamodel</em>'.
	 * @see org.eclipse.papyrus.infra.core.architecture.ArchitectureDescriptionLanguage#getMetamodel()
	 * @see #getArchitectureDescriptionLanguage()
	 * @generated
	 */
	EReference getArchitectureDescriptionLanguage_Metamodel();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.infra.core.architecture.ArchitectureDescriptionLanguage#getProfiles <em>Profiles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Profiles</em>'.
	 * @see org.eclipse.papyrus.infra.core.architecture.ArchitectureDescriptionLanguage#getProfiles()
	 * @see #getArchitectureDescriptionLanguage()
	 * @generated
	 */
	EReference getArchitectureDescriptionLanguage_Profiles();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.core.architecture.Stakeholder <em>Stakeholder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stakeholder</em>'.
	 * @see org.eclipse.papyrus.infra.core.architecture.Stakeholder
	 * @generated
	 */
	EClass getStakeholder();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.infra.core.architecture.Stakeholder#getConcerns <em>Concerns</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Concerns</em>'.
	 * @see org.eclipse.papyrus.infra.core.architecture.Stakeholder#getConcerns()
	 * @see #getStakeholder()
	 * @generated
	 */
	EReference getStakeholder_Concerns();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.papyrus.infra.core.architecture.Stakeholder#getDomain <em>Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Domain</em>'.
	 * @see org.eclipse.papyrus.infra.core.architecture.Stakeholder#getDomain()
	 * @see #getStakeholder()
	 * @generated
	 */
	EReference getStakeholder_Domain();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.core.architecture.Concern <em>Concern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Concern</em>'.
	 * @see org.eclipse.papyrus.infra.core.architecture.Concern
	 * @generated
	 */
	EClass getConcern();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.papyrus.infra.core.architecture.Concern#getDomain <em>Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Domain</em>'.
	 * @see org.eclipse.papyrus.infra.core.architecture.Concern#getDomain()
	 * @see #getConcern()
	 * @generated
	 */
	EReference getConcern_Domain();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.core.architecture.ArchitectureViewpoint <em>Viewpoint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Viewpoint</em>'.
	 * @see org.eclipse.papyrus.infra.core.architecture.ArchitectureViewpoint
	 * @generated
	 */
	EClass getArchitectureViewpoint();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.infra.core.architecture.ArchitectureViewpoint#getConcerns <em>Concerns</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Concerns</em>'.
	 * @see org.eclipse.papyrus.infra.core.architecture.ArchitectureViewpoint#getConcerns()
	 * @see #getArchitectureViewpoint()
	 * @generated
	 */
	EReference getArchitectureViewpoint_Concerns();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.infra.core.architecture.ArchitectureViewpoint#getRepresentationKinds <em>Representation Kinds</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Representation Kinds</em>'.
	 * @see org.eclipse.papyrus.infra.core.architecture.ArchitectureViewpoint#getRepresentationKinds()
	 * @see #getArchitectureViewpoint()
	 * @generated
	 */
	EReference getArchitectureViewpoint_RepresentationKinds();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.papyrus.infra.core.architecture.ArchitectureViewpoint#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Context</em>'.
	 * @see org.eclipse.papyrus.infra.core.architecture.ArchitectureViewpoint#getContext()
	 * @see #getArchitectureViewpoint()
	 * @generated
	 */
	EReference getArchitectureViewpoint_Context();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.core.architecture.RepresentationKind <em>Representation Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Representation Kind</em>'.
	 * @see org.eclipse.papyrus.infra.core.architecture.RepresentationKind
	 * @generated
	 */
	EClass getRepresentationKind();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.infra.core.architecture.RepresentationKind#getConcerns <em>Concerns</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Concerns</em>'.
	 * @see org.eclipse.papyrus.infra.core.architecture.RepresentationKind#getConcerns()
	 * @see #getRepresentationKind()
	 * @generated
	 */
	EReference getRepresentationKind_Concerns();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.papyrus.infra.core.architecture.RepresentationKind#getLanguage <em>Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Language</em>'.
	 * @see org.eclipse.papyrus.infra.core.architecture.RepresentationKind#getLanguage()
	 * @see #getRepresentationKind()
	 * @generated
	 */
	EReference getRepresentationKind_Language();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.core.architecture.ArchitectureContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Context</em>'.
	 * @see org.eclipse.papyrus.infra.core.architecture.ArchitectureContext
	 * @generated
	 */
	EClass getArchitectureContext();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.core.architecture.ArchitectureContext#getViewpoints <em>Viewpoints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Viewpoints</em>'.
	 * @see org.eclipse.papyrus.infra.core.architecture.ArchitectureContext#getViewpoints()
	 * @see #getArchitectureContext()
	 * @generated
	 */
	EReference getArchitectureContext_Viewpoints();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.infra.core.architecture.ArchitectureContext#getDefaultViewpoints <em>Default Viewpoints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Default Viewpoints</em>'.
	 * @see org.eclipse.papyrus.infra.core.architecture.ArchitectureContext#getDefaultViewpoints()
	 * @see #getArchitectureContext()
	 * @generated
	 */
	EReference getArchitectureContext_DefaultViewpoints();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.infra.core.architecture.ArchitectureContext#getElementTypes <em>Element Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Element Types</em>'.
	 * @see org.eclipse.papyrus.infra.core.architecture.ArchitectureContext#getElementTypes()
	 * @see #getArchitectureContext()
	 * @generated
	 */
	EReference getArchitectureContext_ElementTypes();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.core.architecture.ArchitectureContext#getExtensionPrefix <em>Extension Prefix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Extension Prefix</em>'.
	 * @see org.eclipse.papyrus.infra.core.architecture.ArchitectureContext#getExtensionPrefix()
	 * @see #getArchitectureContext()
	 * @generated
	 */
	EAttribute getArchitectureContext_ExtensionPrefix();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.core.architecture.ArchitectureContext#getCreationCommandClass <em>Creation Command Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Creation Command Class</em>'.
	 * @see org.eclipse.papyrus.infra.core.architecture.ArchitectureContext#getCreationCommandClass()
	 * @see #getArchitectureContext()
	 * @generated
	 */
	EAttribute getArchitectureContext_CreationCommandClass();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.core.architecture.ArchitectureContext#getConversionCommandClass <em>Conversion Command Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Conversion Command Class</em>'.
	 * @see org.eclipse.papyrus.infra.core.architecture.ArchitectureContext#getConversionCommandClass()
	 * @see #getArchitectureContext()
	 * @generated
	 */
	EAttribute getArchitectureContext_ConversionCommandClass();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.infra.core.architecture.ArchitectureContext#ceationCommandClassExists(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Ceation Command Class Exists</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Ceation Command Class Exists</em>' operation.
	 * @see org.eclipse.papyrus.infra.core.architecture.ArchitectureContext#ceationCommandClassExists(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @since 2.0
	 */
	EOperation getArchitectureContext__CeationCommandClassExists__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.infra.core.architecture.ArchitectureContext#conversionCommandClassExists(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Conversion Command Class Exists</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Conversion Command Class Exists</em>' operation.
	 * @see org.eclipse.papyrus.infra.core.architecture.ArchitectureContext#conversionCommandClassExists(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @since 2.0
	 */
	EOperation getArchitectureContext__ConversionCommandClassExists__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.papyrus.infra.core.architecture.ArchitectureContext#getDomain <em>Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Domain</em>'.
	 * @see org.eclipse.papyrus.infra.core.architecture.ArchitectureContext#getDomain()
	 * @see #getArchitectureContext()
	 * @generated
	 */
	EReference getArchitectureContext_Domain();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.core.architecture.ArchitectureFramework <em>Framework</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Framework</em>'.
	 * @see org.eclipse.papyrus.infra.core.architecture.ArchitectureFramework
	 * @generated
	 */
	EClass getArchitectureFramework();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.core.architecture.ArchitectureDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Description</em>'.
	 * @see org.eclipse.papyrus.infra.core.architecture.ArchitectureDescription
	 * @generated
	 */
	EClass getArchitectureDescription();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.core.architecture.ArchitectureDescription#getContextId <em>Context Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Context Id</em>'.
	 * @see org.eclipse.papyrus.infra.core.architecture.ArchitectureDescription#getContextId()
	 * @see #getArchitectureDescription()
	 * @generated
	 */
	EAttribute getArchitectureDescription_ContextId();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.core.architecture.ArchitectureDescriptionPreferences <em>Description Preferences</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Description Preferences</em>'.
	 * @see org.eclipse.papyrus.infra.core.architecture.ArchitectureDescriptionPreferences
	 * @generated
	 */
	EClass getArchitectureDescriptionPreferences();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.infra.core.architecture.ArchitectureDescriptionPreferences#getViewpointIds <em>Viewpoint Ids</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Viewpoint Ids</em>'.
	 * @see org.eclipse.papyrus.infra.core.architecture.ArchitectureDescriptionPreferences#getViewpointIds()
	 * @see #getArchitectureDescriptionPreferences()
	 * @generated
	 */
	EAttribute getArchitectureDescriptionPreferences_ViewpointIds();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ArchitectureFactory getArchitectureFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.core.architecture.impl.ADElementImpl <em>AD Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.core.architecture.impl.ADElementImpl
		 * @see org.eclipse.papyrus.infra.core.architecture.impl.ArchitecturePackageImpl#getADElement()
		 * @generated
		 */
		EClass AD_ELEMENT = eINSTANCE.getADElement();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AD_ELEMENT__ID = eINSTANCE.getADElement_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AD_ELEMENT__NAME = eINSTANCE.getADElement_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AD_ELEMENT__DESCRIPTION = eINSTANCE.getADElement_Description();

		/**
		 * The meta object literal for the '<em><b>Qualified Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AD_ELEMENT__QUALIFIED_NAME = eINSTANCE.getADElement_QualifiedName();

		/**
		 * The meta object literal for the '<em><b>Icon</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AD_ELEMENT__ICON = eINSTANCE.getADElement_Icon();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.core.architecture.impl.ArchitectureDomainImpl <em>Domain</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.core.architecture.impl.ArchitectureDomainImpl
		 * @see org.eclipse.papyrus.infra.core.architecture.impl.ArchitecturePackageImpl#getArchitectureDomain()
		 * @generated
		 */
		EClass ARCHITECTURE_DOMAIN = eINSTANCE.getArchitectureDomain();

		/**
		 * The meta object literal for the '<em><b>Stakeholders</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURE_DOMAIN__STAKEHOLDERS = eINSTANCE.getArchitectureDomain_Stakeholders();

		/**
		 * The meta object literal for the '<em><b>Concerns</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURE_DOMAIN__CONCERNS = eINSTANCE.getArchitectureDomain_Concerns();

		/**
		 * The meta object literal for the '<em><b>Contexts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURE_DOMAIN__CONTEXTS = eINSTANCE.getArchitectureDomain_Contexts();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.core.architecture.impl.ArchitectureDescriptionLanguageImpl <em>Description Language</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.core.architecture.impl.ArchitectureDescriptionLanguageImpl
		 * @see org.eclipse.papyrus.infra.core.architecture.impl.ArchitecturePackageImpl#getArchitectureDescriptionLanguage()
		 * @generated
		 */
		EClass ARCHITECTURE_DESCRIPTION_LANGUAGE = eINSTANCE.getArchitectureDescriptionLanguage();

		/**
		 * The meta object literal for the '<em><b>Representation Kinds</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURE_DESCRIPTION_LANGUAGE__REPRESENTATION_KINDS = eINSTANCE.getArchitectureDescriptionLanguage_RepresentationKinds();

		/**
		 * The meta object literal for the '<em><b>Metamodel</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURE_DESCRIPTION_LANGUAGE__METAMODEL = eINSTANCE.getArchitectureDescriptionLanguage_Metamodel();

		/**
		 * The meta object literal for the '<em><b>Profiles</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURE_DESCRIPTION_LANGUAGE__PROFILES = eINSTANCE.getArchitectureDescriptionLanguage_Profiles();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.core.architecture.impl.StakeholderImpl <em>Stakeholder</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.core.architecture.impl.StakeholderImpl
		 * @see org.eclipse.papyrus.infra.core.architecture.impl.ArchitecturePackageImpl#getStakeholder()
		 * @generated
		 */
		EClass STAKEHOLDER = eINSTANCE.getStakeholder();

		/**
		 * The meta object literal for the '<em><b>Concerns</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STAKEHOLDER__CONCERNS = eINSTANCE.getStakeholder_Concerns();

		/**
		 * The meta object literal for the '<em><b>Domain</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STAKEHOLDER__DOMAIN = eINSTANCE.getStakeholder_Domain();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.core.architecture.impl.ConcernImpl <em>Concern</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.core.architecture.impl.ConcernImpl
		 * @see org.eclipse.papyrus.infra.core.architecture.impl.ArchitecturePackageImpl#getConcern()
		 * @generated
		 */
		EClass CONCERN = eINSTANCE.getConcern();

		/**
		 * The meta object literal for the '<em><b>Domain</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCERN__DOMAIN = eINSTANCE.getConcern_Domain();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.core.architecture.impl.ArchitectureViewpointImpl <em>Viewpoint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.core.architecture.impl.ArchitectureViewpointImpl
		 * @see org.eclipse.papyrus.infra.core.architecture.impl.ArchitecturePackageImpl#getArchitectureViewpoint()
		 * @generated
		 */
		EClass ARCHITECTURE_VIEWPOINT = eINSTANCE.getArchitectureViewpoint();

		/**
		 * The meta object literal for the '<em><b>Concerns</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURE_VIEWPOINT__CONCERNS = eINSTANCE.getArchitectureViewpoint_Concerns();

		/**
		 * The meta object literal for the '<em><b>Representation Kinds</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURE_VIEWPOINT__REPRESENTATION_KINDS = eINSTANCE.getArchitectureViewpoint_RepresentationKinds();

		/**
		 * The meta object literal for the '<em><b>Context</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURE_VIEWPOINT__CONTEXT = eINSTANCE.getArchitectureViewpoint_Context();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.core.architecture.impl.RepresentationKindImpl <em>Representation Kind</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.core.architecture.impl.RepresentationKindImpl
		 * @see org.eclipse.papyrus.infra.core.architecture.impl.ArchitecturePackageImpl#getRepresentationKind()
		 * @generated
		 */
		EClass REPRESENTATION_KIND = eINSTANCE.getRepresentationKind();

		/**
		 * The meta object literal for the '<em><b>Concerns</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REPRESENTATION_KIND__CONCERNS = eINSTANCE.getRepresentationKind_Concerns();

		/**
		 * The meta object literal for the '<em><b>Language</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REPRESENTATION_KIND__LANGUAGE = eINSTANCE.getRepresentationKind_Language();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.core.architecture.impl.ArchitectureContextImpl <em>Context</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.core.architecture.impl.ArchitectureContextImpl
		 * @see org.eclipse.papyrus.infra.core.architecture.impl.ArchitecturePackageImpl#getArchitectureContext()
		 * @generated
		 */
		EClass ARCHITECTURE_CONTEXT = eINSTANCE.getArchitectureContext();

		/**
		 * The meta object literal for the '<em><b>Viewpoints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURE_CONTEXT__VIEWPOINTS = eINSTANCE.getArchitectureContext_Viewpoints();

		/**
		 * The meta object literal for the '<em><b>Default Viewpoints</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURE_CONTEXT__DEFAULT_VIEWPOINTS = eINSTANCE.getArchitectureContext_DefaultViewpoints();

		/**
		 * The meta object literal for the '<em><b>Element Types</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURE_CONTEXT__ELEMENT_TYPES = eINSTANCE.getArchitectureContext_ElementTypes();

		/**
		 * The meta object literal for the '<em><b>Extension Prefix</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARCHITECTURE_CONTEXT__EXTENSION_PREFIX = eINSTANCE.getArchitectureContext_ExtensionPrefix();

		/**
		 * The meta object literal for the '<em><b>Creation Command Class</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARCHITECTURE_CONTEXT__CREATION_COMMAND_CLASS = eINSTANCE.getArchitectureContext_CreationCommandClass();

		/**
		 * The meta object literal for the '<em><b>Conversion Command Class</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARCHITECTURE_CONTEXT__CONVERSION_COMMAND_CLASS = eINSTANCE.getArchitectureContext_ConversionCommandClass();

		/**
		 * The meta object literal for the '<em><b>Ceation Command Class Exists</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 * @since 2.0
		 */
		EOperation ARCHITECTURE_CONTEXT___CEATION_COMMAND_CLASS_EXISTS__DIAGNOSTICCHAIN_MAP = eINSTANCE.getArchitectureContext__CeationCommandClassExists__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Conversion Command Class Exists</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 * @since 2.0
		 */
		EOperation ARCHITECTURE_CONTEXT___CONVERSION_COMMAND_CLASS_EXISTS__DIAGNOSTICCHAIN_MAP = eINSTANCE.getArchitectureContext__ConversionCommandClassExists__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Domain</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURE_CONTEXT__DOMAIN = eINSTANCE.getArchitectureContext_Domain();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.core.architecture.impl.ArchitectureFrameworkImpl <em>Framework</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.core.architecture.impl.ArchitectureFrameworkImpl
		 * @see org.eclipse.papyrus.infra.core.architecture.impl.ArchitecturePackageImpl#getArchitectureFramework()
		 * @generated
		 */
		EClass ARCHITECTURE_FRAMEWORK = eINSTANCE.getArchitectureFramework();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.core.architecture.impl.ArchitectureDescriptionImpl <em>Description</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.core.architecture.impl.ArchitectureDescriptionImpl
		 * @see org.eclipse.papyrus.infra.core.architecture.impl.ArchitecturePackageImpl#getArchitectureDescription()
		 * @generated
		 */
		EClass ARCHITECTURE_DESCRIPTION = eINSTANCE.getArchitectureDescription();

		/**
		 * The meta object literal for the '<em><b>Context Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARCHITECTURE_DESCRIPTION__CONTEXT_ID = eINSTANCE.getArchitectureDescription_ContextId();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.core.architecture.impl.ArchitectureDescriptionPreferencesImpl <em>Description Preferences</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.core.architecture.impl.ArchitectureDescriptionPreferencesImpl
		 * @see org.eclipse.papyrus.infra.core.architecture.impl.ArchitecturePackageImpl#getArchitectureDescriptionPreferences()
		 * @generated
		 */
		EClass ARCHITECTURE_DESCRIPTION_PREFERENCES = eINSTANCE.getArchitectureDescriptionPreferences();

		/**
		 * The meta object literal for the '<em><b>Viewpoint Ids</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARCHITECTURE_DESCRIPTION_PREFERENCES__VIEWPOINT_IDS = eINSTANCE.getArchitectureDescriptionPreferences_ViewpointIds();

	}

} //ArchitecturePackage
