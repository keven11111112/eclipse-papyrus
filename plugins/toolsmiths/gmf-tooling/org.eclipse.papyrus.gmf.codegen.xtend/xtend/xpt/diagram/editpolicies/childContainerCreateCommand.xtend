/*******************************************************************************
 * Copyright (c) 2007, 2020 Borland Software Corporation, CEA LIST, Artal
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
import org.eclipse.papyrus.gmf.codegen.gmfgen.GenNode
import xpt.Common
import xpt.providers.ElementTypes
import xpt.QualifiedClassNameProvider

@com.google.inject.Singleton class childContainerCreateCommand {
	
	@Inject extension Common;
	@Inject extension QualifiedClassNameProvider;
	
	@Inject ElementTypes xptElementTypes;
 
 	def childContainerCreateCommand(Iterable<? extends GenNode> nodes) '''
	«IF !nodes.empty»

	«generatedMemberComment()»
	protected org.eclipse.gef.commands.Command getCreateCommand(org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest req) {
	«FOR n : nodes»		
		«childNodeCreateCommand(n)»
	«ENDFOR»
		return super.getCreateCommand(req);
	}
	«ENDIF»
	'''


	def childNodeCreateCommand(GenNode node) '''
	if («xptElementTypes.accessElementType(node)» == req.getElementType()) {
		return getGEFWrapper(new «getCreateCommandQualifiedClassName(node)»(req));
	}
	'''

}