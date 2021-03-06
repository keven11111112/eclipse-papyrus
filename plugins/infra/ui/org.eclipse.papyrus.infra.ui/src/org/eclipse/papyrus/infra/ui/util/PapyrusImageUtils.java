/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Tristan Faure (ATOS ORIGIN INTEGRATION) tristan.faure@atosorigin.com - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.ui.util;

import java.io.IOException;
import java.net.URL;

import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.papyrus.infra.ui.Activator;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

/**
 * Services to access to Papyrus images
 *
 * @author tristan faure
 * @since 1.2
 *
 */
public class PapyrusImageUtils {

	private static final String default_icon_32 = "/icons/papyrus/32x32/Papyrus_32x32_t.gif"; //$NON-NLS-1$

	private static final String default_icon = "/icons/papyrus/Papyrus.gif"; //$NON-NLS-1$

	/**
	 * get the default icon for Papyrus the image does not have to be disposed
	 * as it is registered in an ImageRegistry
	 *
	 * @return the Image
	 */
	public static Image getDefaultIcon() {
		return getIcon(default_icon);
	}

	/**
	 * get the default icon 32x32 for Papyrus the image does not have to be
	 * disposed as it is registered in an ImageRegistry
	 *
	 * @return the Image
	 */
	public static Image getDefaultIcon32() {
		return getIcon(default_icon_32);
	}

	private static Image getIcon(String path) {
		String key = Activator.PLUGIN_ID + path;
		Image result = JFaceResources.getImageRegistry().get(key);
		if (result == null) {
			URL url = Activator.getDefault().getBundle().getEntry(path);

			if (url != null) {
				try {
					result = new Image(Display.getDefault(), url.openStream());
					JFaceResources.getImageRegistry().put(key, result);
				} catch (IOException e) {
				}
			}
		}
		return result;
	}
}
