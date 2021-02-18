/******************************************************************************
 * Copyright (c) 2005, 2020 Sven Efftinge, CEA LIST, Artal and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/ 
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors: 
 *     Sven Efftinge - Initial API and implementation
 *     Artem Tikhomirov (Borland) - Migration to OCL expressions
 *     AurÃ©lien Didier (ARTAL) - aurelien.didier51@gmail.com - Bug 569174
 *******************************************************************************/
package org.eclipse.papyrus.gmf.internal.xpand.util;

/**
 * @author Sven Efftinge
 * @author Arno Haase
 */
public class TypeNameUtil {

	public final static String NS_DELIM = "::";

	public static String withoutLastSegment(final String fqn) {
		if (fqn.lastIndexOf(TypeNameUtil.NS_DELIM) == -1) {
			return null;
		}
		return fqn.substring(0, fqn.lastIndexOf(TypeNameUtil.NS_DELIM));
	}

	public static boolean isQualifiedName(String name) {
		assert name != null;
		return name.indexOf(TypeNameUtil.NS_DELIM) != -1;
	}

	public static String getLastSegment(final String fqn) {
		if (fqn.lastIndexOf(TypeNameUtil.NS_DELIM) == -1) {
			return fqn;
		}
		return fqn.substring(fqn.lastIndexOf(TypeNameUtil.NS_DELIM) + TypeNameUtil.NS_DELIM.length());
	}
}
