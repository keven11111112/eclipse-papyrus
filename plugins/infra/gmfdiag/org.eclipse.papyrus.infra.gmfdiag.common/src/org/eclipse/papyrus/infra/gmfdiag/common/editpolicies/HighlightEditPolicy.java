/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Francois Le Fevre (CEA LIST) francois.le-fevre@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.editpolicies;

import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.editpolicies.GraphicalEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.HighlightUtil;
import org.eclipse.swt.SWT;

/**
 * EditPolicy dedicated to highligh node/edge in case of mouseover.
 * @author flefevre
 *
 */
public class HighlightEditPolicy extends GraphicalEditPolicy {

	public static final String HIGHLIGHT_ROLE = "Highlight Edit Policy";

	protected Indicator sourceIndicator;

	protected Indicator targetIndicator;

	@SuppressWarnings({ "rawtypes" })
	@Override
	public void showTargetFeedback(Request request) {
		EditPart host = getHost();

		if(RequestConstants.REQ_DROP_OBJECTS.equals(request.getType())) {
			highlight(host);
		}
	}

	/**
	 * Highlight, subclass can override it.
	 */
	protected void highlight(EditPart object) {
		HighlightUtil.highlight(object);
	}

	/**
	 * Erase highlighted figure, subclass can override it.
	 */
	protected void unhighlight(EditPart object) {
		HighlightUtil.unhighlight(object);
	}

	/**
	 * Erase all highlighted figures, subclass can override it.
	 */
	protected void unhighlight() {
		HighlightUtil.unhighlight();
	}

	private void safeRemoveFeedback(IFigure feedback) {
		if (feedback == null || feedback.getParent() == null) {
			return;
		}
		feedback.getParent().remove(feedback);
	}

	@Override
	public void eraseTargetFeedback(Request request) {
		unhighlight();
		safeRemoveFeedback(sourceIndicator);
		sourceIndicator = null;
		safeRemoveFeedback(targetIndicator);
		targetIndicator = null;
	}

	@Override
	public void eraseSourceFeedback(Request request) {
		super.eraseSourceFeedback(request);
		safeRemoveFeedback(sourceIndicator);
		sourceIndicator = null;
		safeRemoveFeedback(targetIndicator);
		targetIndicator = null;
	}

	private static class Indicator extends Ellipse {

		/**
		 * Constructor.
		 *
		 */
		public Indicator() {
			setLineWidth(2);
			setAntialias(SWT.ON);
			setSize(10, 10);
		}
	}
}
