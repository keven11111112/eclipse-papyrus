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

package org.eclipse.papyrus.aof.sync.tests.runners;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Qualifier;

import com.google.inject.Provides;

/**
 * A qualifier annotation for injection of the test instance, itself, as a dependency.
 * This is only useful for injection providers, such as {@link Provides @Provides}
 * methods of a Guice module.
 */
@Retention(RUNTIME)
@Qualifier
@Documented
public @interface TestInstance {
	// Marker interface
}
