/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.customization.factory;

import org.eclipse.papyrus.customization.messages.Messages;
import org.eclipse.papyrus.customization.model.customization.CustomizableElement;
import org.eclipse.papyrus.customization.model.customization.FileBasedCustomizableElement;
import org.eclipse.papyrus.customization.plugin.ProjectEditor;


public class EnvironmentExtensionFactory extends FileBasedExtensionFactory {

	public EnvironmentExtensionFactory() {
		super(Messages.EnvironmentExtensionFactory_PropertyViewEnvironment, org.eclipse.papyrus.properties.Activator.ENVIRONMENT_EXTENSION, "environmentModel", "environment", true); //$NON-NLS-1$ //$NON-NLS-2$
	}

	@Override
	public void addElement(CustomizableElement element, ProjectEditor editor) {
		super.addElement(element, editor);

		editor.getManifestEditor().addDependency(org.eclipse.papyrus.properties.Activator.PLUGIN_ID);
	}

	@Override
	protected String getTargetPath(FileBasedCustomizableElement element) {
		return "/environment/" + getFileName(element); //$NON-NLS-1$
	}

}
