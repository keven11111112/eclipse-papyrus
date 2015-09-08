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

import static org.eclipse.papyrus.junit.matchers.MoreMatchers.emptyIterable;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assume.assumeThat;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.aof.sync.gmf.internal.DiagramMapping;
import org.junit.Test;

/**
 * Test cases for the {@link DiagramMapping} class.
 */
public class DiagramMappingTest extends AbstractMappingTest<Diagram> {

	public DiagramMappingTest() {
		super();
	}

	@Test
	public void notMapElement() {
		// The Diagram's element is *not* mapped

		assumeThat(getFrom().getElement(), notNullValue());
		assumeThat(getTo().getElement(), is(getFrom().getElement()));

		EObject oldElement = getFrom().getElement();
		getFrom().setElement(NotationPackage.eINSTANCE);

		assertThat(getTo().getElement(), is(oldElement));
	}

	@Test
	public void mapEdges() {
		mapContents(NotationPackage.Literals.DIAGRAM__PERSISTED_EDGES);
	}

	@Test
	public void mapNodes() {
		mapContents(NotationPackage.Literals.VIEW__PERSISTED_CHILDREN);
	}

	void mapContents(EReference reference) {
		@SuppressWarnings("unchecked")
		List<View> fromViews = (List<View>) getFrom().eGet(reference);
		@SuppressWarnings("unchecked")
		List<View> toViews = (List<View>) getTo().eGet(reference);

		assumeThat(fromViews, not(emptyIterable()));
		assertThat(toViews.size(), is(fromViews.size()));

		Iterator<View> fromViewIter = fromViews.iterator();
		toViews.stream().forEach(toView -> {
			View fromView = fromViewIter.next();
			assertThat(toView.getType(), is(fromView.getType()));
			assertThat(toView.getElement(), is(fromView.getElement()));

			assertThat(toView, not(fromView)); // not the same views
		});

		// The reverse direction does not sync

		List<View> originalFromViews = new ArrayList<>(fromViews);
		toViews.add(EcoreUtil.copy(toViews.get(0)));
		assertThat(fromViews, is(originalFromViews));
	}
}
