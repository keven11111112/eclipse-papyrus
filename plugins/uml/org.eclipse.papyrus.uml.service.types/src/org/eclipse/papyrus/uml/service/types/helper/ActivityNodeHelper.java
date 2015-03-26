/*****************************************************************************
 * Copyright (c) 2012, 2015 CEA LIST, Christian W. Damus, and others.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *  Christian W. Damus - bug 462979
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.service.types.helper;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.infra.tools.util.TypeUtils;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * A customization of the destroy and configure commands for activity nodes to account for
 * the bizarre {@link Element#getOwnedElements() Element::ownedElement} override in {@link Activity} that has {@code node} and {@code group} subsetting {@code ownedElement} instead of {@code ownedNode} and {@code ownedGroup}.
 * 
 * @see https://bugs.eclipse.org/bugs/show_bug.cgi?id=463177
 */
public class ActivityNodeHelper extends ElementEditHelper {

	/**
	 * Parameter name for {@link ConfigureRequest} Used to pass the actual partition instance to set {@link ActivityNode#getInPartition()}
	 */
	public static final String IN_PARTITION = "IN_PARTITION"; //$NON-NLS-1$

	public static final String IN_INTERRUPTIBLE_ACTIVITY_REGION = "IN_INTERRUPTIBLE_ACTIVITY_REGION"; //$NON-NLS-1$

	@Override
	protected ICommand getBasicDestroyElementCommand(DestroyElementRequest req) {
		ICommand result = req.getBasicDestroyCommand();

		if (result == null) {
			result = new DestroyActivityOwnedElementCommand(req);
		} else {
			// ensure that re-use of this request will not accidentally
			// propagate this command, which would destroy the wrong object
			req.setBasicDestroyCommand(null);
		}

		return result;
	}

	@Override
	protected ICommand getConfigureCommand(ConfigureRequest req) {
		if (req.getParameter(IN_PARTITION) != null) {
			return new SetValueCommand(new SetRequest((EObject) req.getParameter(IN_PARTITION), UMLPackage.eINSTANCE.getActivityPartition_Node(), req.getElementToConfigure()));
		}
		if (req.getParameter(IN_INTERRUPTIBLE_ACTIVITY_REGION) != null) {
			return new SetValueCommand(new SetRequest((EObject) req.getParameter(IN_INTERRUPTIBLE_ACTIVITY_REGION), UMLPackage.eINSTANCE.getInterruptibleActivityRegion_Node(), req.getElementToConfigure()));
		}
		return super.getConfigureCommand(req);
	}

	/**
	 * Basic destruction command for owned elements of activities.
	 * 
	 * @see https://bugs.eclipse.org/bugs/show_bug.cgi?id=463177
	 */
	static class DestroyActivityOwnedElementCommand extends DestroyElementCommand {

		DestroyActivityOwnedElementCommand(DestroyElementRequest request) {
			super(request);
		}

		@Override
		protected void tearDownIncomingReferences(EObject destructee) {
			Activity activity = TypeUtils.as(destructee.eContainer(), Activity.class);
			if (activity != null) {
				// Forcibly remove it from invalid subsets of Activity::ownedElement
				activity.getNodes().remove(destructee);
				activity.getGroups().remove(destructee);
			}

			super.tearDownIncomingReferences(destructee);
		}
	}
}
