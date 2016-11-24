/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Nicolas FAUVERGUE (ALL4TEC) nicolas.fauvergue@all4tec.net - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.infra.internationalization.common.editor;

/**
 * Interface to define if the editor support the internationalization and the corresponding label modification.
 */
public interface IInternationalizationEditor {

	/**
	 * This allows to modify the part name.
	 * 
	 * @param name
	 *            The new name of the editor.
	 */
	public void modifyPartName(final String name);
	
	/**
	 * This allows to refresh the editor part.
	 */
	public void refreshEditorPart();

}
