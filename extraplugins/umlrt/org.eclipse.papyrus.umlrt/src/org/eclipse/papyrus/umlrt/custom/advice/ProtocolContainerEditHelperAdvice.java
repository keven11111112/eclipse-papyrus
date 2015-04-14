/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: CEA LIST
 *
 *****************************************************************************/
package org.eclipse.papyrus.umlrt.custom.advice;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.commands.wrappers.EMFtoGMFCommandWrapper;
import org.eclipse.papyrus.umlrt.custom.utils.MessageSetUtils;
import org.eclipse.papyrus.umlrt.custom.utils.ProtocolContainerUtils;
import org.eclipse.uml2.uml.Collaboration;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * The helper advice class used for UMLRealTime::ProtocolContainer.
 */
public class ProtocolContainerEditHelperAdvice extends AbstractEditHelperAdvice {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ICommand getAfterSetCommand(SetRequest request) {
		// for change name request, changes the name of the protocol and its interfaces
		if (UMLPackage.eINSTANCE.getNamedElement_Name().equals(request.getFeature())) {

			final EObject elementToEdit = request.getElementToEdit();
			if (!(elementToEdit instanceof Package)) {
				return super.getBeforeSetCommand(request);
			}

			final String newName = (request.getValue() != null) ? request.getValue().toString() : "Protocol";

			final Package protocolContainer = (Package) elementToEdit;
			RecordingCommand command = new RecordingCommand(request.getEditingDomain(), "Change Dependents", "Change the names of the dependents of the ProtocolContainer") {

				@Override
				protected void doExecute() {
					// rename protocol, avoid dependency to avoid circular dependencies towards advices
					Interface interfaceIn = ProtocolContainerUtils.getMessageSetIn(protocolContainer);
					if (interfaceIn != null) {
						interfaceIn.setName(MessageSetUtils.computeInterfaceInName(newName));
					}

					Interface interfaceOut = ProtocolContainerUtils.getMessageSetOut(protocolContainer);
					if (interfaceOut != null) {
						interfaceOut.setName(MessageSetUtils.computeInterfaceOutName(newName));
					}

					Interface interfaceInOut = ProtocolContainerUtils.getMessageSetInOut(protocolContainer);
					if (interfaceInOut != null) {
						interfaceInOut.setName(MessageSetUtils.computeInterfaceInOutName(newName));
					}

					Collaboration collaboration = ProtocolContainerUtils.getCollaboration(protocolContainer);
					if (collaboration != null) {
						collaboration.setName(newName);
					}
				}
			};
			// check the super in case of more commands
			ICommand superCommand = super.getAfterSetCommand(request);
			if (superCommand != null) {
				return superCommand.compose(new EMFtoGMFCommandWrapper(command));
			}
			return new EMFtoGMFCommandWrapper(command);
		}
		return super.getAfterSetCommand(request);
	}
}
