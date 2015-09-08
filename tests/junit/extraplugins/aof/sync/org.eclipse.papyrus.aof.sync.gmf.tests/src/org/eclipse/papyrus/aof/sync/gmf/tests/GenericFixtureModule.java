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

package org.eclipse.papyrus.aof.sync.gmf.tests;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.MeasurementUnit;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.Size;
import org.eclipse.papyrus.aof.sync.gmf.DiagramMappingModule;
import org.eclipse.papyrus.aof.sync.internal.CustomInjectionModule;
import org.eclipse.papyrus.aof.sync.tests.AbstractTest.From;
import org.eclipse.papyrus.aof.sync.tests.AbstractTest.To;
import org.eclipse.papyrus.aof.sync.tests.runners.TestScoped;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

/**
 * Guice configuration of test dependencies additional to those provided
 * by the {@link DiagramMappingModule}.
 */
public class GenericFixtureModule extends AbstractModule {

	public GenericFixtureModule() {
		super();
	}

	@Override
	protected void configure() {
		// Set up custom injection
		binder().install(new CustomInjectionModule());

		// The rest is all in the provider methods
	}

	@Provides
	@From
	@TestScoped
	public Location provideFromLocation() {
		return NotationFactory.eINSTANCE.createLocation();
	}

	@Provides
	@To
	@TestScoped
	public Location provideToLocation() {
		return NotationFactory.eINSTANCE.createLocation();
	}

	@Provides
	@From
	@TestScoped
	public Size provideFromSize() {
		return NotationFactory.eINSTANCE.createSize();
	}

	@Provides
	@To
	@TestScoped
	public Size provideToSize() {
		return NotationFactory.eINSTANCE.createSize();
	}

	@Provides
	@From
	@TestScoped
	public Node provideFromNode() {
		return createNode("2008", EcorePackage.Literals.EDATA_TYPE);
	}

	@Provides
	@To
	@TestScoped
	public Node provideToNode() {
		return createNode("2008", EcorePackage.Literals.EDATA_TYPE);
	}

	private Node createNode(String type, EObject element) {
		Node result = NotationFactory.eINSTANCE.createNode();

		result.setType(type);
		result.setElement(element);
		result.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());

		return result;
	}

	@Provides
	@From
	@TestScoped
	public Edge provideFromEdge() {
		return provideEdge();
	}

	@Provides
	@To
	@TestScoped
	public Edge provideToEdge() {
		return provideEdge();
	}

	@SuppressWarnings("unchecked")
	Edge provideEdge() {
		Diagram diagram = createDiagram();

		Edge result = createEdge("4001", EcorePackage.Literals.ECLASS__ESUPER_TYPES);

		diagram.getPersistedEdges().add(result);

		Node source = createNode("2008", EcorePackage.Literals.EREFERENCE);
		diagram.getPersistedChildren().add(source);
		result.setSource(source);

		Node target = createNode("2008", EcorePackage.Literals.ESTRUCTURAL_FEATURE);
		diagram.getPersistedChildren().add(target);
		result.setTarget(target);

		return result;
	}

	private Edge createEdge(String type, EObject element) {
		Edge result = NotationFactory.eINSTANCE.createEdge();

		result.setType(type);
		result.setBendpoints(NotationFactory.eINSTANCE.createRelativeBendpoints());
		result.setSourceAnchor(NotationFactory.eINSTANCE.createIdentityAnchor());
		result.setTargetAnchor(NotationFactory.eINSTANCE.createIdentityAnchor());
		result.setElement(element);

		return result;
	}

	@Provides
	@From
	@TestScoped
	public Diagram provideFromDiagram() {
		return provideFromEdge().getDiagram();
	}

	@Provides
	@To
	@TestScoped
	public Diagram provideToDiagram() {
		return provideToEdge().getDiagram();
	}

	private Diagram createDiagram() {
		Diagram result = NotationFactory.eINSTANCE.createDiagram();

		result.setType("TestEcoreDiagram");
		result.setElement(EcorePackage.eINSTANCE);
		result.setMeasurementUnit(MeasurementUnit.HIMETRIC_LITERAL);
		result.setName("test");

		return result;
	}
}
