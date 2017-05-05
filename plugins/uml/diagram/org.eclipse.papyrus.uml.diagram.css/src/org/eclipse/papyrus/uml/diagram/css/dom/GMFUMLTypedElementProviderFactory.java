/*****************************************************************************
 * Copyright (c) 2017 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Shuai Li <shuai.li@cea.fr> (CEA LIST) - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.css.dom;

import org.eclipse.papyrus.infra.gmfdiag.css.notation.CSSDiagram;
import org.eclipse.papyrus.infra.gmfdiag.css.provider.IPapyrusElementProvider;
import org.eclipse.papyrus.uml.diagram.css.dom.GMFUMLElementProviderFactory;

/**
 * IElementProvider Factory for Diagrams related to UML TypedElements
 *
 * @author Shuai Li
 * @since 2.0
 *
 */
public class GMFUMLTypedElementProviderFactory extends GMFUMLElementProviderFactory {
	@Override
	public IPapyrusElementProvider createProvider(CSSDiagram diagram) {
		return new GMFUMLTypedElementProvider();
	}
}
