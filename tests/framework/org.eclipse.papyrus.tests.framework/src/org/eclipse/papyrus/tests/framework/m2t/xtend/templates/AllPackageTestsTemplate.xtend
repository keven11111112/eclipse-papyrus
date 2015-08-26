/*******************************************************************************
 * Copyright (c) 2014, 2015 CEA LIST, Christian W. Damus, and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   Christian W. Damus - bug 464647
 *     
 ******************************************************************************/
package org.eclipse.papyrus.tests.framework.m2t.xtend.templates

import java.util.List
import javax.inject.Inject

/**
 * Code generation template for the all-tests suite of a test package.  Also used for the top-level all-tests
 * suite that aggregates the suite for each package.
 */
class AllPackageTestsTemplate {
    @Inject extension TemplateQueries
    @Inject extension Importator
    
	def generate(String className, String packageName, List<String> classes ) '''
		«javaHeader»
		package «packageName»;

		«markImports()»
		
		/**
		 * All test in canonical package
		 */
		@«imported('org.junit.runner.RunWith')»(«imported('org.eclipse.papyrus.junit.framework.classification.ClassificationSuite')».class)
		@«imported('org.junit.runners.Suite.SuiteClasses')»({
		«FOR String clazz : classes»
		«imported(clazz)».class,
		«ENDFOR»	
		})
		@«imported('org.eclipse.papyrus.junit.framework.classification.GeneratedTest')»
		public class «className» {
		}
	'''
}
