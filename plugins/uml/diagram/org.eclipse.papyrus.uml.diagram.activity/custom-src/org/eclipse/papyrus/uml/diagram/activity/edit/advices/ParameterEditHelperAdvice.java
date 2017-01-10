/*****************************************************************************
 * Copyright (c) 2017 CEA LIST and others.
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

package org.eclipse.papyrus.uml.diagram.activity.edit.advices;

import java.util.List;

import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.uml.diagram.activity.edit.commands.util.PinUpdateCommand;
import org.eclipse.papyrus.uml.diagram.activity.edit.utils.updater.IPinUpdater;
import org.eclipse.papyrus.uml.diagram.activity.edit.utils.updater.PinUpdaterFactory;
import org.eclipse.papyrus.uml.diagram.activity.edit.utils.updater.intermediateactions.StartObjectBehaviorActionPinUpdater;
import org.eclipse.papyrus.uml.diagram.activity.edit.utils.updater.preferences.AutomatedModelCompletionPreferencesInitializer;
import org.eclipse.papyrus.uml.diagram.activity.edit.utils.updater.preferences.IAutomatedModelCompletionPreferencesConstants;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.tools.utils.ElementUtil;
import org.eclipse.papyrus.uml.tools.utils.PackageUtil;
import org.eclipse.uml2.uml.AcceptCallAction;
import org.eclipse.uml2.uml.AcceptEventAction;
import org.eclipse.uml2.uml.CallEvent;
import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.Pin;
import org.eclipse.uml2.uml.StartObjectBehaviorAction;
import org.eclipse.uml2.uml.Trigger;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Automated pin derivation for AcceptEventAction and AcceptCallAction
 * 
 * Call pin derivation command on modification of a parameter
 */
public class ParameterEditHelperAdvice extends AbstractEditHelperAdvice {

	/**
	 * This method call command to synchronize pin
	 * 
	 * @see org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice#getAfterEditCommand(org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest)
	 *
	 * @param request
	 * @return
	 */
	@Override
	public ICommand getAfterSetCommand(SetRequest request) {
		// 1] check if the setFeature is Name, Type, Direction or Multiplicity
		if (request.getFeature().equals(UMLPackage.eINSTANCE.getTypedElement_Type()) ||
				request.getFeature().equals(UMLPackage.eINSTANCE.getMultiplicityElement_Lower()) ||
				request.getFeature().equals(UMLPackage.eINSTANCE.getMultiplicityElement_Upper()) ||
				request.getFeature().equals(UMLPackage.eINSTANCE.getParameter_Direction()) ||
				request.getFeature().equals(UMLPackage.eINSTANCE.getNamedElement_Name())) {
			final IPreferenceStore prefStore = Activator.getDefault().getPreferenceStore();
			boolean synchronizePinPreference = false;
			CompositeCommand command = new CompositeCommand("Update parameter"); //$NON-NLS-1$
			Parameter parameter = (Parameter) request.getElementToEdit();
			Package root = PackageUtil.getRootPackage(parameter);
			if (root != null) {
				// 2] check the preference for AcceptCallEvent
				synchronizePinPreference = (prefStore.getString(IAutomatedModelCompletionPreferencesConstants.ACCEPT_CALL_ACTION_ACCELERATOR).equals(AutomatedModelCompletionPreferencesInitializer.PIN_SYNCHRONIZATION));
				if (synchronizePinPreference) {
					// 3] get allAcceptCallAction
					List<AcceptCallAction> allAcceptCallAction = ElementUtil.getInstancesFilteredByType(root, AcceptCallAction.class, null);
					for (AcceptCallAction acceptCallAction : allAcceptCallAction) {
						if (acceptCallAction instanceof AcceptCallAction) {
							for (Trigger t : acceptCallAction.getTriggers()) {
								if (t.getEvent() instanceof CallEvent) {
									for (Parameter p : ((CallEvent) t.getEvent()).getOperation().getOwnedParameters()) {
										if (p == parameter) {
											// 4] call the command for the acceptEventAction whose trigger reference a callEvent
											// which reference an operation which owned the parameter
											IPinUpdater<AcceptEventAction> updater = PinUpdaterFactory.getInstance().instantiate(acceptCallAction);
											command.add(new PinUpdateCommand<AcceptEventAction>("Update accept event action pins", updater, acceptCallAction)); //$NON-NLS-1$
										}
									}
								}
							}
						}
					}
				}
				// Pins of StartObjectBehaviorAction should be create and update automatically
				// 1] get the preference for StartObjectBehaviorAction
				synchronizePinPreference = (prefStore.getString(IAutomatedModelCompletionPreferencesConstants.START_OBJECT_BEHAVIOR_ACTION).equals(AutomatedModelCompletionPreferencesInitializer.PIN_SYNCHRONIZATION));
				// 2] check preference
				if (synchronizePinPreference) {
					// 3] get all StartObjectBehaviorAction
					List<StartObjectBehaviorAction> allStartObjectBahaviorAction = ElementUtil.getInstancesFilteredByType(root, StartObjectBehaviorAction.class, null);
					// 4] loop into the list of StartObjectBehaviorAction
					for (StartObjectBehaviorAction startObjectBehaviorAction : allStartObjectBahaviorAction) {
						if (isParameterReferenceAPin(parameter, startObjectBehaviorAction.getArguments())) {
							// 5] call the command for the StartObjectBehaviorAction if the action has an argument pin referencing the current parameter
							IPinUpdater<StartObjectBehaviorAction> updater = new StartObjectBehaviorActionPinUpdater();
							command.add(new PinUpdateCommand<StartObjectBehaviorAction>("Update start object behavior action pins", updater, startObjectBehaviorAction)); //$NON-NLS-1$
						}
						if (isParameterReferenceAPin(parameter, startObjectBehaviorAction.getResults())) {
							// 6] call the command for the StartObjectBehaviorAction if the action has an result pin referencing the current parameter
							IPinUpdater<StartObjectBehaviorAction> updater = new StartObjectBehaviorActionPinUpdater();
							command.add(new PinUpdateCommand<StartObjectBehaviorAction>("Update start object behavior action pins", updater, startObjectBehaviorAction)); //$NON-NLS-1$
						}
					}
				}
			}
			if (!command.isEmpty()) {
				return command;
			}
		}
		return super.getAfterSetCommand(request);
	}

	/**
	 * This method checks if a pin of the pins list is matching for the parameter
	 * 
	 * @param parameter
	 * @param pins
	 * @return true if at least one pin of the list is matching
	 */
	private static boolean isParameterReferenceAPin(Parameter parameter, List<? extends Pin> pins) {
		for (Pin pin : pins) {
			if (pinParameterMatch(pin, parameter)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * This method check if the pin and the parameter are matching
	 * Matching condition:
	 * -output pin if the direction of parameter is out or return
	 * -input pin if the direction of parameter is in
	 * -name of the pin corresponding to the parameter name with optional string before it
	 * (example: "[in] foo" where foo is the name parameter)
	 * -multiplicity are matching
	 * 
	 * @param pin
	 * @param parameter
	 * @return true if pin and parameter are matching
	 */
	private static <P extends Pin> boolean pinParameterMatch(P pin, Parameter parameter) {
		boolean match = true;
		match = pin.getType() == parameter.getType();
		// 1] check if the direction is correct
		if (parameter.getDirection() == ParameterDirectionKind.OUT_LITERAL |
				parameter.getDirection() == ParameterDirectionKind.RETURN_LITERAL) {
			match = pin instanceof OutputPin;
		} else if (parameter.getDirection() == ParameterDirectionKind.IN_LITERAL) {
			match = pin instanceof InputPin;
		}
		// 2] check if the name of the pin match with the name of the parameter (with or without [in/out])
		if (match && parameter.getName() != null) {
			if (pin.getName().matches("\\[[a-z]+\\]\\s.*")) {
				match = pin.getName().replaceFirst("\\[[a-z]+\\]\\s", "").equals(parameter.getName());
			} else {
				match = pin.getName().equals(parameter.getName());
			}
		}
		// 3] check if the multiplicity is correct
		if (match) {
			match = pin.getLower() == parameter.getLower();
			if (match) {
				match = pin.getUpper() == parameter.getUpper();
			}
		}
		return match;
	}
}
