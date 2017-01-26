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

import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProcess;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage;
import org.eclipse.papyrus.bpmn.BPMNProfile.FlowElement;
import org.eclipse.papyrus.bpmn.BPMNProfile.Task;
import org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProcessCustom;
import org.eclipse.papyrus.bpmn.util.BPMNResource;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.OpaqueAction;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.util.UMLUtil;
import org.eclipse.uml2.uml.util.UMLUtil.StereotypeApplicationHelper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BPMNProcessCustomTest {
	
	private BPMNProcess bpmnProcess;
	private Task task;
	
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
	}
	
	/*
	 * test that custom code is present in generated code
	 */
	@Test
	public void getFlowElementsGeneratedTest(){
		try{
			bpmnProcess.getFlowElements();
		}
		catch(UnsupportedOperationException e){
			Assert.fail("missing custom code !");
		}
	}
	
	/*
	 * test custom code
	 */
	@Test
	public void getFlowElementsCustomTest(){
		EList<FlowElement> flowElements = BPMNProcessCustom.getFlowElements(bpmnProcess);
		Assert.assertNotNull(flowElements);
		assertEquals(task, flowElements.get(0));
	}
	
	/*
	 * test full path
	 */
	@Test
	public void getFlowElementsTest(){
			EList<FlowElement> flowElements = bpmnProcess.getFlowElements();
			Assert.assertNotNull(flowElements);
			assertEquals(task, flowElements.get(0));
	}
	
	@Test
	public void basicGetSupportsGeneratedTest(){
		try{
			bpmnProcess.getSupports();
		}
		catch(UnsupportedOperationException e){
			Assert.fail("missing custom code !");
		}
	}
	
	@Test
	public void basicGetSupportsTest(){
		assertEquals(bpmnProcess, bpmnProcess.getSupports());
	}
}
