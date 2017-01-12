/*****************************************************************************
 * Copyright (c) 2017 CEA LIST and other.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Benoit Maggi (CEA LIST) benoit.maggi@cea.fr - #510281 change dependency to replace gmft-runtime
 *****************************************************************************/
package aspects.xpt.diagram.editpolicies

import org.eclipse.gmf.codegen.gmfgen.GenDiagram
import com.google.inject.Inject
import xpt.Common
import com.google.inject.Singleton
import xpt.CodeStyle

@Singleton class TextSelectionEditPolicy extends xpt.diagram.editpolicies.TextSelectionEditPolicy {
	
	@Inject extension Common
	@Inject extension CodeStyle
	
	// rebranch to the tooling runtime in the release train.
	override TextSelectionEditPolicy_implementsClause(GenDiagram it) '''implements org.eclipse.gmf.tooling.runtime.edit.policies.labels.IRefreshableFeedbackEditPolicy'''
	
	override textFeedback_createFocusFeedbackFigure(GenDiagram it) '''
		«generatedMemberComment»
		protected org.eclipse.draw2d.IFigure createFocusFeedbackFigure() {
			return new org.eclipse.draw2d.Figure() {
		
			«overrideC»
			protected void paintFigure(org.eclipse.draw2d.Graphics graphics) {
				graphics.drawFocus(getBounds().getResized(-1, -1));
			}
			};
		}
	'''
	
	override textFeedback_getHostPositionListener(GenDiagram it) '''
		«generatedMemberComment»
		private org.eclipse.draw2d.FigureListener getHostPositionListener() {
			if (hostPositionListener == null) {
				hostPositionListener = new org.eclipse.draw2d.FigureListener() {
					«overrideI»
					public void figureMoved(org.eclipse.draw2d.IFigure source) {
						refreshFeedback();
					}
				};
			}
			return hostPositionListener;
		}
	'''
	
}