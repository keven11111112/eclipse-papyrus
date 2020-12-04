/*****************************************************************************
 * Copyright (c) 2017 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 * Benoit Maggi (CEA LIST) benoit.maggi@cea.fr - Initial API and implementation
 * 
 *****************************************************************************/
package aspects.xpt.diagram.edithelpers;

import org.eclipse.papyrus.gmf.codegen.gmfgen.GenDiagram

public class BaseEditHelper extends xpt.diagram.edithelpers.BaseEditHelper {

	override superClass(GenDiagram it) '''org.eclipse.papyrus.infra.gmfdiag.tooling.runtime.edit.helpers.GeneratedEditHelperBase'''

	override def editPolicyCommandConstant(GenDiagram it) '''org.eclipse.papyrus.infra.gmfdiag.tooling.runtime.edit.helpers.GeneratedEditHelperBase.EDIT_POLICY_COMMAND'''

	override def contextElementTypeConstant(GenDiagram it) '''org.eclipse.papyrus.infra.gmfdiag.tooling.runtime.edit.helpers.GeneratedEditHelperBase.CONTEXT_ELEMENT_TYPE'''


}
