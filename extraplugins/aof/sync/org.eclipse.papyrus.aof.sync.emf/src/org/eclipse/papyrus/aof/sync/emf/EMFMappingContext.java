/*****************************************************************************
 * Copyright (c) 2015 Christian W. Damus and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.aof.sync.emf;

import static java.lang.Boolean.TRUE;

import javax.inject.Inject;
import javax.inject.Provider;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.emf.transaction.impl.InternalTransactionalEditingDomain;
import org.eclipse.papyrus.aof.sync.IMappingProvider;
import org.eclipse.papyrus.aof.sync.MappingContext;

/**
 * An EMF-aware mapping context.
 */
public class EMFMappingContext extends MappingContext {

	@Inject
	private Provider<EditingDomain> domain;

	@Inject
	public EMFMappingContext(IMappingProvider provider) {
		super(provider);
	}

	/**
	 * Suppresses auto-disable hooks when undoing or redoing an
	 * {@linkplain Transaction EMF transaction}. Undo and redo
	 * will directly modify the target side of bindings, which
	 * is okay.
	 * 
	 * @return whether an undo/redo transaction is in progress
	 */
	@Override
	public boolean isSuppressAutoDisableHooks() {
		return (domain.get() instanceof InternalTransactionalEditingDomain)
				&& isUndoingOrRedoing((InternalTransactionalEditingDomain) domain.get());
	}

	private boolean isUndoingOrRedoing(InternalTransactionalEditingDomain domain) {
		Transaction active = domain.getActiveTransaction();

		return (active != null)
				&& TRUE.equals(active.getOptions().get(Transaction.OPTION_IS_UNDO_REDO_TRANSACTION));
	}
}
