package org.eclipse.papyrus.uml.diagram.usecase.custom.providers;

import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.papyrus.uml.diagram.common.parser.stereotype.AppliedStereotypeParser;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.AppliedStereotypeAbstractionEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.AppliedStereotypePackageMergeEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.AppliedStereotypeUsageEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.PackageImportAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.providers.UMLParserProvider;

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
		case AppliedStereotypeAbstractionEditPart.VISUAL_ID:
			return getAppliedStereotypeParser("abstraction"); //$NON-NLS-1$
		case AppliedStereotypePackageMergeEditPart.VISUAL_ID:
			return getAppliedStereotypeParser("merge"); //$NON-NLS-1$
		case AppliedStereotypeUsageEditPart.VISUAL_ID:
			return getAppliedStereotypeParser("use"); //$NON-NLS-1$
		case PackageImportAppliedStereotypeEditPart.VISUAL_ID:
			return getAppliedStereotypeParser("import"); //$NON-NLS-1$
		}
		return super.getParser(visualID);
	}
}