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

import org.eclipse.uml2.uml.Element;

/**
 * This is a migrator for the action of deleting an element from a container
 */
public interface IDeleteMigrator extends IAtomicMigrator {

	/**
	 * Get the deleted element
	 * 
	 * @return the deleted element
	 */
	public Element getDeletedElement();

	/**
	 * Get the container of the element before its deletion
	 * 
	 * @return the container of the element before its deletion
	 */
	public Element getDeletedElementContainer();

}
