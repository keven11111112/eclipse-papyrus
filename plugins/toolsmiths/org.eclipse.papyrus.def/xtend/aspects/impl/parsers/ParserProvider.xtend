/*****************************************************************************
 * Copyright (c) 2007-2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 * Dmitry Stadnik (Borland) - initial API and implementation
 * Artem Tikhomirov (Borland) - [235113] alternative parser access
 *                                 [244419] custom parsers
 *                                 [138179] expression-backed labels
 * Michael Golubev (Montages) - #386838 - migrate to Xtend2
 * 
 *****************************************************************************/
package aspects.impl.parsers

import com.google.inject.Inject
import com.google.inject.Singleton
import impl.parsers.expression_qvto
import metamodel.MetaModel
import org.eclipse.gmf.codegen.gmfgen.GenChildLabelNode
import org.eclipse.gmf.codegen.gmfgen.GenLink
import org.eclipse.gmf.codegen.gmfgen.GenNode
import org.eclipse.gmf.codegen.gmfgen.GenParsers
import parsers.ExpressionLabelParser
import parsers.PredefinedParser
import plugin.Activator
import xpt.Common
import xpt.Common_qvto
import xpt.editor.VisualIDRegistry
import xpt.expressions.OclTracker_qvto
import xpt.expressions.getExpression
import xpt.providers.ElementTypes
import xpt.providers.ParserUtils_qvto

@Singleton class ParserProvider extends impl.parsers.ParserProvider {
	@Inject extension Common
	@Inject extension Common_qvto

	@Inject extension OclTracker_qvto
	@Inject extension ParserUtils_qvto
	@Inject extension expression_qvto

	@Inject extension ExpressionLabelParser;
	@Inject extension PredefinedParser;

	@Inject getExpression xptGetExpression;
	@Inject MetaModel xptMetaModel;
	@Inject VisualIDRegistry xptVisualIDRegistry;
	@Inject ElementTypes xptElementTypes;
	@Inject parsers.ParserProvider xptParsers;
	@Inject Activator xptActivator;

	override def HintAdapterClass(GenParsers it) '''
			«generatedMemberComment()»
			private static class HintAdapter extends org.eclipse.gmf.runtime.emf.ui.services.parser.ParserHintAdapter {
		
				«generatedMemberComment()»
				private final org.eclipse.gmf.runtime.emf.type.core.IElementType elementType;
		
				«generatedMemberComment()»
				public HintAdapter(org.eclipse.gmf.runtime.emf.type.core.IElementType type,
						org.eclipse.emf.ecore.EObject object, String parserHint) {
				super(object, parserHint);
				«_assert('type != null')»
				elementType = type;
				}
		
				«generatedMemberComment()»
				public Object getAdapter(@SuppressWarnings("rawtypes") Class adapter) {
					if (org.eclipse.gmf.runtime.emf.type.core.IElementType.class.equals(adapter)) {
						return elementType;
					}
					return super.getAdapter(adapter);
				}
			}
	'''

	override dispatch dispatch_parsers(GenNode it) ''' 
		«FOR label : it.labels»
			«IF label.modelFacet != null»
				«dispatch_parser(label.modelFacet.parser, label.modelFacet, label)»
			«ENDIF»
		«ENDFOR»
	'''

	override dispatch dispatch_parsers(GenLink it) '''
		«FOR label : it.labels»
			«IF label.modelFacet != null»
				«dispatch_parser(label.modelFacet.parser, label.modelFacet, label)»
			«ENDIF»
		«ENDFOR»
	'''

	override dispatch dispatch_getParsers(GenNode it) // 
	'''
		«FOR label : it.labels»
			«IF label.modelFacet != null»
				«doGetParser(label.modelFacet.parser, label)»
			«ENDIF»
		«ENDFOR»
		
	'''

	override dispatch dispatch_getParsers(GenLink it) // 
	'''
		«FOR label : it.labels»
			«IF label.modelFacet != null»
				«doGetParser(label.modelFacet.parser, label)»
			«ENDIF»
		«ENDFOR»
		
	'''

	override dispatch dispatch_getParsers(GenChildLabelNode it) '''
		«IF it.modelFacet != null»
			«doGetParser(it.labelModelFacet.parser, it)»
		«ENDIF»
	'''

	override def getParserByVisualIdMethod(GenParsers it) '''
		«generatedMemberComment()»
		protected org.eclipse.gmf.runtime.common.ui.services.parser.IParser getParser(String visualID) {
			if (visualID != null) {
				switch (visualID) {
					«FOR node : editorGen.diagram.topLevelNodes»
						«dispatch_getParsers(node)»
					«ENDFOR»
					«FOR node : editorGen.diagram.childNodes»
						«dispatch_getParsers(node)»
					«ENDFOR»
					«FOR link : editorGen.diagram.links»
						«dispatch_getParsers(link)»
					«ENDFOR»
				}
			}
			return null;
		}
	'''

	override def provider_providesMethod(GenParsers it) '''
		«generatedMemberComment()»
		public boolean provides(org.eclipse.gmf.runtime.common.core.service.IOperation operation) {
			if (operation instanceof org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation) {
				org.eclipse.core.runtime.IAdaptable hint =
						((org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation) operation).getHint();
				if («xptElementTypes.qualifiedClassName(editorGen.diagram)».getElement(hint) == null) {
					return false;
				}
				return getParser(hint) != null;
			}
			return false;
		}
	'''
}
