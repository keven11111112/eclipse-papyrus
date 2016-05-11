/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Jérémie TATIBOUET (CEA LIST) - Initial API and implementation
 *   Sébastien REVOL (CEA LIST) - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.activity.edit.utils.updater;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.uml2.uml.CallBehaviorAction;
import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.UMLFactory;

public class CallBehaviorActionPinUpdater extends AbstractCallActionPinUpdater<CallBehaviorAction> {

	/**
	 * @see org.eclipse.papyrus.uml.diagram.activity.edit.utils.updater.AbstractCallActionPinUpdater#deriveResults()
	 *
	 * @return
	 */
	@Override
	public List<OutputPin> deriveResults(CallBehaviorAction node) {
		List<OutputPin> derivedOutputPins = new ArrayList<OutputPin>();
		if (node.getBehavior() != null) {
			for (Parameter parameter : node.getBehavior().getOwnedParameters()) {
				if (parameter.getDirection() == ParameterDirectionKind.INOUT_LITERAL
						|| parameter.getDirection() == ParameterDirectionKind.RETURN_LITERAL
						|| parameter.getDirection() == ParameterDirectionKind.OUT_LITERAL) {
					OutputPin derivedPin = UMLFactory.eINSTANCE.createOutputPin();
					derivedPin.setType(parameter.getType());
					derivedPin.setLower(parameter.getLower());
					derivedPin.setUpper(parameter.getUpper());
					if (parameter.getDirection() == ParameterDirectionKind.INOUT_LITERAL) {
						derivedPin.setName("[out] " + parameter.getName());
					} else {
						derivedPin.setName(parameter.getName());
					}
					derivedOutputPins.add(derivedPin);
				}
			}
		}
		return derivedOutputPins;
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.activity.edit.utils.updater.AbstractInvocationActionPinUpdater#deriveArguments()
	 *
	 * @return
	 */
	@Override
	public List<InputPin> deriveArguments(CallBehaviorAction node) {
		List<InputPin> derivedInputPins = new ArrayList<InputPin>();
		if (node.getBehavior() != null) {
			for (Parameter parameter : node.getBehavior().getOwnedParameters()) {
				if (parameter.getDirection() == ParameterDirectionKind.INOUT_LITERAL
						|| parameter.getDirection() == ParameterDirectionKind.IN_LITERAL) {
					InputPin derivedPin = UMLFactory.eINSTANCE.createInputPin();
					derivedPin.setType(parameter.getType());
					derivedPin.setLower(parameter.getLower());
					derivedPin.setUpper(parameter.getUpper());
					if (parameter.getDirection() == ParameterDirectionKind.INOUT_LITERAL) {
						derivedPin.setName("[in] " + parameter.getName());
					} else {
						derivedPin.setName(parameter.getName());
					}
					derivedInputPins.add(derivedPin);
				}
			}
		}
		return derivedInputPins;
	}

}
