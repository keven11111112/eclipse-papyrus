/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.editpart;

import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ConnectionBendpointEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.internal.editpolicies.ConnectionLineSegEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.internal.editpolicies.TreeConnectionBendpointEditPolicy;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.CustomConnectionLineSegEditPolicy;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.PapyrusConnectionEndEditPolicy;


/**
 * Abstract edit part for all connection nodes.
 */
public abstract class ConnectionEditPart extends ConnectionNodeEditPart implements IPapyrusEditPart {

	public ConnectionEditPart(View view) {
		super(view);
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart#createDefaultEditPolicies()
	 * 
	 */
	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicy.CONNECTION_ENDPOINTS_ROLE, new PapyrusConnectionEndEditPolicy());
	}

	@SuppressWarnings("restriction")
	@Override
	public void installEditPolicy(Object role, EditPolicy editPolicy) {
		if(EditPolicy.CONNECTION_BENDPOINTS_ROLE.equals(role)) {
			if(editPolicy instanceof ConnectionLineSegEditPolicy) {
				EditPolicy replacement = new CustomConnectionLineSegEditPolicy();
				super.installEditPolicy(role, replacement);
				//				super.installEditPolicy(role, editPolicy);
			} else if(editPolicy instanceof TreeConnectionBendpointEditPolicy) {
				super.installEditPolicy(role, editPolicy);
			} else if(editPolicy instanceof ConnectionBendpointEditPolicy) {
				EditPolicy replacement = editPolicy;
				super.installEditPolicy(role, replacement);
			}
		} else {
			super.installEditPolicy(role, editPolicy);
		}
	};

	@Override
	protected void setLineWidth(int width) {
		if(width < 0) {
			width = 1;
		}

		if(getFigure() instanceof PolylineConnectionEx) {
			PolylineConnectionEx conn = (PolylineConnectionEx)getFigure();
			conn.setLineWidth(getMapMode().DPtoLP(width));
		}
	}

	@Override
	protected void refreshVisuals() {
		super.refreshVisuals();
		refreshLineWidth();
		installRouter();
	}

}
