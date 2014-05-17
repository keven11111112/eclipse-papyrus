/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.editpolicies;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.ConnectionLocator;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.editpolicies.ConnectionEndpointEditPolicy;
import org.eclipse.gef.editpolicies.FeedbackHelper;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.papyrus.infra.gmfdiag.common.helper.CustomFeedbackHelper;
import org.eclipse.papyrus.infra.gmfdiag.common.snap.PapyrusConnectionEndpointHandle;


/**
 * 
 * This class allows to provides our own EndPointHandle to provide our own DragTracker
 * 
 */
public class PapyrusConnectionEndEditPolicy extends ConnectionEndpointEditPolicy {

	/**
	 * the feedback helper
	 */
	private FeedbackHelper feedbackHelper;

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public PapyrusConnectionEndEditPolicy() {
		super();
	}

	/**
	 * @see org.eclipse.gef.editpolicies.SelectionHandlesEditPolicy#createSelectionHandles()
	 */
	@Override
	protected List<?> createSelectionHandles() {
		List<PapyrusConnectionEndpointHandle> list = new ArrayList<PapyrusConnectionEndpointHandle>();
		list.add(new PapyrusConnectionEndpointHandle((ConnectionEditPart)getHost(), ConnectionLocator.SOURCE));
		list.add(new PapyrusConnectionEndpointHandle((ConnectionEditPart)getHost(), ConnectionLocator.TARGET));
		return list;
	}


	/**
	 * 
	 * @see org.eclipse.gef.editpolicies.ConnectionEndpointEditPolicy#getFeedbackHelper(org.eclipse.gef.requests.ReconnectRequest)
	 * 
	 * @param request
	 * @return
	 */
	@Override
	protected FeedbackHelper getFeedbackHelper(final ReconnectRequest request) {
		if(feedbackHelper == null) {
			feedbackHelper = new CustomFeedbackHelper();
			feedbackHelper.setConnection(getConnection());
			feedbackHelper.setMovingStartAnchor(request.isMovingStartAnchor());
		}
		return feedbackHelper;
	}


	/**
	 * Erases connection move feedback. This method is called when a
	 * ReconnectRequest is received.
	 * 
	 * @param request
	 *            the reconnect request.
	 */
	@Override
	protected void eraseConnectionMoveFeedback(ReconnectRequest request) {
		super.eraseConnectionMoveFeedback(request);
		this.feedbackHelper = null;
	}

	/**
	 * 
	 * @see org.eclipse.gef.editpolicies.ConnectionEndpointEditPolicy#showConnectionMoveFeedback(org.eclipse.gef.requests.ReconnectRequest)
	 *
	 * @param request
	 */
	@Override
	protected void showConnectionMoveFeedback(ReconnectRequest request) {
		super.showConnectionMoveFeedback(request);
		//we need to do calculus to find the real anchor point on the side of the figure
		//+ update the router constraint, so we do nothing here and we do the job in CustomFeedbackHelper.setAnchor(ConnectionAnchor anchor)
	}
}
