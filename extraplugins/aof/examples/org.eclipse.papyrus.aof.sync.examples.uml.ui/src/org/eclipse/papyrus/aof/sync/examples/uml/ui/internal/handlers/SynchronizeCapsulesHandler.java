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

package org.eclipse.papyrus.aof.sync.examples.uml.ui.internal.handlers;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.aof.sync.emf.MappingCommand;
import org.eclipse.papyrus.aof.sync.examples.uml.internal.UMLRTMappingFactory;
import org.eclipse.papyrus.infra.core.utils.AdapterUtils;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.uml2.uml.Class;

/**
 * Command handler that configures semantic-model synchronization of classes after the
 * fashion of UML-RT capsules.
 */
public class SynchronizeCapsulesHandler extends AbstractHandler {

	public SynchronizeCapsulesHandler() {
		super();
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IStructuredSelection sel = (IStructuredSelection) HandlerUtil.getCurrentSelection(event);

		synchronize(((List<?>) sel.toList()).stream()
				.map(e -> AdapterUtils.adapt(e, Class.class, null))
				.collect(Collectors.toList()));

		return null;
	}

	public void synchronize(Collection<? extends Class> capsules) {
		if (capsules.size() != 2) {
			throw new IllegalArgumentException("Selection not exactly two capsules");
		}

		Class[] pair = capsules.toArray(new Class[capsules.size()]);
		Class from = pair[0];
		Class to = pair[1];

		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(from);
		MappingCommand.Factory<Class, Class> commandFactory = new UMLRTMappingFactory().getInstance(MappingCommand.Factory.class, Class.class, Class.class);

		domain.getCommandStack().execute(commandFactory.create(from, to, "Synchronize Capsules"));
	}
}
