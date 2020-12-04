/*******************************************************************************
 * Copyright (c) 2006, 2020 Borland Software Corporation, CEA LIST, ARTAL
 * 
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License 2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-2.0/
 * 
 *  SPDX-License-Identifier: EPL-2.0
 * 
 *  Contributors:
 *     Borland - initial API and implementation
 *     Aurelien Didier (ARTAL) - aurelien.didier51@gmail.com - Bug 569174
 ******************************************************************************/
package org.eclipse.papyrus.gmf.internal.bridge.trace;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.BundleContext;

public class GmfTracePlugin extends Plugin {

	private static GmfTracePlugin myInstance;

	public void start(BundleContext context) throws Exception {
		super.start(context);
		myInstance = this;
	}

	public void stop(BundleContext context) throws Exception {
		super.stop(context);
		myInstance = null;
	}

	public static GmfTracePlugin getInstance() {
		return myInstance;
	}

	public void logError(String message, Throwable exception) {
		getLog().log(new Status(IStatus.ERROR, getBundle().getSymbolicName(), 0, message, exception));
	}

	public void logDebugInfo(String message) {
		if (isDebugging()) {
			getLog().log(new Status(IStatus.INFO, getBundle().getSymbolicName(), 0, message, null));
		}
	}

}
