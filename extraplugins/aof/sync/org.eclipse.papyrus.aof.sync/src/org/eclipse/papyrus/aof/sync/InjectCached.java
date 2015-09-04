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

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.inject.Inject;

/**
 * An alternative to {@link Inject @Inject} indicating that the injected
 * dependency is to be a caching variant of what would normally be
 * injected. Thus, this annotation is only applicable to dependency
 * types that provide cached variants of themselves.
 * 
 * @see CacheProvider
 */
@Retention(RUNTIME)
@Target({ FIELD, METHOD })
@Documented
public @interface InjectCached {
	// Empty
}
