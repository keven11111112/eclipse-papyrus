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

import static com.google.common.collect.Iterables.transform;
import static org.eclipse.papyrus.junit.matchers.MoreMatchers.isEmpty;
import static org.eclipse.papyrus.junit.matchers.MoreMatchers.regexContains;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;
import java.util.Set;

import org.eclipse.papyrus.infra.elementtypesconfigurations.ElementtypesconfigurationsPackage;
import org.eclipse.papyrus.infra.elementtypesconfigurations.IconEntry;
import org.eclipse.papyrus.infra.elementtypesconfigurations.SpecializationTypeConfiguration;
import org.eclipse.papyrus.infra.emf.utils.EMFFunctions;
import org.eclipse.papyrus.junit.utils.rules.PluginResource;
import org.eclipse.papyrus.uml.tools.elementtypesconfigurations.applystereotypeadviceconfiguration.ApplyStereotypeAdviceConfiguration;
import org.eclipse.papyrus.uml.tools.elementtypesconfigurations.stereotypeapplicationmatcherconfiguration.StereotypeApplicationMatcherConfiguration;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.edit.UMLEditPlugin;
import org.eclipse.xtext.xbase.lib.Pair;
import org.junit.ClassRule;
import org.junit.Test;

import com.google.common.collect.ImmutableSet;

/**
 * Test cases for diagram-specific element types generation for UML profiles.
 */
@PluginResource("/resources/j2ee.profile.uml")
@BaseElementTypes("org.eclipse.papyrus.uml.diagram.usecase.elementTypeSet")
public class DiagramSpecificElementTypesGenerationTest {

	@ClassRule
	public static final ModelGenFixture fixture = new ModelGenFixture();

	public DiagramSpecificElementTypesGenerationTest() {
		super();
	}

	@Test
	public void elementTypesGenerated() {
		Pair<Stereotype, Class> userActor = fixture.getMetaclassExtension("User", "Actor");
		fixture.assertAllSpecializationTypes(userActor);
		assertThat(fixture.getElementTypeSet().getMetamodelNsURI(), is(UMLPackage.eNS_URI));
	}

	/**
	 * Verifies that diagram-specific element types are generated with both a semantic parent and a visual parent.
	 * 
	 * @see https://bugs.eclipse.org/bugs/show_bug.cgi?id=461717
	 */
	@Test
	public void elementTypeSpecializedTypes_bug461717() {
		Pair<Stereotype, Class> userActor = fixture.getMetaclassExtension("User", "Actor");
		List<SpecializationTypeConfiguration> specializationTypes = fixture.assertAllSpecializationTypes(userActor);
		assertThat("No specialization types generated", specializationTypes, not(isEmpty()));

		String semanticParentID = fixture.prefix + ".User";
		String idPrefix = semanticParentID + "_";

		for (SpecializationTypeConfiguration next : specializationTypes) {
			assertThat(next.getIdentifier(), startsWith(idPrefix));

			List<String> specializedTypeIDs = next.getSpecializedTypesID();
			assertThat(specializedTypeIDs.size(), is(2));
			assertThat(specializedTypeIDs.get(0), is(semanticParentID));
			assertThat(specializedTypeIDs.get(1), regexContains("Actor_\\d{4}$")); // a visual ID
		}
	}

	@Test
	public void distinctHintsGenerated() {
		Pair<Stereotype, Class> userActor = fixture.getMetaclassExtension("User", "Actor");
		List<SpecializationTypeConfiguration> types = fixture.assertAllSpecializationTypes(userActor);
		Set<String> hints = ImmutableSet.copyOf(transform(types, EMFFunctions.getFeature(ElementtypesconfigurationsPackage.Literals.ELEMENT_TYPE_CONFIGURATION__HINT, String.class)));
		assertThat(hints, hasItems("2011", "2012"));
	}

	@Test
	public void iconGenerated() {
		Pair<Stereotype, Class> userActor = fixture.getMetaclassExtension("User", "Actor");
		List<SpecializationTypeConfiguration> types = fixture.assertAllSpecializationTypes(userActor);
		for (SpecializationTypeConfiguration type : types) {
			IconEntry icon = type.getIconEntry();
			assertThat(icon.getBundleId(), is(UMLEditPlugin.getPlugin().getSymbolicName()));
			assertThat(icon.getIconPath(), containsString("obj16/Actor.gif"));
		}
	}

	@Test
	public void stereotypeMatcherGenerated() {
		Pair<Stereotype, Class> userActor = fixture.getMetaclassExtension("User", "Actor");
		List<SpecializationTypeConfiguration> types = fixture.assertAllSpecializationTypes(userActor);
		for (SpecializationTypeConfiguration type : types) {
			StereotypeApplicationMatcherConfiguration matcher = fixture.assertStereotypeMatcher(type);
			assertThat(matcher.getStereotypesQualifiedNames(), hasItem("j2ee::User"));
		}
	}

	@Test
	public void stereotypeAdviceGenerated() {
		Pair<Stereotype, Class> userActor = fixture.getMetaclassExtension("User", "Actor");
		List<ApplyStereotypeAdviceConfiguration> advices = fixture.assertAllApplyStereotypeAdvices(userActor);
		for (ApplyStereotypeAdviceConfiguration advice : advices) {
			String visualID = advice.getIdentifier().substring(advice.getIdentifier().lastIndexOf('_') + 1);
			assertThat(advice.getTarget(), is(fixture.getElementTypeConfiguration(userActor, visualID)));
			assertThat(advice.getStereotypesToApply(), not(isEmpty()));
			assertThat(advice.getStereotypesToApply().get(0).getRequiredProfiles(), hasItem("j2ee"));
			assertThat(advice.getStereotypesToApply().get(0).getStereotypeQualifiedName(), is("j2ee::User"));
		}
	}
}
