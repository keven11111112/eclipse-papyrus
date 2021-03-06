/*******************************************************************************
 * Copyright (c) 2009 EclipseSource and others. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which accompanies this distribution,
t https://www.eclipse.org/legal/epl-2.0/
t
t SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   EclipseSource - initial API and implementation
 ******************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.css.engine.enginecopy;

import java.util.Comparator;

import org.eclipse.papyrus.infra.gmfdiag.css.engine.ExtendedCSSEngine.CascadeScope;
import org.w3c.dom.css.CSSStyleDeclaration;

/**
 * A wrapper that holds a reference to the styles defined in a CSS rule block,
 * together with all the information needed to calculate a matching selector's
 * precedence.
 */
// Copied from org.eclipse.e4.ui.css.core.impl.dom.StyleWrapper
final class StyleWrapper {

	private static class StyleWrapperComparator implements Comparator<StyleWrapper> {

		@Override
		public int compare(final StyleWrapper wrapper1, final StyleWrapper wrapper2) {
			int result = 0;

			if (wrapper1.scope.getOrder() > wrapper2.scope.getOrder()) {
				result = 1;
			} else if (wrapper1.scope.getOrder() < wrapper2.scope.getOrder()) {
				result = -1;
			} else if (wrapper1.specificity > wrapper2.specificity) {
				result = 1;
			} else if (wrapper1.specificity < wrapper2.specificity) {
				result = -1;
			} else if (wrapper1.position > wrapper2.position) {
				result = 1;
			} else if (wrapper1.position < wrapper2.position) {
				result = -1;
			}

			return result;
		}
	}

	/**
	 * A comparator for {@link StyleWrapper}s.
	 */
	public static final StyleWrapperComparator COMPARATOR = new StyleWrapperComparator();

	public final CSSStyleDeclaration style;

	public final int specificity;

	public final int position;

	public final CascadeScope scope;

	public StyleWrapper(CSSStyleDeclaration style, int specificity, int position, CascadeScope scope) {
		this.style = style;
		this.specificity = specificity;
		this.position = position;
		this.scope = scope;
	}
}
