/*****************************************************************************
 * Copyright (c) 2015, 2016 CEA LIST, Christian W. Damus, and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   Christian W. Damus - bug 505330
 *   
 *****************************************************************************/

package org.eclipse.papyrus.migration.rsa.transformation;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.migration.rsa.concurrent.ThreadSafeResourceSet;

/**
 * @author Camille Letavernier
 *
 */
public class MigrationResourceSetImpl extends ThreadSafeResourceSet implements MigrationResourceSet {

	private boolean frozen = false;

	/**
	 * Initializes me without a dependency analysis helper, which is not recommended
	 * because then it will be difficult for me to resolve profile namespace locations.
	 * 
	 * @deprecated Use the {@link #MigrationResourceSetImpl(DependencyAnalysisHelper)} constructor, instead
	 */
	@Deprecated
	public MigrationResourceSetImpl() {
		this(null);
	}

	/**
	 * Initializes me with my dependency analysis helper.
	 * 
	 * @param dependencyHelper
	 *            my dependency analysis helper, or {@code null} if none
	 */
	public MigrationResourceSetImpl(DependencyAnalysisHelper dependencyHelper) {
		super();

		if (dependencyHelper != null) {
			// Install a URI converter that maps *.epx to *.profile.uml where
			// the target actually exists
			setURIConverter(new ProfileMappingAwareURIConverter(this, dependencyHelper));
		}
	}

	@Override
	public void freeze() {
		this.frozen = true;
	}

	@Override
	public void unfreeze() {
		this.frozen = false;
	}

	@Override
	public Resource getResource(URI uri, boolean loadOnDemand) {
		return super.getResource(uri, frozen ? false : loadOnDemand);
	}

}
