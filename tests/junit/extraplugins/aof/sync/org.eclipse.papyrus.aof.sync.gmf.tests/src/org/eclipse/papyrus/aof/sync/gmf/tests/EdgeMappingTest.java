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
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assume.assumeThat;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.papyrus.aof.sync.gmf.internal.EdgeMapping;
import org.junit.Test;

/**
 * Test cases for the {@link EdgeMapping} class.
 */
public class EdgeMappingTest extends AbstractMappingTest<Edge> {

	public EdgeMappingTest() {
		super();
	}

	@Test
	public void mapElement() {
		assertFeature(NotationPackage.Literals.VIEW__ELEMENT,
				EcorePackage.Literals.EREFERENCE__EOPPOSITE,
				EcorePackage.Literals.EMODEL_ELEMENT__EANNOTATIONS);
	}

	@Test
	public void mapSource() {
		mapEnd(NotationPackage.Literals.EDGE__SOURCE);
	}

	@Test
	public void mapTarget() {
		mapEnd(NotationPackage.Literals.EDGE__TARGET);
	}

	void mapEnd(EReference reference) {
		Node fromEnd = (Node) getFrom().eGet(reference);
		Node toEnd = (Node) getTo().eGet(reference);

		assumeThat(fromEnd, notNullValue());
		assertThat(toEnd, not(fromEnd)); // not the same object

		assertThat(toEnd.getType(), is(fromEnd.getType()));
		assertThat(toEnd.getElement(), is(fromEnd.getElement()));

		Node newEnd = createNode("3008", EcorePackage.Literals.EANNOTATION);
		getFrom().eSet(reference, newEnd);

		assertThat(toEnd.getType(), is(fromEnd.getType()));
		assertThat(toEnd.getElement(), is(fromEnd.getElement()));

		// The reverse direction does not sync

		getTo().eSet(reference, createNode("2008", EcorePackage.Literals.EPACKAGE));

		assertThat(getFrom().eGet(reference), is(newEnd));
	}

	Node createNode(String type, EObject element) {
		Node result = notation.createNode();
		result.setType(type);
		result.setElement(element);
		result.setLayoutConstraint(notation.createBounds());
		return result;
	}
}
