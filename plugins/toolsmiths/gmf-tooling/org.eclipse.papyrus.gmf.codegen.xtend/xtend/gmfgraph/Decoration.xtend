
/*******************************************************************************
 * Copyright (c) 2006, 2020 Borland Software Corporation, CEA LIST, Artal and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/ 
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors: 
 *    Artem Tikhomirov (Borland) - initial API and implementation
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 *    Aurelien Didier (ARTAL) - aurelien.didier51@gmail.com - Bug 569174
 *****************************************************************************/
package gmfgraph

import com.google.inject.Inject
import org.eclipse.papyrus.gmf.gmfgraph.DecorationFigure
import org.eclipse.papyrus.gmf.gmfgraph.PolygonDecoration
import org.eclipse.papyrus.gmf.gmfgraph.PolylineDecoration

/**
 * Instantiate and define attributes for DecorationFigures
 */
@com.google.inject.Singleton class Decoration {

	@Inject Runtime xptRuntime;
	@Inject Attrs xptAttrs;
	@Inject gmfgraph.attr.Decoration xptDecorationAttrs;

	def dispatch Instantiate(DecorationFigure it, String figureVarName) '''
		«xptRuntime.newInstance(it, figureVarName)»
		«xptAttrs.Init(it, figureVarName)»
	'''

	def dispatch Instantiate(PolylineDecoration it, String figureVarName) '''
		«xptRuntime.newInstance(it, figureVarName)»
		«xptDecorationAttrs.polylineAttrs(it, figureVarName)»
	'''

	/**
	 * Copy of above template for PolylineDecoration, 
	 * just because PolygonDecoration doesn't extend PolylineDecoration in draw2d and gmfgraph
	 */
	def dispatch Instantiate(PolygonDecoration it, String figureVarName) '''
		«xptRuntime.newInstance(it, figureVarName)»
		«xptDecorationAttrs.polylineAttrs(it, figureVarName)»
	'''

}
