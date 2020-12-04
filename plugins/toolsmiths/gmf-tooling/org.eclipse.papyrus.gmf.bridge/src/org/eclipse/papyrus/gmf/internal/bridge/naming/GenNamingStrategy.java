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

/**
 * @author dstadnik
 */
public interface GenNamingStrategy {

	public String get(GenDiagram element);

	public String get(GenNode element);

	public String get(GenCompartment element);

	public String get(GenLink element);

	public String get(GenLabel element);
}
