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
package org.eclipse.papyrus.bpmn.test;

import static org.junit.Assert.assertEquals;

import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage;
import org.eclipse.papyrus.bpmn.BPMNProfile.FlowNode;
import org.eclipse.papyrus.bpmn.BPMNProfile.SequenceFlow;
import org.eclipse.papyrus.bpmn.BPMNProfile.impl.SequenceFlowCustom;
import org.eclipse.papyrus.bpmn.util.BPMNResource;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ControlFlow;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.OpaqueAction;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.util.UMLUtil;
import org.eclipse.uml2.uml.util.UMLUtil.StereotypeApplicationHelper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SequenceFlowCustomTest {

	private SequenceFlow sequenceFlow;
	private OpaqueAction source;
	private OpaqueAction target;
	
	@Before
	public void setUp() {
		Model model = BPMNResource.createBPMNModel();

		Activity activity = UMLFactory.eINSTANCE.createActivity();
		model.getPackagedElements().add(activity);
		StereotypeApplicationHelper.getInstance(null).applyStereotype(activity, BPMNProfilePackage.eINSTANCE.getBPMNProcess());

		ControlFlow controlFlow = UMLFactory.eINSTANCE.createControlFlow();
		controlFlow.setActivity(activity);
		sequenceFlow = (SequenceFlow)StereotypeApplicationHelper.getInstance(null).applyStereotype(controlFlow, BPMNProfilePackage.eINSTANCE.getSequenceFlow());
	
		source = UMLFactory.eINSTANCE.createOpaqueAction();
		activity.getOwnedNodes().add(source);		
		StereotypeApplicationHelper.getInstance(null).applyStereotype(source, BPMNProfilePackage.eINSTANCE.getTask());
	
		target = UMLFactory.eINSTANCE.createOpaqueAction();
		activity.getOwnedNodes().add(target);		
		StereotypeApplicationHelper.getInstance(null).applyStereotype(target, BPMNProfilePackage.eINSTANCE.getTask());

		controlFlow.setSource(source);
		controlFlow.setTarget(target);
	}
	
	@Test
	public void basicGetSourceRefGeneratedTest() {
		try{
			sequenceFlow.getSourceRef();
		}
		catch(UnsupportedOperationException e){
			Assert.fail("missing custom code !");
		}
	}
	
	@Test
	public void basicGetSourceRefCustomTest() {
		FlowNode f = SequenceFlowCustom.basicGetSourceRef(sequenceFlow);
		Assert.assertNotNull(f);
		assertEquals(f, UMLUtil.getStereotypeApplication(source, FlowNode.class));
	}
	
	@Test
	public void basicGetSourceRefTest() {
		FlowNode f = sequenceFlow.getSourceRef();
		Assert.assertNotNull(f);
		assertEquals(f, UMLUtil.getStereotypeApplication(source, FlowNode.class));
	}

	@Test
	public void basicGetTargetRefGeneratedTest() {
		try{
			sequenceFlow.getTargetRef();
		}
		catch(UnsupportedOperationException e){
			Assert.fail("missing custom code !");
		}
	}
	
	@Test
	public void basicGetTargetRefCustomTest() {
		FlowNode f = SequenceFlowCustom.basicGetTargetRef(sequenceFlow);
		Assert.assertNotNull(f);
		assertEquals(f, UMLUtil.getStereotypeApplication(target, FlowNode.class));
	}
	
	@Test
	public void basicGetTargetRefTest() {
		FlowNode f = sequenceFlow.getTargetRef();
		Assert.assertNotNull(f);
		assertEquals(f, UMLUtil.getStereotypeApplication(target, FlowNode.class));
	}
}
