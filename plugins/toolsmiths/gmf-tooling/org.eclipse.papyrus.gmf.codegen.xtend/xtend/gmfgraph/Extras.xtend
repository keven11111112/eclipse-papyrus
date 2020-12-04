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
import org.eclipse.papyrus.gmf.gmfgraph.Figure
import org.eclipse.papyrus.gmf.gmfgraph.SVGFigure
import org.eclipse.papyrus.gmf.gmfgraph.SVGProperty
import org.eclipse.papyrus.gmf.gmfgraph.SVGPropertyType
import xpt.Common

@com.google.inject.Singleton class Extras {
	@Inject extension Utils_qvto
	@Inject extension Common

	def dispatch extraMethods(Figure it) ''''''

	def dispatch extraMethods(SVGFigure it) '''
		«FOR p : properties»
			«svgProperty(p)»
		«ENDFOR»
	'''

	def svgProperty(SVGProperty it) '''
		«IF getter != null»
			«svgPropertyGetter(it)»
		«ENDIF»
		«IF setter != null»
			«svgPropertySetter(it)»
		«ENDIF»
	'''

	def svgPropertyGetter(SVGProperty it) '''
		«generatedMemberComment»
		public «svgPropertyType(it)» «getter»() {
			org.w3c.dom.NodeList nodes = getNodes("«it.query»"); //$NON-NLS-1$
			if (nodes.getLength() > 0) {
				org.w3c.dom.Element element = (org.w3c.dom.Element) nodes.item(0);
				«IF type == SVGPropertyType::COLOR»
					return getColor(element, "«attribute»"); «nonNLS(1)»
				«ELSEIF type == SVGPropertyType::FLOAT»
					String value = element.getAttributeNS(null, "«attribute»"); «nonNLS(1)»
					return Float.parseFloat(value);
				«ELSE»
					return element.getAttributeNS(null, "«attribute»"); «nonNLS(1)»
				«ENDIF»
			}
			«IF type == SVGPropertyType::FLOAT»
				return 0;
			«ELSE»
				return null;
			«ENDIF»
		}
	'''

	def svgPropertySetter(SVGProperty it) '''
		«generatedMemberComment»
		public void «setter»(«svgPropertyType(it)» value) {
			«IF type == SVGPropertyType::COLOR»
				String svalue = org.eclipse.gmf.runtime.lite.svg.SVGUtils.toSVGColor(getDocument(), value);
			«ELSEIF type == SVGPropertyType::FLOAT»
				String svalue = Float.toString(value);
			«ENDIF»
			org.w3c.dom.NodeList nodes = getNodes("«it.query»"); «nonNLS(1)»
			for (int i = 0; i < nodes.getLength(); i++) {
				((org.w3c.dom.Element) nodes.item(i)).setAttributeNS(null, "«attribute»", «nonNLS(1)»
					«IF type == SVGPropertyType::STRING»value«ELSE»svalue«ENDIF»);
			}
			«IF callSuper»
				super.«setter»(value);
			«ENDIF»
		}
	'''

}
