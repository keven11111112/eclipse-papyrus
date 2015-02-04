/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Ansgar Radermacher (CEA LIST) ansgar.radermacher@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.umlrt.properties.modelelement;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.uml.properties.modelelement.UMLModelElement;
import org.eclipse.papyrus.uml.properties.modelelement.UMLModelElementFactory;
import org.eclipse.papyrus.umlrt.properties.Activator;
import org.eclipse.papyrus.umlrt.utils.UMLRTUtil;
import org.eclipse.papyrus.views.properties.contexts.DataContextElement;
import org.eclipse.uml2.uml.Collaboration;

public class UMLRTExtModelElementFactory extends UMLModelElementFactory {

	@Override
	protected UMLModelElement doCreateFromSource(Object sourceElement, DataContextElement context) {
		EObject source = EMFHelper.getEObject(sourceElement);
		if (source == null) {
			Activator.log.warn("Unable to resolve the selected element to an EObject"); //$NON-NLS-1$
			return null;
		}
		if (UMLRTUtil.isProtocolContainer(source)) {
			return new UMLRTExtModelElement(source);
		}else if(source instanceof Collaboration){
			return new UMLRTExtModelElement(source);
		}
		else {
			return super.doCreateFromSource(sourceElement, context);
		}
	}

}
