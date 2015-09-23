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

package org.eclipse.papyrus.sync.tests;

import static org.junit.Assert.fail;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.aof.sync.MappingFactory;
import org.eclipse.papyrus.aof.sync.examples.uml.internal.UMLRTMappingFactory;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.sync.spi.AOFSyncDelegate;

/**
 * @author damus
 *
 */
public class TestSyncDelegate extends AOFSyncDelegate {

	public static boolean runningTest;

	public TestSyncDelegate() {
		super();
	}

	@Override
	public String getID() {
		return "org.eclipse.papyrus.sync.tests.delegate";
	}

	@Override
	public boolean canSynchronize(Object source, Object target) {
		return runningTest && super.canSynchronize(source, target);
	}

	@Override
	protected MappingFactory createMappingFactory(ServicesRegistry serviceRegistry) {
		try {
			return new UMLRTMappingFactory(serviceRegistry.getService(TransactionalEditingDomain.class));
		} catch (ServiceException e) {
			e.printStackTrace();
			fail("Failed to initialize editing domain service: " + e.getMessage());
			return null; // Unreachable
		}
	}

}
