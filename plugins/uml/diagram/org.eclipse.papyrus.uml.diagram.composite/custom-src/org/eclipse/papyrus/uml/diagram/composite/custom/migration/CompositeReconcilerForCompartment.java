/*****************************************************************************
 * Copyright (c) 2009-2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Mickael ADAM (ALL4TEC) mickael.adam@all4tec.net - Initial API and Implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.composite.custom.migration;

import java.util.Arrays;
import java.util.List;

import org.eclipse.papyrus.infra.gmfdiag.common.reconciler.ReconcilerForCompartment;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.ActivityCompositeCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.ActivityCompositeCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.ClassCompositeCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.ClassCompositeCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.CollaborationCompositeCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.CollaborationCompositeCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.ComponentCompositeCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.ComponentCompositeCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.DataTypeAttributeCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.DataTypeAttributeCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.DataTypeOperationCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.DataTypeOperationCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.DeviceCompositeCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.DeviceCompositeCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.EnumerationEnumerationLiteralCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.EnumerationEnumerationLiteralCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.ExecutionEnvironmentCompositeCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.ExecutionEnvironmentCompositeCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.FunctionBehaviorCompositeCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.FunctionBehaviorCompositeCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.InteractionCompositeCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.InteractionCompositeCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.NodeCompositeCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.NodeCompositeCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.OpaqueBehaviorCompositeCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.OpaqueBehaviorCompositeCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.PropertyPartCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.ProtocolStateMachineCompositeCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.ProtocolStateMachineCompositeCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.StateMachineCompositeCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.StateMachineCompositeCompartmentEditPartCN;

/**
 * Diagram Reconciler for compartment from 1.1.0 to 1.2.0
 */
public class CompositeReconcilerForCompartment extends ReconcilerForCompartment {

	/** The compartments visual id. */
	private List<String> compartmentsVisualID = Arrays.asList(
			DataTypeAttributeCompartmentEditPart.VISUAL_ID,
			DataTypeOperationCompartmentEditPart.VISUAL_ID,
			DataTypeAttributeCompartmentEditPartCN.VISUAL_ID,
			DataTypeOperationCompartmentEditPartCN.VISUAL_ID,
			EnumerationEnumerationLiteralCompartmentEditPart.VISUAL_ID,
			EnumerationEnumerationLiteralCompartmentEditPartCN.VISUAL_ID,
			ActivityCompositeCompartmentEditPartCN.VISUAL_ID,
			InteractionCompositeCompartmentEditPartCN.VISUAL_ID,
			ProtocolStateMachineCompositeCompartmentEditPartCN.VISUAL_ID,
			StateMachineCompositeCompartmentEditPartCN.VISUAL_ID,
			FunctionBehaviorCompositeCompartmentEditPartCN.VISUAL_ID,
			OpaqueBehaviorCompositeCompartmentEditPartCN.VISUAL_ID,
			ComponentCompositeCompartmentEditPartCN.VISUAL_ID,
			DeviceCompositeCompartmentEditPartCN.VISUAL_ID,
			ExecutionEnvironmentCompositeCompartmentEditPartCN.VISUAL_ID,
			NodeCompositeCompartmentEditPartCN.VISUAL_ID,
			ClassCompositeCompartmentEditPartCN.VISUAL_ID,
			CollaborationCompositeCompartmentEditPartCN.VISUAL_ID,
			ActivityCompositeCompartmentEditPart.VISUAL_ID,
			InteractionCompositeCompartmentEditPart.VISUAL_ID,
			ProtocolStateMachineCompositeCompartmentEditPart.VISUAL_ID,
			StateMachineCompositeCompartmentEditPart.VISUAL_ID,
			FunctionBehaviorCompositeCompartmentEditPart.VISUAL_ID,
			OpaqueBehaviorCompositeCompartmentEditPart.VISUAL_ID,
			ComponentCompositeCompartmentEditPart.VISUAL_ID,
			DeviceCompositeCompartmentEditPart.VISUAL_ID,
			ExecutionEnvironmentCompositeCompartmentEditPart.VISUAL_ID,
			NodeCompositeCompartmentEditPart.VISUAL_ID,
			ClassCompositeCompartmentEditPart.VISUAL_ID,
			CollaborationCompositeCompartmentEditPart.VISUAL_ID,
			PropertyPartCompartmentEditPartCN.VISUAL_ID);

	/**
	 * Gets the compartments visual id.
	 *
	 * @return the compartments visual id
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.reconciler.ReconcilerForCompartment#getCompartmentsVisualID()
	 */
	@Override
	public List<String> getCompartmentsVisualID() {
		return compartmentsVisualID;
	}

}
