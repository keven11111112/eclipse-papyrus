/*******************************************************************************
 * Copyright (c) 2006, 2020 Borland Software Corporation, CEA LIST, Artal and others
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
 *    Alexander Shatalin (Borland) - initial API and implementation
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 *    Aurelien Didier (ARTAL) - aurelien.didier51@gmail.com - Bug 569174
 *****************************************************************************/
package diagram.editparts

import com.google.inject.Inject
import impl.diagram.editparts.TextAware
import org.eclipse.papyrus.gmf.codegen.gmfgen.GenLinkLabel
import xpt.Common

@com.google.inject.Singleton class LinkLabelEditPart {
	@Inject extension Common;

	@Inject impl.diagram.editparts.LinkLabelEditPart xptLinkLabelEditPart;
	@Inject TextAware xptTextAware;
	@Inject xpt.diagram.editparts.Common xptEditpartsCommon;

	def qualifiedClassName(GenLinkLabel it) '''«xptLinkLabelEditPart.packageName(it)».«xptLinkLabelEditPart.className(it)»'''

	def fullPath(GenLinkLabel it) '''«qualifiedClassName(it)»'''

	def Main(GenLinkLabel it) '''
		«copyright(getDiagram().editorGen)»
		package «xptLinkLabelEditPart.packageName(it)»;
		
		«generatedClassComment»
		public class «xptLinkLabelEditPart.className(it)» «extendsList(it)» «implementsList(it)» {
		
			«attributes(it)»
			
			«xptLinkLabelEditPart.initializer(it)»
			
			«xptLinkLabelEditPart.constructor(it)»
			
			«createDefaultEditPolicies(it)»
			
			«xptLinkLabelEditPart.getKeyPoint(it)»
			
			«xptTextAware.methods(it, false, readOnly, elementIcon, viewmap, modelFacet, link, getDiagram())»
			
			«handleNotificationEvent(it)»
			
			«xptEditpartsCommon.labelFigure(it.viewmap)»
		
			«additions(it)»
		}
	'''

	def extendsList(GenLinkLabel it) '''extends org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart'''

	def implementsList(GenLinkLabel it) '''implements org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart'''

	def attributes(GenLinkLabel it) '''
		«xptEditpartsCommon.visualIDConstant(it)»
		
		«xptTextAware.fields(it)»
	'''

	def createDefaultEditPolicies(GenLinkLabel it) '''
		«generatedMemberComment»
		protected void createDefaultEditPolicies() {
			«xptLinkLabelEditPart.createDefaultEditPoliciesBody(it)»
		}
	'''

	def handleNotificationEvent(GenLinkLabel it) '''
		«generatedMemberComment»
		protected void handleNotificationEvent(org.eclipse.emf.common.notify.Notification event) {
			«xptLinkLabelEditPart.handleNotificationEventBody(it)»
		}
	'''

	def additions(GenLinkLabel it) ''''''
}
