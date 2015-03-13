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

public interface IFactory {

	// AOF model constructors

	<A, B> IPair<A, B> createTuple(A first, B second);

	<A> IBox<A> createBox(IConstrained constrained);

	<A> IBox<A> createBox(IConstrained constrained, A... elements);

	<A> IOption<A> createOption();

	<A> IOption<A> createOption(A element);

	/**
	 * 
	 * @param defaultElement should never been null - use an Option instead
	 * @return
	 */
	<A> IOne<A> createOne(A defaultElement);
	
	<A> IOne<A> createOne(A defaultElement,A initialElement);

	<A> ISet<A> createSet(A... elements);

	<A> IOrderedSet<A> createOrderedSet(A... elements);

	<A> ISequence<A> createSequence(A... elements);

	<A> IBag<A> createBag(A... elements);


	// Platform-dependent model constructors

	// TODO remove first arg
	<A> IBox<A> createPropertyBox(Object object, Object property);

	<A, B> IUnaryFunction<A, IBox<B>> createPropertyAccessor(Object property); // TODO throws PropertyNotFoundException ?

	<A> A createInstance(Object clazz) throws ClassNotFoundException;

}
