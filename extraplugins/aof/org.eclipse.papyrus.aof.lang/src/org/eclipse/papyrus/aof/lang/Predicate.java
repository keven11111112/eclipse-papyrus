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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.papyrus.aof.core.IMetaClass;
import org.eclipse.papyrus.aof.core.IUnaryFunction;

/**
 * A {@link Predicate} is a special kind of {@link ComposableUnaryFunction} that returns a
 * {@link Boolean}.
 *
 * It has additional capabilities related to boolean operations.
 *
 * @author Frederic Jouault
 *
 * @param <E>
 *            type of values on which this predicate operates.
 */
public abstract class Predicate<E> extends ComposableUnaryFunction<E, Boolean> {

	/**
	 * A predicate that logically negates its argument.
	 */
	public static Predicate<Boolean> not = new Predicate<Boolean>() {
		@Override
		public Boolean apply(Boolean a) {
			return !a;
		}

		@Override
		public String toString() {
			return "not";
		}
	};

	/**
	 * A {@link ComposableBinaryFunction} that returns the conjunction (logical and) of its arguments.
	 */
	public static ComposableBinaryFunction<Boolean, Boolean, Boolean> and = new ComposableBinaryFunction<Boolean, Boolean, Boolean>() {
		@Override
		public Boolean apply(Boolean a, Boolean b) {
			return a && b;
		}

		@Override
		public String toString() {
			return "and";
		}
	};

	/**
	 * A {@link ComposableBinaryFunction} that returns the disjunction (logical or) of its arguments.
	 */
	public static ComposableBinaryFunction<Boolean, Boolean, Boolean> or = new ComposableBinaryFunction<Boolean, Boolean, Boolean>() {
		@Override
		public Boolean apply(Boolean a, Boolean b) {
			return a || b;
		}

		@Override
		public String toString() {
			return "or";
		}
	};

	/**
	 * Creates a predicate that negates the result of this predicate.
	 *
	 * @return a predicate that returns the logical negation of what this predicate returns for
	 *         the given argument.
	 */
	public Predicate<E> not() {
		return asPredicate(Predicate.not.compose(this));
	}

	/**
	 * Creates a predicate that returns the conjunction of this predicate and another predicate.
	 *
	 * @param otherPredicate
	 *            an other predicate.
	 * @return a predicate that returns the logical and of what this predicate and the other
	 *         predicate return for the given argument.
	 */
	public Predicate<E> and(IUnaryFunction<? super E, Boolean> otherPredicate) {
		return asPredicate(mergeInputs(Predicate.and.compose(this, otherPredicate)));
	}

	/**
	 * Creates a predicate that returns the disjunction of this predicate and another predicate.
	 *
	 * @param otherPredicate
	 *            an other predicate.
	 * @return a predicate that returns the logical or of what this predicate and the other
	 *         predicate return for the given argument.
	 */
	public <B> Predicate<E> or(IUnaryFunction<? super E, Boolean> otherPredicate) {
		return asPredicate(mergeInputs(Predicate.or.compose(this, otherPredicate)));
	}

	/**
	 * Transforms this immutable predicate into a seemingly mutable predicate.
	 *
	 * This is especially useful to compose this predicate with actual {@link MutablePredicate}s.
	 *
	 * @return a {@link MutablePredicate} that boxes the result of this predicate.
	 */
	public MutablePredicate<E> asMutablePredicate() {
		return MutablePredicate.asMutablePredicate(super.boxOutput());
	}

	/**
	 * Creates a predicate that tests its argument for equality with an other value.
	 *
	 * @param other
	 *            the value to compare the argument given to returned predicate with.
	 * @return a predicate that safely (with respect to null values) compares its argument to
	 *         the given other value.
	 * @param <E>
	 *            type of values on which the returned predicate operates.
	 */
	public static <E> Predicate<E> valueEquals(final E other) {
		return new Predicate<E>() {
			@Override
			public Boolean apply(E a) {
				if (other == null) {
					return a == null;
				} else {
					return other.equals(a);
				}
			}

			@Override
			public String toString() {
				return " == " + other;
			}
		};
	}

	/**
	 * Creates a predicate that tests if its argument is an instance of the given {@link Class}.
	 *
	 * @param clazz
	 *            the {@link Class} to check if the argument of the returned predicate is an instance of.
	 * @return a predicate that tests whether its argument is an instance of {@link Class} <code>clazz</code>.
	 * @param <E>
	 *            type of values on which the returned predicate operates.
	 */
	public static <E> Predicate<E> isInstanceOf(final java.lang.Class<? extends E> clazz) {
		return new Predicate<E>() {
			@Override
			public Boolean apply(E o) {
				return clazz.isInstance(o);
			}

			@Override
			public String toString() {
				return "isInstanceOf(" + clazz.getSimpleName() + ")";
			}
		};
	}

	/**
	 * Creates a predicate that tests if its argument is an instance of the given {@link IMetaClass}.
	 *
	 * @param clazz
	 *            the {@link IMetaClass} to check if the argument of the returned predicate is an instance of.
	 * @return a predicate that tests whether its argument is an instance of {@link IMetaClass} <code>clazz</code>.
	 * @param <E>
	 *            type of values on which the returned predicate operates.
	 */
	public static <E> Predicate<E> isInstanceOf(final IMetaClass<? extends E> clazz) {
		return new Predicate<E>() {
			@Override
			public Boolean apply(E o) {
				return clazz.isInstance(o);
			}

			@Override
			public String toString() {
				return "isInstanceOf(" + clazz + ")";
			}
		};
	}

	/**
	 * Creates a predicate that tests if its argument is an instance of the given {@link EClass}.
	 *
	 * @param clazz
	 *            the {@link EClass} to check if the argument of the returned predicate is an instance of.
	 * @return a predicate that tests whether its argument is an instance of {@link EClass} <code>clazz</code>.
	 * @param <E>
	 *            type of values on which the returned predicate operates.
	 */
	public static <E> Predicate<E> isInstanceOf(final EClass clazz) {
		return new Predicate<E>() {
			@Override
			public Boolean apply(E o) {
				return clazz.isInstance(o);
			}

			@Override
			public String toString() {
				return "isInstanceOf(" + clazz.getName() + ")";
			}
		};
	}

	/**
	 * Converts the given {@link IUnaryFunction} into a {@link Predicate}.
	 *
	 * @param predicate
	 *            the predicate to convert.
	 * @return a predicate that is actually an instance class {@link Predicate}.
	 * @param <E>
	 *            type of values on which the returned predicate operates.
	 */
	public static <E> Predicate<E> asPredicate(final IUnaryFunction<? super E, Boolean> predicate) {
		if (predicate instanceof Predicate) {
			return (Predicate<E>) predicate;
		} else {
			return new Predicate<E>() {
				@Override
				public Boolean apply(E a) {
					return predicate.apply(a);
				}

				@Override
				public String toString() {
					return predicate.toString() + ".asPredicate()";
				}
			};
		}
	}
}