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
package org.eclipse.papyrus.toolsmiths.profilemigration.internal.migrators.atomic.enumeration;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.tree.TreeNode;
import org.eclipse.papyrus.toolsmiths.profilemigration.MigratorProfileApplication;
import org.eclipse.papyrus.toolsmiths.profilemigration.internal.utils.TreeNodeUtils;
import org.eclipse.papyrus.toolsmiths.profilemigration.migrators.atomic.IMoveMigrator;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;

/**
 * If an enumeration literal is deleted from an enumeration in the profile specification and this
 * enumeration is used to type one or many properties of stereotypes then all stereotype
 * applications corresponding to the affected stereotype shall be upgraded. The upgrade
 * consists for each stereotype application in providing the designer with the possibility to
 * update the enumeration literal affected to the property whose specification was changed.
 */
public class MoveEnumerationLiteralFromEnumerationMigrator extends DeleteEnumerationLiteralFromEnumerationMigrator implements IMoveMigrator {

	/**
	 * Constructor.
	 *
	 * @param treeNode
	 *            the treeNode corresponding to this migrator
	 */
	public MoveEnumerationLiteralFromEnumerationMigrator(TreeNode treeNode) {
		super(treeNode);
	}

	/**
	 * This method check if the specified treeNode is a node representing the current change
	 *
	 * Is valid if:
	 * 1] the treeNode is a moved node
	 * 2] the moved element is a EnumerationLiteral
	 * 3] the new container is in the currently profile use for the migration
	 *
	 * @param treeNode
	 * @return true if the treeNode represent the current change
	 */
	public static boolean isValid(TreeNode treeNode) {
		if (TreeNodeUtils.isMoveChange(treeNode)) {
			Object element = TreeNodeUtils.getMovedElement(treeNode);
			EObject oldContainer = TreeNodeUtils.getMovedSourceContainer(treeNode, MigratorProfileApplication.comparison);
			if (element instanceof EnumerationLiteral && oldContainer != null && oldContainer instanceof Enumeration) {
				if (TreeNodeUtils.getNearestProfile(treeNode) == MigratorProfileApplication.appliedProfile) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * This method is used to evaluate if the specified node correspond to the
	 * change that we expect to manage with
	 *
	 * @return return true if the treeNode is the expected change, false otherwise
	 */
	@Override
	public boolean isValid() {
		return isValid(treeNode);
	}

	/**
	 * Get the new container of the element
	 * 
	 * @return the new container of the element
	 */
	@Override
	public Element getTargetContainer() {
		return getEnumerationLiteral().getOwner();
	}

	/**
	 * Get the old container of the element (before the move)
	 * 
	 * @return the old container of the element
	 */
	@Override
	public Element getSourceContainer() {
		return getEnumeration();
	}

	/**
	 * Initialize attributes from the treeNode
	 */
	@Override
	public void initAttributes() {
		if (isValid()) {
			enumerationLiteral = (EnumerationLiteral) TreeNodeUtils.getMovedElement(treeNode);
			enumeration = (Enumeration) TreeNodeUtils.getMovedSourceContainer(treeNode, MigratorProfileApplication.comparison);
		}
	}

	/**
	 * Get the moved element
	 * 
	 * @return the moved element
	 */
	@Override
	public Element getMovedElement() {
		return getEnumerationLiteral();
	}

}
