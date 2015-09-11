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

package org.eclipse.papyrus.aof.sync.emf.tests;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.aof.core.IBox;
import org.eclipse.papyrus.aof.core.IFactory;
import org.eclipse.papyrus.aof.core.IOne;
import org.eclipse.papyrus.aof.sync.AbstractMapping;
import org.eclipse.papyrus.aof.sync.ICorrespondenceResolver;
import org.eclipse.papyrus.aof.sync.IMapping;
import org.eclipse.papyrus.aof.sync.emf.internal.EMFMappingModule;
import org.eclipse.papyrus.aof.sync.tests.AbstractTest.From;
import org.eclipse.papyrus.aof.sync.tests.AbstractTest.To;
import org.eclipse.papyrus.aof.sync.tests.runners.TestScoped;

import com.google.inject.Provides;
import com.google.inject.TypeLiteral;
import com.google.inject.name.Names;

/**
 * Guice configuration of test dependencies.
 */
public class TestFixtureModule extends EMFMappingModule {

	public TestFixtureModule() {
		super();
	}

	@Override
	protected void configure() {
		super.configure();

		bind(new TypeLiteral<IMapping<EClass>>() {
		}).annotatedWith(Names.named("unused")).to(EClassMapping.class);
	}

	public Class<? extends IMapping<EPackage>> getEPackageMappingBinding() {
		return EPackageMapping.class;
	}

	public Class<? extends IMapping<EClass>> getEClassMappingBinding() {
		return EClassMapping.class;
	}

	@Named("ignore me")
	public Class<? extends IMapping<EClass>> getIgnoredBinding() {
		return EClassMapping.class;
	}

	@Provides
	public EcoreFactory provideEcoreFactory() {
		return EcoreFactory.eINSTANCE;
	}

	@Provides
	public ICorrespondenceResolver<EClass, EPackage> provideEClassCorrespondence() {
		return TestFixtureModule::getCorrespondingEClass;
	}

	@Provides
	@From
	@TestScoped
	public EPackage provideFromEPackage(@From Resource resource) {
		return (EPackage) resource.getContents().get(0);
	}

	@Provides
	@To
	@TestScoped
	public EPackage provideToEPackage(@To Resource resource) {
		return (EPackage) resource.getContents().get(0);
	}

	@Provides
	@From
	@TestScoped
	public EClass provideFromEClass(@From Resource resource) {
		return (EClass) ((EPackage) resource.getContents().get(0)).getEClassifier("From");
	}

	@Provides
	@To
	@TestScoped
	public EClass provideToEClass(@To Resource resource) {
		return (EClass) ((EPackage) resource.getContents().get(0)).getEClassifier("To");
	}

	@Provides
	@TestScoped
	public EditingDomain provideEditingDomain() {
		return TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain();
	}

	@Provides
	@From
	@TestScoped
	public Resource provideFromResource(EditingDomain domain, EcoreFactory ecore) {
		return createTestModel(domain, ecore, "from", "From");
	}

	@Provides
	@To
	@TestScoped
	public Resource provideToResource(EditingDomain domain, EcoreFactory ecore) {
		return createTestModel(domain, ecore, "to", "To");
	}

	private Resource createTestModel(EditingDomain domain, EcoreFactory ecore, String packageName, String className) {
		URI uri = URI.createURI(String.format("test:/%s.ecore", packageName), true);
		ResourceSet rset = domain.getResourceSet();
		Resource result = rset.getResource(uri, false);
		if (result == null) {
			rset.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
			result = rset.createResource(uri);

			EPackage epackage = ecore.createEPackage();
			epackage.setName(packageName);
			epackage.setNsURI(uri.toString());

			EClass from = ecore.createEClass();
			from.setName(className);
			epackage.getEClassifiers().add(from);

			Resource resource = result;
			domain.getCommandStack().execute(new RecordingCommand((TransactionalEditingDomain) domain, String.format("Initialize \"%s\" Fixture", packageName)) {

				@Override
				protected void doExecute() {
					resource.getContents().add(epackage);
				}
			});
		}

		return result;
	}

	static EClass getCorrespondingEClass(EClass eclass, EPackage inPackage) {
		String lookFor = eclass.getName();

		EClass result = (EClass) inPackage.getEClassifier(lookFor);
		if (result == null) {
			String specialCase = specialCaseToLookFor(lookFor);
			if (specialCase != null) {
				result = (EClass) inPackage.getEClassifier(specialCase);
			}
			if (result == null) {
				result = (EClass) EcoreUtil.create(eclass.eClass());
				result.setName(lookFor);
				inPackage.getEClassifiers().add(result);
			}
		}
		return result;
	}

	private static String specialCaseToLookFor(String name) {
		String result = null;

		if (name != null) {
			switch (name) {
			case "From":
				result = "To";
				break;
			case "To":
				result = "From";
				break;
			default:
				result = null;
				break;
			}
		}

		return result;
	}

	//
	// Nested types
	//

	static class EPackageMapping extends AbstractMapping<EPackage> {

		@Inject
		private ICorrespondenceResolver<EClass, EPackage> eclassResolver;

		@Inject
		private IMapping<EClass> eclassMapping;

		@Inject
		public EPackageMapping(IFactory factory) {
			super(EcorePackage.Literals.EPACKAGE, factory);
		}

		@Override
		protected void mapProperties(IOne<EPackage> from, IOne<EPackage> to) {
			IBox<EClass> fromClasses = property(from, EcorePackage.Literals.EPACKAGE__ECLASSIFIERS).select(EClass.class);
			IBox<EClass> toClasses = property(to, EcorePackage.Literals.EPACKAGE__ECLASSIFIERS).select(EClass.class);

			mapCorresponding(fromClasses, toClasses, to, eclassResolver, eclassMapping);
		}
	}

	static class EClassMapping extends AbstractMapping<EClass> {

		@Inject
		public EClassMapping(IFactory factory) {
			super(EcorePackage.Literals.ECLASS, factory);
		}

		@Override
		protected void mapProperties(IOne<EClass> from, IOne<EClass> to) {
			bindProperty(from, to, EcorePackage.Literals.ENAMED_ELEMENT__NAME);
			bindProperty(from, to, EcorePackage.Literals.ECLASS__INTERFACE);
			bindProperty(from, to, EcorePackage.Literals.ECLASS__ABSTRACT);
		}
	}

}
