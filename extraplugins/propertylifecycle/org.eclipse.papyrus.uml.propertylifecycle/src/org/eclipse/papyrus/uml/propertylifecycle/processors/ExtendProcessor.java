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

package org.eclipse.papyrus.uml.propertylifecycle.processors;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.AbstractEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.papyrus.propertylifecycle.commands.LifecycleSetCommand;
import org.eclipse.papyrus.propertylifecycle.utils.CommandValueProcessor;
import org.eclipse.papyrus.uml.tools.utils.NamedElementUtil;
import org.eclipse.uml2.uml.Extend;
import org.eclipse.uml2.uml.ExtensionPoint;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UseCase;

/**
 *
 */
public class ExtendProcessor implements CommandValueProcessor {

	@Override
	public ICommand setValueFromRequest(String featureLabel, boolean isImmutable, AbstractEditCommandRequest request) {
		return setName(request);
	}

	public ExtendProcessor() {

	}

	public ICommand setName(AbstractEditCommandRequest request) {
		ICommand gmfCommand = null;

		if (request instanceof ConfigureRequest) {
			ConfigureRequest confRequest = (ConfigureRequest) request;

			Extend extend = (Extend) confRequest.getElementToConfigure();
			UseCase target = getTarget(confRequest);
			if ((target == null)) {
				return gmfCommand;
			}

			ExtensionPoint targetEnd = UMLFactory.eINSTANCE.createExtensionPoint();
			// Add extensionLocations references
			extend.getExtensionLocations().add(targetEnd);
			// Add end in the model
			target.getExtensionPoints().add(targetEnd);

			EStructuralFeature feature = targetEnd.eClass().getEStructuralFeature("name");
			String nameValue = NamedElementUtil.getDefaultNameWithIncrement(targetEnd, targetEnd.getOwner().eContents());
			LifecycleSetCommand setCommand = new LifecycleSetCommand("Extend_Set",
					targetEnd, feature, nameValue);

			gmfCommand = CompositeCommand.compose(gmfCommand, setCommand);
		}

		return gmfCommand;
	}

	/**
	 * This method provides the target type provided as {@link ConfigureRequest} parameter.
	 * 
	 * @return the target role
	 */
	protected UseCase getTarget(ConfigureRequest req) {
		UseCase result = null;
		Object paramObject = req.getParameter(CreateRelationshipRequest.TARGET);
		if (paramObject instanceof UseCase) {
			result = (UseCase) paramObject;
		}
		return result;
	}
}
