/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Saadia Dhouib saadia.dhouib@cea.fr
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.communication.custom.providers;

import java.util.ArrayList;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.Connector;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.RelativeBendpoints;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.datatype.RelativeBendpoint;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.uml.diagram.common.helper.PreferenceInitializerForElementHelper;
import org.eclipse.papyrus.uml.diagram.communication.edit.parts.AppliedStereotypeMessageEditPart;
import org.eclipse.papyrus.uml.diagram.communication.edit.parts.MessageEditPart;
import org.eclipse.papyrus.uml.diagram.communication.edit.parts.MessageNameEditPart;
import org.eclipse.papyrus.uml.diagram.communication.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.uml.diagram.communication.providers.UMLViewProvider;

/**
 * The Class CustomUmlViewProvider provides a custom creation of the message
 */
public class CustomUMLViewProvider extends UMLViewProvider {

	/**
	 * @see org.eclipse.papyrus.uml.diagram.communication.providers.UMLViewProvider#createEdge(org.eclipse.core.runtime.IAdaptable, org.eclipse.gmf.runtime.notation.View, java.lang.String, int, boolean,
	 *      org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint)
	 *
	 * @param semanticAdapter
	 * @param containerView
	 * @param semanticHint
	 * @param index
	 * @param persisted
	 * @param preferencesHint
	 * @return the edge
	 */
	@Override
	public Edge createEdge(IAdaptable semanticAdapter, View containerView, String semanticHint, int index, boolean persisted, PreferencesHint preferencesHint) {
		IElementType elementType = getSemanticElementType(semanticAdapter);
		String elementTypeHint = ((IHintedType) elementType).getSemanticHint();
		switch (UMLVisualIDRegistry.getVisualID(elementTypeHint)) {
		case MessageEditPart.VISUAL_ID:
			return customCreatePath_Edge(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		}
		// can never happen, provided #provides(CreateEdgeViewOperation) is correct
		return super.createEdge(semanticAdapter, containerView, semanticHint, index, persisted, preferencesHint);
	}

	/**
	 * Custom create Path_Edge.
	 * this method adds a customization to set the semantic element of the connection label to the domainElement which is a uml message in our case
	 *
	 * @param domainElement
	 *            the domain element
	 * @param containerView
	 *            the container view
	 * @param index
	 *            the index
	 * @param persisted
	 *            the persisted
	 * @param preferencesHint
	 *            the preferences hint
	 * @return the edge
	 */
	@SuppressWarnings("unchecked")
	public Edge customCreatePath_Edge(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(MessageEditPart.VISUAL_ID));
		// the semantic element is no more associated to the edge
		// edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(edge, prefStore, "Message"); //$NON-NLS-1$
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(edge, prefStore, "Message"); //$NON-NLS-1$
		// org.eclipse.gmf.runtime.notation.Routing routing = org.eclipse.gmf.runtime.notation.Routing.get(prefStore.getInt(org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_LINE_STYLE));
		// if (routing != null) {
		// org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(edge, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		// }
		PreferenceInitializerForElementHelper.initRountingFromPrefs(edge, prefStore, "Message"); //$NON-NLS-1$
		Node path_MessageLabel = createLabel(edge, UMLVisualIDRegistry.getType(MessageNameEditPart.VISUAL_ID));
		path_MessageLabel.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location path_MessageLabel_Location = (Location) path_MessageLabel.getLayoutConstraint();
		path_MessageLabel_Location.setX(1);
		path_MessageLabel_Location.setY(-23);
		// added to set the element of the connection label to the domainElement which is a uml message in our case
		path_MessageLabel.setElement(domainElement);
		Node path_StereotypeLabel = createLabel(edge, UMLVisualIDRegistry.getType(AppliedStereotypeMessageEditPart.VISUAL_ID));
		path_StereotypeLabel.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location path_StereotypeLabel_Location = (Location) path_StereotypeLabel.getLayoutConstraint();
		path_StereotypeLabel_Location.setX(1);
		path_StereotypeLabel_Location.setY(-53);
		return edge;
	}
}
