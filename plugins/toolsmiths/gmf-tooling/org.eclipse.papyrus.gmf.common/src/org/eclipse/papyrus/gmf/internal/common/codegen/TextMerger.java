/******************************************************************************
 * Copyright (c) 2006, 2020 Borland Software Corporation, CEA LIST, Artal
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/ 
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors: 
 *    Dmitri Stadnik (Borland) - initial API and implementation
 *    Aurelien Didier (ARTAL) - aurelien.didier51@gmail.com - Bug 569174
 *****************************************************************************/
package org.eclipse.papyrus.gmf.internal.common.codegen;

/**
 * @author dstadnik
 */
public class TextMerger {
	public String mergeJava(String oldText, String newText) {
		return newText;
	}

	public String mergeProperties(String oldText, String newText) {
		return newText;
	}

	public String mergeXML(String oldText, String newText) {
		return newText;
	}

	public String mergePluginXML(String oldText, String newText) {
		return newText;
	}

	public String mergeManifestMF(String oldText, String newText) {
		return newText;
	}

	public String process(String fileName, String oldText, String newText) {
		if (fileName == null) {
			return newText;
		}
		if (fileName.endsWith(".java")) {
			return mergeJava(oldText, newText);
		} else if (fileName.endsWith(".xml")) {
			if (fileName.equals("plugin.xml")) {
				return mergePluginXML(oldText, newText);
			}
			return mergeXML(oldText, newText);
		} else if (fileName.endsWith(".properties")) {
			return mergeProperties(oldText, newText);
		} else if (fileName.equals("MANIFEST.MF")) {
			return mergeManifestMF(oldText, newText);
		}
		return newText;
	}
}
