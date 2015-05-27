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
 * 		Christian W. Damus - bug 467016
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.service.types.helper;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.papyrus.infra.gmfdiag.common.helper.DefaultEditHelper;
import org.eclipse.papyrus.infra.services.edit.commands.IConfigureCommandFactory;
import org.eclipse.papyrus.uml.tools.model.UmlUtils;
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

	@Override
	protected boolean approveRequest(IEditCommandRequest request) {
		boolean result = super.approveRequest(request);

		if (!result) {
			if (request instanceof CreateElementRequest) {
				// Bug 467016: Maybe the "containment" reference isn't actually a containment but subsets one?
				// e.g., BehavioredClassifier::classifierBehavior subsets BehavioredClassifier::ownedBehavior
				Object context = request.getEditHelperContext();
				if (context instanceof EObject) {
					EObject owner = (EObject) context;
					EReference reference = getContainmentFeature((CreateElementRequest) request);
					if ((reference != null) && reference.getEContainingClass().isSuperTypeOf(owner.eClass()) && !reference.isContainment()) {
						// Look for containment superset. UML2 will do the right thing and add the new
						// element implicitly to that superset
						for (EReference next : UmlUtils.getSupersets(reference)) {
							if (next.isContainment()) {
								result = true;
								break;
							}
						}
					}
				}
			}
		}

		return result;
	}
}
