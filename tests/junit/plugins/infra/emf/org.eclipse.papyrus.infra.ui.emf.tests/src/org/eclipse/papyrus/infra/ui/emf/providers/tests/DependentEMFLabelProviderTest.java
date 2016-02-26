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

package org.eclipse.papyrus.infra.ui.emf.providers.tests;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.papyrus.infra.ui.emf.providers.DependentEMFLabelProvider;
import org.eclipse.papyrus.junit.utils.rules.HouseKeeper;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLFactory;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

/**
 * Tests for the {@link DependentEMFLabelProvider} class.
 */
public class DependentEMFLabelProviderTest {

	@Rule
	public final HouseKeeper houseKeeper = new HouseKeeper();

	private ILabelProvider fixture;

	private Package imported;
	private Package importing;

	@Test
	public void getText() {
		assertThat(fixture.getText(imported), is("<Package> foo (imported by <Package> bar)"));
	}

	@Test
	public void notificationsOnDependentWhenItChanges() {
		boolean[] gotEvent = { false };
		ILabelProviderListener listener = event -> gotEvent[0] = gotEvent[0] || (event.getElement() == imported);
		fixture.addListener(listener);

		fixture.getText(imported); // Access it once to hook up the item adapters
		gotEvent[0] = false;

		// Change the name of the package, itself
		imported.setName("quux");

		assertThat("Label provider did not notify", gotEvent[0], is(true));
	}

	@Test
	public void notificationsOnDependentWhenDependencyChanges() {
		boolean[] gotEvent = { false };
		ILabelProviderListener listener = event -> gotEvent[0] = gotEvent[0] || (event.getElement() == imported);
		fixture.addListener(listener);

		fixture.getText(imported); // Access it once to hook up the item adapters
		gotEvent[0] = false;

		// Change the name of the package that the label of our dependent package depends on
		importing.setName("quux");

		assertThat("Label provider did not notify", gotEvent[0], is(true));
	}

	//
	// Test framework
	//

	@Before
	public void createFixture() {
		fixture = houseKeeper.cleanUpLater(new ImportedPackageLabelProvider());

		imported = UMLFactory.eINSTANCE.createPackage();
		imported.setName("foo");

		importing = UMLFactory.eINSTANCE.createPackage();
		importing.setName("bar");

		importing.createPackageImport(imported);
	}

	// For testing purposes, a label provider for packages that decorates the label
	// with the label of one package that imports it (if any)
	private class ImportedPackageLabelProvider extends DependentEMFLabelProvider {
		@Override
		protected String getText(EObject element) {
			// Default
			String result = super.getText(element);

			if (element instanceof Package) {
				Package package_ = (Package) element;
				Package importer = getImportingPackage(package_);
				if (importer != null) {
					// Listen for changes in the dependency to notify on the dependent
					subscribe(importer, package_);

					result = String.format("%s (imported by %s)", result, getText(importer));
				}
			}

			return result;
		}

		private Package getImportingPackage(Package package_) {
			Package result = null;

			// Cheat!
			if (importing.getPackageImport(package_) != null) {
				result = importing;
			}

			return result;
		}
	}
}
