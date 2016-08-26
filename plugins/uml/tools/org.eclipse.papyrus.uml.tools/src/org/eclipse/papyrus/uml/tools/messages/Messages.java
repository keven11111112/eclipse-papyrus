/*****************************************************************************
 * Copyright (c) 2016 CEA LIST, ALL4TEC and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Mickael ADAM (ALL4TEC) - mickael.adam@all4tec.net -  Initial API and implementation
 *****************************************************************************/

package org.eclipse.papyrus.uml.tools.messages;

import org.eclipse.osgi.util.NLS;

/**
 * Messages class for org.eclipse.papyrus.uml.tools plugin.
 */
public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.papyrus.uml.tools.messages.messages"; //$NON-NLS-1$
	public static String FlatTabUMLLabelProvider_QualifyNameButtonTooltip;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
