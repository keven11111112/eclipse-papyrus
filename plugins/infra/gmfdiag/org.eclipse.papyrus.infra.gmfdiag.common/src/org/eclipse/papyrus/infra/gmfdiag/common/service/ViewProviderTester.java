/*****************************************************************************
 * Copyright (c) 2018 EclipseSource and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   EclipseSource - Initial API and implementation (Bug 533701)
 *
 *****************************************************************************/

package org.eclipse.papyrus.infra.gmfdiag.common.service;

import org.eclipse.gmf.runtime.diagram.core.providers.IViewProvider;
import org.eclipse.gmf.runtime.notation.View;

/**
 * <p>
 * A contribution to the {@link ViewProviderService}
 * </p>
 *
 * @since 3.100
 */
public interface ViewProviderTester {

	/**
	 * Tests whether the given provider is allowed in the context of that edit part
	 *
	 * @param provider
	 * @param editPart
	 * @return
	 * 		<code>false</code> if this tester explicitly rejects this provider in the context of that edit part;
	 *         <code>true</code> otherwise.
	 */
	boolean isEnabled(IViewProvider provider, View view);
}

