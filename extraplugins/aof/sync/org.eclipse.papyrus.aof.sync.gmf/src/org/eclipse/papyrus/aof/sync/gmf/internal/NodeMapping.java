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

package org.eclipse.papyrus.aof.sync.gmf.internal;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.Size;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.aof.core.IFactory;
import org.eclipse.papyrus.aof.core.IOne;
import org.eclipse.papyrus.aof.sync.ISyncCorrespondenceResolver;
import org.eclipse.papyrus.aof.sync.ISyncMapping;

/**
 * Mapping of nodes as children of other views.
 */
@Singleton
public class NodeMapping extends ViewMapping<Node> {
	@Inject
	private ISyncMapping<Location> location;

	@Inject
	private ISyncMapping<Size> size;

	@Inject
	private ISyncCorrespondenceResolver<Node, View> nodeCorrespondence;

	@Inject
	private ISyncCorrespondenceResolver<Location, Node> locationCorrespondence;

	@Inject
	private ISyncCorrespondenceResolver<Size, Node> sizeCorrespondence;

	@Inject
	public NodeMapping(IFactory factory) {
		super(NotationPackage.Literals.NODE, factory);
	}

	@Override
	protected void doMapProperties(IOne<Node> from, IOne<Node> to) {
		super.doMapProperties(from, to);

		mapCorresponding(from, to, NotationPackage.Literals.LOCATION, locationCorrespondence, location);
		mapCorresponding(from, to, NotationPackage.Literals.SIZE, sizeCorrespondence, size);

		mapCorresponding(from, to, NotationPackage.Literals.VIEW__PERSISTED_CHILDREN, nodeCorrespondence, this);
	}
}
