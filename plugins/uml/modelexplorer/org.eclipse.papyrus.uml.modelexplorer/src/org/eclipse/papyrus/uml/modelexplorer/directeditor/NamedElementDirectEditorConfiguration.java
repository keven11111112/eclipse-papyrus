/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Fanch BONNABESSE (ALL4TEC) fanch.bonnabesse@all4tec.net - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.modelexplorer.directeditor;

import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.papyrus.extensionpoints.editors.configuration.AbstractBasicDirectEditorConfiguration;
import org.eclipse.uml2.uml.NamedElement;

/**
 * Specific direct editor configuration to rename Named Element.
 */
public class NamedElementDirectEditorConfiguration extends AbstractBasicDirectEditorConfiguration {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getTextToEdit(final Object objectToEdit) {
		if (objectToEdit instanceof NamedElement) {
			return ((NamedElement) objectToEdit).getName();
		}

		return super.getTextToEdit(objectToEdit);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IParser createDirectEditorParser() {
		return new NamedElementDirectEditorParser(getTextToEdit(objectToEdit));
	}
}
