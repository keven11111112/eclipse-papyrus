/*****************************************************************************
 * Copyright (c) 2016 Christian W. Damus and others.
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

package org.eclipse.papyrus.infra.ui.providers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.viewers.ITreeContentProvider;

/**
 * Default implementation of a composite content-provider factory.
 */
class CompositeSemanticContentProviderFactory implements ISemanticContentProviderFactory {
	private final List<ISemanticContentProviderFactory> factories;

	CompositeSemanticContentProviderFactory(ISemanticContentProviderFactory first, ISemanticContentProviderFactory second) {
		super();

		factories = Arrays.asList(first, second);
	}

	private CompositeSemanticContentProviderFactory(CompositeSemanticContentProviderFactory composite, ISemanticContentProviderFactory other) {
		super();

		if (other instanceof CompositeSemanticContentProviderFactory) {
			List<ISemanticContentProviderFactory> otherFactories = ((CompositeSemanticContentProviderFactory) other).factories;
			factories = new ArrayList<>(composite.factories.size() + otherFactories.size());
			factories.addAll(composite.factories);
			factories.addAll(otherFactories);
		} else {
			factories = new ArrayList<>(composite.factories.size() + 1);
			factories.addAll(composite.factories);
			factories.add(other);
		}
	}

	@Override
	public ITreeContentProvider createSemanticContentProvider(ResourceSet resourceSet) {
		return DelegatingPapyrusContentProvider.compose(factories.stream()
				.map(f -> f.createSemanticContentProvider(resourceSet))
				.collect(Collectors.toList()));
	}

	@Override
	public ISemanticContentProviderFactory compose(ISemanticContentProviderFactory other) {
		return new CompositeSemanticContentProviderFactory(this, other);
	}

}
