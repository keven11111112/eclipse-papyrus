/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.junit.framework.classification;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * Indicates that this test has been generated with the Papyrus Test Generation Framework
 * (see https://wiki.eclipse.org/Papyrus_Developer_Guide/Automatic_Test_Generation_for_Diagram_Editors)
 *
 *
 * This annotation must be used with the {@link ClassificationRule}
 *
 * @author Camille Letavernier
 * @since 1.2
 *
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface GeneratedTest {

	/**
	 * A description
	 *
	 * @return
	 */
	String value() default "";
}
