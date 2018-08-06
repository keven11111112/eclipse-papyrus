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
package aspects.xpt.editor

import com.google.inject.Singleton
import org.eclipse.gmf.codegen.gmfgen.GenDiagram

@Singleton class ModelElementSelectionPage extends xpt.editor.ModelElementSelectionPage{

	override def extendsList(GenDiagram it) '''extends org.eclipse.papyrus.infra.gmfdiag.tooling.runtime.part.DefaultModelElementSelectionPage'''

}
