/*****************************************************************************
 * Copyright (c) 2010, 2015 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	 Florian Noyrit  (CEA) florian.noyrit@cea.fr - Initial API and Implementation
 *   Mickael ADAM (ALL4TEC) mickael.adam@all4tec.net - reconciler to add floating label
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.clazz.custom.migration;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.AbstractCommand;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.commands.InsertFloatingLabelFromMapCommand;
import org.eclipse.papyrus.infra.gmfdiag.common.reconciler.DiagramReconciler;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.AssociationClassEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.AssociationClassFloatingNameEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.AssociationFloatingNameEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.AssociationNodeEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ClassEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ClassEditPartCN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ClassFloatingNameEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ClassFloatingNameEditPartCN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ComponentEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ComponentEditPartCN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ComponentFloatingNameEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ComponentFloatingNameEditPartCN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ContainmentLinkEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.DataTypeEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.DataTypeEditPartCN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.DataTypeFloatingNameEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.DataTypeFloatingNameEditPartCN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.DependencyFloatingNameEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.DependencyNodeEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.EnumerationEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.EnumerationEditPartCN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.EnumerationFloatingNameEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.EnumerationFloatingNameEditPartCN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.InformationItemEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.InformationItemEditPartCN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.InformationItemFloatingNameEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.InformationItemFloatingNameEditPartCN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.InstanceSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.InstanceSpecificationEditPartCN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.InstanceSpecificationFloatingNameEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.InstanceSpecificationFloatingNameEditPartCN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.InterfaceEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.InterfaceEditPartCN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.InterfaceFloatingNameEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.InterfaceFloatingNameEditPartCN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.PrimitiveTypeEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.PrimitiveTypeEditPartCN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.PrimitiveTypeFloatingNameEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.PrimitiveTypeFloatingNameEditPartCN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.SignalEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.SignalEditPartCN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.SignalFloatingNameEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.SignalFloatingNameEditPartCN;

/**
 * Class Diagram Reconciler from 1.0.0 to 1.1.0
 */
public class ClassReconcilier extends DiagramReconciler {

	final String CONTAINMENT_LINK_OLD_VISUAL_ID = "4022"; //$NON-NLS-1$
	final String CONTAINMENT_LINK_NEW_VISUAL_ID = ContainmentLinkEditPart.VISUAL_ID;
	final String CONTAINMENT_LINK_AFFIXEDNODE_OLD_VISUAL_ID = "3032"; //$NON-NLS-1$


	@Override
	public ICommand getReconcileCommand(Diagram diagram) {
		CompositeCommand cc = new CompositeCommand("Migrate Class diagram and derivated diagrams");
		updateContainmentLinks(diagram, cc);

		// Adds command to insert floating label to Nodes which provide it
		cc.add(new InsertFloatingLabelFromMapCommand(diagram, getFloatingLabelMap()));

		return cc;
	}

	/**
	 * Gets the floating label map to add.
	 *
	 * @return the floating label map
	 */
	private Map<String, String> getFloatingLabelMap() {
		Map<String, String> map = new HashMap<String, String>();
		map.put(String.valueOf(ClassEditPart.VISUAL_ID), String.valueOf(ClassFloatingNameEditPart.VISUAL_ID));
		map.put(String.valueOf(AssociationClassEditPart.VISUAL_ID), String.valueOf(AssociationClassFloatingNameEditPart.VISUAL_ID));
		map.put(String.valueOf(AssociationNodeEditPart.VISUAL_ID), String.valueOf(AssociationFloatingNameEditPart.VISUAL_ID));
		map.put(String.valueOf(ClassEditPartCN.VISUAL_ID), String.valueOf(ClassFloatingNameEditPartCN.VISUAL_ID));
		map.put(String.valueOf(ComponentEditPart.VISUAL_ID), String.valueOf(ComponentFloatingNameEditPart.VISUAL_ID));
		map.put(String.valueOf(ComponentEditPartCN.VISUAL_ID), String.valueOf(ComponentFloatingNameEditPartCN.VISUAL_ID));
		map.put(String.valueOf(DataTypeEditPart.VISUAL_ID), String.valueOf(DataTypeFloatingNameEditPart.VISUAL_ID));
		map.put(String.valueOf(DataTypeEditPartCN.VISUAL_ID), String.valueOf(DataTypeFloatingNameEditPartCN.VISUAL_ID));
		map.put(String.valueOf(DependencyNodeEditPart.VISUAL_ID), String.valueOf(DependencyFloatingNameEditPart.VISUAL_ID));
		map.put(String.valueOf(EnumerationEditPart.VISUAL_ID), String.valueOf(EnumerationFloatingNameEditPart.VISUAL_ID));
		map.put(String.valueOf(EnumerationEditPartCN.VISUAL_ID), String.valueOf(EnumerationFloatingNameEditPartCN.VISUAL_ID));
		map.put(String.valueOf(InformationItemEditPart.VISUAL_ID), String.valueOf(InformationItemFloatingNameEditPart.VISUAL_ID));
		map.put(String.valueOf(InformationItemEditPartCN.VISUAL_ID), String.valueOf(InformationItemFloatingNameEditPartCN.VISUAL_ID));
		map.put(String.valueOf(InstanceSpecificationEditPart.VISUAL_ID), String.valueOf(InstanceSpecificationFloatingNameEditPart.VISUAL_ID));
		map.put(String.valueOf(InstanceSpecificationEditPartCN.VISUAL_ID), String.valueOf(InstanceSpecificationFloatingNameEditPartCN.VISUAL_ID));
		map.put(String.valueOf(InterfaceEditPart.VISUAL_ID), String.valueOf(InterfaceFloatingNameEditPart.VISUAL_ID));
		map.put(String.valueOf(InterfaceEditPartCN.VISUAL_ID), String.valueOf(InterfaceFloatingNameEditPartCN.VISUAL_ID));
		map.put(String.valueOf(PrimitiveTypeEditPart.VISUAL_ID), String.valueOf(PrimitiveTypeFloatingNameEditPart.VISUAL_ID));
		map.put(String.valueOf(PrimitiveTypeEditPartCN.VISUAL_ID), String.valueOf(PrimitiveTypeFloatingNameEditPartCN.VISUAL_ID));
		map.put(String.valueOf(SignalEditPart.VISUAL_ID), String.valueOf(SignalFloatingNameEditPart.VISUAL_ID));
		map.put(String.valueOf(SignalEditPartCN.VISUAL_ID), String.valueOf(SignalFloatingNameEditPartCN.VISUAL_ID));

		return map;
	}

	protected void updateContainmentLinks(Diagram diagram, CompositeCommand cc) {
		cc.add(new UpdateContainmentLinksCommand(diagram));

		// Remove affixed Nodes of containment links
		TreeIterator<EObject> allContentIterator = diagram.eAllContents();

		while (allContentIterator.hasNext()) {
			EObject eObject = allContentIterator.next();

			if (eObject instanceof View) {
				if (((View) eObject).getType().equals(CONTAINMENT_LINK_AFFIXEDNODE_OLD_VISUAL_ID)) {
					DeleteCommand cmd = new DeleteCommand((View) eObject);
					cc.add(cmd);
				}
			}
		}
	}

	protected class UpdateContainmentLinksCommand extends AbstractCommand {

		protected final Diagram diagram;

		public UpdateContainmentLinksCommand(Diagram diagram) {
			super("Update containementLinks in Class diagram and derivated diagrams");
			this.diagram = diagram;
		}

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {

			TreeIterator<EObject> allContentIterator = diagram.eAllContents();

			while (allContentIterator.hasNext()) {
				EObject eObject = allContentIterator.next();

				if (eObject instanceof Edge) {
					if (((Edge) eObject).getType().equals(CONTAINMENT_LINK_OLD_VISUAL_ID)) {
						Edge edge = ((Edge) eObject);

						View source = edge.getSource();
						EObject sourceContainer = source.eContainer();

						if (sourceContainer instanceof View) {
							// update source of the connector to the root node instead of the affixedNode
							edge.setSource((View) sourceContainer);
							// Update the type of the connector 4022 -> 4023
							edge.setType(CONTAINMENT_LINK_NEW_VISUAL_ID);
						}
					}
				}
			}

			return CommandResult.newOKCommandResult();
		}

		@Override
		public boolean canUndo() {
			return false;
		}

		@Override
		public boolean canRedo() {
			return false;
		}

		@Override
		protected CommandResult doRedoWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
			throw new ExecutionException("Should not be called, canRedo false");
		}

		@Override
		protected CommandResult doUndoWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
			throw new ExecutionException("Should not be called, canUndo false");
		}
	}

}
