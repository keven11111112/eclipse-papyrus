/*****************************************************************************
 * Copyright (c) 2017 CEA LIST, ALL4TEC and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Mickaël ADAM (ALL4TEC) mickael.adam@all4tec.net - Initial API and implementation
 *****************************************************************************/

package org.eclipse.papyrus.infra.gmfdiag.paletteconfiguration.modelelement;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.infra.gmfdiag.paletteconfiguration.ElementDescriptor;
import org.eclipse.papyrus.infra.gmfdiag.paletteconfiguration.provider.ElementTypeLabelProvider;
import org.eclipse.papyrus.infra.gmfdiag.paletteconfiguration.provider.ElementTypeSetConfigurationContentProvider;
import org.eclipse.papyrus.infra.properties.ui.modelelement.EMFModelElement;
import org.eclipse.papyrus.infra.widgets.providers.FilteredContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;

/**
 * Model Element for {@link ElementDescriptor}.
 *
 */
public class ElementDescriptorModelElement extends EMFModelElement {
	/**
	 * Constructor.
	 *
	 * @param sourceElement
	 *            the palette configuration where to edit the icon descriptor
	 * @param domain
	 *            the editing domain
	 */
	public ElementDescriptorModelElement(final ElementDescriptor sourceElement, final EditingDomain domain) {
		super(sourceElement, domain);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.infra.properties.ui.modelelement.EMFModelElement#isFeatureEditable(java.lang.String)
	 */
	@Override
	protected boolean isFeatureEditable(final String propertyPath) {
		boolean featureEditable = false;
		if ("elementType".equals(propertyPath)) { //$NON-NLS-1$
			featureEditable = true;
		} else {
			featureEditable = super.isFeatureEditable(propertyPath);
		}
		return featureEditable;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.infra.properties.ui.modelelement.EMFModelElement#getLabelProvider(java.lang.String)
	 */
	@Override
	public ILabelProvider getLabelProvider(final String propertyPath) {
		ILabelProvider labelProvider = null;
		if ("elementType".equals(propertyPath)) {//$NON-NLS-1$
			labelProvider = new ElementTypeLabelProvider();
		} else {
			labelProvider = super.getLabelProvider(propertyPath);
		}
		return labelProvider;
	}


	/**
	 * @see org.eclipse.papyrus.infra.properties.ui.modelelement.EMFModelElement#getContentProvider(java.lang.String)
	 */
	@Override
	public IStaticContentProvider getContentProvider(String propertyPath) {
		IStaticContentProvider contentProvider = null;
		if ("elementType".equals(propertyPath)) {//$NON-NLS-1$
			contentProvider = new FilteredContentProvider(new ElementTypeSetConfigurationContentProvider());
		} else {
			contentProvider = super.getContentProvider(propertyPath);
		}
		return contentProvider;
	}
}
