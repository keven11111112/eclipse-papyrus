/*****************************************************************************
 * Copyright (c) 2007, 2009, 2013 Borland Software Corporation and others
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
import org.eclipse.papyrus.gmf.codegen.gmfgen.GenNavigator
import xpt.Commonimport xpt.CodeStyle

@Singleton class AbstractNavigatorItem extends xpt.navigator.AbstractNavigatorItem {
	@Inject extension Common;
	@Inject extension CodeStyle

	override def registerAdapterFactory(GenNavigator it) '''
		«generatedMemberComment()»
		static {
			@SuppressWarnings("rawtypes")
			final Class[] supportedTypes = new Class[] { org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor.class };
			final org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor propertySheetPageContributor = new org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor() {
				«overrideI(it.editorGen.diagram)»
				public String getContributorId() {
					return "«editorGen.plugin.ID»";  «nonNLS(1)»
				}
			};
			org.eclipse.core.runtime.Platform.getAdapterManager().registerAdapters(new org.eclipse.core.runtime.IAdapterFactory() {
				
				«overrideI(it.editorGen.diagram)»
				@SuppressWarnings("rawtypes")
				public Object getAdapter(Object adaptableObject, Class adapterType) {
					if (adaptableObject instanceof «qualifiedClassName(it)» && adapterType == org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor.class) {
						return propertySheetPageContributor;				
					}
					return null;
				}
		
				«overrideI(it.editorGen.diagram)»
				@SuppressWarnings("rawtypes")
				public Class[] getAdapterList() {
					return supportedTypes;
				}
			}, «qualifiedClassName(it)».class);
		}
	'''

}
