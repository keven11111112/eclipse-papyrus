/*****************************************************************************
 * Copyright (c) 2017 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.sequence.edit.policies;

import java.util.HashSet;
import java.util.Iterator;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.editpolicies.GraphicalEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IPrimaryEditPart;
import org.eclipse.papyrus.infra.gmfdiag.common.SemanticFromGMFElement;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.AbstractExecutionSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.AbstractMessageEditPart;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.ExecutionSpecification;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageEnd;
import org.eclipse.uml2.uml.OccurrenceSpecification;

/**
 * this class is used to manage strong and weak references to editPart in the sequence : all execution specification and all messages
 * for example: a message  connected to an executionSpecification means that a strong reference exists between editpart of the message
 * and the editpart of the execution specification.
 * Two consecutive execution specifications on the same life-line means that a weak reference exists from the top exec to the bottom lifeline.
 *  
 *
 */
public class SequenceReferenceEditPolicy extends GraphicalEditPolicy {
	public static String SEQUENCE_REFERENCE="SEQUENCE_REFERENCE";

	protected HashSet<EditPart> weakReferences= new HashSet<EditPart>();
	protected HashSet<EditPart> strongReferences= new HashSet<EditPart>();
	/**
	 * @return the weakReferences
	 */
	public HashSet<EditPart> getWeakReferences() {
		return weakReferences;
	}
	/**
	 * @return the strongReferences
	 */
	public HashSet<EditPart> getStrongReferences() {
		return strongReferences;
	}

	/**
	 * @see org.eclipse.gef.editpolicies.AbstractEditPolicy#activate()
	 *
	 */
	@Override
	public void activate() {
		super.activate();
		updateStrongAndWeakReferences();
	}


	/**
	 * compute strong a weak reference
	 */
	public void updateStrongAndWeakReferences() {
		strongReferences.clear();
		weakReferences.clear();

		//management of execution specification
		if( getHost() instanceof AbstractExecutionSpecificationEditPart) {
			ExecutionSpecification exec= (ExecutionSpecification)((AbstractExecutionSpecificationEditPart)getHost()).resolveSemanticElement();
			//manage Strong references
			if( exec.getStart() instanceof MessageEnd) {
				MessageEnd messageEnd=(MessageEnd) exec.getStart();
				addMessageIntoReferences(messageEnd, strongReferences);
			}
			if( exec.getFinish() instanceof MessageEnd) {
				MessageEnd messageEnd=(MessageEnd) exec.getFinish();
				addMessageIntoReferences(messageEnd, strongReferences);
			}
			//manage weak references
			//the weak reference is the next element associated to next event after the finish event.
			if(exec.getCovereds().size()==1) {
				Lifeline currentLifeline= exec.getCovereds().get(0);

				fillWeakReference((OccurrenceSpecification)exec.getFinish(), currentLifeline);
			}
		}
		//management of messages
		if( getHost() instanceof AbstractMessageEditPart) {
			Message aMessage= (Message)((AbstractMessageEditPart)getHost()).resolveSemanticElement();
			//manage Strong references
			//fill about source
			MessageEnd sourceEvent=aMessage.getSendEvent();
			addExecutionSpecIntoReferences((OccurrenceSpecification)sourceEvent, strongReferences);
			//fill about target
			MessageEnd targetEvent=aMessage.getReceiveEvent();
			addExecutionSpecIntoReferences((OccurrenceSpecification)targetEvent, strongReferences);

			//manage weakReferences
			//source
			if(((OccurrenceSpecification)sourceEvent).getCovereds().size()==1) {
				Lifeline currentLifeline= ((OccurrenceSpecification)sourceEvent).getCovereds().get(0);
				fillWeakReference(((OccurrenceSpecification)sourceEvent), currentLifeline);
			}
			//target
			if(((OccurrenceSpecification)targetEvent).getCovereds().size()==1) {
				Lifeline currentLifeline= ((OccurrenceSpecification)targetEvent).getCovereds().get(0);
				fillWeakReference(((OccurrenceSpecification)targetEvent), currentLifeline);
			}
		}


	}

	/**
	 * this method is used to add a weak reference from the next event after the given event
	 * @param sourceEvent the given event the next is maybe an  element to add in the weakreference
	 * @param currentLifeline, the lifeline where we look for the next event
	 */
	protected void fillWeakReference(OccurrenceSpecification sourceEvent, Lifeline currentLifeline) {
		Element nextEvent=getNextEventFromLifeline(currentLifeline, sourceEvent);
		if( nextEvent instanceof MessageEnd) {
			addMessageIntoReferences((MessageEnd)nextEvent, weakReferences);
		}
		else if(nextEvent instanceof OccurrenceSpecification) {
			addExecutionSpecIntoReferences((OccurrenceSpecification)nextEvent, weakReferences);
		}
	}
	/**
	 * this method is used to get the execution specification associated to the message End
	 * @param event the given event where we look for a executionSpecification, must be never null
	 * @return the associated execution specification or null if there is no association
	 */
	protected ExecutionSpecification getExecutionSpecificationAssociatedToEvent(OccurrenceSpecification event) {
		ExecutionSpecification exec=null;
		if(event.getCovereds().size()>0) {
			Lifeline currentLifeline= event.getCovereds().get(0);
			int index=0;
			while(exec==null&&index<currentLifeline.getCoveredBys().size()) {
				if( currentLifeline.getCoveredBys().get(index) instanceof ExecutionSpecification) {
					ExecutionSpecification currentExec=(ExecutionSpecification)currentLifeline.getCoveredBys().get(index);
					if( event.equals(currentExec.getStart())){
						exec=currentExec;
					}
					if( event.equals(currentExec.getFinish())){
						exec=currentExec;
					}
				}
				index++;
			}
		}
		return exec;
	}
	/**
	 * this method returns the next events after the given event 
	 * @param event we look for the next event after this one.
	 * @param currentLifeline the current lifeline where we look for the covered element
	 * @return null if there is not event after the given event or the next.
	 */
	protected Element getNextEventFromLifeline(Lifeline currentLifeline, Object event) {
		int index=currentLifeline.getCoveredBys().indexOf(event);
		Element nextEvent=null;
		if(index!=-1) {
			//we look for the next event
			index=index+1;
			while(nextEvent==null && (index<currentLifeline.getCoveredBys().size())) {
				if(currentLifeline.getCoveredBys().get(index) instanceof MessageEnd||
						currentLifeline.getCoveredBys().get(index) instanceof OccurrenceSpecification) {
					nextEvent=currentLifeline.getCoveredBys().get(index);
				}
				index++;
			}
		}
		return nextEvent;
	}
	/**
	 * given a messageEnd, the corresponding editPart to a message is adding to the references list 
	 * @param messageEnd a messageEnd
	 * @param referenceList the list of references
	 */
	protected void addMessageIntoReferences(MessageEnd messageEnd, HashSet<EditPart> referenceList) {
		if( messageEnd.getMessage()!=null) {
			IGraphicalEditPart resultedEditPart=getEditPartFromSemantic(messageEnd.getMessage());
			if( resultedEditPart!=null) {
				referenceList.add(resultedEditPart);
			}
		}		
	}

	/**
	 * given a messageEnd, the corresponding editPart to a ExecutionSpec is added to the references list 
	 * @param messageEnd a messageEnd
	 * @param referenceList the list of references
	 */
	protected void addExecutionSpecIntoReferences(OccurrenceSpecification sourceEvent, HashSet<EditPart> referenceList) {
		ExecutionSpecification executionSpec=getExecutionSpecificationAssociatedToEvent(sourceEvent);
		if( executionSpec!=null) {
			IGraphicalEditPart resultedEditPart=getEditPartFromSemantic(executionSpec);
			if( resultedEditPart!=null) {
				referenceList.add(resultedEditPart);
			}
		}

	}
	/**
	 * this method return the controller attached to the semantic element
	 * the complexity of this algorithm is N (N the number of controller in the opened sequence diagram)
	 * @param semanticElement  must be different from null
	 * @return the reference to the controller or null.
	 */
	protected IGraphicalEditPart getEditPartFromSemantic(Object semanticElement) {
		IGraphicalEditPart researchedEditPart = null;
		SemanticFromGMFElement semanticFromGMFElement  =new SemanticFromGMFElement();
		EditPartViewer editPartViewer = getHost().getViewer();
		if (editPartViewer != null) {
			// look for all edit part if the semantic is contained in the list
			Iterator<?> iter = editPartViewer.getEditPartRegistry().values().iterator();

			while (iter.hasNext() && researchedEditPart==null) {
				Object currentEditPart = iter.next();
				// look only amidst IPrimary editpart to avoid compartment and labels of links
				if (currentEditPart instanceof IPrimaryEditPart) {
					Object currentElement = semanticFromGMFElement.getSemanticElement(currentEditPart);
					if( semanticElement.equals(currentElement)) {
						researchedEditPart = ((IGraphicalEditPart) currentEditPart);
					}
				}
			}
		}
		return researchedEditPart;
	}
}