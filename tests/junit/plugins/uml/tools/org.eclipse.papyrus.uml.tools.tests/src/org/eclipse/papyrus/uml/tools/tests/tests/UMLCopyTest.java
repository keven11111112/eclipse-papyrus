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

package org.eclipse.papyrus.uml.tools.tests.tests;

import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Arrays;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.infra.core.clipboard.ICopierFactory;
import org.eclipse.papyrus.junit.utils.rules.HouseKeeper;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.InterfaceRealization;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.util.UMLUtil;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

/**
 * Test cases for the UML-specific tuning of the {@link EcoreUtil.Copier}
 * used by the Papyrus copy/paste infrastructure.
 */
public class UMLCopyTest {

	@Rule
	public final HouseKeeper houseKeeper = new HouseKeeper();

	private ResourceSet rset;

	private Package model;
	private Interface foo;
	private Class bar;
	private InterfaceRealization rlz;

	/**
	 * Initializes me.
	 */
	public UMLCopyTest() {
		super();
	}

	@Test
	public void copyingInterfaceRealizationDoesNotCorruptTheModel() {
		EcoreUtil.Copier copier = ICopierFactory.getInstance(rset).get();

		copier.copyAll(Arrays.asList(foo, bar));
		copier.copyReferences();

		InterfaceRealization copy = (InterfaceRealization) copier.get(rlz);

		// Verify the copy
		assertThat(copy.getImplementingClassifier(), both(notNullValue()).and(is(copier.get(bar))));
		assertThat(copy.getContract(), both(notNullValue()).and(is(copier.get(foo))));

		// Verify the non-corruption
		assertThat(copy.getClients().size(), is(1));
	}

	//
	// Nested types
	//

	@Before
	public void initFixture() {
		rset = houseKeeper.createResourceSet();

		model = UMLUtil.load(rset,
				URI.createPlatformPluginURI("org.eclipse.papyrus.uml.tools.tests/resources/uml/copy.uml", true),
				UMLPackage.Literals.PACKAGE);
		foo = (Interface) model.getOwnedType("Foo");
		bar = (Class) model.getOwnedType("Bar");
		rlz = bar.getInterfaceRealization(null, foo);
	}
}
