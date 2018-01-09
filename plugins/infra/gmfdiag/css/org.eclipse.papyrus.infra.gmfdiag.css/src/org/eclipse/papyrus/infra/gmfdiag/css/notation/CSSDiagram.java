/*****************************************************************************
 * Copyright (c) 2012, 2015 CEA LIST, Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Christian W. Damus - bug 464443
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.css.notation;

import java.util.List;

import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.ExtendedCSSEngine;
import org.eclipse.papyrus.infra.gmfdiag.css.style.CSSView;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StyleSheet;

/**
 * A GMF Diagram with CSS Support
 *
 * @author Camille Letavernier
 *
 */
public interface CSSDiagram extends Diagram, CSSView {

	/**
	 * Returns the list of stylesheets directly owned by this diagram
	 *
	 * @return
	 */
	public List<StyleSheet> getStyleSheets();

	/**
	 * Returns the CSS Engine associated to this diagram
	 *
	 * @return
	 */
	public ExtendedCSSEngine getEngine();

}
