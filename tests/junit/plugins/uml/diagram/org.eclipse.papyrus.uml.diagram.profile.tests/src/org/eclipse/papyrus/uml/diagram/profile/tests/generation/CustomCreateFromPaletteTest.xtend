/*****************************************************************************
 * Copyright (c) 2015 Christian W. Damus and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.profile.tests.generation

import javax.inject.Inject
import javax.inject.Singleton
import org.eclipse.papyrus.tests.framework.gmfgenuml2utp.CreateFromPaletteTest
import org.eclipse.papyrus.tests.framework.gmfgenuml2utp.TransformationUtilities
import org.eclipse.uml2.uml.CallOperationAction
import org.eclipse.uml2.uml.InstanceSpecification

/**
 * Customization of the create-from-palette test UTP transformation for profile diagrams, to
 * account for specific custom editing behaviours of this diagram.
 */
 @Singleton
class CustomCreateFromPaletteTest extends CreateFromPaletteTest {
	@Inject extension TransformationUtilities
	final String defaultAssociationName = 'srcMul'
	
	override protected def toCallTestLinkOperationActivity(InstanceSpecification linkEditPart, InstanceSpecification sourceEditPart, InstanceSpecification targetEditPart) {
		super.toCallTestLinkOperationActivity(linkEditPart, sourceEditPart, targetEditPart) => [
			if (linkEditPart.editPart == 'AssociationEditPart') {
				// Insert a parameter for the association name (invokes a different overloaded variant of the framework method)
				ownedNodes.filter(CallOperationAction).head.arguments.add(3, defaultAssociationName.toValuePin('initialName'))
			}
		]
	}

	override protected def toCallTestLinkOperationActivity(InstanceSpecification linkEditPart, InstanceSpecification sourceEditPart, InstanceSpecification targetEditPart, InstanceSpecification containerEditPart) {
		super.toCallTestLinkOperationActivity(linkEditPart, sourceEditPart, targetEditPart, containerEditPart) => [
			if (linkEditPart.editPart == 'AssociationEditPart') {
				// Insert a parameter for the association name (invokes a different overloaded variant of the framework method)
				ownedNodes.filter(CallOperationAction).head.arguments.add(4, defaultAssociationName.toValuePin('initialName'))
			}
		]
	}	
}
