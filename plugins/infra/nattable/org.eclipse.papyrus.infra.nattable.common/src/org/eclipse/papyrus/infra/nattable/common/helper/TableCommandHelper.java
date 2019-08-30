/*****************************************************************************
 * Copyright (c) 2013, 2017, 2019 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Laurent Wouters laurent.wouters@cea.fr - Initial API and implementation
 *  Thanh Liem PHAN (ALL4TEC) thanhliem.phan@all4tec.net - Bug 516882
 *  Christian W. Damus - bug 527580
 *  Nicolas FAUVERGUE (CEA LIST) nicolas.fauvergue@cea.fr - Bug 550568
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.common.helper;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.nattable.common.utils.TableUtil;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.representation.PapyrusTable;
import org.eclipse.papyrus.infra.nattable.representation.RepresentationPackage;
import org.eclipse.papyrus.infra.viewpoints.policy.AbstractViewTypeHelper;
import org.eclipse.papyrus.infra.viewpoints.policy.ViewPrototype;

/**
 * Represents the command helper for viewpoints-based generic tables
 *
 * @author Laurent Wouters
 * @since 3.0
 */
public class TableCommandHelper extends AbstractViewTypeHelper<PapyrusTable> {

	public TableCommandHelper() {
		super(PapyrusTable.class);
	}

	@Override
	public boolean isSupported(EClass type) {
		return (type == RepresentationPackage.eINSTANCE.getPapyrusTable());
	}

	@Override
	public boolean isSupported(EObject view) {
		if (!(view instanceof Table)) {
			return false;
		}
		Table table = (Table) view;
		// Bug 516882: When undoing table creation, table kind ID is null leads to the fact that
		// table view is not removed from the list of observables.
		// As a consequence, the broken table view remains in the Welcome page / Notation Views.
		// Checking also the table configuration could handle this problem.
		return (table.getTableKindId() != null || table.getTableConfiguration() != null);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @since 5.0
	 */
	@Override
	protected ViewPrototype doGetPrototypeFor(PapyrusTable papyrusTable) {
		return new TableViewPrototype(papyrusTable);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @since 4.1
	 */
	@Override
	protected ViewPrototype doGetPrototypeOf(EObject view) {
		return TableUtil.getPrototype((Table) view, false);
	}
}
