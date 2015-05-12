/**
 * Copyright (c) 2015 Christian W. Damus and others.
 *
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *  Christian W. Damus - Initial API and implementation
 *
 *
 */
package org.eclipse.papyrus.infra.viewpoints.configuration.tests;

import junit.textui.TestRunner;

import org.eclipse.papyrus.infra.viewpoints.configuration.ConfigurationFactory;
import org.eclipse.papyrus.infra.viewpoints.configuration.OwningRule;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Owning Rule</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class OwningRuleTest extends RuleTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(OwningRuleTest.class);
	}

	/**
	 * Constructs a new Owning Rule test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OwningRuleTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Owning Rule test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected OwningRule getFixture() {
		return (OwningRule)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(ConfigurationFactory.eINSTANCE.createOwningRule());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //OwningRuleTest