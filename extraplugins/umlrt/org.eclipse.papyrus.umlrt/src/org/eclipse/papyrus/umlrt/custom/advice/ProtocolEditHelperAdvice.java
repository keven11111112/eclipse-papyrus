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

import static org.eclipse.papyrus.uml.service.types.element.UMLElementTypes.ANY_RECEIVE_EVENT;
import static org.eclipse.papyrus.uml.service.types.element.UMLElementTypes.INTERFACE_REALIZATION;
import static org.eclipse.papyrus.uml.service.types.element.UMLElementTypes.USAGE;
import static org.eclipse.papyrus.umlrt.custom.UMLRTElementTypesEnumerator.PROTOCOL_CONTAINER;
import static org.eclipse.papyrus.umlrt.custom.UMLRTElementTypesEnumerator.RT_MESSAGE_SET;

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
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.papyrus.uml.tools.utils.NamedElementUtil;
import org.eclipse.papyrus.umlrt.UMLRealTime.RTMessageKind;
import org.eclipse.papyrus.umlrt.UMLRealTime.RTMessageSet;
import org.eclipse.uml2.uml.Collaboration;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.InterfaceRealization;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.Usage;
import org.eclipse.uml2.uml.util.UMLUtil;


/**
 * The helperadvice class used for UMLRealTime::Protocol.
 *
 * @author Onder Gurcan <onder.gurcan@cea.fr>
 *
 */
public class ProtocolEditHelperAdvice extends AbstractEditHelperAdvice {

	private enum Relation {
		CHILD, SIBLING, PARENT;
	}

	/**
	 * @see org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice#getBeforeConfigureCommand(org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest)
	 *
	 * @param request
	 * @return
	 */
	@Override
	protected ICommand getBeforeConfigureCommand(ConfigureRequest request) {
		final Collaboration protocol = (Collaboration) request.getElementToConfigure();
		final String name = NamedElementUtil.getDefaultNameWithIncrementFromBase("EmptyProtocol", protocol.eContainer().eContents());

		return new ConfigureElementCommand(request) {
			private IProgressMonitor progressMonitor;
			private IAdaptable info;

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
				this.progressMonitor = progressMonitor;
				this.info = info;

				// Create the UMLRealTime::ProtocolContainer package
				createElement(protocol, name, PROTOCOL_CONTAINER, Relation.PARENT); 

				// Create the incoming UMLRealTime::RTMessageSet interface
				String nameIn = name;
				Interface rtMessageSetInt = (Interface) createElement(protocol, nameIn, RT_MESSAGE_SET, Relation.SIBLING); 
				setRtMsgKind(rtMessageSetInt, RTMessageKind.IN);
				createInterfaceRealization(protocol, nameIn, rtMessageSetInt);

				// Create the outgoing UMLRealTime::RTMessageSet interface
				String nameOut = name + "~";
				Interface rtMessageSetOutInt = (Interface) createElement(protocol, nameOut, RT_MESSAGE_SET, Relation.SIBLING); 
				setRtMsgKind(rtMessageSetOutInt, RTMessageKind.OUT);
				createUsage(protocol, nameOut, rtMessageSetOutInt);

				createElement(protocol, "*", ANY_RECEIVE_EVENT, Relation.SIBLING); //$NON-NLS-1$

				// Create the in-out UMLRealTime::RTMessageSet interface
				String nameInOut = name + "IO";
				Interface rtMessageSetInOutInt = (Interface) createElement(protocol, nameInOut, RT_MESSAGE_SET, Relation.SIBLING); 
				setRtMsgKind(rtMessageSetInOutInt, RTMessageKind.IN_OUT);
				createInterfaceRealization(protocol, nameInOut, rtMessageSetInOutInt);
				createUsage(protocol, nameInOut, rtMessageSetInOutInt);

				return CommandResult.newOKCommandResult(protocol);
			}

			/**
			 * Creates a UML::Usage relation between protocol and rtMessageSet with given name.
			 *
			 * @param protocol
			 * @param name
			 * @param rtMessageSet
			 * @throws ExecutionException
			 */
			private void createUsage(final Collaboration protocol, final String name, Interface rtMessageSet) throws ExecutionException {
				Usage usageOut = (Usage) createElement(protocol, name, USAGE, Relation.SIBLING); 
				usageOut.getClients().add(protocol);
				usageOut.getSuppliers().add(rtMessageSet);
			}

			/**
			 *  Creates an UML::InterfaceRealization relation between protocol and rtMessageSet with given name.
			 *
			 * @param protocol
			 * @param name
			 * @param rtMessageSet
			 * @throws ExecutionException
			 */
			private void createInterfaceRealization(final Collaboration protocol, final String name, Interface rtMessageSetInt) throws ExecutionException {
				InterfaceRealization realization = (InterfaceRealization) createElement(protocol, name, INTERFACE_REALIZATION, Relation.CHILD); 
				realization.getClients().add(protocol);
				realization.getSuppliers().add(rtMessageSetInt);
			}

			/**
			 *
			 * @param referenceElement
			 * @param name
			 * @param elementType
			 * @param relation
			 * @return created element as EObject
			 * @throws ExecutionException
			 */
			private EObject createElement(Collaboration referenceElement, String name, IElementType elementType, Relation relation) throws ExecutionException {
				if ((referenceElement == null) || (name == null)) {
					throw new ExecutionException("Either the referenceElement or the name parameter is null. ");
				}

				EObject newElement = null;

				CreateElementRequest createElementRequest = new CreateElementRequest(referenceElement.getNearestPackage(), elementType);
				CreateElementCommand command = new CreateElementCommand(createElementRequest);
				command.execute(progressMonitor, info);
				newElement = command.getNewElement();

				if (newElement == null) {
					throw new ExecutionException("Element creation problem for " + elementType.getDisplayName() + ".");
				}

				((NamedElement)newElement).setName(name);

				if (relation == Relation.CHILD) { // if newElement is an owned element of protocol
					if (elementType == INTERFACE_REALIZATION) {
						referenceElement.getInterfaceRealizations().add((InterfaceRealization) newElement);
					} else {
						referenceElement.createOwnedAttribute(name, (Type) newElement);
					}
				} else if (relation == Relation.SIBLING) { // if newElement is a sibling of protocol
					Package nearestPackage = referenceElement.getNearestPackage();
					nearestPackage.getPackagedElements().add((PackageableElement) newElement);
				} else if (relation == Relation.PARENT) { // otherwise newElement is a container element of protocol
					Package container = (Package) newElement;
					EList<PackageableElement> packagedElements = container.getPackagedElements();
					packagedElements.add(referenceElement);
				}

				return newElement;
			}

			private void setRtMsgKind(Interface rtMessageSetInt, RTMessageKind kind){
				RTMessageSet rtMessageSet = UMLUtil.getStereotypeApplication(rtMessageSetInt, RTMessageSet.class);
				rtMessageSet.setRtMsgKind(kind);
			}
		};
	}
	
	/**
	 * @see org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice#getBeforeDestroyElementCommand(org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest)
	 *
	 * @param request
	 * @return
	 */
	@Override
	protected ICommand getAfterDestroyElementCommand(DestroyElementRequest request) {
		PackageableElement protocolToDestroy = (PackageableElement) request.getElementToDestroy();
		Package protocolContainerToDestroy = protocolToDestroy.getNearestPackage();
		
		request = new DestroyElementRequest(protocolContainerToDestroy, false);
		
		return new DestroyElementCommand(request);
	}
}
