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
package org.eclipse.papyrus.req.reqif.transformation;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLFactory;
/**
 * This is a basic merger in order to add requirement from right to left
 * could be improved by using hashmap
 * This algorithm is n2
 *
 */
public class BasicRequirementMerger {

	protected Package leftPackage=null;
	protected Package rightPackage=null;
	protected String matchProperty=null;
	protected String changeableProperty=null;
	protected HashMap<String, Element> leftIndex= new HashMap<>(); 
	protected HashMap<String, Element> rightIndex= new HashMap<>(); 

	/**
	 * Merge information from version2 into version1
	 * 
	 * @param leftPackage
	 *            is the package where we will do the modifications
	 * @param rightPackage
	 *            is the package that we will analyze
	 * @param matchProperty
	 *            is the stereotype's property name used to determine if one
	 *            element in basePk is the same than other element in extPk. For
	 *            example, "id" is a good matchProperty when comparing SysML
	 *            Requirements
	 * @param changeableProperty
	 *            is the property that we will change if the value of
	 *            copyAllPropertyValues is false. For example "text".
	 * **/
	public BasicRequirementMerger(Package leftPackage, Package rightPackage, String matchProperty, String changeableProperty) {
		this.leftPackage=leftPackage;
		this.rightPackage=rightPackage;
		this.matchProperty=matchProperty;
		this.changeableProperty=changeableProperty;
	}

	/**
	 * 
	 *@param checkPackageName
	 *            is an option. true means that the matched packaged elements
	 *            must be in packages with the same name.
	 * @param copyAllPropertyValues
	 *            is an option. true means that the user wants to copy the name
	 *            and all the stereotype values. This option disables the
	 *            changeableProperty parameter.
	 * @param deleteFromBase 
	 * 	     is an option. True means that element that not match with right will be removed 
	 * @return true merge finishes successfully
	 */
	public boolean merge(boolean checkPackageName, boolean copyAllPropertyValues, boolean deleteFromBase) {
		boolean merged = false;
		merged = updateAndAddFromRight(leftPackage, rightPackage, matchProperty, changeableProperty, checkPackageName, copyAllPropertyValues);
		if (merged && deleteFromBase == I_RI.DELETE_FROM_BASE) {
			deleteInsideLeft( matchProperty, checkPackageName, leftPackage,rightPackage);
		}
		return true;
	}

	private boolean deleteInsideLeft(String matchProperty, boolean checkPackageName, Package basePk, Package extPk) {
		List<PackageableElement> delList = new ArrayList<PackageableElement>();
		delList = (getElementsToBeDeleted(basePk, extPk, matchProperty,
				checkPackageName, delList));
		return delList.isEmpty() ? false : confirmDelete( basePk,
				delList, matchProperty);
	}

	/**
	 * Prepare a list of Packageable Elements to be deleted from basePk
	 * 
	 * @param version1
	 *            is the package where we will try to find elements to be
	 *            deleted because they are not anymore in the extPk (which is a
	 *            version of basePk that evolved separately).
	 * @param version2
	 *            is the package where we will try to find elements that are not
	 *            in the basePk.
	 * @param matchProperty
	 *            is the stereotype's property name used to determine if one
	 *            element in basePk is the same than other element in extPk. For
	 *            example, "id" is a good matchProperty when comparing SysML
	 *            Requirements
	 * @param delList
	 *            empty list that will store the packageableElements to be
	 *            deleted.
	 * @return list of packageableElements to be deleted.
	 */
	private List<PackageableElement> getElementsToBeDeleted(
			org.eclipse.uml2.uml.Package version1,
			org.eclipse.uml2.uml.Package version2, String matchProperty,
			boolean checkPackageName, List<PackageableElement> delList) {

//		for (PackageableElement peInBasePk : version1.getPackagedElements()) {
//			if (peInBasePk instanceof org.eclipse.uml2.uml.Class
//					&& peInBasePk.getAppliedStereotypes().size() > 0) {
//				Stereotype stOfPeInBasePk = peInBasePk.getAppliedStereotypes()
//						.get(0);
//				boolean foundMatch = false;
//				foundMatch = matchStereotypedPackagedElements(version2,
//						peInBasePk, stOfPeInBasePk, matchProperty, null,
//						checkPackageName, !I_RI.PERFORM_CHANGES,
//						!I_RI.COPY_All_PROPERTY_VALUES);
//				if (!foundMatch) {
//					delList.add(peInBasePk);
//				}
//			} else if (peInBasePk instanceof Package) {
//				return getElementsToBeDeleted((Package) peInBasePk, version2,
//						matchProperty, checkPackageName, delList);
//			}
//		}
		return delList;
	}

	/**
	 * Confirm to delete or not a list of packageable elements 
	 * 
	 * @param window IWorkbenchWindow to receive the confirmation to delete the elements
	 * @param baseModel package or model where the elements in delList will be deleted
	 * @param delList list of elements to be deleted
	 * @param matchProperty
	 *            is the stereotype's property name used to determine if one
	 *            element in basePk is the same than other element in
	 *            externalPk. For example "id" when comparing SysML
	 *            Requirements.
	 * @return true if deletion finishes successfully
	 */
	private boolean confirmDelete(Package baseModel,
			List<PackageableElement> delList, String matchProperty) {
		StringBuffer humanReadableList = new StringBuffer();

		for (PackageableElement pe : delList) {
			humanReadableList.append("\n"
					+ matchProperty
					+ I_RI.TOOL_PROPERTY_SEPARATOR
					+ pe.getValue(pe.getAppliedStereotypes().get(0),
							matchProperty) + "\t"
							+ I_RI.PACKAGED_ELEMENT_NAME_ATT
							+ I_RI.TOOL_PROPERTY_SEPARATOR + pe.getName());
		}
		if (MessageDialog.openQuestion(new Shell(), I_RI.TOOL_TITLE,
				I_RI.TOOL_DEL_CONFIRM + humanReadableList)) {
			return deletePackagedElements(delList, baseModel, matchProperty);
		}
		return false;
	}

	/**
	 * Delete a list of packageable elements without any confirmation from the user
	 * 
	 * @param delList list of elements to be deleted
	 * @param basePk 
	 * @param matchProperty
	 * @return
	 */
	private boolean deletePackagedElements(List<PackageableElement> delList,
			Package basePk, String matchProperty) {
		for (Iterator<PackageableElement> elementsToDelete = delList.iterator(); elementsToDelete
				.hasNext();) {
			PackageableElement del = elementsToDelete.next();
			Stereotype stOfDel = del.getAppliedStereotypes().get(0);
			String matchInDel = (String) del.getValue(stOfDel, matchProperty);

			for (Iterator<PackageableElement> elementsInBasePk = basePk
					.getPackagedElements().iterator(); elementsInBasePk
					.hasNext();) {
				PackageableElement peInBasePk = elementsInBasePk.next();
				if (peInBasePk instanceof org.eclipse.uml2.uml.Class
						&& peInBasePk.getAppliedStereotypes().size() > 0) {
					Stereotype stOfmatchInBasePk = peInBasePk
							.getAppliedStereotypes().get(0);
					String matchInBasePk = (String) peInBasePk.getValue(
							stOfmatchInBasePk, matchProperty);
					if (matchInDel.trim().contentEquals(matchInBasePk.trim())) {
						peInBasePk.destroy();
						break;
					}
				} else if (peInBasePk instanceof Package) {
					return deletePackagedElements(delList,
							(Package) peInBasePk, matchProperty);
				}
			}
		}
		return true;
	}


	/**
	 * Merge information from version2 into version1
	 * 
	 * @param leftContainer
	 *            is the package where we will do the modifications
	 * @param rightContainer
	 *            is the package that we will analyze
	 * @param matchProperty
	 *            is the stereotype's property name used to determine if one
	 *            element in basePk is the same than other element in extPk. For
	 *            example, "id" is a good matchProperty when comparing SysML
	 *            Requirements
	 * @param changeableProperty
	 *            is the property that we will change if the value of
	 *            copyAllPropertyValues is false. For example "text".
	 * @param chkPkNameOption
	 *            is an option. true means that the matched packaged elements
	 *            must be in packages with the same name.
	 * @param copyOption
	 *            is an option. true means that the user wants to copy the name
	 *            and all the stereotype values. This option disables the
	 *            changeableProperty parameter.
	 * @return true merge finishes successfully
	 */
	private boolean updateAndAddFromRight(org.eclipse.uml2.uml.Element leftContainer, org.eclipse.uml2.uml.Element rightContainer, String matchProperty,
			String changeableProperty, boolean chkPkNameOption, boolean copyOption) {
		for (Element subElementFromRight : rightContainer.getOwnedElements()) {
			Element foundLeftElement = null;
			if (subElementFromRight.getAppliedStereotypes().size() > 0) {
				Stereotype appliedStereotypeFromRight= subElementFromRight.getAppliedStereotypes().get(0);
				
				foundLeftElement = matchStereotypedPackagedElements(leftContainer,subElementFromRight, appliedStereotypeFromRight, matchProperty,
						changeableProperty);
				if(foundLeftElement!=null){
					copyConfig(subElementFromRight, appliedStereotypeFromRight, changeableProperty,foundLeftElement, appliedStereotypeFromRight, copyOption);

				}
				else {
					foundLeftElement = addElementInsideLeft(leftContainer, subElementFromRight, appliedStereotypeFromRight);
				}
			}
			if (subElementFromRight.getOwnedElements().size()>0) {
				return updateAndAddFromRight(foundLeftElement,  subElementFromRight, matchProperty,	changeableProperty, chkPkNameOption, copyOption);
			} 
		}
		return true;
	}

	/**
	 * Add a packageable element from right to left
	 * 
	 * @param leftContainer
	 *            is the package where we will add new elements from rightPackage.
	 * @param elementFromRight
	 *            Packageable element in Right package.
	 * @param appliedSterotypeRight
	 *            stereotype of peInExtPk.
	 * @return createdElement
	 */
	private Element addElementInsideLeft(Element leftContainer,Element elementFromRight, Stereotype appliedSterotypeRight) {
		Element result= null;
		EObject stApplication_right = elementFromRight.getStereotypeApplication(appliedSterotypeRight);
		ArrayList<EObject> subsetToCopy=new ArrayList<EObject>();
		subsetToCopy.add(elementFromRight);
		subsetToCopy.add(elementFromRight.getStereotypeApplication(appliedSterotypeRight));
		Collection<EObject> copy=EcoreUtil.copyAll(subsetToCopy);
		for (EObject eObject : copy) {
			if( eObject instanceof Element){
				if( eObject instanceof Comment){
					(leftContainer).getOwnedComments().add((Comment) eObject);}
				else if( leftContainer instanceof Package && eObject instanceof PackageableElement ){
					((Package)leftContainer).getPackagedElements().add((PackageableElement) eObject);}
				else if( leftContainer instanceof Classifier && eObject instanceof Classifier){
					((Class)leftContainer).getNestedClassifiers().add((Classifier) eObject);}
				else{
					System.err.println("Impossible to add "+ eObject+ " inside"+ leftContainer);
				}
				result=(Element) eObject;
			}
			else{
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
	 *            Packageable element in external package.
	 * @param stOfExtPe
	 *            stereotype of peInExtPk.
	 * @param peInBasePk
	 *            Packageable element in base package that will receive the new
	 *            values from peInExtPk.
	 */
	private void copyAllStereotypePropertyValues(Element peInExtPk,
			Stereotype stOfExtPe, Element peInBasePk) {
		for (Property stProperty : stOfExtPe.getAllAttributes()) {
			if (!stProperty.isReadOnly() && !stProperty.isDerived()
					&& !stProperty.getName().startsWith("base_")) {
				peInBasePk.setValue(stOfExtPe, stProperty.getName(),
						peInExtPk.getValue(stOfExtPe, stProperty.getName()));
			}
		}
	}

	/**
	 * Matches two stereotyped packageable elements based on a matchProperty at the current level
	 * 
	 * @param containerLeft
	 *            is  the container where we look for elementRight
	 * @param elementRight
	 *            is the stereotyped PackagedElement to be matched. For example,
	 *            the packaged element of type "org.eclipse.uml2.uml.Class"
	 *            stereotyped with "ReqType5".
	 * @param appliedStereotypeRight
	 *            is the Stereotype that defines the matchProperty. For example,
	 *            the stereotype "ReqType5" defines the matchProperty "id".
	 * @param matchProperty
	 *            is the stereotype's property name used to determine if one
	 *            element in basePk matches other element in extPk. For example,
	 *            the stereotype "Requirement" in the profile SysML Requirements
	 *            defines the property "id" that is used frequently as a
	 *            matchProperty.
	 * @param changeableProperty
	 *            is the property whose value will be changed. For example the
	 *            property "text" in the stereotype "Requirement".
	 * @param checkPackageName
	 *            is an option. true means that the matched packaged elements
	 *            must be in packages with the same name.
	 * @param performChanges
	 *            is an option. true means that the user wants to actually
	 *            change the value of changeableProperty. false will disable the
	 *            copyAllPropertyValues option.

	 * @return the element that matches
	 */
	private Element matchStereotypedPackagedElements(Element containerLeft, Element elementRight,
			Stereotype appliedStereotypeRight, String matchProperty,String changeableProperty) {
		String matchPropertyValueRight = (String) elementRight.getValue(appliedStereotypeRight, matchProperty);
		if(matchPropertyValueRight!=null){
			for (Element subElementLeft : containerLeft.getOwnedElements()) {
				if (subElementLeft.getAppliedStereotypes().size() > 0) {
					Stereotype appliedStereotypeLeft = subElementLeft.getAppliedStereotypes().get(0);
					if (appliedStereotypeLeft.getName().equals(appliedStereotypeRight.getName())) {
						String matchPropertyValueLeft = (String) subElementLeft.getValue(appliedStereotypeLeft, matchProperty);
						if(matchPropertyValueLeft!=null){
							if (matchPropertyValueRight.trim().equals(matchPropertyValueLeft.trim())) {
								return subElementLeft;
							}
						}
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
	 *            is the packageable element in external package
	 * @param AppliedStereotypeRight
	 *            is the stereotype of peInExtPk
	 * @param changeableProperty
	 *            is the property to copy when the value of copyOption is false
	 * @param leftElement
	 *            is the stereotyped packageable element whose value(s) will be
	 *            modified.
	 * @param stOfPeInBasePk
	 *            is the stereotype of peInBasePk
	 * @param copyOption
	 *            is the copy option. true means to copy all the stereotype
	 *            property values. false means to copy only the property in the
	 *            parameter changeableProperty.
	 */
	private void copyConfig(Element rightElement, Stereotype AppliedStereotypeRight,
			String changeableProperty, Element leftElement,
			Stereotype appliedStereotype, boolean copyOption) {
		if (copyOption == I_RI.COPY_All_PROPERTY_VALUES) {
			if( leftElement instanceof NamedElement){
				((NamedElement)leftElement).setName(((NamedElement)rightElement).getName());
			}
			for (Stereotype st : leftElement.getAppliedStereotypes()) {
				copyAllStereotypePropertyValues(rightElement, st, leftElement);
			}
		} else if (copyOption != I_RI.COPY_All_PROPERTY_VALUES) {
			leftElement.setValue(appliedStereotype, changeableProperty,
					rightElement.getValue(AppliedStereotypeRight, changeableProperty));
		}
	}

}
