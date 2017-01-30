/**
 *   Copyright (c) 2016 CEA LIST and others.
 *   
 *   All rights reserved. This program and the accompanying materials
 *   are made available under the terms of the Eclipse Public License v1.0
 *   which accompanies this distribution, and is available at
 *   http://www.eclipse.org/legal/epl-v10.html
 *  
 *   Contributors:
 *     CEA LIST - Initial API and implementation
 * 
 */
package org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl;

import java.io.IOException;

import java.net.URL;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;

import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyFactory;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UMLRhapsodyPackageImpl extends EPackageImpl implements UMLRhapsodyPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected String packageFilename = "rhapsodymetamodel.ecore"; //$NON-NLS-1$

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass associationsTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cCollaborationChartEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgiActionStateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgiActiveXEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgiAnchorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgiAnnotationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgiArrowEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgiAssociationEndEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgiAssociationRoleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgiBasicClassEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgiBlockStateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgiBoxEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgiButtonArrayEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgiClassEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgiClassChartEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgiClassifierRoleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgiCompartmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgiComponentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgiCompositeClassEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgiConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgiContainArrowEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgiDiagramFrameEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgiFreeShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgiFreeTextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgiGenericElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgiImageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgiImageDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgiInformationFlowEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgiInheritanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgimfcCtrlEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgiMessageLabelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgiMscChartEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgiMscColumnCREClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgiMscConditionMarkEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgiMscExecutionOccurrenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgiMscInteractionOccurrenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgiMscInteractionOperandEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgiMscInteractionOperatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgiMscMessageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgiObjectInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgiObjectLinkEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgiPackageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgiPartitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgiPortConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgiStateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgiStateChartEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgiSwimlaneFrameEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgiTextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgiTextBoxEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgiTransEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass collEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compartmentsTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass componentsTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conveyedTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass declarativesTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass defaultSubsystemTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass defaultTransTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dependsOnTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass descriptionTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass elementsTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass embededFilesTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass end1_TypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass end2_TypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass filesTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fromLinkTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass graphElementsTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass graphicChartTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass hyperLinksTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iAcceptEventActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iAcceptTimeEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iActivityDiagramEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iActivityGraphEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iActorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iAnchorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iAnnotationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iArgumentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iAssociationClassEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iAssociationEndEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iAssociationEndHandleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iAssociationRoleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iAttributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iBlockEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iBodyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iBranchEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iCallActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iCallOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iClassEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iClassHandleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iClassInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iClassifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iClassifierRoleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iCodeGenConfigInfoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iCodeGenConfigInfoHandleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iCollaborationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iCollaborationDiagramEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iColorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iCombinedFragmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iCommentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iComponentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iComponentDiagramEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iComponentInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iConstructorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iContextSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iControlledFileEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iDefaultDrvdTransEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iDependencyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iDeploymentDiagramEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iDescriptionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iDestructorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iDiagramEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iEmbededFileEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iEnumerationLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iEventHandleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iEventReceptionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iExecutionOccurrenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iExternalHyperlinkEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iFileEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iFileFragmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iFlowEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iFlowItemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iFlowchartEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iFolderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iForkEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iGeneralizationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iGuardEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iHandleWithDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iHistoryConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iHyperLinkEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iInformationFlowEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iInformationItemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iInstanceSlotEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iInstanceSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iInstanceValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iInteractionOccurrenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iInteractionOperandEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iInteractionOperatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iInterfaceItemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iInterfaceItemTriggerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iInternalHyperlinkEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iLabelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iLinkEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iLinkInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iLiteralSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass imHyperLinkEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass imscEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iMatrixInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iMatrixLayoutEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iMatrixViewEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iMessageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iMessagePointEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iMetaLinkHandleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iModelElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iModuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iMultiplicityItemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iObjectLinkEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iObjectLinkHandleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iObjectModelDiagramEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iObjectNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iPackageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iPanelDiagramEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iPartEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iPinEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iPortEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iPrimitiveOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iProfileEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iProjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iPropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iPropertyContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iPropertyMetaclassEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iPropertySubjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iReceptionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iReferenceActivityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iRelationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iRequirementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iSendActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iSequenceDiagramEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iSlotEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iStateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iStateChartEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iStateChartDiagramEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iStateVertexEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iStereotypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iStructureDiagramEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iSubsystemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iSwimlaneEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iSysMLPortEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iTableInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iTableLayoutEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iTableViewEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iTagEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iTemplateInstEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iTemplateInstParamEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iTemplateInstantiationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iTemplateInstantiationParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iTemplateParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iTimeEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iTimeoutEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iTransitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iTriggerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iTriggeredEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iucDiagramEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iUseCaseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iUseCaseDiagramEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iUseCaseStereoTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iValueSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iVariableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inverseTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass itemsTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass itsLabelTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass itsStateChartTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass itsTargetTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass itsTriggerTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass linksTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass m_hTargetTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass m_pBaseTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass m_pFormalMessageTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass m_pModelObjectTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass m_pRootTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass m_subjectTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass matrixInstancesTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nestedStateChartTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass objectLinksTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operationsTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ownerHandleTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass p_MessageHandlerTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parentTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertiesTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tableDataDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tableInstancesTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass targetTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass theMainDiagramTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass toLinkTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass transitionsTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unknownTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass valueTypeEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private UMLRhapsodyPackageImpl() {
		super(eNS_URI, UMLRhapsodyFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link UMLRhapsodyPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @generated
	 */
	public static UMLRhapsodyPackage init() {
		if (isInited) return (UMLRhapsodyPackage)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI);

		// Obtain or create and register package
		UMLRhapsodyPackageImpl theUMLRhapsodyPackage = (UMLRhapsodyPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof UMLRhapsodyPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new UMLRhapsodyPackageImpl());

		isInited = true;

		// Load packages
		theUMLRhapsodyPackage.loadPackage();

		// Fix loaded packages
		theUMLRhapsodyPackage.fixPackageContents();

		// Mark meta-data to indicate it can't be changed
		theUMLRhapsodyPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(UMLRhapsodyPackage.eNS_URI, theUMLRhapsodyPackage);
		return theUMLRhapsodyPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAssociationsType() {
		if (associationsTypeEClass == null) {
			associationsTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(0);
		}
		return associationsTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCCollaborationChart() {
		if (cCollaborationChartEClass == null) {
			cCollaborationChartEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(1);
		}
		return cCollaborationChartEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCCollaborationChart_M_pModelObject() {
        return (EReference)getCCollaborationChart().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCCollaborationChart_M_pRoot() {
        return (EReference)getCCollaborationChart().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGIActionState() {
		if (cgiActionStateEClass == null) {
			cgiActionStateEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(2);
		}
		return cgiActionStateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIActionState_Properties() {
        return (EReference)getCGIActionState().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIActionState_M_pModelObject() {
        return (EReference)getCGIActionState().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIActionState_M_pParent() {
        return (EReference)getCGIActionState().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIActionState_M_transform() {
        return (EAttribute)getCGIActionState().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIActionState_M_AdditionalLabel() {
        return (EReference)getCGIActionState().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIActionState_M_polygon() {
        return (EAttribute)getCGIActionState().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIActionState_M_nNameFormat() {
        return (EAttribute)getCGIActionState().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIActionState_M_nIsNameFormat() {
        return (EAttribute)getCGIActionState().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIActionState_Compartments() {
        return (EReference)getCGIActionState().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIActionState_NAndLineCount() {
        return (EAttribute)getCGIActionState().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIActionState_M_pInheritsFrom() {
        return (EReference)getCGIActionState().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIActionState_M_nInheritanceMask() {
        return (EAttribute)getCGIActionState().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIActionState_M_pDefaultComponentRelation() {
        return (EAttribute)getCGIActionState().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIActionState_M_NameDisplayMode() {
        return (EAttribute)getCGIActionState().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIActionState_M_ActDescLablDiaplayMode() {
        return (EAttribute)getCGIActionState().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIActionState_M_moveAndLineTimeStamp() {
        return (EAttribute)getCGIActionState().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGIActiveX() {
		if (cgiActiveXEClass == null) {
			cgiActiveXEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(3);
		}
		return cgiActiveXEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIActiveX_Properties() {
        return (EReference)getCGIActiveX().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIActiveX_M_pModelObject() {
        return (EReference)getCGIActiveX().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIActiveX_M_pParent() {
        return (EReference)getCGIActiveX().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIActiveX_M_transform() {
        return (EAttribute)getCGIActiveX().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIActiveX_M_polygon() {
        return (EAttribute)getCGIActiveX().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIActiveX_M_nNameFormat() {
        return (EAttribute)getCGIActiveX().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIActiveX_M_nIsNameFormat() {
        return (EAttribute)getCGIActiveX().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIActiveX_Compartments() {
        return (EReference)getCGIActiveX().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIActiveX_M_csModelObjPath() {
        return (EAttribute)getCGIActiveX().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIActiveX_M_csName() {
        return (EAttribute)getCGIActiveX().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIActiveX_M_PartsArray() {
        return (EReference)getCGIActiveX().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGIAnchor() {
		if (cgiAnchorEClass == null) {
			cgiAnchorEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(4);
		}
		return cgiAnchorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIAnchor_M_pModelObject() {
        return (EReference)getCGIAnchor().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIAnchor_M_pParent() {
        return (EAttribute)getCGIAnchor().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIAnchor_M_pSource() {
        return (EReference)getCGIAnchor().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIAnchor_M_sourceType() {
        return (EAttribute)getCGIAnchor().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIAnchor_M_pTarget() {
        return (EReference)getCGIAnchor().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIAnchor_M_targetType() {
        return (EAttribute)getCGIAnchor().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIAnchor_M_direction() {
        return (EAttribute)getCGIAnchor().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIAnchor_M_rpn() {
        return (EReference)getCGIAnchor().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIAnchor_M_anglePoint1() {
        return (EAttribute)getCGIAnchor().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIAnchor_M_anglePoint2() {
        return (EAttribute)getCGIAnchor().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIAnchor_M_line_style() {
        return (EAttribute)getCGIAnchor().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIAnchor_M_SourcePort() {
        return (EAttribute)getCGIAnchor().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIAnchor_M_TargetPort() {
        return (EAttribute)getCGIAnchor().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIAnchor_Properties() {
        return (EReference)getCGIAnchor().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIAnchor_M_color() {
        return (EReference)getCGIAnchor().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIAnchor_M_lineWidth() {
        return (EAttribute)getCGIAnchor().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIAnchor_M_arrow() {
        return (EAttribute)getCGIAnchor().getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGIAnnotation() {
		if (cgiAnnotationEClass == null) {
			cgiAnnotationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(5);
		}
		return cgiAnnotationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIAnnotation_Properties() {
        return (EReference)getCGIAnnotation().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIAnnotation_M_pParent() {
        return (EReference)getCGIAnnotation().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIAnnotation_M_transform() {
        return (EAttribute)getCGIAnnotation().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIAnnotation_M_AdditionalLabel() {
        return (EReference)getCGIAnnotation().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIAnnotation_M_polygon() {
        return (EAttribute)getCGIAnnotation().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIAnnotation_M_nNameFormat() {
        return (EAttribute)getCGIAnnotation().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIAnnotation_M_nIsNameFormat() {
        return (EAttribute)getCGIAnnotation().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIAnnotation_ITempdisplayTextFlag() {
        return (EAttribute)getCGIAnnotation().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIAnnotation_M_bIsBoxStyle() {
        return (EAttribute)getCGIAnnotation().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIAnnotation_M_pModelObject() {
        return (EReference)getCGIAnnotation().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIAnnotation_M_color() {
        return (EReference)getCGIAnnotation().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIAnnotation_M_lineWidth() {
        return (EAttribute)getCGIAnnotation().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIAnnotation_Frameset() {
        return (EAttribute)getCGIAnnotation().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIAnnotation_Compartments() {
        return (EReference)getCGIAnnotation().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIAnnotation_M_bIsStructured() {
        return (EAttribute)getCGIAnnotation().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIAnnotation_M_bFramesetModified() {
        return (EAttribute)getCGIAnnotation().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGIArrow() {
		if (cgiArrowEClass == null) {
			cgiArrowEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(6);
		}
		return cgiArrowEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIArrow_M_pModelObject() {
        return (EReference)getCGIArrow().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIArrow_M_pParent() {
        return (EAttribute)getCGIArrow().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIArrow_M_pSource() {
        return (EReference)getCGIArrow().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIArrow_M_sourceType() {
        return (EAttribute)getCGIArrow().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIArrow_M_pTarget() {
        return (EReference)getCGIArrow().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIArrow_M_targetType() {
        return (EAttribute)getCGIArrow().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIArrow_M_direction() {
        return (EAttribute)getCGIArrow().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIArrow_M_rpn() {
        return (EReference)getCGIArrow().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIArrow_M_anglePoint1() {
        return (EAttribute)getCGIArrow().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIArrow_M_anglePoint2() {
        return (EAttribute)getCGIArrow().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIArrow_M_line_style() {
        return (EAttribute)getCGIArrow().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIArrow_M_SourcePort() {
        return (EAttribute)getCGIArrow().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIArrow_M_TargetPort() {
        return (EAttribute)getCGIArrow().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGIAssociationEnd() {
		if (cgiAssociationEndEClass == null) {
			cgiAssociationEndEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(7);
		}
		return cgiAssociationEndEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIAssociationEnd_Properties() {
        return (EReference)getCGIAssociationEnd().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIAssociationEnd_M_pModelObject() {
        return (EReference)getCGIAssociationEnd().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIAssociationEnd_M_pParent() {
        return (EAttribute)getCGIAssociationEnd().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIAssociationEnd_M_pSource() {
        return (EReference)getCGIAssociationEnd().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIAssociationEnd_M_sourceType() {
        return (EAttribute)getCGIAssociationEnd().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIAssociationEnd_M_pTarget() {
        return (EReference)getCGIAssociationEnd().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIAssociationEnd_M_targetType() {
        return (EAttribute)getCGIAssociationEnd().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIAssociationEnd_M_direction() {
        return (EAttribute)getCGIAssociationEnd().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIAssociationEnd_M_rpn() {
        return (EReference)getCGIAssociationEnd().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIAssociationEnd_M_anglePoint1() {
        return (EAttribute)getCGIAssociationEnd().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIAssociationEnd_M_anglePoint2() {
        return (EAttribute)getCGIAssociationEnd().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIAssociationEnd_M_line_style() {
        return (EAttribute)getCGIAssociationEnd().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIAssociationEnd_M_SourcePort() {
        return (EAttribute)getCGIAssociationEnd().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIAssociationEnd_M_TargetPort() {
        return (EAttribute)getCGIAssociationEnd().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIAssociationEnd_M_pInverseModelObject() {
        return (EReference)getCGIAssociationEnd().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIAssociationEnd_M_pInstance() {
        return (EReference)getCGIAssociationEnd().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIAssociationEnd_M_pInverseInstance() {
        return (EReference)getCGIAssociationEnd().getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIAssociationEnd_M_bShowSourceMultiplicity() {
        return (EAttribute)getCGIAssociationEnd().getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIAssociationEnd_M_bShowSourceRole() {
        return (EAttribute)getCGIAssociationEnd().getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIAssociationEnd_M_bShowTargetMultiplicity() {
        return (EAttribute)getCGIAssociationEnd().getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIAssociationEnd_M_bShowTargetRole() {
        return (EAttribute)getCGIAssociationEnd().getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIAssociationEnd_M_bShowLinkName() {
        return (EAttribute)getCGIAssociationEnd().getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIAssociationEnd_M_bShowSpecificType() {
        return (EAttribute)getCGIAssociationEnd().getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIAssociationEnd_M_bInstance() {
        return (EAttribute)getCGIAssociationEnd().getEStructuralFeatures().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIAssociationEnd_M_bShowQualifier1() {
        return (EAttribute)getCGIAssociationEnd().getEStructuralFeatures().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIAssociationEnd_M_bShowQualifier2() {
        return (EAttribute)getCGIAssociationEnd().getEStructuralFeatures().get(25);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIAssociationEnd_M_sourceRole() {
        return (EReference)getCGIAssociationEnd().getEStructuralFeatures().get(26);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIAssociationEnd_M_targetRole() {
        return (EReference)getCGIAssociationEnd().getEStructuralFeatures().get(27);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIAssociationEnd_M_sourceMultiplicity() {
        return (EReference)getCGIAssociationEnd().getEStructuralFeatures().get(28);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIAssociationEnd_M_targetMultiplicity() {
        return (EReference)getCGIAssociationEnd().getEStructuralFeatures().get(29);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIAssociationEnd_M_sourceQualifier() {
        return (EReference)getCGIAssociationEnd().getEStructuralFeatures().get(30);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIAssociationEnd_M_targetQualifier() {
        return (EReference)getCGIAssociationEnd().getEStructuralFeatures().get(31);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIAssociationEnd_M_specificType() {
        return (EAttribute)getCGIAssociationEnd().getEStructuralFeatures().get(32);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIAssociationEnd_M_arrow() {
        return (EAttribute)getCGIAssociationEnd().getEStructuralFeatures().get(33);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGIAssociationRole() {
		if (cgiAssociationRoleEClass == null) {
			cgiAssociationRoleEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(8);
		}
		return cgiAssociationRoleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIAssociationRole_M_pModelObject() {
        return (EReference)getCGIAssociationRole().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIAssociationRole_M_pParent() {
        return (EAttribute)getCGIAssociationRole().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIAssociationRole_M_pSource() {
        return (EReference)getCGIAssociationRole().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIAssociationRole_M_sourceType() {
        return (EAttribute)getCGIAssociationRole().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIAssociationRole_M_pTarget() {
        return (EReference)getCGIAssociationRole().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIAssociationRole_M_targetType() {
        return (EAttribute)getCGIAssociationRole().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIAssociationRole_M_direction() {
        return (EAttribute)getCGIAssociationRole().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIAssociationRole_M_rpn() {
        return (EReference)getCGIAssociationRole().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIAssociationRole_M_anglePoint1() {
        return (EAttribute)getCGIAssociationRole().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIAssociationRole_M_anglePoint2() {
        return (EAttribute)getCGIAssociationRole().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIAssociationRole_M_line_style() {
        return (EAttribute)getCGIAssociationRole().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIAssociationRole_M_SourcePort() {
        return (EAttribute)getCGIAssociationRole().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIAssociationRole_M_TargetPort() {
        return (EAttribute)getCGIAssociationRole().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIAssociationRole_M_arrow() {
        return (EAttribute)getCGIAssociationRole().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIAssociationRole_Properties() {
        return (EReference)getCGIAssociationRole().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGIBasicClass() {
		if (cgiBasicClassEClass == null) {
			cgiBasicClassEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(9);
		}
		return cgiBasicClassEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIBasicClass_M_pModelObject() {
        return (EReference)getCGIBasicClass().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIBasicClass_M_pParent() {
        return (EReference)getCGIBasicClass().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIBasicClass_M_transform() {
        return (EAttribute)getCGIBasicClass().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIBasicClass_M_AdditionalLabel() {
        return (EReference)getCGIBasicClass().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIBasicClass_M_polygon() {
        return (EAttribute)getCGIBasicClass().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIBasicClass_M_nNameFormat() {
        return (EAttribute)getCGIBasicClass().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIBasicClass_M_nIsNameFormat() {
        return (EAttribute)getCGIBasicClass().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIBasicClass_Compartments() {
        return (EReference)getCGIBasicClass().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIBasicClass_Properties() {
        return (EReference)getCGIBasicClass().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIBasicClass_M_pImageViewData() {
        return (EReference)getCGIBasicClass().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGIBlockState() {
		if (cgiBlockStateEClass == null) {
			cgiBlockStateEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(10);
		}
		return cgiBlockStateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIBlockState_M_pModelObject() {
        return (EReference)getCGIBlockState().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIBlockState_M_pParent() {
        return (EReference)getCGIBlockState().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIBlockState_M_transform() {
        return (EAttribute)getCGIBlockState().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIBlockState_M_polygon() {
        return (EAttribute)getCGIBlockState().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIBlockState_M_nNameFormat() {
        return (EAttribute)getCGIBlockState().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIBlockState_M_nIsNameFormat() {
        return (EAttribute)getCGIBlockState().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIBlockState_NAndLineCount() {
        return (EAttribute)getCGIBlockState().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIBlockState_M_pInheritsFrom() {
        return (EReference)getCGIBlockState().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIBlockState_M_nInheritanceMask() {
        return (EAttribute)getCGIBlockState().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIBlockState_M_pDefaultComponentRelation() {
        return (EAttribute)getCGIBlockState().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIBlockState_M_NameDisplayMode() {
        return (EAttribute)getCGIBlockState().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIBlockState_M_ActDescLablDiaplayMode() {
        return (EAttribute)getCGIBlockState().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIBlockState_Properties() {
        return (EReference)getCGIBlockState().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIBlockState_M_AdditionalLabel() {
        return (EReference)getCGIBlockState().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIBlockState_M_moveAndLineTimeStamp() {
        return (EAttribute)getCGIBlockState().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIBlockState_Compartments() {
        return (EReference)getCGIBlockState().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIBlockState_Frameset() {
        return (EAttribute)getCGIBlockState().getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGIBox() {
		if (cgiBoxEClass == null) {
			cgiBoxEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(11);
		}
		return cgiBoxEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIBox_M_pModelObject() {
        return (EReference)getCGIBox().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIBox_M_polygon() {
        return (EAttribute)getCGIBox().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIBox_M_nNameFormat() {
        return (EAttribute)getCGIBox().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIBox_M_nIsNameFormat() {
        return (EAttribute)getCGIBox().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIBox_Compartments() {
        return (EReference)getCGIBox().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIBox_M_pParent() {
        return (EReference)getCGIBox().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIBox_M_transform() {
        return (EAttribute)getCGIBox().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIBox_Properties() {
        return (EReference)getCGIBox().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGIButtonArray() {
		if (cgiButtonArrayEClass == null) {
			cgiButtonArrayEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(12);
		}
		return cgiButtonArrayEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIButtonArray_Properties() {
        return (EReference)getCGIButtonArray().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIButtonArray_M_pModelObject() {
        return (EReference)getCGIButtonArray().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIButtonArray_M_pParent() {
        return (EReference)getCGIButtonArray().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIButtonArray_M_transform() {
        return (EAttribute)getCGIButtonArray().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIButtonArray_M_polygon() {
        return (EAttribute)getCGIButtonArray().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIButtonArray_M_nNameFormat() {
        return (EAttribute)getCGIButtonArray().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIButtonArray_M_nIsNameFormat() {
        return (EAttribute)getCGIButtonArray().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIButtonArray_Frameset() {
        return (EAttribute)getCGIButtonArray().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIButtonArray_Compartments() {
        return (EReference)getCGIButtonArray().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIButtonArray_M_csModelObjPath() {
        return (EAttribute)getCGIButtonArray().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIButtonArray_M_csName() {
        return (EAttribute)getCGIButtonArray().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIButtonArray_M_PartsArray() {
        return (EReference)getCGIButtonArray().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIButtonArray_M_liButtonNames() {
        return (EAttribute)getCGIButtonArray().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIButtonArray_M_liButtonValues() {
        return (EAttribute)getCGIButtonArray().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGIClass() {
		if (cgiClassEClass == null) {
			cgiClassEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(13);
		}
		return cgiClassEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIClass_M_pModelObject() {
        return (EReference)getCGIClass().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIClass_M_AdditionalLabel() {
        return (EReference)getCGIClass().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIClass_M_polygon() {
        return (EAttribute)getCGIClass().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIClass_M_nNameFormat() {
        return (EAttribute)getCGIClass().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIClass_M_nIsNameFormat() {
        return (EAttribute)getCGIClass().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIClass_Compartments() {
        return (EReference)getCGIClass().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIClass_M_pParent() {
        return (EReference)getCGIClass().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIClass_M_transform() {
        return (EAttribute)getCGIClass().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIClass_Frameset() {
        return (EAttribute)getCGIClass().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIClass_Properties() {
        return (EReference)getCGIClass().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIClass_Attrs() {
        return (EReference)getCGIClass().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIClass_Operations() {
        return (EReference)getCGIClass().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIClass_M_color() {
        return (EReference)getCGIClass().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIClass_M_lineWidth() {
        return (EAttribute)getCGIClass().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIClass_M_dSeparatorPosition() {
        return (EAttribute)getCGIClass().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIClass_M_bIsMisplaced() {
        return (EAttribute)getCGIClass().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIClass_M_pImageViewData() {
        return (EReference)getCGIClass().getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIClass_M_bFramesetModified() {
        return (EAttribute)getCGIClass().getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGIClassChart() {
		if (cgiClassChartEClass == null) {
			cgiClassChartEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(14);
		}
		return cgiClassChartEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIClassChart_M_pModelObject() {
        return (EReference)getCGIClassChart().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIClassChart_M_pRoot() {
        return (EReference)getCGIClassChart().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGIClassifierRole() {
		if (cgiClassifierRoleEClass == null) {
			cgiClassifierRoleEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(15);
		}
		return cgiClassifierRoleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIClassifierRole_M_pModelObject() {
        return (EReference)getCGIClassifierRole().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIClassifierRole_M_pParent() {
        return (EReference)getCGIClassifierRole().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIClassifierRole_M_transform() {
        return (EAttribute)getCGIClassifierRole().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIClassifierRole_M_polygon() {
        return (EAttribute)getCGIClassifierRole().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIClassifierRole_M_nNameFormat() {
        return (EAttribute)getCGIClassifierRole().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIClassifierRole_M_nIsNameFormat() {
        return (EAttribute)getCGIClassifierRole().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIClassifierRole_Compartments() {
        return (EReference)getCGIClassifierRole().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIClassifierRole_Properties() {
        return (EReference)getCGIClassifierRole().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGICompartment() {
		if (cgiCompartmentEClass == null) {
			cgiCompartmentEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(16);
		}
		return cgiCompartmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGICompartment_Id() {
        return (EAttribute)getCGICompartment().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGICompartment_M_name() {
        return (EAttribute)getCGICompartment().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGICompartment_M_displayOption() {
        return (EAttribute)getCGICompartment().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGICompartment_M_bShowInherited() {
        return (EAttribute)getCGICompartment().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGICompartment_M_bOrdered() {
        return (EAttribute)getCGICompartment().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGICompartment_Items() {
        return (EReference)getCGICompartment().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGIComponent() {
		if (cgiComponentEClass == null) {
			cgiComponentEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(17);
		}
		return cgiComponentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIComponent_M_pModelObject() {
        return (EReference)getCGIComponent().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIComponent_M_pParent() {
        return (EReference)getCGIComponent().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIComponent_M_transform() {
        return (EAttribute)getCGIComponent().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIComponent_M_polygon() {
        return (EAttribute)getCGIComponent().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIComponent_M_nNameFormat() {
        return (EAttribute)getCGIComponent().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIComponent_M_nIsNameFormat() {
        return (EAttribute)getCGIComponent().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIComponent_Compartments() {
        return (EReference)getCGIComponent().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIComponent_Properties() {
        return (EReference)getCGIComponent().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIComponent_M_AdditionalLabel() {
        return (EReference)getCGIComponent().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGICompositeClass() {
		if (cgiCompositeClassEClass == null) {
			cgiCompositeClassEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(18);
		}
		return cgiCompositeClassEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGICompositeClass_M_pModelObject() {
        return (EReference)getCGICompositeClass().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGICompositeClass_M_pParent() {
        return (EAttribute)getCGICompositeClass().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGICompositeClass_M_AdditionalLabel() {
        return (EReference)getCGICompositeClass().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGICompositeClass_M_polygon() {
        return (EAttribute)getCGICompositeClass().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGICompositeClass_M_nNameFormat() {
        return (EAttribute)getCGICompositeClass().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGICompositeClass_M_nIsNameFormat() {
        return (EAttribute)getCGICompositeClass().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGICompositeClass_Compartments() {
        return (EReference)getCGICompositeClass().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGICompositeClass_Properties() {
        return (EReference)getCGICompositeClass().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGICompositeClass_M_color() {
        return (EReference)getCGICompositeClass().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGICompositeClass_M_lineWidth() {
        return (EAttribute)getCGICompositeClass().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGIConnector() {
		if (cgiConnectorEClass == null) {
			cgiConnectorEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(19);
		}
		return cgiConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIConnector_M_pModelObject() {
        return (EReference)getCGIConnector().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIConnector_M_pParent() {
        return (EReference)getCGIConnector().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIConnector_M_transform() {
        return (EAttribute)getCGIConnector().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIConnector_M_position() {
        return (EAttribute)getCGIConnector().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIConnector_M_nInheritanceMask() {
        return (EAttribute)getCGIConnector().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIConnector_M_SubType() {
        return (EAttribute)getCGIConnector().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIConnector_Properties() {
        return (EReference)getCGIConnector().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIConnector_M_AdditionalLabel() {
        return (EReference)getCGIConnector().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIConnector_MyState() {
        return (EAttribute)getCGIConnector().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIConnector_M_pInheritsFrom() {
        return (EReference)getCGIConnector().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGIContainArrow() {
		if (cgiContainArrowEClass == null) {
			cgiContainArrowEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(20);
		}
		return cgiContainArrowEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIContainArrow_M_pModelObject() {
        return (EReference)getCGIContainArrow().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIContainArrow_M_pParent() {
        return (EAttribute)getCGIContainArrow().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIContainArrow_M_pSource() {
        return (EReference)getCGIContainArrow().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIContainArrow_M_sourceType() {
        return (EAttribute)getCGIContainArrow().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIContainArrow_M_pTarget() {
        return (EReference)getCGIContainArrow().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIContainArrow_M_targetType() {
        return (EAttribute)getCGIContainArrow().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIContainArrow_M_direction() {
        return (EAttribute)getCGIContainArrow().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIContainArrow_M_rpn() {
        return (EReference)getCGIContainArrow().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIContainArrow_M_arrow() {
        return (EAttribute)getCGIContainArrow().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIContainArrow_M_anglePoint1() {
        return (EAttribute)getCGIContainArrow().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIContainArrow_M_anglePoint2() {
        return (EAttribute)getCGIContainArrow().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIContainArrow_M_line_style() {
        return (EAttribute)getCGIContainArrow().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIContainArrow_M_SourcePort() {
        return (EAttribute)getCGIContainArrow().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIContainArrow_M_TargetPort() {
        return (EAttribute)getCGIContainArrow().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGIDiagramFrame() {
		if (cgiDiagramFrameEClass == null) {
			cgiDiagramFrameEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(21);
		}
		return cgiDiagramFrameEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIDiagramFrame_M_pModelObject() {
        return (EReference)getCGIDiagramFrame().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIDiagramFrame_M_pParent() {
        return (EReference)getCGIDiagramFrame().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIDiagramFrame_M_transform() {
        return (EAttribute)getCGIDiagramFrame().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIDiagramFrame_M_AdditionalLabel() {
        return (EReference)getCGIDiagramFrame().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIDiagramFrame_M_polygon() {
        return (EAttribute)getCGIDiagramFrame().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIDiagramFrame_M_nNameFormat() {
        return (EAttribute)getCGIDiagramFrame().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIDiagramFrame_M_nIsNameFormat() {
        return (EAttribute)getCGIDiagramFrame().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIDiagramFrame_M_bVisible() {
        return (EAttribute)getCGIDiagramFrame().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIDiagramFrame_Frameset() {
        return (EAttribute)getCGIDiagramFrame().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIDiagramFrame_Compartments() {
        return (EReference)getCGIDiagramFrame().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGIFreeShape() {
		if (cgiFreeShapeEClass == null) {
			cgiFreeShapeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(22);
		}
		return cgiFreeShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIFreeShape_Properties() {
        return (EReference)getCGIFreeShape().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIFreeShape_M_pModelObject() {
        return (EReference)getCGIFreeShape().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIFreeShape_M_pParent() {
        return (EReference)getCGIFreeShape().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIFreeShape_M_transform() {
        return (EAttribute)getCGIFreeShape().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIFreeShape_M_points() {
        return (EAttribute)getCGIFreeShape().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGIFreeText() {
		if (cgiFreeTextEClass == null) {
			cgiFreeTextEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(23);
		}
		return cgiFreeTextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIFreeText_M_pModelObject() {
        return (EReference)getCGIFreeText().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIFreeText_M_pParent() {
        return (EReference)getCGIFreeText().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIFreeText_M_transform() {
        return (EAttribute)getCGIFreeText().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIFreeText_M_points() {
        return (EAttribute)getCGIFreeText().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIFreeText_M_text() {
        return (EAttribute)getCGIFreeText().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIFreeText_Properties() {
        return (EReference)getCGIFreeText().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGIGenericElement() {
		if (cgiGenericElementEClass == null) {
			cgiGenericElementEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(24);
		}
		return cgiGenericElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIGenericElement_M_pModelObject() {
        return (EReference)getCGIGenericElement().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIGenericElement_M_pParent() {
        return (EReference)getCGIGenericElement().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIGenericElement_M_transform() {
        return (EAttribute)getCGIGenericElement().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIGenericElement_M_AdditionalLabel() {
        return (EReference)getCGIGenericElement().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIGenericElement_M_polygon() {
        return (EAttribute)getCGIGenericElement().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIGenericElement_M_nNameFormat() {
        return (EAttribute)getCGIGenericElement().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIGenericElement_M_nIsNameFormat() {
        return (EAttribute)getCGIGenericElement().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIGenericElement_Frameset() {
        return (EAttribute)getCGIGenericElement().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIGenericElement_Compartments() {
        return (EReference)getCGIGenericElement().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIGenericElement_Properties() {
        return (EReference)getCGIGenericElement().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIGenericElement_M_pImageViewData() {
        return (EReference)getCGIGenericElement().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIGenericElement_M_csContext() {
        return (EAttribute)getCGIGenericElement().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIGenericElement_M_csPartsArray() {
        return (EAttribute)getCGIGenericElement().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIGenericElement_M_bIsStructured() {
        return (EAttribute)getCGIGenericElement().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGIImage() {
		if (cgiImageEClass == null) {
			cgiImageEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(25);
		}
		return cgiImageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIImage_M_pModelObject() {
        return (EReference)getCGIImage().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIImage_M_pParent() {
        return (EReference)getCGIImage().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIImage_M_transform() {
        return (EAttribute)getCGIImage().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIImage_M_pImageViewData() {
        return (EReference)getCGIImage().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIImage_M_points() {
        return (EAttribute)getCGIImage().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGIImageData() {
		if (cgiImageDataEClass == null) {
			cgiImageDataEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(26);
		}
		return cgiImageDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIImageData_M_pModelObject() {
        return (EReference)getCGIImageData().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIImageData_M_pParent() {
        return (EReference)getCGIImageData().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIImageData_M_dataSize() {
        return (EAttribute)getCGIImageData().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIImageData_M_data() {
        return (EAttribute)getCGIImageData().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIImageData_M_srcFile() {
        return (EAttribute)getCGIImageData().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIImageData_M_fileModifiedTime() {
        return (EAttribute)getCGIImageData().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGIInformationFlow() {
		if (cgiInformationFlowEClass == null) {
			cgiInformationFlowEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(27);
		}
		return cgiInformationFlowEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIInformationFlow_M_pModelObject() {
        return (EReference)getCGIInformationFlow().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIInformationFlow_M_pParent() {
        return (EAttribute)getCGIInformationFlow().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIInformationFlow_M_pSource() {
        return (EReference)getCGIInformationFlow().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIInformationFlow_M_sourceType() {
        return (EAttribute)getCGIInformationFlow().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIInformationFlow_M_pTarget() {
        return (EReference)getCGIInformationFlow().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIInformationFlow_M_targetType() {
        return (EAttribute)getCGIInformationFlow().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIInformationFlow_M_direction() {
        return (EAttribute)getCGIInformationFlow().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIInformationFlow_M_rpn() {
        return (EReference)getCGIInformationFlow().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIInformationFlow_M_anglePoint1() {
        return (EAttribute)getCGIInformationFlow().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIInformationFlow_M_anglePoint2() {
        return (EAttribute)getCGIInformationFlow().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIInformationFlow_M_line_style() {
        return (EAttribute)getCGIInformationFlow().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIInformationFlow_M_SourcePort() {
        return (EAttribute)getCGIInformationFlow().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIInformationFlow_M_TargetPort() {
        return (EAttribute)getCGIInformationFlow().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIInformationFlow_M_bShowKeyword() {
        return (EAttribute)getCGIInformationFlow().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIInformationFlow_M_showConveyed() {
        return (EAttribute)getCGIInformationFlow().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIInformationFlow_M_keyword() {
        return (EReference)getCGIInformationFlow().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIInformationFlow_M_conveyed() {
        return (EReference)getCGIInformationFlow().getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIInformationFlow_M_arrow() {
        return (EAttribute)getCGIInformationFlow().getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIInformationFlow_Properties() {
        return (EReference)getCGIInformationFlow().getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGIInheritance() {
		if (cgiInheritanceEClass == null) {
			cgiInheritanceEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(28);
		}
		return cgiInheritanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIInheritance_M_pModelObject() {
        return (EReference)getCGIInheritance().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIInheritance_M_pParent() {
        return (EAttribute)getCGIInheritance().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIInheritance_M_pSource() {
        return (EReference)getCGIInheritance().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIInheritance_M_sourceType() {
        return (EAttribute)getCGIInheritance().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIInheritance_M_pTarget() {
        return (EReference)getCGIInheritance().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIInheritance_M_targetType() {
        return (EAttribute)getCGIInheritance().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIInheritance_M_direction() {
        return (EAttribute)getCGIInheritance().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIInheritance_M_rpn() {
        return (EReference)getCGIInheritance().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIInheritance_M_anglePoint1() {
        return (EAttribute)getCGIInheritance().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIInheritance_M_anglePoint2() {
        return (EAttribute)getCGIInheritance().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIInheritance_M_line_style() {
        return (EAttribute)getCGIInheritance().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIInheritance_M_SourcePort() {
        return (EAttribute)getCGIInheritance().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIInheritance_M_TargetPort() {
        return (EAttribute)getCGIInheritance().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIInheritance_M_ShowName() {
        return (EAttribute)getCGIInheritance().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIInheritance_M_ShowStereotype() {
        return (EAttribute)getCGIInheritance().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIInheritance_Properties() {
        return (EReference)getCGIInheritance().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIInheritance_M_color() {
        return (EReference)getCGIInheritance().getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIInheritance_M_lineWidth() {
        return (EAttribute)getCGIInheritance().getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIInheritance_M_arrow() {
        return (EAttribute)getCGIInheritance().getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGIMFCCtrl() {
		if (cgimfcCtrlEClass == null) {
			cgimfcCtrlEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(29);
		}
		return cgimfcCtrlEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIMFCCtrl_Properties() {
        return (EReference)getCGIMFCCtrl().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIMFCCtrl_M_pModelObject() {
        return (EReference)getCGIMFCCtrl().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIMFCCtrl_M_pParent() {
        return (EReference)getCGIMFCCtrl().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIMFCCtrl_M_transform() {
        return (EAttribute)getCGIMFCCtrl().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIMFCCtrl_M_polygon() {
        return (EAttribute)getCGIMFCCtrl().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIMFCCtrl_M_nNameFormat() {
        return (EAttribute)getCGIMFCCtrl().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIMFCCtrl_M_nIsNameFormat() {
        return (EAttribute)getCGIMFCCtrl().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIMFCCtrl_Compartments() {
        return (EReference)getCGIMFCCtrl().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIMFCCtrl_M_csModelObjPath() {
        return (EAttribute)getCGIMFCCtrl().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIMFCCtrl_M_csName() {
        return (EAttribute)getCGIMFCCtrl().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIMFCCtrl_M_PartsArray() {
        return (EReference)getCGIMFCCtrl().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIMFCCtrl_M_csButtonCaption() {
        return (EAttribute)getCGIMFCCtrl().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGIMessageLabel() {
		if (cgiMessageLabelEClass == null) {
			cgiMessageLabelEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(30);
		}
		return cgiMessageLabelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIMessageLabel_M_pModelObject() {
        return (EReference)getCGIMessageLabel().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIMessageLabel_M_pParent() {
        return (EAttribute)getCGIMessageLabel().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIMessageLabel_M_pCommunicationConnection() {
        return (EReference)getCGIMessageLabel().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIMessageLabel_Percent() {
        return (EAttribute)getCGIMessageLabel().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGIMscChart() {
		if (cgiMscChartEClass == null) {
			cgiMscChartEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(31);
		}
		return cgiMscChartEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIMscChart_VLadderMargin() {
        return (EAttribute)getCGIMscChart().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIMscChart_M_usingActivationBar() {
        return (EAttribute)getCGIMscChart().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIMscChart_Id() {
        return (EAttribute)getCGIMscChart().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIMscChart_M_type() {
        return (EAttribute)getCGIMscChart().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIMscChart_M_pModelObject() {
        return (EReference)getCGIMscChart().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIMscChart_M_pParent() {
        return (EAttribute)getCGIMscChart().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIMscChart_M_name() {
        return (EReference)getCGIMscChart().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIMscChart_M_drawBehavior() {
        return (EAttribute)getCGIMscChart().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIMscChart_M_bIsPreferencesInitialized() {
        return (EAttribute)getCGIMscChart().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIMscChart_ElementList() {
        return (EAttribute)getCGIMscChart().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIMscChart_GraphElements() {
        return (EReference)getCGIMscChart().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIMscChart_M_access() {
        return (EAttribute)getCGIMscChart().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIMscChart_M_modified() {
        return (EAttribute)getCGIMscChart().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIMscChart_M_fileVersion() {
        return (EAttribute)getCGIMscChart().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIMscChart_M_nModifyDate() {
        return (EAttribute)getCGIMscChart().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIMscChart_M_nCreateDate() {
        return (EAttribute)getCGIMscChart().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIMscChart_M_creator() {
        return (EAttribute)getCGIMscChart().getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIMscChart_M_bScaleWithZoom() {
        return (EAttribute)getCGIMscChart().getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIMscChart_M_arrowStyle() {
        return (EAttribute)getCGIMscChart().getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIMscChart_M_pRoot() {
        return (EReference)getCGIMscChart().getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIMscChart_M_currentLeftTop() {
        return (EAttribute)getCGIMscChart().getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIMscChart_M_currentRightBottom() {
        return (EAttribute)getCGIMscChart().getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGIMscColumnCR() {
		if (cgiMscColumnCREClass == null) {
			cgiMscColumnCREClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(32);
		}
		return cgiMscColumnCREClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIMscColumnCR_M_pModelObject() {
        return (EReference)getCGIMscColumnCR().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIMscColumnCR_M_pParent() {
        return (EReference)getCGIMscColumnCR().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIMscColumnCR_M_transform() {
        return (EAttribute)getCGIMscColumnCR().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIMscColumnCR_M_AdditionalLabel() {
        return (EReference)getCGIMscColumnCR().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIMscColumnCR_M_position() {
        return (EAttribute)getCGIMscColumnCR().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIMscColumnCR_M_pInheritsFrom() {
        return (EReference)getCGIMscColumnCR().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIMscColumnCR_M_nInheritanceMask() {
        return (EAttribute)getCGIMscColumnCR().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIMscColumnCR_M_SubType() {
        return (EAttribute)getCGIMscColumnCR().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIMscColumnCR_Properties() {
        return (EReference)getCGIMscColumnCR().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGIMscConditionMark() {
		if (cgiMscConditionMarkEClass == null) {
			cgiMscConditionMarkEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(33);
		}
		return cgiMscConditionMarkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIMscConditionMark_Properties() {
        return (EReference)getCGIMscConditionMark().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIMscConditionMark_M_pModelObject() {
        return (EReference)getCGIMscConditionMark().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIMscConditionMark_M_pParent() {
        return (EReference)getCGIMscConditionMark().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIMscConditionMark_M_transform() {
        return (EAttribute)getCGIMscConditionMark().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIMscConditionMark_M_polygon() {
        return (EAttribute)getCGIMscConditionMark().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIMscConditionMark_M_nNameFormat() {
        return (EAttribute)getCGIMscConditionMark().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIMscConditionMark_M_nIsNameFormat() {
        return (EAttribute)getCGIMscConditionMark().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIMscConditionMark_Compartments() {
        return (EReference)getCGIMscConditionMark().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGIMscExecutionOccurrence() {
		if (cgiMscExecutionOccurrenceEClass == null) {
			cgiMscExecutionOccurrenceEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(34);
		}
		return cgiMscExecutionOccurrenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIMscExecutionOccurrence_M_pModelObject() {
        return (EReference)getCGIMscExecutionOccurrence().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIMscExecutionOccurrence_M_pParent() {
        return (EReference)getCGIMscExecutionOccurrence().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIMscExecutionOccurrence_M_transform() {
        return (EAttribute)getCGIMscExecutionOccurrence().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIMscExecutionOccurrence_M_position() {
        return (EAttribute)getCGIMscExecutionOccurrence().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIMscExecutionOccurrence_M_pInheritsFrom() {
        return (EReference)getCGIMscExecutionOccurrence().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIMscExecutionOccurrence_M_nInheritanceMask() {
        return (EAttribute)getCGIMscExecutionOccurrence().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIMscExecutionOccurrence_M_SubType() {
        return (EAttribute)getCGIMscExecutionOccurrence().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIMscExecutionOccurrence_M_pStartMessage() {
        return (EReference)getCGIMscExecutionOccurrence().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGIMscInteractionOccurrence() {
		if (cgiMscInteractionOccurrenceEClass == null) {
			cgiMscInteractionOccurrenceEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(35);
		}
		return cgiMscInteractionOccurrenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIMscInteractionOccurrence_M_pModelObject() {
        return (EReference)getCGIMscInteractionOccurrence().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIMscInteractionOccurrence_M_pParent() {
        return (EReference)getCGIMscInteractionOccurrence().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIMscInteractionOccurrence_M_transform() {
        return (EAttribute)getCGIMscInteractionOccurrence().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIMscInteractionOccurrence_M_polygon() {
        return (EAttribute)getCGIMscInteractionOccurrence().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIMscInteractionOccurrence_M_nNameFormat() {
        return (EAttribute)getCGIMscInteractionOccurrence().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIMscInteractionOccurrence_M_nIsNameFormat() {
        return (EAttribute)getCGIMscInteractionOccurrence().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIMscInteractionOccurrence_Compartments() {
        return (EReference)getCGIMscInteractionOccurrence().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIMscInteractionOccurrence_Properties() {
        return (EReference)getCGIMscInteractionOccurrence().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGIMscInteractionOperand() {
		if (cgiMscInteractionOperandEClass == null) {
			cgiMscInteractionOperandEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(36);
		}
		return cgiMscInteractionOperandEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIMscInteractionOperand_Properties() {
        return (EReference)getCGIMscInteractionOperand().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIMscInteractionOperand_M_pModelObject() {
        return (EReference)getCGIMscInteractionOperand().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIMscInteractionOperand_M_pParent() {
        return (EReference)getCGIMscInteractionOperand().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIMscInteractionOperand_M_AdditionalLabel() {
        return (EReference)getCGIMscInteractionOperand().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIMscInteractionOperand_M_polygon() {
        return (EAttribute)getCGIMscInteractionOperand().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIMscInteractionOperand_M_nNameFormat() {
        return (EAttribute)getCGIMscInteractionOperand().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIMscInteractionOperand_M_nIsNameFormat() {
        return (EAttribute)getCGIMscInteractionOperand().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIMscInteractionOperand_Compartments() {
        return (EReference)getCGIMscInteractionOperand().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIMscInteractionOperand_M_transform() {
        return (EAttribute)getCGIMscInteractionOperand().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGIMscInteractionOperator() {
		if (cgiMscInteractionOperatorEClass == null) {
			cgiMscInteractionOperatorEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(37);
		}
		return cgiMscInteractionOperatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIMscInteractionOperator_M_operatorType() {
        return (EAttribute)getCGIMscInteractionOperator().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIMscInteractionOperator_Properties() {
        return (EReference)getCGIMscInteractionOperator().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIMscInteractionOperator_M_pModelObject() {
        return (EReference)getCGIMscInteractionOperator().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIMscInteractionOperator_M_pParent() {
        return (EReference)getCGIMscInteractionOperator().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIMscInteractionOperator_M_transform() {
        return (EAttribute)getCGIMscInteractionOperator().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIMscInteractionOperator_M_polygon() {
        return (EAttribute)getCGIMscInteractionOperator().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIMscInteractionOperator_M_nNameFormat() {
        return (EAttribute)getCGIMscInteractionOperator().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIMscInteractionOperator_M_nIsNameFormat() {
        return (EAttribute)getCGIMscInteractionOperator().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIMscInteractionOperator_Frameset() {
        return (EAttribute)getCGIMscInteractionOperator().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIMscInteractionOperator_Compartments() {
        return (EReference)getCGIMscInteractionOperator().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIMscInteractionOperator_M_bFramesetModified() {
        return (EAttribute)getCGIMscInteractionOperator().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGIMscMessage() {
		if (cgiMscMessageEClass == null) {
			cgiMscMessageEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(38);
		}
		return cgiMscMessageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIMscMessage_M_pModelObject() {
        return (EReference)getCGIMscMessage().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIMscMessage_M_pParent() {
        return (EAttribute)getCGIMscMessage().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIMscMessage_M_pSource() {
        return (EReference)getCGIMscMessage().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIMscMessage_M_sourceType() {
        return (EAttribute)getCGIMscMessage().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIMscMessage_M_pTarget() {
        return (EReference)getCGIMscMessage().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIMscMessage_M_targetType() {
        return (EAttribute)getCGIMscMessage().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIMscMessage_M_direction() {
        return (EAttribute)getCGIMscMessage().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIMscMessage_M_rpn() {
        return (EReference)getCGIMscMessage().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIMscMessage_M_anglePoint1() {
        return (EAttribute)getCGIMscMessage().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIMscMessage_M_anglePoint2() {
        return (EAttribute)getCGIMscMessage().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIMscMessage_M_line_style() {
        return (EAttribute)getCGIMscMessage().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIMscMessage_M_SourcePort() {
        return (EAttribute)getCGIMscMessage().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIMscMessage_M_TargetPort() {
        return (EAttribute)getCGIMscMessage().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIMscMessage_M_bLeft() {
        return (EAttribute)getCGIMscMessage().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIMscMessage_M_arrow() {
        return (EAttribute)getCGIMscMessage().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIMscMessage_Properties() {
        return (EReference)getCGIMscMessage().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIMscMessage_MyState() {
        return (EAttribute)getCGIMscMessage().getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIMscMessage_M_pSourceExec() {
        return (EReference)getCGIMscMessage().getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIMscMessage_M_pTargetExec() {
        return (EReference)getCGIMscMessage().getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGIObjectInstance() {
		if (cgiObjectInstanceEClass == null) {
			cgiObjectInstanceEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(39);
		}
		return cgiObjectInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIObjectInstance_M_pModelObject() {
        return (EReference)getCGIObjectInstance().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIObjectInstance_M_pParent() {
        return (EReference)getCGIObjectInstance().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIObjectInstance_M_transform() {
        return (EAttribute)getCGIObjectInstance().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIObjectInstance_M_AdditionalLabel() {
        return (EReference)getCGIObjectInstance().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIObjectInstance_M_polygon() {
        return (EAttribute)getCGIObjectInstance().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIObjectInstance_M_nNameFormat() {
        return (EAttribute)getCGIObjectInstance().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIObjectInstance_M_nIsNameFormat() {
        return (EAttribute)getCGIObjectInstance().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIObjectInstance_Frameset() {
        return (EAttribute)getCGIObjectInstance().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIObjectInstance_Compartments() {
        return (EReference)getCGIObjectInstance().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIObjectInstance_M_multiplicity() {
        return (EReference)getCGIObjectInstance().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIObjectInstance_Properties() {
        return (EReference)getCGIObjectInstance().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIObjectInstance_Operations() {
        return (EReference)getCGIObjectInstance().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIObjectInstance_Attrs() {
        return (EReference)getCGIObjectInstance().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIObjectInstance_M_bFramesetModified() {
        return (EAttribute)getCGIObjectInstance().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIObjectInstance_M_pImageViewData() {
        return (EReference)getCGIObjectInstance().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIObjectInstance_M_bIsMisplaced() {
        return (EAttribute)getCGIObjectInstance().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGIObjectLink() {
		if (cgiObjectLinkEClass == null) {
			cgiObjectLinkEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(40);
		}
		return cgiObjectLinkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIObjectLink_Properties() {
        return (EReference)getCGIObjectLink().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIObjectLink_M_pModelObject() {
        return (EReference)getCGIObjectLink().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIObjectLink_M_pParent() {
        return (EAttribute)getCGIObjectLink().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIObjectLink_M_pSource() {
        return (EReference)getCGIObjectLink().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIObjectLink_M_sourceType() {
        return (EAttribute)getCGIObjectLink().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIObjectLink_M_pTarget() {
        return (EReference)getCGIObjectLink().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIObjectLink_M_targetType() {
        return (EAttribute)getCGIObjectLink().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIObjectLink_M_direction() {
        return (EAttribute)getCGIObjectLink().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIObjectLink_M_rpn() {
        return (EReference)getCGIObjectLink().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIObjectLink_M_arrow() {
        return (EAttribute)getCGIObjectLink().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIObjectLink_M_anglePoint1() {
        return (EAttribute)getCGIObjectLink().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIObjectLink_M_anglePoint2() {
        return (EAttribute)getCGIObjectLink().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIObjectLink_M_line_style() {
        return (EAttribute)getCGIObjectLink().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIObjectLink_M_SourcePort() {
        return (EAttribute)getCGIObjectLink().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIObjectLink_M_TargetPort() {
        return (EAttribute)getCGIObjectLink().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIObjectLink_M_bShowSourceMultiplicity() {
        return (EAttribute)getCGIObjectLink().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIObjectLink_M_bShowSourceRole() {
        return (EAttribute)getCGIObjectLink().getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIObjectLink_M_bShowTargetMultiplicity() {
        return (EAttribute)getCGIObjectLink().getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIObjectLink_M_bShowTargetRole() {
        return (EAttribute)getCGIObjectLink().getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIObjectLink_M_bShowLinkName() {
        return (EAttribute)getCGIObjectLink().getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIObjectLink_M_sourceRole() {
        return (EReference)getCGIObjectLink().getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIObjectLink_M_targetRole() {
        return (EReference)getCGIObjectLink().getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIObjectLink_M_sourceMultiplicity() {
        return (EReference)getCGIObjectLink().getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIObjectLink_M_targetMultiplicity() {
        return (EReference)getCGIObjectLink().getEStructuralFeatures().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGIPackage() {
		if (cgiPackageEClass == null) {
			cgiPackageEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(41);
		}
		return cgiPackageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIPackage_M_pModelObject() {
        return (EReference)getCGIPackage().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIPackage_M_pParent() {
        return (EReference)getCGIPackage().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIPackage_M_transform() {
        return (EAttribute)getCGIPackage().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIPackage_M_polygon() {
        return (EAttribute)getCGIPackage().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIPackage_M_nNameFormat() {
        return (EAttribute)getCGIPackage().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIPackage_M_nIsNameFormat() {
        return (EAttribute)getCGIPackage().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIPackage_Compartments() {
        return (EReference)getCGIPackage().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIPackage_Properties() {
        return (EReference)getCGIPackage().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIPackage_M_color() {
        return (EReference)getCGIPackage().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIPackage_M_lineWidth() {
        return (EAttribute)getCGIPackage().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIPackage_M_AdditionalLabel() {
        return (EReference)getCGIPackage().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIPackage_Frameset() {
        return (EAttribute)getCGIPackage().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIPackage_M_bIsStructured() {
        return (EAttribute)getCGIPackage().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGIPartition() {
		if (cgiPartitionEClass == null) {
			cgiPartitionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(42);
		}
		return cgiPartitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIPartition_M_pModelObject() {
        return (EReference)getCGIPartition().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIPartition_M_pParent() {
        return (EReference)getCGIPartition().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIPartition_M_polygon() {
        return (EAttribute)getCGIPartition().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIPartition_M_nNameFormat() {
        return (EAttribute)getCGIPartition().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIPartition_M_nIsNameFormat() {
        return (EAttribute)getCGIPartition().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIPartition_Frameset() {
        return (EAttribute)getCGIPartition().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIPartition_M_AdditionalLabel() {
        return (EReference)getCGIPartition().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIPartition_Properties() {
        return (EReference)getCGIPartition().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIPartition_Compartments() {
        return (EReference)getCGIPartition().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGIPortConnector() {
		if (cgiPortConnectorEClass == null) {
			cgiPortConnectorEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(43);
		}
		return cgiPortConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIPortConnector_M_pModelObject() {
        return (EReference)getCGIPortConnector().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIPortConnector_M_pParent() {
        return (EReference)getCGIPortConnector().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIPortConnector_M_transform() {
        return (EAttribute)getCGIPortConnector().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIPortConnector_M_AdditionalLabel() {
        return (EReference)getCGIPortConnector().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIPortConnector_M_position() {
        return (EAttribute)getCGIPortConnector().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIPortConnector_M_pInheritsFrom() {
        return (EReference)getCGIPortConnector().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIPortConnector_M_nInheritanceMask() {
        return (EAttribute)getCGIPortConnector().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIPortConnector_M_SubType() {
        return (EAttribute)getCGIPortConnector().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIPortConnector_M_providedInterfaceLabel() {
        return (EReference)getCGIPortConnector().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIPortConnector_M_requiredInterfaceLabel() {
        return (EReference)getCGIPortConnector().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIPortConnector_Properties() {
        return (EReference)getCGIPortConnector().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIPortConnector_M_bVisible() {
        return (EAttribute)getCGIPortConnector().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIPortConnector_M_nAngle() {
        return (EAttribute)getCGIPortConnector().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGIState() {
		if (cgiStateEClass == null) {
			cgiStateEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(44);
		}
		return cgiStateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIState_M_pModelObject() {
        return (EReference)getCGIState().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIState_M_AdditionalLabel() {
        return (EReference)getCGIState().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIState_M_polygon() {
        return (EAttribute)getCGIState().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIState_M_nNameFormat() {
        return (EAttribute)getCGIState().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIState_M_nIsNameFormat() {
        return (EAttribute)getCGIState().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIState_NAndLineCount() {
        return (EAttribute)getCGIState().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIState_M_nInheritanceMask() {
        return (EAttribute)getCGIState().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIState_M_pDefaultComponentRelation() {
        return (EAttribute)getCGIState().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIState_Properties() {
        return (EReference)getCGIState().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIState_M_pParent() {
        return (EReference)getCGIState().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIState_M_transform() {
        return (EAttribute)getCGIState().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIState_AndLinePoly() {
        return (EAttribute)getCGIState().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIState_M_pVirtualParent() {
        return (EReference)getCGIState().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIState_M_moveAndLineTimeStamp() {
        return (EAttribute)getCGIState().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIState_MyState() {
        return (EAttribute)getCGIState().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIState_M_pInheritsFrom() {
        return (EReference)getCGIState().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIState_Frameset() {
        return (EAttribute)getCGIState().getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIState_M_bFramesetModified() {
        return (EAttribute)getCGIState().getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIState_M_bIsMisplaced() {
        return (EAttribute)getCGIState().getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIState_M_color() {
        return (EReference)getCGIState().getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIState_M_lineWidth() {
        return (EAttribute)getCGIState().getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIState_Compartments() {
        return (EReference)getCGIState().getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGIStateChart() {
		if (cgiStateChartEClass == null) {
			cgiStateChartEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(45);
		}
		return cgiStateChartEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIStateChart_M_pModelObject() {
        return (EReference)getCGIStateChart().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIStateChart_M_pRoot() {
        return (EReference)getCGIStateChart().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIStateChart_MyState() {
        return (EAttribute)getCGIStateChart().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIStateChart_M_pInheritsFrom() {
        return (EReference)getCGIStateChart().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIStateChart_DiagramList() {
        return (EReference)getCGIStateChart().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIStateChart_Properties() {
        return (EReference)getCGIStateChart().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGISwimlaneFrame() {
		if (cgiSwimlaneFrameEClass == null) {
			cgiSwimlaneFrameEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(46);
		}
		return cgiSwimlaneFrameEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGISwimlaneFrame_M_pModelObject() {
        return (EReference)getCGISwimlaneFrame().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGISwimlaneFrame_M_pParent() {
        return (EReference)getCGISwimlaneFrame().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGISwimlaneFrame_M_polygon() {
        return (EAttribute)getCGISwimlaneFrame().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGISwimlaneFrame_M_nNameFormat() {
        return (EAttribute)getCGISwimlaneFrame().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGISwimlaneFrame_M_nIsNameFormat() {
        return (EAttribute)getCGISwimlaneFrame().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGISwimlaneFrame_Frameset() {
        return (EAttribute)getCGISwimlaneFrame().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGISwimlaneFrame_M_transform() {
        return (EAttribute)getCGISwimlaneFrame().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGISwimlaneFrame_M_bFramesetModified() {
        return (EAttribute)getCGISwimlaneFrame().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGISwimlaneFrame_Compartments() {
        return (EReference)getCGISwimlaneFrame().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGIText() {
		if (cgiTextEClass == null) {
			cgiTextEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(47);
		}
		return cgiTextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIText_M_str() {
        return (EAttribute)getCGIText().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIText_M_style() {
        return (EAttribute)getCGIText().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGIText_M_color() {
        return (EReference)getCGIText().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIText_M_position() {
        return (EAttribute)getCGIText().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIText_M_nIdent() {
        return (EAttribute)getCGIText().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIText_M_bImplicitSetRectPoints() {
        return (EAttribute)getCGIText().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIText_M_nOrientationCtrlPt() {
        return (EAttribute)getCGIText().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIText_M_nVerticalSpacing() {
        return (EAttribute)getCGIText().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIText_M_nHorizontalSpacing() {
        return (EAttribute)getCGIText().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGIText_M_transform() {
        return (EAttribute)getCGIText().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGITextBox() {
		if (cgiTextBoxEClass == null) {
			cgiTextBoxEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(48);
		}
		return cgiTextBoxEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGITextBox_Properties() {
        return (EReference)getCGITextBox().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGITextBox_M_pModelObject() {
        return (EReference)getCGITextBox().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGITextBox_M_pParent() {
        return (EReference)getCGITextBox().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGITextBox_M_transform() {
        return (EAttribute)getCGITextBox().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGITextBox_M_polygon() {
        return (EAttribute)getCGITextBox().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGITextBox_M_nNameFormat() {
        return (EAttribute)getCGITextBox().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGITextBox_M_nIsNameFormat() {
        return (EAttribute)getCGITextBox().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGITextBox_Compartments() {
        return (EReference)getCGITextBox().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGITextBox_M_csModelObjPath() {
        return (EAttribute)getCGITextBox().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGITextBox_M_csName() {
        return (EAttribute)getCGITextBox().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGITextBox_M_PartsArray() {
        return (EReference)getCGITextBox().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGITrans() {
		if (cgiTransEClass == null) {
			cgiTransEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(49);
		}
		return cgiTransEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGITrans_Properties() {
        return (EReference)getCGITrans().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGITrans_M_pModelObject() {
        return (EReference)getCGITrans().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGITrans_M_pParent() {
        return (EAttribute)getCGITrans().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGITrans_M_pSource() {
        return (EReference)getCGITrans().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGITrans_M_sourceType() {
        return (EAttribute)getCGITrans().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGITrans_M_pTarget() {
        return (EReference)getCGITrans().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGITrans_M_targetType() {
        return (EAttribute)getCGITrans().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGITrans_M_direction() {
        return (EAttribute)getCGITrans().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGITrans_M_rpn() {
        return (EReference)getCGITrans().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGITrans_M_anglePoint1() {
        return (EAttribute)getCGITrans().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGITrans_M_anglePoint2() {
        return (EAttribute)getCGITrans().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGITrans_M_line_style() {
        return (EAttribute)getCGITrans().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGITrans_M_SourcePort() {
        return (EAttribute)getCGITrans().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGITrans_M_TargetPort() {
        return (EAttribute)getCGITrans().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGITrans_M_nInheritanceMask() {
        return (EAttribute)getCGITrans().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGITrans_M_bShowName() {
        return (EAttribute)getCGITrans().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGITrans_M_arrow() {
        return (EAttribute)getCGITrans().getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGITrans_MyState() {
        return (EAttribute)getCGITrans().getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGITrans_M_pInheritsFrom() {
        return (EReference)getCGITrans().getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCGITrans_M_color() {
        return (EReference)getCGITrans().getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCGITrans_M_lineWidth() {
        return (EAttribute)getCGITrans().getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCollEvent() {
		if (collEventEClass == null) {
			collEventEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(50);
		}
		return collEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCollEvent_Id() {
        return (EAttribute)getCollEvent().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCollEvent_First() {
        return (EAttribute)getCollEvent().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollEvent_Second() {
        return (EReference)getCollEvent().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCollEvent_ObjectCreation() {
        return (EAttribute)getCollEvent().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCollEvent_UmlDependencyID() {
        return (EAttribute)getCollEvent().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompartmentsType() {
		if (compartmentsTypeEClass == null) {
			compartmentsTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(51);
		}
		return compartmentsTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComponentsType() {
		if (componentsTypeEClass == null) {
			componentsTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(52);
		}
		return componentsTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConveyedType() {
		if (conveyedTypeEClass == null) {
			conveyedTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(53);
		}
		return conveyedTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConveyedType_LastID() {
        return (EAttribute)getConveyedType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeclarativesType() {
		if (declarativesTypeEClass == null) {
			declarativesTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(54);
		}
		return declarativesTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDefaultSubsystemType() {
		if (defaultSubsystemTypeEClass == null) {
			defaultSubsystemTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(55);
		}
		return defaultSubsystemTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDefaultTransType() {
		if (defaultTransTypeEClass == null) {
			defaultTransTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(56);
		}
		return defaultTransTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDependsOnType() {
		if (dependsOnTypeEClass == null) {
			dependsOnTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(57);
		}
		return dependsOnTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDescriptionType() {
		if (descriptionTypeEClass == null) {
			descriptionTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(58);
		}
		return descriptionTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getElementsType() {
		if (elementsTypeEClass == null) {
			elementsTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(59);
		}
		return elementsTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEmbededFilesType() {
		if (embededFilesTypeEClass == null) {
			embededFilesTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(60);
		}
		return embededFilesTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnd1_Type() {
		if (end1_TypeEClass == null) {
			end1_TypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(61);
		}
		return end1_TypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnd2_Type() {
		if (end2_TypeEClass == null) {
			end2_TypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(62);
		}
		return end2_TypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnd2_Type_Multiplicity() {
        return (EAttribute)getEnd2_Type().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFilesType() {
		if (filesTypeEClass == null) {
			filesTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(63);
		}
		return filesTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFilesType_ModifiedTimeWeak() {
        return (EAttribute)getFilesType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFilesType_Id() {
        return (EAttribute)getFilesType().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFilesType_UmlDependencyID() {
        return (EAttribute)getFilesType().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFilesType_LastID() {
        return (EAttribute)getFilesType().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFilesType_MyState() {
        return (EAttribute)getFilesType().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFilesType_M_path() {
        return (EAttribute)getFilesType().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFilesType_ObjectCreation() {
        return (EAttribute)getFilesType().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFilesType_Name() {
        return (EAttribute)getFilesType().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFromLinkType() {
		if (fromLinkTypeEClass == null) {
			fromLinkTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(64);
		}
		return fromLinkTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGraphElementsType() {
		if (graphElementsTypeEClass == null) {
			graphElementsTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(65);
		}
		return graphElementsTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGraphElementsType_Id() {
        return (EAttribute)getGraphElementsType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGraphElementsType_M_drawBehavior() {
        return (EAttribute)getGraphElementsType().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGraphElementsType_M_type() {
        return (EAttribute)getGraphElementsType().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGraphElementsType_M_name() {
        return (EReference)getGraphElementsType().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGraphElementsType_M_bIsPreferencesInitialized() {
        return (EAttribute)getGraphElementsType().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGraphicChartType() {
		if (graphicChartTypeEClass == null) {
			graphicChartTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(66);
		}
		return graphicChartTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGraphicChartType_Id() {
        return (EAttribute)getGraphicChartType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGraphicChartType_M_access() {
        return (EAttribute)getGraphicChartType().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGraphicChartType_ElementList() {
        return (EAttribute)getGraphicChartType().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGraphicChartType_M_nModifyDate() {
        return (EAttribute)getGraphicChartType().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGraphicChartType_M_currentLeftTop() {
        return (EAttribute)getGraphicChartType().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGraphicChartType_M_modified() {
        return (EAttribute)getGraphicChartType().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGraphicChartType_M_nCreateDate() {
        return (EAttribute)getGraphicChartType().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGraphicChartType_M_pParent() {
        return (EAttribute)getGraphicChartType().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGraphicChartType_M_arrowStyle() {
        return (EAttribute)getGraphicChartType().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGraphicChartType_M_drawBehavior() {
        return (EAttribute)getGraphicChartType().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGraphicChartType_M_currentRightBottom() {
        return (EAttribute)getGraphicChartType().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGraphicChartType_M_creator() {
        return (EAttribute)getGraphicChartType().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGraphicChartType_M_bScaleWithZoom() {
        return (EAttribute)getGraphicChartType().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGraphicChartType_M_type() {
        return (EAttribute)getGraphicChartType().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGraphicChartType_GraphElements() {
        return (EReference)getGraphicChartType().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGraphicChartType_M_name() {
        return (EReference)getGraphicChartType().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGraphicChartType_M_fileVersion() {
        return (EAttribute)getGraphicChartType().getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGraphicChartType_M_bIsPreferencesInitialized() {
        return (EAttribute)getGraphicChartType().getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHyperLinksType() {
		if (hyperLinksTypeEClass == null) {
			hyperLinksTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(67);
		}
		return hyperLinksTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIAcceptEventAction() {
		if (iAcceptEventActionEClass == null) {
			iAcceptEventActionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(68);
		}
		return iAcceptEventActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIAcceptEventAction_Event() {
        return (EReference)getIAcceptEventAction().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIAcceptTimeEvent() {
		if (iAcceptTimeEventEClass == null) {
			iAcceptTimeEventEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(69);
		}
		return iAcceptTimeEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIAction() {
		if (iActionEClass == null) {
			iActionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(70);
		}
		return iActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIAction_Id() {
        return (EAttribute)getIAction().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIAction_MyState() {
        return (EAttribute)getIAction().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIAction_Body() {
        return (EAttribute)getIAction().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIAction_ModifiedTimeWeak() {
        return (EAttribute)getIAction().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIAction_ObjectCreation() {
        return (EAttribute)getIAction().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIAction_UmlDependencyID() {
        return (EAttribute)getIAction().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIActivityDiagram() {
		if (iActivityDiagramEClass == null) {
			iActivityDiagramEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(71);
		}
		return iActivityDiagramEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIActivityDiagram_GraphicChart() {
        return (EReference)getIActivityDiagram().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIActivityDiagram_CodeUpdateCGTime() {
        return (EAttribute)getIActivityDiagram().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIActivityGraph() {
		if (iActivityGraphEClass == null) {
			iActivityGraphEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(72);
		}
		return iActivityGraphEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIActivityGraph_LastID() {
        return (EAttribute)getIActivityGraph().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIActivityGraph_WeakCGTime() {
        return (EAttribute)getIActivityGraph().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIActivityGraph_StrongCGTime() {
        return (EAttribute)getIActivityGraph().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIActivityGraph_Multiplicity() {
        return (EAttribute)getIActivityGraph().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIActivityGraph_ItsStateChart() {
        return (EReference)getIActivityGraph().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIActivityGraph_ClassModifier() {
        return (EAttribute)getIActivityGraph().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIActivityGraph_States() {
        return (EReference)getIActivityGraph().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIActivityGraph_BaseVersion() {
        return (EAttribute)getIActivityGraph().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIActivityGraph_Diagram() {
        return (EReference)getIActivityGraph().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIActivityGraph_Views() {
        return (EReference)getIActivityGraph().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIActivityGraph_Properties() {
        return (EReference)getIActivityGraph().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIActivityGraph_RequiremenTracabilityHandle() {
        return (EAttribute)getIActivityGraph().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIActivityGraph_Description() {
        return (EReference)getIActivityGraph().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIActivityGraph_Swimlanes() {
        return (EReference)getIActivityGraph().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIActivityGraph_Stereotypes() {
        return (EReference)getIActivityGraph().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIActivityGraph_AnalysisMode() {
        return (EAttribute)getIActivityGraph().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIActivityGraph_Annotations() {
        return (EReference)getIActivityGraph().getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIActivityGraph_CodeUpdateCGTime() {
        return (EAttribute)getIActivityGraph().getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIActivityGraph_ObjectCreation() {
        return (EAttribute)getIActivityGraph().getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIActivityGraph_UmlDependencyID() {
        return (EAttribute)getIActivityGraph().getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIActivityGraph_HyperLinks() {
        return (EReference)getIActivityGraph().getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIActivityGraph_Dependencies() {
        return (EReference)getIActivityGraph().getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIActivityGraph_TheMainDiagram() {
        return (EReference)getIActivityGraph().getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIActivityGraph_Associations() {
        return (EReference)getIActivityGraph().getEStructuralFeatures().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIActivityGraph_Tags() {
        return (EReference)getIActivityGraph().getEStructuralFeatures().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIActor() {
		if (iActorEClass == null) {
			iActorEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(73);
		}
		return iActorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIActor_Id() {
        return (EAttribute)getIActor().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIActor_MyState() {
        return (EAttribute)getIActor().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIActor_Name() {
        return (EAttribute)getIActor().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIActor_TheMainDiagram() {
        return (EReference)getIActor().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIActor_Dependencies() {
        return (EReference)getIActor().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIActor_LastID() {
        return (EAttribute)getIActor().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIActor_WeakCGTime() {
        return (EAttribute)getIActor().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIActor_StrongCGTime() {
        return (EAttribute)getIActor().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIActor_Operations() {
        return (EReference)getIActor().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIActor_StateCharts() {
        return (EReference)getIActor().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIActor_ItsStateChart() {
        return (EReference)getIActor().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIActor_Associations() {
        return (EReference)getIActor().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIActor_ClassModifier() {
        return (EAttribute)getIActor().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIActor_HyperLinks() {
        return (EReference)getIActor().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIActor_ModifiedTimeWeak() {
        return (EAttribute)getIActor().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIActor_Ports() {
        return (EReference)getIActor().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIActor_Inheritances() {
        return (EReference)getIActor().getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIActor_Attrs() {
        return (EReference)getIActor().getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIActor_RequiremenTracabilityHandle() {
        return (EAttribute)getIActor().getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIActor_Description() {
        return (EReference)getIActor().getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIActor_Annotations() {
        return (EReference)getIActor().getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIActor_ComponentFiles() {
        return (EReference)getIActor().getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIActor_Properties() {
        return (EReference)getIActor().getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIAnchor() {
		if (iAnchorEClass == null) {
			iAnchorEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(74);
		}
		return iAnchorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIAnchor_Id() {
        return (EAttribute)getIAnchor().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIAnchor_MyState() {
        return (EAttribute)getIAnchor().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIAnchor_Name() {
        return (EAttribute)getIAnchor().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIAnchor_DependsOn() {
        return (EReference)getIAnchor().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIAnchor_ModifiedTimeWeak() {
        return (EAttribute)getIAnchor().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIAnnotation() {
		if (iAnnotationEClass == null) {
			iAnnotationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(75);
		}
		return iAnnotationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIAnnotation_RequiremenTracabilityHandle() {
        return (EAttribute)getIAnnotation().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIAnnotation_Description() {
        return (EReference)getIAnnotation().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIAnnotation_UmlDependencyID() {
        return (EAttribute)getIAnnotation().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIAnnotation_ObjectCreation() {
        return (EAttribute)getIAnnotation().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIAnnotation_Tags() {
        return (EReference)getIAnnotation().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIAnnotation_Body() {
        return (EAttribute)getIAnnotation().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIArgument() {
		if (iArgumentEClass == null) {
			iArgumentEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(76);
		}
		return iArgumentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIArgument_Id() {
        return (EAttribute)getIArgument().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIArgument_MyState() {
        return (EAttribute)getIArgument().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIArgument_Properties() {
        return (EReference)getIArgument().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIArgument_Name() {
        return (EAttribute)getIArgument().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIArgument_ModifiedTimeWeak() {
        return (EAttribute)getIArgument().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIArgument_TypeOf() {
        return (EReference)getIArgument().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIArgument_ArgumentDirection() {
        return (EAttribute)getIArgument().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIArgument_DefaultValue() {
        return (EAttribute)getIArgument().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIArgument_ValueSpecifications() {
        return (EReference)getIArgument().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIArgument_Description() {
        return (EReference)getIArgument().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIArgument_CodeUpdateCGTime() {
        return (EAttribute)getIArgument().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIArgument_ObjectCreation() {
        return (EAttribute)getIArgument().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIArgument_UmlDependencyID() {
        return (EAttribute)getIArgument().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIAssociationClass() {
		if (iAssociationClassEClass == null) {
			iAssociationClassEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(77);
		}
		return iAssociationClassEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIAssociationClass_IsClass() {
        return (EAttribute)getIAssociationClass().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIAssociationClass_M_end1() {
        return (EReference)getIAssociationClass().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIAssociationClass_M_end2() {
        return (EReference)getIAssociationClass().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIAssociationEnd() {
		if (iAssociationEndEClass == null) {
			iAssociationEndEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(78);
		}
		return iAssociationEndEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIAssociationEnd_Id() {
        return (EAttribute)getIAssociationEnd().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIAssociationEnd_MyState() {
        return (EAttribute)getIAssociationEnd().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIAssociationEnd_Name() {
        return (EAttribute)getIAssociationEnd().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIAssociationEnd_Multiplicity() {
        return (EAttribute)getIAssociationEnd().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIAssociationEnd_OtherClass() {
        return (EReference)getIAssociationEnd().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIAssociationEnd_LinkName() {
        return (EAttribute)getIAssociationEnd().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIAssociationEnd_LinkType() {
        return (EAttribute)getIAssociationEnd().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIAssociationEnd_Navigability() {
        return (EAttribute)getIAssociationEnd().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIAssociationEnd_Inverse() {
        return (EReference)getIAssociationEnd().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIAssociationEnd_ModifiedTimeWeak() {
        return (EAttribute)getIAssociationEnd().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIAssociationEnd_Qualifiers() {
        return (EReference)getIAssociationEnd().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIAssociationEnd_Stereotypes() {
        return (EReference)getIAssociationEnd().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIAssociationEnd_CodeUpdateCGTime() {
        return (EAttribute)getIAssociationEnd().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIAssociationEnd_QualifierType() {
        return (EReference)getIAssociationEnd().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIAssociationEnd_M_associationClass() {
        return (EReference)getIAssociationEnd().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIAssociationEndHandle() {
		if (iAssociationEndHandleEClass == null) {
			iAssociationEndHandleEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(79);
		}
		return iAssociationEndHandleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIAssociationEndHandle_M2Class() {
        return (EAttribute)getIAssociationEndHandle().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIAssociationEndHandle_Filename() {
        return (EAttribute)getIAssociationEndHandle().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIAssociationEndHandle_Subsystem() {
        return (EAttribute)getIAssociationEndHandle().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIAssociationEndHandle_Class() {
        return (EAttribute)getIAssociationEndHandle().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIAssociationEndHandle_Name() {
        return (EAttribute)getIAssociationEndHandle().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIAssociationEndHandle_Id() {
        return (EAttribute)getIAssociationEndHandle().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIAssociationRole() {
		if (iAssociationRoleEClass == null) {
			iAssociationRoleEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(80);
		}
		return iAssociationRoleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIAssociationRole_Id() {
        return (EAttribute)getIAssociationRole().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIAssociationRole_MyState() {
        return (EAttribute)getIAssociationRole().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIAssociationRole_M_fAssocType1() {
        return (EAttribute)getIAssociationRole().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIAssociationRole_M_fAssocType2() {
        return (EAttribute)getIAssociationRole().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIAssociationRole_M_pSource() {
        return (EReference)getIAssociationRole().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIAssociationRole_M_pTarget() {
        return (EReference)getIAssociationRole().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIAssociationRole_M_pFormalAssoc1() {
        return (EReference)getIAssociationRole().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIAssociationRole_M_pFormalAssoc2() {
        return (EReference)getIAssociationRole().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIAssociationRole_Name() {
        return (EAttribute)getIAssociationRole().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIAssociationRole_ModifiedTimeWeak() {
        return (EAttribute)getIAssociationRole().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIAssociationRole_ObjectCreation() {
        return (EAttribute)getIAssociationRole().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIAssociationRole_UmlDependencyID() {
        return (EAttribute)getIAssociationRole().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIAttribute() {
		if (iAttributeEClass == null) {
			iAttributeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(81);
		}
		return iAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIAttribute_TypeOf() {
        return (EReference)getIAttribute().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIAttribute_Protection() {
        return (EAttribute)getIAttribute().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIAttribute_Static() {
        return (EAttribute)getIAttribute().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIAttribute_IsReference() {
        return (EAttribute)getIAttribute().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIAttribute_IsConstant() {
        return (EAttribute)getIAttribute().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIAttribute_Stereotypes() {
        return (EReference)getIAttribute().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIAttribute_ValueSpecifications() {
        return (EReference)getIAttribute().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIAttribute_Properties() {
        return (EReference)getIAttribute().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIAttribute_Description() {
        return (EReference)getIAttribute().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIAttribute_Tags() {
        return (EReference)getIAttribute().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIAttribute_DefaultValue() {
        return (EAttribute)getIAttribute().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIAttribute_Dependencies() {
        return (EReference)getIAttribute().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIAttribute_LastID() {
        return (EAttribute)getIAttribute().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIAttribute_Annotations() {
        return (EReference)getIAttribute().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIAttribute_RequiremenTracabilityHandle() {
        return (EAttribute)getIAttribute().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIAttribute_CodeUpdateCGTime() {
        return (EAttribute)getIAttribute().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIAttribute_TheMainDiagram() {
        return (EReference)getIAttribute().getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIBlock() {
		if (iBlockEClass == null) {
			iBlockEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(82);
		}
		return iBlockEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIBlock_Id() {
        return (EAttribute)getIBlock().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIBlock_MyState() {
        return (EAttribute)getIBlock().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIBlock_Name() {
        return (EAttribute)getIBlock().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIBlock_ObjectCreation() {
        return (EAttribute)getIBlock().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIBlock_UmlDependencyID() {
        return (EAttribute)getIBlock().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIBlock_OtherClass() {
        return (EReference)getIBlock().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIBlock_Inverse() {
        return (EReference)getIBlock().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIBlock_PartKind() {
        return (EAttribute)getIBlock().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIBody() {
		if (iBodyEClass == null) {
			iBodyEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(83);
		}
		return iBodyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIBody_BodyData() {
        return (EAttribute)getIBody().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIBranch() {
		if (iBranchEClass == null) {
			iBranchEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(84);
		}
		return iBranchEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIBranch_Id() {
        return (EAttribute)getIBranch().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIBranch_Name() {
        return (EAttribute)getIBranch().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIBranch_ModifiedTimeWeak() {
        return (EAttribute)getIBranch().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIBranch_Parent() {
        return (EReference)getIBranch().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIBranch_ConnectorType() {
        return (EAttribute)getIBranch().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIBranch_MyState() {
        return (EAttribute)getIBranch().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIBranch_Stereotypes() {
        return (EReference)getIBranch().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIBranch_CodeUpdateCGTime() {
        return (EAttribute)getIBranch().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIBranch_ObjectCreation() {
        return (EAttribute)getIBranch().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIBranch_UmlDependencyID() {
        return (EAttribute)getIBranch().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getICallAction() {
		if (iCallActionEClass == null) {
			iCallActionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(85);
		}
		return iCallActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getICallAction_Id() {
        return (EAttribute)getICallAction().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getICallAction_ModifiedTimeWeak() {
        return (EAttribute)getICallAction().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getICallAction_InterfaceItem() {
        return (EReference)getICallAction().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getICallAction_ArgumentNames() {
        return (EAttribute)getICallAction().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getICallAction_ArgumentValues() {
        return (EAttribute)getICallAction().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getICallOperation() {
		if (iCallOperationEClass == null) {
			iCallOperationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(86);
		}
		return iCallOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getICallOperation_Operation() {
        return (EReference)getICallOperation().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getICallOperation_Target() {
        return (EReference)getICallOperation().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIClass() {
		if (iClassEClass == null) {
			iClassEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(87);
		}
		return iClassEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIClass_WeakCGTime() {
        return (EAttribute)getIClass().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIClass_StrongCGTime() {
        return (EAttribute)getIClass().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIClass_Multiplicity() {
        return (EAttribute)getIClass().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIClass_ClassModifier() {
        return (EAttribute)getIClass().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIClass_Properties() {
        return (EReference)getIClass().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIClass_Stereotypes() {
        return (EReference)getIClass().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIClass_Operations() {
        return (EReference)getIClass().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIClass_Inheritances() {
        return (EReference)getIClass().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIClass_TheMainDiagram() {
        return (EReference)getIClass().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIClass_Attrs() {
        return (EReference)getIClass().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIClass_Tags() {
        return (EReference)getIClass().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIClass_Associations() {
        return (EReference)getIClass().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIClass_Dependencies() {
        return (EReference)getIClass().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIClass_Ports() {
        return (EReference)getIClass().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIClass_ObjectLinks() {
        return (EReference)getIClass().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIClass_StateCharts() {
        return (EReference)getIClass().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIClass_ItsStateChart() {
        return (EReference)getIClass().getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIClass_TriggeredOperations() {
        return (EReference)getIClass().getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIClass_Receptions() {
        return (EReference)getIClass().getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIClass_PrimitiveOperations() {
        return (EReference)getIClass().getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIClass_Annotations() {
        return (EReference)getIClass().getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIClass_Description() {
        return (EReference)getIClass().getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIClass_Declaratives() {
        return (EReference)getIClass().getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIClass_AssociationElements() {
        return (EReference)getIClass().getEStructuralFeatures().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIClass_OwnerHandle() {
        return (EReference)getIClass().getEStructuralFeatures().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIClass_HyperLinks() {
        return (EReference)getIClass().getEStructuralFeatures().get(25);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIClass_RequiremenTracabilityHandle() {
        return (EAttribute)getIClass().getEStructuralFeatures().get(26);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIClass_ComponentFiles() {
        return (EReference)getIClass().getEStructuralFeatures().get(27);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIClass_Links() {
        return (EReference)getIClass().getEStructuralFeatures().get(28);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIClass_Components() {
        return (EReference)getIClass().getEStructuralFeatures().get(29);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIClass_EventHandles() {
        return (EReference)getIClass().getEStructuralFeatures().get(30);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIClass_TemplateParameters() {
        return (EReference)getIClass().getEStructuralFeatures().get(31);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIClass_CodeUpdateCGTime() {
        return (EAttribute)getIClass().getEStructuralFeatures().get(32);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIClass_Cmheader() {
        return (EAttribute)getIClass().getEStructuralFeatures().get(33);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIClassHandle() {
		if (iClassHandleEClass == null) {
			iClassHandleEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(88);
		}
		return iClassHandleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIClassHandle_M2Class() {
        return (EAttribute)getIClassHandle().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIClassHandle_Id() {
        return (EAttribute)getIClassHandle().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIClassHandle_Filename() {
        return (EAttribute)getIClassHandle().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIClassHandle_Subsystem() {
        return (EAttribute)getIClassHandle().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIClassHandle_Class() {
        return (EAttribute)getIClassHandle().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIClassHandle_Name() {
        return (EAttribute)getIClassHandle().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIClassInstance() {
		if (iClassInstanceEClass == null) {
			iClassInstanceEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(89);
		}
		return iClassInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIClassInstance_Inverse() {
        return (EReference)getIClassInstance().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIClassifier() {
		if (iClassifierEClass == null) {
			iClassifierEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(90);
		}
		return iClassifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIClassifierRole() {
		if (iClassifierRoleEClass == null) {
			iClassifierRoleEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(91);
		}
		return iClassifierRoleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIClassifierRole_Id() {
        return (EAttribute)getIClassifierRole().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIClassifierRole_Name() {
        return (EAttribute)getIClassifierRole().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIClassifierRole_M_eRoleType() {
        return (EAttribute)getIClassifierRole().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIClassifierRole_MyState() {
        return (EAttribute)getIClassifierRole().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIClassifierRole_M_pBase() {
        return (EReference)getIClassifierRole().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIClassifierRole_M_instance() {
        return (EReference)getIClassifierRole().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIClassifierRole_Properties() {
        return (EReference)getIClassifierRole().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIClassifierRole_ModifiedTimeWeak() {
        return (EAttribute)getIClassifierRole().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIClassifierRole_M_pRefSD() {
        return (EReference)getIClassifierRole().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIClassifierRole_CodeUpdateCGTime() {
        return (EAttribute)getIClassifierRole().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIClassifierRole_Stereotypes() {
        return (EReference)getIClassifierRole().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIClassifierRole_ObjectCreation() {
        return (EAttribute)getIClassifierRole().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIClassifierRole_UmlDependencyID() {
        return (EAttribute)getIClassifierRole().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getICodeGenConfigInfo() {
		if (iCodeGenConfigInfoEClass == null) {
			iCodeGenConfigInfoEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(92);
		}
		return iCodeGenConfigInfoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getICodeGenConfigInfo_Id() {
        return (EAttribute)getICodeGenConfigInfo().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getICodeGenConfigInfo_MyState() {
        return (EAttribute)getICodeGenConfigInfo().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getICodeGenConfigInfo_Name() {
        return (EAttribute)getICodeGenConfigInfo().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getICodeGenConfigInfo_ModifiedTimeWeak() {
        return (EAttribute)getICodeGenConfigInfo().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getICodeGenConfigInfo_HyperLinks() {
        return (EReference)getICodeGenConfigInfo().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getICodeGenConfigInfo_ScopeType() {
        return (EAttribute)getICodeGenConfigInfo().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getICodeGenConfigInfo_Libraries() {
        return (EAttribute)getICodeGenConfigInfo().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getICodeGenConfigInfo_AdditionalSources() {
        return (EAttribute)getICodeGenConfigInfo().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getICodeGenConfigInfo_StandardHeaders() {
        return (EAttribute)getICodeGenConfigInfo().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getICodeGenConfigInfo_IncludePath() {
        return (EAttribute)getICodeGenConfigInfo().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getICodeGenConfigInfo_TargetMain() {
        return (EAttribute)getICodeGenConfigInfo().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getICodeGenConfigInfo_Instrumentation() {
        return (EAttribute)getICodeGenConfigInfo().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getICodeGenConfigInfo_TimeModel() {
        return (EAttribute)getICodeGenConfigInfo().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getICodeGenConfigInfo_M_generateActors() {
        return (EAttribute)getICodeGenConfigInfo().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getICodeGenConfigInfo_StatechartImplementation() {
        return (EAttribute)getICodeGenConfigInfo().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getICodeGenConfigInfo_InitializationCode() {
        return (EAttribute)getICodeGenConfigInfo().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getICodeGenConfigInfo_ChecksList() {
        return (EAttribute)getICodeGenConfigInfo().getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getICodeGenConfigInfo_ScopeElements() {
        return (EReference)getICodeGenConfigInfo().getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getICodeGenConfigInfo_Root() {
        return (EReference)getICodeGenConfigInfo().getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getICodeGenConfigInfo_WeakCGTime() {
        return (EAttribute)getICodeGenConfigInfo().getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getICodeGenConfigInfo_StrongCGTime() {
        return (EAttribute)getICodeGenConfigInfo().getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getICodeGenConfigInfo_M_allInAnimScope() {
        return (EAttribute)getICodeGenConfigInfo().getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getICodeGenConfigInfo_M_generateUsecases() {
        return (EAttribute)getICodeGenConfigInfo().getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getICodeGenConfigInfo_Dependencies() {
        return (EReference)getICodeGenConfigInfo().getEStructuralFeatures().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getICodeGenConfigInfo_InitialInstances() {
        return (EReference)getICodeGenConfigInfo().getEStructuralFeatures().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getICodeGenConfigInfo_Properties() {
        return (EReference)getICodeGenConfigInfo().getEStructuralFeatures().get(25);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getICodeGenConfigInfo_Annotations() {
        return (EReference)getICodeGenConfigInfo().getEStructuralFeatures().get(26);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getICodeGenConfigInfo_LastID() {
        return (EAttribute)getICodeGenConfigInfo().getEStructuralFeatures().get(27);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getICodeGenConfigInfo_Description() {
        return (EReference)getICodeGenConfigInfo().getEStructuralFeatures().get(28);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getICodeGenConfigInfo_Tags() {
        return (EReference)getICodeGenConfigInfo().getEStructuralFeatures().get(29);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getICodeGenConfigInfo_Cmheader() {
        return (EAttribute)getICodeGenConfigInfo().getEStructuralFeatures().get(30);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getICodeGenConfigInfo_RequiremenTracabilityHandle() {
        return (EAttribute)getICodeGenConfigInfo().getEStructuralFeatures().get(31);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getICodeGenConfigInfo_Stereotypes() {
        return (EReference)getICodeGenConfigInfo().getEStructuralFeatures().get(32);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getICodeGenConfigInfo_CodeUpdateCGTime() {
        return (EAttribute)getICodeGenConfigInfo().getEStructuralFeatures().get(33);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getICodeGenConfigInfo_AnimScopeElements() {
        return (EReference)getICodeGenConfigInfo().getEStructuralFeatures().get(34);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getICodeGenConfigInfo_EmbededFiles() {
        return (EReference)getICodeGenConfigInfo().getEStructuralFeatures().get(35);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getICodeGenConfigInfo_ObjectCreation() {
        return (EAttribute)getICodeGenConfigInfo().getEStructuralFeatures().get(36);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getICodeGenConfigInfo_UmlDependencyID() {
        return (EAttribute)getICodeGenConfigInfo().getEStructuralFeatures().get(37);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getICodeGenConfigInfoHandle() {
		if (iCodeGenConfigInfoHandleEClass == null) {
			iCodeGenConfigInfoHandleEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(93);
		}
		return iCodeGenConfigInfoHandleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getICodeGenConfigInfoHandle_M2Class() {
        return (EAttribute)getICodeGenConfigInfoHandle().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getICodeGenConfigInfoHandle_Id() {
        return (EAttribute)getICodeGenConfigInfoHandle().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getICollaboration() {
		if (iCollaborationEClass == null) {
			iCollaborationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(94);
		}
		return iCollaborationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getICollaboration_Id() {
        return (EAttribute)getICollaboration().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getICollaboration_ClassifierRoles() {
        return (EReference)getICollaboration().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getICollaboration_Messages() {
        return (EReference)getICollaboration().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getICollaboration_Annotations() {
        return (EReference)getICollaboration().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getICollaboration_AssociationRoles() {
        return (EReference)getICollaboration().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getICollaboration_ModifiedTimeWeak() {
        return (EAttribute)getICollaboration().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getICollaboration_CombinedFragments() {
        return (EReference)getICollaboration().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getICollaboration_P_MessageHandler() {
        return (EReference)getICollaboration().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getICollaboration_InteractionOccurrences() {
        return (EReference)getICollaboration().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getICollaboration_ExecutionOccurrences() {
        return (EReference)getICollaboration().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getICollaboration_ObjectCreation() {
        return (EAttribute)getICollaboration().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getICollaboration_UmlDependencyID() {
        return (EAttribute)getICollaboration().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getICollaborationDiagram() {
		if (iCollaborationDiagramEClass == null) {
			iCollaborationDiagramEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(95);
		}
		return iCollaborationDiagramEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getICollaborationDiagram_M_pICollaboration() {
        return (EReference)getICollaborationDiagram().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIColor() {
		if (iColorEClass == null) {
			iColorEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(96);
		}
		return iColorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIColor_M_fgColor() {
        return (EAttribute)getIColor().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIColor_M_bgColor() {
        return (EAttribute)getIColor().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIColor_M_bgFlag() {
        return (EAttribute)getIColor().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getICombinedFragment() {
		if (iCombinedFragmentEClass == null) {
			iCombinedFragmentEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(97);
		}
		return iCombinedFragmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getICombinedFragment_Id() {
        return (EAttribute)getICombinedFragment().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getICombinedFragment_MyState() {
        return (EAttribute)getICombinedFragment().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getICombinedFragment_Name() {
        return (EAttribute)getICombinedFragment().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getICombinedFragment_ModifiedTimeWeak() {
        return (EAttribute)getICombinedFragment().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getICombinedFragment_InteractionOperator() {
        return (EAttribute)getICombinedFragment().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getICombinedFragment_InteractionOperands() {
        return (EReference)getICombinedFragment().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getICombinedFragment_Stereotypes() {
        return (EReference)getICombinedFragment().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getICombinedFragment_Tags() {
        return (EReference)getICombinedFragment().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIComment() {
		if (iCommentEClass == null) {
			iCommentEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(98);
		}
		return iCommentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIComment_HyperLinks() {
        return (EReference)getIComment().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIComment_Anchors() {
        return (EReference)getIComment().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIComment_Dependencies() {
        return (EReference)getIComment().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIComment_Stereotypes() {
        return (EReference)getIComment().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIComment_LastID() {
        return (EAttribute)getIComment().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIComment_CodeUpdateCGTime() {
        return (EAttribute)getIComment().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIComment_TheMainDiagram() {
        return (EReference)getIComment().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIComment_Properties() {
        return (EReference)getIComment().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIComponent() {
		if (iComponentEClass == null) {
			iComponentEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(99);
		}
		return iComponentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIComponent_OwnerHandle() {
        return (EReference)getIComponent().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIComponent_Id() {
        return (EAttribute)getIComponent().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIComponent_MyState() {
        return (EAttribute)getIComponent().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIComponent_Name() {
        return (EAttribute)getIComponent().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIComponent_Stereotypes() {
        return (EReference)getIComponent().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIComponent_ModifiedTimeWeak() {
        return (EAttribute)getIComponent().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIComponent_M_buildType() {
        return (EAttribute)getIComponent().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIComponent_M_libraries() {
        return (EAttribute)getIComponent().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIComponent_M_additionalSources() {
        return (EAttribute)getIComponent().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIComponent_M_standardHeaders() {
        return (EAttribute)getIComponent().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIComponent_M_includePath() {
        return (EAttribute)getIComponent().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIComponent_M_initializationCode() {
        return (EAttribute)getIComponent().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIComponent_M_folder() {
        return (EReference)getIComponent().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIComponent_M_configActive() {
        return (EReference)getIComponent().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIComponent_Configs() {
        return (EReference)getIComponent().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIComponent_Dependencies() {
        return (EReference)getIComponent().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIComponent_HandlesInMe() {
        return (EReference)getIComponent().getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIComponent_Properties() {
        return (EReference)getIComponent().getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIComponent_LastID() {
        return (EAttribute)getIComponent().getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIComponent_Description() {
        return (EReference)getIComponent().getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIComponent_RequiremenTracabilityHandle() {
        return (EAttribute)getIComponent().getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIComponent_HyperLinks() {
        return (EReference)getIComponent().getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIComponent_CodeUpdateCGTime() {
        return (EAttribute)getIComponent().getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIComponent_Declaratives() {
        return (EReference)getIComponent().getEStructuralFeatures().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIComponent_VariationPoints() {
        return (EReference)getIComponent().getEStructuralFeatures().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIComponent_SelectedVariants() {
        return (EReference)getIComponent().getEStructuralFeatures().get(25);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIComponent_ObjectCreation() {
        return (EAttribute)getIComponent().getEStructuralFeatures().get(26);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIComponent_UmlDependencyID() {
        return (EAttribute)getIComponent().getEStructuralFeatures().get(27);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIComponent_Cmheader() {
        return (EAttribute)getIComponent().getEStructuralFeatures().get(28);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIComponentDiagram() {
		if (iComponentDiagramEClass == null) {
			iComponentDiagramEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(100);
		}
		return iComponentDiagramEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIComponentInstance() {
		if (iComponentInstanceEClass == null) {
			iComponentInstanceEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(101);
		}
		return iComponentInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIConfiguration() {
		if (iConfigurationEClass == null) {
			iConfigurationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(102);
		}
		return iConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIConnector() {
		if (iConnectorEClass == null) {
			iConnectorEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(103);
		}
		return iConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIConnector_Parent() {
        return (EReference)getIConnector().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIConnector_ConnectorType() {
        return (EAttribute)getIConnector().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIConstraint() {
		if (iConstraintEClass == null) {
			iConstraintEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(104);
		}
		return iConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIConstraint_Id() {
        return (EAttribute)getIConstraint().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIConstraint_MyState() {
        return (EAttribute)getIConstraint().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIConstraint_Name() {
        return (EAttribute)getIConstraint().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIConstraint_ModifiedTimeWeak() {
        return (EAttribute)getIConstraint().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIConstraint_Stereotypes() {
        return (EReference)getIConstraint().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIConstraint_Properties() {
        return (EReference)getIConstraint().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIConstraint_Anchors() {
        return (EReference)getIConstraint().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIConstructor() {
		if (iConstructorEClass == null) {
			iConstructorEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(105);
		}
		return iConstructorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIConstructor_Id() {
        return (EAttribute)getIConstructor().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIConstructor_MyState() {
        return (EAttribute)getIConstructor().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIConstructor_ModifiedTimeWeak() {
        return (EAttribute)getIConstructor().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIConstructor_ReturnType() {
        return (EReference)getIConstructor().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIConstructor_Abstract() {
        return (EAttribute)getIConstructor().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIConstructor_Final() {
        return (EAttribute)getIConstructor().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIConstructor_Concurrency() {
        return (EAttribute)getIConstructor().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIConstructor_Protection() {
        return (EAttribute)getIConstructor().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIConstructor_Static() {
        return (EAttribute)getIConstructor().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIConstructor_Constant() {
        return (EAttribute)getIConstructor().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIConstructor_ItsBody() {
        return (EReference)getIConstructor().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIConstructor_Initializer() {
        return (EAttribute)getIConstructor().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIConstructor_Args() {
        return (EReference)getIConstructor().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIConstructor_Name() {
        return (EAttribute)getIConstructor().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIConstructor_Description() {
        return (EReference)getIConstructor().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIConstructor_RequiremenTracabilityHandle() {
        return (EAttribute)getIConstructor().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIConstructor_CodeUpdateCGTime() {
        return (EAttribute)getIConstructor().getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIConstructor_Tags() {
        return (EReference)getIConstructor().getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIConstructor_LastID() {
        return (EAttribute)getIConstructor().getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIContextSpecification() {
		if (iContextSpecificationEClass == null) {
			iContextSpecificationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(106);
		}
		return iContextSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIControlledFile() {
		if (iControlledFileEClass == null) {
			iControlledFileEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(107);
		}
		return iControlledFileEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIDefaultDrvdTrans() {
		if (iDefaultDrvdTransEClass == null) {
			iDefaultDrvdTransEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(108);
		}
		return iDefaultDrvdTransEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIDefaultDrvdTrans_ItsSource() {
        return (EAttribute)getIDefaultDrvdTrans().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIDefaultDrvdTrans_OfState() {
        return (EReference)getIDefaultDrvdTrans().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIDefaultDrvdTrans_ErrorStatus() {
        return (EAttribute)getIDefaultDrvdTrans().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIDefaultDrvdTrans_InheritsFromHandle() {
        return (EReference)getIDefaultDrvdTrans().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIDefaultDrvdTrans_Annotations() {
        return (EReference)getIDefaultDrvdTrans().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIDefaultDrvdTrans_Stereotypes() {
        return (EReference)getIDefaultDrvdTrans().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIDependency() {
		if (iDependencyEClass == null) {
			iDependencyEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(109);
		}
		return iDependencyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIDependency_Id() {
        return (EAttribute)getIDependency().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIDependency_MyState() {
        return (EAttribute)getIDependency().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIDependency_Properties() {
        return (EReference)getIDependency().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIDependency_Name() {
        return (EAttribute)getIDependency().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIDependency_Stereotypes() {
        return (EReference)getIDependency().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIDependency_ModifiedTimeWeak() {
        return (EAttribute)getIDependency().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIDependency_DependsOn() {
        return (EReference)getIDependency().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIDependency_Tags() {
        return (EReference)getIDependency().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIDependency_Annotations() {
        return (EReference)getIDependency().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIDependency_Dependencies() {
        return (EReference)getIDependency().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIDependency_Description() {
        return (EReference)getIDependency().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIDependency_RequiremenTracabilityHandle() {
        return (EAttribute)getIDependency().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIDependency_CodeUpdateCGTime() {
        return (EAttribute)getIDependency().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIDeploymentDiagram() {
		if (iDeploymentDiagramEClass == null) {
			iDeploymentDiagramEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(110);
		}
		return iDeploymentDiagramEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIDescription() {
		if (iDescriptionEClass == null) {
			iDescriptionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(111);
		}
		return iDescriptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIDescription_TextRTF() {
        return (EAttribute)getIDescription().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIDescription_Text() {
        return (EAttribute)getIDescription().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIDescription_Hyperlinks() {
        return (EReference)getIDescription().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIDestructor() {
		if (iDestructorEClass == null) {
			iDestructorEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(112);
		}
		return iDestructorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIDestructor_Id() {
        return (EAttribute)getIDestructor().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIDestructor_Name() {
        return (EAttribute)getIDestructor().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIDestructor_Args() {
        return (EReference)getIDestructor().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIDestructor_Abstract() {
        return (EAttribute)getIDestructor().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIDestructor_Final() {
        return (EAttribute)getIDestructor().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIDestructor_Concurrency() {
        return (EAttribute)getIDestructor().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIDestructor_Protection() {
        return (EAttribute)getIDestructor().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIDestructor_Static() {
        return (EAttribute)getIDestructor().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIDestructor_Constant() {
        return (EAttribute)getIDestructor().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIDestructor_ItsBody() {
        return (EReference)getIDestructor().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIDestructor_ModifiedTimeWeak() {
        return (EAttribute)getIDestructor().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIDestructor_Description() {
        return (EReference)getIDestructor().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIDestructor_Properties() {
        return (EReference)getIDestructor().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIDestructor_MyState() {
        return (EAttribute)getIDestructor().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIDestructor_ReturnType() {
        return (EReference)getIDestructor().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIDiagram() {
		if (iDiagramEClass == null) {
			iDiagramEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(113);
		}
		return iDiagramEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIDiagram_Properties() {
        return (EReference)getIDiagram().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIDiagram_Stereotypes() {
        return (EReference)getIDiagram().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIDiagram_ModifiedTimeWeak() {
        return (EAttribute)getIDiagram().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIDiagram_GraphicChart() {
        return (EReference)getIDiagram().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIDiagram_Annotations() {
        return (EReference)getIDiagram().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIDiagram_CodeUpdateCGTime() {
        return (EAttribute)getIDiagram().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIDiagram_HyperLinks() {
        return (EReference)getIDiagram().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIEmbededFile() {
		if (iEmbededFileEClass == null) {
			iEmbededFileEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(114);
		}
		return iEmbededFileEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIEmbededFile_Id() {
        return (EAttribute)getIEmbededFile().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIEmbededFile_Name() {
        return (EAttribute)getIEmbededFile().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIEmbededFile_ModifiedTimeWeak() {
        return (EAttribute)getIEmbededFile().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIEmbededFile_MayNeedToRelocate() {
        return (EAttribute)getIEmbededFile().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIEmbededFile_LastKnownFullPath() {
        return (EAttribute)getIEmbededFile().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIEmbededFile_Stereotypes() {
        return (EReference)getIEmbededFile().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIEmbededFile_Tags() {
        return (EReference)getIEmbededFile().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIEnumerationLiteral() {
		if (iEnumerationLiteralEClass == null) {
			iEnumerationLiteralEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(115);
		}
		return iEnumerationLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIEnumerationLiteral_Id() {
        return (EAttribute)getIEnumerationLiteral().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIEnumerationLiteral_Name() {
        return (EAttribute)getIEnumerationLiteral().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIEnumerationLiteral_ModifiedTimeWeak() {
        return (EAttribute)getIEnumerationLiteral().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIEnumerationLiteral_Value() {
        return (EAttribute)getIEnumerationLiteral().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIEnumerationLiteral_Properties() {
        return (EReference)getIEnumerationLiteral().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIEnumerationLiteral_Tags() {
        return (EReference)getIEnumerationLiteral().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIEnumerationLiteral_CodeUpdateCGTime() {
        return (EAttribute)getIEnumerationLiteral().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIEnumerationLiteral_Description() {
        return (EReference)getIEnumerationLiteral().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIEvent() {
		if (iEventEClass == null) {
			iEventEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(116);
		}
		return iEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIEvent_Id() {
        return (EAttribute)getIEvent().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIEvent_MyState() {
        return (EAttribute)getIEvent().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIEvent_Name() {
        return (EAttribute)getIEvent().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIEvent_Virtual() {
        return (EAttribute)getIEvent().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIEvent_ModifiedTimeWeak() {
        return (EAttribute)getIEvent().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIEvent_Args() {
        return (EReference)getIEvent().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIEvent_Stereotypes() {
        return (EReference)getIEvent().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIEvent_Description() {
        return (EReference)getIEvent().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIEvent_Properties() {
        return (EReference)getIEvent().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIEvent_Dependencies() {
        return (EReference)getIEvent().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIEvent_Tags() {
        return (EReference)getIEvent().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIEvent_SuperEvent() {
        return (EReference)getIEvent().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIEvent_RequiremenTracabilityHandle() {
        return (EAttribute)getIEvent().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIEvent_Annotations() {
        return (EReference)getIEvent().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIEventHandle() {
		if (iEventHandleEClass == null) {
			iEventHandleEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(117);
		}
		return iEventHandleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIEventHandle_M2Class() {
        return (EAttribute)getIEventHandle().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIEventHandle_Filename() {
        return (EAttribute)getIEventHandle().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIEventHandle_Subsystem() {
        return (EAttribute)getIEventHandle().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIEventHandle_Class() {
        return (EAttribute)getIEventHandle().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIEventHandle_Name() {
        return (EAttribute)getIEventHandle().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIEventHandle_Id() {
        return (EAttribute)getIEventHandle().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIEventReception() {
		if (iEventReceptionEClass == null) {
			iEventReceptionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(118);
		}
		return iEventReceptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIExecutionOccurrence() {
		if (iExecutionOccurrenceEClass == null) {
			iExecutionOccurrenceEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(119);
		}
		return iExecutionOccurrenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIExecutionOccurrence_Id() {
        return (EAttribute)getIExecutionOccurrence().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIExecutionOccurrence_M_startMessage() {
        return (EReference)getIExecutionOccurrence().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIExecutionOccurrence_M_endMessage() {
        return (EReference)getIExecutionOccurrence().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIExecutionOccurrence_M_length() {
        return (EAttribute)getIExecutionOccurrence().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIExternalHyperlink() {
		if (iExternalHyperlinkEClass == null) {
			iExternalHyperlinkEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(120);
		}
		return iExternalHyperlinkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIExternalHyperlink_Target() {
        return (EAttribute)getIExternalHyperlink().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIFile() {
		if (iFileEClass == null) {
			iFileEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(121);
		}
		return iFileEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIFile_Properties() {
        return (EReference)getIFile().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIFile_M_type() {
        return (EAttribute)getIFile().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIFile_Fragments() {
        return (EReference)getIFile().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIFile_Description() {
        return (EReference)getIFile().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIFile_Dependencies() {
        return (EReference)getIFile().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIFileFragment() {
		if (iFileFragmentEClass == null) {
			iFileFragmentEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(122);
		}
		return iFileFragmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIFileFragment_Id() {
        return (EAttribute)getIFileFragment().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIFileFragment_Name() {
        return (EAttribute)getIFileFragment().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIFileFragment_M_type() {
        return (EAttribute)getIFileFragment().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIFileFragment_M_text() {
        return (EAttribute)getIFileFragment().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIFileFragment_M_startRow() {
        return (EAttribute)getIFileFragment().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIFileFragment_M_startCol() {
        return (EAttribute)getIFileFragment().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIFileFragment_Description() {
        return (EReference)getIFileFragment().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIFileFragment_M_startCol_Short() {
        return (EAttribute)getIFileFragment().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIFileFragment_M_endRow() {
        return (EAttribute)getIFileFragment().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIFileFragment_M_endCol_Short() {
        return (EAttribute)getIFileFragment().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIFileFragment_M_subject() {
        return (EReference)getIFileFragment().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIFileFragment_Tags() {
        return (EReference)getIFileFragment().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIFileFragment_Fragments() {
        return (EReference)getIFileFragment().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIFileFragment_ModifiedTimeWeak() {
        return (EAttribute)getIFileFragment().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIFileFragment_ObjectCreation() {
        return (EAttribute)getIFileFragment().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIFileFragment_UmlDependencyID() {
        return (EAttribute)getIFileFragment().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIFlow() {
		if (iFlowEClass == null) {
			iFlowEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(123);
		}
		return iFlowEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIFlowItem() {
		if (iFlowItemEClass == null) {
			iFlowItemEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(124);
		}
		return iFlowItemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIFlowchart() {
		if (iFlowchartEClass == null) {
			iFlowchartEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(125);
		}
		return iFlowchartEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIFolder() {
		if (iFolderEClass == null) {
			iFolderEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(126);
		}
		return iFolderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIFolder_Elements() {
        return (EReference)getIFolder().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIFolder_Files() {
        return (EReference)getIFolder().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIFolder_RequiremenTracabilityHandle() {
        return (EAttribute)getIFolder().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIFolder_CodeUpdateCGTime() {
        return (EAttribute)getIFolder().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIFork() {
		if (iForkEClass == null) {
			iForkEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(127);
		}
		return iForkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIFork_Id() {
        return (EAttribute)getIFork().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIFork_MyState() {
        return (EAttribute)getIFork().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIFork_Name() {
        return (EAttribute)getIFork().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIFork_ModifiedTimeWeak() {
        return (EAttribute)getIFork().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIFork_Description() {
        return (EReference)getIFork().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIFork_Parent() {
        return (EReference)getIFork().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIFork_ConnectorType() {
        return (EAttribute)getIFork().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIFork_ObjectCreation() {
        return (EAttribute)getIFork().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIFork_UmlDependencyID() {
        return (EAttribute)getIFork().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIGeneralization() {
		if (iGeneralizationEClass == null) {
			iGeneralizationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(128);
		}
		return iGeneralizationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIGeneralization_Id() {
        return (EAttribute)getIGeneralization().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIGeneralization_ModifiedTimeWeak() {
        return (EAttribute)getIGeneralization().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIGeneralization_DependsOn() {
        return (EReference)getIGeneralization().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIGeneralization_InheritanceType() {
        return (EAttribute)getIGeneralization().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIGeneralization_IsVirtual() {
        return (EAttribute)getIGeneralization().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIGeneralization_Stereotypes() {
        return (EReference)getIGeneralization().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIGeneralization_Description() {
        return (EReference)getIGeneralization().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIGeneralization_ObjectCreation() {
        return (EAttribute)getIGeneralization().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIGeneralization_UmlDependencyID() {
        return (EAttribute)getIGeneralization().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIGeneralization_Ti() {
        return (EReference)getIGeneralization().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIGeneralization_Annotations() {
        return (EReference)getIGeneralization().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIGuard() {
		if (iGuardEClass == null) {
			iGuardEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(129);
		}
		return iGuardEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIGuard_Id() {
        return (EAttribute)getIGuard().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIGuard_Body() {
        return (EAttribute)getIGuard().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIGuard_ModifiedTimeWeak() {
        return (EAttribute)getIGuard().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIGuard_ObjectCreation() {
        return (EAttribute)getIGuard().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIGuard_UmlDependencyID() {
        return (EAttribute)getIGuard().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIHandleWithData() {
		if (iHandleWithDataEClass == null) {
			iHandleWithDataEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(130);
		}
		return iHandleWithDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIHandleWithData_M2Class() {
        return (EAttribute)getIHandleWithData().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIHandleWithData_Filename() {
        return (EAttribute)getIHandleWithData().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIHandleWithData_Subsystem() {
        return (EAttribute)getIHandleWithData().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIHandleWithData_Class() {
        return (EAttribute)getIHandleWithData().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIHandleWithData_Name() {
        return (EAttribute)getIHandleWithData().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIHandleWithData_Id() {
        return (EAttribute)getIHandleWithData().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIHandleWithData_Data() {
        return (EAttribute)getIHandleWithData().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIHistoryConnector() {
		if (iHistoryConnectorEClass == null) {
			iHistoryConnectorEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(131);
		}
		return iHistoryConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIHistoryConnector_Id() {
        return (EAttribute)getIHistoryConnector().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIHistoryConnector_Name() {
        return (EAttribute)getIHistoryConnector().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIHistoryConnector_Parent() {
        return (EReference)getIHistoryConnector().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIHistoryConnector_ConnectorType() {
        return (EAttribute)getIHistoryConnector().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIHistoryConnector_MyState() {
        return (EAttribute)getIHistoryConnector().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIHistoryConnector_ModifiedTimeWeak() {
        return (EAttribute)getIHistoryConnector().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIHistoryConnector_ObjectCreation() {
        return (EAttribute)getIHistoryConnector().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIHistoryConnector_UmlDependencyID() {
        return (EAttribute)getIHistoryConnector().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIHyperLink() {
		if (iHyperLinkEClass == null) {
			iHyperLinkEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(132);
		}
		return iHyperLinkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIInformationFlow() {
		if (iInformationFlowEClass == null) {
			iInformationFlowEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(133);
		}
		return iInformationFlowEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIInformationFlow_Id() {
        return (EAttribute)getIInformationFlow().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIInformationFlow_MyState() {
        return (EAttribute)getIInformationFlow().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIInformationFlow_Name() {
        return (EAttribute)getIInformationFlow().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIInformationFlow_Conveyed() {
        return (EReference)getIInformationFlow().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIInformationFlow_End1_() {
        return (EReference)getIInformationFlow().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIInformationFlow_End2_() {
        return (EReference)getIInformationFlow().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIInformationFlow_Direction_() {
        return (EAttribute)getIInformationFlow().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIInformationFlow_ModifiedTimeWeak() {
        return (EAttribute)getIInformationFlow().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIInformationFlow_Description() {
        return (EReference)getIInformationFlow().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIInformationFlow_End1ObjectPort_() {
        return (EReference)getIInformationFlow().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIInformationFlow_End2ObjectPort_() {
        return (EReference)getIInformationFlow().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIInformationFlow_RequiremenTracabilityHandle() {
        return (EAttribute)getIInformationFlow().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIInformationFlow_HyperLinks() {
        return (EReference)getIInformationFlow().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIInformationFlow_Dependencies() {
        return (EReference)getIInformationFlow().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIInformationFlow_Annotations() {
        return (EReference)getIInformationFlow().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIInformationFlow_ObjectCreation() {
        return (EAttribute)getIInformationFlow().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIInformationFlow_UmlDependencyID() {
        return (EAttribute)getIInformationFlow().getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIInformationFlow_Stereotypes() {
        return (EReference)getIInformationFlow().getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIInformationFlow_Tags() {
        return (EReference)getIInformationFlow().getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIInformationItem() {
		if (iInformationItemEClass == null) {
			iInformationItemEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(134);
		}
		return iInformationItemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIInformationItem_Id() {
        return (EAttribute)getIInformationItem().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIInformationItem_MyState() {
        return (EAttribute)getIInformationItem().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIInformationItem_Name() {
        return (EAttribute)getIInformationItem().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIInformationItem_RequiremenTracabilityHandle() {
        return (EAttribute)getIInformationItem().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIInformationItem_ModifiedTimeWeak() {
        return (EAttribute)getIInformationItem().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIInformationItem_Description() {
        return (EReference)getIInformationItem().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIInformationItem_Represented() {
        return (EReference)getIInformationItem().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIInformationItem_Annotations() {
        return (EReference)getIInformationItem().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIInformationItem_ObjectCreation() {
        return (EAttribute)getIInformationItem().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIInformationItem_UmlDependencyID() {
        return (EAttribute)getIInformationItem().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIInstance() {
		if (iInstanceEClass == null) {
			iInstanceEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(135);
		}
		return iInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIInstance_ModifiedTimeWeak() {
        return (EAttribute)getIInstance().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIInstance_Id() {
        return (EAttribute)getIInstance().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIInstance_Inverse() {
        return (EReference)getIInstance().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIInstance_MyState() {
        return (EAttribute)getIInstance().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIInstance_Name() {
        return (EAttribute)getIInstance().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIInstanceSlot() {
		if (iInstanceSlotEClass == null) {
			iInstanceSlotEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(136);
		}
		return iInstanceSlotEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIInstanceSpecification() {
		if (iInstanceSpecificationEClass == null) {
			iInstanceSpecificationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(137);
		}
		return iInstanceSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIInstanceValue() {
		if (iInstanceValueEClass == null) {
			iInstanceValueEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(138);
		}
		return iInstanceValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIInstanceValue_Id() {
        return (EAttribute)getIInstanceValue().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIInstanceValue_ModifiedTimeWeak() {
        return (EAttribute)getIInstanceValue().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIInstanceValue_Value() {
        return (EReference)getIInstanceValue().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIInteractionOccurrence() {
		if (iInteractionOccurrenceEClass == null) {
			iInteractionOccurrenceEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(139);
		}
		return iInteractionOccurrenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIInteractionOccurrence_Id() {
        return (EAttribute)getIInteractionOccurrence().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIInteractionOccurrence_Name() {
        return (EAttribute)getIInteractionOccurrence().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIInteractionOccurrence_ModifiedTimeWeak() {
        return (EAttribute)getIInteractionOccurrence().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIInteractionOccurrence_M_pRefSD() {
        return (EReference)getIInteractionOccurrence().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIInteractionOccurrence_Stereotypes() {
        return (EReference)getIInteractionOccurrence().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIInteractionOccurrence_Tags() {
        return (EReference)getIInteractionOccurrence().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIInteractionOccurrence_ObjectCreation() {
        return (EAttribute)getIInteractionOccurrence().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIInteractionOccurrence_UmlDependencyID() {
        return (EAttribute)getIInteractionOccurrence().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIInteractionOperand() {
		if (iInteractionOperandEClass == null) {
			iInteractionOperandEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(140);
		}
		return iInteractionOperandEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIInteractionOperand_MyState() {
        return (EAttribute)getIInteractionOperand().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIInteractionOperand_Name() {
        return (EAttribute)getIInteractionOperand().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIInteractionOperand_InteractionConstraint() {
        return (EAttribute)getIInteractionOperand().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIInteractionOperator() {
		if (iInteractionOperatorEClass == null) {
			iInteractionOperatorEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(141);
		}
		return iInteractionOperatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIInterfaceItem() {
		if (iInterfaceItemEClass == null) {
			iInterfaceItemEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(142);
		}
		return iInterfaceItemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIInterfaceItemTrigger() {
		if (iInterfaceItemTriggerEClass == null) {
			iInterfaceItemTriggerEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(143);
		}
		return iInterfaceItemTriggerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIInterfaceItemTrigger_ItsInterfaceItem() {
        return (EReference)getIInterfaceItemTrigger().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIInterfaceItemTrigger_InheritsFromHandle() {
        return (EReference)getIInterfaceItemTrigger().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIInternalHyperlink() {
		if (iInternalHyperlinkEClass == null) {
			iInternalHyperlinkEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(144);
		}
		return iInternalHyperlinkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIInternalHyperlink_Target() {
        return (EReference)getIInternalHyperlink().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getILabel() {
		if (iLabelEClass == null) {
			iLabelEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(145);
		}
		return iLabelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getILabel_Id() {
        return (EAttribute)getILabel().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getILabel_ItsTrigger() {
        return (EReference)getILabel().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getILabel_ItsAction() {
        return (EReference)getILabel().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getILabel_ItsGuard() {
        return (EReference)getILabel().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getILabel_ModifiedTimeWeak() {
        return (EAttribute)getILabel().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getILabel_MyState() {
        return (EAttribute)getILabel().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getILabel_InheritsFromHandle() {
        return (EReference)getILabel().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getILabel_CodeUpdateCGTime() {
        return (EAttribute)getILabel().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getILabel_ObjectCreation() {
        return (EAttribute)getILabel().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getILabel_UmlDependencyID() {
        return (EAttribute)getILabel().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getILink() {
		if (iLinkEClass == null) {
			iLinkEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(146);
		}
		return iLinkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getILink_Inverse() {
        return (EReference)getILink().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getILink_LinkName() {
        return (EAttribute)getILink().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getILink_LinkType() {
        return (EAttribute)getILink().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getILink_MyState() {
        return (EAttribute)getILink().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getILinkInstance() {
		if (iLinkInstanceEClass == null) {
			iLinkInstanceEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(147);
		}
		return iLinkInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getILinkInstance_Id() {
        return (EAttribute)getILinkInstance().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getILinkInstance_Name() {
        return (EAttribute)getILinkInstance().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getILinkInstance_ToLink() {
        return (EReference)getILinkInstance().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getILinkInstance_FromLink() {
        return (EReference)getILinkInstance().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getILinkInstance_Instantiates() {
        return (EReference)getILinkInstance().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getILiteralSpecification() {
		if (iLiteralSpecificationEClass == null) {
			iLiteralSpecificationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(148);
		}
		return iLiteralSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getILiteralSpecification_Id() {
        return (EAttribute)getILiteralSpecification().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getILiteralSpecification_ModifiedTimeWeak() {
        return (EAttribute)getILiteralSpecification().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getILiteralSpecification_Value() {
        return (EAttribute)getILiteralSpecification().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getILiteralSpecification_MyState() {
        return (EAttribute)getILiteralSpecification().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getILiteralSpecification_Name() {
        return (EAttribute)getILiteralSpecification().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getILiteralSpecification_CodeUpdateCGTime() {
        return (EAttribute)getILiteralSpecification().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIMHyperLink() {
		if (imHyperLinkEClass == null) {
			imHyperLinkEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(149);
		}
		return imHyperLinkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIMHyperLink_Id() {
        return (EAttribute)getIMHyperLink().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIMHyperLink_Properties() {
        return (EReference)getIMHyperLink().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIMHyperLink_ModifiedTimeWeak() {
        return (EAttribute)getIMHyperLink().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIMHyperLink_DependsOn() {
        return (EReference)getIMHyperLink().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIMHyperLink_LinkDispName() {
        return (EAttribute)getIMHyperLink().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIMHyperLink_LinkType() {
        return (EAttribute)getIMHyperLink().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIMHyperLink_IsConfigurationFileHyperLink() {
        return (EAttribute)getIMHyperLink().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIMHyperLink_LinkTarget() {
        return (EAttribute)getIMHyperLink().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIMHyperLink_Description() {
        return (EReference)getIMHyperLink().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIMHyperLink_RequiremenTracabilityHandle() {
        return (EAttribute)getIMHyperLink().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIMHyperLink_ObjectCreation() {
        return (EAttribute)getIMHyperLink().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIMHyperLink_UmlDependencyID() {
        return (EAttribute)getIMHyperLink().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIMSC() {
		if (imscEClass == null) {
			imscEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(150);
		}
		return imscEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIMSC_Id() {
        return (EAttribute)getIMSC().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIMSC_MyState() {
        return (EAttribute)getIMSC().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIMSC_Properties() {
        return (EReference)getIMSC().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIMSC_Name() {
        return (EAttribute)getIMSC().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIMSC_LastModifiedTime() {
        return (EAttribute)getIMSC().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIMSC_GraphicChart() {
        return (EReference)getIMSC().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIMSC_DefaultSubsystem() {
        return (EReference)getIMSC().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIMSC_M_pICollaboration() {
        return (EReference)getIMSC().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIMSC_Cmheader() {
        return (EAttribute)getIMSC().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIMSC_LastID() {
        return (EAttribute)getIMSC().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIMSC_OwnerHandle() {
        return (EReference)getIMSC().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIMSC_Description() {
        return (EReference)getIMSC().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIMSC_ModifiedTimeWeak() {
        return (EAttribute)getIMSC().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIMSC_Stereotypes() {
        return (EReference)getIMSC().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIMSC_Tags() {
        return (EReference)getIMSC().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIMSC_RequiremenTracabilityHandle() {
        return (EAttribute)getIMSC().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIMSC_Annotations() {
        return (EReference)getIMSC().getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIMSC_ObjectCreation() {
        return (EAttribute)getIMSC().getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIMSC_UmlDependencyID() {
        return (EAttribute)getIMSC().getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIMatrixInstance() {
		if (iMatrixInstanceEClass == null) {
			iMatrixInstanceEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(151);
		}
		return iMatrixInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIMatrixInstance_Id() {
        return (EAttribute)getIMatrixInstance().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIMatrixInstance_MyState() {
        return (EAttribute)getIMatrixInstance().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIMatrixInstance_Name() {
        return (EAttribute)getIMatrixInstance().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIMatrixInstance_ModifiedTimeWeak() {
        return (EAttribute)getIMatrixInstance().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIMatrixInstance_LayoutHandle() {
        return (EReference)getIMatrixInstance().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIMatrixInstance_FromScopeHandles() {
        return (EReference)getIMatrixInstance().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIMatrixInstance_ToScopeHandles() {
        return (EReference)getIMatrixInstance().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIMatrixInstance_Stereotypes() {
        return (EReference)getIMatrixInstance().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIMatrixInstance_M_IncludeDescendants_to() {
        return (EAttribute)getIMatrixInstance().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIMatrixInstance_Properties() {
        return (EReference)getIMatrixInstance().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIMatrixLayout() {
		if (iMatrixLayoutEClass == null) {
			iMatrixLayoutEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(152);
		}
		return iMatrixLayoutEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIMatrixLayout_Id() {
        return (EAttribute)getIMatrixLayout().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIMatrixLayout_MyState() {
        return (EAttribute)getIMatrixLayout().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIMatrixLayout_Name() {
        return (EAttribute)getIMatrixLayout().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIMatrixLayout_ModifiedTimeWeak() {
        return (EAttribute)getIMatrixLayout().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIMatrixLayout_FromElementTypes() {
        return (EReference)getIMatrixLayout().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIMatrixLayout_ToElementTypes() {
        return (EReference)getIMatrixLayout().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIMatrixLayout_CellElementTypes() {
        return (EReference)getIMatrixLayout().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIMatrixLayout_Description() {
        return (EReference)getIMatrixLayout().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIMatrixView() {
		if (iMatrixViewEClass == null) {
			iMatrixViewEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(153);
		}
		return iMatrixViewEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIMessage() {
		if (iMessageEClass == null) {
			iMessageEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(154);
		}
		return iMessageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIMessage_Id() {
        return (EAttribute)getIMessage().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIMessage_MyState() {
        return (EAttribute)getIMessage().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIMessage_Name() {
        return (EAttribute)getIMessage().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIMessage_M_szSequence() {
        return (EAttribute)getIMessage().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIMessage_M_szActualArgs() {
        return (EAttribute)getIMessage().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIMessage_M_szReturnVal() {
        return (EAttribute)getIMessage().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIMessage_M_pReceiver() {
        return (EReference)getIMessage().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIMessage_M_pSender() {
        return (EReference)getIMessage().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIMessage_M_pFormalMessage() {
        return (EReference)getIMessage().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIMessage_M_eType() {
        return (EAttribute)getIMessage().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIMessage_M_pCommunicationConnection() {
        return (EReference)getIMessage().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIMessage_M_freeText() {
        return (EAttribute)getIMessage().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIMessage_ModifiedTimeWeak() {
        return (EAttribute)getIMessage().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIMessage_Stereotypes() {
        return (EReference)getIMessage().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIMessage_Tags() {
        return (EReference)getIMessage().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIMessage_Properties() {
        return (EReference)getIMessage().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIMessage_M_targetExec() {
        return (EReference)getIMessage().getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIMessage_M_srcExec() {
        return (EReference)getIMessage().getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIMessage_ObjectCreation() {
        return (EAttribute)getIMessage().getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIMessage_UmlDependencyID() {
        return (EAttribute)getIMessage().getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIMessagePoint() {
		if (iMessagePointEClass == null) {
			iMessagePointEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(155);
		}
		return iMessagePointEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIMetaLinkHandle() {
		if (iMetaLinkHandleEClass == null) {
			iMetaLinkHandleEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(156);
		}
		return iMetaLinkHandleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIMetaLinkHandle_M2Class() {
        return (EAttribute)getIMetaLinkHandle().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIMetaLinkHandle_Filename() {
        return (EAttribute)getIMetaLinkHandle().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIMetaLinkHandle_Subsystem() {
        return (EAttribute)getIMetaLinkHandle().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIMetaLinkHandle_Class() {
        return (EAttribute)getIMetaLinkHandle().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIMetaLinkHandle_Name() {
        return (EAttribute)getIMetaLinkHandle().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIMetaLinkHandle_Id() {
        return (EAttribute)getIMetaLinkHandle().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIModelElement() {
		if (iModelElementEClass == null) {
			iModelElementEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(157);
		}
		return iModelElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIModelElement_DisplayName() {
        return (EAttribute)getIModelElement().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIModule() {
		if (iModuleEClass == null) {
			iModuleEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(158);
		}
		return iModuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIModule_Stereotypes() {
        return (EReference)getIModule().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIModule_Description() {
        return (EReference)getIModule().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIModule_HyperLinks() {
        return (EReference)getIModule().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIModule_OtherClass() {
        return (EReference)getIModule().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIModule_ImplicitClass() {
        return (EReference)getIModule().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIModule_Properties() {
        return (EReference)getIModule().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIModule_RequiremenTracabilityHandle() {
        return (EAttribute)getIModule().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIModule_PartKind() {
        return (EAttribute)getIModule().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIMultiplicityItem() {
		if (iMultiplicityItemEClass == null) {
			iMultiplicityItemEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(159);
		}
		return iMultiplicityItemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIMultiplicityItem_Name() {
        return (EAttribute)getIMultiplicityItem().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIMultiplicityItem_Count() {
        return (EAttribute)getIMultiplicityItem().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getINode() {
		if (iNodeEClass == null) {
			iNodeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(160);
		}
		return iNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIObjectLink() {
		if (iObjectLinkEClass == null) {
			iObjectLinkEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(161);
		}
		return iObjectLinkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIObjectLink_Stereotypes() {
        return (EReference)getIObjectLink().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIObjectLink_Tags() {
        return (EReference)getIObjectLink().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIObjectLink_ToLink() {
        return (EReference)getIObjectLink().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIObjectLink_FromLink() {
        return (EReference)getIObjectLink().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIObjectLink_Instantiates() {
        return (EReference)getIObjectLink().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIObjectLink_End1Multiplicity() {
        return (EAttribute)getIObjectLink().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIObjectLink_End2Multiplicity() {
        return (EAttribute)getIObjectLink().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIObjectLink_ToPort() {
        return (EReference)getIObjectLink().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIObjectLink_FromPort() {
        return (EReference)getIObjectLink().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIObjectLink_Description() {
        return (EReference)getIObjectLink().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIObjectLink_RequiremenTracabilityHandle() {
        return (EAttribute)getIObjectLink().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIObjectLink_CodeUpdateCGTime() {
        return (EAttribute)getIObjectLink().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIObjectLink_ObjectCreation() {
        return (EAttribute)getIObjectLink().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIObjectLink_UmlDependencyID() {
        return (EAttribute)getIObjectLink().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIObjectLinkHandle() {
		if (iObjectLinkHandleEClass == null) {
			iObjectLinkHandleEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(162);
		}
		return iObjectLinkHandleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIObjectLinkHandle_M2Class() {
        return (EAttribute)getIObjectLinkHandle().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIObjectLinkHandle_Filename() {
        return (EAttribute)getIObjectLinkHandle().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIObjectLinkHandle_Subsystem() {
        return (EAttribute)getIObjectLinkHandle().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIObjectLinkHandle_Class() {
        return (EAttribute)getIObjectLinkHandle().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIObjectLinkHandle_Name() {
        return (EAttribute)getIObjectLinkHandle().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIObjectLinkHandle_Id() {
        return (EAttribute)getIObjectLinkHandle().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIObjectModelDiagram() {
		if (iObjectModelDiagramEClass == null) {
			iObjectModelDiagramEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(163);
		}
		return iObjectModelDiagramEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIObjectNode() {
		if (iObjectNodeEClass == null) {
			iObjectNodeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(164);
		}
		return iObjectNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIObjectNode_Represents() {
        return (EReference)getIObjectNode().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIObjectNode_TheInState() {
        return (EReference)getIObjectNode().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIObjectNode_InState() {
        return (EAttribute)getIObjectNode().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIOperation() {
		if (iOperationEClass == null) {
			iOperationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(165);
		}
		return iOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIPackage() {
		if (iPackageEClass == null) {
			iPackageEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(166);
		}
		return iPackageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIPackage_ModifiedTimeWeak() {
        return (EAttribute)getIPackage().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIPackage_Id() {
        return (EAttribute)getIPackage().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIPackage_Description() {
        return (EReference)getIPackage().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIPackage_UmlDependencyID() {
        return (EAttribute)getIPackage().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIPackage_LastID() {
        return (EAttribute)getIPackage().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIPackage_MyState() {
        return (EAttribute)getIPackage().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIPackage_Annotations() {
        return (EReference)getIPackage().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIPackage_ObjectCreation() {
        return (EAttribute)getIPackage().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIPackage_Stereotypes() {
        return (EReference)getIPackage().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIPackage_Name() {
        return (EAttribute)getIPackage().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIPackage_Properties() {
        return (EReference)getIPackage().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIPackage_Cmheader() {
        return (EAttribute)getIPackage().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIPanelDiagram() {
		if (iPanelDiagramEClass == null) {
			iPanelDiagramEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(167);
		}
		return iPanelDiagramEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIPart() {
		if (iPartEClass == null) {
			iPartEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(168);
		}
		return iPartEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIPart_Stereotypes() {
        return (EReference)getIPart().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIPart_OtherClass() {
        return (EReference)getIPart().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIPart_Inverse() {
        return (EReference)getIPart().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIPart_Dependencies() {
        return (EReference)getIPart().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIPart_Tags() {
        return (EReference)getIPart().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIPart_InitialCallAction() {
        return (EReference)getIPart().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIPart_CodeUpdateCGTime() {
        return (EAttribute)getIPart().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIPart_TheMainDiagram() {
        return (EReference)getIPart().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIPart_Slots() {
        return (EReference)getIPart().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIPart_HyperLinks() {
        return (EReference)getIPart().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIPin() {
		if (iPinEClass == null) {
			iPinEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(169);
		}
		return iPinEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIPin_M_type() {
        return (EReference)getIPin().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIPin_M_isParameterPin() {
        return (EAttribute)getIPin().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIPin_M_corePin() {
        return (EReference)getIPin().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIPort() {
		if (iPortEClass == null) {
			iPortEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(170);
		}
		return iPortEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIPort_OtherClass() {
        return (EReference)getIPort().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIPort_Behavioral() {
        return (EAttribute)getIPort().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIPort_Reversed() {
        return (EAttribute)getIPort().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIPort_Stereotypes() {
        return (EReference)getIPort().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIPort_Tags() {
        return (EReference)getIPort().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIPort_ObjectCreation() {
        return (EAttribute)getIPort().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIPort_UmlDependencyID() {
        return (EAttribute)getIPort().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIPort_LastID() {
        return (EAttribute)getIPort().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIPort_Dependencies() {
        return (EReference)getIPort().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIPort_Annotations() {
        return (EReference)getIPort().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIPrimitiveOperation() {
		if (iPrimitiveOperationEClass == null) {
			iPrimitiveOperationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(171);
		}
		return iPrimitiveOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIPrimitiveOperation_Properties() {
        return (EReference)getIPrimitiveOperation().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIPrimitiveOperation_LastID() {
        return (EAttribute)getIPrimitiveOperation().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIPrimitiveOperation_Args() {
        return (EReference)getIPrimitiveOperation().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIPrimitiveOperation_ReturnType() {
        return (EReference)getIPrimitiveOperation().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIPrimitiveOperation_Abstract() {
        return (EAttribute)getIPrimitiveOperation().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIPrimitiveOperation_Final() {
        return (EAttribute)getIPrimitiveOperation().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIPrimitiveOperation_Concurrency() {
        return (EAttribute)getIPrimitiveOperation().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIPrimitiveOperation_Protection() {
        return (EAttribute)getIPrimitiveOperation().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIPrimitiveOperation_Static() {
        return (EAttribute)getIPrimitiveOperation().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIPrimitiveOperation_Constant() {
        return (EAttribute)getIPrimitiveOperation().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIPrimitiveOperation_ItsBody() {
        return (EReference)getIPrimitiveOperation().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIPrimitiveOperation_Tags() {
        return (EReference)getIPrimitiveOperation().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIPrimitiveOperation_Annotations() {
        return (EReference)getIPrimitiveOperation().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIPrimitiveOperation_Dependencies() {
        return (EReference)getIPrimitiveOperation().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIPrimitiveOperation_Stereotypes() {
        return (EReference)getIPrimitiveOperation().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIPrimitiveOperation_MyReturnType() {
        return (EReference)getIPrimitiveOperation().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIPrimitiveOperation_Description() {
        return (EReference)getIPrimitiveOperation().getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIPrimitiveOperation_RequiremenTracabilityHandle() {
        return (EAttribute)getIPrimitiveOperation().getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIPrimitiveOperation_Declaratives() {
        return (EReference)getIPrimitiveOperation().getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIPrimitiveOperation_ItsActivityGraph() {
        return (EReference)getIPrimitiveOperation().getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIPrimitiveOperation_EmbededFiles() {
        return (EReference)getIPrimitiveOperation().getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIPrimitiveOperation_CodeUpdateCGTime() {
        return (EAttribute)getIPrimitiveOperation().getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIPrimitiveOperation_TemplateParameters() {
        return (EReference)getIPrimitiveOperation().getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIProfile() {
		if (iProfileEClass == null) {
			iProfileEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(172);
		}
		return iProfileEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIProfile_Declaratives() {
        return (EReference)getIProfile().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIProfile_DefaultComposite() {
        return (EReference)getIProfile().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIProfile_EventsBaseID() {
        return (EAttribute)getIProfile().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIProfile_Classes() {
        return (EReference)getIProfile().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIProfile_ConfigurationRelatedTime() {
        return (EAttribute)getIProfile().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIProfile_Tags() {
        return (EReference)getIProfile().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIProfile_Types() {
        return (EReference)getIProfile().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIProfile_MatrixLayouts() {
        return (EReference)getIProfile().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIProfile_License() {
        return (EAttribute)getIProfile().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIProject() {
		if (iProjectEClass == null) {
			iProjectEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(173);
		}
		return iProjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIProject_UserColors() {
        return (EAttribute)getIProject().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIProject_DefaultSubsystem() {
        return (EReference)getIProject().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIProject_Component() {
        return (EReference)getIProject().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIProject_Multiplicities() {
        return (EReference)getIProject().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIProject_Subsystems() {
        return (EReference)getIProject().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIProject_Diagrams() {
        return (EReference)getIProject().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIProject_Components() {
        return (EReference)getIProject().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIProject_PanelDiagrams() {
        return (EReference)getIProject().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIProject_HyperLinks() {
        return (EReference)getIProject().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIProject_MSCS() {
        return (EReference)getIProject().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIProject_UCDiagrams() {
        return (EReference)getIProject().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIProject_CollaborationDiagrams() {
        return (EReference)getIProject().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIProject_Declaratives() {
        return (EReference)getIProject().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIProject_ComponentDiagrams() {
        return (EReference)getIProject().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIProject_UnitSccProjName() {
        return (EAttribute)getIProject().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIProject_UnitSccProjPath() {
        return (EAttribute)getIProject().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIProject_Dependencies() {
        return (EReference)getIProject().getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIProject_CodeUpdateCGTime() {
        return (EAttribute)getIProject().getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIProject_Version() {
        return (EAttribute)getIProject().getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIProperty() {
		if (iPropertyEClass == null) {
			iPropertyEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(174);
		}
		return iPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIProperty_Name() {
        return (EAttribute)getIProperty().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIProperty_Value() {
        return (EAttribute)getIProperty().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIProperty_Type() {
        return (EAttribute)getIProperty().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIProperty_ExtraTypeInfo() {
        return (EAttribute)getIProperty().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIPropertyContainer() {
		if (iPropertyContainerEClass == null) {
			iPropertyContainerEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(175);
		}
		return iPropertyContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIPropertyContainer_Subjects() {
        return (EReference)getIPropertyContainer().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIPropertyMetaclass() {
		if (iPropertyMetaclassEClass == null) {
			iPropertyMetaclassEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(176);
		}
		return iPropertyMetaclassEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIPropertyMetaclass_Name() {
        return (EAttribute)getIPropertyMetaclass().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIPropertyMetaclass_Properties() {
        return (EReference)getIPropertyMetaclass().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIPropertySubject() {
		if (iPropertySubjectEClass == null) {
			iPropertySubjectEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(177);
		}
		return iPropertySubjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIPropertySubject_Name() {
        return (EAttribute)getIPropertySubject().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIPropertySubject_Metaclasses() {
        return (EReference)getIPropertySubject().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIReception() {
		if (iReceptionEClass == null) {
			iReceptionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(178);
		}
		return iReceptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIReception_Id() {
        return (EAttribute)getIReception().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIReception_MyState() {
        return (EAttribute)getIReception().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIReception_Args() {
        return (EReference)getIReception().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIReception_Event() {
        return (EReference)getIReception().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIReception_ModifiedTimeWeak() {
        return (EAttribute)getIReception().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIReception_Dependencies() {
        return (EReference)getIReception().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIReception_LastID() {
        return (EAttribute)getIReception().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIReception_RequiremenTracabilityHandle() {
        return (EAttribute)getIReception().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIReception_Description() {
        return (EReference)getIReception().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIReception_ObjectCreation() {
        return (EAttribute)getIReception().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIReception_UmlDependencyID() {
        return (EAttribute)getIReception().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIReferenceActivity() {
		if (iReferenceActivityEClass == null) {
			iReferenceActivityEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(179);
		}
		return iReferenceActivityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIReferenceActivity_Id() {
        return (EAttribute)getIReferenceActivity().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIReferenceActivity_Name() {
        return (EAttribute)getIReferenceActivity().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIReferenceActivity_Stereotypes() {
        return (EReference)getIReferenceActivity().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIReferenceActivity_ModifiedTimeWeak() {
        return (EAttribute)getIReferenceActivity().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIReferenceActivity_Parent() {
        return (EReference)getIReferenceActivity().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIReferenceActivity_StateType() {
        return (EAttribute)getIReferenceActivity().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIReferenceActivity_DefaultTrans() {
        return (EAttribute)getIReferenceActivity().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIReferenceActivity_Swimlane() {
        return (EReference)getIReferenceActivity().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIReferenceActivity_ReferencedActivity() {
        return (EReference)getIReferenceActivity().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIReferenceActivity_MyState() {
        return (EAttribute)getIReferenceActivity().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIRelation() {
		if (iRelationEClass == null) {
			iRelationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(180);
		}
		return iRelationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIRequirement() {
		if (iRequirementEClass == null) {
			iRequirementEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(181);
		}
		return iRequirementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIRequirement_Id() {
        return (EAttribute)getIRequirement().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIRequirement_Name() {
        return (EAttribute)getIRequirement().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIRequirement_Annotations() {
        return (EReference)getIRequirement().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIRequirement_MyState() {
        return (EAttribute)getIRequirement().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIRequirement_LastID() {
        return (EAttribute)getIRequirement().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIRequirement_Stereotypes() {
        return (EReference)getIRequirement().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIRequirement_ModifiedTimeWeak() {
        return (EAttribute)getIRequirement().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIRequirement_ReqID() {
        return (EAttribute)getIRequirement().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIRequirement_Dependencies() {
        return (EReference)getIRequirement().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIRequirement_Anchors() {
        return (EReference)getIRequirement().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIRequirement_HyperLinks() {
        return (EReference)getIRequirement().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIRequirement_TheMainDiagram() {
        return (EReference)getIRequirement().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getISendAction() {
		if (iSendActionEClass == null) {
			iSendActionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(182);
		}
		return iSendActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getISendAction_M_hTarget() {
        return (EReference)getISendAction().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getISendAction_M_hEvent() {
        return (EReference)getISendAction().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getISendAction_ArgValCount() {
        return (EAttribute)getISendAction().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getISendAction_GraphElements() {
        return (EReference)getISendAction().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getISequenceDiagram() {
		if (iSequenceDiagramEClass == null) {
			iSequenceDiagramEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(183);
		}
		return iSequenceDiagramEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getISlot() {
		if (iSlotEClass == null) {
			iSlotEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(184);
		}
		return iSlotEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getISlot_Id() {
        return (EAttribute)getISlot().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getISlot_Name() {
        return (EAttribute)getISlot().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getISlot_Value() {
        return (EAttribute)getISlot().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getISlot_DefiningVar() {
        return (EReference)getISlot().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIState() {
		if (iStateEClass == null) {
			iStateEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(185);
		}
		return iStateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIState_Parent() {
        return (EReference)getIState().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIState_StateType() {
        return (EAttribute)getIState().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIState_DefaultTrans() {
        return (EReference)getIState().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIState_EntryAction() {
        return (EReference)getIState().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIState_InheritsFromHandle() {
        return (EReference)getIState().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIState_ExitAction() {
        return (EReference)getIState().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIState_NestedStateChart() {
        return (EReference)getIState().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIState_RequiremenTracabilityHandle() {
        return (EAttribute)getIState().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIState_Annotations() {
        return (EReference)getIState().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIState_Dependencies() {
        return (EReference)getIState().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIState_TheMainDiagram() {
        return (EReference)getIState().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIState_Swimlane() {
        return (EReference)getIState().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIState_CodeUpdateCGTime() {
        return (EAttribute)getIState().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIStateChart() {
		if (iStateChartEClass == null) {
			iStateChartEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(186);
		}
		return iStateChartEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIStateChart_States() {
        return (EReference)getIStateChart().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIStateChart_BaseVersion() {
        return (EAttribute)getIStateChart().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIStateChart_Diagram() {
        return (EReference)getIStateChart().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIStateChart_Views() {
        return (EReference)getIStateChart().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIStateChart_InheritsFromHandle() {
        return (EReference)getIStateChart().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIStateChartDiagram() {
		if (iStateChartDiagramEClass == null) {
			iStateChartDiagramEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(187);
		}
		return iStateChartDiagramEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIStateVertex() {
		if (iStateVertexEClass == null) {
			iStateVertexEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(188);
		}
		return iStateVertexEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIStateVertex_ModifiedTimeWeak() {
        return (EAttribute)getIStateVertex().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIStateVertex_Id() {
        return (EAttribute)getIStateVertex().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIStateVertex_Description() {
        return (EReference)getIStateVertex().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIStateVertex_UmlDependencyID() {
        return (EAttribute)getIStateVertex().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIStateVertex_MyState() {
        return (EAttribute)getIStateVertex().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIStateVertex_Stereotypes() {
        return (EReference)getIStateVertex().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIStateVertex_ObjectCreation() {
        return (EAttribute)getIStateVertex().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIStateVertex_Name() {
        return (EAttribute)getIStateVertex().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIStereotype() {
		if (iStereotypeEClass == null) {
			iStereotypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(189);
		}
		return iStereotypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIStereotype_Properties() {
        return (EReference)getIStereotype().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIStereotype_M2Classes() {
        return (EAttribute)getIStereotype().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIStereotype_NewTerm() {
        return (EAttribute)getIStereotype().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIStereotype_Description() {
        return (EReference)getIStereotype().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIStereotype_Tags() {
        return (EReference)getIStereotype().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIStereotype_LastID() {
        return (EAttribute)getIStereotype().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIStereotype_Inheritances() {
        return (EReference)getIStereotype().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIStereotype_Dependencies() {
        return (EReference)getIStereotype().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIStereotype_RequiremenTracabilityHandle() {
        return (EAttribute)getIStereotype().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIStereotype_ObjectCreation() {
        return (EAttribute)getIStereotype().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIStereotype_UmlDependencyID() {
        return (EAttribute)getIStereotype().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIStereotype_TheMainDiagram() {
        return (EReference)getIStereotype().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIStereotype_Annotations() {
        return (EReference)getIStereotype().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIStructureDiagram() {
		if (iStructureDiagramEClass == null) {
			iStructureDiagramEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(190);
		}
		return iStructureDiagramEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getISubsystem() {
		if (iSubsystemEClass == null) {
			iSubsystemEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(191);
		}
		return iSubsystemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getISubsystem_Id() {
        return (EAttribute)getISubsystem().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getISubsystem_MyState() {
        return (EAttribute)getISubsystem().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getISubsystem_Name() {
        return (EAttribute)getISubsystem().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getISubsystem_ModifiedTimeWeak() {
        return (EAttribute)getISubsystem().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getISubsystem_DefaultComposite() {
        return (EReference)getISubsystem().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getISubsystem_EventsBaseID() {
        return (EAttribute)getISubsystem().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getISubsystem_Classes() {
        return (EReference)getISubsystem().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getISubsystem_ConfigurationRelatedTime() {
        return (EAttribute)getISubsystem().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getISubsystem_Properties() {
        return (EReference)getISubsystem().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getISubsystem_LastID() {
        return (EAttribute)getISubsystem().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getISubsystem_Cmheader() {
        return (EAttribute)getISubsystem().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getISubsystem_Declaratives() {
        return (EReference)getISubsystem().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getISubsystem_Types() {
        return (EReference)getISubsystem().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getISubsystem_Stereotypes() {
        return (EReference)getISubsystem().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getISubsystem_PredefinedTypes() {
        return (EAttribute)getISubsystem().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getISubsystem_Events() {
        return (EReference)getISubsystem().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getISubsystem_Annotations() {
        return (EReference)getISubsystem().getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getISubsystem_UseCases() {
        return (EReference)getISubsystem().getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getISubsystem_Actors() {
        return (EReference)getISubsystem().getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getISubsystem_Description() {
        return (EReference)getISubsystem().getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getISubsystem_Tags() {
        return (EReference)getISubsystem().getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getISubsystem_AssociationElements() {
        return (EReference)getISubsystem().getEStructuralFeatures().get(35);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getISubsystem_Dependencies() {
        return (EReference)getISubsystem().getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getISubsystem_OwnerHandle() {
        return (EReference)getISubsystem().getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getISubsystem_TheMainDiagram() {
        return (EReference)getISubsystem().getEStructuralFeatures().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getISubsystem_HyperLinks() {
        return (EReference)getISubsystem().getEStructuralFeatures().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getISubsystem_TableLayouts() {
        return (EReference)getISubsystem().getEStructuralFeatures().get(25);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getISubsystem_MatrixLayouts() {
        return (EReference)getISubsystem().getEStructuralFeatures().get(26);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getISubsystem_TableInstances() {
        return (EReference)getISubsystem().getEStructuralFeatures().get(27);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getISubsystem_MatrixInstances() {
        return (EReference)getISubsystem().getEStructuralFeatures().get(28);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getISubsystem_EmbededFiles() {
        return (EReference)getISubsystem().getEStructuralFeatures().get(29);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getISubsystem_ComponentFiles() {
        return (EReference)getISubsystem().getEStructuralFeatures().get(30);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getISubsystem_RequiremenTracabilityHandle() {
        return (EAttribute)getISubsystem().getEStructuralFeatures().get(31);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getISubsystem_CodeUpdateCGTime() {
        return (EAttribute)getISubsystem().getEStructuralFeatures().get(32);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getISubsystem_ObjectCreation() {
        return (EAttribute)getISubsystem().getEStructuralFeatures().get(33);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getISubsystem_UmlDependencyID() {
        return (EAttribute)getISubsystem().getEStructuralFeatures().get(34);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getISwimlane() {
		if (iSwimlaneEClass == null) {
			iSwimlaneEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(192);
		}
		return iSwimlaneEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getISwimlane_Id() {
        return (EAttribute)getISwimlane().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getISwimlane_Name() {
        return (EAttribute)getISwimlane().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getISwimlane_ModifiedTimeWeak() {
        return (EAttribute)getISwimlane().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getISwimlane_Description() {
        return (EReference)getISwimlane().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getISwimlane_Represents() {
        return (EReference)getISwimlane().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getISwimlane_MyState() {
        return (EAttribute)getISwimlane().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getISwimlane_ObjectCreation() {
        return (EAttribute)getISwimlane().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getISwimlane_UmlDependencyID() {
        return (EAttribute)getISwimlane().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getISwimlane_Swimlanes() {
        return (EReference)getISwimlane().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getISwimlane_Stereotypes() {
        return (EReference)getISwimlane().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getISysMLPort() {
		if (iSysMLPortEClass == null) {
			iSysMLPortEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(193);
		}
		return iSysMLPortEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getISysMLPort_Dependencies() {
        return (EReference)getISysMLPort().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getISysMLPort_Stereotypes() {
        return (EReference)getISysMLPort().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getISysMLPort_Tags() {
        return (EReference)getISysMLPort().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getISysMLPort_OtherClass() {
        return (EReference)getISysMLPort().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getISysMLPort_Direction() {
        return (EAttribute)getISysMLPort().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getISysMLPort_Description() {
        return (EReference)getISysMLPort().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getISysMLPort_LastID() {
        return (EAttribute)getISysMLPort().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getISysMLPort_Reversed() {
        return (EAttribute)getISysMLPort().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getITableInstance() {
		if (iTableInstanceEClass == null) {
			iTableInstanceEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(194);
		}
		return iTableInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getITableInstance_Id() {
        return (EAttribute)getITableInstance().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getITableInstance_MyState() {
        return (EAttribute)getITableInstance().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getITableInstance_Properties() {
        return (EReference)getITableInstance().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getITableInstance_Name() {
        return (EAttribute)getITableInstance().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getITableInstance_ModifiedTimeWeak() {
        return (EAttribute)getITableInstance().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getITableInstance_LayoutHandle() {
        return (EReference)getITableInstance().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getITableInstance_ScopeHandles() {
        return (EReference)getITableInstance().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getITableInstance_Stereotypes() {
        return (EReference)getITableInstance().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getITableLayout() {
		if (iTableLayoutEClass == null) {
			iTableLayoutEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(195);
		}
		return iTableLayoutEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getITableLayout_Properties() {
        return (EReference)getITableLayout().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getITableLayout_Stereotypes() {
        return (EReference)getITableLayout().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getITableLayout_Tags() {
        return (EReference)getITableLayout().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getITableLayout_TableElementTypes() {
        return (EReference)getITableLayout().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getITableLayout_DataColumns() {
        return (EReference)getITableLayout().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getITableLayout_Description() {
        return (EReference)getITableLayout().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getITableView() {
		if (iTableViewEClass == null) {
			iTableViewEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(196);
		}
		return iTableViewEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getITag() {
		if (iTagEClass == null) {
			iTagEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(197);
		}
		return iTagEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getITag_Id() {
        return (EAttribute)getITag().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getITag_Name() {
        return (EAttribute)getITag().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getITag_ModifiedTimeWeak() {
        return (EAttribute)getITag().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getITag_ValueSpecifications() {
        return (EReference)getITag().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getITag_TypeOf() {
        return (EReference)getITag().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getITag_MyState() {
        return (EAttribute)getITag().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getITag_Multiplicity() {
        return (EAttribute)getITag().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getITag_Properties() {
        return (EReference)getITag().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getITag_Description() {
        return (EReference)getITag().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getITag_HyperLinks() {
        return (EReference)getITag().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getITag_Base() {
        return (EReference)getITag().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getITag_MetaClass() {
        return (EAttribute)getITag().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getITag_DefaultValue() {
        return (EAttribute)getITag().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getITag_CodeUpdateCGTime() {
        return (EAttribute)getITag().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getITemplateInst() {
		if (iTemplateInstEClass == null) {
			iTemplateInstEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(198);
		}
		return iTemplateInstEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getITemplateInst_Id() {
        return (EAttribute)getITemplateInst().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getITemplateInst_ModifiedTimeWeak() {
        return (EAttribute)getITemplateInst().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getITemplateInst_TemplateInstParams() {
        return (EReference)getITemplateInst().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getITemplateInst_OfTemplate() {
        return (EReference)getITemplateInst().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getITemplateInstParam() {
		if (iTemplateInstParamEClass == null) {
			iTemplateInstParamEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(199);
		}
		return iTemplateInstParamEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getITemplateInstParam_Id() {
        return (EAttribute)getITemplateInstParam().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getITemplateInstParam_Name() {
        return (EAttribute)getITemplateInstParam().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getITemplateInstParam_ModifiedTimeWeak() {
        return (EAttribute)getITemplateInstParam().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getITemplateInstParam_Value() {
        return (EReference)getITemplateInstParam().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getITemplateInstParam_ArgValue() {
        return (EAttribute)getITemplateInstParam().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getITemplateInstParam_OnTheFlyValue() {
        return (EAttribute)getITemplateInstParam().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getITemplateInstantiation() {
		if (iTemplateInstantiationEClass == null) {
			iTemplateInstantiationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(200);
		}
		return iTemplateInstantiationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getITemplateInstantiationParameter() {
		if (iTemplateInstantiationParameterEClass == null) {
			iTemplateInstantiationParameterEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(201);
		}
		return iTemplateInstantiationParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getITemplateParameter() {
		if (iTemplateParameterEClass == null) {
			iTemplateParameterEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(202);
		}
		return iTemplateParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getITemplateParameter_Id() {
        return (EAttribute)getITemplateParameter().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getITemplateParameter_Name() {
        return (EAttribute)getITemplateParameter().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getITemplateParameter_MyState() {
        return (EAttribute)getITemplateParameter().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getITemplateParameter_ModifiedTimeWeak() {
        return (EAttribute)getITemplateParameter().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getITemplateParameter_Representative() {
        return (EReference)getITemplateParameter().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getITimeEvent() {
		if (iTimeEventEClass == null) {
			iTimeEventEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(203);
		}
		return iTimeEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getITimeEvent_Id() {
        return (EAttribute)getITimeEvent().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getITimeEvent_MyState() {
        return (EAttribute)getITimeEvent().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getITimeEvent_Name() {
        return (EAttribute)getITimeEvent().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getITimeEvent_ModifiedTimeWeak() {
        return (EAttribute)getITimeEvent().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getITimeEvent_Parent() {
        return (EReference)getITimeEvent().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getITimeEvent_StateType() {
        return (EAttribute)getITimeEvent().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getITimeEvent_DefaultTrans() {
        return (EAttribute)getITimeEvent().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getITimeEvent_DurationTime() {
        return (EAttribute)getITimeEvent().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getITimeEvent_Swimlane() {
        return (EReference)getITimeEvent().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getITimeout() {
		if (iTimeoutEClass == null) {
			iTimeoutEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(204);
		}
		return iTimeoutEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getITimeout_Time() {
        return (EAttribute)getITimeout().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getITimeout_InheritsFromHandle() {
        return (EReference)getITimeout().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getITransition() {
		if (iTransitionEClass == null) {
			iTransitionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(205);
		}
		return iTransitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getITransition_ItsSource() {
        return (EReference)getITransition().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getITransition_InheritsFromHandle() {
        return (EReference)getITransition().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getITransition_Dependencies() {
        return (EReference)getITransition().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getITransition_Stereotypes() {
        return (EReference)getITransition().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getITrigger() {
		if (iTriggerEClass == null) {
			iTriggerEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(206);
		}
		return iTriggerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getITriggered() {
		if (iTriggeredEClass == null) {
			iTriggeredEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(207);
		}
		return iTriggeredEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getITriggered_Id() {
        return (EAttribute)getITriggered().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getITriggered_Name() {
        return (EAttribute)getITriggered().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getITriggered_Args() {
        return (EReference)getITriggered().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getITriggered_ReturnType() {
        return (EReference)getITriggered().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getITriggered_Abstract() {
        return (EAttribute)getITriggered().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getITriggered_Final() {
        return (EAttribute)getITriggered().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getITriggered_Concurrency() {
        return (EAttribute)getITriggered().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getITriggered_Protection() {
        return (EAttribute)getITriggered().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getITriggered_ModifiedTimeWeak() {
        return (EAttribute)getITriggered().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getITriggered_MyState() {
        return (EAttribute)getITriggered().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIType() {
		if (iTypeEClass == null) {
			iTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(208);
		}
		return iTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIType_LastID() {
        return (EAttribute)getIType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIType_Literals() {
        return (EReference)getIType().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIType_Kind() {
        return (EAttribute)getIType().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIType_Properties() {
        return (EReference)getIType().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIType_Description() {
        return (EReference)getIType().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIType_Declaration() {
        return (EAttribute)getIType().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIType_Stereotypes() {
        return (EReference)getIType().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIType_Attrs() {
        return (EReference)getIType().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIType_AssociationElements() {
        return (EReference)getIType().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIType_Tags() {
        return (EReference)getIType().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIType_TypedefBaseType() {
        return (EReference)getIType().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIType_TypedefMultiplicity() {
        return (EAttribute)getIType().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIType_TypedefIsOrdered() {
        return (EAttribute)getIType().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIType_TypedefIsReference() {
        return (EAttribute)getIType().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIType_TypedefIsConstant() {
        return (EAttribute)getIType().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIType_RequiremenTracabilityHandle() {
        return (EAttribute)getIType().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIType_CodeUpdateCGTime() {
        return (EAttribute)getIType().getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIType_TheMainDiagram() {
        return (EReference)getIType().getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIUCDiagram() {
		if (iucDiagramEClass == null) {
			iucDiagramEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(209);
		}
		return iucDiagramEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIUCDiagram_Properties() {
        return (EReference)getIUCDiagram().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIUCDiagram_GraphicChart() {
        return (EReference)getIUCDiagram().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIUCDiagram_ModifiedTimeWeak() {
        return (EAttribute)getIUCDiagram().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIUnit() {
		if (iUnitEClass == null) {
			iUnitEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(210);
		}
		return iUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIUseCase() {
		if (iUseCaseEClass == null) {
			iUseCaseEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(211);
		}
		return iUseCaseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIUseCase_Id() {
        return (EAttribute)getIUseCase().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIUseCase_MyState() {
        return (EAttribute)getIUseCase().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIUseCase_Name() {
        return (EAttribute)getIUseCase().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIUseCase_TheMainDiagram() {
        return (EReference)getIUseCase().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIUseCase_HyperLinks() {
        return (EReference)getIUseCase().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIUseCase_WeakCGTime() {
        return (EAttribute)getIUseCase().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIUseCase_StrongCGTime() {
        return (EAttribute)getIUseCase().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIUseCase_ClassModifier() {
        return (EAttribute)getIUseCase().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIUseCase_Description() {
        return (EReference)getIUseCase().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIUseCase_Inheritances() {
        return (EReference)getIUseCase().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIUseCase_Associations() {
        return (EReference)getIUseCase().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIUseCase_UseCaseStereoTypes() {
        return (EReference)getIUseCase().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIUseCase_EntryPoints() {
        return (EAttribute)getIUseCase().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIUseCase_Dependencies() {
        return (EReference)getIUseCase().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIUseCase_LastID() {
        return (EAttribute)getIUseCase().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIUseCase_Diagrams() {
        return (EReference)getIUseCase().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIUseCase_ModifiedTimeWeak() {
        return (EAttribute)getIUseCase().getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIUseCase_RequiremenTracabilityHandle() {
        return (EAttribute)getIUseCase().getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIUseCase_Cmheader() {
        return (EAttribute)getIUseCase().getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIUseCase_OwnerHandle() {
        return (EReference)getIUseCase().getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIUseCase_Declaratives() {
        return (EReference)getIUseCase().getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIUseCase_Operations() {
        return (EReference)getIUseCase().getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIUseCase_StateCharts() {
        return (EReference)getIUseCase().getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIUseCase_ItsStateChart() {
        return (EReference)getIUseCase().getEStructuralFeatures().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIUseCase_Attrs() {
        return (EReference)getIUseCase().getEStructuralFeatures().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIUseCase_Annotations() {
        return (EReference)getIUseCase().getEStructuralFeatures().get(25);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIUseCase_EmbededFiles() {
        return (EReference)getIUseCase().getEStructuralFeatures().get(26);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIUseCase_ObjectCreation() {
        return (EAttribute)getIUseCase().getEStructuralFeatures().get(27);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIUseCase_UmlDependencyID() {
        return (EAttribute)getIUseCase().getEStructuralFeatures().get(28);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIUseCase_ObjectLinks() {
        return (EReference)getIUseCase().getEStructuralFeatures().get(29);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIUseCase_Properties() {
        return (EReference)getIUseCase().getEStructuralFeatures().get(30);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIUseCaseDiagram() {
		if (iUseCaseDiagramEClass == null) {
			iUseCaseDiagramEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(212);
		}
		return iUseCaseDiagramEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIUseCaseStereoType() {
		if (iUseCaseStereoTypeEClass == null) {
			iUseCaseStereoTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(213);
		}
		return iUseCaseStereoTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIUseCaseStereoType_UseCase() {
        return (EReference)getIUseCaseStereoType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIUseCaseStereoType_StereoType() {
        return (EAttribute)getIUseCaseStereoType().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIUseCaseStereoType_EntryPoint() {
        return (EAttribute)getIUseCaseStereoType().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIValueSpecification() {
		if (iValueSpecificationEClass == null) {
			iValueSpecificationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(214);
		}
		return iValueSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIVariable() {
		if (iVariableEClass == null) {
			iVariableEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(215);
		}
		return iVariableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIVariable_IsOrdered() {
        return (EAttribute)getIVariable().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIVariable_MyTypeOf() {
        return (EReference)getIVariable().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInverseType() {
		if (inverseTypeEClass == null) {
			inverseTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(216);
		}
		return inverseTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getItemsType() {
		if (itemsTypeEClass == null) {
			itemsTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(217);
		}
		return itemsTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getItsLabelType() {
		if (itsLabelTypeEClass == null) {
			itsLabelTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(218);
		}
		return itsLabelTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getItsStateChartType() {
		if (itsStateChartTypeEClass == null) {
			itsStateChartTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(219);
		}
		return itsStateChartTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getItsTargetType() {
		if (itsTargetTypeEClass == null) {
			itsTargetTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(220);
		}
		return itsTargetTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getItsTriggerType() {
		if (itsTriggerTypeEClass == null) {
			itsTriggerTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(221);
		}
		return itsTriggerTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getItsTriggerType_ModifiedTimeWeak() {
        return (EAttribute)getItsTriggerType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getItsTriggerType_Id() {
        return (EAttribute)getItsTriggerType().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getItsTriggerType_Info() {
        return (EAttribute)getItsTriggerType().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getItsTriggerType_UmlDependencyID() {
        return (EAttribute)getItsTriggerType().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getItsTriggerType_MyState() {
        return (EAttribute)getItsTriggerType().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getItsTriggerType_ObjectCreation() {
        return (EAttribute)getItsTriggerType().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getItsTriggerType_Body() {
        return (EAttribute)getItsTriggerType().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLinksType() {
		if (linksTypeEClass == null) {
			linksTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(222);
		}
		return linksTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLinksType_Id() {
        return (EAttribute)getLinksType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLinksType_Multiplicity() {
        return (EAttribute)getLinksType().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLinksType_Name() {
        return (EAttribute)getLinksType().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLinksType_OtherClass() {
        return (EReference)getLinksType().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getM_hTargetType() {
		if (m_hTargetTypeEClass == null) {
			m_hTargetTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(223);
		}
		return m_hTargetTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getM_hTargetType_RequiremenTracabilityHandle() {
        return (EAttribute)getM_hTargetType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getM_hTargetType_Description() {
        return (EReference)getM_hTargetType().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getM_hTargetType_Properties() {
        return (EReference)getM_hTargetType().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getM_pBaseType() {
		if (m_pBaseTypeEClass == null) {
			m_pBaseTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(224);
		}
		return m_pBaseTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getM_pFormalMessageType() {
		if (m_pFormalMessageTypeEClass == null) {
			m_pFormalMessageTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(225);
		}
		return m_pFormalMessageTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getM_pModelObjectType() {
		if (m_pModelObjectTypeEClass == null) {
			m_pModelObjectTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(226);
		}
		return m_pModelObjectTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getM_pRootType() {
		if (m_pRootTypeEClass == null) {
			m_pRootTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(227);
		}
		return m_pRootTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getM_subjectType() {
		if (m_subjectTypeEClass == null) {
			m_subjectTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(228);
		}
		return m_subjectTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getM_subjectType_UmlDependencyID() {
        return (EAttribute)getM_subjectType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getM_subjectType_ObjectCreation() {
        return (EAttribute)getM_subjectType().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMatrixInstancesType() {
		if (matrixInstancesTypeEClass == null) {
			matrixInstancesTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(229);
		}
		return matrixInstancesTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNestedStateChartType() {
		if (nestedStateChartTypeEClass == null) {
			nestedStateChartTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(230);
		}
		return nestedStateChartTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNestedStateChartType_DefNumber() {
        return (EAttribute)getNestedStateChartType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNestedStateChartType_GraphicChart() {
        return (EReference)getNestedStateChartType().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNestedStateChartType_LastModifiedTime() {
        return (EAttribute)getNestedStateChartType().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNestedStateChartType_Transitions() {
        return (EReference)getNestedStateChartType().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNestedStateChartType_Connectors() {
        return (EReference)getNestedStateChartType().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNestedStateChartType_Version() {
        return (EAttribute)getNestedStateChartType().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getObjectLinksType() {
		if (objectLinksTypeEClass == null) {
			objectLinksTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(231);
		}
		return objectLinksTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOperationsType() {
		if (operationsTypeEClass == null) {
			operationsTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(232);
		}
		return operationsTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOperationsType_Virtual() {
        return (EAttribute)getOperationsType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOwnerHandleType() {
		if (ownerHandleTypeEClass == null) {
			ownerHandleTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(233);
		}
		return ownerHandleTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOwnerHandleType_WeakCGTime() {
        return (EAttribute)getOwnerHandleType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOwnerHandleType_StrongCGTime() {
        return (EAttribute)getOwnerHandleType().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getP_MessageHandlerType() {
		if (p_MessageHandlerTypeEClass == null) {
			p_MessageHandlerTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(234);
		}
		return p_MessageHandlerTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParentType() {
		if (parentTypeEClass == null) {
			parentTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(235);
		}
		return parentTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPropertiesType() {
		if (propertiesTypeEClass == null) {
			propertiesTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(236);
		}
		return propertiesTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTableDataDefinition() {
		if (tableDataDefinitionEClass == null) {
			tableDataDefinitionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(237);
		}
		return tableDataDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTableDataDefinition_MyTable() {
        return (EReference)getTableDataDefinition().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTableDataDefinition_Name() {
        return (EAttribute)getTableDataDefinition().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTableDataDefinition_DataType() {
        return (EAttribute)getTableDataDefinition().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTableDataDefinition_ColumnName() {
        return (EAttribute)getTableDataDefinition().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTableDataDefinition_ModelElement() {
        return (EReference)getTableDataDefinition().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTableInstancesType() {
		if (tableInstancesTypeEClass == null) {
			tableInstancesTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(238);
		}
		return tableInstancesTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTargetType() {
		if (targetTypeEClass == null) {
			targetTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(239);
		}
		return targetTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTheMainDiagramType() {
		if (theMainDiagramTypeEClass == null) {
			theMainDiagramTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(240);
		}
		return theMainDiagramTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTheMainDiagramType_Id() {
        return (EAttribute)getTheMainDiagramType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTheMainDiagramType_LastModifiedTime() {
        return (EAttribute)getTheMainDiagramType().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTheMainDiagramType_RequiremenTracabilityHandle() {
        return (EAttribute)getTheMainDiagramType().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTheMainDiagramType_DefaultSubsystem() {
        return (EReference)getTheMainDiagramType().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTheMainDiagramType_Description() {
        return (EReference)getTheMainDiagramType().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTheMainDiagramType_UmlDependencyID() {
        return (EAttribute)getTheMainDiagramType().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTheMainDiagramType_LastID() {
        return (EAttribute)getTheMainDiagramType().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTheMainDiagramType_MyState() {
        return (EAttribute)getTheMainDiagramType().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTheMainDiagramType_OwnerHandle() {
        return (EReference)getTheMainDiagramType().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTheMainDiagramType_ObjectCreation() {
        return (EAttribute)getTheMainDiagramType().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTheMainDiagramType_Name() {
        return (EAttribute)getTheMainDiagramType().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTheMainDiagramType_Cmheader() {
        return (EAttribute)getTheMainDiagramType().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getToLinkType() {
		if (toLinkTypeEClass == null) {
			toLinkTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(241);
		}
		return toLinkTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getToLinkType_ImplicitClass() {
        return (EReference)getToLinkType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTransitionsType() {
		if (transitionsTypeEClass == null) {
			transitionsTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(242);
		}
		return transitionsTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTransitionsType_ModifiedTimeWeak() {
        return (EAttribute)getTransitionsType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTransitionsType_StaticReaction() {
        return (EAttribute)getTransitionsType().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransitionsType_ItsTarget() {
        return (EReference)getTransitionsType().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTransitionsType_Id() {
        return (EAttribute)getTransitionsType().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTransitionsType_CodeUpdateCGTime() {
        return (EAttribute)getTransitionsType().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTransitionsType_RequiremenTracabilityHandle() {
        return (EAttribute)getTransitionsType().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransitionsType_Description() {
        return (EReference)getTransitionsType().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransitionsType_ItsLabel() {
        return (EReference)getTransitionsType().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTransitionsType_UmlDependencyID() {
        return (EAttribute)getTransitionsType().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTransitionsType_MyState() {
        return (EAttribute)getTransitionsType().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTransitionsType_ObjectCreation() {
        return (EAttribute)getTransitionsType().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTransitionsType_Name() {
        return (EAttribute)getTransitionsType().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnknownType() {
		if (unknownTypeEClass == null) {
			unknownTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(243);
		}
		return unknownTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getValueType() {
		if (valueTypeEClass == null) {
			valueTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UMLRhapsodyPackage.eNS_URI).getEClassifiers().get(244);
		}
		return valueTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getValueType_ModifiedTimeWeak() {
        return (EAttribute)getValueType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getValueType_Id() {
        return (EAttribute)getValueType().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getValueType_MyState() {
        return (EAttribute)getValueType().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getValueType_Name() {
        return (EAttribute)getValueType().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UMLRhapsodyFactory getUMLRhapsodyFactory() {
		return (UMLRhapsodyFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isLoaded = false;

	/**
	 * Laods the package and any sub-packages from their serialized form.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void loadPackage() {
		if (isLoaded) return;
		isLoaded = true;

		URL url = getClass().getResource(packageFilename);
		if (url == null) {
			throw new RuntimeException("Missing serialized package: " + packageFilename); //$NON-NLS-1$
		}
		URI uri = URI.createURI(url.toString());
		Resource resource = new EcoreResourceFactoryImpl().createResource(uri);
		try {
			resource.load(null);
		}
		catch (IOException exception) {
			throw new WrappedException(exception);
		}
		initializeFromLoadedEPackage(this, (EPackage)resource.getContents().get(0));
		createResource(eNS_URI);
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isFixed = false;

	/**
	 * Fixes up the loaded package, to make it appear as if it had been programmatically built.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void fixPackageContents() {
		if (isFixed) return;
		isFixed = true;
		fixEClassifiers();
	}

	/**
	 * Sets the instance class on the given classifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void fixInstanceClass(EClassifier eClassifier) {
		if (eClassifier.getInstanceClassName() == null) {
			eClassifier.setInstanceClassName("org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel." + eClassifier.getName()); //$NON-NLS-1$
			setGeneratedClassName(eClassifier);
		}
	}

} //UMLRhapsodyPackageImpl
