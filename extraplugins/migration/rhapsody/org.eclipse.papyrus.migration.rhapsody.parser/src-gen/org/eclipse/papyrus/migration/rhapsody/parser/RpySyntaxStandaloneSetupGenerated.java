/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/
package org.eclipse.papyrus.migration.rhapsody.parser;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.ISetup;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Generated from StandaloneSetup.xpt!
 */
@SuppressWarnings("all")
public class RpySyntaxStandaloneSetupGenerated implements ISetup {

	@Override
	public Injector createInjectorAndDoEMFRegistration() {
		org.eclipse.xtext.common.TerminalsStandaloneSetup.doSetup();

		Injector injector = createInjector();
		register(injector);
		return injector;
	}
	
	public Injector createInjector() {
		return Guice.createInjector(new org.eclipse.papyrus.migration.rhapsody.parser.RpySyntaxRuntimeModule());
	}
	
	public void register(Injector injector) {
	if (!EPackage.Registry.INSTANCE.containsKey("http://www.eclipse.org/papyrus/rhapsody/RpySyntax")) {
		EPackage.Registry.INSTANCE.put("http://www.eclipse.org/papyrus/rhapsody/RpySyntax", org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpySyntaxPackage.eINSTANCE);
	}

		org.eclipse.xtext.resource.IResourceFactory resourceFactory = injector.getInstance(org.eclipse.xtext.resource.IResourceFactory.class);
		org.eclipse.xtext.resource.IResourceServiceProvider serviceProvider = injector.getInstance(org.eclipse.xtext.resource.IResourceServiceProvider.class);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("cmp", resourceFactory);
		org.eclipse.xtext.resource.IResourceServiceProvider.Registry.INSTANCE.getExtensionToFactoryMap().put("cmp", serviceProvider);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("sbs", resourceFactory);
		org.eclipse.xtext.resource.IResourceServiceProvider.Registry.INSTANCE.getExtensionToFactoryMap().put("sbs", serviceProvider);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("dat", resourceFactory);
		org.eclipse.xtext.resource.IResourceServiceProvider.Registry.INSTANCE.getExtensionToFactoryMap().put("dat", serviceProvider);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("omd", resourceFactory);
		org.eclipse.xtext.resource.IResourceServiceProvider.Registry.INSTANCE.getExtensionToFactoryMap().put("omd", serviceProvider);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("msc", resourceFactory);
		org.eclipse.xtext.resource.IResourceServiceProvider.Registry.INSTANCE.getExtensionToFactoryMap().put("msc", serviceProvider);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("rpy", resourceFactory);
		org.eclipse.xtext.resource.IResourceServiceProvider.Registry.INSTANCE.getExtensionToFactoryMap().put("rpy", serviceProvider);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("clb", resourceFactory);
		org.eclipse.xtext.resource.IResourceServiceProvider.Registry.INSTANCE.getExtensionToFactoryMap().put("clb", serviceProvider);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ucd", resourceFactory);
		org.eclipse.xtext.resource.IResourceServiceProvider.Registry.INSTANCE.getExtensionToFactoryMap().put("ucd", serviceProvider);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("cls", resourceFactory);
		org.eclipse.xtext.resource.IResourceServiceProvider.Registry.INSTANCE.getExtensionToFactoryMap().put("cls", serviceProvider);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ctd", resourceFactory);
		org.eclipse.xtext.resource.IResourceServiceProvider.Registry.INSTANCE.getExtensionToFactoryMap().put("ctd", serviceProvider);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("pld", resourceFactory);
		org.eclipse.xtext.resource.IResourceServiceProvider.Registry.INSTANCE.getExtensionToFactoryMap().put("pld", serviceProvider);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("std", resourceFactory);
		org.eclipse.xtext.resource.IResourceServiceProvider.Registry.INSTANCE.getExtensionToFactoryMap().put("std", serviceProvider);
		


	}
}
