/*****************************************************************************
 * Copyright (c) 2018 CEA LIST and others.
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

package org.eclipse.papyrus.infra.viewpoints.policy.providers;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.papyrus.infra.core.architecture.provider.ArchitectureViewpointItemProvider;

/**
 * @author melaasar
 *
 */
public class MergedArchitectureViewpointItemProvider extends ArchitectureViewpointItemProvider {

	/**
	 * Constructor.
	 *
	 * @param adapterFactory
	 */
	public MergedArchitectureViewpointItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	protected ItemPropertyDescriptor createItemPropertyDescriptor(
			AdapterFactory adapterFactory,
			ResourceLocator resourceLocator,
			String displayName,
			String description,
			EStructuralFeature feature,
			boolean isSettable,
			boolean multiLine,
			boolean sortChoices,
			Object staticImage,
			String category,
			String[] filterFlags,
			Object propertyEditorFactory) {
		return new MergedItemPropertyDescriptor(adapterFactory,
				resourceLocator,
				displayName,
				description,
				feature,
				false,
				multiLine,
				sortChoices,
				staticImage,
				category,
				filterFlags,
				propertyEditorFactory);
	}

}
