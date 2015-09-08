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
package org.eclipse.papyrus.umldi.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.papyrus.dd.di.Diagram;
import org.eclipse.papyrus.dd.di.DiagramElement;
import org.eclipse.papyrus.dd.di.Edge;
import org.eclipse.papyrus.dd.di.Shape;
import org.eclipse.papyrus.dd.di.Style;

import org.eclipse.papyrus.umldi.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.umldi.UMLDIPackage
 * @generated
 */
public class UMLDISwitch<T> extends Switch<T> {

	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static UMLDIPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public UMLDISwitch() {
		if(modelPackage == null) {
			modelPackage = UMLDIPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param ePackage
	 *        the package in question.
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
	 * 
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch(classifierID) {
		case UMLDIPackage.UML_DIAGRAM:
		{
			UmlDiagram umlDiagram = (UmlDiagram)theEObject;
			T result = caseUmlDiagram(umlDiagram);
			if(result == null)
				result = caseUmlDiagramElement(umlDiagram);
			if(result == null)
				result = caseDiagram(umlDiagram);
			if(result == null)
				result = caseShape(umlDiagram);
			if(result == null)
				result = caseDiagramElement(umlDiagram);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.UML_DIAGRAM_ELEMENT:
		{
			UmlDiagramElement umlDiagramElement = (UmlDiagramElement)theEObject;
			T result = caseUmlDiagramElement(umlDiagramElement);
			if(result == null)
				result = caseDiagramElement(umlDiagramElement);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.UML_STYLE:
		{
			UmlStyle umlStyle = (UmlStyle)theEObject;
			T result = caseUmlStyle(umlStyle);
			if(result == null)
				result = caseStyle(umlStyle);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.UML_EDGE:
		{
			UmlEdge umlEdge = (UmlEdge)theEObject;
			T result = caseUmlEdge(umlEdge);
			if(result == null)
				result = caseTopUmlDiagramElement(umlEdge);
			if(result == null)
				result = caseEdge(umlEdge);
			if(result == null)
				result = caseStereotypedDiagramElement(umlEdge);
			if(result == null)
				result = caseUmlDiagramElement(umlEdge);
			if(result == null)
				result = caseDiagramElement(umlEdge);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.TOP_UML_DIAGRAM_ELEMENT:
		{
			TopUmlDiagramElement topUmlDiagramElement = (TopUmlDiagramElement)theEObject;
			T result = caseTopUmlDiagramElement(topUmlDiagramElement);
			if(result == null)
				result = caseStereotypedDiagramElement(topUmlDiagramElement);
			if(result == null)
				result = caseUmlDiagramElement(topUmlDiagramElement);
			if(result == null)
				result = caseDiagramElement(topUmlDiagramElement);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.STEREOTYPED_DIAGRAM_ELEMENT:
		{
			StereotypedDiagramElement stereotypedDiagramElement = (StereotypedDiagramElement)theEObject;
			T result = caseStereotypedDiagramElement(stereotypedDiagramElement);
			if(result == null)
				result = caseUmlDiagramElement(stereotypedDiagramElement);
			if(result == null)
				result = caseDiagramElement(stereotypedDiagramElement);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.STEREOTYPE_LABEL:
		{
			StereotypeLabel stereotypeLabel = (StereotypeLabel)theEObject;
			T result = caseStereotypeLabel(stereotypeLabel);
			if(result == null)
				result = caseUmlLabel(stereotypeLabel);
			if(result == null)
				result = caseUmlDiagramElement(stereotypeLabel);
			if(result == null)
				result = caseShape(stereotypeLabel);
			if(result == null)
				result = caseDiagramElement(stereotypeLabel);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.UML_LABEL:
		{
			UmlLabel umlLabel = (UmlLabel)theEObject;
			T result = caseUmlLabel(umlLabel);
			if(result == null)
				result = caseUmlDiagramElement(umlLabel);
			if(result == null)
				result = caseShape(umlLabel);
			if(result == null)
				result = caseDiagramElement(umlLabel);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.DIAGRAM_COMPARTMENT:
		{
			DiagramCompartment diagramCompartment = (DiagramCompartment)theEObject;
			T result = caseDiagramCompartment(diagramCompartment);
			if(result == null)
				result = caseUmlCompartment(diagramCompartment);
			if(result == null)
				result = caseUmlDiagramElement(diagramCompartment);
			if(result == null)
				result = caseShape(diagramCompartment);
			if(result == null)
				result = caseDiagramElement(diagramCompartment);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.UML_COMPARTMENT:
		{
			UmlCompartment umlCompartment = (UmlCompartment)theEObject;
			T result = caseUmlCompartment(umlCompartment);
			if(result == null)
				result = caseUmlDiagramElement(umlCompartment);
			if(result == null)
				result = caseShape(umlCompartment);
			if(result == null)
				result = caseDiagramElement(umlCompartment);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.MAIN_LABEL:
		{
			MainLabel mainLabel = (MainLabel)theEObject;
			T result = caseMainLabel(mainLabel);
			if(result == null)
				result = caseUmlLabel(mainLabel);
			if(result == null)
				result = caseUmlDiagramElement(mainLabel);
			if(result == null)
				result = caseShape(mainLabel);
			if(result == null)
				result = caseDiagramElement(mainLabel);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.UML_SHAPE:
		{
			UmlShape umlShape = (UmlShape)theEObject;
			T result = caseUmlShape(umlShape);
			if(result == null)
				result = caseTopUmlDiagramElement(umlShape);
			if(result == null)
				result = caseShape(umlShape);
			if(result == null)
				result = caseStereotypedDiagramElement(umlShape);
			if(result == null)
				result = caseUmlDiagramElement(umlShape);
			if(result == null)
				result = caseDiagramElement(umlShape);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.STEREOTYPE_COMPARTMENT:
		{
			StereotypeCompartment stereotypeCompartment = (StereotypeCompartment)theEObject;
			T result = caseStereotypeCompartment(stereotypeCompartment);
			if(result == null)
				result = caseListCompartment(stereotypeCompartment);
			if(result == null)
				result = caseUmlCompartment(stereotypeCompartment);
			if(result == null)
				result = caseUmlDiagramElement(stereotypeCompartment);
			if(result == null)
				result = caseShape(stereotypeCompartment);
			if(result == null)
				result = caseDiagramElement(stereotypeCompartment);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.LIST_COMPARTMENT:
		{
			ListCompartment listCompartment = (ListCompartment)theEObject;
			T result = caseListCompartment(listCompartment);
			if(result == null)
				result = caseUmlCompartment(listCompartment);
			if(result == null)
				result = caseUmlDiagramElement(listCompartment);
			if(result == null)
				result = caseShape(listCompartment);
			if(result == null)
				result = caseDiagramElement(listCompartment);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.LIST_ITEM_LABEL:
		{
			ListItemLabel listItemLabel = (ListItemLabel)theEObject;
			T result = caseListItemLabel(listItemLabel);
			if(result == null)
				result = caseStereotypedDiagramElement(listItemLabel);
			if(result == null)
				result = caseUmlLabel(listItemLabel);
			if(result == null)
				result = caseUmlDiagramElement(listItemLabel);
			if(result == null)
				result = caseShape(listItemLabel);
			if(result == null)
				result = caseDiagramElement(listItemLabel);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.CLASS_DIAGRAM:
		{
			ClassDiagram classDiagram = (ClassDiagram)theEObject;
			T result = caseClassDiagram(classDiagram);
			if(result == null)
				result = caseStructureDiagram(classDiagram);
			if(result == null)
				result = caseUmlDiagram(classDiagram);
			if(result == null)
				result = caseUmlDiagramElement(classDiagram);
			if(result == null)
				result = caseDiagram(classDiagram);
			if(result == null)
				result = caseShape(classDiagram);
			if(result == null)
				result = caseDiagramElement(classDiagram);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.STRUCTURE_DIAGRAM:
		{
			StructureDiagram structureDiagram = (StructureDiagram)theEObject;
			T result = caseStructureDiagram(structureDiagram);
			if(result == null)
				result = caseUmlDiagram(structureDiagram);
			if(result == null)
				result = caseUmlDiagramElement(structureDiagram);
			if(result == null)
				result = caseDiagram(structureDiagram);
			if(result == null)
				result = caseShape(structureDiagram);
			if(result == null)
				result = caseDiagramElement(structureDiagram);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.CLASSIFIER_SHAPE:
		{
			ClassifierShape classifierShape = (ClassifierShape)theEObject;
			T result = caseClassifierShape(classifierShape);
			if(result == null)
				result = caseTemplateableElementShape(classifierShape);
			if(result == null)
				result = caseElementShape(classifierShape);
			if(result == null)
				result = caseUmlShape(classifierShape);
			if(result == null)
				result = caseTopUmlDiagramElement(classifierShape);
			if(result == null)
				result = caseShape(classifierShape);
			if(result == null)
				result = caseStereotypedDiagramElement(classifierShape);
			if(result == null)
				result = caseUmlDiagramElement(classifierShape);
			if(result == null)
				result = caseDiagramElement(classifierShape);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.TEMPLATEABLE_ELEMENT_SHAPE:
		{
			TemplateableElementShape templateableElementShape = (TemplateableElementShape)theEObject;
			T result = caseTemplateableElementShape(templateableElementShape);
			if(result == null)
				result = caseElementShape(templateableElementShape);
			if(result == null)
				result = caseUmlShape(templateableElementShape);
			if(result == null)
				result = caseTopUmlDiagramElement(templateableElementShape);
			if(result == null)
				result = caseShape(templateableElementShape);
			if(result == null)
				result = caseStereotypedDiagramElement(templateableElementShape);
			if(result == null)
				result = caseUmlDiagramElement(templateableElementShape);
			if(result == null)
				result = caseDiagramElement(templateableElementShape);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.ELEMENT_SHAPE:
		{
			ElementShape elementShape = (ElementShape)theEObject;
			T result = caseElementShape(elementShape);
			if(result == null)
				result = caseUmlShape(elementShape);
			if(result == null)
				result = caseTopUmlDiagramElement(elementShape);
			if(result == null)
				result = caseShape(elementShape);
			if(result == null)
				result = caseStereotypedDiagramElement(elementShape);
			if(result == null)
				result = caseUmlDiagramElement(elementShape);
			if(result == null)
				result = caseDiagramElement(elementShape);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.TEMPLATE_PARAMETER_COMPARTMENT:
		{
			TemplateParameterCompartment templateParameterCompartment = (TemplateParameterCompartment)theEObject;
			T result = caseTemplateParameterCompartment(templateParameterCompartment);
			if(result == null)
				result = caseListCompartment(templateParameterCompartment);
			if(result == null)
				result = caseUmlCompartment(templateParameterCompartment);
			if(result == null)
				result = caseUmlDiagramElement(templateParameterCompartment);
			if(result == null)
				result = caseShape(templateParameterCompartment);
			if(result == null)
				result = caseDiagramElement(templateParameterCompartment);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.OWNED_USE_CASE_COMPARTMENT:
		{
			OwnedUseCaseCompartment ownedUseCaseCompartment = (OwnedUseCaseCompartment)theEObject;
			T result = caseOwnedUseCaseCompartment(ownedUseCaseCompartment);
			if(result == null)
				result = caseClassifierCompartment(ownedUseCaseCompartment);
			if(result == null)
				result = caseDiagramCompartment(ownedUseCaseCompartment);
			if(result == null)
				result = caseListCompartment(ownedUseCaseCompartment);
			if(result == null)
				result = caseUmlCompartment(ownedUseCaseCompartment);
			if(result == null)
				result = caseUmlDiagramElement(ownedUseCaseCompartment);
			if(result == null)
				result = caseShape(ownedUseCaseCompartment);
			if(result == null)
				result = caseDiagramElement(ownedUseCaseCompartment);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.CLASSIFIER_COMPARTMENT:
		{
			ClassifierCompartment classifierCompartment = (ClassifierCompartment)theEObject;
			T result = caseClassifierCompartment(classifierCompartment);
			if(result == null)
				result = caseDiagramCompartment(classifierCompartment);
			if(result == null)
				result = caseListCompartment(classifierCompartment);
			if(result == null)
				result = caseUmlCompartment(classifierCompartment);
			if(result == null)
				result = caseUmlDiagramElement(classifierCompartment);
			if(result == null)
				result = caseShape(classifierCompartment);
			if(result == null)
				result = caseDiagramElement(classifierCompartment);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.USE_CASE_COMPARTMENT:
		{
			UseCaseCompartment useCaseCompartment = (UseCaseCompartment)theEObject;
			T result = caseUseCaseCompartment(useCaseCompartment);
			if(result == null)
				result = caseDiagramCompartment(useCaseCompartment);
			if(result == null)
				result = caseUmlCompartment(useCaseCompartment);
			if(result == null)
				result = caseUmlDiagramElement(useCaseCompartment);
			if(result == null)
				result = caseShape(useCaseCompartment);
			if(result == null)
				result = caseDiagramElement(useCaseCompartment);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.PACKAGE_SHAPE:
		{
			PackageShape packageShape = (PackageShape)theEObject;
			T result = casePackageShape(packageShape);
			if(result == null)
				result = caseElementWithPackagedElementsShape(packageShape);
			if(result == null)
				result = caseTemplateableElementShape(packageShape);
			if(result == null)
				result = caseElementShape(packageShape);
			if(result == null)
				result = caseUmlShape(packageShape);
			if(result == null)
				result = caseTopUmlDiagramElement(packageShape);
			if(result == null)
				result = caseShape(packageShape);
			if(result == null)
				result = caseStereotypedDiagramElement(packageShape);
			if(result == null)
				result = caseUmlDiagramElement(packageShape);
			if(result == null)
				result = caseDiagramElement(packageShape);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.ELEMENT_WITH_PACKAGED_ELEMENTS_SHAPE:
		{
			ElementWithPackagedElementsShape elementWithPackagedElementsShape = (ElementWithPackagedElementsShape)theEObject;
			T result = caseElementWithPackagedElementsShape(elementWithPackagedElementsShape);
			if(result == null)
				result = caseElementShape(elementWithPackagedElementsShape);
			if(result == null)
				result = caseUmlShape(elementWithPackagedElementsShape);
			if(result == null)
				result = caseTopUmlDiagramElement(elementWithPackagedElementsShape);
			if(result == null)
				result = caseShape(elementWithPackagedElementsShape);
			if(result == null)
				result = caseStereotypedDiagramElement(elementWithPackagedElementsShape);
			if(result == null)
				result = caseUmlDiagramElement(elementWithPackagedElementsShape);
			if(result == null)
				result = caseDiagramElement(elementWithPackagedElementsShape);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.PACKAGED_ELEMENT_COMPARTMENT:
		{
			PackagedElementCompartment packagedElementCompartment = (PackagedElementCompartment)theEObject;
			T result = casePackagedElementCompartment(packagedElementCompartment);
			if(result == null)
				result = caseDiagramCompartment(packagedElementCompartment);
			if(result == null)
				result = caseUmlCompartment(packagedElementCompartment);
			if(result == null)
				result = caseUmlDiagramElement(packagedElementCompartment);
			if(result == null)
				result = caseShape(packagedElementCompartment);
			if(result == null)
				result = caseDiagramElement(packagedElementCompartment);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.CONSTRAINT_SHAPE:
		{
			ConstraintShape constraintShape = (ConstraintShape)theEObject;
			T result = caseConstraintShape(constraintShape);
			if(result == null)
				result = caseElementShape(constraintShape);
			if(result == null)
				result = caseUmlShape(constraintShape);
			if(result == null)
				result = caseTopUmlDiagramElement(constraintShape);
			if(result == null)
				result = caseShape(constraintShape);
			if(result == null)
				result = caseStereotypedDiagramElement(constraintShape);
			if(result == null)
				result = caseUmlDiagramElement(constraintShape);
			if(result == null)
				result = caseDiagramElement(constraintShape);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.ATTRIBUTE_COMPARTMENT:
		{
			AttributeCompartment attributeCompartment = (AttributeCompartment)theEObject;
			T result = caseAttributeCompartment(attributeCompartment);
			if(result == null)
				result = caseListCompartment(attributeCompartment);
			if(result == null)
				result = caseUmlCompartment(attributeCompartment);
			if(result == null)
				result = caseUmlDiagramElement(attributeCompartment);
			if(result == null)
				result = caseShape(attributeCompartment);
			if(result == null)
				result = caseDiagramElement(attributeCompartment);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.CLASSIFIER_WITH_ATTRIBUTES_SHAPE:
		{
			ClassifierWithAttributesShape classifierWithAttributesShape = (ClassifierWithAttributesShape)theEObject;
			T result = caseClassifierWithAttributesShape(classifierWithAttributesShape);
			if(result == null)
				result = caseClassifierShape(classifierWithAttributesShape);
			if(result == null)
				result = caseTemplateableElementShape(classifierWithAttributesShape);
			if(result == null)
				result = caseElementShape(classifierWithAttributesShape);
			if(result == null)
				result = caseUmlShape(classifierWithAttributesShape);
			if(result == null)
				result = caseTopUmlDiagramElement(classifierWithAttributesShape);
			if(result == null)
				result = caseShape(classifierWithAttributesShape);
			if(result == null)
				result = caseStereotypedDiagramElement(classifierWithAttributesShape);
			if(result == null)
				result = caseUmlDiagramElement(classifierWithAttributesShape);
			if(result == null)
				result = caseDiagramElement(classifierWithAttributesShape);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.OPERATION_COMPARTMENT:
		{
			OperationCompartment operationCompartment = (OperationCompartment)theEObject;
			T result = caseOperationCompartment(operationCompartment);
			if(result == null)
				result = caseListCompartment(operationCompartment);
			if(result == null)
				result = caseUmlCompartment(operationCompartment);
			if(result == null)
				result = caseUmlDiagramElement(operationCompartment);
			if(result == null)
				result = caseShape(operationCompartment);
			if(result == null)
				result = caseDiagramElement(operationCompartment);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.CLASSIFIER_WITH_OPERATIONS_SHAPE:
		{
			ClassifierWithOperationsShape classifierWithOperationsShape = (ClassifierWithOperationsShape)theEObject;
			T result = caseClassifierWithOperationsShape(classifierWithOperationsShape);
			if(result == null)
				result = caseClassifierWithAttributesShape(classifierWithOperationsShape);
			if(result == null)
				result = caseClassifierShape(classifierWithOperationsShape);
			if(result == null)
				result = caseTemplateableElementShape(classifierWithOperationsShape);
			if(result == null)
				result = caseElementShape(classifierWithOperationsShape);
			if(result == null)
				result = caseUmlShape(classifierWithOperationsShape);
			if(result == null)
				result = caseTopUmlDiagramElement(classifierWithOperationsShape);
			if(result == null)
				result = caseShape(classifierWithOperationsShape);
			if(result == null)
				result = caseStereotypedDiagramElement(classifierWithOperationsShape);
			if(result == null)
				result = caseUmlDiagramElement(classifierWithOperationsShape);
			if(result == null)
				result = caseDiagramElement(classifierWithOperationsShape);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.RECEPTION_COMPARTMENT:
		{
			ReceptionCompartment receptionCompartment = (ReceptionCompartment)theEObject;
			T result = caseReceptionCompartment(receptionCompartment);
			if(result == null)
				result = caseListCompartment(receptionCompartment);
			if(result == null)
				result = caseUmlCompartment(receptionCompartment);
			if(result == null)
				result = caseUmlDiagramElement(receptionCompartment);
			if(result == null)
				result = caseShape(receptionCompartment);
			if(result == null)
				result = caseDiagramElement(receptionCompartment);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.CLASSIFIER_WITH_RECEPTIONS_SHAPE:
		{
			ClassifierWithReceptionsShape classifierWithReceptionsShape = (ClassifierWithReceptionsShape)theEObject;
			T result = caseClassifierWithReceptionsShape(classifierWithReceptionsShape);
			if(result == null)
				result = caseClassifierWithOperationsShape(classifierWithReceptionsShape);
			if(result == null)
				result = caseClassifierWithAttributesShape(classifierWithReceptionsShape);
			if(result == null)
				result = caseClassifierShape(classifierWithReceptionsShape);
			if(result == null)
				result = caseTemplateableElementShape(classifierWithReceptionsShape);
			if(result == null)
				result = caseElementShape(classifierWithReceptionsShape);
			if(result == null)
				result = caseUmlShape(classifierWithReceptionsShape);
			if(result == null)
				result = caseTopUmlDiagramElement(classifierWithReceptionsShape);
			if(result == null)
				result = caseShape(classifierWithReceptionsShape);
			if(result == null)
				result = caseStereotypedDiagramElement(classifierWithReceptionsShape);
			if(result == null)
				result = caseUmlDiagramElement(classifierWithReceptionsShape);
			if(result == null)
				result = caseDiagramElement(classifierWithReceptionsShape);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.LITERAL_COMPARTMENT:
		{
			LiteralCompartment literalCompartment = (LiteralCompartment)theEObject;
			T result = caseLiteralCompartment(literalCompartment);
			if(result == null)
				result = caseListCompartment(literalCompartment);
			if(result == null)
				result = caseUmlCompartment(literalCompartment);
			if(result == null)
				result = caseUmlDiagramElement(literalCompartment);
			if(result == null)
				result = caseShape(literalCompartment);
			if(result == null)
				result = caseDiagramElement(literalCompartment);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.ENUMERATION_SHAPE:
		{
			EnumerationShape enumerationShape = (EnumerationShape)theEObject;
			T result = caseEnumerationShape(enumerationShape);
			if(result == null)
				result = caseClassifierShape(enumerationShape);
			if(result == null)
				result = caseTemplateableElementShape(enumerationShape);
			if(result == null)
				result = caseElementShape(enumerationShape);
			if(result == null)
				result = caseUmlShape(enumerationShape);
			if(result == null)
				result = caseTopUmlDiagramElement(enumerationShape);
			if(result == null)
				result = caseShape(enumerationShape);
			if(result == null)
				result = caseStereotypedDiagramElement(enumerationShape);
			if(result == null)
				result = caseUmlDiagramElement(enumerationShape);
			if(result == null)
				result = caseDiagramElement(enumerationShape);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.ROLE_LABEL:
		{
			RoleLabel roleLabel = (RoleLabel)theEObject;
			T result = caseRoleLabel(roleLabel);
			if(result == null)
				result = caseUmlLabel(roleLabel);
			if(result == null)
				result = caseUmlDiagramElement(roleLabel);
			if(result == null)
				result = caseShape(roleLabel);
			if(result == null)
				result = caseDiagramElement(roleLabel);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.ASSOCIATION_EDGE:
		{
			AssociationEdge associationEdge = (AssociationEdge)theEObject;
			T result = caseAssociationEdge(associationEdge);
			if(result == null)
				result = caseElementEdge(associationEdge);
			if(result == null)
				result = caseUmlEdge(associationEdge);
			if(result == null)
				result = caseTopUmlDiagramElement(associationEdge);
			if(result == null)
				result = caseEdge(associationEdge);
			if(result == null)
				result = caseStereotypedDiagramElement(associationEdge);
			if(result == null)
				result = caseUmlDiagramElement(associationEdge);
			if(result == null)
				result = caseDiagramElement(associationEdge);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.ELEMENT_EDGE:
		{
			ElementEdge elementEdge = (ElementEdge)theEObject;
			T result = caseElementEdge(elementEdge);
			if(result == null)
				result = caseUmlEdge(elementEdge);
			if(result == null)
				result = caseTopUmlDiagramElement(elementEdge);
			if(result == null)
				result = caseEdge(elementEdge);
			if(result == null)
				result = caseStereotypedDiagramElement(elementEdge);
			if(result == null)
				result = caseUmlDiagramElement(elementEdge);
			if(result == null)
				result = caseDiagramElement(elementEdge);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.MULTIPLICITY_LABEL:
		{
			MultiplicityLabel multiplicityLabel = (MultiplicityLabel)theEObject;
			T result = caseMultiplicityLabel(multiplicityLabel);
			if(result == null)
				result = caseUmlLabel(multiplicityLabel);
			if(result == null)
				result = caseUmlDiagramElement(multiplicityLabel);
			if(result == null)
				result = caseShape(multiplicityLabel);
			if(result == null)
				result = caseDiagramElement(multiplicityLabel);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.PROPERTY_EDGE:
		{
			PropertyEdge propertyEdge = (PropertyEdge)theEObject;
			T result = casePropertyEdge(propertyEdge);
			if(result == null)
				result = caseElementEdge(propertyEdge);
			if(result == null)
				result = caseUmlEdge(propertyEdge);
			if(result == null)
				result = caseTopUmlDiagramElement(propertyEdge);
			if(result == null)
				result = caseEdge(propertyEdge);
			if(result == null)
				result = caseStereotypedDiagramElement(propertyEdge);
			if(result == null)
				result = caseUmlDiagramElement(propertyEdge);
			if(result == null)
				result = caseDiagramElement(propertyEdge);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.CONSTRAINT_LABEL:
		{
			ConstraintLabel constraintLabel = (ConstraintLabel)theEObject;
			T result = caseConstraintLabel(constraintLabel);
			if(result == null)
				result = caseUmlLabel(constraintLabel);
			if(result == null)
				result = caseUmlDiagramElement(constraintLabel);
			if(result == null)
				result = caseShape(constraintLabel);
			if(result == null)
				result = caseDiagramElement(constraintLabel);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.GENERALIZATION_SET_EDGE:
		{
			GeneralizationSetEdge generalizationSetEdge = (GeneralizationSetEdge)theEObject;
			T result = caseGeneralizationSetEdge(generalizationSetEdge);
			if(result == null)
				result = caseElementEdge(generalizationSetEdge);
			if(result == null)
				result = caseUmlEdge(generalizationSetEdge);
			if(result == null)
				result = caseTopUmlDiagramElement(generalizationSetEdge);
			if(result == null)
				result = caseEdge(generalizationSetEdge);
			if(result == null)
				result = caseStereotypedDiagramElement(generalizationSetEdge);
			if(result == null)
				result = caseUmlDiagramElement(generalizationSetEdge);
			if(result == null)
				result = caseDiagramElement(generalizationSetEdge);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.POWER_LABEL:
		{
			PowerLabel powerLabel = (PowerLabel)theEObject;
			T result = casePowerLabel(powerLabel);
			if(result == null)
				result = caseUmlLabel(powerLabel);
			if(result == null)
				result = caseUmlDiagramElement(powerLabel);
			if(result == null)
				result = caseShape(powerLabel);
			if(result == null)
				result = caseDiagramElement(powerLabel);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.OBJECT_NODE_SHAPE:
		{
			ObjectNodeShape objectNodeShape = (ObjectNodeShape)theEObject;
			T result = caseObjectNodeShape(objectNodeShape);
			if(result == null)
				result = caseActivityNodeShape(objectNodeShape);
			if(result == null)
				result = caseElementShape(objectNodeShape);
			if(result == null)
				result = caseUmlShape(objectNodeShape);
			if(result == null)
				result = caseTopUmlDiagramElement(objectNodeShape);
			if(result == null)
				result = caseShape(objectNodeShape);
			if(result == null)
				result = caseStereotypedDiagramElement(objectNodeShape);
			if(result == null)
				result = caseUmlDiagramElement(objectNodeShape);
			if(result == null)
				result = caseDiagramElement(objectNodeShape);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.ACTIVITY_NODE_SHAPE:
		{
			ActivityNodeShape activityNodeShape = (ActivityNodeShape)theEObject;
			T result = caseActivityNodeShape(activityNodeShape);
			if(result == null)
				result = caseElementShape(activityNodeShape);
			if(result == null)
				result = caseUmlShape(activityNodeShape);
			if(result == null)
				result = caseTopUmlDiagramElement(activityNodeShape);
			if(result == null)
				result = caseShape(activityNodeShape);
			if(result == null)
				result = caseStereotypedDiagramElement(activityNodeShape);
			if(result == null)
				result = caseUmlDiagramElement(activityNodeShape);
			if(result == null)
				result = caseDiagramElement(activityNodeShape);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.SELECTION_LABEL:
		{
			SelectionLabel selectionLabel = (SelectionLabel)theEObject;
			T result = caseSelectionLabel(selectionLabel);
			if(result == null)
				result = caseUmlLabel(selectionLabel);
			if(result == null)
				result = caseUmlDiagramElement(selectionLabel);
			if(result == null)
				result = caseShape(selectionLabel);
			if(result == null)
				result = caseDiagramElement(selectionLabel);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.OBJECT_FLOW_EDGE:
		{
			ObjectFlowEdge objectFlowEdge = (ObjectFlowEdge)theEObject;
			T result = caseObjectFlowEdge(objectFlowEdge);
			if(result == null)
				result = caseActivityEdgeEdge(objectFlowEdge);
			if(result == null)
				result = caseElementEdge(objectFlowEdge);
			if(result == null)
				result = caseUmlEdge(objectFlowEdge);
			if(result == null)
				result = caseTopUmlDiagramElement(objectFlowEdge);
			if(result == null)
				result = caseEdge(objectFlowEdge);
			if(result == null)
				result = caseStereotypedDiagramElement(objectFlowEdge);
			if(result == null)
				result = caseUmlDiagramElement(objectFlowEdge);
			if(result == null)
				result = caseDiagramElement(objectFlowEdge);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.ACTIVITY_EDGE_EDGE:
		{
			ActivityEdgeEdge activityEdgeEdge = (ActivityEdgeEdge)theEObject;
			T result = caseActivityEdgeEdge(activityEdgeEdge);
			if(result == null)
				result = caseElementEdge(activityEdgeEdge);
			if(result == null)
				result = caseUmlEdge(activityEdgeEdge);
			if(result == null)
				result = caseTopUmlDiagramElement(activityEdgeEdge);
			if(result == null)
				result = caseEdge(activityEdgeEdge);
			if(result == null)
				result = caseStereotypedDiagramElement(activityEdgeEdge);
			if(result == null)
				result = caseUmlDiagramElement(activityEdgeEdge);
			if(result == null)
				result = caseDiagramElement(activityEdgeEdge);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.GUARD_LABEL:
		{
			GuardLabel guardLabel = (GuardLabel)theEObject;
			T result = caseGuardLabel(guardLabel);
			if(result == null)
				result = caseUmlLabel(guardLabel);
			if(result == null)
				result = caseUmlDiagramElement(guardLabel);
			if(result == null)
				result = caseShape(guardLabel);
			if(result == null)
				result = caseDiagramElement(guardLabel);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.WEIGHT_LABEL:
		{
			WeightLabel weightLabel = (WeightLabel)theEObject;
			T result = caseWeightLabel(weightLabel);
			if(result == null)
				result = caseUmlLabel(weightLabel);
			if(result == null)
				result = caseUmlDiagramElement(weightLabel);
			if(result == null)
				result = caseShape(weightLabel);
			if(result == null)
				result = caseDiagramElement(weightLabel);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.TRANSFORMATION_LABEL:
		{
			TransformationLabel transformationLabel = (TransformationLabel)theEObject;
			T result = caseTransformationLabel(transformationLabel);
			if(result == null)
				result = caseUmlLabel(transformationLabel);
			if(result == null)
				result = caseUmlDiagramElement(transformationLabel);
			if(result == null)
				result = caseShape(transformationLabel);
			if(result == null)
				result = caseDiagramElement(transformationLabel);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.LIFELINE_SHAPE:
		{
			LifelineShape lifelineShape = (LifelineShape)theEObject;
			T result = caseLifelineShape(lifelineShape);
			if(result == null)
				result = caseElementShape(lifelineShape);
			if(result == null)
				result = caseUmlShape(lifelineShape);
			if(result == null)
				result = caseTopUmlDiagramElement(lifelineShape);
			if(result == null)
				result = caseShape(lifelineShape);
			if(result == null)
				result = caseStereotypedDiagramElement(lifelineShape);
			if(result == null)
				result = caseUmlDiagramElement(lifelineShape);
			if(result == null)
				result = caseDiagramElement(lifelineShape);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.INTERACTION_FRAGMENT_SHAPE:
		{
			InteractionFragmentShape interactionFragmentShape = (InteractionFragmentShape)theEObject;
			T result = caseInteractionFragmentShape(interactionFragmentShape);
			if(result == null)
				result = caseElementShape(interactionFragmentShape);
			if(result == null)
				result = caseUmlShape(interactionFragmentShape);
			if(result == null)
				result = caseTopUmlDiagramElement(interactionFragmentShape);
			if(result == null)
				result = caseShape(interactionFragmentShape);
			if(result == null)
				result = caseStereotypedDiagramElement(interactionFragmentShape);
			if(result == null)
				result = caseUmlDiagramElement(interactionFragmentShape);
			if(result == null)
				result = caseDiagramElement(interactionFragmentShape);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.ACTION_SHAPE:
		{
			ActionShape actionShape = (ActionShape)theEObject;
			T result = caseActionShape(actionShape);
			if(result == null)
				result = caseActivityNodeShape(actionShape);
			if(result == null)
				result = caseElementShape(actionShape);
			if(result == null)
				result = caseUmlShape(actionShape);
			if(result == null)
				result = caseTopUmlDiagramElement(actionShape);
			if(result == null)
				result = caseShape(actionShape);
			if(result == null)
				result = caseStereotypedDiagramElement(actionShape);
			if(result == null)
				result = caseUmlDiagramElement(actionShape);
			if(result == null)
				result = caseDiagramElement(actionShape);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.PIN_SHAPE:
		{
			PinShape pinShape = (PinShape)theEObject;
			T result = casePinShape(pinShape);
			if(result == null)
				result = caseObjectNodeShape(pinShape);
			if(result == null)
				result = caseActivityNodeShape(pinShape);
			if(result == null)
				result = caseElementShape(pinShape);
			if(result == null)
				result = caseUmlShape(pinShape);
			if(result == null)
				result = caseTopUmlDiagramElement(pinShape);
			if(result == null)
				result = caseShape(pinShape);
			if(result == null)
				result = caseStereotypedDiagramElement(pinShape);
			if(result == null)
				result = caseUmlDiagramElement(pinShape);
			if(result == null)
				result = caseDiagramElement(pinShape);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.CONNECTOR_EDGE:
		{
			ConnectorEdge connectorEdge = (ConnectorEdge)theEObject;
			T result = caseConnectorEdge(connectorEdge);
			if(result == null)
				result = caseElementEdge(connectorEdge);
			if(result == null)
				result = caseUmlEdge(connectorEdge);
			if(result == null)
				result = caseTopUmlDiagramElement(connectorEdge);
			if(result == null)
				result = caseEdge(connectorEdge);
			if(result == null)
				result = caseStereotypedDiagramElement(connectorEdge);
			if(result == null)
				result = caseUmlDiagramElement(connectorEdge);
			if(result == null)
				result = caseDiagramElement(connectorEdge);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.INSTANCE_SPECIFICATION_EDGE:
		{
			InstanceSpecificationEdge instanceSpecificationEdge = (InstanceSpecificationEdge)theEObject;
			T result = caseInstanceSpecificationEdge(instanceSpecificationEdge);
			if(result == null)
				result = caseElementEdge(instanceSpecificationEdge);
			if(result == null)
				result = caseUmlEdge(instanceSpecificationEdge);
			if(result == null)
				result = caseTopUmlDiagramElement(instanceSpecificationEdge);
			if(result == null)
				result = caseEdge(instanceSpecificationEdge);
			if(result == null)
				result = caseStereotypedDiagramElement(instanceSpecificationEdge);
			if(result == null)
				result = caseUmlDiagramElement(instanceSpecificationEdge);
			if(result == null)
				result = caseDiagramElement(instanceSpecificationEdge);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.DEPENDENCY_EDGE:
		{
			DependencyEdge dependencyEdge = (DependencyEdge)theEObject;
			T result = caseDependencyEdge(dependencyEdge);
			if(result == null)
				result = caseElementEdge(dependencyEdge);
			if(result == null)
				result = caseUmlEdge(dependencyEdge);
			if(result == null)
				result = caseTopUmlDiagramElement(dependencyEdge);
			if(result == null)
				result = caseEdge(dependencyEdge);
			if(result == null)
				result = caseStereotypedDiagramElement(dependencyEdge);
			if(result == null)
				result = caseUmlDiagramElement(dependencyEdge);
			if(result == null)
				result = caseDiagramElement(dependencyEdge);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.INSTANCE_SPECIFICATION_SHAPE:
		{
			InstanceSpecificationShape instanceSpecificationShape = (InstanceSpecificationShape)theEObject;
			T result = caseInstanceSpecificationShape(instanceSpecificationShape);
			if(result == null)
				result = caseDeploymentTargetShape(instanceSpecificationShape);
			if(result == null)
				result = caseElementShape(instanceSpecificationShape);
			if(result == null)
				result = caseUmlShape(instanceSpecificationShape);
			if(result == null)
				result = caseTopUmlDiagramElement(instanceSpecificationShape);
			if(result == null)
				result = caseShape(instanceSpecificationShape);
			if(result == null)
				result = caseStereotypedDiagramElement(instanceSpecificationShape);
			if(result == null)
				result = caseUmlDiagramElement(instanceSpecificationShape);
			if(result == null)
				result = caseDiagramElement(instanceSpecificationShape);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.DEPLOYMENT_TARGET_SHAPE:
		{
			DeploymentTargetShape deploymentTargetShape = (DeploymentTargetShape)theEObject;
			T result = caseDeploymentTargetShape(deploymentTargetShape);
			if(result == null)
				result = caseElementShape(deploymentTargetShape);
			if(result == null)
				result = caseUmlShape(deploymentTargetShape);
			if(result == null)
				result = caseTopUmlDiagramElement(deploymentTargetShape);
			if(result == null)
				result = caseShape(deploymentTargetShape);
			if(result == null)
				result = caseStereotypedDiagramElement(deploymentTargetShape);
			if(result == null)
				result = caseUmlDiagramElement(deploymentTargetShape);
			if(result == null)
				result = caseDiagramElement(deploymentTargetShape);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.DEPLOYED_ARTIFACT_COMPARTMENT:
		{
			DeployedArtifactCompartment deployedArtifactCompartment = (DeployedArtifactCompartment)theEObject;
			T result = caseDeployedArtifactCompartment(deployedArtifactCompartment);
			if(result == null)
				result = caseClassifierCompartment(deployedArtifactCompartment);
			if(result == null)
				result = caseDiagramCompartment(deployedArtifactCompartment);
			if(result == null)
				result = caseListCompartment(deployedArtifactCompartment);
			if(result == null)
				result = caseUmlCompartment(deployedArtifactCompartment);
			if(result == null)
				result = caseUmlDiagramElement(deployedArtifactCompartment);
			if(result == null)
				result = caseShape(deployedArtifactCompartment);
			if(result == null)
				result = caseDiagramElement(deployedArtifactCompartment);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.SLOT_COMPARTMENT:
		{
			SlotCompartment slotCompartment = (SlotCompartment)theEObject;
			T result = caseSlotCompartment(slotCompartment);
			if(result == null)
				result = caseListCompartment(slotCompartment);
			if(result == null)
				result = caseUmlCompartment(slotCompartment);
			if(result == null)
				result = caseUmlDiagramElement(slotCompartment);
			if(result == null)
				result = caseShape(slotCompartment);
			if(result == null)
				result = caseDiagramElement(slotCompartment);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.CLASS_SHAPE:
		{
			ClassShape classShape = (ClassShape)theEObject;
			T result = caseClassShape(classShape);
			if(result == null)
				result = caseClassifierWithNestedClassifiersShape(classShape);
			if(result == null)
				result = caseBehavioredClassifierShape(classShape);
			if(result == null)
				result = caseElementWithPortsShape(classShape);
			if(result == null)
				result = caseClassifierWithReceptionsShape(classShape);
			if(result == null)
				result = caseElementWithStructureShape(classShape);
			if(result == null)
				result = caseClassifierWithOperationsShape(classShape);
			if(result == null)
				result = caseClassifierWithAttributesShape(classShape);
			if(result == null)
				result = caseClassifierShape(classShape);
			if(result == null)
				result = caseTemplateableElementShape(classShape);
			if(result == null)
				result = caseElementShape(classShape);
			if(result == null)
				result = caseUmlShape(classShape);
			if(result == null)
				result = caseTopUmlDiagramElement(classShape);
			if(result == null)
				result = caseShape(classShape);
			if(result == null)
				result = caseStereotypedDiagramElement(classShape);
			if(result == null)
				result = caseUmlDiagramElement(classShape);
			if(result == null)
				result = caseDiagramElement(classShape);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.ELEMENT_WITH_PORTS_SHAPE:
		{
			ElementWithPortsShape elementWithPortsShape = (ElementWithPortsShape)theEObject;
			T result = caseElementWithPortsShape(elementWithPortsShape);
			if(result == null)
				result = caseElementWithStructureShape(elementWithPortsShape);
			if(result == null)
				result = caseElementShape(elementWithPortsShape);
			if(result == null)
				result = caseUmlShape(elementWithPortsShape);
			if(result == null)
				result = caseTopUmlDiagramElement(elementWithPortsShape);
			if(result == null)
				result = caseShape(elementWithPortsShape);
			if(result == null)
				result = caseStereotypedDiagramElement(elementWithPortsShape);
			if(result == null)
				result = caseUmlDiagramElement(elementWithPortsShape);
			if(result == null)
				result = caseDiagramElement(elementWithPortsShape);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.ELEMENT_WITH_STRUCTURE_SHAPE:
		{
			ElementWithStructureShape elementWithStructureShape = (ElementWithStructureShape)theEObject;
			T result = caseElementWithStructureShape(elementWithStructureShape);
			if(result == null)
				result = caseElementShape(elementWithStructureShape);
			if(result == null)
				result = caseUmlShape(elementWithStructureShape);
			if(result == null)
				result = caseTopUmlDiagramElement(elementWithStructureShape);
			if(result == null)
				result = caseShape(elementWithStructureShape);
			if(result == null)
				result = caseStereotypedDiagramElement(elementWithStructureShape);
			if(result == null)
				result = caseUmlDiagramElement(elementWithStructureShape);
			if(result == null)
				result = caseDiagramElement(elementWithStructureShape);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.STRUCTURE_COMPARTMENT:
		{
			StructureCompartment structureCompartment = (StructureCompartment)theEObject;
			T result = caseStructureCompartment(structureCompartment);
			if(result == null)
				result = caseDiagramCompartment(structureCompartment);
			if(result == null)
				result = caseUmlCompartment(structureCompartment);
			if(result == null)
				result = caseUmlDiagramElement(structureCompartment);
			if(result == null)
				result = caseShape(structureCompartment);
			if(result == null)
				result = caseDiagramElement(structureCompartment);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.PORT_SHAPE:
		{
			PortShape portShape = (PortShape)theEObject;
			T result = casePortShape(portShape);
			if(result == null)
				result = caseElementShape(portShape);
			if(result == null)
				result = caseUmlShape(portShape);
			if(result == null)
				result = caseTopUmlDiagramElement(portShape);
			if(result == null)
				result = caseShape(portShape);
			if(result == null)
				result = caseStereotypedDiagramElement(portShape);
			if(result == null)
				result = caseUmlDiagramElement(portShape);
			if(result == null)
				result = caseDiagramElement(portShape);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.CLASSIFIER_WITH_NESTED_CLASSIFIERS_SHAPE:
		{
			ClassifierWithNestedClassifiersShape classifierWithNestedClassifiersShape = (ClassifierWithNestedClassifiersShape)theEObject;
			T result = caseClassifierWithNestedClassifiersShape(classifierWithNestedClassifiersShape);
			if(result == null)
				result = caseClassifierWithReceptionsShape(classifierWithNestedClassifiersShape);
			if(result == null)
				result = caseClassifierWithOperationsShape(classifierWithNestedClassifiersShape);
			if(result == null)
				result = caseClassifierWithAttributesShape(classifierWithNestedClassifiersShape);
			if(result == null)
				result = caseClassifierShape(classifierWithNestedClassifiersShape);
			if(result == null)
				result = caseTemplateableElementShape(classifierWithNestedClassifiersShape);
			if(result == null)
				result = caseElementShape(classifierWithNestedClassifiersShape);
			if(result == null)
				result = caseUmlShape(classifierWithNestedClassifiersShape);
			if(result == null)
				result = caseTopUmlDiagramElement(classifierWithNestedClassifiersShape);
			if(result == null)
				result = caseShape(classifierWithNestedClassifiersShape);
			if(result == null)
				result = caseStereotypedDiagramElement(classifierWithNestedClassifiersShape);
			if(result == null)
				result = caseUmlDiagramElement(classifierWithNestedClassifiersShape);
			if(result == null)
				result = caseDiagramElement(classifierWithNestedClassifiersShape);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.NESTED_CLASSIFIER_COMPARTMENT:
		{
			NestedClassifierCompartment nestedClassifierCompartment = (NestedClassifierCompartment)theEObject;
			T result = caseNestedClassifierCompartment(nestedClassifierCompartment);
			if(result == null)
				result = caseClassifierCompartment(nestedClassifierCompartment);
			if(result == null)
				result = caseDiagramCompartment(nestedClassifierCompartment);
			if(result == null)
				result = caseListCompartment(nestedClassifierCompartment);
			if(result == null)
				result = caseUmlCompartment(nestedClassifierCompartment);
			if(result == null)
				result = caseUmlDiagramElement(nestedClassifierCompartment);
			if(result == null)
				result = caseShape(nestedClassifierCompartment);
			if(result == null)
				result = caseDiagramElement(nestedClassifierCompartment);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.BEHAVIORED_CLASSIFIER_SHAPE:
		{
			BehavioredClassifierShape behavioredClassifierShape = (BehavioredClassifierShape)theEObject;
			T result = caseBehavioredClassifierShape(behavioredClassifierShape);
			if(result == null)
				result = caseClassifierShape(behavioredClassifierShape);
			if(result == null)
				result = caseTemplateableElementShape(behavioredClassifierShape);
			if(result == null)
				result = caseElementShape(behavioredClassifierShape);
			if(result == null)
				result = caseUmlShape(behavioredClassifierShape);
			if(result == null)
				result = caseTopUmlDiagramElement(behavioredClassifierShape);
			if(result == null)
				result = caseShape(behavioredClassifierShape);
			if(result == null)
				result = caseStereotypedDiagramElement(behavioredClassifierShape);
			if(result == null)
				result = caseUmlDiagramElement(behavioredClassifierShape);
			if(result == null)
				result = caseDiagramElement(behavioredClassifierShape);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.OWNED_BEHAVIOR_COMPARTMENT:
		{
			OwnedBehaviorCompartment ownedBehaviorCompartment = (OwnedBehaviorCompartment)theEObject;
			T result = caseOwnedBehaviorCompartment(ownedBehaviorCompartment);
			if(result == null)
				result = caseClassifierCompartment(ownedBehaviorCompartment);
			if(result == null)
				result = caseDiagramCompartment(ownedBehaviorCompartment);
			if(result == null)
				result = caseListCompartment(ownedBehaviorCompartment);
			if(result == null)
				result = caseUmlCompartment(ownedBehaviorCompartment);
			if(result == null)
				result = caseUmlDiagramElement(ownedBehaviorCompartment);
			if(result == null)
				result = caseShape(ownedBehaviorCompartment);
			if(result == null)
				result = caseDiagramElement(ownedBehaviorCompartment);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.INTERFACE_SHAPE:
		{
			InterfaceShape interfaceShape = (InterfaceShape)theEObject;
			T result = caseInterfaceShape(interfaceShape);
			if(result == null)
				result = caseClassifierWithNestedClassifiersShape(interfaceShape);
			if(result == null)
				result = caseClassifierWithReceptionsShape(interfaceShape);
			if(result == null)
				result = caseClassifierWithOperationsShape(interfaceShape);
			if(result == null)
				result = caseClassifierWithAttributesShape(interfaceShape);
			if(result == null)
				result = caseClassifierShape(interfaceShape);
			if(result == null)
				result = caseTemplateableElementShape(interfaceShape);
			if(result == null)
				result = caseElementShape(interfaceShape);
			if(result == null)
				result = caseUmlShape(interfaceShape);
			if(result == null)
				result = caseTopUmlDiagramElement(interfaceShape);
			if(result == null)
				result = caseShape(interfaceShape);
			if(result == null)
				result = caseStereotypedDiagramElement(interfaceShape);
			if(result == null)
				result = caseUmlDiagramElement(interfaceShape);
			if(result == null)
				result = caseDiagramElement(interfaceShape);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.DATA_TYPE_SHAPE:
		{
			DataTypeShape dataTypeShape = (DataTypeShape)theEObject;
			T result = caseDataTypeShape(dataTypeShape);
			if(result == null)
				result = caseClassifierWithOperationsShape(dataTypeShape);
			if(result == null)
				result = caseClassifierWithAttributesShape(dataTypeShape);
			if(result == null)
				result = caseClassifierShape(dataTypeShape);
			if(result == null)
				result = caseTemplateableElementShape(dataTypeShape);
			if(result == null)
				result = caseElementShape(dataTypeShape);
			if(result == null)
				result = caseUmlShape(dataTypeShape);
			if(result == null)
				result = caseTopUmlDiagramElement(dataTypeShape);
			if(result == null)
				result = caseShape(dataTypeShape);
			if(result == null)
				result = caseStereotypedDiagramElement(dataTypeShape);
			if(result == null)
				result = caseUmlDiagramElement(dataTypeShape);
			if(result == null)
				result = caseDiagramElement(dataTypeShape);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.PRIMITIVE_TYPE_SHAPE:
		{
			PrimitiveTypeShape primitiveTypeShape = (PrimitiveTypeShape)theEObject;
			T result = casePrimitiveTypeShape(primitiveTypeShape);
			if(result == null)
				result = caseDataTypeShape(primitiveTypeShape);
			if(result == null)
				result = caseClassifierWithOperationsShape(primitiveTypeShape);
			if(result == null)
				result = caseClassifierWithAttributesShape(primitiveTypeShape);
			if(result == null)
				result = caseClassifierShape(primitiveTypeShape);
			if(result == null)
				result = caseTemplateableElementShape(primitiveTypeShape);
			if(result == null)
				result = caseElementShape(primitiveTypeShape);
			if(result == null)
				result = caseUmlShape(primitiveTypeShape);
			if(result == null)
				result = caseTopUmlDiagramElement(primitiveTypeShape);
			if(result == null)
				result = caseShape(primitiveTypeShape);
			if(result == null)
				result = caseStereotypedDiagramElement(primitiveTypeShape);
			if(result == null)
				result = caseUmlDiagramElement(primitiveTypeShape);
			if(result == null)
				result = caseDiagramElement(primitiveTypeShape);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.SIGNAL_SHAPE:
		{
			SignalShape signalShape = (SignalShape)theEObject;
			T result = caseSignalShape(signalShape);
			if(result == null)
				result = caseClassifierWithAttributesShape(signalShape);
			if(result == null)
				result = caseClassifierShape(signalShape);
			if(result == null)
				result = caseTemplateableElementShape(signalShape);
			if(result == null)
				result = caseElementShape(signalShape);
			if(result == null)
				result = caseUmlShape(signalShape);
			if(result == null)
				result = caseTopUmlDiagramElement(signalShape);
			if(result == null)
				result = caseShape(signalShape);
			if(result == null)
				result = caseStereotypedDiagramElement(signalShape);
			if(result == null)
				result = caseUmlDiagramElement(signalShape);
			if(result == null)
				result = caseDiagramElement(signalShape);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.MODEL_SHAPE:
		{
			ModelShape modelShape = (ModelShape)theEObject;
			T result = caseModelShape(modelShape);
			if(result == null)
				result = casePackageShape(modelShape);
			if(result == null)
				result = caseElementWithPackagedElementsShape(modelShape);
			if(result == null)
				result = caseTemplateableElementShape(modelShape);
			if(result == null)
				result = caseElementShape(modelShape);
			if(result == null)
				result = caseUmlShape(modelShape);
			if(result == null)
				result = caseTopUmlDiagramElement(modelShape);
			if(result == null)
				result = caseShape(modelShape);
			if(result == null)
				result = caseStereotypedDiagramElement(modelShape);
			if(result == null)
				result = caseUmlDiagramElement(modelShape);
			if(result == null)
				result = caseDiagramElement(modelShape);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.CONTAINMENT_EDGE:
		{
			ContainmentEdge containmentEdge = (ContainmentEdge)theEObject;
			T result = caseContainmentEdge(containmentEdge);
			if(result == null)
				result = caseUmlEdge(containmentEdge);
			if(result == null)
				result = caseTopUmlDiagramElement(containmentEdge);
			if(result == null)
				result = caseEdge(containmentEdge);
			if(result == null)
				result = caseStereotypedDiagramElement(containmentEdge);
			if(result == null)
				result = caseUmlDiagramElement(containmentEdge);
			if(result == null)
				result = caseDiagramElement(containmentEdge);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.GENERALIZATION_EDGE:
		{
			GeneralizationEdge generalizationEdge = (GeneralizationEdge)theEObject;
			T result = caseGeneralizationEdge(generalizationEdge);
			if(result == null)
				result = caseElementEdge(generalizationEdge);
			if(result == null)
				result = caseUmlEdge(generalizationEdge);
			if(result == null)
				result = caseTopUmlDiagramElement(generalizationEdge);
			if(result == null)
				result = caseEdge(generalizationEdge);
			if(result == null)
				result = caseStereotypedDiagramElement(generalizationEdge);
			if(result == null)
				result = caseUmlDiagramElement(generalizationEdge);
			if(result == null)
				result = caseDiagramElement(generalizationEdge);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.REALIZATION_EDGE:
		{
			RealizationEdge realizationEdge = (RealizationEdge)theEObject;
			T result = caseRealizationEdge(realizationEdge);
			if(result == null)
				result = caseAbstractionEdge(realizationEdge);
			if(result == null)
				result = caseDependencyEdge(realizationEdge);
			if(result == null)
				result = caseElementEdge(realizationEdge);
			if(result == null)
				result = caseUmlEdge(realizationEdge);
			if(result == null)
				result = caseTopUmlDiagramElement(realizationEdge);
			if(result == null)
				result = caseEdge(realizationEdge);
			if(result == null)
				result = caseStereotypedDiagramElement(realizationEdge);
			if(result == null)
				result = caseUmlDiagramElement(realizationEdge);
			if(result == null)
				result = caseDiagramElement(realizationEdge);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.ABSTRACTION_EDGE:
		{
			AbstractionEdge abstractionEdge = (AbstractionEdge)theEObject;
			T result = caseAbstractionEdge(abstractionEdge);
			if(result == null)
				result = caseDependencyEdge(abstractionEdge);
			if(result == null)
				result = caseElementEdge(abstractionEdge);
			if(result == null)
				result = caseUmlEdge(abstractionEdge);
			if(result == null)
				result = caseTopUmlDiagramElement(abstractionEdge);
			if(result == null)
				result = caseEdge(abstractionEdge);
			if(result == null)
				result = caseStereotypedDiagramElement(abstractionEdge);
			if(result == null)
				result = caseUmlDiagramElement(abstractionEdge);
			if(result == null)
				result = caseDiagramElement(abstractionEdge);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.INTERFACE_REALIZATION_EDGE:
		{
			InterfaceRealizationEdge interfaceRealizationEdge = (InterfaceRealizationEdge)theEObject;
			T result = caseInterfaceRealizationEdge(interfaceRealizationEdge);
			if(result == null)
				result = caseRealizationEdge(interfaceRealizationEdge);
			if(result == null)
				result = caseAbstractionEdge(interfaceRealizationEdge);
			if(result == null)
				result = caseDependencyEdge(interfaceRealizationEdge);
			if(result == null)
				result = caseElementEdge(interfaceRealizationEdge);
			if(result == null)
				result = caseUmlEdge(interfaceRealizationEdge);
			if(result == null)
				result = caseTopUmlDiagramElement(interfaceRealizationEdge);
			if(result == null)
				result = caseEdge(interfaceRealizationEdge);
			if(result == null)
				result = caseStereotypedDiagramElement(interfaceRealizationEdge);
			if(result == null)
				result = caseUmlDiagramElement(interfaceRealizationEdge);
			if(result == null)
				result = caseDiagramElement(interfaceRealizationEdge);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.USAGE_EDGE:
		{
			UsageEdge usageEdge = (UsageEdge)theEObject;
			T result = caseUsageEdge(usageEdge);
			if(result == null)
				result = caseDependencyEdge(usageEdge);
			if(result == null)
				result = caseElementEdge(usageEdge);
			if(result == null)
				result = caseUmlEdge(usageEdge);
			if(result == null)
				result = caseTopUmlDiagramElement(usageEdge);
			if(result == null)
				result = caseEdge(usageEdge);
			if(result == null)
				result = caseStereotypedDiagramElement(usageEdge);
			if(result == null)
				result = caseUmlDiagramElement(usageEdge);
			if(result == null)
				result = caseDiagramElement(usageEdge);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.ELEMENT_IMPORT_EDGE:
		{
			ElementImportEdge elementImportEdge = (ElementImportEdge)theEObject;
			T result = caseElementImportEdge(elementImportEdge);
			if(result == null)
				result = caseElementEdge(elementImportEdge);
			if(result == null)
				result = caseUmlEdge(elementImportEdge);
			if(result == null)
				result = caseTopUmlDiagramElement(elementImportEdge);
			if(result == null)
				result = caseEdge(elementImportEdge);
			if(result == null)
				result = caseStereotypedDiagramElement(elementImportEdge);
			if(result == null)
				result = caseUmlDiagramElement(elementImportEdge);
			if(result == null)
				result = caseDiagramElement(elementImportEdge);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.PACKAGE_IMPORT_EDGE:
		{
			PackageImportEdge packageImportEdge = (PackageImportEdge)theEObject;
			T result = casePackageImportEdge(packageImportEdge);
			if(result == null)
				result = caseElementEdge(packageImportEdge);
			if(result == null)
				result = caseUmlEdge(packageImportEdge);
			if(result == null)
				result = caseTopUmlDiagramElement(packageImportEdge);
			if(result == null)
				result = caseEdge(packageImportEdge);
			if(result == null)
				result = caseStereotypedDiagramElement(packageImportEdge);
			if(result == null)
				result = caseUmlDiagramElement(packageImportEdge);
			if(result == null)
				result = caseDiagramElement(packageImportEdge);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.PACKAGE_MERGE_EDGE:
		{
			PackageMergeEdge packageMergeEdge = (PackageMergeEdge)theEObject;
			T result = casePackageMergeEdge(packageMergeEdge);
			if(result == null)
				result = caseElementEdge(packageMergeEdge);
			if(result == null)
				result = caseUmlEdge(packageMergeEdge);
			if(result == null)
				result = caseTopUmlDiagramElement(packageMergeEdge);
			if(result == null)
				result = caseEdge(packageMergeEdge);
			if(result == null)
				result = caseStereotypedDiagramElement(packageMergeEdge);
			if(result == null)
				result = caseUmlDiagramElement(packageMergeEdge);
			if(result == null)
				result = caseDiagramElement(packageMergeEdge);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.SUBSTITUTION_EDGE:
		{
			SubstitutionEdge substitutionEdge = (SubstitutionEdge)theEObject;
			T result = caseSubstitutionEdge(substitutionEdge);
			if(result == null)
				result = caseRealizationEdge(substitutionEdge);
			if(result == null)
				result = caseAbstractionEdge(substitutionEdge);
			if(result == null)
				result = caseDependencyEdge(substitutionEdge);
			if(result == null)
				result = caseElementEdge(substitutionEdge);
			if(result == null)
				result = caseUmlEdge(substitutionEdge);
			if(result == null)
				result = caseTopUmlDiagramElement(substitutionEdge);
			if(result == null)
				result = caseEdge(substitutionEdge);
			if(result == null)
				result = caseStereotypedDiagramElement(substitutionEdge);
			if(result == null)
				result = caseUmlDiagramElement(substitutionEdge);
			if(result == null)
				result = caseDiagramElement(substitutionEdge);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.INFORMATION_FLOW_EDGE:
		{
			InformationFlowEdge informationFlowEdge = (InformationFlowEdge)theEObject;
			T result = caseInformationFlowEdge(informationFlowEdge);
			if(result == null)
				result = caseElementEdge(informationFlowEdge);
			if(result == null)
				result = caseUmlEdge(informationFlowEdge);
			if(result == null)
				result = caseTopUmlDiagramElement(informationFlowEdge);
			if(result == null)
				result = caseEdge(informationFlowEdge);
			if(result == null)
				result = caseStereotypedDiagramElement(informationFlowEdge);
			if(result == null)
				result = caseUmlDiagramElement(informationFlowEdge);
			if(result == null)
				result = caseDiagramElement(informationFlowEdge);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.CONVEYED_LABEL:
		{
			ConveyedLabel conveyedLabel = (ConveyedLabel)theEObject;
			T result = caseConveyedLabel(conveyedLabel);
			if(result == null)
				result = caseUmlLabel(conveyedLabel);
			if(result == null)
				result = caseUmlDiagramElement(conveyedLabel);
			if(result == null)
				result = caseShape(conveyedLabel);
			if(result == null)
				result = caseDiagramElement(conveyedLabel);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.ASSOCIATION_CLASS_EDGE:
		{
			AssociationClassEdge associationClassEdge = (AssociationClassEdge)theEObject;
			T result = caseAssociationClassEdge(associationClassEdge);
			if(result == null)
				result = caseAssociationEdge(associationClassEdge);
			if(result == null)
				result = caseElementEdge(associationClassEdge);
			if(result == null)
				result = caseUmlEdge(associationClassEdge);
			if(result == null)
				result = caseTopUmlDiagramElement(associationClassEdge);
			if(result == null)
				result = caseEdge(associationClassEdge);
			if(result == null)
				result = caseStereotypedDiagramElement(associationClassEdge);
			if(result == null)
				result = caseUmlDiagramElement(associationClassEdge);
			if(result == null)
				result = caseDiagramElement(associationClassEdge);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.COMMENT_SHAPE:
		{
			CommentShape commentShape = (CommentShape)theEObject;
			T result = caseCommentShape(commentShape);
			if(result == null)
				result = caseElementShape(commentShape);
			if(result == null)
				result = caseUmlShape(commentShape);
			if(result == null)
				result = caseTopUmlDiagramElement(commentShape);
			if(result == null)
				result = caseShape(commentShape);
			if(result == null)
				result = caseStereotypedDiagramElement(commentShape);
			if(result == null)
				result = caseUmlDiagramElement(commentShape);
			if(result == null)
				result = caseDiagramElement(commentShape);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.ATTACHMENT_EDGE:
		{
			AttachmentEdge attachmentEdge = (AttachmentEdge)theEObject;
			T result = caseAttachmentEdge(attachmentEdge);
			if(result == null)
				result = caseUmlEdge(attachmentEdge);
			if(result == null)
				result = caseTopUmlDiagramElement(attachmentEdge);
			if(result == null)
				result = caseEdge(attachmentEdge);
			if(result == null)
				result = caseStereotypedDiagramElement(attachmentEdge);
			if(result == null)
				result = caseUmlDiagramElement(attachmentEdge);
			if(result == null)
				result = caseDiagramElement(attachmentEdge);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.ASSOCIATION_CLASS_SHAPE:
		{
			AssociationClassShape associationClassShape = (AssociationClassShape)theEObject;
			T result = caseAssociationClassShape(associationClassShape);
			if(result == null)
				result = caseClassShape(associationClassShape);
			if(result == null)
				result = caseClassifierWithNestedClassifiersShape(associationClassShape);
			if(result == null)
				result = caseBehavioredClassifierShape(associationClassShape);
			if(result == null)
				result = caseElementWithPortsShape(associationClassShape);
			if(result == null)
				result = caseClassifierWithReceptionsShape(associationClassShape);
			if(result == null)
				result = caseElementWithStructureShape(associationClassShape);
			if(result == null)
				result = caseClassifierWithOperationsShape(associationClassShape);
			if(result == null)
				result = caseClassifierWithAttributesShape(associationClassShape);
			if(result == null)
				result = caseClassifierShape(associationClassShape);
			if(result == null)
				result = caseTemplateableElementShape(associationClassShape);
			if(result == null)
				result = caseElementShape(associationClassShape);
			if(result == null)
				result = caseUmlShape(associationClassShape);
			if(result == null)
				result = caseTopUmlDiagramElement(associationClassShape);
			if(result == null)
				result = caseShape(associationClassShape);
			if(result == null)
				result = caseStereotypedDiagramElement(associationClassShape);
			if(result == null)
				result = caseUmlDiagramElement(associationClassShape);
			if(result == null)
				result = caseDiagramElement(associationClassShape);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.COMPONENT_SHAPE:
		{
			ComponentShape componentShape = (ComponentShape)theEObject;
			T result = caseComponentShape(componentShape);
			if(result == null)
				result = caseClassShape(componentShape);
			if(result == null)
				result = caseElementWithPackagedElementsShape(componentShape);
			if(result == null)
				result = caseClassifierWithNestedClassifiersShape(componentShape);
			if(result == null)
				result = caseBehavioredClassifierShape(componentShape);
			if(result == null)
				result = caseElementWithPortsShape(componentShape);
			if(result == null)
				result = caseClassifierWithReceptionsShape(componentShape);
			if(result == null)
				result = caseElementWithStructureShape(componentShape);
			if(result == null)
				result = caseClassifierWithOperationsShape(componentShape);
			if(result == null)
				result = caseClassifierWithAttributesShape(componentShape);
			if(result == null)
				result = caseClassifierShape(componentShape);
			if(result == null)
				result = caseTemplateableElementShape(componentShape);
			if(result == null)
				result = caseElementShape(componentShape);
			if(result == null)
				result = caseUmlShape(componentShape);
			if(result == null)
				result = caseTopUmlDiagramElement(componentShape);
			if(result == null)
				result = caseShape(componentShape);
			if(result == null)
				result = caseStereotypedDiagramElement(componentShape);
			if(result == null)
				result = caseUmlDiagramElement(componentShape);
			if(result == null)
				result = caseDiagramElement(componentShape);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.INFORMATION_ITEM_SHAPE:
		{
			InformationItemShape informationItemShape = (InformationItemShape)theEObject;
			T result = caseInformationItemShape(informationItemShape);
			if(result == null)
				result = caseClassifierShape(informationItemShape);
			if(result == null)
				result = caseTemplateableElementShape(informationItemShape);
			if(result == null)
				result = caseElementShape(informationItemShape);
			if(result == null)
				result = caseUmlShape(informationItemShape);
			if(result == null)
				result = caseTopUmlDiagramElement(informationItemShape);
			if(result == null)
				result = caseShape(informationItemShape);
			if(result == null)
				result = caseStereotypedDiagramElement(informationItemShape);
			if(result == null)
				result = caseUmlDiagramElement(informationItemShape);
			if(result == null)
				result = caseDiagramElement(informationItemShape);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.REPRESENTATION_EDGE:
		{
			RepresentationEdge representationEdge = (RepresentationEdge)theEObject;
			T result = caseRepresentationEdge(representationEdge);
			if(result == null)
				result = caseUmlEdge(representationEdge);
			if(result == null)
				result = caseTopUmlDiagramElement(representationEdge);
			if(result == null)
				result = caseEdge(representationEdge);
			if(result == null)
				result = caseStereotypedDiagramElement(representationEdge);
			if(result == null)
				result = caseUmlDiagramElement(representationEdge);
			if(result == null)
				result = caseDiagramElement(representationEdge);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.ASSOCIATION_SHAPE:
		{
			AssociationShape associationShape = (AssociationShape)theEObject;
			T result = caseAssociationShape(associationShape);
			if(result == null)
				result = caseClassifierShape(associationShape);
			if(result == null)
				result = caseTemplateableElementShape(associationShape);
			if(result == null)
				result = caseElementShape(associationShape);
			if(result == null)
				result = caseUmlShape(associationShape);
			if(result == null)
				result = caseTopUmlDiagramElement(associationShape);
			if(result == null)
				result = caseShape(associationShape);
			if(result == null)
				result = caseStereotypedDiagramElement(associationShape);
			if(result == null)
				result = caseUmlDiagramElement(associationShape);
			if(result == null)
				result = caseDiagramElement(associationShape);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.DEPENDENCY_SHAPE:
		{
			DependencyShape dependencyShape = (DependencyShape)theEObject;
			T result = caseDependencyShape(dependencyShape);
			if(result == null)
				result = caseElementShape(dependencyShape);
			if(result == null)
				result = caseUmlShape(dependencyShape);
			if(result == null)
				result = caseTopUmlDiagramElement(dependencyShape);
			if(result == null)
				result = caseShape(dependencyShape);
			if(result == null)
				result = caseStereotypedDiagramElement(dependencyShape);
			if(result == null)
				result = caseUmlDiagramElement(dependencyShape);
			if(result == null)
				result = caseDiagramElement(dependencyShape);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.TIME_OBSERVATION_SHAPE:
		{
			TimeObservationShape timeObservationShape = (TimeObservationShape)theEObject;
			T result = caseTimeObservationShape(timeObservationShape);
			if(result == null)
				result = caseElementShape(timeObservationShape);
			if(result == null)
				result = caseUmlShape(timeObservationShape);
			if(result == null)
				result = caseTopUmlDiagramElement(timeObservationShape);
			if(result == null)
				result = caseShape(timeObservationShape);
			if(result == null)
				result = caseStereotypedDiagramElement(timeObservationShape);
			if(result == null)
				result = caseUmlDiagramElement(timeObservationShape);
			if(result == null)
				result = caseDiagramElement(timeObservationShape);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.TIME_OBSERVATION_SHAPE_TIME_OBSERVATION_SHAPE:
		{
			TimeObservationShape_TimeObservationShape timeObservationShape_TimeObservationShape = (TimeObservationShape_TimeObservationShape)theEObject;
			T result = caseTimeObservationShape_TimeObservationShape(timeObservationShape_TimeObservationShape);
			if(result == null)
				result = caseElementShape(timeObservationShape_TimeObservationShape);
			if(result == null)
				result = caseUmlShape(timeObservationShape_TimeObservationShape);
			if(result == null)
				result = caseTopUmlDiagramElement(timeObservationShape_TimeObservationShape);
			if(result == null)
				result = caseShape(timeObservationShape_TimeObservationShape);
			if(result == null)
				result = caseStereotypedDiagramElement(timeObservationShape_TimeObservationShape);
			if(result == null)
				result = caseUmlDiagramElement(timeObservationShape_TimeObservationShape);
			if(result == null)
				result = caseDiagramElement(timeObservationShape_TimeObservationShape);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.DURATION_OBSERVATION_SHAPE:
		{
			DurationObservationShape durationObservationShape = (DurationObservationShape)theEObject;
			T result = caseDurationObservationShape(durationObservationShape);
			if(result == null)
				result = caseElementShape(durationObservationShape);
			if(result == null)
				result = caseUmlShape(durationObservationShape);
			if(result == null)
				result = caseTopUmlDiagramElement(durationObservationShape);
			if(result == null)
				result = caseShape(durationObservationShape);
			if(result == null)
				result = caseStereotypedDiagramElement(durationObservationShape);
			if(result == null)
				result = caseUmlDiagramElement(durationObservationShape);
			if(result == null)
				result = caseDiagramElement(durationObservationShape);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.PACKAGE_DIAGRAM:
		{
			PackageDiagram packageDiagram = (PackageDiagram)theEObject;
			T result = casePackageDiagram(packageDiagram);
			if(result == null)
				result = caseStructureDiagram(packageDiagram);
			if(result == null)
				result = caseUmlDiagram(packageDiagram);
			if(result == null)
				result = caseUmlDiagramElement(packageDiagram);
			if(result == null)
				result = caseDiagram(packageDiagram);
			if(result == null)
				result = caseShape(packageDiagram);
			if(result == null)
				result = caseDiagramElement(packageDiagram);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.PROFILE_DIAGRAM:
		{
			ProfileDiagram profileDiagram = (ProfileDiagram)theEObject;
			T result = caseProfileDiagram(profileDiagram);
			if(result == null)
				result = caseStructureDiagram(profileDiagram);
			if(result == null)
				result = caseUmlDiagram(profileDiagram);
			if(result == null)
				result = caseUmlDiagramElement(profileDiagram);
			if(result == null)
				result = caseDiagram(profileDiagram);
			if(result == null)
				result = caseShape(profileDiagram);
			if(result == null)
				result = caseDiagramElement(profileDiagram);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.COMPOSITE_STRUCTURE_DIAGRAM:
		{
			CompositeStructureDiagram compositeStructureDiagram = (CompositeStructureDiagram)theEObject;
			T result = caseCompositeStructureDiagram(compositeStructureDiagram);
			if(result == null)
				result = caseStructureDiagram(compositeStructureDiagram);
			if(result == null)
				result = caseUmlDiagram(compositeStructureDiagram);
			if(result == null)
				result = caseUmlDiagramElement(compositeStructureDiagram);
			if(result == null)
				result = caseDiagram(compositeStructureDiagram);
			if(result == null)
				result = caseShape(compositeStructureDiagram);
			if(result == null)
				result = caseDiagramElement(compositeStructureDiagram);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.DEPLOYMENT_DIAGRAM:
		{
			DeploymentDiagram deploymentDiagram = (DeploymentDiagram)theEObject;
			T result = caseDeploymentDiagram(deploymentDiagram);
			if(result == null)
				result = caseStructureDiagram(deploymentDiagram);
			if(result == null)
				result = caseUmlDiagram(deploymentDiagram);
			if(result == null)
				result = caseUmlDiagramElement(deploymentDiagram);
			if(result == null)
				result = caseDiagram(deploymentDiagram);
			if(result == null)
				result = caseShape(deploymentDiagram);
			if(result == null)
				result = caseDiagramElement(deploymentDiagram);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.COMPONENT_DIAGRAM:
		{
			ComponentDiagram componentDiagram = (ComponentDiagram)theEObject;
			T result = caseComponentDiagram(componentDiagram);
			if(result == null)
				result = caseStructureDiagram(componentDiagram);
			if(result == null)
				result = caseUmlDiagram(componentDiagram);
			if(result == null)
				result = caseUmlDiagramElement(componentDiagram);
			if(result == null)
				result = caseDiagram(componentDiagram);
			if(result == null)
				result = caseShape(componentDiagram);
			if(result == null)
				result = caseDiagramElement(componentDiagram);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.OBJECT_DIAGRAM:
		{
			ObjectDiagram objectDiagram = (ObjectDiagram)theEObject;
			T result = caseObjectDiagram(objectDiagram);
			if(result == null)
				result = caseStructureDiagram(objectDiagram);
			if(result == null)
				result = caseUmlDiagram(objectDiagram);
			if(result == null)
				result = caseUmlDiagramElement(objectDiagram);
			if(result == null)
				result = caseDiagram(objectDiagram);
			if(result == null)
				result = caseShape(objectDiagram);
			if(result == null)
				result = caseDiagramElement(objectDiagram);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.PROFILE_SHAPE:
		{
			ProfileShape profileShape = (ProfileShape)theEObject;
			T result = caseProfileShape(profileShape);
			if(result == null)
				result = casePackageShape(profileShape);
			if(result == null)
				result = caseElementWithPackagedElementsShape(profileShape);
			if(result == null)
				result = caseTemplateableElementShape(profileShape);
			if(result == null)
				result = caseElementShape(profileShape);
			if(result == null)
				result = caseUmlShape(profileShape);
			if(result == null)
				result = caseTopUmlDiagramElement(profileShape);
			if(result == null)
				result = caseShape(profileShape);
			if(result == null)
				result = caseStereotypedDiagramElement(profileShape);
			if(result == null)
				result = caseUmlDiagramElement(profileShape);
			if(result == null)
				result = caseDiagramElement(profileShape);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.PROFILE_APPLICATION_EDGE:
		{
			ProfileApplicationEdge profileApplicationEdge = (ProfileApplicationEdge)theEObject;
			T result = caseProfileApplicationEdge(profileApplicationEdge);
			if(result == null)
				result = caseElementEdge(profileApplicationEdge);
			if(result == null)
				result = caseUmlEdge(profileApplicationEdge);
			if(result == null)
				result = caseTopUmlDiagramElement(profileApplicationEdge);
			if(result == null)
				result = caseEdge(profileApplicationEdge);
			if(result == null)
				result = caseStereotypedDiagramElement(profileApplicationEdge);
			if(result == null)
				result = caseUmlDiagramElement(profileApplicationEdge);
			if(result == null)
				result = caseDiagramElement(profileApplicationEdge);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.EXTENSION_EDGE:
		{
			ExtensionEdge extensionEdge = (ExtensionEdge)theEObject;
			T result = caseExtensionEdge(extensionEdge);
			if(result == null)
				result = caseAssociationEdge(extensionEdge);
			if(result == null)
				result = caseElementEdge(extensionEdge);
			if(result == null)
				result = caseUmlEdge(extensionEdge);
			if(result == null)
				result = caseTopUmlDiagramElement(extensionEdge);
			if(result == null)
				result = caseEdge(extensionEdge);
			if(result == null)
				result = caseStereotypedDiagramElement(extensionEdge);
			if(result == null)
				result = caseUmlDiagramElement(extensionEdge);
			if(result == null)
				result = caseDiagramElement(extensionEdge);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.BEHAVIOR_DIAGRAM:
		{
			BehaviorDiagram behaviorDiagram = (BehaviorDiagram)theEObject;
			T result = caseBehaviorDiagram(behaviorDiagram);
			if(result == null)
				result = caseUmlDiagram(behaviorDiagram);
			if(result == null)
				result = caseUmlDiagramElement(behaviorDiagram);
			if(result == null)
				result = caseDiagram(behaviorDiagram);
			if(result == null)
				result = caseShape(behaviorDiagram);
			if(result == null)
				result = caseDiagramElement(behaviorDiagram);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.USE_CASE_DIAGRAM:
		{
			UseCaseDiagram useCaseDiagram = (UseCaseDiagram)theEObject;
			T result = caseUseCaseDiagram(useCaseDiagram);
			if(result == null)
				result = caseBehaviorDiagram(useCaseDiagram);
			if(result == null)
				result = caseUmlDiagram(useCaseDiagram);
			if(result == null)
				result = caseUmlDiagramElement(useCaseDiagram);
			if(result == null)
				result = caseDiagram(useCaseDiagram);
			if(result == null)
				result = caseShape(useCaseDiagram);
			if(result == null)
				result = caseDiagramElement(useCaseDiagram);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.ARTIFACT_SHAPE:
		{
			ArtifactShape artifactShape = (ArtifactShape)theEObject;
			T result = caseArtifactShape(artifactShape);
			if(result == null)
				result = caseClassifierWithOperationsShape(artifactShape);
			if(result == null)
				result = caseClassifierWithAttributesShape(artifactShape);
			if(result == null)
				result = caseClassifierShape(artifactShape);
			if(result == null)
				result = caseTemplateableElementShape(artifactShape);
			if(result == null)
				result = caseElementShape(artifactShape);
			if(result == null)
				result = caseUmlShape(artifactShape);
			if(result == null)
				result = caseTopUmlDiagramElement(artifactShape);
			if(result == null)
				result = caseShape(artifactShape);
			if(result == null)
				result = caseStereotypedDiagramElement(artifactShape);
			if(result == null)
				result = caseUmlDiagramElement(artifactShape);
			if(result == null)
				result = caseDiagramElement(artifactShape);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.NESTED_ARTIFACT_COMPARTMENT:
		{
			NestedArtifactCompartment nestedArtifactCompartment = (NestedArtifactCompartment)theEObject;
			T result = caseNestedArtifactCompartment(nestedArtifactCompartment);
			if(result == null)
				result = caseClassifierCompartment(nestedArtifactCompartment);
			if(result == null)
				result = caseDiagramCompartment(nestedArtifactCompartment);
			if(result == null)
				result = caseListCompartment(nestedArtifactCompartment);
			if(result == null)
				result = caseUmlCompartment(nestedArtifactCompartment);
			if(result == null)
				result = caseUmlDiagramElement(nestedArtifactCompartment);
			if(result == null)
				result = caseShape(nestedArtifactCompartment);
			if(result == null)
				result = caseDiagramElement(nestedArtifactCompartment);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.COMPONENT_REALIZATION_EDGE:
		{
			ComponentRealizationEdge componentRealizationEdge = (ComponentRealizationEdge)theEObject;
			T result = caseComponentRealizationEdge(componentRealizationEdge);
			if(result == null)
				result = caseRealizationEdge(componentRealizationEdge);
			if(result == null)
				result = caseAbstractionEdge(componentRealizationEdge);
			if(result == null)
				result = caseDependencyEdge(componentRealizationEdge);
			if(result == null)
				result = caseElementEdge(componentRealizationEdge);
			if(result == null)
				result = caseUmlEdge(componentRealizationEdge);
			if(result == null)
				result = caseTopUmlDiagramElement(componentRealizationEdge);
			if(result == null)
				result = caseEdge(componentRealizationEdge);
			if(result == null)
				result = caseStereotypedDiagramElement(componentRealizationEdge);
			if(result == null)
				result = caseUmlDiagramElement(componentRealizationEdge);
			if(result == null)
				result = caseDiagramElement(componentRealizationEdge);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.MANIFESTATION_EDGE:
		{
			ManifestationEdge manifestationEdge = (ManifestationEdge)theEObject;
			T result = caseManifestationEdge(manifestationEdge);
			if(result == null)
				result = caseAbstractionEdge(manifestationEdge);
			if(result == null)
				result = caseDependencyEdge(manifestationEdge);
			if(result == null)
				result = caseElementEdge(manifestationEdge);
			if(result == null)
				result = caseUmlEdge(manifestationEdge);
			if(result == null)
				result = caseTopUmlDiagramElement(manifestationEdge);
			if(result == null)
				result = caseEdge(manifestationEdge);
			if(result == null)
				result = caseStereotypedDiagramElement(manifestationEdge);
			if(result == null)
				result = caseUmlDiagramElement(manifestationEdge);
			if(result == null)
				result = caseDiagramElement(manifestationEdge);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.PROPERTY_SHAPE:
		{
			PropertyShape propertyShape = (PropertyShape)theEObject;
			T result = casePropertyShape(propertyShape);
			if(result == null)
				result = caseElementWithPortsShape(propertyShape);
			if(result == null)
				result = caseDeploymentTargetShape(propertyShape);
			if(result == null)
				result = caseElementWithStructureShape(propertyShape);
			if(result == null)
				result = caseElementShape(propertyShape);
			if(result == null)
				result = caseUmlShape(propertyShape);
			if(result == null)
				result = caseTopUmlDiagramElement(propertyShape);
			if(result == null)
				result = caseShape(propertyShape);
			if(result == null)
				result = caseStereotypedDiagramElement(propertyShape);
			if(result == null)
				result = caseUmlDiagramElement(propertyShape);
			if(result == null)
				result = caseDiagramElement(propertyShape);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.COLLABORATION_SHAPE:
		{
			CollaborationShape collaborationShape = (CollaborationShape)theEObject;
			T result = caseCollaborationShape(collaborationShape);
			if(result == null)
				result = caseClassifierWithOperationsShape(collaborationShape);
			if(result == null)
				result = caseBehavioredClassifierShape(collaborationShape);
			if(result == null)
				result = caseElementWithStructureShape(collaborationShape);
			if(result == null)
				result = caseClassifierWithAttributesShape(collaborationShape);
			if(result == null)
				result = caseClassifierShape(collaborationShape);
			if(result == null)
				result = caseTemplateableElementShape(collaborationShape);
			if(result == null)
				result = caseElementShape(collaborationShape);
			if(result == null)
				result = caseUmlShape(collaborationShape);
			if(result == null)
				result = caseTopUmlDiagramElement(collaborationShape);
			if(result == null)
				result = caseShape(collaborationShape);
			if(result == null)
				result = caseStereotypedDiagramElement(collaborationShape);
			if(result == null)
				result = caseUmlDiagramElement(collaborationShape);
			if(result == null)
				result = caseDiagramElement(collaborationShape);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.COLLABORATION_USE_SHAPE:
		{
			CollaborationUseShape collaborationUseShape = (CollaborationUseShape)theEObject;
			T result = caseCollaborationUseShape(collaborationUseShape);
			if(result == null)
				result = caseElementShape(collaborationUseShape);
			if(result == null)
				result = caseUmlShape(collaborationUseShape);
			if(result == null)
				result = caseTopUmlDiagramElement(collaborationUseShape);
			if(result == null)
				result = caseShape(collaborationUseShape);
			if(result == null)
				result = caseStereotypedDiagramElement(collaborationUseShape);
			if(result == null)
				result = caseUmlDiagramElement(collaborationUseShape);
			if(result == null)
				result = caseDiagramElement(collaborationUseShape);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.TEMPLATE_BINDING_EDGE:
		{
			TemplateBindingEdge templateBindingEdge = (TemplateBindingEdge)theEObject;
			T result = caseTemplateBindingEdge(templateBindingEdge);
			if(result == null)
				result = caseElementEdge(templateBindingEdge);
			if(result == null)
				result = caseUmlEdge(templateBindingEdge);
			if(result == null)
				result = caseTopUmlDiagramElement(templateBindingEdge);
			if(result == null)
				result = caseEdge(templateBindingEdge);
			if(result == null)
				result = caseStereotypedDiagramElement(templateBindingEdge);
			if(result == null)
				result = caseUmlDiagramElement(templateBindingEdge);
			if(result == null)
				result = caseDiagramElement(templateBindingEdge);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.STEREOTYPE_SHAPE:
		{
			StereotypeShape stereotypeShape = (StereotypeShape)theEObject;
			T result = caseStereotypeShape(stereotypeShape);
			if(result == null)
				result = caseClassShape(stereotypeShape);
			if(result == null)
				result = caseClassifierWithNestedClassifiersShape(stereotypeShape);
			if(result == null)
				result = caseBehavioredClassifierShape(stereotypeShape);
			if(result == null)
				result = caseElementWithPortsShape(stereotypeShape);
			if(result == null)
				result = caseClassifierWithReceptionsShape(stereotypeShape);
			if(result == null)
				result = caseElementWithStructureShape(stereotypeShape);
			if(result == null)
				result = caseClassifierWithOperationsShape(stereotypeShape);
			if(result == null)
				result = caseClassifierWithAttributesShape(stereotypeShape);
			if(result == null)
				result = caseClassifierShape(stereotypeShape);
			if(result == null)
				result = caseTemplateableElementShape(stereotypeShape);
			if(result == null)
				result = caseElementShape(stereotypeShape);
			if(result == null)
				result = caseUmlShape(stereotypeShape);
			if(result == null)
				result = caseTopUmlDiagramElement(stereotypeShape);
			if(result == null)
				result = caseShape(stereotypeShape);
			if(result == null)
				result = caseStereotypedDiagramElement(stereotypeShape);
			if(result == null)
				result = caseUmlDiagramElement(stereotypeShape);
			if(result == null)
				result = caseDiagramElement(stereotypeShape);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.NODE_SHAPE:
		{
			NodeShape nodeShape = (NodeShape)theEObject;
			T result = caseNodeShape(nodeShape);
			if(result == null)
				result = caseClassShape(nodeShape);
			if(result == null)
				result = caseDeploymentTargetShape(nodeShape);
			if(result == null)
				result = caseClassifierWithNestedClassifiersShape(nodeShape);
			if(result == null)
				result = caseBehavioredClassifierShape(nodeShape);
			if(result == null)
				result = caseElementWithPortsShape(nodeShape);
			if(result == null)
				result = caseClassifierWithReceptionsShape(nodeShape);
			if(result == null)
				result = caseElementWithStructureShape(nodeShape);
			if(result == null)
				result = caseClassifierWithOperationsShape(nodeShape);
			if(result == null)
				result = caseClassifierWithAttributesShape(nodeShape);
			if(result == null)
				result = caseClassifierShape(nodeShape);
			if(result == null)
				result = caseTemplateableElementShape(nodeShape);
			if(result == null)
				result = caseElementShape(nodeShape);
			if(result == null)
				result = caseUmlShape(nodeShape);
			if(result == null)
				result = caseTopUmlDiagramElement(nodeShape);
			if(result == null)
				result = caseShape(nodeShape);
			if(result == null)
				result = caseStereotypedDiagramElement(nodeShape);
			if(result == null)
				result = caseUmlDiagramElement(nodeShape);
			if(result == null)
				result = caseDiagramElement(nodeShape);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.NESTED_NODE_COMPARTMENT:
		{
			NestedNodeCompartment nestedNodeCompartment = (NestedNodeCompartment)theEObject;
			T result = caseNestedNodeCompartment(nestedNodeCompartment);
			if(result == null)
				result = caseClassifierCompartment(nestedNodeCompartment);
			if(result == null)
				result = caseDiagramCompartment(nestedNodeCompartment);
			if(result == null)
				result = caseListCompartment(nestedNodeCompartment);
			if(result == null)
				result = caseUmlCompartment(nestedNodeCompartment);
			if(result == null)
				result = caseUmlDiagramElement(nestedNodeCompartment);
			if(result == null)
				result = caseShape(nestedNodeCompartment);
			if(result == null)
				result = caseDiagramElement(nestedNodeCompartment);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.DEVICE_SHAPE:
		{
			DeviceShape deviceShape = (DeviceShape)theEObject;
			T result = caseDeviceShape(deviceShape);
			if(result == null)
				result = caseNodeShape(deviceShape);
			if(result == null)
				result = caseClassShape(deviceShape);
			if(result == null)
				result = caseDeploymentTargetShape(deviceShape);
			if(result == null)
				result = caseClassifierWithNestedClassifiersShape(deviceShape);
			if(result == null)
				result = caseBehavioredClassifierShape(deviceShape);
			if(result == null)
				result = caseElementWithPortsShape(deviceShape);
			if(result == null)
				result = caseClassifierWithReceptionsShape(deviceShape);
			if(result == null)
				result = caseElementWithStructureShape(deviceShape);
			if(result == null)
				result = caseClassifierWithOperationsShape(deviceShape);
			if(result == null)
				result = caseClassifierWithAttributesShape(deviceShape);
			if(result == null)
				result = caseClassifierShape(deviceShape);
			if(result == null)
				result = caseTemplateableElementShape(deviceShape);
			if(result == null)
				result = caseElementShape(deviceShape);
			if(result == null)
				result = caseUmlShape(deviceShape);
			if(result == null)
				result = caseTopUmlDiagramElement(deviceShape);
			if(result == null)
				result = caseShape(deviceShape);
			if(result == null)
				result = caseStereotypedDiagramElement(deviceShape);
			if(result == null)
				result = caseUmlDiagramElement(deviceShape);
			if(result == null)
				result = caseDiagramElement(deviceShape);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.EXECUTION_ENVIRONMENT_SHAPE:
		{
			ExecutionEnvironmentShape executionEnvironmentShape = (ExecutionEnvironmentShape)theEObject;
			T result = caseExecutionEnvironmentShape(executionEnvironmentShape);
			if(result == null)
				result = caseNodeShape(executionEnvironmentShape);
			if(result == null)
				result = caseClassShape(executionEnvironmentShape);
			if(result == null)
				result = caseDeploymentTargetShape(executionEnvironmentShape);
			if(result == null)
				result = caseClassifierWithNestedClassifiersShape(executionEnvironmentShape);
			if(result == null)
				result = caseBehavioredClassifierShape(executionEnvironmentShape);
			if(result == null)
				result = caseElementWithPortsShape(executionEnvironmentShape);
			if(result == null)
				result = caseClassifierWithReceptionsShape(executionEnvironmentShape);
			if(result == null)
				result = caseElementWithStructureShape(executionEnvironmentShape);
			if(result == null)
				result = caseClassifierWithOperationsShape(executionEnvironmentShape);
			if(result == null)
				result = caseClassifierWithAttributesShape(executionEnvironmentShape);
			if(result == null)
				result = caseClassifierShape(executionEnvironmentShape);
			if(result == null)
				result = caseTemplateableElementShape(executionEnvironmentShape);
			if(result == null)
				result = caseElementShape(executionEnvironmentShape);
			if(result == null)
				result = caseUmlShape(executionEnvironmentShape);
			if(result == null)
				result = caseTopUmlDiagramElement(executionEnvironmentShape);
			if(result == null)
				result = caseShape(executionEnvironmentShape);
			if(result == null)
				result = caseStereotypedDiagramElement(executionEnvironmentShape);
			if(result == null)
				result = caseUmlDiagramElement(executionEnvironmentShape);
			if(result == null)
				result = caseDiagramElement(executionEnvironmentShape);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.ACTIVITY_SHAPE:
		{
			ActivityShape activityShape = (ActivityShape)theEObject;
			T result = caseActivityShape(activityShape);
			if(result == null)
				result = caseClassShape(activityShape);
			if(result == null)
				result = caseElementWithActivityNodesShape(activityShape);
			if(result == null)
				result = caseClassifierWithNestedClassifiersShape(activityShape);
			if(result == null)
				result = caseBehavioredClassifierShape(activityShape);
			if(result == null)
				result = caseElementWithPortsShape(activityShape);
			if(result == null)
				result = caseClassifierWithReceptionsShape(activityShape);
			if(result == null)
				result = caseElementWithStructureShape(activityShape);
			if(result == null)
				result = caseClassifierWithOperationsShape(activityShape);
			if(result == null)
				result = caseClassifierWithAttributesShape(activityShape);
			if(result == null)
				result = caseClassifierShape(activityShape);
			if(result == null)
				result = caseTemplateableElementShape(activityShape);
			if(result == null)
				result = caseElementShape(activityShape);
			if(result == null)
				result = caseUmlShape(activityShape);
			if(result == null)
				result = caseTopUmlDiagramElement(activityShape);
			if(result == null)
				result = caseShape(activityShape);
			if(result == null)
				result = caseStereotypedDiagramElement(activityShape);
			if(result == null)
				result = caseUmlDiagramElement(activityShape);
			if(result == null)
				result = caseDiagramElement(activityShape);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.ELEMENT_WITH_ACTIVITY_NODES_SHAPE:
		{
			ElementWithActivityNodesShape elementWithActivityNodesShape = (ElementWithActivityNodesShape)theEObject;
			T result = caseElementWithActivityNodesShape(elementWithActivityNodesShape);
			if(result == null)
				result = caseElementShape(elementWithActivityNodesShape);
			if(result == null)
				result = caseUmlShape(elementWithActivityNodesShape);
			if(result == null)
				result = caseTopUmlDiagramElement(elementWithActivityNodesShape);
			if(result == null)
				result = caseShape(elementWithActivityNodesShape);
			if(result == null)
				result = caseStereotypedDiagramElement(elementWithActivityNodesShape);
			if(result == null)
				result = caseUmlDiagramElement(elementWithActivityNodesShape);
			if(result == null)
				result = caseDiagramElement(elementWithActivityNodesShape);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.ACTIVITY_NODE_COMPARTMENT:
		{
			ActivityNodeCompartment activityNodeCompartment = (ActivityNodeCompartment)theEObject;
			T result = caseActivityNodeCompartment(activityNodeCompartment);
			if(result == null)
				result = caseDiagramCompartment(activityNodeCompartment);
			if(result == null)
				result = caseUmlCompartment(activityNodeCompartment);
			if(result == null)
				result = caseUmlDiagramElement(activityNodeCompartment);
			if(result == null)
				result = caseShape(activityNodeCompartment);
			if(result == null)
				result = caseDiagramElement(activityNodeCompartment);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.PARAMETER_COMPARTMENT:
		{
			ParameterCompartment parameterCompartment = (ParameterCompartment)theEObject;
			T result = caseParameterCompartment(parameterCompartment);
			if(result == null)
				result = caseListCompartment(parameterCompartment);
			if(result == null)
				result = caseUmlCompartment(parameterCompartment);
			if(result == null)
				result = caseUmlDiagramElement(parameterCompartment);
			if(result == null)
				result = caseShape(parameterCompartment);
			if(result == null)
				result = caseDiagramElement(parameterCompartment);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.POST_CONDITION_COMPARTMENT:
		{
			PostConditionCompartment postConditionCompartment = (PostConditionCompartment)theEObject;
			T result = casePostConditionCompartment(postConditionCompartment);
			if(result == null)
				result = caseListCompartment(postConditionCompartment);
			if(result == null)
				result = caseUmlCompartment(postConditionCompartment);
			if(result == null)
				result = caseUmlDiagramElement(postConditionCompartment);
			if(result == null)
				result = caseShape(postConditionCompartment);
			if(result == null)
				result = caseDiagramElement(postConditionCompartment);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.PRE_CONDITION_COMPARTMENT:
		{
			PreConditionCompartment preConditionCompartment = (PreConditionCompartment)theEObject;
			T result = casePreConditionCompartment(preConditionCompartment);
			if(result == null)
				result = caseListCompartment(preConditionCompartment);
			if(result == null)
				result = caseUmlCompartment(preConditionCompartment);
			if(result == null)
				result = caseUmlDiagramElement(preConditionCompartment);
			if(result == null)
				result = caseShape(preConditionCompartment);
			if(result == null)
				result = caseDiagramElement(preConditionCompartment);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.ACTIVITY_PARAMETER_NODE_SHAPE:
		{
			ActivityParameterNodeShape activityParameterNodeShape = (ActivityParameterNodeShape)theEObject;
			T result = caseActivityParameterNodeShape(activityParameterNodeShape);
			if(result == null)
				result = caseObjectNodeShape(activityParameterNodeShape);
			if(result == null)
				result = caseActivityNodeShape(activityParameterNodeShape);
			if(result == null)
				result = caseElementShape(activityParameterNodeShape);
			if(result == null)
				result = caseUmlShape(activityParameterNodeShape);
			if(result == null)
				result = caseTopUmlDiagramElement(activityParameterNodeShape);
			if(result == null)
				result = caseShape(activityParameterNodeShape);
			if(result == null)
				result = caseStereotypedDiagramElement(activityParameterNodeShape);
			if(result == null)
				result = caseUmlDiagramElement(activityParameterNodeShape);
			if(result == null)
				result = caseDiagramElement(activityParameterNodeShape);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.INTERACTION_SHAPE:
		{
			InteractionShape interactionShape = (InteractionShape)theEObject;
			T result = caseInteractionShape(interactionShape);
			if(result == null)
				result = caseClassShape(interactionShape);
			if(result == null)
				result = caseInteractionFragmentWithGatesShape(interactionShape);
			if(result == null)
				result = caseInteractionFragmentWithSubfragmentsShape(interactionShape);
			if(result == null)
				result = caseClassifierWithNestedClassifiersShape(interactionShape);
			if(result == null)
				result = caseBehavioredClassifierShape(interactionShape);
			if(result == null)
				result = caseElementWithPortsShape(interactionShape);
			if(result == null)
				result = caseInteractionFragmentShape(interactionShape);
			if(result == null)
				result = caseClassifierWithReceptionsShape(interactionShape);
			if(result == null)
				result = caseElementWithStructureShape(interactionShape);
			if(result == null)
				result = caseClassifierWithOperationsShape(interactionShape);
			if(result == null)
				result = caseClassifierWithAttributesShape(interactionShape);
			if(result == null)
				result = caseClassifierShape(interactionShape);
			if(result == null)
				result = caseTemplateableElementShape(interactionShape);
			if(result == null)
				result = caseElementShape(interactionShape);
			if(result == null)
				result = caseUmlShape(interactionShape);
			if(result == null)
				result = caseTopUmlDiagramElement(interactionShape);
			if(result == null)
				result = caseShape(interactionShape);
			if(result == null)
				result = caseStereotypedDiagramElement(interactionShape);
			if(result == null)
				result = caseUmlDiagramElement(interactionShape);
			if(result == null)
				result = caseDiagramElement(interactionShape);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.INTERACTION_FRAGMENT_WITH_SUBFRAGMENTS_SHAPE:
		{
			InteractionFragmentWithSubfragmentsShape interactionFragmentWithSubfragmentsShape = (InteractionFragmentWithSubfragmentsShape)theEObject;
			T result = caseInteractionFragmentWithSubfragmentsShape(interactionFragmentWithSubfragmentsShape);
			if(result == null)
				result = caseInteractionFragmentShape(interactionFragmentWithSubfragmentsShape);
			if(result == null)
				result = caseElementShape(interactionFragmentWithSubfragmentsShape);
			if(result == null)
				result = caseUmlShape(interactionFragmentWithSubfragmentsShape);
			if(result == null)
				result = caseTopUmlDiagramElement(interactionFragmentWithSubfragmentsShape);
			if(result == null)
				result = caseShape(interactionFragmentWithSubfragmentsShape);
			if(result == null)
				result = caseStereotypedDiagramElement(interactionFragmentWithSubfragmentsShape);
			if(result == null)
				result = caseUmlDiagramElement(interactionFragmentWithSubfragmentsShape);
			if(result == null)
				result = caseDiagramElement(interactionFragmentWithSubfragmentsShape);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.SUBFRAGMENT_COMPARTMENT:
		{
			SubfragmentCompartment subfragmentCompartment = (SubfragmentCompartment)theEObject;
			T result = caseSubfragmentCompartment(subfragmentCompartment);
			if(result == null)
				result = caseDiagramCompartment(subfragmentCompartment);
			if(result == null)
				result = caseUmlCompartment(subfragmentCompartment);
			if(result == null)
				result = caseUmlDiagramElement(subfragmentCompartment);
			if(result == null)
				result = caseShape(subfragmentCompartment);
			if(result == null)
				result = caseDiagramElement(subfragmentCompartment);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.INTERACTION_FRAGMENT_WITH_GATES_SHAPE:
		{
			InteractionFragmentWithGatesShape interactionFragmentWithGatesShape = (InteractionFragmentWithGatesShape)theEObject;
			T result = caseInteractionFragmentWithGatesShape(interactionFragmentWithGatesShape);
			if(result == null)
				result = caseInteractionFragmentShape(interactionFragmentWithGatesShape);
			if(result == null)
				result = caseElementShape(interactionFragmentWithGatesShape);
			if(result == null)
				result = caseUmlShape(interactionFragmentWithGatesShape);
			if(result == null)
				result = caseTopUmlDiagramElement(interactionFragmentWithGatesShape);
			if(result == null)
				result = caseShape(interactionFragmentWithGatesShape);
			if(result == null)
				result = caseStereotypedDiagramElement(interactionFragmentWithGatesShape);
			if(result == null)
				result = caseUmlDiagramElement(interactionFragmentWithGatesShape);
			if(result == null)
				result = caseDiagramElement(interactionFragmentWithGatesShape);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.GATE_SHAPE:
		{
			GateShape gateShape = (GateShape)theEObject;
			T result = caseGateShape(gateShape);
			if(result == null)
				result = caseElementShape(gateShape);
			if(result == null)
				result = caseUmlShape(gateShape);
			if(result == null)
				result = caseTopUmlDiagramElement(gateShape);
			if(result == null)
				result = caseShape(gateShape);
			if(result == null)
				result = caseStereotypedDiagramElement(gateShape);
			if(result == null)
				result = caseUmlDiagramElement(gateShape);
			if(result == null)
				result = caseDiagramElement(gateShape);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.OPAQUE_BEHAVIOR_SHAPE:
		{
			OpaqueBehaviorShape opaqueBehaviorShape = (OpaqueBehaviorShape)theEObject;
			T result = caseOpaqueBehaviorShape(opaqueBehaviorShape);
			if(result == null)
				result = caseClassShape(opaqueBehaviorShape);
			if(result == null)
				result = caseClassifierWithNestedClassifiersShape(opaqueBehaviorShape);
			if(result == null)
				result = caseBehavioredClassifierShape(opaqueBehaviorShape);
			if(result == null)
				result = caseElementWithPortsShape(opaqueBehaviorShape);
			if(result == null)
				result = caseClassifierWithReceptionsShape(opaqueBehaviorShape);
			if(result == null)
				result = caseElementWithStructureShape(opaqueBehaviorShape);
			if(result == null)
				result = caseClassifierWithOperationsShape(opaqueBehaviorShape);
			if(result == null)
				result = caseClassifierWithAttributesShape(opaqueBehaviorShape);
			if(result == null)
				result = caseClassifierShape(opaqueBehaviorShape);
			if(result == null)
				result = caseTemplateableElementShape(opaqueBehaviorShape);
			if(result == null)
				result = caseElementShape(opaqueBehaviorShape);
			if(result == null)
				result = caseUmlShape(opaqueBehaviorShape);
			if(result == null)
				result = caseTopUmlDiagramElement(opaqueBehaviorShape);
			if(result == null)
				result = caseShape(opaqueBehaviorShape);
			if(result == null)
				result = caseStereotypedDiagramElement(opaqueBehaviorShape);
			if(result == null)
				result = caseUmlDiagramElement(opaqueBehaviorShape);
			if(result == null)
				result = caseDiagramElement(opaqueBehaviorShape);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.FUNCTION_BEHAVIOR_SHAPE:
		{
			FunctionBehaviorShape functionBehaviorShape = (FunctionBehaviorShape)theEObject;
			T result = caseFunctionBehaviorShape(functionBehaviorShape);
			if(result == null)
				result = caseOpaqueBehaviorShape(functionBehaviorShape);
			if(result == null)
				result = caseClassShape(functionBehaviorShape);
			if(result == null)
				result = caseClassifierWithNestedClassifiersShape(functionBehaviorShape);
			if(result == null)
				result = caseBehavioredClassifierShape(functionBehaviorShape);
			if(result == null)
				result = caseElementWithPortsShape(functionBehaviorShape);
			if(result == null)
				result = caseClassifierWithReceptionsShape(functionBehaviorShape);
			if(result == null)
				result = caseElementWithStructureShape(functionBehaviorShape);
			if(result == null)
				result = caseClassifierWithOperationsShape(functionBehaviorShape);
			if(result == null)
				result = caseClassifierWithAttributesShape(functionBehaviorShape);
			if(result == null)
				result = caseClassifierShape(functionBehaviorShape);
			if(result == null)
				result = caseTemplateableElementShape(functionBehaviorShape);
			if(result == null)
				result = caseElementShape(functionBehaviorShape);
			if(result == null)
				result = caseUmlShape(functionBehaviorShape);
			if(result == null)
				result = caseTopUmlDiagramElement(functionBehaviorShape);
			if(result == null)
				result = caseShape(functionBehaviorShape);
			if(result == null)
				result = caseStereotypedDiagramElement(functionBehaviorShape);
			if(result == null)
				result = caseUmlDiagramElement(functionBehaviorShape);
			if(result == null)
				result = caseDiagramElement(functionBehaviorShape);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.STATE_MACHINE_SHAPE:
		{
			StateMachineShape stateMachineShape = (StateMachineShape)theEObject;
			T result = caseStateMachineShape(stateMachineShape);
			if(result == null)
				result = caseClassShape(stateMachineShape);
			if(result == null)
				result = caseBaseStateShape(stateMachineShape);
			if(result == null)
				result = caseClassifierWithNestedClassifiersShape(stateMachineShape);
			if(result == null)
				result = caseBehavioredClassifierShape(stateMachineShape);
			if(result == null)
				result = caseElementWithPortsShape(stateMachineShape);
			if(result == null)
				result = caseClassifierWithReceptionsShape(stateMachineShape);
			if(result == null)
				result = caseElementWithStructureShape(stateMachineShape);
			if(result == null)
				result = caseClassifierWithOperationsShape(stateMachineShape);
			if(result == null)
				result = caseClassifierWithAttributesShape(stateMachineShape);
			if(result == null)
				result = caseClassifierShape(stateMachineShape);
			if(result == null)
				result = caseTemplateableElementShape(stateMachineShape);
			if(result == null)
				result = caseElementShape(stateMachineShape);
			if(result == null)
				result = caseUmlShape(stateMachineShape);
			if(result == null)
				result = caseTopUmlDiagramElement(stateMachineShape);
			if(result == null)
				result = caseShape(stateMachineShape);
			if(result == null)
				result = caseStereotypedDiagramElement(stateMachineShape);
			if(result == null)
				result = caseUmlDiagramElement(stateMachineShape);
			if(result == null)
				result = caseDiagramElement(stateMachineShape);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.BASE_STATE_SHAPE:
		{
			BaseStateShape baseStateShape = (BaseStateShape)theEObject;
			T result = caseBaseStateShape(baseStateShape);
			if(result == null)
				result = caseElementShape(baseStateShape);
			if(result == null)
				result = caseUmlShape(baseStateShape);
			if(result == null)
				result = caseTopUmlDiagramElement(baseStateShape);
			if(result == null)
				result = caseShape(baseStateShape);
			if(result == null)
				result = caseStereotypedDiagramElement(baseStateShape);
			if(result == null)
				result = caseUmlDiagramElement(baseStateShape);
			if(result == null)
				result = caseDiagramElement(baseStateShape);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.PSEUDOSTATE_SHAPE:
		{
			PseudostateShape pseudostateShape = (PseudostateShape)theEObject;
			T result = casePseudostateShape(pseudostateShape);
			if(result == null)
				result = caseElementShape(pseudostateShape);
			if(result == null)
				result = caseUmlShape(pseudostateShape);
			if(result == null)
				result = caseTopUmlDiagramElement(pseudostateShape);
			if(result == null)
				result = caseShape(pseudostateShape);
			if(result == null)
				result = caseStereotypedDiagramElement(pseudostateShape);
			if(result == null)
				result = caseUmlDiagramElement(pseudostateShape);
			if(result == null)
				result = caseDiagramElement(pseudostateShape);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.REGION_COMPARTMENT:
		{
			RegionCompartment regionCompartment = (RegionCompartment)theEObject;
			T result = caseRegionCompartment(regionCompartment);
			if(result == null)
				result = caseDiagramCompartment(regionCompartment);
			if(result == null)
				result = caseUmlCompartment(regionCompartment);
			if(result == null)
				result = caseUmlDiagramElement(regionCompartment);
			if(result == null)
				result = caseShape(regionCompartment);
			if(result == null)
				result = caseDiagramElement(regionCompartment);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.PROTOCOL_STATE_MACHINE_SHAPE:
		{
			ProtocolStateMachineShape protocolStateMachineShape = (ProtocolStateMachineShape)theEObject;
			T result = caseProtocolStateMachineShape(protocolStateMachineShape);
			if(result == null)
				result = caseStateMachineShape(protocolStateMachineShape);
			if(result == null)
				result = caseClassShape(protocolStateMachineShape);
			if(result == null)
				result = caseBaseStateShape(protocolStateMachineShape);
			if(result == null)
				result = caseClassifierWithNestedClassifiersShape(protocolStateMachineShape);
			if(result == null)
				result = caseBehavioredClassifierShape(protocolStateMachineShape);
			if(result == null)
				result = caseElementWithPortsShape(protocolStateMachineShape);
			if(result == null)
				result = caseClassifierWithReceptionsShape(protocolStateMachineShape);
			if(result == null)
				result = caseElementWithStructureShape(protocolStateMachineShape);
			if(result == null)
				result = caseClassifierWithOperationsShape(protocolStateMachineShape);
			if(result == null)
				result = caseClassifierWithAttributesShape(protocolStateMachineShape);
			if(result == null)
				result = caseClassifierShape(protocolStateMachineShape);
			if(result == null)
				result = caseTemplateableElementShape(protocolStateMachineShape);
			if(result == null)
				result = caseElementShape(protocolStateMachineShape);
			if(result == null)
				result = caseUmlShape(protocolStateMachineShape);
			if(result == null)
				result = caseTopUmlDiagramElement(protocolStateMachineShape);
			if(result == null)
				result = caseShape(protocolStateMachineShape);
			if(result == null)
				result = caseStereotypedDiagramElement(protocolStateMachineShape);
			if(result == null)
				result = caseUmlDiagramElement(protocolStateMachineShape);
			if(result == null)
				result = caseDiagramElement(protocolStateMachineShape);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.DEPLOYMENT_SPECIFICATION_SHAPE:
		{
			DeploymentSpecificationShape deploymentSpecificationShape = (DeploymentSpecificationShape)theEObject;
			T result = caseDeploymentSpecificationShape(deploymentSpecificationShape);
			if(result == null)
				result = caseArtifactShape(deploymentSpecificationShape);
			if(result == null)
				result = caseClassifierWithOperationsShape(deploymentSpecificationShape);
			if(result == null)
				result = caseClassifierWithAttributesShape(deploymentSpecificationShape);
			if(result == null)
				result = caseClassifierShape(deploymentSpecificationShape);
			if(result == null)
				result = caseTemplateableElementShape(deploymentSpecificationShape);
			if(result == null)
				result = caseElementShape(deploymentSpecificationShape);
			if(result == null)
				result = caseUmlShape(deploymentSpecificationShape);
			if(result == null)
				result = caseTopUmlDiagramElement(deploymentSpecificationShape);
			if(result == null)
				result = caseShape(deploymentSpecificationShape);
			if(result == null)
				result = caseStereotypedDiagramElement(deploymentSpecificationShape);
			if(result == null)
				result = caseUmlDiagramElement(deploymentSpecificationShape);
			if(result == null)
				result = caseDiagramElement(deploymentSpecificationShape);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.COMMUNICATION_PATH_EDGE:
		{
			CommunicationPathEdge communicationPathEdge = (CommunicationPathEdge)theEObject;
			T result = caseCommunicationPathEdge(communicationPathEdge);
			if(result == null)
				result = caseAssociationEdge(communicationPathEdge);
			if(result == null)
				result = caseElementEdge(communicationPathEdge);
			if(result == null)
				result = caseUmlEdge(communicationPathEdge);
			if(result == null)
				result = caseTopUmlDiagramElement(communicationPathEdge);
			if(result == null)
				result = caseEdge(communicationPathEdge);
			if(result == null)
				result = caseStereotypedDiagramElement(communicationPathEdge);
			if(result == null)
				result = caseUmlDiagramElement(communicationPathEdge);
			if(result == null)
				result = caseDiagramElement(communicationPathEdge);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.DEPLOYMENT_EDGE:
		{
			DeploymentEdge deploymentEdge = (DeploymentEdge)theEObject;
			T result = caseDeploymentEdge(deploymentEdge);
			if(result == null)
				result = caseDependencyEdge(deploymentEdge);
			if(result == null)
				result = caseElementEdge(deploymentEdge);
			if(result == null)
				result = caseUmlEdge(deploymentEdge);
			if(result == null)
				result = caseTopUmlDiagramElement(deploymentEdge);
			if(result == null)
				result = caseEdge(deploymentEdge);
			if(result == null)
				result = caseStereotypedDiagramElement(deploymentEdge);
			if(result == null)
				result = caseUmlDiagramElement(deploymentEdge);
			if(result == null)
				result = caseDiagramElement(deploymentEdge);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.ACTOR_SHAPE:
		{
			ActorShape actorShape = (ActorShape)theEObject;
			T result = caseActorShape(actorShape);
			if(result == null)
				result = caseBehavioredClassifierShape(actorShape);
			if(result == null)
				result = caseClassifierShape(actorShape);
			if(result == null)
				result = caseTemplateableElementShape(actorShape);
			if(result == null)
				result = caseElementShape(actorShape);
			if(result == null)
				result = caseUmlShape(actorShape);
			if(result == null)
				result = caseTopUmlDiagramElement(actorShape);
			if(result == null)
				result = caseShape(actorShape);
			if(result == null)
				result = caseStereotypedDiagramElement(actorShape);
			if(result == null)
				result = caseUmlDiagramElement(actorShape);
			if(result == null)
				result = caseDiagramElement(actorShape);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.EXTENSION_POINT_COMPARTMENT:
		{
			ExtensionPointCompartment extensionPointCompartment = (ExtensionPointCompartment)theEObject;
			T result = caseExtensionPointCompartment(extensionPointCompartment);
			if(result == null)
				result = caseListCompartment(extensionPointCompartment);
			if(result == null)
				result = caseUmlCompartment(extensionPointCompartment);
			if(result == null)
				result = caseUmlDiagramElement(extensionPointCompartment);
			if(result == null)
				result = caseShape(extensionPointCompartment);
			if(result == null)
				result = caseDiagramElement(extensionPointCompartment);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.USE_CASE_SHAPE:
		{
			UseCaseShape useCaseShape = (UseCaseShape)theEObject;
			T result = caseUseCaseShape(useCaseShape);
			if(result == null)
				result = caseBehavioredClassifierShape(useCaseShape);
			if(result == null)
				result = caseClassifierShape(useCaseShape);
			if(result == null)
				result = caseTemplateableElementShape(useCaseShape);
			if(result == null)
				result = caseElementShape(useCaseShape);
			if(result == null)
				result = caseUmlShape(useCaseShape);
			if(result == null)
				result = caseTopUmlDiagramElement(useCaseShape);
			if(result == null)
				result = caseShape(useCaseShape);
			if(result == null)
				result = caseStereotypedDiagramElement(useCaseShape);
			if(result == null)
				result = caseUmlDiagramElement(useCaseShape);
			if(result == null)
				result = caseDiagramElement(useCaseShape);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.INCLUDE_EDGE:
		{
			IncludeEdge includeEdge = (IncludeEdge)theEObject;
			T result = caseIncludeEdge(includeEdge);
			if(result == null)
				result = caseElementEdge(includeEdge);
			if(result == null)
				result = caseUmlEdge(includeEdge);
			if(result == null)
				result = caseTopUmlDiagramElement(includeEdge);
			if(result == null)
				result = caseEdge(includeEdge);
			if(result == null)
				result = caseStereotypedDiagramElement(includeEdge);
			if(result == null)
				result = caseUmlDiagramElement(includeEdge);
			if(result == null)
				result = caseDiagramElement(includeEdge);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.EXTEND_EDGE:
		{
			ExtendEdge extendEdge = (ExtendEdge)theEObject;
			T result = caseExtendEdge(extendEdge);
			if(result == null)
				result = caseElementEdge(extendEdge);
			if(result == null)
				result = caseUmlEdge(extendEdge);
			if(result == null)
				result = caseTopUmlDiagramElement(extendEdge);
			if(result == null)
				result = caseEdge(extendEdge);
			if(result == null)
				result = caseStereotypedDiagramElement(extendEdge);
			if(result == null)
				result = caseUmlDiagramElement(extendEdge);
			if(result == null)
				result = caseDiagramElement(extendEdge);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.STATE_MACHINE_DIAGRAM:
		{
			StateMachineDiagram stateMachineDiagram = (StateMachineDiagram)theEObject;
			T result = caseStateMachineDiagram(stateMachineDiagram);
			if(result == null)
				result = caseBehaviorDiagram(stateMachineDiagram);
			if(result == null)
				result = caseUmlDiagram(stateMachineDiagram);
			if(result == null)
				result = caseUmlDiagramElement(stateMachineDiagram);
			if(result == null)
				result = caseDiagram(stateMachineDiagram);
			if(result == null)
				result = caseShape(stateMachineDiagram);
			if(result == null)
				result = caseDiagramElement(stateMachineDiagram);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.ACTIVITY_DIAGRAM:
		{
			ActivityDiagram activityDiagram = (ActivityDiagram)theEObject;
			T result = caseActivityDiagram(activityDiagram);
			if(result == null)
				result = caseBehaviorDiagram(activityDiagram);
			if(result == null)
				result = caseUmlDiagram(activityDiagram);
			if(result == null)
				result = caseUmlDiagramElement(activityDiagram);
			if(result == null)
				result = caseDiagram(activityDiagram);
			if(result == null)
				result = caseShape(activityDiagram);
			if(result == null)
				result = caseDiagramElement(activityDiagram);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.SEQUENCE_DIAGRAM:
		{
			SequenceDiagram sequenceDiagram = (SequenceDiagram)theEObject;
			T result = caseSequenceDiagram(sequenceDiagram);
			if(result == null)
				result = caseInteractionDiagram(sequenceDiagram);
			if(result == null)
				result = caseBehaviorDiagram(sequenceDiagram);
			if(result == null)
				result = caseUmlDiagram(sequenceDiagram);
			if(result == null)
				result = caseUmlDiagramElement(sequenceDiagram);
			if(result == null)
				result = caseDiagram(sequenceDiagram);
			if(result == null)
				result = caseShape(sequenceDiagram);
			if(result == null)
				result = caseDiagramElement(sequenceDiagram);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.INTERACTION_DIAGRAM:
		{
			InteractionDiagram interactionDiagram = (InteractionDiagram)theEObject;
			T result = caseInteractionDiagram(interactionDiagram);
			if(result == null)
				result = caseBehaviorDiagram(interactionDiagram);
			if(result == null)
				result = caseUmlDiagram(interactionDiagram);
			if(result == null)
				result = caseUmlDiagramElement(interactionDiagram);
			if(result == null)
				result = caseDiagram(interactionDiagram);
			if(result == null)
				result = caseShape(interactionDiagram);
			if(result == null)
				result = caseDiagramElement(interactionDiagram);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.COMMUNICATION_DIAGRAM:
		{
			CommunicationDiagram communicationDiagram = (CommunicationDiagram)theEObject;
			T result = caseCommunicationDiagram(communicationDiagram);
			if(result == null)
				result = caseInteractionDiagram(communicationDiagram);
			if(result == null)
				result = caseBehaviorDiagram(communicationDiagram);
			if(result == null)
				result = caseUmlDiagram(communicationDiagram);
			if(result == null)
				result = caseUmlDiagramElement(communicationDiagram);
			if(result == null)
				result = caseDiagram(communicationDiagram);
			if(result == null)
				result = caseShape(communicationDiagram);
			if(result == null)
				result = caseDiagramElement(communicationDiagram);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.TIMING_DIAGRAM:
		{
			TimingDiagram timingDiagram = (TimingDiagram)theEObject;
			T result = caseTimingDiagram(timingDiagram);
			if(result == null)
				result = caseInteractionDiagram(timingDiagram);
			if(result == null)
				result = caseBehaviorDiagram(timingDiagram);
			if(result == null)
				result = caseUmlDiagram(timingDiagram);
			if(result == null)
				result = caseUmlDiagramElement(timingDiagram);
			if(result == null)
				result = caseDiagram(timingDiagram);
			if(result == null)
				result = caseShape(timingDiagram);
			if(result == null)
				result = caseDiagramElement(timingDiagram);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.INTERACTION_OVERVIEW_DIAGRAM:
		{
			InteractionOverviewDiagram interactionOverviewDiagram = (InteractionOverviewDiagram)theEObject;
			T result = caseInteractionOverviewDiagram(interactionOverviewDiagram);
			if(result == null)
				result = caseInteractionDiagram(interactionOverviewDiagram);
			if(result == null)
				result = caseBehaviorDiagram(interactionOverviewDiagram);
			if(result == null)
				result = caseUmlDiagram(interactionOverviewDiagram);
			if(result == null)
				result = caseUmlDiagramElement(interactionOverviewDiagram);
			if(result == null)
				result = caseDiagram(interactionOverviewDiagram);
			if(result == null)
				result = caseShape(interactionOverviewDiagram);
			if(result == null)
				result = caseDiagramElement(interactionOverviewDiagram);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.INTERNAL_BEHAVIOR_COMPARTMENT:
		{
			InternalBehaviorCompartment internalBehaviorCompartment = (InternalBehaviorCompartment)theEObject;
			T result = caseInternalBehaviorCompartment(internalBehaviorCompartment);
			if(result == null)
				result = caseListCompartment(internalBehaviorCompartment);
			if(result == null)
				result = caseUmlCompartment(internalBehaviorCompartment);
			if(result == null)
				result = caseUmlDiagramElement(internalBehaviorCompartment);
			if(result == null)
				result = caseShape(internalBehaviorCompartment);
			if(result == null)
				result = caseDiagramElement(internalBehaviorCompartment);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.STATE_SHAPE:
		{
			StateShape stateShape = (StateShape)theEObject;
			T result = caseStateShape(stateShape);
			if(result == null)
				result = caseBaseStateShape(stateShape);
			if(result == null)
				result = caseElementShape(stateShape);
			if(result == null)
				result = caseUmlShape(stateShape);
			if(result == null)
				result = caseTopUmlDiagramElement(stateShape);
			if(result == null)
				result = caseShape(stateShape);
			if(result == null)
				result = caseStereotypedDiagramElement(stateShape);
			if(result == null)
				result = caseUmlDiagramElement(stateShape);
			if(result == null)
				result = caseDiagramElement(stateShape);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.CONNECTION_POINT_REFERENCE_SHAPE:
		{
			ConnectionPointReferenceShape connectionPointReferenceShape = (ConnectionPointReferenceShape)theEObject;
			T result = caseConnectionPointReferenceShape(connectionPointReferenceShape);
			if(result == null)
				result = caseElementShape(connectionPointReferenceShape);
			if(result == null)
				result = caseUmlShape(connectionPointReferenceShape);
			if(result == null)
				result = caseTopUmlDiagramElement(connectionPointReferenceShape);
			if(result == null)
				result = caseShape(connectionPointReferenceShape);
			if(result == null)
				result = caseStereotypedDiagramElement(connectionPointReferenceShape);
			if(result == null)
				result = caseUmlDiagramElement(connectionPointReferenceShape);
			if(result == null)
				result = caseDiagramElement(connectionPointReferenceShape);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.INTERNAL_TRANSITION_COMPARTMENT:
		{
			InternalTransitionCompartment internalTransitionCompartment = (InternalTransitionCompartment)theEObject;
			T result = caseInternalTransitionCompartment(internalTransitionCompartment);
			if(result == null)
				result = caseListCompartment(internalTransitionCompartment);
			if(result == null)
				result = caseUmlCompartment(internalTransitionCompartment);
			if(result == null)
				result = caseUmlDiagramElement(internalTransitionCompartment);
			if(result == null)
				result = caseShape(internalTransitionCompartment);
			if(result == null)
				result = caseDiagramElement(internalTransitionCompartment);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.DEFERRABLE_TRIGGER_COMPARTMENT:
		{
			DeferrableTriggerCompartment deferrableTriggerCompartment = (DeferrableTriggerCompartment)theEObject;
			T result = caseDeferrableTriggerCompartment(deferrableTriggerCompartment);
			if(result == null)
				result = caseListCompartment(deferrableTriggerCompartment);
			if(result == null)
				result = caseUmlCompartment(deferrableTriggerCompartment);
			if(result == null)
				result = caseUmlDiagramElement(deferrableTriggerCompartment);
			if(result == null)
				result = caseShape(deferrableTriggerCompartment);
			if(result == null)
				result = caseDiagramElement(deferrableTriggerCompartment);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.REGION_SHAPE:
		{
			RegionShape regionShape = (RegionShape)theEObject;
			T result = caseRegionShape(regionShape);
			if(result == null)
				result = caseElementShape(regionShape);
			if(result == null)
				result = caseUmlShape(regionShape);
			if(result == null)
				result = caseTopUmlDiagramElement(regionShape);
			if(result == null)
				result = caseShape(regionShape);
			if(result == null)
				result = caseStereotypedDiagramElement(regionShape);
			if(result == null)
				result = caseUmlDiagramElement(regionShape);
			if(result == null)
				result = caseDiagramElement(regionShape);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.SUBVERTEX_COMPARTMENT:
		{
			SubvertexCompartment subvertexCompartment = (SubvertexCompartment)theEObject;
			T result = caseSubvertexCompartment(subvertexCompartment);
			if(result == null)
				result = caseDiagramCompartment(subvertexCompartment);
			if(result == null)
				result = caseUmlCompartment(subvertexCompartment);
			if(result == null)
				result = caseUmlDiagramElement(subvertexCompartment);
			if(result == null)
				result = caseShape(subvertexCompartment);
			if(result == null)
				result = caseDiagramElement(subvertexCompartment);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.TRANSITION_EDGE:
		{
			TransitionEdge transitionEdge = (TransitionEdge)theEObject;
			T result = caseTransitionEdge(transitionEdge);
			if(result == null)
				result = caseElementEdge(transitionEdge);
			if(result == null)
				result = caseUmlEdge(transitionEdge);
			if(result == null)
				result = caseTopUmlDiagramElement(transitionEdge);
			if(result == null)
				result = caseEdge(transitionEdge);
			if(result == null)
				result = caseStereotypedDiagramElement(transitionEdge);
			if(result == null)
				result = caseUmlDiagramElement(transitionEdge);
			if(result == null)
				result = caseDiagramElement(transitionEdge);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.CONTROL_FLOW_EDGE:
		{
			ControlFlowEdge controlFlowEdge = (ControlFlowEdge)theEObject;
			T result = caseControlFlowEdge(controlFlowEdge);
			if(result == null)
				result = caseActivityEdgeEdge(controlFlowEdge);
			if(result == null)
				result = caseElementEdge(controlFlowEdge);
			if(result == null)
				result = caseUmlEdge(controlFlowEdge);
			if(result == null)
				result = caseTopUmlDiagramElement(controlFlowEdge);
			if(result == null)
				result = caseEdge(controlFlowEdge);
			if(result == null)
				result = caseStereotypedDiagramElement(controlFlowEdge);
			if(result == null)
				result = caseUmlDiagramElement(controlFlowEdge);
			if(result == null)
				result = caseDiagramElement(controlFlowEdge);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.ACTIVITY_GROUP_SHAPE:
		{
			ActivityGroupShape activityGroupShape = (ActivityGroupShape)theEObject;
			T result = caseActivityGroupShape(activityGroupShape);
			if(result == null)
				result = caseElementShape(activityGroupShape);
			if(result == null)
				result = caseUmlShape(activityGroupShape);
			if(result == null)
				result = caseTopUmlDiagramElement(activityGroupShape);
			if(result == null)
				result = caseShape(activityGroupShape);
			if(result == null)
				result = caseStereotypedDiagramElement(activityGroupShape);
			if(result == null)
				result = caseUmlDiagramElement(activityGroupShape);
			if(result == null)
				result = caseDiagramElement(activityGroupShape);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.EXCEPTION_HANDLER_EDGE:
		{
			ExceptionHandlerEdge exceptionHandlerEdge = (ExceptionHandlerEdge)theEObject;
			T result = caseExceptionHandlerEdge(exceptionHandlerEdge);
			if(result == null)
				result = caseElementEdge(exceptionHandlerEdge);
			if(result == null)
				result = caseUmlEdge(exceptionHandlerEdge);
			if(result == null)
				result = caseTopUmlDiagramElement(exceptionHandlerEdge);
			if(result == null)
				result = caseEdge(exceptionHandlerEdge);
			if(result == null)
				result = caseStereotypedDiagramElement(exceptionHandlerEdge);
			if(result == null)
				result = caseUmlDiagramElement(exceptionHandlerEdge);
			if(result == null)
				result = caseDiagramElement(exceptionHandlerEdge);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.TYPE_LABEL:
		{
			TypeLabel typeLabel = (TypeLabel)theEObject;
			T result = caseTypeLabel(typeLabel);
			if(result == null)
				result = caseUmlLabel(typeLabel);
			if(result == null)
				result = caseUmlDiagramElement(typeLabel);
			if(result == null)
				result = caseShape(typeLabel);
			if(result == null)
				result = caseDiagramElement(typeLabel);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.INTERACTION_USE_SHAPE:
		{
			InteractionUseShape interactionUseShape = (InteractionUseShape)theEObject;
			T result = caseInteractionUseShape(interactionUseShape);
			if(result == null)
				result = caseInteractionFragmentWithGatesShape(interactionUseShape);
			if(result == null)
				result = caseInteractionFragmentShape(interactionUseShape);
			if(result == null)
				result = caseElementShape(interactionUseShape);
			if(result == null)
				result = caseUmlShape(interactionUseShape);
			if(result == null)
				result = caseTopUmlDiagramElement(interactionUseShape);
			if(result == null)
				result = caseShape(interactionUseShape);
			if(result == null)
				result = caseStereotypedDiagramElement(interactionUseShape);
			if(result == null)
				result = caseUmlDiagramElement(interactionUseShape);
			if(result == null)
				result = caseDiagramElement(interactionUseShape);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.ICON_LABEL:
		{
			IconLabel iconLabel = (IconLabel)theEObject;
			T result = caseIconLabel(iconLabel);
			if(result == null)
				result = caseUmlLabel(iconLabel);
			if(result == null)
				result = caseUmlDiagramElement(iconLabel);
			if(result == null)
				result = caseShape(iconLabel);
			if(result == null)
				result = caseDiagramElement(iconLabel);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.SUBPARTITION_COMPARTMENT:
		{
			SubpartitionCompartment subpartitionCompartment = (SubpartitionCompartment)theEObject;
			T result = caseSubpartitionCompartment(subpartitionCompartment);
			if(result == null)
				result = caseDiagramCompartment(subpartitionCompartment);
			if(result == null)
				result = caseUmlCompartment(subpartitionCompartment);
			if(result == null)
				result = caseUmlDiagramElement(subpartitionCompartment);
			if(result == null)
				result = caseShape(subpartitionCompartment);
			if(result == null)
				result = caseDiagramElement(subpartitionCompartment);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.ACTIVITY_PARTITION_SHAPE:
		{
			ActivityPartitionShape activityPartitionShape = (ActivityPartitionShape)theEObject;
			T result = caseActivityPartitionShape(activityPartitionShape);
			if(result == null)
				result = caseActivityGroupShape(activityPartitionShape);
			if(result == null)
				result = caseElementShape(activityPartitionShape);
			if(result == null)
				result = caseUmlShape(activityPartitionShape);
			if(result == null)
				result = caseTopUmlDiagramElement(activityPartitionShape);
			if(result == null)
				result = caseShape(activityPartitionShape);
			if(result == null)
				result = caseStereotypedDiagramElement(activityPartitionShape);
			if(result == null)
				result = caseUmlDiagramElement(activityPartitionShape);
			if(result == null)
				result = caseDiagramElement(activityPartitionShape);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.STRUCTURED_ACTIVITY_NODE_SHAPE:
		{
			StructuredActivityNodeShape structuredActivityNodeShape = (StructuredActivityNodeShape)theEObject;
			T result = caseStructuredActivityNodeShape(structuredActivityNodeShape);
			if(result == null)
				result = caseActionShape(structuredActivityNodeShape);
			if(result == null)
				result = caseElementWithActivityNodesShape(structuredActivityNodeShape);
			if(result == null)
				result = caseActivityGroupShape(structuredActivityNodeShape);
			if(result == null)
				result = caseActivityNodeShape(structuredActivityNodeShape);
			if(result == null)
				result = caseElementShape(structuredActivityNodeShape);
			if(result == null)
				result = caseUmlShape(structuredActivityNodeShape);
			if(result == null)
				result = caseTopUmlDiagramElement(structuredActivityNodeShape);
			if(result == null)
				result = caseShape(structuredActivityNodeShape);
			if(result == null)
				result = caseStereotypedDiagramElement(structuredActivityNodeShape);
			if(result == null)
				result = caseUmlDiagramElement(structuredActivityNodeShape);
			if(result == null)
				result = caseDiagramElement(structuredActivityNodeShape);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.EXPANSION_REGION_SHAPE:
		{
			ExpansionRegionShape expansionRegionShape = (ExpansionRegionShape)theEObject;
			T result = caseExpansionRegionShape(expansionRegionShape);
			if(result == null)
				result = caseStructuredActivityNodeShape(expansionRegionShape);
			if(result == null)
				result = caseActionShape(expansionRegionShape);
			if(result == null)
				result = caseElementWithActivityNodesShape(expansionRegionShape);
			if(result == null)
				result = caseActivityGroupShape(expansionRegionShape);
			if(result == null)
				result = caseActivityNodeShape(expansionRegionShape);
			if(result == null)
				result = caseElementShape(expansionRegionShape);
			if(result == null)
				result = caseUmlShape(expansionRegionShape);
			if(result == null)
				result = caseTopUmlDiagramElement(expansionRegionShape);
			if(result == null)
				result = caseShape(expansionRegionShape);
			if(result == null)
				result = caseStereotypedDiagramElement(expansionRegionShape);
			if(result == null)
				result = caseUmlDiagramElement(expansionRegionShape);
			if(result == null)
				result = caseDiagramElement(expansionRegionShape);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.EXPANSION_NODE_SHAPE:
		{
			ExpansionNodeShape expansionNodeShape = (ExpansionNodeShape)theEObject;
			T result = caseExpansionNodeShape(expansionNodeShape);
			if(result == null)
				result = caseObjectNodeShape(expansionNodeShape);
			if(result == null)
				result = caseActivityNodeShape(expansionNodeShape);
			if(result == null)
				result = caseElementShape(expansionNodeShape);
			if(result == null)
				result = caseUmlShape(expansionNodeShape);
			if(result == null)
				result = caseTopUmlDiagramElement(expansionNodeShape);
			if(result == null)
				result = caseShape(expansionNodeShape);
			if(result == null)
				result = caseStereotypedDiagramElement(expansionNodeShape);
			if(result == null)
				result = caseUmlDiagramElement(expansionNodeShape);
			if(result == null)
				result = caseDiagramElement(expansionNodeShape);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.MESSAGE_EDGE:
		{
			MessageEdge messageEdge = (MessageEdge)theEObject;
			T result = caseMessageEdge(messageEdge);
			if(result == null)
				result = caseElementEdge(messageEdge);
			if(result == null)
				result = caseUmlEdge(messageEdge);
			if(result == null)
				result = caseTopUmlDiagramElement(messageEdge);
			if(result == null)
				result = caseEdge(messageEdge);
			if(result == null)
				result = caseStereotypedDiagramElement(messageEdge);
			if(result == null)
				result = caseUmlDiagramElement(messageEdge);
			if(result == null)
				result = caseDiagramElement(messageEdge);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.GENERAL_ORDERING_EDGE:
		{
			GeneralOrderingEdge generalOrderingEdge = (GeneralOrderingEdge)theEObject;
			T result = caseGeneralOrderingEdge(generalOrderingEdge);
			if(result == null)
				result = caseElementEdge(generalOrderingEdge);
			if(result == null)
				result = caseUmlEdge(generalOrderingEdge);
			if(result == null)
				result = caseTopUmlDiagramElement(generalOrderingEdge);
			if(result == null)
				result = caseEdge(generalOrderingEdge);
			if(result == null)
				result = caseStereotypedDiagramElement(generalOrderingEdge);
			if(result == null)
				result = caseUmlDiagramElement(generalOrderingEdge);
			if(result == null)
				result = caseDiagramElement(generalOrderingEdge);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.COMBINED_FRAGMENT_SHAPE:
		{
			CombinedFragmentShape combinedFragmentShape = (CombinedFragmentShape)theEObject;
			T result = caseCombinedFragmentShape(combinedFragmentShape);
			if(result == null)
				result = caseInteractionFragmentWithGatesShape(combinedFragmentShape);
			if(result == null)
				result = caseInteractionFragmentWithSubfragmentsShape(combinedFragmentShape);
			if(result == null)
				result = caseInteractionFragmentShape(combinedFragmentShape);
			if(result == null)
				result = caseElementShape(combinedFragmentShape);
			if(result == null)
				result = caseUmlShape(combinedFragmentShape);
			if(result == null)
				result = caseTopUmlDiagramElement(combinedFragmentShape);
			if(result == null)
				result = caseShape(combinedFragmentShape);
			if(result == null)
				result = caseStereotypedDiagramElement(combinedFragmentShape);
			if(result == null)
				result = caseUmlDiagramElement(combinedFragmentShape);
			if(result == null)
				result = caseDiagramElement(combinedFragmentShape);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.INTERACTION_OPERAND_SHAPE:
		{
			InteractionOperandShape interactionOperandShape = (InteractionOperandShape)theEObject;
			T result = caseInteractionOperandShape(interactionOperandShape);
			if(result == null)
				result = caseInteractionFragmentWithSubfragmentsShape(interactionOperandShape);
			if(result == null)
				result = caseInteractionFragmentShape(interactionOperandShape);
			if(result == null)
				result = caseElementShape(interactionOperandShape);
			if(result == null)
				result = caseUmlShape(interactionOperandShape);
			if(result == null)
				result = caseTopUmlDiagramElement(interactionOperandShape);
			if(result == null)
				result = caseShape(interactionOperandShape);
			if(result == null)
				result = caseStereotypedDiagramElement(interactionOperandShape);
			if(result == null)
				result = caseUmlDiagramElement(interactionOperandShape);
			if(result == null)
				result = caseDiagramElement(interactionOperandShape);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.EXECUTION_SPECIFICATION_SHAPE:
		{
			ExecutionSpecificationShape executionSpecificationShape = (ExecutionSpecificationShape)theEObject;
			T result = caseExecutionSpecificationShape(executionSpecificationShape);
			if(result == null)
				result = caseInteractionFragmentShape(executionSpecificationShape);
			if(result == null)
				result = caseElementShape(executionSpecificationShape);
			if(result == null)
				result = caseUmlShape(executionSpecificationShape);
			if(result == null)
				result = caseTopUmlDiagramElement(executionSpecificationShape);
			if(result == null)
				result = caseShape(executionSpecificationShape);
			if(result == null)
				result = caseStereotypedDiagramElement(executionSpecificationShape);
			if(result == null)
				result = caseUmlDiagramElement(executionSpecificationShape);
			if(result == null)
				result = caseDiagramElement(executionSpecificationShape);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.DURATION_CONSTRAINT_SHAPE:
		{
			DurationConstraintShape durationConstraintShape = (DurationConstraintShape)theEObject;
			T result = caseDurationConstraintShape(durationConstraintShape);
			if(result == null)
				result = caseConstraintShape(durationConstraintShape);
			if(result == null)
				result = caseElementShape(durationConstraintShape);
			if(result == null)
				result = caseUmlShape(durationConstraintShape);
			if(result == null)
				result = caseTopUmlDiagramElement(durationConstraintShape);
			if(result == null)
				result = caseShape(durationConstraintShape);
			if(result == null)
				result = caseStereotypedDiagramElement(durationConstraintShape);
			if(result == null)
				result = caseUmlDiagramElement(durationConstraintShape);
			if(result == null)
				result = caseDiagramElement(durationConstraintShape);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.TIME_CONSTRAINT_SHAPE:
		{
			TimeConstraintShape timeConstraintShape = (TimeConstraintShape)theEObject;
			T result = caseTimeConstraintShape(timeConstraintShape);
			if(result == null)
				result = caseConstraintShape(timeConstraintShape);
			if(result == null)
				result = caseElementShape(timeConstraintShape);
			if(result == null)
				result = caseUmlShape(timeConstraintShape);
			if(result == null)
				result = caseTopUmlDiagramElement(timeConstraintShape);
			if(result == null)
				result = caseShape(timeConstraintShape);
			if(result == null)
				result = caseStereotypedDiagramElement(timeConstraintShape);
			if(result == null)
				result = caseUmlDiagramElement(timeConstraintShape);
			if(result == null)
				result = caseDiagramElement(timeConstraintShape);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.TIME_EXPRESSION_SHAPE:
		{
			TimeExpressionShape timeExpressionShape = (TimeExpressionShape)theEObject;
			T result = caseTimeExpressionShape(timeExpressionShape);
			if(result == null)
				result = caseElementShape(timeExpressionShape);
			if(result == null)
				result = caseUmlShape(timeExpressionShape);
			if(result == null)
				result = caseTopUmlDiagramElement(timeExpressionShape);
			if(result == null)
				result = caseShape(timeExpressionShape);
			if(result == null)
				result = caseStereotypedDiagramElement(timeExpressionShape);
			if(result == null)
				result = caseUmlDiagramElement(timeExpressionShape);
			if(result == null)
				result = caseDiagramElement(timeExpressionShape);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.DURATION_SHAPE:
		{
			DurationShape durationShape = (DurationShape)theEObject;
			T result = caseDurationShape(durationShape);
			if(result == null)
				result = caseElementShape(durationShape);
			if(result == null)
				result = caseUmlShape(durationShape);
			if(result == null)
				result = caseTopUmlDiagramElement(durationShape);
			if(result == null)
				result = caseShape(durationShape);
			if(result == null)
				result = caseStereotypedDiagramElement(durationShape);
			if(result == null)
				result = caseUmlDiagramElement(durationShape);
			if(result == null)
				result = caseDiagramElement(durationShape);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.PATH_EDGE:
		{
			PathEdge pathEdge = (PathEdge)theEObject;
			T result = casePathEdge(pathEdge);
			if(result == null)
				result = caseUmlEdge(pathEdge);
			if(result == null)
				result = caseTopUmlDiagramElement(pathEdge);
			if(result == null)
				result = caseEdge(pathEdge);
			if(result == null)
				result = caseStereotypedDiagramElement(pathEdge);
			if(result == null)
				result = caseUmlDiagramElement(pathEdge);
			if(result == null)
				result = caseDiagramElement(pathEdge);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.MESSAGE_LABEL:
		{
			MessageLabel messageLabel = (MessageLabel)theEObject;
			T result = caseMessageLabel(messageLabel);
			if(result == null)
				result = caseUmlLabel(messageLabel);
			if(result == null)
				result = caseUmlDiagramElement(messageLabel);
			if(result == null)
				result = caseShape(messageLabel);
			if(result == null)
				result = caseDiagramElement(messageLabel);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UMLDIPackage.STATE_INVARIANT_SHAPE:
		{
			StateInvariantShape stateInvariantShape = (StateInvariantShape)theEObject;
			T result = caseStateInvariantShape(stateInvariantShape);
			if(result == null)
				result = caseInteractionFragmentShape(stateInvariantShape);
			if(result == null)
				result = caseElementShape(stateInvariantShape);
			if(result == null)
				result = caseUmlShape(stateInvariantShape);
			if(result == null)
				result = caseTopUmlDiagramElement(stateInvariantShape);
			if(result == null)
				result = caseShape(stateInvariantShape);
			if(result == null)
				result = caseStereotypedDiagramElement(stateInvariantShape);
			if(result == null)
				result = caseUmlDiagramElement(stateInvariantShape);
			if(result == null)
				result = caseDiagramElement(stateInvariantShape);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Uml Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Uml Diagram</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUmlDiagram(UmlDiagram object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Uml Diagram Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Uml Diagram Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUmlDiagramElement(UmlDiagramElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Uml Style</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Uml Style</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUmlStyle(UmlStyle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Uml Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Uml Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUmlEdge(UmlEdge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Top Uml Diagram Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Top Uml Diagram Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTopUmlDiagramElement(TopUmlDiagramElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Stereotyped Diagram Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Stereotyped Diagram Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStereotypedDiagramElement(StereotypedDiagramElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Diagram Compartment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Diagram Compartment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDiagramCompartment(DiagramCompartment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Uml Compartment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Uml Compartment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUmlCompartment(UmlCompartment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element With Packaged Elements Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element With Packaged Elements Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElementWithPackagedElementsShape(ElementWithPackagedElementsShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Uml Label</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Uml Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUmlLabel(UmlLabel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElementEdge(ElementEdge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Classifier Compartment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Classifier Compartment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClassifierCompartment(ClassifierCompartment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Class Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Class Diagram</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClassDiagram(ClassDiagram object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Structure Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Structure Diagram</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStructureDiagram(StructureDiagram object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Classifier Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Classifier Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClassifierShape(ClassifierShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Package Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Package Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePackageShape(PackageShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Templateable Element Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Templateable Element Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTemplateableElementShape(TemplateableElementShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElementShape(ElementShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Stereotype Compartment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Stereotype Compartment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStereotypeCompartment(StereotypeCompartment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Constraint Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Constraint Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConstraintShape(ConstraintShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Compartment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Compartment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttributeCompartment(AttributeCompartment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operation Compartment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operation Compartment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperationCompartment(OperationCompartment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reception Compartment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reception Compartment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReceptionCompartment(ReceptionCompartment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal Compartment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal Compartment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiteralCompartment(LiteralCompartment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Packaged Element Compartment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Packaged Element Compartment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePackagedElementCompartment(PackagedElementCompartment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertyEdge(PropertyEdge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Constraint Label</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Constraint Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConstraintLabel(ConstraintLabel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Instance Specification Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Instance Specification Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInstanceSpecificationEdge(InstanceSpecificationEdge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Instance Specification Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Instance Specification Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInstanceSpecificationShape(InstanceSpecificationShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Deployment Target Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Deployment Target Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDeploymentTargetShape(DeploymentTargetShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Deployed Artifact Compartment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Deployed Artifact Compartment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDeployedArtifactCompartment(DeployedArtifactCompartment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Slot Compartment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Slot Compartment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSlotCompartment(SlotCompartment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Class Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Class Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClassShape(ClassShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element With Ports Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element With Ports Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElementWithPortsShape(ElementWithPortsShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element With Structure Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element With Structure Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElementWithStructureShape(ElementWithStructureShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Structure Compartment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Structure Compartment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStructureCompartment(StructureCompartment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Port Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Port Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePortShape(PortShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Classifier With Nested Classifiers Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Classifier With Nested Classifiers Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClassifierWithNestedClassifiersShape(ClassifierWithNestedClassifiersShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Nested Classifier Compartment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Nested Classifier Compartment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNestedClassifierCompartment(NestedClassifierCompartment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Behaviored Classifier Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Behaviored Classifier Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBehavioredClassifierShape(BehavioredClassifierShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Owned Behavior Compartment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Owned Behavior Compartment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOwnedBehaviorCompartment(OwnedBehaviorCompartment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Classifier With Receptions Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Classifier With Receptions Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClassifierWithReceptionsShape(ClassifierWithReceptionsShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Classifier With Attributes Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Classifier With Attributes Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClassifierWithAttributesShape(ClassifierWithAttributesShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Classifier With Operations Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Classifier With Operations Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClassifierWithOperationsShape(ClassifierWithOperationsShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Interface Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Interface Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInterfaceShape(InterfaceShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Type Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Type Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataTypeShape(DataTypeShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Primitive Type Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Primitive Type Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrimitiveTypeShape(PrimitiveTypeShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enumeration Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enumeration Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnumerationShape(EnumerationShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Role Label</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Role Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRoleLabel(RoleLabel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Signal Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Signal Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSignalShape(SignalShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelShape(ModelShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Containment Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Containment Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContainmentEdge(ContainmentEdge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Generalization Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Generalization Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGeneralizationEdge(GeneralizationEdge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Association Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Association Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAssociationEdge(AssociationEdge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Multiplicity Label</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Multiplicity Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMultiplicityLabel(MultiplicityLabel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Realization Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Realization Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRealizationEdge(RealizationEdge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstraction Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstraction Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractionEdge(AbstractionEdge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dependency Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dependency Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDependencyEdge(DependencyEdge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Interface Realization Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Interface Realization Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInterfaceRealizationEdge(InterfaceRealizationEdge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Usage Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Usage Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUsageEdge(UsageEdge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element Import Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element Import Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElementImportEdge(ElementImportEdge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Package Import Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Package Import Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePackageImportEdge(PackageImportEdge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Package Merge Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Package Merge Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePackageMergeEdge(PackageMergeEdge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Substitution Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Substitution Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubstitutionEdge(SubstitutionEdge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Information Flow Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Information Flow Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInformationFlowEdge(InformationFlowEdge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Conveyed Label</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Conveyed Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConveyedLabel(ConveyedLabel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Association Class Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Association Class Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAssociationClassEdge(AssociationClassEdge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Generalization Set Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Generalization Set Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGeneralizationSetEdge(GeneralizationSetEdge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Power Label</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Power Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePowerLabel(PowerLabel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Connector Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Connector Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConnectorEdge(ConnectorEdge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Comment Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Comment Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCommentShape(CommentShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attachment Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attachment Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttachmentEdge(AttachmentEdge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Association Class Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Association Class Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAssociationClassShape(AssociationClassShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Component Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComponentShape(ComponentShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Information Item Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Information Item Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInformationItemShape(InformationItemShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Representation Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Representation Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRepresentationEdge(RepresentationEdge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Association Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Association Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAssociationShape(AssociationShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dependency Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dependency Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDependencyShape(DependencyShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Time Observation Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Time Observation Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTimeObservationShape(TimeObservationShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Time Observation Shape Time Observation Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Time Observation Shape Time Observation Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTimeObservationShape_TimeObservationShape(TimeObservationShape_TimeObservationShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Duration Observation Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Duration Observation Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDurationObservationShape(DurationObservationShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Package Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Package Diagram</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePackageDiagram(PackageDiagram object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Profile Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Profile Diagram</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProfileDiagram(ProfileDiagram object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Composite Structure Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Composite Structure Diagram</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompositeStructureDiagram(CompositeStructureDiagram object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Deployment Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Deployment Diagram</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDeploymentDiagram(DeploymentDiagram object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Component Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component Diagram</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComponentDiagram(ComponentDiagram object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Object Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Object Diagram</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseObjectDiagram(ObjectDiagram object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Profile Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Profile Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProfileShape(ProfileShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Profile Application Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Profile Application Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProfileApplicationEdge(ProfileApplicationEdge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Extension Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Extension Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExtensionEdge(ExtensionEdge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Behavior Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Behavior Diagram</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBehaviorDiagram(BehaviorDiagram object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Use Case Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Use Case Diagram</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUseCaseDiagram(UseCaseDiagram object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Artifact Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Artifact Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseArtifactShape(ArtifactShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Nested Artifact Compartment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Nested Artifact Compartment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNestedArtifactCompartment(NestedArtifactCompartment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Component Realization Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component Realization Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComponentRealizationEdge(ComponentRealizationEdge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Manifestation Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Manifestation Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseManifestationEdge(ManifestationEdge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertyShape(PropertyShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Collaboration Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collaboration Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCollaborationShape(CollaborationShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Collaboration Use Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collaboration Use Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCollaborationUseShape(CollaborationUseShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Template Binding Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Template Binding Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTemplateBindingEdge(TemplateBindingEdge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Stereotype Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Stereotype Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStereotypeShape(StereotypeShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Node Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Node Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNodeShape(NodeShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Nested Node Compartment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Nested Node Compartment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNestedNodeCompartment(NestedNodeCompartment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Device Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Device Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDeviceShape(DeviceShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Execution Environment Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Execution Environment Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExecutionEnvironmentShape(ExecutionEnvironmentShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Activity Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Activity Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActivityShape(ActivityShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element With Activity Nodes Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element With Activity Nodes Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElementWithActivityNodesShape(ElementWithActivityNodesShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Activity Node Compartment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Activity Node Compartment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActivityNodeCompartment(ActivityNodeCompartment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameter Compartment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameter Compartment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParameterCompartment(ParameterCompartment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Post Condition Compartment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Post Condition Compartment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePostConditionCompartment(PostConditionCompartment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pre Condition Compartment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pre Condition Compartment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePreConditionCompartment(PreConditionCompartment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Structured Activity Node Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Structured Activity Node Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStructuredActivityNodeShape(StructuredActivityNodeShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Activity Parameter Node Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Activity Parameter Node Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActivityParameterNodeShape(ActivityParameterNodeShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Interaction Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Interaction Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInteractionShape(InteractionShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Interaction Fragment With Subfragments Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Interaction Fragment With Subfragments Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInteractionFragmentWithSubfragmentsShape(InteractionFragmentWithSubfragmentsShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Interaction Fragment Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Interaction Fragment Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInteractionFragmentShape(InteractionFragmentShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Subfragment Compartment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Subfragment Compartment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubfragmentCompartment(SubfragmentCompartment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Interaction Fragment With Gates Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Interaction Fragment With Gates Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInteractionFragmentWithGatesShape(InteractionFragmentWithGatesShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Gate Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gate Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGateShape(GateShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Opaque Behavior Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Opaque Behavior Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOpaqueBehaviorShape(OpaqueBehaviorShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Function Behavior Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Function Behavior Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFunctionBehaviorShape(FunctionBehaviorShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>State Machine Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>State Machine Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStateMachineShape(StateMachineShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Base State Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Base State Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBaseStateShape(BaseStateShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pseudostate Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pseudostate Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePseudostateShape(PseudostateShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Region Compartment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Region Compartment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRegionCompartment(RegionCompartment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Protocol State Machine Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Protocol State Machine Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProtocolStateMachineShape(ProtocolStateMachineShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Deployment Specification Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Deployment Specification Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDeploymentSpecificationShape(DeploymentSpecificationShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Communication Path Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Communication Path Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCommunicationPathEdge(CommunicationPathEdge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Deployment Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Deployment Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDeploymentEdge(DeploymentEdge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Actor Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Actor Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActorShape(ActorShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Extension Point Compartment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Extension Point Compartment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExtensionPointCompartment(ExtensionPointCompartment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Use Case Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Use Case Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUseCaseShape(UseCaseShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Include Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Include Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIncludeEdge(IncludeEdge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Extend Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Extend Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExtendEdge(ExtendEdge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>State Machine Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>State Machine Diagram</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStateMachineDiagram(StateMachineDiagram object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Activity Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Activity Diagram</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActivityDiagram(ActivityDiagram object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sequence Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sequence Diagram</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSequenceDiagram(SequenceDiagram object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Interaction Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Interaction Diagram</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInteractionDiagram(InteractionDiagram object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Communication Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Communication Diagram</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCommunicationDiagram(CommunicationDiagram object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Timing Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Timing Diagram</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTimingDiagram(TimingDiagram object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Interaction Overview Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Interaction Overview Diagram</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInteractionOverviewDiagram(InteractionOverviewDiagram object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Internal Behavior Compartment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Internal Behavior Compartment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInternalBehaviorCompartment(InternalBehaviorCompartment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>State Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>State Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStateShape(StateShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Connection Point Reference Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Connection Point Reference Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConnectionPointReferenceShape(ConnectionPointReferenceShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Internal Transition Compartment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Internal Transition Compartment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInternalTransitionCompartment(InternalTransitionCompartment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Deferrable Trigger Compartment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Deferrable Trigger Compartment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDeferrableTriggerCompartment(DeferrableTriggerCompartment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Region Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Region Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRegionShape(RegionShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Transition Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Transition Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTransitionEdge(TransitionEdge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Activity Edge Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Activity Edge Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActivityEdgeEdge(ActivityEdgeEdge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Weight Label</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Weight Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWeightLabel(WeightLabel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Control Flow Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Control Flow Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseControlFlowEdge(ControlFlowEdge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Object Flow Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Object Flow Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseObjectFlowEdge(ObjectFlowEdge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Activity Group Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Activity Group Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActivityGroupShape(ActivityGroupShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Exception Handler Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Exception Handler Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExceptionHandlerEdge(ExceptionHandlerEdge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type Label</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypeLabel(TypeLabel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Icon Label</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Icon Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIconLabel(IconLabel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Activity Partition Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Activity Partition Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActivityPartitionShape(ActivityPartitionShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Expansion Region Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expansion Region Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpansionRegionShape(ExpansionRegionShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Expansion Node Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expansion Node Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpansionNodeShape(ExpansionNodeShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Lifeline Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Lifeline Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLifelineShape(LifelineShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Execution Specification Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Execution Specification Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExecutionSpecificationShape(ExecutionSpecificationShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Duration Constraint Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Duration Constraint Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDurationConstraintShape(DurationConstraintShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Time Constraint Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Time Constraint Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTimeConstraintShape(TimeConstraintShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Time Expression Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Time Expression Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTimeExpressionShape(TimeExpressionShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Duration Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Duration Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDurationShape(DurationShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Path Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Path Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePathEdge(PathEdge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Message Label</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Message Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMessageLabel(MessageLabel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>State Invariant Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>State Invariant Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStateInvariantShape(StateInvariantShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Message Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Message Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMessageEdge(MessageEdge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>General Ordering Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>General Ordering Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGeneralOrderingEdge(GeneralOrderingEdge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Combined Fragment Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Combined Fragment Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCombinedFragmentShape(CombinedFragmentShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Interaction Use Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Interaction Use Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInteractionUseShape(InteractionUseShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Interaction Operand Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Interaction Operand Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInteractionOperandShape(InteractionOperandShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Action Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Action Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActionShape(ActionShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pin Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pin Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePinShape(PinShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Subpartition Compartment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Subpartition Compartment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubpartitionCompartment(SubpartitionCompartment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Object Node Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Object Node Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseObjectNodeShape(ObjectNodeShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Selection Label</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Selection Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSelectionLabel(SelectionLabel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Transformation Label</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Transformation Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTransformationLabel(TransformationLabel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Guard Label</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Guard Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGuardLabel(GuardLabel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Activity Node Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Activity Node Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActivityNodeShape(ActivityNodeShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Subvertex Compartment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Subvertex Compartment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubvertexCompartment(SubvertexCompartment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Template Parameter Compartment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Template Parameter Compartment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTemplateParameterCompartment(TemplateParameterCompartment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>List Compartment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>List Compartment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseListCompartment(ListCompartment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>List Item Label</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>List Item Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseListItemLabel(ListItemLabel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Stereotype Label</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Stereotype Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStereotypeLabel(StereotypeLabel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Owned Use Case Compartment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Owned Use Case Compartment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOwnedUseCaseCompartment(OwnedUseCaseCompartment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Use Case Compartment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Use Case Compartment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUseCaseCompartment(UseCaseCompartment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Uml Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Uml Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUmlShape(UmlShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Main Label</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Main Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMainLabel(MainLabel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Diagram Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Diagram Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDiagramElement(DiagramElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseShape(Shape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Diagram</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDiagram(Diagram object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Style</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Style</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStyle(Style object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEdge(Edge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}
} //UMLDISwitch
