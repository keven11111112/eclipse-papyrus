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

package org.eclipse.papyrus.infra.gmfdiag.welcome.tests;

import static org.hamcrest.CoreMatchers.anything;
import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.ListDiffEntry;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.infra.editor.welcome.tests.AbstractWelcomePageTest;
import org.eclipse.papyrus.infra.gmfdiag.welcome.internal.modelelements.DiagramObservable;
import org.eclipse.papyrus.infra.gmfdiag.welcome.internal.modelelements.WelcomeModelElement;
import org.eclipse.papyrus.infra.gmfdiag.welcome.internal.modelelements.WelcomeModelElementFactory;
import org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusDiagram;
import org.eclipse.papyrus.infra.viewpoints.policy.PolicyChecker;
import org.eclipse.papyrus.infra.viewpoints.policy.ViewPrototype;
import org.eclipse.papyrus.junit.utils.rules.PluginResource;
import org.eclipse.uml2.uml.NamedElement;
import org.junit.Before;
import org.junit.Test;

/**
 * Test cases for the {@link WelcomeModelElement} and its properties.
 */
@PluginResource(value = "resources/many_diagrams.di", bundle = "org.eclipse.papyrus.infra.editor.welcome.tests")
public class WelcomeModelElementTest extends AbstractWelcomePageTest {

	private WelcomeModelElement fixture;

	public WelcomeModelElementTest() {
		super();
	}

	@Test
	public void diagramsProperty() {
		IObservableList<DiagramObservable> diagrams = getDiagrams();

		assertThat(diagrams.size(), is(4));
		assertThat(diagrams, hasItem(anything()));

		List<String> diagramNames = diagrams.stream()
				.map(DiagramObservable::getDiagram)
				.map(IObservableValue::getValue)
				.map(Diagram::getName)
				.collect(Collectors.toList());
		assertThat(diagramNames, both(hasItem("classes")).and(hasItem("packages"))
				.and(hasItem("use cases")).and(hasItem("components")));

		List<String> contextNames = diagrams.stream()
				.map(DiagramObservable::getContext)
				.map(IObservableValue::getValue)
				.map(NamedElement.class::cast)
				.map(NamedElement::getName)
				.collect(Collectors.toList());
		assertThat(contextNames, is(Collections.nCopies(4, "model")));
	}

	@Test
	public void deleteDiagram() {
		IObservableList<DiagramObservable> diagrams = getDiagrams();

		DiagramObservable toBeDeleted = getDiagram(diagrams, "use cases");

		boolean[] deleted = { false };
		diagrams.addListChangeListener(event -> {
			for (ListDiffEntry<? extends DiagramObservable> next : event.diff.getDifferences()) {
				if (!next.isAddition() && (next.getElement() == toBeDeleted)) {
					deleted[0] = true;
				}
			}
		});

		editor.execute(new RecordingCommand(editor.getEditingDomain(), "Delete Diagram") {

			@Override
			protected void doExecute() {
				EcoreUtil.delete(toBeDeleted.getDiagram().getValue(), true);
			}
		});

		assertThat("List did not notify", deleted[0], is(true));
		assertThat(diagrams.size(), is(3));
		assertThat(diagrams, not(hasItem(toBeDeleted)));
	}

	@Test
	public void createDiagram() {
		IObservableList<DiagramObservable> diagrams = getDiagrams();

		DiagramObservable[] created = { null };

		diagrams.addListChangeListener(event -> {
			for (ListDiffEntry<? extends DiagramObservable> next : event.diff.getDifferences()) {
				if (next.isAddition() && "CreatedInTest".equals(next.getElement().getDiagram().getValue().getName())) {
					created[0] = next.getElement();
				}
			}
		});

		editor.execute(new RecordingCommand(editor.getEditingDomain(), "Delete Diagram") {

			@Override
			protected void doExecute() {
				ViewPrototype prototype = PolicyChecker.getCurrent().getPrototypesFor(editor.getModel()).stream()
						.filter(proto -> proto.getConfiguration() instanceof PapyrusDiagram)
						.findAny().get();
				prototype.instantiateOn(editor.getModel(), "CreatedInTest");
			}
		});

		assertThat("List did not notify", created[0], notNullValue());
		assertThat(diagrams.size(), is(5));
		assertThat(diagrams, hasItem(created[0]));
	}

	@Test
	public void isEditable() {
		assertThat(fixture.isEditable("diagrams"), is(true));
		assertThat(fixture.isEditable("garbage"), is(false));
	}

	//
	// Test framework
	//

	@Before
	public void createFixture() {
		fixture = (WelcomeModelElement) new WelcomeModelElementFactory().createFromSource(
				requireWelcome(), null); // The data-context isn't used by the factory
	}

	IObservableList<DiagramObservable> getDiagrams() {
		@SuppressWarnings("unchecked")
		IObservableList<DiagramObservable> result = (IObservableList<DiagramObservable>) fixture.getObservable("diagrams");
		return result;
	}

	DiagramObservable getDiagram(Collection<? extends DiagramObservable> diagrams, String name) {
		return diagrams.stream()
				.filter(d -> name.equals(d.getDiagram().getValue().getName()))
				.findFirst().get();
	}
}
