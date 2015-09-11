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
public class MappingCommandFactory<E extends EObject> implements Factory<E> {
	@Inject
	private MembersInjector<MappingCommand<E>> commandInjector;

	public MappingCommandFactory() {
		super();
	}

	private MappingCommand<E> inject(MappingCommand<E> command) {
		commandInjector.injectMembers(command);

		return command;
	}

	@Override
	public MappingCommand<E> create(E from, E to) {
		return inject(new MappingCommand<>(from, to));
	}

	@Override
	public MappingCommand<E> create(E from, E to, String label) {
		return inject(new MappingCommand<>(from, to, label));
	}

	@Override
	public MappingCommand<E> create(E from, E to, String label, String description) {
		return inject(new MappingCommand<>(from, to, label, description));
	}

}
