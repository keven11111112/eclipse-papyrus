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

package org.eclipse.papyrus.aof.sync.emf.tests;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assume.assumeThat;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.aof.sync.From;
import org.eclipse.papyrus.aof.sync.IMapping;
import org.eclipse.papyrus.aof.sync.To;
import org.eclipse.papyrus.aof.sync.emf.EMFMappingModule;
import org.eclipse.papyrus.aof.sync.emf.syncmapping.MappingModel;
import org.eclipse.papyrus.aof.sync.tests.runners.GuiceRunner;
import org.eclipse.papyrus.aof.sync.tests.runners.InjectWith;
import org.eclipse.papyrus.junit.utils.rules.HouseKeeper;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;

/**
 * Test cases for the {@link EMFMappingModule} class.
 */
@RunWith(GuiceRunner.class)
@InjectWith({ TestFixtureModule.class })
public class EMFMappingModuleTest {
	@Rule
	public final HouseKeeper housekeeper = new HouseKeeper();

	@Inject
	protected EcoreFactory ecore;

	@Inject
	protected MappingModel mappingModel;

	@Inject
	protected IMapping<EPackage, EPackage> mapping;

	@Inject
	protected TransactionalEditingDomain domain;

	@Inject
	@From
	protected EPackage from;

	@Inject
	@To
	protected EPackage to;

	@Inject
	@From
	protected EClass fromClass;

	@Inject
	@To
	protected EClass toClass;

	public EMFMappingModuleTest() {
		super();
	}

	@Test
	public void createMapping() {
		executeMapping();

		assumeThat(toClass.getName(), not("Foo"));

		set(fromClass, EcorePackage.Literals.ENAMED_ELEMENT__NAME, "Foo");

		assertThat("Mapping is not in effect", toClass.getName(), is("Foo"));
	}

	@Test
	public void undoMapping() {
		executeMapping();
		set(fromClass, EcorePackage.Literals.ENAMED_ELEMENT__NAME, "Foo");
		assumeThat("Mapping is not in effect", toClass.getName(), is("Foo"));

		// Undo exercise of the mapping
		undo();

		assertThat(toClass.getName(), is("From"));

		// Undo establishment of the mapping
		undo();

		assertThat(toClass.getName(), is("To"));

		// The mapping has been uninstalled
		set(fromClass, EcorePackage.Literals.ENAMED_ELEMENT__NAME, "Bar");
		assertThat("Mapping still in effect", toClass.getName(), is("To"));
	}

	@Test
	public void redoMapping() {
		executeMapping();
		set(fromClass, EcorePackage.Literals.ENAMED_ELEMENT__NAME, "Foo");
		assumeThat("Mapping is not in effect", toClass.getName(), is("Foo"));

		// Undo exercise of the mapping
		undo();

		assumeThat(toClass.getName(), is("From"));

		// Undo establishment of the mapping
		undo();

		assumeThat(toClass.getName(), is("To"));

		// Redo establishment of the mapping
		redo();

		assertThat(toClass.getName(), is("From"));

		set(fromClass, EcorePackage.Literals.ENAMED_ELEMENT__NAME, "Bar");
		assertThat("Mapping is not in effect", toClass.getName(), is("Bar"));
	}

	//
	// Test framework
	//

	protected void executeMapping() {
		domain.getCommandStack().execute(new RecordingCommand(domain, "Do Mapping") {

			@Override
			protected void doExecute() {
				IMapping.Instance<EPackage, EPackage> instance = mapping.map(from, to);
				mappingModel.getInstances().add(instance);
			}
		});
	}

	protected void execute(Command command) {
		domain.getCommandStack().execute(command);
	}

	protected void set(EObject object, EStructuralFeature feature, Object newValue) {
		execute(SetCommand.create(domain, object, feature, newValue));
	}

	protected void undo() {
		domain.getCommandStack().undo();
	}

	protected void redo() {
		domain.getCommandStack().redo();
	}
}
