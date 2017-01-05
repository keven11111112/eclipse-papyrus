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
package org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage
 * @generated
 */
public class UMLRhapsodySwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static UMLRhapsodyPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UMLRhapsodySwitch() {
		if (modelPackage == null) {
			modelPackage = UMLRhapsodyPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case UMLRhapsodyPackage.ASSOCIATIONS_TYPE: {
				AssociationsType associationsType = (AssociationsType)theEObject;
				T result = caseAssociationsType(associationsType);
				if (result == null) result = caseInverseType(associationsType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.CCOLLABORATION_CHART: {
				CCollaborationChart cCollaborationChart = (CCollaborationChart)theEObject;
				T result = caseCCollaborationChart(cCollaborationChart);
				if (result == null) result = caseGraphicChartType(cCollaborationChart);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.CGI_ACTION_STATE: {
				CGIActionState cgiActionState = (CGIActionState)theEObject;
				T result = caseCGIActionState(cgiActionState);
				if (result == null) result = caseGraphElementsType(cgiActionState);
				if (result == null) result = caseM_pRootType(cgiActionState);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.CGI_ACTIVE_X: {
				CGIActiveX cgiActiveX = (CGIActiveX)theEObject;
				T result = caseCGIActiveX(cgiActiveX);
				if (result == null) result = caseGraphElementsType(cgiActiveX);
				if (result == null) result = caseM_pRootType(cgiActiveX);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.CGI_ANCHOR: {
				CGIAnchor cgiAnchor = (CGIAnchor)theEObject;
				T result = caseCGIAnchor(cgiAnchor);
				if (result == null) result = caseGraphElementsType(cgiAnchor);
				if (result == null) result = caseM_pRootType(cgiAnchor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.CGI_ANNOTATION: {
				CGIAnnotation cgiAnnotation = (CGIAnnotation)theEObject;
				T result = caseCGIAnnotation(cgiAnnotation);
				if (result == null) result = caseGraphElementsType(cgiAnnotation);
				if (result == null) result = caseM_pRootType(cgiAnnotation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.CGI_ARROW: {
				CGIArrow cgiArrow = (CGIArrow)theEObject;
				T result = caseCGIArrow(cgiArrow);
				if (result == null) result = caseGraphElementsType(cgiArrow);
				if (result == null) result = caseM_pRootType(cgiArrow);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END: {
				CGIAssociationEnd cgiAssociationEnd = (CGIAssociationEnd)theEObject;
				T result = caseCGIAssociationEnd(cgiAssociationEnd);
				if (result == null) result = caseGraphElementsType(cgiAssociationEnd);
				if (result == null) result = caseM_pRootType(cgiAssociationEnd);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.CGI_ASSOCIATION_ROLE: {
				CGIAssociationRole cgiAssociationRole = (CGIAssociationRole)theEObject;
				T result = caseCGIAssociationRole(cgiAssociationRole);
				if (result == null) result = caseGraphElementsType(cgiAssociationRole);
				if (result == null) result = caseM_pRootType(cgiAssociationRole);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.CGI_BASIC_CLASS: {
				CGIBasicClass cgiBasicClass = (CGIBasicClass)theEObject;
				T result = caseCGIBasicClass(cgiBasicClass);
				if (result == null) result = caseGraphElementsType(cgiBasicClass);
				if (result == null) result = caseM_pRootType(cgiBasicClass);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.CGI_BLOCK_STATE: {
				CGIBlockState cgiBlockState = (CGIBlockState)theEObject;
				T result = caseCGIBlockState(cgiBlockState);
				if (result == null) result = caseGraphElementsType(cgiBlockState);
				if (result == null) result = caseM_pRootType(cgiBlockState);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.CGI_BOX: {
				CGIBox cgiBox = (CGIBox)theEObject;
				T result = caseCGIBox(cgiBox);
				if (result == null) result = caseGraphElementsType(cgiBox);
				if (result == null) result = caseM_pRootType(cgiBox);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.CGI_BUTTON_ARRAY: {
				CGIButtonArray cgiButtonArray = (CGIButtonArray)theEObject;
				T result = caseCGIButtonArray(cgiButtonArray);
				if (result == null) result = caseGraphElementsType(cgiButtonArray);
				if (result == null) result = caseM_pRootType(cgiButtonArray);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.CGI_CLASS: {
				CGIClass cgiClass = (CGIClass)theEObject;
				T result = caseCGIClass(cgiClass);
				if (result == null) result = caseGraphElementsType(cgiClass);
				if (result == null) result = caseM_pRootType(cgiClass);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.CGI_CLASS_CHART: {
				CGIClassChart cgiClassChart = (CGIClassChart)theEObject;
				T result = caseCGIClassChart(cgiClassChart);
				if (result == null) result = caseGraphicChartType(cgiClassChart);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.CGI_CLASSIFIER_ROLE: {
				CGIClassifierRole cgiClassifierRole = (CGIClassifierRole)theEObject;
				T result = caseCGIClassifierRole(cgiClassifierRole);
				if (result == null) result = caseGraphElementsType(cgiClassifierRole);
				if (result == null) result = caseM_pRootType(cgiClassifierRole);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.CGI_COMPARTMENT: {
				CGICompartment cgiCompartment = (CGICompartment)theEObject;
				T result = caseCGICompartment(cgiCompartment);
				if (result == null) result = caseCompartmentsType(cgiCompartment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.CGI_COMPONENT: {
				CGIComponent cgiComponent = (CGIComponent)theEObject;
				T result = caseCGIComponent(cgiComponent);
				if (result == null) result = caseGraphElementsType(cgiComponent);
				if (result == null) result = caseM_pRootType(cgiComponent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.CGI_COMPOSITE_CLASS: {
				CGICompositeClass cgiCompositeClass = (CGICompositeClass)theEObject;
				T result = caseCGICompositeClass(cgiCompositeClass);
				if (result == null) result = caseGraphElementsType(cgiCompositeClass);
				if (result == null) result = caseM_pRootType(cgiCompositeClass);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.CGI_CONNECTOR: {
				CGIConnector cgiConnector = (CGIConnector)theEObject;
				T result = caseCGIConnector(cgiConnector);
				if (result == null) result = caseGraphElementsType(cgiConnector);
				if (result == null) result = caseM_pRootType(cgiConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.CGI_CONTAIN_ARROW: {
				CGIContainArrow cgiContainArrow = (CGIContainArrow)theEObject;
				T result = caseCGIContainArrow(cgiContainArrow);
				if (result == null) result = caseGraphElementsType(cgiContainArrow);
				if (result == null) result = caseM_pRootType(cgiContainArrow);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.CGI_DIAGRAM_FRAME: {
				CGIDiagramFrame cgiDiagramFrame = (CGIDiagramFrame)theEObject;
				T result = caseCGIDiagramFrame(cgiDiagramFrame);
				if (result == null) result = caseGraphElementsType(cgiDiagramFrame);
				if (result == null) result = caseM_pRootType(cgiDiagramFrame);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.CGI_FREE_SHAPE: {
				CGIFreeShape cgiFreeShape = (CGIFreeShape)theEObject;
				T result = caseCGIFreeShape(cgiFreeShape);
				if (result == null) result = caseGraphElementsType(cgiFreeShape);
				if (result == null) result = caseM_pRootType(cgiFreeShape);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.CGI_FREE_TEXT: {
				CGIFreeText cgiFreeText = (CGIFreeText)theEObject;
				T result = caseCGIFreeText(cgiFreeText);
				if (result == null) result = caseGraphElementsType(cgiFreeText);
				if (result == null) result = caseM_pRootType(cgiFreeText);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.CGI_GENERIC_ELEMENT: {
				CGIGenericElement cgiGenericElement = (CGIGenericElement)theEObject;
				T result = caseCGIGenericElement(cgiGenericElement);
				if (result == null) result = caseGraphElementsType(cgiGenericElement);
				if (result == null) result = caseM_pRootType(cgiGenericElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.CGI_IMAGE: {
				CGIImage cgiImage = (CGIImage)theEObject;
				T result = caseCGIImage(cgiImage);
				if (result == null) result = caseGraphElementsType(cgiImage);
				if (result == null) result = caseM_pRootType(cgiImage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.CGI_IMAGE_DATA: {
				CGIImageData cgiImageData = (CGIImageData)theEObject;
				T result = caseCGIImageData(cgiImageData);
				if (result == null) result = caseGraphElementsType(cgiImageData);
				if (result == null) result = caseM_pRootType(cgiImageData);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.CGI_INFORMATION_FLOW: {
				CGIInformationFlow cgiInformationFlow = (CGIInformationFlow)theEObject;
				T result = caseCGIInformationFlow(cgiInformationFlow);
				if (result == null) result = caseGraphElementsType(cgiInformationFlow);
				if (result == null) result = caseM_pRootType(cgiInformationFlow);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.CGI_INHERITANCE: {
				CGIInheritance cgiInheritance = (CGIInheritance)theEObject;
				T result = caseCGIInheritance(cgiInheritance);
				if (result == null) result = caseGraphElementsType(cgiInheritance);
				if (result == null) result = caseM_pRootType(cgiInheritance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.CGIMFC_CTRL: {
				CGIMFCCtrl cgimfcCtrl = (CGIMFCCtrl)theEObject;
				T result = caseCGIMFCCtrl(cgimfcCtrl);
				if (result == null) result = caseGraphElementsType(cgimfcCtrl);
				if (result == null) result = caseM_pRootType(cgimfcCtrl);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.CGI_MESSAGE_LABEL: {
				CGIMessageLabel cgiMessageLabel = (CGIMessageLabel)theEObject;
				T result = caseCGIMessageLabel(cgiMessageLabel);
				if (result == null) result = caseGraphElementsType(cgiMessageLabel);
				if (result == null) result = caseM_pRootType(cgiMessageLabel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.CGI_MSC_CHART: {
				CGIMscChart cgiMscChart = (CGIMscChart)theEObject;
				T result = caseCGIMscChart(cgiMscChart);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.CGI_MSC_COLUMN_CR: {
				CGIMscColumnCR cgiMscColumnCR = (CGIMscColumnCR)theEObject;
				T result = caseCGIMscColumnCR(cgiMscColumnCR);
				if (result == null) result = caseGraphElementsType(cgiMscColumnCR);
				if (result == null) result = caseM_pRootType(cgiMscColumnCR);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.CGI_MSC_CONDITION_MARK: {
				CGIMscConditionMark cgiMscConditionMark = (CGIMscConditionMark)theEObject;
				T result = caseCGIMscConditionMark(cgiMscConditionMark);
				if (result == null) result = caseGraphElementsType(cgiMscConditionMark);
				if (result == null) result = caseM_pRootType(cgiMscConditionMark);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.CGI_MSC_EXECUTION_OCCURRENCE: {
				CGIMscExecutionOccurrence cgiMscExecutionOccurrence = (CGIMscExecutionOccurrence)theEObject;
				T result = caseCGIMscExecutionOccurrence(cgiMscExecutionOccurrence);
				if (result == null) result = caseGraphElementsType(cgiMscExecutionOccurrence);
				if (result == null) result = caseM_pRootType(cgiMscExecutionOccurrence);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.CGI_MSC_INTERACTION_OCCURRENCE: {
				CGIMscInteractionOccurrence cgiMscInteractionOccurrence = (CGIMscInteractionOccurrence)theEObject;
				T result = caseCGIMscInteractionOccurrence(cgiMscInteractionOccurrence);
				if (result == null) result = caseGraphElementsType(cgiMscInteractionOccurrence);
				if (result == null) result = caseM_pRootType(cgiMscInteractionOccurrence);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.CGI_MSC_INTERACTION_OPERAND: {
				CGIMscInteractionOperand cgiMscInteractionOperand = (CGIMscInteractionOperand)theEObject;
				T result = caseCGIMscInteractionOperand(cgiMscInteractionOperand);
				if (result == null) result = caseGraphElementsType(cgiMscInteractionOperand);
				if (result == null) result = caseM_pRootType(cgiMscInteractionOperand);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.CGI_MSC_INTERACTION_OPERATOR: {
				CGIMscInteractionOperator cgiMscInteractionOperator = (CGIMscInteractionOperator)theEObject;
				T result = caseCGIMscInteractionOperator(cgiMscInteractionOperator);
				if (result == null) result = caseGraphElementsType(cgiMscInteractionOperator);
				if (result == null) result = caseM_pRootType(cgiMscInteractionOperator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.CGI_MSC_MESSAGE: {
				CGIMscMessage cgiMscMessage = (CGIMscMessage)theEObject;
				T result = caseCGIMscMessage(cgiMscMessage);
				if (result == null) result = caseGraphElementsType(cgiMscMessage);
				if (result == null) result = caseM_pRootType(cgiMscMessage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.CGI_OBJECT_INSTANCE: {
				CGIObjectInstance cgiObjectInstance = (CGIObjectInstance)theEObject;
				T result = caseCGIObjectInstance(cgiObjectInstance);
				if (result == null) result = caseGraphElementsType(cgiObjectInstance);
				if (result == null) result = caseM_pRootType(cgiObjectInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.CGI_OBJECT_LINK: {
				CGIObjectLink cgiObjectLink = (CGIObjectLink)theEObject;
				T result = caseCGIObjectLink(cgiObjectLink);
				if (result == null) result = caseGraphElementsType(cgiObjectLink);
				if (result == null) result = caseM_pRootType(cgiObjectLink);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.CGI_PACKAGE: {
				CGIPackage cgiPackage = (CGIPackage)theEObject;
				T result = caseCGIPackage(cgiPackage);
				if (result == null) result = caseGraphElementsType(cgiPackage);
				if (result == null) result = caseM_pRootType(cgiPackage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.CGI_PARTITION: {
				CGIPartition cgiPartition = (CGIPartition)theEObject;
				T result = caseCGIPartition(cgiPartition);
				if (result == null) result = caseGraphElementsType(cgiPartition);
				if (result == null) result = caseM_pRootType(cgiPartition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.CGI_PORT_CONNECTOR: {
				CGIPortConnector cgiPortConnector = (CGIPortConnector)theEObject;
				T result = caseCGIPortConnector(cgiPortConnector);
				if (result == null) result = caseGraphElementsType(cgiPortConnector);
				if (result == null) result = caseM_pRootType(cgiPortConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.CGI_STATE: {
				CGIState cgiState = (CGIState)theEObject;
				T result = caseCGIState(cgiState);
				if (result == null) result = caseGraphElementsType(cgiState);
				if (result == null) result = caseM_pRootType(cgiState);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.CGI_STATE_CHART: {
				CGIStateChart cgiStateChart = (CGIStateChart)theEObject;
				T result = caseCGIStateChart(cgiStateChart);
				if (result == null) result = caseGraphicChartType(cgiStateChart);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.CGI_SWIMLANE_FRAME: {
				CGISwimlaneFrame cgiSwimlaneFrame = (CGISwimlaneFrame)theEObject;
				T result = caseCGISwimlaneFrame(cgiSwimlaneFrame);
				if (result == null) result = caseGraphElementsType(cgiSwimlaneFrame);
				if (result == null) result = caseM_pRootType(cgiSwimlaneFrame);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.CGI_TEXT: {
				CGIText cgiText = (CGIText)theEObject;
				T result = caseCGIText(cgiText);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.CGI_TEXT_BOX: {
				CGITextBox cgiTextBox = (CGITextBox)theEObject;
				T result = caseCGITextBox(cgiTextBox);
				if (result == null) result = caseGraphElementsType(cgiTextBox);
				if (result == null) result = caseM_pRootType(cgiTextBox);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.CGI_TRANS: {
				CGITrans cgiTrans = (CGITrans)theEObject;
				T result = caseCGITrans(cgiTrans);
				if (result == null) result = caseGraphElementsType(cgiTrans);
				if (result == null) result = caseM_pRootType(cgiTrans);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.COLL_EVENT: {
				CollEvent collEvent = (CollEvent)theEObject;
				T result = caseCollEvent(collEvent);
				if (result == null) result = caseP_MessageHandlerType(collEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.COMPARTMENTS_TYPE: {
				CompartmentsType compartmentsType = (CompartmentsType)theEObject;
				T result = caseCompartmentsType(compartmentsType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.COMPONENTS_TYPE: {
				ComponentsType componentsType = (ComponentsType)theEObject;
				T result = caseComponentsType(componentsType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.CONVEYED_TYPE: {
				ConveyedType conveyedType = (ConveyedType)theEObject;
				T result = caseConveyedType(conveyedType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.DECLARATIVES_TYPE: {
				DeclarativesType declarativesType = (DeclarativesType)theEObject;
				T result = caseDeclarativesType(declarativesType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.DEFAULT_SUBSYSTEM_TYPE: {
				DefaultSubsystemType defaultSubsystemType = (DefaultSubsystemType)theEObject;
				T result = caseDefaultSubsystemType(defaultSubsystemType);
				if (result == null) result = caseIModelElement(defaultSubsystemType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.DEFAULT_TRANS_TYPE: {
				DefaultTransType defaultTransType = (DefaultTransType)theEObject;
				T result = caseDefaultTransType(defaultTransType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.DEPENDS_ON_TYPE: {
				DependsOnType dependsOnType = (DependsOnType)theEObject;
				T result = caseDependsOnType(dependsOnType);
				if (result == null) result = caseElementsType(dependsOnType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.DESCRIPTION_TYPE: {
				DescriptionType descriptionType = (DescriptionType)theEObject;
				T result = caseDescriptionType(descriptionType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.ELEMENTS_TYPE: {
				ElementsType elementsType = (ElementsType)theEObject;
				T result = caseElementsType(elementsType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.EMBEDED_FILES_TYPE: {
				EmbededFilesType embededFilesType = (EmbededFilesType)theEObject;
				T result = caseEmbededFilesType(embededFilesType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.END1_TYPE: {
				End1_Type end1_Type = (End1_Type)theEObject;
				T result = caseEnd1_Type(end1_Type);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.END2_TYPE: {
				End2_Type end2_Type = (End2_Type)theEObject;
				T result = caseEnd2_Type(end2_Type);
				if (result == null) result = caseEnd1_Type(end2_Type);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.FILES_TYPE: {
				FilesType filesType = (FilesType)theEObject;
				T result = caseFilesType(filesType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.FROM_LINK_TYPE: {
				FromLinkType fromLinkType = (FromLinkType)theEObject;
				T result = caseFromLinkType(fromLinkType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.GRAPH_ELEMENTS_TYPE: {
				GraphElementsType graphElementsType = (GraphElementsType)theEObject;
				T result = caseGraphElementsType(graphElementsType);
				if (result == null) result = caseM_pRootType(graphElementsType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.GRAPHIC_CHART_TYPE: {
				GraphicChartType graphicChartType = (GraphicChartType)theEObject;
				T result = caseGraphicChartType(graphicChartType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.HYPER_LINKS_TYPE: {
				HyperLinksType hyperLinksType = (HyperLinksType)theEObject;
				T result = caseHyperLinksType(hyperLinksType);
				if (result == null) result = caseIModelElement(hyperLinksType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IACCEPT_EVENT_ACTION: {
				IAcceptEventAction iAcceptEventAction = (IAcceptEventAction)theEObject;
				T result = caseIAcceptEventAction(iAcceptEventAction);
				if (result == null) result = caseIState(iAcceptEventAction);
				if (result == null) result = caseIStateVertex(iAcceptEventAction);
				if (result == null) result = caseItsTargetType(iAcceptEventAction);
				if (result == null) result = caseM_pModelObjectType(iAcceptEventAction);
				if (result == null) result = caseDependsOnType(iAcceptEventAction);
				if (result == null) result = caseTargetType(iAcceptEventAction);
				if (result == null) result = caseIModelElement(iAcceptEventAction);
				if (result == null) result = caseParentType(iAcceptEventAction);
				if (result == null) result = caseElementsType(iAcceptEventAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IACCEPT_TIME_EVENT: {
				IAcceptTimeEvent iAcceptTimeEvent = (IAcceptTimeEvent)theEObject;
				T result = caseIAcceptTimeEvent(iAcceptTimeEvent);
				if (result == null) result = caseIState(iAcceptTimeEvent);
				if (result == null) result = caseIStateVertex(iAcceptTimeEvent);
				if (result == null) result = caseItsTargetType(iAcceptTimeEvent);
				if (result == null) result = caseM_pModelObjectType(iAcceptTimeEvent);
				if (result == null) result = caseDependsOnType(iAcceptTimeEvent);
				if (result == null) result = caseTargetType(iAcceptTimeEvent);
				if (result == null) result = caseIModelElement(iAcceptTimeEvent);
				if (result == null) result = caseParentType(iAcceptTimeEvent);
				if (result == null) result = caseElementsType(iAcceptTimeEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IACTION: {
				IAction iAction = (IAction)theEObject;
				T result = caseIAction(iAction);
				if (result == null) result = caseIModelElement(iAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IACTIVITY_DIAGRAM: {
				IActivityDiagram iActivityDiagram = (IActivityDiagram)theEObject;
				T result = caseIActivityDiagram(iActivityDiagram);
				if (result == null) result = caseDependsOnType(iActivityDiagram);
				if (result == null) result = caseTargetType(iActivityDiagram);
				if (result == null) result = caseElementsType(iActivityDiagram);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IACTIVITY_GRAPH: {
				IActivityGraph iActivityGraph = (IActivityGraph)theEObject;
				T result = caseIActivityGraph(iActivityGraph);
				if (result == null) result = caseNestedStateChartType(iActivityGraph);
				if (result == null) result = caseDependsOnType(iActivityGraph);
				if (result == null) result = caseValueType(iActivityGraph);
				if (result == null) result = caseTargetType(iActivityGraph);
				if (result == null) result = caseM_pModelObjectType(iActivityGraph);
				if (result == null) result = caseIModelElement(iActivityGraph);
				if (result == null) result = caseItsStateChartType(iActivityGraph);
				if (result == null) result = caseElementsType(iActivityGraph);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IACTOR: {
				IActor iActor = (IActor)theEObject;
				T result = caseIActor(iActor);
				if (result == null) result = caseIClassifier(iActor);
				if (result == null) result = caseM_pBaseType(iActor);
				if (result == null) result = caseDependsOnType(iActor);
				if (result == null) result = caseM_subjectType(iActor);
				if (result == null) result = caseEnd2_Type(iActor);
				if (result == null) result = caseIUnit(iActor);
				if (result == null) result = caseM_pModelObjectType(iActor);
				if (result == null) result = caseElementsType(iActor);
				if (result == null) result = caseEnd1_Type(iActor);
				if (result == null) result = caseIModelElement(iActor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IANCHOR: {
				IAnchor iAnchor = (IAnchor)theEObject;
				T result = caseIAnchor(iAnchor);
				if (result == null) result = caseM_pModelObjectType(iAnchor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IANNOTATION: {
				IAnnotation iAnnotation = (IAnnotation)theEObject;
				T result = caseIAnnotation(iAnnotation);
				if (result == null) result = caseIUnit(iAnnotation);
				if (result == null) result = caseIModelElement(iAnnotation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IARGUMENT: {
				IArgument iArgument = (IArgument)theEObject;
				T result = caseIArgument(iArgument);
				if (result == null) result = caseIVariable(iArgument);
				if (result == null) result = caseIUnit(iArgument);
				if (result == null) result = caseIModelElement(iArgument);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IASSOCIATION_CLASS: {
				IAssociationClass iAssociationClass = (IAssociationClass)theEObject;
				T result = caseIAssociationClass(iAssociationClass);
				if (result == null) result = caseIClass(iAssociationClass);
				if (result == null) result = caseIClassifier(iAssociationClass);
				if (result == null) result = caseDeclarativesType(iAssociationClass);
				if (result == null) result = caseM_pBaseType(iAssociationClass);
				if (result == null) result = caseDependsOnType(iAssociationClass);
				if (result == null) result = caseM_subjectType(iAssociationClass);
				if (result == null) result = caseValueType(iAssociationClass);
				if (result == null) result = caseConveyedType(iAssociationClass);
				if (result == null) result = caseTargetType(iAssociationClass);
				if (result == null) result = caseIUnit(iAssociationClass);
				if (result == null) result = caseM_pModelObjectType(iAssociationClass);
				if (result == null) result = caseElementsType(iAssociationClass);
				if (result == null) result = caseIModelElement(iAssociationClass);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IASSOCIATION_END: {
				IAssociationEnd iAssociationEnd = (IAssociationEnd)theEObject;
				T result = caseIAssociationEnd(iAssociationEnd);
				if (result == null) result = caseAssociationsType(iAssociationEnd);
				if (result == null) result = caseM_subjectType(iAssociationEnd);
				if (result == null) result = caseM_hTargetType(iAssociationEnd);
				if (result == null) result = caseM_pModelObjectType(iAssociationEnd);
				if (result == null) result = caseToLinkType(iAssociationEnd);
				if (result == null) result = caseInverseType(iAssociationEnd);
				if (result == null) result = caseFromLinkType(iAssociationEnd);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IASSOCIATION_END_HANDLE: {
				IAssociationEndHandle iAssociationEndHandle = (IAssociationEndHandle)theEObject;
				T result = caseIAssociationEndHandle(iAssociationEndHandle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IASSOCIATION_ROLE: {
				IAssociationRole iAssociationRole = (IAssociationRole)theEObject;
				T result = caseIAssociationRole(iAssociationRole);
				if (result == null) result = caseIModelElement(iAssociationRole);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IATTRIBUTE: {
				IAttribute iAttribute = (IAttribute)theEObject;
				T result = caseIAttribute(iAttribute);
				if (result == null) result = caseIVariable(iAttribute);
				if (result == null) result = caseDependsOnType(iAttribute);
				if (result == null) result = caseM_subjectType(iAttribute);
				if (result == null) result = caseValueType(iAttribute);
				if (result == null) result = caseItemsType(iAttribute);
				if (result == null) result = caseM_pModelObjectType(iAttribute);
				if (result == null) result = caseEnd2_Type(iAttribute);
				if (result == null) result = caseIUnit(iAttribute);
				if (result == null) result = caseElementsType(iAttribute);
				if (result == null) result = caseEnd1_Type(iAttribute);
				if (result == null) result = caseIModelElement(iAttribute);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IBLOCK: {
				IBlock iBlock = (IBlock)theEObject;
				T result = caseIBlock(iBlock);
				if (result == null) result = caseAssociationsType(iBlock);
				if (result == null) result = caseM_pModelObjectType(iBlock);
				if (result == null) result = caseToLinkType(iBlock);
				if (result == null) result = caseEnd2_Type(iBlock);
				if (result == null) result = caseInverseType(iBlock);
				if (result == null) result = caseFromLinkType(iBlock);
				if (result == null) result = caseEnd1_Type(iBlock);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IBODY: {
				IBody iBody = (IBody)theEObject;
				T result = caseIBody(iBody);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IBRANCH: {
				IBranch iBranch = (IBranch)theEObject;
				T result = caseIBranch(iBranch);
				if (result == null) result = caseItsTargetType(iBranch);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.ICALL_ACTION: {
				ICallAction iCallAction = (ICallAction)theEObject;
				T result = caseICallAction(iCallAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.ICALL_OPERATION: {
				ICallOperation iCallOperation = (ICallOperation)theEObject;
				T result = caseICallOperation(iCallOperation);
				if (result == null) result = caseIState(iCallOperation);
				if (result == null) result = caseIStateVertex(iCallOperation);
				if (result == null) result = caseItsTargetType(iCallOperation);
				if (result == null) result = caseM_pModelObjectType(iCallOperation);
				if (result == null) result = caseDependsOnType(iCallOperation);
				if (result == null) result = caseTargetType(iCallOperation);
				if (result == null) result = caseIModelElement(iCallOperation);
				if (result == null) result = caseParentType(iCallOperation);
				if (result == null) result = caseElementsType(iCallOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.ICLASS: {
				IClass iClass = (IClass)theEObject;
				T result = caseIClass(iClass);
				if (result == null) result = caseIClassifier(iClass);
				if (result == null) result = caseDeclarativesType(iClass);
				if (result == null) result = caseM_pBaseType(iClass);
				if (result == null) result = caseDependsOnType(iClass);
				if (result == null) result = caseM_subjectType(iClass);
				if (result == null) result = caseValueType(iClass);
				if (result == null) result = caseConveyedType(iClass);
				if (result == null) result = caseTargetType(iClass);
				if (result == null) result = caseIUnit(iClass);
				if (result == null) result = caseM_pModelObjectType(iClass);
				if (result == null) result = caseElementsType(iClass);
				if (result == null) result = caseIModelElement(iClass);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.ICLASS_HANDLE: {
				IClassHandle iClassHandle = (IClassHandle)theEObject;
				T result = caseIClassHandle(iClassHandle);
				if (result == null) result = caseM_pBaseType(iClassHandle);
				if (result == null) result = caseM_pModelObjectType(iClassHandle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.ICLASS_INSTANCE: {
				IClassInstance iClassInstance = (IClassInstance)theEObject;
				T result = caseIClassInstance(iClassInstance);
				if (result == null) result = caseLinksType(iClassInstance);
				if (result == null) result = caseM_pModelObjectType(iClassInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.ICLASSIFIER: {
				IClassifier iClassifier = (IClassifier)theEObject;
				T result = caseIClassifier(iClassifier);
				if (result == null) result = caseIUnit(iClassifier);
				if (result == null) result = caseIModelElement(iClassifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.ICLASSIFIER_ROLE: {
				IClassifierRole iClassifierRole = (IClassifierRole)theEObject;
				T result = caseIClassifierRole(iClassifierRole);
				if (result == null) result = caseIModelElement(iClassifierRole);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO: {
				ICodeGenConfigInfo iCodeGenConfigInfo = (ICodeGenConfigInfo)theEObject;
				T result = caseICodeGenConfigInfo(iCodeGenConfigInfo);
				if (result == null) result = caseDependsOnType(iCodeGenConfigInfo);
				if (result == null) result = caseElementsType(iCodeGenConfigInfo);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO_HANDLE: {
				ICodeGenConfigInfoHandle iCodeGenConfigInfoHandle = (ICodeGenConfigInfoHandle)theEObject;
				T result = caseICodeGenConfigInfoHandle(iCodeGenConfigInfoHandle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.ICOLLABORATION: {
				ICollaboration iCollaboration = (ICollaboration)theEObject;
				T result = caseICollaboration(iCollaboration);
				if (result == null) result = caseIModelElement(iCollaboration);
				if (result == null) result = caseM_pModelObjectType(iCollaboration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.ICOLLABORATION_DIAGRAM: {
				ICollaborationDiagram iCollaborationDiagram = (ICollaborationDiagram)theEObject;
				T result = caseICollaborationDiagram(iCollaborationDiagram);
				if (result == null) result = caseIDiagram(iCollaborationDiagram);
				if (result == null) result = caseIUnit(iCollaborationDiagram);
				if (result == null) result = caseTheMainDiagramType(iCollaborationDiagram);
				if (result == null) result = caseDeclarativesType(iCollaborationDiagram);
				if (result == null) result = caseDependsOnType(iCollaborationDiagram);
				if (result == null) result = caseTargetType(iCollaborationDiagram);
				if (result == null) result = caseIModelElement(iCollaborationDiagram);
				if (result == null) result = caseM_pModelObjectType(iCollaborationDiagram);
				if (result == null) result = caseElementsType(iCollaborationDiagram);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.ICOLOR: {
				IColor iColor = (IColor)theEObject;
				T result = caseIColor(iColor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.ICOMBINED_FRAGMENT: {
				ICombinedFragment iCombinedFragment = (ICombinedFragment)theEObject;
				T result = caseICombinedFragment(iCombinedFragment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.ICOMMENT: {
				IComment iComment = (IComment)theEObject;
				T result = caseIComment(iComment);
				if (result == null) result = caseIAnnotation(iComment);
				if (result == null) result = caseValueType(iComment);
				if (result == null) result = caseIUnit(iComment);
				if (result == null) result = caseIModelElement(iComment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.ICOMPONENT: {
				IComponent iComponent = (IComponent)theEObject;
				T result = caseIComponent(iComponent);
				if (result == null) result = caseIUnit(iComponent);
				if (result == null) result = caseOwnerHandleType(iComponent);
				if (result == null) result = caseDependsOnType(iComponent);
				if (result == null) result = caseDeclarativesType(iComponent);
				if (result == null) result = caseM_pModelObjectType(iComponent);
				if (result == null) result = caseDefaultSubsystemType(iComponent);
				if (result == null) result = caseElementsType(iComponent);
				if (result == null) result = caseIModelElement(iComponent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.ICOMPONENT_DIAGRAM: {
				IComponentDiagram iComponentDiagram = (IComponentDiagram)theEObject;
				T result = caseIComponentDiagram(iComponentDiagram);
				if (result == null) result = caseIDiagram(iComponentDiagram);
				if (result == null) result = caseIUnit(iComponentDiagram);
				if (result == null) result = caseTheMainDiagramType(iComponentDiagram);
				if (result == null) result = caseDeclarativesType(iComponentDiagram);
				if (result == null) result = caseDependsOnType(iComponentDiagram);
				if (result == null) result = caseTargetType(iComponentDiagram);
				if (result == null) result = caseIModelElement(iComponentDiagram);
				if (result == null) result = caseM_pModelObjectType(iComponentDiagram);
				if (result == null) result = caseElementsType(iComponentDiagram);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.ICOMPONENT_INSTANCE: {
				IComponentInstance iComponentInstance = (IComponentInstance)theEObject;
				T result = caseIComponentInstance(iComponentInstance);
				if (result == null) result = caseIModelElement(iComponentInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.ICONFIGURATION: {
				IConfiguration iConfiguration = (IConfiguration)theEObject;
				T result = caseIConfiguration(iConfiguration);
				if (result == null) result = caseIModelElement(iConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.ICONNECTOR: {
				IConnector iConnector = (IConnector)theEObject;
				T result = caseIConnector(iConnector);
				if (result == null) result = caseIStateVertex(iConnector);
				if (result == null) result = caseItsTargetType(iConnector);
				if (result == null) result = caseIModelElement(iConnector);
				if (result == null) result = caseParentType(iConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.ICONSTRAINT: {
				IConstraint iConstraint = (IConstraint)theEObject;
				T result = caseIConstraint(iConstraint);
				if (result == null) result = caseIAnnotation(iConstraint);
				if (result == null) result = caseIUnit(iConstraint);
				if (result == null) result = caseIModelElement(iConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.ICONSTRUCTOR: {
				IConstructor iConstructor = (IConstructor)theEObject;
				T result = caseIConstructor(iConstructor);
				if (result == null) result = caseOperationsType(iConstructor);
				if (result == null) result = caseM_subjectType(iConstructor);
				if (result == null) result = caseItemsType(iConstructor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.ICONTEXT_SPECIFICATION: {
				IContextSpecification iContextSpecification = (IContextSpecification)theEObject;
				T result = caseIContextSpecification(iContextSpecification);
				if (result == null) result = caseIValueSpecification(iContextSpecification);
				if (result == null) result = caseIModelElement(iContextSpecification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.ICONTROLLED_FILE: {
				IControlledFile iControlledFile = (IControlledFile)theEObject;
				T result = caseIControlledFile(iControlledFile);
				if (result == null) result = caseIUnit(iControlledFile);
				if (result == null) result = caseIModelElement(iControlledFile);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS: {
				IDefaultDrvdTrans iDefaultDrvdTrans = (IDefaultDrvdTrans)theEObject;
				T result = caseIDefaultDrvdTrans(iDefaultDrvdTrans);
				if (result == null) result = caseDefaultTransType(iDefaultDrvdTrans);
				if (result == null) result = caseTransitionsType(iDefaultDrvdTrans);
				if (result == null) result = caseDependsOnType(iDefaultDrvdTrans);
				if (result == null) result = caseElementsType(iDefaultDrvdTrans);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IDEPENDENCY: {
				IDependency iDependency = (IDependency)theEObject;
				T result = caseIDependency(iDependency);
				if (result == null) result = caseIModelElement(iDependency);
				if (result == null) result = caseDependsOnType(iDependency);
				if (result == null) result = caseM_subjectType(iDependency);
				if (result == null) result = caseElementsType(iDependency);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IDEPLOYMENT_DIAGRAM: {
				IDeploymentDiagram iDeploymentDiagram = (IDeploymentDiagram)theEObject;
				T result = caseIDeploymentDiagram(iDeploymentDiagram);
				if (result == null) result = caseIDiagram(iDeploymentDiagram);
				if (result == null) result = caseIUnit(iDeploymentDiagram);
				if (result == null) result = caseTheMainDiagramType(iDeploymentDiagram);
				if (result == null) result = caseDeclarativesType(iDeploymentDiagram);
				if (result == null) result = caseDependsOnType(iDeploymentDiagram);
				if (result == null) result = caseTargetType(iDeploymentDiagram);
				if (result == null) result = caseIModelElement(iDeploymentDiagram);
				if (result == null) result = caseM_pModelObjectType(iDeploymentDiagram);
				if (result == null) result = caseElementsType(iDeploymentDiagram);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IDESCRIPTION: {
				IDescription iDescription = (IDescription)theEObject;
				T result = caseIDescription(iDescription);
				if (result == null) result = caseDescriptionType(iDescription);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IDESTRUCTOR: {
				IDestructor iDestructor = (IDestructor)theEObject;
				T result = caseIDestructor(iDestructor);
				if (result == null) result = caseOperationsType(iDestructor);
				if (result == null) result = caseM_subjectType(iDestructor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IDIAGRAM: {
				IDiagram iDiagram = (IDiagram)theEObject;
				T result = caseIDiagram(iDiagram);
				if (result == null) result = caseIUnit(iDiagram);
				if (result == null) result = caseTheMainDiagramType(iDiagram);
				if (result == null) result = caseDeclarativesType(iDiagram);
				if (result == null) result = caseDependsOnType(iDiagram);
				if (result == null) result = caseTargetType(iDiagram);
				if (result == null) result = caseIModelElement(iDiagram);
				if (result == null) result = caseM_pModelObjectType(iDiagram);
				if (result == null) result = caseElementsType(iDiagram);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IEMBEDED_FILE: {
				IEmbededFile iEmbededFile = (IEmbededFile)theEObject;
				T result = caseIEmbededFile(iEmbededFile);
				if (result == null) result = caseEmbededFilesType(iEmbededFile);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IENUMERATION_LITERAL: {
				IEnumerationLiteral iEnumerationLiteral = (IEnumerationLiteral)theEObject;
				T result = caseIEnumerationLiteral(iEnumerationLiteral);
				if (result == null) result = caseIModelElement(iEnumerationLiteral);
				if (result == null) result = caseItemsType(iEnumerationLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IEVENT: {
				IEvent iEvent = (IEvent)theEObject;
				T result = caseIEvent(iEvent);
				if (result == null) result = caseIInterfaceItem(iEvent);
				if (result == null) result = caseM_subjectType(iEvent);
				if (result == null) result = caseM_pFormalMessageType(iEvent);
				if (result == null) result = caseConveyedType(iEvent);
				if (result == null) result = caseTargetType(iEvent);
				if (result == null) result = caseIClassifier(iEvent);
				if (result == null) result = caseIUnit(iEvent);
				if (result == null) result = caseIModelElement(iEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IEVENT_HANDLE: {
				IEventHandle iEventHandle = (IEventHandle)theEObject;
				T result = caseIEventHandle(iEventHandle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IEVENT_RECEPTION: {
				IEventReception iEventReception = (IEventReception)theEObject;
				T result = caseIEventReception(iEventReception);
				if (result == null) result = caseIInterfaceItem(iEventReception);
				if (result == null) result = caseIClassifier(iEventReception);
				if (result == null) result = caseIUnit(iEventReception);
				if (result == null) result = caseIModelElement(iEventReception);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IEXECUTION_OCCURRENCE: {
				IExecutionOccurrence iExecutionOccurrence = (IExecutionOccurrence)theEObject;
				T result = caseIExecutionOccurrence(iExecutionOccurrence);
				if (result == null) result = caseIModelElement(iExecutionOccurrence);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IEXTERNAL_HYPERLINK: {
				IExternalHyperlink iExternalHyperlink = (IExternalHyperlink)theEObject;
				T result = caseIExternalHyperlink(iExternalHyperlink);
				if (result == null) result = caseHyperLinksType(iExternalHyperlink);
				if (result == null) result = caseIModelElement(iExternalHyperlink);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IFILE: {
				IFile iFile = (IFile)theEObject;
				T result = caseIFile(iFile);
				if (result == null) result = caseIUnit(iFile);
				if (result == null) result = caseFilesType(iFile);
				if (result == null) result = caseIModelElement(iFile);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IFILE_FRAGMENT: {
				IFileFragment iFileFragment = (IFileFragment)theEObject;
				T result = caseIFileFragment(iFileFragment);
				if (result == null) result = caseIModelElement(iFileFragment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IFLOW: {
				IFlow iFlow = (IFlow)theEObject;
				T result = caseIFlow(iFlow);
				if (result == null) result = caseIModelElement(iFlow);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IFLOW_ITEM: {
				IFlowItem iFlowItem = (IFlowItem)theEObject;
				T result = caseIFlowItem(iFlowItem);
				if (result == null) result = caseIClassifier(iFlowItem);
				if (result == null) result = caseIUnit(iFlowItem);
				if (result == null) result = caseIModelElement(iFlowItem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IFLOWCHART: {
				IFlowchart iFlowchart = (IFlowchart)theEObject;
				T result = caseIFlowchart(iFlowchart);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IFOLDER: {
				IFolder iFolder = (IFolder)theEObject;
				T result = caseIFolder(iFolder);
				if (result == null) result = caseFilesType(iFolder);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IFORK: {
				IFork iFork = (IFork)theEObject;
				T result = caseIFork(iFork);
				if (result == null) result = caseItsTargetType(iFork);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IGENERALIZATION: {
				IGeneralization iGeneralization = (IGeneralization)theEObject;
				T result = caseIGeneralization(iGeneralization);
				if (result == null) result = caseIModelElement(iGeneralization);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IGUARD: {
				IGuard iGuard = (IGuard)theEObject;
				T result = caseIGuard(iGuard);
				if (result == null) result = caseIModelElement(iGuard);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IHANDLE_WITH_DATA: {
				IHandleWithData iHandleWithData = (IHandleWithData)theEObject;
				T result = caseIHandleWithData(iHandleWithData);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IHISTORY_CONNECTOR: {
				IHistoryConnector iHistoryConnector = (IHistoryConnector)theEObject;
				T result = caseIHistoryConnector(iHistoryConnector);
				if (result == null) result = caseItsTargetType(iHistoryConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IHYPER_LINK: {
				IHyperLink iHyperLink = (IHyperLink)theEObject;
				T result = caseIHyperLink(iHyperLink);
				if (result == null) result = caseIDependency(iHyperLink);
				if (result == null) result = caseIModelElement(iHyperLink);
				if (result == null) result = caseDependsOnType(iHyperLink);
				if (result == null) result = caseM_subjectType(iHyperLink);
				if (result == null) result = caseElementsType(iHyperLink);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IINFORMATION_FLOW: {
				IInformationFlow iInformationFlow = (IInformationFlow)theEObject;
				T result = caseIInformationFlow(iInformationFlow);
				if (result == null) result = caseDeclarativesType(iInformationFlow);
				if (result == null) result = caseDependsOnType(iInformationFlow);
				if (result == null) result = caseElementsType(iInformationFlow);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IINFORMATION_ITEM: {
				IInformationItem iInformationItem = (IInformationItem)theEObject;
				T result = caseIInformationItem(iInformationItem);
				if (result == null) result = caseDeclarativesType(iInformationItem);
				if (result == null) result = caseDependsOnType(iInformationItem);
				if (result == null) result = caseConveyedType(iInformationItem);
				if (result == null) result = caseElementsType(iInformationItem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IINSTANCE: {
				IInstance iInstance = (IInstance)theEObject;
				T result = caseIInstance(iInstance);
				if (result == null) result = caseIRelation(iInstance);
				if (result == null) result = caseIUnit(iInstance);
				if (result == null) result = caseIModelElement(iInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IINSTANCE_SLOT: {
				IInstanceSlot iInstanceSlot = (IInstanceSlot)theEObject;
				T result = caseIInstanceSlot(iInstanceSlot);
				if (result == null) result = caseIModelElement(iInstanceSlot);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IINSTANCE_SPECIFICATION: {
				IInstanceSpecification iInstanceSpecification = (IInstanceSpecification)theEObject;
				T result = caseIInstanceSpecification(iInstanceSpecification);
				if (result == null) result = caseIModelElement(iInstanceSpecification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IINSTANCE_VALUE: {
				IInstanceValue iInstanceValue = (IInstanceValue)theEObject;
				T result = caseIInstanceValue(iInstanceValue);
				if (result == null) result = caseIValueSpecification(iInstanceValue);
				if (result == null) result = caseIModelElement(iInstanceValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IINTERACTION_OCCURRENCE: {
				IInteractionOccurrence iInteractionOccurrence = (IInteractionOccurrence)theEObject;
				T result = caseIInteractionOccurrence(iInteractionOccurrence);
				if (result == null) result = caseIModelElement(iInteractionOccurrence);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IINTERACTION_OPERAND: {
				IInteractionOperand iInteractionOperand = (IInteractionOperand)theEObject;
				T result = caseIInteractionOperand(iInteractionOperand);
				if (result == null) result = caseICollaboration(iInteractionOperand);
				if (result == null) result = caseIModelElement(iInteractionOperand);
				if (result == null) result = caseM_pModelObjectType(iInteractionOperand);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IINTERACTION_OPERATOR: {
				IInteractionOperator iInteractionOperator = (IInteractionOperator)theEObject;
				T result = caseIInteractionOperator(iInteractionOperator);
				if (result == null) result = caseIModelElement(iInteractionOperator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IINTERFACE_ITEM: {
				IInterfaceItem iInterfaceItem = (IInterfaceItem)theEObject;
				T result = caseIInterfaceItem(iInterfaceItem);
				if (result == null) result = caseIClassifier(iInterfaceItem);
				if (result == null) result = caseIUnit(iInterfaceItem);
				if (result == null) result = caseIModelElement(iInterfaceItem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IINTERFACE_ITEM_TRIGGER: {
				IInterfaceItemTrigger iInterfaceItemTrigger = (IInterfaceItemTrigger)theEObject;
				T result = caseIInterfaceItemTrigger(iInterfaceItemTrigger);
				if (result == null) result = caseItsTriggerType(iInterfaceItemTrigger);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IINTERNAL_HYPERLINK: {
				IInternalHyperlink iInternalHyperlink = (IInternalHyperlink)theEObject;
				T result = caseIInternalHyperlink(iInternalHyperlink);
				if (result == null) result = caseHyperLinksType(iInternalHyperlink);
				if (result == null) result = caseIModelElement(iInternalHyperlink);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.ILABEL: {
				ILabel iLabel = (ILabel)theEObject;
				T result = caseILabel(iLabel);
				if (result == null) result = caseItsLabelType(iLabel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.ILINK: {
				ILink iLink = (ILink)theEObject;
				T result = caseILink(iLink);
				if (result == null) result = caseIUnit(iLink);
				if (result == null) result = caseLinksType(iLink);
				if (result == null) result = caseM_pModelObjectType(iLink);
				if (result == null) result = caseIModelElement(iLink);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.ILINK_INSTANCE: {
				ILinkInstance iLinkInstance = (ILinkInstance)theEObject;
				T result = caseILinkInstance(iLinkInstance);
				if (result == null) result = caseComponentsType(iLinkInstance);
				if (result == null) result = caseM_pModelObjectType(iLinkInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.ILITERAL_SPECIFICATION: {
				ILiteralSpecification iLiteralSpecification = (ILiteralSpecification)theEObject;
				T result = caseILiteralSpecification(iLiteralSpecification);
				if (result == null) result = caseIValueSpecification(iLiteralSpecification);
				if (result == null) result = caseIModelElement(iLiteralSpecification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IM_HYPER_LINK: {
				IMHyperLink imHyperLink = (IMHyperLink)theEObject;
				T result = caseIMHyperLink(imHyperLink);
				if (result == null) result = caseHyperLinksType(imHyperLink);
				if (result == null) result = caseIModelElement(imHyperLink);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IMSC: {
				IMSC imsc = (IMSC)theEObject;
				T result = caseIMSC(imsc);
				if (result == null) result = caseDeclarativesType(imsc);
				if (result == null) result = caseDependsOnType(imsc);
				if (result == null) result = caseTargetType(imsc);
				if (result == null) result = caseElementsType(imsc);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IMATRIX_INSTANCE: {
				IMatrixInstance iMatrixInstance = (IMatrixInstance)theEObject;
				T result = caseIMatrixInstance(iMatrixInstance);
				if (result == null) result = caseMatrixInstancesType(iMatrixInstance);
				if (result == null) result = caseDependsOnType(iMatrixInstance);
				if (result == null) result = caseElementsType(iMatrixInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IMATRIX_LAYOUT: {
				IMatrixLayout iMatrixLayout = (IMatrixLayout)theEObject;
				T result = caseIMatrixLayout(iMatrixLayout);
				if (result == null) result = caseIUnit(iMatrixLayout);
				if (result == null) result = caseIModelElement(iMatrixLayout);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IMATRIX_VIEW: {
				IMatrixView iMatrixView = (IMatrixView)theEObject;
				T result = caseIMatrixView(iMatrixView);
				if (result == null) result = caseIUnit(iMatrixView);
				if (result == null) result = caseIModelElement(iMatrixView);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IMESSAGE: {
				IMessage iMessage = (IMessage)theEObject;
				T result = caseIMessage(iMessage);
				if (result == null) result = caseIModelElement(iMessage);
				if (result == null) result = caseDependsOnType(iMessage);
				if (result == null) result = caseElementsType(iMessage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IMESSAGE_POINT: {
				IMessagePoint iMessagePoint = (IMessagePoint)theEObject;
				T result = caseIMessagePoint(iMessagePoint);
				if (result == null) result = caseIModelElement(iMessagePoint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IMETA_LINK_HANDLE: {
				IMetaLinkHandle iMetaLinkHandle = (IMetaLinkHandle)theEObject;
				T result = caseIMetaLinkHandle(iMetaLinkHandle);
				if (result == null) result = caseInverseType(iMetaLinkHandle);
				if (result == null) result = caseM_pModelObjectType(iMetaLinkHandle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IMODEL_ELEMENT: {
				IModelElement iModelElement = (IModelElement)theEObject;
				T result = caseIModelElement(iModelElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IMODULE: {
				IModule iModule = (IModule)theEObject;
				T result = caseIModule(iModule);
				if (result == null) result = caseIInstance(iModule);
				if (result == null) result = caseAssociationsType(iModule);
				if (result == null) result = caseDependsOnType(iModule);
				if (result == null) result = caseM_pModelObjectType(iModule);
				if (result == null) result = caseEnd2_Type(iModule);
				if (result == null) result = caseIRelation(iModule);
				if (result == null) result = caseInverseType(iModule);
				if (result == null) result = caseElementsType(iModule);
				if (result == null) result = caseEnd1_Type(iModule);
				if (result == null) result = caseIUnit(iModule);
				if (result == null) result = caseIModelElement(iModule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IMULTIPLICITY_ITEM: {
				IMultiplicityItem iMultiplicityItem = (IMultiplicityItem)theEObject;
				T result = caseIMultiplicityItem(iMultiplicityItem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.INODE: {
				INode iNode = (INode)theEObject;
				T result = caseINode(iNode);
				if (result == null) result = caseIClassifier(iNode);
				if (result == null) result = caseIUnit(iNode);
				if (result == null) result = caseIModelElement(iNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IOBJECT_LINK: {
				IObjectLink iObjectLink = (IObjectLink)theEObject;
				T result = caseIObjectLink(iObjectLink);
				if (result == null) result = caseObjectLinksType(iObjectLink);
				if (result == null) result = caseValueType(iObjectLink);
				if (result == null) result = caseM_pModelObjectType(iObjectLink);
				if (result == null) result = caseDependsOnType(iObjectLink);
				if (result == null) result = caseElementsType(iObjectLink);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IOBJECT_LINK_HANDLE: {
				IObjectLinkHandle iObjectLinkHandle = (IObjectLinkHandle)theEObject;
				T result = caseIObjectLinkHandle(iObjectLinkHandle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IOBJECT_MODEL_DIAGRAM: {
				IObjectModelDiagram iObjectModelDiagram = (IObjectModelDiagram)theEObject;
				T result = caseIObjectModelDiagram(iObjectModelDiagram);
				if (result == null) result = caseIDiagram(iObjectModelDiagram);
				if (result == null) result = caseIUnit(iObjectModelDiagram);
				if (result == null) result = caseTheMainDiagramType(iObjectModelDiagram);
				if (result == null) result = caseDeclarativesType(iObjectModelDiagram);
				if (result == null) result = caseDependsOnType(iObjectModelDiagram);
				if (result == null) result = caseTargetType(iObjectModelDiagram);
				if (result == null) result = caseIModelElement(iObjectModelDiagram);
				if (result == null) result = caseM_pModelObjectType(iObjectModelDiagram);
				if (result == null) result = caseElementsType(iObjectModelDiagram);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IOBJECT_NODE: {
				IObjectNode iObjectNode = (IObjectNode)theEObject;
				T result = caseIObjectNode(iObjectNode);
				if (result == null) result = caseIState(iObjectNode);
				if (result == null) result = caseIStateVertex(iObjectNode);
				if (result == null) result = caseItsTargetType(iObjectNode);
				if (result == null) result = caseM_pModelObjectType(iObjectNode);
				if (result == null) result = caseDependsOnType(iObjectNode);
				if (result == null) result = caseTargetType(iObjectNode);
				if (result == null) result = caseIModelElement(iObjectNode);
				if (result == null) result = caseParentType(iObjectNode);
				if (result == null) result = caseElementsType(iObjectNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IOPERATION: {
				IOperation iOperation = (IOperation)theEObject;
				T result = caseIOperation(iOperation);
				if (result == null) result = caseIInterfaceItem(iOperation);
				if (result == null) result = caseIClassifier(iOperation);
				if (result == null) result = caseIUnit(iOperation);
				if (result == null) result = caseIModelElement(iOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IPACKAGE: {
				IPackage iPackage = (IPackage)theEObject;
				T result = caseIPackage(iPackage);
				if (result == null) result = caseIUnit(iPackage);
				if (result == null) result = caseIModelElement(iPackage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IPANEL_DIAGRAM: {
				IPanelDiagram iPanelDiagram = (IPanelDiagram)theEObject;
				T result = caseIPanelDiagram(iPanelDiagram);
				if (result == null) result = caseIDiagram(iPanelDiagram);
				if (result == null) result = caseIUnit(iPanelDiagram);
				if (result == null) result = caseTheMainDiagramType(iPanelDiagram);
				if (result == null) result = caseDeclarativesType(iPanelDiagram);
				if (result == null) result = caseDependsOnType(iPanelDiagram);
				if (result == null) result = caseTargetType(iPanelDiagram);
				if (result == null) result = caseIModelElement(iPanelDiagram);
				if (result == null) result = caseM_pModelObjectType(iPanelDiagram);
				if (result == null) result = caseElementsType(iPanelDiagram);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IPART: {
				IPart iPart = (IPart)theEObject;
				T result = caseIPart(iPart);
				if (result == null) result = caseAssociationsType(iPart);
				if (result == null) result = caseDependsOnType(iPart);
				if (result == null) result = caseM_subjectType(iPart);
				if (result == null) result = caseValueType(iPart);
				if (result == null) result = caseM_hTargetType(iPart);
				if (result == null) result = caseM_pModelObjectType(iPart);
				if (result == null) result = caseToLinkType(iPart);
				if (result == null) result = caseConveyedType(iPart);
				if (result == null) result = caseEnd2_Type(iPart);
				if (result == null) result = caseTargetType(iPart);
				if (result == null) result = caseIModelElement(iPart);
				if (result == null) result = caseInverseType(iPart);
				if (result == null) result = caseElementsType(iPart);
				if (result == null) result = caseFromLinkType(iPart);
				if (result == null) result = caseEnd1_Type(iPart);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IPIN: {
				IPin iPin = (IPin)theEObject;
				T result = caseIPin(iPin);
				if (result == null) result = caseIConnector(iPin);
				if (result == null) result = caseIStateVertex(iPin);
				if (result == null) result = caseItsTargetType(iPin);
				if (result == null) result = caseIModelElement(iPin);
				if (result == null) result = caseParentType(iPin);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IPORT: {
				IPort iPort = (IPort)theEObject;
				T result = caseIPort(iPort);
				if (result == null) result = caseIInstance(iPort);
				if (result == null) result = caseM_hTargetType(iPort);
				if (result == null) result = caseToLinkType(iPort);
				if (result == null) result = caseEnd2_Type(iPort);
				if (result == null) result = caseIRelation(iPort);
				if (result == null) result = caseFromLinkType(iPort);
				if (result == null) result = caseEnd1_Type(iPort);
				if (result == null) result = caseIUnit(iPort);
				if (result == null) result = caseIModelElement(iPort);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION: {
				IPrimitiveOperation iPrimitiveOperation = (IPrimitiveOperation)theEObject;
				T result = caseIPrimitiveOperation(iPrimitiveOperation);
				if (result == null) result = caseOperationsType(iPrimitiveOperation);
				if (result == null) result = caseDependsOnType(iPrimitiveOperation);
				if (result == null) result = caseM_subjectType(iPrimitiveOperation);
				if (result == null) result = caseValueType(iPrimitiveOperation);
				if (result == null) result = caseM_pFormalMessageType(iPrimitiveOperation);
				if (result == null) result = caseItemsType(iPrimitiveOperation);
				if (result == null) result = caseTargetType(iPrimitiveOperation);
				if (result == null) result = caseM_pModelObjectType(iPrimitiveOperation);
				if (result == null) result = caseIModelElement(iPrimitiveOperation);
				if (result == null) result = caseElementsType(iPrimitiveOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IPROFILE: {
				IProfile iProfile = (IProfile)theEObject;
				T result = caseIProfile(iProfile);
				if (result == null) result = caseIPackage(iProfile);
				if (result == null) result = caseOwnerHandleType(iProfile);
				if (result == null) result = caseDependsOnType(iProfile);
				if (result == null) result = caseIUnit(iProfile);
				if (result == null) result = caseDefaultSubsystemType(iProfile);
				if (result == null) result = caseElementsType(iProfile);
				if (result == null) result = caseIModelElement(iProfile);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IPROJECT: {
				IProject iProject = (IProject)theEObject;
				T result = caseIProject(iProject);
				if (result == null) result = caseIPackage(iProject);
				if (result == null) result = caseM_pModelObjectType(iProject);
				if (result == null) result = caseIUnit(iProject);
				if (result == null) result = caseIModelElement(iProject);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IPROPERTY: {
				IProperty iProperty = (IProperty)theEObject;
				T result = caseIProperty(iProperty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IPROPERTY_CONTAINER: {
				IPropertyContainer iPropertyContainer = (IPropertyContainer)theEObject;
				T result = caseIPropertyContainer(iPropertyContainer);
				if (result == null) result = casePropertiesType(iPropertyContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IPROPERTY_METACLASS: {
				IPropertyMetaclass iPropertyMetaclass = (IPropertyMetaclass)theEObject;
				T result = caseIPropertyMetaclass(iPropertyMetaclass);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IPROPERTY_SUBJECT: {
				IPropertySubject iPropertySubject = (IPropertySubject)theEObject;
				T result = caseIPropertySubject(iPropertySubject);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IRECEPTION: {
				IReception iReception = (IReception)theEObject;
				T result = caseIReception(iReception);
				if (result == null) result = caseOperationsType(iReception);
				if (result == null) result = caseItemsType(iReception);
				if (result == null) result = caseDependsOnType(iReception);
				if (result == null) result = caseElementsType(iReception);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IREFERENCE_ACTIVITY: {
				IReferenceActivity iReferenceActivity = (IReferenceActivity)theEObject;
				T result = caseIReferenceActivity(iReferenceActivity);
				if (result == null) result = caseDependsOnType(iReferenceActivity);
				if (result == null) result = caseParentType(iReferenceActivity);
				if (result == null) result = caseItsTargetType(iReferenceActivity);
				if (result == null) result = caseElementsType(iReferenceActivity);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IRELATION: {
				IRelation iRelation = (IRelation)theEObject;
				T result = caseIRelation(iRelation);
				if (result == null) result = caseIUnit(iRelation);
				if (result == null) result = caseIModelElement(iRelation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IREQUIREMENT: {
				IRequirement iRequirement = (IRequirement)theEObject;
				T result = caseIRequirement(iRequirement);
				if (result == null) result = caseIAnnotation(iRequirement);
				if (result == null) result = caseDependsOnType(iRequirement);
				if (result == null) result = caseIUnit(iRequirement);
				if (result == null) result = caseElementsType(iRequirement);
				if (result == null) result = caseIModelElement(iRequirement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.ISEND_ACTION: {
				ISendAction iSendAction = (ISendAction)theEObject;
				T result = caseISendAction(iSendAction);
				if (result == null) result = caseIAction(iSendAction);
				if (result == null) result = caseIModelElement(iSendAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.ISEQUENCE_DIAGRAM: {
				ISequenceDiagram iSequenceDiagram = (ISequenceDiagram)theEObject;
				T result = caseISequenceDiagram(iSequenceDiagram);
				if (result == null) result = caseIDiagram(iSequenceDiagram);
				if (result == null) result = caseIUnit(iSequenceDiagram);
				if (result == null) result = caseTheMainDiagramType(iSequenceDiagram);
				if (result == null) result = caseDeclarativesType(iSequenceDiagram);
				if (result == null) result = caseDependsOnType(iSequenceDiagram);
				if (result == null) result = caseTargetType(iSequenceDiagram);
				if (result == null) result = caseIModelElement(iSequenceDiagram);
				if (result == null) result = caseM_pModelObjectType(iSequenceDiagram);
				if (result == null) result = caseElementsType(iSequenceDiagram);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.ISLOT: {
				ISlot iSlot = (ISlot)theEObject;
				T result = caseISlot(iSlot);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.ISTATE: {
				IState iState = (IState)theEObject;
				T result = caseIState(iState);
				if (result == null) result = caseIStateVertex(iState);
				if (result == null) result = caseItsTargetType(iState);
				if (result == null) result = caseM_pModelObjectType(iState);
				if (result == null) result = caseDependsOnType(iState);
				if (result == null) result = caseTargetType(iState);
				if (result == null) result = caseIModelElement(iState);
				if (result == null) result = caseParentType(iState);
				if (result == null) result = caseElementsType(iState);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.ISTATE_CHART: {
				IStateChart iStateChart = (IStateChart)theEObject;
				T result = caseIStateChart(iStateChart);
				if (result == null) result = caseIClass(iStateChart);
				if (result == null) result = caseNestedStateChartType(iStateChart);
				if (result == null) result = caseIClassifier(iStateChart);
				if (result == null) result = caseDeclarativesType(iStateChart);
				if (result == null) result = caseM_pBaseType(iStateChart);
				if (result == null) result = caseDependsOnType(iStateChart);
				if (result == null) result = caseM_subjectType(iStateChart);
				if (result == null) result = caseValueType(iStateChart);
				if (result == null) result = caseConveyedType(iStateChart);
				if (result == null) result = caseTargetType(iStateChart);
				if (result == null) result = caseItsStateChartType(iStateChart);
				if (result == null) result = caseIUnit(iStateChart);
				if (result == null) result = caseM_pModelObjectType(iStateChart);
				if (result == null) result = caseElementsType(iStateChart);
				if (result == null) result = caseIModelElement(iStateChart);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.ISTATE_CHART_DIAGRAM: {
				IStateChartDiagram iStateChartDiagram = (IStateChartDiagram)theEObject;
				T result = caseIStateChartDiagram(iStateChartDiagram);
				if (result == null) result = caseIDiagram(iStateChartDiagram);
				if (result == null) result = caseIUnit(iStateChartDiagram);
				if (result == null) result = caseTheMainDiagramType(iStateChartDiagram);
				if (result == null) result = caseDeclarativesType(iStateChartDiagram);
				if (result == null) result = caseDependsOnType(iStateChartDiagram);
				if (result == null) result = caseTargetType(iStateChartDiagram);
				if (result == null) result = caseIModelElement(iStateChartDiagram);
				if (result == null) result = caseM_pModelObjectType(iStateChartDiagram);
				if (result == null) result = caseElementsType(iStateChartDiagram);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.ISTATE_VERTEX: {
				IStateVertex iStateVertex = (IStateVertex)theEObject;
				T result = caseIStateVertex(iStateVertex);
				if (result == null) result = caseIModelElement(iStateVertex);
				if (result == null) result = caseParentType(iStateVertex);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.ISTEREOTYPE: {
				IStereotype iStereotype = (IStereotype)theEObject;
				T result = caseIStereotype(iStereotype);
				if (result == null) result = caseIClassifier(iStereotype);
				if (result == null) result = caseValueType(iStereotype);
				if (result == null) result = caseDeclarativesType(iStereotype);
				if (result == null) result = caseDependsOnType(iStereotype);
				if (result == null) result = caseM_pModelObjectType(iStereotype);
				if (result == null) result = caseIUnit(iStereotype);
				if (result == null) result = caseElementsType(iStereotype);
				if (result == null) result = caseIModelElement(iStereotype);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.ISTRUCTURE_DIAGRAM: {
				IStructureDiagram iStructureDiagram = (IStructureDiagram)theEObject;
				T result = caseIStructureDiagram(iStructureDiagram);
				if (result == null) result = caseIDiagram(iStructureDiagram);
				if (result == null) result = caseIUnit(iStructureDiagram);
				if (result == null) result = caseTheMainDiagramType(iStructureDiagram);
				if (result == null) result = caseDeclarativesType(iStructureDiagram);
				if (result == null) result = caseDependsOnType(iStructureDiagram);
				if (result == null) result = caseTargetType(iStructureDiagram);
				if (result == null) result = caseIModelElement(iStructureDiagram);
				if (result == null) result = caseM_pModelObjectType(iStructureDiagram);
				if (result == null) result = caseElementsType(iStructureDiagram);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.ISUBSYSTEM: {
				ISubsystem iSubsystem = (ISubsystem)theEObject;
				T result = caseISubsystem(iSubsystem);
				if (result == null) result = caseOwnerHandleType(iSubsystem);
				if (result == null) result = caseDependsOnType(iSubsystem);
				if (result == null) result = caseDeclarativesType(iSubsystem);
				if (result == null) result = caseM_pModelObjectType(iSubsystem);
				if (result == null) result = caseTargetType(iSubsystem);
				if (result == null) result = caseDefaultSubsystemType(iSubsystem);
				if (result == null) result = caseElementsType(iSubsystem);
				if (result == null) result = caseIModelElement(iSubsystem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.ISWIMLANE: {
				ISwimlane iSwimlane = (ISwimlane)theEObject;
				T result = caseISwimlane(iSwimlane);
				if (result == null) result = caseIModelElement(iSwimlane);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.ISYS_ML_PORT: {
				ISysMLPort iSysMLPort = (ISysMLPort)theEObject;
				T result = caseISysMLPort(iSysMLPort);
				if (result == null) result = caseIInstance(iSysMLPort);
				if (result == null) result = caseDependsOnType(iSysMLPort);
				if (result == null) result = caseM_pFormalMessageType(iSysMLPort);
				if (result == null) result = caseToLinkType(iSysMLPort);
				if (result == null) result = caseEnd2_Type(iSysMLPort);
				if (result == null) result = caseIRelation(iSysMLPort);
				if (result == null) result = caseElementsType(iSysMLPort);
				if (result == null) result = caseFromLinkType(iSysMLPort);
				if (result == null) result = caseEnd1_Type(iSysMLPort);
				if (result == null) result = caseIUnit(iSysMLPort);
				if (result == null) result = caseIModelElement(iSysMLPort);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.ITABLE_INSTANCE: {
				ITableInstance iTableInstance = (ITableInstance)theEObject;
				T result = caseITableInstance(iTableInstance);
				if (result == null) result = caseTableInstancesType(iTableInstance);
				if (result == null) result = caseDependsOnType(iTableInstance);
				if (result == null) result = caseElementsType(iTableInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.ITABLE_LAYOUT: {
				ITableLayout iTableLayout = (ITableLayout)theEObject;
				T result = caseITableLayout(iTableLayout);
				if (result == null) result = caseIUnit(iTableLayout);
				if (result == null) result = caseValueType(iTableLayout);
				if (result == null) result = caseIModelElement(iTableLayout);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.ITABLE_VIEW: {
				ITableView iTableView = (ITableView)theEObject;
				T result = caseITableView(iTableView);
				if (result == null) result = caseIUnit(iTableView);
				if (result == null) result = caseIModelElement(iTableView);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.ITAG: {
				ITag iTag = (ITag)theEObject;
				T result = caseITag(iTag);
				if (result == null) result = caseIVariable(iTag);
				if (result == null) result = caseM_pModelObjectType(iTag);
				if (result == null) result = caseIUnit(iTag);
				if (result == null) result = caseIModelElement(iTag);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.ITEMPLATE_INST: {
				ITemplateInst iTemplateInst = (ITemplateInst)theEObject;
				T result = caseITemplateInst(iTemplateInst);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.ITEMPLATE_INST_PARAM: {
				ITemplateInstParam iTemplateInstParam = (ITemplateInstParam)theEObject;
				T result = caseITemplateInstParam(iTemplateInstParam);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.ITEMPLATE_INSTANTIATION: {
				ITemplateInstantiation iTemplateInstantiation = (ITemplateInstantiation)theEObject;
				T result = caseITemplateInstantiation(iTemplateInstantiation);
				if (result == null) result = caseIModelElement(iTemplateInstantiation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.ITEMPLATE_INSTANTIATION_PARAMETER: {
				ITemplateInstantiationParameter iTemplateInstantiationParameter = (ITemplateInstantiationParameter)theEObject;
				T result = caseITemplateInstantiationParameter(iTemplateInstantiationParameter);
				if (result == null) result = caseIModelElement(iTemplateInstantiationParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.ITEMPLATE_PARAMETER: {
				ITemplateParameter iTemplateParameter = (ITemplateParameter)theEObject;
				T result = caseITemplateParameter(iTemplateParameter);
				if (result == null) result = caseIVariable(iTemplateParameter);
				if (result == null) result = caseIUnit(iTemplateParameter);
				if (result == null) result = caseIModelElement(iTemplateParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.ITIME_EVENT: {
				ITimeEvent iTimeEvent = (ITimeEvent)theEObject;
				T result = caseITimeEvent(iTimeEvent);
				if (result == null) result = caseItsTargetType(iTimeEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.ITIMEOUT: {
				ITimeout iTimeout = (ITimeout)theEObject;
				T result = caseITimeout(iTimeout);
				if (result == null) result = caseItsTriggerType(iTimeout);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.ITRANSITION: {
				ITransition iTransition = (ITransition)theEObject;
				T result = caseITransition(iTransition);
				if (result == null) result = caseIModelElement(iTransition);
				if (result == null) result = caseTransitionsType(iTransition);
				if (result == null) result = caseDependsOnType(iTransition);
				if (result == null) result = caseTargetType(iTransition);
				if (result == null) result = caseElementsType(iTransition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.ITRIGGER: {
				ITrigger iTrigger = (ITrigger)theEObject;
				T result = caseITrigger(iTrigger);
				if (result == null) result = caseIModelElement(iTrigger);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.ITRIGGERED: {
				ITriggered iTriggered = (ITriggered)theEObject;
				T result = caseITriggered(iTriggered);
				if (result == null) result = caseOperationsType(iTriggered);
				if (result == null) result = caseM_pFormalMessageType(iTriggered);
				if (result == null) result = caseItemsType(iTriggered);
				if (result == null) result = caseIModelElement(iTriggered);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.ITYPE: {
				IType iType = (IType)theEObject;
				T result = caseIType(iType);
				if (result == null) result = caseIClassifier(iType);
				if (result == null) result = caseDeclarativesType(iType);
				if (result == null) result = caseDependsOnType(iType);
				if (result == null) result = caseM_subjectType(iType);
				if (result == null) result = caseValueType(iType);
				if (result == null) result = caseTargetType(iType);
				if (result == null) result = caseM_pModelObjectType(iType);
				if (result == null) result = caseIUnit(iType);
				if (result == null) result = caseElementsType(iType);
				if (result == null) result = caseIModelElement(iType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IUC_DIAGRAM: {
				IUCDiagram iucDiagram = (IUCDiagram)theEObject;
				T result = caseIUCDiagram(iucDiagram);
				if (result == null) result = caseTheMainDiagramType(iucDiagram);
				if (result == null) result = caseDependsOnType(iucDiagram);
				if (result == null) result = caseDeclarativesType(iucDiagram);
				if (result == null) result = caseM_pModelObjectType(iucDiagram);
				if (result == null) result = caseElementsType(iucDiagram);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IUNIT: {
				IUnit iUnit = (IUnit)theEObject;
				T result = caseIUnit(iUnit);
				if (result == null) result = caseIModelElement(iUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IUSE_CASE: {
				IUseCase iUseCase = (IUseCase)theEObject;
				T result = caseIUseCase(iUseCase);
				if (result == null) result = caseIClassifier(iUseCase);
				if (result == null) result = caseDependsOnType(iUseCase);
				if (result == null) result = caseEnd2_Type(iUseCase);
				if (result == null) result = caseTargetType(iUseCase);
				if (result == null) result = caseIUnit(iUseCase);
				if (result == null) result = caseElementsType(iUseCase);
				if (result == null) result = caseEnd1_Type(iUseCase);
				if (result == null) result = caseIModelElement(iUseCase);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IUSE_CASE_DIAGRAM: {
				IUseCaseDiagram iUseCaseDiagram = (IUseCaseDiagram)theEObject;
				T result = caseIUseCaseDiagram(iUseCaseDiagram);
				if (result == null) result = caseIDiagram(iUseCaseDiagram);
				if (result == null) result = caseIUnit(iUseCaseDiagram);
				if (result == null) result = caseTheMainDiagramType(iUseCaseDiagram);
				if (result == null) result = caseDeclarativesType(iUseCaseDiagram);
				if (result == null) result = caseDependsOnType(iUseCaseDiagram);
				if (result == null) result = caseTargetType(iUseCaseDiagram);
				if (result == null) result = caseIModelElement(iUseCaseDiagram);
				if (result == null) result = caseM_pModelObjectType(iUseCaseDiagram);
				if (result == null) result = caseElementsType(iUseCaseDiagram);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IUSE_CASE_STEREO_TYPE: {
				IUseCaseStereoType iUseCaseStereoType = (IUseCaseStereoType)theEObject;
				T result = caseIUseCaseStereoType(iUseCaseStereoType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IVALUE_SPECIFICATION: {
				IValueSpecification iValueSpecification = (IValueSpecification)theEObject;
				T result = caseIValueSpecification(iValueSpecification);
				if (result == null) result = caseIModelElement(iValueSpecification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.IVARIABLE: {
				IVariable iVariable = (IVariable)theEObject;
				T result = caseIVariable(iVariable);
				if (result == null) result = caseIUnit(iVariable);
				if (result == null) result = caseIModelElement(iVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.INVERSE_TYPE: {
				InverseType inverseType = (InverseType)theEObject;
				T result = caseInverseType(inverseType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.ITEMS_TYPE: {
				ItemsType itemsType = (ItemsType)theEObject;
				T result = caseItemsType(itemsType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.ITS_LABEL_TYPE: {
				ItsLabelType itsLabelType = (ItsLabelType)theEObject;
				T result = caseItsLabelType(itsLabelType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.ITS_STATE_CHART_TYPE: {
				ItsStateChartType itsStateChartType = (ItsStateChartType)theEObject;
				T result = caseItsStateChartType(itsStateChartType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.ITS_TARGET_TYPE: {
				ItsTargetType itsTargetType = (ItsTargetType)theEObject;
				T result = caseItsTargetType(itsTargetType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.ITS_TRIGGER_TYPE: {
				ItsTriggerType itsTriggerType = (ItsTriggerType)theEObject;
				T result = caseItsTriggerType(itsTriggerType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.LINKS_TYPE: {
				LinksType linksType = (LinksType)theEObject;
				T result = caseLinksType(linksType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.MHTARGET_TYPE: {
				M_hTargetType m_hTargetType = (M_hTargetType)theEObject;
				T result = caseM_hTargetType(m_hTargetType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.MPBASE_TYPE: {
				M_pBaseType m_pBaseType = (M_pBaseType)theEObject;
				T result = caseM_pBaseType(m_pBaseType);
				if (result == null) result = caseM_pModelObjectType(m_pBaseType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.MPFORMAL_MESSAGE_TYPE: {
				M_pFormalMessageType m_pFormalMessageType = (M_pFormalMessageType)theEObject;
				T result = caseM_pFormalMessageType(m_pFormalMessageType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.MPMODEL_OBJECT_TYPE: {
				M_pModelObjectType m_pModelObjectType = (M_pModelObjectType)theEObject;
				T result = caseM_pModelObjectType(m_pModelObjectType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.MPROOT_TYPE: {
				M_pRootType m_pRootType = (M_pRootType)theEObject;
				T result = caseM_pRootType(m_pRootType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.MSUBJECT_TYPE: {
				M_subjectType m_subjectType = (M_subjectType)theEObject;
				T result = caseM_subjectType(m_subjectType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.MATRIX_INSTANCES_TYPE: {
				MatrixInstancesType matrixInstancesType = (MatrixInstancesType)theEObject;
				T result = caseMatrixInstancesType(matrixInstancesType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.NESTED_STATE_CHART_TYPE: {
				NestedStateChartType nestedStateChartType = (NestedStateChartType)theEObject;
				T result = caseNestedStateChartType(nestedStateChartType);
				if (result == null) result = caseItsStateChartType(nestedStateChartType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.OBJECT_LINKS_TYPE: {
				ObjectLinksType objectLinksType = (ObjectLinksType)theEObject;
				T result = caseObjectLinksType(objectLinksType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.OPERATIONS_TYPE: {
				OperationsType operationsType = (OperationsType)theEObject;
				T result = caseOperationsType(operationsType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.OWNER_HANDLE_TYPE: {
				OwnerHandleType ownerHandleType = (OwnerHandleType)theEObject;
				T result = caseOwnerHandleType(ownerHandleType);
				if (result == null) result = caseDefaultSubsystemType(ownerHandleType);
				if (result == null) result = caseIModelElement(ownerHandleType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.PMESSAGE_HANDLER_TYPE: {
				P_MessageHandlerType p_MessageHandlerType = (P_MessageHandlerType)theEObject;
				T result = caseP_MessageHandlerType(p_MessageHandlerType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.PARENT_TYPE: {
				ParentType parentType = (ParentType)theEObject;
				T result = caseParentType(parentType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.PROPERTIES_TYPE: {
				PropertiesType propertiesType = (PropertiesType)theEObject;
				T result = casePropertiesType(propertiesType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.TABLE_DATA_DEFINITION: {
				TableDataDefinition tableDataDefinition = (TableDataDefinition)theEObject;
				T result = caseTableDataDefinition(tableDataDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.TABLE_INSTANCES_TYPE: {
				TableInstancesType tableInstancesType = (TableInstancesType)theEObject;
				T result = caseTableInstancesType(tableInstancesType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.TARGET_TYPE: {
				TargetType targetType = (TargetType)theEObject;
				T result = caseTargetType(targetType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.THE_MAIN_DIAGRAM_TYPE: {
				TheMainDiagramType theMainDiagramType = (TheMainDiagramType)theEObject;
				T result = caseTheMainDiagramType(theMainDiagramType);
				if (result == null) result = caseM_pModelObjectType(theMainDiagramType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.TO_LINK_TYPE: {
				ToLinkType toLinkType = (ToLinkType)theEObject;
				T result = caseToLinkType(toLinkType);
				if (result == null) result = caseFromLinkType(toLinkType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.TRANSITIONS_TYPE: {
				TransitionsType transitionsType = (TransitionsType)theEObject;
				T result = caseTransitionsType(transitionsType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.UNKNOWN_TYPE: {
				UnknownType unknownType = (UnknownType)theEObject;
				T result = caseUnknownType(unknownType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLRhapsodyPackage.VALUE_TYPE: {
				ValueType valueType = (ValueType)theEObject;
				T result = caseValueType(valueType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Associations Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Associations Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAssociationsType(AssociationsType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CCollaboration Chart</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CCollaboration Chart</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCCollaborationChart(CCollaborationChart object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CGI Action State</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CGI Action State</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGIActionState(CGIActionState object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CGI Active X</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CGI Active X</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGIActiveX(CGIActiveX object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CGI Anchor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CGI Anchor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGIAnchor(CGIAnchor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CGI Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CGI Annotation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGIAnnotation(CGIAnnotation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CGI Arrow</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CGI Arrow</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGIArrow(CGIArrow object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CGI Association End</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CGI Association End</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGIAssociationEnd(CGIAssociationEnd object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CGI Association Role</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CGI Association Role</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGIAssociationRole(CGIAssociationRole object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CGI Basic Class</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CGI Basic Class</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGIBasicClass(CGIBasicClass object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CGI Block State</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CGI Block State</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGIBlockState(CGIBlockState object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CGI Box</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CGI Box</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGIBox(CGIBox object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CGI Button Array</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CGI Button Array</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGIButtonArray(CGIButtonArray object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CGI Class</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CGI Class</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGIClass(CGIClass object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CGI Class Chart</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CGI Class Chart</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGIClassChart(CGIClassChart object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CGI Classifier Role</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CGI Classifier Role</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGIClassifierRole(CGIClassifierRole object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CGI Compartment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CGI Compartment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGICompartment(CGICompartment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CGI Component</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CGI Component</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGIComponent(CGIComponent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CGI Composite Class</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CGI Composite Class</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGICompositeClass(CGICompositeClass object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CGI Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CGI Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGIConnector(CGIConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CGI Contain Arrow</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CGI Contain Arrow</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGIContainArrow(CGIContainArrow object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CGI Diagram Frame</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CGI Diagram Frame</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGIDiagramFrame(CGIDiagramFrame object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CGI Free Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CGI Free Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGIFreeShape(CGIFreeShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CGI Free Text</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CGI Free Text</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGIFreeText(CGIFreeText object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CGI Generic Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CGI Generic Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGIGenericElement(CGIGenericElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CGI Image</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CGI Image</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGIImage(CGIImage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CGI Image Data</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CGI Image Data</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGIImageData(CGIImageData object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CGI Information Flow</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CGI Information Flow</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGIInformationFlow(CGIInformationFlow object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CGI Inheritance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CGI Inheritance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGIInheritance(CGIInheritance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CGIMFC Ctrl</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CGIMFC Ctrl</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGIMFCCtrl(CGIMFCCtrl object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CGI Message Label</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CGI Message Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGIMessageLabel(CGIMessageLabel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CGI Msc Chart</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CGI Msc Chart</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGIMscChart(CGIMscChart object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CGI Msc Column CR</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CGI Msc Column CR</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGIMscColumnCR(CGIMscColumnCR object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CGI Msc Condition Mark</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CGI Msc Condition Mark</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGIMscConditionMark(CGIMscConditionMark object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CGI Msc Execution Occurrence</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CGI Msc Execution Occurrence</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGIMscExecutionOccurrence(CGIMscExecutionOccurrence object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CGI Msc Interaction Occurrence</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CGI Msc Interaction Occurrence</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGIMscInteractionOccurrence(CGIMscInteractionOccurrence object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CGI Msc Interaction Operand</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CGI Msc Interaction Operand</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGIMscInteractionOperand(CGIMscInteractionOperand object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CGI Msc Interaction Operator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CGI Msc Interaction Operator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGIMscInteractionOperator(CGIMscInteractionOperator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CGI Msc Message</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CGI Msc Message</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGIMscMessage(CGIMscMessage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CGI Object Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CGI Object Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGIObjectInstance(CGIObjectInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CGI Object Link</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CGI Object Link</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGIObjectLink(CGIObjectLink object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CGI Package</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CGI Package</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGIPackage(CGIPackage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CGI Partition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CGI Partition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGIPartition(CGIPartition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CGI Port Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CGI Port Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGIPortConnector(CGIPortConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CGI State</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CGI State</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGIState(CGIState object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CGI State Chart</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CGI State Chart</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGIStateChart(CGIStateChart object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CGI Swimlane Frame</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CGI Swimlane Frame</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGISwimlaneFrame(CGISwimlaneFrame object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CGI Text</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CGI Text</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGIText(CGIText object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CGI Text Box</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CGI Text Box</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGITextBox(CGITextBox object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CGI Trans</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CGI Trans</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGITrans(CGITrans object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Coll Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Coll Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCollEvent(CollEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Compartments Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Compartments Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompartmentsType(CompartmentsType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Components Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Components Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComponentsType(ComponentsType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Conveyed Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Conveyed Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConveyedType(ConveyedType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Declaratives Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Declaratives Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDeclarativesType(DeclarativesType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Default Subsystem Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Default Subsystem Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDefaultSubsystemType(DefaultSubsystemType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Default Trans Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Default Trans Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDefaultTransType(DefaultTransType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Depends On Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Depends On Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDependsOnType(DependsOnType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Description Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Description Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDescriptionType(DescriptionType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Elements Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Elements Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElementsType(ElementsType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Embeded Files Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Embeded Files Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEmbededFilesType(EmbededFilesType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>End1 Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>End1 Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnd1_Type(End1_Type object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>End2 Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>End2 Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnd2_Type(End2_Type object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Files Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Files Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFilesType(FilesType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>From Link Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>From Link Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFromLinkType(FromLinkType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Graph Elements Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Graph Elements Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGraphElementsType(GraphElementsType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Graphic Chart Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Graphic Chart Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGraphicChartType(GraphicChartType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Hyper Links Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Hyper Links Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHyperLinksType(HyperLinksType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IAccept Event Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IAccept Event Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIAcceptEventAction(IAcceptEventAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IAccept Time Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IAccept Time Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIAcceptTimeEvent(IAcceptTimeEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IAction</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IAction</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIAction(IAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IActivity Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IActivity Diagram</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIActivityDiagram(IActivityDiagram object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IActivity Graph</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IActivity Graph</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIActivityGraph(IActivityGraph object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IActor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IActor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIActor(IActor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IAnchor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IAnchor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIAnchor(IAnchor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IAnnotation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IAnnotation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIAnnotation(IAnnotation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IArgument</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IArgument</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIArgument(IArgument object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IAssociation Class</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IAssociation Class</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIAssociationClass(IAssociationClass object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IAssociation End</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IAssociation End</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIAssociationEnd(IAssociationEnd object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IAssociation End Handle</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IAssociation End Handle</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIAssociationEndHandle(IAssociationEndHandle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IAssociation Role</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IAssociation Role</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIAssociationRole(IAssociationRole object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IAttribute</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IAttribute</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIAttribute(IAttribute object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IBlock</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IBlock</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIBlock(IBlock object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IBody</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IBody</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIBody(IBody object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IBranch</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IBranch</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIBranch(IBranch object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ICall Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ICall Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseICallAction(ICallAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ICall Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ICall Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseICallOperation(ICallOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IClass</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IClass</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIClass(IClass object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IClass Handle</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IClass Handle</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIClassHandle(IClassHandle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IClass Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IClass Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIClassInstance(IClassInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IClassifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IClassifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIClassifier(IClassifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IClassifier Role</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IClassifier Role</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIClassifierRole(IClassifierRole object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ICode Gen Config Info</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ICode Gen Config Info</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseICodeGenConfigInfo(ICodeGenConfigInfo object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ICode Gen Config Info Handle</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ICode Gen Config Info Handle</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseICodeGenConfigInfoHandle(ICodeGenConfigInfoHandle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ICollaboration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ICollaboration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseICollaboration(ICollaboration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ICollaboration Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ICollaboration Diagram</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseICollaborationDiagram(ICollaborationDiagram object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IColor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IColor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIColor(IColor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ICombined Fragment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ICombined Fragment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseICombinedFragment(ICombinedFragment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IComment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IComment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIComment(IComment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IComponent</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IComponent</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIComponent(IComponent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IComponent Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IComponent Diagram</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIComponentDiagram(IComponentDiagram object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IComponent Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IComponent Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIComponentInstance(IComponentInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IConfiguration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IConfiguration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIConfiguration(IConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IConnector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IConnector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIConnector(IConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IConstraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IConstraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIConstraint(IConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IConstructor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IConstructor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIConstructor(IConstructor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IContext Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IContext Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIContextSpecification(IContextSpecification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IControlled File</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IControlled File</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIControlledFile(IControlledFile object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IDefault Drvd Trans</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IDefault Drvd Trans</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIDefaultDrvdTrans(IDefaultDrvdTrans object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IDependency</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IDependency</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIDependency(IDependency object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IDeployment Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IDeployment Diagram</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIDeploymentDiagram(IDeploymentDiagram object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IDescription</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IDescription</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIDescription(IDescription object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IDestructor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IDestructor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIDestructor(IDestructor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IDiagram</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IDiagram</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIDiagram(IDiagram object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IEmbeded File</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IEmbeded File</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIEmbededFile(IEmbededFile object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IEnumeration Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IEnumeration Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIEnumerationLiteral(IEnumerationLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IEvent</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IEvent</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIEvent(IEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IEvent Handle</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IEvent Handle</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIEventHandle(IEventHandle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IEvent Reception</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IEvent Reception</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIEventReception(IEventReception object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IExecution Occurrence</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IExecution Occurrence</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIExecutionOccurrence(IExecutionOccurrence object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IExternal Hyperlink</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IExternal Hyperlink</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIExternalHyperlink(IExternalHyperlink object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IFile</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IFile</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIFile(IFile object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IFile Fragment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IFile Fragment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIFileFragment(IFileFragment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IFlow</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IFlow</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIFlow(IFlow object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IFlow Item</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IFlow Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIFlowItem(IFlowItem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IFlowchart</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IFlowchart</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIFlowchart(IFlowchart object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IFolder</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IFolder</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIFolder(IFolder object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IFork</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IFork</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIFork(IFork object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IGeneralization</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IGeneralization</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIGeneralization(IGeneralization object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IGuard</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IGuard</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIGuard(IGuard object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IHandle With Data</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IHandle With Data</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIHandleWithData(IHandleWithData object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IHistory Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IHistory Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIHistoryConnector(IHistoryConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IHyper Link</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IHyper Link</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIHyperLink(IHyperLink object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IInformation Flow</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IInformation Flow</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIInformationFlow(IInformationFlow object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IInformation Item</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IInformation Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIInformationItem(IInformationItem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IInstance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IInstance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIInstance(IInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IInstance Slot</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IInstance Slot</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIInstanceSlot(IInstanceSlot object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IInstance Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IInstance Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIInstanceSpecification(IInstanceSpecification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IInstance Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IInstance Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIInstanceValue(IInstanceValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IInteraction Occurrence</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IInteraction Occurrence</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIInteractionOccurrence(IInteractionOccurrence object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IInteraction Operand</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IInteraction Operand</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIInteractionOperand(IInteractionOperand object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IInteraction Operator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IInteraction Operator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIInteractionOperator(IInteractionOperator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IInterface Item</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IInterface Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIInterfaceItem(IInterfaceItem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IInterface Item Trigger</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IInterface Item Trigger</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIInterfaceItemTrigger(IInterfaceItemTrigger object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IInternal Hyperlink</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IInternal Hyperlink</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIInternalHyperlink(IInternalHyperlink object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ILabel</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ILabel</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseILabel(ILabel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ILink</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ILink</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseILink(ILink object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ILink Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ILink Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseILinkInstance(ILinkInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ILiteral Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ILiteral Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseILiteralSpecification(ILiteralSpecification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IM Hyper Link</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IM Hyper Link</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIMHyperLink(IMHyperLink object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IMSC</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IMSC</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIMSC(IMSC object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IMatrix Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IMatrix Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIMatrixInstance(IMatrixInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IMatrix Layout</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IMatrix Layout</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIMatrixLayout(IMatrixLayout object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IMatrix View</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IMatrix View</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIMatrixView(IMatrixView object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IMessage</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IMessage</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIMessage(IMessage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IMessage Point</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IMessage Point</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIMessagePoint(IMessagePoint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IMeta Link Handle</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IMeta Link Handle</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIMetaLinkHandle(IMetaLinkHandle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IModel Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IModel Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIModelElement(IModelElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IModule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IModule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIModule(IModule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IMultiplicity Item</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IMultiplicity Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIMultiplicityItem(IMultiplicityItem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>INode</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>INode</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseINode(INode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IObject Link</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IObject Link</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIObjectLink(IObjectLink object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IObject Link Handle</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IObject Link Handle</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIObjectLinkHandle(IObjectLinkHandle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IObject Model Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IObject Model Diagram</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIObjectModelDiagram(IObjectModelDiagram object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IObject Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IObject Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIObjectNode(IObjectNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IOperation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IOperation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIOperation(IOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IPackage</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IPackage</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIPackage(IPackage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IPanel Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IPanel Diagram</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIPanelDiagram(IPanelDiagram object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IPart</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IPart</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIPart(IPart object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IPin</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IPin</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIPin(IPin object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IPort</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IPort</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIPort(IPort object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IPrimitive Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IPrimitive Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIPrimitiveOperation(IPrimitiveOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IProfile</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IProfile</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIProfile(IProfile object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IProject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IProject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIProject(IProject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IProperty</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IProperty</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIProperty(IProperty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IProperty Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IProperty Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIPropertyContainer(IPropertyContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IProperty Metaclass</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IProperty Metaclass</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIPropertyMetaclass(IPropertyMetaclass object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IProperty Subject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IProperty Subject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIPropertySubject(IPropertySubject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IReception</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IReception</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIReception(IReception object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IReference Activity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IReference Activity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIReferenceActivity(IReferenceActivity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IRelation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IRelation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIRelation(IRelation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IRequirement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IRequirement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIRequirement(IRequirement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ISend Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ISend Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseISendAction(ISendAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ISequence Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ISequence Diagram</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseISequenceDiagram(ISequenceDiagram object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ISlot</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ISlot</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseISlot(ISlot object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IState</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IState</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIState(IState object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IState Chart</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IState Chart</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIStateChart(IStateChart object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IState Chart Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IState Chart Diagram</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIStateChartDiagram(IStateChartDiagram object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IState Vertex</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IState Vertex</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIStateVertex(IStateVertex object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IStereotype</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IStereotype</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIStereotype(IStereotype object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IStructure Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IStructure Diagram</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIStructureDiagram(IStructureDiagram object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ISubsystem</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ISubsystem</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseISubsystem(ISubsystem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ISwimlane</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ISwimlane</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseISwimlane(ISwimlane object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ISys ML Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ISys ML Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseISysMLPort(ISysMLPort object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ITable Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ITable Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseITableInstance(ITableInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ITable Layout</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ITable Layout</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseITableLayout(ITableLayout object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ITable View</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ITable View</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseITableView(ITableView object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ITag</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ITag</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseITag(ITag object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ITemplate Inst</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ITemplate Inst</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseITemplateInst(ITemplateInst object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ITemplate Inst Param</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ITemplate Inst Param</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseITemplateInstParam(ITemplateInstParam object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ITemplate Instantiation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ITemplate Instantiation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseITemplateInstantiation(ITemplateInstantiation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ITemplate Instantiation Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ITemplate Instantiation Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseITemplateInstantiationParameter(ITemplateInstantiationParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ITemplate Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ITemplate Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseITemplateParameter(ITemplateParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ITime Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ITime Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseITimeEvent(ITimeEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ITimeout</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ITimeout</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseITimeout(ITimeout object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ITransition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ITransition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseITransition(ITransition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ITrigger</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ITrigger</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseITrigger(ITrigger object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ITriggered</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ITriggered</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseITriggered(ITriggered object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IType</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IType</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIType(IType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IUC Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IUC Diagram</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIUCDiagram(IUCDiagram object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IUnit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IUnit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIUnit(IUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IUse Case</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IUse Case</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIUseCase(IUseCase object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IUse Case Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IUse Case Diagram</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIUseCaseDiagram(IUseCaseDiagram object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IUse Case Stereo Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IUse Case Stereo Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIUseCaseStereoType(IUseCaseStereoType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IValue Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IValue Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIValueSpecification(IValueSpecification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IVariable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IVariable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIVariable(IVariable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Inverse Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Inverse Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInverseType(InverseType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Items Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Items Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseItemsType(ItemsType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Its Label Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Its Label Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseItsLabelType(ItsLabelType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Its State Chart Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Its State Chart Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseItsStateChartType(ItsStateChartType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Its Target Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Its Target Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseItsTargetType(ItsTargetType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Its Trigger Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Its Trigger Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseItsTriggerType(ItsTriggerType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Links Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Links Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLinksType(LinksType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>MhTarget Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>MhTarget Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseM_hTargetType(M_hTargetType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>MpBase Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>MpBase Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseM_pBaseType(M_pBaseType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>MpFormal Message Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>MpFormal Message Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseM_pFormalMessageType(M_pFormalMessageType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>MpModel Object Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>MpModel Object Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseM_pModelObjectType(M_pModelObjectType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>MpRoot Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>MpRoot Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseM_pRootType(M_pRootType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Msubject Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Msubject Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseM_subjectType(M_subjectType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Matrix Instances Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Matrix Instances Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMatrixInstancesType(MatrixInstancesType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Nested State Chart Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Nested State Chart Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNestedStateChartType(NestedStateChartType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Object Links Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Object Links Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseObjectLinksType(ObjectLinksType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operations Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operations Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperationsType(OperationsType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Owner Handle Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Owner Handle Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOwnerHandleType(OwnerHandleType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>PMessage Handler Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PMessage Handler Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseP_MessageHandlerType(P_MessageHandlerType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parent Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parent Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParentType(ParentType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Properties Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Properties Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertiesType(PropertiesType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Table Data Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Table Data Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTableDataDefinition(TableDataDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Table Instances Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Table Instances Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTableInstancesType(TableInstancesType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Target Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Target Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTargetType(TargetType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>The Main Diagram Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>The Main Diagram Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTheMainDiagramType(TheMainDiagramType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>To Link Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>To Link Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseToLinkType(ToLinkType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Transitions Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Transitions Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTransitionsType(TransitionsType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unknown Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unknown Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnknownType(UnknownType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Value Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Value Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseValueType(ValueType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //UMLRhapsodySwitch
