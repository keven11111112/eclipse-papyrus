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

import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.Size;
import org.junit.Test;

/**
 * @author damus
 *
 */
public class SizeMappingTest extends AbstractMappingTest<Size> {

	public SizeMappingTest() {
		super();
	}

	@Test
	public void mapWidth() {
		assertFeature(NotationPackage.Literals.SIZE__WIDTH, 42, 17);
	}

	@Test
	public void mapHeight() {
		assertFeature(NotationPackage.Literals.SIZE__HEIGHT, 42, 17);
	}
}
