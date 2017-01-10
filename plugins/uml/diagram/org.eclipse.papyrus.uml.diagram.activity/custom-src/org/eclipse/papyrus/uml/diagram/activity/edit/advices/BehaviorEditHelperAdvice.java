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
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.StartObjectBehaviorAction;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * 
 * Pins of StartObjectBehaviorAction should be create and update automatically
 *
 */
public class BehaviorEditHelperAdvice extends AbstractEditHelperAdvice {

	/**
	 * @see org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice#getAfterEditCommand(org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest)
	 *
	 * @param request
	 * @return
	 */
	@Override
	public ICommand getAfterSetCommand(SetRequest request) {
		// 1] check if the setFeature is ownedParameter
		if (request.getFeature().equals(UMLPackage.eINSTANCE.getBehavior_OwnedParameter())) {
			final IPreferenceStore prefStore = Activator.getDefault().getPreferenceStore();
			boolean synchronizePin = false;
			CompositeCommand command = new CompositeCommand("Update pins on modification of a behavior"); //$NON-NLS-1$
			// 2] get the preference for StartObjectBehaviorAction
			synchronizePin = (prefStore.getString(IAutomatedModelCompletionPreferencesConstants.START_OBJECT_BEHAVIOR_ACTION).equals(AutomatedModelCompletionPreferencesInitializer.PIN_SYNCHRONIZATION));
			// 3] check preference
			if (synchronizePin) {
				Behavior behavior = (Behavior) request.getElementToEdit();
				Package root = PackageUtil.getRootPackage(behavior);
				if (root != null) {
					// 4] get all StartObjectBehaviorAction
					List<StartObjectBehaviorAction> allStartObjectBehaviorAction = ElementUtil.getInstancesFilteredByType(root, StartObjectBehaviorAction.class, null);
					// 5] loop into the list of StartObjectBehaviorAction
					for (StartObjectBehaviorAction startObjectBehaviorAction : allStartObjectBehaviorAction) {
						if (startObjectBehaviorAction.behavior() == behavior) {
							// 6] call the command for the StartObjectBehaviorAction which has as behavior the current one
							IPinUpdater<StartObjectBehaviorAction> updater = PinUpdaterFactory.getInstance().instantiate(startObjectBehaviorAction);
							command.add(new PinUpdateCommand<StartObjectBehaviorAction>("Update start object behavior action pins", updater, startObjectBehaviorAction)); //$NON-NLS-1$
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
