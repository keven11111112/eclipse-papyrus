/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
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

package org.eclipse.papyrus.propertylifecycle.tests.strategies.processors;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.AbstractEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.propertylifecycle.commands.LifecycleSetCommand;
import org.eclipse.papyrus.propertylifecycle.utils.CommandValueProcessor;
import org.eclipse.papyrus.uml.tools.utils.NamedElementUtil;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Property;


public class ComponentProcessor implements CommandValueProcessor {

	NamedElement element;

	@Override
	public ICommand setValueFromRequest(String featureLabel, boolean isImmutable, AbstractEditCommandRequest request) {
		return setName(request, isImmutable);
	}

	public ComponentProcessor() {

	}

	public ICommand setName(AbstractEditCommandRequest request, boolean isImmutable) {
		ICommand gmfCommand = null;

		if (request instanceof SetRequest) {
			SetRequest setRequest = (SetRequest) request;
			element = (NamedElement) setRequest.getElementToEdit();
			LifecycleSetCommand setCommand = new LifecycleSetCommand("Component_Set",
					element, setRequest.getFeature(), setRequest.getValue());
			gmfCommand = CompositeCommand.compose(gmfCommand, setCommand);

			// We want the name of the properties inside the element to change as well
			for (EObject eObject : element.eContents()) {
				if (eObject instanceof Property) {
					String initializedName = NamedElementUtil.getDefaultNameWithIncrementFromBase(element.getName() + "_property", element.eContents());
					EStructuralFeature feature = eObject.eClass().getEStructuralFeature("name");

					// The strategies will be browsed by this setRequest and a command will be constructed in the PropertyProcessor if any match
					SetRequest setPropRequest = new SetRequest(eObject, feature, initializedName);

					// SubRequest, outside of the current service edit (element) hence we can call on it again (eObject) without fear of loops
					IElementEditService provider = ElementEditServiceUtils.getCommandProvider(eObject);
					ICommand createGMFCommand = provider.getEditCommand(setPropRequest);

					gmfCommand = CompositeCommand.compose(gmfCommand, createGMFCommand);
				}
			}

			if (gmfCommand != null) {
				gmfCommand.reduce();
			}

		} else {

			if (request instanceof ConfigureRequest) {
				ConfigureRequest confRequest = (ConfigureRequest) request;
				element = (NamedElement) confRequest.getElementToConfigure();
			}
			if (request instanceof CreateElementRequest) {
				CreateElementRequest createRequest = (CreateElementRequest) request;
				element = (NamedElement) createRequest.getNewElement();
			}

			if (element != null && !isImmutable) {
				String initializedName = NamedElementUtil.getDefaultNameWithIncrementFromBase("NewComponentName", element.eContainer().eContents());
				EStructuralFeature feature = element.eClass().getEStructuralFeature("name");

				ICommand setCommand = new LifecycleSetCommand("Component_Conf&Create", element, feature, initializedName);
				gmfCommand = CompositeCommand.compose(gmfCommand, setCommand);
			}
		}

		return gmfCommand;
	}

}

