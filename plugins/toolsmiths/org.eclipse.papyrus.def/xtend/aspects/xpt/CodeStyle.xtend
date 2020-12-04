/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 * Anatoliy Tischenko - Initial API and implementation
 * 
 *****************************************************************************/
package aspects.xpt

import org.eclipse.papyrus.gmf.codegen.gmfgen.GenCommonBase
import com.google.inject.Singleton

@Singleton class CodeStyle extends xpt.CodeStyle {

	override overrideI(GenCommonBase xptSelf) '''
		@Override
	'''

}