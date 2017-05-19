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

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.papyrus.uml.diagram.wizards.messages.Messages;

/**
 * A simple data model for the wizard pages to share data.
 * 
 * @since 3.0
 */
public class NewModelWizardData {

	private final IObservableValue<String> defaultModelName = new WritableValue<>(
			Messages.NewModelFilePage_default_diagram_name,
			String.class);

	public NewModelWizardData() {
		super();
	}

	public IObservableValue<String> getDefaultModelName() {
		return defaultModelName;
	}

	void setModelFileName(String fileName) {
		if (fileName != null) {
			int dot = fileName.indexOf('.');
			if (dot >= 0) {
				fileName = fileName.substring(0, dot);
			}
		}

		defaultModelName.setValue(fileName);
	}
}
