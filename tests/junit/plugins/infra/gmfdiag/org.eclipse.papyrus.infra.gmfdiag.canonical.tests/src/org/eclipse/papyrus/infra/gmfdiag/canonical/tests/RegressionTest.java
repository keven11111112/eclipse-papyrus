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

import org.eclipse.papyrus.junit.framework.runner.Scenario;
import org.eclipse.papyrus.junit.framework.runner.ScenarioRunner;
import org.eclipse.papyrus.junit.utils.rules.ActiveDiagram;
import org.eclipse.papyrus.junit.utils.rules.PluginResource;
import org.eclipse.uml2.uml.Constraint;
import org.junit.runner.RunWith;

/**
 * Specific regression tests for generic canonical model-view synchronization bugs.
 */
@ActiveDiagram("classes")
@RunWith(ScenarioRunner.class)
public class RegressionTest extends AbstractCanonicalTest {

	public RegressionTest() {
		super();
	}

	@PluginResource("models/bugs/472155.di")
	@Scenario({ "initial", "synch", "undo", "redo" })
	public void referenceConnectionNotDeleted_bug472155() {
		org.eclipse.uml2.uml.Class class1 = (org.eclipse.uml2.uml.Class) editor.getModel().getOwnedType("Class1");
		Constraint constraint = class1.getOwnedRule("Constraint1");

		if (verificationPoint()) {
			requireEdge(requireView(class1), requireView(constraint));
		}

		// We know from previous assertion that there's an edit part here
		setCanonical(true, getEditPart(class1));

		if (verificationPoint()) {
			// Still have the edge
			requireEdge(requireView(class1), requireView(constraint));
		}

		undo();

		if (verificationPoint()) {
			// Still have the edge
			requireEdge(requireView(class1), requireView(constraint));
		}

		redo();

		if (verificationPoint()) {
			// Still have the edge
			requireEdge(requireView(class1), requireView(constraint));
		}
	}

}
