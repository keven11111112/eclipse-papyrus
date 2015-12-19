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

package org.eclipse.papyrus.uml.diagram.clazz.test.canonical;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.AssociationEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.providers.UMLElementTypes;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.StructuredClassifier;
import org.junit.Assert;
import org.junit.Test;

public class TestClassDiagramAssociationLinkSemantic extends AbstractPapyrusTestCase {

	@Test
	public void testAssociationLink() {
		IGraphicalEditPart source = createChild(UMLElementTypes.Class_2008, getDiagramEditPart(), 0);
		IGraphicalEditPart target = createChild(UMLElementTypes.Class_2008, getDiagramEditPart(), 1);
		IGraphicalEditPart association = createLink(UMLElementTypes.Association_4001, source, target);
		assertNotNull(association);
		// check source semantic
		EObject sourceSemantic = source.resolveSemanticElement();
		assertTrue("Source should be StructuredClassifier.", sourceSemantic instanceof StructuredClassifier);
		List<Property> sourceProperties = ((StructuredClassifier) sourceSemantic).getOwnedAttributes();
		assertEquals("Source owned attributes", 1, sourceProperties.size());
		Property sourceProperty = sourceProperties.get(0);
		assertEquals("Source property type", target.resolveSemanticElement(), sourceProperty.getType());
		// check target semantic
		EObject targetSemantic = target.resolveSemanticElement();
		assertTrue("Target should be StructuredClassifier.", targetSemantic instanceof StructuredClassifier);
		assertEquals("Target owned attributes", 0, ((StructuredClassifier) targetSemantic).getOwnedAttributes().size());
		// check association semantic
		EObject associationSemantic = association.resolveSemanticElement();
		assertTrue("Created link is not association.", associationSemantic instanceof Association);
		List<Property> associationProperties = ((Association) associationSemantic).getOwnedEnds();
		assertEquals("Association owned attributes", 1, associationProperties.size());
		Property associationProperty = associationProperties.get(0);
		assertEquals("Association property owner", associationSemantic, associationProperty.eContainer());
		assertEquals("Association property type", sourceSemantic, associationProperty.getType());
	}

	private IGraphicalEditPart createChild(IElementType childType, IGraphicalEditPart container, int num) {
		final CreateViewRequest requestcreation = CreateViewRequestFactory.getCreateShapeRequest(childType, container.getDiagramPreferencesHint());
		requestcreation.setSize(new Dimension(1, 1));
		requestcreation.setLocation(new Point(10, 10));
		Command cmd = container.getCommand(requestcreation);
		executeOnUIThread(cmd);
		assertEquals("Probably, child was not created.", num + 1, getDiagramEditPart().getChildren().size());
		return (IGraphicalEditPart) getDiagramEditPart().getChildren().get(num);
	}

	private IGraphicalEditPart createLink(IElementType type, EditPart source, EditPart target) {
		Command endCommand = target.getCommand(createConnectionViewRequest(type, source, target));
		Assert.assertNotNull(endCommand);
		Assert.assertTrue(endCommand.canExecute());
		executeOnUIThread(endCommand);
		Assert.assertEquals(1, getDiagramEditPart().getConnections().size());
		IGraphicalEditPart association = (IGraphicalEditPart) getDiagramEditPart().getConnections().get(0);
		Assert.assertTrue(association instanceof AssociationEditPart);
		return association;
	}

	private CreateConnectionViewRequest createConnectionViewRequest(IElementType type, EditPart source, EditPart target) {
		CreateConnectionViewRequest connectionRequest = CreateViewRequestFactory.getCreateConnectionRequest(type, ((IGraphicalEditPart) getDiagramEditPart()).getDiagramPreferencesHint());
		connectionRequest.setSourceEditPart(null);
		connectionRequest.setTargetEditPart(source);
		connectionRequest.setType(RequestConstants.REQ_CONNECTION_START);
		source.getCommand(connectionRequest);
		connectionRequest.setSourceEditPart(source);
		connectionRequest.setTargetEditPart(target);
		connectionRequest.setType(RequestConstants.REQ_CONNECTION_END);
		return connectionRequest;
	}
}
