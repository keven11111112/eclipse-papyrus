/*****************************************************************************
 * Copyright (c) 2017 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Vincent Lorenzo (CEA LIST) - vincent.lorenzo@cea.fr - Initial API and implementation
 *   
 *****************************************************************************/
package org.eclipse.papyrus.uml.nattable.matrix.cell.managers;

import org.eclipse.uml2.uml.UMLPackage;

/**
 * 
 * The cell manager for UML Abstraction
 *
 */
public class AbstractionMatrixCellManager extends AbstractUMLGenericMatrixRelationshipCellManager {

	/**
	 * 
	 * Constructor.
	 *
	 */
	public AbstractionMatrixCellManager() {
		super(UMLPackage.eINSTANCE.getAbstraction());
	}

}
