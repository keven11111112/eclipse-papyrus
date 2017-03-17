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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreEList.UnmodifiableEList;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage;
import org.eclipse.papyrus.bpmn.BPMNProfile.FlowElement;
import org.eclipse.papyrus.bpmn.BPMNProfile.SubProcess;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.StructuredActivityNode;
import org.eclipse.uml2.uml.util.UMLUtil;

public class SubProcessCustom {

	private SubProcessCustom() {
	}

	
	public static EList<FlowElement> getFlowElements(SubProcess subProcess) {
		List<FlowElement> flowElements = new ArrayList<>();
		StructuredActivityNode baseNode = (StructuredActivityNode) subProcess.getBase_Element();
		EList<ActivityNode> nodes;
		if (baseNode != null && (nodes = baseNode.getNodes()) != null && !nodes.isEmpty()) {
			flowElements = nodes.stream()
					.map(e -> UMLUtil.getStereotypeApplication(e, FlowElement.class))
					.filter(Objects::nonNull)
					.collect(Collectors.toList());
		}
		// Can't return BasicElist, will throw ClassCastException later, so we need this magic stuff
		return new UnmodifiableEList<>((SubProcessImpl) subProcess, BPMNProfilePackage.eINSTANCE.getFlowElementsContainer_FlowElements(), flowElements.size(), flowElements.toArray());
	}
}
