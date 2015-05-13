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
package org.eclipse.papyrus.uml.diagram.usecase.custom.migration;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.infra.gmfdiag.common.commands.InsertFloatingLabelFromMapCommand;
import org.eclipse.papyrus.infra.gmfdiag.common.reconciler.DiagramReconciler;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ActorEditPartTN;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ActorFloatingLabelEditPartTN;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ActorInComponentEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ActorInComponentFloatingLabelEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ActorInPackageEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ActorInPackageFloatingLabelEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ComponentInPackageEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ComponentInPackageFloatingLabelEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.SubjectClassifierEditPartTN;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.SubjectClassifierFloatingLabelEditPartTN;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.UseCaseEditPartTN;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.UseCaseFloatingLabelEditPartTN;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.UseCaseInComponentEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.UseCaseInComponentFloatingLabelEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.UseCaseInPackageEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.UseCaseInPackageFloatingLabelEditPart;

/**
 * UseCase Diagram Reconciler from 1.0.0 to 1.1.0
 */
public class UseCaseReconcilier extends DiagramReconciler {

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
		map.put(String.valueOf(ActorEditPartTN.VISUAL_ID), String.valueOf(ActorFloatingLabelEditPartTN.VISUAL_ID));
		map.put(String.valueOf(ActorInComponentEditPart.VISUAL_ID), String.valueOf(ActorInComponentFloatingLabelEditPart.VISUAL_ID));
		map.put(String.valueOf(ActorInPackageEditPart.VISUAL_ID), String.valueOf(ActorInPackageFloatingLabelEditPart.VISUAL_ID));
		map.put(String.valueOf(ComponentInPackageEditPart.VISUAL_ID), String.valueOf(ComponentInPackageFloatingLabelEditPart.VISUAL_ID));
		map.put(String.valueOf(SubjectClassifierEditPartTN.VISUAL_ID), String.valueOf(SubjectClassifierFloatingLabelEditPartTN.VISUAL_ID));
		map.put(String.valueOf(UseCaseEditPartTN.VISUAL_ID), String.valueOf(UseCaseFloatingLabelEditPartTN.VISUAL_ID));
		map.put(String.valueOf(UseCaseInComponentEditPart.VISUAL_ID), String.valueOf(UseCaseInComponentFloatingLabelEditPart.VISUAL_ID));
		map.put(String.valueOf(UseCaseInPackageEditPart.VISUAL_ID), String.valueOf(UseCaseInPackageFloatingLabelEditPart.VISUAL_ID));

		return map;
	}
}
