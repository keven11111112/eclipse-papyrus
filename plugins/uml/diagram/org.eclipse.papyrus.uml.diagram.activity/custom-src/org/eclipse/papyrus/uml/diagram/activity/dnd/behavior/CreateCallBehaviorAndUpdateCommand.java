/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Francois Le Fevre (CEA LIST) francois.le-fevre@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.dnd.behavior;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.uml.diagram.activity.dnd.GenericCreateTAndUpdateCommand;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ActivityActivityContentCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ActivityCNContentCompartmentEditPart;
import org.eclipse.uml2.uml.UMLPackage;


/**
 * 
 *
 */
public class CreateCallBehaviorAndUpdateCommand<T extends EObject ,E extends EObject, S extends EObject> extends GenericCreateTAndUpdateCommand<T, E, S> {

	public CreateCallBehaviorAndUpdateCommand(EditPart targetEditPart,  Class<T> typeParameterClass, E activity, S behavior, boolean headless, IHintedType typeToCreate) {
		super(targetEditPart,typeParameterClass,activity,behavior,headless,typeToCreate);
	}

	// Sets the slot's property (definingFeature) and initialize its value (property#defaultValue)
	public void updateNewlyCreatedEObjectWithEObjectDragged(T slot, S property) throws ExecutionException {
		SetRequest setFeatureRequest = new SetRequest(slot, UMLPackage.eINSTANCE.getCallBehaviorAction_Behavior(), property);
		SetValueCommand setFeatureCommand = new SetValueCommand(setFeatureRequest);
		setFeatureCommand.execute(new NullProgressMonitor(), null);
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.activity.dnd.InterfaceCreateTAndUpdateCommand#isSlotCompartmentAvailable(org.eclipse.gef.EditPart)
	 *
	 * @param targetEditPart
	 * @return
	 */
	@Override
	public boolean isSlotCompartmentAvailable(EditPart targetEditPart) {
		if (targetEditPart instanceof ActivityActivityContentCompartmentEditPart
				|| targetEditPart instanceof ActivityCNContentCompartmentEditPart) {
			return true;
		}
		for (Object editPartObject : targetEditPart.getChildren()) {
			if (isSlotCompartmentAvailable((EditPart) editPartObject)) {
				return true;
			}
		}
		return false;
	}

}
