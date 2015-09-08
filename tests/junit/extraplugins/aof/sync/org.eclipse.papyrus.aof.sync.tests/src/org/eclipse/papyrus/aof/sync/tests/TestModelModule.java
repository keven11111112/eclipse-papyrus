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

import java.util.Arrays;
import java.util.Objects;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.aof.core.IFactory;
import org.eclipse.papyrus.aof.emf.EMFFactory;
import org.eclipse.papyrus.aof.sync.ICorrespondenceResolver;
import org.eclipse.papyrus.aof.sync.tests.AbstractTest.From;
import org.eclipse.papyrus.aof.sync.tests.AbstractTest.To;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;

/**
 * A Guice module for injection of dependencies into mapping-related tests.
 */
public class TestModelModule extends AbstractModule {

	public TestModelModule() {
		super();
	}

	@Override
	protected void configure() {
		bind(IFactory.class).toInstance(EMFFactory.INSTANCE);

		EPackage epackage = EcoreFactory.eINSTANCE.createEPackage();
		epackage.setName("test");
		bind(EPackage.class).toInstance(epackage);
		bind(EFactory.class).toInstance(epackage.getEFactoryInstance());

		EClass person = EcoreFactory.eINSTANCE.createEClass();
		person.setName("Person");
		epackage.getEClassifiers().add(person);
		bind(EClass.class).toInstance(person);

		EAttribute name = EcoreFactory.eINSTANCE.createEAttribute();
		name.setName("name");
		name.setEType(EcorePackage.Literals.ESTRING);
		person.getEStructuralFeatures().add(name);

		EAttribute age = EcoreFactory.eINSTANCE.createEAttribute();
		age.setName("age");
		age.setEType(EcorePackage.Literals.EINT);
		person.getEStructuralFeatures().add(age);
		bind(EAttribute.class).toInstance(age);

		EReference acquaintances = EcoreFactory.eINSTANCE.createEReference();
		acquaintances.setName("acquaintances");
		acquaintances.setEType(person);
		acquaintances.setLowerBound(0);
		acquaintances.setUpperBound(ETypedElement.UNBOUNDED_MULTIPLICITY);
		person.getEStructuralFeatures().add(acquaintances);
		bind(EReference.class).toInstance(acquaintances);

		// Create a new "from" instance for every test
		bind(EObject.class).annotatedWith(From.class).toProvider(() -> {
			EObject result = create(person, name, "From");

			@SuppressWarnings("unchecked")
			EList<EObject> fromsAcquaintances = (EList<EObject>) result.eGet(acquaintances);
			EObject alice = create(person, name, "Alice");
			EObject betty = create(person, name, "Betty");
			EObject caroline = create(person, name, "Caroline");
			ECollections.setEList(fromsAcquaintances, Arrays.asList(alice, betty, caroline));

			return result;
		});

		// Create a new "to" instance for every test
		bind(EObject.class).annotatedWith(To.class).toProvider(() -> create(person, name, "To"));

		ICorrespondenceResolver<EObject, EObject> correspondence = (element, context) -> {
			@SuppressWarnings("unchecked")
			EList<EObject> list = (EList<EObject>) context.eGet(acquaintances);
			return list.stream()
					.filter(e -> Objects.equals(e.eGet(name), element.eGet(name)))
					.findFirst()
					.orElseGet(() -> create(person, name, element.eGet(name)));
		};
		bind(new TypeLiteral<ICorrespondenceResolver<EObject, EObject>>() {
		}).toInstance(correspondence);
	}

	static EObject create(EClass eclass, Object... features) {
		EObject result = EcoreUtil.create(eclass);

		for (int i = 0; i < features.length; i += 2) {
			result.eSet((EStructuralFeature) features[i], features[i + 1]);
		}

		return result;
	}
}
