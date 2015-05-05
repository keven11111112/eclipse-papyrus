/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.umlrt.ui.provider;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.IElementMatcher;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.ISpecializationType;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.services.labelprovider.service.IFilteredLabelProvider;
import org.eclipse.papyrus.umlrt.custom.UMLRTElementTypesEnumerator;
import org.eclipse.papyrus.umlrt.ui.Activator;
import org.eclipse.uml2.uml.Element;

/**
 * Label provider used by the label provider service
 */
public class UMLRTFilteredLabelProvider extends UMLRTLabelProvider implements IFilteredLabelProvider {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean accept(Object element) {
		EObject semanticObject = EMFHelper.getEObject(element);

		// element should be an UML element at least. UML-RT profile should be present.
		if (!(semanticObject instanceof Element)) {
			return false;
		}

		for (IElementType type : UMLRTElementTypesEnumerator.getAllRTTypes()) {
			if (type instanceof ISpecializationType) {
				IElementMatcher matcher = ((ISpecializationType) type).getMatcher();
				if (matcher != null) {
					if (((ISpecializationType) type).getMatcher().matches(semanticObject)) {
						return true;
					}
				} else {
					Activator.log.debug("no matcher for this element type: " + type);
				}

			}
		}

		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getText(Object element) {
		EObject semanticObject = EMFHelper.getEObject(element);
		if (semanticObject == null) {
			return super.getText(element);
		}

		// specific for RT Message label
		ISpecializationType inMessageType = (ISpecializationType) UMLRTElementTypesEnumerator.RT_MESSAGE_IN;
		ISpecializationType outMessageType = (ISpecializationType) UMLRTElementTypesEnumerator.RT_MESSAGE_OUT;
		ISpecializationType inOutMessageType = (ISpecializationType) UMLRTElementTypesEnumerator.RT_MESSAGE_INOUT;

		if (inMessageType != null && inMessageType.getMatcher() != null && inMessageType.getMatcher().matches((EObject) semanticObject)) {
			return "in " + super.getText(element);
		}

		if (outMessageType != null && outMessageType.getMatcher() != null && outMessageType.getMatcher().matches((EObject) semanticObject)) {
			return "out " + super.getText(element);
		}

		if (inOutMessageType != null && inOutMessageType.getMatcher() != null && inOutMessageType.getMatcher().matches((EObject) semanticObject)) {
			return "inout " + super.getText(element);
		}

		return super.getText(element);
	}

}
