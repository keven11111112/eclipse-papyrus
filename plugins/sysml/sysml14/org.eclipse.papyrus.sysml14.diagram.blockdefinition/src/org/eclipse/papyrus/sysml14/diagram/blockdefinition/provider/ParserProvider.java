/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml14.diagram.blockdefinition.provider;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.parser.ConstraintLabelParser;

/**
 * Parser provider for labels used by this diagram.
 */
public class ParserProvider extends AbstractProvider implements IParserProvider {

	/** map from graphical hint to parsers */
	private static final Map<String, IParser> graphicalHintToParser = new HashMap<String, IParser>();

	static {
		graphicalHintToParser.put("Constraint_Label", new ConstraintLabelParser());
		}

	/**
	 * {@inheritDoc}
	 */
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();


			return getParser(hint) != null;
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	public IParser getParser(IAdaptable hint) {
		String parserHint = (String) hint.getAdapter(String.class);
		if (parserHint != null) {
			IParser parser = graphicalHintToParser.get(parserHint);
			if (parser != null) {
				return parser;
			}
		}

		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			IParser parser = graphicalHintToParser.get(view.getType());
			if (parser != null) {
				return parser;
			}
		}

		return null;
	}

	private String getDiagramType(IAdaptable hint) {
		Diagram diagram = (Diagram) hint.getAdapter(Diagram.class);
		if (diagram != null) {
			return diagram.getType();
		}

		return "undefined";
	}

}