/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Thibault Le Ouay (Sherpa Engineering) t.leouay@sherpa-eng.com  - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.profile.tests.canonical;


import org.eclipse.papyrus.junit.framework.classification.ClassificationSuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(ClassificationSuite.class)
@SuiteClasses({
		TestProfileDiagramTopNode.class,
		TestProfileDiagramChildNode.class,
		TestProfileDiagramLink.class,
		TestImportMetaClass.class,
		TestProfileDiagramExtension.class,
		TestProfileDiagramContextLink.class })
public class AllCanonicalTests {
}
