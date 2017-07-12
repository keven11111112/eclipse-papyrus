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

import java.util.LinkedList;
import java.util.List;

import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.ExtendedCSSEngine;
import org.eclipse.papyrus.infra.tools.util.ListHelper;
import org.eclipse.papyrus.uml.diagram.css.dom.GMFUMLElementAdapter;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.TypedElement;

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

	public static final String TYPE_APPLIED_STEREOTYPES_PROPERTY = "typeAppliedStereotypes"; //$NON-NLS-1$

	public GMFUMLTypedElementAdapter(View view, ExtendedCSSEngine engine) {
		super(view, engine);
	}

	/**
	 * {@inheritDoc}
	 *
	 * Typed applied stereotypes are manipulated as DOM attributes
	 */
	@Override
	protected String doGetAttribute(String attr) {
		// Semantic properties
		String parentValue = super.doGetAttribute(attr);
		if (parentValue != null) {
			return parentValue;
		}

		if (attr.equals(TYPE_APPLIED_STEREOTYPES_PROPERTY) && semanticElement instanceof TypedElement) {
			Type type = ((TypedElement) semanticElement).getType();
			if (type != null) {
				List<String> appliedStereotypes = new LinkedList<>();
				for (Stereotype stereotype : type.getAppliedStereotypes()) {
					appliedStereotypes.add(stereotype.getName());
					appliedStereotypes.add(stereotype.getQualifiedName());
				}

				if (!appliedStereotypes.isEmpty()) {
					return ListHelper.deepToString(appliedStereotypes, CSS_VALUES_SEPARATOR);
				}
			}
		}

		return null;
	}
}
