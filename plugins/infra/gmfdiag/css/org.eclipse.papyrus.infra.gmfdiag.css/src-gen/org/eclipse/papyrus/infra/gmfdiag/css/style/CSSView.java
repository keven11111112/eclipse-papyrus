/*****************************************************************************
 * Copyright (c) 2013, 2015 CEA LIST, Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *  Christian W. Damus - bug 433206
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.css.style;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.gmf.runtime.notation.NamedStyle;
import org.eclipse.gmf.runtime.notation.Style;
import org.eclipse.gmf.runtime.notation.View;


public interface CSSView {

	/**
	 * CSS Implementation of the isVisible() method
	 *
	 * @return
	 *
	 * @see View#isVisible()
	 */
	public boolean isCSSVisible();

	/**
	 * CSS Implementation of the getNamedStyle() method
	 *
	 * @param eClass
	 * @param name
	 * @return
	 *
	 * @see View#getNamedStyle(EClass, String)
	 */
	public NamedStyle getCSSNamedStyle(EClass eClass, String name);

	/**
	 * CSS implementation of the {@link View#getStyle(EClass)} API.
	 * 
	 * @param eClass
	 *            the style kind to get
	 * @return the (possibly implicitly defined) CSS implementation of the style
	 * 
	 * @see View#getStyle(EClass)
	 */
	public Style getCSSStyle(EClass eClass);
}
