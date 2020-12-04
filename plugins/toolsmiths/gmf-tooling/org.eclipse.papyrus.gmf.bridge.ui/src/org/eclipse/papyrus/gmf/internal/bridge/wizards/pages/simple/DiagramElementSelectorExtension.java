/******************************************************************************
 * Copyright (c) 2006, 2020 Eclipse.org, CEA LIST, Artal
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/ 
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors: 
 *    Dmitry Stadnik - initial API and implementation
 *    Aurelien Didier (ARTAL) - aurelien.didier51@gmail.com - Bug 569174
 *****************************************************************************/
package org.eclipse.papyrus.gmf.internal.bridge.wizards.pages.simple;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.papyrus.gmf.internal.common.ui.ListElementSelectorExtension;

/**
 * @author dstadnik
 */
public class DiagramElementSelectorExtension extends ListElementSelectorExtension {

	protected String getModelElementName() {
		return Messages.DiagramElementSelectorElement;
	}

	protected String getModelElementLabel(EObject modelElement) {
		String name = ((EClass) modelElement).getName();
		if (name == null || name.trim().length() == 0) {
			name = Messages.DiagramElementSelectorNoName;
		}
		return name;
	}

	protected EClass getModelElementClass() {
		return EcorePackage.eINSTANCE.getEClass();
	}
}
