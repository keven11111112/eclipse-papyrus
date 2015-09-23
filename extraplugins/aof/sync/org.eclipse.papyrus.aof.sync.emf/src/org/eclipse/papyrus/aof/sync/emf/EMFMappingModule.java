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

import javax.inject.Provider;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.aof.core.IFactory;
import org.eclipse.papyrus.aof.emf.EMFFactory;
import org.eclipse.papyrus.aof.sync.MappingModule;

import com.google.inject.Provides;

/**
 * Guice configuration for mappings in the EMF domain, providing at least
 * <ul>
 * <li>the {@link EMFFactory} instance for the {@link IFactory} binding</li>
 * <li>an optional {@link EditingDomain} (also as a {@link TransactionalEditingDomain} if that is what is provided)</li>
 * </ul>
 */
public abstract class EMFMappingModule extends MappingModule {
	public EMFMappingModule() {
		super();
	}

	@Override
	protected IFactory getDefaultFactory() {
		return EMFFactory.INSTANCE;
	}

	protected Provider<? extends EditingDomain> getEditingDomainBinding() {
		return () -> null;
	}

	@Provides
	public TransactionalEditingDomain provideTransactionalEditingDomain(EditingDomain domain) {
		return (domain instanceof TransactionalEditingDomain) ? (TransactionalEditingDomain) domain : null;
	}
}
