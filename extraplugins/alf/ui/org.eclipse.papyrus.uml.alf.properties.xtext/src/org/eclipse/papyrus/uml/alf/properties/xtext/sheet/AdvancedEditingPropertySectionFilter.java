/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 
 *****************************************************************************/
package org.eclipse.papyrus.uml.alf.properties.xtext.sheet;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.papyrus.extensionpoints.editors.Activator;
import org.eclipse.papyrus.extensionpoints.editors.configuration.ICustomDirectEditorConfiguration;
import org.eclipse.papyrus.extensionpoints.editors.configuration.IDirectEditorConfiguration;
import org.eclipse.papyrus.extensionpoints.editors.utils.DirectEditorsUtil;
import org.eclipse.papyrus.extensionpoints.editors.utils.IDirectEditorsIds;
import org.eclipse.papyrus.uml.alf.properties.xtext.constraints.ALFFilterConstraint;
import org.eclipse.uml2.uml.Association;

public class AdvancedEditingPropertySectionFilter implements IFilter {

	public boolean select(Object toTest) {
		EObject semanticElement = null;
		if (toTest instanceof IAdaptable) {
			semanticElement = (EObject) ((IAdaptable) toTest).getAdapter(EObject.class);
		}
		else if (toTest instanceof GraphicalEditPart) {
			GraphicalEditPart part = (GraphicalEditPart) toTest;
			semanticElement = part.resolveSemanticElement();
		}
		if (semanticElement != null) {
			IPreferenceStore store = Activator.getDefault().getPreferenceStore();
			String key = IDirectEditorsIds.EDITOR_FOR_ELEMENT
					+ semanticElement.eClass().getInstanceClassName();

			String languagePreferred = store.getString(key);

			if (languagePreferred != null && !languagePreferred.equals("")) {
				IDirectEditorConfiguration configuration = null;
				if (languagePreferred.equals("Alf") && semanticElement instanceof Association) {
					if (ALFFilterConstraint.conforms((Association) semanticElement)) {
						configuration = DirectEditorsUtil.findEditorConfiguration(
								languagePreferred, semanticElement.eClass()
										.getInstanceClassName());
					}
				} else {
					configuration = DirectEditorsUtil.findEditorConfiguration(
							languagePreferred, semanticElement.eClass()
									.getInstanceClassName());
				}
				return configuration instanceof ICustomDirectEditorConfiguration;
			}
		}
		return false;
	}
}