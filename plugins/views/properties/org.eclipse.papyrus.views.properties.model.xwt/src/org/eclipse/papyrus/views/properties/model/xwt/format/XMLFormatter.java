/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.model.xwt.format;

import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.papyrus.views.properties.model.xwt.Activator;
import org.eclipse.wst.xml.core.internal.formatter.XMLFormatterFormatProcessor;

/**
 * A Helper for formatting XML Files
 *
 * @author Camille Letavernier
 */
public class XMLFormatter {

	public static void format(IFile file) {
		XMLFormatterFormatProcessor processor = new XMLFormatterFormatProcessor();
		try {
			processor.formatFile(file);
		} catch (IOException ex) {
			Activator.log.error(ex);
		} catch (CoreException ex) {
			Activator.log.error(ex);
		}
	}
}
