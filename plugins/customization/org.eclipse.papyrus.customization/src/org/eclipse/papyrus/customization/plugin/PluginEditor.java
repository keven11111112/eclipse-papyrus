/*****************************************************************************
 * Copyright (c) 2011, 2016 CEA LIST, Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Christian W. Damus - bug 485220
 *  
 *****************************************************************************/
package org.eclipse.papyrus.customization.plugin;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.papyrus.eclipse.project.editors.interfaces.ProjectEditors;
import org.xml.sax.SAXException;

/**
 * @deprecated Use the {@link ProjectEditors#getPluginEditor(IProject)} API, instead.
 */
@Deprecated
public class PluginEditor extends org.eclipse.papyrus.eclipse.project.editors.project.PluginEditor {

	public PluginEditor(IProject project) throws CoreException, IOException, SAXException, ParserConfigurationException {
		super(project);

		if (!exists()) {
			create();
		}

		init();
	}
}
