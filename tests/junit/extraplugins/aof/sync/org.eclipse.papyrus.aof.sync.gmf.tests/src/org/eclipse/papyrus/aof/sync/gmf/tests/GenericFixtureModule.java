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
import org.eclipse.gmf.runtime.notation.FontStyle;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.MeasurementUnit;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.Size;
import org.eclipse.gmf.runtime.notation.Style;
import org.eclipse.gmf.runtime.notation.impl.NotationFactoryImpl;
import org.eclipse.papyrus.aof.sync.From;
import org.eclipse.papyrus.aof.sync.To;
import org.eclipse.papyrus.aof.sync.gmf.DiagramMappingModule;
import org.eclipse.papyrus.aof.sync.internal.CustomInjectionModule;
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
	public NotationFactory provideNotationFactory() {
		// Don't use the CSS factory
		return new NotationFactoryImpl();
	}

	@Provides
	@From
	@TestScoped
	public Location provideFromLocation(NotationFactory notation) {
		return notation.createLocation();
	}

	@Provides
	@To
	@TestScoped
	public Location provideToLocation(NotationFactory notation) {
		return notation.createLocation();
	}

	@Provides
	@From
	@TestScoped
	public Size provideFromSize(NotationFactory notation) {
		return notation.createSize();
	}

	@Provides
	@To
	@TestScoped
	public Size provideToSize(NotationFactory notation) {
		return notation.createSize();
	}

	@Provides
	@From
	@TestScoped
	public Node provideFromNode(NotationFactory notation) {
		Shape result = createNode(notation, "2008", EcorePackage.Literals.EDATA_TYPE);

		result.setFontName("Helvetica");
		result.setFontHeight(12);

		return result;
	}

	@Provides
	@To
	@TestScoped
	public Node provideToNode(NotationFactory notation) {
		return createNode(notation, "2008", EcorePackage.Literals.EDATA_TYPE);
	}

	private Shape createNode(NotationFactory notation, String type, EObject element) {
		Shape result = notation.createShape();

		result.setType(type);
		result.setElement(element);
		result.setLayoutConstraint(notation.createBounds());

		return result;
	}

	@Provides
	@From
	@TestScoped
	public Edge provideFromEdge(NotationFactory notation) {
		return provideEdge(notation);
	}

	@Provides
	@To
	@TestScoped
	public Edge provideToEdge(NotationFactory notation) {
		return provideEdge(notation);
	}

	@SuppressWarnings("unchecked")
	Edge provideEdge(NotationFactory notation) {
		Diagram diagram = createDiagram(notation);

		Edge result = createEdge(notation, "4001", EcorePackage.Literals.ECLASS__ESUPER_TYPES);

		diagram.getPersistedEdges().add(result);

		Node source = createNode(notation, "2008", EcorePackage.Literals.EREFERENCE);
		diagram.getPersistedChildren().add(source);
		result.setSource(source);

		Node target = createNode(notation, "2008", EcorePackage.Literals.ESTRUCTURAL_FEATURE);
		diagram.getPersistedChildren().add(target);
		result.setTarget(target);

		return result;
	}

	private Edge createEdge(NotationFactory notation, String type, EObject element) {
		Edge result = notation.createEdge();

		result.setType(type);
		result.setBendpoints(notation.createRelativeBendpoints());
		result.setSourceAnchor(notation.createIdentityAnchor());
		result.setTargetAnchor(notation.createIdentityAnchor());
		result.setElement(element);

		return result;
	}

	private Diagram createDiagram(NotationFactory notation) {
		Diagram result = notation.createDiagram();

		result.setType("TestEcoreDiagram");
		result.setElement(EcorePackage.eINSTANCE);
		result.setMeasurementUnit(MeasurementUnit.HIMETRIC_LITERAL);
		result.setName("test");

		return result;
	}

	@Provides
	@From
	@TestScoped
	public Diagram provideFromDiagram(NotationFactory notation) {
		return provideFromEdge(notation).getDiagram();
	}

	@Provides
	@To
	@TestScoped
	public Diagram provideToDiagram(NotationFactory notation) {
		return provideToEdge(notation).getDiagram();
	}

	@Provides
	@From
	@TestScoped
	public Style provideFromStyle(NotationFactory notation) {
		FontStyle result = notation.createFontStyle();
		result.setFontName("Helvetica");
		result.setFontHeight(12);
		result.setFontColor(0xececf7);
		return result;
	}

	@Provides
	@To
	@TestScoped
	public Style provideToStyle(NotationFactory notation) {
		return notation.createFontStyle();
	}
}
