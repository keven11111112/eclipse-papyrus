/*****************************************************************************
 * Copyright (c) 2017 CEA LIST, ALL4TEC and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Mickaël ADAM (ALL4TEC) mickael.adam@all4tec.net - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.tools;

import java.util.List;

import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest.ConnectionViewDescriptor;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.AnnotatedLinkEndEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.AnnotatedLinkStartEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;

/**
 * Tool to create Annotated Link in sequence diagram.
 */
public class AnnotatedLinkCreationTool extends SequenceSpecificConnectionTool {

	/**
	 * Constructor.
	 *
	 * @param elementTypes
	 */
	public AnnotatedLinkCreationTool(final List<IElementType> elementTypes) {
		super(elementTypes);
		setUnloadWhenFinished(true);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.service.palette.AspectUnspecifiedTypeConnectionTool#createTargetRequest()
	 */
	@Override
	protected CreateConnectionRequest createTargetRequest() {
		IHintedType type = (IHintedType) UMLElementTypes.Comment_AnnotatedElementEdge;
		return new CreateConnectionViewRequest(new ConnectionViewDescriptor(type, type.getSemanticHint(), getPreferencesHint()));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.tools.AbstractConnectionCreationTool#getCommandName()
	 */
	@Override
	protected String getCommandName() {
		if (isInState(STATE_CONNECTION_STARTED | STATE_ACCESSIBLE_DRAG_IN_PROGRESS)) {
			return AnnotatedLinkEndEditPolicy.REQ_ANNOTATED_LINK_END;
		} else {
			return AnnotatedLinkStartEditPolicy.REQ_ANNOTATED_LINK_START;
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.service.palette.AspectUnspecifiedTypeConnectionTool#handleCreateConnection()
	 */
	@Override
	protected boolean handleCreateConnection() {
		boolean handled = super.handleCreateConnection();
		// Make sure to erase source feedback whatever the connection created or not.
		setAvoidDeactivation(false);
		eraseSourceFeedback();
		deactivate();
		return handled;
	}
}