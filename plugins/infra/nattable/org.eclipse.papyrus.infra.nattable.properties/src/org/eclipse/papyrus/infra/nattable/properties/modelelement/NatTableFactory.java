/*****************************************************************************
 * Copyright (c) 2013, 2014 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 417409
 *  Nicolas FAUVERGUE (ALL4TEC) nicolas.fauvergue@all4tec.net - Bug 492891
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.properties.modelelement;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.properties.Activator;
import org.eclipse.papyrus.infra.properties.contexts.DataContextElement;
import org.eclipse.papyrus.infra.properties.ui.modelelement.EMFModelElement;
import org.eclipse.papyrus.infra.properties.ui.modelelement.EMFModelElementFactory;

/**
 * The model factory to create {@link NatTableModelElement}s.
 */
public class NatTableFactory extends EMFModelElementFactory {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.infra.properties.ui.modelelement.EMFModelElementFactory#doCreateFromSource(java.lang.Object, org.eclipse.papyrus.infra.properties.contexts.DataContextElement)
	 */
	@Override
	protected EMFModelElement doCreateFromSource(final Object sourceElement, final DataContextElement context) {
		EObject source = EMFHelper.getEObject(sourceElement);
		if (source == null) {
			Activator.log.warn("Unable to resolve the selected element to an EObject"); //$NON-NLS-1$
			return null;
		}
		if (source instanceof Table) {
			EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(source);
			return new NatTableModelElement((Table) source, domain);
		} else {
			return super.doCreateFromSource(sourceElement, context);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.infra.properties.ui.modelelement.AbstractEMFModelElementFactory#updateModelElement(org.eclipse.papyrus.infra.properties.ui.modelelement.EMFModelElement, java.lang.Object)
	 * 
	 * @since 2.1
	 */
	@Override
	protected void updateModelElement(final EMFModelElement modelElement, final Object newSourceElement) {
		final EObject eObject = EMFHelper.getEObject(newSourceElement);
		if (null == eObject) {
			throw new IllegalArgumentException("Cannot resolve EObject selection: " + newSourceElement);
		}

		if (modelElement instanceof NatTableModelElement && eObject instanceof Table) {
			updateTableModelElement((NatTableModelElement) modelElement, (Table) eObject);
		}
		updateEMFModelElement(modelElement, eObject);
	}

	/**
	 * Modify the table property of the nattable model element.
	 * 
	 * @param nattableModelElement
	 *            The nattable model element.
	 * @param table
	 *            The table.
	 * 
	 * @since 2.1
	 */
	public static void updateTableModelElement(final NatTableModelElement nattableModelElement, final Table table) {
		nattableModelElement.table = table;
	}
}
