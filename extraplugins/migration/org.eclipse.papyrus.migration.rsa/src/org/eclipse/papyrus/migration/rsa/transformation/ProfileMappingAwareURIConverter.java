/*****************************************************************************
 * Copyright (c) 2016 Christian W. Damus and others.
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

package org.eclipse.papyrus.migration.rsa.transformation;

import static org.eclipse.emf.common.util.URI.createURI;

import java.util.Map;
import java.util.Optional;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;
import org.eclipse.emf.ecore.resource.impl.URIMappingRegistryImpl;
import org.eclipse.papyrus.migration.rsa.RSAToPapyrusParameters.URIMapping;

import com.google.common.collect.Maps;

/**
 * A custom URI converter that lets the resource set find the Papyrus versions of
 * profiles imported from RSA automatically, especially to resolve schema locations
 * before the dependency-mapping/stereotype-repair phase.
 */
class ProfileMappingAwareURIConverter extends ExtensibleURIConverterImpl {

	private final ResourceSet owner;
	private final DependencyAnalysisHelper dependencyHelper;

	private final Map<URI, Optional<URIMapping>> profileMappings = Maps.newConcurrentMap();

	/**
	 * Initializes me with the resource set that owns me and a dependency analysis
	 * helper that resolves profile mappings within it.
	 * 
	 * @param owner
	 *            my contextual resource set
	 * @param dependencyHelper
	 *            the profile mapping helper
	 */
	public ProfileMappingAwareURIConverter(ResourceSet owner, DependencyAnalysisHelper dependencyHelper) {
		super();

		this.owner = owner;
		this.dependencyHelper = dependencyHelper;
	}

	@Override
	protected URIMap getInternalURIMap() {

		if (uriMap == null) {
			URIMap delegate = super.getInternalURIMap();
			uriMap = (URIMap) new URIMappingRegistryImpl() {
				private static final long serialVersionUID = 1L;

				@Override
				protected URI delegatedGetURI(URI uri) {
					URI result;

					if (!"epx".equalsIgnoreCase(uri.fileExtension())) {
						result = delegate.getURI(uri);
					} else {
						Optional<URIMapping> mapping = getProfileMapping(uri);
						result = mapping
								.map(m -> createURI(m.getTargetURI()))
								.orElseGet(() -> delegate.getURI(uri));
					}

					return result;
				}
			}.map();
		}

		return uriMap;

	}

	private Optional<URIMapping> getProfileMapping(URI uri) {
		return profileMappings.computeIfAbsent(uri, this::findProfileMapping);
	}

	private Optional<URIMapping> findProfileMapping(URI uri) {
		// If the EPX actually exists, use it. And we must use an independent
		// converter instance for this test, because otherwise we will
		// deadlock on re-entrance into looking for a profile mapping
		URIMapping result = URIConverter.INSTANCE.exists(uri, null)
				? null
				: dependencyHelper.findExistingProfileMapping(uri, owner);
		return Optional.ofNullable(result);
	}

}
