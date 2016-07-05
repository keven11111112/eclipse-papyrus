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

package org.eclipse.papyrus.sysml.propertylifecycle.processors;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.AbstractEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.papyrus.propertylifecycle.commands.LifecycleSetCommand;
import org.eclipse.papyrus.propertylifecycle.messages.Messages;
import org.eclipse.papyrus.propertylifecycle.utils.CommandValueProcessor;
import org.eclipse.papyrus.uml.tools.utils.NamedElementUtil;
import org.eclipse.uml2.uml.NamedElement;

/**
 *
 */
public class ActorPartPropertyProcessor implements CommandValueProcessor {

	@Override
	public ICommand setValueFromRequest(String featureLabel, boolean isImmutable, AbstractEditCommandRequest request) {
		return setName(request);
	}

	public ActorPartPropertyProcessor() {

	}

	public ICommand setName(AbstractEditCommandRequest request) {
		ICommand gmfCommand = null;

		if (request instanceof ConfigureRequest) {
			ConfigureRequest confRequest = (ConfigureRequest) request;

			NamedElement element = (NamedElement) confRequest.getElementToConfigure();
			EStructuralFeature feature = element.eClass().getEStructuralFeature(Messages.FEATURELABEL_NAME);
			if (element != null && feature != null) {

				// Set default name
				String initializedName = NamedElementUtil.getDefaultNameWithIncrementFromBase("actorPart", element.eContainer().eContents()); //$NON-NLS-1$
				LifecycleSetCommand setCommand = new LifecycleSetCommand("ActorPartProperty_SetName", element, feature, initializedName);
				gmfCommand = CompositeCommand.compose(gmfCommand, setCommand);
			}
		}

		return gmfCommand;
	}

}
