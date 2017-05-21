/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.sequence.referencialgrilling;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gmf.runtime.diagram.core.listener.DiagramEventBroker;
import org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramRootEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.gef.ui.internal.editpolicies.GraphicalEditPolicyEx;
import org.eclipse.gmf.runtime.notation.BasicCompartment;
import org.eclipse.gmf.runtime.notation.DecorationNode;
import org.eclipse.gmf.runtime.notation.LayoutConstraint;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.AutomaticNotationEditPolicy;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramEditPartsUtil;
import org.eclipse.papyrus.uml.diagram.sequence.CustomMessages;
import org.eclipse.papyrus.uml.diagram.sequence.command.CreateCoordinateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.command.CreateGrillingStructureCommand;
import org.eclipse.papyrus.uml.diagram.sequence.keyboardlistener.KeyToSetMoveLinesListener;
import org.eclipse.papyrus.uml.diagram.sequence.part.UMLDiagramEditorPlugin;
import org.eclipse.swt.SWT;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.InteractionOperand;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * This edit policy is used to manage the referential grid of the sequence diagram
 *
 */
public class GridManagementEditPolicy extends GraphicalEditPolicyEx implements AutomaticNotationEditPolicy, NotificationListener, IGrillingEditpolicy {
	public static final String GRILL_CONNECTION = "Grill Connection";
	protected GrillingEditpart grillingCompartment = null;


	public static String GRILLING_MANAGEMENT = "GRILLING_MANAGEMENT";
	public static String COLUMN = "COLUMN_";
	public static String ROW = "ROW_";

	public int threshold = 10;
	public int margin = 50;
	public boolean respectMargin = true;
	public boolean moveAllLinesAtSamePosition = false;

	public ArrayList<DecorationNode> rows = new ArrayList<DecorationNode>();
	public ArrayList<DecorationNode> columns = new ArrayList<DecorationNode>();

	// ok if the creation a X is free
	public boolean CREATION_X_FREE = true;
	/** if the CREATION_X_FREE == false COLUMN are created at fixed position **/
	public int X_SPACING = 100;
	private ContentDiagramListener contentDiagramListener;
	private CommandStackListener commandStackListener;

	/**
	 * @return the moveAllLinesAtSamePosition
	 */
	public boolean isMoveAllLinesAtSamePosition() {
		return moveAllLinesAtSamePosition;
	}

	/**
	 * @param moveAllLinesAtSamePosition
	 *            the moveAllLinesAtSamePosition to set
	 */
	public void setMoveAllLinesAtSamePosition(boolean moveAllLinesAtSamePosition) {

		UMLDiagramEditorPlugin.log.trace(CustomMessages.SEQUENCE_DEBUG_REFERENCEGRID, ">> set moveAllLinesAtSamePosition=" + moveAllLinesAtSamePosition);//$NON-NLS-1$
		this.moveAllLinesAtSamePosition = moveAllLinesAtSamePosition;
	}

	/**
	 * @return the respectMargin
	 */
	public boolean isRespectMargin() {
		return respectMargin;
	}

	/**
	 * @param respectMargin
	 *            the respectMargin to set
	 */
	public void setRespectMargin(boolean respectMargin) {
		this.respectMargin = respectMargin;
	}



	public boolean strictRespectMargin = true;




	public Comparator<DecorationNode> RowComparator = new Comparator<DecorationNode>() {

		@Override
		public int compare(DecorationNode o1, DecorationNode o2) {
			LayoutConstraint layoutConstrainto1 = ((Node) o1).getLayoutConstraint();
			LayoutConstraint layoutConstrainto2 = ((Node) o2).getLayoutConstraint();
			if (layoutConstrainto1 != null && layoutConstrainto2 != null) {
				return ((Integer) ((Location) layoutConstrainto1).getY()).compareTo(((Integer) ((Location) layoutConstrainto2).getY()));
			}
			return 0;
		}
	};

	public Comparator<DecorationNode> ColumnComparator = new Comparator<DecorationNode>() {

		@Override
		public int compare(DecorationNode o1, DecorationNode o2) {
			LayoutConstraint layoutConstrainto1 = ((Node) o1).getLayoutConstraint();
			LayoutConstraint layoutConstrainto2 = ((Node) o2).getLayoutConstraint();
			if (layoutConstrainto1 != null && layoutConstrainto2 != null) {
				return ((Integer) ((Location) layoutConstrainto1).getX()).compareTo(((Integer) ((Location) layoutConstrainto2).getX()));
			}
			return 0;
		}
	};




	/**
	 * Constructor.
	 *
	 */
	public GridManagementEditPolicy() {
	}

	/**
	 * @see org.eclipse.gef.editpolicies.AbstractEditPolicy#activate()
	 *
	 */
	@Override
	public void activate() {
		super.activate();
		getDiagramEventBroker().addNotificationListener(((EObject) getHost().getModel()), this);
		contentDiagramListener = new ContentDiagramListener(this);
		commandStackListener = new GridCommandStackListener(this);
		((EObject) getHost().getModel()).eResource().eAdapters().add(contentDiagramListener);
		getDiagramEditPart(getHost()).getEditingDomain().getCommandStack().addCommandStackListener(commandStackListener);
		PlatformUI.getWorkbench().getDisplay().addFilter(SWT.KeyDown, new KeyToSetMoveLinesListener(this, SWT.SHIFT, false));
		PlatformUI.getWorkbench().getDisplay().addFilter(SWT.KeyUp, new KeyToSetMoveLinesListener(this, SWT.SHIFT, true));
		refreshGrillingStructure();
	}

	/**
	 * 
	 */
	private void refreshGrillingStructure() {
		EditPart host = getHost();
		int i = 0;
		while (grillingCompartment == null && i < host.getChildren().size()) {
			if (host.getChildren().get(i) instanceof GrillingEditpart) {
				grillingCompartment = (GrillingEditpart) (host.getChildren().get(i));
			}
			i++;
		}
		if (grillingCompartment == null) {
			CreateGrillingStructureCommand createGrillingStructureCommand = new CreateGrillingStructureCommand(((IGraphicalEditPart) getHost()).getEditingDomain(), (View) getHost().getModel());
			// Record for undo if possible, otherwise unprotected
			execute(createGrillingStructureCommand);


		}
		while (grillingCompartment == null && i < host.getChildren().size()) {
			if (host.getChildren().get(i) instanceof GrillingEditpart) {
				grillingCompartment = (GrillingEditpart) (host.getChildren().get(i));
			}
			i++;
		}
		// cleanUnusedRowAndColumn();
		updateRowsAndColumns();
	}

	/**
	 * update the list of romw and colmumn
	 */
	public void updateRowsAndColumns() {


		rows.clear();
		columns.clear();
		if (grillingCompartment != null) {
			for (int j = 0; j < grillingCompartment.getNotationView().getChildren().size(); j++) {
				if (grillingCompartment.getNotationView().getChildren().get(j) instanceof DecorationNode) {
					DecorationNode decorationNode = (DecorationNode) grillingCompartment.getNotationView().getChildren().get(j);
					if (decorationNode.getType().startsWith(ROW)) {
						rows.add(decorationNode);

					}
					if (decorationNode.getType().startsWith(COLUMN)) {
						columns.add(decorationNode);
					}
				}
			}
		}
		Collections.sort(new ArrayList<>(rows), RowComparator);
		Collections.sort(new ArrayList<>(columns), ColumnComparator);
	}

	/**
	 * this class is very specific the the sequence diagram
	 * this purpose of this method is to ensure the consistency of event in the the represented diagram
	 **/
	public void updateSemanticAfterUpdate() {
		// 1. look for all Lifelines
		// There are columns.
		HashSet<Lifeline> lifelineList = new HashSet<Lifeline>();
		for (DecorationNode column : columns) {
			if ((getRef(column)) != null) {
				for (EObject referedElement : getRef(column)) {
					if (referedElement instanceof Lifeline) {
						lifelineList.add((Lifeline) referedElement);
					}
				}
			}

		}
		// for each lifeline recreat the list of covered element
		for (Lifeline lifeline : lifelineList) {
			ArrayList<InteractionFragment> covered = new ArrayList<InteractionFragment>();
			for (DecorationNode row : rows) {
				if ((getRef(row)) != null) {
					for (EObject referedElement : getRef(row)) {
						if (referedElement instanceof InteractionFragment && (!(referedElement instanceof InteractionOperand))) {
							InteractionFragment interactionFragment = (InteractionFragment) (referedElement);
							if (lifeline.getCoveredBys().contains(interactionFragment)) {
								covered.add(interactionFragment);

							}
						}

					}
				}

			}

			// 3. managment of InteractionOperand
			// There are columns.

			ArrayList<InteractionOperand> coveredbyInteractionOperand = new ArrayList<InteractionOperand>();
			for (DecorationNode column : columns) {
				if ((getRef(column)) != null) {
					for (EObject referedElement : getRef(column)) {
						if (referedElement instanceof InteractionOperand) {
							if (!(coveredbyInteractionOperand.contains(referedElement))) {
								coveredbyInteractionOperand.add((InteractionOperand) referedElement);
							} else {
								coveredbyInteractionOperand.remove((InteractionOperand) referedElement);
							}
						}
						if (referedElement.equals(lifeline)) {
							covered.addAll(coveredbyInteractionOperand);
						}
					}
				}

			}

			if (covered.size() == lifeline.getCoveredBys().size()) {
				UMLDiagramEditorPlugin.log.trace(CustomMessages.SEQUENCE_DEBUG_REFERENCEGRID, "equality");//$NON-NLS-1$
				execute(new SetCommand(((IGraphicalEditPart) getHost()).getEditingDomain(), lifeline, UMLPackage.eINSTANCE.getLifeline_CoveredBy(), covered));
			} else if (covered.size() < lifeline.getCoveredBys().size()) {
				UMLDiagramEditorPlugin.log.trace(CustomMessages.SEQUENCE_DEBUG_REFERENCEGRID, "Event not managed or being created");//$NON-NLS-1$
				// covered.addAll(lifeline.getCoveredBys());
				execute(new SetCommand(((IGraphicalEditPart) getHost()).getEditingDomain(), lifeline, UMLPackage.eINSTANCE.getLifeline_CoveredBy(), covered));
			} else if (covered.size() > lifeline.getCoveredBys().size()) {
				UMLDiagramEditorPlugin.log.trace(CustomMessages.SEQUENCE_DEBUG_REFERENCEGRID, "more event than in the lifeline due to combined fragment");//$NON-NLS-1$
				execute(new SetCommand(((IGraphicalEditPart) getHost()).getEditingDomain(), lifeline, UMLPackage.eINSTANCE.getLifeline_CoveredBy(), covered));
			}
		}

	}


	/**
	 * Gets the diagram event broker from the editing domain.
	 *
	 * @return the diagram event broker
	 */
	protected DiagramEventBroker getDiagramEventBroker() {
		TransactionalEditingDomain theEditingDomain = ((IGraphicalEditPart) getHost()).getEditingDomain();
		if (null != theEditingDomain) {
			return DiagramEventBroker.getInstance(theEditingDomain);
		}
		return null;
	}

	/**
	 * @see org.eclipse.gef.editpolicies.AbstractEditPolicy#deactivate()
	 * 
	 */
	@Override
	public void deactivate() {
		getDiagramEventBroker().removeNotificationListener(((EObject) getHost().getModel()), this);
		super.deactivate();
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener#notifyChanged(org.eclipse.emf.common.notify.Notification)
	 *
	 * @param notifications
	 */
	@Override
	public void notifyChanged(Notification notification) {
		if (notification instanceof CommandExecutionNotification) {
			// after a command execution moveAllLinesAtSamePosition is set to false
			// we must explicitly set to true if we want to move it as a line
			//setMoveAllLinesAtSamePosition(true);
			//UMLDiagramEditorPlugin.log.trace(CustomMessages.SEQUENCE_DEBUG_REFERENCEGRID, "executed Command");//$NON-NLS-1$
		} else {

			if (notification.getEventType() == Notification.SET && notification.getNotifier() instanceof Location) {
				updateRowsAndColumns();
				if ((((EObject) notification.getNotifier()).eContainer()) instanceof DecorationNode && rows.contains((((EObject) notification.getNotifier()).eContainer()))) {
					if (notification.getFeature().equals(NotationPackage.eINSTANCE.getLocation_Y())) {
						// when we move line we disconnect listeners to avoid problems of infinite loop
						if (moveAllLinesAtSamePosition) {
							ArrayList<DecorationNode> rowlist = getRowAtPosition(notification.getOldIntValue());
							((EObject) getHost().getModel()).eResource().eAdapters().remove(contentDiagramListener);

							// maybe we must move other lines
							// it exist other lines
							if (rows.size() > rowlist.size()) {
								updateYpositionForRow((DecorationNode) (((EObject) notification.getNotifier()).eContainer()), notification.getOldIntValue());
							}
							for (Iterator<DecorationNode> iterator = rowlist.iterator(); iterator.hasNext();) {
								DecorationNode axis = (DecorationNode) iterator.next();
								execute(new SetBoundsCommand(getDiagramEditPart(getHost()).getEditingDomain(), "update Line", new EObjectAdapter(axis), new Point(0, notification.getNewIntValue())));

							}
							((EObject) getHost().getModel()).eResource().eAdapters().add(contentDiagramListener);
						}

					}
				}
			}
		}
	}



	/**
	 * get the decoration node that represents a column from a position (absolute)
	 * 
	 * @param x
	 *            the position x for the column
	 * @return the decoration node
	 */
	public DecorationNode createColumnTolisten(int x, Element semantic) throws NoGrillElementFound {
		execute(new CreateCoordinateCommand(((IGraphicalEditPart) getHost()).getEditingDomain(), ((BasicCompartment) grillingCompartment.getNotationView()), COLUMN + columns.size(), semantic, x));
		return getLastCreatedAxis();
	}

	/**
	 * get the decoration node that represents a line from a position (absolute)
	 * 
	 * @param y
	 *            the position y for the line
	 * @return the decoration node
	 */
	public DecorationNode createRowTolisten(int y, Element semantic) throws NoGrillElementFound {
		execute(new CreateCoordinateCommand(((IGraphicalEditPart) getHost()).getEditingDomain(), ((BasicCompartment) grillingCompartment.getNotationView()), ROW + rows.size(), semantic, y));
		DecorationNode row = getLastCreatedAxis();
		return row;

	}

	/**
	 * @return get the last created Axis
	 **/
	public DecorationNode getLastCreatedAxis() throws NoGrillElementFound {
		BasicCompartment grid = ((BasicCompartment) grillingCompartment.getNotationView());
		if (grid.getChildren().size() == 0) {
			throw new NoGrillElementFound();
		} else {
			return (DecorationNode) grid.getChildren().get(grid.getChildren().size() - 1);
		}

	}


	/**
	 * 
	 * @param y
	 *            the position y where we look for a row
	 * @return the rows that exists at the position [y- threshold, y+threshold]s
	 */
	public ArrayList<DecorationNode> getRowAtPosition(int y) {
		ArrayList<DecorationNode> sameLines = new ArrayList<DecorationNode>();
		for (Iterator<DecorationNode> iterator = rows.iterator(); iterator.hasNext();) {
			DecorationNode currentRow = iterator.next();
			int Yposition = getPositionY(currentRow);
			if (Yposition - threshold <= y && y <= Yposition + threshold) {
				sameLines.add(currentRow);
			}

		}
		return sameLines;
	}

	/**
	 * @param decorationNode
	 * @return the Position Y for a decoration node
	 */
	public int getPositionY(DecorationNode decorationNode) {
		LayoutConstraint constraint = decorationNode.getLayoutConstraint();
		if (constraint instanceof Location) {
			return ((Location) constraint).getY();
		}
		return 0;
	}


	protected void updateYpositionForRow(DecorationNode movedRow, int y) {
		LayoutConstraint newconstraint = movedRow.getLayoutConstraint();
		DecorationNode nextRow = getDistanceWithNextRow(movedRow, y);
		if (nextRow == null) {
			return;
		}
		LayoutConstraint nextConstraint = nextRow.getLayoutConstraint();
		int nextDistance = ((Location) nextConstraint).getY() - ((Location) newconstraint).getY();
		int margin = getGridSpacing();
		if (nextDistance < margin) {
			ArrayList<DecorationNode> rowsCopy = new ArrayList<DecorationNode>();
			rowsCopy.addAll(rows);
			for (int i = rowsCopy.indexOf(nextRow); i < rowsCopy.size(); i++) {
				LayoutConstraint aConstraint = rowsCopy.get(i).getLayoutConstraint();
				if (aConstraint instanceof Location) {
					execute(new SetCommand(((IGraphicalEditPart) getHost()).getEditingDomain(), aConstraint, NotationPackage.eINSTANCE.getLocation_Y(), ((Location) aConstraint).getY() + margin));
				}
			}
		}
	}

	/**
	 * 
	 * @param currentRow
	 * @param currentRowPosition
	 * @return get the next row that has not the same position
	 */
	protected DecorationNode getDistanceWithNextRow(DecorationNode currentRow, int currentRowPosition) {
		Object[] arrayRow = rows.toArray();
		List<Object> orderedRows = Arrays.asList(arrayRow);
		int index = orderedRows.indexOf(currentRow);
		if (index == orderedRows.size() - 1) {
			return null;
		} else {

			LayoutConstraint currentConstraint = currentRow.getLayoutConstraint();
			DecorationNode nextRow = null;
			// look for the next row
			for (Iterator<DecorationNode> iterator = rows.iterator(); iterator.hasNext();) {
				DecorationNode aRow = iterator.next();
				int Yposition = getPositionY(aRow);
				if (currentRowPosition + threshold < Yposition && (!aRow.equals(currentRow))) {
					nextRow = aRow;
					return nextRow;
				}

			}
			return nextRow;
		}
	}

	protected int getGridSpacing() {
		if (DiagramEditPartsUtil.isSnapToGridActive(getHost())) {

			RootEditPart drep = getHost().getRoot();
			if (drep instanceof DiagramRootEditPart) {
				return (int) ((DiagramRootEditPart) drep).getGridSpacing();
			}
		}
		return margin;
	}

	public static Point getLocation(DecorationNode current) throws NoGrillElementFound {
		LayoutConstraint currentConstraint = current.getLayoutConstraint();
		if (currentConstraint instanceof Location) {
			return new Point(((Location) currentConstraint).getX(), ((Location) currentConstraint).getY());
		} else {
			throw new NoGrillElementFound();
		}
	}

	public static List<EObject> getRef(DecorationNode current) {
		EAnnotation eAnnotation = current.getEAnnotation(GRILL_CONNECTION);
		if (eAnnotation == null) {
			return null;
		} else {
			if (eAnnotation.getReferences().size() != 0) {
				return eAnnotation.getReferences();
			}
			return null;
		}
	}

}