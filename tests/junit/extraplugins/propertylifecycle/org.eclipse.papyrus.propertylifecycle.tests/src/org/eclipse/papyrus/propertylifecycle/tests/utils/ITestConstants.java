/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.propertylifecycle.tests.utils;


public interface ITestConstants {

	// Saving Created Resources
	public static String RESOURCES_PROJECTNAME = "PropertyLifecycle";

	public static String RESOURCES_FOLDERNAME = "resources";

	public static String RESOURCES_ENCODING = "UTF-8";

	public static String RESOURCES_UMLMODELNAME = "testmodel.uml";

	public static String RESOURCES_DIMODELNAME = "testmodel.di";

	public static String RESOURCES_STRATEGYMODELNAME = "teststrategy.propertylifecycle";


	// Init UML Test model
	public static String ROOTMODEL_NAME = "PropertyLifecycleTestModel";

	public static String SUBMODEL_NAME = "SubModel";

	public static String COMPONENT_PACKAGE_NAME = "ComponentPackage";

	public static String COMPONENT_NAME = "beforeStrategyComponent";

	public static String CLASS_PACKAGE_NAME = "ClassPackage";

	public static String CLASS_NAME = "beforeStrategyClass";

	public static String PROPERTY_CLASS_NAME = "beforeStrategyClassProperty";

	public static String PROPERTY_COMPONENT_NAME = "beforeStrategyComponentProperty";

	// Init Strategy test model
	static final String STRATEGYSET_DESCRIPTION = "this is a strategySet containing strategies applicable to the Elements";

	static final String STRATEGYSET_ID = "org.eclipse.papyrus.infra.propertylifecycle.tests.propertylifecycletest";

	static final String STRATEGYSET_NAME = "test strategySet";

	/** Component strategy initialization variables */
	static final String STRATEGYELEMENT_BASETYPE_COMPONENT = "org.eclipse.papyrus.uml.Component";

	static final String STRATEGYELEMENT_DESCRIPTION_COMPONENT = "comonent description";

	static final String STRATEGYELEMENT_ID_COMPONENT = "org.eclipse.papyrus.uml.Component.Tests";

	static final String STRATEGYELEMENT_NAME_COMPONENT = "org.eclipse.papyrus.uml.Component.Tests";

	static final String STRATEGYELEMENT_SPECIALIZEDTYPE_COMPONENT = null;

	static final String STRATEGYPROPERTY_FEATURELABEL_COMPONENT = "name";

	static final Integer ELEMENTPROPERTY_PRIORITY_COMPONENT = 0;

	static final String ELEMENTPROPERTY_PROCESSORPATH_COMPONENT = "org.eclipse.papyrus.infra.propertylifecycle.tests.strategies.processors.ComponentProcessor";

	/** Class strategy initialization variables */
	static final String STRATEGYELEMENT_BASETYPE_CLASS = "org.eclipse.papyrus.uml.Class";

	static final String STRATEGYELEMENT_DESCRIPTION_CLASS = "class description";

	static final String STRATEGYELEMENT_ID_CLASS = "org.eclipse.papyrus.uml.Class.Tests";

	static final String STRATEGYELEMENT_NAME_CLASS = "org.eclipse.papyrus.uml.Class.Tests";

	static final String STRATEGYELEMENT_SPECIALIZEDTYPE_CLASS = null;

	static final String STRATEGYCONTAINER_BASETYPE_CLASS = "org.eclipse.papyrus.uml.Model";

	static final String STRATEGYCONTAINER_SPECIALIZEDTYPE_CLASS = null;

	static final String STRATEGYPROPERTY_FEATURELABEL_CLASS = "name";

	static final Integer ELEMENTPROPERTY_PRIORITY_CLASS = 0;

	static final String ELEMENTPROPERTY_PROCESSORPATH_CLASS = "org.eclipse.papyrus.infra.propertylifecycle.tests.strategies.processors.ClassProcessor";

	/** Property strategy initialization variables */
	// 0- Shared variables
	static final String STRATEGYELEMENT_BASETYPE_PROPERTY = "org.eclipse.papyrus.uml.Property";

	static final String STRATEGYELEMENT_DESCRIPTION_PROPERTY = "property description";

	static final String STRATEGYELEMENT_SPECIALIZEDTYPE_PROPERTY = null;

	static final String STRATEGYCONTAINER_SPECIALIZEDTYPE_PROPERTY = null;

	static final String STRATEGYPROPERTY_FEATURELABEL_PROPERTY = "name";

	static final String ELEMENTPROPERTY_PROCESSORPATH_PROPERTY = "org.eclipse.papyrus.infra.propertylifecycle.tests.strategies.processors.PropertyProcessor";

	// 1- Component property

	static final String STRATEGYELEMENT_ID_COMPONENTPROPERTY = "org.eclipse.papyrus.uml.ComponentProperty.Tests";

	static final String STRATEGYELEMENT_NAME_COMPONENTPROPERTY = "org.eclipse.papyrus.uml.ComponentProperty.Tests";

	static final String STRATEGYCONTAINER_BASETYPE_COMPONENTPROPERTY = "org.eclipse.papyrus.uml.Component";

	static final Integer ELEMENTPROPERTY_PRIORITY_PROPERTY = 0;

	// 2- Class property
	static final String STRATEGYELEMENT_ID_CLASSPROPERTY = "org.eclipse.papyrus.uml.ClassProperty.Tests";

	static final String STRATEGYELEMENT_NAME_CLASSPROPERTY = "org.eclipse.papyrus.uml.ClassProperty.Tests";

	static final String STRATEGYCONTAINER_BASETYPE_CLASSPROPERTY = "org.eclipse.papyrus.uml.Class";

	static final Integer ELEMENTPROPERTY_PRIORITY_CLASSPROPERTY = -1;

	/** SysML Block strategy initialization variables */
	static final String STRATEGYELEMENT_BASETYPE_SYSMLBLOCK = "org.eclipse.papyrus.sysml.Block";

	static final String STRATEGYELEMENT_DESCRIPTION_SYSMLBLOCK = "SysML Block description";

	static final String STRATEGYELEMENT_ID_SYSMLBLOCK = "org.eclipse.papyrus.sysml.Block.Tests";

	static final String STRATEGYELEMENT_NAME_SYSMLBLOCK = "org.eclipse.papyrus.sysml.Block.Tests";

	static final String STRATEGYELEMENT_SPECIALIZEDTYPE_SYSMLBLOCK = "org.eclipse.papyrus.uml.Class";

	static final String STRATEGYPROPERTY_FEATURELABEL_SYSMLBLOCK = "name";

	static final Integer ELEMENTPROPERTY_PRIORITY_SYSMLBLOCK = 0;

	static final String ELEMENTPROPERTY_PROCESSORPATH_SYSMLBLOCK = "org.eclipse.papyrus.infra.propertylifecycle.tests.strategies.processors.SysmlBlockProcessor";

	/** SysML14 Block strategy initialization variables */
	static final String STRATEGYELEMENT_BASETYPE_SYSML14BLOCK = "org.eclipse.papyrus.SysML14.Block";

	static final String STRATEGYELEMENT_DESCRIPTION_SYSML14BLOCK = "SysML14 Block description";

	static final String STRATEGYELEMENT_ID_SYSML14BLOCK = "org.eclipse.papyrus.SysML14.Block.Tests";

	static final String STRATEGYELEMENT_NAME_SYSML14BLOCK = "org.eclipse.papyrus.SysML14.Block.Tests";

	static final String STRATEGYELEMENT_SPECIALIZEDTYPE_SYSML14BLOCK = "org.eclipse.papyrus.uml.Class";

	static final String STRATEGYPROPERTY_FEATURELABEL_SYSML14BLOCK = "name";

	static final Integer ELEMENTPROPERTY_PRIORITY_SYSML14BLOCK = 0;

	static final String ELEMENTPROPERTY_PROCESSORPATH_SYSML14BLOCK = "org.eclipse.papyrus.infra.propertylifecycle.tests.strategies.processors.Sysml14BlockProcessor";

	/** Association strategy initialization variables */
	static final String STRATEGYELEMENT_BASETYPE_ASSOCIATION = "org.eclipse.papyrus.uml.Association";

	static final String STRATEGYELEMENT_DESCRIPTION_ASSOCIATION = "association description";

	static final String STRATEGYELEMENT_ID_ASSOCIATION = "org.eclipse.papyrus.uml.Association.Tests";

	static final String STRATEGYELEMENT_NAME_ASSOCIATION = "org.eclipse.papyrus.uml.Association.Tests";

	static final String STRATEGYELEMENT_SPECIALIZEDTYPE_ASSOCIATION = null;

	static final String STRATEGYPROPERTY_FEATURELABEL_ASSOCIATION = "name";

	static final Integer ELEMENTPROPERTY_PRIORITY_ASSOCIATION = 0;

	static final String ELEMENTPROPERTY_PROCESSORPATH_ASSOCIATION = "org.eclipse.papyrus.infra.propertylifecycle.tests.strategies.processors.AssociationProcessor";

}
