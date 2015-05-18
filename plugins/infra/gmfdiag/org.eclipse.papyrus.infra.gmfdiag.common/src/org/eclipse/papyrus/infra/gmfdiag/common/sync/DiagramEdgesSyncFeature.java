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

package org.eclipse.papyrus.infra.gmfdiag.common.sync;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramEditPartsUtil;
import org.eclipse.papyrus.infra.sync.SyncBucket;

/**
 * Synchronization feature for the edges in a diagram. It is generally a good idea to add edge features to a bucket
 * only after all of the node features, so that nodes are synchronized before the edges that connect them.
 */
public abstract class DiagramEdgesSyncFeature<M extends EObject, N extends EObject, T extends EditPart> extends AbstractNestedDiagramViewsSyncFeature<M, N, T> {
	/**
	 * Initializes me with my controlling bucket.
	 *
	 * @param bucket
	 *            The bucket doing the synchronization
	 */
	public DiagramEdgesSyncFeature(SyncBucket<M, T, Notification> bucket) {
		super(bucket, NotationPackage.Literals.DIAGRAM__PERSISTED_EDGES, NotationPackage.Literals.DIAGRAM__TRANSIENT_EDGES);
	}

	/**
	 * Gets the diagram edit part containing (recursively) the given {@code parent}.
	 *
	 * @param parent
	 *            The edit part we work on
	 * @return The containing diagram
	 */
	@Override
	protected DiagramEditPart getEffectiveEditPart(EditPart parent) {
		return DiagramEditPartsUtil.getDiagramEditPart(parent);
	}

	@SuppressWarnings("unchecked")
	@Override
	Iterable<? extends T> basicGetContents(T backend) {
		return getEffectiveEditPart(backend).getConnections();
	}

	@Override
	protected EObject getNotifier(T backend) {
		EObject result;

		if (backend instanceof ConnectionEditPart) {
			// The connection's view is the proper notifier
			result = (View) backend.getModel();
		} else {
			result = super.getNotifier(backend);
		}

		return result;
	}
}
