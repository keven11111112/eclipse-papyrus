/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.elementtypesconfigurations.developer.providers;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.emf.type.core.SpecializationType;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class ElementTypesDetailsContentProvider implements IStructuredContentProvider {

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object[] getElements(Object inputElement) {
		ArrayList<String> result = new ArrayList<String>();
		if (inputElement instanceof IElementType) {
			if (inputElement instanceof IHintedType) {
				result.add("Semantic Hint: " + ((IHintedType) inputElement).getSemanticHint());
			} else {
				result.add("Not Hinted");
			}
			if (inputElement instanceof SpecializationType) {
				for (String id : ((SpecializationType) inputElement).getSpecializedTypeIds()) {
					result.add("SpecializedType Id: " + id);
				}


				if (((SpecializationType) inputElement).getEditHelperAdvice() != null) {
					result.add("EditHelperAdvice: " + ((SpecializationType) inputElement).getEditHelperAdvice().getClass().getName());
				} else {
					result.add("EditHelperAdvice: None");
				}

				if (((SpecializationType) inputElement).getEContainerDescriptor() != null) {
					String eReferences = "";
					for (EReference eReference : ((SpecializationType) inputElement).getEContainerDescriptor().getContainmentFeatures()) {
						eReferences += EMFCoreUtil.getQualifiedName(eReference, true) + " ";
					}
					result.add("EContainerDescriptor: " + eReferences);
				} else {
					result.add("EContainerDescriptor: None");
				}
			}

			if (((IElementType) inputElement).getEditHelper() != null) {
				result.add("EditHelper: " + ((IElementType) inputElement).getEditHelper().getClass().getName());
			} else {
				result.add("EditHelper: None");
			}

			if (((IElementType) inputElement).getEClass() != null) {
				result.add("Eclass: " + EMFCoreUtil.getQualifiedName(((IElementType) inputElement).getEClass(), true));
			} else {
				result.add("Eclass: None");
			}

			result.add("Display Name: " + ((IElementType) inputElement).getDisplayName());
		}
		return result.toArray();
	}
}
