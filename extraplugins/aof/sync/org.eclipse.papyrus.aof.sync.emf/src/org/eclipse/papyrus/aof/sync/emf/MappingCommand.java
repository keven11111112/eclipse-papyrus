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

import javax.inject.Inject;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandWrapper;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.papyrus.aof.sync.IMapping;

/**
 * A command that provides undoable and redoable set-up of
 * mappings on EMF models.
 */
public class MappingCommand<F extends EObject, T extends EObject> extends CommandWrapper {
	private F from;
	private T to;

	private IMapping<F, T> mapping;

	private IMapping.Instance<F, T> mappingInstance;

	public MappingCommand(F from, T to) {
		super();

		this.from = from;
		this.to = to;
	}

	public MappingCommand(F from, T to, String label) {
		super(label);

		this.from = from;
		this.to = to;
	}

	public MappingCommand(F from, T to, String label, String description) {
		super(label, description);

		this.from = from;
		this.to = to;
	}

	@Inject
	void setMapping(IMapping<F, T> mapping) {
		this.mapping = mapping;
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
		destroyMapping();

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
		mappingInstance = mapping.map(from, to);
	}

	void destroyMapping() {
		if (mappingInstance != null) {
			mappingInstance.destroy();
			mappingInstance = null;
		}
	}

	//
	// Nested types
	//

	/**
	 * Protocol for injectable mapping command factories.
	 */
	public interface Factory<F extends EObject, T extends EObject> {
		MappingCommand<F, T> create(F from, T to);

		MappingCommand<F, T> create(F from, T to, String label);

		MappingCommand<F, T> create(F from, T to, String label, String description);
	}
}
