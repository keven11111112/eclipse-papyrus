/*******************************************************************************
 * Copyright (c) 2012 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Nicolas Bros (Mia-Software) - Bug 379683 - customizable Tree content provider
 *******************************************************************************/
package org.eclipse.papyrus.emf.facet.custom.ui;

import org.eclipse.papyrus.emf.facet.custom.core.ICustomizationManager;
import org.eclipse.papyrus.emf.facet.custom.ui.internal.ResolvingCustomizedLabelProviderFactory;

/**
 * A factory to create instances of {@link ICustomizedLabelProvider} that work on proxy UI elements, by customizing the
 * resolved elements.
 *
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 * @since 0.2
 */
public interface IResolvingCustomizedLabelProviderFactory {
	IResolvingCustomizedLabelProviderFactory DEFAULT = new ResolvingCustomizedLabelProviderFactory();

	/**
	 * This method is used to instantiate a {@link ICustomizedLabelProvider}.
	 *
	 * @param customizationManager
	 *            the customization manager which has to used by the content provider.
	 * @return a label provider
	 */
	ICustomizedLabelProvider createCustomizedLabelProvider(ICustomizationManager customizationMgr);
}
