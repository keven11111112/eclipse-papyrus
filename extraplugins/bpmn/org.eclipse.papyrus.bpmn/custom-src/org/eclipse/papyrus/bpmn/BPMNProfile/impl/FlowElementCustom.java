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

import org.apache.log4j.Logger;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNActivity;
import org.eclipse.papyrus.bpmn.BPMNProfile.BoundaryEvent;
import org.eclipse.papyrus.bpmn.BPMNProfile.FlowElement;
import org.eclipse.papyrus.bpmn.BPMNProfile.FlowElementsContainer;
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Event;
import org.eclipse.uml2.uml.LoopNode;
import org.eclipse.uml2.uml.util.UMLUtil;

public class FlowElementCustom {

	private static final Logger log = Logger.getLogger(FlowElementCustom.class);

	private FlowElementCustom() {
	}

	public static FlowElementsContainer basicGetContainer(FlowElement flowElement) {
		FlowElementsContainer flowElementsContainer = null;
		Element element = flowElement.getBase_Element();
		
		if (element != null) {
			if (element instanceof ActivityNode || element instanceof ActivityEdge) {
				Element container = element.getOwner();
				if (container != null && container instanceof LoopNode) {
					container = container.getOwner();
				}
				if(container != null){
					log.debug("owner : " + element.getOwner());
					flowElementsContainer = UMLUtil.getStereotypeApplication(container, FlowElementsContainer.class);
				}
			} else if (element instanceof Event) {
				BoundaryEvent event = UMLUtil.getStereotypeApplication(element, BoundaryEvent.class);
				if(event != null) {
					log.debug(event);
					BPMNActivity bpmnActivity = BoundaryEventCustom.basicGetAttachedToRef(event);
					Element baseElement;
					Element container;
					if (bpmnActivity != null && (baseElement = bpmnActivity.getBase_Element()) != null && (container = baseElement.getOwner()) != null) {
						flowElementsContainer = UMLUtil.getStereotypeApplication(container, FlowElementsContainer.class);
						if (flowElementsContainer == null) {
							log.error("no flowElementsContainer for " + bpmnActivity);
						}
					}
				}
			}
		}
		if (flowElementsContainer == null) {
			log.info("no container for " + flowElement);
		}
		return flowElementsContainer;
	}

}
