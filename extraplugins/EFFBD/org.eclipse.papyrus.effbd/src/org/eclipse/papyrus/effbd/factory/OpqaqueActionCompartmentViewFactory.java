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
import org.eclipse.gmf.runtime.diagram.ui.view.factories.optimal.ShapeViewFactory;
import org.eclipse.gmf.runtime.notation.Compartment;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.adapter.SemanticAdapter;

public class OpqaqueActionCompartmentViewFactory extends AbstractBasicViewFactory {

	@Override
	public View createElementView(EObject domainElement, View containerView, String semanticHint, int index, boolean persisted, PreferencesHint preferencesHint) {
		Compartment compartment = NotationFactory.eINSTANCE.createCompartment();
		compartment.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		compartment.setType(semanticHint);

		ShapeViewFactory factory = new ShapeViewFactory();
		View node = factory.createView(new SemanticAdapter(domainElement, null), containerView, "opaqueAction_body", index, persisted, preferencesHint);


		ViewUtil.insertChildView(compartment, node, index, persisted);
		ViewUtil.insertChildView(containerView, compartment, index, persisted);
		return compartment;
	}

}
