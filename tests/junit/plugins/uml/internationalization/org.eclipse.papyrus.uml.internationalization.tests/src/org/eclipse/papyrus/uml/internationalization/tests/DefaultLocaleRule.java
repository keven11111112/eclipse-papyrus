/*******************************************************************************
 * Copyright (c) 2017 Christian W. Damus and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Christian W. Damus - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.uml.internationalization.tests;

import java.util.Locale;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * A JUnit rule that sets the VM's default locale for the duration of a test.
 *
 * @author Christian W. Damus
 */
public class DefaultLocaleRule implements TestRule {

	private final Locale locale;

	private Locale restore;

	public DefaultLocaleRule(Locale locale) {
		super();

		this.locale = locale;
	}

	@Override
	public Statement apply(Statement base, Description description) {
		return new Statement() {
			@Override
			public void evaluate() throws Throwable {
				restore = Locale.getDefault();

				Locale.setDefault(locale);

				try {
					base.evaluate();
				} finally {
					Locale.setDefault(restore);
				}
			}
		};
	}

}
