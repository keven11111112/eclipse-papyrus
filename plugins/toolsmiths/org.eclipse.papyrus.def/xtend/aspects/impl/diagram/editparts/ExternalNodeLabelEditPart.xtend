/*****************************************************************************
 * Copyright (c) 2014 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 * CEA LIST - Initial API and implementation
 * 
 *****************************************************************************/

package aspects.impl.diagram.editparts

import org.eclipse.gmf.codegen.gmfgen.GenExternalNodeLabel

/**
 * @author Mickael ADAM
 *
 */
class ExternalNodeLabelEditPart extends impl.diagram.editparts.ExternalNodeLabelEditPart {

	override additionalEditPolicies(GenExternalNodeLabel it){
	'''
		installEditPolicy(org.eclipse.gef.EditPolicy.PRIMARY_DRAG_ROLE, new org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.ExternalLabelPrimaryDragRoleEditPolicy());
	'''
	}
	
}