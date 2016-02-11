/*****************************************************************************
 * Copyright (c) 2010, 2016 CEA LIST, Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *  Christian W. Damus - bug 485220
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.providers;

/**
 *
 * a paste provider has provide operation in order to paste by taking account system clipboard or papyrus clipboard
 *
 * @deprecated Use the {@link org.eclipse.papyrus.infra.gmfdiag.common.providers.IPasteCommandProvider} API, instead
 */
@Deprecated
public interface IPasteCommandProvider extends org.eclipse.papyrus.infra.gmfdiag.common.providers.IPasteCommandProvider {
	// Nothing additional
}
