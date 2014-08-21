/*****************************************************************************
 * Copyright (c) 2013, 2014 Cedric Dumoulin, CEA, and others.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 433371
 *
 *****************************************************************************/

package org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.internal;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageManager;
import org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.Activator;
import org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.IOpenable;
import org.eclipse.papyrus.infra.core.sashwindows.di.SashWindowsMngr;
import org.eclipse.swt.widgets.Display;
import org.osgi.framework.FrameworkUtil;


/**
 * This class provide high level method to manage the Sash pages through its DI
 * implementation.
 *
 * @author cedric dumoulin
 *
 */
public class PageManagerImpl extends PageMngrImpl implements IPageManager {

	/**
	 * Constructor.
	 * Use a default {@link ICurrentFolderAndPageMngr} that alwayrs use the first
	 * folder as the current folder. Futhermore, the default implementation doesn't
	 * allow to set the active folder. <br>
	 * Suitable for tests
	 *
	 * @param diSashModel
	 *            The model onto which operation of this class act.
	 * @param contentChangedEventProvider
	 *            A class listening on changes on the internal model and delivering events to registered listeners. This implementation
	 *            need the class in order to deactivate event triggering during the operations.
	 *
	 */
	protected PageManagerImpl(SashWindowsMngr diSashModel, ContentChangedEventProvider contentChangedEventProvider) {
		super(diSashModel, contentChangedEventProvider);
	}

	/**
	 * Constructor.
	 *
	 * @param diSashModel
	 * @param contentChangedEventProvider
	 * @param folderAndPageMngr
	 */
	protected PageManagerImpl(SashWindowsMngr diSashModel, ContentChangedEventProvider contentChangedEventProvider, ICurrentFolderAndPageMngr folderAndPageMngr) {
		super(diSashModel, contentChangedEventProvider, folderAndPageMngr);
	}

	@Override
	public void closeAllOpenedPages(Object pageIdentifier) {
		while (isOpen(pageIdentifier)) {
			closePage(pageIdentifier);
		}
	}

	@Override
	public void addPage(Object pageIdentifier) {
		// Nothing
	}

	@Override
	public List<Object> allPages() {
		// FIXME: Temporary, naive code. Need to implement a mechanism to contribute page providers
		List<Object> result = new LinkedList<Object>();
		for (Resource resource : diSashModel.eResource().getResourceSet().getResources()) {
			if (resource != null && resource.isLoaded()) {
				if ("notation".equals(resource.getURI().fileExtension())) {
					for (EObject content : resource.getContents()) {
						if (Platform.getAdapterManager().getAdapter(content, IOpenable.class) != null) {
							result.add(content);
						}
					}
				}
			}
		}
		return result;
	}

	@Override
	public void openPage(Object pageIdentifier) {
		diSashModel.getSashModel().addPage(getCurrentFolder(), pageIdentifier);
	}

	@Override
	public void selectPage(final Object pageIdentifier) {
		Display.getDefault().syncExec(new Runnable() {

			@Override
			public void run() {
				folderAndPageMngr.setActivePage(pageIdentifier);
			}
		});
	}

	@Override
	public void removePage(Object pageIdentifier) {
		closeAllOpenedPages(pageIdentifier);
	}

	public void setCurrentFolderAndPageMngr(ICurrentFolderAndPageMngr currentFolderAndPageMngr) {
		this.folderAndPageMngr = currentFolderAndPageMngr;

	}

	/**
	 * Executes an operation on my internal sash model.
	 *
	 * @param sashModelOperation
	 *            the operation to execute
	 * @return the operation's result
	 *
	 * @throws IllegalAccessException
	 *             on attempt to execute an operation defined by a client bundle
	 */
	public <T> T execute(SashModelOperation<T> sashModelOperation) throws IllegalAccessException {
		T result;

		if (FrameworkUtil.getBundle(sashModelOperation.getClass()) != Activator.getDefault().getBundle()) {
			throw new IllegalAccessException("Attempt to access bundle-private API."); //$NON-NLS-1$
		}

		ContentChangedEventProvider eventProvider = getContentChangedEventProvider();
		final boolean deliver = eventProvider.isDeliver();

		eventProvider.setDeliver(false);
		try {
			result = sashModelOperation.execute(diSashModel);
		} finally {
			eventProvider.setDeliver(deliver);
		}

		return result;
	}

	//
	// Private interfaces
	//

	/**
	 * An operation on the internal sash model of a page manager.
	 */
	public static interface SashModelOperation<T> {

		T execute(SashWindowsMngr sashWindowsManager);
	}
}
