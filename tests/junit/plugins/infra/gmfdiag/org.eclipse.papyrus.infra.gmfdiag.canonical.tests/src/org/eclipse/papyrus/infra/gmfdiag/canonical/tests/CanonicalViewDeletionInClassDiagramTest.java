/*****************************************************************************
 * Copyright (c) 2015 Christian W. Damus and others.
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

package org.eclipse.papyrus.infra.gmfdiag.canonical.tests;

import org.eclipse.papyrus.junit.utils.rules.ActiveDiagram;
import org.eclipse.papyrus.junit.utils.rules.PluginResource;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.Operation;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests various add/delete scenarios on canonical views in the diagram, with undo and redo.
 * These scenarios perform the equivalent of "hide element" to request deletion of the view
 * only, but because it's canonical, the semantic element is deleted, too.
 */
@PluginResource("models/classdiagram_canonical.di")
@ActiveDiagram("canonical")
public class CanonicalViewDeletionInClassDiagramTest extends AbstractCanonicalTest {
	private org.eclipse.uml2.uml.Package root;

	private org.eclipse.uml2.uml.Class foo;
	private Operation foo_doit;
	private Association foo_bar;

	private org.eclipse.uml2.uml.Package types;
	private org.eclipse.uml2.uml.Class types_subfoo;
	private Generalization types_subfoo_foo;

	public CanonicalViewDeletionInClassDiagramTest() {
		super();
	}

	@Test
	public void deleteOperationViewFromClass() {
		delete(requireEditPart(foo_doit));

		assertDetached(foo_doit);
	}

	@Test
	public void deleteOperationViewFromClass_undo() {
		delete(requireEditPart(foo_doit));

		undo();

		requireEditPart(foo_doit);
		assertAttached(foo_doit);
	}

	@Test
	public void deleteOperationViewFromClass_undo_redo() {
		delete(requireEditPart(foo_doit));

		undo();
		redo();

		assertDetached(foo_doit);
	}

	@NeedsUIEvents
	@Test
	public void deleteClassViewFromPackage() {
		delete(requireEditPart(types_subfoo));

		assertDetached(types_subfoo);
	}

	@NeedsUIEvents
	@Test
	public void deleteClassViewFromPackage_undo() {
		delete(requireEditPart(types_subfoo));

		undo();

		requireEditPart(types_subfoo);
		assertAttached(types_subfoo);
	}

	@NeedsUIEvents
	@Test
	public void deleteClassViewFromPackage_undo_redo() {
		delete(requireEditPart(types_subfoo));

		undo();
		redo();

		assertDetached(types_subfoo);
	}

	@NeedsUIEvents
	@Test
	public void deleteGeneralizationViewFromClass() {
		delete(requireConnectionEditPart(types_subfoo_foo));

		assertDetached(types_subfoo_foo);
	}

	@NeedsUIEvents
	@Test
	public void deleteGeneralizationViewFromClass_undo() {
		delete(requireConnectionEditPart(types_subfoo_foo));

		undo();

		requireConnectionEditPart(types_subfoo_foo);
		assertAttached(types_subfoo_foo);
	}

	@NeedsUIEvents
	@Test
	public void deleteGeneralizationViewFromClass_undo_redo() {
		delete(requireConnectionEditPart(types_subfoo_foo));

		undo();
		redo();

		assertDetached(types_subfoo_foo);
	}

	@NeedsUIEvents
	@Test
	public void deleteAssociationViewFromClass() {
		delete(requireConnectionEditPart(foo_bar));

		assertDetached(foo_bar);
	}

	@NeedsUIEvents
	@Test
	public void deleteAssociationViewFromClass_undo() {
		delete(requireConnectionEditPart(foo_bar));

		undo();

		requireConnectionEditPart(foo_bar);
		assertAttached(foo_bar);
	}

	@NeedsUIEvents
	@Test
	public void deleteAssociationViewFromClass_undo_redo() {
		delete(requireConnectionEditPart(foo_bar));

		undo();
		redo();

		assertDetached(foo_bar);
	}


	//
	// Test framework
	//

	@Before
	public void getModelElementsAndEnsureCanonicalConnections() {
		root = editor.getModel();

		foo = (org.eclipse.uml2.uml.Class) root.getOwnedType("Foo");
		foo_doit = foo.getOwnedOperation("doIt", null, null);
		foo_bar = foo.getOwnedAttribute("bar", null).getAssociation();

		types = root.getNestedPackage("types");
		types_subfoo = (org.eclipse.uml2.uml.Class) types.getOwnedType("SubFoo");
		types_subfoo_foo = types_subfoo.getGeneralization(foo);

		// Ensure canonical connections
		setCanonical(true, requireEditPart(root));
		setCanonical(true, requireEditPart(types_subfoo));
	}

}
