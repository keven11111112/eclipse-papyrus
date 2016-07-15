/*****************************************************************************
 * Copyright (c) 2016 Christian W. Damus and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.migration.rsa.tests.regression;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.Size;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.migration.rsa.tests.qvt.AbstractTransformationTest;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.ClassCompositeEditPart;
import org.junit.Test;

/**
 * Specific regression tests for bugs in the import of structure diagrams.
 */
public class StructureDiagramTest extends AbstractTransformationTest {

	/**
	 * Initializes me.
	 */
	public StructureDiagramTest() {
		super();
	}

	/**
	 * @see <a href="http://eclip.se/461980">bug 461980</a>
	 */
	@Test
	public void defaultFrameSize_bug461980() throws Exception {
		simpleImport("resources/bug461980/CompositeStructureDiagram.emx");

		openEditor();

		// Need to open the diagram to convert the visual IDs to modern notation for assertions
		Diagram diagram = openDiagram("StructureDiagram1");

		View frameView = ViewUtil.getChildBySemanticHint(diagram, ClassCompositeEditPart.VISUAL_ID);
		assertThat(frameView, instanceOf(Node.class));

		Node frame = (Node) frameView;
		assertThat(frame.getLayoutConstraint(), instanceOf(Size.class));
		Size size = (Size) frame.getLayoutConstraint();
		assertThat(size.getWidth(), is(600));
		assertThat(size.getHeight(), is(400));
	}
}
