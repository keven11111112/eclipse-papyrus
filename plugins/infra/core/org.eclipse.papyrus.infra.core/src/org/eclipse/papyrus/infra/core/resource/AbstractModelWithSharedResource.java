/*****************************************************************************
 * Copyright (c) 2011, 2016 LIFL, CEA LIST, Christian W. Damus, and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   LIFL - Initial API and implementation
 *   Christian W. Damus - bugs 485220, 496299
 *   Nicolas FAUVERGUE (ALL4TEC) nicolas.fauvergue@all4tec.net - Bug 496905
 *   
 *****************************************************************************/
package org.eclipse.papyrus.infra.core.resource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.infra.core.Activator;

/**
 * Base class for models sharing a common {@link Resource}. To share a common {@link Resource}, one of the model should be Master, while the other are
 * slaves. The Master is the one performing the save operation. All the model
 * should use the same file extension. So, {@link #getModelFileExtension()} should return the same value for all models.
 *
 * @author cedric dumoulin
 *
 * @param T
 *            Type of the roots of the model.
 */
public abstract class AbstractModelWithSharedResource<T extends EObject> extends EMFLogicalModel {

	/**
	 * Possible type for this model: master or slave
	 */
	public enum ModelKind {
		master, slave
	}

	/**
	 * Model kind.
	 * 
	 * @since 3.0
	 */
	protected ModelKind modelKind;

	/**
	 *
	 * Constructor.
	 *
	 * @param modelKind
	 */
	public AbstractModelWithSharedResource(ModelKind modelKind) {
		this.modelKind = modelKind;
	}

	/**
	 * By default, we are a slave. Constructor.
	 *
	 * @param modelKind
	 */
	public AbstractModelWithSharedResource() {
		this.modelKind = ModelKind.slave;
	}

	/**
	 * Attach the model to its resource if this is not already done.
	 */
	@Override
	public void loadModel(URI uriWithoutExtension) {
		try {
			// Look for the resource
			lookupResource(uriWithoutExtension);

			// Check if model is loaded.
			if (resourceIsSet()) {
				configureResource(resource);
				startSnippets();
				return;
			}
			// model is not loaded, do it.
			super.loadModel(uriWithoutExtension);
		} catch (Exception ex) {
			if (modelKind == ModelKind.master) {
				Activator.log.error(ex);
			}
		}
	}

	/**
	 * Create the model if this is not already done.
	 */
	@Override
	public void createModel(URI uri) {
		try {
			// Look for the resource
			lookupResource(uri);

			// Check if model is loaded.
			if (resourceIsSet()) {
				configureResource(resource);
				return;
			}
			super.createModel(uri);
		} catch (Exception ex) {
			if (modelKind == ModelKind.master) {
				Activator.log.error(ex);
			}
		}
	}

	/**
	 * Lookup for the resource in the resourceSet.
	 *
	 * @param uri
	 *            the URI (without extension) of the resource to look for
	 */
	private void lookupResource(URI uriWithoutExtension) {

		// Compute model URI
		resourceURI = uriWithoutExtension.appendFileExtension(getModelFileExtension());

		resource = getResourceSet().getResource(resourceURI, false);

	}

	/**
	 * Do nothing as we are slave. The Resource is save by the master model.
	 *
	 * @see org.eclipse.papyrus.infra.core.resource.AbstractBaseModel#saveModel()
	 *
	 * @throws IOException
	 */
	@Override
	public void saveModel() throws IOException {

		// Do nothing if we are a slave
		if (modelKind == ModelKind.slave) {
			return;
		}

		// Do the save
		super.saveModel();
	}

	@Override
	public void saveCopy(IPath targetPathWithoutExtension, Map<Object, Object> targetMap) {
		// Do nothing if we are a slave
		if (modelKind == ModelKind.slave) {
			return;
		}

		// Do the save
		super.saveCopy(targetPathWithoutExtension, targetMap);
	}


	/**
	 * Get the root of this model. Lookup in the associated {@link Resource} for
	 * the root.
	 *
	 * @return The root of the model, or null if no root exist.
	 */
	@SuppressWarnings("unchecked")
	public T getModelRoot() {
		Resource resource = getResource();
		if (resource == null) {
			return null;
		}

		for (EObject object : resource.getContents()) {

			if (isModelRoot(object)) {
				return (T) object;
			}
		}

		// Not found
		return null;
	}

	/**
	 * Get the roots of this model. Lookup in the associated {@link Resource} for the roots.
	 *
	 * @return A list containing the roots of the model. The list is empty if
	 *         there is no root.
	 */
	@SuppressWarnings("unchecked")
	public List<T> getModelRoots() {

		List<T> roots = new ArrayList<>();

		for (EObject object : getResource().getContents()) {
			if (isModelRoot(object)) {
				roots.add((T) object);
			}
		}

		return roots;
	}

	@Override
	public Iterable<? extends EObject> getRootElements() {
		return getModelRoots();
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.resource.EMFLogicalModel#isModelFor(java.lang.Object)
	 *
	 * @param element
	 * @return
	 */
	@Override
	public boolean isModelFor(Object element) {
		if (modelKind == ModelKind.slave) {
			// I'm not the main model for this resource/object
			return false;
		}
		return super.isModelFor(element);
	}

	/**
	 * Return true if the provided object is a root of the model, false
	 * otherwise. This method should be implemented by subclasses.
	 *
	 * @param object
	 * @return
	 */
	protected abstract boolean isModelRoot(EObject object);

	/**
	 * Add a root to this model.
	 *
	 * @param root
	 */
	public void addModelRoot(T root) {
		getResource().getContents().add(root);
	}

	@Override
	protected Map<Object, Object> getSaveOptions() {
		if (modelKind == ModelKind.master) {
			return super.getSaveOptions();
		} else {
			return Collections.emptyMap();
		}
	}

	@Override
	protected boolean isSupportedRoot(EObject object) {
		return isModelRoot(object);
	}
}
