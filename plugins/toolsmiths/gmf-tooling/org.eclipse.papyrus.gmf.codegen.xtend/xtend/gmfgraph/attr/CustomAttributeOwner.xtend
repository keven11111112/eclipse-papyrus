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

import java.text.MessageFormat
import org.eclipse.papyrus.gmf.gmfgraph.CustomAttribute
import org.eclipse.papyrus.gmf.gmfgraph.CustomClass

/**
 * During Xpand->Xtend2 conversion this class had been merged with CustomClass.xpt
 */
@com.google.inject.Singleton class CustomAttributeOwner {

	def customAttributes(org.eclipse.papyrus.gmf.gmfgraph.CustomAttributeOwner it, String instanceVarName) '''
		«FOR attr : it.attributes»
			«customAttribute(attr, instanceVarName)»
		«ENDFOR»
	'''

	def Init(CustomClass it, String instanceVarName) '''«customAttributes(it, instanceVarName)»'''

	def customAttribute(CustomAttribute it, String instanceVarName) '''
		«customAttrValueImpl(it)»
		«IF directAccess»
			«instanceVarName».«name» = «customAttrValue(it)»;
		«ELSE»
			«instanceVarName».set«name.toFirstUpper»(«customAttrValue(it)»);
		«ENDIF»
	'''

	def customAttrValueImpl(CustomAttribute it) '''
		«IF multiStatementValue»
			«MessageFormat::format(it.value, 'attr' + name.toFirstUpper)»
		«ENDIF»
	'''

	def customAttrValue(CustomAttribute it) '''
		«IF multiStatementValue»attr«name.toFirstUpper»«ELSE»«value»«ENDIF»
	'''

}
