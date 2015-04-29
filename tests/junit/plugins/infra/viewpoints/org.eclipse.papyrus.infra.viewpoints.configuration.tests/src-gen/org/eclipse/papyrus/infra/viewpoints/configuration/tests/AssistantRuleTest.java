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

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.infra.viewpoints.configuration.AssistantRule;
import org.eclipse.papyrus.infra.viewpoints.configuration.ConfigurationFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Assistant Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 * <li>{@link org.eclipse.papyrus.infra.viewpoints.configuration.AssistantRule#matches(org.eclipse.gmf.runtime.emf.type.core.IElementType)
 * <em>Matches</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class AssistantRuleTest extends RuleTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(AssistantRuleTest.class);
	}

	/**
	 * Constructs a new Assistant Rule test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public AssistantRuleTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Assistant Rule test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected AssistantRule getFixture() {
		return (AssistantRule)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(ConfigurationFactory.eINSTANCE.createAssistantRule());
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
	 * Tests the '{@link org.eclipse.papyrus.infra.viewpoints.configuration.AssistantRule#matches(org.eclipse.gmf.runtime.emf.type.core.IElementType)
	 * <em>Matches</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.AssistantRule#matches(org.eclipse.gmf.runtime.emf.type.core.IElementType)
	 * @generated NOT
	 */
	public void testMatches__IElementType() {
		IElementType elementType = mockElementType("test.element.type.Foo");

		// No ID pattern: matches any element type
		assertThat(getFixture().matches(elementType), is(true));

		// Exact ID match
		getFixture().setElementTypeID("test.element.type.Foo");
		assertThat(getFixture().matches(elementType), is(true));

		// Exact ID mismatch
		getFixture().setElementTypeID("test.element.type.Bar");
		assertThat(getFixture().matches(elementType), is(false));

		// Wildcard ID match
		getFixture().setElementTypeID("test.element.type.*");
		assertThat(getFixture().matches(elementType), is(true));

		// Wildcard ID mismatch
		getFixture().setElementTypeID("test.element.junk.*");
		assertThat(getFixture().matches(elementType), is(false));

		// Prefix wildcard ID match
		getFixture().setElementTypeID("*.Foo");
		assertThat(getFixture().matches(elementType), is(true));

		// Prefix wildcard ID mis match
		getFixture().setElementTypeID("*.Bar");
		assertThat(getFixture().matches(elementType), is(false));
	}

	IElementType mockElementType(final String id) {
		return (IElementType)Proxy.newProxyInstance(getClass().getClassLoader(), new Class<?>[]{ IElementType.class }, new InvocationHandler() {

			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				if(method.getDeclaringClass().equals(Object.class)) {
					return method.invoke(this, args);
				} else if((method.getDeclaringClass() == IElementType.class) && method.getName().equals("getId")) {
					return id;
				}

				return null;
			}
		});
	}
} //AssistantRuleTest
