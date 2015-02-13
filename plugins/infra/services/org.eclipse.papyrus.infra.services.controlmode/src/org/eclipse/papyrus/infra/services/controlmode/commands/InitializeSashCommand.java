/*****************************************************************************
 * Copyright (c) 2013,2015 Atos, CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Arthur Daussy (Atos) arthur.daussy@atos.net- Initial API and implementation
 *   Gabriel Pascual (ALL4TEC) gabriel.pascual@all4tec.net - Bug 459702
 *****************************************************************************/
package org.eclipse.papyrus.infra.services.controlmode.commands;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.papyrus.infra.core.resource.sasheditor.DiModel;
import org.eclipse.papyrus.infra.core.resource.sasheditor.SashModelUtils;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageManager;
import org.eclipse.papyrus.infra.core.sashwindows.di.SashModel;
import org.eclipse.papyrus.infra.core.sashwindows.di.SashWindowsMngr;
import org.eclipse.papyrus.infra.core.sashwindows.di.exception.SashEditorException;
import org.eclipse.papyrus.infra.core.sashwindows.di.util.DiUtils;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForResourceSet;
import org.eclipse.papyrus.infra.services.controlmode.ControlModePlugin;
import org.eclipse.papyrus.infra.services.controlmode.ControlModeRequest;
import org.eclipse.papyrus.infra.services.controlmode.ControlModeRequestParameters;

/**
 * Initialise a correct Sash Model in the right location. Two case:
 * <dl>
 * <dt>Legacy</dt>
 * <dd>The sash model must written in Di file.</dd>
 * <dt>Standard</dt>
 * <dd>Since Luna, the Sash Model must be inserted in its own workspace's resource.</dd>
 * </dl>
 * 
 * @author adaussy
 *
 */
public class InitializeSashCommand extends AbstractControlCommand {

	/** The Constant SASH_RESOURCE_ERROR. */
	private static final String SASH_RESOURCE_ERROR = "Unable to find Sash resource";

	/** The Constant SASH_COMMAND_TITLE. */
	private static final String SASH_COMMAND_TITLE = "Initialize Sash model";

	/**
	 * Instantiates a new initialize sash command.
	 *
	 * @param request
	 *            the request
	 */
	public InitializeSashCommand(ControlModeRequest request) {
		super(SASH_COMMAND_TITLE, null, request);
	}

	/**
	 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor, org.eclipse.core.runtime.IAdaptable)
	 *
	 * @param monitor
	 * @param info
	 * @return
	 * @throws ExecutionException
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		/*
		 * Get from the request tab and diagrams being moved
		 */
		Collection<EObject> openables = getMovedOpenablesFromRequest();
		try {
			SashWindowsMngr sashMng = createSashWindowsMngr(openables);
			Resource sashResourceResource = getSashResource();


			if (sashResourceResource == null) {
				return CommandResult.newErrorCommandResult(SASH_RESOURCE_ERROR);
			}
			sashResourceResource.getContents().add(sashMng);
		} catch (SashEditorException e) {
			ControlModePlugin.log.error(e);
			return CommandResult.newErrorCommandResult(e);
		} catch (ServiceException e) {
			ControlModePlugin.log.error(e);
			return CommandResult.newErrorCommandResult(e);
		}
		return CommandResult.newOKCommandResult();
	}

	/**
	 * Gets the moved openables from request.
	 *
	 * @return tables being moved from the request
	 */
	@SuppressWarnings("unchecked")
	protected Collection<EObject> getMovedOpenablesFromRequest() {
		Collection<EObject> tabs = (Collection<EObject>) getRequest().getParameter(ControlModeRequestParameters.MOVED_OPENABLES);
		if (tabs == null) {
			return new ArrayList<EObject>();
		}
		return tabs;
	}

	/**
	 * Gets the sash resource.
	 *
	 * @return retrieve the di resource from the request
	 * @throws ServiceException
	 */
	protected Resource getSashResource() throws ServiceException {

		org.eclipse.papyrus.infra.core.resource.sasheditor.SashModel sashModel = SashModelUtils.getSashModel(request.getModelSet());
		Resource sashResource = request.getTargetResource(DiModel.MODEL_FILE_EXTENSION);

		// Check if the Sash resource is not Legacy format
		if (org.eclipse.papyrus.infra.core.resource.sasheditor.SashModel.SASH_MODEL_FILE_EXTENSION.equals(sashModel.getResourceURI().fileExtension())) {

			// Load Sash resource
			URI targetUri = sashResource.getURI().trimFileExtension();
			sashModel.loadModel(targetUri);
			sashResource = SashModelUtils.getSashModel(request.getModelSet()).getResource();
		}

		return sashResource;
	}

	/**
	 * Create a new {@link SashModel} and add page ref for each diagrams and tables being controlled
	 *
	 * @param openables
	 * @return
	 * @throws SashEditorException
	 * @throws ServiceException
	 */
	protected SashWindowsMngr createSashWindowsMngr(Collection<EObject> openables) throws SashEditorException, ServiceException {

		// Create a new SashWindowManager
		SashWindowsMngr windowsMngr = DiUtils.createDefaultSashWindowsMngr();
		IPageManager pageManager = ServiceUtilsForResourceSet.getInstance().getIPageManager(request.getModelSet());

		// Complete SashWindow Manager filling the default TabFolder with opened diagram
		for (EObject openable : openables) {
			if (pageManager.isOpen(openable)) {
				windowsMngr.getSashModel().addPage(windowsMngr.getSashModel().getCurrentSelection(), openable);
			}
		}

		return windowsMngr;
	}
}
