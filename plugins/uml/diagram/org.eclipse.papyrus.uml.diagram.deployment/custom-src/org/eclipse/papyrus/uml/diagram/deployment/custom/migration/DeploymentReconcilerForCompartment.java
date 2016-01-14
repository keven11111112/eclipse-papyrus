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
package org.eclipse.papyrus.uml.diagram.deployment.custom.migration;

import java.util.Arrays;
import java.util.List;

import org.eclipse.papyrus.infra.gmfdiag.common.reconciler.ReconcilerForCompartment;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ArtifactCompositeCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ArtifactCompositeCompartmentEditPartACN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ArtifactCompositeCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DeviceCompositeCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DeviceCompositeCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ExecutionEnvironmentCompositeCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ExecutionEnvironmentCompositeCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ModelPackageableElementCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ModelPackageableElementCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NodeCompositeCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NodeCompositeCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.PackagePackageableElementCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.PackagePackageableElementCompartmentEditPartCN;

/**
 * Diagram Reconciler for compartment from 1.1.0 to 1.2.0
 */
public class DeploymentReconcilerForCompartment extends ReconcilerForCompartment {

	/** The compartments visual id. */
	private List<String> compartmentsVisualID = Arrays.asList(
			ModelPackageableElementCompartmentEditPart.VISUAL_ID,
			PackagePackageableElementCompartmentEditPart.VISUAL_ID,
			DeviceCompositeCompartmentEditPart.VISUAL_ID,
			ExecutionEnvironmentCompositeCompartmentEditPart.VISUAL_ID,
			NodeCompositeCompartmentEditPart.VISUAL_ID,
			ArtifactCompositeCompartmentEditPart.VISUAL_ID,
			ModelPackageableElementCompartmentEditPartCN.VISUAL_ID,
			PackagePackageableElementCompartmentEditPartCN.VISUAL_ID,
			DeviceCompositeCompartmentEditPartCN.VISUAL_ID,
			ExecutionEnvironmentCompositeCompartmentEditPartCN.VISUAL_ID,
			NodeCompositeCompartmentEditPartCN.VISUAL_ID,
			ArtifactCompositeCompartmentEditPartCN.VISUAL_ID,
			ArtifactCompositeCompartmentEditPartACN.VISUAL_ID);

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
