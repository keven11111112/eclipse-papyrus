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

import org.eclipse.papyrus.gmf.gmfgraph.LineKind
import org.eclipse.papyrus.gmf.gmfgraph.Polygon

/**
 *	org.eclipse.draw2d.Shape
 *	private boolean fill = true, outline = true, xorFill, xorOutline;
 *	lineAttributes.width = 1.0
 *	lineAttributes.style = LINE_SOLID
 */
@com.google.inject.Singleton class Shape {

	def shapeAttrs(org.eclipse.papyrus.gmf.gmfgraph.Shape it, String figureVarName) '''
	«fill(it, figureVarName)»
	«IF it.xorFill»«xorFill(it, figureVarName)»«ENDIF»
	«IF !it.outline»«outline(it, figureVarName)»«ENDIF»
	«IF it.xorOutline»«xorOutline(it, figureVarName)»«ENDIF»
	«IF it.lineWidth != 1»«lineWidth(it, figureVarName)»«ENDIF»
	«IF it.lineKind != LineKind::LINE_SOLID_LITERAL»«lineKind(it, figureVarName)»«ENDIF»
	'''

	def dispatch fill(org.eclipse.papyrus.gmf.gmfgraph.Shape it, String figureVarName) '''
	«IF !fill»«figureVarName».setFill(«fill»);
	«ENDIF»
	'''

	def dispatch fill(Polygon it, String figureVarName) '''
	«IF it.fill»«figureVarName».setFill(«it.fill»);
	«ENDIF»
	'''

	def xorFill(org.eclipse.papyrus.gmf.gmfgraph.Shape it, String figureVarName) '''
	«figureVarName».setFillXOR(«xorFill»);
	'''

	def outline(org.eclipse.papyrus.gmf.gmfgraph.Shape it, String figureVarName) '''
	«figureVarName».setOutline(«outline»);
	'''

	def xorOutline(org.eclipse.papyrus.gmf.gmfgraph.Shape it, String figureVarName) '''
	«figureVarName».setOutlineXOR(«xorOutline»);
	'''

	def lineWidth(org.eclipse.papyrus.gmf.gmfgraph.Shape it, String figureVarName) '''
	«figureVarName».setLineWidth(«lineWidth»);
	'''

	def lineKind(org.eclipse.papyrus.gmf.gmfgraph.Shape it, String figureVarName) '''
	«figureVarName».setLineStyle(org.eclipse.draw2d.Graphics.«lineKind»);
	'''

}
