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
package org.eclipse.papyrus.infra.gmfdiag.paletteconfiguration.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.papyrus.infra.types.ElementTypeConfiguration;
import org.eclipse.papyrus.infra.types.ElementTypeSetConfiguration;
import org.eclipse.papyrus.infra.types.core.registries.ElementTypeSetConfigurationRegistry;
import org.eclipse.papyrus.infra.widgets.providers.IHierarchicContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;

/**
 * Content Provider for {@link ElementTypeSetConfiguration}.
 */
public class ElementTypeSetConfigurationContentProvider implements IStaticContentProvider, IHierarchicContentProvider {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
	 */
	@Override
	public Object[] getElements(final Object inputElement) {
		List<ElementTypeSetConfiguration> els = new ArrayList<ElementTypeSetConfiguration>();
		Collection<Map<String, ElementTypeSetConfiguration>> values = ElementTypeSetConfigurationRegistry.getInstance().getElementTypeSetConfigurations().values();
		for (Iterator iterator = values.iterator(); iterator.hasNext();) {
			Map<String, ElementTypeSetConfiguration> map = (Map<String, ElementTypeSetConfiguration>) iterator.next();
			Collection<ElementTypeSetConfiguration> values2 = map.values();
			for (Iterator iterator2 = values2.iterator(); iterator2.hasNext();) {
				ElementTypeSetConfiguration elementTypeSetConfiguration = (ElementTypeSetConfiguration) iterator2.next();
				if (!elementTypeSetConfiguration.getElementTypeConfigurations().isEmpty()) {
					els.add(elementTypeSetConfiguration);
				}
			}
		}
		return els.toArray();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider#getElements()
	 */
	@Override
	public Object[] getElements() {
		return getElements(null);
	}

	/**
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang.Object)
	 */
	@Override
	public Object[] getChildren(Object parentElement) {
		Object[] children = null;
		if (parentElement instanceof ElementTypeSetConfiguration) {
			children = ((ElementTypeSetConfiguration) parentElement).getElementTypeConfigurations().toArray();
		}
		return children;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang.Object)
	 */
	@Override
	public Object getParent(final Object element) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang.Object)
	 */
	@Override
	public boolean hasChildren(final Object element) {
		return null != getChildren(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.infra.widgets.providers.IHierarchicContentProvider#isValidValue(java.lang.Object)
	 */
	@Override
	public boolean isValidValue(final Object element) {
		return element instanceof ElementTypeConfiguration;
	}

}