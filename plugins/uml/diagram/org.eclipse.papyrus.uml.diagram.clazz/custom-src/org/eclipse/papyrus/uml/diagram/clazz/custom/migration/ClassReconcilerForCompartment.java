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

/**
 * Diagram Reconciler for compartment from 1.1.0 to 1.2.0
 */
public class ClassReconcilerForCompartment extends ReconcilerForCompartment {

	private static final String ClassAttributeCompartmentEditPart_VISUAL_ID = "7017";
	private static final String ClassOperationCompartmentEditPart_VISUAL_ID = "7018";
	private static final String ClassNestedClassifierCompartmentEditPart_VISUAL_ID = "7019";
	private static final String ComponentAttributeCompartmentEditPart_VISUAL_ID = "7002";
	private static final String ComponentOperationCompartmentEditPart_VISUAL_ID = "7003";
	private static final String ComponentNestedClassifierCompartmentEditPart_VISUAL_ID = "7004";
	private static final String SignalAttributeCompartmentEditPart_VISUAL_ID = "7005";
	private static final String InterfaceAttributeCompartmentEditPart_VISUAL_ID = "7006";
	private static final String InterfaceOperationCompartmentEditPart_VISUAL_ID = "7007";
	private static final String InterfaceNestedClassifierCompartmentEditPart_VISUAL_ID = "7008";
	private static final String PrimitiveTypeAttributeCompartmentEditPart_VISUAL_ID = "7039";
	private static final String PrimitiveTypeOperationCompartmentEditPart_VISUAL_ID = "7040";
	private static final String DataTypeAttributeCompartmentEditPart_VISUAL_ID = "7020";
	private static final String DataTypeOperationCompartmentEditPart_VISUAL_ID = "7021";
	private static final String ModelPackageableElementCompartmentEditPartTN_VISUAL_ID = "7009";
	private static final String PackagePackageableElementCompartmentEditPart_VISUAL_ID = "7016";
	private static final String EnumerationEnumerationLiteralCompartmentEditPart_VISUAL_ID = "7015";
	private static final String InstanceSpecificationSlotCompartmentEditPart_VISUAL_ID = "7001";
	private static final String AssociationClassAttributeCompartmentEditPart_VISUAL_ID = "7034";
	private static final String AssociationClassOperationCompartmentEditPart_VISUAL_ID = "7036";
	private static final String AssociationClassNestedClassifierCompartmentEditPart_VISUAL_ID = "7037";
	private static final String RedefinableTemplateSignatureTemplateParameterCompartmentEditPart_VISUAL_ID = "7014";
	private static final String TemplateSignatureTemplateParameterCompartmentEditPart_VISUAL_ID = "7038";
	private static final String ClassAttributeCompartmentEditPartCN_VISUAL_ID = "7011";
	private static final String ClassOperationCompartmentEditPartCN_VISUAL_ID = "7012";
	private static final String ClassNestedClassifierCompartmentEditPartCN_VISUAL_ID = "7013";
	private static final String ComponentAttributeCompartmentEditPartCN_VISUAL_ID = "7023";
	private static final String ComponentOperationCompartmentEditPartCN_VISUAL_ID = "7024";
	private static final String ComponentNestedClassifierCompartmentEditPartCN_VISUAL_ID = "7025";
	private static final String SignalAttributeCompartmentEditPartCN_VISUAL_ID = "7026";
	private static final String InterfaceAttributeCompartmentEditPartCN_VISUAL_ID = "7027";
	private static final String InterfaceOperationCompartmentEditPartCN_VISUAL_ID = "7028";
	private static final String InterfaceNestedClassifierCompartmentEditPartCN_VISUAL_ID = "7029";
	private static final String PrimitiveTypeAttributeCompartmentEditPartCN_VISUAL_ID = "7041";
	private static final String PrimitiveTypeOperationCompartmentEditPartCN_VISUAL_ID = "7042";
	private static final String DataTypeAttributeCompartmentEditPartCN_VISUAL_ID = "7032";
	private static final String DataTypeOperationCompartmentEditPartCN_VISUAL_ID = "7033";
	private static final String ModelPackageableElementCompartmentEditPartCN_VISUAL_ID = "7030";
	private static final String PackagePackageableElementCompartmentEditPartCN_VISUAL_ID = "7010";
	private static final String EnumerationEnumerationLiteralCompartmentEditPartCN_VISUAL_ID = "7031";
	private static final String InstanceSpecificationSlotCompartmentEditPartCN_VISUAL_ID = "7035";
	
	/** The compartments visual id. */
	private List<String> compartmentsVisualID = Arrays.asList(
			ClassAttributeCompartmentEditPart_VISUAL_ID,
			ClassOperationCompartmentEditPart_VISUAL_ID,
			ClassNestedClassifierCompartmentEditPart_VISUAL_ID,
			ComponentAttributeCompartmentEditPart_VISUAL_ID,
			ComponentOperationCompartmentEditPart_VISUAL_ID,
			ComponentNestedClassifierCompartmentEditPart_VISUAL_ID,
			SignalAttributeCompartmentEditPart_VISUAL_ID,
			InterfaceAttributeCompartmentEditPart_VISUAL_ID,
			InterfaceOperationCompartmentEditPart_VISUAL_ID,
			InterfaceNestedClassifierCompartmentEditPart_VISUAL_ID,
			PrimitiveTypeAttributeCompartmentEditPart_VISUAL_ID,
			PrimitiveTypeOperationCompartmentEditPart_VISUAL_ID,
			DataTypeAttributeCompartmentEditPart_VISUAL_ID,
			DataTypeOperationCompartmentEditPart_VISUAL_ID,
			ModelPackageableElementCompartmentEditPartTN_VISUAL_ID,
			PackagePackageableElementCompartmentEditPart_VISUAL_ID,
			EnumerationEnumerationLiteralCompartmentEditPart_VISUAL_ID,
			InstanceSpecificationSlotCompartmentEditPart_VISUAL_ID,
			AssociationClassAttributeCompartmentEditPart_VISUAL_ID,
			AssociationClassOperationCompartmentEditPart_VISUAL_ID,
			AssociationClassNestedClassifierCompartmentEditPart_VISUAL_ID,
			RedefinableTemplateSignatureTemplateParameterCompartmentEditPart_VISUAL_ID,
			TemplateSignatureTemplateParameterCompartmentEditPart_VISUAL_ID,
			ClassAttributeCompartmentEditPartCN_VISUAL_ID,
			ClassOperationCompartmentEditPartCN_VISUAL_ID,
			ClassNestedClassifierCompartmentEditPartCN_VISUAL_ID,
			ComponentAttributeCompartmentEditPartCN_VISUAL_ID,
			ComponentOperationCompartmentEditPartCN_VISUAL_ID,
			ComponentNestedClassifierCompartmentEditPartCN_VISUAL_ID,
			SignalAttributeCompartmentEditPartCN_VISUAL_ID,
			InterfaceAttributeCompartmentEditPartCN_VISUAL_ID,
			InterfaceOperationCompartmentEditPartCN_VISUAL_ID,
			InterfaceNestedClassifierCompartmentEditPartCN_VISUAL_ID,
			PrimitiveTypeAttributeCompartmentEditPartCN_VISUAL_ID,
			PrimitiveTypeOperationCompartmentEditPartCN_VISUAL_ID,
			DataTypeAttributeCompartmentEditPartCN_VISUAL_ID,
			DataTypeOperationCompartmentEditPartCN_VISUAL_ID,
			ModelPackageableElementCompartmentEditPartCN_VISUAL_ID,
			PackagePackageableElementCompartmentEditPartCN_VISUAL_ID,
			EnumerationEnumerationLiteralCompartmentEditPartCN_VISUAL_ID,
			InstanceSpecificationSlotCompartmentEditPartCN_VISUAL_ID);

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
