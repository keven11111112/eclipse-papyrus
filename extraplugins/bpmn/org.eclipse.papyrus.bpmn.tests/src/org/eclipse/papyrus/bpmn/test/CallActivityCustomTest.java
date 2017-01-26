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

import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProcess;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage;
import org.eclipse.papyrus.bpmn.BPMNProfile.CallActivity;
import org.eclipse.papyrus.bpmn.BPMNProfile.CallableElement;
import org.eclipse.papyrus.bpmn.BPMNProfile.Task;
import org.eclipse.papyrus.bpmn.BPMNProfile.impl.CallActivityCustom;
import org.eclipse.papyrus.bpmn.util.BPMNResource;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.CallBehaviorAction;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.OpaqueAction;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.util.UMLUtil;
import org.eclipse.uml2.uml.util.UMLUtil.StereotypeApplicationHelper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by GD249233 on 01/02/2017.
 */
public class CallActivityCustomTest {

	private BPMNProcess bpmnProcess;
	private BPMNProcess bpmnSubProcess;
	private Task task;
	private CallActivity callActivity;
	private Activity activity2;

	@Before
	public void setUp(){
		Model model = BPMNResource.createBPMNModel();

		Activity activity = UMLFactory.eINSTANCE.createActivity();
		model.getPackagedElements().add(activity);
		StereotypeApplicationHelper.getInstance(null).applyStereotype(activity, BPMNProfilePackage.eINSTANCE.getBPMNProcess());

		OpaqueAction action = UMLFactory.eINSTANCE.createOpaqueAction();
		activity.getOwnedNodes().add(action);
		task = (Task) StereotypeApplicationHelper.getInstance(null).applyStereotype(action, BPMNProfilePackage.eINSTANCE.getTask());

		bpmnProcess = UMLUtil.getStereotypeApplication(activity, BPMNProcess.class);
		
		CallBehaviorAction callBehaviorAction = UMLFactory.eINSTANCE.createCallBehaviorAction();
		activity.getOwnedNodes().add(callBehaviorAction);
		callActivity = (CallActivity) StereotypeApplicationHelper.getInstance(null).applyStereotype(callBehaviorAction, BPMNProfilePackage.eINSTANCE.getCallActivity());
	
		activity2 = UMLFactory.eINSTANCE.createActivity();
		model.getPackagedElements().add(activity2);
		bpmnSubProcess = (BPMNProcess) StereotypeApplicationHelper.getInstance(null).applyStereotype(activity2, BPMNProfilePackage.eINSTANCE.getBPMNProcess());
		
		callBehaviorAction.setBehavior((Behavior)activity2);
	}
	
	/*
	 * test that custom code is present in generated code
	 */
	@Test
	public void basicGetCalledElementRefGeneratedTest(){
		try{
			callActivity.getCalledElementRef();
		}
		catch(UnsupportedOperationException e){
			Assert.fail("missing custom code !");
		}
	}
	
	@Test
	public void basicGetCalledElementRefCustomTest(){
		CallableElement e = CallActivityCustom.basicGetCalledElementRef(callActivity);
		Assert.assertNotNull(e);
		assertEquals(e, bpmnSubProcess);
	}
	
	@Test
	public void basicGetCalledElementRefTest(){
		CallableElement e = callActivity.getCalledElementRef();
		Assert.assertNotNull(e);
		assertEquals(e, bpmnSubProcess);
	}
	
	
}
