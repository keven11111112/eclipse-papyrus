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

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.junit.utils.rules.ModelSetFixture;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * This rule provides a ResourceSet with a TransactionalEditingDomain
 *
 * All test methods are executed within a Transaction (Which means test method
 * do not need to care about transactions)
 *
 * Usage:
 *
 * <pre>
 * &#064;Rule
 * public NoTransactionRule noTransaction = new NoTransactionRule();
 * </pre>
 */
public class NoTransactionRule implements TestRule {

	/**
	 * The model set fixture.
	 */
	private final ModelSetFixture modelSet = new ModelSetFixture();

	/**
	 * The no transition fixture created from the model set fixture.
	 */
	private final NoTransactionFixture noTransaction = new NoTransactionFixture(modelSet);

	/**
	 * Get the {@link RuleChain}.
	 * 
	 * @return The {@link RuleChain}.
	 */
	public RuleChain getRuleChain() {
		return RuleChain.outerRule(modelSet).around(noTransaction);
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
		return getRuleChain().apply(base, description);
	}

	/**
	 * Get the resource set.
	 * 
	 * @return The resource set
	 */
	public ResourceSet getResourceSet() {
		return modelSet.getResourceSet();
	}

	/**
	 * Get the model resource.
	 * 
	 * @return The model resource.
	 */
	public Resource getModelResource() {
		return modelSet.getModelResource();
	}
}
