/*******************************************************************************
 *  Copyright (c) 2015 ESEO.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *     Olivier Beaudoux - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.aof.core;

public interface IWritable<A> {

	void append(A element);

	void remove(A element);

	void clear();

	void assign(Iterable<A> iterable);

	// active operations uses the internal order of box elements, this interface
	// thus defines index-based writings

	void add(int index, A element);

	void removeAt(int index);

	void replace(int index, A element);

}
