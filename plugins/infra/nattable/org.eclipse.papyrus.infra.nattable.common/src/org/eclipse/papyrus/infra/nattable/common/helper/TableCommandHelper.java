/*****************************************************************************
 * Copyright (c) 2013, 2017 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Laurent Wouters laurent.wouters@cea.fr - Initial API and implementation
 *  Thanh Liem PHAN (ALL4TEC) thanhliem.phan@all4tec.net - Bug 516882
 *  Christian W. Damus - bug 527580
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.common.helper;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.architecture.ArchitectureDomainManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.representation.PapyrusTable;
import org.eclipse.papyrus.infra.nattable.representation.RepresentationPackage;
import org.eclipse.papyrus.infra.viewpoints.policy.AbstractViewTypeHelper;
import org.eclipse.papyrus.infra.viewpoints.policy.PolicyChecker;
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
	 * @since 4.1
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
		PolicyChecker checker = getPolicyChecker(view);
		ArchitectureDomainManager manager = ArchitectureDomainManager.getInstance();
		PapyrusTable repKind = (PapyrusTable) manager.getRepresentationKindById(((Table) view).getTableKindId());
		if (null != repKind && checker.isInViewpoint(repKind)) // null when we are destroying the table (undo after a creation for example), bug 516882
			return getPrototypeFor(repKind);
		return ViewPrototype.UNAVAILABLE_VIEW;
	}
}
