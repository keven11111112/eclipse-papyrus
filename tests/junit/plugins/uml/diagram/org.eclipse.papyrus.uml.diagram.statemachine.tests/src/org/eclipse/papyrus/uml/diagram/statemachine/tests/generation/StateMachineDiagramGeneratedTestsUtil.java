/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.statemachine.tests.generation;

import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.StateMachine;

import com.google.common.collect.Iterables;

/**
 * Utility APIs for the customizations in the generated State Machine Diagram tests.
 */
public class StateMachineDiagramGeneratedTestsUtil {

	private StateMachineDiagramGeneratedTestsUtil() {
		super();
	}

	/**
	 * Resolves the actual container edit part in which we want to create children, which
	 * is the first region's shape compartment if the given {@code container} is actually
	 * the state machine edit part or its (regions) shape compartment.
	 * 
	 * @param container
	 *            a container edit part
	 * @return the resolved preferred container, which may just be the same {@code container}
	 */
	public static IGraphicalEditPart resolveTopRegionCompartment(IGraphicalEditPart container) {
		IGraphicalEditPart result = container;

		if (result.resolveSemanticElement() instanceof StateMachine) {
			// Find the regions compartment
			result = getShapeCompartment(result);

			// Find the region in the state machine compartment
			result = getFirstGraphicalChild(result);

			if (result.resolveSemanticElement() instanceof Region) {
				// Find the region compartment
				result = getShapeCompartment(result);
			}
		}

		return result;
	}

	public static IGraphicalEditPart getShapeCompartment(IGraphicalEditPart editPart) {
		IGraphicalEditPart result = editPart;

		if (!(result instanceof ShapeCompartmentEditPart)) {
			// Find the regions compartment
			for (ShapeCompartmentEditPart next : Iterables.filter(result.getChildren(), ShapeCompartmentEditPart.class)) {
				result = next;
				break;
			}
		}

		return result;
	}

	public static IGraphicalEditPart getFirstGraphicalChild(IGraphicalEditPart editPart) {
		IGraphicalEditPart result = editPart;

		for (IGraphicalEditPart next : Iterables.filter(result.getChildren(), IGraphicalEditPart.class)) {
			result = next;
			break;
		}

		return result;
	}
}
