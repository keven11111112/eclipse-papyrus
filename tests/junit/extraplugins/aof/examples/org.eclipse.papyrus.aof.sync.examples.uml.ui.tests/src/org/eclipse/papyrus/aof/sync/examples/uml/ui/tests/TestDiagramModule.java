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

package org.eclipse.papyrus.aof.sync.examples.uml.ui.tests;

import javax.inject.Provider;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.aof.sync.examples.uml.internal.UMLRTMappingModule;
import org.eclipse.papyrus.aof.sync.examples.uml.ui.internal.handlers.AbstractSynchronizeViewsHandler;
import org.eclipse.papyrus.aof.sync.examples.uml.ui.internal.handlers.SynchronizeDiagramsHandler;
import org.eclipse.papyrus.junit.utils.rules.AbstractModelFixture;
import org.eclipse.uml2.uml.UMLFactory;

import com.google.inject.AbstractModule;
import com.google.inject.Key;
import com.google.inject.Provides;
import com.google.inject.TypeLiteral;

/**
 * Guice configuration module for the UML diagram mapping example tests.
 */
public class TestDiagramModule extends AbstractModule {

	public TestDiagramModule() {
		super();
	}

	@Override
	protected void configure() {
		binder().install(new UMLRTMappingModule(createEditingDomainProvider()));

		bind(UMLFactory.class).toInstance(UMLFactory.eINSTANCE);
	}

	@Provides
	public AbstractSynchronizeViewsHandler<Diagram, DiagramEditPart> provideSynchronizeHandler() {
		return new SynchronizeDiagramsHandler();
	}

	private Provider<EditingDomain> createEditingDomainProvider() {
		Provider<AbstractModelFixture<? extends EditingDomain>> modelFixture = getProvider(Key.get(new TypeLiteral<AbstractModelFixture<? extends EditingDomain>>() {
		}));
		return () -> modelFixture.get().getEditingDomain();
	}

}
