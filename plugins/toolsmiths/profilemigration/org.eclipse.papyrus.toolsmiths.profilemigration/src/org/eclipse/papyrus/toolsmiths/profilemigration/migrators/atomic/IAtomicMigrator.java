/*****************************************************************************
 * Copyright (c) 2017 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Pauline DEVILLE (CEA LIST) pauline.deville@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.toolsmiths.profilemigration.migrators.atomic;

import org.eclipse.papyrus.toolsmiths.profilemigration.migrators.IMigrator;

/**
 * An AtomicMigrator is a migrator which correspond to a difference find between the old and the new profile
 */
public interface IAtomicMigrator extends IMigrator {

	/**
	 * This method is used to evaluate if the specified node correspond to the
	 * change that we expect to manage with
	 *
	 * @return return true if the treeNode is the expected change, false otherwise
	 */
	public boolean isValid();

	/**
	 * Get the priority, this priority will define the order of execution of migrators.
	 * If the priority is 0 it will be execute last.
	 *
	 * @return the priority
	 */
	public int getPriority();

}
