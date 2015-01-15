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
package org.eclipse.papyrus.aof.core.impl;

import static org.eclipse.papyrus.aof.core.IBoxType.BAG;
import static org.eclipse.papyrus.aof.core.IBoxType.ONE;
import static org.eclipse.papyrus.aof.core.IBoxType.OPTION;
import static org.eclipse.papyrus.aof.core.IBoxType.ORDERED_SET;
import static org.eclipse.papyrus.aof.core.IBoxType.SEQUENCE;
import static org.eclipse.papyrus.aof.core.IBoxType.SET;

import java.util.Arrays;

import javax.naming.InvalidNameException;

import org.eclipse.papyrus.aof.core.IFactory;
import org.eclipse.papyrus.aof.core.IBag;
import org.eclipse.papyrus.aof.core.IBox;
import org.eclipse.papyrus.aof.core.IConstrained;
import org.eclipse.papyrus.aof.core.IOne;
import org.eclipse.papyrus.aof.core.IOption;
import org.eclipse.papyrus.aof.core.IOrderedSet;
import org.eclipse.papyrus.aof.core.ISequence;
import org.eclipse.papyrus.aof.core.ISet;
import org.eclipse.papyrus.aof.core.IPair;
import org.eclipse.papyrus.aof.core.impl.delegate.BaseDelegate;
import org.eclipse.papyrus.aof.core.impl.delegate.ListDelegate;

public abstract class BaseFactory implements IFactory {

	public <A, B> IPair<A, B> createTuple(A first, B second) {
		return new Pair<A, B>(first, second);
	}

	// A generic box constructor, used by all the following constructors

	protected <A> IBox<A> createBox(IConstrained constrained, BaseDelegate<A> delegate) {
		Box<A> box = null;
		if (OPTION.satisfies(constrained)) {
			box = new Option<A>();
		}
		else if (ONE.satisfies(constrained)) {
			box = new One<A>();
		}
		else if (SET.satisfies(constrained)) {
			box = new Set<A>();
		}
		else if (ORDERED_SET.satisfies(constrained)) {
			box = new OrderedSet<A>();
		}
		else if (SEQUENCE.satisfies(constrained)) {
			box = new Sequence<A>();
		}
		else /* if (BAG.satisfies(constrained)) */{
			box = new Bag<A>();
		}
		box.setDelegate(delegate);
		return box;
	}

	// Boxes independent of the model

	public <A> IBox<A> createBox(IConstrained constrained) {
		IBox<A> box = createBox(constrained, new ListDelegate<A>());
		return box;
	}

	public <A> IBox<A> createBox(IConstrained constrained, A... elements) {
		IBox<A> box = createBox(constrained);
		box.assign(Arrays.asList(elements));
		return box;
	}

	public <A> IBox<A> createBox(Object object, String propertyName) throws InvalidNameException {
		// TODO JavaBean introspection on getter returning the corresponding Box
		return null;
	}

	@SuppressWarnings("unchecked")
	public <A> IOption<A> createOption() {
		return (IOption<A>) createBox(OPTION);
	}

	@SuppressWarnings("unchecked")
	public <A> IOption<A> createOption(A element) {
		return (IOption<A>) createBox(OPTION, element);
	}

	public <A extends Object> IOne<A> createOne(A element) {
		return (IOne<A>) createBox(ONE, (A[]) new Object[] { element });
	}

	public <A> ISet<A> createSet(A... elements) {
		return (ISet<A>) createBox(SET, elements);
	}

	public <A> IOrderedSet<A> createOrderedSet(A... elements) {
		return (IOrderedSet<A>) createBox(ORDERED_SET, elements);
	}

	public <A> ISequence<A> createSequence(A... elements) {
		return (ISequence<A>) createBox(SEQUENCE, elements);
	}

	public <A> IBag<A> createBag(A... elements) {
		return (IBag<A>) createBox(BAG, elements);
	}


}
