/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Mickael ADAM (ALL4TEC) mickael.adam@all4tec.net - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.infra.widgets.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;

/**
 * Selection Service for Papyrus widget. Usually for widget instantiate with xwt where we can't use SelectionService like MultipleValueEditor.
 */
public class PapyrusSelectionService implements ISelectionChangedListener, ISelectionProvider {

	/** The instance. */
	private static PapyrusSelectionService instance;

	/** The current selection. */
	private ISelection selection;

	/** the list of registered listener. */
	private List<ISelectionChangedListener> listeners = new ArrayList<ISelectionChangedListener>();

	/**
	 * get the instance of the singleton.
	 */
	public static PapyrusSelectionService getInstance() {
		if (null == instance) {
			instance = new PapyrusSelectionService();
		}
		return instance;
	}

	/**
	 * Constructor.
	 */
	private PapyrusSelectionService() {
		// not to be called publicly
	}

	/**
	 * Set selection provider.
	 */
	public void setSelectionProvider(final ISelectionProvider selection) {
		selection.addSelectionChangedListener(this);
	}

	/**
	 * Unset selection provider.
	 */
	public void unsetSelectionProvider(final ISelectionProvider selection) {
		selection.removeSelectionChangedListener(this);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
	 */
	@Override
	public void selectionChanged(final SelectionChangedEvent event) {
		setSelection(event.getSelection());
		for (ISelectionChangedListener listener : listeners) {
			listener.selectionChanged(event);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.ISelectionProvider#addSelectionChangedListener(org.eclipse.jface.viewers.ISelectionChangedListener)
	 */
	@Override
	public void addSelectionChangedListener(final ISelectionChangedListener listener) {
		listeners.add(listener);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.ISelectionProvider#getSelection()
	 */
	@Override
	public ISelection getSelection() {
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.ISelectionProvider#removeSelectionChangedListener(org.eclipse.jface.viewers.ISelectionChangedListener)
	 */
	@Override
	public void removeSelectionChangedListener(final ISelectionChangedListener listener) {
		listeners.remove(listener);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.ISelectionProvider#setSelection(org.eclipse.jface.viewers.ISelection)
	 */
	@Override
	public void setSelection(final ISelection selection) {
		this.selection = selection;
	}



}
