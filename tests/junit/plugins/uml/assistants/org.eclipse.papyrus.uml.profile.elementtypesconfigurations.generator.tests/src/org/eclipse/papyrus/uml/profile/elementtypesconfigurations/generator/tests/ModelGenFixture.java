/*****************************************************************************
 * Copyright (c) 2015 Christian W. Damus and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.profile.elementtypesconfigurations.generator.tests;

import static org.eclipse.papyrus.junit.matchers.MoreMatchers.lessThan;
import static org.eclipse.uml2.common.util.UML2Util.getValidJavaIdentifier;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.infra.elementtypesconfigurations.AdviceBindingConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.ElementTypeConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.ElementTypeSetConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.MatcherConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.SpecializationTypeConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.registries.ElementTypeSetConfigurationRegistry;
import org.eclipse.papyrus.junit.utils.JUnitUtils;
import org.eclipse.papyrus.junit.utils.rules.ResourceSetFixture;
import org.eclipse.papyrus.uml.profile.elementtypesconfigurations.generator.ElementTypesGenerator;
import org.eclipse.papyrus.uml.profile.elementtypesconfigurations.generator.Identifiers;
import org.eclipse.papyrus.uml.tools.elementtypesconfigurations.applystereotypeadviceconfiguration.ApplyStereotypeAdviceConfiguration;
import org.eclipse.papyrus.uml.tools.elementtypesconfigurations.stereotypeapplicationmatcherconfiguration.StereotypeApplicationMatcherConfiguration;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.hamcrest.CoreMatchers;
import org.junit.runner.Description;

import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;

/**
 * A test fixture for orchestration of model transformations and verification of transformation results.
 */
public class ModelGenFixture extends ResourceSetFixture {
	private static final String UML_ELEMENT_TYPES = "org.eclipse.papyrus.uml.service.types.UMLElementTypeSet";

	protected final String prefix = "org.eclipse.papyrus.test";

	private String baseElementTypesSet = UML_ELEMENT_TYPES;

	public ModelGenFixture() {
		super();
	}

	public URI getElementTypesResourceURI() {
		URI inputURI = getModelResourceURI();
		String basename = inputURI.lastSegment();
		basename = basename.substring(0, basename.indexOf('.'));

		return inputURI.trimSegments(1).appendSegment(basename).appendFileExtension("elementtypesconfiguration");
	}

	public ElementTypeSetConfiguration getElementTypeSet() {
		Resource resource = getResourceSet().getResource(getElementTypesResourceURI(), true);
		return (ElementTypeSetConfiguration) resource.getContents().get(0);
	}

	static Predicate<NamedElement> named(final String name) {
		return new Predicate<NamedElement>() {
			@Override
			public boolean apply(NamedElement input) {
				return Objects.equal(name, input.getName());
			}
		};
	}

	public Pair<Stereotype, org.eclipse.uml2.uml.Class> getMetaclassExtension(final String stereotypeName, final String metaclassName) {
		Pair<Stereotype, org.eclipse.uml2.uml.Class> result = null;
		Stereotype stereotype = Iterators.find(Iterators.filter(getModel().eAllContents(), Stereotype.class), named(stereotypeName));
		if (stereotype != null) {
			org.eclipse.uml2.uml.Class metaclass = Iterables.find(stereotype.getAllExtendedMetaclasses(), named(metaclassName));
			if (metaclass != null) {
				result = Pair.of(stereotype, metaclass);
			}
		}

		return result;
	}

	public <C extends ElementTypeConfiguration> C getElementTypeConfiguration(Pair<Stereotype, org.eclipse.uml2.uml.Class> metaclassExtension, Class<C> type) {
		ElementTypeConfiguration result = getElementTypeConfiguration(metaclassExtension);
		assertThat("not a " + type.getSimpleName(), result, instanceOf(type));
		return type.cast(result);
	}

	public ElementTypeConfiguration getElementTypeConfiguration(Pair<Stereotype, org.eclipse.uml2.uml.Class> metaclassExtension) {
		return getElementTypeConfiguration(getElementTypeID(metaclassExtension, false));
	}

	public ElementTypeConfiguration getElementTypeConfiguration(Pair<Stereotype, org.eclipse.uml2.uml.Class> metaclassExtension, String visualID) {
		return getElementTypeConfiguration(String.format("%s_%s", getElementTypeID(metaclassExtension, false), visualID));
	}

	protected String getElementTypeID(Pair<Stereotype, org.eclipse.uml2.uml.Class> metaclassExtension, boolean initialLower) {
		String metaclassName = getValidJavaIdentifier(metaclassExtension.getValue().getName());
		if (initialLower) {
			metaclassName = StringExtensions.toFirstLower(metaclassName);
		}
		String stereotypeName = getValidJavaIdentifier(metaclassExtension.getKey().getName());
		if (initialLower) {
			stereotypeName = StringExtensions.toFirstLower(stereotypeName);
		}

		return (metaclassExtension.getKey().getExtendedMetaclasses().size() > 1)
				? String.format("%s.%s_%s", prefix, stereotypeName, metaclassName)
				: String.format("%s.%s", prefix, stereotypeName);
	}

	protected String getElementTypeID(org.eclipse.uml2.uml.Class metaclass) {
		String metaclassName = getValidJavaIdentifier(metaclass.getName());
		return baseElementTypesSet.equals(UML_ELEMENT_TYPES) ? "org.eclipse.papyrus.uml." + metaclassName : baseElementTypesSet.replaceFirst("\\w+$", metaclassName);
	}

	public ElementTypeConfiguration getElementTypeConfiguration(String id) {
		ElementTypeConfiguration result = null;

		for (ElementTypeConfiguration next : getElementTypeSet().getElementTypeConfigurations()) {
			if (id.equals(next.getIdentifier())) {
				result = next;
				break;
			}
		}

		return result;
	}

	public <C extends ElementTypeConfiguration> List<C> getAllElementTypeConfigurations(Pair<Stereotype, org.eclipse.uml2.uml.Class> metaclassExtension, Class<C> type) {
		List<ElementTypeConfiguration> result = getAllElementTypeConfigurations(metaclassExtension);
		assertThat("not " + type.getSimpleName(), result, everyItem(CoreMatchers.<ElementTypeConfiguration> instanceOf(type)));

		@SuppressWarnings("unchecked")
		List<C> resultAsC = (List<C>) result;
		return resultAsC;
	}

	public List<ElementTypeConfiguration> getAllElementTypeConfigurations(Pair<Stereotype, org.eclipse.uml2.uml.Class> metaclassExtension) {
		return getAllElementTypeConfigurations(Pattern.compile(String.format("%s($|_\\w+)", Pattern.quote(getElementTypeID(metaclassExtension, false)))));
	}

	public List<ElementTypeConfiguration> getAllElementTypeConfigurations(Pattern idPattern) {
		List<ElementTypeConfiguration> result = Lists.newArrayListWithExpectedSize(3);

		for (ElementTypeConfiguration next : getElementTypeSet().getElementTypeConfigurations()) {
			if (idPattern.matcher(next.getIdentifier()).find()) {
				result.add(next);
			}
		}

		return result;
	}

	public SpecializationTypeConfiguration assertSpecializationType(Pair<Stereotype, org.eclipse.uml2.uml.Class> metaclassExtension) {
		SpecializationTypeConfiguration result = getElementTypeConfiguration(metaclassExtension, SpecializationTypeConfiguration.class);
		return result;
	}

	public List<SpecializationTypeConfiguration> assertAllSpecializationTypes(Pair<Stereotype, org.eclipse.uml2.uml.Class> metaclassExtension) {
		List<SpecializationTypeConfiguration> result = getAllElementTypeConfigurations(metaclassExtension, SpecializationTypeConfiguration.class);
		return result;
	}

	public StereotypeApplicationMatcherConfiguration assertStereotypeMatcher(SpecializationTypeConfiguration specializationType) {
		MatcherConfiguration result = specializationType.getMatcherConfiguration();
		assertThat("not a stereotype matcher", result, instanceOf(StereotypeApplicationMatcherConfiguration.class));
		return (StereotypeApplicationMatcherConfiguration) result;
	}

	public <C extends AdviceBindingConfiguration> C getAdviceBindingConfiguration(Pair<Stereotype, org.eclipse.uml2.uml.Class> metaclassExtension, Class<C> type) {
		AdviceBindingConfiguration result = getAdviceBindingConfiguration(metaclassExtension);
		assertThat("not a " + type.getSimpleName(), result, instanceOf(type));
		return type.cast(result);
	}

	public AdviceBindingConfiguration getAdviceBindingConfiguration(Pair<Stereotype, org.eclipse.uml2.uml.Class> metaclassExtension) {
		return getAdviceBindingConfiguration(getElementTypeID(metaclassExtension, true));
	}

	public AdviceBindingConfiguration getAdviceBindingConfiguration(String id) {
		AdviceBindingConfiguration result = null;

		for (AdviceBindingConfiguration next : getElementTypeSet().getAdviceBindingsConfigurations()) {
			if (id.equals(next.getIdentifier())) {
				result = next;
				break;
			}
		}

		return result;
	}

	public <C extends AdviceBindingConfiguration> List<C> getAllAdviceBindingConfigurations(Pair<Stereotype, org.eclipse.uml2.uml.Class> metaclassExtension, Class<C> type) {
		List<AdviceBindingConfiguration> result = getAllAdviceBindingConfigurations(metaclassExtension);
		assertThat("not " + type.getSimpleName(), result, everyItem(CoreMatchers.<AdviceBindingConfiguration> instanceOf(type)));

		@SuppressWarnings("unchecked")
		List<C> resultAsC = (List<C>) result;
		return resultAsC;
	}

	public List<AdviceBindingConfiguration> getAllAdviceBindingConfigurations(Pair<Stereotype, org.eclipse.uml2.uml.Class> metaclassExtension) {
		return getAllAdviceBindingConfigurations(Pattern.compile(String.format("%s($|_\\w+)", Pattern.quote(getElementTypeID(metaclassExtension, true)))));
	}

	public List<AdviceBindingConfiguration> getAllAdviceBindingConfigurations(Pattern idPattern) {
		List<AdviceBindingConfiguration> result = Lists.newArrayListWithExpectedSize(3);

		for (AdviceBindingConfiguration next : getElementTypeSet().getAdviceBindingsConfigurations()) {
			if (idPattern.matcher(next.getIdentifier()).find()) {
				result.add(next);
			}
		}

		return result;
	}

	public ApplyStereotypeAdviceConfiguration assertApplyStereotypeAdvice(Pair<Stereotype, org.eclipse.uml2.uml.Class> metaclassExtension) {
		ApplyStereotypeAdviceConfiguration result = getAdviceBindingConfiguration(metaclassExtension, ApplyStereotypeAdviceConfiguration.class);
		return result;
	}

	public List<ApplyStereotypeAdviceConfiguration> assertAllApplyStereotypeAdvices(Pair<Stereotype, org.eclipse.uml2.uml.Class> metaclassExtension) {
		List<ApplyStereotypeAdviceConfiguration> result = getAllAdviceBindingConfigurations(metaclassExtension, ApplyStereotypeAdviceConfiguration.class);
		return result;
	}

	/**
	 * Extends the inherited method to run the profile-to-elementtypes transformation.
	 * 
	 * @see #generateElementTypesConfiguration()
	 */
	@Override
	protected void starting(Description description) {
		super.starting(description);

		// Get some configuration details
		BaseElementTypes basedOn = JUnitUtils.getAnnotation(description, BaseElementTypes.class);
		if (basedOn != null) {
			baseElementTypesSet = basedOn.value();
		}

		// Ensure the registration of the element types that we need
		ElementTypeSetConfigurationRegistry.getInstance();

		generateModel();
	}

	private void generateModel() {
		Identifiers identifiers = new Identifiers();
		identifiers.setPrefix(prefix);
		identifiers.setDiagramElementTypesSet(getBaseElementTypesSet());

		generateModel(identifiers);
	}

	protected void generateModel(Identifiers identifiers) {
		generateElementTypesConfiguration(identifiers);
	}

	protected String getBaseElementTypesSet() {
		return baseElementTypesSet;
	}

	private void generateElementTypesConfiguration(Identifiers identifiers) {
		ElementTypesGenerator elementTypesGenerator = new ElementTypesGenerator(identifiers);
		IStatus status = elementTypesGenerator.generate(getModelURI(), getElementTypesResourceURI());
		assertThat(status.getMessage(), status.getSeverity(), lessThan(IStatus.ERROR));
	}
}
