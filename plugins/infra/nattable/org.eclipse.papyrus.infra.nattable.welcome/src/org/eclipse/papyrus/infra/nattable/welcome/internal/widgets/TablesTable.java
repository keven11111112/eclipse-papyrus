/*****************************************************************************
 * Copyright (c) 2015 Christian W. Damus and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.infra.nattable.welcome.internal.widgets;

import org.eclipse.nebula.widgets.nattable.data.IColumnPropertyAccessor;
import org.eclipse.papyrus.infra.editor.welcome.nattable.widgets.HyperlinkTable;
import org.eclipse.papyrus.infra.nattable.welcome.internal.modelelements.TableObservable;
import org.eclipse.swt.widgets.Composite;

/**
 * A two-column table of hyperlinks for diagrams: on the left side, a link that navigates
 * to the diagram page, and on the right side, a link that navigates to the diagram's
 * context element in the Model Explorer.
 */
public class TablesTable extends HyperlinkTable<TableObservable> {

	public TablesTable(Composite parent, int style) {
		super(parent, style, new DiagramsColumnAccessor(), "Table", "Context");
	}

	//
	// Nested types
	//

	static class DiagramsColumnAccessor implements IColumnPropertyAccessor<TableObservable> {
		static final String TABLE = "table"; //$NON-NLS-1$
		static final String CONTEXT = "context"; //$NON-NLS-1$

		@Override
		public int getColumnCount() {
			return 2;
		}

		@Override
		public Object getDataValue(TableObservable rowObject, int columnIndex) {
			Object result;

			switch (columnIndex) {
			case 0:
				result = rowObject.getTable();
				break;
			case 1:
				result = rowObject.getContext();
				break;
			default:
				throw new IndexOutOfBoundsException(Integer.toString(columnIndex));
			}

			return result;
		}

		@Override
		public void setDataValue(TableObservable rowObject, int columnIndex, Object newValue) {
			throw new IllegalStateException("not editable"); //$NON-NLS-1$
		}

		@Override
		public String getColumnProperty(int columnIndex) {
			switch (columnIndex) {
			case 0:
				return TABLE;
			case 1:
				return CONTEXT;
			default:
				throw new IndexOutOfBoundsException(Integer.toString(columnIndex));
			}
		}

		@Override
		public int getColumnIndex(String propertyName) {
			switch (propertyName) {
			case TABLE:
				return 0;
			case CONTEXT:
				return 1;
			default:
				throw new IllegalArgumentException(propertyName);
			}
		}
	}
}
