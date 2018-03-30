/*****************************************************************************
 * Copyright (c) 2018 CEA LIST.
 * 
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	Ansgar Radermacher (CEA LIST) ansgar.radermacher@cea.fr - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.textedit.tests.editor;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.papyrus.extensionpoints.editors.configuration.ICustomDirectEditorConfiguration;
import org.eclipse.papyrus.uml.xtext.integration.DefaultXtextDirectEditorConfiguration;

import com.google.inject.Injector;

/**
 * A dummy C++ editor contribution that will not work. This is intentional: test focus is to
 * check whether right editor (contribution) is chosen
 */
public class ConstraintWithCppPopupEditorConfiguration extends DefaultXtextDirectEditorConfiguration implements ICustomDirectEditorConfiguration {

	public ConstraintWithCppPopupEditorConfiguration() {
		super();
	}

	@Override
	public String getTextToEdit(Object editedObject) {
		return "dummy"; //$NON-NLS-1$
	}

	@Override
	public Injector getInjector() {
		return null;
	}

	@Override
	protected ICommand getParseCommand(EObject umlObject, EObject xtextObject) {
		return null;
	}
}
