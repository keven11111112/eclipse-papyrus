/*****************************************************************************
 * Copyright (c) 2015, 2016 Christian W. Damus and others.
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

import java.util.function.Supplier;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.core.resource.ResourceAdapter;
import org.eclipse.papyrus.infra.tools.databinding.WritableListWithIterator;
import org.eclipse.papyrus.infra.viewpoints.policy.ViewPrototype;

/**
 * A list property of diagram-observables, tracking all of the diagrams available
 * in the resource set.
 */
public class NotationObservableProperty implements Supplier<IObservableList<NotationObservable>> {
	private TransactionalEditingDomain domain;
	private ResourceAdapter.Transactional diagramsListener;

	private IObservableList<NotationObservable> list;

	public NotationObservableProperty(WelcomeModelElement owner) {
		super();

		this.list = new WritableListWithIterator.Containment<>(NotationObservable.class);
		this.domain = (TransactionalEditingDomain) owner.getDomain();

		hookDiagramsListener();

		list.addDisposeListener(event -> {
			diagramsListener.uninstall(domain);
			diagramsListener = null;
			domain = null;
		});
	}

	@Override
	public IObservableList<NotationObservable> get() {
		return list;
	}

	void hookDiagramsListener() {
		diagramsListener = new ResourceAdapter.Transactional() {

			@Override
			protected void handleResourceLoaded(Resource resource) {
				resource.getContents().stream()
						.filter(ViewPrototype::isViewObject)
						.map(NotationObservable::new)
						.forEach(list::add);
			}

			@Override
			protected void handleRootAdded(Resource resource, EObject root) {
				if (ViewPrototype.isViewObject(root)) {
					list.add(new NotationObservable(root));
				}
			}

			@Override
			protected void handleRootRemoved(Resource resource, EObject root) {
				if (ViewPrototype.isViewObject(root)) {
					list.removeIf(next -> next.getView().getValue() == root);
				}
			}
		};

		diagramsListener.install(domain);
	}
}
