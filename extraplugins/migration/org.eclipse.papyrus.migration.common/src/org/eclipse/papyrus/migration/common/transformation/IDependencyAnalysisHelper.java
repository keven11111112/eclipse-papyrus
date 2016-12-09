/*****************************************************************************
 * Copyright (c) 2014, 2016 CEA LIST, Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *****************************************************************************/

package org.eclipse.papyrus.migration.common.transformation;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.migration.common.MigrationParameters.MappingParameters;
import org.eclipse.papyrus.migration.common.MigrationParameters.URIMapping;


/**
 * @author Vincent Lorenzo
 *
 */
public interface IDependencyAnalysisHelper {

	void computeURIMappings(Collection<Resource> sourceModels);

	/** Propagates the URI Mappings to all duplicates */
	void propagateURIMappings(List<URIMapping> allMappings, MappingParameters result);

	void resolveAllMappings(Map<URI, URI> urisToReplace, Map<URI, URI> profileUrisToReplace);

	List<URIMapping> flattenURIMappings(MappingParameters result);

}