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

import org.eclipse.papyrus.gmf.codegen.gmfgen.Viewmap;
import org.eclipse.papyrus.gmf.gmfgraph.Canvas;
import org.eclipse.papyrus.gmf.gmfgraph.Compartment;
import org.eclipse.papyrus.gmf.gmfgraph.Connection;
import org.eclipse.papyrus.gmf.gmfgraph.DiagramLabel;
import org.eclipse.papyrus.gmf.gmfgraph.Node;

/**
 * @author artem
 * XXX rename 'create' to 'get'? 
 */
public abstract class ViewmapProducer {

	public abstract Viewmap create(Canvas canvasElement);

	// XXX with Node split to AbstractNode, may need to reconsider this API
	public abstract Viewmap create(Node node);

	public abstract Viewmap create(Connection link);

	public abstract Viewmap create(Compartment compartment);

	public abstract Viewmap create(DiagramLabel label);

	/**
	 * 
	 * @return collection of plug-in identifiers that viewmaps depend from
	 */
	public abstract String[] dependencies();
}
