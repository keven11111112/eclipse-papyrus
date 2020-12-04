/******************************************************************************
 * Copyright (c) 2012, 2020 Borland Software Corporation, CEA LIST, Artal
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
 *    Aurelien Didier (ARTAL) - aurelien.didier51@gmail.com - Bug 569174
 *****************************************************************************/
package org.eclipse.papyrus.gmf.internal.bridge.genmodel;

import org.eclipse.papyrus.gmf.codegen.gmfgen.GMFGenFactory;
import org.eclipse.papyrus.gmf.codegen.gmfgen.ModeledViewmap;
import org.eclipse.papyrus.gmf.codegen.gmfgen.Viewmap;
import org.eclipse.papyrus.gmf.gmfgraph.Canvas;
import org.eclipse.papyrus.gmf.gmfgraph.Compartment;
import org.eclipse.papyrus.gmf.gmfgraph.Connection;
import org.eclipse.papyrus.gmf.gmfgraph.DiagramElement;
import org.eclipse.papyrus.gmf.gmfgraph.DiagramLabel;
import org.eclipse.papyrus.gmf.gmfgraph.Node;

public class ModeledViewmapProducer extends DefaultViewmapProducer {

	@Override
	public Viewmap create(Canvas canvasElement) {
		ModeledViewmap result = GMFGenFactory.eINSTANCE.createModeledViewmap();
		result.setFigureModel(canvasElement);
		return result;
	}

	@Override
	public Viewmap create(Node node) {
		Viewmap viewmap = createModeledViewmap(node);
		setupResizeConstraints(viewmap, node);
		setupLayoutType(viewmap, node);
		setupDefaultSize(viewmap, node);
		return viewmap;
	}

	@Override
	public Viewmap create(Connection link) {
		return createModeledViewmap(link);
	}

	@Override
	public Viewmap create(Compartment compartment) {
		return createModeledViewmap(compartment);
	}

	@Override
	public Viewmap create(DiagramLabel label) {
		return createModeledViewmap(label);
	}

	@Override
	public String[] dependencies() {
		return new String[0];
	}

	private ModeledViewmap createModeledViewmap(DiagramElement diagramElement) {
		ModeledViewmap result = GMFGenFactory.eINSTANCE.createModeledViewmap();
		result.setFigureModel(diagramElement);
		if (diagramElement.getFigure() != null && diagramElement.getFigure().getActualFigure() != null) {
			setupStyleAttributes(result, diagramElement.getFigure().getActualFigure());
		}
		return result;
	}

}
