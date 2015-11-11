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
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.aof.core.IBox;
import org.eclipse.papyrus.aof.core.IFactory;
import org.eclipse.papyrus.aof.core.IOne;
import org.eclipse.papyrus.aof.sync.From;
import org.eclipse.papyrus.aof.sync.ICorrespondenceResolver;
import org.eclipse.papyrus.aof.sync.IMapping;
import org.eclipse.papyrus.aof.sync.To;
import org.eclipse.papyrus.aof.sync.emf.EMFMapping;
import org.eclipse.papyrus.aof.sync.emf.EMFMappingModule;
import org.eclipse.papyrus.aof.sync.emf.syncmapping.MappingModel;
import org.eclipse.papyrus.aof.sync.emf.syncmapping.SyncMappingFactory;
import org.eclipse.papyrus.aof.sync.emf.syncmapping.SyncMappingPackage;
import org.eclipse.papyrus.aof.sync.emf.syncmapping.util.SyncMappingResource;
import org.eclipse.papyrus.aof.sync.tests.runners.TestScoped;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.resource.UMLResource;

import com.google.inject.Provides;

/**
 * Guice configuration of a simple UML-to-Ecore for testing.
 */
public class UML2EcoreMappingModule extends EMFMappingModule {

	public UML2EcoreMappingModule() {
		super();
	}

	public java.lang.Class<? extends IMapping<Package, EPackage>> getPackageMappingBinding() {
		return PackageMapping.class;
	}

	public java.lang.Class<? extends IMapping<Class, EClass>> getClassMappingBinding() {
		return ClassMapping.class;
	}

	@Provides
	public UMLFactory provideUMLFactory() {
		return UMLFactory.eINSTANCE;
	}

	@Provides
	public EcoreFactory provideEcoreFactory() {
		return EcoreFactory.eINSTANCE;
	}

	@Provides
	public ICorrespondenceResolver<Class, EClass, EPackage> provideEClassCorrespondence() {
		return UML2EcoreMappingModule::getCorrespondingEClass;
	}

	@Provides
	@From
	@TestScoped
	public Package provideFromPackage(@From Resource resource) {
		return (Package) resource.getContents().get(0);
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
	public Class provideFromClass(@From Resource resource) {
		return (Class) ((Package) resource.getContents().get(0)).getOwnedType("From");
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
	public SyncMappingResource provideSyncMappingResource(TransactionalEditingDomain domain) {
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
	public Resource provideFromResource(TransactionalEditingDomain domain, UMLFactory uml) {
		URI uri = URI.createURI("test:/from.uml", true);
		ResourceSet rset = domain.getResourceSet();
		Resource result = rset.getResource(uri, false);
		if (result == null) {
			rset.getResourceFactoryRegistry().getExtensionToFactoryMap().put(UMLResource.FILE_EXTENSION, UMLResource.Factory.INSTANCE);
			result = rset.createResource(uri);

			Package package_ = uml.createPackage();
			package_.setName("from");
			package_.setURI(uri.toString());

			Class from = uml.createClass();
			from.setName("From");
			package_.getPackagedElements().add(from);

			domain.getCommandStack().execute(new AddCommand(domain, result.getContents(), package_));
		}

		return result;
	}

	@Provides
	@To
	@TestScoped
	public Resource provideToResource(TransactionalEditingDomain domain, EcoreFactory ecore) {
		URI uri = URI.createURI("test:/to.ecore", true);
		ResourceSet rset = domain.getResourceSet();
		Resource result = rset.getResource(uri, false);
		if (result == null) {
			rset.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
			result = rset.createResource(uri);

			EPackage epackage = ecore.createEPackage();
			epackage.setName("to");
			epackage.setNsURI(uri.toString());

			EClass from = ecore.createEClass();
			from.setName("To");
			epackage.getEClassifiers().add(from);

			Resource resource = result;
			domain.getCommandStack().execute(new RecordingCommand(domain, "Initialize \"to\" Fixture") {

				@Override
				protected void doExecute() {
					resource.getContents().add(epackage);
				}
			});
		}

		return result;
	}

	static EClass getCorrespondingEClass(Class umlclass, EPackage inPackage) {
		String lookFor = umlclass.getName();

		EClass result = (EClass) inPackage.getEClassifier(lookFor);
		if (result == null) {
			String specialCase = specialCaseToLookFor(lookFor);
			if (specialCase != null) {
				result = (EClass) inPackage.getEClassifier(specialCase);
			}
			if (result == null) {
				result = (EClass) EcoreUtil.create(umlclass.eClass());
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

	static class PackageMapping extends EMFMapping<Package, EPackage> {

		@Inject
		private ICorrespondenceResolver<Class, EClass, EPackage> classResolver;

		@Inject
		private IMapping<Class, EClass> classMapping;

		@Inject
		public PackageMapping(@From IFactory fromFactory, @To IFactory toFactory) {
			super(UMLPackage.Literals.PACKAGE, fromFactory, EcorePackage.Literals.EPACKAGE, toFactory);
		}

		@Override
		protected void mapProperties(IOne<Package> from, IOne<EPackage> to) {
			IBox<Class> fromClasses = property(from, UMLPackage.Literals.PACKAGE, UMLPackage.Literals.PACKAGE__PACKAGED_ELEMENT).select(Class.class);
			IBox<EClass> toClasses = property(to, EcorePackage.Literals.EPACKAGE, EcorePackage.Literals.EPACKAGE__ECLASSIFIERS).select(EClass.class);

			mapCorresponding(fromClasses, toClasses, to, EcorePackage.Literals.EPACKAGE__ECLASSIFIERS,
					classResolver, classMapping);
		}
	}

	static class ClassMapping extends EMFMapping<Class, EClass> {

		@Inject
		public ClassMapping(@From IFactory fromFactory, @To IFactory toFactory) {
			super(UMLPackage.Literals.PACKAGE, fromFactory, EcorePackage.Literals.ECLASS, toFactory);
		}

		@Override
		protected void mapProperties(IOne<Class> from, IOne<EClass> to) {
			bindProperty(from, UMLPackage.Literals.NAMED_ELEMENT__NAME, to, EcorePackage.Literals.ENAMED_ELEMENT__NAME);
			bindProperty(from, UMLPackage.Literals.CLASSIFIER__IS_ABSTRACT, to, EcorePackage.Literals.ECLASS__ABSTRACT);
		}
	}

}
