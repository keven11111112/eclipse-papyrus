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
package org.eclipse.papyrus.infra.services.tracebreakpoints.ui;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.infra.services.tracebreakpoints.TraceActionEnums.TraceFeature;
import org.eclipse.papyrus.infra.services.tracebreakpoints.ui.preferences.TPPreferenceConstants;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.State;

/**
 * Set of enumerations that indicates what we want to trace.
 *
 * @author ansgar
 *
 */
public class TraceActions {

	public static String[][] getStringFields(Enum<?>[] enumValues) {
		int i = 0;
		String[][] taOptions = new String[enumValues.length][2];
		for (Enum<?> tLiteral : enumValues) {
			taOptions[i][1] = tLiteral.name();
			taOptions[i][0] = tLiteral.name();
			i++;
		}
		return taOptions;
	}

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

	/**
	 * Initialize an action string that will be stored in the trace marker from the configured actions
	 * in the preferences. In case of a class, the value is a combination of different options
	 * that are prefixed to enable a unique classification
	 *
	 * @param feature
	 *            The trace feature for which we set an action
	 * @return
	 */
	public static String actionFromPreferences(TraceFeature feature) {
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		if (feature == TraceFeature.Class) {
			return compositeClassOption(store.getInt(TPPreferenceConstants.P_TRACE_OPTION_CLASS),
					store.getInt(TPPreferenceConstants.P_TRACE_OPTION_STATE),
					store.getInt(TPPreferenceConstants.P_TRACE_OPTION_OP));
		}
		else if (feature == TraceFeature.State) {
			return store.getString(TPPreferenceConstants.P_TRACE_OPTION_STATE);
		}
		else if (feature == TraceFeature.Operation) {
			return store.getString(TPPreferenceConstants.P_TRACE_OPTION_OP);
		}
		return ""; //$NON-NLS-1$
	}

	public static String compositeClassOption(int classOption, int stateOption, int operationOption) {
		return getStringPrefix(TraceFeature.Class) + classOption + "," + //$NON-NLS-1$
				getStringPrefix(TraceFeature.State) + stateOption + "," + //$NON-NLS-1$
				getStringPrefix(TraceFeature.Operation) + operationOption;
	}

	/**
	 * Convenience function, return the action defined in the preferences in function of the model element
	 *
	 * @param element
	 * @return
	 */
	public static String actionFromPreferences(EObject element) {
		return actionFromPreferences(getTraceFeature(element));
	}


	public static TraceFeature getTraceFeature(EObject element) {
		if (element instanceof State) {
			return TraceFeature.State;
		}
		else if (element instanceof Operation) {
			return TraceFeature.Operation;
		}
		else if (element instanceof org.eclipse.uml2.uml.Class) {
			return TraceFeature.Class;
		}
		return null;
	}
}
