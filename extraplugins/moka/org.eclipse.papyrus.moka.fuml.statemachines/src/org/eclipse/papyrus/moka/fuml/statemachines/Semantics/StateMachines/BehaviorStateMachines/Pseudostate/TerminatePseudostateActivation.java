package org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines.BehaviorStateMachines.Pseudostate;

import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.Execution;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines.BehaviorStateMachines.RegionActivation;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines.BehaviorStateMachines.TransitionActivation;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines.BehaviorStateMachines.VertexActivation;

public class TerminatePseudostateActivation extends PseudostateActivation {

	public void enter(TransitionActivation enteringTransition, RegionActivation leastCommonAncestor) {
		// When a terminate pseudo state is entered the state-machine executing terminates its execution.
		// This termination occurs without exiting "exit" behaviors of state(s) that are currently
		// registered in the state-machine configuration.
		// 
		// Note: the termination of the current state-machine execution leads
		// to the destruction of its context object. This means the object
		// will be stopped and consequently no any other event will be dispatched
		// and the object will finally be removed from the locus.
		if (leastCommonAncestor != null && this.getParent() != leastCommonAncestor) {
			VertexActivation parentVertexActivation = this.getParentState();
			if (parentVertexActivation != null) {
				parentVertexActivation.enter(enteringTransition, leastCommonAncestor);
			}
		}
		super.enter(enteringTransition, leastCommonAncestor);
		Execution stateMachineExecution = this.getStateMachineExecution();
		stateMachineExecution.terminate();
		stateMachineExecution.context.destroy();
		super.exit(enteringTransition, leastCommonAncestor);
	}
}
