/*****************************************************************************
 * Copyright (c) 2007, 2009 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 * Alexander Shatalin (Borland) - initial API and implementation
 * Gabriel Pascual (ALL4TEC) -  Bug 372322
 * 
 *****************************************************************************/
package aspects.xpt.diagram.updater

import com.google.inject.Singleton
import org.eclipse.papyrus.gmf.codegen.gmfgen.GenDiagramUpdater

@Singleton class Extensions extends xpt.diagram.updater.extensions{
	
	override def extensions(GenDiagramUpdater it) {
		// Override Refresh contribution
	}
	
}