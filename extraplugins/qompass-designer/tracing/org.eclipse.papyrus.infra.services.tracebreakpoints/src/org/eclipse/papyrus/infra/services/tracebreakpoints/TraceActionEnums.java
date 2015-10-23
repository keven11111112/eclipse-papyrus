/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Ansgar Radermacher (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.services.tracebreakpoints;

/**
 * Set of enumerations that indicates what we want to trace.
 *
 * @author ansgar
 *
 */
public class TraceActionEnums {

	public enum TraceScope {
		clazz,
		operation,
		state,
		activity,
	};

	/**
	 * Options for tracing a class. Note that some options need additional information, e.g. "all operations"
	 * needs additional information how operations are traced
	 */
	public enum TAClass {
		Creation,
		Destruction,
		AllOperations,
		AllPorts,
		AllStates
		// +(?) all properties/all operations
		// +(all ports?)
		// +all state changes? (hierarchical propagation?)

	};

	/**
	 * Different ways to trace operations: put only the call itself or the values of the parameters into
	 * a trace event.
	 */
	public enum TAOperation {
		OnlyCall,
		ParameterValues, // here exclusive (parameter values and OnlyCall may not be selected at the same time)
	};

	/**
	 * Not used for the moment
	 */
	public enum TAAttribute {
		PropertyRead,
		PropertyWrite; // write old and new value
	};

	/**
	 * Options to trace state
	 */
	public enum TAState {
		StateEnter, // add incoming transition to trace?
		StateLeave, // add outgoing transition to trace?
		Transition // nothing (?) (triggers are known? - no, could be one out of many triggers)
	};

	/**
	 * Not used for the moment
	 */
	public enum TAActivity {
		activity // (i.e. call operation action) explicit choice of (named attribute?)
	};

	public enum TraceFeature {
		Class,
		Port,
		State,
		Operation
	};

	/**
	 * Obtain the definition of a trace option in case of traces on classes
	 *
	 * @param traceAction
	 * @param subFeature
	 *            the trace feature which we want to obtain, i.e. class, state or operation
	 *            from a composite action string in case of class trace points
	 * @return
	 */
	public static String getOptions(String traceAction, TraceFeature subFeature) {
		String prefix = getStringPrefix(subFeature);
		int pos = traceAction.indexOf(prefix);
		if (pos == -1) {
			return null;
		} else {
			// comma is used as separation character.
			pos += prefix.length();
			int endPos = traceAction.indexOf(',', pos);
			if (endPos == -1) {
				return traceAction.substring(pos);
			}
			return traceAction.substring(pos, endPos);
		}
	}

	/**
	 * Get the prefix that is used in each case of a class action to distinguish class, state and operation actions.
	 *
	 * @param feature
	 *            The trace feature for which we set an action
	 * @return
	 */
	public static String getStringPrefix(TraceFeature feature) {
		if (feature == TraceFeature.Class) {
			return "C:"; //$NON-NLS-1$
		}
		if (feature == TraceFeature.Port) {
			return "P:"; //$NON-NLS-1$
		}
		else if (feature == TraceFeature.State) {
			return "S:"; //$NON-NLS-1$
		}
		else if (feature == TraceFeature.Operation) {
			return "O:"; //$NON-NLS-1$
		}
		return null;
	}
}
