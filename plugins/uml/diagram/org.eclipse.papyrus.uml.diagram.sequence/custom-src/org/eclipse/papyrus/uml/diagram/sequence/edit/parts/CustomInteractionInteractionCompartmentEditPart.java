/*****************************************************************************
 * Copyright (c) 2010 CEA
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Soyatec - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.edit.parts;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.emf.transaction.TransactionalCommandStack;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.uml.diagram.sequence.command.CustomZOrderCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.CombinedFragmentCreationEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.semantic.CustomInteractionInteractionCompartmentItemSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.util.HighlightUtil;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Lifeline;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class CustomInteractionInteractionCompartmentEditPart extends InteractionInteractionCompartmentEditPart {

	/**
	 * Constructor.
	 *
	 * @param view
	 */
	public CustomInteractionInteractionCompartmentEditPart(View view) {
		super(view);
	}

	/**
	 * @Override
	 */
	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomInteractionInteractionCompartmentItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CombinedFragmentCreationEditPolicy());
		removeEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE);
	}

	/**
	 * Generated not for send to back CombinedFragment and InteractionUse {@inheritDoc}
	 */
	// TODO Use transparency instead of send to back method
	@Override
	protected void addChildVisual(EditPart childEditPart, int index) {
		if (childEditPart instanceof CombinedFragmentEditPart || childEditPart instanceof ConsiderIgnoreFragmentEditPart || childEditPart instanceof InteractionUseEditPart) {
			index = 0;
		}
		super.addChildVisual(childEditPart, index);
	}

	@Override
	protected void handleNotificationEvent(Notification notification) {
		super.handleNotificationEvent(notification);
		// Bring lifelines forward after delete+undo (https://bugs.eclipse.org/bugs/show_bug.cgi?id=455071)
		if (notification.getEventType() == Notification.ADD &&
				notification.getNewValue() instanceof Shape) {
			final Shape shape = (Shape) notification.getNewValue();
			if (shape.getElement() instanceof Lifeline) {
				final TransactionalEditingDomain domain = getEditingDomain();

				Display.getDefault().asyncExec(new Runnable() {
					@Override
					public void run() {
						View containerView = ViewUtil.getContainerView(shape);
						CustomZOrderCommand cmd = new CustomZOrderCommand(domain, shape, containerView.getChildren().size() - 1);

						CommandStack commandStack = domain.getCommandStack();
						if (commandStack instanceof TransactionalCommandStack) {
							TransactionalCommandStack stack = (TransactionalCommandStack) commandStack;
							Map<Object, Object> options = new HashMap<Object, Object>();
							options.put(Transaction.OPTION_NO_NOTIFICATIONS, Boolean.TRUE);
							options.put(Transaction.OPTION_NO_TRIGGERS, Boolean.TRUE);
							try {
								stack.execute(new GMFtoEMFCommandWrapper(cmd), options);
							}
							catch (Exception e) {
								throw new RuntimeException(e);
							}
						}
					}
				});
			}
		}
    }

    /*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#
	 * showTargetFeedback(org.eclipse.gef.Request)
	 */
	@Override
	public void showTargetFeedback(Request request) {
		if (!isEditModeEnabled() || !isActive()) {
			return;
		}
		// Avoid default drop feedback by setting background, just highlight it
		// with bold border.
		EditPolicyIterator i = getEditPolicyIterator();
		while (i.hasNext()) {
			EditPolicy next = i.next();
			if (REQ_CREATE.equals(request.getType()) && next.getClass().getName().equals("org.eclipse.papyrus.infra.gmfdiag.dnd.policy.CustomizableDropEditPolicy")) {
				HighlightUtil.highlight(this);
			} else {
				next.showTargetFeedback(request);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#
	 * eraseTargetFeedback(org.eclipse.gef.Request)
	 */
	@Override
	public void eraseTargetFeedback(Request request) {
		super.eraseTargetFeedback(request);
		HighlightUtil.unhighlight(this);
	}
}
