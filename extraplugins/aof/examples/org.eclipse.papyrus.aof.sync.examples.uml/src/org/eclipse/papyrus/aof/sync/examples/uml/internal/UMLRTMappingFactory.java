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

package org.eclipse.papyrus.aof.sync.examples.uml.internal;

import org.eclipse.papyrus.aof.sync.IMapping;
import org.eclipse.papyrus.aof.sync.MappingFactory;
import org.eclipse.papyrus.aof.sync.MappingModule;
import org.eclipse.uml2.uml.Class;

/**
 * Factory for model-to-model mappings of redefining capsule state machines,
 * inspired by UML-RT.
 */
public class UMLRTMappingFactory extends MappingFactory {
	public UMLRTMappingFactory() {
		this(new UMLRTMappingModule());
	}

	public UMLRTMappingFactory(MappingModule... module) {
		super(module);
	}

	public IMapping<Class> getCapsuleMapping() {
		return getInstance(IMapping.class, Class.class);
	}
}
