/*****************************************************************************
 * Copyright (c) 2009-2011 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.composite.custom.providers;

import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.papyrus.uml.diagram.common.parser.stereotype.AppliedStereotypeParser;
import org.eclipse.papyrus.uml.diagram.composite.custom.parsers.ConnectorLabelParser;
import org.eclipse.papyrus.uml.diagram.composite.custom.parsers.MultiplicityLabelParser;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.AbstractionAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.ConnectorMultiplicitySourceEditPart;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.ConnectorMultiplicityTargetEditPart;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.ConnectorNameEditPart;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.DeploymentAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.InformationFlowAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.ManifestationAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.SubstitutionAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.UsageAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.composite.providers.UMLParserProvider;

public class CustomParserProvider extends UMLParserProvider {

	public CustomParserProvider() {
		super();
	}

	protected IParser getAppliedStereotypeParser(String defaultEditString) {
		return new AppliedStereotypeParser(defaultEditString);
	}

	@Override
	protected IParser getParser(String visualID) {
		switch (visualID) {
		case ConnectorMultiplicitySourceEditPart.VISUAL_ID:
		case ConnectorMultiplicityTargetEditPart.VISUAL_ID:
			return getMultiplicityFormatParser();
		case ConnectorNameEditPart.VISUAL_ID:
			return getConnectorLabelParser();
		case AbstractionAppliedStereotypeEditPart.VISUAL_ID:
			return getAppliedStereotypeParser("abstraction"); //$NON-NLS-1$
		case DeploymentAppliedStereotypeEditPart.VISUAL_ID:
			return getAppliedStereotypeParser("deployment"); //$NON-NLS-1$
		case InformationFlowAppliedStereotypeEditPart.VISUAL_ID:
			return getAppliedStereotypeParser("flow"); //$NON-NLS-1$
		case ManifestationAppliedStereotypeEditPart.VISUAL_ID:
			return getAppliedStereotypeParser("manifestation"); //$NON-NLS-1$
		case SubstitutionAppliedStereotypeEditPart.VISUAL_ID:
			return getAppliedStereotypeParser("substitution"); //$NON-NLS-1$
		case UsageAppliedStereotypeEditPart.VISUAL_ID:
			return getAppliedStereotypeParser("use"); //$NON-NLS-1$
		}
		return super.getParser(visualID);
	}

	private IParser getConnectorLabelParser() {
		return new ConnectorLabelParser();
	}

	private IParser getMultiplicityFormatParser() {
		return new MultiplicityLabelParser();
	}
}
