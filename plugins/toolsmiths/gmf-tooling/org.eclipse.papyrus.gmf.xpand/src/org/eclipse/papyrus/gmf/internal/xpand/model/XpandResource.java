/******************************************************************************
 * Copyright (c) 2005, 2008 Sven Efftinge, CEA LIST, Artal and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/ 
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors: 
 *     Sven Efftinge - Initial API and implementation
 *     Artem Tikhomirov (Borland) - Migration to OCL expressions
 */
package org.eclipse.papyrus.gmf.internal.xpand.model;

import org.eclipse.papyrus.gmf.internal.xpand.ResourceMarker;

public interface XpandResource extends XpandAnalyzable, ResourceMarker {
	public static final String TEMPLATE_EXTENSION = "xpt";

	String getFullyQualifiedName(); // [artem] from Resource XXX reconsider - almost useless?

    XpandDefinition[] getDefinitions();

    XpandAdvice[] getAdvices();
}
