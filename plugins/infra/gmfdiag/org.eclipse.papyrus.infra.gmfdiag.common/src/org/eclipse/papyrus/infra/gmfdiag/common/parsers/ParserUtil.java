/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.parsers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserService;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.adapter.NotationAndTypeAdapter;
import org.eclipse.papyrus.infra.gmfdiag.common.helper.NotationHelper;

/**
 * @author Camille Letavernier
 *
 */
public class ParserUtil {

	public static IParser getParser(IElementType type, EObject parserElement, EditPart editPart, String visualID) {
		IAdaptable hintAdapter = getParserAdapter(type, parserElement, editPart, visualID);
		return ParserService.getInstance().getParser(hintAdapter);
	}

	public static IAdaptable getParserAdapter(IElementType type, EObject parserElement, EditPart editPart, String visualID) {
		View view = NotationHelper.findView(editPart);
		if (visualID == null) {
			visualID = view == null ? null : view.getType();
		}
		return new NotationAndTypeAdapter(type, parserElement, view, visualID);
	}

	public static IAdaptable getParserAdapter(EObject parserElement, EditPart editPart) {
		return getParserAdapter(null, parserElement, editPart, null);
	}

}

