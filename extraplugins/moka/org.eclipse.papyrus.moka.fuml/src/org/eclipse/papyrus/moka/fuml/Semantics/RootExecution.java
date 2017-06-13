/*****************************************************************************
 * Copyright (c) 2017 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.moka.fuml.Semantics;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.Value;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.Execution;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.ParameterValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.Locus;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;

public class RootExecution extends Execution{

	// The model element executed in the context of the
	// root execution.
	protected Class classifier;
	
	public RootExecution(){
	}
	
	public RootExecution(Class classifier, List<ParameterValue> inputParameterValues, Locus locus){
		this.classifier = classifier;
		this.setInputParameterValues(inputParameterValues);
		this.locus = locus;
	}
	
	public void setInputParameterValues(List<ParameterValue> inputParameterValues){
		// Set input parameter values of the root execution
		for(ParameterValue inputParameterValue : inputParameterValues){
			this.setParameterValue(inputParameterValue);
		}
	}
	
	@Override
	public void execute() {
		// If the model element is a behavior then it gets executed through the locus executor.
		// Outputs of this execution are made available through the parameter values of the
		// root execution.
		// [TODO: handle the case were the model element is an active class]
		if(this.classifier instanceof Behavior){
			List<ParameterValue> outputParameterValues = this.locus.executor.execute((Behavior)this.classifier, null, this.parameterValues);
			for(ParameterValue parameterValue : outputParameterValues){
				this.setParameterValue(parameterValue);
			}
		}
	}

	@Override
	public Value new_() {
		return new RootExecution();
	}
	
	@Override
	public List<Classifier> getTypes() {
		List<Classifier> types = new ArrayList<Classifier>();
		types.add(this.classifier);
		return types;
	}
	
	
	@Override
	public String toString() {
		return "RootExecution()";
	}
}
