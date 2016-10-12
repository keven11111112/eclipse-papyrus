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
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assume.assumeThat;

import java.util.List;

import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.Size;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.junit.utils.rules.PluginResource;
import org.eclipse.papyrus.migration.rsa.tests.UML25HandlerExtension;
import org.eclipse.papyrus.migration.rsa.tests.regression.AbstractMigrationRegressionTest.TransformationExtensionClass;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.ClassCompositeCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.ClassCompositeEditPart;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.ClassCompositeNameEditPart;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Port;
import org.junit.Test;

/**
 * Specific regression tests for bugs in the import of structure diagrams.
 */
@TransformationExtensionClass(UML25HandlerExtension.class)
public class StructureDiagramTest extends AbstractMigrationRegressionTest {

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
	@PluginResource("CompositeStructureDiagram.emx")
	public void defaultFrameSize_bug461980() throws Exception {
		// Need to open the diagram to convert the visual IDs to modern notation for assertions
		Diagram diagram = openDiagram("StructureDiagram1");

		Node frame = requireChild(diagram, ClassCompositeEditPart.VISUAL_ID, Node.class);
		assertThat(frame.getLayoutConstraint(), instanceOf(Size.class));
		Size size = (Size) frame.getLayoutConstraint();
		assertThat(size.getWidth(), is(600));
		assertThat(size.getHeight(), is(400));
	}

	/**
	 * @see <a href="http://eclip.se/496653">bug 496653</a>
	 */
	@Test
	@PluginResource("bug461980/CompositeStructureDiagram.emx")
	public void dividerBetweenNameAndStructureCompartment_bug496653() throws Exception {
		// Need to open the diagram to convert the visual IDs to modern notation for assertions
		Diagram diagram = openDiagram("StructureDiagram1");

		View frame = requireChild(diagram, ClassCompositeEditPart.VISUAL_ID);

		View name = requireChild(frame, ClassCompositeNameEditPart.VISUAL_ID);
		View structure = requireChild(frame, ClassCompositeCompartmentEditPart.VISUAL_ID);

		@SuppressWarnings("unchecked")
		List<? extends View> children = frame.getChildren();
		assertThat(children, containsInOrder(name, structure));
	}

	/**
	 * Verify that non-conjugated ports in imported diagrams show the coloured interior
	 * as specified in the source diagram notation.
	 * 
	 * @see <a href="http://eclip.se/498282">bug 498282</a>
	 */
	@Test
	@PluginResource("ConjugationExample.emx")
	public void portNonconjugationVisuals_bug498282() throws Exception {
		Class client = (Class) rootPackage.getOwnedType("Client");
		Diagram csd = diagramsOf(client).findAny().get();
		assumeThat(csd, notNullValue());

		// All of these are not conjugated
		streamAllContents(csd)
				.filter(Shape.class::isInstance).map(Shape.class::cast)
				.filter(s -> s.getElement() instanceof Port)
				.forEach(p -> assertThat(p.eIsSet(NotationPackage.Literals.FILL_STYLE__FILL_COLOR), is(true)));
	}

	/**
	 * Verify that conjugated ports in imported diagrams show the white interior
	 * regardless of the coloration in the source (which used a different styling
	 * convention to show conjugation).
	 * 
	 * @see <a href="http://eclip.se/498282">bug 498282</a>
	 */
	@Test
	@PluginResource("ConjugationExample.emx")
	public void portConjugationVisuals_bug498282() throws Exception {
		Class server = (Class) rootPackage.getOwnedType("Server");
		Diagram csd = diagramsOf(server).findAny().get();
		assumeThat(csd, notNullValue());

		// All of these are conjugated
		streamAllContents(csd)
				.filter(Shape.class::isInstance).map(Shape.class::cast)
				.filter(s -> s.getElement() instanceof Port)
				.forEach(p -> assertThat(p.eIsSet(NotationPackage.Literals.FILL_STYLE__FILL_COLOR), is(false)));
	}
}
