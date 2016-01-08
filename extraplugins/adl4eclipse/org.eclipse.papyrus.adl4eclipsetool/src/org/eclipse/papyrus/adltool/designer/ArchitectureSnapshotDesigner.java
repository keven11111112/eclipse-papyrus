/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) patrick.tessier@cea.fr - Initial API and implementation
 *  Thomas Daniellou (CEA LIST) - Refactoring and cleanup
 *****************************************************************************/
package org.eclipse.papyrus.adltool.designer;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.adl4eclipse.org.ADL4Eclipse_Stereotypes;
import org.eclipse.papyrus.adltool.ADLConstants;
import org.eclipse.papyrus.adltool.Activator;
import org.eclipse.papyrus.adltool.reversible.Reversible;
import org.eclipse.papyrus.adltool.reversible.extension.ReversibleExtension;
import org.eclipse.papyrus.adltool.reversible.extension.SchemaAttribute;
import org.eclipse.papyrus.adltool.reversible.extension.SchemaElement;
import org.eclipse.papyrus.adltool.reversible.extensionpoint.ReversibleExtensionPoint;
import org.eclipse.papyrus.adltool.reversible.packages.ReversiblePackage;
import org.eclipse.papyrus.adltool.reversible.project.ReversibleFeature;
import org.eclipse.papyrus.adltool.reversible.project.ReversiblePlugin;
import org.eclipse.papyrus.adltool.reversible.project.ReversibleProject;
import org.eclipse.papyrus.adltool.reversible.project.StereotypeVersion;
import org.eclipse.papyrus.osgi.profile.OSGIStereotypes;
import org.eclipse.papyrus.uml.extensionpoints.profile.IRegisteredProfile;
import org.eclipse.papyrus.uml.extensionpoints.profile.RegisteredProfile;
import org.eclipse.papyrus.uml.extensionpoints.utils.Util;
import org.eclipse.papyrus.uml.tools.utils.PackageUtil;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * This class manipulates each reversibles representation, creates the
 * dependencies between them, and when necessary, adds them in the model.
 */
public class ArchitectureSnapshotDesigner {

	/**
	 * Set containing the projects that have been reversed during the current
	 * import.
	 */
	private Set<ReversibleProject> reversedProjects;

	/**
	 * Set of projects to be reversed.
	 */
	private Set<ReversibleProject> reversibles;

	/**
	 * Set of reversibles that need to apply and fill their stereotypes.
	 */
	private Set<Reversible<?>> postponedReversibles;

	/**
	 * Reverse settings containing the depth level of dependencies to reverse.
	 */
	private ReverseSettings settings;

	/**
	 * The package that will hold the reversed projects.
	 */
	private Package model;

	/**
	 * Constructor.
	 *
	 * @param model
	 * @param reversibles
	 * @param settings
	 */
	public ArchitectureSnapshotDesigner(Package model, Set<ReversibleProject> reversibles, ReverseSettings settings) {
		if (model == null || reversibles == null || reversibles.isEmpty()) {
			throw new IllegalArgumentException();
		}

		this.model = model;
		this.settings = settings;
		this.reversibles = reversibles;

		reversedProjects = new HashSet<>();
		postponedReversibles = new HashSet<>();
	}

	/**
	 * Launches the import of bundles into the model.
	 */
	public void runImportBundles() {
		initModel();

		// Reverses the selected projects in the model
		for (ReversibleProject project : reversibles) {
			reverseProject(project);
		}

		// Fill the reversibles' stereotypes
		for (Reversible<?> reversible : postponedReversibles) {
			reversible.fillStereotype();
		}

	}


	/**
	 * Ensures that the ADL4Eclipse and OSGi profiles have been applied.
	 */
	private void initModel() {
		applyProfile(OSGIStereotypes.OSGI);
		applyProfile(ADL4Eclipse_Stereotypes.ADL4ECLIPSE);
	}

	private void applyProfile(String profileName) {
		Profile appliedProfile = model.getAppliedProfile(profileName);

		if (appliedProfile == null) {
			IRegisteredProfile registeredProfile = RegisteredProfile.getRegisteredProfile(profileName);

			if (registeredProfile != null) {
				URI modelUri = registeredProfile.getUri();
				Resource modelResource = Util.createTemporaryResourceSet().getResource(modelUri, true);
				Profile profile = (Profile) modelResource.getContents().get(0);

				PackageUtil.applyProfile(model, profile, true);
			}
		}
	}

	/**
	 * Checks whether the reversible has been flagged as reversed or not.
	 *
	 * @param project
	 * @return returns true if this the reversible has been reversed.
	 */
	private boolean wasReversed(ReversibleProject project) {
		return reversedProjects.contains(project);
	}

	/**
	 * Flags the reversible to prevent recursive reverse loop.
	 *
	 * @param project
	 *            the project to be flagged as reversed
	 */
	private void setReversed(ReversibleProject project) {
		reversedProjects.add(project);
	}

	/**
	 * Saves the reversible to fill its properties at the end of the reverse.
	 * 
	 * @param reversible
	 */
	private void postPoneFillStereotype(Reversible<?> reversible) {
		postponedReversibles.add(reversible);
	}

	/**
	 * Reverses a project and, if the {@link ReverseSettings} allows it, its
	 * dependencies, exported packages, extension points and extensions.
	 *
	 * <p>
	 * <b>Note:</b> This method adds the project's representation in the model.
	 * </p>
	 *
	 * @param project
	 *            the project to reverse
	 */
	private void reverseProject(ReversibleProject project) {
		insertInModel(project);
		setReversed(project);

		// Reverse the children
		if (settings.reverseDependencies()) {
			for (ReversibleProject child : project.getDependencies()) {
				reverseChildProject(project, child, settings.getReverseDepth());
			}
		}

		if (project instanceof ReversiblePlugin) {
			ReversiblePlugin reversiblePlugin = (ReversiblePlugin) project;

			// Reverse exported packages
			if (settings.reverseExportPackages()) {
				for (ReversiblePackage exportedPackageName : reversiblePlugin.getExportedPackages()) {
					reversePackage(project, exportedPackageName);
				}
			}

			// Reverse imported packages
			if (settings.reverseImportPackages()) {
				for (ReversiblePackage importedPackage : reversiblePlugin.getImportedPackages()) {
					reversePackage(project, importedPackage);
				}
			}

			// Extension points
			if (settings.reverseExtensionPoints()) {
				for (ReversibleExtensionPoint extensionPoint : reversiblePlugin.getExtensionPoints()) {
					reverseExtensionPoint(extensionPoint);
				}
			}

			// Extensions
			if (settings.reverseExtensions()) {
				for (ReversibleExtension extension : reversiblePlugin.getExtensions()) {
					reverseExtension(extension);
				}
			}
		}

		// Fill stereotype properties
		postPoneFillStereotype(project);
	}

	/**
	 * Reverses a child project and adds a dependency to its parent.
	 *
	 * <p>
	 * <b>Note:</b> This method adds the project's representation in the model.
	 * </p>
	 *
	 * @param parent
	 *            the parent project
	 * @param child
	 *            the child project
	 * @param currentDepth
	 *            the current depth level
	 */
	private void reverseChildProject(ReversibleProject parent, ReversibleProject child, int currentDepth) {
		// Prevent recursion cycle
		if (!wasReversed(child)) {
			insertInModel(child);
			setReversed(child);

			// Reverse the sub-children if we are in infinite mode or the depth
			// is not reached
			if (currentDepth == ADLConstants.INFINITE_DEPTH_OPTION || currentDepth > 1) {
				int newDepth = currentDepth == ADLConstants.INFINITE_DEPTH_OPTION ? currentDepth : currentDepth - 1;

				for (ReversibleProject subChild : child.getDependencies()) {
					reverseChildProject(child, subChild, newDepth);
				}
			}

			// Apply stereotype
			child.applyStereotype();
			postPoneFillStereotype(child);
		}

		createDependency(parent, child);
	}

	/**
	 * Reverses an reversible package inside a reversible project, creates a
	 * dependency between the package and the project and applies the
	 * stereotypes on the created elements.
	 *
	 * @param project
	 *            the project containing the imported packages
	 * @param reversiblePackage
	 *            the imported package name
	 */
	private void reversePackage(ReversibleProject project, ReversiblePackage reversiblePackage) {
		Component reversedProject = project.getRepresentation();
		Package reversedPackage = project.getElement(reversiblePackage);

		if (reversedPackage == null) {
			reversedPackage = reversiblePackage.getRepresentation();
			reversedProject.getPackagedElements().add(reversedPackage);
		} else {
			reversiblePackage.setRepresentation(reversedPackage);
		}

		reversiblePackage.applyStereotype();

		Dependency packageDependency = project.getElement(reversiblePackage.getId(), Dependency.class);

		if (packageDependency == null) {
			// Create the dependency link
			packageDependency = createDependency(reversiblePackage.getId(), reversedProject, reversedPackage);
			reversedProject.getPackagedElements().add(packageDependency);
		}

		String dependencyStereotypeName = reversiblePackage.getDependencyStereotypeName();
		Stereotype dependencyStereotype = packageDependency.getAppliedStereotype(dependencyStereotypeName);

		if (dependencyStereotype == null) {
			// Apply the PackageReference stereotype on the link
			dependencyStereotype = packageDependency.getApplicableStereotype(OSGIStereotypes.PACKAGE_REFERENCE);

			if (dependencyStereotype != null) {
				packageDependency.applyStereotype(dependencyStereotype);
			}
		}

		// Fill dependency stereotype
		StereotypeVersion dependencyVersion = project.getReversibleVersion(reversiblePackage);

		if (dependencyVersion != null) {
			String floor = dependencyVersion.getFloor();
			String ceiling = dependencyVersion.getCeiling();
			boolean includeFloor = dependencyVersion.includeFloor();
			boolean includeCeiling = dependencyVersion.includeCeiling();

			packageDependency.setValue(dependencyStereotype, OSGIStereotypes.VERSIONRANGE_FLOOR_ATT, floor);
			packageDependency.setValue(dependencyStereotype, OSGIStereotypes.VERSIONRANGE_INCLUDEFLOOR_ATT,
					includeFloor);

			if (ceiling != null) {
				packageDependency.setValue(dependencyStereotype, OSGIStereotypes.VERSIONRANGE_CEILING_ATT, ceiling);
				packageDependency.setValue(dependencyStereotype, OSGIStereotypes.VERSIONRANGE_INCLUDECEILING_ATT,
						includeCeiling);
			}
		}
	}

	/**
	 * Reverses an extension point. <br />
	 * A reversed extension point is a component inside the project's component.
	 *
	 * @param extensionPoint
	 */
	private void reverseExtensionPoint(ReversibleExtensionPoint extensionPoint) {
		ReversibleProject project = extensionPoint.getParent();
		Component reversedProject = project.getRepresentation();
		Component reversedExtensionPoint = project.getElement(extensionPoint);

		if (reversedExtensionPoint == null) {
			reversedExtensionPoint = extensionPoint.getRepresentation();
			reversedProject.getPackagedElements().add(reversedExtensionPoint);
		} else {
			extensionPoint.setRepresentation(reversedExtensionPoint);
		}

		// Create a port of type "reversed extension point" if it does not exist
		if (project.getElement(extensionPoint.getId(), Port.class) == null) {
			reversedProject.createOwnedPort(extensionPoint.getId(), reversedExtensionPoint);
		}

		reverseExtensionPointElements(extensionPoint);

		// Apply stereotype
		extensionPoint.applyStereotype();
		postPoneFillStereotype(extensionPoint);
	}

	/**
	 * Reverses an extension. <br/>
	 * An reversed extension is represented by an
	 * {@link org.eclipse.uml2.uml.InstanceSpecification InstanceSpecification}
	 * inside the project's component. The reversed project will have a port
	 * linked to the extension point definer's port.
	 *
	 * @param extension
	 */
	private void reverseExtension(ReversibleExtension extension) {
		ReversibleProject project = extension.getParent();
		ReversibleExtensionPoint extensionPoint = extension.getExtensionPoint();

		if (extensionPoint != null) {
			Component reversedProject = project.getRepresentation();

			// Check if the extension is in the project's representation
			InstanceSpecification reversedExtension = project.getElement(extension);

			if (reversedExtension == null) {
				reversedExtension = extension.getRepresentation();
				reversedProject.getPackagedElements().add(reversedExtension);
			} else {
				extension.setRepresentation(reversedExtension);
			}

			// TODO: Create a Usage link

			// Make sure the extension point's elements are reversed
			reverseExtensionPointElements(extensionPoint);

			// Create the instance specification's slots
			for (SchemaElement element : extension.getElements()) {
				Component reversedElement = extensionPoint.getElement(element.getName(), Component.class);

				if (reversedElement != null) {
					// Set the InstanceSpecification's classifier
					reversedExtension.getClassifiers().add(reversedElement);
					reversedExtension.getSlots().clear();

					for (SchemaAttribute schemaAttribute : element.getAttributes()) {
						LiteralString value = UMLFactory.eINSTANCE.createLiteralString();
						value.setValue(schemaAttribute.getValue());

						// TODO: This might need some refactoring
						for (Property attribute : reversedElement.getOwnedAttributes()) {
							if (attribute.getName().equals(schemaAttribute.getName())) {
								Slot slot = reversedExtension.createSlot();

								slot.setDefiningFeature(attribute);
								slot.getValues().add(value);
							}
						}
					}
				}
			}

			// Create a port of type "reversed extension point"
			if (project.getElement(extensionPoint.getId(), Port.class) == null) {
				reversedProject.createOwnedPort(extensionPoint.getId(), extensionPoint.getRepresentation());
			}

			createExtensionPointDependency(project, extensionPoint);
		}

		// Apply stereotype
		extension.applyStereotype();
		postPoneFillStereotype(extension);
	}

	/**
	 * Creates a dependency between two projects (the one that contributes to an
	 * extension point and the extension point's parent).
	 *
	 * <p>
	 * <b>Note:</b> If the project and its extension point are not in the model,
	 * this method will add them.
	 * </p>
	 *
	 * @param project
	 * @param extensionPoint
	 */
	private void createExtensionPointDependency(ReversibleProject project, ReversibleExtensionPoint extensionPoint) {
		// Retrieve the extension point definer
		ReversibleProject parent = extensionPoint.getParent();

		Component reversedProject = project.getRepresentation();
		Component parentRepresentation = parent.getRepresentation();
		Component reversedExtensionPoint = extensionPoint.getRepresentation();

		// Add the extension point definer in the model
		if (searchRepresentation(parent) == null) {
			model.getPackagedElements().add(parentRepresentation);
		}

		// Make sure the extension point is in the model
		if (parent.getElement(extensionPoint) == null) {
			parentRepresentation.getPackagedElements().add(reversedExtensionPoint);
		}

		// Ensure the stereotype are applied
		parent.applyStereotype();
		extensionPoint.applyStereotype();

		postPoneFillStereotype(parent);
		postPoneFillStereotype(extensionPoint);

		// The project's port was created before this method is called
		Port extensionPort = project.getElement(extensionPoint.getId(), Port.class);
		Port extensionPointPort = parent.getElement(extensionPoint.getId(), Port.class);

		if (extensionPointPort == null) {
			extensionPointPort = parentRepresentation.createOwnedPort(extensionPoint.getId(), reversedExtensionPoint);
		}

		String dependencyName = extensionPoint.getId();
		Dependency dependency = project.getElement(dependencyName, Dependency.class);

		if (dependency != null) {
			return; // The dependency already exists
		}

		// Create the dependency and add it to the reversed project's
		// representation
		Dependency extensionPointDependency = createDependency(dependencyName, extensionPort, extensionPointPort);

		reversedProject.getPackagedElements().add(extensionPointDependency);

		String extensionPtStereotypeName = extensionPoint.getDependencyStereotypeName();
		Stereotype dependencyStereotype = extensionPointDependency.getApplicableStereotype(extensionPtStereotypeName);

		extensionPointDependency.applyStereotype(dependencyStereotype);
	}

	/**
	 * Creates a dependency link between two reversible projects. Adds the
	 * dependency to the first reversible representation and apply the
	 * stereotype.
	 *
	 * @param parent
	 * @param child
	 * @return the created dependency
	 */
	private Dependency createDependency(ReversibleProject parent, ReversibleProject child) {
		Component parentComponent = parent.getRepresentation();
		Component childComponent = child.getRepresentation();

		String dependencyName = child.getId();
		Dependency dependency = parent.getElement(dependencyName, Dependency.class);

		// Create the dependency if it does not exist
		if (dependency == null) {
			dependency = createDependency(dependencyName, parentComponent, childComponent);

			parentComponent.getPackagedElements().add(dependency);

			// create only the owned attribute in case of really owned elements
			// (e.g. do not add for simple referenced bundles)
			if (shouldCreateAttribute(parent, child)) {
				parentComponent.createOwnedAttribute(child.getId(), childComponent);
			}

		}

		// Apply the stereotype
		String depStereotypeName = child.getDependencyStereotypeName();
		Stereotype depStereotype = dependency.getApplicableStereotype(depStereotypeName);

		if (dependency.getAppliedStereotype(depStereotypeName) == null) {
			dependency.applyStereotype(depStereotype);
		}

		// Get the version to fill the stereotype
		StereotypeVersion dependencyVersionRange = parent.getReversibleVersion(child);

		if (dependencyVersionRange != null) {
			String floor = dependencyVersionRange.getFloor();
			String ceiling = dependencyVersionRange.getCeiling();
			boolean includeFloor = dependencyVersionRange.includeFloor();
			boolean includeCeiling = dependencyVersionRange.includeCeiling();

			dependency.setValue(depStereotype, OSGIStereotypes.VERSIONRANGE_FLOOR_ATT, floor);
			dependency.setValue(depStereotype, OSGIStereotypes.VERSIONRANGE_INCLUDEFLOOR_ATT, includeFloor);

			if (ceiling != null) {
				dependency.setValue(depStereotype, OSGIStereotypes.VERSIONRANGE_CEILING_ATT, ceiling);
				dependency.setValue(depStereotype, OSGIStereotypes.VERSIONRANGE_INCLUDECEILING_ATT, includeCeiling);
			}
		}

		return dependency;
	}

	private static boolean shouldCreateAttribute(ReversibleProject parent, ReversibleProject child) {
		if (parent instanceof ReversibleFeature) {
			// should only create for included plugins & included features, not
			// referenced plugins
			if (child instanceof ReversibleFeature
					&& ((ReversibleFeature) parent).getIncludedReversibleFeatures().contains(child)) {
				return true;
			}
			if (child instanceof ReversiblePlugin
					&& ((ReversibleFeature) parent).getIncludedReversiblePlugins().contains(child)) {
				return true;
			}
			return false;
		} else if (parent instanceof ReversiblePlugin) {
			return true;
		} else {
			Activator.log.error("Case not handled", null);
			return true;
		}
	}

	/**
	 * Creates a dependency link between two
	 * {@link org.eclipse.uml2.uml.NamedElement NamedElement}s
	 *
	 * @param name
	 *            the name of the dependency
	 * @param client
	 *            the client NamedElement
	 * @param supplier
	 *            the supplier NamedElement
	 * @return the created dependency
	 */
	private Dependency createDependency(String name, NamedElement client, NamedElement supplier) {
		Dependency dependency = UMLFactory.eINSTANCE.createDependency();

		dependency.setName(name);
		dependency.getClients().add(client);
		dependency.getSuppliers().add(supplier);

		return dependency;
	}

	/**
	 * Adds a reversible project's representation in the model or updates it if
	 * is already in it (in case we are updating an existing model).
	 *
	 * @param project
	 */
	private void insertInModel(ReversibleProject project) {
		PackageableElement representation = searchRepresentation(project);

		if (representation instanceof Component) {
			project.setRepresentation((Component) representation);
		} else {
			representation = project.getRepresentation();
			model.getPackagedElements().add(representation);
		}
	}

	private void reverseExtensionPointElements(ReversibleExtensionPoint extensionPoint) {
		ReversibleProject parent = extensionPoint.getParent();

		// Make sure the parent project is in the model to apply the stereotypes
		// on the elements
		insertInModel(parent);

		// Ensure the extension point is in its parent's representation
		Component reversedExtensionPoint = parent.getElement(extensionPoint);

		if (reversedExtensionPoint != null) {
			extensionPoint.setRepresentation(reversedExtensionPoint);
		} else {
			Component parentRepresentation = parent.getRepresentation();
			reversedExtensionPoint = extensionPoint.getRepresentation();

			parentRepresentation.getPackagedElements().add(reversedExtensionPoint);
		}

		// Create the extension point's elements
		for (SchemaElement element : extensionPoint.getElements()) {
			String elementName = element.getName();
			PackageableElement existingElement = reversedExtensionPoint.getPackagedElement(elementName);

			if (existingElement == null) {
				Component reversedElement = UMLFactory.eINSTANCE.createComponent();

				reversedElement.setName(elementName);
				reversedExtensionPoint.getPackagedElements().add(reversedElement);

				for (SchemaAttribute attribute : element.getAttributes()) {
					Property property = UMLFactory.eINSTANCE.createProperty();

					property.setName(attribute.getName());
					reversedElement.getOwnedAttributes().add(property);
				}
			}
		}

		// Apply the stereotype if it is not already applied
		for (PackageableElement element : reversedExtensionPoint.getPackagedElements()) {
			if (element instanceof Component) {
				String stereotypeName = ADL4Eclipse_Stereotypes.ELEMENT_STEREOTYPE;
				Stereotype elementStereotype = element.getAppliedStereotype(stereotypeName);

				if (elementStereotype == null) {
					elementStereotype = element.getApplicableStereotype(stereotypeName);
					element.applyStereotype(elementStereotype);
				}
			}
		}
	}

	/**
	 * Returns a reversible project's representation in the model. This method
	 * checks if the representation has the same name of the reversible's id and
	 * if the reversible's stereotype is applied on it.
	 *
	 * @param reversible
	 * @return the representation or null if it does not exists
	 */
	private PackageableElement searchRepresentation(ReversibleProject reversible) {
		for (PackageableElement element : model.getPackagedElements()) {
			if (element.getName().equals(reversible.getId())) {
				Stereotype appliedStereotype = element.getAppliedStereotype(reversible.getStereotypeName());

				if (appliedStereotype != null) {
					return element;
				}
			}
		}

		return null;
	}

}