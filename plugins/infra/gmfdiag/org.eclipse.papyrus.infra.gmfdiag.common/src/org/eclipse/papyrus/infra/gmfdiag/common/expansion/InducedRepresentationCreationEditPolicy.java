/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
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
package org.eclipse.papyrus.infra.gmfdiag.common.expansion;

import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.editpolicies.GraphicalEditPolicy;
import org.eclipse.gmf.runtime.diagram.core.listener.DiagramEventBroker;
import org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.core.listenerservice.IPapyrusListener;
import org.eclipse.papyrus.infra.gmfdiag.common.Activator;
import org.eclipse.papyrus.infra.gmfdiag.common.commands.SetNodeVisibilityCommand;
import org.eclipse.papyrus.infra.gmfdiag.common.editpart.IPapyrusEditPart;
import org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.InducedRepresentation;
import org.eclipse.papyrus.infra.gmfdiag.common.service.shape.NotificationManager;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.GMFUnsafe;
import org.eclipse.papyrus.infra.viewpoints.policy.ViewPrototype;
import org.eclipse.swt.widgets.Display;

/**
 * this edit policy can be apply only on {@link IPapyrusEditPart} in order to
 * access to primary figure. the primary figure has to be a {@link IPapyrusNodeUMLElementFigure}.

 * it creates the compartment displaying shapes for an element by reading the expansion model
 * see #Req org.eclipse.papyrus.infra.gmfdiag.expansion.Req_011
 */
public class InducedRepresentationCreationEditPolicy extends GraphicalEditPolicy implements NotificationListener, IPapyrusListener {

	/** constant for this edit policy role */
	public final static String INDUCED_REPRESENTATION_CREATOR_EDITPOLICY = "InducedRepresentationCreationEditPolicy"; //$NON-NLS-1$

	/** manager for notifications: should the compartment react to the notification? */
	protected NotificationManager notificationManager;

	protected DiagramExpansionsRegistry diagramExpansionRegistry;

	/**
	 * Creates a new AppliedStereotype display edit policy
	 */
	public InducedRepresentationCreationEditPolicy() {
		super();
		this.diagramExpansionRegistry = DiagramExpansionSingleton.getInstance().getDiagramExpansionRegistry();
	}

	/**
	 *
	 * {@inheritDoc}
	 */
	@Override
	public void activate() {
		super.activate();
		// retrieve the view and the element managed by the edit part
		View view = getView();
		if (view == null) {
			return;
		}
		updateAddedCompartment();

	}

	/**
	 *
	 * {@inheritDoc}
	 */
	@Override
	public void deactivate() {
		// retrieve the view and the element managed by the edit part
		View view = getView();
		if (view == null) {
			return;
		}
		super.deactivate();
	}

	/**
	 * Returns the view controlled by the host edit part
	 *
	 * @return the view controlled by the host edit part
	 */
	protected View getView() {
		return (View) getHost().getModel();
	}

	/**
	 * {@inheritDoc}
	 */
	public void refreshDisplay() {
		final IGraphicalEditPart editPart = (IGraphicalEditPart) getHost();
		editPart.refresh();
	}


	/**
	 * the goal of this method is to execute the a command to create a notation node for a compartment of stereotype
	 *
	 * @param editPart
	 *            the editpart owner of the new compartment
	 * @param appliedstereotype
	 *            the stereotype application
	 */
	protected void executeShapeCompartmentCreation(final IGraphicalEditPart editPart, HashMap<String, View> existedDynamicCompartment, List<String> wantedChildreenID,ChildrenListRepresentation listRepresentation) {
		for (String wantedID : wantedChildreenID) {
			if( existedDynamicCompartment.get(wantedID)==null){	
				if( listRepresentation.IDMap.get(wantedID) instanceof InducedRepresentation){
					try {
						TransactionalEditingDomain domain = getEditingDomain(editPart);

						CreateInducedRepresentationViewCommand command = new CreateInducedRepresentationViewCommand
								(domain,
										"view Creation",
										wantedID,
										"view Creation",
										editPart.getNotationView(),
										true,
										editPart.getDiagramPreferencesHint());
						try {
							// This should not change the command stack, as this transaction will only manipulate transient views. Create a transaction manually, if needed
							GMFUnsafe.write(domain, command);
						} catch (Exception e) {
							Activator.log.error(e);
						}
					} catch (Exception e) {
						Activator.log.error(e);
					}
				}
			}
		}


	}

	/**
	 * Returns the editing domain for the given edit Part
	 *
	 * @param editPart
	 *            the edit part from which editing domain is searched
	 * @return the editing domain
	 */
	protected TransactionalEditingDomain getEditingDomain(IGraphicalEditPart editPart) {
		return editPart.getEditingDomain();
	}

	/**
	 * Gets the diagram event broker from the editing domain.
	 *
	 * @return the diagram event broker
	 */
	protected DiagramEventBroker getDiagramEventBroker() {
		TransactionalEditingDomain theEditingDomain = ((IGraphicalEditPart) getHost()).getEditingDomain();
		if (theEditingDomain != null) {
			return DiagramEventBroker.getInstance(theEditingDomain);
		}
		return null;
	}

	/**
	 *
	 * {@inheritedDoc}
	 */
	@Override
	public void notifyChanged(Notification notification) {
		refreshDisplay();
	}
	protected String getDiagramType(View currentView) {
		Diagram diagram=currentView.getDiagram();
		String currentDiagramType=null;
		ViewPrototype viewPrototype=org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramUtils.getPrototype(diagram);
		if(viewPrototype!=null){
			currentDiagramType=viewPrototype.getLabel();
		}
		else{
			currentDiagramType=diagram.getType();
		}
		return currentDiagramType;
	}
	/**
	 * this method creates a node for the compartment of stereotype if it does not exist.
	 *
	 * @param stereotypeApplication
	 *            the stereotype application
	 */
	public void updateAddedCompartment() {
		final IGraphicalEditPart editPart = (IGraphicalEditPart) getHost();
		final View view = editPart.getNotationView();
		String diagramType= getDiagramType(view);
		ChildrenListRepresentation listRepresentation=diagramExpansionRegistry.mapChildreen.get(diagramType);
		if( listRepresentation==null){
			return;
		}
		List<String> childreenID=listRepresentation.parentChildrenRelation.get(view.getType());
		if( childreenID==null){
			return;
		}
		// Look for the node for the shape compartment
		HashMap<String,View> dynamicCompartments = getAddedCompartmentView(view, childreenID);
		// it does not exist
		if (dynamicCompartments.size()<childreenID.size()) {

			executeShapeCompartmentCreation(editPart, dynamicCompartments, childreenID, listRepresentation);
		}
	}

	/**
	 * Returns the view corresponding to the shape compartment
	 *
	 * @param view 
	 * @return
	 */
	private HashMap<String,View> getAddedCompartmentView(View view, List<String> childreenID) {

		HashMap<String,View> dynamicCompartments= new HashMap<String,View>();
		for (Object child : view.getChildren()) {
			if (child instanceof View && childreenID.contains(((View) child).getType())) {
				dynamicCompartments.put((((View) child).getType()), (View) child);
			}
		}
		return dynamicCompartments;
	}


}