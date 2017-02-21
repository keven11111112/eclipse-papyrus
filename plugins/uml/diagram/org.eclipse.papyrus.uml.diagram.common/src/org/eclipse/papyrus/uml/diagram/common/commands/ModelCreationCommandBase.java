/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tatiana Fesenko (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.commands;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.infra.architecture.commands.IModelCreationCommand;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.uml.tools.model.UmlUtils;

/**
 * The Class ModelCreationCommandBase.
 */
public abstract class ModelCreationCommandBase implements IModelCreationCommand {

	/**
	 * @param modelSet
	 */
	@Override
	public void createModel(final ModelSet modelSet) {
		final Resource modelResource = UmlUtils.getUmlResource(modelSet);
		EObject model = getRootElement(modelResource);
		attachModelToResource(model, modelResource);
		initializeModel(model);
	}

	/**
	 * Initialize model.
	 *
	 * @param owner
	 *            the owner
	 */
	protected void initializeModel(EObject owner) {
		// Nothing (Subclasses may override)
	}

	/**
	 * Get the root element associated with canvas.
	 *
	 * @param modelResource
	 *            the model resource
	 * @return the root element
	 */
	protected EObject getRootElement(Resource modelResource) {
		EObject rootElement = null;
		if (modelResource != null && modelResource.getContents() != null && modelResource.getContents().size() > 0) {
			Object root = modelResource.getContents().get(0);
			if (root instanceof EObject) {
				rootElement = (EObject) root;
			}
		} else {
			rootElement = createRootElement();
		}
		return rootElement;
	}

	/**
	 * Store model element in the resource.
	 */
	protected void attachModelToResource(EObject root, Resource resource) {
		resource.getContents().add(root);
	}

	/**
	 * Create the root element of an EMF model
	 *
	 * @return the root element
	 */
	protected abstract EObject createRootElement();

}
