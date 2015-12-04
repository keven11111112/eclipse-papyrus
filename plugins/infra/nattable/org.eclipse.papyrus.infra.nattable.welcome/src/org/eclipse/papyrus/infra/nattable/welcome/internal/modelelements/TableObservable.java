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

package org.eclipse.papyrus.infra.nattable.welcome.internal.modelelements;

import org.eclipse.core.databinding.observable.AbstractObservable;
import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.nattable.model.nattable.NattablePackage;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.tools.databinding.TouchableValue;

/**
 * Encapsulation of a {@link Table} that presents the following as observable properties:
 * <ul>
 * <li>the table</li>
 * <li>the table's context element</li>
 * </ul>
 */
public class TableObservable extends AbstractObservable {
	private final Table table;

	private Adapter tableAdapter;
	private Adapter contextAdapter;

	private final TouchableValue<Table> tableValue;
	private final TouchableValue<EObject> contextValue;

	public TableObservable(Table table) {
		this(Realm.getDefault(), table);
	}

	public TableObservable(Realm realm, Table table) {
		super(realm);

		this.table = table;

		this.tableValue = new TouchableValue<>(realm, Table.class, table);
		this.contextValue = new TouchableValue<>(realm, EObject.class, table.getContext());

		this.tableAdapter = new TableAdapter(table);
		handleContextChanged(null, table.getContext());

		// Roll up changes to my elements as changes to me
		IChangeListener rollup = new IChangeListener() {

			@Override
			public void handleChange(ChangeEvent event) {
				TableObservable.this.fireChange();
			}
		};
		tableValue.addChangeListener(rollup);
		contextValue.addChangeListener(rollup);
	}

	@Override
	public synchronized void dispose() {
		if (tableAdapter != null) {
			// This will nullify the 'tableAdapter' field
			table.eAdapters().remove(tableAdapter);
		}

		if (contextAdapter != null) {
			// This will nullify the 'contextAdapter' field
			table.getContext().eAdapters().remove(contextAdapter);
		}

		tableValue.dispose();
		contextValue.dispose();

		super.dispose();
	}

	public IObservableValue<Table> getTable() {
		return tableValue;
	}

	public IObservableValue<EObject> getContext() {
		return contextValue;
	}

	@Override
	public boolean isStale() {
		return false;
	}

	void handleContextChanged(EObject oldContext, EObject newContext) {
		Adapter adapter = this.contextAdapter;

		if (oldContext != null) {
			// This will nullify the 'contextAdapter' field
			oldContext.eAdapters().remove(contextAdapter);
		}
		if (newContext != null) {
			if (adapter == null) {
				// initial context
				contextAdapter = new ContextAdapter(newContext);
			} else {
				// reuse the adapter
				newContext.eAdapters().add(adapter);
				contextAdapter = adapter;
			}
		}

		contextValue.setValue(newContext);
	}

	//
	// Nested types
	//

	private class TableAdapter extends AdapterImpl {
		TableAdapter(Table table) {
			super();

			table.eAdapters().add(this);
		}

		@Override
		public void unsetTarget(Notifier oldTarget) {
			if (target == oldTarget) {
				// I am disposed
				tableAdapter = null;
			}

			super.unsetTarget(oldTarget);
		}

		@Override
		public void notifyChanged(Notification msg) {
			if (!msg.isTouch()) {
				switch (msg.getFeatureID(Table.class)) {
				case NattablePackage.TABLE__NAME:
				case NattablePackage.TABLE__TABLE_CONFIGURATION:
					tableValue.touch();
					break;
				case NattablePackage.TABLE__CONTEXT:
					handleContextChanged((EObject) msg.getOldValue(), (EObject) msg.getNewValue());
					break;
				}
			}
		}
	}

	private class ContextAdapter extends AdapterImpl {
		ContextAdapter(EObject context) {
			super();

			context.eAdapters().add(this);
		}

		@Override
		public void unsetTarget(Notifier oldTarget) {
			if (target == oldTarget) {
				// I am disposed
				contextAdapter = null;
			}

			super.unsetTarget(oldTarget);
		}

		@Override
		public void notifyChanged(Notification msg) {
			if (!msg.isTouch()) {
				// Can't interpret the change, so just assume that the label needs to change
				contextValue.touch();
			}
		}
	}
}
