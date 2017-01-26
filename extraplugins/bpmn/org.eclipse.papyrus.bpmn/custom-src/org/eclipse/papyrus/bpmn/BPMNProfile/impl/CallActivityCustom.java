package org.eclipse.papyrus.bpmn.BPMNProfile.impl;

import org.eclipse.papyrus.bpmn.BPMNProfile.CallActivity;
import org.eclipse.papyrus.bpmn.BPMNProfile.CallableElement;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.CallBehaviorAction;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * Created by GD249233 on 01/02/2017.
 */
public class CallActivityCustom {
	
	private CallActivityCustom(){
	}
	
	public static CallableElement basicGetCalledElementRef(CallActivity callActivity) {
		CallableElement callableElement = null;
		Element element = callActivity.getBase_Element();
		if(element != null && element instanceof CallBehaviorAction){
			CallBehaviorAction cba = (CallBehaviorAction)element;
			Behavior behavior = cba.getBehavior();
			if(behavior != null){
				callableElement = UMLUtil.getStereotypeApplication(behavior, CallableElement.class);
			}
		}
		
		return callableElement;
	}
}
