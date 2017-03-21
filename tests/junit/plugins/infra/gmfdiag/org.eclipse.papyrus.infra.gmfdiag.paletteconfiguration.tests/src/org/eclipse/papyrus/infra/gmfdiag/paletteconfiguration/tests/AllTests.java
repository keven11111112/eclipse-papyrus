/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.paletteconfiguration.tests;

import org.junit.runner.RunWith;
import org.eclipse.papyrus.infra.gmfdiag.paletteconfiguration.tests.regression.Bug457712PaletteConfigurationRequiredProfile;
import org.eclipse.papyrus.junit.framework.classification.ClassificationSuite;
import org.junit.runners.Suite.SuiteClasses;


/**
 * All tests for this fragment
 */
@RunWith(ClassificationSuite.class)
@SuiteClasses({ Bug457712PaletteConfigurationRequiredProfile.class, })
public class AllTests {

}
