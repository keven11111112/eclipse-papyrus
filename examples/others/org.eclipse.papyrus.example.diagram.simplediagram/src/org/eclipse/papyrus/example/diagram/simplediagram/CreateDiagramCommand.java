/*****************************************************************************
 * Copyright (c) 2014 CEA LIST & other.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Benoit Maggi (CEA LIST) benoit.maggi@cea.fr - Bug 445097
 *****************************************************************************/
package org.eclipse.papyrus.example.diagram.simplediagram;

import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.papyrus.example.diagram.simplediagram.edit.parts.ModelEditPart;
import org.eclipse.papyrus.infra.gmfdiag.common.AbstractPapyrusGmfCreateDiagramCommandHandler;


public class CreateDiagramCommand extends AbstractPapyrusGmfCreateDiagramCommandHandler {

	private static final String EXAMPLE_SIMPLE_DIAGRAM = "ExampleSimpleDiagram"; //$NON-NLS-1$

	@Override
	protected String getDefaultDiagramName() {
		return EXAMPLE_SIMPLE_DIAGRAM;
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
		return org.eclipse.papyrus.example.diagram.simplediagram.part.UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT;
	}

}



