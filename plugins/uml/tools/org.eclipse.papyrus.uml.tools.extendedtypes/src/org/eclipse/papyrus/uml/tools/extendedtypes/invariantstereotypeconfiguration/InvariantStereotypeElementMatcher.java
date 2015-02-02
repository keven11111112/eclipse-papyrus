/*****************************************************************************
 * Copyright (c) 2013, 2014 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) - Initial API and implementation
 *  Sebastien Gabel (Esterel Technologies) - Add support to isStrict attribute  
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.extendedtypes.invariantstereotypeconfiguration;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.IInvariantElementMatcher;
import org.eclipse.papyrus.uml.tools.utils.StereotypeUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;


/**
 * @author RS211865
 */
public class InvariantStereotypeElementMatcher implements IInvariantElementMatcher<InvariantStereotypeConfiguration> {

	private String stereotypeQualifiedName;

	private boolean isStrict;

	/**
	 * {@inheritDoc}
	 */
	public boolean matches(EObject eObject) {

		if (!(eObject instanceof Element)) {
			return false;
		}

		String stereotypeQualifiedName = getStereotypeQualifiedName();
		if(stereotypeQualifiedName==null) { // to avoid null pointers
			return false;
		}
		Stereotype appliedStereotype = ((Element) eObject).getAppliedStereotype(stereotypeQualifiedName);
		if (appliedStereotype != null) { // one has been found, no need to get further
			return true; 
		} else if(!isStrict) { // the stereotype does not match perfectly, but one of the applied stereotypes on the element could match if not strict
			for (Stereotype stereotype : ((Element) eObject).getAppliedStereotypes()) { 
				for (Stereotype superStereotype : StereotypeUtil.getAllSuperStereotypes(stereotype)) {
					if (stereotypeQualifiedName.equals(superStereotype.getQualifiedName())) {
						return true; // there is a match in the super stereotypes. Finish here, element matches
					}
				}
			}
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	public void init(InvariantStereotypeConfiguration ruleConfiguration) {
		setStereotypeQualifiedName(ruleConfiguration.getStereotypeQualifiedName());
		setStrict(ruleConfiguration.isStrict());
	}

	/**
	 * @return the stereotypeQualifiedName
	 */
	public String getStereotypeQualifiedName() {
		return stereotypeQualifiedName;
	}

	/**
	 * @param stereotypeQualifiedName
	 *            the stereotypeQualifiedName to set
	 */
	public void setStereotypeQualifiedName(String stereotypeQualifiedName) {
		this.stereotypeQualifiedName = stereotypeQualifiedName;
	}


	/**
	 * @return the isStrict
	 */
	public boolean isStrict() {
		return isStrict;
	}

	/**
	 * @param isStrict
	 *            the isStrict to set
	 */
	public void setStrict(boolean isStrict) {
		this.isStrict = isStrict;
	}
}
