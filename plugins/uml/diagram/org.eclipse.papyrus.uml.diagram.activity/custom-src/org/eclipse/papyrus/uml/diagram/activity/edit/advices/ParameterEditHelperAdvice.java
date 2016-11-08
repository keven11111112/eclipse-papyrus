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
import org.eclipse.papyrus.uml.diagram.activity.edit.utils.updater.preferences.AutomatedModelCompletionPreferencesInitializer;
import org.eclipse.papyrus.uml.diagram.activity.edit.utils.updater.preferences.IAutomatedModelCompletionPreferencesConstants;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.tools.utils.ElementUtil;
import org.eclipse.papyrus.uml.tools.utils.PackageUtil;
import org.eclipse.uml2.uml.AcceptCallAction;
import org.eclipse.uml2.uml.AcceptEventAction;
import org.eclipse.uml2.uml.CallEvent;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Parameter;
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
		// 1] check if the setFeature is Name, Type or Multiplicity
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
				if (!command.isEmpty()) {
					return command;
				}
			}
		}
		return super.getAfterSetCommand(request);
	}
}
