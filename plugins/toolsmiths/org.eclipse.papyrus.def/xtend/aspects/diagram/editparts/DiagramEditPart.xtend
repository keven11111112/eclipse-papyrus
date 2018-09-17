/*****************************************************************************
 * Copyright (c) 2006, 2010, 2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 * Dmitry Stadnik (Borland) - initial API and implementation
 * Alexander Shatalin (Borland) - initial API and implementation
 * Michael Golubev (Montages) - #386838 - migrate to Xtend2
 * 
 *****************************************************************************/
package aspects.diagram.editparts

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.gmf.codegen.gmfgen.GenDiagram

@Singleton class DiagramEditPart extends diagram.editparts.DiagramEditPart {

	@Inject aspects.impl.diagram.editparts.DiagramEditPart aspectDiagramEditPart;

	//BEGIN: PapyrusGenCode
	//patches the super type of the diagram edit part in case the controlled object represents a UML element
	override extendsList(GenDiagram it) '''extends «aspectDiagramEditPart.extendsListContents(it)»'''
	//END: PapyrusGenCode
}
