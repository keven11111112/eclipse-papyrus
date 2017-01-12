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
package aspects.impl.actions

import com.google.inject.Singleton

@Singleton class LoadResourceAction extends impl.actions.LoadResourceAction{

	override def extendsList(org.eclipse.gmf.codegen.gmfgen.LoadResourceAction it) //
	''' extends org.eclipse.gmf.tooling.runtime.actions.DefaultLoadResourceAction'''

}
