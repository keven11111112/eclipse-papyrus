/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.sequence;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.papyrus.core.adaptor.gmf.AbstractPapyrusGmfCreateDiagramCommandHandler;
import org.eclipse.papyrus.diagram.sequence.edit.parts.PackageEditPart;
import org.eclipse.papyrus.diagram.sequence.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.diagram.sequence.providers.ElementInitializers;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * Define a command to create a new Sequence Diagram. This command is used by all UI (toolbar,
 * outline, creation wizards) to create a new Sequence Diagram.
 */
public class CreateSequenceDiagramCommand extends AbstractPapyrusGmfCreateDiagramCommandHandler {

	private Interaction interaction = null;

	@Override
	protected String getDiagramNotationID() {
		return PackageEditPart.MODEL_ID;
	}

	@Override
	protected PreferencesHint getPreferenceHint() {
		return UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT;
	}


	/**
	 * Initialize the diagram. The diagram is attached to the interaction instead of its real owner.
	 */
	@Override
	protected void initializeDiagram(EObject diagram) {
		if(diagram instanceof Diagram) {
			Diagram diag = (Diagram)diagram;
			if(interaction != null) {
				diag.setElement(interaction);
				createInteractionGraph(interaction, diag);
			}
		}
	}

	/**
	 * Initialize the model.
	 */
	@Override
	protected void initializeModel(EObject owner) {
		// If the interaction is null, it means we are creating a diagram from a package. So we need to create the interaction
		if(interaction == null && owner instanceof org.eclipse.uml2.uml.Package) {
			org.eclipse.uml2.uml.Package pack = (org.eclipse.uml2.uml.Package)owner;
			interaction = UMLFactory.eINSTANCE.createInteraction();
			interaction = (Interaction)pack.createPackagedElement(null, interaction.eClass());
			ElementInitializers.init_NamedElement(interaction);
		}
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	protected Diagram createDiagram(Resource diagramResource, EObject owner, String name) {
		Diagram diagram = null;
		interaction = null;
		if(owner instanceof Interaction) {
			// Set the interaction
			interaction = (Interaction)owner;
			// Create the diagram with the owner corresponding to the package containing the current interaction
			diagram = super.createDiagram(diagramResource, interaction.getPackage(), name);
		} else if(owner instanceof org.eclipse.uml2.uml.Package) {
			diagram = super.createDiagram(diagramResource, owner, name);
		}
		return diagram;
	}

	private void createInteractionGraph(Element interaction, Diagram diagram) {
		ViewService.getInstance().createView(Node.class, new EObjectAdapter(interaction), diagram, null, ViewUtil.APPEND, true, UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
	}

	@Override
	protected EObject createRootElement() {
		return UMLFactory.eINSTANCE.createModel();
	}

	@Override
	protected String getDefaultDiagramName() {
		return super.openDiagramNameDialog("SequenceDiagram");
	}

}
