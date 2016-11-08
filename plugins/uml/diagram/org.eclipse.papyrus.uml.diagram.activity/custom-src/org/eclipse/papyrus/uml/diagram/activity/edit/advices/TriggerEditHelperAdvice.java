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
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Trigger;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Automated pin derivation for AcceptEventAction and AcceptCallAction
 *
 * Call pin derivation command on modification of a trigger
 */
public class TriggerEditHelperAdvice extends AbstractEditHelperAdvice {

	/**
	 * @see org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice#getAfterEditCommand(org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest)
	 *
	 * @param request
	 * @return
	 */
	@Override
	public ICommand getAfterSetCommand(SetRequest request) {
		// 1] check if the setFeature is event
		if (request.getFeature().equals(UMLPackage.eINSTANCE.getTrigger_Event())) {
			final IPreferenceStore prefStore = Activator.getDefault().getPreferenceStore();
			boolean synchronizePinPreference = false;
			CompositeCommand command = new CompositeCommand("Update trigger"); //$NON-NLS-1$
			Trigger trigger = (Trigger) request.getElementToEdit();
			Package root = PackageUtil.getRootPackage(trigger);
			if (root != null) {
				List<AcceptEventAction> allAcceptEventAction = null;
				// 2] check the preference for AcceptEventAction
				synchronizePinPreference = (prefStore.getString(IAutomatedModelCompletionPreferencesConstants.ACCEPTE_EVENT_ACTION_ACCELERATOR).equals(AutomatedModelCompletionPreferencesInitializer.PIN_SYNCHRONIZATION));
				if (synchronizePinPreference) {
					// 3] get all AcceptEventAction
					allAcceptEventAction = ElementUtil.getInstancesFilteredByType(root, AcceptEventAction.class, null);
					for (AcceptEventAction acceptEventAction : allAcceptEventAction) {
						if (!(acceptEventAction instanceof AcceptCallAction)) {
							for (Trigger t : acceptEventAction.getTriggers()) {
								if (t == trigger) {
									// 4] call the command for the acceptEventAction whose trigger is equal to the current one
									IPinUpdater<AcceptEventAction> updater = PinUpdaterFactory.getInstance().instantiate(acceptEventAction);
									command.add(new PinUpdateCommand<AcceptEventAction>("Update accept event action pins", updater, acceptEventAction)); //$NON-NLS-1$
								}
							}
						}
					}
				}
				// 5] check the preference for AcceptCallEvent
				synchronizePinPreference = (prefStore.getString(IAutomatedModelCompletionPreferencesConstants.ACCEPT_CALL_ACTION_ACCELERATOR).equals(AutomatedModelCompletionPreferencesInitializer.PIN_SYNCHRONIZATION));
				if (synchronizePinPreference) {
					// 6] get allAcceptEventAction if we don't get it before
					if (allAcceptEventAction == null) {
						allAcceptEventAction = ElementUtil.getInstancesFilteredByType(root, AcceptEventAction.class, null);
					}
					for (AcceptEventAction acceptEventAction : allAcceptEventAction) {
						if (acceptEventAction instanceof AcceptCallAction) {
							for (Trigger t : acceptEventAction.getTriggers()) {
								if (t == trigger) {
									// 7] call the command for the acceptEventAction whose trigger is equal to the current one
									IPinUpdater<AcceptEventAction> updater = PinUpdaterFactory.getInstance().instantiate(acceptEventAction);
									command.add(new PinUpdateCommand<AcceptEventAction>("Update accept event action pins", updater, acceptEventAction)); //$NON-NLS-1$
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
