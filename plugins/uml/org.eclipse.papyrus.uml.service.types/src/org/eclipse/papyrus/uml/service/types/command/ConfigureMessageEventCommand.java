/*****************************************************************************
 * Copyright (c) 2017 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Celine JANSSENS (ALL4TEC) - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.service.types.command;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.commands.ConfigureElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.uml.service.types.element.UMLElementTypes;
import org.eclipse.papyrus.uml.service.types.utils.ElementUtil;
import org.eclipse.papyrus.uml.service.types.utils.SequenceRequestConstant;
import org.eclipse.uml2.uml.DestructionOccurrenceSpecification;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.ExecutionOccurrenceSpecification;
import org.eclipse.uml2.uml.ExecutionSpecification;
import org.eclipse.uml2.uml.Gate;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageEnd;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;
import org.eclipse.uml2.uml.MessageSort;
import org.eclipse.uml2.uml.OccurrenceSpecification;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * @author Céline JANSSENS
 * @since 3.1
 *
 */
public class ConfigureMessageEventCommand extends ConfigureElementCommand {

	private ConfigureRequest request;

	/**
	 * Constructor.
	 *
	 */
	public ConfigureMessageEventCommand(ConfigureRequest request) {
		super(request);
		this.request = request;
	}

	/**
	 * This method provides the source type provided as {@link ConfigureRequest} parameter.
	 * 
	 * @return the target role
	 * @since 3.0
	 */
	protected Element getSource(ConfigureRequest req) {
		Element result = null;
		Object paramObject = req.getParameter(CreateRelationshipRequest.SOURCE);
		if (paramObject instanceof Element) {
			result = (Element) paramObject;
		}

		return result;
	}

	/**
	 * Create a MessageEnd
	 *
	 * @param message
	 *            the message that reference the message end always !=null
	 * @param lifeline
	 *            the lifeLine where is set the message end ,always !=null
	 * @since 3.0
	 */
	public static MessageEnd createMessageEnd(Message message, Lifeline lifeline, final MessageEnd previous) {
		MessageOccurrenceSpecification messageOccurrenceSpecification = UMLFactory.eINSTANCE.createMessageOccurrenceSpecification();
		if (previous == null) {
			messageOccurrenceSpecification.setCovered(lifeline);
		} else {
			lifeline.getCoveredBys().add(lifeline.getCoveredBys().indexOf(previous) + 1, messageOccurrenceSpecification);
		}
		messageOccurrenceSpecification.setMessage(message);
		((Interaction) message.getOwner()).getFragments().add(messageOccurrenceSpecification);
		return messageOccurrenceSpecification;
	}

	/**
	 * Create a MessageEnd
	 *
	 * @param message
	 *            the message that reference the message end always !=null
	 * @param lifeline
	 *            the lifeLine where is set the message end ,always !=null
	 * @since 3.0
	 */
	public static MessageEnd createDestroyMessageEnd(Message message, Lifeline lifeline) {
		DestructionOccurrenceSpecification messageOccurrenceSpecification = UMLFactory.eINSTANCE.createDestructionOccurrenceSpecification();
		messageOccurrenceSpecification.setCovered(lifeline);
		messageOccurrenceSpecification.setMessage(message);
		((Interaction) message.getOwner()).getFragments().add(messageOccurrenceSpecification);
		return messageOccurrenceSpecification;
	}

	/**
	 * This method provides the target type provided as {@link ConfigureRequest} parameter.
	 * 
	 * @return the target role
	 * @since 3.0
	 */
	protected Element getTarget(ConfigureRequest req) {
		Element result = null;
		Object paramObject = req.getParameter(CreateRelationshipRequest.TARGET);
		if (paramObject instanceof Element) {
			result = (Element) paramObject;
		}

		return result;
	}


	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
		final Message message = (Message) request.getElementToConfigure();
		final Element source = getSource(request);
		final Element target = getTarget(request);
		MessageEnd previousSentEvent = (MessageEnd) request.getParameters().get(SequenceRequestConstant.PREVIOUS_EVENT);
		MessageEnd previousReceiveEvent = (MessageEnd) request.getParameters().get(SequenceRequestConstant.SECOND_PREVIOUS_EVENT);
		ExecutionOccurrenceSpecification toReplacebyMessageSent = (ExecutionOccurrenceSpecification) request.getParameters().get(SequenceRequestConstant.MESSAGE_SENTEVENT_REPLACE_EXECUTIONEVENT);
		ExecutionOccurrenceSpecification toReplacebyMessageReceive = (ExecutionOccurrenceSpecification) request.getParameters().get(SequenceRequestConstant.MESSAGE_RECEIVEEVENT_REPLACE_EXECUTIONEVENT);


		IElementType elementType = request.getTypeToConfigure();
		if (ElementUtil.isTypeOf(elementType, UMLElementTypes.COMPLETE_ASYNCH_CALL)) {
			createSendEvent(message, source, previousSentEvent);
			createReceiveEvent(message, target, previousReceiveEvent);
			message.setMessageSort(MessageSort.ASYNCH_CALL_LITERAL);
		} else if (ElementUtil.isTypeOf(elementType, UMLElementTypes.COMPLETE_ASYNCH_SIGNAL)) {
			createSendEvent(message, source, previousSentEvent);
			createReceiveEvent(message, target, previousReceiveEvent);
			message.setMessageSort(MessageSort.ASYNCH_SIGNAL_LITERAL);
		} else if (ElementUtil.isTypeOf(elementType, UMLElementTypes.COMPLETE_CREATE_MESSAGE)) {
			createSendEvent(message, source, previousSentEvent);
			createReceiveEvent(message, target, previousReceiveEvent);
			message.setMessageSort(MessageSort.CREATE_MESSAGE_LITERAL);
		} else if (ElementUtil.isTypeOf(elementType, UMLElementTypes.COMPLETE_DELETE_MESSAGE)) {
			createSendEvent(message, source, previousSentEvent);
			createDestroyReceiveEvent(message, target);
			message.setMessageSort(MessageSort.DELETE_MESSAGE_LITERAL);
		} else if (ElementUtil.isTypeOf(elementType, UMLElementTypes.COMPLETE_REPLY)) {
			createSendEvent(message, source, previousSentEvent);
			createReceiveEvent(message, target, previousReceiveEvent);
			message.setMessageSort(MessageSort.REPLY_LITERAL);
		} else if (ElementUtil.isTypeOf(elementType, UMLElementTypes.COMPLETE_SYNCH_CALL)) {
			createSendEvent(message, source, previousSentEvent);
			createReceiveEvent(message, target, previousReceiveEvent);
			message.setMessageSort(MessageSort.SYNCH_CALL_LITERAL);
		} else if (ElementUtil.isTypeOf(elementType, UMLElementTypes.FOUND_ASYNCH_CALL)) {
			createReceiveEvent(message, target, previousReceiveEvent);
			message.setMessageSort(MessageSort.ASYNCH_CALL_LITERAL);
		} else if (ElementUtil.isTypeOf(elementType, UMLElementTypes.FOUND_ASYNCH_SIGNAL)) {
			createReceiveEvent(message, target, previousReceiveEvent);
			message.setMessageSort(MessageSort.ASYNCH_SIGNAL_LITERAL);
		} else if (ElementUtil.isTypeOf(elementType, UMLElementTypes.FOUND_CREATE_MESSAGE)) {
			createReceiveEvent(message, target, previousReceiveEvent);
			message.setMessageSort(MessageSort.CREATE_MESSAGE_LITERAL);
		} else if (ElementUtil.isTypeOf(elementType, UMLElementTypes.FOUND_DELETE_MESSAGE)) {
			createDestroyReceiveEvent(message, target);
			message.setMessageSort(MessageSort.DELETE_MESSAGE_LITERAL);
		} else if (ElementUtil.isTypeOf(elementType, UMLElementTypes.FOUND_REPLY)) {
			createReceiveEvent(message, target, previousReceiveEvent);
			message.setMessageSort(MessageSort.REPLY_LITERAL);
		} else if (ElementUtil.isTypeOf(elementType, UMLElementTypes.LOST_ASYNCH_CALL)) {
			createSendEvent(message, source, previousSentEvent);
			message.setMessageSort(MessageSort.ASYNCH_CALL_LITERAL);
		} else if (ElementUtil.isTypeOf(elementType, UMLElementTypes.LOST_ASYNCH_SIGNAL)) {
			createSendEvent(message, source, previousSentEvent);
			message.setMessageSort(MessageSort.ASYNCH_SIGNAL_LITERAL);
		} else if (ElementUtil.isTypeOf(elementType, UMLElementTypes.LOST_CREATE_MESSAGE)) {
			createSendEvent(message, source, previousSentEvent);
			message.setMessageSort(MessageSort.CREATE_MESSAGE_LITERAL);
		} else if (ElementUtil.isTypeOf(elementType, UMLElementTypes.LOST_DELETE_MESSAGE)) {
			createSendEvent(message, source, previousSentEvent);
			message.setMessageSort(MessageSort.DELETE_MESSAGE_LITERAL);
		} else if (ElementUtil.isTypeOf(elementType, UMLElementTypes.LOST_REPLY)) {
			createSendEvent(message, source, previousSentEvent);
			message.setMessageSort(MessageSort.REPLY_LITERAL);
		}

		// an occurence spec must replaced?
		if (toReplacebyMessageSent != null) {
			if (toReplacebyMessageSent.getExecution() != null) {
				// by the sent event of the message?
				// this is the start?
				if (toReplacebyMessageSent.getExecution().getStart().equals(toReplacebyMessageSent)) {
					toReplacebyMessageSent.getExecution().setStart((OccurrenceSpecification) message.getSendEvent());
				} else {
					// this is the finish
					toReplacebyMessageSent.getExecution().setFinish((OccurrenceSpecification) message.getSendEvent());
				}
			}
			if (toReplacebyMessageSent != null) {
				// the occurennce spec must disapear!
				if (toReplacebyMessageSent.getOwner() != null) {
					IElementEditService provider = ElementEditServiceUtils.getCommandProvider(toReplacebyMessageSent);
					if (provider != null) {
						DestroyElementRequest destroyRequest = new DestroyElementRequest(toReplacebyMessageSent, false);
						ICommand destroyCommand = provider.getEditCommand(destroyRequest);
						destroyCommand.execute(new NullProgressMonitor(), null);
					}
				}

			}
		}
		if (toReplacebyMessageReceive != null) {
			// replace by the receive message
			if (toReplacebyMessageReceive.getExecution() != null) {
				// this is the start?
				if (toReplacebyMessageReceive.getExecution().getStart().equals(toReplacebyMessageReceive)) {
					toReplacebyMessageReceive.getExecution().setStart((OccurrenceSpecification) message.getReceiveEvent());
				} else {
					// this is the finish
					toReplacebyMessageReceive.getExecution().setFinish((OccurrenceSpecification) message.getReceiveEvent());
				}
			}
			// the occurence spec must be deleted
			if (toReplacebyMessageReceive.getOwner() != null) {
				IElementEditService provider = ElementEditServiceUtils.getCommandProvider(toReplacebyMessageReceive);
				if (provider != null) {
					DestroyElementRequest destroyRequest = new DestroyElementRequest(toReplacebyMessageReceive, false);
					ICommand destroyCommand = provider.getEditCommand(destroyRequest);
					destroyCommand.execute(new NullProgressMonitor(), null);
				}
			}
		}
		return CommandResult.newOKCommandResult(message);
	}



	/**
	 * @param message
	 * @param source
	 */
	private void createDestroyReceiveEvent(final Message message, final Element source) {
		// Create source and target ends
		MessageEnd sendEvent = createDestroyMessageEnd(message, (Lifeline) source);
		sendEvent.setName(message.getName() + "ReceiveDestroyEvent");
		message.setReceiveEvent(sendEvent);
	}


	/**
	 * @param message
	 * @param source
	 */
	private void createSendEvent(final Message message, final Element source, final MessageEnd previous) {
		if (source instanceof Gate) {
			message.setSendEvent((Gate) source);
		} else if (source instanceof ExecutionSpecification) {
			if (((ExecutionSpecification) source).getCovereds().size() > 0) {
				Lifeline lifeline = ((ExecutionSpecification) source).getCovereds().get(0);
				MessageEnd sendEvent = createMessageEnd(message, lifeline, previous);
				sendEvent.setName(message.getName() + "SendEvent");
				message.setSendEvent(sendEvent);
			}
		} else if (source instanceof Lifeline) {
			// Create source and target ends
			MessageEnd sendEvent = createMessageEnd(message, (Lifeline) source, previous);
			sendEvent.setName(message.getName() + "SendEvent");
			message.setSendEvent(sendEvent);
		}
	}

	/**
	 * @param message
	 * @param target
	 */
	private void createReceiveEvent(final Message message, final Element target, final MessageEnd previous) {
		if (target instanceof Gate) {
			message.setReceiveEvent((Gate) target);

		} else if (target instanceof ExecutionSpecification) {
			if (((ExecutionSpecification) target).getCovereds().size() > 0) {
				Lifeline lifeline = ((ExecutionSpecification) target).getCovereds().get(0);
				MessageEnd receiveEvent = createMessageEnd(message, lifeline, previous);
				receiveEvent.setName(message.getName() + "ReceiveEvent");
				message.setReceiveEvent(receiveEvent);
			}
		} else if (target instanceof Lifeline) {
			MessageEnd receiveEvent = createMessageEnd(message, (Lifeline) target, previous);
			receiveEvent.setName(message.getName() + "ReceiveEvent");
			message.setReceiveEvent(receiveEvent);
		}
	}
}
