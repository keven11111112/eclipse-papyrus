/*****************************************************************************
 * Copyright (c) 2014, 2016 CEA LIST, Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Christian W. Damus - bug 485220
 *  
 *****************************************************************************/
package org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.internal;

import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.Activator;
import org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.utils.TransactionHelper;
import org.eclipse.papyrus.infra.core.sashwindows.di.SashWindowsMngr;

/**
 * Transactional implementation of the PageManager.
 *
 * It runs all commands in write transactions on the editing domain, without using the CommandStack
 *
 * @author Camille Letavernier
 *
 */
public class TransactionalPageManagerImpl extends PageManagerImpl {

	private EditingDomain editingDomain;

	public TransactionalPageManagerImpl(SashWindowsMngr diSashModel, ContentChangedEventProvider contentChangedEventProvider) {
		super(diSashModel, contentChangedEventProvider);

		this.editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(diSashModel);
	}

	public TransactionalPageManagerImpl(SashWindowsMngr diSashModel, ContentChangedEventProvider contentChangedEventProvider, ICurrentFolderAndPageMngr folderAndPageMngr) {
		super(diSashModel, contentChangedEventProvider, folderAndPageMngr);

		this.editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(diSashModel);
	}

	protected EditingDomain getEditingDomain() {
		return editingDomain;
	}

	@Override
	public void removePage(final Object pageIdentifier) {
		try {
			TransactionHelper.run(getEditingDomain(), new Runnable() {

				@Override
				public void run() {
					TransactionalPageManagerImpl.super.removePage(pageIdentifier);
				}
			});
		} catch (Exception ex) {
			Activator.log.error(ex);
		}
	}

	@Override
	public void closePage(final Object pageIdentifier) {
		try {
			TransactionHelper.run(getEditingDomain(), new Runnable() {

				@Override
				public void run() {
					TransactionalPageManagerImpl.super.closePage(pageIdentifier);
				}
			});
		} catch (Exception ex) {
			Activator.log.error(ex);
		}
	}

	@Override
	public void closeAllOpenedPages() {
		try {
			TransactionHelper.run(getEditingDomain(), new Runnable() {

				@Override
				public void run() {
					TransactionalPageManagerImpl.super.closeAllOpenedPages();
				}
			});
		} catch (Exception ex) {
			Activator.log.error(ex);
		}
	}

	@Override
	public void closeOtherPages(final Object pageIdentifier) {
		try {
			TransactionHelper.run(getEditingDomain(), new Runnable() {

				@Override
				public void run() {
					TransactionalPageManagerImpl.super.closeOtherPages(pageIdentifier);
				}
			});
		} catch (Exception ex) {
			Activator.log.error(ex);
		}
	}

	@Override
	public void openPage(final Object pageIdentifier) {
		try {
			TransactionHelper.run(getEditingDomain(), new Runnable() {

				@Override
				public void run() {
					TransactionalPageManagerImpl.super.openPage(pageIdentifier);
				}
			});
		} catch (Exception ex) {
			Activator.log.error(ex);
		}
	}

	@Override
	public void openPage(final Object pageIdentifier, final String editorID) {
		try {
			TransactionHelper.run(getEditingDomain(), new Runnable() {

				@Override
				public void run() {
					TransactionalPageManagerImpl.super.openPage(pageIdentifier, editorID);
				}
			});
		} catch (Exception ex) {
			Activator.log.error(ex);
		}
	}

	@Override
	public void closeAllOpenedPages(final Object pageIdentifier) {
		try {
			TransactionHelper.run(getEditingDomain(), new Runnable() {

				@Override
				public void run() {
					TransactionalPageManagerImpl.super.closeAllOpenedPages(pageIdentifier);
				}
			});
		} catch (Exception ex) {
			Activator.log.error(ex);
		}
	}

}
