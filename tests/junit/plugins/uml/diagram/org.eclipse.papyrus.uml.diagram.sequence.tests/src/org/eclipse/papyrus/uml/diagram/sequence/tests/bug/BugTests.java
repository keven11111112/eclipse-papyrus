/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
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
package org.eclipse.papyrus.uml.diagram.sequence.tests.bug;

import org.junit.runner.RunWith;
import org.eclipse.papyrus.junit.framework.classification.ClassificationSuite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * All tests for bug.
 */
@RunWith(ClassificationSuite.class)
@SuiteClasses({ TestCombinedFragmentKind_364710.class, TestCombinedFragmentOperand_364701.class, TestMessagesDeletion_364828.class, TestNestedCombinedFragment_364795.class, TestSynchronousMessageCreation_364827.class, /*
																																																																																			 * TestCombinedFragmentGates_364816
																																																																																			 * .
																																																																																			 * class
																																																																																			 * ,
																																																																																			 * TestCombinedFragmentDeletion_364804
																																																																																			 * .
																																																																																			 * class
																																																																																			 * ,
																																																																																			 */
 TestAdvancedDragDrop_364696.class, TestGuardEdition_364808.class })
public class BugTests {

}
