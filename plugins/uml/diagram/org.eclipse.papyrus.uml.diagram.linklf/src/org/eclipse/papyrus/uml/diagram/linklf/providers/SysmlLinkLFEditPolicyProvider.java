/*****************************************************************************
 * Copyright (c) 2015 CEA LIST, Montages AG and others
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Michael Golubev - bug #470440
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.linklf.providers;

import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.INodeEditPart;
import org.eclipse.papyrus.uml.diagram.linklf.policy.graphicalnode.SysmlLinkLFGraphicalNodeEditPolicy;

public class SysmlLinkLFEditPolicyProvider extends LinksLFEditPolicyProvider {

	/**
	 * Replaces the default graphical node edit policy with LinkLF-sepcific one,
	 * tweaked for SysML.
	 */
	@Override
	protected void installGraphicalNodeEditPolicy(INodeEditPart nodeEP) {
		if (nodeEP.getEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE) != null) {
			nodeEP.installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new SysmlLinkLFGraphicalNodeEditPolicy());
		}
	}

}
