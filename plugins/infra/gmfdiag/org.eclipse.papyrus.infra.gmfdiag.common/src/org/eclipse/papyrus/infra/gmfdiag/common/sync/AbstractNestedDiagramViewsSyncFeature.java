/*****************************************************************************
 * Copyright (c) 2014, 2015 CEA LIST, Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   Christian W. Damus - bug 465416
 *
 *****************************************************************************/

package org.eclipse.papyrus.infra.gmfdiag.common.sync;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.commands.requests.CanonicalDropObjectsRequest;
import org.eclipse.papyrus.infra.sync.EStructuralFeatureSyncFeature;
import org.eclipse.papyrus.infra.sync.SyncBucket;
import org.eclipse.papyrus.infra.sync.SyncItem;
import org.eclipse.papyrus.infra.sync.service.ISyncService;
import org.eclipse.papyrus.infra.sync.service.SyncServiceRunnable;
import org.eclipse.swt.widgets.Control;

import com.google.common.collect.MapMaker;

/**
 * Common implementation of a synchronization feature for nested views in a GMF diagram.
 *
 * @author Laurent Wouters
 *
 * @param <M>
 *            The type of the underlying model element common to all synchronized items in a single bucket
 * @param <T>
 *            The type of the backend element to synchronize
 */
public abstract class AbstractNestedDiagramViewsSyncFeature<M extends EObject, T extends EditPart> extends EStructuralFeatureSyncFeature<M, T> {
	private Map<EObject, EObject> lastKnownElements = new MapMaker().weakKeys().weakValues().makeMap();

	/**
	 * Initializes me with my controlling bucket and one or more references
	 * in the GMF notation model that provide nested views.
	 *
	 * @param bucket
	 *            The bucket doing the synchronization
	 * @param reference
	 *            a notation view reference
	 * @param more
	 *            additional (optional) notation view references
	 */
	public AbstractNestedDiagramViewsSyncFeature(SyncBucket<M, T, Notification> bucket, EReference reference, EReference... more) {
		super(bucket, reference, more);
	}


	/**
	 * Gets the edit part that shall be observed and modified from the specified one
	 *
	 * @param parent
	 *            The edit part we work on
	 * @return The effective edit part that is observed and modified
	 */
	protected abstract EditPart getEffectiveEditPart(EditPart parent);

	/**
	 * Override this one because we need to execute post-actions asynchronously.
	 */
	@Override
	protected Command getAddCommand(final SyncItem<M, T> from, final SyncItem<M, T> to, final EObject newModel) {
		return new AbstractCommand() {
			private T child;

			private EObject objectToDrop;
			private org.eclipse.gef.commands.Command dropCommand;

			@Override
			protected boolean prepare() {
				return true;
			}

			/**
			 * We need to defer the calculation of the drop command until it is time to execute it,
			 * because otherwise the object that we need to drop may not yet exist in the target
			 * model if there is some kind of master/slave mapping in the semantic model, also.
			 * 
			 * @return the drop command
			 */
			private org.eclipse.gef.commands.Command getDropCommand() {
				if (dropCommand == null) {
					EditPartViewer viewer = getEffectiveEditPart(to.getBackend()).getViewer();
					Control control = viewer.getControl();
					FigureCanvas figureCanvas = (FigureCanvas) control;
					Point location = figureCanvas.getViewport().getViewLocation();

					DropObjectsRequest dropObjectsRequest = new DropObjectsRequest();
					objectToDrop = getTargetModel(from, to, newModel);
					dropObjectsRequest.setObjects(Collections.singletonList(objectToDrop));
					dropObjectsRequest.setLocation(location);

					EditPart dropEditPart = getEffectiveEditPart(to.getBackend());
					EditPart targetEditPart = getTargetEditPart(dropEditPart, dropObjectsRequest);
					if (targetEditPart != null) {
						dropEditPart = targetEditPart;
					}

					dropCommand = dropEditPart.getCommand(new CanonicalDropObjectsRequest(dropObjectsRequest));

					if (dropCommand == null) {
						dropCommand = org.eclipse.gef.commands.UnexecutableCommand.INSTANCE;
					}
				}

				return dropCommand;
			}

			@Override
			public void execute() {
				getDropCommand().execute();
				onDo();
			}

			@Override
			public void undo() {
				if (child != null) {
					onTargetRemoved(to, child);
				}
				getDropCommand().undo();
			}

			@Override
			public void redo() {
				getDropCommand().redo();
				onDo();
			}

			private void onDo() {
				UISyncUtils.asyncExec(AbstractNestedDiagramViewsSyncFeature.this, new SyncServiceRunnable.Safe<T>() {
					@Override
					public T run(ISyncService syncService) {
						child = retrieveChild(to.getBackend(), getTargetModel(from, to, objectToDrop));
						if (child != null) {
							onTargetAdded(from, newModel, to, child);
						}
						return child;
					}
				});
			}
		};
	}

	protected EditPart getTargetEditPart(EditPart parentEditPart, DropObjectsRequest dropObjectsRequest) {
		return parentEditPart.getTargetEditPart(dropObjectsRequest);
	}

	/**
	 * Retrieves the child edit part that represents the specified model element
	 *
	 * @param parent
	 *            The parent edit part
	 * @param model
	 *            The model element to look for
	 * @return The child edit part, or <code>null</code> if none is found
	 */
	private T retrieveChild(T parent, EObject model) {
		if (parent == null || model == null) {
			return null;
		}
		List<? extends T> children = getContents(parent);
		for (int i = 0; i < children.size(); i++) {
			T child = children.get(i);
			if (model == getModelOf(child)) {
				return child;
			}
		}
		return null;
	}

	@Override
	protected Command doGetRemoveCommand(final SyncItem<M, T> from, final EObject oldSource, final SyncItem<M, T> to, final T oldTarget) {
		return RemoveCommand.create(getEditingDomain(), oldTarget.getModel());
	}

	@Override
	protected EObject getModelOfNotifier(EObject backendNotifier) {
		EObject result = ((View) backendNotifier).getElement();

		if (result != null) {
			// Update the cache of the last known element, if required
			if (lastKnownElements.get(backendNotifier) != result) {
				lastKnownElements.put(backendNotifier, result);
			}
		} else {
			result = lastKnownElements.get(backendNotifier);
		}

		return result;
	}

	@Override
	protected EObject getNotifier(T backend) {
		return (View) getEffectiveEditPart(backend).getModel();
	}
}
