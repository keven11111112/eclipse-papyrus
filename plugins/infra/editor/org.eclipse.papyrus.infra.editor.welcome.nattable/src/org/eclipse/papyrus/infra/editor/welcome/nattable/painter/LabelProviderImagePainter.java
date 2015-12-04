/*****************************************************************************
 * Copyright (c) 2015 Christian W. Damus and others.
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

package org.eclipse.papyrus.infra.editor.welcome.nattable.painter;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;
import org.eclipse.nebula.widgets.nattable.layer.cell.ILayerCell;
import org.eclipse.nebula.widgets.nattable.painter.cell.ImagePainter;
import org.eclipse.papyrus.infra.editor.welcome.nattable.ServiceConfigAttributes;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.swt.graphics.Image;

/**
 * An image painter that obtains images from the {@link LabelProviderService} registered
 * in the NatTable configuration registry.
 */
public class LabelProviderImagePainter extends ImagePainter {

	public LabelProviderImagePainter() {
		super();
	}

	public LabelProviderImagePainter(boolean paintBg) {
		super(null, paintBg);
	}

	@Override
	protected Image getImage(ILayerCell cell, IConfigRegistry configRegistry) {
		Object dataValue = cell.getDataValue();

		if (dataValue instanceof IObservableValue<?>) {
			dataValue = ((IObservableValue<?>) dataValue).getValue();
		}

		LabelProviderService labelService = ServiceConfigAttributes.getService(LabelProviderService.class, configRegistry, cell);
		ILabelProvider labelProvider = (dataValue == null) ? labelService.getLabelProvider() : labelService.getLabelProvider(dataValue);

		return labelProvider.getImage(dataValue);
	}
}
