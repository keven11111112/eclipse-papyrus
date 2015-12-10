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
 *   Mickael ADAM (ALL4TEC) mickael.adam@all4tec.net - Initial API and Implementation
 *   
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.component.custom.migration;

import java.util.Arrays;
import java.util.List;

import org.eclipse.papyrus.infra.gmfdiag.common.reconciler.ReconcilerForCompartment;

/**
 * Diagram Reconciler for compartment from 1.1.0 to 1.2.0
 */
public class ComponentReconcilerForCompartment extends ReconcilerForCompartment {

	private static final String ComponentCompositeCompartmentEditPart_VISUAL_ID = "7001";
	private static final String ModelPackageableElementCompartmentEditPart_VISUAL_ID = "7006";
	private static final String PackagePackageableElementCompartmentEditPart_VISUAL_ID = "7002";
	private static final String ModelPackageableElementCompartmentEditPartCN_VISUAL_ID = "7007";
	private static final String PackagePackageableElementCompartmentEditPartCN_VISUAL_ID = "7005";
	private static final String ComponentCompositeCompartmentEditPartCN_VISUAL_ID = "7003";
	private static final String ComponentCompositeCompartmentEditPartPCN_VISUAL_ID = "7004";
	private static final String InterfaceAttributeCompartmentEditPart_VISUAL_ID = "7008";
	private static final String InterfaceOperationCompartmentEditPart_VISUAL_ID = "7009";
	private static final String InterfaceAttributeCompartmentEditPartCN_VISUAL_ID = "7010";
	private static final String InterfaceOperationCompartmentEditPartCN_VISUAL_ID = "7011";

	/** The compartments visual id. */
	private List<String> compartmentsVisualID = Arrays.asList(
			ComponentCompositeCompartmentEditPart_VISUAL_ID,
			ModelPackageableElementCompartmentEditPart_VISUAL_ID,
			PackagePackageableElementCompartmentEditPart_VISUAL_ID,
			ModelPackageableElementCompartmentEditPartCN_VISUAL_ID,
			PackagePackageableElementCompartmentEditPartCN_VISUAL_ID,
			ComponentCompositeCompartmentEditPartCN_VISUAL_ID,
			ComponentCompositeCompartmentEditPartPCN_VISUAL_ID,
			InterfaceAttributeCompartmentEditPart_VISUAL_ID,
			InterfaceOperationCompartmentEditPart_VISUAL_ID,
			InterfaceAttributeCompartmentEditPartCN_VISUAL_ID,
			InterfaceOperationCompartmentEditPartCN_VISUAL_ID);

	/**
	 * Gets the compartments visual id.
	 *
	 * @return the compartments visual id
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.reconciler.ReconcilerForCompartment#getCompartmentsVisualID()
	 */
	@Override
	public List<String> getCompartmentsVisualID() {
		return compartmentsVisualID;
	}

}
