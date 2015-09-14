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

package org.eclipse.papyrus.aof.sync;

/**
 * A simple mapping in which the source and target types are the same,
 * which is particularly useful for synchronizing two models of the
 * same kind.
 *
 * @param <E>
 *            the source and target type of the mapping
 */
public interface ISyncMapping<E> extends IMapping<E, E> {
	// Nothing further
}
