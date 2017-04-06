/*****************************************************************************
 * Copyright (c) 2016 CEA.
 * <p>
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * <p>
 * Contributors:
 * Géry Deloge (CEATech AQUI) gery.deloge@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.bpmn.BPMNProfile.impl;

import org.eclipse.papyrus.bpmn.BPMNProfile.FlowNode;
import org.eclipse.papyrus.bpmn.BPMNProfile.SequenceFlow;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.ControlFlow;
import org.eclipse.uml2.uml.util.UMLUtil;

public class SequenceFlowCustom {

	private SequenceFlowCustom() {
	}

	public static FlowNode basicGetSourceRef(SequenceFlow sequenceFlow) {
		FlowNode flowNode = null;
		ControlFlow controlFlow;
		ActivityNode node;

		if ((controlFlow = sequenceFlow.getBase_ControlFlow()) != null && (node = controlFlow.getSource()) != null) {
			flowNode = UMLUtil.getStereotypeApplication(node, FlowNode.class);
		}
		return flowNode;
	}

	public static FlowNode basicGetTargetRef(SequenceFlow sequenceFlow) {
		FlowNode flowNode = null;
		ControlFlow controlFlow;
		ActivityNode node;

		if ((controlFlow = sequenceFlow.getBase_ControlFlow()) != null && (node = controlFlow.getTarget()) != null) {
			flowNode = UMLUtil.getStereotypeApplication(node, FlowNode.class);
		}
		return flowNode;
	}
}
