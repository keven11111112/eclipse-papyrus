/******************************************************************************
 * Copyright (c) 2005, 2020 Borland Software Corporation, CEA LIST, Artal
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
package org.eclipse.papyrus.gmf.internal.bridge.genmodel;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.papyrus.gmf.mappings.CanvasMapping;
import org.eclipse.papyrus.gmf.mappings.LabelMapping;
import org.eclipse.papyrus.gmf.mappings.LinkMapping;
import org.eclipse.papyrus.gmf.mappings.NodeMapping;

/**
 * Bridges diagram definition elements with classes that represent diagram at runtime.
 * @author artem
 */
public interface DiagramRunTimeModelHelper {

	public GenClass get(NodeMapping nodeMapping);

	public GenClass get(LinkMapping linkMapping);

	public GenClass get(CanvasMapping canvasMapping);

	public GenClass getChildContainerDefault();

	public GenClass get(LabelMapping mapping);
}
