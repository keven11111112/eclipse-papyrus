/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Benoit Maggi (CEA LIST) benoit.maggi@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml14.tests;

import org.eclipse.uml2.uml.UMLPlugin;
import org.junit.Assert;
import org.junit.Test;

/**
 * Basic test for Sysml 1.4 profile
 * @author Benoit Maggi
 */
public class SysmlProfileTest {

	/**
	 * Check that we have a profile registered here : "http://www.eclipse.org/papyrus/1.4/SysML"
	 */
	@Test
	public void testProfilRegistration() {
		Assert.assertNotNull(UMLPlugin.getEPackageNsURIToProfileLocationMap().get("http://www.eclipse.org/papyrus/1.4/SysML"));
	}

}
