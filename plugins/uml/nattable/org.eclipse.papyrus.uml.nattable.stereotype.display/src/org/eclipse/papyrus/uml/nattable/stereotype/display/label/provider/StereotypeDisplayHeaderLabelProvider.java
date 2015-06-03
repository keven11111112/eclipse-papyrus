/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
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

package org.eclipse.papyrus.uml.nattable.stereotype.display.label.provider;

import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;
import org.eclipse.papyrus.infra.emf.nattable.provider.EMFFeatureHeaderLabelProvider;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.FeatureLabelProviderConfiguration;
import org.eclipse.papyrus.infra.nattable.utils.AxisUtils;
import org.eclipse.papyrus.infra.nattable.utils.ILabelProviderContextElementWrapper;
import org.eclipse.papyrus.uml.nattable.stereotype.display.utils.StereotypeDisplayTreeTableConstants;

/**
 * @author Céline JANSSENS
 *
 */
public class StereotypeDisplayHeaderLabelProvider extends EMFFeatureHeaderLabelProvider {

	/**
	 *
	 * @see org.eclipse.papyrus.infra.nattable.provider.AbstractNattableCellLabelProvider#accept(java.lang.Object)
	 *
	 * @param element
	 * @return
	 *         <code>true</code> if we are looking for the label of an EStructuralFeature
	 */
	@Override
	public boolean accept(Object element) {

		if (element instanceof ILabelProviderContextElementWrapper) {
			Object wrappedElement = ((ILabelProviderContextElementWrapper) element).getObject();
			Object object = AxisUtils.getRepresentedElement(wrappedElement);
			if (object instanceof String) {
				if (((String) object).startsWith(StereotypeDisplayTreeTableConstants.PREFIX)) {
					return true;
				}
			}
		}

		return false;
	}

	@Override
	protected String getText(FeatureLabelProviderConfiguration featureConf, final IConfigRegistry configRegistry, final String name, final Object type, final boolean isDerived, final int lowerBound, final int upperBounds) {
		// we collect the required values
		String text = "";
		boolean displayName = false;
		try {
			displayName = featureConf.isDisplayName();
		} catch (Exception e) {
			// Activator.log.error(e);
		}

		if (displayName) {
			text = name;
		}

		return text;
	}

}
