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

package org.eclipse.papyrus.junit.matchers;

import java.util.function.Predicate;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

/**
 * Matchers for commands of various flavours, which are defined in nested classes.
 * 
 * @since 2.2
 */
public final class CommandMatchers {

	/**
	 * Not instantiable by clients.
	 */
	private CommandMatchers() {
		super();
	}

	static <C> Matcher<C> executable(Predicate<? super C> canExecute) {
		return new TypeSafeMatcher<C>() {
			@Override
			public void describeTo(Description description) {
				description.appendText("unexecutable");
			}

			@Override
			protected boolean matchesSafely(C item) {
				return canExecute.test(item);
			}
		};
	}

	/**
	 * Matchers for GMF commands.
	 * 
	 * @since 2.2
	 */
	public static final class GMF {
		/**
		 * Not instantiable by clients.
		 */
		private GMF() {
			super();
		}

		public static Matcher<org.eclipse.gmf.runtime.common.core.command.ICommand> canExecute() {
			return executable(org.eclipse.gmf.runtime.common.core.command.ICommand::canExecute);
		}
	}

	/**
	 * Matchers for EMF commands.
	 * 
	 * @since 2.2
	 */
	public static class EMF {
		/**
		 * Not instantiable by clients.
		 */
		private EMF() {
			super();
		}

		public static Matcher<org.eclipse.emf.common.command.Command> canExecute() {
			return executable(org.eclipse.emf.common.command.Command::canExecute);
		}
	}

	/**
	 * Matchers for GEF commands.
	 * 
	 * @since 2.2
	 */
	public static final class GEF {
		/**
		 * Not instantiable by clients.
		 */
		private GEF() {
			super();
		}

		public static Matcher<org.eclipse.gef.commands.Command> canExecute() {
			return executable(org.eclipse.gef.commands.Command::canExecute);
		}
	}
}
