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

package org.eclipse.papyrus.infra.gmfdiag.common.parsers;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.infra.gmfdiag.tooling.runtime.parsers.AbstractAttributeParser;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;

/**
 * Attribute parser that uses the service edit to modify the attribute rather than directly create the command from a SetRequest
 */
public abstract class AbstractElementTypeBasedAttributeParser extends AbstractAttributeParser {

	public AbstractElementTypeBasedAttributeParser(EAttribute[] features) {
		super(features);
	}

	public AbstractElementTypeBasedAttributeParser(EAttribute[] features, EAttribute[] editableFeatures) {
		super(features, editableFeatures);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ICommand getModificationCommand(EObject element, EStructuralFeature feature, Object value) {
		value = getValidNewValue(feature, value);
		if (value instanceof InvalidValue) {
			return UnexecutableCommand.INSTANCE;
		}
		SetRequest request = new SetRequest(element, feature, value);

		// use service edit here
		IElementEditService service = ElementEditServiceUtils.getCommandProvider(element);
		if (service != null) {
			return service.getEditCommand(request);
		}

		// no service edit => return standard command
		return new SetValueCommand(request);
	}

}
