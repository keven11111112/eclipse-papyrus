/*****************************************************************************
 * Copyright (c) 2013 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Soyatec - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.tests.bug.m7;

import org.eclipse.papyrus.junit.framework.classification.ClassificationSuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
@RunWith(ClassificationSuite.class)
@SuiteClasses({ TestExecutionSpecificationPosition_395462.class,  TestGuardVisibility_402966.class, TestInteractionUse.class,
		TestMessageCreateWithLifeline_403134.class, TestResizeStateInvariant_395774.class, TestMessageOccurrenceSpecification_402975.class, TestMakeSameHeightForLifelines_402978.class, TestMoveMessageLostFound_403138.class,
		 TestExecutionEndsWithMessageOccurrenceSpecification.class,
		TestMessageOccurrenceSpecification_477463.class })
public class BugTest_m7 {
}
