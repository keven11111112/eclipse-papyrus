/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Jeremie Tatibouet (CEA LIST)
 *  Arnaud Cuccuru (CEA LIST)
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.fuml.statemachines.Semantics.Values;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.moka.composites.Semantics.Classes.Kernel.CS_OpaqueExpressionEvaluation;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.Object_;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.Value;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.ParameterValue;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.OpaqueExpression;

public class SM_OpaqueExpressionEvaluation extends CS_OpaqueExpressionEvaluation {

	// The context is basically the execution context of the state-machine.
	// This provides the possibility for the behavior associated to the evaluated
	// opaque expression to access features available at the context.
	public Object_ context = null ;

	@Override
	public List<Value> executeExpressionBehavior() {
		// An opaque expression can have an associated behavior. If this is the case
		// this behavior is executed. Values produced by the execution of the behavior
		// are the result of the evaluation of the opaque expression 
		List<Value> evaluation = new ArrayList<Value>();
		OpaqueExpression expression = (OpaqueExpression)this.specification;
		Behavior behavior = expression.getBehavior();
		if(behavior != null) {
			List<ParameterValue> inputs = new ArrayList<ParameterValue>();
			List<ParameterValue> results = this.locus.executor.execute(behavior, context, inputs);
			for(int i = 0; i < results.size(); i++) { // results.size should be 1
				ParameterValue parameterValue = results.get(i);
				List<Value> values = parameterValue.values;
				for(int j = 0; j < values.size(); j++) {
					evaluation.add(values.get(j));
				}
			}
		}
		return evaluation;
	}
}
