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
package gmfgraph.attr

import com.google.inject.Inject
import gmfgraph.MapMode
import org.eclipse.papyrus.gmf.gmfgraph.Point
import org.eclipse.papyrus.gmf.gmfgraph.PolygonDecoration
import org.eclipse.papyrus.gmf.gmfgraph.Polyline
import org.eclipse.papyrus.gmf.gmfgraph.PolylineDecoration

@com.google.inject.Singleton class Decoration {
	@Inject Figure xptFigure;
	@Inject MapMode xptMapMode;
	@Inject Shape xptShape;

	def dispatch polylineAttrs(PolylineDecoration it, String figureVarName) '''
		«xptShape.shapeAttrs(it, figureVarName)»
		«xptFigure.figureAttrs(it, figureVarName)»
		«templatePoints(it, figureVarName)»
		«scale(it, figureVarName)»
	'''

	def dispatch polylineAttrs(PolygonDecoration it, String figureVarName) '''
		«xptShape.shapeAttrs(it, figureVarName)»
		«xptFigure.figureAttrs(it, figureVarName)»
		«templatePoints(it, figureVarName)»
		«scale(it, figureVarName)»
	'''

	def templatePoints(Polyline it, String figureVarName) '''
		«IF !template.empty»
			org.eclipse.draw2d.geometry.PointList pl = new org.eclipse.draw2d.geometry.PointList();
			«FOR p : it.template»
				«templatePoint(p, 'pl')»
			«ENDFOR»
			«figureVarName».setTemplate(pl);
		«ENDIF»
	'''

	def templatePoint(Point it, String pointListVarName) '''
		«pointListVarName».addPoint(«xptMapMode.mapMode(it)»);
	'''

	def dispatch scale(PolylineDecoration it, String figureVarName) '''
		«IF !template.empty»
			«figureVarName».setScale(«xptMapMode.mapMode(7)», «xptMapMode.mapMode(3)»);
		«ENDIF»
	'''

	def dispatch scale(PolygonDecoration it, String figureVarName) '''
		«IF !template.empty»
			«figureVarName».setScale(«xptMapMode.mapMode(7)», «xptMapMode.mapMode(3)»);
		«ENDIF»
	'''

}
