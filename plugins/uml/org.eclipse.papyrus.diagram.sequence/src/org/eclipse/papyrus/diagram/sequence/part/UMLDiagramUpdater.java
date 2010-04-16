/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.sequence.part;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.helper.DurationConstraintHelper;
import org.eclipse.papyrus.diagram.common.helper.TimeConstraintHelper;
import org.eclipse.papyrus.diagram.common.helper.TimeObservationHelper;
import org.eclipse.papyrus.diagram.sequence.edit.parts.ActionExecutionSpecificationEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.BehaviorExecutionSpecificationEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.CombinedFragment2EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.CombinedFragmentCombinedFragmentCompartmentEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.CombinedFragmentEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.CommentEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.ConsiderIgnoreFragmentEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.ConstraintConstrainedElementEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.ConstraintEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.ContinuationEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.DestructionEventEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.DurationConstraintEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.InteractionEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.InteractionInteractionCompartmentEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.InteractionOperandEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.InteractionUseEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.Message2EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.Message3EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.Message4EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.Message5EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.Message6EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.Message7EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.MessageEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.PackageEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.StateInvariantEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.TimeConstraintEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.TimeObservationEditPart;
import org.eclipse.papyrus.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.uml2.uml.ActionExecutionSpecification;
import org.eclipse.uml2.uml.BehaviorExecutionSpecification;
import org.eclipse.uml2.uml.CombinedFragment;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.ConsiderIgnoreFragment;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Continuation;
import org.eclipse.uml2.uml.DestructionEvent;
import org.eclipse.uml2.uml.DurationConstraint;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.InteractionOperand;
import org.eclipse.uml2.uml.InteractionUse;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.StateInvariant;
import org.eclipse.uml2.uml.TimeConstraint;
import org.eclipse.uml2.uml.TimeObservation;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class UMLDiagramUpdater {

	/**
	 * @generated
	 */
	public static List getSemanticChildren(View view) {
		switch(UMLVisualIDRegistry.getVisualID(view)) {
		case InteractionOperandEditPart.VISUAL_ID:
			return getInteractionOperand_3005SemanticChildren(view);
		case LifelineEditPart.VISUAL_ID:
			return getLifeline_3001SemanticChildren(view);
		case InteractionInteractionCompartmentEditPart.VISUAL_ID:
			return getInteractionInteractionCompartment_7001SemanticChildren(view);
		case CombinedFragmentCombinedFragmentCompartmentEditPart.VISUAL_ID:
			return getCombinedFragmentCombinedFragmentCompartment_7004SemanticChildren(view);
		case PackageEditPart.VISUAL_ID:
			return getPackage_1000SemanticChildren(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getInteractionOperand_3005SemanticChildren(View view) {
		if(!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		InteractionOperand modelElement = (InteractionOperand)view.getElement();
		List result = new LinkedList();
		for(Iterator it = modelElement.getFragments().iterator(); it.hasNext();) {
			InteractionFragment childElement = (InteractionFragment)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == InteractionUseEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == CombinedFragmentEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ConsiderIgnoreFragmentEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator it = modelElement.getFragments().iterator(); it.hasNext();) {
			InteractionFragment childElement = (InteractionFragment)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ContinuationEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated NOT (update at each lifeline modification) Added code for manage ExecutionSpecification, handle TimeConstraintEditPart and
	 *            DurationConstraintEditPart children, handle TimeObservationEditPart children
	 */
	public static List getLifeline_3001SemanticChildren(View view) {
		if(!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Lifeline modelElement = (Lifeline)view.getElement();
		List result = new LinkedList();

		// Added code for manage ExecutionSpecification
		if(modelElement instanceof Lifeline) {
			if((modelElement).getCoveredBys().size() > 0) {
				Interaction interaction = modelElement.getInteraction();

				for(Iterator values = interaction.getFragments().iterator(); values.hasNext();) {
					EObject nextValue = (EObject)values.next();
					int visualID = UMLVisualIDRegistry.getNodeVisualID(view, nextValue);
					if(BehaviorExecutionSpecificationEditPart.VISUAL_ID == visualID) {
						BehaviorExecutionSpecification be = (BehaviorExecutionSpecification)nextValue;
						if(be.getCovereds().size() > 0 && be.getCovereds().get(0) == modelElement) {
							// result.add(nextValue);
							result.add(new UMLNodeDescriptor(be, visualID));
						}
					} else if(ActionExecutionSpecificationEditPart.VISUAL_ID == visualID) {
						ActionExecutionSpecification ae = (ActionExecutionSpecification)nextValue;
						if(ae.getCovereds().size() > 0 && ae.getCovereds().get(0) == modelElement) {
							result.add(new UMLNodeDescriptor(ae, visualID));
						}
					} else if(StateInvariantEditPart.VISUAL_ID == visualID) {
						StateInvariant ae = (StateInvariant)nextValue;
						if(ae.getCovereds().size() > 0 && ae.getCovereds().get(0) == modelElement) {
							result.add(new UMLNodeDescriptor(ae, visualID));
						}
					} else if(CombinedFragment2EditPart.VISUAL_ID == visualID) {
						CombinedFragment ae = (CombinedFragment)nextValue;
						if(ae.getCovereds().size() > 0 && ae.getCovereds().get(0) == modelElement) {
							result.add(new UMLNodeDescriptor(ae, visualID));
						}
					}
				}
			}
		}
		/*
		 * Autogenerated code not valid for (Iterator it = modelElement.getFragments().iterator();
		 * it.hasNext();) { InteractionFragment childElement = (InteractionFragment) it.next(); int
		 * visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement); if (visualID ==
		 * BehaviorExecutionSpecificationEditPart.VISUAL_ID) { result.add(new
		 * UMLNodeDescriptor(childElement, visualID)); continue; } }
		 */

		// handle TimeConstraintEditPart and DurationConstraintEditPart children
		if(modelElement instanceof Lifeline) {
			for(InteractionFragment covering : modelElement.getCoveredBys()) {
				for(TimeConstraint childElement : TimeConstraintHelper.getTimeConstraintsOn(covering)) {
					// block from generated code
					int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
					if(visualID == TimeConstraintEditPart.VISUAL_ID) {
						result.add(new UMLNodeDescriptor(childElement, visualID));
						continue;
					}
				}
				for(DurationConstraint childElement : DurationConstraintHelper.getDurationConstraintsOn(covering)) {
					// block from generated code
					int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
					if(visualID == DurationConstraintEditPart.VISUAL_ID) {
						result.add(new UMLNodeDescriptor(childElement, visualID));
						continue;
					}
				}
			}
		}

		// handle TimeObservationEditPart children
		if(modelElement instanceof Lifeline) {
			for(InteractionFragment covering : modelElement.getCoveredBys()) {
				for(TimeObservation childElement : TimeObservationHelper.getTimeObservations(covering)) {
					// block from generated code
					int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
					if(visualID == TimeObservationEditPart.VISUAL_ID) {
						result.add(new UMLNodeDescriptor(childElement, visualID));
						continue;
					}
				}
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInteractionInteractionCompartment_7001SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Interaction modelElement = (Interaction)containerView.getElement();
		List result = new LinkedList();
		for(Iterator it = modelElement.getFragments().iterator(); it.hasNext();) {
			InteractionFragment childElement = (InteractionFragment)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ConsiderIgnoreFragmentEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == CombinedFragmentEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == InteractionUseEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator it = modelElement.getLifelines().iterator(); it.hasNext();) {
			Lifeline childElement = (Lifeline)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == LifelineEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator it = modelElement.getOwnedRules().iterator(); it.hasNext();) {
			Constraint childElement = (Constraint)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ConstraintEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator it = modelElement.getOwnedComments().iterator(); it.hasNext();) {
			Comment childElement = (Comment)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == CommentEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getCombinedFragmentCombinedFragmentCompartment_7004SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		CombinedFragment modelElement = (CombinedFragment)containerView.getElement();
		List result = new LinkedList();
		for(Iterator it = modelElement.getOperands().iterator(); it.hasNext();) {
			InteractionOperand childElement = (InteractionOperand)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == InteractionOperandEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPackage_1000SemanticChildren(View view) {
		if(!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Package modelElement = (Package)view.getElement();
		List result = new LinkedList();
		for(Iterator it = modelElement.getPackagedElements().iterator(); it.hasNext();) {
			PackageableElement childElement = (PackageableElement)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == InteractionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getContainedLinks(View view) {
		switch(UMLVisualIDRegistry.getVisualID(view)) {
		case PackageEditPart.VISUAL_ID:
			return getPackage_1000ContainedLinks(view);
		case InteractionEditPart.VISUAL_ID:
			return getInteraction_2001ContainedLinks(view);
		case ConsiderIgnoreFragmentEditPart.VISUAL_ID:
			return getConsiderIgnoreFragment_3007ContainedLinks(view);
		case CombinedFragmentEditPart.VISUAL_ID:
			return getCombinedFragment_3004ContainedLinks(view);
		case InteractionOperandEditPart.VISUAL_ID:
			return getInteractionOperand_3005ContainedLinks(view);
		case InteractionUseEditPart.VISUAL_ID:
			return getInteractionUse_3002ContainedLinks(view);
		case ContinuationEditPart.VISUAL_ID:
			return getContinuation_3016ContainedLinks(view);
		case LifelineEditPart.VISUAL_ID:
			return getLifeline_3001ContainedLinks(view);
		case ActionExecutionSpecificationEditPart.VISUAL_ID:
			return getActionExecutionSpecification_3006ContainedLinks(view);
		case BehaviorExecutionSpecificationEditPart.VISUAL_ID:
			return getBehaviorExecutionSpecification_3003ContainedLinks(view);
		case StateInvariantEditPart.VISUAL_ID:
			return getStateInvariant_3017ContainedLinks(view);
		case CombinedFragment2EditPart.VISUAL_ID:
			return getCombinedFragment_3018ContainedLinks(view);
		case TimeConstraintEditPart.VISUAL_ID:
			return getTimeConstraint_3019ContainedLinks(view);
		case TimeObservationEditPart.VISUAL_ID:
			return getTimeObservation_3020ContainedLinks(view);
		case DurationConstraintEditPart.VISUAL_ID:
			return getDurationConstraint_3021ContainedLinks(view);
		case DestructionEventEditPart.VISUAL_ID:
			return getDestructionEvent_3022ContainedLinks(view);
		case ConstraintEditPart.VISUAL_ID:
			return getConstraint_3008ContainedLinks(view);
		case CommentEditPart.VISUAL_ID:
			return getComment_3009ContainedLinks(view);
		case MessageEditPart.VISUAL_ID:
			return getMessage_4003ContainedLinks(view);
		case Message2EditPart.VISUAL_ID:
			return getMessage_4004ContainedLinks(view);
		case Message3EditPart.VISUAL_ID:
			return getMessage_4005ContainedLinks(view);
		case Message4EditPart.VISUAL_ID:
			return getMessage_4006ContainedLinks(view);
		case Message5EditPart.VISUAL_ID:
			return getMessage_4007ContainedLinks(view);
		case Message6EditPart.VISUAL_ID:
			return getMessage_4008ContainedLinks(view);
		case Message7EditPart.VISUAL_ID:
			return getMessage_4009ContainedLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIncomingLinks(View view) {
		switch(UMLVisualIDRegistry.getVisualID(view)) {
		case InteractionEditPart.VISUAL_ID:
			return getInteraction_2001IncomingLinks(view);
		case ConsiderIgnoreFragmentEditPart.VISUAL_ID:
			return getConsiderIgnoreFragment_3007IncomingLinks(view);
		case CombinedFragmentEditPart.VISUAL_ID:
			return getCombinedFragment_3004IncomingLinks(view);
		case InteractionOperandEditPart.VISUAL_ID:
			return getInteractionOperand_3005IncomingLinks(view);
		case InteractionUseEditPart.VISUAL_ID:
			return getInteractionUse_3002IncomingLinks(view);
		case ContinuationEditPart.VISUAL_ID:
			return getContinuation_3016IncomingLinks(view);
		case LifelineEditPart.VISUAL_ID:
			return getLifeline_3001IncomingLinks(view);
		case ActionExecutionSpecificationEditPart.VISUAL_ID:
			return getActionExecutionSpecification_3006IncomingLinks(view);
		case BehaviorExecutionSpecificationEditPart.VISUAL_ID:
			return getBehaviorExecutionSpecification_3003IncomingLinks(view);
		case StateInvariantEditPart.VISUAL_ID:
			return getStateInvariant_3017IncomingLinks(view);
		case CombinedFragment2EditPart.VISUAL_ID:
			return getCombinedFragment_3018IncomingLinks(view);
		case TimeConstraintEditPart.VISUAL_ID:
			return getTimeConstraint_3019IncomingLinks(view);
		case TimeObservationEditPart.VISUAL_ID:
			return getTimeObservation_3020IncomingLinks(view);
		case DurationConstraintEditPart.VISUAL_ID:
			return getDurationConstraint_3021IncomingLinks(view);
		case DestructionEventEditPart.VISUAL_ID:
			return getDestructionEvent_3022IncomingLinks(view);
		case ConstraintEditPart.VISUAL_ID:
			return getConstraint_3008IncomingLinks(view);
		case CommentEditPart.VISUAL_ID:
			return getComment_3009IncomingLinks(view);
		case MessageEditPart.VISUAL_ID:
			return getMessage_4003IncomingLinks(view);
		case Message2EditPart.VISUAL_ID:
			return getMessage_4004IncomingLinks(view);
		case Message3EditPart.VISUAL_ID:
			return getMessage_4005IncomingLinks(view);
		case Message4EditPart.VISUAL_ID:
			return getMessage_4006IncomingLinks(view);
		case Message5EditPart.VISUAL_ID:
			return getMessage_4007IncomingLinks(view);
		case Message6EditPart.VISUAL_ID:
			return getMessage_4008IncomingLinks(view);
		case Message7EditPart.VISUAL_ID:
			return getMessage_4009IncomingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOutgoingLinks(View view) {
		switch(UMLVisualIDRegistry.getVisualID(view)) {
		case InteractionEditPart.VISUAL_ID:
			return getInteraction_2001OutgoingLinks(view);
		case ConsiderIgnoreFragmentEditPart.VISUAL_ID:
			return getConsiderIgnoreFragment_3007OutgoingLinks(view);
		case CombinedFragmentEditPart.VISUAL_ID:
			return getCombinedFragment_3004OutgoingLinks(view);
		case InteractionOperandEditPart.VISUAL_ID:
			return getInteractionOperand_3005OutgoingLinks(view);
		case InteractionUseEditPart.VISUAL_ID:
			return getInteractionUse_3002OutgoingLinks(view);
		case ContinuationEditPart.VISUAL_ID:
			return getContinuation_3016OutgoingLinks(view);
		case LifelineEditPart.VISUAL_ID:
			return getLifeline_3001OutgoingLinks(view);
		case ActionExecutionSpecificationEditPart.VISUAL_ID:
			return getActionExecutionSpecification_3006OutgoingLinks(view);
		case BehaviorExecutionSpecificationEditPart.VISUAL_ID:
			return getBehaviorExecutionSpecification_3003OutgoingLinks(view);
		case StateInvariantEditPart.VISUAL_ID:
			return getStateInvariant_3017OutgoingLinks(view);
		case CombinedFragment2EditPart.VISUAL_ID:
			return getCombinedFragment_3018OutgoingLinks(view);
		case TimeConstraintEditPart.VISUAL_ID:
			return getTimeConstraint_3019OutgoingLinks(view);
		case TimeObservationEditPart.VISUAL_ID:
			return getTimeObservation_3020OutgoingLinks(view);
		case DurationConstraintEditPart.VISUAL_ID:
			return getDurationConstraint_3021OutgoingLinks(view);
		case DestructionEventEditPart.VISUAL_ID:
			return getDestructionEvent_3022OutgoingLinks(view);
		case ConstraintEditPart.VISUAL_ID:
			return getConstraint_3008OutgoingLinks(view);
		case CommentEditPart.VISUAL_ID:
			return getComment_3009OutgoingLinks(view);
		case MessageEditPart.VISUAL_ID:
			return getMessage_4003OutgoingLinks(view);
		case Message2EditPart.VISUAL_ID:
			return getMessage_4004OutgoingLinks(view);
		case Message3EditPart.VISUAL_ID:
			return getMessage_4005OutgoingLinks(view);
		case Message4EditPart.VISUAL_ID:
			return getMessage_4006OutgoingLinks(view);
		case Message5EditPart.VISUAL_ID:
			return getMessage_4007OutgoingLinks(view);
		case Message6EditPart.VISUAL_ID:
			return getMessage_4008OutgoingLinks(view);
		case Message7EditPart.VISUAL_ID:
			return getMessage_4009OutgoingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getPackage_1000ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getInteraction_2001ContainedLinks(View view) {
		Interaction modelElement = (Interaction)view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Message_4003(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Message_4004(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Message_4005(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Message_4006(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Message_4007(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Message_4008(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Message_4009(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getLifeline_3001ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getBehaviorExecutionSpecification_3003ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getStateInvariant_3017ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getCombinedFragment_3018ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getTimeConstraint_3019ContainedLinks(View view) {
		TimeConstraint modelElement = (TimeConstraint)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4011(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getTimeObservation_3020ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getDurationConstraint_3021ContainedLinks(View view) {
		DurationConstraint modelElement = (DurationConstraint)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4011(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDestructionEvent_3022ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getActionExecutionSpecification_3006ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getInteractionUse_3002ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getCombinedFragment_3004ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getInteractionOperand_3005ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getContinuation_3016ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getConstraint_3008ContainedLinks(View view) {
		Constraint modelElement = (Constraint)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4011(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getComment_3009ContainedLinks(View view) {
		Comment modelElement = (Comment)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Comment_AnnotatedElement_4010(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getConsiderIgnoreFragment_3007ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getMessage_4003ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getMessage_4004ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getMessage_4005ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getMessage_4006ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getMessage_4007ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getMessage_4008ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getMessage_4009ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getInteraction_2001IncomingLinks(View view) {
		Interaction modelElement = (Interaction)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Message_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4009(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4010(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4011(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getLifeline_3001IncomingLinks(View view) {
		Lifeline modelElement = (Lifeline)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Message_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4009(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4010(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4011(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getBehaviorExecutionSpecification_3003IncomingLinks(View view) {
		BehaviorExecutionSpecification modelElement = (BehaviorExecutionSpecification)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Message_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4009(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4010(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4011(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getStateInvariant_3017IncomingLinks(View view) {
		StateInvariant modelElement = (StateInvariant)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Message_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4009(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4010(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4011(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getCombinedFragment_3018IncomingLinks(View view) {
		CombinedFragment modelElement = (CombinedFragment)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Message_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4009(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4010(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4011(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getTimeConstraint_3019IncomingLinks(View view) {
		TimeConstraint modelElement = (TimeConstraint)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Message_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4009(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4010(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4011(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getTimeObservation_3020IncomingLinks(View view) {
		TimeObservation modelElement = (TimeObservation)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Message_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4009(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4010(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4011(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDurationConstraint_3021IncomingLinks(View view) {
		DurationConstraint modelElement = (DurationConstraint)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Message_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4009(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4010(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4011(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDestructionEvent_3022IncomingLinks(View view) {
		DestructionEvent modelElement = (DestructionEvent)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Message_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4009(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4010(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4011(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getActionExecutionSpecification_3006IncomingLinks(View view) {
		ActionExecutionSpecification modelElement = (ActionExecutionSpecification)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Message_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4009(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4010(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4011(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInteractionUse_3002IncomingLinks(View view) {
		InteractionUse modelElement = (InteractionUse)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Message_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4009(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4010(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4011(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getCombinedFragment_3004IncomingLinks(View view) {
		CombinedFragment modelElement = (CombinedFragment)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Message_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4009(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4010(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4011(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInteractionOperand_3005IncomingLinks(View view) {
		InteractionOperand modelElement = (InteractionOperand)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Message_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4009(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4010(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4011(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getContinuation_3016IncomingLinks(View view) {
		Continuation modelElement = (Continuation)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Message_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4009(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4010(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4011(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getConstraint_3008IncomingLinks(View view) {
		Constraint modelElement = (Constraint)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Message_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4009(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4010(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4011(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getComment_3009IncomingLinks(View view) {
		Comment modelElement = (Comment)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Message_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4009(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4010(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4011(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getConsiderIgnoreFragment_3007IncomingLinks(View view) {
		ConsiderIgnoreFragment modelElement = (ConsiderIgnoreFragment)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Message_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4009(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4010(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4011(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getMessage_4003IncomingLinks(View view) {
		Message modelElement = (Message)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Message_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4009(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4010(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4011(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getMessage_4004IncomingLinks(View view) {
		Message modelElement = (Message)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Message_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4009(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4010(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4011(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getMessage_4005IncomingLinks(View view) {
		Message modelElement = (Message)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Message_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4009(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4010(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4011(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getMessage_4006IncomingLinks(View view) {
		Message modelElement = (Message)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Message_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4009(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4010(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4011(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getMessage_4007IncomingLinks(View view) {
		Message modelElement = (Message)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Message_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4009(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4010(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4011(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getMessage_4008IncomingLinks(View view) {
		Message modelElement = (Message)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Message_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4009(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4010(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4011(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getMessage_4009IncomingLinks(View view) {
		Message modelElement = (Message)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Message_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Message_4009(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4010(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4011(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInteraction_2001OutgoingLinks(View view) {
		Interaction modelElement = (Interaction)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4009(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getLifeline_3001OutgoingLinks(View view) {
		Lifeline modelElement = (Lifeline)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4009(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getBehaviorExecutionSpecification_3003OutgoingLinks(View view) {
		BehaviorExecutionSpecification modelElement = (BehaviorExecutionSpecification)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4009(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getStateInvariant_3017OutgoingLinks(View view) {
		StateInvariant modelElement = (StateInvariant)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4009(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getCombinedFragment_3018OutgoingLinks(View view) {
		CombinedFragment modelElement = (CombinedFragment)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4009(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getTimeConstraint_3019OutgoingLinks(View view) {
		TimeConstraint modelElement = (TimeConstraint)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4009(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4011(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getTimeObservation_3020OutgoingLinks(View view) {
		TimeObservation modelElement = (TimeObservation)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4009(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDurationConstraint_3021OutgoingLinks(View view) {
		DurationConstraint modelElement = (DurationConstraint)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4009(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4011(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDestructionEvent_3022OutgoingLinks(View view) {
		DestructionEvent modelElement = (DestructionEvent)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4009(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getActionExecutionSpecification_3006OutgoingLinks(View view) {
		ActionExecutionSpecification modelElement = (ActionExecutionSpecification)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4009(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInteractionUse_3002OutgoingLinks(View view) {
		InteractionUse modelElement = (InteractionUse)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4009(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getCombinedFragment_3004OutgoingLinks(View view) {
		CombinedFragment modelElement = (CombinedFragment)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4009(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInteractionOperand_3005OutgoingLinks(View view) {
		InteractionOperand modelElement = (InteractionOperand)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4009(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getContinuation_3016OutgoingLinks(View view) {
		Continuation modelElement = (Continuation)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4009(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getConstraint_3008OutgoingLinks(View view) {
		Constraint modelElement = (Constraint)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4009(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4011(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getComment_3009OutgoingLinks(View view) {
		Comment modelElement = (Comment)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4009(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Comment_AnnotatedElement_4010(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getConsiderIgnoreFragment_3007OutgoingLinks(View view) {
		ConsiderIgnoreFragment modelElement = (ConsiderIgnoreFragment)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4009(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getMessage_4003OutgoingLinks(View view) {
		Message modelElement = (Message)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4009(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getMessage_4004OutgoingLinks(View view) {
		Message modelElement = (Message)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4009(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getMessage_4005OutgoingLinks(View view) {
		Message modelElement = (Message)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4009(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getMessage_4006OutgoingLinks(View view) {
		Message modelElement = (Message)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4009(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getMessage_4007OutgoingLinks(View view) {
		Message modelElement = (Message)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4009(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getMessage_4008OutgoingLinks(View view) {
		Message modelElement = (Message)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4009(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getMessage_4009OutgoingLinks(View view) {
		Message modelElement = (Message)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Message_4009(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_Message_4003(Interaction container) {
		Collection result = new LinkedList();
		for(Iterator links = container.getMessages().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof Message) {
				continue;
			}
			Message link = (Message)linkObject;
			if(MessageEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}





			List targets = link.getOwnedElements();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if(false == theTarget instanceof Element) {
				continue;
			}
			Element dst = (Element)theTarget;
			Element src = link.getOwner();
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Message_4003, MessageEditPart.VISUAL_ID));


		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_Message_4004(Interaction container) {
		Collection result = new LinkedList();
		for(Iterator links = container.getMessages().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof Message) {
				continue;
			}
			Message link = (Message)linkObject;
			if(Message2EditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}





			List targets = link.getOwnedElements();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if(false == theTarget instanceof Element) {
				continue;
			}
			Element dst = (Element)theTarget;
			Element src = link.getOwner();
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Message_4004, Message2EditPart.VISUAL_ID));


		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_Message_4005(Interaction container) {
		Collection result = new LinkedList();
		for(Iterator links = container.getMessages().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof Message) {
				continue;
			}
			Message link = (Message)linkObject;
			if(Message3EditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}





			List targets = link.getOwnedElements();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if(false == theTarget instanceof Element) {
				continue;
			}
			Element dst = (Element)theTarget;
			Element src = link.getOwner();
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Message_4005, Message3EditPart.VISUAL_ID));


		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_Message_4006(Interaction container) {
		Collection result = new LinkedList();
		for(Iterator links = container.getMessages().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof Message) {
				continue;
			}
			Message link = (Message)linkObject;
			if(Message4EditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}





			List targets = link.getOwnedElements();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if(false == theTarget instanceof Element) {
				continue;
			}
			Element dst = (Element)theTarget;
			Element src = link.getOwner();
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Message_4006, Message4EditPart.VISUAL_ID));


		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_Message_4007(Interaction container) {
		Collection result = new LinkedList();
		for(Iterator links = container.getMessages().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof Message) {
				continue;
			}
			Message link = (Message)linkObject;
			if(Message5EditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}





			List targets = link.getOwnedElements();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if(false == theTarget instanceof Element) {
				continue;
			}
			Element dst = (Element)theTarget;
			Element src = link.getOwner();
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Message_4007, Message5EditPart.VISUAL_ID));


		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_Message_4008(Interaction container) {
		Collection result = new LinkedList();
		for(Iterator links = container.getMessages().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof Message) {
				continue;
			}
			Message link = (Message)linkObject;
			if(Message6EditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}





			List targets = link.getOwnedElements();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if(false == theTarget instanceof Element) {
				continue;
			}
			Element dst = (Element)theTarget;
			Element src = link.getOwner();
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Message_4008, Message6EditPart.VISUAL_ID));


		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_Message_4009(Interaction container) {
		Collection result = new LinkedList();
		for(Iterator links = container.getMessages().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof Message) {
				continue;
			}
			Message link = (Message)linkObject;
			if(Message7EditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}





			List targets = link.getOwnedElements();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if(false == theTarget instanceof Element) {
				continue;
			}
			Element dst = (Element)theTarget;
			Element src = link.getOwner();
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Message_4009, Message7EditPart.VISUAL_ID));


		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_Message_4003(Element target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection)crossReferences.get(target);
		for(Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting)it.next();
			if(setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getElement_OwnedElement() || false == setting.getEObject() instanceof Message) {
				continue;
			}
			Message link = (Message)setting.getEObject();
			if(MessageEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Element src = link.getOwner();
			result.add(new UMLLinkDescriptor(src, target, link, UMLElementTypes.Message_4003, MessageEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_Message_4004(Element target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection)crossReferences.get(target);
		for(Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting)it.next();
			if(setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getElement_OwnedElement() || false == setting.getEObject() instanceof Message) {
				continue;
			}
			Message link = (Message)setting.getEObject();
			if(Message2EditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Element src = link.getOwner();
			result.add(new UMLLinkDescriptor(src, target, link, UMLElementTypes.Message_4004, Message2EditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_Message_4005(Element target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection)crossReferences.get(target);
		for(Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting)it.next();
			if(setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getElement_OwnedElement() || false == setting.getEObject() instanceof Message) {
				continue;
			}
			Message link = (Message)setting.getEObject();
			if(Message3EditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Element src = link.getOwner();
			result.add(new UMLLinkDescriptor(src, target, link, UMLElementTypes.Message_4005, Message3EditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_Message_4006(Element target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection)crossReferences.get(target);
		for(Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting)it.next();
			if(setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getElement_OwnedElement() || false == setting.getEObject() instanceof Message) {
				continue;
			}
			Message link = (Message)setting.getEObject();
			if(Message4EditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Element src = link.getOwner();
			result.add(new UMLLinkDescriptor(src, target, link, UMLElementTypes.Message_4006, Message4EditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_Message_4007(Element target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection)crossReferences.get(target);
		for(Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting)it.next();
			if(setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getElement_OwnedElement() || false == setting.getEObject() instanceof Message) {
				continue;
			}
			Message link = (Message)setting.getEObject();
			if(Message5EditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Element src = link.getOwner();
			result.add(new UMLLinkDescriptor(src, target, link, UMLElementTypes.Message_4007, Message5EditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_Message_4008(Element target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection)crossReferences.get(target);
		for(Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting)it.next();
			if(setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getElement_OwnedElement() || false == setting.getEObject() instanceof Message) {
				continue;
			}
			Message link = (Message)setting.getEObject();
			if(Message6EditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Element src = link.getOwner();
			result.add(new UMLLinkDescriptor(src, target, link, UMLElementTypes.Message_4008, Message6EditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_Message_4009(Element target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection)crossReferences.get(target);
		for(Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting)it.next();
			if(setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getElement_OwnedElement() || false == setting.getEObject() instanceof Message) {
				continue;
			}
			Message link = (Message)setting.getEObject();
			if(Message7EditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Element src = link.getOwner();
			result.add(new UMLLinkDescriptor(src, target, link, UMLElementTypes.Message_4009, Message7EditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4010(Element target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection)crossReferences.get(target);
		for(Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting)it.next();
			if(setting.getEStructuralFeature() == UMLPackage.eINSTANCE.getComment_AnnotatedElement()) {
				result.add(new UMLLinkDescriptor(setting.getEObject(), target, UMLElementTypes.CommentAnnotatedElement_4010, CommentAnnotatedElementEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4011(Element target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection)crossReferences.get(target);
		for(Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting)it.next();
			if(setting.getEStructuralFeature() == UMLPackage.eINSTANCE.getConstraint_ConstrainedElement()) {
				result.add(new UMLLinkDescriptor(setting.getEObject(), target, UMLElementTypes.ConstraintConstrainedElement_4011, ConstraintConstrainedElementEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_Message_4003(Element source) {
		Interaction container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for(EObject element = source; element != null && container == null; element = element.eContainer()) {
			if(element instanceof Interaction) {
				container = (Interaction)element;
			}
		}
		if(container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for(Iterator links = container.getMessages().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof Message) {
				continue;
			}
			Message link = (Message)linkObject;
			if(MessageEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}





			List targets = link.getOwnedElements();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if(false == theTarget instanceof Element) {
				continue;
			}
			Element dst = (Element)theTarget;
			Element src = link.getOwner();
			if(src != source) {
				continue;
			}
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Message_4003, MessageEditPart.VISUAL_ID));


		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_Message_4004(Element source) {
		Interaction container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for(EObject element = source; element != null && container == null; element = element.eContainer()) {
			if(element instanceof Interaction) {
				container = (Interaction)element;
			}
		}
		if(container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for(Iterator links = container.getMessages().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof Message) {
				continue;
			}
			Message link = (Message)linkObject;
			if(Message2EditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}





			List targets = link.getOwnedElements();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if(false == theTarget instanceof Element) {
				continue;
			}
			Element dst = (Element)theTarget;
			Element src = link.getOwner();
			if(src != source) {
				continue;
			}
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Message_4004, Message2EditPart.VISUAL_ID));


		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_Message_4005(Element source) {
		Interaction container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for(EObject element = source; element != null && container == null; element = element.eContainer()) {
			if(element instanceof Interaction) {
				container = (Interaction)element;
			}
		}
		if(container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for(Iterator links = container.getMessages().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof Message) {
				continue;
			}
			Message link = (Message)linkObject;
			if(Message3EditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}





			List targets = link.getOwnedElements();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if(false == theTarget instanceof Element) {
				continue;
			}
			Element dst = (Element)theTarget;
			Element src = link.getOwner();
			if(src != source) {
				continue;
			}
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Message_4005, Message3EditPart.VISUAL_ID));


		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_Message_4006(Element source) {
		Interaction container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for(EObject element = source; element != null && container == null; element = element.eContainer()) {
			if(element instanceof Interaction) {
				container = (Interaction)element;
			}
		}
		if(container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for(Iterator links = container.getMessages().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof Message) {
				continue;
			}
			Message link = (Message)linkObject;
			if(Message4EditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}





			List targets = link.getOwnedElements();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if(false == theTarget instanceof Element) {
				continue;
			}
			Element dst = (Element)theTarget;
			Element src = link.getOwner();
			if(src != source) {
				continue;
			}
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Message_4006, Message4EditPart.VISUAL_ID));


		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_Message_4007(Element source) {
		Interaction container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for(EObject element = source; element != null && container == null; element = element.eContainer()) {
			if(element instanceof Interaction) {
				container = (Interaction)element;
			}
		}
		if(container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for(Iterator links = container.getMessages().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof Message) {
				continue;
			}
			Message link = (Message)linkObject;
			if(Message5EditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}





			List targets = link.getOwnedElements();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if(false == theTarget instanceof Element) {
				continue;
			}
			Element dst = (Element)theTarget;
			Element src = link.getOwner();
			if(src != source) {
				continue;
			}
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Message_4007, Message5EditPart.VISUAL_ID));


		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_Message_4008(Element source) {
		Interaction container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for(EObject element = source; element != null && container == null; element = element.eContainer()) {
			if(element instanceof Interaction) {
				container = (Interaction)element;
			}
		}
		if(container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for(Iterator links = container.getMessages().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof Message) {
				continue;
			}
			Message link = (Message)linkObject;
			if(Message6EditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}





			List targets = link.getOwnedElements();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if(false == theTarget instanceof Element) {
				continue;
			}
			Element dst = (Element)theTarget;
			Element src = link.getOwner();
			if(src != source) {
				continue;
			}
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Message_4008, Message6EditPart.VISUAL_ID));


		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_Message_4009(Element source) {
		Interaction container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for(EObject element = source; element != null && container == null; element = element.eContainer()) {
			if(element instanceof Interaction) {
				container = (Interaction)element;
			}
		}
		if(container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for(Iterator links = container.getMessages().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof Message) {
				continue;
			}
			Message link = (Message)linkObject;
			if(Message7EditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}





			List targets = link.getOwnedElements();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if(false == theTarget instanceof Element) {
				continue;
			}
			Element dst = (Element)theTarget;
			Element src = link.getOwner();
			if(src != source) {
				continue;
			}
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Message_4009, Message7EditPart.VISUAL_ID));


		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_Comment_AnnotatedElement_4010(Comment source) {
		Collection result = new LinkedList();
		for(Iterator destinations = source.getAnnotatedElements().iterator(); destinations.hasNext();) {
			Element destination = (Element)destinations.next();
			result.add(new UMLLinkDescriptor(source, destination, UMLElementTypes.CommentAnnotatedElement_4010, CommentAnnotatedElementEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4011(Constraint source) {
		Collection result = new LinkedList();
		for(Iterator destinations = source.getConstrainedElements().iterator(); destinations.hasNext();) {
			Element destination = (Element)destinations.next();
			result.add(new UMLLinkDescriptor(source, destination, UMLElementTypes.ConstraintConstrainedElement_4011, ConstraintConstrainedElementEditPart.VISUAL_ID));
		}
		return result;
	}

}
