/*****************************************************************************
 * Copyright (c) 2017 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 * Benoit Maggi (CEA LIST) benoit.maggi@cea.fr - Initial API and implementation
 * Nicolas FAUVERGUE (ALL4TEC) nicolas.fauvergue@all4tec.net - Bug 496905
 * Gabriel Pascual (ALL4TEC) gabriel.pascual@all4tec.net - Bug 464625
 * 
 *****************************************************************************/
package aspects.parsers

import com.google.inject.Singleton

@Singleton class PredefinedParser extends parsers.PredefinedParser{

	override def extendsList(org.eclipse.papyrus.gmf.codegen.gmfgen.PredefinedParser it) //
	'''extends org.eclipse.papyrus.infra.gmfdiag.common.parsers.AbstractElementTypeBasedAttributeParser'''
	
	override def additions(org.eclipse.papyrus.gmf.codegen.gmfgen.PredefinedParser it) //
	'''
	/**
	 * @generated
	 * {@inheritDoc}
	 * @see org.eclipse.papyrus.infra.gmfdiag.tooling.runtime.parsers.AbstractFeatureParser#getModificationCommand(org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EStructuralFeature, java.lang.Object)
	 */
	@Override
	protected org.eclipse.gmf.runtime.common.core.command.ICommand getModificationCommand(final org.eclipse.emf.ecore.EObject element, final org.eclipse.emf.ecore.EStructuralFeature feature, final Object value) {
		org.eclipse.gmf.runtime.common.core.command.ICommand result = null;

		// If the feature to edit is the name, check that this is not really the internationalization to edit and not the name
		if (feature.equals(org.eclipse.uml2.uml.UMLPackage.eINSTANCE.getNamedElement_Name())) {
			if (org.eclipse.papyrus.infra.internationalization.common.utils.InternationalizationPreferencesUtils.getInternationalizationPreference(element) && null != org.eclipse.papyrus.uml.internationalization.utils.utils.UMLLabelInternationalization.getInstance().getLabelWithoutUML((org.eclipse.uml2.uml.NamedElement) element)) {
				final org.eclipse.papyrus.infra.core.resource.ModelSet modelSet = (org.eclipse.papyrus.infra.core.resource.ModelSet) element.eResource().getResourceSet();
				if (null != modelSet) {
					result = new org.eclipse.papyrus.infra.emf.gmf.command.EMFtoGMFCommandWrapper(UMLLabelInternationalization.getInstance().getSetLabelCommand(modelSet.getTransactionalEditingDomain(), (org.eclipse.uml2.uml.NamedElement) element, (String) value, null));
				}
			}
		}

		return null != result ? result : super.getModificationCommand(element, feature, value);
	}
	
	/**
	 * @generated
	 * {@inheritDoc}
	 * @see org.eclipse.papyrus.infra.gmfdiag.tooling.runtime.parsers.AbstractAttributeParser#getValue(org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EStructuralFeature)
	 */
	@Override
	protected Object getValue(final org.eclipse.emf.ecore.EObject element, final org.eclipse.emf.ecore.EStructuralFeature feature) {
		Object result = null;
		
		if(element instanceof org.eclipse.uml2.uml.NamedElement && feature.equals(org.eclipse.uml2.uml.UMLPackage.eINSTANCE.getNamedElement_Name())){
			if (org.eclipse.papyrus.infra.internationalization.common.utils.InternationalizationPreferencesUtils.getInternationalizationPreference(element) && null != org.eclipse.papyrus.uml.internationalization.utils.utils.UMLLabelInternationalization.getInstance().getLabelWithoutUML((org.eclipse.uml2.uml.NamedElement)element)) {
				result = UMLLabelInternationalization.getInstance().getLabelWithoutUML((org.eclipse.uml2.uml.NamedElement)element);
			}
		}
		
		return null != result ? result : super.getValue(element, feature);
	}	
	'''
}
