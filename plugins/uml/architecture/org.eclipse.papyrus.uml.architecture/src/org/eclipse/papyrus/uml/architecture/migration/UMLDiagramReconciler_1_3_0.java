/*****************************************************************************
 * Copyright (c) 2017 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	 Maged Elaasar - Initial API and Implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.architecture.migration;

import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.infra.core.architecture.RepresentationKind;
import org.eclipse.papyrus.infra.core.architecture.merged.MergedArchitectureDescriptionLanguage;
import org.eclipse.papyrus.infra.architecture.ArchitectureDomainManager;
import org.eclipse.papyrus.infra.gmfdiag.common.reconciler.DiagramReconciler_1_3_0;
import org.eclipse.papyrus.infra.gmfdiag.representation.PapyrusDiagram;
import org.eclipse.papyrus.infra.viewpoints.style.PapyrusViewStyle;
import org.eclipse.papyrus.uml.architecture.UMLArchitectureContextIds;

/**
 * UML Diagram Reconciler from 1.2.0 to 1.3.0 that switches the old PapyrusViewStyle by
 * the new PapyrusDiagramStyle
 */
public class UMLDiagramReconciler_1_3_0 extends DiagramReconciler_1_3_0 {

	private static final String ACTIVITY_DIAGRAM = "PapyrusUMLActivityDiagram";
	private static final String CLASS_DIAGRAM = "PapyrusUMLClassDiagram";
	private static final String COMMUNICATION_DIAGRAM = "PapyrusUMLCommunicationDiagram";
	private static final String COMPONENT_DIAGRAM = "PapyrusUMLComponentDiagram";
	private static final String COMPOSITE_STRUCTURE_DIAGRAM = "CompositeStructure";
	private static final String DEPLOYMENT_DIAGRAM = "PapyrusUMLDeploymentDiagram";
	private static final String INTERACTION_OVERVIEW_DIAGRAM = "PapyrusUMLInteractionOverviewDiagram";
	private static final String PROFILE_DIAGRAM = "PapyrusUMLProfileDiagram";
	private static final String SEQUENCE_DIAGRAM = "PapyrusUMLSequenceDiagram";
	private static final String STATE_MACHINE_DIAGRAM = "PapyrusUMLStateMachineDiagram";
	private static final String TIMING_DIAGRAM = "PapyrusUMLTimingDiagram";
	private static final String USE_CASE_DIAGRAM = "UseCase";
	
	/**
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.reconciler.DiagramReconciler_1_3_0#getPapyrusDiagram(org.eclipse.papyrus.infra.viewpoints.style.PapyrusViewStyle)
	 *
	 * @param oldStyle
	 * @return
	 */
	@Override
	protected PapyrusDiagram getDiagramKind(Diagram diagram, PapyrusViewStyle oldStyle) {
		if (oldStyle != null) {
			org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusDiagram oldDiagramKind =
				(org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusDiagram) oldStyle.getConfiguration();
			if (oldDiagramKind != null)
				return getDiagramKind(oldDiagramKind.getName(), diagram);
		}
		if (ACTIVITY_DIAGRAM.equals(diagram.getType())) {
			return getDiagramKind("Activity Diagram", diagram);
		} else if (CLASS_DIAGRAM.equals(diagram.getType())) {
			return getDiagramKind("Class Diagram", diagram);
		} else if (COMMUNICATION_DIAGRAM.equals(diagram.getType())) {
			return getDiagramKind("Communication Diagram", diagram);
		} else if (COMPONENT_DIAGRAM.equals(diagram.getType())) {
			return getDiagramKind("Component Diagram", diagram);
		} else if (COMPOSITE_STRUCTURE_DIAGRAM.equals(diagram.getType())) {
			return getDiagramKind("Composite Structure Diagram", diagram);
		} else if (DEPLOYMENT_DIAGRAM.equals(diagram.getType())) {
			return getDiagramKind("Deployment Diagram", diagram);
		} else if (INTERACTION_OVERVIEW_DIAGRAM.equals(diagram.getType())) {
			return getDiagramKind("Interaction Overview Diagram", diagram);
		} else if (PROFILE_DIAGRAM.equals(diagram.getType())) {
			return getDiagramKind("Profile Diagram", diagram);
		} else if (SEQUENCE_DIAGRAM.equals(diagram.getType())) {
			return getDiagramKind("Sequence Diagram", diagram);
		} else if (STATE_MACHINE_DIAGRAM.equals(diagram.getType())) {
			return getDiagramKind("State Machine Diagram", diagram);
		} else if (TIMING_DIAGRAM.equals(diagram.getType())) {
			return getDiagramKind("Timing Diagram", diagram);
		} else if (USE_CASE_DIAGRAM.equals(diagram.getType())) {
			return getDiagramKind("Use Case Diagram", diagram);
		}
		return null;
	}

	/**
	 * Gets the diagram kind that matches given name and that supports the given diagram
	 */
	protected PapyrusDiagram getDiagramKind(String name, Diagram diagram) {
		ArchitectureDomainManager manager = ArchitectureDomainManager.getInstance();
		MergedArchitectureDescriptionLanguage context = (MergedArchitectureDescriptionLanguage) manager.getArchitectureContextById(UMLArchitectureContextIds.UML);
		for(RepresentationKind pKind : context.getRepresentationKinds()) {
			if (pKind.getName().equals(name)) {
				PapyrusDiagram dKind = (PapyrusDiagram) pKind;
				if (dKind.getModelRules().get(0).getElement().isInstance(diagram.getElement())) {
					return dKind;
				}
			}
		}
		return null;
	}
}
