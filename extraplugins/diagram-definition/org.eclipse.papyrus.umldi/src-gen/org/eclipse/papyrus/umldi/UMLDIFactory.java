/**
 * Copyright (c) 2014 CEA LIST.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.umldi;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.umldi.UMLDIPackage
 * @generated
 */
public interface UMLDIFactory extends EFactory {

	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	UMLDIFactory eINSTANCE = org.eclipse.papyrus.umldi.impl.UMLDIFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Uml Style</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Uml Style</em>'.
	 * @generated
	 */
	UmlStyle createUmlStyle();

	/**
	 * Returns a new object of class '<em>Main Label</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Main Label</em>'.
	 * @generated
	 */
	MainLabel createMainLabel();

	/**
	 * Returns a new object of class '<em>Class Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Class Diagram</em>'.
	 * @generated
	 */
	ClassDiagram createClassDiagram();

	/**
	 * Returns a new object of class '<em>Stereotype Compartment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Stereotype Compartment</em>'.
	 * @generated
	 */
	StereotypeCompartment createStereotypeCompartment();

	/**
	 * Returns a new object of class '<em>Template Parameter Compartment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Template Parameter Compartment</em>'.
	 * @generated
	 */
	TemplateParameterCompartment createTemplateParameterCompartment();

	/**
	 * Returns a new object of class '<em>List Item Label</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>List Item Label</em>'.
	 * @generated
	 */
	ListItemLabel createListItemLabel();

	/**
	 * Returns a new object of class '<em>Stereotype Label</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Stereotype Label</em>'.
	 * @generated
	 */
	StereotypeLabel createStereotypeLabel();

	/**
	 * Returns a new object of class '<em>Owned Use Case Compartment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Owned Use Case Compartment</em>'.
	 * @generated
	 */
	OwnedUseCaseCompartment createOwnedUseCaseCompartment();

	/**
	 * Returns a new object of class '<em>Use Case Compartment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Use Case Compartment</em>'.
	 * @generated
	 */
	UseCaseCompartment createUseCaseCompartment();

	/**
	 * Returns a new object of class '<em>Package Shape</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Package Shape</em>'.
	 * @generated
	 */
	PackageShape createPackageShape();

	/**
	 * Returns a new object of class '<em>Packaged Element Compartment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Packaged Element Compartment</em>'.
	 * @generated
	 */
	PackagedElementCompartment createPackagedElementCompartment();

	/**
	 * Returns a new object of class '<em>Constraint Shape</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Constraint Shape</em>'.
	 * @generated
	 */
	ConstraintShape createConstraintShape();

	/**
	 * Returns a new object of class '<em>Attribute Compartment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Attribute Compartment</em>'.
	 * @generated
	 */
	AttributeCompartment createAttributeCompartment();

	/**
	 * Returns a new object of class '<em>Operation Compartment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Operation Compartment</em>'.
	 * @generated
	 */
	OperationCompartment createOperationCompartment();

	/**
	 * Returns a new object of class '<em>Reception Compartment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Reception Compartment</em>'.
	 * @generated
	 */
	ReceptionCompartment createReceptionCompartment();

	/**
	 * Returns a new object of class '<em>Literal Compartment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Literal Compartment</em>'.
	 * @generated
	 */
	LiteralCompartment createLiteralCompartment();

	/**
	 * Returns a new object of class '<em>Enumeration Shape</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Enumeration Shape</em>'.
	 * @generated
	 */
	EnumerationShape createEnumerationShape();

	/**
	 * Returns a new object of class '<em>Role Label</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Role Label</em>'.
	 * @generated
	 */
	RoleLabel createRoleLabel();

	/**
	 * Returns a new object of class '<em>Association Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Association Edge</em>'.
	 * @generated
	 */
	AssociationEdge createAssociationEdge();

	/**
	 * Returns a new object of class '<em>Multiplicity Label</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Multiplicity Label</em>'.
	 * @generated
	 */
	MultiplicityLabel createMultiplicityLabel();

	/**
	 * Returns a new object of class '<em>Property Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Property Edge</em>'.
	 * @generated
	 */
	PropertyEdge createPropertyEdge();

	/**
	 * Returns a new object of class '<em>Constraint Label</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Constraint Label</em>'.
	 * @generated
	 */
	ConstraintLabel createConstraintLabel();

	/**
	 * Returns a new object of class '<em>Generalization Set Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Generalization Set Edge</em>'.
	 * @generated
	 */
	GeneralizationSetEdge createGeneralizationSetEdge();

	/**
	 * Returns a new object of class '<em>Power Label</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Power Label</em>'.
	 * @generated
	 */
	PowerLabel createPowerLabel();

	/**
	 * Returns a new object of class '<em>Object Node Shape</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Object Node Shape</em>'.
	 * @generated
	 */
	ObjectNodeShape createObjectNodeShape();

	/**
	 * Returns a new object of class '<em>Activity Node Shape</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Activity Node Shape</em>'.
	 * @generated
	 */
	ActivityNodeShape createActivityNodeShape();

	/**
	 * Returns a new object of class '<em>Selection Label</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Selection Label</em>'.
	 * @generated
	 */
	SelectionLabel createSelectionLabel();

	/**
	 * Returns a new object of class '<em>Object Flow Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Object Flow Edge</em>'.
	 * @generated
	 */
	ObjectFlowEdge createObjectFlowEdge();

	/**
	 * Returns a new object of class '<em>Guard Label</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Guard Label</em>'.
	 * @generated
	 */
	GuardLabel createGuardLabel();

	/**
	 * Returns a new object of class '<em>Weight Label</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Weight Label</em>'.
	 * @generated
	 */
	WeightLabel createWeightLabel();

	/**
	 * Returns a new object of class '<em>Transformation Label</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Transformation Label</em>'.
	 * @generated
	 */
	TransformationLabel createTransformationLabel();

	/**
	 * Returns a new object of class '<em>Connector Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Connector Edge</em>'.
	 * @generated
	 */
	ConnectorEdge createConnectorEdge();

	/**
	 * Returns a new object of class '<em>Instance Specification Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Instance Specification Edge</em>'.
	 * @generated
	 */
	InstanceSpecificationEdge createInstanceSpecificationEdge();

	/**
	 * Returns a new object of class '<em>Dependency Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Dependency Edge</em>'.
	 * @generated
	 */
	DependencyEdge createDependencyEdge();

	/**
	 * Returns a new object of class '<em>Instance Specification Shape</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Instance Specification Shape</em>'.
	 * @generated
	 */
	InstanceSpecificationShape createInstanceSpecificationShape();

	/**
	 * Returns a new object of class '<em>Deployed Artifact Compartment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Deployed Artifact Compartment</em>'.
	 * @generated
	 */
	DeployedArtifactCompartment createDeployedArtifactCompartment();

	/**
	 * Returns a new object of class '<em>Slot Compartment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Slot Compartment</em>'.
	 * @generated
	 */
	SlotCompartment createSlotCompartment();

	/**
	 * Returns a new object of class '<em>Class Shape</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Class Shape</em>'.
	 * @generated
	 */
	ClassShape createClassShape();

	/**
	 * Returns a new object of class '<em>Structure Compartment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Structure Compartment</em>'.
	 * @generated
	 */
	StructureCompartment createStructureCompartment();

	/**
	 * Returns a new object of class '<em>Port Shape</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Port Shape</em>'.
	 * @generated
	 */
	PortShape createPortShape();

	/**
	 * Returns a new object of class '<em>Nested Classifier Compartment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Nested Classifier Compartment</em>'.
	 * @generated
	 */
	NestedClassifierCompartment createNestedClassifierCompartment();

	/**
	 * Returns a new object of class '<em>Owned Behavior Compartment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Owned Behavior Compartment</em>'.
	 * @generated
	 */
	OwnedBehaviorCompartment createOwnedBehaviorCompartment();

	/**
	 * Returns a new object of class '<em>Interface Shape</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Interface Shape</em>'.
	 * @generated
	 */
	InterfaceShape createInterfaceShape();

	/**
	 * Returns a new object of class '<em>Data Type Shape</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Data Type Shape</em>'.
	 * @generated
	 */
	DataTypeShape createDataTypeShape();

	/**
	 * Returns a new object of class '<em>Primitive Type Shape</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Primitive Type Shape</em>'.
	 * @generated
	 */
	PrimitiveTypeShape createPrimitiveTypeShape();

	/**
	 * Returns a new object of class '<em>Signal Shape</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Signal Shape</em>'.
	 * @generated
	 */
	SignalShape createSignalShape();

	/**
	 * Returns a new object of class '<em>Model Shape</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Model Shape</em>'.
	 * @generated
	 */
	ModelShape createModelShape();

	/**
	 * Returns a new object of class '<em>Containment Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Containment Edge</em>'.
	 * @generated
	 */
	ContainmentEdge createContainmentEdge();

	/**
	 * Returns a new object of class '<em>Generalization Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Generalization Edge</em>'.
	 * @generated
	 */
	GeneralizationEdge createGeneralizationEdge();

	/**
	 * Returns a new object of class '<em>Realization Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Realization Edge</em>'.
	 * @generated
	 */
	RealizationEdge createRealizationEdge();

	/**
	 * Returns a new object of class '<em>Abstraction Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Abstraction Edge</em>'.
	 * @generated
	 */
	AbstractionEdge createAbstractionEdge();

	/**
	 * Returns a new object of class '<em>Interface Realization Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Interface Realization Edge</em>'.
	 * @generated
	 */
	InterfaceRealizationEdge createInterfaceRealizationEdge();

	/**
	 * Returns a new object of class '<em>Usage Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Usage Edge</em>'.
	 * @generated
	 */
	UsageEdge createUsageEdge();

	/**
	 * Returns a new object of class '<em>Element Import Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Element Import Edge</em>'.
	 * @generated
	 */
	ElementImportEdge createElementImportEdge();

	/**
	 * Returns a new object of class '<em>Package Import Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Package Import Edge</em>'.
	 * @generated
	 */
	PackageImportEdge createPackageImportEdge();

	/**
	 * Returns a new object of class '<em>Package Merge Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Package Merge Edge</em>'.
	 * @generated
	 */
	PackageMergeEdge createPackageMergeEdge();

	/**
	 * Returns a new object of class '<em>Substitution Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Substitution Edge</em>'.
	 * @generated
	 */
	SubstitutionEdge createSubstitutionEdge();

	/**
	 * Returns a new object of class '<em>Information Flow Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Information Flow Edge</em>'.
	 * @generated
	 */
	InformationFlowEdge createInformationFlowEdge();

	/**
	 * Returns a new object of class '<em>Conveyed Label</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Conveyed Label</em>'.
	 * @generated
	 */
	ConveyedLabel createConveyedLabel();

	/**
	 * Returns a new object of class '<em>Association Class Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Association Class Edge</em>'.
	 * @generated
	 */
	AssociationClassEdge createAssociationClassEdge();

	/**
	 * Returns a new object of class '<em>Comment Shape</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Comment Shape</em>'.
	 * @generated
	 */
	CommentShape createCommentShape();

	/**
	 * Returns a new object of class '<em>Attachment Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Attachment Edge</em>'.
	 * @generated
	 */
	AttachmentEdge createAttachmentEdge();

	/**
	 * Returns a new object of class '<em>Association Class Shape</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Association Class Shape</em>'.
	 * @generated
	 */
	AssociationClassShape createAssociationClassShape();

	/**
	 * Returns a new object of class '<em>Component Shape</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Component Shape</em>'.
	 * @generated
	 */
	ComponentShape createComponentShape();

	/**
	 * Returns a new object of class '<em>Information Item Shape</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Information Item Shape</em>'.
	 * @generated
	 */
	InformationItemShape createInformationItemShape();

	/**
	 * Returns a new object of class '<em>Representation Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Representation Edge</em>'.
	 * @generated
	 */
	RepresentationEdge createRepresentationEdge();

	/**
	 * Returns a new object of class '<em>Association Shape</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Association Shape</em>'.
	 * @generated
	 */
	AssociationShape createAssociationShape();

	/**
	 * Returns a new object of class '<em>Dependency Shape</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Dependency Shape</em>'.
	 * @generated
	 */
	DependencyShape createDependencyShape();

	/**
	 * Returns a new object of class '<em>Time Observation Shape</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Time Observation Shape</em>'.
	 * @generated
	 */
	TimeObservationShape createTimeObservationShape();

	/**
	 * Returns a new object of class '<em>Time Observation Shape Time Observation Shape</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Time Observation Shape Time Observation Shape</em>'.
	 * @generated
	 */
	TimeObservationShape_TimeObservationShape createTimeObservationShape_TimeObservationShape();

	/**
	 * Returns a new object of class '<em>Duration Observation Shape</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Duration Observation Shape</em>'.
	 * @generated
	 */
	DurationObservationShape createDurationObservationShape();

	/**
	 * Returns a new object of class '<em>Package Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Package Diagram</em>'.
	 * @generated
	 */
	PackageDiagram createPackageDiagram();

	/**
	 * Returns a new object of class '<em>Profile Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Profile Diagram</em>'.
	 * @generated
	 */
	ProfileDiagram createProfileDiagram();

	/**
	 * Returns a new object of class '<em>Composite Structure Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Composite Structure Diagram</em>'.
	 * @generated
	 */
	CompositeStructureDiagram createCompositeStructureDiagram();

	/**
	 * Returns a new object of class '<em>Deployment Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Deployment Diagram</em>'.
	 * @generated
	 */
	DeploymentDiagram createDeploymentDiagram();

	/**
	 * Returns a new object of class '<em>Component Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Component Diagram</em>'.
	 * @generated
	 */
	ComponentDiagram createComponentDiagram();

	/**
	 * Returns a new object of class '<em>Object Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Object Diagram</em>'.
	 * @generated
	 */
	ObjectDiagram createObjectDiagram();

	/**
	 * Returns a new object of class '<em>Profile Shape</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Profile Shape</em>'.
	 * @generated
	 */
	ProfileShape createProfileShape();

	/**
	 * Returns a new object of class '<em>Profile Application Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Profile Application Edge</em>'.
	 * @generated
	 */
	ProfileApplicationEdge createProfileApplicationEdge();

	/**
	 * Returns a new object of class '<em>Extension Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Extension Edge</em>'.
	 * @generated
	 */
	ExtensionEdge createExtensionEdge();

	/**
	 * Returns a new object of class '<em>Use Case Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Use Case Diagram</em>'.
	 * @generated
	 */
	UseCaseDiagram createUseCaseDiagram();

	/**
	 * Returns a new object of class '<em>Artifact Shape</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Artifact Shape</em>'.
	 * @generated
	 */
	ArtifactShape createArtifactShape();

	/**
	 * Returns a new object of class '<em>Nested Artifact Compartment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Nested Artifact Compartment</em>'.
	 * @generated
	 */
	NestedArtifactCompartment createNestedArtifactCompartment();

	/**
	 * Returns a new object of class '<em>Component Realization Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Component Realization Edge</em>'.
	 * @generated
	 */
	ComponentRealizationEdge createComponentRealizationEdge();

	/**
	 * Returns a new object of class '<em>Manifestation Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Manifestation Edge</em>'.
	 * @generated
	 */
	ManifestationEdge createManifestationEdge();

	/**
	 * Returns a new object of class '<em>Property Shape</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Property Shape</em>'.
	 * @generated
	 */
	PropertyShape createPropertyShape();

	/**
	 * Returns a new object of class '<em>Collaboration Shape</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Collaboration Shape</em>'.
	 * @generated
	 */
	CollaborationShape createCollaborationShape();

	/**
	 * Returns a new object of class '<em>Collaboration Use Shape</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Collaboration Use Shape</em>'.
	 * @generated
	 */
	CollaborationUseShape createCollaborationUseShape();

	/**
	 * Returns a new object of class '<em>Template Binding Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Template Binding Edge</em>'.
	 * @generated
	 */
	TemplateBindingEdge createTemplateBindingEdge();

	/**
	 * Returns a new object of class '<em>Stereotype Shape</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Stereotype Shape</em>'.
	 * @generated
	 */
	StereotypeShape createStereotypeShape();

	/**
	 * Returns a new object of class '<em>Node Shape</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Node Shape</em>'.
	 * @generated
	 */
	NodeShape createNodeShape();

	/**
	 * Returns a new object of class '<em>Nested Node Compartment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Nested Node Compartment</em>'.
	 * @generated
	 */
	NestedNodeCompartment createNestedNodeCompartment();

	/**
	 * Returns a new object of class '<em>Device Shape</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Device Shape</em>'.
	 * @generated
	 */
	DeviceShape createDeviceShape();

	/**
	 * Returns a new object of class '<em>Execution Environment Shape</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Execution Environment Shape</em>'.
	 * @generated
	 */
	ExecutionEnvironmentShape createExecutionEnvironmentShape();

	/**
	 * Returns a new object of class '<em>Activity Shape</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Activity Shape</em>'.
	 * @generated
	 */
	ActivityShape createActivityShape();

	/**
	 * Returns a new object of class '<em>Activity Node Compartment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Activity Node Compartment</em>'.
	 * @generated
	 */
	ActivityNodeCompartment createActivityNodeCompartment();

	/**
	 * Returns a new object of class '<em>Parameter Compartment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Parameter Compartment</em>'.
	 * @generated
	 */
	ParameterCompartment createParameterCompartment();

	/**
	 * Returns a new object of class '<em>Post Condition Compartment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Post Condition Compartment</em>'.
	 * @generated
	 */
	PostConditionCompartment createPostConditionCompartment();

	/**
	 * Returns a new object of class '<em>Pre Condition Compartment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Pre Condition Compartment</em>'.
	 * @generated
	 */
	PreConditionCompartment createPreConditionCompartment();

	/**
	 * Returns a new object of class '<em>Activity Parameter Node Shape</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Activity Parameter Node Shape</em>'.
	 * @generated
	 */
	ActivityParameterNodeShape createActivityParameterNodeShape();

	/**
	 * Returns a new object of class '<em>Interaction Shape</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Interaction Shape</em>'.
	 * @generated
	 */
	InteractionShape createInteractionShape();

	/**
	 * Returns a new object of class '<em>Interaction Fragment Shape</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Interaction Fragment Shape</em>'.
	 * @generated
	 */
	InteractionFragmentShape createInteractionFragmentShape();

	/**
	 * Returns a new object of class '<em>Subfragment Compartment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Subfragment Compartment</em>'.
	 * @generated
	 */
	SubfragmentCompartment createSubfragmentCompartment();

	/**
	 * Returns a new object of class '<em>Gate Shape</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Gate Shape</em>'.
	 * @generated
	 */
	GateShape createGateShape();

	/**
	 * Returns a new object of class '<em>Opaque Behavior Shape</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Opaque Behavior Shape</em>'.
	 * @generated
	 */
	OpaqueBehaviorShape createOpaqueBehaviorShape();

	/**
	 * Returns a new object of class '<em>Function Behavior Shape</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Function Behavior Shape</em>'.
	 * @generated
	 */
	FunctionBehaviorShape createFunctionBehaviorShape();

	/**
	 * Returns a new object of class '<em>State Machine Shape</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>State Machine Shape</em>'.
	 * @generated
	 */
	StateMachineShape createStateMachineShape();

	/**
	 * Returns a new object of class '<em>Pseudostate Shape</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Pseudostate Shape</em>'.
	 * @generated
	 */
	PseudostateShape createPseudostateShape();

	/**
	 * Returns a new object of class '<em>Region Compartment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Region Compartment</em>'.
	 * @generated
	 */
	RegionCompartment createRegionCompartment();

	/**
	 * Returns a new object of class '<em>Protocol State Machine Shape</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Protocol State Machine Shape</em>'.
	 * @generated
	 */
	ProtocolStateMachineShape createProtocolStateMachineShape();

	/**
	 * Returns a new object of class '<em>Deployment Specification Shape</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Deployment Specification Shape</em>'.
	 * @generated
	 */
	DeploymentSpecificationShape createDeploymentSpecificationShape();

	/**
	 * Returns a new object of class '<em>Communication Path Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Communication Path Edge</em>'.
	 * @generated
	 */
	CommunicationPathEdge createCommunicationPathEdge();

	/**
	 * Returns a new object of class '<em>Deployment Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Deployment Edge</em>'.
	 * @generated
	 */
	DeploymentEdge createDeploymentEdge();

	/**
	 * Returns a new object of class '<em>Actor Shape</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Actor Shape</em>'.
	 * @generated
	 */
	ActorShape createActorShape();

	/**
	 * Returns a new object of class '<em>Extension Point Compartment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Extension Point Compartment</em>'.
	 * @generated
	 */
	ExtensionPointCompartment createExtensionPointCompartment();

	/**
	 * Returns a new object of class '<em>Use Case Shape</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Use Case Shape</em>'.
	 * @generated
	 */
	UseCaseShape createUseCaseShape();

	/**
	 * Returns a new object of class '<em>Include Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Include Edge</em>'.
	 * @generated
	 */
	IncludeEdge createIncludeEdge();

	/**
	 * Returns a new object of class '<em>Extend Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Extend Edge</em>'.
	 * @generated
	 */
	ExtendEdge createExtendEdge();

	/**
	 * Returns a new object of class '<em>State Machine Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>State Machine Diagram</em>'.
	 * @generated
	 */
	StateMachineDiagram createStateMachineDiagram();

	/**
	 * Returns a new object of class '<em>Activity Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Activity Diagram</em>'.
	 * @generated
	 */
	ActivityDiagram createActivityDiagram();

	/**
	 * Returns a new object of class '<em>Sequence Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Sequence Diagram</em>'.
	 * @generated
	 */
	SequenceDiagram createSequenceDiagram();

	/**
	 * Returns a new object of class '<em>Communication Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Communication Diagram</em>'.
	 * @generated
	 */
	CommunicationDiagram createCommunicationDiagram();

	/**
	 * Returns a new object of class '<em>Timing Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Timing Diagram</em>'.
	 * @generated
	 */
	TimingDiagram createTimingDiagram();

	/**
	 * Returns a new object of class '<em>Interaction Overview Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Interaction Overview Diagram</em>'.
	 * @generated
	 */
	InteractionOverviewDiagram createInteractionOverviewDiagram();

	/**
	 * Returns a new object of class '<em>Internal Behavior Compartment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Internal Behavior Compartment</em>'.
	 * @generated
	 */
	InternalBehaviorCompartment createInternalBehaviorCompartment();

	/**
	 * Returns a new object of class '<em>State Shape</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>State Shape</em>'.
	 * @generated
	 */
	StateShape createStateShape();

	/**
	 * Returns a new object of class '<em>Connection Point Reference Shape</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Connection Point Reference Shape</em>'.
	 * @generated
	 */
	ConnectionPointReferenceShape createConnectionPointReferenceShape();

	/**
	 * Returns a new object of class '<em>Internal Transition Compartment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Internal Transition Compartment</em>'.
	 * @generated
	 */
	InternalTransitionCompartment createInternalTransitionCompartment();

	/**
	 * Returns a new object of class '<em>Deferrable Trigger Compartment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Deferrable Trigger Compartment</em>'.
	 * @generated
	 */
	DeferrableTriggerCompartment createDeferrableTriggerCompartment();

	/**
	 * Returns a new object of class '<em>Region Shape</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Region Shape</em>'.
	 * @generated
	 */
	RegionShape createRegionShape();

	/**
	 * Returns a new object of class '<em>Subvertex Compartment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Subvertex Compartment</em>'.
	 * @generated
	 */
	SubvertexCompartment createSubvertexCompartment();

	/**
	 * Returns a new object of class '<em>Transition Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Transition Edge</em>'.
	 * @generated
	 */
	TransitionEdge createTransitionEdge();

	/**
	 * Returns a new object of class '<em>Control Flow Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Control Flow Edge</em>'.
	 * @generated
	 */
	ControlFlowEdge createControlFlowEdge();

	/**
	 * Returns a new object of class '<em>Activity Group Shape</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Activity Group Shape</em>'.
	 * @generated
	 */
	ActivityGroupShape createActivityGroupShape();

	/**
	 * Returns a new object of class '<em>Exception Handler Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Exception Handler Edge</em>'.
	 * @generated
	 */
	ExceptionHandlerEdge createExceptionHandlerEdge();

	/**
	 * Returns a new object of class '<em>Type Label</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Type Label</em>'.
	 * @generated
	 */
	TypeLabel createTypeLabel();

	/**
	 * Returns a new object of class '<em>Icon Label</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Icon Label</em>'.
	 * @generated
	 */
	IconLabel createIconLabel();

	/**
	 * Returns a new object of class '<em>Action Shape</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Action Shape</em>'.
	 * @generated
	 */
	ActionShape createActionShape();

	/**
	 * Returns a new object of class '<em>Pin Shape</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Pin Shape</em>'.
	 * @generated
	 */
	PinShape createPinShape();

	/**
	 * Returns a new object of class '<em>Subpartition Compartment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Subpartition Compartment</em>'.
	 * @generated
	 */
	SubpartitionCompartment createSubpartitionCompartment();

	/**
	 * Returns a new object of class '<em>Activity Partition Shape</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Activity Partition Shape</em>'.
	 * @generated
	 */
	ActivityPartitionShape createActivityPartitionShape();

	/**
	 * Returns a new object of class '<em>Structured Activity Node Shape</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Structured Activity Node Shape</em>'.
	 * @generated
	 */
	StructuredActivityNodeShape createStructuredActivityNodeShape();

	/**
	 * Returns a new object of class '<em>Expansion Region Shape</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Expansion Region Shape</em>'.
	 * @generated
	 */
	ExpansionRegionShape createExpansionRegionShape();

	/**
	 * Returns a new object of class '<em>Expansion Node Shape</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Expansion Node Shape</em>'.
	 * @generated
	 */
	ExpansionNodeShape createExpansionNodeShape();

	/**
	 * Returns a new object of class '<em>Lifeline Shape</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Lifeline Shape</em>'.
	 * @generated
	 */
	LifelineShape createLifelineShape();

	/**
	 * Returns a new object of class '<em>Execution Specification Shape</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Execution Specification Shape</em>'.
	 * @generated
	 */
	ExecutionSpecificationShape createExecutionSpecificationShape();

	/**
	 * Returns a new object of class '<em>Duration Constraint Shape</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Duration Constraint Shape</em>'.
	 * @generated
	 */
	DurationConstraintShape createDurationConstraintShape();

	/**
	 * Returns a new object of class '<em>Time Constraint Shape</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Time Constraint Shape</em>'.
	 * @generated
	 */
	TimeConstraintShape createTimeConstraintShape();

	/**
	 * Returns a new object of class '<em>Time Expression Shape</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Time Expression Shape</em>'.
	 * @generated
	 */
	TimeExpressionShape createTimeExpressionShape();

	/**
	 * Returns a new object of class '<em>Duration Shape</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Duration Shape</em>'.
	 * @generated
	 */
	DurationShape createDurationShape();

	/**
	 * Returns a new object of class '<em>Path Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Path Edge</em>'.
	 * @generated
	 */
	PathEdge createPathEdge();

	/**
	 * Returns a new object of class '<em>Message Label</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Message Label</em>'.
	 * @generated
	 */
	MessageLabel createMessageLabel();

	/**
	 * Returns a new object of class '<em>State Invariant Shape</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>State Invariant Shape</em>'.
	 * @generated
	 */
	StateInvariantShape createStateInvariantShape();

	/**
	 * Returns a new object of class '<em>Message Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Message Edge</em>'.
	 * @generated
	 */
	MessageEdge createMessageEdge();

	/**
	 * Returns a new object of class '<em>General Ordering Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>General Ordering Edge</em>'.
	 * @generated
	 */
	GeneralOrderingEdge createGeneralOrderingEdge();

	/**
	 * Returns a new object of class '<em>Combined Fragment Shape</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Combined Fragment Shape</em>'.
	 * @generated
	 */
	CombinedFragmentShape createCombinedFragmentShape();

	/**
	 * Returns a new object of class '<em>Interaction Use Shape</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Interaction Use Shape</em>'.
	 * @generated
	 */
	InteractionUseShape createInteractionUseShape();

	/**
	 * Returns a new object of class '<em>Interaction Operand Shape</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Interaction Operand Shape</em>'.
	 * @generated
	 */
	InteractionOperandShape createInteractionOperandShape();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the package supported by this factory.
	 * @generated
	 */
	UMLDIPackage getUMLDIPackage();
} //UMLDIFactory
