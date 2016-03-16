/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Fanch BONNABESSE (ALL4TEC) fanch.bonnabesse@all4tec.net - Initial API and implementation
 *****************************************************************************/

package org.eclipse.papyrus.views.references.providers;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.papyrus.views.references.utils.HandleReferences;
import org.eclipse.swt.graphics.Image;

/**
 * Class to create the Label Provider used to set the name and the image on the
 * header of the Form.
 */
public class ReferencesHeaderLabelProvider extends LabelProvider {

	/**
	 * The labelProvider used to get the text and the image corresponding to the
	 * object.
	 */
	private final ILabelProvider labelProvider;

	/**
	 * The {@link LabelProviderService} Context
	 */
	public final static String REFERENCES_HEADER_CONTEXT = "org.eclipse.papyrus.view.references.header.labelProvider.context"; //$NON-NLS-1$

	/**
	 * Constructor.
	 */
	public ReferencesHeaderLabelProvider() {
		final LabelProviderService labelProviderService = HandleReferences.INSTANCE.getLabelProviderService();
		labelProvider = labelProviderService.getLabelProvider(REFERENCES_HEADER_CONTEXT);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getText(final Object element) {
		return labelProvider.getText(element);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Image getImage(final Object element) {
		return labelProvider.getImage(element);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void dispose() {
		super.dispose();
		if (null != labelProvider) {
			labelProvider.dispose();
		}
	}
}
