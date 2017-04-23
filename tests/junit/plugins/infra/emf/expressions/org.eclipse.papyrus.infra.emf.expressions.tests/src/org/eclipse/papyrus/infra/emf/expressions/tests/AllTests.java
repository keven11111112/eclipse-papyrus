/*****************************************************************************
 * Copyright (c) 2017 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.infra.emf.expressions.tests;

import org.eclipse.papyrus.junit.framework.classification.ClassificationSuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(ClassificationSuite.class)
@SuiteClasses({
	AndExpressionTests.class,
	LiteralFalseExpressionTests.class,
	LiteralTrueExpressionTests.class,
	NotExpressionTests.class,
	OrExpressionTests.class,
	ReferenceExpressionTests.class
})
/**
 * @author VL222926
 *
 */
public class AllTests {
	// JUnit 4 test suite

}
