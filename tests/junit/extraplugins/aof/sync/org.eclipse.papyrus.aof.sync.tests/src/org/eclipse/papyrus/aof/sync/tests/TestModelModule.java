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

import javax.inject.Named;

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
import org.eclipse.papyrus.aof.sync.From;
import org.eclipse.papyrus.aof.sync.ICorrespondenceResolver;
import org.eclipse.papyrus.aof.sync.ISyncCorrespondenceResolver;
import org.eclipse.papyrus.aof.sync.MappingModule;
import org.eclipse.papyrus.aof.sync.To;
import org.eclipse.papyrus.aof.sync.tests.runners.TestScoped;

import com.google.inject.Provides;

/**
 * A Guice module for injection of dependencies into mapping-related tests.
 */
public class TestModelModule extends MappingModule {

	public TestModelModule() {
		super();
	}

	@Override
	protected IFactory getDefaultFactory() {
		return EMFFactory.INSTANCE;
	}

	@Provides
	@TestScoped
	public EPackage provideEPackage() {
		EPackage epackage = EcoreFactory.eINSTANCE.createEPackage();
		epackage.setName("test");
		return epackage;
	}

	@Provides
	@TestScoped
	public EFactory provideEFactory(EPackage ePackage) {
		return ePackage.getEFactoryInstance();
	}

	@Provides
	@TestScoped
	public EClass providePersonClass(EPackage ePackage) {
		EClass person = EcoreFactory.eINSTANCE.createEClass();
		person.setName("Person");
		ePackage.getEClassifiers().add(person);
		return person;
	}

	@Provides
	@TestScoped
	@Named("name")
	public EAttribute provideNameAttribute(EClass person) {
		EAttribute name = EcoreFactory.eINSTANCE.createEAttribute();
		name.setName("name");
		name.setEType(EcorePackage.Literals.ESTRING);
		person.getEStructuralFeatures().add(name);
		return name;
	}

	@Provides
	@TestScoped
	public EAttribute provideAgeAttribute(EClass person) {
		EAttribute age = EcoreFactory.eINSTANCE.createEAttribute();
		age.setName("age");
		age.setEType(EcorePackage.Literals.EINT);
		person.getEStructuralFeatures().add(age);
		return age;
	}

	@Provides
	@TestScoped
	public EReference provideAcquaintancesReference(EClass person) {
		EReference acquaintances = EcoreFactory.eINSTANCE.createEReference();
		acquaintances.setName("acquaintances");
		acquaintances.setEType(person);
		acquaintances.setLowerBound(0);
		acquaintances.setUpperBound(ETypedElement.UNBOUNDED_MULTIPLICITY);
		person.getEStructuralFeatures().add(acquaintances);
		return acquaintances;
	}

	@Provides
	@TestScoped
	@From
	public EObject provideFromPerson(EClass person, @Named("name") EAttribute name, EReference acquaintances) {
		EObject result = create(person, name, "From");

		@SuppressWarnings("unchecked")
		EList<EObject> fromsAcquaintances = (EList<EObject>) result.eGet(acquaintances);
		EObject alice = create(person, name, "Alice");
		EObject betty = create(person, name, "Betty");
		EObject caroline = create(person, name, "Caroline");
		ECollections.setEList(fromsAcquaintances, Arrays.asList(alice, betty, caroline));

		return result;
	}

	@Provides
	@TestScoped
	@To
	public EObject provideToPerson(EClass person, @Named("name") EAttribute name, EReference acquaintances) {
		EObject result = create(person, name, "To");

		return result;
	}

	@Provides
	public ICorrespondenceResolver<EObject, EObject, EObject> providePersonCorrespondence(EClass person, @Named("name") EAttribute name, EReference acquaintances) {
		ISyncCorrespondenceResolver<EObject, EObject> correspondence = (element, context) -> {
			@SuppressWarnings("unchecked")
			EList<EObject> list = (EList<EObject>) context.eGet(acquaintances);
			return list.stream()
					.filter(e -> Objects.equals(e.eGet(name), element.eGet(name)))
					.findFirst()
					.orElseGet(() -> create(person, name, element.eGet(name)));
		};

		return correspondence;
	}

	static EObject create(EClass eclass, Object... features) {
		EObject result = EcoreUtil.create(eclass);

		for (int i = 0; i < features.length; i += 2) {
			result.eSet((EStructuralFeature) features[i], features[i + 1]);
		}

		return result;
	}
}
