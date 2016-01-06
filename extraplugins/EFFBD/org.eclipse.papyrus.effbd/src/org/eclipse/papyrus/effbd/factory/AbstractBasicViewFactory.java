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
package org.eclipse.papyrus.effbd.factory;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.notation.DecorationNode;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.TitleStyle;
import org.eclipse.gmf.runtime.notation.View;

/**
 * This abstract view factory is used to allow reuse code from GMF generated diagram
 * 
 */
public abstract class AbstractBasicViewFactory implements IBasicViewFactory {

	@Override
	public View createView(IAdaptable semanticAdapter, View containerView, String semanticHint, int index, boolean persisted, PreferencesHint preferencesHint) {
		return createElementView(semanticAdapter.getAdapter(EObject.class), containerView, semanticHint, index, persisted, preferencesHint);
	}

	/**
	 * This method is used to create a label in the context of based GMF diagram
	 * 
	 * @param owner
	 *            the container of the new view
	 * @param hint
	 *            the number that is associated to the created view
	 * @return the decoration node that is the serialization of the label
	 */
	protected Node createLabel(View owner, String hint) {
		DecorationNode rv = NotationFactory.eINSTANCE.createDecorationNode();
		rv.setType(hint);
		ViewUtil.insertChildView(owner, rv, ViewUtil.APPEND, true);
		return rv;
	}


	/**
	 * This method comes from GMF based generation diagram
	 * it is sued to create compartment.
	 * 
	 * @param owner
	 *            the container of the compartment
	 * @param hint
	 *            the number that will be associated to the node
	 * @param canCollapse
	 *            true if the compartment can be collapse
	 * @param hasTitle
	 *            true if the compartment can have a title
	 * @param canSort
	 *            true if the compartment can be sorted
	 * @param canFilter
	 *            true if the compartment can be filtered
	 * @return the created compartment
	 */
	protected Node createCompartment(View owner, String hint, boolean canCollapse, boolean hasTitle, boolean canSort, boolean canFilter) {
		Node rv;
		if (canCollapse) {
			rv = NotationFactory.eINSTANCE.createBasicCompartment();
		} else {
			rv = NotationFactory.eINSTANCE.createDecorationNode();
		}

		rv.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());

		if (hasTitle) {
			TitleStyle ts = NotationFactory.eINSTANCE.createTitleStyle();
			rv.getStyles().add(ts);
		}
		if (canSort) {
			rv.getStyles().add(NotationFactory.eINSTANCE.createSortingStyle());
		}
		if (canFilter) {
			rv.getStyles().add(NotationFactory.eINSTANCE.createFilteringStyle());
		}
		rv.setType(hint);
		ViewUtil.insertChildView(owner, rv, ViewUtil.APPEND, true);
		return rv;
	}

}
