/*****************************************************************************
 * Copyright (c) 2017 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA - Initial API and implementation
 *   
 *****************************************************************************/
package org.eclipse.papyrus.bpmn.BPMNProfile.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreEList.UnmodifiableEList;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProcess;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage;
import org.eclipse.papyrus.bpmn.BPMNProfile.BoundaryEvent;
import org.eclipse.papyrus.bpmn.BPMNProfile.FlowElement;
import org.eclipse.papyrus.bpmn.BPMNProfile.LaneSet;
import org.eclipse.papyrus.bpmn.BPMNProfile.Task;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.ActivityPartition;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.LoopNode;
import org.eclipse.uml2.uml.OpaqueAction;
import org.eclipse.uml2.uml.util.UMLUtil;


public class BPMNProcessCustom {

	private static final Logger log = Logger.getLogger(BPMNProcessCustom.class);

	private BPMNProcessCustom() {
	}

	private static List<FlowElement> getProcessFlowElements(Activity activity) {
		List<FlowElement> flowElements = null;
		List<Element> elements;
		if ((elements = activity.getOwnedElements()) != null) {
			flowElements = elements.stream()
					.map(e -> UMLUtil.getStereotypeApplication(e, FlowElement.class))
					.filter(Objects::nonNull)
					.collect(Collectors.toList());
		}
		return flowElements;
	}

	private static List<FlowElement> getFlowElementsInLoop(LoopNode loopNode) {
		List<FlowElement> flowElements = new ArrayList<>();

		// first, recursively manage nested loop
		List<LoopNode> loopNodes = loopNode.getNodes().stream()
				.filter(LoopNode.class::isInstance)
				.map(LoopNode.class::cast)
				.collect(Collectors.toList());

		for (LoopNode node : loopNodes) {
			flowElements.addAll(getFlowElementsInLoop(node));
		}

		// then process with other elements
		flowElements.addAll(loopNode.getNodes().stream()
				.map(e -> UMLUtil.getStereotypeApplication(e, FlowElement.class))
				.filter(Objects::nonNull)
				.collect(Collectors.toList()));

		return flowElements;
	}

	public static EList<FlowElement> getFlowElements(BPMNProcess bpmnProcess) {
		List<FlowElement> flowElements = new ArrayList<>();

		Activity activity = bpmnProcess.getBase_Activity();
		if (activity != null) {
			flowElements.addAll(getProcessFlowElements(activity));

			EList<ActivityNode> nodes = activity.getNodes();

			for (ActivityNode n : nodes) {
				log.debug("bpmnProcess " + bpmnProcess.getId() + " contains " + n.getName());
				if (n instanceof LoopNode) {
					LoopNode loopNode = (LoopNode) n;
					flowElements.addAll(getFlowElementsInLoop(loopNode));
				}
				if (n instanceof OpaqueAction) {
					Task task = UMLUtil.getStereotypeApplication(n, Task.class);
					if (task != null) {
						EList<BoundaryEvent> boundaryEvents = task.getBoundaryEventRefs();
						if (boundaryEvents != null && !boundaryEvents.isEmpty()) {
							flowElements.addAll(boundaryEvents.stream()
									.map(b -> UMLUtil.getStereotypeApplication(b.getBase_Element(), FlowElement.class))
									.filter(Objects::nonNull)
									.collect(Collectors.toList()));
						}

					}
				}
			}
		}

		// Can't return BasicElist, will throw ClassCastException later, so we need this magic stuff
		return new UnmodifiableEList<>((BPMNProcessImpl) bpmnProcess, BPMNProfilePackage.eINSTANCE.getFlowElementsContainer_FlowElements(), flowElements.size(), flowElements.toArray());
	}


	public static EList<LaneSet> getLaneSets(BPMNProcess bpmnProcess) {
		List<LaneSet> laneSet = new ArrayList<>();
		Activity activity = bpmnProcess.getBase_Activity();
		if (activity != null) {
			EList<ActivityPartition> partitions = activity.getPartitions();
			if (partitions != null && !partitions.isEmpty()) {
				partitions.stream().map(b -> UMLUtil.getStereotypeApplication(b, LaneSet.class))
						.filter(Objects::nonNull)
						.collect(Collectors.toList());
			}
		}
		return new UnmodifiableEList<>((BPMNProcessImpl) bpmnProcess, BPMNProfilePackage.eINSTANCE.getFlowElementsContainer_FlowElements(), laneSet.size(), laneSet.toArray());
	}

}
