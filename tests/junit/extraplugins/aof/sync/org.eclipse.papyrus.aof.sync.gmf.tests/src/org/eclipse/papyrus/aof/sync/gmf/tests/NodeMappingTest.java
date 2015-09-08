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

package org.eclipse.papyrus.aof.sync.gmf.tests;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assume.assumeThat;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.Size;
import org.eclipse.papyrus.aof.sync.gmf.internal.NodeMapping;
import org.junit.Test;

/**
 * Test cases for the {@link NodeMapping} class.
 */
public class NodeMappingTest extends AbstractMappingTest<Node> {

	public NodeMappingTest() {
		super();
	}

	@Test
	public void mapElement() {
		assertFeature(NotationPackage.Literals.VIEW__ELEMENT,
				EcorePackage.Literals.EMODEL_ELEMENT,
				EcorePackage.Literals.EATTRIBUTE);
	}

	@Test
	public void mapChildren() {
		EStructuralFeature feature = NotationPackage.Literals.VIEW__PERSISTED_CHILDREN;

		List<Node> children = Arrays.asList(
				createAttrNode(EcorePackage.Literals.EDATA_TYPE__SERIALIZABLE),
				createAttrNode(EcorePackage.Literals.ECLASSIFIER__INSTANCE_CLASS_NAME));

		assumeThat(getFrom().eGet(feature), is(Collections.EMPTY_LIST));
		assumeThat(getTo().eGet(feature), is(getFrom().eGet(feature)));

		getFrom().eSet(feature, children);

		@SuppressWarnings("unchecked")
		List<Node> toChildren = (List<Node>) getTo().eGet(feature);
		assertThat(toChildren.size(), is(2));
		assertThat(toChildren.get(0).getType(), is("3001"));
		assertThat(toChildren.get(0).getElement(), is(EcorePackage.Literals.EDATA_TYPE__SERIALIZABLE));
		assertThat(toChildren.get(1).getType(), is("3001"));
		assertThat(toChildren.get(1).getElement(), is(EcorePackage.Literals.ECLASSIFIER__INSTANCE_CLASS_NAME));

		// But, they are not actually the same nodes!
		assertThat(toChildren, not(children));

		// The reverse direction does not sync

		toChildren.add(createAttrNode(EcorePackage.Literals.ECLASSIFIER__DEFAULT_VALUE));

		assertThat(getFrom().eGet(feature), is(children));
	}

	Node createAttrNode(EObject element) {
		Node result = NotationFactory.eINSTANCE.createNode();
		result.setType("3001");
		result.setElement(element);
		result.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		return result;
	}

	@Test
	public void mapLocation() {
		Location fromLoc = (Location) getFrom().getLayoutConstraint();
		Location toLoc = (Location) getTo().getLayoutConstraint();

		// Not the same object
		assertThat(toLoc, not(fromLoc));

		assertFeature(fromLoc, toLoc, NotationPackage.Literals.LOCATION__X, 42, 17);
		assertFeature(fromLoc, toLoc, NotationPackage.Literals.LOCATION__Y, 42, 17);
	}

	@Test
	public void mapSize() {
		Size fromSize = (Size) getFrom().getLayoutConstraint();
		Size toSize = (Size) getTo().getLayoutConstraint();

		// Not the same object
		assertThat(toSize, not(fromSize));

		assertFeature(fromSize, toSize, NotationPackage.Literals.SIZE__WIDTH, 42, 17);
		assertFeature(fromSize, toSize, NotationPackage.Literals.SIZE__HEIGHT, 42, 17);
	}
}
