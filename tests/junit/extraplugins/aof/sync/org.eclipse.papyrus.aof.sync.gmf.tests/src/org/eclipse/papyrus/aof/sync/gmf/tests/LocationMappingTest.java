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

import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.papyrus.aof.sync.gmf.internal.LocationMapping;
import org.junit.Test;

/**
 * Test cases for the {@link LocationMapping} class.
 */
public class LocationMappingTest extends AbstractMappingTest<Location> {

	public LocationMappingTest() {
		super();
	}

	@Test
	public void mapX() {
		assertFeature(NotationPackage.Literals.LOCATION__X, 42, 17);
	}

	@Test
	public void mapY() {
		assertFeature(NotationPackage.Literals.LOCATION__Y, 42, 17);
	}
}
