/*****************************************************************************
 * Copyright (c) 2006, 2010, 2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 * Alexander Shatalin (Borland) - initial API and implementation
 * Michael Golubev (Montages) - #386838 - migrate to Xtend2
 * Modified by Patrick Tessier (CEA LIST)
 * Emilien Perico (Atos Origin) - update template for GMF 2.2 compliance
 * 
 *****************************************************************************/
package aspects.xpt.navigator

import aspects.xpt.Common
import com.google.inject.Inject
import com.google.inject.Singleton
import metamodel.MetaModel
import org.eclipse.emf.codegen.ecore.genmodel.GenClass
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase
import org.eclipse.gmf.codegen.gmfgen.LabelModelFacet
import parsers.ParserProvider
import plugin.Activator
import xpt.navigator.Utils_qvto

@Singleton class NavigatorLabelProvider extends xpt.navigator.NavigatorLabelProvider {
	@Inject extension Common;
	@Inject extension Utils_qvto;

	@Inject Activator xptActivator;
	@Inject ParserProvider xptParserProvider;
	@Inject MetaModel xptMetaModel;

	override def getTextMethodName(GenCommonBase it) '''get«stringUniqueIdentifier»Text'''

	override def CharSequence getDiagramLabelText(GenCommonBase it, GenCommonBase elementTypeHolder, LabelModelFacet labelModelFacet) '''
		org.eclipse.gmf.runtime.common.ui.services.parser.IParser parser = «xptParserProvider.accessorCall(it, elementTypeHolder, labelModelFacet, 'view.getElement() != null ? view.getElement() : view')»;
		if (parser != null) {
			return parser.getPrintString(new org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter(view.getElement() != null ? view.getElement() : view), org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions.NONE.intValue());
		} else {
			«xptActivator.qualifiedClassName(getDiagram().editorGen.plugin)».getInstance().logError("Parser was not found for label «stringVisualID»"); «nonNLS(1)»
			«returnEmptyString()»
		}
	'''

	override def getLabelFeatureText(GenCommonBase it, GenClass genClass) '''
		«IF null != genClass && null != genClass.labelFeature»
			«xptMetaModel.DeclareAndAssign(genClass, 'domainModelElement', 'view.getElement()')»
			if (domainModelElement != null) {
				return «IF !isStringFeature(genClass.labelFeature)»String.valueOf(«ENDIF»UMLLabelInternationalization.getInstance().getLabel(domainModelElement)«IF !isStringFeature(genClass.labelFeature)»)«ENDIF»;
			} else {
				«xptActivator.qualifiedClassName(getDiagram().editorGen.plugin)».getInstance().logError("No domain element for view with visualID = «stringVisualID»");  «nonNLS(1)»
					«returnEmptyString()»
			}
		«ELSE»
			«returnEmptyString()»
		«ENDIF»
	'''
	
	
}
