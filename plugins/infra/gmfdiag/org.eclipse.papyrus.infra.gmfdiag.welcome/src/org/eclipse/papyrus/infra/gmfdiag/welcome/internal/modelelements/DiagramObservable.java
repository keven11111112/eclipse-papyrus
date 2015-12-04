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

package org.eclipse.papyrus.infra.gmfdiag.welcome.internal.modelelements;

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
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.papyrus.infra.tools.databinding.TouchableValue;

/**
 * Encapsulation of a {@link Diagram} that presents the following as observable properties:
 * <ul>
 * <li>the diagram</li>
 * <li>the diagram's context element</li>
 * </ul>
 */
public class DiagramObservable extends AbstractObservable {
	private final Diagram diagram;

	private Adapter diagramAdapter;
	private Adapter contextAdapter;

	private final TouchableValue<Diagram> diagramValue;
	private final TouchableValue<EObject> contextValue;

	public DiagramObservable(Diagram diagram) {
		this(Realm.getDefault(), diagram);
	}

	public DiagramObservable(Realm realm, Diagram diagram) {
		super(realm);

		this.diagram = diagram;

		this.diagramValue = new TouchableValue<Diagram>(realm, Diagram.class, diagram);
		this.contextValue = new TouchableValue<EObject>(realm, EObject.class, diagram.getElement());

		this.diagramAdapter = new DiagramAdapter(diagram);
		handleContextChanged(null, diagram.getElement());

		// Roll up changes to my elements as changes to me
		IChangeListener rollup = new IChangeListener() {

			@Override
			public void handleChange(ChangeEvent event) {
				DiagramObservable.this.fireChange();
			}
		};
		diagramValue.addChangeListener(rollup);
		contextValue.addChangeListener(rollup);
	}

	@Override
	public synchronized void dispose() {
		if (diagramAdapter != null) {
			// This will nullify the 'diagramAdapter' field
			diagram.eAdapters().remove(diagramAdapter);
		}

		if (contextAdapter != null) {
			// This will nullify the 'contextAdapter' field
			diagram.getElement().eAdapters().remove(contextAdapter);
		}

		diagramValue.dispose();
		contextValue.dispose();

		super.dispose();
	}

	public IObservableValue<Diagram> getDiagram() {
		return diagramValue;
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

	private class DiagramAdapter extends AdapterImpl {
		DiagramAdapter(Diagram diagram) {
			super();

			diagram.eAdapters().add(this);
		}

		@Override
		public void unsetTarget(Notifier oldTarget) {
			if (target == oldTarget) {
				// I am disposed
				diagramAdapter = null;
			}

			super.unsetTarget(oldTarget);
		}

		@Override
		public void notifyChanged(Notification msg) {
			if (!msg.isTouch()) {
				switch (msg.getFeatureID(Diagram.class)) {
				case NotationPackage.DIAGRAM__NAME:
				case NotationPackage.DIAGRAM__TYPE:
					diagramValue.touch();
					break;
				case NotationPackage.DIAGRAM__ELEMENT:
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
