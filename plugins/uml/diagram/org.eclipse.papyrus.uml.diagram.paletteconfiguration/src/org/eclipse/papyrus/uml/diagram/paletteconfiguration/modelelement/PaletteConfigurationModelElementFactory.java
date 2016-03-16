/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Mickael ADAM (ALL4TEC) mickael.adam@all4tec.net - Initial API and Implementation
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.paletteconfiguration.modelelement;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.properties.contexts.DataContextElement;
import org.eclipse.papyrus.infra.properties.ui.modelelement.EMFModelElement;
import org.eclipse.papyrus.infra.properties.ui.modelelement.EMFModelElementFactory;
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.Configuration;
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.PaletteConfiguration;

/**
 * The model element factory or palette configuration.
 */
public class PaletteConfigurationModelElementFactory extends EMFModelElementFactory {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected EMFModelElement doCreateFromSource(final Object sourceElement, final DataContextElement context) {
		EMFModelElement modelElement = null;
		EditingDomain domain = EMFHelper.resolveEditingDomain(sourceElement);
		if ("PaletteConfiguration".equals(context.getName()) && sourceElement instanceof PaletteConfiguration) {//$NON-NLS-1$
			modelElement = new PaletteConfigurationModelElement(((PaletteConfiguration) sourceElement), domain);
		} else if ("Configuration".equals(context.getName()) && sourceElement instanceof Configuration) {//$NON-NLS-1$
			// Create the modelElement
			modelElement = new ConfigurationModelElement(((Configuration) sourceElement), domain);
		} else {
			modelElement = super.doCreateFromSource(sourceElement, context);
		}
		return modelElement;
	}

}
