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

import java.util.Collection;

/**
 * Protocol for providers of synchronization service, particularly the setting
 * up and tearing down of synchronization relationships and querying the
 * synchronization state of model elements.
 */
public interface ISyncProvider {

	/**
	 * Queries whether I can synchronize a {@code source} to a {@code target}.
	 * 
	 * @param source
	 *            the source object of a proposed synchronization relationship
	 * @param target
	 *            the target object
	 * 
	 * @return whether I can synchronize the two
	 */
	boolean canSynchronize(Object source, Object target);

	/**
	 * Initiates a persistent synchronization of a {@code target} object from a
	 * {@code source} object. The provider may optionally establish the
	 * synchronization in both directions, but this is not required.
	 * 
	 * @param source
	 *            the source object of the synchronization relationship
	 * @param target
	 *            the target object to synchronize from the source
	 * 
	 * @return an opaque (as far as clients are concerned) reference to the
	 *         synchronization of this {@code source} and {@code target} pair,
	 *         or {@code null} if this provider cannot synchronize these objects
	 * 
	 * @see #unsynchronize(Object)
	 */
	Object synchronize(Object source, Object target);

	/**
	 * Obtains opaque synchronization references for all of the synchronizations
	 * that are currently active in the provider's scope.
	 * 
	 * @return the currently active synchronization references
	 */
	Collection<?> getSynchronizationReferences();

	/**
	 * Queries the source object of the synchronization instance represented by
	 * the given reference.
	 * 
	 * @param synchReference
	 *            an opaque reference to a synchronization instance
	 * 
	 * @return the source object in the referenced synchronization
	 */
	Object getSource(Object synchReference);

	/**
	 * Queries the target object of the synchronization instance represented by
	 * the given reference.
	 * 
	 * @param synchReference
	 *            an opaque reference to a synchronization instance
	 * 
	 * @return the target object in the referenced synchronization
	 */
	Object getTarget(Object synchReference);

	/**
	 * Permanently destroys the synchronization relationship between a source
	 * and target that is represented by the given opaque synchronization
	 * reference.
	 * 
	 * @param synchReference
	 *            a synchronization reference previously provided by the
	 *            {@link #synchronize(Object, Object)} or
	 *            {@link #getSynchronizationReferences()} API
	 * 
	 * @return {@code true} if after completion the referenced synchronization
	 *         is permanently discontinued; {@code false}, otherwise
	 */
	boolean unsynchronize(Object synchReference);

	/**
	 * Adds a listener interested in notifications about changes to the
	 * synchronization state of model elements. Has no effect if this
	 * {@code listener} is already attached.
	 * 
	 * @param listener
	 *            the listener to add
	 */
	void addSyncListener(ISyncListener listener);

	/**
	 * Removes a listener that is no longer interested in notifications about
	 * changes to the synchronization state of model elements. Has no effect if
	 * this {@code listener} is not attached.
	 * 
	 * @param listener
	 *            the listener to remove
	 */
	void removeSyncListener(ISyncListener listener);
}
