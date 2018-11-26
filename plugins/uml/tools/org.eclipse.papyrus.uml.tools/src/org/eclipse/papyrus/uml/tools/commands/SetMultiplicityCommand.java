/*****************************************************************************
 * Copyright (c) 2013, 2018 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Camille Letavernier (camille.letavernier@cea.fr) - Initial API and implementation
 *  Ansgar Radermacher (CEA) - Bug 540815
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.commands;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.AbstractEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.infra.emf.gmf.command.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.uml.tools.util.MultiplicityParser;
import org.eclipse.uml2.uml.MultiplicityElement;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * A Command to edit the Multiplicity of a MultiplicityElement. The expected value is a String
 * representing the Multiplicity.
 *
 * This command is a CompoundCommand, and relies on the Service Edit to retrieve the individual "set bounds" commands
 *
 * @author Camille Letavernier
 *
 * @see {@link MultiplicityParser}
 */
public class SetMultiplicityCommand extends CompoundCommand {

	private int[] lowerUpper;

	private MultiplicityElement element;

	static EStructuralFeature lowerFeature = UMLPackage.eINSTANCE.getMultiplicityElement_Lower();
	static EStructuralFeature lowerFeatureVS = UMLPackage.eINSTANCE.getMultiplicityElement_LowerValue();

	static EStructuralFeature upperFeature = UMLPackage.eINSTANCE.getMultiplicityElement_Upper();
	static EStructuralFeature upperFeatureVS = UMLPackage.eINSTANCE.getMultiplicityElement_UpperValue();

	public SetMultiplicityCommand(MultiplicityElement element, String value) {
		if (element == null) {
			return;
		}

		int[] lowerUpper = MultiplicityParser.getBounds(value);
		if (lowerUpper == null || lowerUpper.length < 2) {
			return;
		}

		int lower = lowerUpper[0];
		int upper = lowerUpper[1];

		if (!MultiplicityParser.isValidMultiplicity(lower, upper)) {
			return;
		}

		this.lowerUpper = lowerUpper;
		this.element = element;

		append(getSetCommand(lowerFeature, lowerFeatureVS, lower));
		append(getSetCommand(upperFeature, upperFeatureVS, upper));
	}

	private Command getSetCommand(EStructuralFeature feature, EStructuralFeature featureVS, int value) {
		IElementEditService provider = ElementEditServiceUtils.getCommandProvider(element);
		if (provider != null) {
			AbstractEditCommandRequest request;
			if (value == 1) { // default value (see bug 540815)
				request = new SetRequest(element, featureVS, null);
			} else {
				request = new SetRequest(element, feature, value);
			}
			ICommand gmfCommand = provider.getEditCommand(request);
			Command emfCommand = new GMFtoEMFCommandWrapper(gmfCommand);

			return emfCommand;
		}
		return null;
	}

	@Override
	public boolean canExecute() {
		return element != null && lowerUpper != null && lowerUpper.length == 2 && super.canExecute();
	}

}
