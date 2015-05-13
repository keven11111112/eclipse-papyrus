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

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.papyrus.infra.viewpoints.configuration.ConfigurationFactory;
import org.eclipse.papyrus.infra.viewpoints.configuration.ModelAutoCreate;
import org.eclipse.papyrus.infra.viewpoints.configuration.OwningRule;

import junit.framework.TestCase;
import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Model Auto Create</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 * <li>{@link org.eclipse.papyrus.infra.viewpoints.configuration.ModelAutoCreate#getOrigin() <em>Origin</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ModelAutoCreateTest extends TestCase {

	/**
	 * The fixture for this Model Auto Create test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ModelAutoCreate fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ModelAutoCreateTest.class);
	}

	/**
	 * Constructs a new Model Auto Create test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ModelAutoCreateTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Model Auto Create test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void setFixture(ModelAutoCreate fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Model Auto Create test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ModelAutoCreate getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see junit.framework.TestCase#setUp()
	 * @generated NOT
	 */
	@Override
	protected void setUp() throws Exception {
		OwningRule rule = ConfigurationFactory.eINSTANCE.createOwningRule();
		rule.setElement(EcorePackage.Literals.EPACKAGE);

		ModelAutoCreate fixture = ConfigurationFactory.eINSTANCE.createModelAutoCreate();
		fixture.setCreationType("org.eclipse.papyrus.ecore.EClass");
		fixture.setFeature(EcorePackage.Literals.EPACKAGE__ECLASSIFIERS);
		rule.getNewModelPath().add(fixture);
		setFixture(fixture);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

	/**
	 * Tests the '{@link org.eclipse.papyrus.infra.viewpoints.configuration.ModelAutoCreate#getOrigin() <em>Origin</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.ModelAutoCreate#getOrigin()
	 * @generated NOT
	 */
	public void testGetOrigin() {
		assertThat(getFixture().getOrigin(), is(EcorePackage.Literals.EPACKAGE));

		ModelAutoCreate path = ConfigurationFactory.eINSTANCE.createModelAutoCreate();
		path.setFeature(EcorePackage.Literals.ECLASS__ESTRUCTURAL_FEATURES);
		((OwningRule)getFixture().eContainer()).getNewModelPath().add(path);
		assertThat(path.getOrigin(), not(EcorePackage.Literals.EPACKAGE));
	}

} //ModelAutoCreateTest
