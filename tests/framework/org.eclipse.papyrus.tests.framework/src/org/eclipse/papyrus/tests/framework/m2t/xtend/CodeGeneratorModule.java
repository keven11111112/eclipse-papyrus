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

package org.eclipse.papyrus.tests.framework.m2t.xtend;

import com.google.inject.AbstractModule;

/**
 * Guice module for the Xtend code generator.
 */
public class CodeGeneratorModule extends AbstractModule {

	public CodeGeneratorModule() {
		super();
	}

	@Override
	protected void configure() {
		bindImportator();
		bindPapyrusDiagramCanonicalTests();

		bindTemplateQueries();
		bindAllPackageTestsTemplate();
		bindAppearanceTestTemplate();
		bindDeleteTestTemplate();
		bindDropTestTemplate();
		bindEditionTestTemplate();
		bindTestChildLabelNodeTestTemplate();
		bindTestLinkTemplate();
		bindTestNodeTemplate();
	}

	protected void bindImportator() {
		// Pass
	}

	private void bindTemplateQueries() {
		// Pass
	}

	protected void bindPapyrusDiagramCanonicalTests() {
		// Pass
	}

	private void bindAllPackageTestsTemplate() {
		// Pass
	}

	private void bindAppearanceTestTemplate() {
		// Pass
	}

	private void bindDeleteTestTemplate() {
		// Pass
	}

	private void bindDropTestTemplate() {
		// Pass
	}

	private void bindEditionTestTemplate() {
		// Pass
	}

	private void bindTestChildLabelNodeTestTemplate() {
		// Pass
	}

	private void bindTestLinkTemplate() {
		// Pass
	}

	private void bindTestNodeTemplate() {
		// Pass
	}

}
