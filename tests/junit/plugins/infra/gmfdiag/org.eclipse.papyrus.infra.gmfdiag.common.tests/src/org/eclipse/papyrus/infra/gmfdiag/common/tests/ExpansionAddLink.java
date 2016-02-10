/*****************************************************************************
 * Copyright (c) 2015, 2016 CEA LIST, Christian W. Damus, and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   Christian W. Damus - bug 485220
 *   
 *****************************************************************************/

package org.eclipse.papyrus.infra.gmfdiag.common.tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.sashwindows.di.service.IPageManager;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.infra.gmfdiag.common.SynchronizableGmfDiagramEditor;
import org.eclipse.papyrus.infra.gmfdiag.common.expansion.ChildrenListRepresentation;
import org.eclipse.papyrus.infra.gmfdiag.common.expansion.DiagramExpansionSingleton;
import org.eclipse.papyrus.infra.gmfdiag.common.expansion.DiagramExpansionsRegistry;
import org.eclipse.papyrus.infra.gmfdiag.common.model.NotationModel;
import org.eclipse.papyrus.infra.types.core.registries.ElementTypeConfigurationTypeRegistry;
import org.eclipse.papyrus.infra.ui.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.junit.utils.tests.AbstractEditorTest;
import org.junit.Assert;
import org.junit.Test;
import org.osgi.framework.Bundle;

/**
 * this Test is used to test if it is possible to add compartment
 * see #Test T005-Add link
 * 
 *
 */
public class ExpansionAddLink extends AbstractEditorTest {


	public void openDiagram(IMultiDiagramEditor editor, final String name) {

		try {
			ModelSet modelSet = ServiceUtils.getInstance().getModelSet(editor.getServicesRegistry());
			NotationModel notation = (NotationModel) modelSet.getModel(NotationModel.MODEL_ID);
			Diagram diagram = notation.getDiagram(name);
			ServiceUtils.getInstance().getService(IPageManager.class, editor.getServicesRegistry()).openPage(diagram);
			flushDisplayEvents();
		} catch (Exception e) {
			throw new IllegalStateException("Cannot initialize test", e);
		}

	}

	protected static final String CLASS_DIAGRAM_TYPE = "Class Diagram";
	protected static final String DEPENDENCY_HINT = "Dependency_Link";
	protected static final String NEW_DEPENDENCY_ELEMENTTYPE_ID = "org.eclipse.papyrus.uml.diagram.testexpansion.Dependency_Link";

	@Test
	public void load_DiagramExpansion() {
		// loading
		DiagramExpansionsRegistry diagramExpansionsRegistry = loadXMIExpansionModel("AddLink.xmi");
		Assert.assertEquals("Size ot the registry must be equals to 1", 1, diagramExpansionsRegistry.getDiagramExpansions().size());
		Assert.assertEquals("Size ot the map childreen must be equals to 1", 1, diagramExpansionsRegistry.mapChildreen.size());

		// test the data structure that is interpreted by the framework
		ChildrenListRepresentation childrenListRepresentation = diagramExpansionsRegistry.mapChildreen.get(CLASS_DIAGRAM_TYPE);
		System.out.println(childrenListRepresentation);
		Assert.assertNotNull("A usage contex has been defined for " + CLASS_DIAGRAM_TYPE, childrenListRepresentation);

		Assert.assertNotNull("The Link of NewDependency has been added", childrenListRepresentation.IDMap.get(DEPENDENCY_HINT));
		List<String> the_ClassDiagram_Children = childrenListRepresentation.parentChildrenRelation.get(CLASS_DIAGRAM_TYPE);
		Assert.assertEquals("The class Diagram can have a new child", 1, the_ClassDiagram_Children.size());
		Assert.assertEquals("class Diagram has to contain " + DEPENDENCY_HINT, DEPENDENCY_HINT, the_ClassDiagram_Children.get(0));


		// the model is valid
		// now launch a class diagram

		try {
			initModel("ExpansionModelProject", "ExpansionModelTest", getBundle());
			openDiagram(editor, "NewDiagram");
			SynchronizableGmfDiagramEditor diagramEditor = (SynchronizableGmfDiagramEditor) editor.getActiveEditor();
			DiagramEditPart diagramEditPart = editor.getAdapter(DiagramEditPart.class);
			Assert.assertNotNull("A Class edit Part must exist", diagramEditPart);
			Assert.assertNotNull("The diagram must be opened", diagramEditPart);
			Assert.assertEquals("The class diagram has to contain two class representation", 2, diagramEditPart.getChildren().size());
			IGraphicalEditPart myclassEditPart = (IGraphicalEditPart) diagramEditPart.getChildren().get(0);
			IGraphicalEditPart myOtherclassEditPart = (IGraphicalEditPart) diagramEditPart.getChildren().get(1);
			Assert.assertNotNull("myclassEditPart edit Part must exist", myclassEditPart);
			Assert.assertNotNull("myOtherclassEditPart edit Part must exist", myOtherclassEditPart);
			ElementTypeConfigurationTypeRegistry.getInstance();
			final IElementType elementType_Dependency = ElementTypeRegistry.getInstance().getType(NEW_DEPENDENCY_ELEMENTTYPE_ID);

			Command command = myOtherclassEditPart.getCommand(createConnectionViewRequest(elementType_Dependency, myclassEditPart, myOtherclassEditPart, diagramEditPart));
			assertNotNull("The command to create link must be not null", command);
			assertTrue("The command to create link must be executable", command.canExecute() == true);
			diagramEditor.getDiagramEditDomain().getDiagramCommandStack().execute(command);
			assertTrue("The edge must be created", (diagramEditPart.getDiagramView()).getEdges().size() == 1);
			org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart linkEditPart = (org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart) diagramEditPart.getConnections().get(0);
			Assert.assertNotNull("linkEditPart edit Part must exist", linkEditPart);
			Assert.assertEquals("The link must have the type " + DEPENDENCY_HINT, DEPENDENCY_HINT, linkEditPart.getNotationView().getType());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public CreateConnectionViewRequest createConnectionViewRequest(IElementType type, EditPart source, EditPart target, DiagramEditPart diagramEditPart) {
		CreateConnectionViewRequest connectionRequest = CreateViewRequestFactory.getCreateConnectionRequest(type, diagramEditPart.getDiagramPreferencesHint());
		connectionRequest.setSourceEditPart(null);
		connectionRequest.setTargetEditPart(source);
		connectionRequest.setType(RequestConstants.REQ_CONNECTION_START);
		source.getCommand(connectionRequest);
		// Now, setup the request in preparation to get the
		// connection end
		// command.
		connectionRequest.setSourceEditPart(source);
		connectionRequest.setTargetEditPart(target);
		connectionRequest.setType(RequestConstants.REQ_CONNECTION_END);
		return connectionRequest;
	}

	protected DiagramExpansionsRegistry loadXMIExpansionModel(String filename) {
		DiagramExpansionsRegistry diagramExpansionsRegistry = DiagramExpansionSingleton.getInstance().getDiagramExpansionRegistry();
		diagramExpansionsRegistry.clear();
		Assert.assertEquals("Size ot the registry must be equals to 0", 0, diagramExpansionsRegistry.getDiagramExpansions().size());
		Assert.assertEquals("Size ot the map childreen must be equals to 0", 0, diagramExpansionsRegistry.mapChildreen.size());
		URI badContextExpansion = URI.createPlatformPluginURI("org.eclipse.papyrus.infra.gmfdiag.common.tests", true);
		badContextExpansion = badContextExpansion.appendSegment("models");
		badContextExpansion = badContextExpansion.appendSegment(filename);

		diagramExpansionsRegistry.loadExpansion(badContextExpansion);

		return diagramExpansionsRegistry;
	}

	/**
	 * @see org.eclipse.papyrus.junit.utils.tests.AbstractEditorTest#getSourcePath()
	 *
	 * @return
	 */
	@Override
	protected String getSourcePath() {
		return "models/";
	}

	@Override
	protected Bundle getBundle() {
		return org.eclipse.papyrus.infra.gmfdiag.common.Activator.getInstance().getBundle();
	}
}
