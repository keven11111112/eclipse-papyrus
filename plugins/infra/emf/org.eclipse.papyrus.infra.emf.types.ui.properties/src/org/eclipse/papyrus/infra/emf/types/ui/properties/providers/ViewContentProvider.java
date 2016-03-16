/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Mickael ADAM (ALL4TEC) mickael.adam@all4tec.net - Initial API and Implementation
 *****************************************************************************/

package org.eclipse.papyrus.infra.emf.types.ui.properties.providers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.papyrus.infra.properties.contexts.Context;
import org.eclipse.papyrus.infra.properties.contexts.View;
import org.eclipse.papyrus.infra.properties.ui.runtime.PropertiesRuntime;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;

/**
 * A {@link ITreeContentProvider} for {@link View}.
 */
public class ViewContentProvider implements ITreeContentProvider, IStaticContentProvider {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getElements(java.lang.Object)
	 */
	@Override
	public Object[] getElements(final Object inputElement) {
		return getElements();
	}

	/**
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang.Object)
	 */
	@Override
	public Object[] getChildren(final Object parentElement) {
		List<Object> children = new ArrayList<>();
		if (parentElement instanceof Context) {
			children.addAll(((Context) parentElement).getViews());
		}
		return children.toArray();
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
		return 0 < getChildren(element).length;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider#getElements()
	 */
	@Override
	public Object[] getElements() {
		List<Context> features = new ArrayList<Context>();
		features.addAll(PropertiesRuntime.getConfigurationManager().getContexts());
		return features.toArray();
	}

}