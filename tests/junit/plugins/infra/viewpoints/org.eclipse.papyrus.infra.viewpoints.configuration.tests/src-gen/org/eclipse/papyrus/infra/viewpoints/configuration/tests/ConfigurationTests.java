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

import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.papyrus.infra.viewpoints.configuration.ConfigurationPackage;
import org.eclipse.papyrus.infra.viewpoints.configuration.impl.ConfigurationFactoryCustomImpl;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>configuration</b></em>' package.
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class ConfigurationTests extends TestSuite {

	static {
		final String packageURI = "http://www.eclipse.org/papyrus/infra/viewpoints/configuration";
		EPackage.Registry.INSTANCE.put(packageURI, new EPackage.Descriptor() {

			@Override
			public EPackage getEPackage() {
				return ConfigurationPackage.eINSTANCE;
			}

			@Override
			public EFactory getEFactory() {
				return new ConfigurationFactoryCustomImpl();
			}
		});
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(suite());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static Test suite() {
		TestSuite suite = new ConfigurationTests("configuration Tests");
		suite.addTestSuite(PathElementTest.class);
		suite.addTestSuite(ModelAutoCreateTest.class);
		suite.addTestSuite(AssistantRuleTest.class);
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ConfigurationTests(String name) {
		super(name);
	}

} //ConfigurationTests
