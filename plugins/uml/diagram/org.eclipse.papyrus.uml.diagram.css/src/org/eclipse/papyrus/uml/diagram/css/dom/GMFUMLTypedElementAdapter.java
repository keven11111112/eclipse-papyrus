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

import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.ExtendedCSSEngine;

/**
 * DOM Element Adapter for UML Elements
 *
 * Supports type applied stereotypes and stereotype properties
 *
 * @author Shuai Li
 * @since 2.0
 * @deprecated Use/Extend {@link GMFUMLElementAdapter} instead
 */
@Deprecated
public class GMFUMLTypedElementAdapter extends GMFUMLElementAdapter {

	//Deprecated, empty class
	
	public GMFUMLTypedElementAdapter(View view, ExtendedCSSEngine engine) {
		super(view, engine);
	}
	
}
