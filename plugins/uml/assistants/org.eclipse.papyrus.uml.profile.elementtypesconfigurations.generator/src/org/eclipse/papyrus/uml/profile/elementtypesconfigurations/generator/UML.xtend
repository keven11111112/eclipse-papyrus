/*****************************************************************************
 * Copyright (c) 2014, 2015 Christian W. Damus and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *   
 *****************************************************************************/
package org.eclipse.papyrus.uml.profile.elementtypesconfigurations.generator

import static org.eclipse.uml2.uml.UMLPackage.Literals.*

import javax.inject.Singleton
import org.eclipse.uml2.uml.NamedElement
import org.eclipse.uml2.uml.Stereotype
import org.eclipse.uml2.uml.Profile
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EReference

/**
 * Utility extensions for working with UML models and elements.
 */
@Singleton
class UML {
    def dispatch getProfile(Profile element) {
        element
    }
    
    def dispatch getProfile(NamedElement element) {
        element.allOwningPackages.filter(Profile).head
    }
    
    def dispatch getProfile(ImpliedExtension umlExtension) {
        umlExtension.stereotype.profile
    }

    def dispatch Profile getRootProfile(Profile element) {
        element.namespace?.rootProfile ?: element
    }
    def dispatch getRootProfile(NamedElement element) {
        element.allOwningPackages.filter(Profile).last
    }
    
    def Iterable<ImpliedExtension> getAllExtensions(org.eclipse.uml2.uml.Package package_) {
        package_.ownedTypes.filter(Stereotype).map[impliedExtensions].flatten
            + package_.nestedPackages.map[allExtensions].flatten
    }
    
    def Iterable<ImpliedExtension> impliedExtensions(Stereotype stereotype) {
        stereotype.allExtendedMetaclasses.map[new ImpliedExtension(stereotype, it)]
    }
    
    def getSourceReferences(EClass relationshipClass) {
        if (DIRECTED_RELATIONSHIP.isSuperTypeOf(relationshipClass)) {
            relationshipClass.EAllReferences.filter[!derived && changeable && subsets(DIRECTED_RELATIONSHIP__SOURCE)]
        } else if (ASSOCIATION.isSuperTypeOf(relationshipClass)) {
            // ends are both source and target
            #[ASSOCIATION__END_TYPE]
        }   
    }
    
    def getTargetReferences(EClass relationshipClass) {
        if (DIRECTED_RELATIONSHIP.isSuperTypeOf(relationshipClass)) {
            relationshipClass.EAllReferences.filter[!derived && changeable && subsets(DIRECTED_RELATIONSHIP__TARGET)]
        } else if (ASSOCIATION.isSuperTypeOf(relationshipClass)) {
            // ends are both source and target
            #[ASSOCIATION__END_TYPE]
        }   
    }
    
    def subsets(EReference subset, EReference superset) {
        subset.getEAnnotation("subsets")?.references?.contains(superset)
    }
}
