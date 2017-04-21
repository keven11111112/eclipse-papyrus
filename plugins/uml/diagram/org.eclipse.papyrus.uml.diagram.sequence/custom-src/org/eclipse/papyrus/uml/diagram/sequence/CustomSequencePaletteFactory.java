/*****************************************************************************
 * Copyright (c) 2010 CEA
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Soyatec - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.Cursors;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.Tool;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IPrimaryEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest.ConnectionViewDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.services.palette.PaletteFactory;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.uml.diagram.common.service.AspectUnspecifiedTypeConnectionTool;
import org.eclipse.papyrus.uml.diagram.common.service.AspectUnspecifiedTypeCreationTool;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionInteractionCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.AnnotatedLinkEndEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.AnnotatedLinkStartEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.HighlightEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceRequestConstant;
import org.eclipse.papyrus.uml.diagram.sequence.util.TooltipHook;
import org.eclipse.swt.widgets.Display;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class CustomSequencePaletteFactory extends PaletteFactory.Adapter {

	private static final String CREATECOMBINEDFRAGMENTTOOL = "createCombinedFragmentTool";

	private static final String CREATECONSIDERIGNOREFRAGMENTTOOL = "createConsiderIgnoreFragmentTool";

	private static final String CREATEDURATIONCONSTRAINTTOOL = "createDurationConstraintTool";

	private static final String CREATEDURATIONOBSERVATIONTOOL = "createDurationObservationTool";

	private static final String CREATETIMEOBSERVATIONTOOL = "createTimeObservationTool";

	private static final String CREATEDESTRUCTIONEVENTTOOL = "createDestructionEventTool";

	private static final String CREATECOMMENTTOOL = "createCommentTool";

	private static final String CREATECONSTRAINTTOOL = "createConstraintTool";

	private static final String CREATEMESSAGESYNCTOOL = "createMessageSyncTool";

	private static final String CREATEMESSAGEASYNCTOOL = "createMessageAsyncTool";

	private static final String CREATEMESSAGEREPLYTOOL = "createMessageReplyTool";

	private static final String CREATEMESSAGECREATETOOL = "createMessageCreateTool";

	private static final String CREATEMESSAGEDELETETOOL = "createMessageDeleteTool";

	private static final String CREATEMESSAGELOSTTOOL = "createMessageLostTool";

	private static final String CREATEMESSAGEFOUNDTOOL = "createMessageFoundTool";

	private static final String CREATEGENERALORDERINGTOOL = "createGeneralOrderingTool";

	private static final String CREATEANNOTATEDLINKTOOL = "createAnnotatedLinkTool";


	public CustomSequencePaletteFactory() {
	}

	@Override
	public Tool createTool(String toolId) {
		if (toolId.equals(CREATECOMBINEDFRAGMENTTOOL)) {
			return createCombinedFragmentCreationTool();
		}
		// add
		if (toolId.equals(CREATECONSIDERIGNOREFRAGMENTTOOL)) {
			return createConsiderIgnoreFragmentCreationTool();
		}
		if (toolId.equals(CREATECOMMENTTOOL)) {
			return createCommentCreationTool();
		}
		if (toolId.equals(CREATECONSTRAINTTOOL)) {
			return createConstraintCreationTool();
		}
		if (toolId.equals(CREATEDURATIONOBSERVATIONTOOL)) {
			return createDurationObservationCreationTool();
		}
		if (toolId.equals(CREATETIMEOBSERVATIONTOOL)) {
			return createTimeObservationCreationTool();
		}
		if (toolId.equals(CREATEDURATIONCONSTRAINTTOOL)) {
			return createDurationConstraintCreationTool();
		}
		if (toolId.equals(CREATEDESTRUCTIONEVENTTOOL)) {
			return createDestructionEventCreationTool();
		}
		if (toolId.equals(CREATEMESSAGESYNCTOOL)) {
			return createMessageSyncCreationTool();
		}
		if (toolId.equals(CREATEMESSAGEASYNCTOOL)) {
			return createMessageAsyncCreationTool();
		}
		if (toolId.equals(CREATEMESSAGEREPLYTOOL)) {
			return createMessageReplyCreationTool();
		}
		if (toolId.equals(CREATEMESSAGECREATETOOL)) {
			return createMessageCreateCreationTool();
		}
		if (toolId.equals(CREATEMESSAGEDELETETOOL)) {
			return createMessageDeleteCreationTool();
		}
		if (toolId.equals(CREATEMESSAGELOSTTOOL)) {
			return createMessageLostCreationTool();
		}
		if (toolId.equals(CREATEMESSAGEFOUNDTOOL)) {
			return createMessageFoundCreationTool();
		}
		if (toolId.equals(CREATEGENERALORDERINGTOOL)) {
			return createGeneralOrderingCreationTool();
		}
		if (toolId.equals(CREATEANNOTATEDLINKTOOL)) {
			return createAnnotatedLinkCreationTool();
		}
		
		// default return: null
		return null;
	}

	

	@Override
	public Object getTemplate(String templateId) {
		// default return: null
		return null;
	}

	private Tool createCombinedFragmentCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		// types.add(UMLElementTypes.ConsiderIgnoreFragment_Shape);
		types.add(UMLElementTypes.CombinedFragment_Shape);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	private Tool createConsiderIgnoreFragmentCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.ConsiderIgnoreFragment_Shape);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	private Tool createCommentCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Comment_Shape);
		// Tool tool = new AspectUnspecifiedTypeCreationTool(types){
		// protected Command getCommand() {
		// if (!antiScroll){
		// if(getTargetEditPart() instanceof LifelineEditPart){
		// InteractionInteractionCompartmentEditPart parent = ((LifelineEditPart) getTargetEditPart()).getParentInteractionCompartmentEditPart();
		// if(parent != null)
		// return parent.getCommand( getTargetRequest() );
		// }
		// return super.getCommand();
		// }
		// return null;
		// }
		// };
		InteractionChildCreationTool tool = new InteractionChildCreationTool(types);
		return tool;
	}

	private Tool createConstraintCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Constraint_Shape);
		// Tool tool = new AspectUnspecifiedTypeCreationTool(types){
		// protected Command getCommand() {
		// if (!antiScroll){
		// if(getTargetEditPart() instanceof LifelineEditPart){
		// InteractionInteractionCompartmentEditPart parent = ((LifelineEditPart) getTargetEditPart()).getParentInteractionCompartmentEditPart();
		// if(parent != null)
		// return parent.getCommand( getTargetRequest() );
		// }
		// return super.getCommand();
		// }
		// return null;
		// }
		// };
		InteractionChildCreationTool tool = new InteractionChildCreationTool(types);
		return tool;
	}

	private Tool createDurationObservationCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.DurationObservation_Shape);
		// use DurationCreationTool
		// Tool tool = new DurationCreationTool(types);
		// AspectUnspecifiedTypeCreationTool tool = new AspectUnspecifiedTypeCreationTool(types);
		InteractionChildCreationTool tool = new InteractionChildCreationTool(types);
		// tool.setDefaultCursor(SharedCursors.HAND);
		// tool.setDisabledCursor(SharedCursors.NO);
		return tool;
	}

	private Tool createTimeObservationCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.TimeObservation_Shape);
		// AspectUnspecifiedTypeCreationTool tool = new AspectUnspecifiedTypeCreationTool(types){
		// protected Command getCommand() {
		// if (!antiScroll){
		// if(getTargetEditPart() instanceof LifelineEditPart){
		// InteractionInteractionCompartmentEditPart parent = ((LifelineEditPart) getTargetEditPart()).getParentInteractionCompartmentEditPart();
		// if(parent != null)
		// return parent.getCommand( getTargetRequest() );
		// }
		// return super.getCommand();
		// }
		// return null;
		// }
		// };
		InteractionChildCreationTool tool = new InteractionChildCreationTool(types);
		// tool.setDefaultCursor(SharedCursors.HAND);
		// tool.setDisabledCursor(SharedCursors.NO);
		return tool;
	}

	private Tool createDurationConstraintCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.DurationConstraint_Shape);
		// types.add(UMLElementTypes.DurationConstraint_Shape_CN);
		// use DurationCreationTool
		// Tool tool = new DurationCreationTool(types);
		// Disable old DurationConstraint creation.
		InteractionChildCreationTool tool = new InteractionChildCreationTool(types);
		return tool;
	}

	private Tool createDestructionEventCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.DestructionOccurrenceSpecification_Shape);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	private Tool createMessageSyncCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Message_SynchEdge);
		Tool tool = new MessageConnectionTool(types);
		return tool;
	}

	private Tool createMessageAsyncCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Message_AsynchEdge);
		Tool tool = new MessageConnectionTool(types);
		return tool;
	}

	private Tool createMessageReplyCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Message_ReplyEdge);
		Tool tool = new MessageConnectionTool(types);
		return tool;
	}

	private Tool createMessageCreateCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Message_CreateEdge);
		Tool tool = new MessageConnectionTool(types);
		return tool;
	}

	private Tool createMessageDeleteCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Message_DeleteEdge);
		Tool tool = new MessageConnectionTool(types);
		return tool;
	}

	private Tool createMessageLostCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Message_LostEdge);
		Tool tool = new MessageConnectionTool(types);
		return tool;
	}

	private Tool createMessageFoundCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Message_FoundEdge);
		Tool tool = new MessageConnectionTool(types);
		return tool;
	}

	private Tool createGeneralOrderingCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.GeneralOrdering_Edge);
		Tool tool = new AspectUnspecifiedTypeConnectionToolEx(types);
		return tool;
	}

	private Tool createAnnotatedLinkCreationTool() {
		AspectUnspecifiedTypeConnectionToolEx tool = new AspectUnspecifiedTypeConnectionToolEx(null) {

			@Override
			protected CreateConnectionRequest createTargetRequest() {
				IHintedType type = (IHintedType) UMLElementTypes.Comment_AnnotatedElementEdge;
				return new CreateConnectionViewRequest(new ConnectionViewDescriptor(type, type.getSemanticHint(), getPreferencesHint()));
			}

			@Override
			protected String getCommandName() {
				if (isInState(STATE_CONNECTION_STARTED | STATE_ACCESSIBLE_DRAG_IN_PROGRESS)) {
					return AnnotatedLinkEndEditPolicy.REQ_ANNOTATED_LINK_END;
				} else {
					return AnnotatedLinkStartEditPolicy.REQ_ANNOTATED_LINK_START;
				}
			}

			@Override
			protected boolean handleCreateConnection() {
				boolean handled = super.handleCreateConnection();
				// Make sure to erase source feedback whatever the connection created or not.
				setAvoidDeactivation(false);
				eraseSourceFeedback();
				deactivate();
				return handled;
			}
		};
		tool.setUnloadWhenFinished(true);
		return tool;
	}

	public static class AspectUnspecifiedTypeConnectionToolEx extends AspectUnspecifiedTypeConnectionTool {

		private EditPart source;

		private TooltipHook tooltipHook = null;

		public AspectUnspecifiedTypeConnectionToolEx(List<IElementType> elementTypes) {
			super(elementTypes);
			setDisabledCursor(Cursors.NO);
		}

		@Override
		public void setViewer(EditPartViewer viewer) {
			super.setViewer(viewer);
			if (tooltipHook == null || !tooltipHook.isHooked(viewer)) {
				if (tooltipHook != null) {
					tooltipHook.dispose();
				}
				tooltipHook = new TooltipHook(viewer);
			}
		}

		@Override
		public void deactivate() {
			super.deactivate();
			if (tooltipHook != null) {
				tooltipHook.dispose();
				tooltipHook = null;
			}
		}

		@Override
		protected void setConnectionSource(EditPart source) {
			this.source = source;
			super.setConnectionSource(source);
		}

		public void clearConnectionFeedback() {
			if (!isShowingSourceFeedback()) {
				return;
			}
			if (source != null) {
				Request req = getSourceRequest();
				req.setType(REQ_CONNECTION_END);
				source.eraseSourceFeedback(req);
			}
		}
	}

	/**
	 * Try to create child in Interaction directly.
	 *
	 * @author Jin Liu (jin.liu@soyatec.com)
	 */
	public static class InteractionChildCreationTool extends AspectUnspecifiedTypeCreationTool {

		/**
		 * Constructor.
		 *
		 * @param elementTypes
		 */
		public InteractionChildCreationTool(List<IElementType> elementTypes) {
			super(elementTypes);
		}

		@Override
		protected boolean updateTargetUnderMouse() {
			if (antiScroll) {
				return super.updateTargetUnderMouse();
			}
			if (!isTargetLocked()) {
				EditPart editPart = null;
				if (getCurrentViewer() != null) {
					editPart = getCurrentViewer().findObjectAtExcluding(getLocation(), getExclusionSet(), getTargetingConditional());
				}
				if (editPart != null) {
					editPart = getInteractionEditPart(editPart);
				}
				boolean changed = getTargetEditPart() != editPart;
				setTargetEditPart(editPart);
				return changed;
			} else {
				return false;
			}
		}

		private EditPart getInteractionEditPart(EditPart editPart) {
			if (editPart == null) {
				return null;
			}
			if (editPart instanceof InteractionInteractionCompartmentEditPart) {
				return editPart;
			}
			return getInteractionEditPart(editPart.getParent());
		}
	}

	public static class MessageConnectionTool extends AspectUnspecifiedTypeConnectionToolEx {

		/**
		 * Constructor.
		 *
		 * @param elementTypes
		 */
		public MessageConnectionTool(List<IElementType> elementTypes) {
			super(elementTypes);
		}
		
		/**
		 * Updates the target editpart and returns <code>true</code> if the target
		 * changes. The target is updated by using the target conditional and the
		 * target request. If the target has been locked, this method does nothing
		 * and returns <code>false</code>.
		 * 
		 * @return <code>true</code> if the target was changed
		 */
		protected boolean updateTargetUnderMouse() {
			if (!isTargetLocked()) {
				EditPart editPart = null;
				if (getCurrentViewer() != null)
					editPart = getCurrentViewer().findObjectAtExcluding(
							getLocation(), getExclusionSet(),
							getTargetingConditional());
				System.out.println(this.getClass().getName()+ " "+editPart);
				if( editPart instanceof InteractionInteractionCompartmentEditPart){
					editPart = getCurrentViewer().findObjectAtExcluding(
							getLocation(), getExclusionSet(),
							getTargetingConditional());
					editPart= editPart.getParent();
				}
				if (editPart != null)
					editPart = editPart.getTargetEditPart(getTargetRequest());
				boolean changed = getTargetEditPart() != editPart;
				setTargetEditPart(editPart);
				return changed;
			} else
				return false;
		}
		/**
		 * Queries the target editpart for a command.
		 * 
		 * @see org.eclipse.gef.tools.AbstractTool#getCommand()
		 */
		protected Command getCommand() {
			if (getTargetEditPart() == null)
				return null;
			return getTargetEditPart().getCommand(getTargetRequest());
		}
		/**
		 * Returns the current x, y position of the mouse cursor.
		 * Sets the Y coordinate to the one of the start location
		 * for messages created with SHIFT being pressed.
		 * 
		 * @return the mouse location
		 */
		@Override
		protected Point getLocation() {
			Point mouseLocation = getCurrentInput().getMouseLocation();
			// Horizontal connection if Shift is pressed
			if (getCurrentInput().isShiftKeyDown()) {
				return new Point(mouseLocation.x, getStartLocation().y);
			} else {
				return mouseLocation;
			}
		}
		
		@Override
		protected void selectAddedObject(EditPartViewer viewer, Collection objects) {
			final List editparts = new ArrayList();
			final EditPart[] primaryEP = new EditPart[1];
			for (Iterator i = objects.iterator(); i.hasNext();) {
				Object object = i.next();
				if (object instanceof IAdaptable) {
					Object editPart = viewer.getEditPartRegistry().get(((IAdaptable) object).getAdapter(View.class));
					if (editPart instanceof IPrimaryEditPart) {
						editparts.add(editPart);
					}
					// Priority is to put a shape into direct edit mode.
					if (editPart instanceof ShapeEditPart) {
						primaryEP[0] = (ShapeEditPart) editPart;
					}
				}
			}
			if (!editparts.isEmpty()) {
				viewer.setSelection(new StructuredSelection(editparts));
				// automatically put the first shape into edit-mode
				Display.getCurrent().asyncExec(new Runnable() {

					@Override
					public void run() {
						if (primaryEP[0] == null) {
							primaryEP[0] = (EditPart) editparts.get(0);
						}
						//
						// add active test since test scripts are failing on this
						// basically, the editpart has been deleted when this
						// code is being executed. (see RATLC00527114)
						if (primaryEP[0].isActive()) {
							Request request = new Request(org.eclipse.gef.RequestConstants.REQ_DIRECT_EDIT);
							// Mark this request as the first direct edit after creation.
							request.getExtendedData().put(SequenceRequestConstant.DIRECT_EDIT_AFTER_CREATION, true);
							primaryEP[0].performRequest(request);
						}
					}
				});
			}
		}

		/**
		 * @see org.eclipse.gmf.runtime.diagram.ui.tools.ConnectionCreationTool#deactivate()
		 *
		 */
		@Override
		public void deactivate() {
			EditPart targetEditPart = getTargetEditPart();
			if (targetEditPart != null) {
				EditPolicy editPolicy = targetEditPart.getEditPolicy(HighlightEditPolicy.HIGHLIGHT_ROLE);
				if (editPolicy != null) {
					editPolicy.eraseSourceFeedback(getTargetRequest());
				}
			}
			super.deactivate();
		}
	}
}
