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
import org.eclipse.gmf.runtime.notation.Style;
import org.eclipse.papyrus.aof.sync.gmf.internal.StyleMapping;
import org.junit.Test;

/**
 * Test cases for the {@link StyleMapping} class.
 */
public class StyleMappingTest extends AbstractMappingTest<Style> {

	public StyleMappingTest() {
		super();
	}

	@Test
	public void mapFontName() {
		assertFeature(NotationPackage.Literals.FONT_STYLE__FONT_NAME, "Garamond", "Futura");
	}

	@Test
	public void mapFontHeight() {
		assertFeature(NotationPackage.Literals.FONT_STYLE__FONT_HEIGHT, 10, 18);
	}

	@Test
	public void mapFontBold() {
		assertFeature(NotationPackage.Literals.FONT_STYLE__BOLD, true, false);
	}

}
