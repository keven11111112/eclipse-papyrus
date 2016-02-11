/*****************************************************************************
 * Copyright (c) 2011, 2016 CEA LIST, Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *  Christian W. Damus - bug 485220
 *
 *****************************************************************************/
package org.eclipse.papyrus.views.modelexplorer.handler;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.papyrus.infra.core.sashwindows.di.service.IPageManager;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.ui.command.AbstractPapyrusHandler;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * This provides facilities to get the TransactionEditingDomain and the PageManager from the Model Explorer
 *
 *
 * @deprecated Use the {@link AbstractPapyrusHandler} API, instead.
 */
@Deprecated
public abstract class AbstractModelExplorerHandler extends AbstractPapyrusHandler {

	/**
	 * Returns the
	 *
	 * @return
	 * 		the current editing domain
	 */
	@Deprecated
	protected TransactionalEditingDomain getEditingDomain() {
		return getEditingDomain((ExecutionEvent) null);
	}

	/**
	 * Returns the page manager
	 *
	 * @return
	 * 		the page manager
	 */
	@Deprecated
	protected IPageManager getPageManager() {
		return getPageManager((ExecutionEvent) null);
	}

	/**
	 * Adapt the specified object to the requested type, if possible.
	 * Return null if the object can't be adapted.
	 *
	 * @param object
	 * @param expectedClassType
	 * @return The adapted object, or null.
	 */
	@SuppressWarnings("unchecked")
	private <T> T adapt(Object object, Class<T> expectedClassType) {


		EObject eobject = EMFHelper.getEObject(object);

		if (eobject != null && expectedClassType.isInstance(eobject)) {
			return (T) eobject;
		}



		// Try global mechanism
		{
			T ele = Platform.getAdapterManager().getAdapter(object, expectedClassType);
			if (ele != null) {
				return ele;
			}
			// Try as EObject if the expectedClasType is sub-type of EObject.
			if (EObject.class.isAssignableFrom(expectedClassType)) {
				// to EObject
				eobject = Platform.getAdapterManager().getAdapter(object, EObject.class);

				if (eobject != null && expectedClassType.isInstance(eobject)) {

					return (T) eobject;
				}
			}
		}
		// Can't be adapted
		return null;

	}

	/**
	 * Filter the list, and only retain objects that can be adapted to the specified type
	 *
	 * @param objects
	 * @param class1
	 * @return
	 */
	private <T> List<T> getAllElementAdaptedToType(List<Object> list, Class<T> expectedClassType) {

		List<T> res = new ArrayList<T>();

		for (Object cur : list) {

			T adapted = adapt(cur, expectedClassType);
			if (adapted != null) {
				res.add(adapted);
			}
		}
		return res;
	}

	/**
	 * Get all selected element of the specified type.
	 *
	 * @param expectedType
	 * @return
	 * @throws ExecutionException
	 */
	@Override
	@SuppressWarnings("unchecked")
	protected <T> List<T> getCurrentSelectionAdaptedToType(ExecutionEvent event, Class<T> expectedType) throws ExecutionException {

		// Get selection from the workbench
		ISelection selection = HandlerUtil.getCurrentSelectionChecked(event);

		// Get the selected objects according to the type of the selected
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			return getAllElementAdaptedToType(structuredSelection.toList(), expectedType);
		} else if (selection instanceof TreeSelection) {
			TreeSelection treeSelection = (TreeSelection) selection;
			return getAllElementAdaptedToType(treeSelection.toList(), expectedType);

		}
		return null;
	}
}
