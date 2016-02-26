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

package org.eclipse.papyrus.infra.nattable.tests.tests;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assume.assumeThat;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.infra.nattable.model.nattable.NattableFactory;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.provider.TableLabelProvider;
import org.eclipse.papyrus.infra.viewpoints.configuration.ConfigurationFactory;
import org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusTable;
import org.eclipse.papyrus.junit.utils.rules.HouseKeeper;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLFactory;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

/**
 * Tests for the {@link TableLabelProvider} class.
 */
public class TableLabelProviderTest {

	@Rule
	public final HouseKeeper houseKeeper = new HouseKeeper();

	private ILabelProvider fixture;

	private Package package_;
	private PapyrusTable proto;
	private Table table;

	@Test
	public void getText_namedTable() {
		assertThat(fixture.getText(table), is("classes"));
	}

	@Test
	public void getText_unnamedTable() {
		table.setName(null);
		assertThat(fixture.getText(table), is("(Test Table of <Package> foo)"));
	}

	@Test
	public void getText_unnamedTableChangeContextName() {
		table.setName(null);
		assumeThat(fixture.getText(table), is("(Test Table of <Package> foo)"));
		package_.setName("bar");
		assumeThat(fixture.getText(table), is("(Test Table of <Package> bar)"));
	}

	@Test
	public void getText_namedTableNotifications() {
		boolean[] gotEvent = { false };
		ILabelProviderListener listener = event -> gotEvent[0] = gotEvent[0] || (event.getElement() == table);
		fixture.addListener(listener);

		fixture.getText(table); // Access it once to hook up the item adapters
		gotEvent[0] = false;

		table.setName("new name");

		assertThat("Label provider did not notify", gotEvent[0], is(true));
	}

	@Test
	public void getText_unnamedTableNotifications() {
		table.setName(null);

		boolean[] gotEvent = { false };
		ILabelProviderListener listener = event -> gotEvent[0] = gotEvent[0] || (event.getElement() == table);
		fixture.addListener(listener);

		fixture.getText(table); // Access it once to hook up the item adapters
		gotEvent[0] = false;

		package_.setName("bar");

		assertThat("Label provider did not notify", gotEvent[0], is(true));
	}

	@Test
	public void getText_selectionOfMultipleTables() {
		StructuredSelection selection = new StructuredSelection(new Object[] { table, table });

		assertThat(fixture.getText(selection), is("classes, classes"));
	}

	//
	// Test framework
	//

	@Before
	public void createFixture() {
		fixture = houseKeeper.cleanUpLater(new TableLabelProvider());

		package_ = UMLFactory.eINSTANCE.createPackage();
		package_.setName("foo");

		proto = ConfigurationFactory.eINSTANCE.createPapyrusTable();
		proto.setName("Test Table");
		proto.setImplementationID("org.eclipse.papyrus.infra.nattable.tests.TestTable");
		proto.setConfiguration("TestTable");

		table = NattableFactory.eINSTANCE.createTable();
		table.setName("classes");
		table.setPrototype(proto);
		table.setContext(package_);
	}

}
