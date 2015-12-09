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

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.core.resource.ResourceAdapter;
import org.eclipse.papyrus.infra.tools.databinding.WritableListWithIterator;
import org.eclipse.papyrus.infra.viewpoints.policy.ViewPrototype;

/**
 * An observable list of diagram-observables, tracking all of the diagrams available
 * in the resource set.
 */
public class NotationObservableList extends WritableListWithIterator<NotationObservable> {
	private TransactionalEditingDomain domain;
	private ResourceAdapter.Transactional diagramsListener;

	public NotationObservableList(WelcomeModelElement owner) {
		super(new ArrayList<>(), NotationObservable.class);

		this.domain = (TransactionalEditingDomain) owner.getDomain();
		hookDiagramsListener();
	}

	@Override
	public synchronized void dispose() {
		if (diagramsListener != null) {
			diagramsListener.uninstall(domain);
			diagramsListener = null;
			domain = null;
		}

		super.dispose();
	}

	void hookDiagramsListener() {
		diagramsListener = new ResourceAdapter.Transactional() {

			@Override
			protected void handleResourceLoaded(Resource resource) {
				resource.getContents().stream()
						.filter(ViewPrototype::isViewObject)
						.map(NotationObservable::new)
						.forEach(NotationObservableList.this::add);
			}

			@Override
			protected void handleRootAdded(Resource resource, EObject root) {
				if (ViewPrototype.isViewObject(root)) {
					add(new NotationObservable(root));
				}
			}

			@Override
			protected void handleRootRemoved(Resource resource, EObject root) {
				if (ViewPrototype.isViewObject(root)) {
					for (Iterator<NotationObservable> iter = iterator(); iter.hasNext();) {
						NotationObservable next = iter.next();
						if (next.getView().getValue() == root) {
							iter.remove();
							next.dispose();
						}
					}
				}
			}
		};

		diagramsListener.install(domain);
	}
}
