/*****************************************************************************
 * Copyright (c) 2013 CEA
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
package org.eclipse.papyrus.uml.diagram.sequence.tests.bug.pro20130916;

import static org.junit.Assert.assertNotNull;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.AbstractMessageEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.ActionExecutionSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageAsyncEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageCreateEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageDeleteEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageFoundEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageLostEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageReplyEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageSyncEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.junit.Test;


/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class MessageStereotypesTest extends BaseStereotypesTest {

	protected void doTest(AbstractMessageEditPart message) {
		doTestDisplayStereotypeComment(message);
	}

	@Test
	public void testSynchronousMessage() {
		LifelineEditPart lifeline1 = (LifelineEditPart)createNode(UMLElementTypes.Lifeline_Shape, getRootEditPart(), new Point(100, 100), null);
		assertNotNull(lifeline1);
		ActionExecutionSpecificationEditPart source = (ActionExecutionSpecificationEditPart)createNode(UMLElementTypes.ActionExecutionSpecification_Shape, lifeline1, getAbsoluteBounds(lifeline1).getTop().translate(0, 50), null);
		assertNotNull(source);
		LifelineEditPart lifeline2 = (LifelineEditPart)createNode(UMLElementTypes.Lifeline_Shape, getRootEditPart(), new Point(300, 100), null);
		assertNotNull(lifeline2);
		ActionExecutionSpecificationEditPart target = (ActionExecutionSpecificationEditPart)createNode(UMLElementTypes.ActionExecutionSpecification_Shape, lifeline2, getAbsoluteBounds(lifeline2).getTop().translate(0, 50), null);
		assertNotNull(target);
		MessageSyncEditPart message = (MessageSyncEditPart)createLink(UMLElementTypes.Message_SynchEdge, lifeline1.getViewer(), getAbsoluteCenter(source), getAbsoluteCenter(target));
		assertNotNull(message);
		doTest(message);
	}

	@Test
	public void testAsynchronousMessage() {
		LifelineEditPart source = (LifelineEditPart)createNode(UMLElementTypes.Lifeline_Shape, getRootEditPart(), new Point(100, 100), null);
		assertNotNull(source);
		LifelineEditPart target = (LifelineEditPart)createNode(UMLElementTypes.Lifeline_Shape, getRootEditPart(), new Point(300, 100), null);
		assertNotNull(target);
		MessageAsyncEditPart message = (MessageAsyncEditPart)createLink(UMLElementTypes.Message_AsynchEdge, source.getViewer(), getAbsoluteBounds(source).getTop().translate(0, 50), getAbsoluteBounds(target).getTop().translate(0, 50));
		assertNotNull(message);
		doTest(message);
	}

	@Test
	public void testCreateMessage() {
		LifelineEditPart source = (LifelineEditPart)createNode(UMLElementTypes.Lifeline_Shape, getRootEditPart(), new Point(100, 100), null);
		assertNotNull(source);
		LifelineEditPart target = (LifelineEditPart)createNode(UMLElementTypes.Lifeline_Shape, getRootEditPart(), new Point(300, 100), null);
		assertNotNull(target);
		MessageCreateEditPart message = (MessageCreateEditPart)createLink(UMLElementTypes.Message_CreateEdge, source.getViewer(), getAbsoluteBounds(source).getTop().translate(0, 50), getAbsoluteBounds(target).getTop().translate(0, 50));
		assertNotNull(message);
		doTest(message);
	}

	@Test
	public void testReplyMessage() {
		LifelineEditPart lifeline1 = (LifelineEditPart)createNode(UMLElementTypes.Lifeline_Shape, getRootEditPart(), new Point(300, 100), null);
		assertNotNull(lifeline1);
		ActionExecutionSpecificationEditPart source = (ActionExecutionSpecificationEditPart)createNode(UMLElementTypes.ActionExecutionSpecification_Shape, lifeline1, getAbsoluteBounds(lifeline1).getTop().translate(0, 50), null);
		assertNotNull(source);
		LifelineEditPart lifeline2 = (LifelineEditPart)createNode(UMLElementTypes.Lifeline_Shape, getRootEditPart(), new Point(100, 100), null);
		assertNotNull(lifeline2);
		ActionExecutionSpecificationEditPart target = (ActionExecutionSpecificationEditPart)createNode(UMLElementTypes.ActionExecutionSpecification_Shape, lifeline2, getAbsoluteBounds(lifeline1).getTop().translate(0, 150), null);
		assertNotNull(target);
		MessageReplyEditPart message = (MessageReplyEditPart)createLink(UMLElementTypes.Message_ReplyEdge, source.getViewer(), getAbsoluteCenter(source), getAbsoluteCenter(target));
		assertNotNull(message);
		doTest(message);
	}

	@Test
	public void testFoundMessage() {
		LifelineEditPart target = (LifelineEditPart)createNode(UMLElementTypes.Lifeline_Shape, getRootEditPart(), new Point(300, 100), null);
		assertNotNull(target);
		Point targetLocation = getAbsoluteBounds(target).getTop().translate(0, 50);
		Point sourceLocation = targetLocation.getTranslated(-100, 0);
		MessageFoundEditPart message = (MessageFoundEditPart)createLink(UMLElementTypes.Message_FoundEdge, target.getViewer(), sourceLocation, targetLocation);
		assertNotNull(message);
		doTest(message);
	}

	@Test
	public void testLostMessage() {
		LifelineEditPart source = (LifelineEditPart)createNode(UMLElementTypes.Lifeline_Shape, getRootEditPart(), new Point(300, 100), null);
		assertNotNull(source);
		Point sourceLocation = getAbsoluteBounds(source).getTop().translate(0, 50);
		Point targetLocation = sourceLocation.getTranslated(100, 0);
		MessageLostEditPart message = (MessageLostEditPart)createLink(UMLElementTypes.Message_LostEdge, source.getViewer(), sourceLocation, targetLocation);
		assertNotNull(message);
		doTest(message);
	}

	@Test
	public void testDeleteMessage() {
		LifelineEditPart source = (LifelineEditPart)createNode(UMLElementTypes.Lifeline_Shape, getRootEditPart(), new Point(100, 100), null);
		assertNotNull(source);
		LifelineEditPart target = (LifelineEditPart)createNode(UMLElementTypes.Lifeline_Shape, getRootEditPart(), new Point(300, 100), null);
		assertNotNull(target);
		MessageDeleteEditPart message = (MessageDeleteEditPart)createLink(UMLElementTypes.Message_DeleteEdge, source.getViewer(), getAbsoluteBounds(source).getTop().translate(0, 50), getAbsoluteBounds(target).getTop().translate(0, 50));
		assertNotNull(message);
		doTest(message);
	}
}
