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

import org.eclipse.uml2.uml.CallOperationAction;
import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.UMLFactory;

public class CallOperationActionPinUpdater extends AbstractCallActionPinUpdater<CallOperationAction> {

	/**
	 * @see org.eclipse.papyrus.uml.diagram.activity.edit.utils.updater.AbstractCallActionPinUpdater#updatePins(org.eclipse.uml2.uml.CallAction)
	 *
	 * @param node
	 */
	@Override
	public void updatePins(CallOperationAction node) {
		// Update both arguments and results
		super.updatePins(node);
		// Ensure a target is set for this operation call
		InputPin targetPin = this.deriveTarget(node);
		if (node.getTarget() == null) {
			node.setTarget(targetPin);
		} else {
			update(node.getTarget(), targetPin);
		}
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.activity.edit.utils.updater.AbstractInvocationActionPinUpdater#deriveTarget(org.eclipse.uml2.uml.InvocationAction)
	 *
	 * @param node
	 * @return
	 */
	@Override
	public InputPin deriveTarget(CallOperationAction node) {
		InputPin pinTarget = UMLFactory.eINSTANCE.createInputPin();
		pinTarget.setLower(1);
		pinTarget.setUpper(1);
		pinTarget.setName(TARGET_NAME);
		if (node.getOperation() != null) {
			pinTarget.setType(node.getOperation().getClass_());
		}
		return pinTarget;
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.activity.edit.utils.updater.AbstractInvocationActionPinUpdater#deriveArguments(org.eclipse.uml2.uml.InvocationAction)
	 *
	 * @param node
	 * @return
	 */
	@Override
	public List<InputPin> deriveArguments(CallOperationAction node) {
		List<InputPin> derivedInputPins = new ArrayList<InputPin>();
		if (node.getOperation() != null) {
			for (Parameter parameter : node.getOperation().getOwnedParameters()) {
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

	/**
	 * @see org.eclipse.papyrus.uml.diagram.activity.edit.utils.updater.AbstractCallActionPinUpdater#deriveResults(org.eclipse.uml2.uml.CallAction)
	 *
	 * @param node
	 * @return
	 */
	@Override
	public List<OutputPin> deriveResults(CallOperationAction node) {
		List<OutputPin> derivedOutputPins = new ArrayList<OutputPin>();
		if (node.getOperation() != null) {
			for (Parameter parameter : node.getOperation().getOwnedParameters()) {
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


}
