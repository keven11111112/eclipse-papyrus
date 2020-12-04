/******************************************************************************
 * Copyright (c) 2014, 2020 Borland Software Corporation, CEA LIST, Artal and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/ 
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors: 
 *    Svyatoslav Kovalsky (Montages) - initial API and implementation
 *    Aurelien Didier (ARTAL) - aurelien.didier51@gmail.com - Bug 569174
 *****************************************************************************/
package xpt

import com.google.inject.Inject
import org.eclipse.papyrus.gmf.codegen.gmfgen.GenDiagram
import org.eclipse.papyrus.gmf.codegen.gmfgen.GenCommonBase
import org.eclipse.papyrus.gmf.codegen.gmfgen.GenNode
import org.eclipse.papyrus.gmf.codegen.gmfgen.GenLink
import org.eclipse.papyrus.gmf.codegen.gmfgen.GenCompartment
import xpt.diagram.editpolicies.CompartmentItemSemanticEditPolicy
import xpt.diagram.editpolicies.DiagramItemSemanticEditPolicy
import xpt.diagram.editpolicies.LinkItemSemanticEditPolicy
import xpt.diagram.editpolicies.NodeItemSemanticEditPolicy
import xpt.diagram.commands.CreateNodeCommand
import xpt.diagram.commands.CreateLinkCommand

@com.google.inject.Singleton class QualifiedClassNameProvider {

	@Inject CompartmentItemSemanticEditPolicy compItemSemantic;
	@Inject DiagramItemSemanticEditPolicy diagramItemSemantic;
	@Inject LinkItemSemanticEditPolicy linkItemSemantic;
	@Inject NodeItemSemanticEditPolicy nodeItemSemantic;
	
	@Inject CreateLinkCommand linkCommand
	@Inject CreateNodeCommand nodeCommand
	
	def dispatch getItemSemanticEditPolicyQualifiedClassName(GenCommonBase it) ''''''
	def dispatch getItemSemanticEditPolicyQualifiedClassName(GenDiagram it) '''«diagramItemSemantic.qualifiedClassName(it)»'''
	def dispatch getItemSemanticEditPolicyQualifiedClassName(GenCompartment it) '''«compItemSemantic.qualifiedClassName(it)»'''
	def dispatch getItemSemanticEditPolicyQualifiedClassName(GenLink it) '''«linkItemSemantic.qualifiedClassName(it)»'''
	def dispatch getItemSemanticEditPolicyQualifiedClassName(GenNode it) '''«nodeItemSemantic.qualifiedClassName(it)»'''
	
	def dispatch getItemSemanticEditPolicyClassName(GenCommonBase it) ''''''
	def dispatch getItemSemanticEditPolicyClassName(GenDiagram it) '''«diagramItemSemantic.className(it)»'''
	def dispatch getItemSemanticEditPolicyClassName(GenCompartment it) '''«compItemSemantic.className(it)»'''
	def dispatch getItemSemanticEditPolicyClassName(GenLink it) '''«linkItemSemantic.className(it)»'''
	def dispatch getItemSemanticEditPolicyClassName(GenNode it) '''«nodeItemSemantic.className(it)»'''
	
	def dispatch getCreateCommandQualifiedClassName(GenCommonBase it) ''''''
	def dispatch getCreateCommandQualifiedClassName(GenNode it) '''«nodeCommand.qualifiedClassName(it)»'''
	def dispatch getCreateCommandQualifiedClassName(GenLink it) '''«linkCommand.qualifiedClassName(it)»'''
}