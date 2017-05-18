/*****************************************************************************
 * Copyright (c) 2017 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.infra.nattable.manager.table;

import java.util.Collection;

import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.selection.ISelectionExtractor;

/**
 * The manager to use for Matrix
 * 
 * @since 3.0
 *
 */
public class MatrixTableWidgetModelManager extends TreeNattableModelManager implements IMatrixTableWidgetManager {

	/**
	 * Constructor.
	 *
	 * @param rawModel
	 * @param selectionExtractor
	 * @param initializeListeners
	 */
	public MatrixTableWidgetModelManager(Table rawModel, ISelectionExtractor selectionExtractor, boolean initializeListeners) {
		super(rawModel, selectionExtractor, initializeListeners);
	}

	/**
	 * Constructor.
	 *
	 * @param rawModel
	 * @param selectionExtractor
	 */
	public MatrixTableWidgetModelManager(Table rawModel, ISelectionExtractor selectionExtractor) {
		super(rawModel, selectionExtractor);
	}

	/**
	 * Constructor.
	 *
	 * @param rawModel
	 */
	public MatrixTableWidgetModelManager(Table rawModel) {
		super(rawModel);
	}

	/**
	 * @see org.eclipse.papyrus.infra.nattable.manager.table.NattableModelManager#canDropRowElement(java.util.Collection)
	 *
	 * @param objectsToAdd
	 * @return
	 */
	@Override
	public boolean canDropRowElement(Collection<Object> objectsToAdd) {
		return false;
	}

	/**
	 * @see org.eclipse.papyrus.infra.nattable.manager.table.NattableModelManager#canDropColumnsElement(java.util.Collection)
	 *
	 * @param objectsToAdd
	 * @return
	 */
	@Override
	public boolean canDropColumnsElement(Collection<Object> objectsToAdd) {
		return false;
	}

	/**
	 * @see org.eclipse.papyrus.infra.nattable.manager.table.NattableModelManager#canInvertAxis()
	 *
	 * @return
	 */
	@Override
	public boolean canInvertAxis() {
		return false;
	}

	/**
	 * @see org.eclipse.papyrus.infra.nattable.manager.table.NattableModelManager#canCreateColumnElement(java.lang.String)
	 *
	 * @param elementType
	 * @return
	 */
	@Override
	public boolean canCreateColumnElement(String elementType) {
		return false;
	}

	/**
	 * @see org.eclipse.papyrus.infra.nattable.manager.table.NattableModelManager#canCreateDestroyRowsAxis()
	 *
	 * @return
	 */
	@Override
	public boolean canCreateDestroyRowsAxis() {
		return false;
	}

	/**
	 * @see org.eclipse.papyrus.infra.nattable.manager.table.NattableModelManager#canMoveColumns()
	 *
	 * @return
	 */
	@Override
	public boolean canMoveColumns() {
		return false;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.table.NattableModelManager#canInsertRow(java.util.Collection, int)
	 *
	 * @param objectsToAdd
	 * @param index
	 * @return
	 */
	@Override
	public boolean canInsertRow(Collection<Object> objectsToAdd, int index) {
		return false;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.table.NattableModelManager#canInsertColumns(java.util.Collection, int)
	 *
	 * @param objectsToAdd
	 * @param index
	 * @return
	 */
	@Override
	public boolean canInsertColumns(Collection<Object> objectsToAdd, int index) {
		return false;
	}


	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.table.NattableModelManager#canMoveRows()
	 *
	 * @return
	 */
	@Override
	public boolean canMoveRows() {
		return false;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.table.NattableModelManager#canCreateRowElement(java.lang.String)
	 *
	 * @param elementType
	 * @return
	 */
	@Override
	public boolean canCreateRowElement(String elementType) {
		return false;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.table.NattableModelManager#canCreateDestroyColumnsAxis()
	 *
	 * @return
	 */
	@Override
	public boolean canCreateDestroyColumnsAxis() {
		return false;
	}

}
