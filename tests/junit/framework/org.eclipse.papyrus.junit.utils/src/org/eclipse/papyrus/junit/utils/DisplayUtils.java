/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.junit.utils;

import org.eclipse.swt.widgets.Display;


public class DisplayUtils {

	/** Processes all events waiting in the Display's event loop and then returns. */
	public static void flushEventLoop() {
		final Display display = Display.getDefault();
		display.syncExec(new Runnable() {

			public void run() {
				try {
					while(display.readAndDispatch()) {
						// nothing
					}
				} catch (Exception ex) {
					//Do not fail the test for invalid runnables
				}
			}
		});
	}

}
