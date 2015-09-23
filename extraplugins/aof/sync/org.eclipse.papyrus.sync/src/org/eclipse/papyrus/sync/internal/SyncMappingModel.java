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

package org.eclipse.papyrus.sync.internal;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.aof.sync.IMapping;
import org.eclipse.papyrus.aof.sync.emf.syncmapping.MappingModel;
import org.eclipse.papyrus.aof.sync.emf.syncmapping.SyncMappingFactory;
import org.eclipse.papyrus.aof.sync.emf.syncmapping.SyncMappingPackage;
import org.eclipse.papyrus.aof.sync.emf.syncmapping.util.SyncMappingResource;
import org.eclipse.papyrus.infra.core.resource.EMFLogicalModel;
import org.eclipse.papyrus.sync.ISyncMappingModel;

/**
 * The model implementation for the resource that stores
 * {@linkplain IMapping.Instance mapping instances} for the Papyrus Editor. The
 * resource exists implicitly and is never saved to storage.
 */
public class SyncMappingModel extends EMFLogicalModel implements ISyncMappingModel {

	public SyncMappingModel() {
		super();
	}

	@Override
	protected String getModelFileExtension() {
		return SyncMappingResource.FILE_EXTENSION;
	}

	@Override
	public String getIdentifier() {
		return ID;
	}

	@Override
	public MappingModel getMappingModel() {
		return (MappingModel) EcoreUtil.getObjectByType(getResource().getContents(),
				SyncMappingPackage.Literals.MAPPING_MODEL);
	}

	@Override
	public void loadModel(URI uriWithoutExtension) {
		URI uri = uriWithoutExtension.appendFileExtension(getModelFileExtension());
		if (!modelSet.getURIConverter().exists(uri, null)) {
			// The resource doesn't exist, of course, because it never does.
			// So, create it and the mapping model that it canonically contains.

			// Use this direct approach to avoid transaction concerns
			Resource resource = SyncMappingResource.Factory.INSTANCE.createResource(uri);
			resource.getContents().add(SyncMappingFactory.eINSTANCE.createMappingModel());
			modelSet.getResources().add(resource);
		}

		super.loadModel(uriWithoutExtension);
	}

	@Override
	public void saveModel() throws IOException {
		// We never save these anywhere (the resource implementation doesn't
		// even support it)
	}
}
