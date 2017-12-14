/**
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.uml.diagram.statemachine.custom.preferences;

/**
 * Constants for Transition preferences (use same constants as for CSS options)
 */
public class PreferenceConstants {
	/**
	 * integer: Maximum length of displayed bodies.
	 */
	public static final String BODY_CUT_LENGTH = CSSOptionsConstants.BODY_CUT_LENGTH;

	/**
	 * Boolean: if true, indicate presence of parameters (attributes) by adding (...) to call or signal event.
	 */
	public static final String INDICATE_PARAMETERS = CSSOptionsConstants.INDICATE_PARAMETERS;

	/**
	 * Boolean: if true, add a line-break to the transition label before the effect
	 */
	public static final String LINEBREAK_BEFORE_EFFECT = CSSOptionsConstants.LINEBREAK_BEFORE_EFFECT;
}
