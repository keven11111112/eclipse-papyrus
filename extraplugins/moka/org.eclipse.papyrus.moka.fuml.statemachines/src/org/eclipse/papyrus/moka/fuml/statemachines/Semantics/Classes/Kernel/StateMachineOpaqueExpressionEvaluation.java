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
package org.eclipse.papyrus.moka.fuml.statemachines.Semantics.Classes.Kernel;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.moka.composites.Semantics.Classes.Kernel.CS_OpaqueExpressionEvaluation;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.Object_;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.Value;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.ParameterValue;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.OpaqueExpression;

public class StateMachineOpaqueExpressionEvaluation extends CS_OpaqueExpressionEvaluation {

	public Object_ context = null ;

	@Override
	public List<Value> executeExpressionBehavior() {
		// Behaves like in PSCS,
		// except that it takes into account the context object for the
		// execution of the expression behavior
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
