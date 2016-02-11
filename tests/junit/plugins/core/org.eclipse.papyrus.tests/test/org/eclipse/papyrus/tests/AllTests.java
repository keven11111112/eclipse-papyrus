/*****************************************************************************
 * Copyright (c) 2010, 2016 CEA LIST, Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - bugs 402525, 323802, 431953, 433310, 434993
 *  Christian W. Damus - bugs 399859, 451230, 433206, 463156, 474610, 469188, 485220
 *
 *****************************************************************************/
package org.eclipse.papyrus.tests;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.junit.framework.runner.AllTestsRunner;
import org.eclipse.papyrus.junit.framework.runner.FragmentTestSuiteClass;
import org.eclipse.papyrus.junit.framework.runner.ITestSuiteClass;
import org.eclipse.papyrus.junit.framework.runner.PluginTestSuiteClass;
import org.eclipse.papyrus.junit.framework.runner.SuiteSpot;
import org.junit.runner.RunWith;


/**
 * Test class for all tests for Papyrus
 */
@SuppressWarnings("restriction")
@RunWith(AllTestsRunner.class)
public class AllTests {

	@SuiteSpot
	public static final List<ITestSuiteClass> suiteClasses;

	/** list of classes to launch */
	static {
		suiteClasses = new ArrayList<ITestSuiteClass>();

		/* **************** plugins *********************** */
		/* developper */
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.bundles.tests.AllTests.class));

		/* core */
		suiteClasses.add(new FragmentTestSuiteClass(org.eclipse.papyrus.infra.core.Activator.PLUGIN_ID, "org.eclipse.papyrus.infra.core.tests.AllTests"));
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.infra.core.clipboard.tests.AllTests.class));
		suiteClasses.add(new FragmentTestSuiteClass(org.eclipse.papyrus.infra.core.sasheditor.Activator.PLUGIN_ID, "org.eclipse.papyrus.infra.core.sasheditor.tests.AllTests"));
		suiteClasses.add(new FragmentTestSuiteClass("org.eclipse.papyrus.infra.core.sasheditor.di", "org.eclipse.papyrus.infra.core.sasheditor.di.tests.AllTests"));

		/* infra */
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.infra.tools.tests.AllTests.class));
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.infra.ui.tests.AllTests.class));
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.infra.services.edit.tests.suites.AllTests.class));
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.infra.services.edit.ui.tests.AllTests.class));
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.infra.services.labelprovider.tests.AllTests.class));
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.infra.services.semantic.tests.AllTests.class));
		suiteClasses.add(new FragmentTestSuiteClass(org.eclipse.papyrus.infra.emf.Activator.PLUGIN_ID, "org.eclipse.papyrus.infra.emf.tests.AllTests"));
		suiteClasses.add(new FragmentTestSuiteClass(org.eclipse.papyrus.infra.ui.internal.emf.Activator.PLUGIN_ID, "org.eclipse.papyrus.infra.ui.emf.tests.AllTests"));
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.infra.extendedtypes.tests.AllTests.class));
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.infra.extendedtypes.ui.tests.AllTests.class));
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.infra.elementtypesconfigurations.tests.AllTests.class));
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.infra.elementtypesconfigurations.ui.tests.AllTests.class));
		// suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.infra.services.openelement.tests.AllTests.class));
		suiteClasses.add(new FragmentTestSuiteClass(org.eclipse.papyrus.commands.Activator.PLUGIN_ID, "org.eclipse.papyrus.infra.gmfdiag.commands.tests.AllTests"));
		suiteClasses.add(new FragmentTestSuiteClass(org.eclipse.papyrus.infra.gmfdiag.common.Activator.ID, "org.eclipse.papyrus.infra.gmfdiag.common.tests.AllTests"));
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.infra.gmfdiag.canonical.tests.AllTests.class));
		suiteClasses.add(new FragmentTestSuiteClass(org.eclipse.papyrus.infra.emf.readonly.Activator.PLUGIN_ID, "org.eclipse.papyrus.infra.emf.readonly.tests.AllTests"));
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.infra.viewpoints.configuration.tests.AllTests.class));
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.infra.editor.welcome.tests.AllTests.class));
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.infra.gmfdiag.welcome.tests.AllTests.class));

		/* views */
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.views.modelexplorer.tests.AllTests.class));
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.customization.properties.tests.AllTests.class));

		/* integration */
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.editor.integration.tests.AllTests.class));

		// FIXME: Workaround for Bug 441246: Move the ResourceLoading tests after EditorReloadTest, since they are currently conflicting
		suiteClasses.add(new FragmentTestSuiteClass(org.eclipse.papyrus.infra.services.resourceloading.Activator.PLUGIN_ID, "org.eclipse.papyrus.infra.services.resourceloading.tests.AllTests"));

		/* search */
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.search.tests.suites.AllTests.class));

		/* css */
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.infra.gmfdiag.css.tests.tests.AllTests.class));

		/* menu */
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.infra.gmfdiag.menu.tests.tests.AllTests.class));

		/* control mode */
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.infra.services.controlmode.tests.AllTests.class));

		/* Diagram Assistants test suite */
		org.eclipse.papyrus.tests.diagramassistants.AllTests.appendTo(suiteClasses);

		if (System.getProperty("no.SysML.tests") == null) {
			// SysML tests
			suiteClasses.addAll(AllSysMLTests.suiteClasses);
		}

		/* Profile Drafter */
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.uml.profile.drafter.tests.AllTests.class));

		/* uml */
		suiteClasses.add(new FragmentTestSuiteClass(org.eclipse.papyrus.uml.service.types.Activator.PLUGIN_ID, "org.eclipse.papyrus.uml.service.types.tests.suites.AllTests"));
		suiteClasses.add(new FragmentTestSuiteClass(org.eclipse.papyrus.uml.service.types.internal.ui.Activator.PLUGIN_ID, "org.eclipse.papyrus.uml.service.types.ui.tests.suites.AllTests"));
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.uml.modelexplorer.tests.AllTests.class));
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.uml.diagram.dnd.tests.tests.AllTests.class));
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.uml.tools.tests.tests.AllTests.class));
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.uml.tools.utils.tests.tests.AllTests.class));
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.uml.diagram.stereotypeproperty.AllTests.class));
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.uml.diagram.wizards.AllTests.class));
		suiteClasses.add(new FragmentTestSuiteClass(org.eclipse.papyrus.uml.modelrepair.Activator.PLUGIN_ID, "org.eclipse.papyrus.uml.modelrepair.tests.AllTests"));
		suiteClasses.add(new FragmentTestSuiteClass(org.eclipse.papyrus.uml.profile.Activator.PLUGIN_ID, "org.eclipse.papyrus.uml.profile.tests.AllTests"));
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.uml.decoratormodel.tests.AllTests.class));
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.uml.decoratormodel.controlmode.tests.AllTests.class));
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.uml.validation.tests.AllTests.class));

		/* uml diagrams */
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.uml.diagram.common.tests.tests.AllTests.class));
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.uml.diagram.clazz.test.AllTests.class));
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.uml.diagram.activity.tests.AllTests.class));
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.uml.diagram.deployment.test.AllTests.class));
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.uml.diagram.component.test.AllTests.class));
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.uml.diagram.timing.tests.AllTests.class));
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.uml.diagram.usecase.tests.AllTests.class));
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.uml.diagram.composite.test.AllTests.class));
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.uml.diagram.statemachine.tests.AllTests.class));
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.uml.diagram.communication.tests.AllTests.class));
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.uml.diagram.profile.tests.AllTests.class));
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.uml.diagram.sequence.tests.AllTests.class));
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.uml.diagram.interactionoverview.tests.AllTests.class));
		//

		// nattable tests
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.infra.nattable.views.tests.tests.AllTests.class));
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.infra.nattable.common.tests.AllTests.class));
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.infra.nattable.model.editor.tests.tests.AllTests.class));
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.infra.nattable.model.tests.tests.AllTests.class));
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.infra.nattable.tests.tests.AllTests.class));

		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.uml.nattable.tests.tests.AllTests.class));
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.uml.nattable.generic.tests.tests.AllTests.class));
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.uml.nattable.clazz.config.tests.tests.AllTests.class));
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.uml.nattable.stereotype.display.tests.tests.AllTests.class));

		// uml textedit tests
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.uml.textedit.port.tests.suites.AllTests.class));
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.uml.textedit.property.tests.suites.AllTests.class));
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.uml.textedit.parameter.tests.suites.AllTests.class));
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.uml.textedit.valuespecification.tests.suites.AllTests.class));

		// Alf
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.uml.alf.tests.AllTests.class));

		// end
	}

}
