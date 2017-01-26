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
package org.eclipse.papyrus.bpmn.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNExpression;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProcess;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage;
import org.eclipse.papyrus.bpmn.BPMNProfile.StandardLoopCharacteristics;
import org.eclipse.papyrus.bpmn.BPMNProfile.Task;
import org.eclipse.papyrus.bpmn.BPMNProfile.impl.StandardLoopCharacteristicsCustom;
import org.eclipse.papyrus.bpmn.util.BPMNResource;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.LoopNode;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.OpaqueAction;
import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.ValueSpecificationAction;
import org.eclipse.uml2.uml.util.UMLUtil;
import org.eclipse.uml2.uml.util.UMLUtil.StereotypeApplicationHelper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by GD249233 on 25/01/2017.
 */
public class StandardLoopCharacteristicsCustomTest {

	private BPMNProcess bpmnProcess;
	private Task task;
	private StandardLoopCharacteristics loop;
	private BPMNExpression bex;

	@Before
	public void setUp(){
		Model model = BPMNResource.createBPMNModel();

		Activity activity = UMLFactory.eINSTANCE.createActivity();
		model.getPackagedElements().add(activity);
		StereotypeApplicationHelper.getInstance(null).applyStereotype(activity, BPMNProfilePackage.eINSTANCE.getBPMNProcess());
		bpmnProcess = UMLUtil.getStereotypeApplication(activity, BPMNProcess.class);
		
		LoopNode loopNode = UMLFactory.eINSTANCE.createLoopNode();
		activity.getOwnedNodes().add(loopNode);
		StereotypeApplicationHelper.getInstance(null).applyStereotype(loopNode, BPMNProfilePackage.eINSTANCE.getStandardLoopCharacteristics());
		loop = UMLUtil.getStereotypeApplication(loopNode, StandardLoopCharacteristics.class);
		
		OpaqueAction action = UMLFactory.eINSTANCE.createOpaqueAction();
		loopNode.getNodes().add(action);
		task = (Task) StereotypeApplicationHelper.getInstance(null).applyStereotype(action, BPMNProfilePackage.eINSTANCE.getTask());
		
		loopNode.setIsTestedFirst(true);
		
		ValueSpecificationAction valueSpecificationAction = UMLFactory.eINSTANCE.createValueSpecificationAction();
		loopNode.getNodes().add(valueSpecificationAction);
		loopNode.getTests().add(valueSpecificationAction);
		bex = (BPMNExpression) StereotypeApplicationHelper.getInstance(null).applyStereotype(valueSpecificationAction, BPMNProfilePackage.eINSTANCE.getBPMNExpression());
		
		OutputPin outputPin = UMLFactory.eINSTANCE.createOutputPin();
		
		valueSpecificationAction.setResult(outputPin);
	}
	
	@Test
	public void isTestBeforeGeneratedTest() {
		try{
			loop.isTestBefore();
		}
		catch(UnsupportedOperationException e){
			Assert.fail("missing custom code !");
		}
	}
	
	@Test
	public void isTestBeforeCustomTest() {
		assertTrue(StandardLoopCharacteristicsCustom.isTestBefore(loop));
	}
	
	@Test
	public void isTestBeforeTest() {
		assertTrue(loop.isTestBefore());

	}
	
	@Test
	public void basicGetLoopConditionGeneratedTest() {
		try{
			loop.getLoopCondition();
		}
		catch(UnsupportedOperationException e){
			Assert.fail("missing custom code !");
		}
	}
	
	@Test
	public void basicGetLoopConditionCustomTest() {
		assertEquals(bex, StandardLoopCharacteristicsCustom.basicGetLoopCondition(loop));
	}
	
	@Test
	public void basicGetLoopConditionTest() {
		assertEquals(bex, loop.getLoopCondition());
	}
	
}
