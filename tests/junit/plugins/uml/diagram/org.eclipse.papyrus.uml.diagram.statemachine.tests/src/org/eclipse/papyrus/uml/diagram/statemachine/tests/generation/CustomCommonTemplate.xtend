/*******************************************************************************
 * Copyright (c) 2015 Christian W. Damus and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *     
 ******************************************************************************/
package org.eclipse.papyrus.uml.diagram.statemachine.tests.generation

import javax.inject.Singleton
import org.eclipse.papyrus.tests.framework.m2t.xtend.templates.TestNodeTemplate

/**
 * Common utilities for the state machine custom model-to-text templates.
 */
 @Singleton
class CustomCommonTemplate extends TestNodeTemplate {
    def smUtils() {
    	'org.eclipse.papyrus.uml.diagram.statemachine.tests.generation.StateMachineDiagramGeneratedTestsUtil'.imported
    }

	def customGetContainerEditPart() '''
		@Override
		protected «'org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart'.imported» getContainerEditPart() {
			return «smUtils».resolveTopRegionCompartment(super.getContainerEditPart());
		}
	'''
}
