/**
 * Copyright (c) 2015 CEA LIST.
 *
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.papyrus.umlrt.ui.protocol;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListenerImpl;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.uml.tools.listeners.PapyrusStereotypeListener;
import org.eclipse.papyrus.umlrt.UMLRealTime.ProtocolContainer;
import org.eclipse.papyrus.umlrt.UMLRealTime.RTMessageKind;
import org.eclipse.papyrus.umlrt.UMLRealTime.RTMessageSet;
import org.eclipse.papyrus.umlrt.utils.UMLRTUtil;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.CallEvent;
import org.eclipse.uml2.uml.Collaboration;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * UMLRT resource set listener to handle protocol context change.
 * 
 * @author ysroh
 *
 */
public class UMLRTProtocolListener extends ResourceSetListenerImpl {

	private final String IN_MESSAGE_DEPENDENCY_NAME = "ProtocolRealizesIncomingInterface"; //$NON-NLS-1$

	private final String OUT_MESSAGE_DEPENDENCY_NAME = "ProtocolUsesOutgoingInterface"; //$NON-NLS-1$

	private final String IN_OUT_REALIZE_DEPENDENCY_NAME = "ProtocolRealizesSymInterface"; //$NON-NLS-1$

	private final String IN_OUT_USAGE_DEPENDENCY_NAME = "ProtocolUsesSymInterface"; //$NON-NLS-1$

	@Override
	public Command transactionAboutToCommit(ResourceSetChangeEvent event)
			throws RollbackException {

		for (Notification notification : event.getNotifications()) {

			if (!(notification.getNotifier() instanceof Element)) {
				continue;
			}

			Element notifier = (Element) notification.getNotifier();

			// create protocol container contents such as Protocol, MessageSet
			// and CallEvent etc.
			if (notification instanceof PapyrusStereotypeListener.StereotypeCustomNotification
					&& PapyrusStereotypeListener.APPLIED_STEREOTYPE == notification
							.getEventType()) {
				Object newValue = notification.getNewValue();
				if (newValue instanceof ProtocolContainer) {
					Package protocolContainer = (Package) notifier;
					return getCommandForNameChange(event.getEditingDomain(),
							protocolContainer, protocolContainer.getName(),
							protocolContainer.getName());
				}
			}

			// handle protocol name change
			if (notification.getEventType() == Notification.SET
					&& (UMLRTUtil.isProtocol(notifier) || UMLRTUtil
							.isProtocolContainer(notifier))
					&& notification.getFeature().equals(
							UMLPackage.Literals.NAMED_ELEMENT__NAME)) {
				Package protocolContainer = UMLRTUtil
						.getProtocolContainer(notifier);
				if (protocolContainer != null
						&& !UML2Util.isEmpty(notification.getOldStringValue())) {
					return getCommandForNameChange(event.getEditingDomain(),
							protocolContainer,
							notification.getOldStringValue(),
							notification.getNewStringValue());
				}
			}

			// handle operation name change
			if (notification.getEventType() == Notification.SET
					&& notification.getFeature().equals(
							UMLPackage.Literals.NAMED_ELEMENT__NAME)
					&& notifier instanceof Operation
					&& notifier.eContainer() instanceof Element
					&& UMLRTUtil.isRTMessageSet((Element) notifier
							.eContainer())) {
				return getCommandForOperationNameChange(
						event.getEditingDomain(), (Operation) notifier,
						notification.getOldStringValue(),
						notification.getNewStringValue());
			}

			// handle delete operation
			if (notification.getEventType() == Notification.SET
					&& notification.getFeature().equals(
							UMLPackage.Literals.OPERATION__INTERFACE)
					&& notification.getOldValue() instanceof Element
					&& notification.getNewValue() == null
					&& UMLRTUtil.isRTMessageSet((Element) notification
							.getOldValue())) {
				boolean isMove = false;
				// need way to distinguish move from explorer or from properties
				// page.
				for (Notification notification2 : event.getNotifications()) {
					// handle delete operation
					if (!(notification2.getNotifier() instanceof Element)) {
						continue;
					}
					Element notifier2 = (Element) notification2.getNotifier();

					if (!notifier.equals(notifier2)) {
						continue;
					}

					if (notification2.getEventType() == Notification.SET
							&& notification2.getFeature().equals(
									UMLPackage.Literals.OPERATION__INTERFACE)
							&& notification2.getNewValue() instanceof Element
							&& notification2.getOldValue() == null
							&& UMLRTUtil
									.isRTMessageSet((Element) notification2
											.getNewValue())) {
						isMove = true;
						break;
					}
				}
				if (!isMove) {
					return getCommandForRemoveOperation(
							event.getEditingDomain(),
							(Element) notification.getOldValue(),
							(Operation) notifier);
				}
				return null;
			}
			// handle add operation
			if (notification.getEventType() == Notification.ADD
					&& notification.getFeature().equals(
							UMLPackage.Literals.INTERFACE__OWNED_OPERATION)
					&& !UML2Util.isEmpty(((Operation) notification
							.getNewValue()).getName())
					&& UMLRTUtil.isRTMessageSet(notifier)) {
				// see if this is a move
				return getCommandForOperationNameChange(
						event.getEditingDomain(),
						(Operation) notification.getNewValue(),
						UMLUtil.EMPTY_STRING,
						((Operation) notification.getNewValue()).getName());
			}
			// handle new parameter
			if (notification.getFeature().equals(
					UMLPackage.Literals.BEHAVIORAL_FEATURE__OWNED_PARAMETER)
					&& notifier instanceof Operation) {
				Operation op = (Operation) notifier;
				Interface intf = op.getInterface();
				if (intf != null && UMLRTUtil.isRTMessageSet(intf)) {
					return getCommandForOperationNameChange(
							event.getEditingDomain(), op, op.getName(),
							op.getName());
				}
			}

			// handle parameter change in order to change call event name
			if (notification.getEventType() == Notification.SET
					&& notification.getFeature().equals(
							UMLPackage.Literals.TYPED_ELEMENT__TYPE)
					&& notifier instanceof Parameter) {
				Operation op = ((Parameter) notifier).getOperation();
				if (op == null) {
					continue;
				}
				Interface intf = op.getInterface();
				if (intf != null && UMLRTUtil.isRTMessageSet(intf)) {
					return getCommandForOperationNameChange(
							event.getEditingDomain(), op, op.getName(),
							op.getName());
				}
			}
		}

		return null;
	}

	/**
	 * Handle operation change
	 * 
	 * @param editingDomain
	 * @param messageSet
	 * @param operation
	 * @return
	 */
	private Command getCommandForRemoveOperation(
			TransactionalEditingDomain editingDomain, final Element messageSet,
			final Operation operation) {
		return new RecordingCommand(editingDomain) {

			@Override
			protected void doExecute() {
				Package protocolContainer = UMLRTUtil
						.getProtocolContainer(messageSet);
				if (protocolContainer == null) {
					return;
				}
				CallEvent callEvent = (CallEvent) protocolContainer
						.getPackagedElement(operation.getName(), false,
								UMLPackage.Literals.CALL_EVENT, false);
				if (callEvent != null) {
					EcoreUtil.delete(callEvent);
				}
			}
		};
	}

	/**
	 * Handle operation name change
	 * 
	 * @param editingDomain
	 * @param operation
	 * @param oldName
	 * @param newName
	 * @return
	 */
	private Command getCommandForOperationNameChange(
			TransactionalEditingDomain editingDomain,
			final Operation operation, final String oldName,
			final String newName) {

		return new RecordingCommand(editingDomain) {

			@Override
			protected void doExecute() {
				Package protocolContainer = UMLRTUtil
						.getProtocolContainer(operation);
				if (protocolContainer == null) {
					return;
				}
				StringBuilder postfix = new StringBuilder();
				for (Parameter p : operation.getOwnedParameters()) {
					if (ParameterDirectionKind.IN_LITERAL.equals(p
							.getDirection()) && p.getType() != null) {
						postfix.append("_"); //$NON-NLS-1$
						postfix.append(p.getType().getName());
					}
				}
				String postfixString = postfix.toString();
				CallEvent callEvent = null;
				for (PackageableElement e : protocolContainer
						.getPackagedElements()) {
					if (e instanceof CallEvent
							&& operation.equals(((CallEvent) e).getOperation())) {
						e.setName(newName + postfixString);
						return;
					}
				}

				String oldEventName = oldName + postfixString;
				String newEventName = newName + postfixString;
				if (!UML2Util.isEmpty(oldEventName)) {
					callEvent = (CallEvent) protocolContainer
							.getPackagedElement(oldEventName, false,
									UMLPackage.Literals.CALL_EVENT, false);
				}
				if (callEvent == null) {
					callEvent = (CallEvent) protocolContainer
							.getPackagedElement(newEventName, false,
									UMLPackage.Literals.CALL_EVENT, true);
				}
				if (callEvent != null) {
					callEvent.setOperation(operation);
					callEvent.setName(newEventName);
				}
			}
		};
	}

	/**
	 * Handle protocol name change
	 * 
	 * @param editingDomain
	 * @param protocolContainer
	 * @param oldStringValue
	 * @param newStringValue
	 * @return
	 */
	private Command getCommandForNameChange(
			TransactionalEditingDomain editingDomain,
			final Package protocolContainer, final String oldStringValue,
			final String newStringValue) {

		return new RecordingCommand(editingDomain) {

			@Override
			protected void doExecute() {
				createProtocolContainerContent(protocolContainer,
						oldStringValue, newStringValue);

			}
		};
	}

	/**
	 * Create or repair protocol container elements. Child element name must
	 * follow the name of the protocol container.
	 * 
	 * @param container
	 *            protocol container
	 * @param oldName
	 *            name of the old protocol in case this is rename
	 * @param newName
	 *            name of the protocol
	 */
	private void createProtocolContainerContent(Package pContainer,
			String oldName, String newName) {

		// Setup protocol
		PackageableElement protocol = (Collaboration) pContainer
				.getPackagedElement(oldName, false,
						UMLPackage.Literals.COLLABORATION, false);

		if (protocol == null) {
			protocol = pContainer.getPackagedElement(newName, false,
					UMLPackage.Literals.COLLABORATION, true);
		} else {
			protocol.setName(newName);
		}
		applyStereoType(protocol, "UMLRealTime::Protocol"); //$NON-NLS-1$

		// setup message sets
		addRtMessageSet(pContainer, protocol, oldName, newName,
				RTMessageKind.IN);
		addRtMessageSet(pContainer, protocol,
				getMessageSetName(oldName, RTMessageKind.OUT),
				getMessageSetName(newName, RTMessageKind.OUT),
				RTMessageKind.OUT);
		addRtMessageSet(pContainer, protocol,
				getMessageSetName(oldName, RTMessageKind.IN_OUT),
				getMessageSetName(newName, RTMessageKind.IN_OUT),
				RTMessageKind.IN_OUT);

		// Setup any receive event
		pContainer.getPackagedElement("*", false, //$NON-NLS-1$
				UMLPackage.Literals.ANY_RECEIVE_EVENT, true);

		pContainer.setName(newName);

	}

	/**
	 * Add RTMessage set with given message kind.
	 * 
	 * @param container
	 *            protocol container
	 * @param protocol
	 *            protocol
	 * @param oldName
	 * @param newName
	 * @param kind
	 * @return
	 */
	private Interface addRtMessageSet(Package container,
			PackageableElement protocol, String oldName, String newName,
			RTMessageKind kind) {

		Interface messageSet = UMLRTUtil.getMessageSet(container, kind);
		if (messageSet != null) {
			messageSet.setName(newName);
			return messageSet;
		}
		messageSet = (Interface) container.getPackagedElement(oldName, false,
				UMLPackage.Literals.INTERFACE, false);
		if (messageSet == null) {
			messageSet = (Interface) container.getPackagedElement(newName,
					false, UMLPackage.Literals.INTERFACE, true);
		} else {
			messageSet.setName(newName);
		}
		applyStereoType(messageSet, "UMLRealTime::RTMessageSet"); //$NON-NLS-1$
		RTMessageSet rtMessageSet = UMLUtil.getStereotypeApplication(
				messageSet, RTMessageSet.class);
		rtMessageSet.setRtMsgKind(kind);

		// setup relations
		if (kind.equals(RTMessageKind.IN)) {
			addProtocolDependency(container, IN_MESSAGE_DEPENDENCY_NAME,
					UMLPackage.Literals.REALIZATION, protocol, messageSet);
		} else if (kind.equals(RTMessageKind.OUT)) {
			addProtocolDependency(container, OUT_MESSAGE_DEPENDENCY_NAME,
					UMLPackage.Literals.USAGE, protocol, messageSet);
		} else if (kind.equals(RTMessageKind.IN_OUT)) {
			addProtocolDependency(container, IN_OUT_REALIZE_DEPENDENCY_NAME,
					UMLPackage.Literals.REALIZATION, protocol, messageSet);
			addProtocolDependency(container, IN_OUT_USAGE_DEPENDENCY_NAME,
					UMLPackage.Literals.USAGE, protocol, messageSet);
		}

		return messageSet;
	}

	/**
	 * Create or modify existing dependency to add dependency between client and
	 * supplier
	 * 
	 * @param container
	 * @param name
	 * @param eClass
	 * @param client
	 * @param supplier
	 */
	private void addProtocolDependency(Package container, String name,
			EClass eClass, NamedElement client, NamedElement supplier) {
		for (Element e : container.getOwnedElements()) {
			if (e.eClass().equals(eClass)) {
				Dependency d = (Dependency) e;
				if (d.getClients().contains(client)
						&& d.getSuppliers().contains(supplier)) {
					d.setName(name);
					return;
				}
			}
		}
		Dependency dependency = (Dependency) container.getPackagedElement(name,
				false, eClass, true);
		EList<NamedElement> clients = dependency.getClients();
		EList<NamedElement> suppliers = dependency.getSuppliers();

		clients.clear();
		clients.add(client);

		suppliers.clear();
		suppliers.add(supplier);
	}

	/**
	 * Add stereotype with given qualified name of the stereotype if not already
	 * applied.
	 * 
	 * @param element
	 * @param qualifiedName
	 */
	private void applyStereoType(Element element, String qualifiedName) {
		Stereotype protocolStereotype = element
				.getAppliedStereotype(qualifiedName);
		if (protocolStereotype == null) {
			protocolStereotype = element.getApplicableStereotype(qualifiedName);
			element.applyStereotype(protocolStereotype);
		}
	}

	/**
	 * Return default MessageSet name depending on the message kind.
	 * 
	 * @param protocolName
	 * @param kind
	 * @return
	 */
	private String getMessageSetName(String protocolName, RTMessageKind kind) {
		if (kind.equals(RTMessageKind.OUT)) {
			return protocolName + "~"; //$NON-NLS-1$
		} else if (kind.equals(RTMessageKind.IN_OUT)) {
			return protocolName + "Sym"; //$NON-NLS-1$
		}
		return protocolName;
	}
}
