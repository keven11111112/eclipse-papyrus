/*****************************************************************************
 * Copyright (c) 2010, 2015 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Mickael ADAM (ALL4TEC) mickael.adam@all4tec.net - Initial API and Implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.component.custom.migration;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.infra.gmfdiag.common.commands.InsertFloatingLabelFromMapCommand;
import org.eclipse.papyrus.infra.gmfdiag.common.reconciler.DiagramReconciler;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentEditPartCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentEditPartPCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentFloatingLabelEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentFloatingLabelEditPartCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentFloatingLabelEditPartPCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.DependencyNodeEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.DependencyNodeFloatingLabelEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.InterfaceEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.InterfaceEditPartPCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.InterfaceFloatingLabelEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.InterfaceFloatingLabelEditPartPCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.RectangleInterfaceEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.RectangleInterfaceEditPartCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.RectangleInterfaceFloatingLabelEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.RectangleInterfaceFloatingLabelEditPartCN;

/**
 * Component Diagram Reconciler from 1.0.0 to 1.1.0
 */
public class ComponentReconcilier extends DiagramReconciler {

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
		map.put(String.valueOf(ComponentEditPart.VISUAL_ID), String.valueOf(ComponentFloatingLabelEditPart.VISUAL_ID));
		map.put(String.valueOf(ComponentEditPartCN.VISUAL_ID), String.valueOf(ComponentFloatingLabelEditPartCN.VISUAL_ID));
		map.put(String.valueOf(ComponentEditPartPCN.VISUAL_ID), String.valueOf(ComponentFloatingLabelEditPartPCN.VISUAL_ID));
		map.put(String.valueOf(DependencyNodeEditPart.VISUAL_ID), String.valueOf(DependencyNodeFloatingLabelEditPart.VISUAL_ID));
		map.put(String.valueOf(InterfaceEditPart.VISUAL_ID), String.valueOf(InterfaceFloatingLabelEditPart.VISUAL_ID));
		map.put(String.valueOf(InterfaceEditPartPCN.VISUAL_ID), String.valueOf(InterfaceFloatingLabelEditPartPCN.VISUAL_ID));
		map.put(String.valueOf(RectangleInterfaceEditPart.VISUAL_ID), String.valueOf(RectangleInterfaceFloatingLabelEditPart.VISUAL_ID));
		map.put(String.valueOf(RectangleInterfaceEditPartCN.VISUAL_ID), String.valueOf(RectangleInterfaceFloatingLabelEditPartCN.VISUAL_ID));

		return map;
	}
}
