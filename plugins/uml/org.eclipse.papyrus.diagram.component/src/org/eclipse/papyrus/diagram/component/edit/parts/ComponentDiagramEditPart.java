package org.eclipse.papyrus.diagram.component.edit.parts;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.handles.MoveHandle;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.NonResizableLabelEditPolicy;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.editpolicies.DuplicatePasteEditPolicy;
import org.eclipse.papyrus.diagram.common.providers.ViewInfo;
import org.eclipse.papyrus.diagram.common.util.MDTUtil;
import org.eclipse.papyrus.diagram.component.custom.edit.policies.CustomDiagramDragDropEditPolicy;
import org.eclipse.papyrus.diagram.component.custom.edit.policies.RemoveOrphanViewPolicy;
import org.eclipse.papyrus.diagram.component.edit.policies.ComponentDiagramItemSemanticEditPolicy;
import org.eclipse.papyrus.diagram.component.part.UMLVisualIDRegistry;

/**
 * @generated
 */
public class ComponentDiagramEditPart extends DiagramEditPart {

	/**
	 * @generated
	 */
	public final static String MODEL_ID = "PapyrusUMLComponentDiagram"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 1000;

	/**
	 * @generated
	 */
	public ComponentDiagramEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(DuplicatePasteEditPolicy.PASTE_ROLE, new DuplicatePasteEditPolicy());
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new ComponentDiagramItemSemanticEditPolicy());
		//in Papyrus diagrams are not strongly synchronised
		//installEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CANONICAL_ROLE, new org.eclipse.papyrus.diagram.component.edit.policies.ModelCanonicalEditPolicy());
		installEditPolicy("REMOVE_ORPHAN_VIEW", new RemoveOrphanViewPolicy()); //$NON-NLS-1$
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new CustomDiagramDragDropEditPolicy());
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.POPUPBAR_ROLE);
	}

	/**
	 * @generated
	 */
	/* package-local */static class NodeLabelDragPolicy extends NonResizableEditPolicy {

		/**
		 * @generated
		 */
		@SuppressWarnings("rawtypes")
		protected List createSelectionHandles() {
			MoveHandle h = new MoveHandle((GraphicalEditPart)getHost());
			h.setBorder(null);
			return Collections.singletonList(h);
		}

		/**
		 * @generated
		 */
		public Command getCommand(Request request) {
			return null;
		}

		/**
		 * @generated
		 */
		public boolean understandsRequest(Request request) {
			return false;
		}
	}

	/**
	 * @generated
	 */
	/* package-local */static class LinkLabelDragPolicy extends NonResizableLabelEditPolicy {

		/**
		 * @generated
		 */
		@SuppressWarnings("rawtypes")
		protected List createSelectionHandles() {
			MoveHandle mh = new MoveHandle((GraphicalEditPart)getHost());
			mh.setBorder(null);
			return Collections.singletonList(mh);
		}
	}

	/**
	 * @generated
	 */
	protected void handleNotificationEvent(Notification event) {
		super.handleNotificationEvent(event);
		if(event.getNotifier() instanceof EAnnotation) {
			EAnnotation eAnnotation = (EAnnotation)event.getNotifier();
			if(eAnnotation.getSource() != null && eAnnotation.getSource().equals(MDTUtil.FilterViewAndLabelsSource)) {
				//modification form MOSKitt approach, canonical policies are not called
				MDTUtil.filterDiagramViews(this.getDiagramView());
			}
		}
	}

	/**
	 * @generated
	 */
	public Object getAdapter(Class adapter) {
		if(adapter != null && adapter.equals(ViewInfo.class)) {
			return UMLVisualIDRegistry.getDiagramViewInfo();
		}
		return super.getAdapter(adapter);
	}
}
