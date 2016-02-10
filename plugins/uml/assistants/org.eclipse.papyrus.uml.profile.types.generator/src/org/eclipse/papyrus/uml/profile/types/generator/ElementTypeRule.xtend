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
package org.eclipse.papyrus.uml.profile.types.generator

import javax.inject.Inject
import javax.inject.Singleton
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject

import org.eclipse.uml2.uml.Stereotype

import static extension org.eclipse.emf.common.util.URI.decode
import org.eclipse.papyrus.infra.types.SpecializationTypeConfiguration
import org.eclipse.papyrus.infra.types.ElementTypeConfiguration
import org.eclipse.papyrus.infra.types.ElementTypesConfigurationsFactory
import org.eclipse.papyrus.uml.types.core.matchers.stereotype.StereotypeApplicationMatcherFactory

/**
 * Transformation rule for generating a {@link SpecializationTypeConfiguration} from a UML metaclass {@link Extension}.
 */
@Singleton
class ElementTypeRule {
    static extension ElementTypesConfigurationsFactory elementtypesconfigurationsFactory = ElementTypesConfigurationsFactory.
        eINSTANCE
    static extension StereotypeApplicationMatcherFactory stereotypeApplicationMatcherConfigurationFactory = StereotypeApplicationMatcherFactory.
        eINSTANCE

    @Inject extension UMLElementTypes
    @Inject extension Identifiers

    def create createSpecializationTypeConfiguration toElementType(ImpliedExtension umlExtension,
        ElementTypeConfiguration supertype) {

        // Basics
        identifier = umlExtension.toElementTypeID(supertype)
        if (supertype.hasSemanticSupertype) {
            // Add the base semantic type in addition to the parent visual type
            specializedTypesID.add(umlExtension.toElementTypeID(umlExtension.metaclass.elementTypeConfiguration))
        }
        specializedTypesID.add(supertype.identifier)
        hint = supertype.hint
        name = umlExtension.toElementTypeName(supertype)

        // Icon
        var icon = umlExtension.stereotype.iconEntry
        iconEntry = if(icon != null) icon else umlExtension.metaclass.iconEntry

        // Add stereotype matcher, if it isn't inherited from a semantic supertype
        if (!supertype.hasSemanticSupertype) {
            matcherConfiguration = umlExtension.toMatcherConfiguration(supertype)
        }
    }

    private def create createStereotypeApplicationMatcherConfiguration toMatcherConfiguration(ImpliedExtension umlExtension,
        ElementTypeConfiguration supertype) {
            
        stereotypesQualifiedNames.add(umlExtension.stereotype.qualifiedName)
    }

    private def getIconEntry(Stereotype stereotype) {
        val image = stereotype.icons.findFirst[!location.nullOrEmpty]
        if (image != null) {
            val uri = URI.createURI(image.location, true)

            if (uri != null) {
                createIconEntry => [
                    if (uri.platform) {

                        // Explicit platform-scheme URI
                        bundleId = uri.segment(1)
                        iconPath = "/" + uri.segmentsList.drop(2).join("/", [decode])
                    } else if (uri.relative) {

                        // Bundle-relative path.  Infer the bundle ID from the containing project
                        bundleId = stereotype.containingProject.name
                        iconPath = "/" + uri.toString.decode
                    } else {

                        // Absolute URI: use as is; don't decode it
                        iconPath = uri.toString
                    }
                ]
            }
        }
    }

    private def containingProject(EObject object) {
        ResourcesPlugin.workspace.root.getProject(object.eResource.URI.segment(2))
    }
}
