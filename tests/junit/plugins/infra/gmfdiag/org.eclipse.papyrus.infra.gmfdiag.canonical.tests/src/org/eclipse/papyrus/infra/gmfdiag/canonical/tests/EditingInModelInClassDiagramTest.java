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

import static org.eclipse.papyrus.junit.framework.runner.ScenarioRunner.verificationPoint;
import static org.hamcrest.CoreMatchers.either;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.eclipse.emf.edit.command.MoveCommand;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.papyrus.junit.framework.runner.Scenario;
import org.eclipse.papyrus.junit.framework.runner.ScenarioRunner;
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
import org.junit.runner.RunWith;

/**
 * Tests various add/delete/destroy scenarios on elements in the semantic model, with undo and redo.
 */
@PluginResource("models/classdiagram_canonical.di")
@ActiveDiagram("canonical")
@RunWith(ScenarioRunner.class)
public class EditingInModelInClassDiagramTest extends AbstractCanonicalTest {
	private org.eclipse.uml2.uml.Package root;

	private org.eclipse.uml2.uml.Class foo;
	private Property foo_ok;
	private Property foo_bar;
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

	@Scenario({ "execute", "undo", "redo" })
	public void addPropertyToClass() {
		Property property = UMLFactory.eINSTANCE.createProperty();
		property.setName("newProperty");
		property.setType(yesno);
		add(bar, property, UMLPackage.Literals.STRUCTURED_CLASSIFIER__OWNED_ATTRIBUTE);

		EditPart editPart = requireEditPart(property);

		if (verificationPoint()) {
			assertThat(getClassAttributeCompartment(requireEditPart(bar)), is(editPart.getParent()));
		}

		undo();

		if (verificationPoint()) {
			assertNoView(property);
		}

		redo();

		if (verificationPoint()) {
			editPart = requireEditPart(property);
			assertThat(getClassAttributeCompartment(requireEditPart(bar)), is(editPart.getParent()));
		}
	}

	@Scenario({ "execute", "undo", "redo" })
	public void removeOperationFromClass() {
		remove(foo_doit);

		if (verificationPoint()) {
			assertNoView(foo_doit);
		}

		undo();

		if (verificationPoint()) {
			EditPart editPart = requireEditPart(foo_doit);
			assertThat(getClassOperationCompartment(requireEditPart(foo)), is(editPart.getParent()));
		}

		redo();

		if (verificationPoint()) {
			assertNoView(foo_doit);
		}
	}

	@Scenario({ "execute", "undo", "redo" })
	public void addInterfaceToPackage() {
		Interface interface_ = UMLFactory.eINSTANCE.createInterface();
		interface_.setName("IClaudius");
		add(types, interface_, UMLPackage.Literals.PACKAGE__PACKAGED_ELEMENT);

		if (verificationPoint()) {
			EditPart editPart = requireEditPart(interface_);
			assertThat(getPackageContentsCompartment(requireEditPart(types)), is(editPart.getParent()));
		}

		undo();

		if (verificationPoint()) {
			assertNoView(interface_);
		}

		redo();

		if (verificationPoint()) {
			EditPart editPart = requireEditPart(interface_);
			assertThat(getPackageContentsCompartment(requireEditPart(types)), is(editPart.getParent()));
		}
	}

	@Scenario({ "execute", "undo", "redo" })
	public void removeClassFromPackage() {
		remove(types_subfoo);

		if (verificationPoint()) {
			assertNoView(types_subfoo);
		}

		undo();

		if (verificationPoint()) {
			EditPart editPart = requireEditPart(types_subfoo);
			assertThat(getPackageContentsCompartment(requireEditPart(types)), is(editPart.getParent()));
		}

		redo();

		if (verificationPoint()) {
			assertNoView(types_subfoo);
		}
	}

	/**
	 * A relationship that is an element owned by the source (easy case).
	 */
	@NeedsUIEvents
	@Scenario({ "execute", "undo", "redo" })
	public void addElementImportToPackage() {
		// Ensure canonical connections
		setCanonical(true, requireEditPart(root));

		ElementImport import_ = UMLFactory.eINSTANCE.createElementImport();
		import_.setImportedElement(yesno);
		add(types, import_, UMLPackage.Literals.NAMESPACE__ELEMENT_IMPORT);

		if (verificationPoint()) {
			ConnectionEditPart editPart = (ConnectionEditPart) requireConnectionEditPart(import_);
			assertThat(editPart.getSource(), is((EditPart) requireEditPart(types)));
			assertThat(editPart.getTarget(), is((EditPart) requireEditPart(yesno)));
		}

		undo();

		if (verificationPoint()) {
			assertNoView(import_);
		}

		redo();

		if (verificationPoint()) {
			ConnectionEditPart editPart = (ConnectionEditPart) requireConnectionEditPart(import_);
			assertThat(editPart.getSource(), is((EditPart) requireEditPart(types)));
			assertThat(editPart.getTarget(), is((EditPart) requireEditPart(yesno)));
		}
	}

	/**
	 * A relationship that is an element owned by neither source nor target
	 * and the construction of which doesn't alter either end (less easy case).
	 */
	@NeedsUIEvents
	@Scenario({ "execute", "undo", "redo" })
	public void addDependencyToClass() {
		// Ensure canonical connections
		setCanonical(true, requireEditPart(root));
		setCanonical(true, requireEditPart(types_date));

		Dependency dependency = addDependency(bar, types_date);

		if (verificationPoint()) {
			ConnectionEditPart editPart = (ConnectionEditPart) requireConnectionEditPart(dependency);
			assertThat(editPart.getSource(), is((EditPart) requireEditPart(bar)));
			assertThat(editPart.getTarget(), is((EditPart) requireEditPart(types_date)));
		}

		undo();

		if (verificationPoint()) {
			assertNoView(dependency);
		}

		redo();

		if (verificationPoint()) {
			ConnectionEditPart editPart = (ConnectionEditPart) requireConnectionEditPart(dependency);
			assertThat(editPart.getSource(), is((EditPart) requireEditPart(bar)));
			assertThat(editPart.getTarget(), is((EditPart) requireEditPart(types_date)));
		}
	}

	/**
	 * A relationship that is an element owned by neither source nor target
	 * but the construction of which does alter the ends (middling easy case).
	 */
	@NeedsUIEvents
	@Scenario({ "execute", "undo", "redo" })
	public void addAssociationToClass() {
		// Ensure canonical connections
		setCanonical(true, requireEditPart(root));

		Association association = addAssociation(super_, foo);

		if (verificationPoint()) {
			ConnectionEditPart editPart = (ConnectionEditPart) requireConnectionEditPart(association);
			assertThat(editPart.getSource(), either(is((EditPart) requireEditPart(super_))).or(is((EditPart) requireEditPart(foo))));
			assertThat(editPart.getTarget(), either(is((EditPart) requireEditPart(foo))).or(is((EditPart) requireEditPart(super_))));
		}

		undo();

		if (verificationPoint()) {
			assertNoView(association);
		}

		redo();

		if (verificationPoint()) {
			ConnectionEditPart editPart = (ConnectionEditPart) requireConnectionEditPart(association);
			assertThat(editPart.getSource(), either(is((EditPart) requireEditPart(super_))).or(is((EditPart) requireEditPart(foo))));
			assertThat(editPart.getTarget(), either(is((EditPart) requireEditPart(foo))).or(is((EditPart) requireEditPart(super_))));
		}
	}

	@NeedsUIEvents
	@Scenario({ "execute", "undo", "redo" })
	public void removeGeneralizationFromClass() {
		// Ensure canonical connections
		setCanonical(true, requireEditPart(root));
		setCanonical(true, requireEditPart(types_subfoo));
		remove(types_subfoo_foo);

		if (verificationPoint()) {
			assertNoView(types_subfoo_foo);
		}

		undo();

		if (verificationPoint()) {
			ConnectionEditPart editPart = (ConnectionEditPart) requireConnectionEditPart(types_subfoo_foo);
			assertThat(editPart.getSource(), is((EditPart) requireEditPart(types_subfoo)));
			assertThat(editPart.getTarget(), is((EditPart) requireEditPart(foo)));
		}

		redo();

		if (verificationPoint()) {
			assertNoView(types_subfoo_foo);
		}
	}

	@Scenario({ "execute", "undo", "redo" })
	public void reorderPropertiesInClass_bug420549() {
		IGraphicalEditPart attributes = getClassAttributeCompartment(requireEditPart(foo));

		// Move 'bar' ahead of 'ok'
		execute(MoveCommand.create(editor.getEditingDomain(), foo, UMLPackage.Literals.STRUCTURED_CLASSIFIER__OWNED_ATTRIBUTE, foo_bar, 0));

		if (verificationPoint()) {
			IGraphicalEditPart okEditPart = getEditPart(foo_ok, attributes);
			IGraphicalEditPart barEditPart = getEditPart(foo_bar, attributes);
			assertThat(attributes.getChildren().indexOf(barEditPart), is(0));
			assertThat(attributes.getChildren().indexOf(okEditPart), is(1));
		}

		undo();

		if (verificationPoint()) {
			IGraphicalEditPart okEditPart = getEditPart(foo_ok, attributes);
			IGraphicalEditPart barEditPart = getEditPart(foo_bar, attributes);
			assertThat(attributes.getChildren().indexOf(barEditPart), is(1));
			assertThat(attributes.getChildren().indexOf(okEditPart), is(0));
		}

		redo();

		if (verificationPoint()) {
			IGraphicalEditPart okEditPart = getEditPart(foo_ok, attributes);
			IGraphicalEditPart barEditPart = getEditPart(foo_bar, attributes);
			assertThat(attributes.getChildren().indexOf(barEditPart), is(0));
			assertThat(attributes.getChildren().indexOf(okEditPart), is(1));
		}
	}


	//
	// Test framework
	//

	@Before
	public void getModelElements() {
		root = editor.getModel();

		foo = (org.eclipse.uml2.uml.Class) root.getOwnedType("Foo");
		foo_ok = foo.getOwnedAttribute("ok", null);
		foo_bar = foo.getOwnedAttribute("bar", null);
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
