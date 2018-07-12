/*****************************************************************************
 * Copyright (c) 2012, 2015 CEA LIST, Christian W. Damus, and others.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *  Christian W. Damus - bug 462979
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.service.types.helper;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.MoveRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.infra.tools.util.TypeUtils;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.ActivityPartition;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InterruptibleActivityRegion;
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

	public static final String OUT_FROM_PARTITION = "OUT_FROM_PARTITION";

	public static final String OUT_FROM_INTERRUPTIBLE_REGION = "OUT_FROM_REGION";

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

	public static ICommand getMoveOutFromPartitionCommand(MoveRequest req) {
		if (req.getParameter(OUT_FROM_PARTITION) != null) {
			CompositeCommand cc = new CompositeCommand("Move Out From Parition");//$NON-NLS-1$
			ActivityPartition outFromPartition = (ActivityPartition) req.getParameter(OUT_FROM_PARTITION);
			for (Object elementToMove : req.getElementsToMove().keySet()) {
				if (false == elementToMove instanceof ActivityNode) {
					continue;
				}
				ActivityNode node = (ActivityNode) elementToMove;
				List<ActivityPartition> inPartitions = new LinkedList<ActivityPartition>(node.getInPartitions());
				if (inPartitions.contains(outFromPartition)) {
					inPartitions.remove(outFromPartition);
					cc.add(new SetValueCommand(new SetRequest(node, UMLPackage.eINSTANCE.getActivityNode_InPartition(), inPartitions)));
				}
			}
			return cc.isEmpty() ? null : cc.reduce();
		}
		return null;
	}

	public static ICommand getMoveOutFromInterruptibleActivityRegionCommand(MoveRequest req) {
		if (req.getParameter(OUT_FROM_INTERRUPTIBLE_REGION) != null) {
			CompositeCommand cc = new CompositeCommand("Move Out From InterruptibleActivityRegion");//$NON-NLS-1$
			InterruptibleActivityRegion outFromRegion = (InterruptibleActivityRegion) req.getParameter(OUT_FROM_INTERRUPTIBLE_REGION);
			for (Object elementToMove : req.getElementsToMove().keySet()) {
				if (false == elementToMove instanceof ActivityNode) {
					continue;
				}
				ActivityNode node = (ActivityNode) elementToMove;
				List<InterruptibleActivityRegion> inRegion = new LinkedList<InterruptibleActivityRegion>(node.getInInterruptibleRegions());
				if (inRegion.contains(outFromRegion)) {
					inRegion.remove(outFromRegion);
					cc.add(new SetValueCommand(new SetRequest(node, UMLPackage.eINSTANCE.getActivityNode_InInterruptibleRegion(), inRegion)));
				}
			}
			return cc.isEmpty() ? null : cc.reduce();
		}
		return null;
	}
}
