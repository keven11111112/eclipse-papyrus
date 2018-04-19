/*****************************************************************************
 * Copyright (c) 2018 Christian W. Damus and others.
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

package org.eclipse.papyrus.uml.diagram.sequence.util;

import java.util.function.BooleanSupplier;

import org.eclipse.papyrus.uml.diagram.sequence.part.UMLDiagramEditorPlugin;
import org.eclipse.swt.widgets.Display;

/**
 * A deferred action that posts itself asynchronously on the {@link Display} thread
 * and re-tries some limited number of times if its initial conditions are not met.
 * 
 * @since 5.0
 */
public abstract class RetryingDeferredAction {
	private static final int DEFAULT_RETRY_LIMIT = 3;

	private final Display display;
	private final int retryLimit;
	private volatile int retries;

	/**
	 * Initializes me.
	 * 
	 * @param display
	 *            the display on which I post myself for delayed execution
	 * @param retryLimit
	 *            the number of times I may retry
	 * 
	 * @throws IllegalArgumentException
	 *             if the retry limit is non-positive
	 */
	public RetryingDeferredAction(Display display, int retryLimit) {
		super();

		if (retryLimit <= 0) {
			throw new IllegalArgumentException("retry limit must be positive"); //$NON-NLS-1$
		}

		this.display = display;
		this.retryLimit = retryLimit;
	}

	/**
	 * Initializes me with the default number (three) of retries.
	 * 
	 * @param display
	 *            the display on which I post myself for delayed execution
	 */
	public RetryingDeferredAction(Display display) {
		this(display, DEFAULT_RETRY_LIMIT);
	}

	/**
	 * Initializes me with the current display.
	 * 
	 * @param retryLimit
	 *            the number of times I may retry
	 * 
	 * @throws IllegalArgumentException
	 *             if the retry limit is non-positive
	 */
	public RetryingDeferredAction(int retryLimit) {
		this(Display.getCurrent(), retryLimit);
	}

	/**
	 * Initializes me with the current display and the default number (three) of retries.
	 */
	public RetryingDeferredAction() {
		this(Display.getCurrent(), DEFAULT_RETRY_LIMIT);
	}

	/**
	 * Try an {@code action} up to the given number of times, deferred on the {@code display} thread.
	 * This is useful for the simple case where it is only necessary to attempt to perform the
	 * action and there is no need for an explicit preparation step.
	 * 
	 * @param display
	 *            the display on which thread to defer the {@code action}
	 * @param retryLimit
	 *            the maximal number of times to tr-try the {@code action}
	 * @param action
	 *            the action to perform. If it returns {@code false}, then it will
	 *            be re-tried (unless the limit is exceeded, of course)
	 * 
	 * @throws IllegalArgumentException
	 *             if the retry limit is non-positive
	 */
	public static void defer(Display display, int retryLimit, BooleanSupplier action) {
		new Wrapper(display, retryLimit, action).post();
	}

	/**
	 * Try an {@code action} up to the default number (three) of times, deferred on the {@code display} thread.
	 * 
	 * @param display
	 *            the display on which thread to defer the {@code action}
	 * @param action
	 *            the action to perform
	 */
	public static void defer(Display display, BooleanSupplier action) {
		defer(display, DEFAULT_RETRY_LIMIT, action);
	}

	/**
	 * Try an {@code action} up to the given number of times, deferred on the current display thread.
	 * 
	 * @param retryLimit
	 *            the maximal number of times to tr-try the {@code action}
	 * @param action
	 *            the action to perform
	 * 
	 * @throws IllegalArgumentException
	 *             if the retry limit is non-positive
	 */
	public static void defer(int retryLimit, BooleanSupplier action) {
		defer(Display.getCurrent(), retryLimit, action);
	}

	/**
	 * Try an {@code action} up to the default number (three) of times, deferred on the current display thread.
	 * 
	 * @param action
	 *            the action to perform
	 */
	public static void defer(BooleanSupplier action) {
		defer(Display.getCurrent(), DEFAULT_RETRY_LIMIT, action);
	}

	/**
	 * Prepares me for execution, testing my initial conditions and setting up any
	 * required state.
	 * 
	 * @return {@code true} if my initial conditions are satisfied and I may {@link #perform()};
	 *         {@code false}, otherwise
	 */
	protected abstract boolean prepare();

	/**
	 * Performs me. Will not be called unless {@link #prepare()} returned {@code true}.
	 */
	protected abstract void perform();

	private void run() {
		if (prepare()) {
			perform();
		} else {
			retries = retries + 1;
			post();
		}
	}

	/**
	 * Post me for deferred execution.
	 */
	public void post() {
		if (retries < retryLimit) {
			display.asyncExec(this::run);
		} else {
			UMLDiagramEditorPlugin.log.warn("Retry limit exceeded for " + this); //$NON-NLS-1$
		}
	}

	//
	// Nested types
	//

	private static final class Wrapper extends RetryingDeferredAction {
		private final BooleanSupplier action;

		Wrapper(Display display, int retryLimit, BooleanSupplier action) {
			super(display, retryLimit);

			this.action = action;
		}

		@Override
		protected boolean prepare() {
			return action.getAsBoolean();
		}

		@Override
		protected void perform() {
			// Already done in the preparation step
		}
	}
}
