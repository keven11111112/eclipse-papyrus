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

import java.util.function.Supplier;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.aof.sync.ISyncMapping;
import org.eclipse.papyrus.aof.sync.MappingFactory;
import org.eclipse.uml2.uml.Class;

import com.google.inject.Module;
import com.google.inject.util.Providers;

/**
 * Factory for model-to-model mappings of redefining capsule state machines,
 * inspired by UML-RT.
 */
public class UMLRTMappingFactory extends MappingFactory {

	public UMLRTMappingFactory() {
		this(new UMLRTMappingModule());
	}

	public UMLRTMappingFactory(TransactionalEditingDomain editingDomain) {
		this(new UMLRTMappingModule(Providers.of(editingDomain)));
	}

	public UMLRTMappingFactory(Supplier<? extends TransactionalEditingDomain> editingDomainSupplier) {
		this(new UMLRTMappingModule(editingDomainSupplier::get));
	}

	public UMLRTMappingFactory(Module module, Module... more) {
		super(module, more);
	}

	public ISyncMapping<Class> getCapsuleMapping() {
		return getSyncMapping(Class.class);
	}
}
