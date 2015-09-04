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

import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.aof.core.IBox;
import org.eclipse.papyrus.aof.core.IPair;
import org.eclipse.papyrus.aof.sync.examples.uml.internal.UMLRTMappingFactory;
import org.eclipse.papyrus.infra.core.utils.AdapterUtils;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.uml2.uml.Class;

import com.google.common.collect.MapMaker;

/**
 * Command handler that configures semantic-model synchronization of classes after the
 * fashion of UML-RT capsules.
 */
public class SynchronizeCapsulesHandler extends AbstractHandler {
	// XXX
	static Map<Class, Class> synchronizedCapsules = new MapMaker().weakKeys().weakValues().makeMap();

	public SynchronizeCapsulesHandler() {
		super();
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IStructuredSelection sel = (IStructuredSelection) HandlerUtil.getCurrentSelection(event);

		Object[] pair = sel.toArray();
		Class from = AdapterUtils.adapt(pair[0], Class.class, null);
		Class to = AdapterUtils.adapt(pair[1], Class.class, null);

		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(from);
		domain.getCommandStack().execute(new RecordingCommand(domain, "Synchronize Capsules") {

			@Override
			protected void doExecute() {
				IPair<IBox<Class>, IBox<Class>> pair = new UMLRTMappingFactory().getCapsuleMapping().map(from, to);
				synchronizedCapsules.put(pair.getLeft().get(0), pair.getRight().get(0));
			}
		});

		return null;
	}

}
