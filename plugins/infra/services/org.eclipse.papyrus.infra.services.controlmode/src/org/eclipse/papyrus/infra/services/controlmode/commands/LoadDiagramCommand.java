/*****************************************************************************
 * Copyright (c) 2014, 2016 CEA LIST, Christian W. Damus, and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   Christian W. Damus - bugs 485220, 497342
 *   
 *****************************************************************************/

package org.eclipse.papyrus.infra.services.controlmode.commands;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.infra.core.sashwindows.di.service.IPageManager;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForResource;


/**
 * Command to load the diagram related to a resource URI
 * 
 * @author Céline JANSSENS
 *
 */
public class LoadDiagramCommand implements Runnable {

	private final IPageManager pageManager;

	/**
	 * URI of the resource which the diagram is based on.
	 */
	private final URI uri;


	/**
	 * Initializes me as a no-op.
	 */
	public LoadDiagramCommand() {
		this(null, null);
	}


	/**
	 * Initializes me with a page manager inferred from the {@code resource}.
	 *
	 * @param resource
	 *            the resource in which there may be diagrams for me to reload
	 *            in the page manager
	 */
	public LoadDiagramCommand(Resource resource) {
		this(resource, getPageManager(resource));
	}

	private static IPageManager getPageManager(Resource resource) {
		IPageManager result = null;

		try {
			result = ServiceUtilsForResource.getInstance().getService(IPageManager.class, resource);
		} catch (ServiceException e) {
			// nothing to do
		}

		return result;
	}

	/**
	 * Initializes me.
	 *
	 * @param resource
	 *            the resource in which there may be diagrams for me to reload
	 *            in the page manager
	 * @param pageManager
	 *            the page manager in which to reload them, or {@code null} if none
	 * 
	 * @since 1.3
	 */
	public LoadDiagramCommand(Resource resource, IPageManager pageManager) {
		super();

		this.pageManager = pageManager;
		this.uri = resource.getURI();
	}

	/**
	 * Reloads hte pages associated with my resource, if any and if there is a
	 * page manager.
	 */
	@Override
	public void run() {

		if (pageManager != null) {
			URI uriTrimResource = uri.trimFragment().trimFileExtension();
			// retrieve open pages related to this URI
			List<Object> pagesID = pageManager.getAssociatedPages(uriTrimResource);
			if (pagesID.size() > 0) {
				for (Object pageID : pagesID) {
					if (pageID != null) {
						pageManager.reloadPage(pageID);
					}
				}
			}
		}

	}
}
