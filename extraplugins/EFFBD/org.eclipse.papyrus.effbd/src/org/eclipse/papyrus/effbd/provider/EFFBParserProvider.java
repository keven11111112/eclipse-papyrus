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
 *		Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.effbd.provider;

import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;

/**
 * Parser provider for labels used by the parametric diagram.
 */
public class EFFBParserProvider extends AbstractParserProvider implements IParserProvider {

	/**
	 * Constructor.
	 *
	 */
	public EFFBParserProvider() {
		graphicalHintToParser.put("opaqueAction_body", new org.eclipse.papyrus.effbd.OpaqueActionBodyParser());
	}

}