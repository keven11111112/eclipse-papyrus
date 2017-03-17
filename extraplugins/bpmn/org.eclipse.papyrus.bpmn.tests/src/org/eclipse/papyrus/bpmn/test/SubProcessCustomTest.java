package org.eclipse.papyrus.bpmn.test;

import static org.junit.Assert.assertEquals;

import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProcess;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage;
import org.eclipse.papyrus.bpmn.BPMNProfile.FlowElement;
import org.eclipse.papyrus.bpmn.BPMNProfile.SubProcess;
import org.eclipse.papyrus.bpmn.BPMNProfile.Task;
import org.eclipse.papyrus.bpmn.BPMNProfile.impl.SubProcessCustom;
import org.eclipse.papyrus.bpmn.util.BPMNResource;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.OpaqueAction;
import org.eclipse.uml2.uml.StructuredActivityNode;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.util.UMLUtil;
import org.eclipse.uml2.uml.util.UMLUtil.StereotypeApplicationHelper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SubProcessCustomTest {

	
	private SubProcess subProcess;
	private Task task;
	
	@Before	
	public void setUp(){
		Model model = BPMNResource.createBPMNModel();
		
		Activity activity = UMLFactory.eINSTANCE.createActivity();
		model.getPackagedElements().add(activity);
		StereotypeApplicationHelper.getInstance(null).applyStereotype(activity, BPMNProfilePackage.eINSTANCE.getBPMNProcess());

		StructuredActivityNode node = UMLFactory.eINSTANCE.createStructuredActivityNode();
		activity.getOwnedNodes().add(node);
		StereotypeApplicationHelper.getInstance(null).applyStereotype(node, BPMNProfilePackage.eINSTANCE.getSubProcess());
		
		OpaqueAction action = UMLFactory.eINSTANCE.createOpaqueAction();
		node.getNodes().add(action);		
		task = (Task) StereotypeApplicationHelper.getInstance(null).applyStereotype(action, BPMNProfilePackage.eINSTANCE.getTask());

		UMLUtil.getStereotypeApplication(activity, BPMNProcess.class);
		
		subProcess = UMLUtil.getStereotypeApplication(node, SubProcess.class);
	}
	
	
	/*
	 * test that custom code is present in generated code
	 */
	@Test
	public void getFlowElementsGeneratedTest(){
		try{
			subProcess.getFlowElements();
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
		EList<FlowElement> flowElements = SubProcessCustom.getFlowElements(subProcess);
		Assert.assertNotNull(flowElements);
		assertEquals(task, flowElements.get(0));
	}
	
	/*
	 * test full path
	 */
	@Test
	public void getFlowElementsTest(){
			EList<FlowElement> flowElements = subProcess.getFlowElements();
			Assert.assertNotNull(flowElements);
			assertEquals(task, flowElements.get(0));
	}
	
	/*
	 * test that custom code is present in generated code
	 */
	@Test
	public void getLaneSetTest(){
		try{
			subProcess.getLaneSets();
		}
		catch(UnsupportedOperationException e){
			Assert.fail("missing custom code !");
		}
	}
}
