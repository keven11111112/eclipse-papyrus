/*****************************************************************************
 * Copyright (c) 2007, 2010, 2013 Borland Software Corporation and others
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
 * 
 *****************************************************************************/
package aspects.xpt.navigator

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.gmf.codegen.gmfgen.GenNavigator
import xpt.Common
import xpt.editor.VisualIDRegistry

@Singleton class NavigatorSorter extends xpt.navigator.NavigatorSorter {
	@Inject extension Common;

	@Inject VisualIDRegistry xptVisualIDRegistry;
	@Inject NavigatorItem xptNavigatorItem;
	
	override def category(GenNavigator it) '''
		«generatedMemberComment()»
		public int category(Object element) {
			if (element instanceof «xptNavigatorItem.qualifiedClassName(it)») {
				«xptNavigatorItem.qualifiedClassName(it)» item = («xptNavigatorItem.qualifiedClassName(it)») element;
			«IF editorGen.diagram.generateCreateShortcutAction()»
				if (item.getView().getEAnnotation("Shortcut") != null) {  «nonNLS(1)»
					return SHORTCUTS_CATEGORY;
				}
			«ENDIF»
			return «xptVisualIDRegistry.getVisualIDMethodCall(editorGen.diagram)»(item.getView()).hashCode();
			}
			return GROUP_CATEGORY;
		}
	'''
}
