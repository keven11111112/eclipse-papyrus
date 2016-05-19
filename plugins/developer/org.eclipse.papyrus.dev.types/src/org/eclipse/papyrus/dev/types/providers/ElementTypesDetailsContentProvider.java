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
package org.eclipse.papyrus.dev.types.providers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.emf.type.core.SpecializationType;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelperAdvice;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.infra.types.core.utils.AdviceComparator;

public class ElementTypesDetailsContentProvider implements ITreeContentProvider {

	String contextID;

	String typeID;


	/**
	 * @param contextID
	 *            the contextID to set
	 */
	public void setContextID(String contextID) {
		this.contextID = contextID;
	}

	public void setTypeID(String typeID) {
		this.typeID = typeID;
	}

	/**
	 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
	 *
	 */
	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	/**
	 * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
	 *
	 * @param viewer
	 * @param oldInput
	 * @param newInput
	 */
	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// TODO Auto-generated method stub

	}

	/**
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getElements(java.lang.Object)
	 *
	 * @param inputElement
	 * @return
	 */
	@Override
	public Object[] getElements(Object inputElement) {
		ArrayList<Object> result = new ArrayList<Object>();
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
			IEditHelperAdvice[] advices = ElementTypeRegistry.getInstance().getEditHelperAdvice(((IElementType) inputElement));
			result.add(Arrays.asList(advices));
		}
		return result.toArray();
	}

	/**
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang.Object)
	 *
	 * @param parentElement
	 * @return
	 */
	@Override
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof List<?>) {
			Collections.sort((List<IEditHelperAdvice>) parentElement, new AdviceComparator(ElementTypeRegistry.getInstance().getType(typeID), contextID));
			return ((List<?>) parentElement).toArray();
		}

		return Collections.emptyList().toArray();
	}

	/**
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang.Object)
	 *
	 * @param element
	 * @return
	 */
	@Override
	public Object getParent(Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang.Object)
	 *
	 * @param element
	 * @return
	 */
	@Override
	public boolean hasChildren(Object element) {
		return getChildren(element).length == 0 ? false : true;
	}


}
