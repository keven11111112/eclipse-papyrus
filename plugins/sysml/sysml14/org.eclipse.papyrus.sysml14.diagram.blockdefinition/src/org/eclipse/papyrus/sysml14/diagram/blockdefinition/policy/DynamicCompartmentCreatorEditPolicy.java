/*****************************************************************************
 * Copyright (c) 2012, 2014 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 323802
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml14.diagram.blockdefinition.policy;

import java.util.HashMap;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.editpolicies.GraphicalEditPolicy;
import org.eclipse.gmf.runtime.diagram.core.listener.DiagramEventBroker;
import org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.core.listenerservice.IPapyrusListener;
import org.eclipse.papyrus.infra.gmfdiag.common.commands.SetNodeVisibilityCommand;
import org.eclipse.papyrus.infra.gmfdiag.common.editpart.IPapyrusEditPart;
import org.eclipse.papyrus.infra.gmfdiag.common.service.shape.NotificationManager;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.GMFUnsafe;
import org.eclipse.papyrus.sysml14.diagram.blockdefinition.IDRegistry;
import org.eclipse.papyrus.sysml14.diagram.blockdefinition.command.CreateDynamicCompartmentViewCommand;
import org.eclipse.papyrus.sysml14.diagram.blockdefinition.editpart.DynamicListCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.common.figure.node.IPapyrusNodeUMLElementFigure;
import org.eclipse.swt.widgets.Display;

/**
 * this edit policy can be apply only on {@link IPapyrusEditPart} in order to
 * access to primary figure. the primary figure has to be a {@link IPapyrusNodeUMLElementFigure}.
 * This edit policy manage the display of a shape in a new compartment and toggles the compartment display.
 */
public class DynamicCompartmentCreatorEditPolicy extends GraphicalEditPolicy implements NotificationListener, IPapyrusListener {

	/** constant for this edit policy role */
	public final static String COMPARTMENT_CREATOR_EDITPOLICY = "CompartmentCreatorEditPolicy"; //$NON-NLS-1$

	/** manager for notifications: should the compartment react to the notification? */
	protected NotificationManager notificationManager;

	/**
	 * Creates a new AppliedStereotype display edit policy
	 */
	public DynamicCompartmentCreatorEditPolicy() {
		super();
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
	protected void executeShapeCompartmentCreation(final IGraphicalEditPart editPart, HashMap<String, View> existedDynamicCompartment) {
		if( existedDynamicCompartment.get(IDRegistry.FLOWPORT_COMPARMENT_NAME)==null){	
			try {
				TransactionalEditingDomain domain = getEditingDomain(editPart);

				CreateDynamicCompartmentViewCommand command = new CreateDynamicCompartmentViewCommand
						(domain,
								"compartementCreation",
								IDRegistry.FLOWPORT_COMPARMENT_NAME,
								"compartementCreation",
								editPart.getNotationView(),
								true,
								editPart.getDiagramPreferencesHint());
				try {
					// This should not change the command stack, as this transaction will only manipulate transient views. Create a transaction manually, if needed
					GMFUnsafe.write(domain, command);
				} catch (Exception e) {
					System.err.println(e);
				}
			} catch (Exception e) {
				System.err.println(e);
			}
		}
		if( existedDynamicCompartment.get(IDRegistry.NESTED_PART_COMPARMENT_NAME)==null){	
			try {
				TransactionalEditingDomain domain = getEditingDomain(editPart);

				CreateDynamicCompartmentViewCommand command = new CreateDynamicCompartmentViewCommand
						(domain,
								"compartementCreation",
								"Nested Parts",
								"compartementCreation",
								editPart.getNotationView(),
								true,
								editPart.getDiagramPreferencesHint());
				try {
					// This should not change the command stack, as this transaction will only manipulate transient views. Create a transaction manually, if needed
					GMFUnsafe.write(domain, command);
				} catch (Exception e) {
					System.err.println(e);
				}
			} catch (Exception e) {
				System.err.println(e);
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

	/**
	 * this method creates a node for the compartment of stereotype if it does not exist.
	 *
	 * @param stereotypeApplication
	 *            the stereotype application
	 */
	public void updateAddedCompartment() {
		final IGraphicalEditPart editPart = (IGraphicalEditPart) getHost();
		final View node = editPart.getNotationView();
		// Look for the node for the shape compartment
		HashMap<String,View> dynamicCompartments = getAddedCompartmentView(node);
		// it does not exist
		if (dynamicCompartments.size()<2) {
			//ResizableCompartmentViewFactory compartmentViewFactory= new ResizableCompartmentViewFactory();
			//compartmentViewFactory.createView(null, editPart.getNotationView(), ProtoFlowPortCompartmentEditPart.COMPARTMENT_NAME, -1, true, null);

			executeShapeCompartmentCreation(editPart, dynamicCompartments);
		}
	}

	/**
	 * Returns the view corresponding to the shape compartment
	 *
	 * @param node
	 * @return
	 */
	private HashMap<String,View> getAddedCompartmentView(View node) {
		HashMap<String,View> dynamicCompartments= new HashMap<String,View>();
		for (Object child : node.getChildren()) {
			if (child instanceof View && IDRegistry.FLOWPORT_COMPARMENT_NAME.equals(((View) child).getType())) {
				dynamicCompartments.put(IDRegistry.FLOWPORT_COMPARMENT_NAME, (View) child);
			}
			if (child instanceof View && IDRegistry.NESTED_PART_COMPARMENT_NAME.equals(((View) child).getType())) {
				dynamicCompartments.put(IDRegistry.NESTED_PART_COMPARMENT_NAME, (View) child);
			}
		}
		return dynamicCompartments;
	}

	/**
	 * the goal of this method is to execute the a command to create a notation node for a compartment of stereotype
	 *
	 * @param editPart
	 *            the editpart owner of the new compartment
	 * @param appliedstereotype
	 *            the stereotype application
	 */
	protected void setVisibility(final View view, final boolean isVisible) {
		final GraphicalEditPart editPart = (GraphicalEditPart) getHost();
		Display.getCurrent().asyncExec(new Runnable() {

			@Override
			public void run() {
				SetNodeVisibilityCommand setCommand = new SetNodeVisibilityCommand(editPart.getEditingDomain(), view, isVisible);
				// use to avoid to put it in the command stack
				try {
					GMFUnsafe.write(editPart.getEditingDomain(), setCommand);
				} catch (Exception e) {
					System.err.println(e);
				}
			}
		});
	}

}
