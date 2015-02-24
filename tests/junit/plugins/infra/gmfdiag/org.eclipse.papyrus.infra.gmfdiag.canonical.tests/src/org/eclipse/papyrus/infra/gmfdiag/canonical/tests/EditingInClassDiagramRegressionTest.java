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

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.papyrus.junit.utils.rules.ActiveDiagram;
import org.eclipse.papyrus.junit.utils.rules.PluginResource;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLPackage;
import org.junit.Before;
import org.junit.Test;

/**
 * Regression tests for add/delete scenarios in the diagram using the palette tools that operate on notation
 * and semantics together (usual non-canonical work), with undo and redo.
 */
@PluginResource("models/classdiagram_canonical.di")
@ActiveDiagram("canonical")
public class EditingInClassDiagramRegressionTest extends AbstractCanonicalTest {
	private org.eclipse.uml2.uml.Package root;

	private org.eclipse.uml2.uml.Class foo;
	private org.eclipse.uml2.uml.Class bar;
	private Enumeration yesno;
	private EnumerationLiteral yesno_no;

	private Association foo_bar;

	private org.eclipse.uml2.uml.Package types;
	private DataType types_date;

	public EditingInClassDiagramRegressionTest() {
		super();
	}

	@Test
	public void createPropertyInClass() {
		Property property = createWithView(bar, UMLPackage.Literals.PROPERTY, Property.class);

		EditPart editPart = requireEditPart(property);
		assertThat(getClassAttributeCompartment(requireEditPart(bar)), is(editPart.getParent()));
	}

	@Test
	public void createPropertyInClass_undo() {
		Property property = createWithView(bar, UMLPackage.Literals.PROPERTY, Property.class);

		undo();

		assertNoView(property);
	}

	@Test
	public void createPropertyInClass_undo_redo() {
		Property property = createWithView(bar, UMLPackage.Literals.PROPERTY, Property.class);

		undo();
		redo();

		EditPart editPart = requireEditPart(property);
		assertThat(getClassAttributeCompartment(requireEditPart(bar)), is(editPart.getParent()));
	}

	@Test
	public void deleteLiteralInEnumeration() {
		removeWithView(yesno_no);

		assertNoView(yesno_no);
	}

	@Test
	public void deleteLiteralInEnumeration_undo() {
		removeWithView(yesno_no);

		undo();

		EditPart editPart = requireEditPart(yesno_no);
		assertThat(getEnumerationLiteralCompartment(requireEditPart(yesno)), is(editPart.getParent()));
	}

	@Test
	public void deleteLiteralInEnumeration_undo_redo() {
		removeWithView(yesno_no);

		undo();
		redo();

		assertNoView(yesno_no);
	}

	@Test
	public void createInterfaceInPackage() {
		Interface interface_ = createWithView(types, UMLPackage.Literals.INTERFACE, Interface.class);

		EditPart editPart = requireEditPart(interface_);
		assertThat(getPackageContentsCompartment(requireEditPart(types)), is(editPart.getParent()));
	}

	@Test
	public void createInterfaceInPackage_undo() {
		Interface interface_ = createWithView(types, UMLPackage.Literals.INTERFACE, Interface.class);

		undo();

		assertNoView(interface_);
	}

	@Test
	public void createInterfaceInPackage_undo_redo() {
		Interface interface_ = createWithView(types, UMLPackage.Literals.INTERFACE, Interface.class);

		undo();
		redo();

		EditPart editPart = requireEditPart(interface_);
		assertThat(getPackageContentsCompartment(requireEditPart(types)), is(editPart.getParent()));
	}

	@Test
	public void deleteDataTypeFromPackage() {
		removeWithView(types_date);

		assertNoView(types_date);
	}

	@Test
	public void deleteDataTypeFromPackage_undo() {
		removeWithView(types_date);

		undo();

		EditPart editPart = requireEditPart(types_date);
		assertThat(getPackageContentsCompartment(requireEditPart(types)), is(editPart.getParent()));
	}

	@Test
	public void deleteDataTypeFromPackage_undo_redo() {
		removeWithView(types_date);

		undo();
		redo();

		assertNoView(types_date);
	}

	@NeedsUIEvents
	@Test
	public void createDependencyInClass() {
		// Ensure canonical connections
		setCanonical(true, requireEditPart(root));
		setCanonical(true, requireEditPart(types_date));

		Dependency dependency = createDependencyWithView(bar, types_date);

		ConnectionEditPart editPart = (ConnectionEditPart) requireConnectionEditPart(dependency);
		assertThat(editPart.getSource(), is((EditPart) requireEditPart(bar)));
		assertThat(editPart.getTarget(), is((EditPart) requireEditPart(types_date)));
	}

	@NeedsUIEvents
	@Test
	public void createDependencyInClass_undo() {
		// Ensure canonical connections
		setCanonical(true, requireEditPart(root));
		setCanonical(true, requireEditPart(types_date));

		Dependency dependency = createDependencyWithView(bar, types_date);

		undo();

		assertNoView(dependency);
	}

	@NeedsUIEvents
	@Test
	public void createDependencyInClass_undo_redo() {
		// Ensure canonical connections
		setCanonical(true, requireEditPart(root));
		setCanonical(true, requireEditPart(types_date));

		Dependency dependency = createDependencyWithView(bar, types_date);

		undo();
		redo();

		ConnectionEditPart editPart = (ConnectionEditPart) requireConnectionEditPart(dependency);
		assertThat(editPart.getSource(), is((EditPart) requireEditPart(bar)));
		assertThat(editPart.getTarget(), is((EditPart) requireEditPart(types_date)));
	}

	@NeedsUIEvents
	@Test
	public void deleteAssociationFromClass() {
		removeWithView(foo_bar);

		assertNoView(foo_bar);
	}

	@NeedsUIEvents
	@Test
	public void deleteAssociationFromClass_undo() {
		// Ensure canonical connections
		setCanonical(true, requireEditPart(root));

		removeWithView(foo_bar);

		undo();

		ConnectionEditPart editPart = (ConnectionEditPart) requireConnectionEditPart(foo_bar);
		assertThat(editPart.getSource(), is((EditPart) requireEditPart(foo)));
		assertThat(editPart.getTarget(), is((EditPart) requireEditPart(bar)));
	}

	@NeedsUIEvents
	@Test
	public void deleteAssociationFromClass_undo_redo() {
		// Ensure canonical connections
		setCanonical(true, requireEditPart(root));

		removeWithView(foo_bar);

		undo();
		redo();

		assertNoView(foo_bar);
	}


	//
	// Test framework
	//

	@Before
	public void getModelElements() {
		root = editor.getModel();

		foo = (org.eclipse.uml2.uml.Class) root.getOwnedType("Foo");
		bar = (org.eclipse.uml2.uml.Class) root.getOwnedType("Bar");
		yesno = (Enumeration) root.getOwnedType("YesNo");
		yesno_no = yesno.getOwnedLiteral("no");

		foo_bar = foo.getOwnedAttribute("bar", null).getAssociation();

		types = root.getNestedPackage("types");
		types_date = (DataType) types.getOwnedType("Date");
	}

}
