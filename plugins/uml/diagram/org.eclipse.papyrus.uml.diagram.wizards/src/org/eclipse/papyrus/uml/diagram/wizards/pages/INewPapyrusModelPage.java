/*****************************************************************************
 * Copyright (c) 2017 Christian W. Damus and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.wizards.pages;

import org.eclipse.jface.wizard.IWizardPage;

/**
 * Common protocol for wizard pages in the <em>New Model Wizard</em>
 * via which they can share a common data model.
 * 
 * @since 3.0
 */
public interface INewPapyrusModelPage extends IWizardPage {

	NewModelWizardData getNewModelWizardData();

	void setNewModelWizardData(NewModelWizardData wizardData);

}
