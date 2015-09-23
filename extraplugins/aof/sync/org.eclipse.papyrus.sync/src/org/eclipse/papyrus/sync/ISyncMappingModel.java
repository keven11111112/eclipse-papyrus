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

package org.eclipse.papyrus.sync;

import org.eclipse.papyrus.aof.sync.IMapping;
import org.eclipse.papyrus.aof.sync.emf.syncmapping.MappingModel;
import org.eclipse.papyrus.aof.sync.emf.syncmapping.util.SyncMappingResource;
import org.eclipse.papyrus.infra.core.resource.IModel;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.sync.internal.Activator;

/**
 * Interface for a Papyrus Model managing the resource that stores
 * {@linkplain IMapping.Instance mapping instances} for the Papyrus Editor. The
 * resource exists implicitly and is never saved to storage.
 */
public interface ISyncMappingModel extends IModel {
	/**
	 * The unique identifier with which the model may be retrieved from the
	 * {@link ModelSet}.
	 */
	String ID = Activator.PLUGIN_ID + "." + SyncMappingResource.FILE_EXTENSION;

	/**
	 * Gets the synchronization mapping model instance in a particular
	 * {@link ModelSet}.
	 * 
	 * @param modelSet
	 *            a model-set
	 * @return its synchronization mapping model
	 */
	static ISyncMappingModel getInstance(ModelSet modelSet) {
		return (ISyncMappingModel) modelSet.getModel(ID);
	}

	/**
	 * Obtains the container for all {@linkplain IMapping.Instance mapping
	 * instances} in the Papyrus {@link ModelSet}.
	 * 
	 * @return the mapping container
	 */
	MappingModel getMappingModel();
}
