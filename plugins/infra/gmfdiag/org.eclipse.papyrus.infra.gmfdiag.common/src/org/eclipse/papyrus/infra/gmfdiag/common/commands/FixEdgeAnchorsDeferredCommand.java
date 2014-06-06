/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/



package org.eclipse.papyrus.infra.gmfdiag.common.commands;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.SetConnectionAnchorsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.internal.commands.SetConnectionBendpointsCommand;
import org.eclipse.gmf.runtime.diagram.ui.util.EditPartUtil;
import org.eclipse.gmf.runtime.draw2d.ui.figures.BaseSlidableAnchor;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.helper.IdentityAnchorHelper;
import org.eclipse.papyrus.infra.gmfdiag.common.routers.RouterUtil;


/**
 * 
 * see bug 430702: [Diagram] Moving source of a link moves the target too.
 * 
 * This class allows to fix the anchors for a collection of connection edit part
 * 
 */
//FIXME : rename me into FixEdgePointDeferredCommand
@SuppressWarnings("restriction")
public class FixEdgeAnchorsDeferredCommand extends AbstractTransactionalCommand {

	/**
	 * the list of the connections to refresh
	 */
	private Collection<?> connectionsEditPartToRefresh;

	/** the diagram editpart used to get the editpart registry */
	private IGraphicalEditPart containerEP;

	/**
	 * the initial point lists of the connection before the refresh of the diagram
	 */
	private Map<Connection, PointList> initialPointLists;

	/**
	 * the initial bounds request
	 */
	private ChangeBoundsRequest request;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param editingDomain
	 * @param request
	 * @param containerEP
	 * @param connectionsEditPartToRefresh
	 */
	public FixEdgeAnchorsDeferredCommand(final TransactionalEditingDomain editingDomain, ChangeBoundsRequest request, final IGraphicalEditPart containerEP, final Collection<?> connectionsEditPartToRefresh) {
		super(editingDomain, "Fix Edge Anchors", null); //$NON-NLS-1$
		this.containerEP = containerEP;
		this.initialPointLists = new HashMap<Connection, PointList>();
		this.request = request;
		this.connectionsEditPartToRefresh = new ArrayList<Object>(connectionsEditPartToRefresh);
		for(Object object : connectionsEditPartToRefresh) {
			if(object instanceof IGraphicalEditPart) {
				final IFigure fig = ((IGraphicalEditPart)object).getFigure();
				if(fig instanceof Connection) {
					final Connection conn = (Connection)fig;
					this.initialPointLists.put(conn, conn.getPoints().getCopy());
				}
			}
		}
	}

	/**
	 * Fix the anchor and the bendpoints
	 * 
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
		//1.refresh the container (force the routing of existing link
		final RefreshConnectionElementsRunnable refreshRunnable = new RefreshConnectionElementsRunnable(this.connectionsEditPartToRefresh, this.containerEP);

		EditPartUtil.synchronizeRunnableToMainThread(this.containerEP, refreshRunnable);

		for(AbstractConnectionEditPart conn : refreshRunnable.getResult()) {

			//2.detemrine if we are moving source or target
			final boolean isMovingSource;
			final Connection fig = (Connection)conn.getFigure();
			final EditPart sourceEP = conn.getSource();
			final EditPart targetEP = conn.getTarget();
			if(sourceEP == targetEP) {
				//we do nothing
				continue;
			}
			List<?> movedEP = this.request.getEditParts();
			if(movedEP.contains(sourceEP) && movedEP.contains(targetEP)) {
				//in some case there is nothing to do
				//in some others cases (port ? ) it could be interesting to do something
				//we decide to follow the source!
				isMovingSource = true;
			} else if(movedEP.contains(sourceEP)) {
				isMovingSource = true;
			} else if(movedEP.contains(targetEP)) {
				isMovingSource = false;
			} else {
				throw new UnknownError("we are updating link points related to an unknown source/target"); //$NON-NLS-1$
			}


			final PointList newPointList = RouterUtil.routeDummyConnection(fig, this.initialPointLists.get(fig), isMovingSource);
			Edge edge = (Edge)conn.getAdapter(Edge.class);
			final EObjectAdapter adapter = new EObjectAdapter(edge);

			final CompositeCommand fixEdgePointCommand = new CompositeCommand("Fix Edge Point Command");

			final SetConnectionAnchorsCommand setAnchorCommand = new SetConnectionAnchorsCommand(getEditingDomain(), ""); //$NON-NLS-1$
			setAnchorCommand.setEdgeAdaptor(adapter);

			final PrecisionPoint sourceLocation = BaseSlidableAnchor.getAnchorRelativeLocation(newPointList.getFirstPoint(), fig.getSourceAnchor().getOwner().getBounds());
			final String newSourceTerminal = IdentityAnchorHelper.createNewAnchorIdValue(sourceLocation);
			setAnchorCommand.setNewSourceTerminal(newSourceTerminal);

			final PrecisionPoint targetLocation = BaseSlidableAnchor.getAnchorRelativeLocation(newPointList.getLastPoint(), fig.getTargetAnchor().getOwner().getBounds());
			final String newTargetTerminal = IdentityAnchorHelper.createNewAnchorIdValue(targetLocation);
			setAnchorCommand.setNewTargetTerminal(newTargetTerminal);
			fixEdgePointCommand.add(setAnchorCommand);

			SetConnectionBendpointsCommand setBendpointsCommand = new SetConnectionBendpointsCommand(getEditingDomain());
			setBendpointsCommand.setEdgeAdapter(adapter);
			setBendpointsCommand.setNewPointList(newPointList, newPointList.getFirstPoint(), newPointList.getLastPoint());

			fixEdgePointCommand.add(setBendpointsCommand);
			fixEdgePointCommand.execute(new NullProgressMonitor(), null);
		}
		return CommandResult.newOKCommandResult();
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#getAffectedFiles()
	 * 
	 * @return
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List getAffectedFiles() {
		if(this.containerEP != null) {
			View view = (View)this.containerEP.getModel();
			if(view != null) {
				IFile f = WorkspaceSynchronizer.getFile(view.eResource());
				return f != null ? Collections.singletonList(f) : Collections.EMPTY_LIST;
			}
		}
		return super.getAffectedFiles();
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#cleanup()
	 * 
	 */
	@Override
	protected void cleanup() {
		super.cleanup();
		this.connectionsEditPartToRefresh.clear();
		this.initialPointLists.clear();
		this.initialPointLists = null;
		this.connectionsEditPartToRefresh = null;
	}

	/**
	 * 
	 * This runnable is used to refresh the figure source/target of the connection before updating their point list
	 * 
	 */
	private static class RefreshConnectionElementsRunnable extends AbstractRefreshConnectionElementsRunnable<Collection<AbstractConnectionEditPart>> {

		/**
		 * the list of the connections to refresh
		 */
		private Collection<?> connectionsEditPartToRefresh;

		/**
		 * 
		 * Constructor.
		 * 
		 * @param connectionsEditPartToRefresh
		 *        the list of the connection edit part to refresh
		 * @param containerEP
		 */
		public RefreshConnectionElementsRunnable(final Collection<?> connectionsEditPartToRefresh, final IGraphicalEditPart containerEP) {
			super(containerEP);
			this.connectionsEditPartToRefresh = connectionsEditPartToRefresh;
		}

		/**
		 * 
		 * @see java.lang.Runnable#run()
		 * 
		 */
		@Override
		public void run() {
			getContainerEditPart().refresh();

			// We update the figure world 
			getContainerFigure().invalidate();
			getContainerFigure().validate();
			final Iterator<?> iter = this.connectionsEditPartToRefresh.iterator();
			final Collection<AbstractConnectionEditPart> connectionsEP = new HashSet<AbstractConnectionEditPart>();
			setResult(connectionsEP);
			while(iter.hasNext()) {
				final Object object = iter.next();
				if(object instanceof AbstractConnectionEditPart) {
					connectionsEP.add((AbstractConnectionEditPart)object);
					refreshConnection((AbstractConnectionEditPart)object);
				}
			}
			setStatus(Status.OK_STATUS);
		}
	}
}
