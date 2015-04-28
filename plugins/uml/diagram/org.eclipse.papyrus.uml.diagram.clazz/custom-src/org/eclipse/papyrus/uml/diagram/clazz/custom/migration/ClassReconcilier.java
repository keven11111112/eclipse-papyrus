package org.eclipse.papyrus.uml.diagram.clazz.custom.migration;

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
import org.eclipse.papyrus.infra.gmfdiag.common.reconciler.DiagramReconciler;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ContainmentLinkEditPart;

/**
 * Class Diagram Reconciler from 1.0.0 to 1.1.0
 */
public class ClassReconcilier extends DiagramReconciler {

	final String CONTAINMENT_LINK_OLD_VISUAL_ID = "4022";
	final String CONTAINMENT_LINK_NEW_VISUAL_ID = Integer.toString(ContainmentLinkEditPart.VISUAL_ID);
	final String CONTAINMENT_LINK_AFFIXEDNODE_OLD_VISUAL_ID = "3032";


	@Override
	public ICommand getReconcileCommand(Diagram diagram) {
		CompositeCommand cc = new CompositeCommand("Migrate Class diagram and derivated diagrams");
		updateContainmentLinks(diagram, cc);
		return cc;
	}

	protected void updateContainmentLinks(Diagram diagram, CompositeCommand cc) {
		cc.add(new UpdateContainmentLinksCommand(diagram));

		// Remove affixed Nodes of containment links
		TreeIterator<EObject> allContentIterator = diagram.eAllContents();

		while (allContentIterator.hasNext()) {
			EObject eObject = (EObject) allContentIterator.next();

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
				EObject eObject = (EObject) allContentIterator.next();

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
