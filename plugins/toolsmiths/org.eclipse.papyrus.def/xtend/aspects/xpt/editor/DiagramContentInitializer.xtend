/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 * Florian Noyrit - Initial API and implementation
 * 
 *****************************************************************************/
package aspects.xpt.editor

import aspects.xpt.Common
import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.papyrus.gmf.codegen.gmfgen.GenContainerBase
import org.eclipse.papyrus.gmf.codegen.gmfgen.GenDiagram

@Singleton class DiagramContentInitializer extends xpt.editor.DiagramContentInitializer {
	@Inject extension Common;

	@Inject VisualIDRegistry xptVisualIDRegistry;

	override def getCompartment(GenDiagram it) '''
		«generatedMemberComment»
		private org.eclipse.gmf.runtime.notation.Node getCompartment(org.eclipse.gmf.runtime.notation.View node, String visualID) {
			String type = «xptVisualIDRegistry.typeMethodCall(it, 'visualID')»;
			for (java.util.Iterator it = node.getChildren().iterator(); it.hasNext();) {
				org.eclipse.gmf.runtime.notation.View nextView = (org.eclipse.gmf.runtime.notation.View) it.next();
				if (nextView instanceof org.eclipse.gmf.runtime.notation.Node && type.equals(nextView.getType())) {
					return (org.eclipse.gmf.runtime.notation.Node) nextView;
				}
			}
			return null;
		}
	'''

	override def createChildrenMethodName(GenContainerBase it) '''create«it.stringUniqueIdentifier»_Children'''

}