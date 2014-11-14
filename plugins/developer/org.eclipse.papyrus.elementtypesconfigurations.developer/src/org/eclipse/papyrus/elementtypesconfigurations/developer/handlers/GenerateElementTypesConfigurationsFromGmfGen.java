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
import java.util.Collections;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gmf.codegen.gmfgen.FeatureLinkModelFacet;
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase;
import org.eclipse.gmf.codegen.gmfgen.TypeModelFacet;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.elementtypesconfigurations.developer.Activator;
import org.eclipse.papyrus.elementtypesconfigurations.developer.utils.ElementTypeConfigurationComparator;
import org.eclipse.papyrus.elementtypesconfigurations.developer.utils.GenerateElementTypesConfigurationsUtils;
import org.eclipse.papyrus.infra.elementtypesconfigurations.ContainerConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.ElementTypeSetConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.ElementtypesconfigurationsFactory;
import org.eclipse.papyrus.infra.elementtypesconfigurations.IconEntry;
import org.eclipse.papyrus.infra.elementtypesconfigurations.SpecializationTypeConfiguration;
import org.eclipse.ui.handlers.HandlerUtil;


public class GenerateElementTypesConfigurationsFromGmfGen extends AbstractHandler {




	public GenerateElementTypesConfigurationsFromGmfGen() {
	}

	public Object execute(ExecutionEvent event) throws ExecutionException {
		ResourceSet resourceSet = new ResourceSetImpl();
		ISelection currentSelection = HandlerUtil.getCurrentSelection(event);
		if (!(currentSelection instanceof IStructuredSelection) || currentSelection.isEmpty()) {
			return null;
		}

		final IStructuredSelection selection = (IStructuredSelection) currentSelection;
		Object selectedElement = selection.getFirstElement();

		if (selectedElement instanceof IFile) {

			String selectedFilePath = ((IFile) selectedElement).getFullPath().toString();


			Resource inputResource = resourceSet.getResource(URI.createURI(selectedFilePath), true);
			Resource outputResource = resourceSet.createResource(URI.createURI(selectedFilePath + ".elementtypesconfigurations"));
			ElementTypeSetConfiguration elementTypeSetConfiguration = generateElementTypeSetConfiguration(inputResource);


			outputResource.getContents().add(elementTypeSetConfiguration);

			ECollections.sort(((ElementTypeSetConfiguration) outputResource.getContents().get(0)).getElementTypeConfigurations(), new ElementTypeConfigurationComparator());

			try {
				outputResource.save(Collections.EMPTY_MAP);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	protected ElementTypeSetConfiguration generateElementTypeSetConfiguration(Resource inputResource) {
		ElementTypeSetConfiguration elementTypeSetConfiguration = ElementtypesconfigurationsFactory.eINSTANCE.createElementTypeSetConfiguration();

		TreeIterator<EObject> it = inputResource.getAllContents();
		while (it.hasNext()) {
			EObject eObject = (EObject) it.next();
			if (eObject instanceof TypeModelFacet) {
				TypeModelFacet typeModelFacet = (TypeModelFacet) eObject;



				EClass eClass = typeModelFacet.getMetaClass().getEcoreClass();
				if (eClass == null)
				{
					Activator.log.info("EClass not defined for: " + typeModelFacet.eContainer());
				} else {

					SpecializationTypeConfiguration specializationTypeConfiguration = ElementtypesconfigurationsFactory.eINSTANCE.createSpecializationTypeConfiguration();

					specializationTypeConfiguration.setIdentifier(((GenCommonBase) typeModelFacet.eContainer()).getElementType().getUniqueIdentifier());
					specializationTypeConfiguration.setHint("" + ((GenCommonBase) typeModelFacet.eContainer()).getVisualID());
					specializationTypeConfiguration.setName(specializationTypeConfiguration.getIdentifier());

					specializationTypeConfiguration.setKind("org.eclipse.gmf.runtime.emf.type.core.IHintedType");

					EReference containmentEReference = null;
					if (typeModelFacet.getContainmentMetaFeature() != null) {
						EStructuralFeature feature = typeModelFacet.getContainmentMetaFeature().getEcoreFeature();
						if (feature instanceof EReference) {
							containmentEReference = (EReference) feature;
						}
					}
					if (containmentEReference != null) {
						specializationTypeConfiguration.getSpecializedTypesID().add(GenerateElementTypesConfigurationsUtils.findSpecializedTypesIDs(eClass, containmentEReference));

						if (GenerateElementTypesConfigurationsUtils.isSpecializedASpecialization(eClass, containmentEReference)) {

							ContainerConfiguration containerConfiguration = ElementtypesconfigurationsFactory.eINSTANCE.createContainerConfiguration();
							containerConfiguration.getEContainmentFeatures().add(containmentEReference);
							specializationTypeConfiguration.setContainerConfiguration(containerConfiguration);
						}
					}

					IconEntry iconEntryForSpecialization = ElementtypesconfigurationsFactory.eINSTANCE.createIconEntry();
					iconEntryForSpecialization.setBundleId("org.eclipse.uml2.uml.edit");
					iconEntryForSpecialization.setIconPath("/icons/full/obj16/" + eClass.getName() + ".gif");

					specializationTypeConfiguration.setIconEntry(iconEntryForSpecialization);

					elementTypeSetConfiguration.getElementTypeConfigurations().add(specializationTypeConfiguration);
				}

			} else if (eObject instanceof FeatureLinkModelFacet) {
				FeatureLinkModelFacet featureLinkModelFacet = (FeatureLinkModelFacet) eObject;

				SpecializationTypeConfiguration specializationTypeConfiguration = ElementtypesconfigurationsFactory.eINSTANCE.createSpecializationTypeConfiguration();

				specializationTypeConfiguration.setIdentifier(((GenCommonBase) featureLinkModelFacet.eContainer()).getElementType().getUniqueIdentifier());
				specializationTypeConfiguration.setHint("" + ((GenCommonBase) featureLinkModelFacet.eContainer()).getVisualID());
				specializationTypeConfiguration.setName(specializationTypeConfiguration.getIdentifier());

				specializationTypeConfiguration.setKind("org.eclipse.gmf.runtime.emf.type.core.IHintedType");

				specializationTypeConfiguration.getSpecializedTypesID().add("org.eclipse.gmf.runtime.emf.type.core.null");

				elementTypeSetConfiguration.getElementTypeConfigurations().add(specializationTypeConfiguration);

			}
		}

		return elementTypeSetConfiguration;
	}

}
