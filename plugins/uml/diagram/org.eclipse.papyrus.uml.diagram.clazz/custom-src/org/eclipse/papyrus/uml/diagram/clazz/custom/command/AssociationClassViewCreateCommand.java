/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.clazz.custom.command;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.clazz.providers.UMLViewProvider;

/**
 * Custom class to create the associationClass node.
 *
 */
public class AssociationClassViewCreateCommand extends AbstractCustomCommand {

	/** The container view. */
	private View containerView;

	/** The create connection view and element request. */
	private CreateConnectionViewAndElementRequest createConnectionViewAndElementRequest;

	/** The location. */
	private Point location;

	/** The preference hint. */
	private PreferencesHint preferenceHint;

	/** The result. */
	public EObjectAdapter result;

	/**
	 * constructor.
	 *
	 * @param createConnectionViewAndElementRequest
	 *            the request that is used to obtained the associationclass
	 * @param domain
	 *            the current edit domain
	 * @param container
	 *            the container view
	 * @param viewer
	 *            the viewer
	 * @param preferencesHint
	 *            the preference hint of the diagram
	 * @param point
	 *            the location of the future association node
	 */
	public AssociationClassViewCreateCommand(CreateConnectionViewAndElementRequest createConnectionViewAndElementRequest, TransactionalEditingDomain domain, View container, EditPartViewer viewer, PreferencesHint preferencesHint, Point point) {
		super(domain, "AssociationClassViewCreateCommand", null); //$NON-NLS-1$
		this.containerView = container;
		this.viewer = viewer;
		this.preferenceHint = preferencesHint;
		this.createConnectionViewAndElementRequest = createConnectionViewAndElementRequest;
		this.location = point;
	}

	/**
	 *
	 * {@inheritDoc}
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		// / get the factory of the viewer
		// AssociationClassViewFactory factory = new
		// AssociationClassViewFactory();
		// creation of the element
		CreateElementRequestAdapter requestAdapter = createConnectionViewAndElementRequest.getConnectionViewAndElementDescriptor().getCreateElementRequestAdapter();
		CreateRelationshipRequest createElementRequest = (CreateRelationshipRequest) requestAdapter.getAdapter(CreateRelationshipRequest.class);
		UMLViewProvider viewProvider = new UMLViewProvider();
		setNode(viewProvider.createAssociationClass_Shape(createElementRequest.getNewElement(), this.containerView, -1, true, preferenceHint));
		// this.node = factory.createView(new
		// SemanticAdapter(createElementRequest.getNewElement()),
		// this.containerView, ((IHintedType)
		// UMLElementTypes.AssociationClass_2013).getSemanticHint(), -1,
		// true, preferenceHint);
		// put to the good position
		if (getNode() instanceof Node) {
			((Bounds) ((Node) getNode()).getLayoutConstraint()).setX(location.x);
			((Bounds) ((Node) getNode()).getLayoutConstraint()).setY(location.y);
		}
		return CommandResult.newOKCommandResult(getNode());
	}

}
