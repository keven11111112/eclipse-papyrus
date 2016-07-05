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

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.AbstractEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.propertylifecycle.commands.LifecycleSetCommand;
import org.eclipse.papyrus.propertylifecycle.utils.CommandValueProcessor;
import org.eclipse.papyrus.uml.tools.utils.NamedElementUtil;
import org.eclipse.uml2.uml.NamedElement;

public class SysmlBlockProcessor implements CommandValueProcessor {

	NamedElement element;

	@Override
	public ICommand setValueFromRequest(String featureLabel, boolean isImmutable, AbstractEditCommandRequest request) {
		return setName(request, isImmutable);
	}

	public SysmlBlockProcessor() {

	}

	public ICommand setName(AbstractEditCommandRequest request, boolean isImmutable) {
		ICommand compositeCommand = null;

		if (request instanceof ConfigureRequest) {
			ConfigureRequest confRequest = (ConfigureRequest) request;
			element = (NamedElement) confRequest.getElementToConfigure();
		}

		if (request instanceof CreateElementRequest) {
			CreateElementRequest createRequest = (CreateElementRequest) request;
			element = (NamedElement) createRequest.getNewElement();
		}

		if (element != null && !isImmutable) {
			String initializedName = NamedElementUtil.getDefaultNameWithIncrementFromBase("NewSysmlBlockName", element.eContainer().eContents());
			EStructuralFeature feature = element.eClass().getEStructuralFeature("name");

			ICommand setCommand = new LifecycleSetCommand("SysmlBlock_Conf&Create", element, feature, initializedName);
			compositeCommand = CompositeCommand.compose(compositeCommand, setCommand);
		}

		return compositeCommand;
	}

}
