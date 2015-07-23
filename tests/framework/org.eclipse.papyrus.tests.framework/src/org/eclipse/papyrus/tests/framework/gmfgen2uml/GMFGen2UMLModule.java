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

package org.eclipse.papyrus.tests.framework.gmfgen2uml;

import org.eclipse.papyrus.tests.framework.m2m.Metamodels;
import org.eclipse.uml2.uml.Model;

import com.google.inject.AbstractModule;

/**
 * Guice module for the GMFGen-to-UML transformation.
 */
public class GMFGen2UMLModule extends AbstractModule {
	private final Model gmfgenMetamodel;

	public GMFGen2UMLModule(Model gmfgenMetamodel) {
		super();

		this.gmfgenMetamodel = gmfgenMetamodel;
	}

	@Override
	protected void configure() {
		bindMetamodels();
		bindGMFGen2UML();
	}

	protected void bindMetamodels() {
		bind(Metamodels.class).toInstance(new Metamodels(gmfgenMetamodel, null, null));
	}

	private void bindGMFGen2UML() {
		// Pass
	}

}
