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
 *    Michael Golubev (Borland) - initial API and implementation
 *    Artem Tikhomirov (Borland) - redesigned as enumeration
 *    Aurelien Didier (ARTAL) - aurelien.didier51@gmail.com - Bug 569174
 *****************************************************************************/
package org.eclipse.papyrus.gmf.graphdef.codegen;

/**
 * @author artem
 */
public enum MapModeCodeGenStrategy { 
	STATIC(""), 
	DYNAMIC("rt_mm");

	private final String token;

	private MapModeCodeGenStrategy(String token) {
		assert token != null;
		this.token = token;
	}

	/**
	 * @return identifying token of this strategy 
	 */
	public String getToken() {
		return token;
	}
}
