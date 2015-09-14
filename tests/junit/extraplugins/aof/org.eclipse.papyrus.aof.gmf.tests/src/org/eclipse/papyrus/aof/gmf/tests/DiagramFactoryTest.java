/*******************************************************************************
 *  Copyright (c) 2015 ESEO, Christian W. Damus, and others.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *     Olivier Beaudoux - initial API and implementation
 *     Christian W. Damus - initial tests for GMF implementation of AOF
 *     Christian W. Damus - bug 476683
 *******************************************************************************/
package org.eclipse.papyrus.aof.gmf.tests;

import static org.eclipse.papyrus.aof.core.tests.matchers.BoxMatchers.sameAs;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assume.assumeThat;

import org.eclipse.emf.common.util.EList;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.Size;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.aof.core.IBox;
import org.eclipse.papyrus.aof.core.IConstraints;
import org.eclipse.papyrus.aof.core.IFactory;
import org.eclipse.papyrus.aof.core.IOne;
import org.eclipse.papyrus.aof.core.IOption;
import org.eclipse.papyrus.aof.core.tests.FactoryTest;
import org.eclipse.papyrus.aof.core.utils.Boxes;
import org.eclipse.papyrus.aof.gmf.DiagramFactory;
import org.junit.Test;

public class DiagramFactoryTest extends FactoryTest {

	private static final NotationPackage epackage = NotationPackage.eINSTANCE;
	private static final NotationFactory efactory = NotationFactory.eINSTANCE;

	@Override
	protected IFactory createFactory() {
		return new DiagramFactory();
	}

	// Meta-class access

	@Test
	public void testFactoryForGetMetaClassOnJavaShape() {
		testFactoryForGetMetaClass(Shape.class);
	}

	@Test
	public void testFactoryForGetMetaClassOnEcoreShape() {
		testFactoryForGetMetaClass(epackage.getShape());
	}

	// Property box

	@Test
	public void testCreatePropertyBoxOnShapeVisibleProperty() {
		Shape shape = efactory.createShape();
		IBox<Boolean> box = factory.createPropertyBox(shape, "visible");
		assertEquals(IConstraints.ONE, box.getConstraints());
		IOne<Boolean> one = (IOne<Boolean>) box;

		assumeThat(one.get(), is(true));

		shape.setVisible(false);

		assertThat(one.get(), is(false));
	}

	@Test
	public void testCreatePropertyBoxOnViewChildrenProperty() {
		Shape shape = efactory.createShape();
		IBox<View> box = factory.createPropertyBox(shape, DiagramFactory.CHILDREN_PROPERTY);
		assertEquals(IConstraints.ORDERED_SET, box.getConstraints());

		assumeThat(box, sameAs(Boxes.emptyOrderedSet()));

		Shape child = efactory.createShape();

		@SuppressWarnings("unchecked")
		EList<Node> children = shape.getPersistedChildren();
		children.add(child);

		assertThat(box, sameAs(Boxes.with(factory).immutableOrderedSet(child)));
	}

	@Test
	public void testCreatePropertyBoxOnShapeLocationProperty() {
		Shape shape = efactory.createShape();
		IBox<Location> box = factory.createPropertyBox(shape, epackage.getLocation());
		assertEquals(IConstraints.OPTION, box.getConstraints());
		IOption<Location> option = (IOption<Location>) box;

		assumeThat(option.length(), is(0));

		Bounds bounds = efactory.createBounds();
		bounds.setX(42);

		shape.setLayoutConstraint(bounds);

		assertThat(option, sameAs(Boxes.with(factory).immutableOption(bounds)));

		IBox<Integer> x = option.collectMutable(factory, epackage.getLocation(), epackage.getLocation_X());
		assertThat(x.get(0), is(42));
	}

	@Test
	public void testCreatePropertyBoxOnShapeSizeProperty() {
		Shape shape = efactory.createShape();
		IBox<Size> box = factory.createPropertyBox(shape, epackage.getSize());
		assertEquals(IConstraints.OPTION, box.getConstraints());
		IOption<Size> option = (IOption<Size>) box;

		assumeThat(option.length(), is(0));

		Bounds bounds = efactory.createBounds();
		bounds.setWidth(42);

		shape.setLayoutConstraint(bounds);

		assertThat(option, sameAs(Boxes.with(factory).immutableOption(bounds)));

		IBox<Integer> width = option.collectMutable(factory, epackage.getSize(), epackage.getSize_Width());
		assertThat(width.get(0), is(42));
	}

}
