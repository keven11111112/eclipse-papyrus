/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
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
package org.eclipse.papyrus.diagram.activity.edit.policies;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.gmf.runtime.common.core.util.StringStatics;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.Ratio;
import org.eclipse.gmf.runtime.notation.Size;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActionInputPinInSendSigActAsTargetEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActionInputPinInSendSigActEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPinInSendSigActAsTargetEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPinInSendSigActEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ValuePinInSendSigActAsTargetEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ValuePinInSendSigActEditPart;
import org.eclipse.papyrus.diagram.activity.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.diagram.activity.part.UMLDiagramUpdater;
import org.eclipse.papyrus.diagram.activity.part.UMLNodeDescriptor;
import org.eclipse.papyrus.diagram.activity.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.activity.providers.UMLElementTypes;
import org.eclipse.uml2.uml.ActionInputPin;
import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.SendSignalAction;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValuePin;

/**
 * @generated
 */
public class SendSignalActionCanonicalEditPolicy extends CanonicalEditPolicy {

	/**
	 * @generated
	 */
	Set myFeaturesToSynchronize;

	/**
	 * @generated
	 */
	@SuppressWarnings("rawtypes")
	protected List getSemanticChildrenList() {
		View viewObject = (View)getHost().getModel();
		List result = new LinkedList();
		for(Iterator it = UMLDiagramUpdater.getSendSignalAction_3052SemanticChildren(viewObject).iterator(); it.hasNext();) {
			result.add(((UMLNodeDescriptor)it.next()).getModelElement());
		}
		return result;
	}

	/**
	 * @generated
	 */
	protected boolean isOrphaned(Collection semanticChildren, final View view) {
		int visualID = UMLVisualIDRegistry.getVisualID(view);
		switch(visualID) {
		case ActionInputPinInSendSigActEditPart.VISUAL_ID:
		case ValuePinInSendSigActEditPart.VISUAL_ID:
		case InputPinInSendSigActEditPart.VISUAL_ID:
		case ValuePinInSendSigActAsTargetEditPart.VISUAL_ID:
		case ActionInputPinInSendSigActAsTargetEditPart.VISUAL_ID:
		case InputPinInSendSigActAsTargetEditPart.VISUAL_ID:
			if(!semanticChildren.contains(view.getElement())) {
				return true;
			}
			EObject domainModelElement = view.getElement();
			if(visualID != UMLVisualIDRegistry.getNodeVisualID((View)getHost().getModel(), domainModelElement)) {
				List createdViews = createViews(Collections.singletonList(domainModelElement));
				assert createdViews.size() == 1;
				final View createdView = (View)((IAdaptable)createdViews.get(0)).getAdapter(View.class);
				if(createdView != null) {
					try {
						new AbstractEMFOperation(host().getEditingDomain(), StringStatics.BLANK, Collections.singletonMap(Transaction.OPTION_UNPROTECTED, Boolean.TRUE)) {

							protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
								populateViewProperties(view, createdView);
								return Status.OK_STATUS;
							}
						}.execute(new NullProgressMonitor(), null);
					} catch (ExecutionException e) {
						UMLDiagramEditorPlugin.getInstance().logError("Error while copyign view information to newly created view", e); //$NON-NLS-1$
					}
				}
				deleteViews(Collections.singletonList(view).iterator());
			}
		}
		return false;
	}

	/**
	 * @generated
	 */
	private void populateViewProperties(View oldView, View newView) {
		if(oldView instanceof Node && newView instanceof Node) {
			Node oldNode = (Node)oldView;
			Node newNode = (Node)newView;
			if(oldNode.getLayoutConstraint() instanceof Location && newNode.getLayoutConstraint() instanceof Location) {
				((Location)newNode.getLayoutConstraint()).setX(((Location)oldNode.getLayoutConstraint()).getX());
				((Location)newNode.getLayoutConstraint()).setY(((Location)oldNode.getLayoutConstraint()).getY());
			}
			if(oldNode.getLayoutConstraint() instanceof Size && newNode.getLayoutConstraint() instanceof Size) {
				((Size)newNode.getLayoutConstraint()).setWidth(((Size)oldNode.getLayoutConstraint()).getWidth());
				((Size)newNode.getLayoutConstraint()).setHeight(((Size)oldNode.getLayoutConstraint()).getHeight());
			}
			if(oldNode.getLayoutConstraint() instanceof Ratio && newNode.getLayoutConstraint() instanceof Ratio) {
				((Ratio)newNode.getLayoutConstraint()).setValue(((Ratio)oldNode.getLayoutConstraint()).getValue());
			}
			newNode.persist();
		}
	}

	/**
	 * @generated
	 */
	protected String getDefaultFactoryHint() {
		return null;
	}

	/**
	 * @generated
	 */
	protected Set getFeaturesToSynchronize() {
		if(myFeaturesToSynchronize == null) {
			myFeaturesToSynchronize = new HashSet();
			myFeaturesToSynchronize.add(UMLPackage.eINSTANCE.getInvocationAction_Argument());
			myFeaturesToSynchronize.add(UMLPackage.eINSTANCE.getSendSignalAction_Target());
		}
		return myFeaturesToSynchronize;
	}

	/**
	 * Return the appropriate factory hint for the children pins.
	 * 
	 * @see #getFactoryHint(IAdaptable, String)
	 * @param elementAdapter
	 *        adapter that adapts to {@link EObject}.
	 * @return factory hint.
	 * @generated NOT
	 */
	protected String getFactoryHint(IAdaptable elementAdapter) {
		InputPin targetPin = ((SendSignalAction)getSemanticHost()).getTarget();

		Object element = elementAdapter.getAdapter(EObject.class);
		if(element instanceof ValuePin) {
			if(element.equals(targetPin)) {
				return ((IHintedType)UMLElementTypes.ValuePin_3060).getSemanticHint();
			}
			return ((IHintedType)UMLElementTypes.ValuePin_3054).getSemanticHint();
		} else if(element instanceof ActionInputPin) {
			if(element.equals(targetPin)) {
				return ((IHintedType)UMLElementTypes.ActionInputPin_3061).getSemanticHint();
			}
			return ((IHintedType)UMLElementTypes.ActionInputPin_3053).getSemanticHint();
		} else if(element instanceof InputPin) {
			if(element.equals(targetPin)) {
				return ((IHintedType)UMLElementTypes.InputPin_3062).getSemanticHint();
			}
			return ((IHintedType)UMLElementTypes.InputPin_3055).getSemanticHint();
		}
		return null;
	}

}
