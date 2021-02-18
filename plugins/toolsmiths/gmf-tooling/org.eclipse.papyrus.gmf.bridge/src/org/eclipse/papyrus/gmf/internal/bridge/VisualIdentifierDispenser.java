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
 *    Artem Tikhomirov (Borland) - initial API and implementation
 *    Aurelien Didier (ARTAL) - aurelien.didier51@gmail.com - Bug 569174
 *****************************************************************************/
package org.eclipse.papyrus.gmf.internal.bridge;

import org.eclipse.papyrus.gmf.codegen.gmfgen.GenChildNode;
import org.eclipse.papyrus.gmf.codegen.gmfgen.GenCompartment;
import org.eclipse.papyrus.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.papyrus.gmf.codegen.gmfgen.GenLink;
import org.eclipse.papyrus.gmf.codegen.gmfgen.GenLinkLabel;
import org.eclipse.papyrus.gmf.codegen.gmfgen.GenNodeLabel;
import org.eclipse.papyrus.gmf.codegen.gmfgen.GenTopLevelNode;
import org.eclipse.papyrus.gmf.codegen.gmfgen.ToolGroup;

/**
 * @author artem
 */
public interface VisualIdentifierDispenser {

	int get(GenDiagram diagram);
	int get(GenTopLevelNode node);
	int get(GenNodeLabel nodeLabel);
	int get(GenLink link);
	int get(GenChildNode childNode);
	int get(GenCompartment compartment);
	int get(GenLinkLabel label);
	int get(ToolGroup toolGroup);
}
