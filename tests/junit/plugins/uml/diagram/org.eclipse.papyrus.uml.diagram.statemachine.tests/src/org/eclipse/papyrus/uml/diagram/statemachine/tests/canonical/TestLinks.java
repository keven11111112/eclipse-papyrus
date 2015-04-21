/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
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

package org.eclipse.papyrus.uml.diagram.statemachine.tests.canonical;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.uml.diagram.common.service.AspectUnspecifiedTypeConnectionTool;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.CommentEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.ConstraintConstrainedElementEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.ConstraintEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.ContextLinkEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.FinalStateEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.PseudostateChoiceEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.PseudostateDeepHistoryEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.PseudostateEntryPointEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.PseudostateExitPointEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.PseudostateJunctionEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.PseudostateShallowHistoryEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.PseudostateTerminateEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.StateEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.TransitionEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.providers.UMLElementTypes;
import org.junit.Assert;
import org.junit.Test;


public class TestLinks extends BaseTestCase {

	protected Command createLinkCommand(IGraphicalEditPart start, IGraphicalEditPart end, IElementType type) {
		List<IElementType> types = new LinkedList<IElementType>();
		types.add(type);

		AspectUnspecifiedTypeConnectionTool.CreateAspectUnspecifiedTypeConnectionRequest req =
				new AspectUnspecifiedTypeConnectionTool(types).
				new CreateAspectUnspecifiedTypeConnectionRequest(types, false, getDiagramEditPart().getDiagramPreferencesHint());

		req.setSourceEditPart(start);
		req.setType((RequestConstants.REQ_CONNECTION_START));

		Command startCommand = start.getCommand(req);
		Assert.assertNotNull(startCommand);

		req.setStartCommand(startCommand);

		req.setTargetEditPart(end);
		req.setType(RequestConstants.REQ_CONNECTION_END);

		Command endCommand = end.getCommand(req);
		Assert.assertNotNull(endCommand);
		Assert.assertTrue(endCommand.canExecute());
		return endCommand;
	}

	protected void ckeckCannotStartConnectionCommand(IElementType type, int... editPartIDs) {
		List<IElementType> types = Arrays.asList(type);

		for (int vid: editPartIDs) {
			IGraphicalEditPart ep = createChild(vid, getRegionCompartmentEditPart());
			
			AspectUnspecifiedTypeConnectionTool.CreateAspectUnspecifiedTypeConnectionRequest req =
					new AspectUnspecifiedTypeConnectionTool(types).
					new CreateAspectUnspecifiedTypeConnectionRequest(types, false, getDiagramEditPart().getDiagramPreferencesHint());

			req.setSourceEditPart(ep);
			req.setType((RequestConstants.REQ_CONNECTION_START));

			Command startCommand = ep.getCommand(req);
			Assert.assertNull("Element vid=" + vid + " should not provide ability of creation start connection commnad for " + type, startCommand);
		}
	}

	@Test
	public void testConstainedElementLink() {
		IGraphicalEditPart constraint = createChild(ConstraintEditPart.VISUAL_ID, getRegionCompartmentEditPart());
		IGraphicalEditPart state = createChild(StateEditPart.VISUAL_ID, getRegionCompartmentEditPart());

		Command endCommand = createLinkCommand(constraint, state, UMLElementTypes.ConstraintConstrainedElement_670);

		Assert.assertNotNull(endCommand);
		Assert.assertTrue(endCommand.canExecute());

		executeOnUIThread(endCommand);
		Assert.assertEquals(1, getDiagramEditPart().getConnections().size());
		IGraphicalEditPart constraintConnection = (IGraphicalEditPart) getDiagramEditPart().getConnections().get(0);
		Assert.assertTrue(constraintConnection instanceof ConstraintConstrainedElementEditPart);
	}

	@Test
	public void testContextElementLink() {
		IGraphicalEditPart constraint = createChild(ConstraintEditPart.VISUAL_ID, getRegionCompartmentEditPart());
		IGraphicalEditPart state = createChild(StateEditPart.VISUAL_ID, getRegionCompartmentEditPart());

		Command endCommand = createLinkCommand(constraint, state, UMLElementTypes.ConstraintContext_8500);
		Assert.assertNotNull(endCommand);
		Assert.assertTrue(endCommand.canExecute());

		executeOnUIThread(endCommand);
		Assert.assertEquals(1, getDiagramEditPart().getConnections().size());
		IGraphicalEditPart contextConnection = (IGraphicalEditPart) getDiagramEditPart().getConnections().get(0);
		Assert.assertTrue(contextConnection instanceof ContextLinkEditPart);
	}
	

	@Test
	public void testTransitionLink() {
		IGraphicalEditPart stateEP = createChild(StateEditPart.VISUAL_ID, getRegionCompartmentEditPart());
		IGraphicalEditPart pseudostateEP = createChild(PseudostateChoiceEditPart.VISUAL_ID, getRegionCompartmentEditPart());

		Command endCommand = createLinkCommand(stateEP, pseudostateEP, UMLElementTypes.Transition_7000);
		Assert.assertNotNull(endCommand);
		Assert.assertTrue(endCommand.canExecute());

		executeOnUIThread(endCommand);
		Assert.assertEquals(1, getDiagramEditPart().getConnections().size());
		IGraphicalEditPart transitionConnection = (IGraphicalEditPart) getDiagramEditPart().getConnections().get(0);
		Assert.assertTrue(transitionConnection instanceof TransitionEditPart);
	}
	
	@Test
	public void testTransitionLinkWithSameSourceAndTarget() {
		IGraphicalEditPart stateEP = createChild(StateEditPart.VISUAL_ID, getRegionCompartmentEditPart());

		Command endCommand = createLinkCommand(stateEP, stateEP, UMLElementTypes.Transition_7000);
		Assert.assertNotNull(endCommand);
		Assert.assertTrue(endCommand.canExecute());

		executeOnUIThread(endCommand);
		Assert.assertEquals(1, getDiagramEditPart().getConnections().size());
		IGraphicalEditPart transitionConnection = (IGraphicalEditPart) getDiagramEditPart().getConnections().get(0);
		Assert.assertTrue(transitionConnection instanceof TransitionEditPart);
	}

	@Test
	public void testToCreateCommentLink() {
		IGraphicalEditPart comment = createChild(CommentEditPart.VISUAL_ID, getRegionCompartmentEditPart());
		IGraphicalEditPart state = createChild(StateEditPart.VISUAL_ID, getRegionCompartmentEditPart());

		Command endCommand = createLinkCommand(comment, state, UMLElementTypes.CommentAnnotatedElement_667);

		executeOnUIThread(endCommand);
		Assert.assertEquals(1, getDiagramEditPart().getConnections().size());
		IGraphicalEditPart commentConnection = (IGraphicalEditPart) getDiagramEditPart().getConnections().get(0);
		Assert.assertTrue(commentConnection instanceof CommentAnnotatedElementEditPart);
	}

	/**
	 * test show comment link can't start from some nodes
	 */
	@Test
	public void testCommentLinkCannotBeStarted() {
		IElementType link = UMLElementTypes.CommentAnnotatedElement_667;
		ckeckCannotStartConnectionCommand(link,
				PseudostateChoiceEditPart.VISUAL_ID,
				PseudostateEntryPointEditPart.VISUAL_ID,
				FinalStateEditPart.VISUAL_ID,
				ConstraintEditPart.VISUAL_ID,
				StateEditPart.VISUAL_ID);
	}

	/**
	 * test show constraint context link can't start from some nodes
	 * it is right behavior
	 */
	@Test
	public void testConstraintContextLinkCannotBeStarted() {
		IElementType link = UMLElementTypes.ConstraintContext_8500;
		ckeckCannotStartConnectionCommand(link,
				PseudostateShallowHistoryEditPart.VISUAL_ID,
				CommentEditPart.VISUAL_ID,
				PseudostateDeepHistoryEditPart.VISUAL_ID,
				StateEditPart.VISUAL_ID);
	}

	/**
	 * test show constraint constrained element link can't start from some nodes
	 * it is right behavior
	 */
	@Test
	public void testConstraintConstrainedElementLinkCannotBeStarted() {
		IElementType link = UMLElementTypes.ConstraintConstrainedElement_670;
		ckeckCannotStartConnectionCommand(link,
				PseudostateExitPointEditPart.VISUAL_ID,
				CommentEditPart.VISUAL_ID,
				PseudostateTerminateEditPart.VISUAL_ID,
				StateEditPart.VISUAL_ID);
	}

	/**
	 * test show transition link can't start from some nodes
	 * it is right behavior
	 */
	@Test
	public void testTransitionLinkCannotBeStarted() {
		IElementType link = UMLElementTypes.Transition_7000;
		ckeckCannotStartConnectionCommand( link,
				CommentEditPart.VISUAL_ID,
				ConstraintEditPart.VISUAL_ID);
	}

	protected ReconnectRequest getReconnectSource(ConnectionEditPart connection, IGraphicalEditPart newSource) {
		return getReconnectRequest(connection, newSource, RequestConstants.REQ_RECONNECT_SOURCE);
	}

	protected ReconnectRequest getReconnectTarget(ConnectionEditPart connection, IGraphicalEditPart newTarget) {
		return getReconnectRequest(connection, newTarget, RequestConstants.REQ_RECONNECT_TARGET);
	}

	private ReconnectRequest getReconnectRequest(ConnectionEditPart connection, IGraphicalEditPart newEnd, String type) {
		ReconnectRequest reconnect = new ReconnectRequest();
		reconnect.setTargetEditPart(newEnd);
		reconnect.setConnectionEditPart((ConnectionEditPart) connection);
		reconnect.setType(type);
		return reconnect;
	}

	protected void doReconnect(ReconnectRequest req) {
		Command reorientCommand = req.getTarget().getCommand(req);
		Assert.assertNotNull(reorientCommand);
		Assert.assertTrue(reorientCommand.canExecute());

		executeOnUIThread(reorientCommand);
	}

	@Test
	public void testTransitionLinkReorient() {
		IGraphicalEditPart stateEP = createChild(StateEditPart.VISUAL_ID, getRegionCompartmentEditPart());
		IGraphicalEditPart pseustateEP = createChild(PseudostateJunctionEditPart.VISUAL_ID, getRegionCompartmentEditPart());

		Command endCommand = createLinkCommand(pseustateEP, stateEP, UMLElementTypes.Transition_7000);
		Assert.assertNotNull(endCommand);
		Assert.assertTrue(endCommand.canExecute());

		executeOnUIThread(endCommand);
		Assert.assertEquals(1, getDiagramEditPart().getConnections().size());
		IGraphicalEditPart transitionConnection = (IGraphicalEditPart) getDiagramEditPart().getConnections().get(0);
		Assert.assertTrue(transitionConnection instanceof TransitionEditPart);

		TransitionEditPart transitionEP = (TransitionEditPart)transitionConnection;

		ReconnectRequest reconnectSourceReq = getReconnectSource(transitionEP, stateEP);
		doReconnect(reconnectSourceReq);
		Assert.assertEquals(stateEP, transitionEP.getSource());

		ReconnectRequest reconnectTargetReq = getReconnectTarget(transitionEP, pseustateEP);
		doReconnect(reconnectTargetReq);
		Assert.assertEquals(stateEP, transitionEP.getSource());
	}

	@Test
	public void testToReorientCommentLink() {
		IGraphicalEditPart commentEP1 = createChild(CommentEditPart.VISUAL_ID, getRegionCompartmentEditPart());
		IGraphicalEditPart pseudostateEP = createChild(PseudostateDeepHistoryEditPart.VISUAL_ID, getRegionCompartmentEditPart());

		IGraphicalEditPart commentEP2 = null;
		createChild(CommentEditPart.VISUAL_ID, getRegionCompartmentEditPart());
		for (Object child: getRegionCompartmentEditPart().getChildren()) {
			if (child instanceof CommentEditPart && false == child.equals(commentEP1)) {
				commentEP2 =(IGraphicalEditPart) child;
				break;
			}
		}
		Assert.assertNotNull(commentEP2);

		Command endCommand = createLinkCommand(commentEP1, pseudostateEP, UMLElementTypes.CommentAnnotatedElement_667);

		executeOnUIThread(endCommand);
		Assert.assertEquals(1, getDiagramEditPart().getConnections().size());
		IGraphicalEditPart commentConnection = (IGraphicalEditPart) getDiagramEditPart().getConnections().get(0);
		Assert.assertTrue(commentConnection instanceof CommentAnnotatedElementEditPart);

		CommentAnnotatedElementEditPart commentAnnotatedElementEP = (CommentAnnotatedElementEditPart)commentConnection;

		ReconnectRequest reconnectSourceReq = getReconnectSource(commentAnnotatedElementEP, commentEP2);
		doReconnect(reconnectSourceReq);
		Assert.assertEquals(commentEP2, commentAnnotatedElementEP.getSource());

		ReconnectRequest badReconnectSourceReq = getReconnectSource(commentAnnotatedElementEP, pseudostateEP);
		Command badReconnectCommand = pseudostateEP.getCommand(badReconnectSourceReq);
		Assert.assertNotNull(badReconnectCommand );
		Assert.assertFalse(badReconnectCommand.canExecute());

		ReconnectRequest reconnectTarget = getReconnectTarget(commentAnnotatedElementEP, commentEP1);
		doReconnect(reconnectTarget);
		Assert.assertEquals(commentEP1, commentAnnotatedElementEP.getTarget());
	}

	@Test
	public void testToReorientConstraintConstrainedElementLink() {
		IGraphicalEditPart constraintEP1 = createChild(ConstraintEditPart.VISUAL_ID, getRegionCompartmentEditPart());
		IGraphicalEditPart finalStateEP = createChild(FinalStateEditPart.VISUAL_ID, getRegionCompartmentEditPart());

		IGraphicalEditPart constraintEP2 = null;
		createChild(ConstraintEditPart.VISUAL_ID, getRegionCompartmentEditPart());
		for (Object child: getRegionCompartmentEditPart().getChildren()) {
			if (child instanceof ConstraintEditPart && false == child.equals(constraintEP1)) {
				constraintEP2 =(IGraphicalEditPart) child;
				break;
			}
		}
		Assert.assertNotNull(constraintEP2);

		Command endCommand = createLinkCommand(constraintEP1, finalStateEP, UMLElementTypes.ConstraintConstrainedElement_670);

		executeOnUIThread(endCommand);
		Assert.assertEquals(1, getDiagramEditPart().getConnections().size());
		IGraphicalEditPart constraintConnection = (IGraphicalEditPart) getDiagramEditPart().getConnections().get(0);
		Assert.assertTrue(constraintConnection instanceof ConstraintConstrainedElementEditPart);

		ConstraintConstrainedElementEditPart constraintConstrainedElementEP = (ConstraintConstrainedElementEditPart)constraintConnection;

		ReconnectRequest reconnectSourceReq = getReconnectSource(constraintConstrainedElementEP, constraintEP2);
		doReconnect(reconnectSourceReq);

		Assert.assertEquals(constraintEP2, constraintConstrainedElementEP.getSource());

		ReconnectRequest badReconnectSourceReq = getReconnectSource(constraintConstrainedElementEP, finalStateEP);
		Command badReconnectCommand = finalStateEP.getCommand(badReconnectSourceReq);
		Assert.assertNotNull(badReconnectCommand );
		Assert.assertFalse(badReconnectCommand.canExecute());

		ReconnectRequest reconnectTarget = getReconnectTarget(constraintConstrainedElementEP, constraintEP1);
		doReconnect(reconnectTarget);

		Assert.assertEquals(constraintEP1, constraintConstrainedElementEP.getTarget());
	}

	@Test
	public void testToReorientConstraintContextLink() {
		IGraphicalEditPart constraintEP1 = createChild(ConstraintEditPart.VISUAL_ID, getRegionCompartmentEditPart());
		IGraphicalEditPart stateEP = createChild(StateEditPart.VISUAL_ID, getRegionCompartmentEditPart());

		IGraphicalEditPart constraintEP2 = null;
		createChild(ConstraintEditPart.VISUAL_ID, getRegionCompartmentEditPart());
		for (Object child: getRegionCompartmentEditPart().getChildren()) {
			if (child instanceof ConstraintEditPart && false == child.equals(constraintEP1)) {
				constraintEP2 =(IGraphicalEditPart) child;
				break;
			}
		}
		Assert.assertNotNull(constraintEP2);

		Command endCommand = createLinkCommand(constraintEP1, stateEP, UMLElementTypes.ConstraintContext_8500);

		executeOnUIThread(endCommand);
		Assert.assertEquals(1, getDiagramEditPart().getConnections().size());
		IGraphicalEditPart constraintContextConnection = (IGraphicalEditPart) getDiagramEditPart().getConnections().get(0);
		Assert.assertTrue(constraintContextConnection instanceof ContextLinkEditPart);

		ContextLinkEditPart constraintConstextEP = (ContextLinkEditPart)constraintContextConnection;

		ReconnectRequest reconnectSourceReq = getReconnectSource(constraintConstextEP, constraintEP2);
		doReconnect(reconnectSourceReq);

		Assert.assertEquals(constraintEP2, constraintConstextEP.getSource());

		ReconnectRequest badReconnectSourceReq = getReconnectSource(constraintConstextEP, stateEP);
		Command badReconnectCommand = stateEP.getCommand(badReconnectSourceReq);
		Assert.assertNotNull(badReconnectCommand );
		Assert.assertFalse(badReconnectCommand.canExecute());

		ReconnectRequest badReconnectTargetReq = getReconnectTarget(constraintConstextEP, constraintEP1);
		Command badReconnectTargetCommand = stateEP.getCommand(badReconnectTargetReq);
		Assert.assertNotNull(badReconnectTargetCommand);
		Assert.assertFalse(badReconnectTargetCommand.canExecute());

		Assert.assertEquals(stateEP, constraintConstextEP.getTarget());
	}
}
