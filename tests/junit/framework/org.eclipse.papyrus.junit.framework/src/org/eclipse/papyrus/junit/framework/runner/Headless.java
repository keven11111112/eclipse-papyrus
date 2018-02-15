/*****************************************************************************
 * Copyright (c) 2016 Christian W. Damus and others.
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

package org.eclipse.papyrus.junit.framework.runner;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marker annotation for test suites that can (and should be) run in "headless mode"
 * (without the Eclipse Workbench).
 * 
 * @since 1.2
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.PACKAGE })
public @interface Headless {
	// Empty
}
