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

package org.eclipse.papyrus.infra.gmfdiag.canonical.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Test suite for the {@code org.eclipse.papyrus.infra.gmfdiag.canonical} plug-in.
 */
@RunWith(Suite.class)
@SuiteClasses({
		BasicCanonicalClassDiagramTest.class,
		CanonicalStateInClassDiagramTest.class,
		EditingInModelInClassDiagramTest.class,
		CanonicalViewDeletionInClassDiagramTest.class,
		EditingInClassDiagramRegressionTest.class,
		CSSCanonicalClassDiagramTest.class,
		CSSCanonicalStateInClassDiagramTest.class,
		CSSExternalStylesheetInClassDiagramTest.class,
		CSSCanonicalCompositeDiagramTest.class })
public class AllTests {

	public AllTests() {
		super();
	}

}