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

package org.eclipse.papyrus.sync;

/**
 * Notification of a change in the synchronization state of some model
 * element(s).
 */
public final class SyncEvent {

	private final SyncEventKind type;

	private final ISyncProvider source;
	private final Object synchronizationReference;
	private final Object syncSource;
	private final Object syncTarget;

	public SyncEvent(SyncEventKind type, ISyncProvider source, Object synchronizationReference, Object syncSource,
			Object syncTarget) {
		super();

		this.type = type;
		this.source = source;
		this.synchronizationReference = synchronizationReference;
		this.syncSource = syncSource;
		this.syncTarget = syncTarget;
	}

	public SyncEventKind getEventType() {
		return type;
	}

	public ISyncProvider getSource() {
		return source;
	}

	/**
	 * Obtains the opaque object representing the synchronization relationship
	 * that was changed.
	 * 
	 * @return the added/removed/whatever synchronization reference
	 */
	public Object getSynchronizationReference() {
		return synchronizationReference;
	}

	/**
	 * Obtains the source of the {@linkplain #getSynchronizationReference()
	 * synchronization relationship} that changed.
	 * 
	 * @return the synchronization source
	 */
	public Object getSyncSource() {
		return syncSource;
	}

	/**
	 * Obtains the target of the {@linkplain #getSynchronizationReference()
	 * synchronization relationship} that changed.
	 * 
	 * @return the synchronization target
	 */
	public Object getSyncTarget() {
		return syncTarget;
	}

	//
	// Nested types
	//

	/**
	 * The kinds of {@link SyncEvent} that can be broadcast by the
	 * {@link ISyncService}.
	 */
	public enum SyncEventKind {
		/**
		 * The kind of event that notifies about a synchronization relationship
		 * being added.
		 */
		SYNCHRONIZATION_ADDED,

		/**
		 * The kind of event that notifies about a synchronization relationship
		 * being removed.
		 */
		SYNCHRONIZATION_REMOVED,
	}
}
