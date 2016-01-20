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

package org.eclipse.papyrus.uml.ui.internal.adapters;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.papyrus.infra.ui.providers.ISemanticContentProviderFactory;
import org.eclipse.papyrus.uml.tools.model.UmlModel;
import org.eclipse.papyrus.uml.tools.providers.SemanticUMLContentProvider;

/**
 * Adapter factory for the {@link UmlModel} and possibly other UML things.
 */
public class UMLModelAdapterFactory implements IAdapterFactory {

	private final Class<?>[] adapters = { ISemanticContentProviderFactory.class };

	public UMLModelAdapterFactory() {
		super();
	}

	@Override
	public <T> T getAdapter(Object adaptableObject, Class<T> adapterType) {
		T result = null;

		if (adapterType == ISemanticContentProviderFactory.class) {
			if (adaptableObject instanceof UmlModel) {
				ISemanticContentProviderFactory adapter = SemanticUMLContentProvider::new;
				result = adapterType.cast(adapter);
			}
		}

		return result;
	}

	@Override
	public Class<?>[] getAdapterList() {
		return adapters;
	}

}
