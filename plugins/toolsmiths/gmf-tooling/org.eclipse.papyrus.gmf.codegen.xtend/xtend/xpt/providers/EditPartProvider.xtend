/*******************************************************************************
 * Copyright (c) 2007, 2020 Borland Software Corporation, CEA LIST, Artal and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/ 
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors: 
 *    Dmitry Stadnik (Borland) - initial API and implementation
 * 	  Michael Golubev (Montages) - API extracted to GMF-T runtime, migrated to Xtend2 
 */
package xpt.providers

import com.google.inject.Inject
import org.eclipse.papyrus.gmf.codegen.gmfgen.GenDiagram
import xpt.Common
import xpt.editor.VisualIDRegistry
import xpt.diagram.editparts.EditPartFactory

@com.google.inject.Singleton class EditPartProvider {
	@Inject extension Common;

	@Inject VisualIDRegistry xptVisualIDRegistry;
	@Inject EditPartFactory xptEditPartFactory;
	
	def className(GenDiagram it) '''«it.editPartProviderClassName»'''

	def packageName(GenDiagram it) '''«it.providersPackageName»'''

	def qualifiedClassName(GenDiagram it) '''«packageName(it)».«className(it)»'''

	def fullPath(GenDiagram it) '''«qualifiedClassName(it)»'''

	def EditPartProvider(GenDiagram it) '''
		«copyright(editorGen)»
		package «packageName(it)»;
		
		«generatedClassComment»
		public class «className(it)» «extendsList(it)» {
		
			«constructor(it)»
		
			«additions(it)»
		}
	'''

	def extendsList(GenDiagram it) '''extends org.eclipse.gmf.tooling.runtime.providers.DefaultEditPartProvider'''

	def implementsList(GenDiagram it) ''''''

	def constructor(GenDiagram it) '''
		«generatedMemberComment»
		public «className(it)»() {
			super(new «xptEditPartFactory.qualifiedClassName(it)»(), «»
				«xptVisualIDRegistry.runtimeTypedInstanceCall(it)», «»
				«xptEditPartFactory.getEditPartQualifiedClassName(it)».MODEL_ID			
			);
		}
	'''

	def additions(GenDiagram it) ''''''

}
