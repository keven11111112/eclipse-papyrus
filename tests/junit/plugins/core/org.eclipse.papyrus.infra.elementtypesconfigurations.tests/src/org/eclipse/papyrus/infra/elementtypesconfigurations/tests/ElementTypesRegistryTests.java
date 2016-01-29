/*****************************************************************************
 * Copyright (c) 2010, 2016 CEA LIST, Christian W. Damus, and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 431953 (fix test to prevent Model Repair dialog on unrecognized profile schema)
 *  Christian W. Damus (CEA) - bug 434993
 *  Christian W. Damus - bug 485220
 *  
 *****************************************************************************/
package org.eclipse.papyrus.infra.elementtypesconfigurations.tests;

import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for {@link ElementTypesConfigurationsRegistry}
 */
public class ElementTypesRegistryTests extends AbstractElementTypeTests implements ITestConstants {

	/**
	 * Test registration based on plugin declaration
	 */
	@Test
	// transcoded from extended types framework
	public final void testGetTypeRegisteredInplugin() {
		// check standard class
		IElementType classType = ElementTypeRegistry.getInstance().getType(ORG_ECLIPSE_PAPYRUS_UML_CLASS);
		Assert.assertNotNull("Element type should be registered", classType);
		IElementType abstractClassType = ElementTypeRegistry.getInstance().getType(ABSTRACT_CLASS_TOOL);
		Assert.assertNotNull("Element type should be registered", abstractClassType);
	}
}