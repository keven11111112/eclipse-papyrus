/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.migration.rhapsody.wizard;

import org.eclipse.papyrus.migration.common.wizard.pages.AbstractDialogData;
import org.eclipse.papyrus.migration.rhapsody.importer.utils.RhapsodyFileUtils;

/**
 * 
 * @author Vincent Lorenzo
 *
 */
public class RhapsodyDialogData extends AbstractDialogData {

	/**
	 * 
	 * @see org.eclipse.papyrus.migration.common.wizard.pages.AbstractDialogData#getExtensions()
	 *
	 * @return
	 */
	@Override
	public String[] getExtensions() {
		return new String[] { RhapsodyFileUtils.ALL_RPY_FILES, RhapsodyFileUtils.STRING_STAR };

	}

	/**
	 * 
	 * @see org.eclipse.papyrus.migration.common.wizard.pages.AbstractDialogData#getExtensionsNames()
	 *
	 * @return
	 */
	@Override
	public String[] getExtensionsNames() {
		return new String[] { RhapsodyFileUtils.ALL_RPY_FILES, RhapsodyFileUtils.STRING_ALL };
	}

}
