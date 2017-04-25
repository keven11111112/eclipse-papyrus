/**
 * Copyright (c) 2017 CEA LIST.
 * 
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *  Maged Elaasar - Initial API and implementation
 *  
 * 
 */
package org.eclipse.papyrus.infra.architecture.listeners;

import org.eclipse.papyrus.infra.core.resource.IModelSetSnippet;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.sasheditor.DiModel;
import org.eclipse.papyrus.infra.core.resource.sasheditor.SashModel;

/**
 * A model snippet to install the architecture description adapter in the DI model
 *
 * @since 1.0
 */
public class ArchitectureDescriptionSnippet implements IModelSetSnippet {

	/**
	 * The installed adapter
	 */
	private ArchitectureDescriptionAdapter adapter = new ArchitectureDescriptionAdapter();
	
	/**
	 * Installs the architecture adapter model snippet on the given model set
	 * 
	 * @see org.eclipse.papyrus.infra.core.resource.IModelSetSnippet#start(org.eclipse.papyrus.infra.core.resource.ModelSet)
	 *
	 * @param modelSet the given model set
	 */
	@Override
	public void start(ModelSet modelSet) {
		DiModel diModel = (DiModel) modelSet.getModel(DiModel.DI_MODEL_ID);
		if (diModel != null)
			diModel.getResource().eAdapters().add(adapter);
		SashModel sashModel = (SashModel) modelSet.getModel(SashModel.MODEL_ID);
		if (sashModel != null)
			sashModel.getResource().eAdapters().add(adapter);
	}

	/**
	 * Removes the architecture adapter model snippet from the given model set
	 * 
	 * @see org.eclipse.papyrus.infra.core.resource.IModelSetSnippet#dispose(org.eclipse.papyrus.infra.core.resource.ModelSet)
	 *
	 * @param modelSet the given model set
	 */
	@Override
	public void dispose(ModelSet modelSet) {
		DiModel diModel = (DiModel) modelSet.getModel(DiModel.DI_MODEL_ID);
		if (diModel != null)
			diModel.getResource().eAdapters().remove(adapter);
		SashModel sashModel = (SashModel) modelSet.getModel(SashModel.MODEL_ID);
		if (sashModel != null)
			sashModel.getResource().eAdapters().remove(adapter);
	}
}
