/**
 * Copyright (c) 2015 Christian W. Damus and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 */
package org.eclipse.papyrus.aof.sync.emf.syncmapping.util;

import java.io.IOException;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;

/**
 * <!-- begin-user-doc -->
 * The <b>Resource </b> associated with the package.
 * <!-- end-user-doc -->
 *
 * @see org.eclipse.papyrus.aof.sync.emf.syncmapping.util.SyncMappingResourceFactoryImpl
 * @generated
 */
public class SyncMappingResourceImpl extends ResourceImpl implements SyncMappingResource {
	/**
	 * Creates an instance of the resource.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param uri
	 *            the URI of the new resource.
	 * @generated
	 */
	public SyncMappingResourceImpl(URI uri) {
		super(uri);
	}

	/**
	 * Persistence is not supported; load requests are just ignored (except that
	 * I change to loaded state).
	 */
	@Override
	public void load(Map<?, ?> options) throws IOException {
		setLoaded(true);
	}

	/**
	 * Persistence is not supported; save requests are just ignored (except that
	 * I become {@linkplain Resource#isModified() unmodified}.
	 */
	@Override
	public void save(Map<?, ?> options) throws IOException {
		setModified(false);
	}
} // SyncMappingResourceImpl
