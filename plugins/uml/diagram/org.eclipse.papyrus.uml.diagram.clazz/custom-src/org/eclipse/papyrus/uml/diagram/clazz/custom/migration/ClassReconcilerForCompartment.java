/*****************************************************************************
 * Copyright (c) 2010, 2015 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Mickael ADAM (ALL4TEC) mickael.adam@all4tec.net - reconciler to add floating label
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.clazz.custom.migration;

import java.util.Arrays;
import java.util.List;

import org.eclipse.papyrus.infra.gmfdiag.common.reconciler.ReconcilerForCompartment;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.AssociationClassAttributeCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.AssociationClassNestedClassifierCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.AssociationClassOperationCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ClassAttributeCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ClassAttributeCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ClassNestedClassifierCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ClassNestedClassifierCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ClassOperationCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ComponentAttributeCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ComponentAttributeCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ComponentNestedClassifierCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ComponentNestedClassifierCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ComponentOperationCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ComponentOperationCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.DataTypeAttributeCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.DataTypeAttributeCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.DataTypeOperationCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.DataTypeOperationCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.EnumerationEnumerationLiteralCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.EnumerationEnumerationLiteralCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.InstanceSpecificationSlotCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.InstanceSpecificationSlotCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.InterfaceAttributeCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.InterfaceAttributeCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.InterfaceNestedClassifierCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.InterfaceNestedClassifierCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.InterfaceOperationCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.InterfaceOperationCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ModelPackageableElementCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ModelPackageableElementCompartmentEditPartTN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.PackagePackageableElementCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.PrimitiveTypeAttributeCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.PrimitiveTypeAttributeCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.PrimitiveTypeOperationCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.PrimitiveTypeOperationCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.RedefinableTemplateSignatureTemplateParameterCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.SignalAttributeCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.SignalAttributeCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.TemplateSignatureTemplateParameterCompartmentEditPart;

/**
 * Diagram Reconciler for compartment from 1.1.0 to 1.2.0
 */
public class ClassReconcilerForCompartment extends ReconcilerForCompartment {

	/** The compartments visual id. */
	private List<String> compartmentsVisualID = Arrays.asList(
			ClassAttributeCompartmentEditPartCN.VISUAL_ID,
			ClassNestedClassifierCompartmentEditPartCN.VISUAL_ID,
			ComponentAttributeCompartmentEditPartCN.VISUAL_ID,
			ComponentOperationCompartmentEditPartCN.VISUAL_ID,
			ComponentNestedClassifierCompartmentEditPartCN.VISUAL_ID,
			SignalAttributeCompartmentEditPartCN.VISUAL_ID,
			InterfaceAttributeCompartmentEditPartCN.VISUAL_ID,
			InterfaceOperationCompartmentEditPartCN.VISUAL_ID,
			InterfaceNestedClassifierCompartmentEditPartCN.VISUAL_ID,
			PrimitiveTypeAttributeCompartmentEditPartCN.VISUAL_ID,
			PrimitiveTypeOperationCompartmentEditPartCN.VISUAL_ID,
			DataTypeAttributeCompartmentEditPartCN.VISUAL_ID,
			DataTypeOperationCompartmentEditPartCN.VISUAL_ID,
			ModelPackageableElementCompartmentEditPartCN.VISUAL_ID,
			EnumerationEnumerationLiteralCompartmentEditPartCN.VISUAL_ID,
			InstanceSpecificationSlotCompartmentEditPartCN.VISUAL_ID,
			InstanceSpecificationSlotCompartmentEditPartCN.VISUAL_ID,
			ClassAttributeCompartmentEditPart.VISUAL_ID,
			ClassOperationCompartmentEditPart.VISUAL_ID,
			ClassNestedClassifierCompartmentEditPart.VISUAL_ID,
			ComponentAttributeCompartmentEditPart.VISUAL_ID,
			ComponentOperationCompartmentEditPart.VISUAL_ID,
			ComponentNestedClassifierCompartmentEditPart.VISUAL_ID,
			InterfaceAttributeCompartmentEditPart.VISUAL_ID,
			InterfaceOperationCompartmentEditPart.VISUAL_ID,
			InterfaceNestedClassifierCompartmentEditPart.VISUAL_ID,
			PrimitiveTypeAttributeCompartmentEditPart.VISUAL_ID,
			PrimitiveTypeOperationCompartmentEditPart.VISUAL_ID,
			DataTypeAttributeCompartmentEditPart.VISUAL_ID,
			DataTypeOperationCompartmentEditPart.VISUAL_ID,
			AssociationClassAttributeCompartmentEditPart.VISUAL_ID,
			InstanceSpecificationSlotCompartmentEditPart.VISUAL_ID,
			SignalAttributeCompartmentEditPart.VISUAL_ID,
			ModelPackageableElementCompartmentEditPartTN.VISUAL_ID,
			PackagePackageableElementCompartmentEditPart.VISUAL_ID,
			EnumerationEnumerationLiteralCompartmentEditPart.VISUAL_ID,
			AssociationClassOperationCompartmentEditPart.VISUAL_ID,
			AssociationClassNestedClassifierCompartmentEditPart.VISUAL_ID,
			RedefinableTemplateSignatureTemplateParameterCompartmentEditPart.VISUAL_ID,
			TemplateSignatureTemplateParameterCompartmentEditPart.VISUAL_ID);

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
