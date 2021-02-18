/******************************************************************************
 * Copyright (c) 2007, 2020 Borland Software Corporation, CEA LIST, Artal
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/ 
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 *    Aurelien Didier (ARTAL) - aurelien.didier51@gmail.com - Bug 569174
 *****************************************************************************/
package org.eclipse.papyrus.gmf.internal.bridge.naming;

import org.eclipse.papyrus.gmf.codegen.gmfgen.GenCompartment;
import org.eclipse.papyrus.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.papyrus.gmf.codegen.gmfgen.GenLabel;
import org.eclipse.papyrus.gmf.codegen.gmfgen.GenLink;
import org.eclipse.papyrus.gmf.codegen.gmfgen.GenNode;
import org.eclipse.papyrus.gmf.internal.common.NamesDispenser;

/**
 * Provides default names that do not reflect element semantic.
 * 
 * @author dstadnik
 */
public class DefaultGenNamingStrategy extends AbstractGenNamingStrategy {

	public DefaultGenNamingStrategy(String suffix, NamesDispenser namesDispenser, GenNamingStrategy chainedNamingStrategy, GenNamingStrategy prefixNamingStrategy) {
		super(suffix, namesDispenser, chainedNamingStrategy, prefixNamingStrategy);
	}

	public String get(GenDiagram element) {
		return createClassName(GenDiagram.CLASS_NAME_PREFIX);
	}

	public String get(GenNode element) {
		return createClassName(GenNode.CLASS_NAME_PREFIX);
	}

	public String get(GenCompartment element) {
		return createClassName(getCompartmentHostPrefix(element) + GenCompartment.CLASS_NAME_PREFIX);
	}

	public String get(GenLink element) {
		return createClassName(GenLink.CLASS_NAME_PREFIX);
	}

	public String get(GenLabel element) {
		return createClassName(getLabelHostPrefix(element) + GenLabel.CLASS_NAME_PREFIX);
	}
}
