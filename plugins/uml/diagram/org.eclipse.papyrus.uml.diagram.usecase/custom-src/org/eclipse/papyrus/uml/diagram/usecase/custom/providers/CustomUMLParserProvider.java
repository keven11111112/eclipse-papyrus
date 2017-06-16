/*****************************************************************************
 * Copyright (c) 2015-2017 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST- Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.usecase.custom.providers;

import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.papyrus.uml.diagram.common.keyword.KeywordLabel;
import org.eclipse.papyrus.uml.diagram.common.parser.stereotype.AppliedKeywordParser;
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

	/**
	 * @since 3.0
	 */
	protected IParser getAppliedKeywordParser(String defaultPrintString) {
		return new AppliedKeywordParser(defaultPrintString);
	}
	
	@Override
	protected IParser getParser(String visualID) {
		switch (visualID) {
		case AppliedStereotypeAbstractionEditPart.VISUAL_ID:
			return getAppliedKeywordParser(KeywordLabel.ABSTRACTION);
		case AppliedStereotypePackageMergeEditPart.VISUAL_ID:
			return getAppliedKeywordParser(KeywordLabel.MERGE);
		case AppliedStereotypeUsageEditPart.VISUAL_ID:
			return getAppliedStereotypeParser(KeywordLabel.USE);
		case PackageImportAppliedStereotypeEditPart.VISUAL_ID:
			return getAppliedKeywordParser(KeywordLabel.IMPORT);
		}
		return super.getParser(visualID);
	}
}