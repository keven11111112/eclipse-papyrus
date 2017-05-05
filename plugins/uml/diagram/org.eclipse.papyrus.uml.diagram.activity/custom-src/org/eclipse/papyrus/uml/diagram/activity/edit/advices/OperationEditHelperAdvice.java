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
import org.eclipse.uml2.uml.CallEvent;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Trigger;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Automated pin derivation for AcceptEventAction and AcceptCallAction
 * 
 * Call pin derivation command on modification of an operation
 * @since 3.0
 */
public class OperationEditHelperAdvice extends AbstractEditHelperAdvice {

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
		// 1] check if the setFeature is ownedParameter
		if (request.getFeature().equals(UMLPackage.eINSTANCE.getBehavioralFeature_OwnedParameter())) {
			final IPreferenceStore prefStore = Activator.getDefault().getPreferenceStore();
			boolean synchronizePinPreference = false;
			CompositeCommand command = new CompositeCommand("Update operation"); //$NON-NLS-1$
			Operation operation = (Operation) request.getElementToEdit();
			Package root = PackageUtil.getRootPackage(operation);
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
									if (((CallEvent) t.getEvent()).getOperation() == operation) {
										// 6] call the command for the acceptCallAction whose trigger reference a callEvent which reference the operation
										IPinUpdater<AcceptCallAction> updater = PinUpdaterFactory.getInstance().instantiate(acceptCallAction);
										return new PinUpdateCommand<AcceptCallAction>("Update accept event action pins", updater, acceptCallAction); //$NON-NLS-1$
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
