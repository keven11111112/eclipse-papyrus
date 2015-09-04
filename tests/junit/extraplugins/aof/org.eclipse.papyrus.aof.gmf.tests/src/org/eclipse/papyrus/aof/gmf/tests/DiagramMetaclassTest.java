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
 *******************************************************************************/
package org.eclipse.papyrus.aof.gmf.tests;

import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.papyrus.aof.core.IFactory;
import org.eclipse.papyrus.aof.core.IMetaClass;
import org.eclipse.papyrus.aof.core.tests.MetaClassTest;
import org.eclipse.papyrus.aof.gmf.DiagramFactory;
import org.junit.Test;

public class DiagramMetaclassTest extends MetaClassTest {

	private static final NotationPackage epackage = NotationPackage.eINSTANCE;
	private static final NotationFactory efactory = NotationFactory.eINSTANCE;

	@Override
	protected IFactory createFactory() {
		return new DiagramFactory();
	}

	// Is instance of

	@Test
	public void testBaseIsInstanceOfJavaShape() {
		testIsInstanceOfMetaClass(efactory.createShape(), Shape.class, true);
	}

	@Test
	public void testBaseIsInstanceOfEcoreShape() {
		testIsInstanceOfMetaClass(efactory.createShape(), epackage.getShape(), true);
	}

	// Get default instance

	@Override
	public void testGetDefaultInstanceOfAbstractClass() {
		thrown.expect(IllegalArgumentException.class);
		testGetDefaultInstanceOfMetaClass(epackage.getView());
	}

	@Test
	public void testGetDefaultInstanceOfShape() {
		testGetDefaultInstanceOfMetaClass(epackage.getShape());
	}

	// Set default instance

	@Test
	public void testSetDefaultInstanceOfShape() {
		testSetDefaultInstanceOfMetaClass(epackage.getShape(), efactory.createShape());
	}

	// Property accessor

	@Test
	public void testGetPropertyAccessorForInvalidPropertyType() {
		thrown.expect(IllegalArgumentException.class);
		testGetPropertyAccessorOfMetaClass(Shape.class, new Object(), null);
	}

	@Test
	public void testGetPropertyAccessorForShapeVisibleProperty() {
		testGetPropertyAccessorOfMetaClass(epackage.getShape(), "visible", efactory.createShape(), true);
	}

	@Test
	public void testGetPropertyAccessorForShapeLocationProperty() {
		testGetPropertyAccessorOfMetaClass(epackage.getShape(), epackage.getLocation(), efactory.createShape());
	}

	@Test
	public void testGetPropertyAccessorForShapeSizeProperty() {
		testGetPropertyAccessorOfMetaClass(epackage.getShape(), epackage.getSize(), efactory.createShape());
	}

	@Test
	public void testGetPropertyAccessorForViewChildrenProperty() {
		testGetPropertyAccessorOfMetaClass(epackage.getShape(), DiagramFactory.CHILDREN_PROPERTY, efactory.createShape());
	}

	//
	// Subclass queries
	//

	@Override
	protected IMetaClass<?> getAnyPlatformMetaclass() {
		return factory.getMetaClass(epackage.getShape());
	}

}
