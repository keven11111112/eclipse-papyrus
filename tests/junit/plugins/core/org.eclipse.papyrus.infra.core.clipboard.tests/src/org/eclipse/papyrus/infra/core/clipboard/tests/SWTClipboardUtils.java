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
 *
 *****************************************************************************/

package org.eclipse.papyrus.infra.core.clipboard.tests;

import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Display;

public class SWTClipboardUtils {

	 static void fillClipboard(String str) {
		// adapted from CopyDataToClipboard from nattable
		final TextTransfer textTransfer = TextTransfer.getInstance();
		final Clipboard clipboard = new Clipboard(Display.getDefault());
		try {
			clipboard.setContents(new Object[] { str.toString() },
					new Transfer[] { textTransfer });
		} finally {
			clipboard.dispose();
		}

	}

 static String getClipboardContents() {
		// using SWT
		final Display display = Display.getDefault();
		String contents = null;
		final Clipboard clipboard = new Clipboard(display);
		try {

			// we use the text transfert
			final TextTransfer transfer = TextTransfer.getInstance();

			contents = (String) clipboard.getContents(transfer);

			return contents;
		} finally {
			clipboard.dispose();
		}
	}
}
