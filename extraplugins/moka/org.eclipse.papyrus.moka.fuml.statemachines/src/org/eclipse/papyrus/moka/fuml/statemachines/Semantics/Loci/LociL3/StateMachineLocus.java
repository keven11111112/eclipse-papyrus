package org.eclipse.papyrus.moka.fuml.statemachines.Semantics.Loci.LociL3;

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.Object_;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.Locus;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.Classes.Kernel.StateMachineObject;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Class;

public class StateMachineLocus extends Locus {
	
	public Object_ instantiate(Class type) {
		// Extends fUML semantics by instantiating a SM_Object
		// in the case where type is not a Behavior.
		// Otherwise behaves like in fUML

		Object_ object = null;

		if (type instanceof Behavior) {
			object = super.instantiate(type);
		} else {
			object = new StateMachineObject();
			object.types.add(type);
			object.createFeatureValues();
			this.add(object);
		}

		return object;
	}

	
}
