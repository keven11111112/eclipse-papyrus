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
package org.eclipse.papyrus.uml.diagram.sequence.navigator;

import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.ITreePathLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.ViewerLabel;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.ActionExecutionSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.BehaviorExecutionSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragment2EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CommentBodyEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CommentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.ConsiderIgnoreFragmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.ConstraintConstrainedElementEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.ConstraintEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.ConstraintNameEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.ContinuationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.ContinuationNameEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DestructionOccurrenceSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DurationConstraintEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DurationConstraintInMessageEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DurationConstraintInMessageLabelEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DurationConstraintLabelEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DurationObservationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DurationObservationLabelEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.GeneralOrderingAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.GeneralOrderingEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionNameEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionOperandEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionUseEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionUseNameEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineNameEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageAsyncEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageAsyncNameEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageCreateEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageCreateNameEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageDeleteEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageDeleteNameEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageFoundEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageFoundNameEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageLostEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageLostNameEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageReplyEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageReplyNameEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageSyncEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageSyncNameEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.PackageEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.StateInvariantEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.StateInvariantNameEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.TimeConstraintEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.TimeConstraintLabelEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.TimeObservationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.TimeObservationLabelEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.uml.diagram.sequence.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLParserProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;
import org.eclipse.uml2.uml.ActionExecutionSpecification;
import org.eclipse.uml2.uml.BehaviorExecutionSpecification;
import org.eclipse.uml2.uml.CombinedFragment;
import org.eclipse.uml2.uml.ConsiderIgnoreFragment;
import org.eclipse.uml2.uml.DestructionOccurrenceSpecification;
import org.eclipse.uml2.uml.InteractionOperand;
import org.eclipse.uml2.uml.Package;

/**
 * @generated
 */
public class UMLNavigatorLabelProvider extends LabelProvider implements ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		UMLDiagramEditorPlugin.getInstance().getImageRegistry().put("Navigator?UnknownElement", //$NON-NLS-1$
				ImageDescriptor.getMissingImageDescriptor());
		UMLDiagramEditorPlugin.getInstance().getImageRegistry().put("Navigator?ImageNotFound", //$NON-NLS-1$
				ImageDescriptor.getMissingImageDescriptor());
	}

	/**
	 * @generated
	 */
	@Override
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof UMLNavigatorItem && !isOwnView(((UMLNavigatorItem) element).getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	 * @generated
	 */
	@Override
	public Image getImage(Object element) {
		if (element instanceof UMLNavigatorGroup) {
			UMLNavigatorGroup group = (UMLNavigatorGroup) element;
			return UMLDiagramEditorPlugin.getInstance().getBundledImage(group.getIcon());
		}

		if (element instanceof UMLNavigatorItem) {
			UMLNavigatorItem navigatorItem = (UMLNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return super.getImage(element);
			}
			return getImage(navigatorItem.getView());
		}

		return super.getImage(element);
	}

	/**
	 * @generated
	 */
	public Image getImage(View view) {
		switch (UMLVisualIDRegistry.getVisualID(view)) {
		case PackageEditPart.VISUAL_ID:
			return getImage("Navigator?Diagram?http://www.eclipse.org/uml2/5.0.0/UML?Package", //$NON-NLS-1$
					UMLElementTypes.Package_SequenceDiagram);
		case InteractionEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/5.0.0/UML?Interaction", //$NON-NLS-1$
					UMLElementTypes.Interaction_Shape);
		case LifelineEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/5.0.0/UML?Lifeline", //$NON-NLS-1$
					UMLElementTypes.Lifeline_Shape);
		case InteractionUseEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/5.0.0/UML?InteractionUse", //$NON-NLS-1$
					UMLElementTypes.InteractionUse_Shape);
		case BehaviorExecutionSpecificationEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/5.0.0/UML?BehaviorExecutionSpecification", //$NON-NLS-1$
					UMLElementTypes.BehaviorExecutionSpecification_Shape);
		case CombinedFragmentEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/5.0.0/UML?CombinedFragment", //$NON-NLS-1$
					UMLElementTypes.CombinedFragment_Shape);
		case InteractionOperandEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/5.0.0/UML?InteractionOperand", //$NON-NLS-1$
					UMLElementTypes.InteractionOperand_Shape);
		case ActionExecutionSpecificationEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/5.0.0/UML?ActionExecutionSpecification", //$NON-NLS-1$
					UMLElementTypes.ActionExecutionSpecification_Shape);
		case ConsiderIgnoreFragmentEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/5.0.0/UML?ConsiderIgnoreFragment", //$NON-NLS-1$
					UMLElementTypes.ConsiderIgnoreFragment_Shape);
		case ConstraintEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/5.0.0/UML?Constraint", //$NON-NLS-1$
					UMLElementTypes.Constraint_Shape);
		case CommentEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/5.0.0/UML?Comment", //$NON-NLS-1$
					UMLElementTypes.Comment_Shape);
		case ContinuationEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/5.0.0/UML?Continuation", //$NON-NLS-1$
					UMLElementTypes.Continuation_Shape);
		case StateInvariantEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/5.0.0/UML?StateInvariant", //$NON-NLS-1$
					UMLElementTypes.StateInvariant_Shape);
		case CombinedFragment2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/5.0.0/UML?CombinedFragment", //$NON-NLS-1$
					UMLElementTypes.CombinedFragment_CoRegionShape);
		case TimeConstraintEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/5.0.0/UML?TimeConstraint", //$NON-NLS-1$
					UMLElementTypes.TimeConstraint_Shape);
		case TimeObservationEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/5.0.0/UML?TimeObservation", //$NON-NLS-1$
					UMLElementTypes.TimeObservation_Shape);
		case DurationConstraintEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/5.0.0/UML?DurationConstraint", //$NON-NLS-1$
					UMLElementTypes.DurationConstraint_Shape);
		case DestructionOccurrenceSpecificationEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/5.0.0/UML?DestructionOccurrenceSpecification", //$NON-NLS-1$
					UMLElementTypes.DestructionOccurrenceSpecification_Shape);
		case DurationConstraintInMessageEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/5.0.0/UML?DurationConstraint", //$NON-NLS-1$
					UMLElementTypes.DurationConstraint_Shape_CN);
		case DurationObservationEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/5.0.0/UML?DurationObservation", //$NON-NLS-1$
					UMLElementTypes.DurationObservation_Shape);
		case MessageSyncEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/5.0.0/UML?Message", //$NON-NLS-1$
					UMLElementTypes.Message_SynchEdge);
		case MessageAsyncEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/5.0.0/UML?Message", //$NON-NLS-1$
					UMLElementTypes.Message_AsynchEdge);
		case MessageReplyEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/5.0.0/UML?Message", //$NON-NLS-1$
					UMLElementTypes.Message_ReplyEdge);
		case MessageCreateEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/5.0.0/UML?Message", //$NON-NLS-1$
					UMLElementTypes.Message_CreateEdge);
		case MessageDeleteEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/5.0.0/UML?Message", //$NON-NLS-1$
					UMLElementTypes.Message_DeleteEdge);
		case MessageLostEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/5.0.0/UML?Message", //$NON-NLS-1$
					UMLElementTypes.Message_LostEdge);
		case MessageFoundEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/5.0.0/UML?Message", //$NON-NLS-1$
					UMLElementTypes.Message_FoundEdge);
		case CommentAnnotatedElementEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/5.0.0/UML?Comment?annotatedElement", //$NON-NLS-1$
					UMLElementTypes.Comment_AnnotatedElementEdge);
		case ConstraintConstrainedElementEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/5.0.0/UML?Constraint?constrainedElement", //$NON-NLS-1$
					UMLElementTypes.Constraint_ConstrainedElementEdge);
		case GeneralOrderingEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/5.0.0/UML?GeneralOrdering", //$NON-NLS-1$
					UMLElementTypes.GeneralOrdering_Edge);
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = UMLDiagramEditorPlugin.getInstance().getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null && UMLElementTypes.isKnownElementType(elementType)) {
			image = UMLElementTypes.getImage(elementType);
			imageRegistry.put(key, image);
		}

		if (image == null) {
			image = imageRegistry.get("Navigator?ImageNotFound"); //$NON-NLS-1$
			imageRegistry.put(key, image);
		}
		return image;
	}

	/**
	 * @generated
	 */
	@Override
	public String getText(Object element) {
		if (element instanceof UMLNavigatorGroup) {
			UMLNavigatorGroup group = (UMLNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof UMLNavigatorItem) {
			UMLNavigatorItem navigatorItem = (UMLNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return null;
			}
			return getText(navigatorItem.getView());
		}

		return super.getText(element);
	}

	/**
	 * @generated
	 */
	public String getText(View view) {
		if (view.getElement() != null && view.getElement().eIsProxy()) {
			return getUnresolvedDomainElementProxyText(view);
		}
		switch (UMLVisualIDRegistry.getVisualID(view)) {
		case PackageEditPart.VISUAL_ID:
			return getPackage_SequenceDiagramText(view);
		case InteractionEditPart.VISUAL_ID:
			return getInteraction_ShapeText(view);
		case LifelineEditPart.VISUAL_ID:
			return getLifeline_ShapeText(view);
		case InteractionUseEditPart.VISUAL_ID:
			return getInteractionUse_ShapeText(view);
		case BehaviorExecutionSpecificationEditPart.VISUAL_ID:
			return getBehaviorExecutionSpecification_ShapeText(view);
		case CombinedFragmentEditPart.VISUAL_ID:
			return getCombinedFragment_ShapeText(view);
		case InteractionOperandEditPart.VISUAL_ID:
			return getInteractionOperand_ShapeText(view);
		case ActionExecutionSpecificationEditPart.VISUAL_ID:
			return getActionExecutionSpecification_ShapeText(view);
		case ConsiderIgnoreFragmentEditPart.VISUAL_ID:
			return getConsiderIgnoreFragment_ShapeText(view);
		case ConstraintEditPart.VISUAL_ID:
			return getConstraint_ShapeText(view);
		case CommentEditPart.VISUAL_ID:
			return getComment_ShapeText(view);
		case ContinuationEditPart.VISUAL_ID:
			return getContinuation_ShapeText(view);
		case StateInvariantEditPart.VISUAL_ID:
			return getStateInvariant_ShapeText(view);
		case CombinedFragment2EditPart.VISUAL_ID:
			return getCombinedFragment_CoRegionShapeText(view);
		case TimeConstraintEditPart.VISUAL_ID:
			return getTimeConstraint_ShapeText(view);
		case TimeObservationEditPart.VISUAL_ID:
			return getTimeObservation_ShapeText(view);
		case DurationConstraintEditPart.VISUAL_ID:
			return getDurationConstraint_ShapeText(view);
		case DestructionOccurrenceSpecificationEditPart.VISUAL_ID:
			return getDestructionOccurrenceSpecification_ShapeText(view);
		case DurationConstraintInMessageEditPart.VISUAL_ID:
			return getDurationConstraint_Shape_CNText(view);
		case DurationObservationEditPart.VISUAL_ID:
			return getDurationObservation_ShapeText(view);
		case MessageSyncEditPart.VISUAL_ID:
			return getMessage_SynchEdgeText(view);
		case MessageAsyncEditPart.VISUAL_ID:
			return getMessage_AsynchEdgeText(view);
		case MessageReplyEditPart.VISUAL_ID:
			return getMessage_ReplyEdgeText(view);
		case MessageCreateEditPart.VISUAL_ID:
			return getMessage_CreateEdgeText(view);
		case MessageDeleteEditPart.VISUAL_ID:
			return getMessage_DeleteEdgeText(view);
		case MessageLostEditPart.VISUAL_ID:
			return getMessage_LostEdgeText(view);
		case MessageFoundEditPart.VISUAL_ID:
			return getMessage_FoundEdgeText(view);
		case CommentAnnotatedElementEditPart.VISUAL_ID:
			return getComment_AnnotatedElementEdgeText(view);
		case ConstraintConstrainedElementEditPart.VISUAL_ID:
			return getConstraint_ConstrainedElementEdgeText(view);
		case GeneralOrderingEditPart.VISUAL_ID:
			return getGeneralOrdering_EdgeText(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getPackage_SequenceDiagramText(View view) {
		Package domainModelElement = (Package) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.getName());
		} else {
			UMLDiagramEditorPlugin.getInstance()
					.logError("No domain element for view with visualID = Package_SequenceDiagram"); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getInteraction_ShapeText(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Interaction_Shape,
				view.getElement() != null ? view.getElement() : view,
				UMLVisualIDRegistry.getType(InteractionNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label Interaction_NameLabel"); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getLifeline_ShapeText(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Lifeline_Shape,
				view.getElement() != null ? view.getElement() : view,
				UMLVisualIDRegistry.getType(LifelineNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label Lifeline_NameLabel"); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getInteractionUse_ShapeText(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.InteractionUse_Shape,
				view.getElement() != null ? view.getElement() : view,
				UMLVisualIDRegistry.getType(InteractionUseNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label InteractionUse_NameLabel"); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getBehaviorExecutionSpecification_ShapeText(View view) {
		BehaviorExecutionSpecification domainModelElement = (BehaviorExecutionSpecification) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.getName());
		} else {
			UMLDiagramEditorPlugin.getInstance()
					.logError("No domain element for view with visualID = BehaviorExecutionSpecification_Shape"); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getCombinedFragment_ShapeText(View view) {
		CombinedFragment domainModelElement = (CombinedFragment) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.getName());
		} else {
			UMLDiagramEditorPlugin.getInstance()
					.logError("No domain element for view with visualID = CombinedFragment_Shape"); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getInteractionOperand_ShapeText(View view) {
		InteractionOperand domainModelElement = (InteractionOperand) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.getName());
		} else {
			UMLDiagramEditorPlugin.getInstance()
					.logError("No domain element for view with visualID = InteractionOperand_Shape"); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getActionExecutionSpecification_ShapeText(View view) {
		ActionExecutionSpecification domainModelElement = (ActionExecutionSpecification) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.getName());
		} else {
			UMLDiagramEditorPlugin.getInstance()
					.logError("No domain element for view with visualID = ActionExecutionSpecification_Shape"); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getConsiderIgnoreFragment_ShapeText(View view) {
		ConsiderIgnoreFragment domainModelElement = (ConsiderIgnoreFragment) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.getName());
		} else {
			UMLDiagramEditorPlugin.getInstance()
					.logError("No domain element for view with visualID = ConsiderIgnoreFragment_Shape"); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getConstraint_ShapeText(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Constraint_Shape,
				view.getElement() != null ? view.getElement() : view,
				UMLVisualIDRegistry.getType(ConstraintNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label Constraint_NameLabel"); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getComment_ShapeText(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Comment_Shape,
				view.getElement() != null ? view.getElement() : view,
				UMLVisualIDRegistry.getType(CommentBodyEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label Comment_BodyLabel"); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getContinuation_ShapeText(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Continuation_Shape,
				view.getElement() != null ? view.getElement() : view,
				UMLVisualIDRegistry.getType(ContinuationNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label Continuation_NameLabel"); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getStateInvariant_ShapeText(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.StateInvariant_Shape,
				view.getElement() != null ? view.getElement() : view,
				UMLVisualIDRegistry.getType(StateInvariantNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label StateInvariant_NameLabel"); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getCombinedFragment_CoRegionShapeText(View view) {
		CombinedFragment domainModelElement = (CombinedFragment) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.getName());
		} else {
			UMLDiagramEditorPlugin.getInstance()
					.logError("No domain element for view with visualID = CombinedFragment_CoRegionShape"); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getTimeConstraint_ShapeText(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.TimeConstraint_Shape,
				view.getElement() != null ? view.getElement() : view,
				UMLVisualIDRegistry.getType(TimeConstraintLabelEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label TimeConstraint_ConstraintLabel"); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getTimeObservation_ShapeText(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.TimeObservation_Shape,
				view.getElement() != null ? view.getElement() : view,
				UMLVisualIDRegistry.getType(TimeObservationLabelEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label TimeObservation_NameLabel"); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getDurationConstraint_ShapeText(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.DurationConstraint_Shape,
				view.getElement() != null ? view.getElement() : view,
				UMLVisualIDRegistry.getType(DurationConstraintLabelEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label DurationConstraint_BodyLabel"); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getDestructionOccurrenceSpecification_ShapeText(View view) {
		DestructionOccurrenceSpecification domainModelElement = (DestructionOccurrenceSpecification) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.getName());
		} else {
			UMLDiagramEditorPlugin.getInstance()
					.logError("No domain element for view with visualID = DestructionOccurrenceSpecification_Shape"); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getDurationConstraint_Shape_CNText(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.DurationConstraint_Shape_CN,
				view.getElement() != null ? view.getElement() : view,
				UMLVisualIDRegistry.getType(DurationConstraintInMessageLabelEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label DurationConstraint_BodyLabel_CN"); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getDurationObservation_ShapeText(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.DurationObservation_Shape,
				view.getElement() != null ? view.getElement() : view,
				UMLVisualIDRegistry.getType(DurationObservationLabelEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label DurationObservation_NameLabel"); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getMessage_SynchEdgeText(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Message_SynchEdge,
				view.getElement() != null ? view.getElement() : view,
				UMLVisualIDRegistry.getType(MessageSyncNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label Message_SynchNameLabel"); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getMessage_AsynchEdgeText(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Message_AsynchEdge,
				view.getElement() != null ? view.getElement() : view,
				UMLVisualIDRegistry.getType(MessageAsyncNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label Message_AsynchNameLabel"); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getMessage_ReplyEdgeText(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Message_ReplyEdge,
				view.getElement() != null ? view.getElement() : view,
				UMLVisualIDRegistry.getType(MessageReplyNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label Message_ReplyNameLabel"); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getMessage_CreateEdgeText(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Message_CreateEdge,
				view.getElement() != null ? view.getElement() : view,
				UMLVisualIDRegistry.getType(MessageCreateNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label Message_CreateNameLabel"); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getMessage_DeleteEdgeText(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Message_DeleteEdge,
				view.getElement() != null ? view.getElement() : view,
				UMLVisualIDRegistry.getType(MessageDeleteNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label Message_DeleteNameLabel"); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getMessage_LostEdgeText(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Message_LostEdge,
				view.getElement() != null ? view.getElement() : view,
				UMLVisualIDRegistry.getType(MessageLostNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label Message_LostNameLabel"); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getMessage_FoundEdgeText(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.Message_FoundEdge,
				view.getElement() != null ? view.getElement() : view,
				UMLVisualIDRegistry.getType(MessageFoundNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label Message_FoundNameLabel"); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getComment_AnnotatedElementEdgeText(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getConstraint_ConstrainedElementEdgeText(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getGeneralOrdering_EdgeText(View view) {
		IParser parser = UMLParserProvider.getParser(UMLElementTypes.GeneralOrdering_Edge,
				view.getElement() != null ? view.getElement() : view,
				UMLVisualIDRegistry.getType(GeneralOrderingAppliedStereotypeEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label GeneralOrdering_StereotypeLabel"); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getUnknownElementText(View view) {
		return "<UnknownElement Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	private String getUnresolvedDomainElementProxyText(View view) {
		return "<Unresolved domain element Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	@Override
	public void init(ICommonContentExtensionSite aConfig) {
	}

	/**
	 * @generated
	 */
	@Override
	public void restoreState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	@Override
	public void saveState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	@Override
	public String getDescription(Object anElement) {
		return null;
	}

	/**
	 * @generated
	 */
	private boolean isOwnView(View view) {
		return PackageEditPart.MODEL_ID.equals(UMLVisualIDRegistry.getModelID(view));
	}
}
