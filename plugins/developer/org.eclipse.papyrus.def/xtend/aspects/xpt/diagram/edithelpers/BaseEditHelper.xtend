/*****************************************************************************
 * Copyright (c) 2017 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Benoit Maggi (CEA LIST) benoit.maggi@cea.fr - Initial API and implementation
 *****************************************************************************/
package aspects.xpt.diagram.edithelpers;

import org.eclipse.gmf.codegen.gmfgen.GenDiagram

public class BaseEditHelper extends xpt.diagram.edithelpers.BaseEditHelper {

	override superClass(GenDiagram it) '''org.eclipse.gmf.tooling.runtime.edit.helpers.GeneratedEditHelperBase'''

	override def editPolicyCommandConstant(GenDiagram it) '''org.eclipse.gmf.tooling.runtime.edit.helpers.GeneratedEditHelperBase.EDIT_POLICY_COMMAND'''

	override def contextElementTypeConstant(GenDiagram it) '''org.eclipse.gmf.tooling.runtime.edit.helpers.GeneratedEditHelperBase.CONTEXT_ELEMENT_TYPE'''


}
