/*****************************************************************************
 * Copyright (c) 2014, 2015 CEA LIST, Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *  Christian W. Damus - bug 451230
 *
 *****************************************************************************/
package org.eclipse.papyrus.elementtypesconfigurations.developer.handlers;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.codegen.gmfgen.FeatureLinkModelFacet;
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.codegen.gmfgen.NotationType;
import org.eclipse.gmf.codegen.gmfgen.TypeModelFacet;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.elementtypesconfigurations.developer.Activator;
import org.eclipse.papyrus.elementtypesconfigurations.developer.utils.ElementTypeConfigurationComparator;
import org.eclipse.papyrus.elementtypesconfigurations.developer.utils.GenerateElementTypesConfigurationsUtils;
import org.eclipse.papyrus.infra.elementtypesconfigurations.ContainerConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.ElementTypeConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.ElementTypeSetConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.ElementtypesconfigurationsFactory;
import org.eclipse.papyrus.infra.elementtypesconfigurations.ElementtypesconfigurationsPackage;
import org.eclipse.papyrus.infra.elementtypesconfigurations.IconEntry;
import org.eclipse.papyrus.infra.elementtypesconfigurations.SpecializationTypeConfiguration;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Strings;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;


public class GenerateElementTypesConfigurationsFromGmfGen extends AbstractHandler {




	public GenerateElementTypesConfigurationsFromGmfGen() {
	}

	@Override
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

			/*
			 * Generate the semantic types.
			 */
			Resource inputResource = resourceSet.getResource(URI.createPlatformResourceURI(selectedFilePath, true), true);
			String outputFilePath = ((IFile) selectedElement).getFullPath().removeFileExtension().toString();
			URI outputURI = URI.createURI(outputFilePath + ".elementtypesconfigurations");
			Resource outputResource;
			if (resourceSet.getURIConverter().exists(outputURI, null)) {
				// We'll merge with the existing model
				outputResource = resourceSet.getResource(outputURI, true);
			} else {
				// Generate a new model
				outputResource = resourceSet.createResource(outputURI);
			}
			ElementTypeSetConfiguration elementTypeSetConfiguration = generateElementTypeSetConfiguration(inputResource, outputResource);

			/*
			 * Generate the notation types.
			 */
			URI outputNotationURI = URI.createURI(outputFilePath + "-notation.elementtypesconfigurations");
			Resource outputNotationResource;
			if (resourceSet.getURIConverter().exists(outputNotationURI, null)) {
				// We'll merge with the existing model
				outputNotationResource = resourceSet.getResource(outputNotationURI, true);
			} else {
				// Generate a new model
				outputNotationResource = resourceSet.createResource(outputNotationURI);
			}
			ElementTypeSetConfiguration elementTypeSetConfigurationNotation = generateElementTypeSetConfigurationNotation(inputResource, outputNotationResource);

			// Sort only when generating new
			if (!resourceSet.getURIConverter().exists(outputURI, null)) {
				ECollections.sort(elementTypeSetConfiguration.getElementTypeConfigurations(), new ElementTypeConfigurationComparator());
			}
			if (!resourceSet.getURIConverter().exists(outputNotationURI, null)) {
				ECollections.sort(elementTypeSetConfigurationNotation.getElementTypeConfigurations(), new ElementTypeConfigurationComparator());
			}

			try {
				outputResource.save(Collections.EMPTY_MAP);
				outputNotationResource.save(Collections.EMPTY_MAP);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	protected ElementTypeSetConfiguration generateElementTypeSetConfigurationNotation(Resource inputResource, Resource outputResource) {
		ElementTypeSetConfiguration elementTypeSetConfiguration = (ElementTypeSetConfiguration) EcoreUtil.getObjectByType(outputResource.getContents(), ElementtypesconfigurationsPackage.Literals.ELEMENT_TYPE_SET_CONFIGURATION);
		final Map<String, ElementTypeConfiguration> extantConfigurations = Maps.newHashMap();
		if (elementTypeSetConfiguration == null) {
			// Creating a new model
			elementTypeSetConfiguration = ElementtypesconfigurationsFactory.eINSTANCE.createElementTypeSetConfiguration();
			outputResource.getContents().add(elementTypeSetConfiguration);
		} else {
			// Gather the configurations already in the model to merge them
			for (ElementTypeConfiguration next : elementTypeSetConfiguration.getElementTypeConfigurations()) {
				extantConfigurations.put(next.getIdentifier(), next);
			}
		}

		elementTypeSetConfiguration.setMetamodelNsURI("http://www.eclipse.org/gmf/runtime/1.0.2/notation");


		TreeIterator<EObject> it = inputResource.getAllContents();
		while (it.hasNext()) {
			EObject eObject = it.next();
			if (eObject instanceof NotationType) {
				NotationType notationType = (NotationType) eObject;

				// Merge with existing?
				String identifier = notationType.getUniqueIdentifier();
				SpecializationTypeConfiguration specializationTypeConfiguration;
				ElementTypeConfiguration existing = extantConfigurations.get(identifier);
				if (existing instanceof SpecializationTypeConfiguration) {
					// Merged
					specializationTypeConfiguration = (SpecializationTypeConfiguration) extantConfigurations.remove(identifier);
				} else {
					// New
					specializationTypeConfiguration = ElementtypesconfigurationsFactory.eINSTANCE.createSpecializationTypeConfiguration();
					specializationTypeConfiguration.setIdentifier(identifier);
				}

				specializationTypeConfiguration.setIdentifier(notationType.getUniqueIdentifier());
				specializationTypeConfiguration.setHint("" + ((GenCommonBase) notationType.eContainer()).getVisualID());
				specializationTypeConfiguration.setName(notationType.getDisplayName());

				specializationTypeConfiguration.setKind("org.eclipse.gmf.runtime.diagram.ui.util.INotationType");

				if (specializationTypeConfiguration.getSpecializedTypesID().isEmpty()) {
					specializationTypeConfiguration.getSpecializedTypesID().add("org.eclipse.gmf.runtime.emf.type.core.null");
				}

				elementTypeSetConfiguration.getElementTypeConfigurations().add(specializationTypeConfiguration);


			}
		}

		deleteLeftovers(extantConfigurations);

		return elementTypeSetConfiguration;
	}

	protected ElementTypeSetConfiguration generateElementTypeSetConfiguration(Resource inputResource, Resource outputResource) {
		ElementTypeSetConfiguration elementTypeSetConfiguration = (ElementTypeSetConfiguration) EcoreUtil.getObjectByType(outputResource.getContents(), ElementtypesconfigurationsPackage.Literals.ELEMENT_TYPE_SET_CONFIGURATION);
		final Map<String, ElementTypeConfiguration> extantConfigurations = Maps.newHashMap();
		if (elementTypeSetConfiguration == null) {
			// Creating a new model
			elementTypeSetConfiguration = ElementtypesconfigurationsFactory.eINSTANCE.createElementTypeSetConfiguration();
			outputResource.getContents().add(elementTypeSetConfiguration);
		} else {
			// Gather the configurations already in the model to merge them
			for (ElementTypeConfiguration next : elementTypeSetConfiguration.getElementTypeConfigurations()) {
				extantConfigurations.put(next.getIdentifier(), next);
			}
		}

		elementTypeSetConfiguration.setMetamodelNsURI("http://www.eclipse.org/uml2/5.0.0/UML");

		TreeIterator<EObject> it = inputResource.getAllContents();
		while (it.hasNext()) {
			EObject eObject = it.next();
			if (eObject instanceof GenEditorGenerator) {
				GenEditorGenerator editorGen = (GenEditorGenerator) eObject;
				elementTypeSetConfiguration.setName(editorGen.getModelID());
			} else if (eObject instanceof GenDiagram) {
				// Diagram model does not have a TypeModelFacet, so use this instead
				GenDiagram diagram = (GenDiagram) eObject;

				// Merge with existing?
				String identifier = diagram.getElementType().getUniqueIdentifier();
				SpecializationTypeConfiguration specializationTypeConfiguration;
				ElementTypeConfiguration existing = extantConfigurations.get(identifier);
				if (existing instanceof SpecializationTypeConfiguration) {
					// Merged
					specializationTypeConfiguration = (SpecializationTypeConfiguration) extantConfigurations.remove(identifier);
				} else {
					// New
					specializationTypeConfiguration = ElementtypesconfigurationsFactory.eINSTANCE.createSpecializationTypeConfiguration();
					specializationTypeConfiguration.setIdentifier(identifier);
				}

				// This is what the Diagram uses as its type, not the visual ID
				specializationTypeConfiguration.setHint(diagram.getEditorGen().getModelID());

				// The element type name is often just "Undefined"
				specializationTypeConfiguration.setName(cleanUpName(diagram.getDomainDiagramElement().getFormattedName()));

				specializationTypeConfiguration.setKind("org.eclipse.gmf.runtime.emf.type.core.IHintedType");

				// Container configuration is irrelevant for the diagram because it has no parent view
				specializationTypeConfiguration.getSpecializedTypesID().clear();
				specializationTypeConfiguration.getSpecializedTypesID().add(GenerateElementTypesConfigurationsUtils.getIdentifier(diagram.getDomainDiagramElement().getEcoreClass()));

				generateIconEntry(specializationTypeConfiguration, diagram.getDomainDiagramElement().getEcoreClass());

				elementTypeSetConfiguration.getElementTypeConfigurations().add(specializationTypeConfiguration);

			} else if (eObject instanceof TypeModelFacet) {
				TypeModelFacet typeModelFacet = (TypeModelFacet) eObject;



				EClass eClass = typeModelFacet.getMetaClass().getEcoreClass();
				if (eClass == null)
				{
					Activator.log.info("EClass not defined for: " + typeModelFacet.eContainer());
				} else {
					GenCommonBase base = (GenCommonBase) typeModelFacet.eContainer();

					// Merge with existing?
					String identifier = base.getElementType().getUniqueIdentifier();
					SpecializationTypeConfiguration specializationTypeConfiguration;
					ElementTypeConfiguration existing = extantConfigurations.get(identifier);
					if (existing instanceof SpecializationTypeConfiguration) {
						// Merged
						specializationTypeConfiguration = (SpecializationTypeConfiguration) extantConfigurations.remove(identifier);
					} else {
						// New
						specializationTypeConfiguration = ElementtypesconfigurationsFactory.eINSTANCE.createSpecializationTypeConfiguration();
						specializationTypeConfiguration.setIdentifier(identifier);
					}

					specializationTypeConfiguration.setHint(Integer.toString(base.getVisualID()));
					specializationTypeConfiguration.setName(cleanUpName(base.getElementType().getDisplayName()));

					specializationTypeConfiguration.setKind("org.eclipse.gmf.runtime.emf.type.core.IHintedType");

					EReference containmentEReference = null;
					if (typeModelFacet.getContainmentMetaFeature() != null) {
						EStructuralFeature feature = typeModelFacet.getContainmentMetaFeature().getEcoreFeature();
						if (feature instanceof EReference) {
							containmentEReference = (EReference) feature;
						}
					}
					if (containmentEReference != null) {
						specializationTypeConfiguration.getSpecializedTypesID().clear();
						specializationTypeConfiguration.getSpecializedTypesID().add(GenerateElementTypesConfigurationsUtils.findSpecializedTypesIDs(eClass, containmentEReference));

						if (GenerateElementTypesConfigurationsUtils.isSpecializedASpecialization(eClass, containmentEReference)) {
							ContainerConfiguration containerConfiguration = specializationTypeConfiguration.getContainerConfiguration();
							if (containerConfiguration == null) {
								containerConfiguration = ElementtypesconfigurationsFactory.eINSTANCE.createContainerConfiguration();
								specializationTypeConfiguration.setContainerConfiguration(containerConfiguration);
							}

							containerConfiguration.getEContainmentFeatures().clear();
							containerConfiguration.getEContainmentFeatures().add(containmentEReference);
						} else if (specializationTypeConfiguration.getContainerConfiguration() != null) {
							// Delete it
							EcoreUtil.delete(specializationTypeConfiguration.getContainerConfiguration(), true);
						}
					}

					generateIconEntry(specializationTypeConfiguration, eClass);

					elementTypeSetConfiguration.getElementTypeConfigurations().add(specializationTypeConfiguration);
				}

			} else if (eObject instanceof FeatureLinkModelFacet) {
				FeatureLinkModelFacet featureLinkModelFacet = (FeatureLinkModelFacet) eObject;
				GenCommonBase base = (GenCommonBase) featureLinkModelFacet.eContainer();

				// Merge with existing?
				String identifier = base.getElementType().getUniqueIdentifier();
				SpecializationTypeConfiguration specializationTypeConfiguration;
				ElementTypeConfiguration existing = extantConfigurations.get(identifier);
				if (existing instanceof SpecializationTypeConfiguration) {
					// Merged
					specializationTypeConfiguration = (SpecializationTypeConfiguration) extantConfigurations.remove(identifier);
				} else {
					// New
					specializationTypeConfiguration = ElementtypesconfigurationsFactory.eINSTANCE.createSpecializationTypeConfiguration();
					specializationTypeConfiguration.setIdentifier(identifier);
				}

				specializationTypeConfiguration.setHint(Integer.toString(base.getVisualID()));
				specializationTypeConfiguration.setName(cleanUpName(base.getElementType().getUniqueIdentifier()));

				specializationTypeConfiguration.setKind("org.eclipse.gmf.runtime.emf.type.core.IHintedType");

				if (specializationTypeConfiguration.getSpecializedTypesID().isEmpty()) {
					specializationTypeConfiguration.getSpecializedTypesID().add("org.eclipse.gmf.runtime.emf.type.core.null");
				}

				elementTypeSetConfiguration.getElementTypeConfigurations().add(specializationTypeConfiguration);

			}
		}

		deleteLeftovers(extantConfigurations);

		return elementTypeSetConfiguration;
	}

	protected IconEntry generateIconEntry(ElementTypeConfiguration type, EClass eClass) {
		// If an icon entry already exists, it may have been customized, so don't mess with it
		IconEntry result = type.getIconEntry();
		if (result == null) {
			result = ElementtypesconfigurationsFactory.eINSTANCE.createIconEntry();
			result.setBundleId("org.eclipse.uml2.uml.edit");
			result.setIconPath("/icons/full/obj16/" + eClass.getName() + ".gif");
			type.setIconEntry(result);
		}

		return result;
	}

	/**
	 * Deletes from the merged element types model those element types that are no longer defined in the GMFGen.
	 * 
	 * @param elementTypesToDelete
	 *            element types to delete
	 */
	protected void deleteLeftovers(Map<String, ElementTypeConfiguration> elementTypesToDelete) {
		if (!elementTypesToDelete.isEmpty()) {
			String names = Joiner.on(", ").join(Iterables.transform(elementTypesToDelete.values(), new Function<ElementTypeConfiguration, String>() {
				@Override
				public String apply(ElementTypeConfiguration input) {
					return Strings.isNullOrEmpty(input.getName()) ? input.getIdentifier() : input.getName();
				}
			}));

			if (MessageDialog.openQuestion(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), "Delete Left-over Element Types", "Delete element types no longer defined in the GMFGen model?\n\n" + names)) {
				for (ElementTypeConfiguration next : elementTypesToDelete.values()) {
					EcoreUtil.delete(next, true);
				}
			}
		}
	}

	static String cleanUpName(String name) {
		name = name.substring(name.lastIndexOf('.') + 1); // Strip off namespace qualifier, if any
		if (name.matches("^.*_\\d+$")) {
			name = name.substring(0, name.lastIndexOf('_')); // Strip off visual ID suffix, if any
		}
		name = name.replaceAll("([a-z])([A-Z])", "$1 $2"); // put space between camel-case words

		return name;
	}
}
