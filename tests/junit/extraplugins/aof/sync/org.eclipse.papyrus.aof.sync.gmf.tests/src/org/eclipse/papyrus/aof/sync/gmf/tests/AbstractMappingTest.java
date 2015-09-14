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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.papyrus.aof.sync.gmf.DiagramMappingModule;
import org.eclipse.papyrus.aof.sync.tests.AbstractBaseMappingTest;
import org.eclipse.papyrus.aof.sync.tests.runners.InjectWith;

import com.google.inject.Inject;

/**
 * An useful base class for tests of specific notation mappings.
 */
@InjectWith({ DiagramMappingModule.class, GenericFixtureModule.class })
public abstract class AbstractMappingTest<T extends EObject> extends AbstractBaseMappingTest<T, T> {
	@Inject
	protected NotationFactory notation;

	public AbstractMappingTest() {
		super();
	}
}
