/*****************************************************************************
 * Copyright (c) 2021 Christian W. Damus, CEA LIST, and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Christian W. Damus - bug 570486
 *   
 *****************************************************************************/

package org.eclipse.papyrus.infra.core.internal.architecture.merger.tests;

import static java.util.stream.Collectors.toList;
import static org.eclipse.papyrus.infra.architecture.tests.ArchitectureMatchers.diagramNamed;
import static org.eclipse.papyrus.infra.architecture.tests.ArchitectureMatchers.mViewpointNamed;
import static org.eclipse.papyrus.infra.architecture.tests.ArchitectureMatchers.named;
import static org.eclipse.papyrus.infra.architecture.tests.merged.MergedArchitectureDomainTest.merge;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assume.assumeThat;

import java.net.URL;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.infra.architecture.representation.PapyrusRepresentationKind;
import org.eclipse.papyrus.infra.core.architecture.ADElement;
import org.eclipse.papyrus.infra.core.architecture.ArchitectureContext;
import org.eclipse.papyrus.infra.core.architecture.ArchitectureDescriptionLanguage;
import org.eclipse.papyrus.infra.core.architecture.ArchitectureDomain;
import org.eclipse.papyrus.infra.core.architecture.ArchitecturePackage;
import org.eclipse.papyrus.infra.core.architecture.Concern;
import org.eclipse.papyrus.infra.core.architecture.RepresentationKind;
import org.eclipse.papyrus.infra.core.architecture.Stakeholder;
import org.eclipse.papyrus.infra.core.architecture.merged.MergedArchitectureContext;
import org.eclipse.papyrus.infra.core.architecture.merged.MergedArchitectureDomain;
import org.eclipse.papyrus.infra.core.architecture.merged.MergedArchitectureViewpoint;
import org.eclipse.papyrus.infra.core.architecture.util.ArchitectureResourceFactory;
import org.eclipse.papyrus.infra.gmfdiag.representation.PapyrusDiagram;
import org.eclipse.papyrus.infra.gmfdiag.representation.RepresentationPackage;
import org.eclipse.papyrus.infra.tools.util.Iterators2;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Iterables;

/**
 * Tests covering the explicit merge algorithm.
 */
public class ArchitectureDomainMergerTest {

	private ResourceSet resourceSet;
	private ArchitectureDomain extendedDomain;
	private ArchitectureDomain intermediateDomain;
	private ArchitectureDomain extendingDomain;

	@Test
	public void isMerged() {
		MergedArchitectureDomain domain = mergeDomain();
		assertThat("Domain not merged", domain.isMerged(), is(true));
	}

	@Test
	public void getContexts() {
		MergedArchitectureDomain domain = mergeDomain();
		assumeThat("Domain not merged", domain.isMerged(), is(true));

		assertThat("Wrong number of contexts", domain.getContexts().size(), is(2));
		MergedArchitectureContext context = Iterables.getFirst(domain.getContexts(), null);

		assertThat("Merge changed the context name", context.getName(), is("adl"));
	}

	@Test
	public void mergeContextName() {
		// Remove names of the extension graph
		rename(extendedDomain, ArchitectureContext.class, "adl", null);
		rename(intermediateDomain, ArchitectureContext.class, "midadl", null);

		MergedArchitectureDomain domain = mergeDomain();
		assumeThat("Domain not merged", domain.isMerged(), is(true));

		assertThat("Wrong number of contexts", domain.getContexts().size(), is(2));
		MergedArchitectureContext context = Iterables.getFirst(domain.getContexts(), null);

		assertThat("Merge did not set the context name", context.getName(), is("myadl"));
	}

	@SuppressWarnings("unchecked")
	@Test
	public void collectViewpoints() {
		MergedArchitectureDomain domain = mergeDomain();
		assumeThat("Domain not merged", domain.isMerged(), is(true));

		assertThat("Wrong number of contexts", domain.getContexts().size(), is(2));
		MergedArchitectureContext context = Iterables.get(domain.getContexts(), 1, null);

		assertThat("Wrong number of collected viewpoints", context.getViewpoints().size(), is(4));
		assertThat(context.getViewpoints(), hasItems(
				mViewpointNamed("viewpoint3"), mViewpointNamed("viewpoint4"), mViewpointNamed("viewpoint5"), mViewpointNamed("viewpoint6")));
	}

	@SuppressWarnings("unchecked")
	@Test
	public void mergeViewpoints() {
		// Viewpoints are merged by name in merged contexts
		MergedArchitectureDomain domain = mergeDomain();
		assumeThat("Domain not merged", domain.isMerged(), is(true));

		assertThat("Wrong number of contexts", domain.getContexts().size(), is(2));
		MergedArchitectureContext context = Iterables.getFirst(domain.getContexts(), null);

		assertThat("Wrong number of merged viewpoints", context.getViewpoints().size(), is(2));
		assertThat(context.getViewpoints(), hasItems(
				mViewpointNamed("viewpoint1"), mViewpointNamed("viewpoint2")));

		MergedArchitectureViewpoint viewpoint1 = Iterables.getFirst(context.getViewpoints(), null);
		assertThat("Wrong number of diagrams in merged viewpoint", viewpoint1.getRepresentationKinds().size(), is(2));
		assertThat(viewpoint1.getRepresentationKinds(), hasItems(
				diagramNamed("diagram1"), diagramNamed("diagram3")));

		List<ArchitectureContext> owners = viewpoint1.getRepresentationKinds().stream()
				.map(EObject::eContainer)
				.filter(ArchitectureContext.class::isInstance).map(ArchitectureContext.class::cast)
				.distinct()
				.collect(toList());
		assertThat("Not an unique context owning the merged representation kinds", owners.size(), is(1));
		assertThat("Wrong owning context (by name)", owners.get(0).getName(), is("adl"));
		assertThat("wrong owning context (by identity)", owners.get(0), is(context.getAdapter(ArchitectureContext.class)));
	}
	
	@Test
	public void mergeRepresentationKinds() {
		MergedArchitectureDomain domain = mergeDomain();
		assumeThat("Domain not merged", domain.isMerged(), is(true));

		assertThat("Wrong number of contexts", domain.getContexts().size(), is(2));
		MergedArchitectureContext context = Iterables.getFirst(domain.getContexts(), null);

		assertThat("Wrong number of merged viewpoints", context.getViewpoints().size(), is(2));
		MergedArchitectureViewpoint viewpoint1 = Iterables.getFirst(context.getViewpoints(), null);
		
		assertThat("Wrong number of diagrams in merged viewpoint", viewpoint1.getRepresentationKinds().size(), is(2));

		List<Concern> concerns = viewpoint1.getRepresentationKinds().stream()
				.map(RepresentationKind::getConcerns).flatMap(Collection::stream)
				.distinct()
				.collect(toList());
		assertThat("Not an unique concern linked to the merged representation kinds", concerns.size(), is(1));
		assertThat("Wrong concern (by name)", concerns.get(0).getName(), is("concern"));
		assertThat("wrong concern (by identity)", concerns.get(0).getDomain(), is(domain.getAdapter(ArchitectureDomain.class)));
	}

	@SuppressWarnings("unchecked")
	@Test
	public void collectStakeholdersAndConcerns() {
		// Rename some to make sure they're not merged
		rename(extendingDomain, Stakeholder.class, "user", "designer");
		rename(extendingDomain, Concern.class, "concern", "designing");

		MergedArchitectureDomain domain = mergeDomain();
		assumeThat("Domain not merged", domain.isMerged(), is(true));

		assertThat("Wrong number of collected stakeholders", domain.getStakeholders().size(), is(2));
		assertThat(domain.getStakeholders(), hasItems(named("user"), named("designer")));
		assertThat("Wrong number of collected concerns", domain.getConcerns().size(), is(2));
		assertThat(domain.getConcerns(), hasItems(named("concern"), named("designing")));

		// All references to these objects are uniquely to these four instances (nothing from the source models)
		Set<Stakeholder> allStakeholderReferences = new HashSet<>();
		Set<Concern> allConcernReferences = new HashSet<>();
		domain.getAdapter(EObject.class).eAllContents().forEachRemaining(e -> {
			if (e instanceof Stakeholder) {
				allStakeholderReferences.add((Stakeholder) e);
			} else if (e instanceof Concern) {
				allConcernReferences.add((Concern) e);
			} else {
				e.eCrossReferences().forEach(xref -> {
					if (xref instanceof Stakeholder) {
						allStakeholderReferences.add((Stakeholder) xref);
					} else if (xref instanceof Concern) {
						allConcernReferences.add((Concern) xref);
					}
				});
			}
		});

		assertThat("Wrong merging of stakeholders or leaking of source stakeholders", allStakeholderReferences, is(Set.copyOf(domain.getStakeholders())));
		assertThat("Wrong merging of concerns or leaking of source concerns", allConcernReferences, is(Set.copyOf(domain.getConcerns())));
	}

	@Test
	public void mergeDiagramParent() {
		// Rename some to make sure they're not merged
		rename(extendingDomain, Stakeholder.class, "user", "designer");
		rename(extendingDomain, Concern.class, "concern", "designing");

		MergedArchitectureDomain domain = mergeDomain();
		assumeThat("Domain not merged", domain.isMerged(), is(true));

		assertThat("Wrong number of contexts", domain.getContexts().size(), is(2));
		ArchitectureDescriptionLanguage adl = Iterables.getFirst(domain.getContexts(), null).getAdapter(ArchitectureDescriptionLanguage.class);

		assertThat("Wrong number of merged representation kinds", adl.getRepresentationKinds().size(), is(4));
		PapyrusRepresentationKind diagram3 = (PapyrusDiagram) adl.getRepresentationKinds().get(2);
		PapyrusRepresentationKind diagram4 = (PapyrusDiagram) adl.getRepresentationKinds().get(3);
		assertThat("Diagrams merged in the wrong order", diagram3.getName(), is("diagram3"));
		assertThat("Diagrams merged in the wrong order", diagram4.getName(), is("diagram4"));
		
		assertThat("PapyrusDiagram::parent reference not merged", diagram4.getParent(), sameInstance(diagram3));
	}

	//
	// Test framework
	//

	@Before
	public void loadTestModel() {
		// Ensure registration of the packages we use
		resourceSet = new ResourceSetImpl();

		if (!EcorePlugin.IS_ECLIPSE_RUNNING) {
			// Ensure registration of the packages we use
			ArchitecturePackage.eINSTANCE.getADElement();
			RepresentationPackage.eINSTANCE.getPapyrusDiagram();
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("architecture", new ArchitectureResourceFactory());
		}

		URL url = ArchitectureDomainMergerTest.class.getResource("extending.architecture");

		Resource resource = resourceSet.getResource(URI.createURI(url.toExternalForm()), true);
		extendingDomain = (ArchitectureDomain) resource.getContents().get(0);
		EcoreUtil.resolveAll(resourceSet);

		resource = resourceSet.getResource(resource.getURI().trimSegments(1).appendSegment("intermediate.architecture"), false);
		intermediateDomain = (ArchitectureDomain) resource.getContents().get(0);

		resource = resourceSet.getResource(resource.getURI().trimSegments(1).appendSegment("extended.architecture"), false);
		extendedDomain = (ArchitectureDomain) resource.getContents().get(0);
	}

	MergedArchitectureDomain mergeDomain() {
		List<MergedArchitectureDomain> result = merge(extendedDomain);
		assertThat("Wrong many domains resultimg from the merge.", result.size(), is(1));
		return result.get(0);
	}

	<T extends ADElement> T rename(ArchitectureDomain domain, Class<T> type, String oldName, String newName) {
		Predicate<EObject> filter = type::isInstance;
		filter = filter.and(e -> oldName.equals(e.eGet(ArchitecturePackage.Literals.AD_ELEMENT__NAME)));

		T result = (T) Iterators2.stream(EcoreUtil.<EObject> getAllContents(Set.of(domain))).filter(filter)
				.findAny().map(type::cast).orElse(null);
		assertThat("Object not found to rename: " + oldName, result, notNullValue());

		result.setName(newName);

		return result;
	}

}
