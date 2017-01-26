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

import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNActivity;
import org.eclipse.papyrus.bpmn.BPMNProfile.BoundaryEvent;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.util.UMLUtil;

import java.util.List;

public class BoundaryEventCustom {

	private BoundaryEventCustom() {
	}

	
	private static BPMNActivity getBoundedActivity(org.eclipse.uml2.uml.Package pack, BoundaryEvent boundaryEvent){
		
		BPMNActivity bpmnActivity = null;
		
		EList<PackageableElement> packagedElements = pack.getPackagedElements();
		if (packagedElements != null) {
			for (PackageableElement e : packagedElements) {
				if (e instanceof Activity) {
					Activity activity = (Activity) e;
					List<ActivityNode> activityNodesList = activity.getNodes();
					for (ActivityNode node : activityNodesList) {
						BPMNActivity act = UMLUtil.getStereotypeApplication(node, BPMNActivity.class);
						if (act != null && !act.getBoundaryEventRefs().isEmpty()) {
							for (BoundaryEvent be : act.getBoundaryEventRefs()) {
								if (be == boundaryEvent) {
									bpmnActivity = act;
									break;
								}
							}
						}
					}
				}
			}
		}
		return bpmnActivity;
	}
	
	public static BPMNActivity basicGetAttachedToRef(BoundaryEvent boundaryEvent) {

		BPMNActivity bpmnActivity = null;
		
		if (boundaryEvent.getBase_ActivityNode() != null) {
			bpmnActivity = UMLUtil.getStereotypeApplication(boundaryEvent.getBase_ActivityNode(), BPMNActivity.class);
		}
		if (bpmnActivity == null) {
			// try to parse model
			// dum parsing
			Element baseElement;

			if((baseElement = boundaryEvent.getBase_Element()) != null){
				org.eclipse.uml2.uml.Package pack = baseElement.getNearestPackage();
				org.eclipse.uml2.uml.Package nestingPack = pack;
				while(bpmnActivity == null && nestingPack != null){
					// parse up
					bpmnActivity = getBoundedActivity(nestingPack, boundaryEvent);
					if(bpmnActivity == null){
						nestingPack = nestingPack.getNestingPackage();
					}
				}	
			}
		}
		return bpmnActivity;
	}
}
