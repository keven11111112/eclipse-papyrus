/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.bpmn.test;

import static org.junit.Assert.assertEquals;

import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNActivity;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProcess;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage;
import org.eclipse.papyrus.bpmn.BPMNProfile.BoundaryEvent;
import org.eclipse.papyrus.bpmn.BPMNProfile.Task;
import org.eclipse.papyrus.bpmn.BPMNProfile.impl.BoundaryEventCustom;
import org.eclipse.papyrus.bpmn.util.BPMNResource;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ChangeEvent;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.OpaqueAction;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.util.UMLUtil;
import org.eclipse.uml2.uml.util.UMLUtil.StereotypeApplicationHelper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BoundaryEventCustomTest {

	private OpaqueAction action;
	private BoundaryEvent boundaryEvent;

	@Before	
	public void setUp(){
		Model model = BPMNResource.createBPMNModel();
		
		Activity activity = UMLFactory.eINSTANCE.createActivity();
		model.getPackagedElements().add(activity);
		StereotypeApplicationHelper.getInstance(null).applyStereotype(activity, BPMNProfilePackage.eINSTANCE.getBPMNProcess());
		BPMNProcess bpmnProcess = UMLUtil.getStereotypeApplication(activity, BPMNProcess.class);
		
		action = UMLFactory.eINSTANCE.createOpaqueAction();
		activity.getOwnedNodes().add(action);		
		Task task = (Task) StereotypeApplicationHelper.getInstance(null).applyStereotype(action, BPMNProfilePackage.eINSTANCE.getTask());
		
		ChangeEvent changeEvent = UMLFactory.eINSTANCE.createChangeEvent();
		model.getPackagedElements().add(changeEvent);
		boundaryEvent = (BoundaryEvent) StereotypeApplicationHelper.getInstance(null).applyStereotype(changeEvent, BPMNProfilePackage.eINSTANCE.getBoundaryEvent());
		task.getBoundaryEventRefs().add(boundaryEvent);
		boundaryEvent.setBase_ActivityNode(task.getBase_ActivityNode());
	}
	
	@Test
	public void basicGetAttachedToRefGeneratedTest() {
		try{
			boundaryEvent.getAttachedToRef();
		}
		catch(UnsupportedOperationException e){
			Assert.fail("missing custom code !");
		}
	}
	
	@Test
	public void basicGetAttachedToRefCustomTest() {
		BPMNActivity bmpnActivity = BoundaryEventCustom.basicGetAttachedToRef(boundaryEvent);
		Assert.assertNotNull(bmpnActivity);
		assertEquals(bmpnActivity, UMLUtil.getStereotypeApplication(action, BPMNActivity.class));
	}

	
	@Test
	public void basicGetAttachedToRefTest() {
		BPMNActivity bmpnActivity = boundaryEvent.getAttachedToRef();
		Assert.assertNotNull(bmpnActivity);
		assertEquals(bmpnActivity, UMLUtil.getStereotypeApplication(action, BPMNActivity.class));
	}
}
