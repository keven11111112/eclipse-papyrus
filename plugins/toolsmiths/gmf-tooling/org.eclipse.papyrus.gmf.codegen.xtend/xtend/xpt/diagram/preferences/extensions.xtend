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
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 *    Aurelien Didier (ARTAL) - aurelien.didier51@gmail.com - Bug 569174
 *****************************************************************************/
package xpt.diagram.preferences

import com.google.inject.Inject
import org.eclipse.papyrus.gmf.codegen.gmfgen.GenDiagram
import org.eclipse.papyrus.gmf.codegen.gmfgen.GenPreferencePage
import org.eclipse.papyrus.gmf.codegen.xtend.annotations.Localization
import xpt.Common
import xpt.Common_qvto
import xpt.diagram.Utils_qvto
import impl.preferences.CustomPage
import impl.preferences.StandardPage
import org.eclipse.papyrus.gmf.codegen.gmfgen.GenCustomPreferencePage
import org.eclipse.papyrus.gmf.codegen.gmfgen.GenStandardPreferencePage

@com.google.inject.Singleton class extensions {
	@Inject extension Common;
	@Inject extension Common_qvto;
	@Inject extension Utils_qvto;

	@Inject PreferenceInitializer xptPreferenceInitializer;
	@Inject CustomPage xptCustomPage;
	@Inject StandardPage xptStandardPage;

	def extensions(GenDiagram it) '''
		
		«tripleSpace(1)»<extension point="org.eclipse.core.runtime.preferences" id="prefs">
		«tripleSpace(2)»«xmlGeneratedTag»
		«tripleSpace(2)»<initializer class="«xptPreferenceInitializer.qualifiedClassName(it)»"/>
		«tripleSpace(1)»</extension>
		
		«IF it.preferencePages.notEmpty»
		«tripleSpace(1)»<extension point="org.eclipse.ui.preferencePages" id="prefpages">
		«tripleSpace(2)»«xmlGeneratedTag»
		      «FOR pref : allPreferencePages(it)»
		«preferencePage(pref)»
		      «ENDFOR»
		«tripleSpace(1)»</extension>
		«ENDIF»
	'''

	def preferencePage(GenPreferencePage it) '''
		«tripleSpace(2)»<page
		«tripleSpace(4)»id="«ID»"
		«tripleSpace(4)»name="%prefpage.«ID»"
			«IF null != parent»
		«tripleSpace(4)»category="«parent.ID»"
			«ELSEIF !parentCategory.nullOrEmpty»
		«tripleSpace(4)»category="«parentCategory»"
			«ENDIF»
		«tripleSpace(4)»class="«getQualifiedPageName(it)»">
		«tripleSpace(2)»</page>
	'''

	@Localization def i18n(GenDiagram it) '''
		# Preferences
		«FOR pref : allPreferencePages(it)»
			prefpage.«pref.ID»=«pref.name»
		«ENDFOR»
		«extraLineBreak»
	'''
	def dispatch getQualifiedPageName(GenPreferencePage it) ''''''
	def dispatch getQualifiedPageName(GenCustomPreferencePage it) '''«xptCustomPage.qualifiedClassName(it)»'''
	def dispatch getQualifiedPageName(GenStandardPreferencePage it) '''«xptStandardPage.qualifiedClassName(it)»'''
}
