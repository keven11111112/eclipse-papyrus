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

package org.eclipse.papyrus.aof.sync.emf.internal;

import javax.inject.Inject;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.aof.sync.emf.MappingCommand;
import org.eclipse.papyrus.aof.sync.emf.MappingCommand.Factory;

import com.google.inject.MembersInjector;

/**
 * Default implementation of the injectable {@link MappingCommand}
 * {@linkplain MappingCommand.Factory factory} protocol.
 */
public class MappingCommandFactory<F extends EObject, T extends EObject> implements Factory<F, T> {
	@Inject
	private MembersInjector<MappingCommand<F, T>> commandInjector;

	public MappingCommandFactory() {
		super();
	}

	private MappingCommand<F, T> inject(MappingCommand<F, T> command) {
		commandInjector.injectMembers(command);

		return command;
	}

	@Override
	public MappingCommand<F, T> create(F from, T to) {
		return inject(new MappingCommand<>(from, to));
	}

	@Override
	public MappingCommand<F, T> create(F from, T to, String label) {
		return inject(new MappingCommand<>(from, to, label));
	}

	@Override
	public MappingCommand<F, T> create(F from, T to, String label, String description) {
		return inject(new MappingCommand<>(from, to, label, description));
	}

}
