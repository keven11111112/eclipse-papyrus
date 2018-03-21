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
package org.eclipse.papyrus.toolsmiths.profilemigration.migrators.atomic.profile;

import org.eclipse.papyrus.toolsmiths.profilemigration.migrators.atomic.IMoveMigrator;
import org.eclipse.uml2.uml.Profile;

/**
 * If a profile is moved to another profile then the migration tool shall focus
 * on the preservation of the stereotype applications available at the profiled model.
 * 
 * If the profile was moved in a profile that is already applied on the profiled
 * model then the migration is trivial and every stereotype application shall remain.
 * 
 * If the profile was moved in a profile that is not already applied on the profiled model
 * then the migration tool asks the designer if the moved profile should be reapplied.
 * If the designer answers 'yes' every stereotype application shall remain conversely if
 * the answer is 'no' then every stereotype application shall be deleted.
 */
public interface IMoveProfileMigrator extends IMoveMigrator {

	/**
	 * Get the moved profile
	 * 
	 * @return the moved profile
	 */
	public Profile getProfile();

}
