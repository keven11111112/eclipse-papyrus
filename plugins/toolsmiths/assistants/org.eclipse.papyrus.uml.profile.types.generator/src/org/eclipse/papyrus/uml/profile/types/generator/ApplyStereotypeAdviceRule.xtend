/*****************************************************************************
 * Copyright (c) 2014, 2015, 2018 Christian W. Damus and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *   Ansgar Radermacher - Bug 526155, add description to stereotype-application-rule
 *   
 *****************************************************************************/
package org.eclipse.papyrus.uml.profile.types.generator

import javax.inject.Inject
import javax.inject.Singleton
import org.eclipse.papyrus.infra.types.ElementTypeConfiguration
import org.eclipse.papyrus.uml.types.core.advices.applystereotype.ApplyStereotypeAdviceConfiguration
import org.eclipse.papyrus.uml.types.core.advices.applystereotype.ApplyStereotypeAdviceFactory
import org.eclipse.papyrus.uml.types.core.advices.applystereotype.ApplyStereotypeAdvicePackage
import org.eclipse.uml2.uml.Stereotype

/**
 * Transformation rule for generating an {@link ApplyStereotypeAdviceConfiguration} from a UML {@link Stereotype}.
 */
@Singleton
class ApplyStereotypeAdviceRule {
    static extension ApplyStereotypeAdviceFactory applyStereotypeAdviceConfigurationFactory = ApplyStereotypeAdviceFactory.
        eINSTANCE

    @Inject extension ElementTypeRule
    @Inject extension Identifiers

    def create createApplyStereotypeAdviceConfiguration toAdviceConfiguration(Stereotype umlStereotype,
        ImpliedExtension umlExtension, ElementTypeConfiguration supertype) {

        identifier = umlStereotype.name.toFirstLower.qualified + supertype.hintSuffix +"."+ ApplyStereotypeAdvicePackage.eNAME;
        stereotypesToApply.add(umlStereotype.toStereotypeToApply(supertype))
        target = umlExtension.toElementType(supertype)
        // make file more readable
        description = "Apply Stereotype "+umlStereotype.name
    }

    private def create createStereotypeToApply toStereotypeToApply(Stereotype umlStereotype, ElementTypeConfiguration supertype) {
        requiredProfiles.add(umlStereotype.profile.qualifiedName)
        stereotypeQualifiedName = umlStereotype.qualifiedName
        updateName = true
    }
}
