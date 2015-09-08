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

package org.eclipse.papyrus.aof.sync.tests;

import javax.inject.Inject;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.aof.core.IBox;
import org.eclipse.papyrus.aof.core.IPair;
import org.eclipse.papyrus.aof.sync.tests.AbstractMappingTest.TestMapping;
import org.eclipse.papyrus.aof.sync.tests.runners.InjectWith;
import org.eclipse.papyrus.junit.framework.classification.rules.MemoryLeakRule;
import org.junit.Rule;
import org.junit.Test;

/**
 * Test cases for verification of complete memory clean-up of models
 * that employ AOF-based synchronization.
 */
@InjectWith(TestModelModule.class)
public class MemoryLeakTest extends AbstractTest {

	@Rule
	public final MemoryLeakRule memory = new MemoryLeakRule();

	@Inject
	private TestMapping mapping;

	@Inject
	@From
	private EObject from;

	@Inject
	@To
	private EObject to;

	@Test
	public void map() {
		memory.add(from);
		memory.add(to);

		IPair<IBox<EObject>, IBox<EObject>> pair = mapping.map(from, to);

		memory.add(pair.getLeft());
		memory.add(pair.getRight());
		memory.add(pair);
	}

}
