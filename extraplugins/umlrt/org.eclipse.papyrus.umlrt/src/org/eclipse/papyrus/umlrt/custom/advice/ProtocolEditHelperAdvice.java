/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Onder Gurcan <onder.gurcan@cea.fr>
 *
 *****************************************************************************/

package org.eclipse.papyrus.umlrt.custom.advice;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.commands.ConfigureElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.uml2.uml.Collaboration;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Type;

import static org.eclipse.papyrus.umlrt.custom.UMLRTElementTypesEnumerator.RT_MESSAGE_SET;
import static org.eclipse.papyrus.umlrt.custom.UMLRTElementTypesEnumerator.PROTOCOL_CONTAINER;;

/**
 * The helperadvice class used for UMLRealTime::Protocol.
 * 
 * @author Onder Gurcan <onder.gurcan@cea.fr>
 *
 */
public class ProtocolEditHelperAdvice extends AbstractEditHelperAdvice {

	/**
	 * @see org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice#getBeforeConfigureCommand(org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest)
	 *
	 * @param request
	 * @return
	 */
	@Override
	protected ICommand getBeforeConfigureCommand(ConfigureRequest request) {
		final Collaboration protocol = (Collaboration) request.getElementToConfigure();

		return new ConfigureElementCommand(request) {
			private IProgressMonitor progressMonitor;
			private IAdaptable info;

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
				this.progressMonitor = progressMonitor;
				this.info = info;

				// RT InMessages
				createElement("rtInMessages", RT_MESSAGE_SET, true); //$NON-NLS-1$
				createElement("rtOutMessages", RT_MESSAGE_SET, true); //$NON-NLS-1$
				createElement("rtInOutMessages", RT_MESSAGE_SET, true); //$NON-NLS-1$

				/* Create ProtocolContainer and add protocol as an owned attribute of it */
				createElement("protocolContainer", PROTOCOL_CONTAINER, false); //$NON-NLS-1$

				return CommandResult.newOKCommandResult(protocol);
			}			

			private EObject createElement(String name, IElementType elementType, boolean owned) throws ExecutionException {
				if ((protocol == null) || (name == null))
					throw new ExecutionException("Either the protocol or the name parameter is null. ");

				EObject newElement = null;

				CreateElementRequest createElementRequest = new CreateElementRequest(protocol.getNearestPackage(), elementType);
				CreateElementCommand command = new CreateElementCommand(createElementRequest);
				command.execute(progressMonitor, info);
				newElement = command.getNewElement();
				
				if (newElement == null)
					throw new ExecutionException("Element creation problem for " + elementType.getDisplayName() + ".");
				
				if (owned) { // if newElement is an owned element of protocol
					protocol.createOwnedAttribute(name, (Type) newElement);
				} else { // otherwise newElement is a container element of protocol
					Package container = (Package) newElement;
					EList<PackageableElement> packagedElements = container.getPackagedElements();
					packagedElements.add(protocol);
				}

				return newElement;
			}
		};
	}
}
