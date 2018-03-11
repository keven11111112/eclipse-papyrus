/**
 * Copyright (c) 2007, 2010, 2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 *    Artem Tikhomirov (Borland) - [257119] Create views directly, not through ViewFactories
 * 	  Michael Golubev (Montages) - #386838 - migrate to Xtend2
 *    Thibault Landre (Atos Origin) - initial API and implementation
 *	  Vincent Lorenzo (CEA-LIST) Add a line to initialize the display of the compartments to true
 *    Vincent Lorenzo (CEA-LIST) - Add lines to initialize the display of the labels - Bug 335987 [General][Enhancement] Show/Hide Connectors Labels and External Nodes Labels
 */
package aspects.xpt.providers

import com.google.inject.Singleton
import org.eclipse.gmf.codegen.gmfgen.GenDiagram

@Singleton class EditPartProvider extends xpt.providers.EditPartProvider {

	override def extendsList(GenDiagram it) '''extends org.eclipse.papyrus.infra.gmfdiag.common.providers.DefaultEditPartProvider'''

}
