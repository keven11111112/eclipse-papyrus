/*****************************************************************************
 * Copyright (c) 2016 Christian W. Damus and others.
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

package org.eclipse.papyrus.infra.types.core.internal.ui;

import org.eclipse.core.runtime.Platform;
import org.eclipse.papyrus.infra.core.log.LogHelper;

/**
 * Logging utility.
 */
public class LogUtil extends LogHelper {

	public static final LogHelper LOG = new LogUtil();

	/**
	 * Not instantiable by clients.
	 */
	private LogUtil() {
		super(Platform.getBundle("org.eclipse.papyrus.infra.types.ui")); //$NON-NLS-1$
	}

}
