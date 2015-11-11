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
import javax.inject.Provider;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.aof.core.IBox;
import org.eclipse.papyrus.aof.core.IFactory;
import org.eclipse.papyrus.aof.core.IOne;
import org.eclipse.papyrus.aof.sync.From;
import org.eclipse.papyrus.aof.sync.ICorrespondenceResolver;
import org.eclipse.papyrus.aof.sync.IMapping;
import org.eclipse.papyrus.aof.sync.To;
import org.eclipse.papyrus.aof.sync.emf.EMFMappingModule;
import org.eclipse.papyrus.aof.sync.emf.EMFSyncMapping;
import org.eclipse.papyrus.aof.sync.emf.syncmapping.MappingModel;
import org.eclipse.papyrus.aof.sync.emf.syncmapping.SyncMappingFactory;
import org.eclipse.papyrus.aof.sync.emf.syncmapping.SyncMappingPackage;
import org.eclipse.papyrus.aof.sync.emf.syncmapping.util.SyncMappingResource;
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

		bind(new TypeLiteral<IMapping<EClass, EClass>>() {
		}).annotatedWith(Names.named("unused")).to(EClassMapping.class);
	}

	public Class<? extends IMapping<EPackage, EPackage>> getEPackageMappingBinding() {
		return EPackageMapping.class;
	}

	public Class<? extends IMapping<EClass, EClass>> getEClassMappingBinding() {
		return EClassMapping.class;
	}

	@Provides
	public EcoreFactory provideEcoreFactory() {
		return EcoreFactory.eINSTANCE;
	}

	@Provides
	public ICorrespondenceResolver<EClass, EClass, EPackage> provideEClassCorrespondence() {
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

	@Override
	@TestScoped
	public Provider<? extends EditingDomain> getEditingDomainBinding() {
		return TransactionalEditingDomain.Factory.INSTANCE::createEditingDomain;
	}

	@Provides
	@TestScoped
	public SyncMappingResource provideSyncMappingResource(EditingDomain domain) {
		URI uri = URI.createURI("sync:/test.syncmapping", true);
		ResourceSet rset = domain.getResourceSet();
		SyncMappingResource result = (SyncMappingResource) rset.getResource(uri, false);
		if (result == null) {
			rset.getResourceFactoryRegistry().getExtensionToFactoryMap().put(SyncMappingResource.FILE_EXTENSION, SyncMappingResource.Factory.INSTANCE);
			result = (SyncMappingResource) rset.createResource(uri);

			MappingModel model = SyncMappingFactory.eINSTANCE.createMappingModel();
			domain.getCommandStack().execute(new AddCommand(domain, result.getContents(), model));
		}

		return result;
	}

	@Provides
	@TestScoped
	public MappingModel provideMappingModel(SyncMappingResource resource) {
		return (MappingModel) EcoreUtil.getObjectByType(resource.getContents(), SyncMappingPackage.Literals.MAPPING_MODEL);
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

			domain.getCommandStack().execute(new AddCommand(domain, result.getContents(), epackage));
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

	static class EPackageMapping extends EMFSyncMapping<EPackage> {

		@Inject
		private ICorrespondenceResolver<EClass, EClass, EPackage> eclassResolver;

		@Inject
		private IMapping<EClass, EClass> eclassMapping;

		@Inject
		public EPackageMapping(IFactory factory) {
			super(EcorePackage.Literals.EPACKAGE, factory);
		}

		@Override
		protected void mapProperties(IOne<EPackage> from, IOne<EPackage> to) {
			EReference ref = EcorePackage.Literals.EPACKAGE__ECLASSIFIERS;
			IBox<EClass> fromClasses = property(from, ref).select(EClass.class);
			IBox<EClass> toClasses = property(to, ref).select(EClass.class);

			mapCorresponding(fromClasses, toClasses, to, ref, eclassResolver, eclassMapping);
		}
	}

	static class EClassMapping extends EMFSyncMapping<EClass> {

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
