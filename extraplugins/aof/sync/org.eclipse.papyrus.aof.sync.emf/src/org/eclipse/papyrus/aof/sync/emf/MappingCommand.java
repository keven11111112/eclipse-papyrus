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

import java.util.Collection;

import javax.inject.Inject;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandWrapper;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.papyrus.aof.core.ObserverTracker;
import org.eclipse.papyrus.aof.sync.IMapping;
import org.eclipse.papyrus.aof.sync.IMappingContext;

/**
 * A command that provides undoable and redoable set-up of
 * mappings on EMF models.
 */
public class MappingCommand<E extends EObject> extends CommandWrapper {
	private E from;
	private E to;

	private IMapping<E> mapping;

	private IMappingContext context;

	private Collection<ObserverTracker> trackers;

	public MappingCommand(E from, E to) {
		super();

		this.from = from;
		this.to = to;
	}

	public MappingCommand(E from, E to, String label) {
		super(label);

		this.from = from;
		this.to = to;
	}

	public MappingCommand(E from, E to, String label, String description) {
		super(label, description);

		this.from = from;
		this.to = to;
	}

	@Inject
	void setMapping(IMapping<E> mapping) {
		this.mapping = mapping;
	}

	@Inject
	void setContext(IMappingContext context) {
		this.context = context;
	}

	@Override
	protected Command createCommand() {
		return new RecordingCommand(TransactionUtil.getEditingDomain(from)) {

			@Override
			protected void doExecute() {
				doMapping();
			}
		};
	}

	@Override
	public void undo() {
		disposeTrackers();

		super.undo();
	}

	@Override
	public void redo() {
		// First, redo all of the changes that were mapping consequences
		super.redo();

		// Then set up the mapping again (should have no further model changes!)
		doMapping();
	}

	void doMapping() {
		context.run(from, to, mapping::map);
		trackers = context.detachObserverTrackers();
	}

	void disposeTrackers() {
		for (ObserverTracker next : trackers) {
			next.dispose();
		}
		trackers = null;
	}

	//
	// Nested types
	//

	/**
	 * Protocol for injectable mapping command factories.
	 */
	public interface Factory<E extends EObject> {
		MappingCommand<E> create(E from, E to);

		MappingCommand<E> create(E from, E to, String label);

		MappingCommand<E> create(E from, E to, String label, String description);
	}
}
