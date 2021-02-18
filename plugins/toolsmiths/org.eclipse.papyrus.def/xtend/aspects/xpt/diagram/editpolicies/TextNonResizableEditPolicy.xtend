/*****************************************************************************
 * Copyright (c) 2017 CEA LIST and other.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 * Benoit Maggi (CEA LIST) benoit.maggi@cea.fr - #510281 change dependency to replace gmft-runtime
 * 
 *****************************************************************************/
package aspects.xpt.diagram.editpolicies

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.papyrus.gmf.codegen.gmfgen.GenDiagram
import xpt.Common

/** 
 * FIXME: [MG] - reverse the calls? call common code from here and TextelectionEP and not vice versa 
*/
@Singleton class TextNonResizableEditPolicy extends xpt.diagram.editpolicies.TextNonResizableEditPolicy {
	
	@Inject extension Common;

	override TextNonResizableEditPolicy_implementsClause(GenDiagram it) '''implements org.eclipse.papyrus.infra.gmfdiag.tooling.runtime.edit.policies.labels.IRefreshableFeedbackEditPolicy'''

	override def TextNonResizableEditPolicy_createSelectionHandles(GenDiagram it) '''
		«generatedMemberComment»
		protected java.util.List<?> createSelectionHandles() {
			org.eclipse.gef.handles.MoveHandle moveHandle =
				new org.eclipse.gef.handles.MoveHandle((org.eclipse.gef.GraphicalEditPart) getHost());
			moveHandle.setBorder(null);
			moveHandle.setDragTracker(new org.eclipse.gmf.runtime.diagram.ui.tools.DragEditPartsTrackerEx(getHost()));
			return java.util.Collections.singletonList(moveHandle);
		}
	'''

}