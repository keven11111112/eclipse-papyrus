/*******************************************************************************
 * Copyright (c) 2007, 2020 Borland Software Corporation, CEA LIST, Artal and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/ 
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors: 
 *    Dmitry Stadnik (Borland) - initial API and implementation
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package xpt.providers

import org.eclipse.papyrus.gmf.codegen.gmfgen.GenCommonBase
import org.eclipse.papyrus.gmf.codegen.xtend.annotations.MetaDef

@com.google.inject.Singleton class ParserUtils_qvto {

	@MetaDef def String parserFieldName(GenCommonBase element) {
		return element.uniqueIdentifier.toFirstLower + 'Parser'
	}

	@MetaDef def String parserAccessorName(GenCommonBase element) {
		return 'get' + element.uniqueIdentifier.toFirstUpper + 'Parser'
	}

}
