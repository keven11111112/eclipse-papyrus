/*****************************************************************************
 * Copyright (c) 2011, 2015 CEA LIST, Christian W. Damus, and others.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 		Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *      Christian W. Damus - bug 458685
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.service.types.helper;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.papyrus.infra.gmfdiag.common.helper.DefaultEditHelper;
import org.eclipse.papyrus.infra.services.edit.commands.IConfigureCommandFactory;
import org.eclipse.uml2.uml.Element;

/**
 * <pre>
 * 
 * Edit helper class for {@link Element}
 * 
 * Expected behavior:
 * - Removes any stereotype application before deletion
 * 
 * The configure command allows contributions provided by the request parameters.
 * </pre>
 */
public class ElementEditHelper extends DefaultEditHelper {


	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ICommand getConfigureCommand(ConfigureRequest req) {
		if (req.getParameter(IConfigureCommandFactory.CONFIGURE_COMMAND_FACTORY_ID) != null) {
			IConfigureCommandFactory factory = (IConfigureCommandFactory) req.getParameter(IConfigureCommandFactory.CONFIGURE_COMMAND_FACTORY_ID);
			return factory.create(req);
		}
		return super.getConfigureCommand(req);
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected Map<EClass, EReference> getDefaultContainmentFeatures() {
		return super.getDefaultContainmentFeatures();
	}

}
