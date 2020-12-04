/*****************************************************************************
 * Copyright (c) 2015 Anatoliy Tischenko and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 * Anatoliy Tischenko  - Initial API and implementation
 * 
 *****************************************************************************/
package aspects.xpt.editor

import com.google.inject.Inject
import xpt.Common
import xpt.CodeStyle
import org.eclipse.papyrus.gmf.codegen.gmfgen.GenDiagram
import com.google.inject.Singleton

@Singleton class ResourceSetInfo extends xpt.editor.ResourceSetInfo {
	
	@Inject extension Common
	@Inject extension CodeStyle
	
	override handleResourceChangedSD(GenDiagram it) '''
		«generatedMemberComment»
		public boolean handleResourceChanged(final org.eclipse.emf.ecore.resource.Resource resource) {
			«updateSynchStateSD(it)»
			org.eclipse.swt.widgets.Display.getDefault().asyncExec(new java.lang.Runnable() {
				«overrideI»
				public void run() {
					handleElementChanged(ResourceSetInfo.this, resource, null);
				}
			});
			return true;
		}
	'''

	override handleResourceDeletedSD(GenDiagram it) '''
		«generatedMemberComment»
		public boolean handleResourceDeleted(org.eclipse.emf.ecore.resource.Resource resource) {
			«updateSynchStateSD(it)»
			org.eclipse.swt.widgets.Display.getDefault().asyncExec(new java.lang.Runnable() {
				«overrideI»
				public void run() {
					fireElementDeleted(ResourceSetInfo.this.getEditorInput());
				}
			});
			return true;
		}
	'''

	override handleResourceMovedSD(GenDiagram it) '''
		«generatedMemberComment»
		public boolean handleResourceMoved(org.eclipse.emf.ecore.resource.Resource resource, final org.eclipse.emf.common.util.URI newURI) {
			«updateSynchStateSD(it)»
			if (myDocument.getDiagram().eResource() == resource) {
				org.eclipse.swt.widgets.Display.getDefault().asyncExec(new java.lang.Runnable() {
					«overrideI»
					public void run() {
						handleElementMoved(ResourceSetInfo.this.getEditorInput(), newURI);
					}
				});
			} else {
				handleResourceDeleted(resource);
			}
			return true;
		}
	'''
	
}