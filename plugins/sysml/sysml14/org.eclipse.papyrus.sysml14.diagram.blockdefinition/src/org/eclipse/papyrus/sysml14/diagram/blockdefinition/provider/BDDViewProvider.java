/**
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.sysml14.diagram.blockdefinition.provider;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.core.providers.IViewProvider;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateDiagramViewOperation;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateEdgeViewOperation;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateNodeViewOperation;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateViewForKindOperation;
import org.eclipse.gmf.runtime.diagram.ui.view.factories.ResizableCompartmentViewFactory;
import org.eclipse.gmf.runtime.diagram.ui.view.factories.optimal.ConnectorViewFactory;
import org.eclipse.gmf.runtime.diagram.ui.view.factories.optimal.DecorationNodeViewFactory;
import org.eclipse.gmf.runtime.diagram.ui.view.factories.optimal.ShapeViewFactory;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.providers.CustomAbstractViewProvider;
import org.eclipse.papyrus.infra.gmfdiag.common.providers.GraphicalTypeRegistry;
import org.eclipse.papyrus.infra.viewpoints.policy.ViewPrototype;
import org.eclipse.papyrus.sysml14.diagram.blockdefinition.IDRegistry;
import org.eclipse.papyrus.sysml14.diagram.blockdefinition.editpart.DynamicBorderItemNameEditPart;
import org.eclipse.papyrus.sysml14.diagram.blockdefinition.editpart.DynamicXYCompartmentEditPart;
import org.eclipse.papyrus.sysml14.diagram.blockdefinition.editpart.DynamicAroundBoderItemEditPart;
import org.eclipse.papyrus.sysml14.diagram.blockdefinition.editpart.DynamicListCompartmentEditPart;
import org.eclipse.papyrus.sysml14.diagram.blockdefinition.factory.BlockClassifierViewFactory;
import org.eclipse.papyrus.sysml14.diagram.blockdefinition.factory.OperationPortViewFactory;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ModelEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.providers.UMLViewProvider;
import org.eclipse.papyrus.uml.diagram.common.factory.ClassifierViewFactory;


public class BDDViewProvider extends CustomAbstractViewProvider implements IViewProvider {


	/** Map containing node view types supported by this provider */
	protected Map<String, Class<?>> nodeMap = new HashMap<String, Class<?>>();

	/** Map containing edge view types supported by this provider */
	protected Map<String, Class<?>> edgeMap = new HashMap<String, Class<?>>();

	/** Default constructor */
	public BDDViewProvider() {
		super();
		initDiagramType();
		initGraphicalTypeRegistry();

		nodeMap.put(IDRegistry.FLOWPORT_LABEL, org.eclipse.papyrus.gmf.diagram.common.factory.ShapeViewFactory.class);
		nodeMap.put(IDRegistry.NESTED_BLOCK_CLASSIFIER, BlockClassifierViewFactory.class);
		nodeMap.put(IDRegistry.OPERATION_BORDER_ITEM, OperationPortViewFactory.class);
		edgeMap.put(IDRegistry.VERIFY_LINK, ConnectorViewFactory.class);
	}


	/**
	 * Initialize the graphical type registry. This should be set in the constructor, and not called again after that.
	 */
	/**
	 * {@inheritDoc}
	 */
	protected void initGraphicalTypeRegistry() {
		this.registry = new ShapeCompartmentGraphicalTypeRegistry();
	}

	/**
	 * Graphical Type Registry specific to this view provider
	 */
	public class ShapeCompartmentGraphicalTypeRegistry extends GraphicalTypeRegistry {

		public ShapeCompartmentGraphicalTypeRegistry() {
			knownNodes.add(IDRegistry.FLOWPORT_LABEL);
			knownNodes.add(IDRegistry.NESTED_BLOCK_CLASSIFIER);
			knownNodes.add(IDRegistry.OPERATION_BORDER_ITEM);
			knownNodes.add(IDRegistry.OPERATION_BORDER_ITEM_LABEL);
			knownNodes.add(IDRegistry.OPERATION_BORDER_ITEM_STEREOTYPE_LABEL);
			knownEdges.add(IDRegistry.VERIFY_LINK);
		}
	}

	@Override
	protected boolean provides(CreateNodeViewOperation operation) {
		//System.err.println(operation.getContainerView().getType());
		System.err.println(this.getClass().getName()+" try to create node in the container "+operation.getContainerView().getType()+ " the view "+ operation.getSemanticHint());
		if(operation.getContainerView().getType().equals(IDRegistry.FLOWPORT_COMPARMENT_NAME)){
			return super.provides(operation);
		}
		if(operation.getContainerView().getType().equals(IDRegistry.NESTED_PART_COMPARMENT_NAME)){
			return super.provides(operation);
		}
		if(operation.getContainerView().getType().equals("2008")){
			return super.provides(operation);
		}
		
		return false;
	}
	
	protected boolean provides(CreateEdgeViewOperation operation) {
		System.err.println(this.getClass().getName()+" try to create edge in the container "+operation.getContainerView().getType()+ " the view "+ operation.getSemanticHint());
		
		//System.err.println(operation.getContainerView().getType());
		if(operation.getContainerView().getType().equals("PapyrusUMLClassDiagram")){
			return super.provides(operation);
		}
		
		return false;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Class<?> getNodeViewClass(IAdaptable semanticAdapter, View containerView, String graphicalType) {
		return nodeMap.get(graphicalType);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Class<?> getEdgeViewClass(IAdaptable semanticAdapter, View containerView, String graphicalType) {
		return edgeMap.get(graphicalType);
	}
	/**
	 * {@inheritDoc}
	 */
	protected void initDiagramType() {
		diagramType="SysML 1.4 Block Definition";
	}

	protected boolean isRelevantDiagram (Diagram diagram){
		ViewPrototype viewPrototype=org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramUtils.getPrototype(diagram);
		if(viewPrototype!=null){
			if(diagramType.equals(viewPrototype.getLabel())){
				return true;
			}
			return false;
			
		}
		if ((diagramType != null) && (diagramType.equals(diagram.getType()))) {
			return true;
		}
		return false;
	}
}
