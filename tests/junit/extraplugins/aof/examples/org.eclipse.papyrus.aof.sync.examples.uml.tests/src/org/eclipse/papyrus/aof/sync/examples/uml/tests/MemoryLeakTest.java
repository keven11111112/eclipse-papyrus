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

package org.eclipse.papyrus.aof.sync.examples.uml.tests;

import static org.eclipse.papyrus.infra.tools.util.TypeUtils.as;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assume.assumeThat;

import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.papyrus.aof.sync.tests.AbstractBaseMappingTest;
import org.eclipse.papyrus.aof.sync.tests.runners.InjectWith;
import org.eclipse.papyrus.junit.framework.classification.rules.MemoryLeakRule;
import org.eclipse.papyrus.junit.utils.rules.JavaResource;
import org.eclipse.papyrus.junit.utils.rules.ResourceSetFixture;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.FinalState;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.Vertex;
import org.junit.Rule;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * Test cases for verification of complete memory clean-up of models
 * that employ AOF-based synchronization of UML.
 */
@InjectWith(TestModelModule.class)
@JavaResource("capsules-with-machines.uml")
public class MemoryLeakTest extends AbstractBaseMappingTest<Class, Class> {

	// This must be the outermost rule!
	@Rule
	public final MemoryLeakRule memory = new MemoryLeakRule();

	@Rule
	public final ResourceSetFixture rset = new ResourceSetFixture();

	@Inject
	private UMLFactory uml;

	@Test
	public void map() {
		memory.add(getFrom());
		memory.add(getTo());

		memory.add(mapped.getLeft());
		memory.add(mapped.getRight());
		memory.add(mapped);
	}

	@Test
	public void addVertexAndTransitionToParent() {
		StateMachine parent = as(getFrom().getClassifierBehavior(), StateMachine.class);
		assumeThat(parent, notNullValue());
		final Region parentRegion = parent.getRegions().get(0);
		final State parentOpen = as(parentRegion.getSubvertex("open"), State.class);
		memory.add(parentOpen);

		StateMachine child = as(getTo().getClassifierBehavior(), StateMachine.class);
		memory.add(child);

		assumeThat(child.getRegions().size(), is(1));
		Region region = child.getRegions().get(0);
		final State open = as(region.getSubvertex("open"), State.class);
		memory.add(open);

		FinalState parentEnd = uml.createFinalState();
		parentEnd.setName("end");
		memory.add(parentEnd);
		rset.execute(AddCommand.create(rset.getEditingDomain(), parentRegion, UMLPackage.Literals.REGION__SUBVERTEX, parentEnd));

		Vertex end = region.getSubvertex("end");
		memory.add(end);

		// Create a transition by first adding it to its region and then
		// setting its source and target vertices
		Transition parentTransition = uml.createTransition();
		parentTransition.setName("finish");
		memory.add(parentTransition);
		rset.execute(
				AddCommand.create(rset.getEditingDomain(), parentRegion, UMLPackage.Literals.REGION__TRANSITION, parentTransition).chain(
						SetCommand.create(rset.getEditingDomain(), parentTransition, UMLPackage.Literals.TRANSITION__SOURCE, parentOpen).chain(
								SetCommand.create(rset.getEditingDomain(), parentTransition, UMLPackage.Literals.TRANSITION__TARGET, parentEnd))));

		Transition transition = region.getTransition("finish");
		memory.add(transition);
	}

}
