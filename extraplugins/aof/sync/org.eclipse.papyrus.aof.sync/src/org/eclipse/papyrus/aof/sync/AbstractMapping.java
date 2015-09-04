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
import org.eclipse.papyrus.aof.core.utils.Functions;

/**
 * A convenient base class for {@link IMapping} implementations, providing various
 * services for the binding of properties of the mapped objects and establishing
 * correspondences.
 */
public abstract class AbstractMapping<T> implements IMapping<T> {

	private final Object type;
	private final IFactory factory;

	public AbstractMapping(Object type, IFactory factory) {
		super();

		this.type = type;
		this.factory = factory;
	}

	protected final IFactory getFactory() {
		return factory;
	}

	@Override
	public IPair<IBox<T>, IBox<T>> map(T from, T to) {
		IOne<T> fromBox = one(from);
		IOne<T> toBox = one(to);

		mapProperties(fromBox, toBox);

		return getFactory().createPair(fromBox, toBox);
	}

	/**
	 * Implemented by subclasses to configure the mappings of the specific properties
	 * of the objects that need to be transformed {@code from} one {@code to} the other.
	 * 
	 * @param from
	 *            the source object the mapping
	 * @param to
	 *            the target object of the mapping
	 */
	protected abstract void mapProperties(IOne<T> from, IOne<T> to);

	/** Creates a "one" box on an object. */
	protected IOne<T> one(T element) {
		return getFactory().createOne(element);
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
	protected <P> IBox<P> property(IBox<? extends T> ofBox, Object identifiedBy) {
		return property(ofBox, type, identifiedBy);
	}

	/**
	 * Obtains a box encapsulating a property of a boxed object as identified by some meta-object.
	 * 
	 * @param ofBox
	 *            a box of objects for which to get the property
	 * @param ofType
	 *            the type of object in the box, as a meta-object of the object's domain/platform
	 * @param identifiedBy
	 *            the meta-object of the object's domain/platform identifying the property
	 * 
	 * @return the boxed property value
	 */
	protected <P> IBox<P> property(IBox<? extends T> ofBox, Object ofType, Object identifiedBy) {
		return ofBox.collectMutable(getFactory(), ofType, identifiedBy);
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
	protected <P> IPair<IBox<P>, IBox<P>> mapProperty(IBox<? extends T> fromBox, IBox<? extends T> toBox, Object identifiedBy, IMapping<? super P> using) {
		IPair<IBox<P>, IBox<P>> result = getFactory().createPair(property(fromBox, identifiedBy), property(toBox, identifiedBy));
		using.map(result.getLeft(), result.getRight());
		return result;
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
	protected <P> IPair<IBox<P>, IBox<P>> bindProperty(IBox<? extends T> fromBox, IBox<? extends T> toBox, Object identifiedBy) {
		IPair<IBox<P>, IBox<P>> result = getFactory().createPair(property(fromBox, identifiedBy), property(toBox, identifiedBy));
		result.getRight().bind(result.getLeft()).setAutoDisable(true);
		return result;
	}

	/**
	 * Binds a boxed "from" a value to a property of boxed "to" objects.
	 * 
	 * @param fromBox
	 *            a box of values that are the binding source
	 * @param toBox
	 *            a box of objects that are the binding target
	 * @param identifiedBy
	 *            the meta-object of the objects' domain/platform identifying the property to be bound
	 * 
	 * @return a pairing of the the boxed property values that are bound
	 */
	protected <P> IPair<IBox<P>, IBox<P>> bindPropertyValue(IBox<P> fromBox, IBox<? extends T> toBox, Object identifiedBy) {
		IPair<IBox<P>, IBox<P>> result = getFactory().createPair(fromBox, property(toBox, identifiedBy));
		result.getRight().bind(result.getLeft()).setAutoDisable(true);
		return result;
	}

	/**
	 * Binds a boxed "from" a value to a property of boxed "to" objects.
	 * 
	 * @param fromBox
	 *            a box of values that are the binding source
	 * @param toBox
	 *            a box of objects that are the binding target
	 * @param ofType
	 *            the type of object in the {@code toBox}, as a meta-object of the object's domain/platform
	 * @param identifiedBy
	 *            the meta-object of the objects' domain/platform identifying the property to be bound
	 * 
	 * @return a pairing of the the boxed property values that are bound
	 */
	protected <P> IPair<IBox<P>, IBox<P>> bindPropertyValue(IBox<P> fromBox, IBox<? extends T> toBox, Object ofType, Object identifiedBy) {
		IPair<IBox<P>, IBox<P>> result = getFactory().createPair(fromBox, property(toBox, ofType, identifiedBy));
		result.getRight().bind(result.getLeft()).setAutoDisable(true);
		return result;
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
	protected <P> IConditionalBinding<P, P> bindPropertyConditionally(IBox<? extends T> fromBox, IBox<? extends T> toBox, Object identifiedBy,
			IUnaryFunction<? super P, ? extends P> transformation, IUnaryFunction<? super IBox<? extends P>, Boolean> condition) {

		IBox<P> fromProperty = property(fromBox, identifiedBy);
		IBox<P> initialValue = (transformation == null) ? fromProperty : fromProperty.collectTo(transformation);
		IBox<P> toProperty = property(toBox, identifiedBy);
		return toProperty.bindConditionally(initialValue, condition);
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
	protected <P> IConditionalBinding<P, P> initProperty(IBox<? extends T> fromBox, IBox<? extends T> toBox, Object identifiedBy,
			IUnaryFunction<? super P, ? extends P> initializer) {

		return bindPropertyConditionally(fromBox, toBox, identifiedBy, initializer, Functions.emptyOrNull());
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
	protected <P> IConditionalBinding<P, P> initProperty(IBox<? extends T> fromBox, IBox<? extends T> toBox, Object identifiedBy) {
		return initProperty(fromBox, toBox, identifiedBy, null);
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
	protected <E> IPair<IBox<E>, IBox<E>> mapCorresponding(IOne<T> fromContext, IOne<T> toContext, Object property,
			ICorrespondenceResolver<E, ? super T> resolvedWith) {

		return mapCorresponding(fromContext, toContext, property, resolvedWith, null);
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
	protected <E> IPair<IBox<E>, IBox<E>> mapCorresponding(IOne<T> fromContext, IOne<T> toContext, Object property,
			ICorrespondenceResolver<E, ? super T> resolvedWith, IMapping<? super E> mappedWith) {

		IBox<E> fromElements = property(fromContext, property);
		IBox<E> toElements = property(toContext, property);

		IBox<E> mapping = fromElements.collectTo(
				(E e) -> getCorresponding(e, toContext.get(), resolvedWith));

		if (mappedWith != null) {
			mappedWith.map(fromElements, toElements);
		}

		toElements.bind(mapping).setAutoDisable(true);

		return getFactory().createPair(fromElements, toElements);
	}

	/**
	 * Obtains the object in the {@code toContext} corresponding to some {@code from} object in the source
	 * of a mapping.
	 * 
	 * @param from
	 *            a source object in a mapping
	 * @param toContext
	 *            the context in which to find (or create, if necessary and according to the resolver) the corresponding object
	 * @param resolvedWith
	 *            the bijective correspondence relation to use to find/create the target object
	 * 
	 * @return the object corresponding to {@code from} in the {@code toContext}
	 */
	protected <E, C> E getCorresponding(E from, C toContext, ICorrespondenceResolver<E, ? super C> resolvedWith) {
		return getCorresponding(from, toContext, resolvedWith, null);
	}

	/**
	 * Obtains the object in the {@code toContext} corresponding to some {@code from} object in the source
	 * of a mapping, optionally applying a recursive mapping to it.
	 * 
	 * @param from
	 *            a source object in a mapping
	 * @param toContext
	 *            the context in which to find (or create, if necessary and according to the resolver) the corresponding object
	 * @param resolvedWith
	 *            the bijective correspondence relation to use to find/create the target object
	 * @param mappedWith
	 *            an optional mapping to apply recursively to the {@code from} object and the resulting correspondent. May be {@code null}
	 * 
	 * @return the object corresponding to {@code from} in the {@code toContext}
	 */
	protected <E, C> E getCorresponding(E from, C toContext, ICorrespondenceResolver<E, ? super C> resolvedWith, IMapping<? super E> mappedWith) {
		E result = resolvedWith.getCorrespondent(from, toContext);

		if (mappedWith != null) {
			mappedWith.map(from, result);
		}

		return result;
	}
}
