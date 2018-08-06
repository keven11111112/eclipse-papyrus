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
import org.eclipse.gmf.codegen.gmfgen.GenNavigator
import xpt.Common

@com.google.inject.Singleton class NavigatorGroup extends xpt.navigator.NavigatorGroup {
	@Inject extension Common;

	override def attributes(GenNavigator it) '''
		«generatedMemberComment()»
		private String myGroupName;
			
		«generatedMemberComment()»
		private String myIcon;
			
		«generatedMemberComment()»
		private java.util.Collection<java.lang.Object> myChildren = new java.util.LinkedList<java.lang.Object>();
	'''
	
	override def addChildren(GenNavigator it) '''
		«generatedMemberComment()»
		public void addChildren(java.util.Collection<java.lang.Object> children) {
			myChildren.addAll(children);
		}
	'''

}
