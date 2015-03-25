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

import static org.hamcrest.CoreMatchers.either;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.papyrus.junit.utils.rules.ActiveDiagram;
import org.eclipse.papyrus.junit.utils.rules.PluginResource;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests various add/delete/destroy scenarios on elements in the semantic model, with undo and redo.
 */
@PluginResource("models/classdiagram_canonical.di")
@ActiveDiagram("canonical")
public class EditingInModelInClassDiagramTest extends AbstractCanonicalTest {
	private org.eclipse.uml2.uml.Package root;

	private org.eclipse.uml2.uml.Class foo;
	private Operation foo_doit;
	private org.eclipse.uml2.uml.Class bar;
	private org.eclipse.uml2.uml.Class super_;
	private Enumeration yesno;

	private org.eclipse.uml2.uml.Package types;
	private org.eclipse.uml2.uml.Class types_subfoo;
	private DataType types_date;

	private Generalization types_subfoo_foo;

	public EditingInModelInClassDiagramTest() {
		super();
	}

	@Test
	public void addPropertyToClass() {
		Property property = UMLFactory.eINSTANCE.createProperty();
		property.setName("newProperty");
		property.setType(yesno);
		add(bar, property, UMLPackage.Literals.STRUCTURED_CLASSIFIER__OWNED_ATTRIBUTE);

		EditPart editPart = requireEditPart(property);
		assertThat(getClassAttributeCompartment(requireEditPart(bar)), is(editPart.getParent()));
	}

	@Test
	public void addPropertyToClass_undo_redo() {
		Property property = UMLFactory.eINSTANCE.createProperty();
		property.setName("newProperty");
		property.setType(yesno);
		add(bar, property, UMLPackage.Literals.STRUCTURED_CLASSIFIER__OWNED_ATTRIBUTE);

		undo();

		assertNoView(property);

		redo();

		EditPart editPart = requireEditPart(property);
		assertThat(getClassAttributeCompartment(requireEditPart(bar)), is(editPart.getParent()));
	}

	@Test
	public void removeOperationFromClass() {
		remove(foo_doit);

		assertNoView(foo_doit);
	}

	@Test
	public void removeOperationFromClass_undo_redo() {
		remove(foo_doit);

		undo();

		EditPart editPart = requireEditPart(foo_doit);
		assertThat(getClassOperationCompartment(requireEditPart(foo)), is(editPart.getParent()));

		redo();

		assertNoView(foo_doit);
	}

	@Test
	public void addInterfaceToPackage() {
		Interface interface_ = UMLFactory.eINSTANCE.createInterface();
		interface_.setName("IClaudius");
		add(types, interface_, UMLPackage.Literals.PACKAGE__PACKAGED_ELEMENT);

		EditPart editPart = requireEditPart(interface_);
		assertThat(getPackageContentsCompartment(requireEditPart(types)), is(editPart.getParent()));
	}

	@Test
	public void addInterfaceToPackage_undo_redo() {
		Interface interface_ = UMLFactory.eINSTANCE.createInterface();
		interface_.setName("IClaudius");
		add(types, interface_, UMLPackage.Literals.PACKAGE__PACKAGED_ELEMENT);

		undo();

		assertNoView(interface_);

		redo();

		EditPart editPart = requireEditPart(interface_);
		assertThat(getPackageContentsCompartment(requireEditPart(types)), is(editPart.getParent()));
	}

	@Test
	public void removeClassFromPackage() {
		remove(types_subfoo);

		assertNoView(types_subfoo);
	}

	@Test
	public void removeClassFromPackage_undo_redo() {
		remove(types_subfoo);

		undo();

		EditPart editPart = requireEditPart(types_subfoo);
		assertThat(getPackageContentsCompartment(requireEditPart(types)), is(editPart.getParent()));

		redo();

		assertNoView(types_subfoo);
	}

	/**
	 * A relationship that is an element owned by the source (easy case).
	 */
	@NeedsUIEvents
	@Test
	public void addElementImportToPackage() {
		// Ensure canonical connections
		setCanonical(true, requireEditPart(root));

		ElementImport import_ = UMLFactory.eINSTANCE.createElementImport();
		import_.setImportedElement(yesno);
		add(types, import_, UMLPackage.Literals.NAMESPACE__ELEMENT_IMPORT);

		ConnectionEditPart editPart = (ConnectionEditPart) requireConnectionEditPart(import_);
		assertThat(editPart.getSource(), is((EditPart) requireEditPart(types)));
		assertThat(editPart.getTarget(), is((EditPart) requireEditPart(yesno)));
	}

	/**
	 * A relationship that is an element owned by the source (easy case).
	 */
	@NeedsUIEvents
	@Test
	public void addElementImportToPackage_undo() {
		// Ensure canonical connections
		setCanonical(true, requireEditPart(root));

		ElementImport import_ = UMLFactory.eINSTANCE.createElementImport();
		import_.setImportedElement(yesno);
		add(types, import_, UMLPackage.Literals.NAMESPACE__ELEMENT_IMPORT);

		undo();

		assertNoView(import_);
	}

	/**
	 * A relationship that is an element owned by the source (easy case).
	 */
	@NeedsUIEvents
	@Test
	public void addElementImportToPackage_undo_redo() {
		// Ensure canonical connections
		setCanonical(true, requireEditPart(root));

		ElementImport import_ = UMLFactory.eINSTANCE.createElementImport();
		import_.setImportedElement(yesno);
		add(types, import_, UMLPackage.Literals.NAMESPACE__ELEMENT_IMPORT);

		undo();
		redo();

		ConnectionEditPart editPart = (ConnectionEditPart) requireConnectionEditPart(import_);
		assertThat(editPart.getSource(), is((EditPart) requireEditPart(types)));
		assertThat(editPart.getTarget(), is((EditPart) requireEditPart(yesno)));
	}

	/**
	 * A relationship that is an element owned by neither source nor target
	 * and the construction of which doesn't alter either end (less easy case).
	 */
	@NeedsUIEvents
	@Test
	public void addDependencyToClass() {
		// Ensure canonical connections
		setCanonical(true, requireEditPart(root));
		setCanonical(true, requireEditPart(types_date));

		Dependency dependency = addDependency(bar, types_date);

		ConnectionEditPart editPart = (ConnectionEditPart) requireConnectionEditPart(dependency);
		assertThat(editPart.getSource(), is((EditPart) requireEditPart(bar)));
		assertThat(editPart.getTarget(), is((EditPart) requireEditPart(types_date)));
	}

	/**
	 * A relationship that is an element owned by neither source nor target
	 * and the construction of which doesn't alter either end (less easy case).
	 */
	@NeedsUIEvents
	@Test
	public void addDependencyToClass_undo() {
		// Ensure canonical connections
		setCanonical(true, requireEditPart(root));
		setCanonical(true, requireEditPart(types_date));

		Dependency dependency = addDependency(bar, types_date);

		undo();

		assertNoView(dependency);
	}

	/**
	 * A relationship that is an element owned by neither source nor target
	 * and the construction of which doesn't alter either end (less easy case).
	 */
	@NeedsUIEvents
	@Test
	public void addDependencyToClass_undo_redo() {
		// Ensure canonical connections
		setCanonical(true, requireEditPart(root));
		setCanonical(true, requireEditPart(types_date));

		Dependency dependency = addDependency(bar, types_date);

		undo();
		redo();

		ConnectionEditPart editPart = (ConnectionEditPart) requireConnectionEditPart(dependency);
		assertThat(editPart.getSource(), is((EditPart) requireEditPart(bar)));
		assertThat(editPart.getTarget(), is((EditPart) requireEditPart(types_date)));
	}

	/**
	 * A relationship that is an element owned by neither source nor target
	 * but the construction of which does alter the ends (middling easy case).
	 */
	@NeedsUIEvents
	@Test
	public void addAssociationToClass() {
		// Ensure canonical connections
		setCanonical(true, requireEditPart(root));

		Association association = addAssociation(super_, foo);

		ConnectionEditPart editPart = (ConnectionEditPart) requireConnectionEditPart(association);
		assertThat(editPart.getSource(), either(is((EditPart) requireEditPart(super_))).or(is((EditPart) requireEditPart(foo))));
		assertThat(editPart.getTarget(), either(is((EditPart) requireEditPart(foo))).or(is((EditPart) requireEditPart(super_))));
	}

	/**
	 * A relationship that is an element owned by neither source nor target
	 * but the construction of which does alter the ends (middling easy case).
	 */
	@NeedsUIEvents
	@Test
	public void addAssociationToClass_undo() {
		// Ensure canonical connections
		setCanonical(true, requireEditPart(root));

		Association association = addAssociation(super_, foo);

		undo();

		assertNoView(association);
	}

	/**
	 * A relationship that is an element owned by neither source nor target
	 * but the construction of which does alter the ends (middling easy case).
	 */
	@NeedsUIEvents
	@Test
	public void addAssociationToClass_undo_redo() {
		// Ensure canonical connections
		setCanonical(true, requireEditPart(root));

		Association association = addAssociation(super_, foo);

		undo();
		redo();

		ConnectionEditPart editPart = (ConnectionEditPart) requireConnectionEditPart(association);
		assertThat(editPart.getSource(), either(is((EditPart) requireEditPart(super_))).or(is((EditPart) requireEditPart(foo))));
		assertThat(editPart.getTarget(), either(is((EditPart) requireEditPart(foo))).or(is((EditPart) requireEditPart(super_))));
	}

	@NeedsUIEvents
	@Test
	public void removeGeneralizationFromClass() {
		remove(types_subfoo_foo);

		assertNoView(types_subfoo_foo);
	}

	@NeedsUIEvents
	@Test
	public void removeGeneralizationFromClass_undo() {
		// Ensure canonical connections
		setCanonical(true, requireEditPart(root));
		setCanonical(true, requireEditPart(types_subfoo));

		remove(types_subfoo_foo);

		undo();

		ConnectionEditPart editPart = (ConnectionEditPart) requireConnectionEditPart(types_subfoo_foo);
		assertThat(editPart.getSource(), is((EditPart) requireEditPart(types_subfoo)));
		assertThat(editPart.getTarget(), is((EditPart) requireEditPart(foo)));
	}

	@NeedsUIEvents
	@Test
	public void removeGeneralizationFromClass_undo_redo() {
		// Ensure canonical connections
		setCanonical(true, requireEditPart(root));
		setCanonical(true, requireEditPart(types_subfoo));

		remove(types_subfoo_foo);

		undo();
		redo();

		assertNoView(types_subfoo_foo);
	}


	//
	// Test framework
	//

	@Before
	public void getModelElements() {
		root = editor.getModel();

		foo = (org.eclipse.uml2.uml.Class) root.getOwnedType("Foo");
		foo_doit = foo.getOwnedOperation("doIt", null, null);
		bar = (org.eclipse.uml2.uml.Class) root.getOwnedType("Bar");
		super_ = (org.eclipse.uml2.uml.Class) root.getOwnedType("Super");
		yesno = (Enumeration) root.getOwnedType("YesNo");

		types = root.getNestedPackage("types");
		types_subfoo = (org.eclipse.uml2.uml.Class) types.getOwnedType("SubFoo");
		types_date = (DataType) types.getOwnedType("Date");

		types_subfoo_foo = types_subfoo.getGeneralization(foo);
	}

}
