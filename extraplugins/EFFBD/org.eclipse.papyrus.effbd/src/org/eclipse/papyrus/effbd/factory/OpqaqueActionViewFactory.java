/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier(CEA LIST) Patrick.Tessier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.effbd.factory;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.OpaqueActionEditPart;
import org.eclipse.papyrus.uml.diagram.activity.locator.PinPositionLocator;
import org.eclipse.papyrus.uml.diagram.activity.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.uml.diagram.common.helper.PreferenceInitializerForElementHelper;

public class OpqaqueActionViewFactory extends AbstractBasicViewFactory {

	@Override
	public View createElementView(EObject domainElement, View containerView, String semanticHint, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		// adapt the height to contained pins
		Bounds boundsConstraint = NotationFactory.eINSTANCE.createBounds();
		PinPositionLocator.adaptActionHeight(boundsConstraint, domainElement);
		node.setLayoutConstraint(boundsConstraint);
		node.setType(UMLVisualIDRegistry.getType(OpaqueActionEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "OpaqueAction");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "OpaqueAction");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "OpaqueAction");
		Node label5003 = createLabel(node, "5003");
		// not generated but changes include on gmfgen, can be override at the generation
		Node label6028 = createLabel(node, "6028");
		label6028.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6028 = (Location) label6028.getLayoutConstraint();
		location6028.setX(0);
		location6028.setY(5);
		// Add pins
		// createPins(domainElement, node, persisted, preferencesHint);
		return node;
	}

}
