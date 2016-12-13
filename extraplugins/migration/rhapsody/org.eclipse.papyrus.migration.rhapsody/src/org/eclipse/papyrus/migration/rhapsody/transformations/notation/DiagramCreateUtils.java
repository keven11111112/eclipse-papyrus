/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are the property of the CEA. 
 * Any use is subject to specific agreement with the CEA.
 *
 * Contributors:
 * 
 * 		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.migration.rhapsody.transformations.notation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.commands.SemanticElementAdapter;
import org.eclipse.papyrus.uml.diagram.statemachine.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.uml.diagram.statemachine.providers.UMLElementTypes;


public class DiagramCreateUtils {



	public static View createGraphicalNode(EObject eObject, String graphicalType, View containerView) {
		return ViewService.getInstance().createView(Node.class, new EObjectAdapter(eObject), containerView, graphicalType, ViewUtil.APPEND, true, getPreferenceHint(containerView.getDiagram()));
	}

	public static View createStateMachingGraphicalNode(EObject semanticElement, View container){
		String graphicalType = UMLVisualIDRegistry.getNodeVisualID(container, semanticElement);
		View view= ViewService.getInstance().createView(Node.class, new SemanticElementAdapter(semanticElement, org.eclipse.papyrus.uml.diagram.statemachine.providers.UMLElementTypes.getElementType(graphicalType)), container,graphicalType , ViewUtil.APPEND, true, new PreferencesHint(IDiagramConstants.STATEMACHINE_PLUGIN_ID));
		return view;
	}
	
	public static View createClassDiagramGraphicalEdge(EObject semanticElement, View sourceView, View targetView, Diagram diagram){
		
		String graphicalType = UMLVisualIDRegistry.getLinkWithClassVisualID(semanticElement);
		Edge edge = (Edge)ViewService.getInstance().createView(Edge.class, new SemanticElementAdapter(semanticElement, UMLElementTypes.getElementType(graphicalType)), diagram,graphicalType , ViewUtil.APPEND, true, new PreferencesHint(IDiagramConstants.CLASS_DIAGRAM_ID));
		if (edge != null) {
			edge.setSource(sourceView);
			edge.setTarget(targetView);
		}
		
		return edge;
	}
	

	private static PreferencesHint getPreferenceHint(Diagram diagram) {
		PreferencesHint preferenceHint = null;
		if(IDiagramConstants.STATEMACHINE_DIAGRAM_ID.equals(diagram.getType())) {
			preferenceHint = new PreferencesHint(IDiagramConstants.STATEMACHINE_PLUGIN_ID);
		} else {
			// TODO add unimplemented exception here
		}
		return preferenceHint;
	}



	
	protected IElementType getClassDiagElementType(String graphicalType) {
		return  UMLElementTypes.getElementType(graphicalType) ;
	}

	/**
	 * @param transition
	 * @param sourceView
	 * @param targetView
	 * @param transform
	 * @return
	 */
	public static View createStateMachineDiagramGraphicalEdge(EObject semanticElement, View sourceView, View targetView, Diagram diagram) {
		String graphicalType = UMLVisualIDRegistry.getLinkWithClassVisualID(semanticElement);
		Edge edge = (Edge)ViewService.getInstance().createView(Edge.class, new SemanticElementAdapter(semanticElement, UMLElementTypes.getElementType(graphicalType)), diagram,graphicalType , ViewUtil.APPEND, true, new PreferencesHint(IDiagramConstants.STATEMACHINE_PLUGIN_ID));
		if (edge != null) {
			edge.setSource(sourceView);
			edge.setTarget(targetView);
		}
		
		return edge;
	}


	
}
