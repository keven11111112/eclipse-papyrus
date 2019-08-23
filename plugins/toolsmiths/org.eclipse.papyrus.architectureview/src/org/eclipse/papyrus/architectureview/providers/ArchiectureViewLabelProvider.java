/*****************************************************************************
 * Copyright (c) 2019 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Nicolas FAUVERGUE (CEA LIST) nicolas.fauvergue@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.architectureview.providers;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.papyrus.architectureview.Activator;
import org.eclipse.papyrus.infra.architecture.ArchitectureDomainManager;
import org.eclipse.papyrus.infra.core.architecture.ADElement;
import org.eclipse.papyrus.infra.core.architecture.ArchitectureDomain;
import org.eclipse.papyrus.infra.core.architecture.merged.MergedArchitectureContext;
import org.eclipse.papyrus.infra.core.architecture.provider.ArchitectureDomainItemProvider;
import org.eclipse.papyrus.infra.core.architecture.provider.ArchitectureItemProviderAdapterFactory;
import org.eclipse.swt.graphics.Image;

/**
 * This is the label provider to display architecture elements of tree viewer.
 */
public class ArchiectureViewLabelProvider implements ITableLabelProvider {

	/**
	 * This map allows to save diagnostics of validation to avoid re-validation.
	 */
	private Map<Resource, Integer> diagnosticByArchitecture;

	/**
	 * This map allows to store the marged architecture status.
	 */
	private Map<Resource, Boolean> mergedArchitecture;

	/**
	 * The default constructor.
	 */
	public ArchiectureViewLabelProvider() {
		diagnosticByArchitecture = new HashMap<>();
		mergedArchitecture = new HashMap<>();
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#removeListener(org.eclipse.jface.viewers.ILabelProviderListener)
	 */
	@Override
	public void removeListener(final ILabelProviderListener listener) {
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#isLabelProperty(java.lang.Object, java.lang.String)
	 */
	@Override
	public boolean isLabelProperty(final Object element, final String property) {
		return false;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#dispose()
	 */
	@Override
	public void dispose() {
		mergedArchitecture.clear();
		mergedArchitecture = null;
		diagnosticByArchitecture.clear();
		diagnosticByArchitecture = null;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#addListener(org.eclipse.jface.viewers.ILabelProviderListener)
	 */
	@Override
	public void addListener(final ILabelProviderListener listener) {
		// Do nothing here.
	}

	/**
	 * Get the test value depending to the element and the column.
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnText(java.lang.Object, int)
	 */
	@Override
	public String getColumnText(final Object element, final int columnIndex) {
		if (element instanceof Resource) {
			final Resource architectureResource = (Resource) element;
			ArchitectureDomain architectureDomain = null;
			final EObject rootContent = architectureResource.getContents().get(0);
			if (rootContent instanceof ArchitectureDomain) {
				architectureDomain = (ArchitectureDomain) rootContent;
			}
			switch (columnIndex) {
			case 0:
				return null != architectureDomain ? architectureDomain.getName() : "Unknown name"; //$NON-NLS-1$
			case 1:
				return null != architectureDomain ? architectureDomain.getId() : "Unknown identifier"; //$NON-NLS-1$
			case 2:
				if (null != mergedArchitecture.get(architectureResource)) {
					return mergedArchitecture.get(architectureResource).toString();
				}
				if (null == architectureDomain) {
					mergedArchitecture.put(architectureResource, false);
				} else {
					final String architectureDomainName = architectureDomain.getName();
					final Collection<MergedArchitectureContext> visibleArchitectureContexts = ArchitectureDomainManager.getInstance().getVisibleArchitectureContexts();
					mergedArchitecture.put(architectureResource, visibleArchitectureContexts.stream().filter(ac -> ac.getParent().getName().equals(architectureDomainName) && ac.getParent().getElementsNumber() > 1).findFirst().isPresent());
				}
				return mergedArchitecture.get(architectureResource).toString();
			case 3:
				return architectureResource.getURI().lastSegment();
			case 4:
				// The second segment should be the plug-in (the 'platform' is managed as scheme)
				final URI uri = architectureResource.getURI();
				return uri.segmentCount() > 2 ? uri.segment(1) : uri.toString();
			case 5:
				if (null != architectureDomain && null == diagnosticByArchitecture.get(architectureResource)) {
					diagnosticByArchitecture.put(architectureResource, Diagnostician.INSTANCE.validate(architectureDomain).getSeverity());
				}
				return Diagnostic.OK == diagnosticByArchitecture.get(architectureResource) ? "true" : "false"; //$NON-NLS-1$ //$NON-NLS-2$
			}
		} else if (element instanceof ADElement) {
			if (0 == columnIndex) {
				return ((ADElement) element).getName();
			}
			return ""; //$NON-NLS-1$
		}
		return "cannot display it: " + element; //$NON-NLS-1$
	}

	/**
	 * Get the icon depending to element and the column.
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnImage(java.lang.Object, int)
	 */
	@Override
	public Image getColumnImage(final Object element, final int columnIndex) {
		if (0 == columnIndex) {
			final ArchitectureItemProviderAdapterFactory adapterFactory = new ArchitectureItemProviderAdapterFactory();
			IItemLabelProvider itemProvider = null;
			if (element instanceof Resource) {
				final EObject rootContent = ((Resource) element).getContents().get(0);
				if (rootContent instanceof ArchitectureDomain) {
					final ArchitectureDomain architectureDomain = (ArchitectureDomain) rootContent;
					itemProvider = (IItemLabelProvider) adapterFactory.adapt(architectureDomain, ArchitectureDomainItemProvider.class);
				}
			} else if (element instanceof ADElement) {
				itemProvider = (IItemLabelProvider) adapterFactory.adapt((ADElement) element, IItemLabelProvider.class);
			}

			if (null != itemProvider) {
				return ExtendedImageRegistry.getInstance().getImage(itemProvider.getImage(element));
			}
		}

		if (2 == columnIndex && element instanceof Resource) {
			if (null == mergedArchitecture.get(element)) {
				final EObject rootContent = ((Resource) element).getContents().get(0);
				if (rootContent instanceof ArchitectureDomain) {
					final ArchitectureDomain architectureDomain = (ArchitectureDomain) rootContent;
					final String architectureDomainName = architectureDomain.getName();
					final Collection<MergedArchitectureContext> visibleArchitectureContexts = ArchitectureDomainManager.getInstance().getVisibleArchitectureContexts();
					mergedArchitecture.put((Resource) element, visibleArchitectureContexts.stream().filter(ac -> ac.getName().equals(architectureDomainName) && ac.getElementsNumber() > 1).findFirst().isPresent());
				}
			}

			return mergedArchitecture.get(element) ? Activator.CHECKED_IMAGE : Activator.UNCHECKED_IMAGE;
		}

		if (5 == columnIndex && element instanceof Resource) {
			if (null == diagnosticByArchitecture.get(element)) {
				final EObject rootContent = ((Resource) element).getContents().get(0);
				if (rootContent instanceof ArchitectureDomain) {
					final ArchitectureDomain architectureDomain = (ArchitectureDomain) rootContent;
					diagnosticByArchitecture.put((Resource) element, Diagnostician.INSTANCE.validate(architectureDomain).getSeverity());
				}
			}

			return Diagnostic.OK == diagnosticByArchitecture.get(element) ? Activator.VALID_IMAGE : Activator.INVALID_IMAGE;
		}

		return null;
	}
}
