/*******************************************************************************
 *  Copyright (c) 2015 ESEO.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *     Frederic Jouault - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.aof.lang;

import static org.eclipse.papyrus.aof.lang.ComposableBinaryFunction.mergeInputs;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.aof.core.IBox;
import org.eclipse.papyrus.aof.core.IMetaClass;
import org.eclipse.papyrus.aof.core.IOne;
import org.eclipse.papyrus.aof.core.IUnaryFunction;
import org.eclipse.papyrus.aof.core.impl.utils.cache.IUnaryCache;
import org.eclipse.papyrus.aof.core.impl.utils.cache.WeakKeysWeakValuesUnaryCache;
import org.eclipse.papyrus.aof.emf.EMFFactory;

/**
 * A {@link MutablePredicate} is a special kind of {@link ComposableUnaryFunction} that returns a
 * boxed {@link Boolean} that may mutate.
 *
 * It also offers additional capabilities related to boolean operations.
 *
 * @author Frederic Jouault
 *
 * @param <E>
 *            type of values on which this mutable predicate operates.
 */
public abstract class MutablePredicate<E> extends ComposableUnaryFunction<E, IOne<Boolean>> {

	/**
	 * A boxed boolean false constant.
	 */
	public static final IOne<Boolean> FALSE = new ConstantOne<Boolean>(false);
	/**
	 * A boxed boolean true constant.
	 */
	public static final IOne<Boolean> TRUE = new ConstantOne<Boolean>(true);

	private static ComposableBinaryFunction<IBox<Boolean>, IBox<Boolean>, IBox<Boolean>> AND = Predicate.and.lift();

	/**
	 * Creates a {@link ComposableBinaryFunction} that returns the conjunction (logical and) of its arguments.
	 * It performs appropriate boxing and unboxing.
	 *
	 * @return a {@link ComposableBinaryFunction} that performs a logical and on its arguments.
	 */
	public static ComposableBinaryFunction<IBox<Boolean>, IBox<Boolean>, ? extends IBox<Boolean>> AND() {
		return AND;
	}

	private static ComposableBinaryFunction<IBox<Boolean>, IBox<Boolean>, IBox<Boolean>> OR = Predicate.or.lift();

	/**
	 * Creates a {@link ComposableBinaryFunction} that returns the disjunction (logical or) of its arguments.
	 * It performs appropriate boxing and unboxing.
	 *
	 * @return a {@link ComposableBinaryFunction} that performs a logical or on its arguments.
	 */
	public static ComposableBinaryFunction<IBox<Boolean>, IBox<Boolean>, ? extends IBox<Boolean>> OR() {
		return OR;
	}

	private static ComposableUnaryFunction<IBox<Boolean>, IBox<Boolean>> NOT = Predicate.not.lift();

	/**
	 * Creates a {@link ComposableUnaryFunction} that returns the negation (logical not) of its argument.
	 * It performs appropriate boxing and unboxing.
	 *
	 * @return a {@link ComposableUnaryFunction} that performs a logical not on its arguments.
	 */
	public static ComposableUnaryFunction<IBox<Boolean>, ? extends IBox<Boolean>> NOT() {
		return NOT;
	}

	/**
	 * Creates a mutable predicate that negates the result of this mutable predicate.
	 *
	 * It performs appropriate boxing and unboxing.
	 *
	 * @return a predicate that returns the logical negation of what this predicate returns for
	 *         the given argument.
	 */
	public MutablePredicate<E> not() {
		return asMutablePredicate((IUnaryFunction<E, IOne<Boolean>>) NOT().compose(this));
	}

	/**
	 * Creates a predicate that returns the conjunction of this predicate and another predicate.
	 *
	 * It performs appropriate boxing and unboxing.
	 *
	 * @param otherPredicate
	 *            an other predicate.
	 * @return a predicate that returns the logical and of what this predicate and the other
	 *         predicate return for the given argument.
	 */
	public MutablePredicate<E> and(IUnaryFunction<? super E, IOne<Boolean>> otherPredicate) {
		return asMutablePredicate((IUnaryFunction<E, IOne<Boolean>>) mergeInputs(AND().compose(this, otherPredicate)));
	}

	/**
	 * Creates a predicate that returns the disjunction of this predicate and another predicate.
	 *
	 * It performs appropriate boxing and unboxing.
	 *
	 * @param otherPredicate
	 *            an other predicate.
	 * @return a predicate that returns the logical or of what this predicate and the other
	 *         predicate return for the given argument.
	 */
	public MutablePredicate<E> or(IUnaryFunction<? super E, IOne<Boolean>> otherPredicate) {
		return asMutablePredicate((IUnaryFunction<E, IOne<Boolean>>) mergeInputs(OR().compose(this, otherPredicate)));
	}

	// We need to override this method to return a MutablePredicate instead of a ComposableUnaryFunction
	// that would need to be explicitly wrapped by a MutablePredicate.
	@Override
	public MutablePredicate<E> cache(final IUnaryCache<E, IOne<Boolean>> cache) {
		return new MutablePredicate<E>() {
			@Override
			public IOne<Boolean> apply(E a) {
				return cachedApply(MutablePredicate.this, cache, a);
			}

			@Override
			public String toString() {
				return MutablePredicate.this.toString() + ".cached()";
			}
		};
	}

	/**
	 * Creates a mutable predicate that tests a property of its argument for equality with a given value.
	 *
	 * @param propertyName
	 *            the name of a property to compare the value with the given value.
	 * @param value
	 *            the value to compare the specified property of the argument given to returned predicate with.
	 * @return a mutable predicate that compares the value of the specified property of its argument to the given value.
	 * @param <E>
	 *            type of elements this predicate operates on.
	 */
	// A possible optimization would be to add a cache to return the same function for the same (propertyName, value) pair.
	// It is not necessary for collectBox to work properly.
	// The following OCL expression:
	// source->select(e | e.<property> = <value>)
	// Can be rewritten as:
	// source.select(source.collect(<factory>, <type>, <property>).collect(equals(<value>)))
	// Or:
	// source.select(source.collect(propertyEquals(<property>, <value>))
	//
	public static <E extends EObject> MutablePredicate<E> propertyEquals(final String propertyName, final Object value) {
		return new MutablePredicate<E>() {
			@Override
			public IOne<Boolean> apply(E a) {
				if (a == null) {
					return FALSE;
				} else {
					return (IOne<Boolean>) EMFFactory.INSTANCE.createPropertyBox(a, propertyName).collect(Predicate.valueEquals(value));
				}
			}

			@Override
			public String toString() {
				return propertyName + " = " + value;
			}
		}.cache(new WeakKeysWeakValuesUnaryCache<E, IOne<Boolean>>());
	}

	/**
	 * Creates a mutable predicate that checks whether the specified property of its argument is empty.
	 *
	 * It should be called for multi-valued properties.
	 *
	 * @param propertyName
	 *            the property to check.
	 * @return a mutable predicate that returns true when the specified property of its argument has an empty value.
	 * @param <E>
	 *            type of elements this predicate operates on.
	 */
	public static <E extends EObject> MutablePredicate<E> isPropertyEmpty(final String propertyName) {
		return new MutablePredicate<E>() {
			@Override
			public IOne<Boolean> apply(E a) {
				if (a == null) {
					return FALSE;
				} else {
					return EMFFactory.INSTANCE.createPropertyBox(a, propertyName).isEmpty();
				}
			}

			@Override
			public String toString() {
				return propertyName + ".isEmpty()";
			}
		}.cache(new WeakKeysWeakValuesUnaryCache<E, IOne<Boolean>>());
	}

	/**
	 * Creates a mutable predicate that tests if its argument is an instance of the given {@link IMetaClass}.
	 *
	 * The returned predicate is not actually mutable because values cannot change type at runtime.
	 * It is however useful to compose with other mutable predicates.
	 *
	 * @param clazz
	 *            the {@link IMetaClass} to check if the argument of the returned predicate is an instance of.
	 * @return a mutable predicate that tests whether its argument is an instance of {@link IMetaClass} <code>clazz</code>.
	 * @param <E>
	 *            type of values on which the returned predicate operates.
	 */
	public static <E> MutablePredicate<E> isInstanceOf(final IMetaClass<? extends E> clazz) {
		return Predicate.isInstanceOf(clazz).asMutablePredicate();
	}

	/**
	 * Converts the given {@link IUnaryFunction} into a {@link MutablePredicate}.
	 *
	 * @param predicate
	 *            the predicate to convert.
	 * @return a mutable predicate that is actually an instance class {@link MutablePredicate}.
	 * @param <E>
	 *            type of values on which the returned predicate operates.
	 */
	public static <E> MutablePredicate<E> asMutablePredicate(final IUnaryFunction<? super E, IOne<Boolean>> predicate) {
		if (predicate instanceof MutablePredicate) {
			return (MutablePredicate<E>) predicate;
		} else {
			return new MutablePredicate<E>() {
				@Override
				public IOne<Boolean> apply(E a) {
					return predicate.apply(a);
				}

				@Override
				public String toString() {
					return predicate.toString() + ".asMutablePredicate()";
				}
			};
		}
	}
}