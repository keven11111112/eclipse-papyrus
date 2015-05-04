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
import static org.hamcrest.MatcherAssert.assertThat;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.papyrus.infra.viewpoints.configuration.ChildRule;
import org.eclipse.papyrus.infra.viewpoints.configuration.ConfigurationFactory;
import org.eclipse.papyrus.infra.viewpoints.configuration.PathElement;

import junit.framework.TestCase;
import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Path Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 * <li>{@link org.eclipse.papyrus.infra.viewpoints.configuration.PathElement#getOrigin() <em>Origin</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.viewpoints.configuration.PathElement#getTarget() <em>Target</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class PathElementTest extends TestCase {

	/**
	 * The fixture for this Path Element test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected PathElement fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(PathElementTest.class);
	}

	/**
	 * Constructs a new Path Element test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public PathElementTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Path Element test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void setFixture(PathElement fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Path Element test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected PathElement getFixture() {
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
		ChildRule childRule = ConfigurationFactory.eINSTANCE.createChildRule();
		childRule.setOrigin(EcorePackage.Literals.EATTRIBUTE);

		// Set a type.ePackage.eAnnotations.references path
		PathElement path = ConfigurationFactory.eINSTANCE.createPathElement();
		path.setFeature(EcorePackage.Literals.EATTRIBUTE__EATTRIBUTE_TYPE);
		childRule.getInsertionPath().add(path);
		path = ConfigurationFactory.eINSTANCE.createPathElement();
		path.setFeature(EcorePackage.Literals.ECLASSIFIER__EPACKAGE);
		childRule.getInsertionPath().add(path);
		path = ConfigurationFactory.eINSTANCE.createPathElement();
		path.setFeature(EcorePackage.Literals.EMODEL_ELEMENT__EANNOTATIONS);
		childRule.getInsertionPath().add(path);

		PathElement fixture = ConfigurationFactory.eINSTANCE.createPathElement();
		fixture.setFeature(EcorePackage.Literals.EANNOTATION__REFERENCES);
		childRule.getInsertionPath().add(fixture);

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
	 * Tests the '{@link org.eclipse.papyrus.infra.viewpoints.configuration.PathElement#getOrigin() <em>Origin</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.PathElement#getOrigin()
	 * @generated NOT
	 */
	public void testGetOrigin() {
		assertThat(getFixture().getOrigin(), is(EcorePackage.Literals.EANNOTATION));
	}

	/**
	 * Tests the '{@link org.eclipse.papyrus.infra.viewpoints.configuration.PathElement#getTarget() <em>Target</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.PathElement#getTarget()
	 * @generated NOT
	 */
	public void testGetTarget() {
		assertThat(getFixture().getTarget(), is(EcorePackage.Literals.EOBJECT));
	}

} //PathElementTest
