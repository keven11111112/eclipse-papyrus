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
package aspects.xpt.propsheet

import aspects.xpt.Common
import aspects.xpt.editor.VisualIDRegistry
import aspects.xpt.providers.ElementTypes
import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.gmf.codegen.gmfgen.GenPropertySheet

@Singleton class LabelProvider extends xpt.propsheet.LabelProvider {
	@Inject extension Common;

	@Inject ElementTypes xptElementTypes;
	@Inject VisualIDRegistry visualId;

	override def unwrapMethods(GenPropertySheet it) '''
		«generatedMemberComment»
		private Object unwrap(Object element) {
		if (element instanceof org.eclipse.jface.viewers.IStructuredSelection) {
		return ((org.eclipse.jface.viewers.IStructuredSelection) element).getFirstElement();
		}
		return element;
		}
		
		«generatedMemberComment»
		private org.eclipse.gmf.runtime.notation.View getView(Object element) {
			if (element instanceof org.eclipse.gmf.runtime.notation.View) {
				return (org.eclipse.gmf.runtime.notation.View) element;
			}
			if (element instanceof org.eclipse.core.runtime.IAdaptable) {
				return (org.eclipse.gmf.runtime.notation.View)
						((org.eclipse.core.runtime.IAdaptable) element).getAdapter(org.eclipse.gmf.runtime.notation.View.class);
			}
			return null;
		}
		
		«generatedMemberComment»
		private org.eclipse.gmf.runtime.emf.type.core.IElementType getElementType(org.eclipse.gmf.runtime.notation.View view) {
			// For intermediate views climb up the containment hierarchy to find the one associated with an element type.
			while (view != null) {
				String vid = «visualId.qualifiedClassName(editorGen.diagram)».getVisualID(view);
				org.eclipse.gmf.runtime.emf.type.core.IElementType etype =
						«xptElementTypes.qualifiedClassName(editorGen.diagram)».getElementType(vid);
				if (etype != null) {
					return etype;
				}
				view = view.eContainer() instanceof org.eclipse.gmf.runtime.notation.View ?
						(org.eclipse.gmf.runtime.notation.View) view.eContainer() : null;
			}
			return null;
		}
	'''

}
