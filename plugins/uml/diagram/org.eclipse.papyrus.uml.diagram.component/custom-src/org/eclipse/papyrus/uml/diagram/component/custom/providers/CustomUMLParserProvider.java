/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.component.custom.providers;

import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.papyrus.uml.diagram.common.parser.stereotype.AppliedStereotypeParser;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.AbstractionAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ManifestationAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.SubstitutionAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.UsageAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.component.providers.UMLParserProvider;

/**
 * @since 3.0
 */
public class CustomUMLParserProvider extends UMLParserProvider {

	public CustomUMLParserProvider() {
		super();
	}

	protected IParser getAppliedStereotypeParser(String defaultEditString) {
		return new AppliedStereotypeParser(defaultEditString);
	}

	@Override
	protected IParser getParser(String visualID) {
		switch (visualID) {
		case AbstractionAppliedStereotypeEditPart.VISUAL_ID:
			return getAppliedStereotypeParser("abstraction"); //$NON-NLS-1$
		case ManifestationAppliedStereotypeEditPart.VISUAL_ID:
			return getAppliedStereotypeParser("manifestation"); //$NON-NLS-1$
		case SubstitutionAppliedStereotypeEditPart.VISUAL_ID:
			return getAppliedStereotypeParser("substitution"); //$NON-NLS-1$
		case UsageAppliedStereotypeEditPart.VISUAL_ID:
			return getAppliedStereotypeParser("use"); //$NON-NLS-1$
		}
		return super.getParser(visualID);
	}
}
