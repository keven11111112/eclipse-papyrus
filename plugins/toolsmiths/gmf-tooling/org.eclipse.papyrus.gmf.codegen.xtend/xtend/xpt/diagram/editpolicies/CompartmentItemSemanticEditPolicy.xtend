/*******************************************************************************
 * Copyright (c) 2006-2020 Borland Software Corporation, CEA LIST, Artal and others
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
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 *    Aurelien Didier (ARTAL) - aurelien.didier51@gmail.com - Bug 569174
 *****************************************************************************/
package xpt.diagram.editpolicies

import com.google.inject.Inject
import org.eclipse.papyrus.gmf.codegen.gmfgen.GenCompartment
import xpt.Common

@com.google.inject.Singleton class CompartmentItemSemanticEditPolicy {
	@Inject extension Common;

	@Inject childContainerCreateCommand xptChildContainerCreateCommand;
	@Inject BaseItemSemanticEditPolicy xptBaseItemSemanticEditPolicy;

	def className(GenCompartment it) '''«it.itemSemanticEditPolicyClassName»'''

	def packageName(GenCompartment it) '''«it.getDiagram().editPoliciesPackageName»'''

	def qualifiedClassName(GenCompartment it) '''«packageName(it)».«className(it)»'''

	def fullPath(GenCompartment it) '''«qualifiedClassName(it)»'''

	def CompartmentItemSemanticEditPolicy(GenCompartment it) '''
		«copyright(getDiagram().editorGen)»
		package «packageName(it)»;
		
		«generatedClassComment()»
		public class «className(it)» extends «xptBaseItemSemanticEditPolicy.qualifiedClassName(getDiagram())» {
		
			«_constructor(it)»
		
			«xptChildContainerCreateCommand.childContainerCreateCommand(it.childNodes)»
			
			«additions(it)»
		}
	'''

	def _constructor(GenCompartment it) '''
		«generatedMemberComment()»
		public «className(it)»() {
			«xptBaseItemSemanticEditPolicy.defaultConstructorBody(node)»
		}
	'''

	def additions(GenCompartment it) ''''''
}
