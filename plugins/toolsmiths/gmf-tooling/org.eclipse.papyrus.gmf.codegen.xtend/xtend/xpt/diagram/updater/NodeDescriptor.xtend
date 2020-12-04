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
 *    Alexander Shatalin (Borland) - initial API and implementation
 *    Michael Golubev (Montages) - API extracted to gmf.tooling.runtime (#372479)  	  
 *                               - #386838 - migrate to Xtend2
 *    Aurelien Didier (ARTAL) - aurelien.didier51@gmail.com - Bug 569174
 *****************************************************************************/
package xpt.diagram.updater

import com.google.inject.Inject
import org.eclipse.papyrus.gmf.codegen.gmfgen.GenDiagramUpdater
import xpt.Common

@com.google.inject.Singleton class NodeDescriptor {
	@Inject extension Common;

	def className(GenDiagramUpdater it) '''«nodeDescriptorClassName»'''
	
	def packageName(GenDiagramUpdater it) '''«it.editorGen.editor.packageName»'''

	def qualifiedClassName(GenDiagramUpdater it) '''«packageName(it)».«className(it)»'''

	def fullPath(GenDiagramUpdater it) '''«qualifiedClassName(it)»'''

	def NodeDescriptor(GenDiagramUpdater it) '''
		«copyright(editorGen)»
		package «packageName(it)»;
		
		«generatedClassComment»
		public class «className(it)» «extendsList(it)» {
			«constructor(it)»
		
			«additions(it)»
		}
	'''

	def extendsList(GenDiagramUpdater it) '''extends org.eclipse.gmf.tooling.runtime.update.UpdaterNodeDescriptor'''

	def constructor(GenDiagramUpdater it) '''
		«generatedMemberComment»
		public «className(it)»(org.eclipse.emf.ecore.EObject modelElement, int visualID) {
			super(modelElement, visualID);
		}
	'''

	def additions(GenDiagramUpdater it) ''''''
}
