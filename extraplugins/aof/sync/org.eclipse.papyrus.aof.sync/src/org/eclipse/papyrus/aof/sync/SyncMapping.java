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

import org.eclipse.papyrus.aof.core.IBox;
import org.eclipse.papyrus.aof.core.IConditionalBinding;
import org.eclipse.papyrus.aof.core.IFactory;
import org.eclipse.papyrus.aof.core.IOne;
import org.eclipse.papyrus.aof.core.IPair;
import org.eclipse.papyrus.aof.core.IUnaryFunction;

/**
 * A simple mapping in which the source and target types are the same,
 * which is particularly useful for synchronizing two models of the
 * same kind.
 *
 * @param <E>
 *            the source and target type of the mapping
 */
public abstract class SyncMapping<E> extends AbstractMapping<E, E>implements ISyncMapping<E> {

	public SyncMapping(Object type, IFactory factory) {
		super(type, factory, type, factory);
	}

	protected final IFactory getFactory() {
		return getToFactory();
	}

	/**
	 * Obtains a box encapsulating a property of a boxed object as identified by some meta-object.
	 * 
	 * @param ofBox
	 *            a box of objects for which to get the property
	 * @param identifiedBy
	 *            the meta-object of the object's domain/platform identifying the property
	 * 
	 * @return the boxed property value
	 */
	protected <P> IBox<P> property(IBox<? extends E> ofBox, Object identifiedBy) {
		return property(ofBox, getFromType(), identifiedBy); // Same as the toType
	}

	/**
	 * Maps a property of boxed "from" objects to boxed "to" objects under the given mapping.
	 * 
	 * @param fromBox
	 *            a box of objects that are the mapping source
	 * @param toBox
	 *            a box of objects that are the mapping target
	 * @param identifiedBy
	 *            the meta-object of the objects' domain/platform identifying the property to be mapped
	 * @param using
	 *            the mapping rule for the property
	 * 
	 * @return a pairing of the the boxed property values that are mapped
	 */
	protected <P, R> IBox<IMapping.Instance<P, R>> mapProperty(IOne<? extends E> fromBox, IOne<? extends E> toBox, Object identifiedBy, IMapping<P, R> using) {
		return mapProperty(fromBox, identifiedBy, toBox, identifiedBy, using);
	}

	/**
	 * Binds a property of boxed "from" objects to boxed "to" objects.
	 * 
	 * @param fromBox
	 *            a box of objects that are the binding source
	 * @param toBox
	 *            a box of objects that are the binding target
	 * @param identifiedBy
	 *            the meta-object of the objects' domain/platform identifying the property to be bound
	 * 
	 * @return a pairing of the the boxed property values that are bound
	 */
	protected <P> IPair<IBox<P>, IBox<P>> bindProperty(IBox<? extends E> fromBox, IBox<? extends E> toBox, Object identifiedBy) {
		return bindProperty(fromBox, identifiedBy, toBox, identifiedBy);
	}

	/**
	 * Conditionally binds a property of boxed "from" objects to boxed "to" objects.
	 * 
	 * @param fromBox
	 *            a box of objects that are the binding source
	 * @param toBox
	 *            a box of objects that are the binding target
	 * @param identifiedBy
	 *            the meta-object of the objects' domain/platform identifying the property to be bound
	 * @param transformation
	 *            an transformation of "from" property box elements to "to" property box elements.
	 *            Pass a {@code null} to indicate that the from property should be bound as is
	 * @param condition
	 *            a predicate on the {@code toBox} determining when the binding is enabled
	 * 
	 * @return a pairing of the the boxed property values that are bound
	 */
	protected <P, R extends P> IConditionalBinding<P, R> bindPropertyConditionally(IOne<? extends E> fromBox, IOne<? extends E> toBox, Object identifiedBy,
			IUnaryFunction<? super P, ? extends R> transformation, IUnaryFunction<? super IBox<? extends P>, Boolean> condition) {

		return bindPropertyConditionally(fromBox, identifiedBy, toBox, identifiedBy, transformation, condition);
	}

	/**
	 * Initializes a property of boxed "from" objects to boxed "to" objects. This is a
	 * {@linkplain #bindPropertyConditionally(IBox, IBox, Object, IUnaryFunction, IUnaryFunction) conditional binding}
	 * that fires only when the {@code toBox} does not contain any value.
	 * 
	 * @param fromBox
	 *            a box of objects that are the binding source
	 * @param toBox
	 *            a box of objects that are the binding target
	 * @param identifiedBy
	 *            the meta-object of the objects' domain/platform identifying the property to be bound
	 * @param initializer
	 *            an transformation of "from" property box elements to "to" property box elements.
	 *            Pass a {@code null} to indicate that the "to" property should be initialized from the "from" property as is
	 * 
	 * @return a pairing of the the boxed property values that are bound
	 */
	protected <P, R extends P> IConditionalBinding<P, R> initProperty(IOne<? extends E> fromBox, IOne<? extends E> toBox, Object identifiedBy,
			IUnaryFunction<? super P, ? extends R> initializer) {

		return initProperty(fromBox, identifiedBy, toBox, identifiedBy, initializer);
	}

	/**
	 * Initializes a property of boxed "from" objects to boxed "to" objects. This is a
	 * {@linkplain #bindPropertyConditionally(IBox, IBox, Object, IUnaryFunction, IUnaryFunction) conditional binding}
	 * that fires only when the {@code toBox} does not contain any value.
	 * 
	 * @param fromBox
	 *            a box of objects that are the binding source
	 * @param toBox
	 *            a box of objects that are the binding target
	 * @param identifiedBy
	 *            the meta-object of the objects' domain/platform identifying the property to be bound
	 * 
	 * @return a pairing of the the boxed property values that are bound
	 */
	protected <P, R extends P> IConditionalBinding<P, R> initProperty(IOne<? extends E> fromBox, IOne<? extends E> toBox, Object identifiedBy) {
		return initProperty(fromBox, identifiedBy, toBox, identifiedBy);
	}

	/**
	 * Maps the objects in some {@code property} from one contextual object to another, according to some
	 * biject correspondence relation.
	 * 
	 * @param fromContext
	 *            a boxed object that is the mapping source
	 * @param toContext
	 *            a boxed object that is the mapping target
	 * @param identifiedBy
	 *            the meta-object of the objects' domain/platform identifying the property to be mapped
	 * @param resolvedWith
	 *            a bijective correspondence relation between objects in the {@code property} of the
	 *            {@code fromContext} and objects in the same {@code property} of the {@code toContext}
	 * 
	 * @return a pairing of the the boxed objects that are mapped
	 */
	protected <A, B, G extends E, H extends E> IBox<? extends IPair<IOne<A>, IOne<B>>> mapCorresponding(IOne<G> fromContext, IOne<H> toContext, Object property,
			ICorrespondenceResolver<A, B, ? super H> resolvedWith) {

		return mapCorresponding(fromContext, property, toContext, property, resolvedWith);
	}

	/**
	 * Maps the objects in some {@code property} from one contextual object to another, according to some
	 * biject correspondence relation, and optionally mapping them recursively.
	 * 
	 * @param fromContext
	 *            a boxed object that is the mapping source
	 * @param toContext
	 *            a boxed object that is the mapping target
	 * @param identifiedBy
	 *            the meta-object of the objects' domain/platform identifying the property to be mapped
	 * @param resolvedWith
	 *            a bijective correspondence relation between objects in the {@code property} of the
	 *            {@code fromContext} and objects in the same {@code property} of the {@code toContext}
	 * @param mappedWith
	 *            an optional mapping to apply recursively to the mapped elements in the
	 *            {@code property} of the {@code fromContext} and {@code toContext}. May be {@code null}
	 * 
	 * @return a pairing of the the boxed objects that are mapped
	 */
	protected <A, B, G extends E, H extends E> IBox<? extends IPair<IOne<A>, IOne<B>>> mapCorresponding(IOne<G> fromContext, IOne<H> toContext, Object property,
			ICorrespondenceResolver<A, B, ? super H> resolvedWith, IMapping<A, B> mappedWith) {

		return mapCorresponding(fromContext, property, toContext, property, resolvedWith, mappedWith);
	}
}
