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

import java.lang.reflect.Field;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.aof.sync.tests.runners.TestInstance;
import org.eclipse.papyrus.aof.sync.tests.runners.TestScoped;
import org.eclipse.papyrus.junit.utils.rules.AbstractModelFixture;
import org.junit.Rule;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

/**
 * A module that binds the {@link AbstractModelFixture} rule of the running test.
 */
public class ModelFixtureRuleModule extends AbstractModule {

	public ModelFixtureRuleModule() {
		super();
	}

	@Override
	protected void configure() {
		// All done with provider methods
	}

	@Provides
	@TestScoped
	@SuppressWarnings("unchecked")
	public AbstractModelFixture<? extends EditingDomain> getModelFixtureRule(@TestInstance Object test) {
		AbstractModelFixture<? extends EditingDomain> result = null;

		for (Field next : test.getClass().getFields()) {
			if (next.isAnnotationPresent(Rule.class) && AbstractModelFixture.class.isAssignableFrom(next.getType())) {
				try {
					result = (AbstractModelFixture<? extends EditingDomain>) next.get(test);
				} catch (Exception e) {
					throw new AssertionError("Reflection error in provider method", e);
				}
				break;
			}
		}

		return result;
	}

}
