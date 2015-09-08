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

package org.eclipse.papyrus.aof.sync.gmf.tests;

import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.junit.framework.classification.rules.MemoryLeakRule;
import org.junit.Rule;
import org.junit.Test;

/**
 * Test cases for verification of complete memory clean-up of models
 * that employ AOF-based synchronization of diagrams.
 */
public class MemoryLeakTest extends AbstractMappingTest<Diagram> {

	@Rule
	public final MemoryLeakRule memory = new MemoryLeakRule();

	@Test
	public void map() {
		memory.add(getFrom());
		memory.add(getTo());

		memory.add(mapped.getLeft());
		memory.add(mapped.getRight());
		memory.add(mapped);
	}

}
