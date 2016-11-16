/*****************************************************************************
 * Copyright (c) 2016 Christian W. Damus and others.
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

package org.eclipse.papyrus.infra.gmfdiag.common.commands.tests;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.infra.gmfdiag.common.commands.CreateEditBasedElementCommand;
import org.eclipse.papyrus.junit.utils.rules.ModelSetFixture;
import org.eclipse.papyrus.junit.utils.rules.PluginResource;
import org.eclipse.papyrus.junit.utils.rules.ServiceRegistryModelSetFixture;
import org.eclipse.papyrus.uml.service.types.element.UMLElementTypes;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

/**
 * Tests for the {@link CreateEditBasedElementCommand} class.
 */
@PluginResource("models/ExpansionModelTest.di")
public class CreateEditBasedElementCommandTest {

	@Rule
	public final ModelSetFixture fixture = new ServiceRegistryModelSetFixture();

	private List<String> invocations = new ArrayList<>();

	@Test
	public void createElement() {
		CreateElementRequest request = new CreateElementRequest(fixture.getModel(), UMLElementTypes.CLASS);
		CreateEditBasedElementCommand command = new CreateEditBasedElementCommand(request);
		assertThat(command.canExecute(), is(true));

		fixture.execute(command);

		// A new class is always given a default name by edit advice
		assertThat(invocations, hasItem("setName"));
	}

	//
	// Test framework
	//

	@Before
	public void installUMLFactory() {
		// Install reflective proxies for the standard package and factory that
		// create reflective proxies for model elements
		ClassLoader cl = getClass().getClassLoader();

		EFactory[] eFactory = { null };
		EPackage[] ePackage = { null };

		ePackage[0] = (EPackage) Proxy.newProxyInstance(cl, new Class[] { UMLPackage.class },
				(__, method, args) -> {
					switch (method.getName()) {
					case "getEFactoryInstance":
					case "getUMLFactory":
						return eFactory[0];
					default:
						return method.invoke(UMLPackage.eINSTANCE, args);
					}
				});
		eFactory[0] = (EFactory) Proxy.newProxyInstance(cl, new Class[] { UMLFactory.class },
				(__, method, args) -> {
					switch (method.getName()) {
					case "getEPackage":
					case "getUMLPackage":
						return ePackage[0];
					case "create":
						EClass eClass = (EClass) args[0];
						EObject realObject = (EObject) method.invoke(UMLFactory.eINSTANCE, args);
						return Proxy.newProxyInstance(cl, new Class[] {
								eClass.getInstanceClass(),
								InternalEObject.class,
						}, (___, method1, args1) -> {
							recordInvocation(method1.getName());
							return method1.invoke(realObject, args1);
						});
					default:
						return method.invoke(UMLFactory.eINSTANCE, args);
					}
				});

		EPackage.Registry registry = fixture.getResourceSet().getPackageRegistry();

		// Replace all registrations of the UML package
		for (Map.Entry<String, Object> next : registry.entrySet()) {
			if (next.getValue() instanceof UMLPackage) {
				next.setValue(ePackage[0]);
			}
		}

		// Just to make sure
		registry.put(ePackage[0].getNsURI(), ePackage[0]);
	}

	void recordInvocation(String methodName) {
		invocations.add(methodName);
	}
}
