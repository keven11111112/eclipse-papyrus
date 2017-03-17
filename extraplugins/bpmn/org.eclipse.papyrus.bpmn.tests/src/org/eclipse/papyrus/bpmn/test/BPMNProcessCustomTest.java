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
import org.eclipse.uml2.uml.LoopNode;
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
	
	/*
	 * test that custom code is present in generated code
	 */
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

	/*
	 * test that custom code is present in generated code
	 */
	@Test
	public void getLaneSetsTest(){
		try{
			bpmnProcess.getLaneSets();
		}
		catch(UnsupportedOperationException e){
			Assert.fail("missing custom code !");
		}
	}
	
	/*
	 * test nested loops
	 */
	@Test
	public void getFlowElementsLoopNodeTest(){
		Model model = BPMNResource.createBPMNModel();
				
		Activity activity = UMLFactory.eINSTANCE.createActivity();
		model.getPackagedElements().add(activity);
		StereotypeApplicationHelper.getInstance(null).applyStereotype(activity, BPMNProfilePackage.eINSTANCE.getBPMNProcess());

		LoopNode loopNode = UMLFactory.eINSTANCE.createLoopNode();
		activity.getOwnedNodes().add(loopNode);
		StereotypeApplicationHelper.getInstance(null).applyStereotype(loopNode, BPMNProfilePackage.eINSTANCE.getStandardLoopCharacteristics());
		
		LoopNode loopNode2 = UMLFactory.eINSTANCE.createLoopNode();
		loopNode.getNodes().add(loopNode2);
		StereotypeApplicationHelper.getInstance(null).applyStereotype(loopNode2, BPMNProfilePackage.eINSTANCE.getStandardLoopCharacteristics());
		
		LoopNode loopNode3 = UMLFactory.eINSTANCE.createLoopNode();
		loopNode2.getNodes().add(loopNode3);
		StereotypeApplicationHelper.getInstance(null).applyStereotype(loopNode3, BPMNProfilePackage.eINSTANCE.getStandardLoopCharacteristics());
		
		OpaqueAction action = UMLFactory.eINSTANCE.createOpaqueAction();
		loopNode3.getNodes().add(action);
		Task looptask = (Task) StereotypeApplicationHelper.getInstance(null).applyStereotype(action, BPMNProfilePackage.eINSTANCE.getTask());

		BPMNProcess loopBpmnProcess = UMLUtil.getStereotypeApplication(activity, BPMNProcess.class);
		
		EList<FlowElement> flowElements = loopBpmnProcess.getFlowElements();
		Assert.assertNotNull(flowElements);
		assertEquals(looptask, flowElements.get(0));
	}
}
