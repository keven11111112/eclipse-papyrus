/*******************************************************************************
 * Copyright (c) 2009, 2020 Borland Software Corp, CEA LIST, Artal
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/ 
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors: 
 *    Alexander Shatalin (Borland) - initial API and implementation
 *     Aurelien Didier (ARTAL) - aurelien.didier51@gmail.com - Bug 569174
 *****************************************************************************/
package org.eclipse.papyrus.gmf.internal.xpand.model;

public class AmbiguousDefinitionException extends Exception {

	private XpandDefinition definition1;

	private XpandDefinition definition2;
	
	public AmbiguousDefinitionException(XpandDefinition candidate1, XpandDefinition candidate2) {
		super("Ambiguous definitions " + candidate1.toString() + " and " + candidate2.toString());
		definition1 = candidate1;
		definition2 = candidate2;
	}

	public XpandDefinition getDefinition1() {
		return definition1;
	}

	public XpandDefinition getDefinition2() {
		return definition2;
	}

}
