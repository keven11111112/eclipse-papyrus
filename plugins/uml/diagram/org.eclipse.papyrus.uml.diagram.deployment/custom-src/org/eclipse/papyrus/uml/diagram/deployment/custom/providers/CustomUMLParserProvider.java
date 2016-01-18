package org.eclipse.papyrus.uml.diagram.deployment.custom.providers;

import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.papyrus.uml.diagram.common.parser.stereotype.AppliedStereotypeParser;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DeploymentAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ManifestationAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.providers.UMLParserProvider;

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
		case DeploymentAppliedStereotypeEditPart.VISUAL_ID:
			return getAppliedStereotypeParser("deployment"); //$NON-NLS-1$
		case ManifestationAppliedStereotypeEditPart.VISUAL_ID:
			return getAppliedStereotypeParser("manifestation"); //$NON-NLS-1$
		}
		return super.getParser(visualID);
	}
}