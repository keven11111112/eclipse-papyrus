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

import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class AWTClipboardUtils {

	 static void fillClipboard(String str) {
		// its seems that the clipboard must be filled with the same way than we read it!
		java.awt.datatransfer.Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

		// if (clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor)) {
		StringSelection s = new StringSelection(str);
		clipboard.setContents(s, s);
		// }
	}

	 static String getClipboardContents() throws UnsupportedFlavorException, IOException {
		String bufferSystem = null;


		java.awt.datatransfer.Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

		if (clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor)) {
			bufferSystem = clipboard.getData(DataFlavor.stringFlavor).toString();
		}
		return bufferSystem;

	}
}
