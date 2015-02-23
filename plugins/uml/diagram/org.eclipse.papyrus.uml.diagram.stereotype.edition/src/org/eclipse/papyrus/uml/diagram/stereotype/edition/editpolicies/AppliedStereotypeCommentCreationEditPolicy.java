/*****************************************************************************
 * Copyright (c) 2012, 2014 CEA LIST and others.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 323802
 *  Gabriel Pascual (ALL4TEC) gabriel.pascual@all4tec.fr - Bug 393532
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.stereotype.edition.editpolicies;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.BorderedBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.BasicCompartment;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.LayoutConstraint;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.GMFUnsafe;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeNodeLabelDisplayEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.stereotype.CreateAppliedStereotypeCommentContentCommand;
import org.eclipse.papyrus.uml.diagram.common.stereotype.CreateAppliedStereotypeCommentViewCommand;
import org.eclipse.papyrus.uml.diagram.common.stereotype.StereotypeLocationEnum;
import org.eclipse.papyrus.uml.tools.listeners.StereotypeElementListener.StereotypeExtensionNotification;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Element;

/**
 * This editpolicy has in charge to :
 * - create or destroy the appliedStereotypesCommentEditpart
 * - adapt the information about stereotype display into appliedstereotypeCommentEditPart
 * by using NamedStyle mechanism into Notation model
 * 
 *
 */
public class AppliedStereotypeCommentCreationEditPolicy extends AppliedStereotypeNodeLabelDisplayEditPolicy {


	/** constant for this edit policy role */
	public final static String APPLIED_STEREOTYPE_COMMENT = "AppliedStereotypeComment";// $NON-NLS-1$

	protected GraphicalEditPart hostEditPart;
	private Node node;
	private Node comment;

	/**
	 * Map between Stereotype Name and StereotypeLabel displayed
	 */
	private Map<EObject, BasicCompartment> stereotypeCommentMap = new HashMap<EObject, BasicCompartment>();



	/**
	 * @see org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeLabelDisplayEditPolicy#activate()
	 *
	 */
	@Override
	public void activate() {
		super.activate();
		if (getHost() instanceof GraphicalEditPart) {
			hostEditPart = (GraphicalEditPart) getHost();
			node = getNotationNode();

		}

		// if stereotype has been applied, compartment has to be created
		Element umlElement = getUMLElement();
		// umlElement may be null if the semantic element has been deleted and the view hasn't been cleaned
		if (umlElement != null) {
			Iterator<EObject> iterator = umlElement.getStereotypeApplications().iterator();
			while (iterator.hasNext()) {
				final EObject appliedstereotype = iterator.next();
				createAppliedStereotypeCompartmentComment(appliedstereotype);

			}
		}
	}

	/**
	 *
	 * {@inheritedDoc}
	 */
	@Override
	public void notifyChanged(Notification notification) {

		final int eventType = notification.getEventType();

		if (eventType == StereotypeExtensionNotification.STEREOTYPE_APPLIED_TO_ELEMENT) {
			super.notifyChanged(notification);

			getDiagramEventBroker().addNotificationListener((EObject) notification.getNewValue(), this);
			createAppliedStereotypeCompartmentComment((EObject) notification.getNewValue());


		} else if (eventType == StereotypeExtensionNotification.STEREOTYPE_UNAPPLIED_FROM_ELEMENT) {
			// super.notifyChanged(notification);
			getDiagramEventBroker().removeNotificationListener((EObject) notification.getOldValue(), this);
			removeAppliedStereotypeCompartmentComment((EObject) notification.getOldValue());



		}

	}

	/**
	 * @return the stereotypeCommentMap
	 */
	public Map<EObject, BasicCompartment> getStereotypeCommentMap() {
		return stereotypeCommentMap;
	}


	/**
	 * This method creates a node for the compartment of stereotype if it does not exist.
	 *
	 * @param stereotypeApplication
	 *            the stereotype application
	 */
	protected void createAppliedStereotypeCompartmentComment(final EObject stereotypeApplication) {

		Node compartment = helper.getStereotypeCompartment(node, stereotypeApplication);
		if (compartment != null) {
			// If the node should be displayed in a Compartment or Brace Comment then create the Comment and its content
			if (!helper.isEmpty(compartment, StereotypeLocationEnum.IN_COMMENT_BRACE)
					|| (!helper.isEmpty(compartment, StereotypeLocationEnum.IN_COMMENT_COMPARTMENT))) {

				if (helper.getStereotypeComment(node) == null) {
					// if Comment doesn't exist => Create it and copy the structure from the host

					if (getHost() instanceof ConnectionEditPart) {
						executeAppliedStereotypeCommentCreation(((ConnectionEditPart) getHost()).resolveSemanticElement());
					}
					if (getHost() instanceof GraphicalEditPart) {
						executeAppliedStereotypeCommentCreation(((GraphicalEditPart) getHost()).resolveSemanticElement());
					}

				}

				executeAppliedStereotypeCommentContent(compartment, stereotypeApplication);
			}
		}
	}

	/**
	 * Remove the Compartment into the Comment associated to the stereotypeApplication
	 * 
	 * @param stereotypeApplication
	 *            the stereotypeApplication associated to the compartment to be deleted
	 */
	protected void removeAppliedStereotypeCompartmentComment(EObject stereotypeApplication) {
		// Remove the Label node
		BasicCompartment compartment = getStereotypeCommentMap().get(stereotypeApplication);
		if ((compartment != null) && (TransactionUtil.getEditingDomain(compartment) != null)) {
			executeAppliedStereotypeCompartmentRemove(hostEditPart, compartment);
			// Delete entry from the Map
			deleteInCommentMap(stereotypeApplication);
		}
	}

	/**
	 * Add the compartment into the Comment Edit Part
	 * 
	 * @param stereotypeApplication
	 *            The Stereotype Application associated to the new Compartment
	 */
	protected void executeAppliedStereotypeCommentContent(Node compartment, EObject stereotypeApplication) {
		comment = helper.getStereotypeComment(node);
		if (comment != null) {
			executeAppliedStereotypeCommentContentCreationCommand(compartment);

			// Store entry in the Map
			storeInCommentMap(stereotypeApplication, comment);
		}
	}

	/**
	 * Create the Comment content based on the original model content
	 * 
	 * @param compartment
	 *            The original compartment on which is based the Comment compartment to be added into the Comment model
	 */
	protected void executeAppliedStereotypeCommentContentCreationCommand(Node compartment) {
		final RecordingCommand cmd = new CreateAppliedStereotypeCommentContentCommand("Applied Stereotype Delegation", comment, hostEditPart, compartment);
		final TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(getView());
		Display.getCurrent().syncExec(new Runnable() {

			public void run() {
				// use to avoid to put it in the command stack
				try {
					GMFUnsafe.write(domain, cmd);
				} catch (Exception e) {
					Activator.log.error(e);
				}
			}
		});
	}

	/**
	 * The goal of this method is to execute the a command to create a notation node for applied stereotype
	 * as "Comment" shape.
	 *
	 * @param appliedstereotype
	 *            the stereotype application
	 */
	protected void executeAppliedStereotypeCommentCreation(final EObject node) {

		final TransactionalEditingDomain domain = hostEditPart.getEditingDomain();
		Display.getCurrent().syncExec(new Runnable() {

			public void run() {
				int x = 200;
				int y = 100;
				if (hostEditPart.getModel() instanceof Node) {
					LayoutConstraint constraint = ((Node) hostEditPart.getModel()).getLayoutConstraint();
					if (constraint instanceof Bounds) {
						x = x + ((Bounds) constraint).getX();
						y = ((Bounds) constraint).getY();
					}

				}
				if (hostEditPart.getModel() instanceof Edge && ((((Edge) hostEditPart.getModel()).getSource()) instanceof Node)) {

					LayoutConstraint constraint = ((Node) ((Edge) hostEditPart.getModel()).getSource()).getLayoutConstraint();
					if (constraint instanceof Bounds) {
						x = x + ((Bounds) constraint).getX();
						y = ((Bounds) constraint).getY() - 100;
					}

				}
				boolean isBorderElement = false;
				if (hostEditPart instanceof BorderedBorderItemEditPart) {
					isBorderElement = true;
				}
				if (helper.getStereotypeComment((View) getHost().getModel()) == null) {
					CreateAppliedStereotypeCommentViewCommand command = new CreateAppliedStereotypeCommentViewCommand(domain, (View) hostEditPart.getModel(), x, y, node, isBorderElement);
					// use to avoid to put it in the command stack
					try {
						GMFUnsafe.write(domain, command);
					} catch (Exception e) {
						Activator.log.error(e);
					}
				}
			}

		});
	}

	/**
	 * In Charge to delete the Comment Node.
	 *
	 * @param domain
	 *            the transactional editing domain
	 * @param commentNode
	 *            the view that represent the comment of stereotype
	 */

	protected void executeAppliedStereotypeCommentDeletion(final TransactionalEditingDomain domain, final View commentNode) {
		Display.getCurrent().syncExec(new Runnable() {

			public void run() {
				// because it is asynchrony the comment node maybe become s null
				if (commentNode != null && TransactionUtil.getEditingDomain(commentNode) != null) {
					DeleteCommand command = new DeleteCommand(commentNode);
					// use to avoid to put it in the command stack
					try {
						GMFUnsafe.write(domain, command);
					} catch (Exception e) {
						Activator.log.error(e);
					}
				}
			}
		});
	}



	/**
	 * This method has in charge to refresh the presence of the view that represent the comment
	 */
	protected void updateAppliedStereotypeCommentShape() {


		// look for the AppliedStereotypesCommentEditPart
		Node commentNode = helper.getStereotypeComment(node);

		if (helper.hasStereotypeCompartment(node)) {

			// if Comment doesn't exist => Create it and copy the structure from the host
			if (commentNode == null) {

				if (getHost() instanceof ConnectionEditPart) {
					executeAppliedStereotypeCommentCreation(((ConnectionEditPart) getHost()).resolveSemanticElement());
				}
				if (getHost() instanceof GraphicalEditPart) {
					executeAppliedStereotypeCommentCreation(((GraphicalEditPart) getHost()).resolveSemanticElement());
				}
			}

		} else {
			// If the host doesn't have compartment remove the Comment if any
			if (commentNode != null) {
				final TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(commentNode);
				executeAppliedStereotypeCommentDeletion(domain, commentNode);
			}
		}
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeNodeLabelDisplayEditPolicy#refreshStereotypeDisplay()
	 *
	 */
	@Override
	protected void refreshStereotypeDisplay() {
		refreshComment();
	}

	/**
	 * Refresh The Comment Figure. Delete if empty.
	 */
	protected void refreshComment() {

		// Refresh to create Comment if CSS Change
		if (node != null) {
			if (node.getElement() instanceof Element) {
				Element elt = (Element) node.getElement();
				EList<EObject> appliedStereotypes = elt.getStereotypeApplications();
				for (EObject obj : appliedStereotypes) {
					getDiagramEventBroker().addNotificationListener(obj, this);
					createAppliedStereotypeCompartmentComment(obj);

				}
			}
		}

		// Delete Comment if empty
		comment = helper.getStereotypeComment(node);
		if (comment != null) {
			if (helper.isCommentEmpty(comment)) {
				// Delete the Comment Node
				executeAppliedStereotypeCommentDeletion(hostEditPart.getEditingDomain(), comment);
			}
		}


	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeLabelDisplayEditPolicy#storeInMap(org.eclipse.emf.ecore.EObject, org.eclipse.gmf.runtime.notation.View)
	 *
	 * @param stereotypeApplication
	 *            The Application Of the stereotype to be stored
	 * @param node
	 *            the Comment Node which contains the Applied Stereotype Compartments
	 */

	protected void storeInCommentMap(EObject stereotypeApplication, View node) {

		if (stereotypeApplication != null && node != null) {
			BasicCompartment compartment = helper.getStereotypeCompartment(node, stereotypeApplication);
			getStereotypeCommentMap().put(stereotypeApplication, compartment);


		}

	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeLabelDisplayEditPolicy#deleteInMap(org.eclipse.emf.ecore.EObject)
	 *
	 * @param stereotypeApplication
	 */

	protected void deleteInCommentMap(EObject stereotypeApplication) {
		getStereotypeCommentMap().remove(stereotypeApplication);
	}

	/**
	 * Get the Node (notation) corresponding to the Host editpart
	 */
	protected Node getNotationNode() {
		Node node = null;

		if (hostEditPart != null) {
			View view = hostEditPart.getNotationView();
			if (view instanceof Node) {
				node = (Node) view;
			}
		}
		return node;
	}



}
