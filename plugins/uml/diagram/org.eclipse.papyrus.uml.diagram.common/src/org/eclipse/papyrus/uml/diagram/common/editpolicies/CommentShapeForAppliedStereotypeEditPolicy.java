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
 *  Celine Janssens (ALL4TEC) celine.janssens@all4tec.net - Bug 460356 : Refactor Stereotype Display
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.editpolicies;

import java.util.Iterator;

import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.core.listener.DiagramEventBroker;
import org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.core.listenerservice.IPapyrusListener;
import org.eclipse.papyrus.infra.gmfdiag.common.editpart.IPapyrusEditPart;
import org.eclipse.papyrus.infra.gmfdiag.common.model.NotationUtils;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.GMFUnsafe;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.diagram.common.figure.node.IPapyrusNodeUMLElementFigure;
import org.eclipse.papyrus.uml.diagram.common.stereotype.StereotypeDisplayUtils;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * This Edit Policy is attached to AppliedStereotypeCommentEdipart, and is in charge to prevent the deletion of the Comment from model
 * and launch command of deletion if it detect that no property of applied stereotype are displayed.
 *
 */
public class CommentShapeForAppliedStereotypeEditPolicy extends AbstractAppliedStereotypeDisplayEditPolicy implements NotificationListener, IPapyrusListener {


	/**
	 * Returns the uml element controlled by the host edit part
	 *
	 * @return the uml element controlled by the host edit part
	 */
	@Override
	protected Element getUMLElement() {
		Element element = null;
		if ((Element) getView().getElement() != null) {
			element = (Element) getView().getElement();
		} else {

			EObject object = NotationUtils.getEObjectValue(getView(), StereotypeDisplayUtils.STEREOTYPE_COMMENT_RELATION_NAME, null);
			if (object != null) {
				if (object instanceof Element) {
					element = (Element) object;
				} else {
					if (UMLUtil.getStereotype(object) != null) {
						element = UMLUtil.getStereotype(object);
					}
				}
			}
		}
		return element;
	}

	@Override
	public Command getCommand(Request request) {
		if (request instanceof EditCommandRequestWrapper) {
			if (((EditCommandRequestWrapper) (request)).getEditCommandRequest() instanceof DestroyElementRequest) {
				return UnexecutableCommand.INSTANCE;
			}
		}
		return super.getCommand(request);
	}

	/**
	 * Refreshes the stereotypes properties displayed above name of the element
	 * in this edit part.
	 * 
	 * @param stereotypesPropertiesToDisplay
	 */
	protected void refreshAppliedStereotypesPropertiesInBrace(IPapyrusNodeUMLElementFigure figure) {
		String toDisplayInBrace = helper.getStereotypePropertiesInBrace(((GraphicalEditPart) getHost()).getNotationView());
		// if the string is not empty, then, the figure has to display it. Else,
		// it displays nothing
		if (!"".equals(toDisplayInBrace)) {
			// it has to be displayed in braces, so compute the string to
			// display
			figure.setStereotypePropertiesInBrace(toDisplayInBrace);
		} else {
			figure.setStereotypePropertiesInBrace(null);
		}
	}

	/**
	 * Execute Comment Deletion
	 * 
	 * @param domain
	 *            TransactionalDomain
	 * @param commentNode
	 *            Node of the Comment to be deleted.
	 */
	protected void executeAppliedStereotypeCommentDeletion(final TransactionalEditingDomain domain, final View commentNode) {

		Display.getCurrent().asyncExec(new Runnable() {

			@Override
			public void run() {
				// because it is asynchronous the comment node's domain maybe become null
				if (TransactionUtil.getEditingDomain(commentNode) == domain) {
					DeleteCommand command = new DeleteCommand(commentNode);
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
	 * Get the number of Visible Compartments
	 * 
	 * @param view
	 *            The View where the number of visible Compartment are evaluated
	 * 
	 * @return the number of Visible Stereotype Compartment
	 */
	protected int getAppliedStereotypeCompartmentNumber(View view) {
		int nbVisibleCompartment = 0;
		Iterator<View> iteratorView = view.getChildren().iterator();
		while (iteratorView.hasNext()) {
			View subview = iteratorView.next();
			if (helper.isStereotypeBrace(subview) || helper.isStereotypeCompartment(subview)) {
				nbVisibleCompartment++;
			}
		}
		return nbVisibleCompartment;
	}




	@Override
	public void activate() {
		// retrieve the view and the element managed by the edit part
		View view = getView();
		if (view == null) {
			return;
		}

		// adds a listener on the view and the element controlled by the
		// editpartrefr
		getDiagramEventBroker().addNotificationListener(view, this);
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

		getDiagramEventBroker().removeNotificationListener(view, this);
	}

	/**
	 * Gets the diagram event broker from the editing domain.
	 *
	 * @return the diagram event broker
	 */
	@Override
	protected DiagramEventBroker getDiagramEventBroker() {
		TransactionalEditingDomain theEditingDomain = ((IGraphicalEditPart) getHost()).getEditingDomain();
		if (theEditingDomain != null) {
			return DiagramEventBroker.getInstance(theEditingDomain);
		}
		return null;
	}

	/**
	 * Returns the view controlled by the host edit part
	 *
	 * @return the view controlled by the host edit part
	 */
	@Override
	protected View getView() {
		return (View) getHost().getModel();
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeLabelDisplayEditPolicy#refreshStereotypeDisplay()
	 *
	 */

	protected void refreshStereotypeDisplay() {
		IFigure figure = ((IPapyrusEditPart) getHost()).getPrimaryShape();

		// refresh Brace display
		if (figure instanceof IPapyrusNodeUMLElementFigure) {
			refreshAppliedStereotypesPropertiesInBrace((IPapyrusNodeUMLElementFigure) figure);
		}

		// Deletion of Comment
		View commentNode = getView();
		if (commentNode != null) {
			final TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(commentNode);

			// if Base_Element is deleted, the Comment is deleted as well
			if (getUMLElement() == null) {
				executeAppliedStereotypeCommentDeletion(domain, commentNode);
			}

			// If no more Compartment, delete the Comment
			if (getAppliedStereotypeCompartmentNumber(commentNode) == 0) {
				executeAppliedStereotypeCommentDeletion(domain, commentNode);
			}

		}

	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.common.editpolicies.AbstractAppliedStereotypeDisplayEditPolicy#refreshDisplay()
	 *
	 */
	@Override
	public void refreshDisplay() {
		refreshStereotypeDisplay();

	}
}
