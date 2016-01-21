/*****************************************************************************
 * Copyright (c) 2015 Christian W. Damus and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.infra.editor.welcome.internal.modelelements;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.properties.contexts.DataContextElement;
import org.eclipse.papyrus.views.properties.Activator;
import org.eclipse.papyrus.views.properties.modelelement.AbstractEMFModelElementFactory;

/**
 * @author damus
 *
 */
public class WelcomeModelElementFactory extends AbstractEMFModelElementFactory<WelcomeModelElement> {

	public WelcomeModelElementFactory() {
		super();
	}

	@Override
	protected WelcomeModelElement doCreateFromSource(Object sourceElement, DataContextElement context) {
		EObject source = EMFHelper.getEObject(sourceElement);
		if (source == null) {
			Activator.log.warn("Unable to resolve the selected element to an EObject"); //$NON-NLS-1$
			return null;
		}

		EditingDomain domain = EMFHelper.resolveEditingDomain(source);
		return new WelcomeModelElement(source, domain);
	}

}
