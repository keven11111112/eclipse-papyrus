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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import org.eclipse.papyrus.aof.core.IBinaryFunction;
import org.eclipse.papyrus.aof.core.IBox;
import org.eclipse.papyrus.aof.core.IConditionalBinding;
import org.eclipse.papyrus.aof.core.IFactory;
import org.eclipse.papyrus.aof.core.IOne;
import org.eclipse.papyrus.aof.core.IPair;
import org.eclipse.papyrus.aof.core.IUnaryFunction;
import org.eclipse.papyrus.aof.core.impl.Pair;
import org.eclipse.papyrus.aof.core.utils.Functions;
import org.eclipse.papyrus.aof.core.utils.ObserverTracker;

/**
 * A convenient base class for {@link IMapping} implementations, providing various
 * services for the binding of properties of the mapped objects and establishing
 * correspondences.
 */
public abstract class AbstractMapping<F, T> implements IMapping<F, T> {

	private final Object fromType;
	private final IFactory fromFactory;
	private final Object toType;
	private final IFactory toFactory;

	@Inject
	private IMappingContext context;

	public AbstractMapping(Object fromType, IFactory fromFactory, Object toType, IFactory toFactory) {
		super();

		this.fromType = fromType;
		this.fromFactory = fromFactory;
		this.toType = toType;
		this.toFactory = toFactory;
	}

	protected final IFactory getFromFactory() {
		return fromFactory;
	}

	protected final IFactory getToFactory() {
		return toFactory;
	}

	@Override
	public final IMappingInstance<F, T> map(F from, T to) {
		IOne<F> fromBox = getFromFactory().createOne(from);
		IOne<T> toBox = getToFactory().createOne(to);

		InternalInstance<F, T> result = createMappingInstance(fromBox, toBox);
		ObserverTracker tracker = context.run(result, this::mapProperties);
		result.setTracker(tracker);

		return result;
	}

	protected InternalInstance<F, T> createMappingInstance(IOne<F> from, IOne<T> to) {
		return new InstanceImpl(from, to);
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
	protected abstract void mapProperties(IOne<F> from, IOne<T> to);

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
	protected <P, E> IBox<P> property(IBox<E> ofBox, Object ofType, Object identifiedBy) {
		return ofBox.collectMutable(ofBox.getFactory(), ofType, identifiedBy);
	}

	/**
	 * Maps a property of boxed "from" objects to boxed "to" objects under the given mapping.
	 * 
	 * @param fromBox
	 *            a box of objects that are the mapping source
	 * @param fromIdentifiedBy
	 *            the meta-object of the source objects' domain/platform identifying the property to be bound
	 * @param toBox
	 *            a box of objects that are the mapping target
	 * @param toIdentifiedBy
	 *            the meta-object of the target objects' domain/platform identifying the property to be mapped
	 * @param using
	 *            the mapping rule for the property
	 * 
	 * @return a pairing of the the boxed property values that are mapped
	 */
	protected <P, R> IBox<IMappingInstance<P, R>> mapProperty(IOne<? extends F> fromBox, Object fromIdentifiedBy, IOne<? extends T> toBox, Object toIdentifiedBy, IMapping<P, R> using) {
		IPair<IBox<P>, IBox<R>> result = getToFactory().createPair(property(fromBox, fromType, fromIdentifiedBy), property(toBox, toType, toIdentifiedBy));
		return using.map(result.getLeft(), result.getRight());
	}

	/**
	 * Binds a property of boxed "from" objects to boxed "to" objects.
	 * 
	 * @param fromBox
	 *            a box of objects that are the binding source
	 * @param fromIdentifiedBy
	 *            the meta-object of the source objects' domain/platform identifying the property to be bound
	 * @param toBox
	 *            a box of objects that are the binding target
	 * @param toIdentifiedBy
	 *            the meta-object of the target objects' domain/platform identifying the property to be bound
	 * 
	 * @return a pairing of the the boxed property values that are bound
	 */
	protected <P> IPair<IBox<P>, IBox<P>> bindProperty(IBox<? extends F> fromBox, Object fromIdentifiedBy, IBox<? extends T> toBox, Object toIdentifiedBy) {
		IPair<IBox<P>, IBox<P>> result = getToFactory().createPair(property(fromBox, fromType, fromIdentifiedBy), property(toBox, toType, toIdentifiedBy));
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
	 *            the meta-object of the target objects' domain/platform identifying the property to be bound
	 * 
	 * @return a pairing of the the boxed property values that are bound
	 */
	protected <P> IPair<IBox<P>, IBox<P>> bindPropertyValue(IBox<P> fromBox, IBox<? extends T> toBox, Object identifiedBy) {
		return bindPropertyValue(fromBox, toBox, toType, identifiedBy);
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
	 *            the meta-object of the target objects' domain/platform identifying the property to be bound
	 * 
	 * @return a pairing of the the boxed property values that are bound
	 */
	protected <P> IPair<IBox<P>, IBox<P>> bindPropertyValue(IBox<P> fromBox, IBox<? extends T> toBox, Object ofType, Object identifiedBy) {
		IPair<IBox<P>, IBox<P>> result = getToFactory().createPair(fromBox, property(toBox, ofType, identifiedBy));
		result.getRight().bind(result.getLeft()).setAutoDisable(true);
		return result;
	}

	/**
	 * Conditionally binds a property of boxed "from" objects to boxed "to" objects.
	 * 
	 * @param fromBox
	 *            a box of objects that are the binding source
	 * @param fromIdentifiedBy
	 *            the meta-object of the source objects' domain/platform identifying the property to be bound
	 * @param toBox
	 *            a box of objects that are the binding target
	 * @param toIdentifiedBy
	 *            the meta-object of the target objects' domain/platform identifying the property to be bound
	 * @param transformation
	 *            an transformation of "from" property box elements to "to" property box elements.
	 *            Pass a {@code null} to indicate that the from property should be bound as is
	 * @param condition
	 *            a predicate on the {@code toBox} determining when the binding is enabled
	 * 
	 * @return a pairing of the the boxed property values that are bound
	 */
	protected <P, R extends P> IConditionalBinding<P, R> bindPropertyConditionally(IOne<? extends F> fromBox, Object fromIdentifiedBy, IOne<? extends T> toBox, Object toIdentifiedBy,
			IUnaryFunction<? super P, ? extends R> transformation, IUnaryFunction<? super IBox<? extends P>, Boolean> condition) {

		IBox<R> fromProperty = property(fromBox, fromType, fromIdentifiedBy);
		IBox<R> initialValue = (transformation == null) ? fromProperty : fromProperty.collectTo(transformation);
		IBox<P> toProperty = property(toBox, toType, toIdentifiedBy);
		return toProperty.bindConditionally(initialValue, condition);
	}

	/**
	 * Initializes a property of boxed "from" objects to boxed "to" objects. This is a
	 * {@linkplain #bindPropertyConditionally(IBox, IBox, Object, IUnaryFunction, IUnaryFunction) conditional binding}
	 * that fires only when the {@code toBox} does not contain any value.
	 * 
	 * @param fromBox
	 *            a box of objects that are the binding source
	 * @param fromIdentifiedBy
	 *            the meta-object of the source objects' domain/platform identifying the property to be bound
	 * @param toBox
	 *            a box of objects that are the binding target
	 * @param toIdentifiedBy
	 *            the meta-object of the target objects' domain/platform identifying the property to be bound
	 * @param initializer
	 *            an transformation of "from" property box elements to "to" property box elements.
	 *            Pass a {@code null} to indicate that the "to" property should be initialized from the "from" property as is
	 * 
	 * @return a pairing of the the boxed property values that are bound
	 */
	protected <P, R extends P> IConditionalBinding<P, R> initProperty(IOne<? extends F> fromBox, Object fromIdentifiedBy, IOne<? extends T> toBox, Object toIdentifiedBy,
			IUnaryFunction<? super P, ? extends R> initializer) {

		return bindPropertyConditionally(fromBox, fromIdentifiedBy, toBox, toIdentifiedBy, initializer, Functions.emptyOrNull());
	}

	/**
	 * Initializes a property of boxed "from" objects to boxed "to" objects. This is a
	 * {@linkplain #bindPropertyConditionally(IBox, IBox, Object, IUnaryFunction, IUnaryFunction) conditional binding}
	 * that fires only when the {@code toBox} does not contain any value.
	 * 
	 * @param fromBox
	 *            a box of objects that are the binding source
	 * @param fromIdentifiedBy
	 *            the meta-object of the source objects' domain/platform identifying the property to be bound
	 * @param toBox
	 *            a box of objects that are the binding target
	 * @param toIdentifiedBy
	 *            the meta-object of the target objects' domain/platform identifying the property to be bound
	 * 
	 * @return a pairing of the the boxed property values that are bound
	 */
	protected <P, R extends P> IConditionalBinding<P, R> initProperty(IOne<? extends F> fromBox, Object fromIdentifiedBy, IOne<? extends T> toBox, Object toIdentifiedBy) {
		return initProperty(fromBox, fromIdentifiedBy, toBox, toIdentifiedBy, null);
	}

	/**
	 * Maps the objects in some {@code property} from one contextual object to another, according to some
	 * biject correspondence relation.
	 * 
	 * @param fromContext
	 *            a boxed object that is the mapping source
	 * @param fromProperty
	 *            the meta-object of the source objects' domain/platform identifying the property to be bound
	 * @param toContext
	 *            a boxed object that is the mapping target
	 * @param toProperty
	 *            the meta-object of the objects' domain/platform identifying the property to be mapped
	 * @param resolvedWith
	 *            a bijective correspondence relation between objects in the {@code property} of the
	 *            {@code fromContext} and objects in the same {@code property} of the {@code toContext}
	 * 
	 * @return a pairing of the the boxed objects that are mapped
	 */
	protected <D, E, G extends F, U extends T> IBox<? extends IPair<IOne<D>, IOne<E>>> mapCorresponding(IOne<G> fromContext, Object fromProperty, IOne<U> toContext, Object toProperty,
			ICorrespondenceResolver<D, E, ? super U> resolvedWith) {

		return mapCorresponding(fromContext, fromProperty, toContext, toProperty, resolvedWith, null);
	}

	/**
	 * Maps the objects in some {@code property} from one contextual object to another, according to some
	 * biject correspondence relation, and optionally mapping them recursively.
	 * 
	 * @param fromContext
	 *            a boxed object that is the mapping source
	 * @param fromProperty
	 *            the meta-object of the source objects' domain/platform identifying the property to be bound
	 * @param toContext
	 *            a boxed object that is the mapping target
	 * @param toProperty
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
	protected <D, E, G extends F, U extends T> IBox<? extends IPair<IOne<D>, IOne<E>>> mapCorresponding(IOne<G> fromContext, Object fromProperty, IOne<U> toContext, Object toProperty,
			ICorrespondenceResolver<D, E, ? super U> resolvedWith, IMapping<D, E> mappedWith) {

		IBox<D> fromElements = property(fromContext, fromType, fromProperty);
		IBox<E> toElements = property(toContext, toType, toProperty);

		return mapCorresponding(fromElements, toElements, toContext, resolvedWith, mappedWith);
	}

	/**
	 * Maps the objects in some {@code property} from one contextual object to another, according to some
	 * biject correspondence relation, and optionally mapping them recursively.
	 * 
	 * @param fromElements
	 *            a box of elements from the mapping source
	 * @param toElements
	 *            a box of elements in the mapping target
	 * @param toContext
	 *            a boxed object that is the mapping target
	 * @param resolvedWith
	 *            a bijective correspondence relation between objects in the {@code fromElements}
	 *            and objects in the same {@code toElements} of the {@code toContext}
	 * @param mappedWith
	 *            an optional mapping to apply recursively to the mapped objects in the
	 *            {@code fromElements} and the {@code toElements}. May be {@code null}
	 * 
	 * @return a pairing of the the boxed objects that are mapped
	 */
	protected <D, E, U extends T> IBox<? extends IPair<IOne<D>, IOne<E>>> mapCorresponding(IBox<D> fromElements, IBox<E> toElements,
			IOne<U> toContext, ICorrespondenceResolver<D, E, ? super U> resolvedWith, IMapping<D, E> mappedWith) {

		IBox<E> mapping = fromElements.collectTo(
				(D d) -> getCorresponding(d, toContext.get(), resolvedWith));

		// Bind the elements before mapping them, so that, if the property is a containment
		// reference, the they will be attached to the model before we recursively map anything
		toElements.bind(mapping).setAutoDisable(true);

		IBox<? extends IPair<IOne<D>, IOne<E>>> result;

		if (mappedWith != null) {
			// Ensure that the parent context of this mapping instance is propagated
			result = mappedWith.map(fromElements, toElements);
		} else {
			result = toElements.zipWith(fromElements, (IBinaryFunction<E, D, ? extends IPair<IOne<D>, IOne<E>>>) (e, d) -> Pair.of(getFromFactory().createOne(d), getToFactory().createOne(e)));
		}

		return result;
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
	protected <D, E, C> E getCorresponding(D from, C toContext, ICorrespondenceResolver<D, E, ? super C> resolvedWith) {
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
	protected <D, E, C> E getCorresponding(D from, C toContext, ICorrespondenceResolver<D, E, ? super C> resolvedWith, IMapping<? super D, ? super E> mappedWith) {
		E result = resolvedWith.getCorrespondent(from, toContext);

		if (mappedWith != null) {
			mappedWith.map(from, result);
		}

		return result;
	}

	final Object getFromType() {
		return fromType;
	}

	final Object getToType() {
		return toType;
	}

	//
	// Nested types
	//

	public interface InternalInstance<F, T> extends IMappingInstance<F, T> {
		void setTracker(ObserverTracker tracker);
	}

	private class InstanceImpl implements InternalInstance<F, T> {
		private final IOne<F> from;
		private final IOne<T> to;

		private ObserverTracker tracker;
		private final List<IMappingInstance<?, ?>> consequents = new ArrayList<>(3);

		InstanceImpl(IOne<F> from, IOne<T> to) {
			super();

			this.from = from;
			this.to = to;
		}

		@Override
		public IMapping<F, T> getType() {
			return AbstractMapping.this;
		}

		@Override
		public IOne<F> getLeft() {
			return from;
		}

		@Override
		public IOne<T> getRight() {
			return to;
		}

		@Override
		public void setTracker(ObserverTracker tracker) {
			this.tracker = tracker;
		}

		@Override
		public Iterator<IMappingInstance<?, ?>> iterator() {
			return consequents.iterator();
		}

		@Override
		public void addConsequent(IMappingInstance<?, ?> consequent) {
			consequents.add(consequent);
		}

		@Override
		public void destroy() {
			if (tracker != null) {
				tracker.dispose();
			}
			this.forEach(IMappingInstance::destroy);
		}
	}
}
