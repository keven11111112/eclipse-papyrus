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

package org.eclipse.papyrus.toolsmiths.profilemigration.migrators.atomic.property;

import org.eclipse.papyrus.toolsmiths.profilemigration.migrators.atomic.IChangeMigrator;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;

/**
 * If the property becomes static then the migration tool shall change the
 * value of every slop corresponding to this property. To determine which
 * value the system shall set, it shall ask the designer which value he wants.
 */
public interface IChangeIsStaticFromPropertyMigrator extends IChangeMigrator {


	/**
	 * Get the modified property
	 *
	 * @return the property
	 */
	public Property getProperty();

	/**
	 * Get the stereotype owning the modified property
	 *
	 * @return the stereotype
	 */
	public Stereotype getStereotype();

	/**
	 * Get the new value of the feature isStatic
	 *
	 * @return the isStatic
	 */
	public boolean getValue();

}
