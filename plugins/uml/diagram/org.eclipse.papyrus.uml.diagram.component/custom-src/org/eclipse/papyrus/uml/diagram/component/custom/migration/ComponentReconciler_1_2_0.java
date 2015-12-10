/*****************************************************************************
 * Copyright (c) 2010, 2015 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	 Florian Noyrit  (CEA) florian.noyrit@cea.fr - Initial API and Implementation
 *   Mickael ADAM (ALL4TEC) mickael.adam@all4tec.net - reconciler to add floating label
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.component.custom.migration;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.AbstractCommand;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.reconciler.DiagramReconciler;

/**
 * Component Diagram Reconciler from 1.1.0 to 1.2.0
 */
public class ComponentReconciler_1_2_0 extends DiagramReconciler {

	@Override
	public ICommand getReconcileCommand(Diagram diagram) {
		CompositeCommand cc = new CompositeCommand("Migrate diagram from 1.1.0 to 1.2.0");
		cc.add(new ChangeVisualIDsCommand(diagram));
		return cc;
	}

	protected class ChangeVisualIDsCommand extends AbstractCommand {

		protected final Diagram diagram;

		public ChangeVisualIDsCommand(Diagram diagram) {
			super("Change the diagram's visual ids from 1.1.0 to 1.2.0");
			this.diagram = diagram;
		}

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
			TreeIterator<EObject> allContentIterator = diagram.eAllContents();

			while (allContentIterator.hasNext()) {
				EObject eObject = allContentIterator.next();
				if (eObject instanceof View) {
					View view = (View) eObject;
					view.setType(getNewVisualID(view.getType()));
				}
			}

			return CommandResult.newOKCommandResult();
		}

		@Override
		public boolean canUndo() {
			return false;
		}

		@Override
		public boolean canRedo() {
			return false;
		}

		@Override
		protected CommandResult doRedoWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
			throw new ExecutionException("Should not be called, canRedo false");
		}

		@Override
		protected CommandResult doUndoWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
			throw new ExecutionException("Should not be called, canUndo false");
		}
	}

	public static String getNewVisualID(String oldVisualID) {
		switch (oldVisualID) {
		case "1000":
			return "Package_ComponentDiagram";
		case "3069":
			return "Port_Shape";
		case "5006":
			return "Port_NameLabel";
		case "5007":
			return "Port_StereotypeLabel";
		case "3077":
			return "Model_Shape_CN";
		case "5264":
			return "Model_NameLabel_CN";
		case "3076":
			return "Package_Shape_CN";
		case "5261":
			return "Package_NameLabel_CN";
		case "3078":
			return "Interface_ClassifierShape_CN";
		case "5267":
			return "Interface_ClassifierNameLabel_CN";
		case "6033":
			return "Interface_ClassifierFloatingNameLabel_CN";
		case "3070":
			return "Component_PackagedElementShape_CCN";
		case "5256":
			return "Component_NameLabel_CCN";
		case "6026":
			return "Component_FloatingNameLabel_CCN";
		case "3071":
			return "Component_PackagedElementShape_CN";
		case "5257":
			return "Component_NameLabel_CN";
		case "6027":
			return "Component_FloatingNameLabel_CN";
		case "3074":
			return "Comment_Shape_CN";
		case "5258":
			return "Comment_BodyLabel_CN";
		case "3075":
			return "Constraint_Shape_CN";
		case "5259":
			return "Constraint_NameLabel_CN";
		case "5260":
			return "Constraint_BodyLabel_CN";
		case "1":
			return "Property_InterfaceAttributeLabel";
		case "5":
			return "Operation_InterfaceOperationLabel";
		case "6":
			return "Reception_InterfaceReceptionLabel";
		case "3072":
			return "Interface_Shape_CN";
		case "0":
			return "Interface_NameLabel_CN";
		case "6028":
			return "Interface_FloatingNameLabel_CN";
		case "3079":
			return "Property_Shape";
		case "5268":
			return "Property_NameLabel";
		case "3203":
			return "Dependency_Shape";
		case "5008":
			return "Dependency_MultiNameLabel";
		case "6029":
			return "Dependency_FloatingNameLabel";
		case "2002":
			return "Component_PackagedElementShape";
		case "5004":
			return "Component_NameLabel";
		case "6030":
			return "Component_FloatingNameLabel";
		case "3202":
			return "Model_Shape";
		case "5262":
			return "Model_NameLabel";
		case "3200":
			return "Package_Shape";
		case "5254":
			return "Package_NameLabel";
		case "3205":
			return "Interface_ClassifierShape";
		case "5266":
			return "Interface_ClassifierNameLabel";
		case "6031":
			return "Interface_ClassifierFloatingNameLabel";
		case "3201":
			return "Comment_Shape";
		case "5255":
			return "Comment_BodyLabel";
		case "3199":
			return "Constraint_Shape";
		case "5252":
			return "Constraint_NameLabel";
		case "5253":
			return "Constraint_BodyLabel";
		case "3204":
			return "NamedElement_DefaultShape";
		case "5265":
			return "NamedElement_NameLabel";
		case "2003":
			return "Interface_Shape";
		case "5005":
			return "Interface_NameLabel";
		case "6032":
			return "Interface_FloatingNameLabel";
		case "4001":
			return "Usage_Edge";
		case "6016":
			return "Usage_NameLabel";
		case "6017":
			return "Usage_StereotypeLabel";
		case "4006":
			return "InterfaceRealization_Edge";
		case "6010":
			return "InterfaceRealization_NameLabel";
		case "6011":
			return "InterfaceRealization_StereotypeLabel";
		case "4003":
			return "Generalization_Edge";
		case "2":
			return "Generalization_StereotypeLabel";
		case "4012":
			return "Substitution_Edge";
		case "6006":
			return "Substitution_NameLabel";
		case "6020":
			return "Substitution_StereotypeLabel";
		case "4014":
			return "Manifestation_Edge";
		case "6008":
			return "Manifestation_NameLabel";
		case "6022":
			return "Manifestation_StereotypeLabel";
		case "4007":
			return "ComponentRealization_Edge";
		case "3":
			return "ComponentRealization_NameLabel";
		case "4":
			return "ComponentRealization_StereotypeLabel";
		case "4013":
			return "Abstraction_Edge";
		case "6007":
			return "Abstraction_NameLabel";
		case "6021":
			return "Abstraction_StereotypeLabel";
		case "4016":
			return "Link_DescriptorEdge";
		case "4015":
			return "Comment_AnnotatedElementEdge";
		case "4009":
			return "Constraint_ConstrainedElementEdge";
		case "4010":
			return "Dependency_Edge";
		case "6009":
			return "Dependency_NameLabel";
		case "6023":
			return "Dependency_StereotypeLabel";
		case "4017":
			return "Dependency_BranchEdge";
		case "4018":
			return "Link_InterfacePortEdge";
		case "4019":
			return "Connector_Edge";
		case "6024":
			return "Connector_StereotypeLabel";
		case "6025":
			return "Connector_NameLabel";
		case "7001":
			return "Component_StructureCompartment";
		case "7006":
			return "Model_PackagedElementCompartment";
		case "7002":
			return "Package_PackagedElementCompartment";
		case "7007":
			return "Model_PackagedElementCompartment_CN";
		case "7005":
			return "Package_PackagedElementCompartment_CN";
		case "7003":
			return "Component_StructureCompartment_CCN";
		case "7004":
			return "Component_StructureCompartment_CN";
		case "7008":
			return "Interface_AttributeCompartment";
		case "7009":
			return "Interface_OperationCompartment";
		case "7010":
			return "Interface_AttributeCompartment_CN";
		case "7011":
			return "Interface_OperationCompartment_CN";
		default:
			return defaultGetNewVisualID(oldVisualID);
		}
	}

	private static String defaultGetNewVisualID(String oldVisualID) {
		return oldVisualID;
	}
}
