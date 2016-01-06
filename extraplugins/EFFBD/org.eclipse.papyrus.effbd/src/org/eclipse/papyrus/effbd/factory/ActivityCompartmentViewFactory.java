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
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.TitleStyle;
import org.eclipse.gmf.runtime.notation.View;

public class ActivityCompartmentViewFactory extends AbstractBasicViewFactory {

	@Override
	public View createElementView(EObject domainElement, View containerView, String semanticHint, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node rv;
		rv = NotationFactory.eINSTANCE.createDecorationNode();

		rv.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());

		TitleStyle ts = NotationFactory.eINSTANCE.createTitleStyle();
		rv.getStyles().add(ts);
		rv.getStyles().add(NotationFactory.eINSTANCE.createFilteringStyle());
		rv.setType("7004");
		return rv;
	}

}
