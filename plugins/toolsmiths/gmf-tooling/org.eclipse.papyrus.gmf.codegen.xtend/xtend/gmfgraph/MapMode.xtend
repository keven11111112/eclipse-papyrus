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

import org.eclipse.papyrus.gmf.gmfgraph.Dimension
import org.eclipse.papyrus.gmf.gmfgraph.Insets
import org.eclipse.papyrus.gmf.gmfgraph.Point

/**
 * No mapMode at all, provided only as hook for extenders
 */
@com.google.inject.Singleton class MapMode {
	def dispatch mapMode(Dimension it) '''«dx», «dy»'''

	def dispatch mapMode(Point it) '''«x», «y»'''

	def dispatch mapMode(Integer it) '''«it»'''

	def dispatch mapMode(Insets it) '''«top», «left», «bottom», «right»'''

	def Activator() ''''''
}
