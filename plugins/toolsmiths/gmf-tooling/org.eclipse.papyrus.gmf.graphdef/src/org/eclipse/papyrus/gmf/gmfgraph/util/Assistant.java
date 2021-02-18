/*******************************************************************************
 * Copyright (c) 2006, 2020 Borland Software Corporation, CEA LIST, ARTAL
 * 
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License 2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-2.0/
 * 
 *  SPDX-License-Identifier: EPL-2.0
 * 
 *  Contributors:
 *     Borland - initial API and implementation
 *     Aurelien Didier (ARTAL) - aurelien.didier51@gmail.com - Bug 569174
 ******************************************************************************/
package org.eclipse.papyrus.gmf.gmfgraph.util;

import org.eclipse.emf.common.util.URI;

/**
 * Utility methods to deal with sample/shared/well-known models that are part of this plug-in.  
 * @author artem
 */
public class Assistant {
	private static URI basicGraphDef;

	public static URI getBasicGraphDef() {
		if (basicGraphDef == null) {
			basicGraphDef = URI.createURI("platform:/plugin/org.eclipse.papyrus.gmf.graphdef/models/basic.gmfgraph");
		}
		return basicGraphDef;
	}
}
