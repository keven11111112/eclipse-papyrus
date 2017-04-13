/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 
 * 		Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.service.types.helper.advice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.commands.ConfigureElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyDependentsRequest;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.uml.service.types.element.UMLElementTypes;
import org.eclipse.papyrus.uml.service.types.utils.ElementUtil;
import org.eclipse.papyrus.uml.service.types.utils.SequenceRequestConstant;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.DestructionOccurrenceSpecification;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageEnd;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;
import org.eclipse.uml2.uml.MessageSort;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Helper advice for all {@link Message} elements.
 */
public class MessageHelperAdvice extends AbstractEditHelperAdvice {




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

	/**
	 * <pre>
	 * {@inheritDoc}
	 * 
	 * Complete the {@link Association} creation by:
	 * 		adding its {@link Property} ends in the model
	 * 		adding the UML Nature on the {@link Association}.
	 * 
	 * </pre>
	 */
	@Override
	protected ICommand getBeforeConfigureCommand(final ConfigureRequest request) {

		final Element source = getSource(request);
		final Element target = getTarget(request);
		if ((source == null) || (target == null)) {
			return UnexecutableCommand.INSTANCE;
		}

		if ((!(target instanceof Lifeline)) && (!(target instanceof Interaction))) {
			return UnexecutableCommand.INSTANCE;
		}
		if ((!(target instanceof Lifeline)) && (!(target instanceof Interaction))) {
			return UnexecutableCommand.INSTANCE;
		}
		return new ConfigureElementCommand(request) {

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
				final Message message = (Message) request.getElementToConfigure();
				final Element source = getSource(request);
				final Element target = getTarget(request);
				MessageEnd previousSentEvent = (MessageEnd) request.getParameters().get(SequenceRequestConstant.PREVIOUS_EVENT);
				MessageEnd previousReceiveEvent = (MessageEnd) request.getParameters().get(SequenceRequestConstant.SECOND_PREVIOUS_EVENT);
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
				// Create source and target ends
				MessageEnd sendEvent = createMessageEnd(message, (Lifeline) source, previous);
				sendEvent.setName(message.getName() + "SendEvent");
				message.setSendEvent(sendEvent);
			}

			/**
			 * @param message
			 * @param target
			 */
			private void createReceiveEvent(final Message message, final Element target, final MessageEnd previous) {
				MessageEnd receiveEvent = createMessageEnd(message, (Lifeline) target, previous);
				receiveEvent.setName(message.getName() + "ReceiveEvent");
				message.setReceiveEvent(receiveEvent);
			}
		};
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
	 * <pre>
	 * Add a command to destroy {@link MessageEnd} referenced by the {@link Message} 
	 * to delete.
	 * This command is only added if the send - receive event referenced is not 
	 * referenced by another element.
	 * </pre>
	 * 
	 * @see org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice#getBeforeDestroyDependentsCommand(org.eclipse.gmf.runtime.emf.type.core.requests.DestroyDependentsRequest)
	 * 
	 * @param request
	 *            the request
	 * @return the command to execute before the edit helper work is done
	 */
	@Override
	protected ICommand getBeforeDestroyDependentsCommand(DestroyDependentsRequest request) {

		List<EObject> dependentsToDestroy = new ArrayList<EObject>();

		Message message = (Message) request.getElementToDestroy();

		// Add send - receive referenced MessageEnd to the dependents list
		// if they are not used by another element.
		MessageEnd sendEvent = message.getSendEvent();
		if ((sendEvent != null) && (!isSharedEvent(sendEvent, message))) {
			dependentsToDestroy.add(sendEvent);
		}

		MessageEnd recvEvent = message.getReceiveEvent();
		if ((recvEvent != null) && (!isSharedEvent(recvEvent, message))) {
			dependentsToDestroy.add(recvEvent);
		}

		// return command to destroy dependents MessageEnd
		if (!dependentsToDestroy.isEmpty()) {
			return request.getDestroyDependentsCommand(dependentsToDestroy);
		}

		return null;
	}

	/**
	 * <pre>
	 * Test if the used element is referenced by other elements than the known
	 * referencer (except its container). It ignores references from an other meta-model.
	 * </pre>
	 *
	 * @param usedObject
	 *            the used object
	 * @param knownReferencer
	 *            the known referencer
	 * @return true if the known referencer is the only referencer.
	 */
	public static boolean isSharedEvent(MessageEnd usedObject, EObject knownReferencer) {
		EPackage mmPackage = usedObject.eClass().getEPackage();

		// Retrieve the list of elements referencing the usedObject.
		Set<EObject> crossReferences = new HashSet<EObject>();
		for (Setting setting : EMFHelper.getUsages(usedObject)) {
			EObject eObj = setting.getEObject();
			if (!setting.getEStructuralFeature().equals(UMLPackage.eINSTANCE.getLifeline_CoveredBy())) {
				if (eObj.eClass().getEPackage().equals(mmPackage)) {
					crossReferences.add(eObj);
				}
			}
		}

		// Remove the container of used object.
		crossReferences.remove(usedObject.eContainer());
		// Remove the knownReferencer from the list of references.
		crossReferences.remove(knownReferencer);

		// If no referencer remains in the list, the known element is the only
		// usage.
		return !(crossReferences.isEmpty());
	}
}
