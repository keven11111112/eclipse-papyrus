/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   Jeremie Tatibouet (CEA) - Apply Fix fUML12-35 Initial execution of an activity is not run to completion
 *   
 *****************************************************************************/

package org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.Execution;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.ParameterValue;
import org.eclipse.uml2.uml.Trigger;

/**
 * An invocation event occurrence represents a signal occurrence of the event of the asynchronous
 * invocation of a specific behavior execution.
 */
public class InvocationEventOccurrence extends EventOccurrence{
	
	/*
	 * The execution being asynchronously invoked.
	 */
	public Execution execution;

	@Override
	public boolean match(Trigger trigger) {
		// An invocation event occurrence does not match any triggers.
		return false;
	}

	@Override
	public List<ParameterValue> getParameterValues() {
		// An invocation event occurrence does not have any associated data.
		return new ArrayList<ParameterValue>();
	}
	
}
