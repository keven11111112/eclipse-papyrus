package org.eclipse.papyrus.diagram.newdiagram;

import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.papyrus.core.adaptor.gmf.AbstractPapyrusGmfCreateDiagramCommandHandler;
import org.eclipse.papyrus.diagram.newdiagram.edit.parts.ModelEditPart;


public class CreateDiagramCommand extends AbstractPapyrusGmfCreateDiagramCommandHandler {

	@Override
	protected String getDefaultDiagramName() {
		return openDiagramNameDialog("NewDiagram");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getDiagramNotationID() {
		return ModelEditPart.MODEL_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected PreferencesHint getPreferenceHint() {
		return org.eclipse.papyrus.diagram.newdiagram.part.UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT;
	}

}



