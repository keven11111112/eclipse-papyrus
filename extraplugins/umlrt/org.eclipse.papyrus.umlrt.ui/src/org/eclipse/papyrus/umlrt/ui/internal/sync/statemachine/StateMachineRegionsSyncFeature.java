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

package org.eclipse.papyrus.umlrt.ui.internal.sync.statemachine;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.gef.EditPart;
import org.eclipse.papyrus.infra.sync.SyncBucket;
import org.eclipse.papyrus.umlrt.ui.internal.sync.UMLRTChildNodesSyncFeature;
import org.eclipse.papyrus.umlrt.ui.internal.sync.UMLRTSyncRegistry;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.StateMachine;

/**
 * Synchronization feature for the edit-parts visualizing the regions of a state machine
 */
public class StateMachineRegionsSyncFeature<M extends Element> extends UMLRTChildNodesSyncFeature<M, Region> {

	public StateMachineRegionsSyncFeature(SyncBucket<M, EditPart, Notification> bucket) {
		super(bucket);
	}

	@Override
	protected Class<? extends UMLRTSyncRegistry<Region>> getNestedSyncRegistryType() {
		return RegionSyncRegistry.class;
	}

	@Override
	protected SyncBucket<Region, EditPart, Notification> createNestedSyncBucket(Region model, EditPart editPart) {
		return new RegionSyncBucket(model, editPart);
	}

	@Override
	protected Iterable<? extends Region> getModelContents(M model) {
		return (model instanceof StateMachine)
				? ((StateMachine) model).getRegions()
				: (model instanceof State)
						? ((State) model).getRegions()
						: ECollections.<Region> emptyEList();
	}
}
