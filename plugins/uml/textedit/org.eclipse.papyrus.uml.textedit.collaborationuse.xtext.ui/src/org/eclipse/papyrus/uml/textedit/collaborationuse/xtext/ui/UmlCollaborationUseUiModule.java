/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.textedit.collaborationuse.xtext.ui;

import org.eclipse.papyrus.uml.xtext.integration.PapyrusDefaultAutoEditStrategyProvider;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.ui.editor.autoedit.AbstractEditStrategyProvider;

/**
 * Use this class to register components to be used within the IDE.
 */
public class UmlCollaborationUseUiModule extends org.eclipse.papyrus.uml.textedit.collaborationuse.xtext.ui.AbstractUmlCollaborationUseUiModule {

	public UmlCollaborationUseUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.xtext.ui.DefaultUiModule#bindAbstractEditStrategyProvider()
	 */
	@Override
	public Class<? extends AbstractEditStrategyProvider> bindAbstractEditStrategyProvider() {
		return PapyrusDefaultAutoEditStrategyProvider.class;
	}
}
