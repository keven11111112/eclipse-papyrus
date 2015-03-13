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


public interface IBox<A> extends IConstrained, IReadable<A>, IWritable<A>, IObservable<A> {

	IBoxType getType();

	// @pre check type/constraints compatibility
	void bind(IBox<A> that);

	IBox<A> inspect(String label);

	<B> IBox<B> apply(IUnaryFunction<A, B> f);

	<B> IBox<B> map(IUnaryFunction<A, B> f);

	<B> IBox<B> path(IFactory factory, Object aMetaClass, Object property) throws ClassNotFoundException;
	IBox<A> select(IBox<Boolean> b);

	IBox<A> select(IUnaryFunction<A, Boolean> f);

	<B> IBox<IPair<A, B>> zip(IBox<B> b);

}
