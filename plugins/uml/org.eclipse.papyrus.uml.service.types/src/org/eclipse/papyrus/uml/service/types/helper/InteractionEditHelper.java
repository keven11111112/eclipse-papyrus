/*****************************************************************************
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 
 * 		Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.service.types.helper;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.GetEditContextRequest;

public class InteractionEditHelper extends ElementEditHelper {

	/**
	 * @see org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelper#getEditContextCommand(org.eclipse.gmf.runtime.emf.type.core.requests.GetEditContextRequest)
	 *
	 * @param req
	 * @return
	 */
	@Override
	protected ICommand getEditContextCommand(GetEditContextRequest req) {
		return super.getEditContextCommand(req);
	}





}
