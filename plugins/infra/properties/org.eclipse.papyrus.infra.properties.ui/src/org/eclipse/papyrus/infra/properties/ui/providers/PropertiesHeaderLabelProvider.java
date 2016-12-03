/*****************************************************************************
 * Copyright (c) 2013, 2016 CEA LIST, Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Christian W. Damus - bug 508629
 *****************************************************************************/
package org.eclipse.papyrus.infra.properties.ui.providers;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.papyrus.infra.services.labelprovider.service.impl.LabelProviderServiceImpl;
import org.eclipse.swt.graphics.Image;

/**
 * An extensible LabelProvider for the Properties View header. It is based
 * on the papyrus {@link LabelProviderService}
 *
 * @author Camille Letavernier
 */
public class PropertiesHeaderLabelProvider extends LabelProvider {


	private final ILabelProvider delegate;

	private final ILabelProviderListener forwardingListener;

	/**
	 * The {@link LabelProviderService} Context
	 */
	public final static String PROPERTIES_HEADER_CONTEXT = "org.eclipse.papyrus.infra.properties.ui.header.labelProvider.context";

	public PropertiesHeaderLabelProvider() {
		LabelProviderService labelProviderService = new LabelProviderServiceImpl();
		delegate = labelProviderService.getLabelProvider(PROPERTIES_HEADER_CONTEXT);

		forwardingListener = this::forwardLabelChange;
		delegate.addListener(forwardingListener);
	}

	@Override
	public String getText(Object element) {
		return delegate.getText(element);
	}

	@Override
	public Image getImage(Object element) {
		return delegate.getImage(element);
	}

	private void forwardLabelChange(LabelProviderChangedEvent event) {
		fireLabelProviderChanged(new LabelProviderChangedEvent(this, event.getElements()));
	}

	@Override
	public void dispose() {
		delegate.removeListener(forwardingListener);
		delegate.dispose();
	}
}
