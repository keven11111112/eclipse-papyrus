package org.eclipse.papyrus.moka.fuml.statemachines.Semantics.Classes.Kernel;

import java.util.List;

import org.eclipse.papyrus.moka.composites.Semantics.CompositeStructures.StructuredClasses.CS_Object;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.ParameterValue;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines.BehaviorStateMachines.Communications.StateMachineObjectActivation;
import org.eclipse.uml2.uml.Class;

public class SM_Object extends CS_Object {
	
	public void startBehavior(Class classifier, List<ParameterValue> inputs) {
		// The behavior captured here is almost identical to the one provide by Object_.
		// Instead of using a simple ObjectActivation we use a StateMachineObjectActivation.
		// This specialized kind of ObjectActivation allows the registering of completion events.
		if (this.objectActivation == null) {
			this.objectActivation = new StateMachineObjectActivation();
			this.objectActivation.object = this;
		}
		this.objectActivation.startBehavior(classifier, inputs);
	}
}
