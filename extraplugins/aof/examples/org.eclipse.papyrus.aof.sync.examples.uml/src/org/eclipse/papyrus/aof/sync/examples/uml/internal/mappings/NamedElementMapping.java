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

package org.eclipse.papyrus.aof.sync.examples.uml.internal.mappings;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.papyrus.aof.core.IFactory;
import org.eclipse.papyrus.aof.core.IOne;
import org.eclipse.papyrus.aof.sync.emf.EMFSyncMapping;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Mapping of named elements, synchronizing their names.
 */
@Singleton
public class NamedElementMapping<T extends NamedElement> extends EMFSyncMapping<T> {
	@Inject
	public NamedElementMapping(EClass type, IFactory factory) {
		super(type, factory);
	}

	@Override
	protected void mapProperties(IOne<T> from, IOne<T> to) {
		bindProperty(from, to, UMLPackage.Literals.NAMED_ELEMENT__NAME);
	}
}
