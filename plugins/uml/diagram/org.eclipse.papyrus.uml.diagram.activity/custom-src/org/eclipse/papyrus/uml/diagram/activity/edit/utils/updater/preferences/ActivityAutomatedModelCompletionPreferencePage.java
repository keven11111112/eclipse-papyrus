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

package org.eclipse.papyrus.uml.diagram.activity.edit.utils.updater.preferences;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.uml.diagram.common.preferences.AbstractAutomatedModelCompletionPreferencesPage;
import org.eclipse.papyrus.uml.diagram.common.preferences.AutomatedModelCompletionPreferenceDescriptor;
import org.eclipse.uml2.uml.AcceptCallAction;
import org.eclipse.uml2.uml.AcceptEventAction;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.AddStructuralFeatureValueAction;
import org.eclipse.uml2.uml.CreateObjectAction;
import org.eclipse.uml2.uml.ReadStructuralFeatureAction;
import org.eclipse.uml2.uml.ValueSpecificationAction;

/**
 * 
 * Automated pin derivation for AcceptEventAction and AcceptCallAction
 * 
 */
public class ActivityAutomatedModelCompletionPreferencePage extends AbstractAutomatedModelCompletionPreferencesPage {

	/**
	 * Constructor.
	 *
	 */
	public ActivityAutomatedModelCompletionPreferencePage() {
		super();
		initContentProvider(getActionList());
	}

	/**
	 * This method initialize the automatedModelCompletionDescriptorsList property
	 */
	protected void initContentProvider(List<Class<? extends ActivityNode>> actionList) {
		List<String> automatedModelCompletionList = new ArrayList<>();
		automatedModelCompletionList.add(AutomatedModelCompletionPreferencesInitializer.PIN_SYNCHRONIZATION);
		automatedModelCompletionList.add(AutomatedModelCompletionPreferencesInitializer.NONE);

		for (Class<? extends ActivityNode> action : actionList) {
			// get only the name of the action
			// initial form : interface org.eclipse.uml2.uml.<ActionName>
			String actionName = action.toString();
			actionName = actionName.replaceAll("org.eclipse.uml2.uml.", "");
			actionName = actionName.replaceFirst("interface\\s", "");
			actionName = actionName.substring(0, 1).toLowerCase() + actionName.substring(1);
			// get preference constant like : org.eclipse.papyrus.uml.diagram.activity.preferences.<ActionName>
			String prefConst = "org.eclipse.papyrus.uml.diagram.activity.preferences.";
			prefConst = prefConst.concat(actionName);

			automatedModelCompletionDescriptorsList.add(new AutomatedModelCompletionPreferenceDescriptor(action, automatedModelCompletionList, prefConst));
		}
	}

	/**
	 * This method create a list of actions which will be display in the preference page
	 * 
	 * @return the list of actions
	 */
	protected List<Class<? extends ActivityNode>> getActionList() {
		List<Class<? extends ActivityNode>> actionList = new ArrayList<>();
		actionList.add(AcceptCallAction.class);
		actionList.add(AcceptEventAction.class);
		actionList.add(AddStructuralFeatureValueAction.class);
		actionList.add(CreateObjectAction.class);
		actionList.add(ReadStructuralFeatureAction.class);
		actionList.add(ValueSpecificationAction.class);
		return actionList;
	}

}
