/*****************************************************************************
 * Copyright (c) 2020 EclipseSource and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   EclipseSource - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.profile.types.generator.strategy;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.infra.types.AbstractAdviceBindingConfiguration;
import org.eclipse.papyrus.infra.types.ElementTypeConfiguration;
import org.eclipse.papyrus.infra.types.ElementTypeSetConfiguration;
import org.eclipse.papyrus.infra.types.MetamodelTypeConfiguration;
import org.eclipse.papyrus.infra.types.SpecializationTypeConfiguration;
import org.eclipse.papyrus.uml.profile.types.generator.ImpliedExtension;
import org.eclipse.papyrus.uml.profile.types.generator.UML;
import org.eclipse.papyrus.uml.tools.utils.ElementUtil;
import org.eclipse.papyrus.uml.types.core.advices.applystereotype.ApplyStereotypeAdviceConfiguration;
import org.eclipse.papyrus.uml.types.core.matchers.stereotype.StereotypeMatcherAdviceConfiguration;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.resource.UMLResource;

/**
 * A helper to retrieve Stereotype information from an {@link ElementTypeSetConfiguration} model.
 */
public class ElementTypeConfigHelper {

	private final UML uml = new UML();

	/**
	 * @param config
	 * @return
	 *         The Stereotype Qualified Name represented by this ElementTypeConfiguration,
	 *         or <code>null</code> if this Element Type doesn't represent a Stereotype.
	 */
	public String getStereotypeName(ElementTypeConfiguration config) {
		// ElementTypes representing Stereotypes are always SpecializationTypes
		if (config instanceof SpecializationTypeConfiguration) {
			List<AbstractAdviceBindingConfiguration> relatedAdvices = getRelatedAdvices(config);

			// TODO Limit this to a single Stereotype Advice. If multiple Stereotype Advices
			// are applied, this ElementType doesn't represent a single generate Stereotype
			// Specialization Type and should be ignored.
			for (AbstractAdviceBindingConfiguration advice : relatedAdvices) {
				if (advice instanceof ApplyStereotypeAdviceConfiguration) {
					return getStereotypeName((ApplyStereotypeAdviceConfiguration) advice);
				} else if (advice instanceof StereotypeMatcherAdviceConfiguration) {
					return getStereotypeName((StereotypeMatcherAdviceConfiguration) advice);
				}
			}
		}
		return null;
	}

	/**
	 * Retrieve all {@link AbstractAdviceBindingConfiguration} related to the selected element type
	 * in its {@link ElementTypeSetConfiguration}
	 *
	 * @param typeConfig
	 *            The ElementType
	 * @return
	 *         The list of Advices related to this element type (i.e. having this type as their target)
	 */
	public List<AbstractAdviceBindingConfiguration> getRelatedAdvices(ElementTypeConfiguration typeConfig) {
		List<AbstractAdviceBindingConfiguration> relatedAdvices = Stream.concat(
				typeConfig.getOwnedAdvice().stream(), // Directly owned advices
				typeConfig.getOwningSet().getAdviceBindingsConfigurations().stream() // External Advices (in the same TypeSet) targetting this type
						.filter(advice -> advice.getTarget() == typeConfig))
				.collect(Collectors.toList());
		return relatedAdvices;
	}

	/**
	 * @param advice
	 * @return
	 */
	public String getStereotypeName(ApplyStereotypeAdviceConfiguration advice) {
		if (advice.getStereotypesToApply().size() == 1) {
			return advice.getStereotypesToApply().get(0).getStereotypeQualifiedName();
		}
		// If there are 0 or > 2 stereotypes to apply, this is not a (valid) generated
		// element type, and should be ignored.
		return null;
	}

	/**
	 * @param advice
	 * @return
	 */
	public String getStereotypeName(StereotypeMatcherAdviceConfiguration advice) {
		if (advice.getStereotypesQualifiedNames().size() == 1) {
			return advice.getStereotypesQualifiedNames().get(0);
		}
		// If there are 0 or > 2 stereotypes to apply, this is not a (valid) generated
		// element type, and should be ignored.
		return null;
	}

	/**
	 * Tests if the stereotype corresponding to the given ElementTypeConfiguration
	 * still exists in the current version of the profile. This methods returns
	 * <code>true</code> if the stereotype has been renamed, but kept the same URI (In that
	 * case, see {@link #getCurrentName(ElementTypeConfiguration, Profile)})
	 *
	 * @param config
	 * @param currentProfile
	 * @return
	 *         An Optional boolean:
	 *         <ul>
	 *         <li><code>True</code> if the config represents a Stereotype that still exists
	 *         <li><code>False</code> if the config represents a Stereotype that no longer exists
	 *         <li>{@link Optional#empty}</li> if the config doesn't represent a Stereotype
	 *         </ul>
	 */
	public Optional<Boolean> exists(ElementTypeConfiguration config, Profile currentProfile) {
		String stereoQName = getStereotypeName(config);
		URI stereoURI = getStereotypeURI(config);
		if (stereoURI != null && currentProfile.eResource().getResourceSet().getEObject(stereoURI, false) != null) {
			// If the URI doesn't exist, don't return false: if the Stereotype was deleted and
			// re-created with the same name, then it still exists. If it has been copied to
			// a different resource with a different URI, while keeping the same name, then
			// it also still exists.
			return Optional.of(Boolean.TRUE);
		}
		if (stereoQName != null) {
			return Optional.of(
					StreamSupport.stream(uml.getAllStereotypes(currentProfile).spliterator(), false)
							.anyMatch(s -> stereoQName.equals(s.getQualifiedName())));
		}

		// We simply want to ignore this unknown element (which doesn't represent a
		// Stereotype QName or URI); so testing if the stereotype exists or not doesn't
		// make sense.
		return Optional.empty();
	}

	/**
	 * @param config
	 * @return
	 *         The URI of the stereotype that was used to generate this element type, or <code>null</code>
	 */
	private URI getStereotypeURI(ElementTypeConfiguration config) {
		if (config.getSource() == null || config.getSource().isEmpty()) {
			return null;
		}
		try {
			URI uri = URI.createURI(config.getSource());
			return uri;
		} catch (IllegalArgumentException ex) {
			// The source is not a valid URI; probably because the type wasn't generated
			// with this tool. Simply ignore.
			return null;
		}
	}

	/**
	 * Tests if stereotype already exists in the previous version of the element type set.
	 * This methods returns <code>true</code> if the stereotype has been renamed, but kept
	 * the same URI (In that case, see {@link #getCurrentName(ElementTypeConfiguration, Profile)})
	 *
	 * @param stereotype
	 * @param previousTypes
	 * @return
	 */
	public boolean exists(Stereotype stereotype, ElementTypeSetConfiguration previousTypes) {
		String stereoQName = stereotype.getQualifiedName();
		URI stereotypeURI = EcoreUtil.getURI(stereotype);
		boolean anyMatch = previousTypes.getElementTypeConfigurations().stream() //
				.anyMatch(config -> stereoQName.equals(getStereotypeName(config)) //
						|| stereotypeURI.equals(getStereotypeURI(config)));
		return anyMatch;
	}

	/**
	 * Retrieve the Stereotype that was used to generate the given config, and return
	 * its current version (from the specified profile).
	 *
	 * This is used to identify e.g. renamed stereotypes (or updated stereotypes, in general).
	 *
	 * @param config
	 *            The element type configuration that was (potentially) generated, in the past
	 * @param currentProfile
	 *            The current version of the profile
	 * @return
	 *         The current stereotype corresponding to the given config, or <code>null</code>.
	 */
	public Stereotype getCurrentStereotypeByURI(ElementTypeConfiguration config, Profile currentProfile) {
		URI sourceURI = getStereotypeURI(config);
		if (sourceURI == null) {
			return null;
		}

		// Use loadOnDemand=false. If the stereotype is not already part of the Profile resource set, then
		// it might match a different profile. We don't want to load these external profiles.
		EObject eObject = currentProfile.eResource().getResourceSet().getEObject(sourceURI, false);
		if (eObject instanceof Stereotype) {
			return ((Stereotype) eObject);
		}
		return null;
	}

	/**
	 * Retrieve the Stereotype corresponding to the given config, and return
	 * its current version (from the specified profile).
	 *
	 * @param config
	 *            The element type configuration
	 * @param currentProfile
	 *            The current version of the profile
	 * @return
	 *         The current stereotype corresponding to the given config, or <code>null</code>.
	 */
	public Stereotype getCurrentStereotype(ElementTypeConfiguration config, Profile currentProfile) {
		// Try to find the Stereotype by URI
		Stereotype stereotype = getCurrentStereotypeByURI(config, currentProfile);
		if (stereotype != null) {
			return stereotype;
		}
		String stereoQName = getStereotypeName(config);
		if (stereoQName == null) {
			// This type doesn't represent a Stereotype
			return null;
		}

		// Try to find the Stereotype by Qualified Name
		return StreamSupport.stream(uml.getAllStereotypes(currentProfile).spliterator(), false).filter(st -> stereoQName.equals(st.getQualifiedName())).findFirst().orElse(null);
	}

	public ImpliedExtension getExtension(ElementTypeConfiguration config, Profile currentProfile) {
		Stereotype stereotype = getCurrentStereotype(config, currentProfile);
		return stereotype == null ? null : getExtension(config, stereotype);
	}

	public boolean exists(ImpliedExtension extension, Iterable<ImpliedExtension> allExtensions) {
		return StreamSupport.stream(allExtensions.spliterator(), false).anyMatch(e -> e.equals(extension));
	}

	/**
	 * Return the Stereotype's {@link ImpliedExtension} corresponding to the given typeConfig.
	 */
	public ImpliedExtension getExtension(ElementTypeConfiguration typeConfig, Stereotype stereotype) {
		if (stereotype == null || typeConfig == null) {
			return null;
		}
		if (typeConfig instanceof SpecializationTypeConfiguration) {
			SpecializationTypeConfiguration type = (SpecializationTypeConfiguration) typeConfig;
			MetamodelTypeConfiguration baseType = getMetamodelType(type);
			if (baseType != null) {
				EClass metaclass = baseType.getEClass();
				if (metaclass != null) {
					org.eclipse.uml2.uml.Package uml2Metamodel = ElementUtil.contentload(URI.createURI(UMLResource.UML_METAMODEL_URI), stereotype);
					PackageableElement baseClass = uml2Metamodel.getPackagedElement(metaclass.getName());
					return baseClass instanceof org.eclipse.uml2.uml.Class ? new ImpliedExtension(stereotype, (org.eclipse.uml2.uml.Class) baseClass) : null;
				}
			}
		}
		return null;
	}

	/**
	 * Retrieve the {@link MetamodelTypeConfiguration} extended by this {@link SpecializationTypeConfiguration}.
	 * This method only supports single-element hierarchies, as the generator only uses such hierarchies (More complex
	 * cases are likely not generated, and thus can be ignored).
	 *
	 * @param specialType
	 * @return
	 */
	private MetamodelTypeConfiguration getMetamodelType(SpecializationTypeConfiguration specialType) {
		List<ElementTypeConfiguration> specializedTypes = specialType.getSpecializedTypes();
		if (specializedTypes.size() != 1) {
			return null;
		}
		ElementTypeConfiguration superType = specializedTypes.get(0);
		if (superType instanceof MetamodelTypeConfiguration) {
			return (MetamodelTypeConfiguration) superType;
		} else if (superType instanceof SpecializationTypeConfiguration) {
			return getMetamodelType((SpecializationTypeConfiguration) superType);
		}
		return null;
	}

	public boolean exists(ImpliedExtension extension, ElementTypeSetConfiguration previousTypes) {
		for (ElementTypeConfiguration config : previousTypes.getElementTypeConfigurations()) {
			ImpliedExtension ext = getExtension(config, extension.getStereotype().getProfile());
			if (extension.equals(ext)) {
				return true;
			}
		}
		return false;
	}

}
