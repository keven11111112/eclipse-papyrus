/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml14.diagram.blockdefinition.provider;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.CreateGraphicEditPartOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.IEditPartOperation;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.gmf.diagram.common.provider.CustomAbstractEditPartProvider;
import org.eclipse.papyrus.sysml14.diagram.blockdefinition.IDRegistry;
import org.eclipse.papyrus.sysml14.diagram.blockdefinition.editpart.DynamicBorderItemNameEditPart;
import org.eclipse.papyrus.sysml14.diagram.blockdefinition.editpart.DynamicXYCompartmentEditPart;
import org.eclipse.papyrus.sysml14.diagram.blockdefinition.editpart.DynamicAroundBoderItemEditPart;
import org.eclipse.papyrus.sysml14.diagram.blockdefinition.editpart.DynamicListCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ClassEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.PropertyForClassEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.DependencyEditPart;
import org.eclipse.uml2.uml.Dependency;

public class BddEditPartProvider extends CustomAbstractEditPartProvider {

	/** Map containing node view types supported by this provider */
	protected Map<String, Class<?>> nodeMap = new HashMap<String, Class<?>>();

	/** Map containing edge view types supported by this provider */
	protected Map<String, Class<?>> edgeMap = new HashMap<String, Class<?>>();

	/** Default constructor */
	public BddEditPartProvider() {
		super();
		
		nodeMap.put(IDRegistry.FLOWPORT_COMPARMENT_NAME, DynamicListCompartmentEditPart.class);
		nodeMap.put(IDRegistry.NESTED_PART_COMPARMENT_NAME, DynamicXYCompartmentEditPart.class);
		nodeMap.put(IDRegistry.FLOWPORT_LABEL, PropertyForClassEditPart.class);
		nodeMap.put(IDRegistry.NESTED_BLOCK_CLASSIFIER, ClassEditPart.class);
		nodeMap.put(IDRegistry.OPERATION_BORDER_ITEM, DynamicAroundBoderItemEditPart.class);
		nodeMap.put(IDRegistry.OPERATION_BORDER_ITEM_LABEL, DynamicBorderItemNameEditPart.class);
		nodeMap.put(IDRegistry.OPERATION_BORDER_ITEM_STEREOTYPE_LABEL, DynamicBorderItemNameEditPart.class);
		edgeMap.put(IDRegistry.VERIFY_LINK, DependencyEditPart.class);
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean provides(IOperation operation) {
		if (operation instanceof CreateGraphicEditPartOperation) {
			View newView = ((IEditPartOperation) operation).getView();
			if (newView == null) {
				return false;
			}

			String graphicalType = newView.getType();
			System.err.println(this.getClass().getName()+" view appears with the type "+graphicalType);

			if ((newView instanceof Node) && (!nodeMap.containsKey(graphicalType))) {
				return false;
			}

			if ((newView instanceof Edge) && (!edgeMap.containsKey(graphicalType))) {
				return false;
			}
		}

		return super.provides(operation);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Class<?> getNodeEditPartClass(View view) {
		return nodeMap.get(view.getType());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Class<?> getEdgeEditPartClass(View view) {
		return edgeMap.get(view.getType());
	}
}
