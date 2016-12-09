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
package org.eclipse.papyrus.migration.rhapsody.parser.ui;

import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;

import com.google.inject.Injector;

import org.eclipse.papyrus.migration.rhapsody.parser.ui.internal.RpySyntaxActivator;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class RpySyntaxExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return RpySyntaxActivator.getInstance().getBundle();
	}
	
	@Override
	protected Injector getInjector() {
		return RpySyntaxActivator.getInstance().getInjector(RpySyntaxActivator.ORG_ECLIPSE_PAPYRUS_MIGRATION_RHAPSODY_PARSER_RPYSYNTAX);
	}
	
}
