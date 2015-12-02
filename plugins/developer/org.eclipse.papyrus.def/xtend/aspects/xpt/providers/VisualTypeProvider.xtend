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

package aspects.xpt.providers

import javax.inject.Inject
import javax.inject.Singleton
import org.eclipse.gmf.codegen.gmfgen.GenDiagram
import org.eclipse.papyrus.papyrusgmfgenextension.GenVisualTypeProvider
import xpt.CodeStyle
import xpt.Common
import xpt.editor.VisualIDRegistry
import xpt.providers.ElementTypes

/**
 * Template for the class that plugs in knowledge of the Visual IDs of this diagram
 * into the {@code VisualTypeService}.
 */
@Singleton class VisualTypeProvider {
	
	@Inject extension Common
	@Inject extension CodeStyle
	@Inject VisualIDRegistry visualIDs
	@Inject ElementTypes elementTypes
	
	def getPackageName(GenDiagram it) '''«it.providersPackageName»'''
	
	def getClassName(GenDiagram it) '''«GenVisualTypeProvider.getClassName(it)»'''
	
	def getQualifiedClassName(GenDiagram it) '''«packageName».«className»'''
	
	protected def constructor(GenDiagram it) '''
		«generatedMemberComment»
		public «it.className»() {
			super();
		}
	'''

	protected def getElementType_(GenDiagram it) '''
		«generatedMemberComment»
		«overrideI»
		public org.eclipse.gmf.runtime.emf.type.core.IElementType getElementType(org.eclipse.gmf.runtime.notation.Diagram diagram, String viewType) {
			org.eclipse.gmf.runtime.emf.type.core.IElementType result = null;
			
			try {
				result = «elementTypes.qualifiedClassName(it)».getElementType(Integer.parseInt(viewType));
			} catch (NumberFormatException e) {
				// Not supported by this diagram
			}
			
			return result;
		}
	'''

	protected def getNodeType(GenDiagram it) '''
		«generatedMemberComment»
		«overrideI»
		public String getNodeType(View parentView, EObject element) {
			int result = «visualIDs.getNodeVisualIDMethodCall(it)»(parentView, element);
			return (result < 0) ? null : Integer.toString(result);
		}
	'''

	protected def getLinkType(GenDiagram it) '''
		«generatedMemberComment»
		«overrideI»
		public String getLinkType(Diagram diagram, EObject element) {
			int result = «visualIDs.getLinkWithClassVisualIDMethodCall(it)»(element);
			return (result < 0) ? null : Integer.toString(result);
		}
	'''

	public def VisualTypeProvider(GenDiagram it) '''
		«editorGen.copyright»
		package «packageName»;
		
		«generatedClassComment»
		public class «className» extends org.eclipse.papyrus.infra.gmfdiag.common.service.visualtype.AbstractVisualTypeProvider {
		
			«constructor»
			
			«getElementType_»
			
			«getNodeType»
			
			«getLinkType»
			
		}
	'''
}