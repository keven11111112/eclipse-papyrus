/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.sysml14.diagram.blockdefinition.dnd;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateNodeViewOperation;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementMatcher;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.emf.type.core.ISpecializationType;
import org.eclipse.gmf.runtime.emf.type.core.SpecializationType;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.infra.gmfdiag.common.adapter.SemanticAdapter;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.GetChildLayoutEditPolicy;
import org.eclipse.papyrus.infra.gmfdiag.dnd.strategy.TransactionalDropStrategy;
import org.eclipse.papyrus.sysml14.diagram.blockdefinition.IDRegistry;
import org.eclipse.papyrus.sysml14.diagram.blockdefinition.editpart.DynamicListCompartmentEditPart;
import org.eclipse.papyrus.sysml14.diagram.blockdefinition.provider.BDDViewProvider;
import org.eclipse.papyrus.uml.diagram.common.service.AspectUnspecifiedTypeConnectionTool.CreateAspectUnspecifiedTypeConnectionRequest;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.UMLPackage;

/**

 *
 */
public class AddedElementDropStrategy extends TransactionalDropStrategy {

	private static final EStructuralFeature feature = UMLPackage.eINSTANCE.getInstanceSpecification_Classifier();

	public String getLabel() {
		return "Added Elemnt";
	}

	public String getID() {
		return "sysMLBDD1.4" + ".Added Elemnt";
	}

	public String getDescription() {
		return "Added Element";
	}

	public Image getImage() {
		return null;
	}

	public int getPriority() {
		return 0;
	}

	public void setOptions(Map<String, Object> options) {
		// Nothing
	}

	@Override
	public Command doGetCommand(Request request, final EditPart targetEditPart) {

		CompositeCommand cc = new CompositeCommand(getLabel());
		if(targetEditPart instanceof GraphicalEditPart){
			GraphicalEditPart graphicalEditPart= (GraphicalEditPart)targetEditPart;
			if( IDRegistry.FLOWPORT_COMPARMENT_NAME.equals(graphicalEditPart.getNotationView().getType())){
				List<EObject> sourceElements = getSourceEObjects(request);
				final List<EObject> valuesToAdd = new ArrayList<EObject>(sourceElements.size());
				for (EObject sourceElement : sourceElements) {
					final IElementType elementType=ElementTypeRegistry.getInstance().getType("org.eclipse.papyrus.sysML.FlowPort_Label");
					if( elementType instanceof ISpecializationType){
						IElementMatcher matcher=((ISpecializationType)elementType).getMatcher();
						if( matcher.matches(sourceElement)){
							valuesToAdd.add((Port) sourceElement);
							Command cmd= new Command() {
								@Override
								public void execute() {
									if( elementType instanceof IHintedType){
									ViewService.createNode(((GraphicalEditPart) targetEditPart).getNotationView(),valuesToAdd.get(0), ((IHintedType)elementType).getSemanticHint(), ((GraphicalEditPart) targetEditPart).getDiagramPreferencesHint());
									}
								}

							};
							return cmd;
						}
					}
				}
			}

		}
			return cc.canExecute() ? new ICommandProxy(cc.reduce()) : null;
		}


		public String getCategoryID() {
			return "org.eclipse.papyrus.dnd.AddedElement";
		}

		public String getCategoryLabel() {
			return "AddedEelement drop";
		}
	}
