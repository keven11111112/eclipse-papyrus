/*****************************************************************************
 * Copyright (c) 2014, 2015 CEA LIST, Christian W. Damus, and others.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *  Christian W. Damus - bug 468079
 *  Christian W. Damus - bug 471836
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.developper.mde.handler;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.papyrus.uml.developper.mde.I_DeveloperIDMStereotype;
import org.eclipse.papyrus.uml.developper.mde.command.CreateDocumentModelCommand;
import org.eclipse.papyrus.uml.developper.mde.transcription.HTMLTranscription;
import org.eclipse.papyrus.uml.developper.mde.transcription.TranscriptionEngine;
import org.eclipse.uml2.uml.Model;

/**
 * This class is used to create and html developper doc file.
 *
 */
public class GetHTMLTextHandler extends IDMAbstractHandler {

	protected static final String INTERNAL_DIRECTORY_NAME = "/doc"; //$NON-NLS-1$




	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		super.execute(event);
		System.err.println(getCurrentProject().getLocationURI().getPath());
		IDMAbstractHandler.clear();

		try {
			CreateDocumentModelCommand createDocumentModelCommand = new CreateDocumentModelCommand(transactionalEditingDomain, (Model) getSelection(), getCurrentProject().getLocationURI().getPath() + INTERNAL_DIRECTORY_NAME);
			transactionalEditingDomain.getCommandStack().execute(createDocumentModelCommand);
			IProject project = getCurrentProject();
			TranscriptionEngine engine = new TranscriptionEngine((Model) getSelection(), project, new HTMLTranscription());
			engine.traduce();
		} finally {
			IDMAbstractHandler.clear();
		}

		return null;
	}

	@Override
	public boolean isEnabled() {
		if (getSelection() instanceof Model) {
			Model model = (Model) getSelection();
			if (model.getAppliedStereotype(I_DeveloperIDMStereotype.PROJECT_STEREOTYPE) != null) {
				return true;
			}

		}
		return false;
	}

}
