/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Nicolas FAUVERGUE (ALL4TEC) nicolas.fauvergue@all4tec.net - Initial API and implementation
 *   
 *****************************************************************************/
package org.eclipse.papyrus.uml.textedit.valuespecification.tests.rules;

import java.util.concurrent.atomic.AtomicReference;

import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.junit.utils.rules.ModelSetFixture;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * This rule provides a ResourceSet with a TransactionalEditingDomain
 *
 * All test methods are executed within a Transaction (Which means test method
 * do not need to care about transactions)
 *
 * This fixture is meant to be used through {@link NoTransactionRule}
 *
 * @see {@link NoTransactionRule}
 */
public class NoTransactionFixture implements TestRule {

	/**
	 * The model set fixture.
	 */
	private final ModelSetFixture modelSet;

	/**
	 * Constructor.
	 *
	 * @param modelSet
	 *            The model set fixture.
	 */
	public NoTransactionFixture(final ModelSetFixture modelSet) {
		this.modelSet = modelSet;
	}

	/**
	 * @see org.junit.rules.TestRule#apply(org.junit.runners.model.Statement, org.junit.runner.Description)
	 *
	 * @param base
	 *            The base statement.
	 * @param description
	 *            The description.
	 * @return The modified statement.
	 */
	public Statement apply(final Statement base, final Description description) {
		return new Statement() {
			@Override
			public void evaluate() throws Throwable {

				final AtomicReference<Throwable> throwable = new AtomicReference<Throwable>();
				modelSet.getEditingDomain().getCommandStack().execute(new AbstractCommand() {

					public void execute() {
						try {
							base.evaluate();
						} catch (Throwable t) {
							throwable.set(t);
						}
					}

					public void redo() {
						// Nothing
					}

					/**
					 * @see org.eclipse.emf.common.command.AbstractCommand#prepare()
					 *
					 * @return
					 */
					@Override
					protected boolean prepare() {
						return true;
					}

				});

				if (null != throwable.get()) {
					throw throwable.get();
				}
			}
		};
	}

	/**
	 * Get the resource set.
	 * 
	 * @return The resource set.
	 */
	public ResourceSet getResourceSet() {
		return modelSet.getResourceSet();
	}

}
