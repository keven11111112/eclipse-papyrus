/*****************************************************************************
 * Copyright (c) 2009-2015 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Mickael ADAM (ALL4TEC) mickael.adam@all4tec.net - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.deployment.custom.migration;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.infra.gmfdiag.common.commands.InsertFloatingLabelFromMapCommand;
import org.eclipse.papyrus.infra.gmfdiag.common.reconciler.DiagramReconciler;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ArtifactEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ArtifactEditPartACN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ArtifactEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ArtifactFloatingLabelEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ArtifactFloatingLabelEditPartACN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ArtifactFloatingLabelEditPartCN;

/**
 * Deployment Diagram Reconciler from 1.0.0 to 1.1.0
 */
public class DeploymentReconcilier extends DiagramReconciler {

	/**
	 * Gets the reconcile command.
	 *
	 * @param diagram
	 *            the diagram
	 * @return the reconcile command
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.reconciler.DiagramReconciler#getReconcileCommand(org.eclipse.gmf.runtime.notation.Diagram)
	 */
	@Override
	public ICommand getReconcileCommand(Diagram diagram) {
		return new InsertFloatingLabelFromMapCommand(diagram, getFloatingLabelMap());
	}

	/**
	 * Gets the floating label map to add.
	 *
	 * @return the floating label map
	 */
	private Map<String, String> getFloatingLabelMap() {
		Map<String, String> map = new HashMap<String, String>();
		map.put(String.valueOf(ArtifactEditPart.VISUAL_ID), String.valueOf(ArtifactFloatingLabelEditPart.VISUAL_ID));
		map.put(String.valueOf(ArtifactEditPartACN.VISUAL_ID), String.valueOf(ArtifactFloatingLabelEditPartACN.VISUAL_ID));
		map.put(String.valueOf(ArtifactEditPartCN.VISUAL_ID), String.valueOf(ArtifactFloatingLabelEditPartCN.VISUAL_ID));

		return map;
	}
}
