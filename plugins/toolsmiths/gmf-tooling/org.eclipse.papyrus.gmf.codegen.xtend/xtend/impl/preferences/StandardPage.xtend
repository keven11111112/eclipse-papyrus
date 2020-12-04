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
 * 	  Michael Golubev (Montages) - #386838 - migrate to Xtend2
 *    Aurelien Didier (ARTAL) - aurelien.didier51@gmail.com - Bug 569174
 *****************************************************************************/
package impl.preferences

import com.google.inject.Inject
import org.eclipse.papyrus.gmf.codegen.gmfgen.GenStandardPreferencePage
import org.eclipse.papyrus.gmf.codegen.gmfgen.StandardPreferencePages
import org.eclipse.papyrus.gmf.codegen.xtend.annotations.MetaDef
import xpt.Common

@com.google.inject.Singleton class StandardPage {
	@Inject extension Common;

	def className(GenStandardPreferencePage it) '''«getClassName()»'''

	def packageName(GenStandardPreferencePage it) '''«getDiagram().preferencesPackageName»'''

	def qualifiedClassName(GenStandardPreferencePage it) '''«packageName(it)».«className(it)»'''

	def fullPath(GenStandardPreferencePage it) '''«qualifiedClassName(it)»'''

	def Main(GenStandardPreferencePage it) '''
		«copyright(it.diagram.editorGen)»
		package «packageName(it)»;
		
		«generatedClassComment»
		public class «className(it)» «extendsList(it)» «implementsList(it)» {
		
			«generatedMemberComment»
			public «className(it)»() {
				setPreferenceStore(«getDiagram().editorGen.plugin.activatorQualifiedClassName».getInstance().getPreferenceStore());
			}
		}
	'''

	def extendsList(GenStandardPreferencePage it) '''
		«IF kind == StandardPreferencePages::GENERAL_LITERAL»
			extends org.eclipse.gmf.runtime.diagram.ui.preferences.DiagramsPreferencePage«»
		«ELSEIF kind == StandardPreferencePages::APPEARANCE_LITERAL»
			extends org.eclipse.gmf.runtime.diagram.ui.preferences.AppearancePreferencePage«»
		«ELSEIF kind == StandardPreferencePages::CONNECTIONS_LITERAL»
			extends org.eclipse.gmf.runtime.diagram.ui.preferences.ConnectionsPreferencePage«»
		«ELSEIF kind == StandardPreferencePages::PRINTING_LITERAL»
			extends org.eclipse.gmf.runtime.diagram.ui.preferences.PrintingPreferencePage«»
		«ELSEIF kind == StandardPreferencePages::RULERS_AND_GRID_LITERAL»
			extends org.eclipse.gmf.runtime.diagram.ui.preferences.RulerGridPreferencePage«»
		«ENDIF»
	'''

	def implementsList(GenStandardPreferencePage it) '''«/* no-op */»'''

	@MetaDef def call_initDefaults(GenStandardPreferencePage it, String storeVarName) //
	'''«IF kind != StandardPreferencePages::PATHMAPS_LITERAL»«qualifiedClassName(it)».initDefaults(«storeVarName»);«ENDIF»'''

}
