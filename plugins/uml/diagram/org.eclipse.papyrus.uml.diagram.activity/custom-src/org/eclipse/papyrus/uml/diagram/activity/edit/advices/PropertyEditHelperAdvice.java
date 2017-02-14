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
import org.eclipse.papyrus.uml.diagram.activity.edit.commands.util.PinUpdateLinkEndDataCommand;
import org.eclipse.papyrus.uml.diagram.activity.edit.utils.updater.IPinUpdater;
import org.eclipse.papyrus.uml.diagram.activity.edit.utils.updater.IPinUpdaterLinkEndData;
import org.eclipse.papyrus.uml.diagram.activity.edit.utils.updater.PinUpdaterFactory;
import org.eclipse.papyrus.uml.diagram.activity.edit.utils.updater.intermediateactions.LinkEndCreationDataPinUpdater;
import org.eclipse.papyrus.uml.diagram.activity.edit.utils.updater.intermediateactions.LinkEndDataPinUpdater;
import org.eclipse.papyrus.uml.diagram.activity.edit.utils.updater.intermediateactions.LinkEndDestructionDataPinUpdater;
import org.eclipse.papyrus.uml.diagram.activity.edit.utils.updater.preferences.AutomatedModelCompletionPreferencesInitializer;
import org.eclipse.papyrus.uml.diagram.activity.edit.utils.updater.preferences.IAutomatedModelCompletionPreferencesConstants;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.tools.utils.ElementUtil;
import org.eclipse.papyrus.uml.tools.utils.PackageUtil;
import org.eclipse.uml2.uml.AcceptCallAction;
import org.eclipse.uml2.uml.AcceptEventAction;
import org.eclipse.uml2.uml.AddStructuralFeatureValueAction;
import org.eclipse.uml2.uml.LinkEndCreationData;
import org.eclipse.uml2.uml.LinkEndData;
import org.eclipse.uml2.uml.LinkEndDestructionData;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.ReadStructuralFeatureAction;
import org.eclipse.uml2.uml.SignalEvent;
import org.eclipse.uml2.uml.Trigger;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Automated pin derivation for AcceptEventAction and AcceptCallAction
 * 
 * Call pin derivation command on modification of a property
 */
public class PropertyEditHelperAdvice extends AbstractEditHelperAdvice {

	/**
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
				request.getFeature().equals(UMLPackage.eINSTANCE.getNamedElement_Name())) {
			final IPreferenceStore prefStore = Activator.getDefault().getPreferenceStore();
			boolean synchronizePinPreference = false;
			CompositeCommand command = new CompositeCommand("Update pins on modification of a property"); //$NON-NLS-1$
			Property property = (Property) request.getElementToEdit();
			Package root = PackageUtil.getRootPackage(property);
			if (root != null) {
				List<AcceptEventAction> allAcceptEventAction = null;
				// 2] check the preference for AcceptEventAction
				synchronizePinPreference = (prefStore.getString(IAutomatedModelCompletionPreferencesConstants.ACCEPTE_EVENT_ACTION_ACCELERATOR).equals(AutomatedModelCompletionPreferencesInitializer.PIN_SYNCHRONIZATION));
				if (synchronizePinPreference) {
					// 3] get all AcceptEventAction
					allAcceptEventAction = ElementUtil.getInstancesFilteredByType(root, AcceptEventAction.class, null);
					for (AcceptEventAction acceptEventAction : allAcceptEventAction) {
						if (!(acceptEventAction instanceof AcceptCallAction)) { // instance of AcceptEventAction and not AcceptCallEvent
							for (Trigger t : acceptEventAction.getTriggers()) {
								if (t.getEvent() instanceof SignalEvent) {
									for (Property p : ((SignalEvent) t.getEvent()).getSignal().getAllAttributes()) { // get all properties including those inherited from its parents
										if (p == property) {
											// 4] call the command for the acceptEventAction whose trigger reference a signalEvent
											// which reference an signal which owned the property
											IPinUpdater<AcceptEventAction> updater = PinUpdaterFactory.getInstance().instantiate(acceptEventAction);
											command.add(new PinUpdateCommand<AcceptEventAction>("Update accept event action pins", updater, acceptEventAction)); //$NON-NLS-1$
										}
									}
								}
							}
						}
					}
				}
				// Pins of CreateLinkAction should be create and update automatically
				List<LinkEndData> allLinkEndData = null;
				// 1] get the preference for CreateLinkAction
				synchronizePinPreference = (prefStore.getString(IAutomatedModelCompletionPreferencesConstants.CREATE_LINK_ACTION_ACCELERATOR).equals(AutomatedModelCompletionPreferencesInitializer.PIN_SYNCHRONIZATION));
				// 2] check preference
				if (synchronizePinPreference) {
					// 3] get all LinkEndData
					allLinkEndData = ElementUtil.getInstancesFilteredByType(root, LinkEndData.class, null);
					// 4] loop into the list of LinkEndCreationData
					for (LinkEndData linkEndCreationData : allLinkEndData) {
						if (linkEndCreationData instanceof LinkEndCreationData && linkEndCreationData.getEnd() == property) {
							// 5] call the command for the CreateLinkAction owning the LinkEndCreationData
							IPinUpdaterLinkEndData updater = new LinkEndCreationDataPinUpdater();
							command.add(new PinUpdateLinkEndDataCommand("Update link end data pins", updater, linkEndCreationData)); //$NON-NLS-1$
						}
					}
				}
				// Pins of DestroyLinkAction should be create and update automatically
				// 1] get the preference for DestroyLinkAction
				synchronizePinPreference = (prefStore.getString(IAutomatedModelCompletionPreferencesConstants.DESTROY_LINK_ACTION_ACCELERATOR).equals(AutomatedModelCompletionPreferencesInitializer.PIN_SYNCHRONIZATION));
				// 2] check preference
				if (synchronizePinPreference) {
					// 3] get all LinkEndDestructionData if not get yet
					if (allLinkEndData == null) {
						allLinkEndData = ElementUtil.getInstancesFilteredByType(root, LinkEndData.class, null);
					}
					// 4] loop into the list of LinkEndDestructionData
					for (LinkEndData linkEndDestructionData : allLinkEndData) {
						if (linkEndDestructionData instanceof LinkEndDestructionData && linkEndDestructionData.getEnd() == property) {
							// 5] call the command for the DestroyLinkAction owning the LinkEndDestructionData
							IPinUpdaterLinkEndData updater = new LinkEndDestructionDataPinUpdater();
							command.add(new PinUpdateLinkEndDataCommand("Update link end data pins", updater, linkEndDestructionData)); //$NON-NLS-1$
						}
					}
				}
				// Pins of ReadLinkAction should be create and update automatically
				// 1] get the preference for ReadLinkAction
				synchronizePinPreference = (prefStore.getString(IAutomatedModelCompletionPreferencesConstants.READ_LINK_ACTION_ACCELERATOR).equals(AutomatedModelCompletionPreferencesInitializer.PIN_SYNCHRONIZATION));
				// 2] check preference
				if (synchronizePinPreference) {
					// 3] get all LinkEndData if not get yet
					if (allLinkEndData == null) {
						allLinkEndData = ElementUtil.getInstancesFilteredByType(root, LinkEndData.class, null);
					}
					// 4] loop into the list of LinkEndDestructionData
					for (LinkEndData linkEndData : allLinkEndData) {
						if (!(linkEndData instanceof LinkEndCreationData || linkEndData instanceof LinkEndDestructionData)) {
							if (linkEndData.getEnd() == property) {
								// 5] call the command for the DestroyLinkAction owning the LinkEndDestructionData
								IPinUpdaterLinkEndData updater = new LinkEndDataPinUpdater();
								command.add(new PinUpdateLinkEndDataCommand("Update link end data pins", updater, linkEndData)); //$NON-NLS-1$
							}
						}
					}
				}
				// check if the setFeature is not Name (only type and multiplicity is interesting)
				if (!request.getFeature().equals(UMLPackage.eINSTANCE.getNamedElement_Name())) {
					// Pins of ReadStructuralFeatureAction should be create and update automatically
					// 1] get the preference for ReadStructuralFeatureAction
					synchronizePinPreference = prefStore.getString(IAutomatedModelCompletionPreferencesConstants.READ_STRUCTURAL_FEATURE_ACTION_ACCELERATOR).equals(AutomatedModelCompletionPreferencesInitializer.PIN_SYNCHRONIZATION);
					// 2] check preference
					if (synchronizePinPreference) {
						// 3] get all ReadStructuralFeatureAction
						List<ReadStructuralFeatureAction> allReadStructuralFeatureAction = ElementUtil.getInstancesFilteredByType(root, ReadStructuralFeatureAction.class, null);
						// 4] loop into the list of ReadStructuralFeatureAction
						for (ReadStructuralFeatureAction readStructuralFeatureAction : allReadStructuralFeatureAction) {
							if (readStructuralFeatureAction.getStructuralFeature() == property) {
								// 5] call the command for the ReadStructuralFeatureAction whose the structuralFeature reference the property
								IPinUpdater<ReadStructuralFeatureAction> updater = PinUpdaterFactory.getInstance().instantiate(readStructuralFeatureAction);
								command.add(new PinUpdateCommand<ReadStructuralFeatureAction>("Update read structural feature action pins", updater, readStructuralFeatureAction)); //$NON-NLS-1$
							}
						}
					}
					// Pins of AddStructuralFeatureValueAction should be create and update automatically
					// 1] get the preference for AddStructuralFeatureValueAction
					synchronizePinPreference = prefStore.getString(IAutomatedModelCompletionPreferencesConstants.ADD_STRUCTURAL_FEATURE_VALUE_ACTION_ACCELERATOR).equals(AutomatedModelCompletionPreferencesInitializer.PIN_SYNCHRONIZATION);
					// 2] check preference
					if (synchronizePinPreference) {
						// 3] get all AddStructuralFeatureValueAction
						List<AddStructuralFeatureValueAction> allAddStructuralFeatureValueAction = ElementUtil.getInstancesFilteredByType(root, AddStructuralFeatureValueAction.class, null);
						// 4] loop into the list of AddStructuralFeatureValueAction
						for (AddStructuralFeatureValueAction addStructuralFeatureValueAction : allAddStructuralFeatureValueAction) {
							if (addStructuralFeatureValueAction.getStructuralFeature() == request.getElementToEdit()) {
								// 5] call the command for the AddStructuralFeatureValueAction whose the structuralFeature is the property
								IPinUpdater<AddStructuralFeatureValueAction> updater = PinUpdaterFactory.getInstance().instantiate(addStructuralFeatureValueAction);
								command.add(new PinUpdateCommand<AddStructuralFeatureValueAction>("Update add structural feature value action pins", updater, addStructuralFeatureValueAction)); //$NON-NLS-1$
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
