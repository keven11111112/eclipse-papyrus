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

package org.eclipse.papyrus.aof.sync.examples.uml.internal.mappings;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.eclipse.papyrus.aof.core.IFactory;
import org.eclipse.papyrus.aof.core.IOne;
import org.eclipse.papyrus.aof.sync.ICorrespondenceResolver;
import org.eclipse.papyrus.aof.sync.IMapping;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.Vertex;

/**
 * Mapping of regions of a state machine (not supporting regions of composite
 * states, just yet).
 */
@Singleton
public class RegionMapping extends NamedElementMapping<Region> {
	@Inject
	private IMapping<Vertex> vertex;

	@Inject
	private IMapping<Transition> transition;

	@Inject
	private ICorrespondenceResolver<Vertex, Region> vertexRedef;

	@Inject
	private ICorrespondenceResolver<Transition, Region> transitionRedef;

	@Inject
	public RegionMapping(IFactory factory) {
		super(UMLPackage.Literals.REGION, factory);
	}

	@Override
	protected void mapProperties(IOne<Region> parentRegion, IOne<Region> childRegion) {
		super.mapProperties(parentRegion, childRegion);

		bindPropertyValue(parentRegion, childRegion, UMLPackage.Literals.REGION__EXTENDED_REGION);

		mapCorresponding(parentRegion, childRegion, UMLPackage.Literals.REGION__SUBVERTEX, vertexRedef, vertex);
		mapCorresponding(parentRegion, childRegion, UMLPackage.Literals.REGION__TRANSITION, transitionRedef, transition);
	}
}
