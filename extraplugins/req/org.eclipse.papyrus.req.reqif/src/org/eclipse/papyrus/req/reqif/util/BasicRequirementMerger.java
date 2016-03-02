/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Mauricio Alferez (CEA LIST) mauricio.alferez@cea.fr - Initial API and implementation
 *  Patrick Tessier (CEA LIST) patrick.tesseir@cea.fr- modification
 *
 *****************************************************************************/
package org.eclipse.papyrus.req.reqif.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;

/**
 * This is a basic merger in order to add requirement from right to left
 * could be improved by using hashmap
 * This algorithm is n2
 *
 */
public class BasicRequirementMerger implements IRequirementMerger {

	protected Package leftPackage = null;

	protected Package rightPackage = null;

	protected String matchProperty = null;

	protected String changeableProperty = null;

	protected EqualityHelperWithoutContainment equalityHelper = new EqualityHelperWithoutContainment();

	protected CopierWithoutContainment copier = new CopierWithoutContainment();

	protected TransactionalEditingDomain domain;

	protected ArrayList<Element> elementToDelete = new ArrayList<Element>();

	protected ArrayList<Element> addedElements = new ArrayList<Element>();

	protected boolean deleteElements = true;

	protected HashSet<Element> modifiedElement = new HashSet<Element>();

	@Override
	public HashSet<Element> getModifiedElement() {
		return modifiedElement;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.req.reqif.transformation.IRequirementMerger#getElementToDelete()
	 */
	@Override
	public ArrayList<Element> getElementToDelete() {
		return elementToDelete;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.req.reqif.transformation.IRequirementMerger#getAddedElements()
	 */
	@Override
	public ArrayList<Element> getAddedElements() {
		return addedElements;
	}

	/**
	 * Merge information from version2 into version1
	 * 
	 * @param leftPackage
	 *        is the package where we will do the modifications
	 * @param rightPackage
	 *        is the package that we will analyze
	 * @param matchProperty
	 *        is the stereotype's property name used to determine if one
	 *        element in basePk is the same than other element in extPk. For
	 *        example, "id" is a good matchProperty when comparing SysML
	 *        Requirements
	 * @param changeableProperty
	 *        is the property that we will change if the value of
	 *        copyAllPropertyValues is false. For example "text".
	 **/
	public BasicRequirementMerger(Package leftPackage, Package rightPackage, String matchProperty, boolean deleteElements, TransactionalEditingDomain domain) {
		this.leftPackage = leftPackage;
		this.rightPackage = rightPackage;
		this.matchProperty = matchProperty;
		this.domain = domain;
		this.deleteElements = deleteElements;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.req.reqif.transformation.IRequirementMerger#merge()
	 */
	@Override
	public boolean merge() {
		boolean merged = false;
		equalityHelper = new EqualityHelperWithoutContainment();
		merged = updateAndAddFromRight(leftPackage, rightPackage, matchProperty);
		equalityHelper = new EqualityHelperWithoutContainment();
		if(merged) {
			deleteInsideLeft(matchProperty, leftPackage, rightPackage);
		}
		return true;
	}

	/**
	 * 
	 * @param matchProperty
	 *        the property if stereotype used to delete element
	 * @param checkPackageName
	 * @param leftPackage
	 *        the package where element will be removed
	 * @param rightPackage
	 *        the package that will be compared
	 */
	protected void deleteInsideLeft(String matchProperty, Package leftPackage, Package rightPackage) {
		elementToDelete = getElementsToBeDeleted(leftPackage, rightPackage, matchProperty, elementToDelete);
		filterReq(matchProperty);
		if(deleteElements) {
			deleteElements(elementToDelete, leftPackage);
		}
	}

	/**
	 * filter elements that has an ID property
	 * 
	 * @param matchProperty
	 */
	protected void filterReq(String matchProperty) {
		ArrayList<Element> result = new ArrayList<Element>();
		for(Element elementToDelete : elementToDelete) {
			if(elementToDelete.getAppliedStereotypes().size() > 0) {
				Stereotype appliedStereotype = elementToDelete.getAppliedStereotypes().get(0);
				if((elementToDelete.getStereotypeApplication(appliedStereotype)).eClass().getEStructuralFeature(matchProperty) != null) {
					String idValue = (String)elementToDelete.getValue(appliedStereotype, matchProperty);
					if(idValue != null) {
						result.add(elementToDelete);
					}
				}
			}
		}
		elementToDelete = result;
	}

	/**
	 * Prepare a list of Packageable Elements to be deleted from basePk
	 * 
	 * @param version1
	 *        is the package where we will try to find elements to be
	 *        deleted because they are not anymore in the extPk (which is a
	 *        version of basePk that evolved separately).
	 * @param version2
	 *        is the package where we will try to find elements that are not
	 *        in the basePk.
	 * @param matchProperty
	 *        is the stereotype's property name used to determine if one
	 *        element in basePk is the same than other element in extPk. For
	 *        example, "id" is a good matchProperty when comparing SysML
	 *        Requirements
	 * @param delList
	 *        empty list that will store the packageableElements to be
	 *        deleted.
	 * @return list of packageableElements to be deleted.
	 */
	protected ArrayList<Element> getElementsToBeDeleted(Element containerLeft, Element containerRight, String matchProperty, ArrayList<Element> delList) {
		for(Element elementLeft : containerLeft.getOwnedElements()) {
			Element foundRightElement = null;
			foundRightElement = lookforEquivalent(containerRight, elementLeft, matchProperty);
			if(foundRightElement == null) {
				delList.add(elementLeft);
			}
			if(elementLeft.getOwnedElements().size() > 0 && foundRightElement != null) {
				getElementsToBeDeleted(elementLeft, foundRightElement, matchProperty, delList);
			}
		}
		return delList;
	}

	/**
	 * Delete a list of packageable elements without any confirmation from the user
	 * 
	 * @param delList
	 *        list of elements to be deleted
	 * @param basePk
	 *        the container of all element it can be indirect.
	 * @param matchProperty
	 * @return true if no problems
	 */
	public boolean deleteElements(List<Element> delList, Package basePk) {
		IElementEditService provider = ElementEditServiceUtils.getCommandProvider(basePk);
		if(provider == null) {
			return false;
		}
		for(Element elementToDelete : delList) {
			if(elementToDelete != null) {
				ICommand createGMFCommand = provider.getEditCommand(new DestroyElementRequest(domain, elementToDelete, false));
				if(createGMFCommand != null) {
					Command emfCommand = new org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper(createGMFCommand);
					domain.getCommandStack().execute(emfCommand);
				}
			}
		}
		return true;
	}

	/**
	 * Merge information from right into left
	 * 
	 * @param leftContainer
	 *        is the package where we will do the modifications
	 * @param rightContainer
	 *        is the package that we will analyze
	 * @param matchProperty
	 *        is the stereotype's property name used to determine if one
	 *        element in basePk is the same than other element in extPk. For
	 *        example, "id" is a good matchProperty when comparing SysML
	 *        Requirements
	 * @param changeableProperty
	 *        is the property that we will change if the value of
	 *        copyAllPropertyValues is false. For example "text".
	 * @param copyOption
	 *        is an option. true means that the user wants to copy the name
	 *        and all the stereotype values. This option disables the
	 *        changeableProperty parameter.
	 * @return true merge finishes successfully
	 */
	protected boolean updateAndAddFromRight(org.eclipse.uml2.uml.Element leftContainer, org.eclipse.uml2.uml.Element rightContainer, String matchProperty) {
		for(Element subElementFromRight : rightContainer.getOwnedElements()) {
			Element foundLeftElement = null;
			foundLeftElement = lookforEquivalent(leftContainer, subElementFromRight, matchProperty);
			if(foundLeftElement != null) {
				copyConfig(subElementFromRight, foundLeftElement);
			} else {
				foundLeftElement = addElementInsideLeft(leftContainer, subElementFromRight);
			}
			if(subElementFromRight.getOwnedElements().size() > 0) {
				updateAndAddFromRight(foundLeftElement, subElementFromRight, matchProperty);
			}
		}
		return true;
	}

	/**
	 * Add an element from right to left
	 * 
	 * @param leftContainer
	 *        is the package where we will add new elements from rightPackage.
	 * @param elementFromRight
	 *        element in Right package.
	 * @param appliedSterotypeRight
	 *        stereotype of peInExtPk.
	 * @return createdElement
	 */
	protected Element addElementInsideLeft(Element leftContainer, Element elementFromRight) {
		Element result = null;
		ArrayList<EObject> subsetToCopy = new ArrayList<EObject>();
		subsetToCopy.add(elementFromRight);
		for(EObject stereoAppli : elementFromRight.getStereotypeApplications()) {
			subsetToCopy.add(stereoAppli);
		}
		Collection<EObject> copy = copier.copyAll(subsetToCopy);
		copier.copyReferences();
		for(EObject eObject : copy) {
			if(eObject instanceof Element) {
				if(eObject instanceof Comment) {
					addedElements.add((Element)eObject);
					(leftContainer).getOwnedComments().add((Comment)eObject);
				} else if(leftContainer instanceof Package && eObject instanceof PackageableElement) {
					addedElements.add((Element)eObject);
					((Package)leftContainer).getPackagedElements().add((PackageableElement)eObject);
				} else if(leftContainer instanceof Classifier && eObject instanceof Classifier) {
					addedElements.add((Element)eObject);
					((Class)leftContainer).getNestedClassifiers().add((Classifier)eObject);
				} else {
					System.err.println("Impossible to add " + eObject + " inside" + leftContainer);
				}
				result = (Element)eObject;
			} else {
				leftContainer.eResource().getContents().add(eObject);
			}
		}
		return result;
	}

	/**
	 * Copy all not derived stereotype property values without changing the base
	 * class
	 * 
	 * @param peInExtPk
	 *        Packageable element in external package.
	 * @param stOfExtPe
	 *        stereotype of peInExtPk.
	 * @param peInBasePk
	 *        Packageable element in base package that will receive the new
	 *        values from peInExtPk.
	 */
	protected void copyAllStereotypePropertyValues(Element peInExtPk, Stereotype stOfExtPe, Element peInBasePk) {
		for(Property stProperty : stOfExtPe.getAllAttributes()) {
			if(!stProperty.isReadOnly() && !stProperty.isDerived() && !stProperty.getName().startsWith("base_")) {
				if(peInBasePk.getValue(stOfExtPe, stProperty.getName()) != null) {
					if(!(peInBasePk.getValue(stOfExtPe, stProperty.getName()).equals(peInExtPk.getValue(stOfExtPe, stProperty.getName())))) {
						modifiedElement.add(peInBasePk);
						peInBasePk.setValue(stOfExtPe, stProperty.getName(), peInExtPk.getValue(stOfExtPe, stProperty.getName()));
					}
				} else if(peInExtPk.getValue(stOfExtPe, stProperty.getName()) != null) {
					if(!(peInExtPk.getValue(stOfExtPe, stProperty.getName()).equals(peInBasePk.getValue(stOfExtPe, stProperty.getName())))) {
						modifiedElement.add(peInBasePk);
						peInBasePk.setValue(stOfExtPe, stProperty.getName(), peInExtPk.getValue(stOfExtPe, stProperty.getName()));
					}
				}
			}
		}
	}

	/**
	 * Matches two stereotyped packageable elements based on a matchProperty at the current level
	 * 
	 * @param researchSpace
	 *        is the container where we look for elementRight
	 * @param wantedElement
	 *        is the stereotyped PackagedElement to be matched. For example,
	 *        the packaged element of type "org.eclipse.uml2.uml.Class"
	 *        stereotyped with "ReqType5".
	 * @param matchProperty
	 *        is the stereotype's property name used to determine if one
	 *        element in basePk matches other element in extPk. For example,
	 *        the stereotype "Requirement" in the profile SysML Requirements
	 *        defines the property "id" that is used frequently as a
	 *        matchProperty.
	 * 
	 * @return the element that matches
	 */
	protected Element lookforEquivalent(Element researchSpace, Element wantedElement, String matchProperty) {
		for(Element potentialElement : researchSpace.getOwnedElements()) {
			if(equalityHelper.equals(potentialElement, wantedElement)) {
				if(wantedElement.getAppliedStereotypes().size() == 0) {
					return potentialElement;
				}
				//they have a stereotype
				Stereotype wantedAppliedStereotype = wantedElement.getAppliedStereotypes().get(0);
				//have they the same applied stereotype?
				if(!potentialElement.isStereotypeApplied(wantedAppliedStereotype)) {
					return null;
				}
				String wantedPropertyValue = null;
				String potentialPropertyValueLeft = null;
				if((wantedElement.getStereotypeApplication(wantedAppliedStereotype)).eClass().getEStructuralFeature(matchProperty) != null) {
					wantedPropertyValue = (String)wantedElement.getValue(wantedAppliedStereotype, matchProperty);
				}
				if((potentialElement.getStereotypeApplication(wantedAppliedStereotype)).eClass().getEStructuralFeature(matchProperty) != null) {
					potentialPropertyValueLeft = (String)potentialElement.getValue(wantedAppliedStereotype, matchProperty);
				}
				if(potentialPropertyValueLeft == null && wantedPropertyValue == null) {
					return potentialElement;
				}
				if(potentialPropertyValueLeft != null && wantedPropertyValue != null) {
					if(wantedPropertyValue.trim().equals(potentialPropertyValueLeft.trim())) {
						return potentialElement;
					}
				}
			}
		}
		return null;
	}

	/**
	 * Copy the name of an element and either one or all stereotype property
	 * values depending on the parameter copyOption
	 * 
	 * @param rightElement
	 *        is the packageable element in external package
	 * @param leftElement
	 *        is the stereotyped packageable element whose value(s) will be
	 *        modified.
	 */
	protected void copyConfig(Element rightElement, Element leftElement) {
		if(leftElement instanceof NamedElement) {
			((NamedElement)leftElement).setName(((NamedElement)rightElement).getName());
		}
		for(Stereotype st : leftElement.getAppliedStereotypes()) {
			copyAllStereotypePropertyValues(rightElement, st, leftElement);
		}
	}
}
