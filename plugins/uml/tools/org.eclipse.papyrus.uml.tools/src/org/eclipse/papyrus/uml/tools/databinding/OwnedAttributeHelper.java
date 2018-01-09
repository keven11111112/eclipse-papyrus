/*****************************************************************************
 * Copyright (c) 2014 CEA LIST and others.
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

package org.eclipse.papyrus.uml.tools.databinding;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.uml.tools.Activator;
import org.eclipse.uml2.uml.Artifact;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.StructuredClassifier;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;

public class OwnedAttributeHelper {

	public static EStructuralFeature getFeatureForType(Type type) {
		if (type instanceof StructuredClassifier) {
			return UMLPackage.eINSTANCE.getStructuredClassifier_OwnedAttribute();
		}
		if (type instanceof Interface) {
			return UMLPackage.eINSTANCE.getInterface_OwnedAttribute();
		}
		if (type instanceof DataType) {
			return UMLPackage.eINSTANCE.getDataType_OwnedAttribute();
		}
		if (type instanceof Artifact) {
			return UMLPackage.eINSTANCE.getArtifact_OwnedAttribute();
		}
		if (type instanceof Signal) {
			return UMLPackage.eINSTANCE.getSignal_OwnedAttribute();
		}

		// Unknown type : we try to find the feature reflexively
		Activator.log.warn("Unknown type : " + type.eClass().getName());
		EStructuralFeature feature = type.eClass().getEStructuralFeature("ownedAttribute"); //$NON-NLS-1$
		if (feature == null) {
			Activator.log.warn("Cannot find a valid feature for type " + type.eClass().getName());
		}
		return feature;
	}
	
	public static ICommand getSetTypeOwnerForAssociationAttributeCommand(Association association, Property memberEnd) {
		ICommand command = null;
		Type ownerType;
		List<Type> ownerList = association.getEndTypes();

		if (ownerList.get(0).equals(memberEnd.getType()) && ownerList.size() > 1) {
			ownerType = ownerList.get(1);
		} else {
			ownerType = ownerList.get(0);
		}

		EStructuralFeature ownedAttributeFeature = getFeatureForType(ownerType);
		if (ownedAttributeFeature != null) {

			List<Property> attributeList = new ArrayList<Property>();
			attributeList.addAll((EList<Property>) ownerType.eGet(ownedAttributeFeature));
			attributeList.add(memberEnd);

			IElementEditService provider = ElementEditServiceUtils.getCommandProvider(ownerType);
			if (provider != null) {
				SetRequest request = new SetRequest(ownerType, ownedAttributeFeature, memberEnd);

				command = provider.getEditCommand(request);
			}
		}
		return command;
	}
}
