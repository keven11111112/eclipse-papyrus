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
 *    Alexander Shatalin (Borland) - initial API and implementation
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 *    Aurelien Didier (ARTAL) - aurelien.didier51@gmail.com - Bug 569174
 *****************************************************************************/
package xpt.navigator

import com.google.inject.Inject
import org.eclipse.papyrus.gmf.codegen.gmfgen.GenNavigator
import xpt.Common
import xpt.editor.VisualIDRegistry

@com.google.inject.Singleton class NavigatorSorter {
	@Inject extension Common;
	@Inject extension Utils_qvto;
	
	@Inject VisualIDRegistry xptVisualIDRegistry;
	@Inject NavigatorItem xptNavigatorItem;

	def className(GenNavigator it) '''«it.sorterClassName»'''

	def packageName(GenNavigator it) '''«it.packageName»'''

	def qualifiedClassName(GenNavigator it) '''«packageName(it)».«className(it)»'''

	def fullPath(GenNavigator it) '''«qualifiedClassName(it)»'''

	def NavigatorSorter(GenNavigator it) '''
		«copyright(editorGen)»
		package «packageName(it)»;
		
		«generatedClassComment()»
		public class «className(it)»  extends org.eclipse.jface.viewers.ViewerSorter {
			
			«attributes(it)»
			
			«category(it)»
			
			   «additions(it)»
		}
	'''

	def attributes(GenNavigator it) '''
		«generatedMemberComment()»
		private static final int GROUP_CATEGORY = «getMaxVisualID(it) + 2»;
		«IF editorGen.diagram.generateCreateShortcutAction()»
			
			«generatedMemberComment()»
			private static final int SHORTCUTS_CATEGORY = «getMaxVisualID(it) + 1»;
		«ENDIF»
	'''

	def category(GenNavigator it) '''
		«generatedMemberComment()»
		public int category(Object element) {
			if (element instanceof «xptNavigatorItem.qualifiedClassName(it)») {
				«xptNavigatorItem.qualifiedClassName(it)» item = («xptNavigatorItem.qualifiedClassName(it)») element;
			«IF editorGen.diagram.generateCreateShortcutAction()»
				if (item.getView().getEAnnotation("Shortcut") != null) {  «nonNLS(1)»
					return SHORTCUTS_CATEGORY;
				}
			«ENDIF»
			return «xptVisualIDRegistry.getVisualIDMethodCall(editorGen.diagram)»(item.getView());
			}
			return GROUP_CATEGORY;
		}
	'''

	def additions(GenNavigator it) ''''''

}
