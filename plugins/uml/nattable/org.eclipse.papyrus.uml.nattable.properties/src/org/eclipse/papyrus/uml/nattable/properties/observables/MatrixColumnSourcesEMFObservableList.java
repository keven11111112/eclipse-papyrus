/*****************************************************************************
 * Copyright (c) 2017 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Vincent LORENZO (CEA-LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.nattable.properties.observables;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.nattable.manager.table.IMatrixTableWidgetManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.IMasterAxisProvider;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.NattableaxisproviderPackage;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablewrapper.EObjectWrapper;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablewrapper.IWrapper;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablewrapper.NattablewrapperFactory;

/**
 * Observable for Matrix column sources feature
 *
 */
public class MatrixColumnSourcesEMFObservableList extends AbstractMatrixSourcesEMFObservableList {


	/**
	 * Constructor.
	 *
	 * @param wrappedList
	 * @param domain
	 * @param source
	 * @param feature
	 */
	public MatrixColumnSourcesEMFObservableList(final EditingDomain domain, final Table table, final IMatrixTableWidgetManager manager) {
		super(domain, table, manager, (IMasterAxisProvider) table.getCurrentColumnAxisProvider(), NattableaxisproviderPackage.eINSTANCE.getIMasterAxisProvider_Sources());
	}

	/**
	 * @Override
	 * @see org.eclipse.papyrus.infra.ui.emf.databinding.EMFObservableList#remove(java.lang.Object)
	 *
	 * @param o
	 * @return
	 */
	public boolean remove(Object o) {
		if (isDisposed()) {
			return true;
		}
		Object toRemove = null;
		if (o instanceof IWrapper) {
			toRemove = (IWrapper) o;
		} else {
			for (final Object currentContext : ((IMasterAxisProvider) this.source).getSources()) {
				if (currentContext instanceof IWrapper && (((IWrapper) currentContext).getElement() == o)) {
					toRemove = currentContext;
					break;
				}
			}
		}
		Assert.isNotNull(toRemove);
		return super.remove(toRemove);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.ui.emf.databinding.EMFObservableList#addAll(java.util.Collection)
	 *
	 * @param c
	 * @return
	 */
	@Override
	public boolean addAll(Collection c) {
		// 1. we build EOBjectWrapper to wrap the element selected by the user and be able to store them in the Table as column context
		final Collection<IWrapper> toAdd = new ArrayList<IWrapper>();
		for (final Object current : c) {
			if (current instanceof IWrapper) {
				// we recreate a wrapper, because the previous one will be destroyed in few time by the remove all command previously executed
				final EObjectWrapper wrapper = NattablewrapperFactory.eINSTANCE.createEObjectWrapper();
				wrapper.setElement((EObject) ((IWrapper) current).getElement());
				toAdd.add(wrapper);
			} else if (current instanceof EObject) {
				final EObjectWrapper wrapper = NattablewrapperFactory.eINSTANCE.createEObjectWrapper();
				wrapper.setElement((EObject) current);
				toAdd.add(wrapper);
			}
		}
		Assert.isTrue(c.size() == toAdd.size());
		return super.addAll(toAdd);
	}

	/**
	 * @see org.eclipse.papyrus.infra.ui.emf.databinding.EMFObservableList#getRemoveCommand(java.lang.Object)
	 *
	 * @param value
	 * @return
	 */
	@Override
	public Command getRemoveCommand(Object value) {
		return super.getRemoveCommand(value);
	}

	/**
	 * @see org.eclipse.papyrus.infra.ui.emf.databinding.EMFObservableList#getAddAllCommand(java.util.Collection)
	 *
	 * @param values
	 * @return
	 */
	@Override
	public Command getAddAllCommand(final Collection<?> values) {
		return super.getAddAllCommand(values);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.ui.emf.databinding.EMFObservableList#clear()
	 *
	 */
	@Override
	public void clear() {
		super.clear();
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.ui.emf.databinding.EMFObservableList#getAddCommand(int, java.lang.Object)
	 *
	 * @param index
	 * @param value
	 * @return
	 */
	@Override
	public Command getAddCommand(int index, Object value) {
		throw new UnsupportedOperationException();
	}


	/**
	 * 
	 * @see org.eclipse.papyrus.infra.ui.emf.databinding.EMFObservableList#getAddCommand(java.lang.Object)
	 *
	 * @param value
	 * @return
	 */
	@Override
	public Command getAddCommand(Object value) {
		throw new UnsupportedOperationException();
	}


	/**
	 * 
	 * @see org.eclipse.papyrus.infra.ui.emf.databinding.EMFObservableList#getAddAllCommand(int, java.util.Collection)
	 *
	 * @param index
	 * @param values
	 * @return
	 */
	@Override
	public Command getAddAllCommand(int index, Collection<?> values) {
		throw new UnsupportedOperationException();
	}


	/**
	 * 
	 * @see org.eclipse.papyrus.infra.ui.emf.databinding.EMFObservableList#getAddAllCommand(int, java.util.Collection)
	 *
	 * @param index
	 * @param values
	 * @return
	 */
	@Override
	public Command getRemoveCommand(int index) {
		throw new UnsupportedOperationException();
	}


	/**
	 * 
	 * @see org.eclipse.papyrus.infra.ui.emf.databinding.EMFObservableList#getAddAllCommand(int, java.util.Collection)
	 *
	 * @param index
	 * @param values
	 * @return
	 */
	@Override
	public Command getRemoveAllCommand(Collection<?> values) {
		// 1. we edit the field column context
		Command cmd = super.getRemoveAllCommand(values);
		return cmd;
	}


	/**
	 * 
	 * @see org.eclipse.papyrus.infra.ui.emf.databinding.EMFObservableList#getAddAllCommand(int, java.util.Collection)
	 *
	 * @param index
	 * @param values
	 * @return
	 */
	@Override
	public Command getRetainAllCommand(Collection<?> values) {
		throw new UnsupportedOperationException();
	}


	/**
	 * 
	 * @see org.eclipse.papyrus.infra.ui.emf.databinding.EMFObservableList#getAddAllCommand(int, java.util.Collection)
	 *
	 * @param index
	 * @param values
	 * @return
	 */
	@Override
	public Command getSetCommand(int index, Object value) {
		throw new UnsupportedOperationException();
	}


	/**
	 * 
	 * @see org.eclipse.papyrus.infra.ui.emf.databinding.EMFObservableList#getAddAllCommand(int, java.util.Collection)
	 *
	 * @param index
	 * @param values
	 * @return
	 */
	@Override
	public void add(int index, Object value) {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.ui.emf.databinding.EMFObservableList#getAddAllCommand(int, java.util.Collection)
	 *
	 * @param index
	 * @param values
	 * @return
	 */
	@Override
	public boolean add(Object o) {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.ui.emf.databinding.EMFObservableList#getAddAllCommand(int, java.util.Collection)
	 *
	 * @param index
	 * @param values
	 * @return
	 */
	@Override
	public boolean addAll(int index, Collection c) {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.ui.emf.databinding.EMFObservableList#removeAll(java.util.Collection)
	 *
	 * @param c
	 * @return
	 */
	@Override
	public boolean removeAll(Collection c) {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.ui.emf.databinding.EMFObservableList#retainAll(java.util.Collection)
	 *
	 * @param c
	 * @return
	 */
	@Override
	public boolean retainAll(Collection c) {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.ui.emf.databinding.EMFObservableList#move(int, int)
	 *
	 * @param oldIndex
	 * @param newIndex
	 * @return
	 */
	@Override
	public Object move(int oldIndex, int newIndex) {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.ui.emf.databinding.EMFObservableList#remove(int)
	 *
	 * @param index
	 * @return
	 */
	@Override
	public Object remove(int index) {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @see org.eclipse.core.databinding.observable.list.ObservableList#contains(java.lang.Object)
	 *
	 * @param o
	 * @return
	 */
	@Override
	public boolean contains(Object o) {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @see org.eclipse.core.databinding.observable.list.ObservableList#containsAll(java.util.Collection)
	 *
	 * @param c
	 * @return
	 */
	@Override
	public boolean containsAll(Collection c) {
		throw new UnsupportedOperationException();
	}
}
