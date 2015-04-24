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
package org.eclipse.papyrus.customization.properties.providers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.emf.providers.EMFLabelProvider;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.services.labelprovider.service.IFilteredLabelProvider;
import org.eclipse.papyrus.views.properties.environment.ModelElementFactoryDescriptor;

/**
 * @author Camille Letavernier
 *
 */
public class ModelElementFactoryLabelProvider extends EMFLabelProvider implements IFilteredLabelProvider {

	/**
	 * @see org.eclipse.papyrus.infra.services.labelprovider.service.IFilteredLabelProvider#accept(java.lang.Object)
	 *
	 * @param element
	 * @return
	 */
	@Override
	public boolean accept(Object element) {
		if (element instanceof IStructuredSelection) {
			Object selectedItem = ((IStructuredSelection) element).getFirstElement();
			return accept(selectedItem);
		}
		return EMFHelper.getEObject(element) instanceof ModelElementFactoryDescriptor;
	}

	/**
	 * @see org.eclipse.papyrus.infra.emf.providers.EMFLabelProvider#getText(java.lang.Object)
	 *
	 * @param element
	 * @return
	 */
	@Override
	public String getText(Object element) {
		EObject eObject = EMFHelper.getEObject(element);
		if (eObject instanceof ModelElementFactoryDescriptor) {
			ModelElementFactoryDescriptor factory = (ModelElementFactoryDescriptor) eObject;
			String label = "[Factory] ";
			String name = factory.getName();
			label += name == null || name.isEmpty() ? "<Unnamed Factory>" : factory.getName();
			return label;
		}
		return super.getText(element);
	}

}
