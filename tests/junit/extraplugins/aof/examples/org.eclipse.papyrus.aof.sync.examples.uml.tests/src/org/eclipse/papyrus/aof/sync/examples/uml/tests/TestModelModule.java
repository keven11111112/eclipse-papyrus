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

package org.eclipse.papyrus.aof.sync.examples.uml.tests;

import java.lang.reflect.Field;

import org.eclipse.papyrus.aof.sync.From;
import org.eclipse.papyrus.aof.sync.To;
import org.eclipse.papyrus.aof.sync.examples.uml.internal.UMLRTMappingModule;
import org.eclipse.papyrus.aof.sync.tests.runners.TestInstance;
import org.eclipse.papyrus.junit.utils.rules.ResourceSetFixture;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLFactory;
import org.junit.Rule;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

/**
 * Guice configuration module for the UML mapping example tests.
 */
public class TestModelModule extends AbstractModule {

	public TestModelModule() {
		super();
	}

	@Override
	protected void configure() {
		binder().install(new UMLRTMappingModule());

		bind(UMLFactory.class).toInstance(UMLFactory.eINSTANCE);
	}

	@Provides
	public Package provideTestModel(@TestInstance Object test) {
		ResourceSetFixture rsetFixture = getResourceSetFixtureRule(test);
		return rsetFixture.getModel();
	}

	@Provides
	@From
	public Class provideCapsule1(@TestInstance Object test) {
		Package model = provideTestModel(test);
		return (Class) model.getOwnedType("Capsule1");
	}

	@Provides
	@To
	public Class provideCapsule2(@TestInstance Object test) {
		Package model = provideTestModel(test);
		return (Class) model.getOwnedType("Capsule2");
	}

	private ResourceSetFixture getResourceSetFixtureRule(Object test) {
		ResourceSetFixture result = null;

		for (Field next : test.getClass().getFields()) {
			if (next.isAnnotationPresent(Rule.class) && ResourceSetFixture.class.isAssignableFrom(next.getType())) {
				try {
					result = (ResourceSetFixture) next.get(test);
				} catch (Exception e) {
					throw new AssertionError("Reflection error in provider method", e);
				}
				break;
			}
		}

		return result;
	}
}
