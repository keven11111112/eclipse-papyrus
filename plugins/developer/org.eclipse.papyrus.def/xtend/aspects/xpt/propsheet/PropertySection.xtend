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
package aspects.xpt.propsheet

import com.google.inject.Singleton
import org.eclipse.gmf.codegen.gmfgen.GenCustomPropertyTab

@Singleton class PropertySection extends xpt.propsheet.PropertySection {

	override extendsList(GenCustomPropertyTab it) '''extends org.eclipse.gmf.tooling.runtime.sheet.DefaultPropertySection'''
	
}
