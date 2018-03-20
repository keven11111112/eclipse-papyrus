/*****************************************************************************
 * Copyright (c) 2018 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Vincent LORENZO (CEA-LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *   
 *****************************************************************************/
package org.eclipse.papyrus.uml.nattable.properties.observables;

import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablecelleditor.NattablecelleditorPackage;
import org.eclipse.papyrus.infra.nattable.utils.TableEditingDomainUtils;


/**
 * Observable for the owner strategy of the relationships to create and display feature
 */
public class MatrixRelationshipOwnerStrategyObservableValue extends AbstractMatrixRelationshipCellEditorConfigurationObservableValue {

	/**
	 * Constructor.
	 *
	 * @param domain
	 *            The current editing domain.
	 * @param table
	 *            The managed table.
	 */
	public MatrixRelationshipOwnerStrategyObservableValue(final Table table) {
		super(TableEditingDomainUtils.getTableEditingDomain(table), table, NattablecelleditorPackage.eINSTANCE.getGenericRelationshipMatrixCellEditorConfiguration_RelationshipOwnerStrategy());
	}

}
