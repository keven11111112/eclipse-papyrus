/*****************************************************************************
 * Copyright (c) 2016 Christian W. Damus and others.
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

package org.eclipse.papyrus.infra.emf.resource;

import static java.util.Collections.emptySet;
import static java.util.Collections.singleton;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.eclipse.emf.common.util.URI;
import org.eclipse.papyrus.infra.emf.internal.resource.CrossReferenceIndex;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.junit.Test;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.SetMultimap;

/**
 * Tests for the {@link CrossReferenceIndex} class, the full indexer.
 */
public class CrossReferenceIndexTest extends AbstractCrossReferenceIndexTest {

	/**
	 * Initializes me.
	 */
	public CrossReferenceIndexTest() {
		super(false); // Always the full indexer
	}

	//
	// Don't need to load any resources for these tests
	//

	@Test
	public void isShard() throws Exception {
		assertThat(index().isShard(uri("package1/packageA/foo.uml")), is(true));
		assertThat(index().isShard(uri("package1/packageA.uml")), is(true));
		assertThat(index().isShard(uri("package1.uml")), is(true));
		assertThat(index().isShard(uri("root.uml")), is(false));
	}

	@Test
	public void shards() throws Exception {
		assertThat(index().getShards(uri("package1/packageA/foo.uml")), is(emptySet()));
		assertThat(index().getShards(uri("package1/packageA.uml")), is(singleton(uri("package1/packageA/foo.uml"))));
		assertThat(index().getShards(uri("package1.uml")), is(singleton(uri("package1/packageA.uml"))));
		assertThat(index().getShards(uri("root.uml")), // This one has two shards
				is(ImmutableSet.of(uri("package1.uml"), uri("package2.uml"))));
	}

	@Test
	public void parentShards() throws Exception {
		assertThat(index().getParents(uri("package1/packageA/foo.uml")), is(singleton(uri("package1/packageA.uml"))));
		assertThat(index().getParents(uri("package1/packageA.uml")), is(singleton(uri("package1.uml"))));
		assertThat(index().getParents(uri("package1.uml")), is(singleton(uri("root.uml"))));
		assertThat(index().getParents(uri("root.uml")), is(emptySet()));
	}

	@Test
	public void roots() throws Exception {
		assertThat(index().getRoots(uri("package1/packageA/foo.uml")), is(singleton(uri("root.uml"))));
		assertThat(index().getRoots(uri("package1/packageA.uml")), is(singleton(uri("root.uml"))));
		assertThat(index().getRoots(uri("package1.uml")), is(singleton(uri("root.uml"))));

		// A root has no parents and, therefore, no root
		assertThat(index().getRoots(uri("root.uml")), is(emptySet()));

		// And this one has nothing to do with shards
		assertThat(index().getRoots(uri("referencing.uml")), is(emptySet()));
	}

	@Test
	public void outgoingReferences_givenURI() throws Exception {
		// Shard relationship (cross-resource containment) is not a cross-reference
		assertThat(index().getOutgoingCrossReferences(uri("package1.uml")), is(emptySet()));

		// We find cross-references to non-workspace resources, though those aren't indexed
		assertThat(index().getOutgoingCrossReferences(uri("root.uml")),
				is(singleton(URI.createURI(UMLResource.ECORE_PROFILE_URI))));

		// This has a cross-reference in the class generalization
		assertThat(index().getOutgoingCrossReferences(uri("referencing.uml")),
				is(singleton(uri("package2/packageB/bar.uml"))));

		// This API is generalized for the Papyrus one-file
		assertThat(index().getOutgoingCrossReferences(uri("referencing.di")),
				is(singleton(uri("package2/packageB/bar.di"))));
	}

	@Test
	public void incomingReferences_givenURI() throws Exception {
		// Parent pointer in shard annotation is not a cross-reference
		assertThat(index().getIncomingCrossReferences(uri("root.uml")), is(emptySet()));
		assertThat(index().getIncomingCrossReferences(uri("package1.uml")), is(emptySet()));

		// This has a cross-reference in the class generalization
		assertThat(index().getIncomingCrossReferences(uri("package2/packageB/bar.uml")),
				is(singleton(uri("referencing.uml"))));

		// This API is generalized for the Papyrus one-file
		assertThat(index().getIncomingCrossReferences(uri("package2/packageB/bar.di")),
				is(singleton(uri("referencing.di"))));
	}

	@Test
	public void outgoingReferences() throws Exception {
		SetMultimap<URI, URI> xrefs = index().getOutgoingCrossReferences();

		// Shard relationship (cross-resource containment) is not a cross-reference
		assertThat(xrefs.get(uri("package1.uml")), is(emptySet()));

		// We find cross-references to non-workspace resources, though those aren't indexed
		assertThat(xrefs.get(uri("root.uml")),
				is(singleton(URI.createURI(UMLResource.ECORE_PROFILE_URI))));

		// This has a cross-reference in the class generalization
		assertThat(xrefs.get(uri("referencing.uml")),
				is(singleton(uri("package2/packageB/bar.uml"))));

		// This API is *not* generalized for the Papyrus one-file
		assertThat(xrefs.get(uri("referencing.di")), is(emptySet()));
	}

	@Test
	public void incomingReferences() throws Exception {
		SetMultimap<URI, URI> xrefs = index().getIncomingCrossReferences();

		// Parent pointer in shard annotation is not a cross-reference
		assertThat(xrefs.get(uri("root.uml")), is(emptySet()));
		assertThat(xrefs.get(uri("package1.uml")), is(emptySet()));

		// This has a cross-reference in the class generalization
		assertThat(xrefs.get(uri("package2/packageB/bar.uml")),
				is(singleton(uri("referencing.uml"))));

		// This API is *not* generalized for the Papyrus one-file
		assertThat(xrefs.get(uri("package2/packageB/bar.di")), is(emptySet()));
	}
}
