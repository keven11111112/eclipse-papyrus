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
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.infra.core.resource.ResourceAdapter;
import org.eclipse.papyrus.infra.tools.databinding.WritableListWithIterator;

/**
 * An observable list of diagram-observables, tracking all of the diagrams available
 * in the resource set.
 */
public class DiagramsObservableList extends WritableListWithIterator<DiagramObservable> {
	private TransactionalEditingDomain domain;
	private ResourceAdapter.Transactional diagramsListener;

	public DiagramsObservableList(WelcomeModelElement owner) {
		super(new ArrayList<>(), DiagramObservable.class);

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
						.filter(Diagram.class::isInstance)
						.map(Diagram.class::cast)
						.map(DiagramObservable::new)
						.forEach(DiagramsObservableList.this::add);
			}

			@Override
			protected void handleRootAdded(Resource resource, EObject root) {
				if (root instanceof Diagram) {
					add(new DiagramObservable((Diagram) root));
				}
			}

			@Override
			protected void handleRootRemoved(Resource resource, EObject root) {
				if (root instanceof Diagram) {
					for (Iterator<DiagramObservable> iter = iterator(); iter.hasNext();) {
						DiagramObservable next = iter.next();
						if (next.getDiagram().getValue() == root) {
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
