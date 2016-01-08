/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.elementtypesconfigurations.developer.handlers;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.elementtypesconfigurations.developer.utils.ElementTypeConfigurationComparator;
import org.eclipse.papyrus.elementtypesconfigurations.developer.utils.GenerateElementTypesConfigurationsUtils;
import org.eclipse.papyrus.infra.elementtypesconfigurations.ContainerConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.ElementTypeConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.ElementTypeSetConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.ElementtypesconfigurationsFactory;
import org.eclipse.papyrus.infra.elementtypesconfigurations.IconEntry;
import org.eclipse.papyrus.infra.elementtypesconfigurations.MetamodelTypeConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.SpecializationTypeConfiguration;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.uml2.uml.UMLPackage;

public class GenerateElementTypesConfigurations extends AbstractHandler {


	public Object execute(ExecutionEvent event) throws ExecutionException {
		ResourceSet resourceSet = new ResourceSetImpl();
		ISelection currentSelection = HandlerUtil.getCurrentSelection(event);
		if (!(currentSelection instanceof IStructuredSelection) || currentSelection.isEmpty()) {
			return null;
		}

		final IStructuredSelection selection = (IStructuredSelection) currentSelection;
		Object selectedElement = selection.getFirstElement();

		if (selectedElement instanceof IFolder) {
			IFolder selectedFolder = (IFolder) selectedElement;
			String selectedFolderPath = selectedFolder.getFullPath().toString();

			ElementTypeSetConfiguration elementTypeSetConfiguration = ElementtypesconfigurationsFactory.eINSTANCE.createElementTypeSetConfiguration();
			elementTypeSetConfiguration.setMetamodelNsURI(UMLPackage.eNS_URI);
			createElementTypesConfigurationsModel(UMLPackage.eINSTANCE, elementTypeSetConfiguration);

			Resource outputResource = resourceSet.createResource(URI.createURI(selectedFolderPath + "/" + "output.elementtypesconfigurations"));
			outputResource.getContents().add(elementTypeSetConfiguration);
			try {
				outputResource.save(Collections.EMPTY_MAP);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (selectedElement instanceof IFile) {
			if ("elementtypesconfigurations".equals(((IFile) selectedElement).getFileExtension())) {
				String selectedFilePath = ((IFile) selectedElement).getFullPath().toString();

				Resource outputResource = resourceSet.getResource(URI.createURI(selectedFilePath), true);
				createElementTypesConfigurationsModel(UMLPackage.eINSTANCE, (ElementTypeSetConfiguration) outputResource.getContents().get(0));

				ECollections.sort(((ElementTypeSetConfiguration) outputResource.getContents().get(0)).getElementTypeConfigurations(), new ElementTypeConfigurationComparator());

				try {
					outputResource.save(Collections.EMPTY_MAP);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		return null;
	}



	protected void createElementTypesConfigurationsModel(EPackage ePackage, ElementTypeSetConfiguration elementTypeSetConfiguration) {

		Collection<EClass> eClasses = GenerateElementTypesConfigurationsUtils.getAllEClass(ePackage);


		// Create metamodelTypes
		for (EClass eClass : eClasses) {
			if (!containsElementType(GenerateElementTypesConfigurationsUtils.getIdentifier(eClass), elementTypeSetConfiguration)) {
				MetamodelTypeConfiguration metamodelTypeConfiguration = createMetamodelTypeConfiguration(eClass);
				elementTypeSetConfiguration.getElementTypeConfigurations().add(metamodelTypeConfiguration);
			}


			// Create Specializations
			if (!eClass.isAbstract()) {

				// get all features for containments
				Collection<EReference> possibleContainmentsEReference = GenerateElementTypesConfigurationsUtils.findPossibleContainmentsEReference(eClass, eClasses);
				for (EReference containmentEReference : possibleContainmentsEReference) {
					Collection<EReference> ambiguousContainments = GenerateElementTypesConfigurationsUtils.findAmbiguousContainments(containmentEReference, possibleContainmentsEReference);
					if (!ambiguousContainments.isEmpty()) {

						if (!containsElementType(GenerateElementTypesConfigurationsUtils.getIdentifier(eClass) + GenerateElementTypesConfigurationsUtils.getAsName(containmentEReference, containmentEReference.getEContainingClass()),
								elementTypeSetConfiguration)) {
							SpecializationTypeConfiguration specializationTypeConfiguration = createSpecializationTypeConfiguration(eClass, containmentEReference,
									GenerateElementTypesConfigurationsUtils.getAsName(containmentEReference, containmentEReference.getEContainingClass()));

							elementTypeSetConfiguration.getElementTypeConfigurations().add(specializationTypeConfiguration);
						}

						// Add ambiguous containments
						for (EReference ambiguousEReference : ambiguousContainments) {
							if (!containsElementType(GenerateElementTypesConfigurationsUtils.getIdentifier(eClass) + GenerateElementTypesConfigurationsUtils.getAsName(ambiguousEReference, containmentEReference.getEContainingClass()),
									elementTypeSetConfiguration)) {
								SpecializationTypeConfiguration ambiguousSpecializationTypeConfiguration = createSpecializationTypeConfiguration(eClass, ambiguousEReference,
										GenerateElementTypesConfigurationsUtils.getAsName(ambiguousEReference, containmentEReference.getEContainingClass()));
								elementTypeSetConfiguration.getElementTypeConfigurations().add(ambiguousSpecializationTypeConfiguration);
							}
						}
					}
				}
			}
		}

	}

	protected MetamodelTypeConfiguration createMetamodelTypeConfiguration(EClass eClass) {
		MetamodelTypeConfiguration metamodelTypeConfiguration = ElementtypesconfigurationsFactory.eINSTANCE.createMetamodelTypeConfiguration();
		metamodelTypeConfiguration.setEClass(eClass);
		metamodelTypeConfiguration.setIdentifier(GenerateElementTypesConfigurationsUtils.getIdentifier(eClass));
		metamodelTypeConfiguration.setHint(metamodelTypeConfiguration.getIdentifier());
		metamodelTypeConfiguration.setName(((ENamedElement) eClass.eContainer()).getName().toUpperCase() + "::" + eClass.getName());
		metamodelTypeConfiguration.setKind("org.eclipse.gmf.runtime.emf.type.core.IHintedType");
		metamodelTypeConfiguration.setEditHelperClassName("org.eclipse.papyrus.infra.gmfdiag.common.helper.DefaultEditHelper");

		IconEntry iconEntry = ElementtypesconfigurationsFactory.eINSTANCE.createIconEntry();
		iconEntry.setBundleId("org.eclipse.uml2.uml.edit");
		iconEntry.setIconPath("/icons/full/obj16/" + eClass.getName() + ".gif");

		metamodelTypeConfiguration.setIconEntry(iconEntry);

		return metamodelTypeConfiguration;
	}

	protected SpecializationTypeConfiguration createSpecializationTypeConfiguration(EClass eClass, EReference containmentEReference, String asName) {
		SpecializationTypeConfiguration specializationTypeConfiguration = ElementtypesconfigurationsFactory.eINSTANCE.createSpecializationTypeConfiguration();

		specializationTypeConfiguration.setIdentifier(GenerateElementTypesConfigurationsUtils.getIdentifier(eClass) + asName);
		specializationTypeConfiguration.setHint(specializationTypeConfiguration.getIdentifier());
		specializationTypeConfiguration.setName(((ENamedElement) eClass.eContainer()).getName().toUpperCase() + "::" + eClass.getName() + asName);
		specializationTypeConfiguration.setKind("org.eclipse.gmf.runtime.emf.type.core.IHintedType");
		specializationTypeConfiguration.getSpecializedTypesID().add(GenerateElementTypesConfigurationsUtils.getIdentifier(eClass));

		ContainerConfiguration containerConfiguration = ElementtypesconfigurationsFactory.eINSTANCE.createContainerConfiguration();
		containerConfiguration.getEContainmentFeatures().add(containmentEReference);
		specializationTypeConfiguration.setContainerConfiguration(containerConfiguration);

		IconEntry iconEntryForSpecialization = ElementtypesconfigurationsFactory.eINSTANCE.createIconEntry();
		iconEntryForSpecialization.setBundleId("org.eclipse.uml2.uml.edit");
		iconEntryForSpecialization.setIconPath("/icons/full/obj16/" + eClass.getName() + ".gif");

		specializationTypeConfiguration.setIconEntry(iconEntryForSpecialization);

		return specializationTypeConfiguration;
	}

	protected boolean containsElementType(String identifier, ElementTypeSetConfiguration elementTypeSetConfiguration) {
		for (ElementTypeConfiguration elementTypeConfiguration : elementTypeSetConfiguration.getElementTypeConfigurations()) {
			if (elementTypeConfiguration.getIdentifier().equals(identifier)) {
				return true;
			}
		}
		return false;
	}


}
