/*****************************************************************************
 * Copyright (c) 2015 Christian W. Damus and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.infra.ui.internal.preferences;

import org.eclipse.osgi.util.NLS;

/**
 * Translatable strings.
 */
class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.papyrus.infra.core.internal.preferences.messages"; //$NON-NLS-1$
	public static String EditorPreferencePage_0;
	public static String EditorPreferencePage_1;
	public static String EditorPreferencePage_2;
	public static String EditorPreferencePage_3;
	public static String EditorPreferencePage_4;
	public static String EditorPreferencePage_5;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
