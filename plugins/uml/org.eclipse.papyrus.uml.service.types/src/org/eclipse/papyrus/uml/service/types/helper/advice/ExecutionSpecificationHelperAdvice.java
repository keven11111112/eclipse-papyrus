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
 *  	Mathieu Velten (Atos Origin) mathieu.velten@atosorigin.com - remove linked messages too
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
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.commands.ConfigureElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyDependentsRequest;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.uml.diagram.common.helper.InteractionFragmentHelper;
import org.eclipse.papyrus.uml.service.types.utils.SequenceRequestConstant;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.ExecutionOccurrenceSpecification;
import org.eclipse.uml2.uml.ExecutionSpecification;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageEnd;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;
import org.eclipse.uml2.uml.MessageSort;
import org.eclipse.uml2.uml.OccurrenceSpecification;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * Helper advice for all {@link ExecutionSpecification} elements.
 */
public class ExecutionSpecificationHelperAdvice extends AbstractEditHelperAdvice {

	/**
	 * Create an execution Occurrence
	 *
	 * @param execution
	 *            the execution that references the execution occurrences always !=null
	 * @param lifeline
	 *            the lifeLine that is covered by the execution occurrences ,always !=null
	 * @since 3.0
	 */
	public static ExecutionOccurrenceSpecification createOccurenceSpecification(ExecutionSpecification execution, Lifeline lifeline) {
		ExecutionOccurrenceSpecification occurrenceSpecification = UMLFactory.eINSTANCE.createExecutionOccurrenceSpecification();
		occurrenceSpecification.setCovered(lifeline);
		((Interaction) execution.getOwner()).getFragments().add(occurrenceSpecification);
		return occurrenceSpecification;
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

		final ExecutionSpecification execution = (ExecutionSpecification) request.getElementToConfigure();
		IElementType elementType = request.getTypeToConfigure();
		return new ConfigureElementCommand(request) {

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
				Object coveredParam = request.getParameters().get(SequenceRequestConstant.COVERED);

				Lifeline coveredLifeline = null;
				if (coveredParam instanceof Lifeline) {
					coveredLifeline = (Lifeline) coveredParam;
				}

				final ExecutionSpecification execution = (ExecutionSpecification) request.getElementToConfigure();

				Object replaceStart = request.getParameters().get(SequenceRequestConstant.REPLACE_EXECUTION_SPECIFICATION_START);
				if (replaceStart instanceof MessageOccurrenceSpecification) {
					execution.setStart((MessageOccurrenceSpecification) replaceStart);
				} else {
					// create Occurrence SpecStart
					ExecutionOccurrenceSpecification start = createOccurenceSpecification(execution, coveredLifeline);
					start.setName(execution.getName() + "Start");
					start.setExecution(execution);
					execution.setStart(start);
				}
				// add covered for the execution
				coveredLifeline.getCoveredBys().add(execution);
				execution.getCovereds().add(coveredLifeline);

				// create Occurrence SpecFinish
				Object replaceFinish = request.getParameters().get(SequenceRequestConstant.REPLACE_EXECUTION_SPECIFICATION_FINISH);
				if (replaceFinish instanceof MessageOccurrenceSpecification) {
					execution.setFinish((MessageOccurrenceSpecification) replaceFinish);
				} else {
					ExecutionOccurrenceSpecification finish = createOccurenceSpecification(execution, coveredLifeline);
					finish.setName(execution.getName() + "Finish");
					finish.setExecution(execution);
					execution.setFinish(finish);
				}
				return CommandResult.newOKCommandResult(execution);
			}

		};
	}

	/**
	 * <pre>
	 * Add a command to associated {@link OccurrenceSpecification} and {@link Message}.
	 * This command is only added if the start - finish referenced {@link OccurrenceSpecification} is not 
	 * referenced by another element or the start/finish references are of type {@link ExecutionOccurrenceSpecification}.
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

		ExecutionSpecification es = (ExecutionSpecification) request.getElementToDestroy();

		// Check whether start - finish referenced OccurrenceSpecification should be added to the dependents list
		OccurrenceSpecification osStart = es.getStart();
		if (shouldDestroyOccurrenceSpecification(es, osStart)&& (!(osStart instanceof MessageEnd))) {
			dependentsToDestroy.add(osStart);
		}

		OccurrenceSpecification osFinish = es.getFinish();
		if (shouldDestroyOccurrenceSpecification(es, osFinish)&& (!(osFinish instanceof MessageEnd))) {
			dependentsToDestroy.add(osFinish);
		}

		Set<Lifeline> coveredLifelines = new HashSet<Lifeline>(es.getCovereds());

		// find initiating MOS of a synch message
//		InteractionFragment previousIft = InteractionFragmentHelper.findPreviousFragment(osStart, es.getOwner());
//		while (previousIft != null) {
//			// keep the first ift with the same lifelines, and check it
//			if (coveredLifelines.equals(new HashSet<Lifeline>(previousIft.getCovereds()))) {
//				if (previousIft instanceof MessageOccurrenceSpecification) {
//					Message msg = ((MessageOccurrenceSpecification) previousIft).getMessage();
//					if (msg != null && MessageSort.SYNCH_CALL_LITERAL.equals(msg.getMessageSort())) {
//						dependentsToDestroy.add(previousIft);
//					}
//				}
//				break;
//			}
//			previousIft = InteractionFragmentHelper.findPreviousFragment(previousIft, es.getOwner());
//		}
//
//		// find MOS between the start and finish
//		InteractionFragment fragment = osStart;
//		while (fragment != null && !fragment.equals(osFinish)) {
//			// remove MOS if it have the same covered lifelines as the ES
//			if (fragment instanceof MessageOccurrenceSpecification && coveredLifelines.equals(new HashSet<Lifeline>(fragment.getCovereds()))) {
//				dependentsToDestroy.add(fragment);
//			}
//
//			fragment = InteractionFragmentHelper.findNextFragment(fragment, es.getOwner());
//		}
//
		// return command to destroy dependents
		if (!dependentsToDestroy.isEmpty()) {
			return request.getDestroyDependentsCommand(dependentsToDestroy);
		}

		return null;
	}

	/**
	 * <pre>
	 * Check that given {@link OccurrenceSpecification} should be destroyed along with {@link ExecutionSpecification} which references it.
	 * It should be destroyed in case:
	 * It is of type {@link ExecutionOccurrenceSpecification} (since the opposite reference 
	 *   'ExecutionOccurrenceSpecification::execution[1]' which designates given {@link ExecutionSpecification} is mandatory).
	 *   or
	 * It is not used by another element.
	 * </pre>
	 * 
	 * @param es
	 *            {@link ExecutionSpecification} which references {@link OccurrenceSpecification} (by means of #start/#finish references)
	 * @param os
	 *            start or finish {@link OccurrenceSpecification} which defines the duration of {@link ExecutionSpecification}
	 * @return true in case {@link OccurrenceSpecification} should be destroyed
	 */
	private boolean shouldDestroyOccurrenceSpecification(ExecutionSpecification es, OccurrenceSpecification os) {
		return os instanceof ExecutionOccurrenceSpecification
				|| (os != null && EMFHelper.isOnlyUsage(os, es));
	}

}
